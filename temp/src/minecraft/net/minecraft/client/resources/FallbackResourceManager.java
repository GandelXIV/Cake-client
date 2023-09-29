package net.minecraft.client.resources;

import com.google.common.collect.Lists;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.SimpleResource;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FallbackResourceManager implements IResourceManager {

   private static final Logger field_177246_b = LogManager.getLogger();
   protected final List field_110540_a = Lists.newArrayList();
   private final IMetadataSerializer field_110539_b;
   private static final String __OBFID = "CL_00001074";


   public FallbackResourceManager(IMetadataSerializer p_i1289_1_) {
      this.field_110539_b = p_i1289_1_;
   }

   public void func_110538_a(IResourcePack p_110538_1_) {
      this.field_110540_a.add(p_110538_1_);
   }

   public Set func_135055_a() {
      return null;
   }

   public IResource func_110536_a(ResourceLocation p_110536_1_) throws IOException {
      IResourcePack var2 = null;
      ResourceLocation var3 = func_110537_b(p_110536_1_);

      for(int var4 = this.field_110540_a.size() - 1; var4 >= 0; --var4) {
         IResourcePack var5 = (IResourcePack)this.field_110540_a.get(var4);
         if(var2 == null && var5.func_110589_b(var3)) {
            var2 = var5;
         }

         if(var5.func_110589_b(p_110536_1_)) {
            InputStream var6 = null;
            if(var2 != null) {
               var6 = this.func_177245_a(var3, var2);
            }

            return new SimpleResource(var5.func_130077_b(), p_110536_1_, this.func_177245_a(p_110536_1_, var5), var6, this.field_110539_b);
         }
      }

      throw new FileNotFoundException(p_110536_1_.toString());
   }

   protected InputStream func_177245_a(ResourceLocation p_177245_1_, IResourcePack p_177245_2_) throws IOException {
      InputStream var3 = p_177245_2_.func_110590_a(p_177245_1_);
      return (InputStream)(field_177246_b.isDebugEnabled()?new FallbackResourceManager.ImputStreamLeakedResourceLogger(var3, p_177245_1_, p_177245_2_.func_130077_b()):var3);
   }

   public List func_135056_b(ResourceLocation p_135056_1_) throws IOException {
      ArrayList var2 = Lists.newArrayList();
      ResourceLocation var3 = func_110537_b(p_135056_1_);
      Iterator var4 = this.field_110540_a.iterator();

      while(var4.hasNext()) {
         IResourcePack var5 = (IResourcePack)var4.next();
         if(var5.func_110589_b(p_135056_1_)) {
            InputStream var6 = var5.func_110589_b(var3)?this.func_177245_a(var3, var5):null;
            var2.add(new SimpleResource(var5.func_130077_b(), p_135056_1_, this.func_177245_a(p_135056_1_, var5), var6, this.field_110539_b));
         }
      }

      if(var2.isEmpty()) {
         throw new FileNotFoundException(p_135056_1_.toString());
      } else {
         return var2;
      }
   }

   static ResourceLocation func_110537_b(ResourceLocation p_110537_0_) {
      return new ResourceLocation(p_110537_0_.func_110624_b(), p_110537_0_.func_110623_a() + ".mcmeta");
   }


   static class ImputStreamLeakedResourceLogger extends InputStream {

      private final InputStream field_177330_a;
      private final String field_177328_b;
      private boolean field_177329_c = false;
      private static final String __OBFID = "CL_00002395";


      public ImputStreamLeakedResourceLogger(InputStream p_i46093_1_, ResourceLocation p_i46093_2_, String p_i46093_3_) {
         this.field_177330_a = p_i46093_1_;
         ByteArrayOutputStream var4 = new ByteArrayOutputStream();
         (new Exception()).printStackTrace(new PrintStream(var4));
         this.field_177328_b = "Leaked resource: \'" + p_i46093_2_ + "\' loaded from pack: \'" + p_i46093_3_ + "\'\n" + var4.toString();
      }

      public void close() throws IOException {
         this.field_177330_a.close();
         this.field_177329_c = true;
      }

      protected void finalize() throws Throwable {
         if(!this.field_177329_c) {
            FallbackResourceManager.field_177246_b.warn(this.field_177328_b);
         }

         super.finalize();
      }

      public int read() throws IOException {
         return this.field_177330_a.read();
      }
   }
}
