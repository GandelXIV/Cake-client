package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.util.ResourceLocation;

public class RenderBlaze extends RenderLiving {

   private static final ResourceLocation field_110837_a = new ResourceLocation("textures/entity/blaze.png");
   private static final String __OBFID = "CL_00000980";


   public RenderBlaze(RenderManager p_i46191_1_) {
      super(p_i46191_1_, new ModelBlaze(), 0.5F);
   }

   protected ResourceLocation func_110775_a(EntityBlaze p_110775_1_) {
      return field_110837_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityBlaze)p_110775_1_);
   }

}
