package net.minecraft.client.renderer;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockFluidRenderer {

   private TextureAtlasSprite[] field_178272_a = new TextureAtlasSprite[2];
   private TextureAtlasSprite[] field_178271_b = new TextureAtlasSprite[2];
   private static final String __OBFID = "CL_00002519";


   public BlockFluidRenderer() {
      this.func_178268_a();
   }

   protected void func_178268_a() {
      TextureMap var1 = Minecraft.func_71410_x().func_147117_R();
      this.field_178272_a[0] = var1.func_110572_b("minecraft:blocks/lava_still");
      this.field_178272_a[1] = var1.func_110572_b("minecraft:blocks/lava_flow");
      this.field_178271_b[0] = var1.func_110572_b("minecraft:blocks/water_still");
      this.field_178271_b[1] = var1.func_110572_b("minecraft:blocks/water_flow");
   }

   public boolean func_178270_a(IBlockAccess p_178270_1_, IBlockState p_178270_2_, BlockPos p_178270_3_, WorldRenderer p_178270_4_) {
      BlockLiquid var5 = (BlockLiquid)p_178270_2_.func_177230_c();
      var5.func_180654_a(p_178270_1_, p_178270_3_);
      TextureAtlasSprite[] var6 = var5.func_149688_o() == Material.field_151587_i?this.field_178272_a:this.field_178271_b;
      int var7 = var5.func_176202_d(p_178270_1_, p_178270_3_);
      float var8 = (float)(var7 >> 16 & 255) / 255.0F;
      float var9 = (float)(var7 >> 8 & 255) / 255.0F;
      float var10 = (float)(var7 & 255) / 255.0F;
      boolean var11 = var5.func_176225_a(p_178270_1_, p_178270_3_.func_177984_a(), EnumFacing.UP);
      boolean var12 = var5.func_176225_a(p_178270_1_, p_178270_3_.func_177977_b(), EnumFacing.DOWN);
      boolean[] var13 = new boolean[]{var5.func_176225_a(p_178270_1_, p_178270_3_.func_177978_c(), EnumFacing.NORTH), var5.func_176225_a(p_178270_1_, p_178270_3_.func_177968_d(), EnumFacing.SOUTH), var5.func_176225_a(p_178270_1_, p_178270_3_.func_177976_e(), EnumFacing.WEST), var5.func_176225_a(p_178270_1_, p_178270_3_.func_177974_f(), EnumFacing.EAST)};
      if(!var11 && !var12 && !var13[0] && !var13[1] && !var13[2] && !var13[3]) {
         return false;
      } else {
         boolean var14 = false;
         float var15 = 0.5F;
         float var16 = 1.0F;
         float var17 = 0.8F;
         float var18 = 0.6F;
         Material var19 = var5.func_149688_o();
         float var20 = this.func_178269_a(p_178270_1_, p_178270_3_, var19);
         float var21 = this.func_178269_a(p_178270_1_, p_178270_3_.func_177968_d(), var19);
         float var22 = this.func_178269_a(p_178270_1_, p_178270_3_.func_177974_f().func_177968_d(), var19);
         float var23 = this.func_178269_a(p_178270_1_, p_178270_3_.func_177974_f(), var19);
         double var24 = (double)p_178270_3_.func_177958_n();
         double var26 = (double)p_178270_3_.func_177956_o();
         double var28 = (double)p_178270_3_.func_177952_p();
         float var30 = 0.001F;
         TextureAtlasSprite var31;
         float var32;
         float var33;
         float var34;
         float var35;
         float var36;
         float var37;
         if(var11) {
            var14 = true;
            var31 = var6[0];
            var32 = (float)BlockLiquid.func_180689_a(p_178270_1_, p_178270_3_, var19);
            if(var32 > -999.0F) {
               var31 = var6[1];
            }

            var20 -= var30;
            var21 -= var30;
            var22 -= var30;
            var23 -= var30;
            float var38;
            float var39;
            float var40;
            if(var32 < -999.0F) {
               var33 = var31.func_94214_a(0.0D);
               var37 = var31.func_94207_b(0.0D);
               var34 = var33;
               var38 = var31.func_94207_b(16.0D);
               var35 = var31.func_94214_a(16.0D);
               var39 = var38;
               var36 = var35;
               var40 = var37;
            } else {
               float var41 = MathHelper.func_76126_a(var32) * 0.25F;
               float var42 = MathHelper.func_76134_b(var32) * 0.25F;
               float var43 = 8.0F;
               var33 = var31.func_94214_a((double)(8.0F + (-var42 - var41) * 16.0F));
               var37 = var31.func_94207_b((double)(8.0F + (-var42 + var41) * 16.0F));
               var34 = var31.func_94214_a((double)(8.0F + (-var42 + var41) * 16.0F));
               var38 = var31.func_94207_b((double)(8.0F + (var42 + var41) * 16.0F));
               var35 = var31.func_94214_a((double)(8.0F + (var42 + var41) * 16.0F));
               var39 = var31.func_94207_b((double)(8.0F + (var42 - var41) * 16.0F));
               var36 = var31.func_94214_a((double)(8.0F + (var42 - var41) * 16.0F));
               var40 = var31.func_94207_b((double)(8.0F + (-var42 - var41) * 16.0F));
            }

            p_178270_4_.func_178963_b(var5.func_176207_c(p_178270_1_, p_178270_3_));
            p_178270_4_.func_178986_b(var16 * var8, var16 * var9, var16 * var10);
            p_178270_4_.func_178985_a(var24 + 0.0D, var26 + (double)var20, var28 + 0.0D, (double)var33, (double)var37);
            p_178270_4_.func_178985_a(var24 + 0.0D, var26 + (double)var21, var28 + 1.0D, (double)var34, (double)var38);
            p_178270_4_.func_178985_a(var24 + 1.0D, var26 + (double)var22, var28 + 1.0D, (double)var35, (double)var39);
            p_178270_4_.func_178985_a(var24 + 1.0D, var26 + (double)var23, var28 + 0.0D, (double)var36, (double)var40);
            if(var5.func_176364_g(p_178270_1_, p_178270_3_.func_177984_a())) {
               p_178270_4_.func_178985_a(var24 + 0.0D, var26 + (double)var20, var28 + 0.0D, (double)var33, (double)var37);
               p_178270_4_.func_178985_a(var24 + 1.0D, var26 + (double)var23, var28 + 0.0D, (double)var36, (double)var40);
               p_178270_4_.func_178985_a(var24 + 1.0D, var26 + (double)var22, var28 + 1.0D, (double)var35, (double)var39);
               p_178270_4_.func_178985_a(var24 + 0.0D, var26 + (double)var21, var28 + 1.0D, (double)var34, (double)var38);
            }
         }

         if(var12) {
            p_178270_4_.func_178963_b(var5.func_176207_c(p_178270_1_, p_178270_3_.func_177977_b()));
            p_178270_4_.func_178986_b(var15, var15, var15);
            var32 = var6[0].func_94209_e();
            var33 = var6[0].func_94212_f();
            var34 = var6[0].func_94206_g();
            var35 = var6[0].func_94210_h();
            p_178270_4_.func_178985_a(var24, var26, var28 + 1.0D, (double)var32, (double)var35);
            p_178270_4_.func_178985_a(var24, var26, var28, (double)var32, (double)var34);
            p_178270_4_.func_178985_a(var24 + 1.0D, var26, var28, (double)var33, (double)var34);
            p_178270_4_.func_178985_a(var24 + 1.0D, var26, var28 + 1.0D, (double)var33, (double)var35);
            var14 = true;
         }

         for(int var52 = 0; var52 < 4; ++var52) {
            int var53 = 0;
            int var54 = 0;
            if(var52 == 0) {
               --var54;
            }

            if(var52 == 1) {
               ++var54;
            }

            if(var52 == 2) {
               --var53;
            }

            if(var52 == 3) {
               ++var53;
            }

            BlockPos var55 = p_178270_3_.func_177982_a(var53, 0, var54);
            var31 = var6[1];
            if(var13[var52]) {
               double var44;
               double var56;
               double var57;
               double var58;
               if(var52 == 0) {
                  var36 = var20;
                  var37 = var23;
                  var56 = var24;
                  var58 = var24 + 1.0D;
                  var57 = var28 + (double)var30;
                  var44 = var28 + (double)var30;
               } else if(var52 == 1) {
                  var36 = var22;
                  var37 = var21;
                  var56 = var24 + 1.0D;
                  var58 = var24;
                  var57 = var28 + 1.0D - (double)var30;
                  var44 = var28 + 1.0D - (double)var30;
               } else if(var52 == 2) {
                  var36 = var21;
                  var37 = var20;
                  var56 = var24 + (double)var30;
                  var58 = var24 + (double)var30;
                  var57 = var28 + 1.0D;
                  var44 = var28;
               } else {
                  var36 = var23;
                  var37 = var22;
                  var56 = var24 + 1.0D - (double)var30;
                  var58 = var24 + 1.0D - (double)var30;
                  var57 = var28;
                  var44 = var28 + 1.0D;
               }

               var14 = true;
               float var46 = var31.func_94214_a(0.0D);
               float var47 = var31.func_94214_a(8.0D);
               float var48 = var31.func_94207_b((double)((1.0F - var36) * 16.0F * 0.5F));
               float var49 = var31.func_94207_b((double)((1.0F - var37) * 16.0F * 0.5F));
               float var50 = var31.func_94207_b(8.0D);
               p_178270_4_.func_178963_b(var5.func_176207_c(p_178270_1_, var55));
               float var51 = 1.0F;
               var51 *= var52 < 2?var17:var18;
               p_178270_4_.func_178986_b(var16 * var51 * var8, var16 * var51 * var9, var16 * var51 * var10);
               p_178270_4_.func_178985_a(var56, var26 + (double)var36, var57, (double)var46, (double)var48);
               p_178270_4_.func_178985_a(var58, var26 + (double)var37, var44, (double)var47, (double)var49);
               p_178270_4_.func_178985_a(var58, var26 + 0.0D, var44, (double)var47, (double)var50);
               p_178270_4_.func_178985_a(var56, var26 + 0.0D, var57, (double)var46, (double)var50);
               p_178270_4_.func_178985_a(var56, var26 + 0.0D, var57, (double)var46, (double)var50);
               p_178270_4_.func_178985_a(var58, var26 + 0.0D, var44, (double)var47, (double)var50);
               p_178270_4_.func_178985_a(var58, var26 + (double)var37, var44, (double)var47, (double)var49);
               p_178270_4_.func_178985_a(var56, var26 + (double)var36, var57, (double)var46, (double)var48);
            }
         }

         return var14;
      }
   }

   private float func_178269_a(IBlockAccess p_178269_1_, BlockPos p_178269_2_, Material p_178269_3_) {
      int var4 = 0;
      float var5 = 0.0F;

      for(int var6 = 0; var6 < 4; ++var6) {
         BlockPos var7 = p_178269_2_.func_177982_a(-(var6 & 1), 0, -(var6 >> 1 & 1));
         if(p_178269_1_.func_180495_p(var7.func_177984_a()).func_177230_c().func_149688_o() == p_178269_3_) {
            return 1.0F;
         }

         IBlockState var8 = p_178269_1_.func_180495_p(var7);
         Material var9 = var8.func_177230_c().func_149688_o();
         if(var9 == p_178269_3_) {
            int var10 = ((Integer)var8.func_177229_b(BlockLiquid.field_176367_b)).intValue();
            if(var10 >= 8 || var10 == 0) {
               var5 += BlockLiquid.func_149801_b(var10) * 10.0F;
               var4 += 10;
            }

            var5 += BlockLiquid.func_149801_b(var10);
            ++var4;
         } else if(!var9.func_76220_a()) {
            ++var5;
            ++var4;
         }
      }

      return 1.0F - var5 / (float)var4;
   }
}
