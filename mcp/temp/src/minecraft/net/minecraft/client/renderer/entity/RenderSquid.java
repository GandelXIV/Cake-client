package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.util.ResourceLocation;

public class RenderSquid extends RenderLiving {

   private static final ResourceLocation field_110901_a = new ResourceLocation("textures/entity/squid.png");
   private static final String __OBFID = "CL_00001028";


   public RenderSquid(RenderManager p_i46138_1_, ModelBase p_i46138_2_, float p_i46138_3_) {
      super(p_i46138_1_, p_i46138_2_, p_i46138_3_);
   }

   protected ResourceLocation func_110775_a(EntitySquid p_110775_1_) {
      return field_110901_a;
   }

   protected void func_77043_a(EntitySquid p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
      float var5 = p_77043_1_.field_70862_e + (p_77043_1_.field_70861_d - p_77043_1_.field_70862_e) * p_77043_4_;
      float var6 = p_77043_1_.field_70860_g + (p_77043_1_.field_70859_f - p_77043_1_.field_70860_g) * p_77043_4_;
      GlStateManager.func_179109_b(0.0F, 0.5F, 0.0F);
      GlStateManager.func_179114_b(180.0F - p_77043_3_, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b(var5, 1.0F, 0.0F, 0.0F);
      GlStateManager.func_179114_b(var6, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179109_b(0.0F, -1.2F, 0.0F);
   }

   protected float func_77044_a(EntitySquid p_77044_1_, float p_77044_2_) {
      return p_77044_1_.field_70865_by + (p_77044_1_.field_70866_j - p_77044_1_.field_70865_by) * p_77044_2_;
   }

   // $FF: synthetic method
   protected float func_77044_a(EntityLivingBase p_77044_1_, float p_77044_2_) {
      return this.func_77044_a((EntitySquid)p_77044_1_, p_77044_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77043_a(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
      this.func_77043_a((EntitySquid)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntitySquid)p_110775_1_);
   }

}
