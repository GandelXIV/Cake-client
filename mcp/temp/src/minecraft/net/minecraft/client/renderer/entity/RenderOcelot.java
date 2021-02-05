package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.util.ResourceLocation;

public class RenderOcelot extends RenderLiving {

   private static final ResourceLocation field_110877_a = new ResourceLocation("textures/entity/cat/black.png");
   private static final ResourceLocation field_110875_f = new ResourceLocation("textures/entity/cat/ocelot.png");
   private static final ResourceLocation field_110876_g = new ResourceLocation("textures/entity/cat/red.png");
   private static final ResourceLocation field_110878_h = new ResourceLocation("textures/entity/cat/siamese.png");
   private static final String __OBFID = "CL_00001017";


   public RenderOcelot(RenderManager p_i46151_1_, ModelBase p_i46151_2_, float p_i46151_3_) {
      super(p_i46151_1_, p_i46151_2_, p_i46151_3_);
   }

   protected ResourceLocation func_110775_a(EntityOcelot p_110775_1_) {
      switch(p_110775_1_.func_70913_u()) {
      case 0:
      default:
         return field_110875_f;
      case 1:
         return field_110877_a;
      case 2:
         return field_110876_g;
      case 3:
         return field_110878_h;
      }
   }

   protected void func_77041_b(EntityOcelot p_77041_1_, float p_77041_2_) {
      super.func_77041_b(p_77041_1_, p_77041_2_);
      if(p_77041_1_.func_70909_n()) {
         GlStateManager.func_179152_a(0.8F, 0.8F, 0.8F);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
      this.func_77041_b((EntityOcelot)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityOcelot)p_110775_1_);
   }

}
