package net.minecraft.client.renderer.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class TileEntityPistonRenderer extends TileEntitySpecialRenderer {

   private final BlockRendererDispatcher field_178462_c = Minecraft.func_71410_x().func_175602_ab();
   private static final String __OBFID = "CL_00002469";


   public void func_178461_a(TileEntityPiston p_178461_1_, double p_178461_2_, double p_178461_4_, double p_178461_6_, float p_178461_8_, int p_178461_9_) {
      BlockPos var10 = p_178461_1_.func_174877_v();
      IBlockState var11 = p_178461_1_.func_174927_b();
      Block var12 = var11.func_177230_c();
      if(var12.func_149688_o() != Material.field_151579_a && p_178461_1_.func_145860_a(p_178461_8_) < 1.0F) {
         Tessellator var13 = Tessellator.func_178181_a();
         WorldRenderer var14 = var13.func_178180_c();
         this.func_147499_a(TextureMap.field_110575_b);
         RenderHelper.func_74518_a();
         GlStateManager.func_179112_b(770, 771);
         GlStateManager.func_179147_l();
         GlStateManager.func_179129_p();
         if(Minecraft.func_71379_u()) {
            GlStateManager.func_179103_j(7425);
         } else {
            GlStateManager.func_179103_j(7424);
         }

         var14.func_178970_b();
         var14.func_178967_a(DefaultVertexFormats.field_176600_a);
         var14.func_178969_c((double)((float)p_178461_2_ - (float)var10.func_177958_n() + p_178461_1_.func_174929_b(p_178461_8_)), (double)((float)p_178461_4_ - (float)var10.func_177956_o() + p_178461_1_.func_174928_c(p_178461_8_)), (double)((float)p_178461_6_ - (float)var10.func_177952_p() + p_178461_1_.func_174926_d(p_178461_8_)));
         var14.func_178986_b(1.0F, 1.0F, 1.0F);
         World var15 = this.func_178459_a();
         if(var12 == Blocks.field_150332_K && p_178461_1_.func_145860_a(p_178461_8_) < 0.5F) {
            var11 = var11.func_177226_a(BlockPistonExtension.field_176327_M, Boolean.valueOf(true));
            this.field_178462_c.func_175019_b().func_178267_a(var15, this.field_178462_c.func_175022_a(var11, var15, var10), var11, var10, var14, true);
         } else if(p_178461_1_.func_145867_d() && !p_178461_1_.func_145868_b()) {
            BlockPistonExtension.EnumPistonType var16 = var12 == Blocks.field_150320_F?BlockPistonExtension.EnumPistonType.STICKY:BlockPistonExtension.EnumPistonType.DEFAULT;
            IBlockState var17 = Blocks.field_150332_K.func_176223_P().func_177226_a(BlockPistonExtension.field_176325_b, var16).func_177226_a(BlockPistonExtension.field_176326_a, var11.func_177229_b(BlockPistonBase.field_176321_a));
            var17 = var17.func_177226_a(BlockPistonExtension.field_176327_M, Boolean.valueOf(p_178461_1_.func_145860_a(p_178461_8_) >= 0.5F));
            this.field_178462_c.func_175019_b().func_178267_a(var15, this.field_178462_c.func_175022_a(var17, var15, var10), var17, var10, var14, true);
            var14.func_178969_c((double)((float)p_178461_2_ - (float)var10.func_177958_n()), (double)((float)p_178461_4_ - (float)var10.func_177956_o()), (double)((float)p_178461_6_ - (float)var10.func_177952_p()));
            var11.func_177226_a(BlockPistonBase.field_176320_b, Boolean.valueOf(true));
            this.field_178462_c.func_175019_b().func_178267_a(var15, this.field_178462_c.func_175022_a(var11, var15, var10), var11, var10, var14, true);
         } else {
            this.field_178462_c.func_175019_b().func_178267_a(var15, this.field_178462_c.func_175022_a(var11, var15, var10), var11, var10, var14, false);
         }

         var14.func_178969_c(0.0D, 0.0D, 0.0D);
         var13.func_78381_a();
         RenderHelper.func_74519_b();
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_180535_a(TileEntity p_180535_1_, double p_180535_2_, double p_180535_4_, double p_180535_6_, float p_180535_8_, int p_180535_9_) {
      this.func_178461_a((TileEntityPiston)p_180535_1_, p_180535_2_, p_180535_4_, p_180535_6_, p_180535_8_, p_180535_9_);
   }
}
