package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;

public class WorldGenMegaPineTree extends WorldGenHugeTrees {

   private boolean field_150542_e;
   private static final String __OBFID = "CL_00000421";


   public WorldGenMegaPineTree(boolean p_i45457_1_, boolean p_i45457_2_) {
      super(p_i45457_1_, 13, 15, BlockPlanks.EnumType.SPRUCE.func_176839_a(), BlockPlanks.EnumType.SPRUCE.func_176839_a());
      this.field_150542_e = p_i45457_2_;
   }

   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      int var4 = this.func_150533_a(p_180709_2_);
      if(!this.func_175929_a(p_180709_1_, p_180709_2_, p_180709_3_, var4)) {
         return false;
      } else {
         this.func_150541_c(p_180709_1_, p_180709_3_.func_177958_n(), p_180709_3_.func_177952_p(), p_180709_3_.func_177956_o() + var4, 0, p_180709_2_);

         for(int var5 = 0; var5 < var4; ++var5) {
            Block var6 = p_180709_1_.func_180495_p(p_180709_3_.func_177981_b(var5)).func_177230_c();
            if(var6.func_149688_o() == Material.field_151579_a || var6.func_149688_o() == Material.field_151584_j) {
               this.func_175905_a(p_180709_1_, p_180709_3_.func_177981_b(var5), Blocks.field_150364_r, this.field_76520_b);
            }

            if(var5 < var4 - 1) {
               var6 = p_180709_1_.func_180495_p(p_180709_3_.func_177982_a(1, var5, 0)).func_177230_c();
               if(var6.func_149688_o() == Material.field_151579_a || var6.func_149688_o() == Material.field_151584_j) {
                  this.func_175905_a(p_180709_1_, p_180709_3_.func_177982_a(1, var5, 0), Blocks.field_150364_r, this.field_76520_b);
               }

               var6 = p_180709_1_.func_180495_p(p_180709_3_.func_177982_a(1, var5, 1)).func_177230_c();
               if(var6.func_149688_o() == Material.field_151579_a || var6.func_149688_o() == Material.field_151584_j) {
                  this.func_175905_a(p_180709_1_, p_180709_3_.func_177982_a(1, var5, 1), Blocks.field_150364_r, this.field_76520_b);
               }

               var6 = p_180709_1_.func_180495_p(p_180709_3_.func_177982_a(0, var5, 1)).func_177230_c();
               if(var6.func_149688_o() == Material.field_151579_a || var6.func_149688_o() == Material.field_151584_j) {
                  this.func_175905_a(p_180709_1_, p_180709_3_.func_177982_a(0, var5, 1), Blocks.field_150364_r, this.field_76520_b);
               }
            }
         }

         return true;
      }
   }

   private void func_150541_c(World p_150541_1_, int p_150541_2_, int p_150541_3_, int p_150541_4_, int p_150541_5_, Random p_150541_6_) {
      int var7 = p_150541_6_.nextInt(5) + (this.field_150542_e?this.field_76522_a:3);
      int var8 = 0;

      for(int var9 = p_150541_4_ - var7; var9 <= p_150541_4_; ++var9) {
         int var10 = p_150541_4_ - var9;
         int var11 = p_150541_5_ + MathHelper.func_76141_d((float)var10 / (float)var7 * 3.5F);
         this.func_175925_a(p_150541_1_, new BlockPos(p_150541_2_, var9, p_150541_3_), var11 + (var10 > 0 && var11 == var8 && (var9 & 1) == 0?1:0));
         var8 = var11;
      }

   }

   public void func_180711_a(World p_180711_1_, Random p_180711_2_, BlockPos p_180711_3_) {
      this.func_175933_b(p_180711_1_, p_180711_3_.func_177976_e().func_177978_c());
      this.func_175933_b(p_180711_1_, p_180711_3_.func_177965_g(2).func_177978_c());
      this.func_175933_b(p_180711_1_, p_180711_3_.func_177976_e().func_177970_e(2));
      this.func_175933_b(p_180711_1_, p_180711_3_.func_177965_g(2).func_177970_e(2));

      for(int var4 = 0; var4 < 5; ++var4) {
         int var5 = p_180711_2_.nextInt(64);
         int var6 = var5 % 8;
         int var7 = var5 / 8;
         if(var6 == 0 || var6 == 7 || var7 == 0 || var7 == 7) {
            this.func_175933_b(p_180711_1_, p_180711_3_.func_177982_a(-3 + var6, 0, -3 + var7));
         }
      }

   }

   private void func_175933_b(World p_175933_1_, BlockPos p_175933_2_) {
      for(int var3 = -2; var3 <= 2; ++var3) {
         for(int var4 = -2; var4 <= 2; ++var4) {
            if(Math.abs(var3) != 2 || Math.abs(var4) != 2) {
               this.func_175934_c(p_175933_1_, p_175933_2_.func_177982_a(var3, 0, var4));
            }
         }
      }

   }

   private void func_175934_c(World p_175934_1_, BlockPos p_175934_2_) {
      for(int var3 = 2; var3 >= -3; --var3) {
         BlockPos var4 = p_175934_2_.func_177981_b(var3);
         Block var5 = p_175934_1_.func_180495_p(var4).func_177230_c();
         if(var5 == Blocks.field_150349_c || var5 == Blocks.field_150346_d) {
            this.func_175905_a(p_175934_1_, var4, Blocks.field_150346_d, BlockDirt.DirtType.PODZOL.func_176925_a());
            break;
         }

         if(var5.func_149688_o() != Material.field_151579_a && var3 < 0) {
            break;
         }
      }

   }
}
