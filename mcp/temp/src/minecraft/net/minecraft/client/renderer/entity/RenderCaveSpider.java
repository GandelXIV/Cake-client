package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.ResourceLocation;

public class RenderCaveSpider extends RenderSpider {

   private static final ResourceLocation field_110893_a = new ResourceLocation("textures/entity/spider/cave_spider.png");
   private static final String __OBFID = "CL_00000982";


   public RenderCaveSpider(RenderManager p_i46189_1_) {
      super(p_i46189_1_);
      this.field_76989_e *= 0.7F;
   }

   protected void func_180585_a(EntityCaveSpider p_180585_1_, float p_180585_2_) {
      GlStateManager.func_179152_a(0.7F, 0.7F, 0.7F);
   }

   protected ResourceLocation func_180586_a(EntityCaveSpider p_180586_1_) {
      return field_110893_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(EntitySpider p_110775_1_) {
      return this.func_180586_a((EntityCaveSpider)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
      this.func_180585_a((EntityCaveSpider)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_180586_a((EntityCaveSpider)p_110775_1_);
   }

}
