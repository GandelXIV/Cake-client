package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelWither;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerWitherAura;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.util.ResourceLocation;

public class RenderWither extends RenderLiving {

   private static final ResourceLocation field_110913_a = new ResourceLocation("textures/entity/wither/wither_invulnerable.png");
   private static final ResourceLocation field_110912_f = new ResourceLocation("textures/entity/wither/wither.png");
   private static final String __OBFID = "CL_00001034";


   public RenderWither(RenderManager p_i46130_1_) {
      super(p_i46130_1_, new ModelWither(0.0F), 1.0F);
      this.func_177094_a(new LayerWitherAura(this));
   }

   public void func_180591_a(EntityWither p_180591_1_, double p_180591_2_, double p_180591_4_, double p_180591_6_, float p_180591_8_, float p_180591_9_) {
      BossStatus.func_82824_a(p_180591_1_, true);
      super.func_76986_a((EntityLiving)p_180591_1_, p_180591_2_, p_180591_4_, p_180591_6_, p_180591_8_, p_180591_9_);
   }

   protected ResourceLocation func_110775_a(EntityWither p_110775_1_) {
      int var2 = p_110775_1_.func_82212_n();
      return var2 > 0 && (var2 > 80 || var2 / 5 % 2 != 1)?field_110913_a:field_110912_f;
   }

   protected void func_180592_a(EntityWither p_180592_1_, float p_180592_2_) {
      float var3 = 2.0F;
      int var4 = p_180592_1_.func_82212_n();
      if(var4 > 0) {
         var3 -= ((float)var4 - p_180592_2_) / 220.0F * 0.5F;
      }

      GlStateManager.func_179152_a(var3, var3, var3);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_180591_a((EntityWither)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
      this.func_180592_a((EntityWither)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_180591_a((EntityWither)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityWither)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_180591_a((EntityWither)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
