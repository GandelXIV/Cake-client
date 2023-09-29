package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

public class RenderCow extends RenderLiving {

   private static final ResourceLocation field_110833_a = new ResourceLocation("textures/entity/cow/cow.png");
   private static final String __OBFID = "CL_00000984";


   public RenderCow(RenderManager p_i46187_1_, ModelBase p_i46187_2_, float p_i46187_3_) {
      super(p_i46187_1_, p_i46187_2_, p_i46187_3_);
   }

   protected ResourceLocation func_180572_a(EntityCow p_180572_1_) {
      return field_110833_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_180572_a((EntityCow)p_110775_1_);
   }

}
