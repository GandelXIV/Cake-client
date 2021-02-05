package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelLeashKnot;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.util.ResourceLocation;

public class RenderLeashKnot extends Render {

   private static final ResourceLocation field_110802_a = new ResourceLocation("textures/entity/lead_knot.png");
   private ModelLeashKnot field_110801_f = new ModelLeashKnot();
   private static final String __OBFID = "CL_00001010";


   public RenderLeashKnot(RenderManager p_i46158_1_) {
      super(p_i46158_1_);
   }

   public void func_180559_a(EntityLeashKnot p_180559_1_, double p_180559_2_, double p_180559_4_, double p_180559_6_, float p_180559_8_, float p_180559_9_) {
      GlStateManager.func_179094_E();
      GlStateManager.func_179129_p();
      GlStateManager.func_179109_b((float)p_180559_2_, (float)p_180559_4_, (float)p_180559_6_);
      float var10 = 0.0625F;
      GlStateManager.func_179091_B();
      GlStateManager.func_179152_a(-1.0F, -1.0F, 1.0F);
      GlStateManager.func_179141_d();
      this.func_180548_c(p_180559_1_);
      this.field_110801_f.func_78088_a(p_180559_1_, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, var10);
      GlStateManager.func_179121_F();
      super.func_76986_a(p_180559_1_, p_180559_2_, p_180559_4_, p_180559_6_, p_180559_8_, p_180559_9_);
   }

   protected ResourceLocation func_110775_a(EntityLeashKnot p_110775_1_) {
      return field_110802_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityLeashKnot)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_180559_a((EntityLeashKnot)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
