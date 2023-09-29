package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSnowMan;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerSnowmanHead;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.util.ResourceLocation;

public class RenderSnowMan extends RenderLiving {

   private static final ResourceLocation field_110895_a = new ResourceLocation("textures/entity/snowman.png");
   private static final String __OBFID = "CL_00001025";


   public RenderSnowMan(RenderManager p_i46140_1_) {
      super(p_i46140_1_, new ModelSnowMan(), 0.5F);
      this.func_177094_a(new LayerSnowmanHead(this));
   }

   protected ResourceLocation func_180587_a(EntitySnowman p_180587_1_) {
      return field_110895_a;
   }

   public ModelSnowMan func_177123_g() {
      return (ModelSnowMan)super.func_177087_b();
   }

   // $FF: synthetic method
   public ModelBase func_177087_b() {
      return this.func_177123_g();
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_180587_a((EntitySnowman)p_110775_1_);
   }

}
