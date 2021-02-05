package net.minecraft.client.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;

public class Gui {

   public static final ResourceLocation field_110325_k = new ResourceLocation("textures/gui/options_background.png");
   public static final ResourceLocation field_110323_l = new ResourceLocation("textures/gui/container/stats_icons.png");
   public static final ResourceLocation field_110324_m = new ResourceLocation("textures/gui/icons.png");
   protected float field_73735_i;
   private static final String __OBFID = "CL_00000662";


   protected void func_73730_a(int p_73730_1_, int p_73730_2_, int p_73730_3_, int p_73730_4_) {
      if(p_73730_2_ < p_73730_1_) {
         int var5 = p_73730_1_;
         p_73730_1_ = p_73730_2_;
         p_73730_2_ = var5;
      }

      func_73734_a(p_73730_1_, p_73730_3_, p_73730_2_ + 1, p_73730_3_ + 1, p_73730_4_);
   }

   protected void func_73728_b(int p_73728_1_, int p_73728_2_, int p_73728_3_, int p_73728_4_) {
      if(p_73728_3_ < p_73728_2_) {
         int var5 = p_73728_2_;
         p_73728_2_ = p_73728_3_;
         p_73728_3_ = var5;
      }

      func_73734_a(p_73728_1_, p_73728_2_ + 1, p_73728_1_ + 1, p_73728_3_, p_73728_4_);
   }

   public static void func_73734_a(int p_73734_0_, int p_73734_1_, int p_73734_2_, int p_73734_3_, int p_73734_4_) {
      int var5;
      if(p_73734_0_ < p_73734_2_) {
         var5 = p_73734_0_;
         p_73734_0_ = p_73734_2_;
         p_73734_2_ = var5;
      }

      if(p_73734_1_ < p_73734_3_) {
         var5 = p_73734_1_;
         p_73734_1_ = p_73734_3_;
         p_73734_3_ = var5;
      }

      float var11 = (float)(p_73734_4_ >> 24 & 255) / 255.0F;
      float var6 = (float)(p_73734_4_ >> 16 & 255) / 255.0F;
      float var7 = (float)(p_73734_4_ >> 8 & 255) / 255.0F;
      float var8 = (float)(p_73734_4_ & 255) / 255.0F;
      Tessellator var9 = Tessellator.func_178181_a();
      WorldRenderer var10 = var9.func_178180_c();
      GlStateManager.func_179147_l();
      GlStateManager.func_179090_x();
      GlStateManager.func_179120_a(770, 771, 1, 0);
      GlStateManager.func_179131_c(var6, var7, var8, var11);
      var10.func_178970_b();
      var10.func_178984_b((double)p_73734_0_, (double)p_73734_3_, 0.0D);
      var10.func_178984_b((double)p_73734_2_, (double)p_73734_3_, 0.0D);
      var10.func_178984_b((double)p_73734_2_, (double)p_73734_1_, 0.0D);
      var10.func_178984_b((double)p_73734_0_, (double)p_73734_1_, 0.0D);
      var9.func_78381_a();
      GlStateManager.func_179098_w();
      GlStateManager.func_179084_k();
   }

   protected void func_73733_a(int p_73733_1_, int p_73733_2_, int p_73733_3_, int p_73733_4_, int p_73733_5_, int p_73733_6_) {
      float var7 = (float)(p_73733_5_ >> 24 & 255) / 255.0F;
      float var8 = (float)(p_73733_5_ >> 16 & 255) / 255.0F;
      float var9 = (float)(p_73733_5_ >> 8 & 255) / 255.0F;
      float var10 = (float)(p_73733_5_ & 255) / 255.0F;
      float var11 = (float)(p_73733_6_ >> 24 & 255) / 255.0F;
      float var12 = (float)(p_73733_6_ >> 16 & 255) / 255.0F;
      float var13 = (float)(p_73733_6_ >> 8 & 255) / 255.0F;
      float var14 = (float)(p_73733_6_ & 255) / 255.0F;
      GlStateManager.func_179090_x();
      GlStateManager.func_179147_l();
      GlStateManager.func_179118_c();
      GlStateManager.func_179120_a(770, 771, 1, 0);
      GlStateManager.func_179103_j(7425);
      Tessellator var15 = Tessellator.func_178181_a();
      WorldRenderer var16 = var15.func_178180_c();
      var16.func_178970_b();
      var16.func_178960_a(var8, var9, var10, var7);
      var16.func_178984_b((double)p_73733_3_, (double)p_73733_2_, (double)this.field_73735_i);
      var16.func_178984_b((double)p_73733_1_, (double)p_73733_2_, (double)this.field_73735_i);
      var16.func_178960_a(var12, var13, var14, var11);
      var16.func_178984_b((double)p_73733_1_, (double)p_73733_4_, (double)this.field_73735_i);
      var16.func_178984_b((double)p_73733_3_, (double)p_73733_4_, (double)this.field_73735_i);
      var15.func_78381_a();
      GlStateManager.func_179103_j(7424);
      GlStateManager.func_179084_k();
      GlStateManager.func_179141_d();
      GlStateManager.func_179098_w();
   }

   public void func_73732_a(FontRenderer p_73732_1_, String p_73732_2_, int p_73732_3_, int p_73732_4_, int p_73732_5_) {
      p_73732_1_.func_175063_a(p_73732_2_, (float)(p_73732_3_ - p_73732_1_.func_78256_a(p_73732_2_) / 2), (float)p_73732_4_, p_73732_5_);
   }

   public void func_73731_b(FontRenderer p_73731_1_, String p_73731_2_, int p_73731_3_, int p_73731_4_, int p_73731_5_) {
      p_73731_1_.func_175063_a(p_73731_2_, (float)p_73731_3_, (float)p_73731_4_, p_73731_5_);
   }

   public void func_73729_b(int p_73729_1_, int p_73729_2_, int p_73729_3_, int p_73729_4_, int p_73729_5_, int p_73729_6_) {
      float var7 = 0.00390625F;
      float var8 = 0.00390625F;
      Tessellator var9 = Tessellator.func_178181_a();
      WorldRenderer var10 = var9.func_178180_c();
      var10.func_178970_b();
      var10.func_178985_a((double)(p_73729_1_ + 0), (double)(p_73729_2_ + p_73729_6_), (double)this.field_73735_i, (double)((float)(p_73729_3_ + 0) * var7), (double)((float)(p_73729_4_ + p_73729_6_) * var8));
      var10.func_178985_a((double)(p_73729_1_ + p_73729_5_), (double)(p_73729_2_ + p_73729_6_), (double)this.field_73735_i, (double)((float)(p_73729_3_ + p_73729_5_) * var7), (double)((float)(p_73729_4_ + p_73729_6_) * var8));
      var10.func_178985_a((double)(p_73729_1_ + p_73729_5_), (double)(p_73729_2_ + 0), (double)this.field_73735_i, (double)((float)(p_73729_3_ + p_73729_5_) * var7), (double)((float)(p_73729_4_ + 0) * var8));
      var10.func_178985_a((double)(p_73729_1_ + 0), (double)(p_73729_2_ + 0), (double)this.field_73735_i, (double)((float)(p_73729_3_ + 0) * var7), (double)((float)(p_73729_4_ + 0) * var8));
      var9.func_78381_a();
   }

   public void func_175174_a(float p_175174_1_, float p_175174_2_, int p_175174_3_, int p_175174_4_, int p_175174_5_, int p_175174_6_) {
      float var7 = 0.00390625F;
      float var8 = 0.00390625F;
      Tessellator var9 = Tessellator.func_178181_a();
      WorldRenderer var10 = var9.func_178180_c();
      var10.func_178970_b();
      var10.func_178985_a((double)(p_175174_1_ + 0.0F), (double)(p_175174_2_ + (float)p_175174_6_), (double)this.field_73735_i, (double)((float)(p_175174_3_ + 0) * var7), (double)((float)(p_175174_4_ + p_175174_6_) * var8));
      var10.func_178985_a((double)(p_175174_1_ + (float)p_175174_5_), (double)(p_175174_2_ + (float)p_175174_6_), (double)this.field_73735_i, (double)((float)(p_175174_3_ + p_175174_5_) * var7), (double)((float)(p_175174_4_ + p_175174_6_) * var8));
      var10.func_178985_a((double)(p_175174_1_ + (float)p_175174_5_), (double)(p_175174_2_ + 0.0F), (double)this.field_73735_i, (double)((float)(p_175174_3_ + p_175174_5_) * var7), (double)((float)(p_175174_4_ + 0) * var8));
      var10.func_178985_a((double)(p_175174_1_ + 0.0F), (double)(p_175174_2_ + 0.0F), (double)this.field_73735_i, (double)((float)(p_175174_3_ + 0) * var7), (double)((float)(p_175174_4_ + 0) * var8));
      var9.func_78381_a();
   }

   public void func_175175_a(int p_175175_1_, int p_175175_2_, TextureAtlasSprite p_175175_3_, int p_175175_4_, int p_175175_5_) {
      Tessellator var6 = Tessellator.func_178181_a();
      WorldRenderer var7 = var6.func_178180_c();
      var7.func_178970_b();
      var7.func_178985_a((double)(p_175175_1_ + 0), (double)(p_175175_2_ + p_175175_5_), (double)this.field_73735_i, (double)p_175175_3_.func_94209_e(), (double)p_175175_3_.func_94210_h());
      var7.func_178985_a((double)(p_175175_1_ + p_175175_4_), (double)(p_175175_2_ + p_175175_5_), (double)this.field_73735_i, (double)p_175175_3_.func_94212_f(), (double)p_175175_3_.func_94210_h());
      var7.func_178985_a((double)(p_175175_1_ + p_175175_4_), (double)(p_175175_2_ + 0), (double)this.field_73735_i, (double)p_175175_3_.func_94212_f(), (double)p_175175_3_.func_94206_g());
      var7.func_178985_a((double)(p_175175_1_ + 0), (double)(p_175175_2_ + 0), (double)this.field_73735_i, (double)p_175175_3_.func_94209_e(), (double)p_175175_3_.func_94206_g());
      var6.func_78381_a();
   }

   public static void func_146110_a(int p_146110_0_, int p_146110_1_, float p_146110_2_, float p_146110_3_, int p_146110_4_, int p_146110_5_, float p_146110_6_, float p_146110_7_) {
      float var8 = 1.0F / p_146110_6_;
      float var9 = 1.0F / p_146110_7_;
      Tessellator var10 = Tessellator.func_178181_a();
      WorldRenderer var11 = var10.func_178180_c();
      var11.func_178970_b();
      var11.func_178985_a((double)p_146110_0_, (double)(p_146110_1_ + p_146110_5_), 0.0D, (double)(p_146110_2_ * var8), (double)((p_146110_3_ + (float)p_146110_5_) * var9));
      var11.func_178985_a((double)(p_146110_0_ + p_146110_4_), (double)(p_146110_1_ + p_146110_5_), 0.0D, (double)((p_146110_2_ + (float)p_146110_4_) * var8), (double)((p_146110_3_ + (float)p_146110_5_) * var9));
      var11.func_178985_a((double)(p_146110_0_ + p_146110_4_), (double)p_146110_1_, 0.0D, (double)((p_146110_2_ + (float)p_146110_4_) * var8), (double)(p_146110_3_ * var9));
      var11.func_178985_a((double)p_146110_0_, (double)p_146110_1_, 0.0D, (double)(p_146110_2_ * var8), (double)(p_146110_3_ * var9));
      var10.func_78381_a();
   }

   public static void func_152125_a(int p_152125_0_, int p_152125_1_, float p_152125_2_, float p_152125_3_, int p_152125_4_, int p_152125_5_, int p_152125_6_, int p_152125_7_, float p_152125_8_, float p_152125_9_) {
      float var10 = 1.0F / p_152125_8_;
      float var11 = 1.0F / p_152125_9_;
      Tessellator var12 = Tessellator.func_178181_a();
      WorldRenderer var13 = var12.func_178180_c();
      var13.func_178970_b();
      var13.func_178985_a((double)p_152125_0_, (double)(p_152125_1_ + p_152125_7_), 0.0D, (double)(p_152125_2_ * var10), (double)((p_152125_3_ + (float)p_152125_5_) * var11));
      var13.func_178985_a((double)(p_152125_0_ + p_152125_6_), (double)(p_152125_1_ + p_152125_7_), 0.0D, (double)((p_152125_2_ + (float)p_152125_4_) * var10), (double)((p_152125_3_ + (float)p_152125_5_) * var11));
      var13.func_178985_a((double)(p_152125_0_ + p_152125_6_), (double)p_152125_1_, 0.0D, (double)((p_152125_2_ + (float)p_152125_4_) * var10), (double)(p_152125_3_ * var11));
      var13.func_178985_a((double)p_152125_0_, (double)p_152125_1_, 0.0D, (double)(p_152125_2_ * var10), (double)(p_152125_3_ * var11));
      var12.func_78381_a();
   }

}
