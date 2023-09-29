package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderXPOrb extends Render {

   private static final ResourceLocation field_110785_a = new ResourceLocation("textures/entity/experience_orb.png");
   private static final String __OBFID = "CL_00000993";


   public RenderXPOrb(RenderManager p_i46178_1_) {
      super(p_i46178_1_);
      this.field_76989_e = 0.15F;
      this.field_76987_f = 0.75F;
   }

   public void func_76986_a(EntityXPOrb p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      GlStateManager.func_179094_E();
      GlStateManager.func_179109_b((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
      this.func_180548_c(p_76986_1_);
      int var10 = p_76986_1_.func_70528_g();
      float var11 = (float)(var10 % 4 * 16 + 0) / 64.0F;
      float var12 = (float)(var10 % 4 * 16 + 16) / 64.0F;
      float var13 = (float)(var10 / 4 * 16 + 0) / 64.0F;
      float var14 = (float)(var10 / 4 * 16 + 16) / 64.0F;
      float var15 = 1.0F;
      float var16 = 0.5F;
      float var17 = 0.25F;
      int var18 = p_76986_1_.func_70070_b(p_76986_9_);
      int var19 = var18 % 65536;
      int var20 = var18 / 65536;
      OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)var19 / 1.0F, (float)var20 / 1.0F);
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      float var27 = 255.0F;
      float var28 = ((float)p_76986_1_.field_70533_a + p_76986_9_) / 2.0F;
      var20 = (int)((MathHelper.func_76126_a(var28 + 0.0F) + 1.0F) * 0.5F * var27);
      int var21 = (int)var27;
      int var22 = (int)((MathHelper.func_76126_a(var28 + 4.1887903F) + 1.0F) * 0.1F * var27);
      int var23 = var20 << 16 | var21 << 8 | var22;
      GlStateManager.func_179114_b(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b(-this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
      float var24 = 0.3F;
      GlStateManager.func_179152_a(var24, var24, var24);
      Tessellator var25 = Tessellator.func_178181_a();
      WorldRenderer var26 = var25.func_178180_c();
      var26.func_178970_b();
      var26.func_178974_a(var23, 128);
      var26.func_178980_d(0.0F, 1.0F, 0.0F);
      var26.func_178985_a((double)(0.0F - var16), (double)(0.0F - var17), 0.0D, (double)var11, (double)var14);
      var26.func_178985_a((double)(var15 - var16), (double)(0.0F - var17), 0.0D, (double)var12, (double)var14);
      var26.func_178985_a((double)(var15 - var16), (double)(1.0F - var17), 0.0D, (double)var12, (double)var13);
      var26.func_178985_a((double)(0.0F - var16), (double)(1.0F - var17), 0.0D, (double)var11, (double)var13);
      var25.func_78381_a();
      GlStateManager.func_179084_k();
      GlStateManager.func_179101_C();
      GlStateManager.func_179121_F();
      super.func_76986_a(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   protected ResourceLocation func_180555_a(EntityXPOrb p_180555_1_) {
      return field_110785_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_180555_a((EntityXPOrb)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityXPOrb)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
