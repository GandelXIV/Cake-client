package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerSpiderEyes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.ResourceLocation;

public class RenderSpider extends RenderLiving {

   private static final ResourceLocation field_110890_f = new ResourceLocation("textures/entity/spider/spider.png");
   private static final String __OBFID = "CL_00001027";


   public RenderSpider(RenderManager p_i46139_1_) {
      super(p_i46139_1_, new ModelSpider(), 1.0F);
      this.func_177094_a(new LayerSpiderEyes(this));
   }

   protected float func_77037_a(EntitySpider p_77037_1_) {
      return 180.0F;
   }

   protected ResourceLocation func_110775_a(EntitySpider p_110775_1_) {
      return field_110890_f;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected float func_77037_a(EntityLivingBase p_77037_1_) {
      return this.func_77037_a((EntitySpider)p_77037_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntitySpider)p_110775_1_);
   }

}
