package net.minecraft.client.renderer.entity.layers;

import java.util.Random;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;

public class LayerEnderDragonDeath implements LayerRenderer {

   private static final String __OBFID = "CL_00002420";


   public void func_177213_a(EntityDragon p_177213_1_, float p_177213_2_, float p_177213_3_, float p_177213_4_, float p_177213_5_, float p_177213_6_, float p_177213_7_, float p_177213_8_) {
      if(p_177213_1_.field_70995_bG > 0) {
         Tessellator var9 = Tessellator.func_178181_a();
         WorldRenderer var10 = var9.func_178180_c();
         RenderHelper.func_74518_a();
         float var11 = ((float)p_177213_1_.field_70995_bG + p_177213_4_) / 200.0F;
         float var12 = 0.0F;
         if(var11 > 0.8F) {
            var12 = (var11 - 0.8F) / 0.2F;
         }

         Random var13 = new Random(432L);
         GlStateManager.func_179090_x();
         GlStateManager.func_179103_j(7425);
         GlStateManager.func_179147_l();
         GlStateManager.func_179112_b(770, 1);
         GlStateManager.func_179118_c();
         GlStateManager.func_179089_o();
         GlStateManager.func_179132_a(false);
         GlStateManager.func_179094_E();
         GlStateManager.func_179109_b(0.0F, -1.0F, -2.0F);

         for(int var14 = 0; (float)var14 < (var11 + var11 * var11) / 2.0F * 60.0F; ++var14) {
            GlStateManager.func_179114_b(var13.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.func_179114_b(var13.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.func_179114_b(var13.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
            GlStateManager.func_179114_b(var13.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.func_179114_b(var13.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.func_179114_b(var13.nextFloat() * 360.0F + var11 * 90.0F, 0.0F, 0.0F, 1.0F);
            var10.func_178964_a(6);
            float var15 = var13.nextFloat() * 20.0F + 5.0F + var12 * 10.0F;
            float var16 = var13.nextFloat() * 2.0F + 1.0F + var12 * 2.0F;
            var10.func_178974_a(16777215, (int)(255.0F * (1.0F - var12)));
            var10.func_178984_b(0.0D, 0.0D, 0.0D);
            var10.func_178974_a(16711935, 0);
            var10.func_178984_b(-0.866D * (double)var16, (double)var15, (double)(-0.5F * var16));
            var10.func_178984_b(0.866D * (double)var16, (double)var15, (double)(-0.5F * var16));
            var10.func_178984_b(0.0D, (double)var15, (double)(1.0F * var16));
            var10.func_178984_b(-0.866D * (double)var16, (double)var15, (double)(-0.5F * var16));
            var9.func_78381_a();
         }

         GlStateManager.func_179121_F();
         GlStateManager.func_179132_a(true);
         GlStateManager.func_179129_p();
         GlStateManager.func_179084_k();
         GlStateManager.func_179103_j(7424);
         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.func_179098_w();
         GlStateManager.func_179141_d();
         RenderHelper.func_74519_b();
      }
   }

   public boolean func_177142_b() {
      return false;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_177141_a(EntityLivingBase p_177141_1_, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
      this.func_177213_a((EntityDragon)p_177141_1_, p_177141_2_, p_177141_3_, p_177141_4_, p_177141_5_, p_177141_6_, p_177141_7_, p_177141_8_);
   }
}
