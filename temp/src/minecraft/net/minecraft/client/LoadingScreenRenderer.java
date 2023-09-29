package net.minecraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MinecraftError;

public class LoadingScreenRenderer implements IProgressUpdate {

   private String field_73727_a = "";
   private Minecraft field_73725_b;
   private String field_73726_c = "";
   private long field_73723_d = Minecraft.func_71386_F();
   private boolean field_73724_e;
   private ScaledResolution field_146587_f;
   private Framebuffer field_146588_g;
   private static final String __OBFID = "CL_00000655";


   public LoadingScreenRenderer(Minecraft p_i1017_1_) {
      this.field_73725_b = p_i1017_1_;
      this.field_146587_f = new ScaledResolution(p_i1017_1_, p_i1017_1_.field_71443_c, p_i1017_1_.field_71440_d);
      this.field_146588_g = new Framebuffer(p_i1017_1_.field_71443_c, p_i1017_1_.field_71440_d, false);
      this.field_146588_g.func_147607_a(9728);
   }

   public void func_73721_b(String p_73721_1_) {
      this.field_73724_e = false;
      this.func_73722_d(p_73721_1_);
   }

   public void func_73720_a(String p_73720_1_) {
      this.field_73724_e = true;
      this.func_73722_d(p_73720_1_);
   }

   private void func_73722_d(String p_73722_1_) {
      this.field_73726_c = p_73722_1_;
      if(!this.field_73725_b.field_71425_J) {
         if(!this.field_73724_e) {
            throw new MinecraftError();
         }
      } else {
         GlStateManager.func_179086_m(256);
         GlStateManager.func_179128_n(5889);
         GlStateManager.func_179096_D();
         if(OpenGlHelper.func_148822_b()) {
            int var2 = this.field_146587_f.func_78325_e();
            GlStateManager.func_179130_a(0.0D, (double)(this.field_146587_f.func_78326_a() * var2), (double)(this.field_146587_f.func_78328_b() * var2), 0.0D, 100.0D, 300.0D);
         } else {
            ScaledResolution var3 = new ScaledResolution(this.field_73725_b, this.field_73725_b.field_71443_c, this.field_73725_b.field_71440_d);
            GlStateManager.func_179130_a(0.0D, var3.func_78327_c(), var3.func_78324_d(), 0.0D, 100.0D, 300.0D);
         }

         GlStateManager.func_179128_n(5888);
         GlStateManager.func_179096_D();
         GlStateManager.func_179109_b(0.0F, 0.0F, -200.0F);
      }
   }

   public void func_73719_c(String p_73719_1_) {
      if(!this.field_73725_b.field_71425_J) {
         if(!this.field_73724_e) {
            throw new MinecraftError();
         }
      } else {
         this.field_73723_d = 0L;
         this.field_73727_a = p_73719_1_;
         this.func_73718_a(-1);
         this.field_73723_d = 0L;
      }
   }

   public void func_73718_a(int p_73718_1_) {
      if(!this.field_73725_b.field_71425_J) {
         if(!this.field_73724_e) {
            throw new MinecraftError();
         }
      } else {
         long var2 = Minecraft.func_71386_F();
         if(var2 - this.field_73723_d >= 100L) {
            this.field_73723_d = var2;
            ScaledResolution var4 = new ScaledResolution(this.field_73725_b, this.field_73725_b.field_71443_c, this.field_73725_b.field_71440_d);
            int var5 = var4.func_78325_e();
            int var6 = var4.func_78326_a();
            int var7 = var4.func_78328_b();
            if(OpenGlHelper.func_148822_b()) {
               this.field_146588_g.func_147614_f();
            } else {
               GlStateManager.func_179086_m(256);
            }

            this.field_146588_g.func_147610_a(false);
            GlStateManager.func_179128_n(5889);
            GlStateManager.func_179096_D();
            GlStateManager.func_179130_a(0.0D, var4.func_78327_c(), var4.func_78324_d(), 0.0D, 100.0D, 300.0D);
            GlStateManager.func_179128_n(5888);
            GlStateManager.func_179096_D();
            GlStateManager.func_179109_b(0.0F, 0.0F, -200.0F);
            if(!OpenGlHelper.func_148822_b()) {
               GlStateManager.func_179086_m(16640);
            }

            Tessellator var8 = Tessellator.func_178181_a();
            WorldRenderer var9 = var8.func_178180_c();
            this.field_73725_b.func_110434_K().func_110577_a(Gui.field_110325_k);
            float var10 = 32.0F;
            var9.func_178970_b();
            var9.func_178991_c(4210752);
            var9.func_178985_a(0.0D, (double)var7, 0.0D, 0.0D, (double)((float)var7 / var10));
            var9.func_178985_a((double)var6, (double)var7, 0.0D, (double)((float)var6 / var10), (double)((float)var7 / var10));
            var9.func_178985_a((double)var6, 0.0D, 0.0D, (double)((float)var6 / var10), 0.0D);
            var9.func_178985_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
            var8.func_78381_a();
            if(p_73718_1_ >= 0) {
               byte var11 = 100;
               byte var12 = 2;
               int var13 = var6 / 2 - var11 / 2;
               int var14 = var7 / 2 + 16;
               GlStateManager.func_179090_x();
               var9.func_178970_b();
               var9.func_178991_c(8421504);
               var9.func_178984_b((double)var13, (double)var14, 0.0D);
               var9.func_178984_b((double)var13, (double)(var14 + var12), 0.0D);
               var9.func_178984_b((double)(var13 + var11), (double)(var14 + var12), 0.0D);
               var9.func_178984_b((double)(var13 + var11), (double)var14, 0.0D);
               var9.func_178991_c(8454016);
               var9.func_178984_b((double)var13, (double)var14, 0.0D);
               var9.func_178984_b((double)var13, (double)(var14 + var12), 0.0D);
               var9.func_178984_b((double)(var13 + p_73718_1_), (double)(var14 + var12), 0.0D);
               var9.func_178984_b((double)(var13 + p_73718_1_), (double)var14, 0.0D);
               var8.func_78381_a();
               GlStateManager.func_179098_w();
            }

            GlStateManager.func_179147_l();
            GlStateManager.func_179120_a(770, 771, 1, 0);
            this.field_73725_b.field_71466_p.func_175063_a(this.field_73726_c, (float)((var6 - this.field_73725_b.field_71466_p.func_78256_a(this.field_73726_c)) / 2), (float)(var7 / 2 - 4 - 16), 16777215);
            this.field_73725_b.field_71466_p.func_175063_a(this.field_73727_a, (float)((var6 - this.field_73725_b.field_71466_p.func_78256_a(this.field_73727_a)) / 2), (float)(var7 / 2 - 4 + 8), 16777215);
            this.field_146588_g.func_147609_e();
            if(OpenGlHelper.func_148822_b()) {
               this.field_146588_g.func_147615_c(var6 * var5, var7 * var5);
            }

            this.field_73725_b.func_175601_h();

            try {
               Thread.yield();
            } catch (Exception var15) {
               ;
            }

         }
      }
   }

   public void func_146586_a() {}
}
