package net.minecraft.client.renderer.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;

public class RenderFish extends Render {

   private static final ResourceLocation field_110792_a = new ResourceLocation("textures/particle/particles.png");
   private static final String __OBFID = "CL_00000996";


   public RenderFish(RenderManager p_i46175_1_) {
      super(p_i46175_1_);
   }

   public void func_180558_a(EntityFishHook p_180558_1_, double p_180558_2_, double p_180558_4_, double p_180558_6_, float p_180558_8_, float p_180558_9_) {
      GlStateManager.func_179094_E();
      GlStateManager.func_179109_b((float)p_180558_2_, (float)p_180558_4_, (float)p_180558_6_);
      GlStateManager.func_179091_B();
      GlStateManager.func_179152_a(0.5F, 0.5F, 0.5F);
      this.func_180548_c(p_180558_1_);
      Tessellator var10 = Tessellator.func_178181_a();
      WorldRenderer var11 = var10.func_178180_c();
      byte var12 = 1;
      byte var13 = 2;
      float var14 = (float)(var12 * 8 + 0) / 128.0F;
      float var15 = (float)(var12 * 8 + 8) / 128.0F;
      float var16 = (float)(var13 * 8 + 0) / 128.0F;
      float var17 = (float)(var13 * 8 + 8) / 128.0F;
      float var18 = 1.0F;
      float var19 = 0.5F;
      float var20 = 0.5F;
      GlStateManager.func_179114_b(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b(-this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
      var11.func_178970_b();
      var11.func_178980_d(0.0F, 1.0F, 0.0F);
      var11.func_178985_a((double)(0.0F - var19), (double)(0.0F - var20), 0.0D, (double)var14, (double)var17);
      var11.func_178985_a((double)(var18 - var19), (double)(0.0F - var20), 0.0D, (double)var15, (double)var17);
      var11.func_178985_a((double)(var18 - var19), (double)(1.0F - var20), 0.0D, (double)var15, (double)var16);
      var11.func_178985_a((double)(0.0F - var19), (double)(1.0F - var20), 0.0D, (double)var14, (double)var16);
      var10.func_78381_a();
      GlStateManager.func_179101_C();
      GlStateManager.func_179121_F();
      if(p_180558_1_.field_146042_b != null) {
         float var21 = p_180558_1_.field_146042_b.func_70678_g(p_180558_9_);
         float var22 = MathHelper.func_76126_a(MathHelper.func_76129_c(var21) * 3.1415927F);
         Vec3 var23 = new Vec3(-0.36D, 0.03D, 0.35D);
         var23 = var23.func_178789_a(-(p_180558_1_.field_146042_b.field_70127_C + (p_180558_1_.field_146042_b.field_70125_A - p_180558_1_.field_146042_b.field_70127_C) * p_180558_9_) * 3.1415927F / 180.0F);
         var23 = var23.func_178785_b(-(p_180558_1_.field_146042_b.field_70126_B + (p_180558_1_.field_146042_b.field_70177_z - p_180558_1_.field_146042_b.field_70126_B) * p_180558_9_) * 3.1415927F / 180.0F);
         var23 = var23.func_178785_b(var22 * 0.5F);
         var23 = var23.func_178789_a(-var22 * 0.7F);
         double var24 = p_180558_1_.field_146042_b.field_70169_q + (p_180558_1_.field_146042_b.field_70165_t - p_180558_1_.field_146042_b.field_70169_q) * (double)p_180558_9_ + var23.field_72450_a;
         double var26 = p_180558_1_.field_146042_b.field_70167_r + (p_180558_1_.field_146042_b.field_70163_u - p_180558_1_.field_146042_b.field_70167_r) * (double)p_180558_9_ + var23.field_72448_b;
         double var28 = p_180558_1_.field_146042_b.field_70166_s + (p_180558_1_.field_146042_b.field_70161_v - p_180558_1_.field_146042_b.field_70166_s) * (double)p_180558_9_ + var23.field_72449_c;
         double var30 = (double)p_180558_1_.field_146042_b.func_70047_e();
         if(this.field_76990_c.field_78733_k != null && this.field_76990_c.field_78733_k.field_74320_O > 0 || p_180558_1_.field_146042_b != Minecraft.func_71410_x().field_71439_g) {
            float var32 = (p_180558_1_.field_146042_b.field_70760_ar + (p_180558_1_.field_146042_b.field_70761_aq - p_180558_1_.field_146042_b.field_70760_ar) * p_180558_9_) * 3.1415927F / 180.0F;
            double var33 = (double)MathHelper.func_76126_a(var32);
            double var35 = (double)MathHelper.func_76134_b(var32);
            double var37 = 0.35D;
            double var39 = 0.8D;
            var24 = p_180558_1_.field_146042_b.field_70169_q + (p_180558_1_.field_146042_b.field_70165_t - p_180558_1_.field_146042_b.field_70169_q) * (double)p_180558_9_ - var35 * 0.35D - var33 * 0.8D;
            var26 = p_180558_1_.field_146042_b.field_70167_r + var30 + (p_180558_1_.field_146042_b.field_70163_u - p_180558_1_.field_146042_b.field_70167_r) * (double)p_180558_9_ - 0.45D;
            var28 = p_180558_1_.field_146042_b.field_70166_s + (p_180558_1_.field_146042_b.field_70161_v - p_180558_1_.field_146042_b.field_70166_s) * (double)p_180558_9_ - var33 * 0.35D + var35 * 0.8D;
            var30 = p_180558_1_.field_146042_b.func_70093_af()?-0.1875D:0.0D;
         }

         double var47 = p_180558_1_.field_70169_q + (p_180558_1_.field_70165_t - p_180558_1_.field_70169_q) * (double)p_180558_9_;
         double var34 = p_180558_1_.field_70167_r + (p_180558_1_.field_70163_u - p_180558_1_.field_70167_r) * (double)p_180558_9_ + 0.25D;
         double var36 = p_180558_1_.field_70166_s + (p_180558_1_.field_70161_v - p_180558_1_.field_70166_s) * (double)p_180558_9_;
         double var38 = (double)((float)(var24 - var47));
         double var40 = (double)((float)(var26 - var34)) + var30;
         double var42 = (double)((float)(var28 - var36));
         GlStateManager.func_179090_x();
         GlStateManager.func_179140_f();
         var11.func_178964_a(3);
         var11.func_178991_c(0);
         byte var44 = 16;

         for(int var45 = 0; var45 <= var44; ++var45) {
            float var46 = (float)var45 / (float)var44;
            var11.func_178984_b(p_180558_2_ + var38 * (double)var46, p_180558_4_ + var40 * (double)(var46 * var46 + var46) * 0.5D + 0.25D, p_180558_6_ + var42 * (double)var46);
         }

         var10.func_78381_a();
         GlStateManager.func_179145_e();
         GlStateManager.func_179098_w();
         super.func_76986_a(p_180558_1_, p_180558_2_, p_180558_4_, p_180558_6_, p_180558_8_, p_180558_9_);
      }

   }

   protected ResourceLocation func_110775_a(EntityFishHook p_110775_1_) {
      return field_110792_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityFishHook)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_180558_a((EntityFishHook)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
