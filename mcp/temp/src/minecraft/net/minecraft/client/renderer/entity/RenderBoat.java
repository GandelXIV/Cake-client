package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderBoat extends Render {

   private static final ResourceLocation field_110782_f = new ResourceLocation("textures/entity/boat.png");
   protected ModelBase field_76998_a = new ModelBoat();
   private static final String __OBFID = "CL_00000981";


   public RenderBoat(RenderManager p_i46190_1_) {
      super(p_i46190_1_);
      this.field_76989_e = 0.5F;
   }

   public void func_180552_a(EntityBoat p_180552_1_, double p_180552_2_, double p_180552_4_, double p_180552_6_, float p_180552_8_, float p_180552_9_) {
      GlStateManager.func_179094_E();
      GlStateManager.func_179109_b((float)p_180552_2_, (float)p_180552_4_ + 0.25F, (float)p_180552_6_);
      GlStateManager.func_179114_b(180.0F - p_180552_8_, 0.0F, 1.0F, 0.0F);
      float var10 = (float)p_180552_1_.func_70268_h() - p_180552_9_;
      float var11 = p_180552_1_.func_70271_g() - p_180552_9_;
      if(var11 < 0.0F) {
         var11 = 0.0F;
      }

      if(var10 > 0.0F) {
         GlStateManager.func_179114_b(MathHelper.func_76126_a(var10) * var10 * var11 / 10.0F * (float)p_180552_1_.func_70267_i(), 1.0F, 0.0F, 0.0F);
      }

      float var12 = 0.75F;
      GlStateManager.func_179152_a(var12, var12, var12);
      GlStateManager.func_179152_a(1.0F / var12, 1.0F / var12, 1.0F / var12);
      this.func_180548_c(p_180552_1_);
      GlStateManager.func_179152_a(-1.0F, -1.0F, 1.0F);
      this.field_76998_a.func_78088_a(p_180552_1_, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
      GlStateManager.func_179121_F();
      super.func_76986_a(p_180552_1_, p_180552_2_, p_180552_4_, p_180552_6_, p_180552_8_, p_180552_9_);
   }

   protected ResourceLocation func_180553_a(EntityBoat p_180553_1_) {
      return field_110782_f;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_180553_a((EntityBoat)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_180552_a((EntityBoat)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
