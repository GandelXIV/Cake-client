package net.minecraft.client.resources;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.awt.image.BufferedImage;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreenWorking;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.FileResourcePack;
import net.minecraft.client.resources.FolderResourcePack;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.client.resources.data.PackMetadataSection;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.HttpUtil;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ResourcePackRepository {

   private static final Logger field_177320_c = LogManager.getLogger();
   private static final FileFilter field_110622_a = new FileFilter() {

      private static final String __OBFID = "CL_00001088";

      public boolean accept(File p_accept_1_) {
         boolean var2 = p_accept_1_.isFile() && p_accept_1_.getName().endsWith(".zip");
         boolean var3 = p_accept_1_.isDirectory() && (new File(p_accept_1_, "pack.mcmeta")).isFile();
         return var2 || var3;
      }
   };
   private final File field_110618_d;
   public final IResourcePack field_110620_b;
   private final File field_148534_e;
   public final IMetadataSerializer field_110621_c;
   private IResourcePack field_148532_f;
   private final ReentrantLock field_177321_h = new ReentrantLock();
   private ListenableFuture field_177322_i;
   private List field_110619_e = Lists.newArrayList();
   private List field_110617_f = Lists.newArrayList();
   private static final String __OBFID = "CL_00001087";


   public ResourcePackRepository(File p_i45101_1_, File p_i45101_2_, IResourcePack p_i45101_3_, IMetadataSerializer p_i45101_4_, GameSettings p_i45101_5_) {
      this.field_110618_d = p_i45101_1_;
      this.field_148534_e = p_i45101_2_;
      this.field_110620_b = p_i45101_3_;
      this.field_110621_c = p_i45101_4_;
      this.func_110616_f();
      this.func_110611_a();
      Iterator var6 = p_i45101_5_.field_151453_l.iterator();

      while(var6.hasNext()) {
         String var7 = (String)var6.next();
         Iterator var8 = this.field_110619_e.iterator();

         while(var8.hasNext()) {
            ResourcePackRepository.Entry var9 = (ResourcePackRepository.Entry)var8.next();
            if(var9.func_110515_d().equals(var7)) {
               this.field_110617_f.add(var9);
               break;
            }
         }
      }

   }

   private void func_110616_f() {
      if(!this.field_110618_d.isDirectory() && (!this.field_110618_d.delete() || !this.field_110618_d.mkdirs())) {
         field_177320_c.debug("Unable to create resourcepack folder: " + this.field_110618_d);
      }

   }

   private List func_110614_g() {
      return this.field_110618_d.isDirectory()?Arrays.asList(this.field_110618_d.listFiles(field_110622_a)):Collections.emptyList();
   }

   public void func_110611_a() {
      ArrayList var1 = Lists.newArrayList();
      Iterator var2 = this.func_110614_g().iterator();

      while(var2.hasNext()) {
         File var3 = (File)var2.next();
         ResourcePackRepository.Entry var4 = new ResourcePackRepository.Entry(var3, null);
         if(!this.field_110619_e.contains(var4)) {
            try {
               var4.func_110516_a();
               var1.add(var4);
            } catch (Exception var6) {
               var1.remove(var4);
            }
         } else {
            int var5 = this.field_110619_e.indexOf(var4);
            if(var5 > -1 && var5 < this.field_110619_e.size()) {
               var1.add(this.field_110619_e.get(var5));
            }
         }
      }

      this.field_110619_e.removeAll(var1);
      var2 = this.field_110619_e.iterator();

      while(var2.hasNext()) {
         ResourcePackRepository.Entry var7 = (ResourcePackRepository.Entry)var2.next();
         var7.func_110517_b();
      }

      this.field_110619_e = var1;
   }

   public List func_110609_b() {
      return ImmutableList.copyOf(this.field_110619_e);
   }

   public List func_110613_c() {
      return ImmutableList.copyOf(this.field_110617_f);
   }

   public void func_148527_a(List p_148527_1_) {
      this.field_110617_f.clear();
      this.field_110617_f.addAll(p_148527_1_);
   }

   public File func_110612_e() {
      return this.field_110618_d;
   }

   public ListenableFuture func_180601_a(String p_180601_1_, String p_180601_2_) {
      String var3;
      if(p_180601_2_.matches("^[a-f0-9]{40}$")) {
         var3 = p_180601_2_;
      } else {
         var3 = p_180601_1_.substring(p_180601_1_.lastIndexOf("/") + 1);
         if(var3.contains("?")) {
            var3 = var3.substring(0, var3.indexOf("?"));
         }

         if(!var3.endsWith(".zip")) {
            return Futures.immediateFailedFuture(new IllegalArgumentException("Invalid filename; must end in .zip"));
         }

         var3 = "legacy_" + var3.replaceAll("\\W", "");
      }

      final File var4 = new File(this.field_148534_e, var3);
      this.field_177321_h.lock();

      try {
         this.func_148529_f();
         if(var4.exists() && p_180601_2_.length() == 40) {
            try {
               String var5 = Hashing.sha1().hashBytes(Files.toByteArray(var4)).toString();
               if(var5.equals(p_180601_2_)) {
                  ListenableFuture var16 = this.func_177319_a(var4);
                  return var16;
               }

               field_177320_c.warn("File " + var4 + " had wrong hash (expected " + p_180601_2_ + ", found " + var5 + "). Deleting it.");
               FileUtils.deleteQuietly(var4);
            } catch (IOException var13) {
               field_177320_c.warn("File " + var4 + " couldn\'t be hashed. Deleting it.", var13);
               FileUtils.deleteQuietly(var4);
            }
         }

         final GuiScreenWorking var15 = new GuiScreenWorking();
         Map var6 = Minecraft.func_175596_ai();
         final Minecraft var7 = Minecraft.func_71410_x();
         Futures.getUnchecked(var7.func_152344_a(new Runnable() {

            private static final String __OBFID = "CL_00001089";

            public void run() {
               var7.func_147108_a(var15);
            }
         }));
         final SettableFuture var8 = SettableFuture.create();
         this.field_177322_i = HttpUtil.func_180192_a(var4, p_180601_1_, var6, 52428800, var15, var7.func_110437_J());
         Futures.addCallback(this.field_177322_i, new FutureCallback() {

            private static final String __OBFID = "CL_00002394";

            public void onSuccess(Object p_onSuccess_1_) {
               ResourcePackRepository.this.func_177319_a(var4);
               var8.set((Object)null);
            }
            public void onFailure(Throwable p_onFailure_1_) {
               var8.setException(p_onFailure_1_);
            }
         });
         ListenableFuture var9 = this.field_177322_i;
         return var9;
      } finally {
         this.field_177321_h.unlock();
      }
   }

   public ListenableFuture func_177319_a(File p_177319_1_) {
      this.field_148532_f = new FileResourcePack(p_177319_1_);
      return Minecraft.func_71410_x().func_175603_A();
   }

   public IResourcePack func_148530_e() {
      return this.field_148532_f;
   }

   public void func_148529_f() {
      this.field_177321_h.lock();

      try {
         if(this.field_177322_i != null) {
            this.field_177322_i.cancel(true);
         }

         this.field_177322_i = null;
         this.field_148532_f = null;
      } finally {
         this.field_177321_h.unlock();
      }

   }


   public class Entry {

      private final File field_110523_b;
      private IResourcePack field_110524_c;
      private PackMetadataSection field_110521_d;
      private BufferedImage field_110522_e;
      private ResourceLocation field_110520_f;
      private static final String __OBFID = "CL_00001090";


      private Entry(File p_i1295_2_) {
         this.field_110523_b = p_i1295_2_;
      }

      public void func_110516_a() throws IOException {
         this.field_110524_c = (IResourcePack)(this.field_110523_b.isDirectory()?new FolderResourcePack(this.field_110523_b):new FileResourcePack(this.field_110523_b));
         this.field_110521_d = (PackMetadataSection)this.field_110524_c.func_135058_a(ResourcePackRepository.this.field_110621_c, "pack");

         try {
            this.field_110522_e = this.field_110524_c.func_110586_a();
         } catch (IOException var2) {
            ;
         }

         if(this.field_110522_e == null) {
            this.field_110522_e = ResourcePackRepository.this.field_110620_b.func_110586_a();
         }

         this.func_110517_b();
      }

      public void func_110518_a(TextureManager p_110518_1_) {
         if(this.field_110520_f == null) {
            this.field_110520_f = p_110518_1_.func_110578_a("texturepackicon", new DynamicTexture(this.field_110522_e));
         }

         p_110518_1_.func_110577_a(this.field_110520_f);
      }

      public void func_110517_b() {
         if(this.field_110524_c instanceof Closeable) {
            IOUtils.closeQuietly((Closeable)this.field_110524_c);
         }

      }

      public IResourcePack func_110514_c() {
         return this.field_110524_c;
      }

      public String func_110515_d() {
         return this.field_110524_c.func_130077_b();
      }

      public String func_110519_e() {
         return this.field_110521_d == null?EnumChatFormatting.RED + "Invalid pack.mcmeta (or missing \'pack\' section)":this.field_110521_d.func_152805_a().func_150254_d();
      }

      public boolean equals(Object p_equals_1_) {
         return this == p_equals_1_?true:(p_equals_1_ instanceof ResourcePackRepository.Entry?this.toString().equals(p_equals_1_.toString()):false);
      }

      public int hashCode() {
         return this.toString().hashCode();
      }

      public String toString() {
         return String.format("%s:%s:%d", new Object[]{this.field_110523_b.getName(), this.field_110523_b.isDirectory()?"folder":"zip", Long.valueOf(this.field_110523_b.lastModified())});
      }

      // $FF: synthetic method
      Entry(File p_i1296_2_, Object p_i1296_3_) {
         this(p_i1296_2_);
      }
   }
}
