package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.client.renderer.texture.ITickableTextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextureManager implements ITickable, IResourceManagerReloadListener {

   private static final Logger field_147646_a = LogManager.getLogger();
   private final Map field_110585_a = Maps.newHashMap();
   private final List field_110583_b = Lists.newArrayList();
   private final Map field_110584_c = Maps.newHashMap();
   private IResourceManager field_110582_d;
   private static final String __OBFID = "CL_00001064";


   public TextureManager(IResourceManager p_i1284_1_) {
      this.field_110582_d = p_i1284_1_;
   }

   public void func_110577_a(ResourceLocation p_110577_1_) {
      Object var2 = (ITextureObject)this.field_110585_a.get(p_110577_1_);
      if(var2 == null) {
         var2 = new SimpleTexture(p_110577_1_);
         this.func_110579_a(p_110577_1_, (ITextureObject)var2);
      }

      TextureUtil.func_94277_a(((ITextureObject)var2).func_110552_b());
   }

   public boolean func_110580_a(ResourceLocation p_110580_1_, ITickableTextureObject p_110580_2_) {
      if(this.func_110579_a(p_110580_1_, p_110580_2_)) {
         this.field_110583_b.add(p_110580_2_);
         return true;
      } else {
         return false;
      }
   }

   public boolean func_110579_a(ResourceLocation p_110579_1_, final ITextureObject p_110579_2_) {
      boolean var3 = true;

      try {
         ((ITextureObject)p_110579_2_).func_110551_a(this.field_110582_d);
      } catch (IOException var8) {
         field_147646_a.warn("Failed to load texture: " + p_110579_1_, var8);
         p_110579_2_ = TextureUtil.field_111001_a;
         this.field_110585_a.put(p_110579_1_, p_110579_2_);
         var3 = false;
      } catch (Throwable var9) {
         CrashReport var5 = CrashReport.func_85055_a(var9, "Registering texture");
         CrashReportCategory var6 = var5.func_85058_a("Resource location being registered");
         var6.func_71507_a("Resource location", p_110579_1_);
         var6.func_71500_a("Texture object class", new Callable() {

            private static final String __OBFID = "CL_00001065";

            public String call() {
               return p_110579_2_.getClass().getName();
            }
            // $FF: synthetic method
            public Object call() {
               return this.call();
            }
         });
         throw new ReportedException(var5);
      }

      this.field_110585_a.put(p_110579_1_, p_110579_2_);
      return var3;
   }

   public ITextureObject func_110581_b(ResourceLocation p_110581_1_) {
      return (ITextureObject)this.field_110585_a.get(p_110581_1_);
   }

   public ResourceLocation func_110578_a(String p_110578_1_, DynamicTexture p_110578_2_) {
      Integer var3 = (Integer)this.field_110584_c.get(p_110578_1_);
      if(var3 == null) {
         var3 = Integer.valueOf(1);
      } else {
         var3 = Integer.valueOf(var3.intValue() + 1);
      }

      this.field_110584_c.put(p_110578_1_, var3);
      ResourceLocation var4 = new ResourceLocation(String.format("dynamic/%s_%d", new Object[]{p_110578_1_, var3}));
      this.func_110579_a(var4, p_110578_2_);
      return var4;
   }

   public void func_110550_d() {
      Iterator var1 = this.field_110583_b.iterator();

      while(var1.hasNext()) {
         ITickable var2 = (ITickable)var1.next();
         var2.func_110550_d();
      }

   }

   public void func_147645_c(ResourceLocation p_147645_1_) {
      ITextureObject var2 = this.func_110581_b(p_147645_1_);
      if(var2 != null) {
         TextureUtil.func_147942_a(var2.func_110552_b());
      }

   }

   public void func_110549_a(IResourceManager p_110549_1_) {
      Iterator var2 = this.field_110585_a.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.func_110579_a((ResourceLocation)var3.getKey(), (ITextureObject)var3.getValue());
      }

   }

}
