package net.minecraft.client.renderer.entity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderMinecart;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;

public class RenderTntMinecart extends RenderMinecart {

   private static final String __OBFID = "CL_00001029";


   public RenderTntMinecart(RenderManager p_i46135_1_) {
      super(p_i46135_1_);
   }

   protected void func_180561_a(EntityMinecartTNT p_180561_1_, float p_180561_2_, IBlockState p_180561_3_) {
      int var4 = p_180561_1_.func_94104_d();
      if(var4 > -1 && (float)var4 - p_180561_2_ + 1.0F < 10.0F) {
         float var5 = 1.0F - ((float)var4 - p_180561_2_ + 1.0F) / 10.0F;
         var5 = MathHelper.func_76131_a(var5, 0.0F, 1.0F);
         var5 *= var5;
         var5 *= var5;
         float var6 = 1.0F + var5 * 0.3F;
         GlStateManager.func_179152_a(var6, var6, var6);
      }

      super.func_180560_a(p_180561_1_, p_180561_2_, p_180561_3_);
      if(var4 > -1 && var4 / 5 % 2 == 0) {
         BlockRendererDispatcher var7 = Minecraft.func_71410_x().func_175602_ab();
         GlStateManager.func_179090_x();
         GlStateManager.func_179140_f();
         GlStateManager.func_179147_l();
         GlStateManager.func_179112_b(770, 772);
         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, (1.0F - ((float)var4 - p_180561_2_ + 1.0F) / 100.0F) * 0.8F);
         GlStateManager.func_179094_E();
         var7.func_175016_a(Blocks.field_150335_W.func_176223_P(), 1.0F);
         GlStateManager.func_179121_F();
         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.func_179084_k();
         GlStateManager.func_179145_e();
         GlStateManager.func_179098_w();
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_180560_a(EntityMinecart p_180560_1_, float p_180560_2_, IBlockState p_180560_3_) {
      this.func_180561_a((EntityMinecartTNT)p_180560_1_, p_180560_2_, p_180560_3_);
   }
}
