package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenForest extends WorldGenAbstractTree {

   private boolean field_150531_a;
   private static final String __OBFID = "CL_00000401";


   public WorldGenForest(boolean p_i45449_1_, boolean p_i45449_2_) {
      super(p_i45449_1_);
      this.field_150531_a = p_i45449_2_;
   }

   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      int var4 = p_180709_2_.nextInt(3) + 5;
      if(this.field_150531_a) {
         var4 += p_180709_2_.nextInt(7);
      }

      boolean var5 = true;
      if(p_180709_3_.func_177956_o() >= 1 && p_180709_3_.func_177956_o() + var4 + 1 <= 256) {
         int var8;
         int var9;
         for(int var6 = p_180709_3_.func_177956_o(); var6 <= p_180709_3_.func_177956_o() + 1 + var4; ++var6) {
            byte var7 = 1;
            if(var6 == p_180709_3_.func_177956_o()) {
               var7 = 0;
            }

            if(var6 >= p_180709_3_.func_177956_o() + 1 + var4 - 2) {
               var7 = 2;
            }

            for(var8 = p_180709_3_.func_177958_n() - var7; var8 <= p_180709_3_.func_177958_n() + var7 && var5; ++var8) {
               for(var9 = p_180709_3_.func_177952_p() - var7; var9 <= p_180709_3_.func_177952_p() + var7 && var5; ++var9) {
                  if(var6 >= 0 && var6 < 256) {
                     if(!this.func_150523_a(p_180709_1_.func_180495_p(new BlockPos(var8, var6, var9)).func_177230_c())) {
                        var5 = false;
                     }
                  } else {
                     var5 = false;
                  }
               }
            }
         }

         if(!var5) {
            return false;
         } else {
            Block var16 = p_180709_1_.func_180495_p(p_180709_3_.func_177977_b()).func_177230_c();
            if((var16 == Blocks.field_150349_c || var16 == Blocks.field_150346_d || var16 == Blocks.field_150458_ak) && p_180709_3_.func_177956_o() < 256 - var4 - 1) {
               this.func_175921_a(p_180709_1_, p_180709_3_.func_177977_b());

               int var17;
               for(var17 = p_180709_3_.func_177956_o() - 3 + var4; var17 <= p_180709_3_.func_177956_o() + var4; ++var17) {
                  var8 = var17 - (p_180709_3_.func_177956_o() + var4);
                  var9 = 1 - var8 / 2;

                  for(int var10 = p_180709_3_.func_177958_n() - var9; var10 <= p_180709_3_.func_177958_n() + var9; ++var10) {
                     int var11 = var10 - p_180709_3_.func_177958_n();

                     for(int var12 = p_180709_3_.func_177952_p() - var9; var12 <= p_180709_3_.func_177952_p() + var9; ++var12) {
                        int var13 = var12 - p_180709_3_.func_177952_p();
                        if(Math.abs(var11) != var9 || Math.abs(var13) != var9 || p_180709_2_.nextInt(2) != 0 && var8 != 0) {
                           BlockPos var14 = new BlockPos(var10, var17, var12);
                           Block var15 = p_180709_1_.func_180495_p(var14).func_177230_c();
                           if(var15.func_149688_o() == Material.field_151579_a || var15.func_149688_o() == Material.field_151584_j) {
                              this.func_175905_a(p_180709_1_, var14, Blocks.field_150362_t, BlockPlanks.EnumType.BIRCH.func_176839_a());
                           }
                        }
                     }
                  }
               }

               for(var17 = 0; var17 < var4; ++var17) {
                  Block var18 = p_180709_1_.func_180495_p(p_180709_3_.func_177981_b(var17)).func_177230_c();
                  if(var18.func_149688_o() == Material.field_151579_a || var18.func_149688_o() == Material.field_151584_j) {
                     this.func_175905_a(p_180709_1_, p_180709_3_.func_177981_b(var17), Blocks.field_150364_r, BlockPlanks.EnumType.BIRCH.func_176839_a());
                  }
               }

               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }
}
