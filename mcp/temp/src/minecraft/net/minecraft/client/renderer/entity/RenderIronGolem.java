package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelIronGolem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerIronGolemFlower;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.util.ResourceLocation;

public class RenderIronGolem extends RenderLiving {

   private static final ResourceLocation field_110899_a = new ResourceLocation("textures/entity/iron_golem.png");
   private static final String __OBFID = "CL_00001031";


   public RenderIronGolem(RenderManager p_i46133_1_) {
      super(p_i46133_1_, new ModelIronGolem(), 0.5F);
      this.func_177094_a(new LayerIronGolemFlower(this));
   }

   protected ResourceLocation func_110775_a(EntityIronGolem p_110775_1_) {
      return field_110899_a;
   }

   protected void func_180588_a(EntityIronGolem p_180588_1_, float p_180588_2_, float p_180588_3_, float p_180588_4_) {
      super.func_77043_a(p_180588_1_, p_180588_2_, p_180588_3_, p_180588_4_);
      if((double)p_180588_1_.field_70721_aZ >= 0.01D) {
         float var5 = 13.0F;
         float var6 = p_180588_1_.field_70754_ba - p_180588_1_.field_70721_aZ * (1.0F - p_180588_4_) + 6.0F;
         float var7 = (Math.abs(var6 % var5 - var5 * 0.5F) - var5 * 0.25F) / (var5 * 0.25F);
         GlStateManager.func_179114_b(6.5F * var7, 0.0F, 0.0F, 1.0F);
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77043_a(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
      this.func_180588_a((EntityIronGolem)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityIronGolem)p_110775_1_);
   }

}
