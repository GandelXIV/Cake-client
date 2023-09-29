package net.minecraft.client.renderer.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderTNTPrimed extends Render {

   private static final String __OBFID = "CL_00001030";


   public RenderTNTPrimed(RenderManager p_i46134_1_) {
      super(p_i46134_1_);
      this.field_76989_e = 0.5F;
   }

   public void func_76986_a(EntityTNTPrimed p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      BlockRendererDispatcher var10 = Minecraft.func_71410_x().func_175602_ab();
      GlStateManager.func_179094_E();
      GlStateManager.func_179109_b((float)p_76986_2_, (float)p_76986_4_ + 0.5F, (float)p_76986_6_);
      float var11;
      if((float)p_76986_1_.field_70516_a - p_76986_9_ + 1.0F < 10.0F) {
         var11 = 1.0F - ((float)p_76986_1_.field_70516_a - p_76986_9_ + 1.0F) / 10.0F;
         var11 = MathHelper.func_76131_a(var11, 0.0F, 1.0F);
         var11 *= var11;
         var11 *= var11;
         float var12 = 1.0F + var11 * 0.3F;
         GlStateManager.func_179152_a(var12, var12, var12);
      }

      var11 = (1.0F - ((float)p_76986_1_.field_70516_a - p_76986_9_ + 1.0F) / 100.0F) * 0.8F;
      this.func_180548_c(p_76986_1_);
      GlStateManager.func_179109_b(-0.5F, -0.5F, 0.5F);
      var10.func_175016_a(Blocks.field_150335_W.func_176223_P(), p_76986_1_.func_70013_c(p_76986_9_));
      GlStateManager.func_179109_b(0.0F, 0.0F, 1.0F);
      if(p_76986_1_.field_70516_a / 5 % 2 == 0) {
         GlStateManager.func_179090_x();
         GlStateManager.func_179140_f();
         GlStateManager.func_179147_l();
         GlStateManager.func_179112_b(770, 772);
         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, var11);
         GlStateManager.func_179136_a(-3.0F, -3.0F);
         GlStateManager.func_179088_q();
         var10.func_175016_a(Blocks.field_150335_W.func_176223_P(), 1.0F);
         GlStateManager.func_179136_a(0.0F, 0.0F);
         GlStateManager.func_179113_r();
         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.func_179084_k();
         GlStateManager.func_179145_e();
         GlStateManager.func_179098_w();
      }

      GlStateManager.func_179121_F();
      super.func_76986_a(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   protected ResourceLocation func_180563_a(EntityTNTPrimed p_180563_1_) {
      return TextureMap.field_110575_b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_180563_a((EntityTNTPrimed)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityTNTPrimed)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
