package net.minecraft.client.renderer.tileentity;

import java.util.List;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileEntityBeaconRenderer extends TileEntitySpecialRenderer {

   private static final ResourceLocation field_147523_b = new ResourceLocation("textures/entity/beacon_beam.png");
   private static final String __OBFID = "CL_00000962";


   public void func_180536_a(TileEntityBeacon p_180536_1_, double p_180536_2_, double p_180536_4_, double p_180536_6_, float p_180536_8_, int p_180536_9_) {
      float var10 = p_180536_1_.func_146002_i();
      GlStateManager.func_179092_a(516, 0.1F);
      if(var10 > 0.0F) {
         Tessellator var11 = Tessellator.func_178181_a();
         WorldRenderer var12 = var11.func_178180_c();
         List var13 = p_180536_1_.func_174907_n();
         int var14 = 0;

         for(int var15 = 0; var15 < var13.size(); ++var15) {
            TileEntityBeacon.BeamSegment var16 = (TileEntityBeacon.BeamSegment)var13.get(var15);
            int var17 = var14 + var16.func_177264_c();
            this.func_147499_a(field_147523_b);
            GL11.glTexParameterf(3553, 10242, 10497.0F);
            GL11.glTexParameterf(3553, 10243, 10497.0F);
            GlStateManager.func_179140_f();
            GlStateManager.func_179129_p();
            GlStateManager.func_179084_k();
            GlStateManager.func_179132_a(true);
            GlStateManager.func_179120_a(770, 1, 1, 0);
            float var18 = (float)p_180536_1_.func_145831_w().func_82737_E() + p_180536_8_;
            float var19 = -var18 * 0.2F - (float)MathHelper.func_76141_d(-var18 * 0.1F);
            double var20 = (double)var18 * 0.025D * -1.5D;
            var12.func_178970_b();
            double var22 = 0.2D;
            double var24 = 0.5D + Math.cos(var20 + 2.356194490192345D) * var22;
            double var26 = 0.5D + Math.sin(var20 + 2.356194490192345D) * var22;
            double var28 = 0.5D + Math.cos(var20 + 0.7853981633974483D) * var22;
            double var30 = 0.5D + Math.sin(var20 + 0.7853981633974483D) * var22;
            double var32 = 0.5D + Math.cos(var20 + 3.9269908169872414D) * var22;
            double var34 = 0.5D + Math.sin(var20 + 3.9269908169872414D) * var22;
            double var36 = 0.5D + Math.cos(var20 + 5.497787143782138D) * var22;
            double var38 = 0.5D + Math.sin(var20 + 5.497787143782138D) * var22;
            double var40 = 0.0D;
            double var42 = 1.0D;
            double var44 = (double)(-1.0F + var19);
            double var46 = (double)((float)var16.func_177264_c() * var10) * (0.5D / var22) + var44;
            var12.func_178960_a(var16.func_177263_b()[0], var16.func_177263_b()[1], var16.func_177263_b()[2], 0.125F);
            var12.func_178985_a(p_180536_2_ + var24, p_180536_4_ + (double)var17, p_180536_6_ + var26, var42, var46);
            var12.func_178985_a(p_180536_2_ + var24, p_180536_4_ + (double)var14, p_180536_6_ + var26, var42, var44);
            var12.func_178985_a(p_180536_2_ + var28, p_180536_4_ + (double)var14, p_180536_6_ + var30, var40, var44);
            var12.func_178985_a(p_180536_2_ + var28, p_180536_4_ + (double)var17, p_180536_6_ + var30, var40, var46);
            var12.func_178985_a(p_180536_2_ + var36, p_180536_4_ + (double)var17, p_180536_6_ + var38, var42, var46);
            var12.func_178985_a(p_180536_2_ + var36, p_180536_4_ + (double)var14, p_180536_6_ + var38, var42, var44);
            var12.func_178985_a(p_180536_2_ + var32, p_180536_4_ + (double)var14, p_180536_6_ + var34, var40, var44);
            var12.func_178985_a(p_180536_2_ + var32, p_180536_4_ + (double)var17, p_180536_6_ + var34, var40, var46);
            var12.func_178985_a(p_180536_2_ + var28, p_180536_4_ + (double)var17, p_180536_6_ + var30, var42, var46);
            var12.func_178985_a(p_180536_2_ + var28, p_180536_4_ + (double)var14, p_180536_6_ + var30, var42, var44);
            var12.func_178985_a(p_180536_2_ + var36, p_180536_4_ + (double)var14, p_180536_6_ + var38, var40, var44);
            var12.func_178985_a(p_180536_2_ + var36, p_180536_4_ + (double)var17, p_180536_6_ + var38, var40, var46);
            var12.func_178985_a(p_180536_2_ + var32, p_180536_4_ + (double)var17, p_180536_6_ + var34, var42, var46);
            var12.func_178985_a(p_180536_2_ + var32, p_180536_4_ + (double)var14, p_180536_6_ + var34, var42, var44);
            var12.func_178985_a(p_180536_2_ + var24, p_180536_4_ + (double)var14, p_180536_6_ + var26, var40, var44);
            var12.func_178985_a(p_180536_2_ + var24, p_180536_4_ + (double)var17, p_180536_6_ + var26, var40, var46);
            var11.func_78381_a();
            GlStateManager.func_179147_l();
            GlStateManager.func_179120_a(770, 771, 1, 0);
            GlStateManager.func_179132_a(false);
            var12.func_178970_b();
            var12.func_178960_a(var16.func_177263_b()[0], var16.func_177263_b()[1], var16.func_177263_b()[2], 0.125F);
            var20 = 0.2D;
            var22 = 0.2D;
            var24 = 0.8D;
            var26 = 0.2D;
            var28 = 0.2D;
            var30 = 0.8D;
            var32 = 0.8D;
            var34 = 0.8D;
            var36 = 0.0D;
            var38 = 1.0D;
            var40 = (double)(-1.0F + var19);
            var42 = (double)((float)var16.func_177264_c() * var10) + var40;
            var12.func_178985_a(p_180536_2_ + var20, p_180536_4_ + (double)var17, p_180536_6_ + var22, var38, var42);
            var12.func_178985_a(p_180536_2_ + var20, p_180536_4_ + (double)var14, p_180536_6_ + var22, var38, var40);
            var12.func_178985_a(p_180536_2_ + var24, p_180536_4_ + (double)var14, p_180536_6_ + var26, var36, var40);
            var12.func_178985_a(p_180536_2_ + var24, p_180536_4_ + (double)var17, p_180536_6_ + var26, var36, var42);
            var12.func_178985_a(p_180536_2_ + var32, p_180536_4_ + (double)var17, p_180536_6_ + var34, var38, var42);
            var12.func_178985_a(p_180536_2_ + var32, p_180536_4_ + (double)var14, p_180536_6_ + var34, var38, var40);
            var12.func_178985_a(p_180536_2_ + var28, p_180536_4_ + (double)var14, p_180536_6_ + var30, var36, var40);
            var12.func_178985_a(p_180536_2_ + var28, p_180536_4_ + (double)var17, p_180536_6_ + var30, var36, var42);
            var12.func_178985_a(p_180536_2_ + var24, p_180536_4_ + (double)var17, p_180536_6_ + var26, var38, var42);
            var12.func_178985_a(p_180536_2_ + var24, p_180536_4_ + (double)var14, p_180536_6_ + var26, var38, var40);
            var12.func_178985_a(p_180536_2_ + var32, p_180536_4_ + (double)var14, p_180536_6_ + var34, var36, var40);
            var12.func_178985_a(p_180536_2_ + var32, p_180536_4_ + (double)var17, p_180536_6_ + var34, var36, var42);
            var12.func_178985_a(p_180536_2_ + var28, p_180536_4_ + (double)var17, p_180536_6_ + var30, var38, var42);
            var12.func_178985_a(p_180536_2_ + var28, p_180536_4_ + (double)var14, p_180536_6_ + var30, var38, var40);
            var12.func_178985_a(p_180536_2_ + var20, p_180536_4_ + (double)var14, p_180536_6_ + var22, var36, var40);
            var12.func_178985_a(p_180536_2_ + var20, p_180536_4_ + (double)var17, p_180536_6_ + var22, var36, var42);
            var11.func_78381_a();
            GlStateManager.func_179145_e();
            GlStateManager.func_179098_w();
            GlStateManager.func_179132_a(true);
            var14 = var17;
         }
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_180535_a(TileEntity p_180535_1_, double p_180535_2_, double p_180535_4_, double p_180535_6_, float p_180535_8_, int p_180535_9_) {
      this.func_180536_a((TileEntityBeacon)p_180535_1_, p_180535_2_, p_180535_4_, p_180535_6_, p_180535_8_, p_180535_9_);
   }

}
