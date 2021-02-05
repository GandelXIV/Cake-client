package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelDragon;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerEnderDragonDeath;
import net.minecraft.client.renderer.entity.layers.LayerEnderDragonEyes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderDragon extends RenderLiving {

   private static final ResourceLocation field_110843_g = new ResourceLocation("textures/entity/endercrystal/endercrystal_beam.png");
   private static final ResourceLocation field_110842_f = new ResourceLocation("textures/entity/enderdragon/dragon_exploding.png");
   private static final ResourceLocation field_110844_k = new ResourceLocation("textures/entity/enderdragon/dragon.png");
   protected ModelDragon field_77084_b;
   private static final String __OBFID = "CL_00000988";


   public RenderDragon(RenderManager p_i46183_1_) {
      super(p_i46183_1_, new ModelDragon(0.0F), 0.5F);
      this.field_77084_b = (ModelDragon)this.field_77045_g;
      this.func_177094_a(new LayerEnderDragonEyes(this));
      this.func_177094_a(new LayerEnderDragonDeath());
   }

   protected void func_180575_a(EntityDragon p_180575_1_, float p_180575_2_, float p_180575_3_, float p_180575_4_) {
      float var5 = (float)p_180575_1_.func_70974_a(7, p_180575_4_)[0];
      float var6 = (float)(p_180575_1_.func_70974_a(5, p_180575_4_)[1] - p_180575_1_.func_70974_a(10, p_180575_4_)[1]);
      GlStateManager.func_179114_b(-var5, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b(var6 * 10.0F, 1.0F, 0.0F, 0.0F);
      GlStateManager.func_179109_b(0.0F, 0.0F, 1.0F);
      if(p_180575_1_.field_70725_aQ > 0) {
         float var7 = ((float)p_180575_1_.field_70725_aQ + p_180575_4_ - 1.0F) / 20.0F * 1.6F;
         var7 = MathHelper.func_76129_c(var7);
         if(var7 > 1.0F) {
            var7 = 1.0F;
         }

         GlStateManager.func_179114_b(var7 * this.func_77037_a(p_180575_1_), 0.0F, 0.0F, 1.0F);
      }

   }

   protected void func_77036_a(EntityDragon p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
      if(p_77036_1_.field_70995_bG > 0) {
         float var8 = (float)p_77036_1_.field_70995_bG / 200.0F;
         GlStateManager.func_179143_c(515);
         GlStateManager.func_179141_d();
         GlStateManager.func_179092_a(516, var8);
         this.func_110776_a(field_110842_f);
         this.field_77045_g.func_78088_a(p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
         GlStateManager.func_179092_a(516, 0.1F);
         GlStateManager.func_179143_c(514);
      }

      this.func_180548_c(p_77036_1_);
      this.field_77045_g.func_78088_a(p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
      if(p_77036_1_.field_70737_aN > 0) {
         GlStateManager.func_179143_c(514);
         GlStateManager.func_179090_x();
         GlStateManager.func_179147_l();
         GlStateManager.func_179112_b(770, 771);
         GlStateManager.func_179131_c(1.0F, 0.0F, 0.0F, 0.5F);
         this.field_77045_g.func_78088_a(p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
         GlStateManager.func_179098_w();
         GlStateManager.func_179084_k();
         GlStateManager.func_179143_c(515);
      }

   }

   public void func_76986_a(EntityDragon p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      BossStatus.func_82824_a(p_76986_1_, false);
      super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
      if(p_76986_1_.field_70992_bH != null) {
         this.func_180574_a(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_9_);
      }

   }

   protected void func_180574_a(EntityDragon p_180574_1_, double p_180574_2_, double p_180574_4_, double p_180574_6_, float p_180574_8_) {
      float var9 = (float)p_180574_1_.field_70992_bH.field_70261_a + p_180574_8_;
      float var10 = MathHelper.func_76126_a(var9 * 0.2F) / 2.0F + 0.5F;
      var10 = (var10 * var10 + var10) * 0.2F;
      float var11 = (float)(p_180574_1_.field_70992_bH.field_70165_t - p_180574_1_.field_70165_t - (p_180574_1_.field_70169_q - p_180574_1_.field_70165_t) * (double)(1.0F - p_180574_8_));
      float var12 = (float)((double)var10 + p_180574_1_.field_70992_bH.field_70163_u - 1.0D - p_180574_1_.field_70163_u - (p_180574_1_.field_70167_r - p_180574_1_.field_70163_u) * (double)(1.0F - p_180574_8_));
      float var13 = (float)(p_180574_1_.field_70992_bH.field_70161_v - p_180574_1_.field_70161_v - (p_180574_1_.field_70166_s - p_180574_1_.field_70161_v) * (double)(1.0F - p_180574_8_));
      float var14 = MathHelper.func_76129_c(var11 * var11 + var13 * var13);
      float var15 = MathHelper.func_76129_c(var11 * var11 + var12 * var12 + var13 * var13);
      GlStateManager.func_179094_E();
      GlStateManager.func_179109_b((float)p_180574_2_, (float)p_180574_4_ + 2.0F, (float)p_180574_6_);
      GlStateManager.func_179114_b((float)(-Math.atan2((double)var13, (double)var11)) * 180.0F / 3.1415927F - 90.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b((float)(-Math.atan2((double)var14, (double)var12)) * 180.0F / 3.1415927F - 90.0F, 1.0F, 0.0F, 0.0F);
      Tessellator var16 = Tessellator.func_178181_a();
      WorldRenderer var17 = var16.func_178180_c();
      RenderHelper.func_74518_a();
      GlStateManager.func_179129_p();
      this.func_110776_a(field_110843_g);
      GlStateManager.func_179103_j(7425);
      float var18 = 0.0F - ((float)p_180574_1_.field_70173_aa + p_180574_8_) * 0.01F;
      float var19 = MathHelper.func_76129_c(var11 * var11 + var12 * var12 + var13 * var13) / 32.0F - ((float)p_180574_1_.field_70173_aa + p_180574_8_) * 0.01F;
      var17.func_178964_a(5);
      byte var20 = 8;

      for(int var21 = 0; var21 <= var20; ++var21) {
         float var22 = MathHelper.func_76126_a((float)(var21 % var20) * 3.1415927F * 2.0F / (float)var20) * 0.75F;
         float var23 = MathHelper.func_76134_b((float)(var21 % var20) * 3.1415927F * 2.0F / (float)var20) * 0.75F;
         float var24 = (float)(var21 % var20) * 1.0F / (float)var20;
         var17.func_178991_c(0);
         var17.func_178985_a((double)(var22 * 0.2F), (double)(var23 * 0.2F), 0.0D, (double)var24, (double)var19);
         var17.func_178991_c(16777215);
         var17.func_178985_a((double)var22, (double)var23, (double)var15, (double)var24, (double)var18);
      }

      var16.func_78381_a();
      GlStateManager.func_179089_o();
      GlStateManager.func_179103_j(7424);
      RenderHelper.func_74519_b();
      GlStateManager.func_179121_F();
   }

   protected ResourceLocation func_110775_a(EntityDragon p_110775_1_) {
      return field_110844_k;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityDragon)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77043_a(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
      this.func_180575_a((EntityDragon)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77036_a(EntityLivingBase p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
      this.func_77036_a((EntityDragon)p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityDragon)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityDragon)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityDragon)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
