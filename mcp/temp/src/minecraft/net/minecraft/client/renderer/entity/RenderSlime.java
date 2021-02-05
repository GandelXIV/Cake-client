package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerSlimeGel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.ResourceLocation;

public class RenderSlime extends RenderLiving {

   private static final ResourceLocation field_110897_a = new ResourceLocation("textures/entity/slime/slime.png");
   private static final String __OBFID = "CL_00001024";


   public RenderSlime(RenderManager p_i46141_1_, ModelBase p_i46141_2_, float p_i46141_3_) {
      super(p_i46141_1_, p_i46141_2_, p_i46141_3_);
      this.func_177094_a(new LayerSlimeGel(this));
   }

   public void func_177124_a(EntitySlime p_177124_1_, double p_177124_2_, double p_177124_4_, double p_177124_6_, float p_177124_8_, float p_177124_9_) {
      this.field_76989_e = 0.25F * (float)p_177124_1_.func_70809_q();
      super.func_76986_a((EntityLiving)p_177124_1_, p_177124_2_, p_177124_4_, p_177124_6_, p_177124_8_, p_177124_9_);
   }

   protected void func_77041_b(EntitySlime p_77041_1_, float p_77041_2_) {
      float var3 = (float)p_77041_1_.func_70809_q();
      float var4 = (p_77041_1_.field_70812_c + (p_77041_1_.field_70811_b - p_77041_1_.field_70812_c) * p_77041_2_) / (var3 * 0.5F + 1.0F);
      float var5 = 1.0F / (var4 + 1.0F);
      GlStateManager.func_179152_a(var5 * var3, 1.0F / var5 * var3, var5 * var3);
   }

   protected ResourceLocation func_110775_a(EntitySlime p_110775_1_) {
      return field_110897_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_177124_a((EntitySlime)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
      this.func_77041_b((EntitySlime)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_177124_a((EntitySlime)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntitySlime)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_177124_a((EntitySlime)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
