package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelGhast;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.util.ResourceLocation;

public class RenderGhast extends RenderLiving {

   private static final ResourceLocation field_110869_a = new ResourceLocation("textures/entity/ghast/ghast.png");
   private static final ResourceLocation field_110868_f = new ResourceLocation("textures/entity/ghast/ghast_shooting.png");
   private static final String __OBFID = "CL_00000997";


   public RenderGhast(RenderManager p_i46174_1_) {
      super(p_i46174_1_, new ModelGhast(), 0.5F);
   }

   protected ResourceLocation func_180576_a(EntityGhast p_180576_1_) {
      return p_180576_1_.func_110182_bF()?field_110868_f:field_110869_a;
   }

   protected void func_77041_b(EntityGhast p_77041_1_, float p_77041_2_) {
      float var3 = 1.0F;
      float var4 = (8.0F + var3) / 2.0F;
      float var5 = (8.0F + 1.0F / var3) / 2.0F;
      GlStateManager.func_179152_a(var5, var4, var5);
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
      this.func_77041_b((EntityGhast)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_180576_a((EntityGhast)p_110775_1_);
   }

}
