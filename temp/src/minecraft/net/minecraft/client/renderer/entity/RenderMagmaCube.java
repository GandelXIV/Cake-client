package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelMagmaCube;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.util.ResourceLocation;

public class RenderMagmaCube extends RenderLiving {

   private static final ResourceLocation field_110873_a = new ResourceLocation("textures/entity/slime/magmacube.png");
   private static final String __OBFID = "CL_00001009";


   public RenderMagmaCube(RenderManager p_i46159_1_) {
      super(p_i46159_1_, new ModelMagmaCube(), 0.25F);
   }

   protected ResourceLocation func_110775_a(EntityMagmaCube p_110775_1_) {
      return field_110873_a;
   }

   protected void func_77041_b(EntityMagmaCube p_77041_1_, float p_77041_2_) {
      int var3 = p_77041_1_.func_70809_q();
      float var4 = (p_77041_1_.field_70812_c + (p_77041_1_.field_70811_b - p_77041_1_.field_70812_c) * p_77041_2_) / ((float)var3 * 0.5F + 1.0F);
      float var5 = 1.0F / (var4 + 1.0F);
      float var6 = (float)var3;
      GlStateManager.func_179152_a(var5 * var6, 1.0F / var5 * var6, var5 * var6);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
      this.func_77041_b((EntityMagmaCube)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityMagmaCube)p_110775_1_);
   }

}
