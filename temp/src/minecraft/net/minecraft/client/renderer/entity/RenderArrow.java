package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderArrow extends Render {

   private static final ResourceLocation field_110780_a = new ResourceLocation("textures/entity/arrow.png");
   private static final String __OBFID = "CL_00000978";


   public RenderArrow(RenderManager p_i46193_1_) {
      super(p_i46193_1_);
   }

   public void func_180551_a(EntityArrow p_180551_1_, double p_180551_2_, double p_180551_4_, double p_180551_6_, float p_180551_8_, float p_180551_9_) {
      this.func_180548_c(p_180551_1_);
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.func_179094_E();
      GlStateManager.func_179109_b((float)p_180551_2_, (float)p_180551_4_, (float)p_180551_6_);
      GlStateManager.func_179114_b(p_180551_1_.field_70126_B + (p_180551_1_.field_70177_z - p_180551_1_.field_70126_B) * p_180551_9_ - 90.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b(p_180551_1_.field_70127_C + (p_180551_1_.field_70125_A - p_180551_1_.field_70127_C) * p_180551_9_, 0.0F, 0.0F, 1.0F);
      Tessellator var10 = Tessellator.func_178181_a();
      WorldRenderer var11 = var10.func_178180_c();
      byte var12 = 0;
      float var13 = 0.0F;
      float var14 = 0.5F;
      float var15 = (float)(0 + var12 * 10) / 32.0F;
      float var16 = (float)(5 + var12 * 10) / 32.0F;
      float var17 = 0.0F;
      float var18 = 0.15625F;
      float var19 = (float)(5 + var12 * 10) / 32.0F;
      float var20 = (float)(10 + var12 * 10) / 32.0F;
      float var21 = 0.05625F;
      GlStateManager.func_179091_B();
      float var22 = (float)p_180551_1_.field_70249_b - p_180551_9_;
      if(var22 > 0.0F) {
         float var23 = -MathHelper.func_76126_a(var22 * 3.0F) * var22;
         GlStateManager.func_179114_b(var23, 0.0F, 0.0F, 1.0F);
      }

      GlStateManager.func_179114_b(45.0F, 1.0F, 0.0F, 0.0F);
      GlStateManager.func_179152_a(var21, var21, var21);
      GlStateManager.func_179109_b(-4.0F, 0.0F, 0.0F);
      GL11.glNormal3f(var21, 0.0F, 0.0F);
      var11.func_178970_b();
      var11.func_178985_a(-7.0D, -2.0D, -2.0D, (double)var17, (double)var19);
      var11.func_178985_a(-7.0D, -2.0D, 2.0D, (double)var18, (double)var19);
      var11.func_178985_a(-7.0D, 2.0D, 2.0D, (double)var18, (double)var20);
      var11.func_178985_a(-7.0D, 2.0D, -2.0D, (double)var17, (double)var20);
      var10.func_78381_a();
      GL11.glNormal3f(-var21, 0.0F, 0.0F);
      var11.func_178970_b();
      var11.func_178985_a(-7.0D, 2.0D, -2.0D, (double)var17, (double)var19);
      var11.func_178985_a(-7.0D, 2.0D, 2.0D, (double)var18, (double)var19);
      var11.func_178985_a(-7.0D, -2.0D, 2.0D, (double)var18, (double)var20);
      var11.func_178985_a(-7.0D, -2.0D, -2.0D, (double)var17, (double)var20);
      var10.func_78381_a();

      for(int var24 = 0; var24 < 4; ++var24) {
         GlStateManager.func_179114_b(90.0F, 1.0F, 0.0F, 0.0F);
         GL11.glNormal3f(0.0F, 0.0F, var21);
         var11.func_178970_b();
         var11.func_178985_a(-8.0D, -2.0D, 0.0D, (double)var13, (double)var15);
         var11.func_178985_a(8.0D, -2.0D, 0.0D, (double)var14, (double)var15);
         var11.func_178985_a(8.0D, 2.0D, 0.0D, (double)var14, (double)var16);
         var11.func_178985_a(-8.0D, 2.0D, 0.0D, (double)var13, (double)var16);
         var10.func_78381_a();
      }

      GlStateManager.func_179101_C();
      GlStateManager.func_179121_F();
      super.func_76986_a(p_180551_1_, p_180551_2_, p_180551_4_, p_180551_6_, p_180551_8_, p_180551_9_);
   }

   protected ResourceLocation func_180550_a(EntityArrow p_180550_1_) {
      return field_110780_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_180550_a((EntityArrow)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_180551_a((EntityArrow)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
