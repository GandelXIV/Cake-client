package net.minecraft.client.renderer.entity;

import java.util.Random;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.ResourceLocation;

public class RenderLightningBolt extends Render {

   private static final String __OBFID = "CL_00001011";


   public RenderLightningBolt(RenderManager p_i46157_1_) {
      super(p_i46157_1_);
   }

   public void func_76986_a(EntityLightningBolt p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      Tessellator var10 = Tessellator.func_178181_a();
      WorldRenderer var11 = var10.func_178180_c();
      GlStateManager.func_179090_x();
      GlStateManager.func_179140_f();
      GlStateManager.func_179147_l();
      GlStateManager.func_179112_b(770, 1);
      double[] var12 = new double[8];
      double[] var13 = new double[8];
      double var14 = 0.0D;
      double var16 = 0.0D;
      Random var18 = new Random(p_76986_1_.field_70264_a);

      for(int var19 = 7; var19 >= 0; --var19) {
         var12[var19] = var14;
         var13[var19] = var16;
         var14 += (double)(var18.nextInt(11) - 5);
         var16 += (double)(var18.nextInt(11) - 5);
      }

      for(int var46 = 0; var46 < 4; ++var46) {
         Random var47 = new Random(p_76986_1_.field_70264_a);

         for(int var20 = 0; var20 < 3; ++var20) {
            int var21 = 7;
            int var22 = 0;
            if(var20 > 0) {
               var21 = 7 - var20;
            }

            if(var20 > 0) {
               var22 = var21 - 2;
            }

            double var23 = var12[var21] - var14;
            double var25 = var13[var21] - var16;

            for(int var27 = var21; var27 >= var22; --var27) {
               double var28 = var23;
               double var30 = var25;
               if(var20 == 0) {
                  var23 += (double)(var47.nextInt(11) - 5);
                  var25 += (double)(var47.nextInt(11) - 5);
               } else {
                  var23 += (double)(var47.nextInt(31) - 15);
                  var25 += (double)(var47.nextInt(31) - 15);
               }

               var11.func_178964_a(5);
               float var32 = 0.5F;
               var11.func_178960_a(0.9F * var32, 0.9F * var32, 1.0F * var32, 0.3F);
               double var33 = 0.1D + (double)var46 * 0.2D;
               if(var20 == 0) {
                  var33 *= (double)var27 * 0.1D + 1.0D;
               }

               double var35 = 0.1D + (double)var46 * 0.2D;
               if(var20 == 0) {
                  var35 *= (double)(var27 - 1) * 0.1D + 1.0D;
               }

               for(int var37 = 0; var37 < 5; ++var37) {
                  double var38 = p_76986_2_ + 0.5D - var33;
                  double var40 = p_76986_6_ + 0.5D - var33;
                  if(var37 == 1 || var37 == 2) {
                     var38 += var33 * 2.0D;
                  }

                  if(var37 == 2 || var37 == 3) {
                     var40 += var33 * 2.0D;
                  }

                  double var42 = p_76986_2_ + 0.5D - var35;
                  double var44 = p_76986_6_ + 0.5D - var35;
                  if(var37 == 1 || var37 == 2) {
                     var42 += var35 * 2.0D;
                  }

                  if(var37 == 2 || var37 == 3) {
                     var44 += var35 * 2.0D;
                  }

                  var11.func_178984_b(var42 + var23, p_76986_4_ + (double)(var27 * 16), var44 + var25);
                  var11.func_178984_b(var38 + var28, p_76986_4_ + (double)((var27 + 1) * 16), var40 + var30);
               }

               var10.func_78381_a();
            }
         }
      }

      GlStateManager.func_179084_k();
      GlStateManager.func_179145_e();
      GlStateManager.func_179098_w();
   }

   protected ResourceLocation func_110775_a(EntityLightningBolt p_110775_1_) {
      return null;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityLightningBolt)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityLightningBolt)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
