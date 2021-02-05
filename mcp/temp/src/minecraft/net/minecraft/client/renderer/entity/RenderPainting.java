package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderPainting extends Render {

   private static final ResourceLocation field_110807_a = new ResourceLocation("textures/painting/paintings_kristoffer_zetterstrand.png");
   private static final String __OBFID = "CL_00001018";


   public RenderPainting(RenderManager p_i46150_1_) {
      super(p_i46150_1_);
   }

   public void func_76986_a(EntityPainting p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      GlStateManager.func_179094_E();
      GlStateManager.func_179137_b(p_76986_2_, p_76986_4_, p_76986_6_);
      GlStateManager.func_179114_b(180.0F - p_76986_8_, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179091_B();
      this.func_180548_c(p_76986_1_);
      EntityPainting.EnumArt var10 = p_76986_1_.field_70522_e;
      float var11 = 0.0625F;
      GlStateManager.func_179152_a(var11, var11, var11);
      this.func_77010_a(p_76986_1_, var10.field_75703_B, var10.field_75704_C, var10.field_75699_D, var10.field_75700_E);
      GlStateManager.func_179101_C();
      GlStateManager.func_179121_F();
      super.func_76986_a(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   protected ResourceLocation func_180562_a(EntityPainting p_180562_1_) {
      return field_110807_a;
   }

   private void func_77010_a(EntityPainting p_77010_1_, int p_77010_2_, int p_77010_3_, int p_77010_4_, int p_77010_5_) {
      float var6 = (float)(-p_77010_2_) / 2.0F;
      float var7 = (float)(-p_77010_3_) / 2.0F;
      float var8 = 0.5F;
      float var9 = 0.75F;
      float var10 = 0.8125F;
      float var11 = 0.0F;
      float var12 = 0.0625F;
      float var13 = 0.75F;
      float var14 = 0.8125F;
      float var15 = 0.001953125F;
      float var16 = 0.001953125F;
      float var17 = 0.7519531F;
      float var18 = 0.7519531F;
      float var19 = 0.0F;
      float var20 = 0.0625F;

      for(int var21 = 0; var21 < p_77010_2_ / 16; ++var21) {
         for(int var22 = 0; var22 < p_77010_3_ / 16; ++var22) {
            float var23 = var6 + (float)((var21 + 1) * 16);
            float var24 = var6 + (float)(var21 * 16);
            float var25 = var7 + (float)((var22 + 1) * 16);
            float var26 = var7 + (float)(var22 * 16);
            this.func_77008_a(p_77010_1_, (var23 + var24) / 2.0F, (var25 + var26) / 2.0F);
            float var27 = (float)(p_77010_4_ + p_77010_2_ - var21 * 16) / 256.0F;
            float var28 = (float)(p_77010_4_ + p_77010_2_ - (var21 + 1) * 16) / 256.0F;
            float var29 = (float)(p_77010_5_ + p_77010_3_ - var22 * 16) / 256.0F;
            float var30 = (float)(p_77010_5_ + p_77010_3_ - (var22 + 1) * 16) / 256.0F;
            Tessellator var31 = Tessellator.func_178181_a();
            WorldRenderer var32 = var31.func_178180_c();
            var32.func_178970_b();
            var32.func_178980_d(0.0F, 0.0F, -1.0F);
            var32.func_178985_a((double)var23, (double)var26, (double)(-var8), (double)var28, (double)var29);
            var32.func_178985_a((double)var24, (double)var26, (double)(-var8), (double)var27, (double)var29);
            var32.func_178985_a((double)var24, (double)var25, (double)(-var8), (double)var27, (double)var30);
            var32.func_178985_a((double)var23, (double)var25, (double)(-var8), (double)var28, (double)var30);
            var32.func_178980_d(0.0F, 0.0F, 1.0F);
            var32.func_178985_a((double)var23, (double)var25, (double)var8, (double)var9, (double)var11);
            var32.func_178985_a((double)var24, (double)var25, (double)var8, (double)var10, (double)var11);
            var32.func_178985_a((double)var24, (double)var26, (double)var8, (double)var10, (double)var12);
            var32.func_178985_a((double)var23, (double)var26, (double)var8, (double)var9, (double)var12);
            var32.func_178980_d(0.0F, 1.0F, 0.0F);
            var32.func_178985_a((double)var23, (double)var25, (double)(-var8), (double)var13, (double)var15);
            var32.func_178985_a((double)var24, (double)var25, (double)(-var8), (double)var14, (double)var15);
            var32.func_178985_a((double)var24, (double)var25, (double)var8, (double)var14, (double)var16);
            var32.func_178985_a((double)var23, (double)var25, (double)var8, (double)var13, (double)var16);
            var32.func_178980_d(0.0F, -1.0F, 0.0F);
            var32.func_178985_a((double)var23, (double)var26, (double)var8, (double)var13, (double)var15);
            var32.func_178985_a((double)var24, (double)var26, (double)var8, (double)var14, (double)var15);
            var32.func_178985_a((double)var24, (double)var26, (double)(-var8), (double)var14, (double)var16);
            var32.func_178985_a((double)var23, (double)var26, (double)(-var8), (double)var13, (double)var16);
            var32.func_178980_d(-1.0F, 0.0F, 0.0F);
            var32.func_178985_a((double)var23, (double)var25, (double)var8, (double)var18, (double)var19);
            var32.func_178985_a((double)var23, (double)var26, (double)var8, (double)var18, (double)var20);
            var32.func_178985_a((double)var23, (double)var26, (double)(-var8), (double)var17, (double)var20);
            var32.func_178985_a((double)var23, (double)var25, (double)(-var8), (double)var17, (double)var19);
            var32.func_178980_d(1.0F, 0.0F, 0.0F);
            var32.func_178985_a((double)var24, (double)var25, (double)(-var8), (double)var18, (double)var19);
            var32.func_178985_a((double)var24, (double)var26, (double)(-var8), (double)var18, (double)var20);
            var32.func_178985_a((double)var24, (double)var26, (double)var8, (double)var17, (double)var20);
            var32.func_178985_a((double)var24, (double)var25, (double)var8, (double)var17, (double)var19);
            var31.func_78381_a();
         }
      }

   }

   private void func_77008_a(EntityPainting p_77008_1_, float p_77008_2_, float p_77008_3_) {
      int var4 = MathHelper.func_76128_c(p_77008_1_.field_70165_t);
      int var5 = MathHelper.func_76128_c(p_77008_1_.field_70163_u + (double)(p_77008_3_ / 16.0F));
      int var6 = MathHelper.func_76128_c(p_77008_1_.field_70161_v);
      EnumFacing var7 = p_77008_1_.field_174860_b;
      if(var7 == EnumFacing.NORTH) {
         var4 = MathHelper.func_76128_c(p_77008_1_.field_70165_t + (double)(p_77008_2_ / 16.0F));
      }

      if(var7 == EnumFacing.WEST) {
         var6 = MathHelper.func_76128_c(p_77008_1_.field_70161_v - (double)(p_77008_2_ / 16.0F));
      }

      if(var7 == EnumFacing.SOUTH) {
         var4 = MathHelper.func_76128_c(p_77008_1_.field_70165_t - (double)(p_77008_2_ / 16.0F));
      }

      if(var7 == EnumFacing.EAST) {
         var6 = MathHelper.func_76128_c(p_77008_1_.field_70161_v + (double)(p_77008_2_ / 16.0F));
      }

      int var8 = this.field_76990_c.field_78722_g.func_175626_b(new BlockPos(var4, var5, var6), 0);
      int var9 = var8 % 65536;
      int var10 = var8 / 65536;
      OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)var9, (float)var10);
      GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_180562_a((EntityPainting)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityPainting)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
