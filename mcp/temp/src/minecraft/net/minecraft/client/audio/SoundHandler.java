package net.minecraft.client.audio;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.ISoundEventAccessor;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.client.audio.SoundEventAccessor;
import net.minecraft.client.audio.SoundEventAccessorComposite;
import net.minecraft.client.audio.SoundList;
import net.minecraft.client.audio.SoundListSerializer;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.client.audio.SoundRegistry;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SoundHandler implements IResourceManagerReloadListener, IUpdatePlayerListBox {

   private static final Logger field_147698_b = LogManager.getLogger();
   private static final Gson field_147699_c = (new GsonBuilder()).registerTypeAdapter(SoundList.class, new SoundListSerializer()).create();
   private static final ParameterizedType field_147696_d = new ParameterizedType() {

      private static final String __OBFID = "CL_00001148";

      public Type[] getActualTypeArguments() {
         return new Type[]{String.class, SoundList.class};
      }
      public Type getRawType() {
         return Map.class;
      }
      public Type getOwnerType() {
         return null;
      }
   };
   public static final SoundPoolEntry field_147700_a = new SoundPoolEntry(new ResourceLocation("meta:missing_sound"), 0.0D, 0.0D, false);
   private final SoundRegistry field_147697_e = new SoundRegistry();
   private final SoundManager field_147694_f;
   private final IResourceManager field_147695_g;
   private static final String __OBFID = "CL_00001147";


   public SoundHandler(IResourceManager p_i45122_1_, GameSettings p_i45122_2_) {
      this.field_147695_g = p_i45122_1_;
      this.field_147694_f = new SoundManager(this, p_i45122_2_);
   }

   public void func_110549_a(IResourceManager p_110549_1_) {
      this.field_147694_f.func_148596_a();
      this.field_147697_e.func_148763_c();
      Iterator var2 = p_110549_1_.func_135055_a().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();

         try {
            List var4 = p_110549_1_.func_135056_b(new ResourceLocation(var3, "sounds.json"));
            Iterator var5 = var4.iterator();

            while(var5.hasNext()) {
               IResource var6 = (IResource)var5.next();

               try {
                  Map var7 = this.func_175085_a(var6.func_110527_b());
                  Iterator var8 = var7.entrySet().iterator();

                  while(var8.hasNext()) {
                     Entry var9 = (Entry)var8.next();
                     this.func_147693_a(new ResourceLocation(var3, (String)var9.getKey()), (SoundList)var9.getValue());
                  }
               } catch (RuntimeException var10) {
                  field_147698_b.warn("Invalid sounds.json", var10);
               }
            }
         } catch (IOException var11) {
            ;
         }
      }

   }

   protected Map func_175085_a(InputStream p_175085_1_) {
      Map var2;
      try {
         var2 = (Map)field_147699_c.fromJson(new InputStreamReader(p_175085_1_), field_147696_d);
      } finally {
         IOUtils.closeQuietly(p_175085_1_);
      }

      return var2;
   }

   private void func_147693_a(ResourceLocation p_147693_1_, SoundList p_147693_2_) {
      boolean var4 = !this.field_147697_e.func_148741_d(p_147693_1_);
      SoundEventAccessorComposite var3;
      if(!var4 && !p_147693_2_.func_148574_b()) {
         var3 = (SoundEventAccessorComposite)this.field_147697_e.func_82594_a(p_147693_1_);
      } else {
         if(!var4) {
            field_147698_b.debug("Replaced sound event location {}", new Object[]{p_147693_1_});
         }

         var3 = new SoundEventAccessorComposite(p_147693_1_, 1.0D, 1.0D, p_147693_2_.func_148573_c());
         this.field_147697_e.func_148762_a(var3);
      }

      Iterator var5 = p_147693_2_.func_148570_a().iterator();

      while(var5.hasNext()) {
         final SoundList.SoundEntry var6 = (SoundList.SoundEntry)var5.next();
         String var7 = var6.func_148556_a();
         ResourceLocation var8 = new ResourceLocation(var7);
         final String var9 = var7.contains(":")?var8.func_110624_b():p_147693_1_.func_110624_b();
         Object var10;
         switch(SoundHandler.SwitchType.field_148765_a[var6.func_148563_e().ordinal()]) {
         case 1:
            ResourceLocation var11 = new ResourceLocation(var9, "sounds/" + var8.func_110623_a() + ".ogg");
            InputStream var12 = null;

            try {
               var12 = this.field_147695_g.func_110536_a(var11).func_110527_b();
            } catch (FileNotFoundException var18) {
               field_147698_b.warn("File {} does not exist, cannot add it to event {}", new Object[]{var11, p_147693_1_});
               continue;
            } catch (IOException var19) {
               field_147698_b.warn("Could not load sound file " + var11 + ", cannot add it to event " + p_147693_1_, var19);
               continue;
            } finally {
               IOUtils.closeQuietly(var12);
            }

            var10 = new SoundEventAccessor(new SoundPoolEntry(var11, (double)var6.func_148560_c(), (double)var6.func_148558_b(), var6.func_148552_f()), var6.func_148555_d());
            break;
         case 2:
            var10 = new ISoundEventAccessor() {

               final ResourceLocation field_148726_a = new ResourceLocation(var9, var6.func_148556_a());
               private static final String __OBFID = "CL_00001149";

               public int func_148721_a() {
                  SoundEventAccessorComposite var1 = (SoundEventAccessorComposite)SoundHandler.this.field_147697_e.func_82594_a(this.field_148726_a);
                  return var1 == null?0:var1.func_148721_a();
               }
               public SoundPoolEntry func_180604_b() {
                  SoundEventAccessorComposite var1 = (SoundEventAccessorComposite)SoundHandler.this.field_147697_e.func_82594_a(this.field_148726_a);
                  return var1 == null?SoundHandler.field_147700_a:var1.func_148720_g();
               }
               // $FF: synthetic method
               public Object func_148720_g() {
                  return this.func_180604_b();
               }
            };
            break;
         default:
            throw new IllegalStateException("IN YOU FACE");
         }

         var3.func_148727_a((ISoundEventAccessor)var10);
      }

   }

   public SoundEventAccessorComposite func_147680_a(ResourceLocation p_147680_1_) {
      return (SoundEventAccessorComposite)this.field_147697_e.func_82594_a(p_147680_1_);
   }

   public void func_147682_a(ISound p_147682_1_) {
      this.field_147694_f.func_148611_c(p_147682_1_);
   }

   public void func_147681_a(ISound p_147681_1_, int p_147681_2_) {
      this.field_147694_f.func_148599_a(p_147681_1_, p_147681_2_);
   }

   public void func_147691_a(EntityPlayer p_147691_1_, float p_147691_2_) {
      this.field_147694_f.func_148615_a(p_147691_1_, p_147691_2_);
   }

   public void func_147689_b() {
      this.field_147694_f.func_148610_e();
   }

   public void func_147690_c() {
      this.field_147694_f.func_148614_c();
   }

   public void func_147685_d() {
      this.field_147694_f.func_148613_b();
   }

   public void func_73660_a() {
      this.field_147694_f.func_148605_d();
   }

   public void func_147687_e() {
      this.field_147694_f.func_148604_f();
   }

   public void func_147684_a(SoundCategory p_147684_1_, float p_147684_2_) {
      if(p_147684_1_ == SoundCategory.MASTER && p_147684_2_ <= 0.0F) {
         this.func_147690_c();
      }

      this.field_147694_f.func_148601_a(p_147684_1_, p_147684_2_);
   }

   public void func_147683_b(ISound p_147683_1_) {
      this.field_147694_f.func_148602_b(p_147683_1_);
   }

   public SoundEventAccessorComposite func_147686_a(SoundCategory ... p_147686_1_) {
      ArrayList var2 = Lists.newArrayList();
      Iterator var3 = this.field_147697_e.func_148742_b().iterator();

      while(var3.hasNext()) {
         ResourceLocation var4 = (ResourceLocation)var3.next();
         SoundEventAccessorComposite var5 = (SoundEventAccessorComposite)this.field_147697_e.func_82594_a(var4);
         if(ArrayUtils.contains(p_147686_1_, var5.func_148728_d())) {
            var2.add(var5);
         }
      }

      if(var2.isEmpty()) {
         return null;
      } else {
         return (SoundEventAccessorComposite)var2.get((new Random()).nextInt(var2.size()));
      }
   }

   public boolean func_147692_c(ISound p_147692_1_) {
      return this.field_147694_f.func_148597_a(p_147692_1_);
   }


   // $FF: synthetic class
   static final class SwitchType {

      // $FF: synthetic field
      static final int[] field_148765_a = new int[SoundList.SoundEntry.Type.values().length];
      private static final String __OBFID = "CL_00001150";


      static {
         try {
            field_148765_a[SoundList.SoundEntry.Type.FILE.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_148765_a[SoundList.SoundEntry.Type.SOUND_EVENT.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
