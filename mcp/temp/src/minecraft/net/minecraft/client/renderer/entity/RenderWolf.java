package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerWolfCollar;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;

public class RenderWolf extends RenderLiving {

   private static final ResourceLocation field_110917_a = new ResourceLocation("textures/entity/wolf/wolf.png");
   private static final ResourceLocation field_110915_f = new ResourceLocation("textures/entity/wolf/wolf_tame.png");
   private static final ResourceLocation field_110916_g = new ResourceLocation("textures/entity/wolf/wolf_angry.png");
   private static final String __OBFID = "CL_00001036";


   public RenderWolf(RenderManager p_i46128_1_, ModelBase p_i46128_2_, float p_i46128_3_) {
      super(p_i46128_1_, p_i46128_2_, p_i46128_3_);
      this.func_177094_a(new LayerWolfCollar(this));
   }

   protected float func_180593_a(EntityWolf p_180593_1_, float p_180593_2_) {
      return p_180593_1_.func_70920_v();
   }

   public void func_177135_a(EntityWolf p_177135_1_, double p_177135_2_, double p_177135_4_, double p_177135_6_, float p_177135_8_, float p_177135_9_) {
      if(p_177135_1_.func_70921_u()) {
         float var10 = p_177135_1_.func_70013_c(p_177135_9_) * p_177135_1_.func_70915_j(p_177135_9_);
         GlStateManager.func_179124_c(var10, var10, var10);
      }

      super.func_76986_a((EntityLiving)p_177135_1_, p_177135_2_, p_177135_4_, p_177135_6_, p_177135_8_, p_177135_9_);
   }

   protected ResourceLocation func_110775_a(EntityWolf p_110775_1_) {
      return p_110775_1_.func_70909_n()?field_110915_f:(p_110775_1_.func_70919_bu()?field_110916_g:field_110917_a);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_177135_a((EntityWolf)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   protected float func_77044_a(EntityLivingBase p_77044_1_, float p_77044_2_) {
      return this.func_180593_a((EntityWolf)p_77044_1_, p_77044_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_177135_a((EntityWolf)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityWolf)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_177135_a((EntityWolf)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
