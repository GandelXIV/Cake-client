package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenTaiga2 extends WorldGenAbstractTree {

   private static final String __OBFID = "CL_00000435";


   public WorldGenTaiga2(boolean p_i2025_1_) {
      super(p_i2025_1_);
   }

   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      int var4 = p_180709_2_.nextInt(4) + 6;
      int var5 = 1 + p_180709_2_.nextInt(2);
      int var6 = var4 - var5;
      int var7 = 2 + p_180709_2_.nextInt(2);
      boolean var8 = true;
      if(p_180709_3_.func_177956_o() >= 1 && p_180709_3_.func_177956_o() + var4 + 1 <= 256) {
         int var11;
         int var21;
         for(int var9 = p_180709_3_.func_177956_o(); var9 <= p_180709_3_.func_177956_o() + 1 + var4 && var8; ++var9) {
            boolean var10 = true;
            if(var9 - p_180709_3_.func_177956_o() < var5) {
               var21 = 0;
            } else {
               var21 = var7;
            }

            for(var11 = p_180709_3_.func_177958_n() - var21; var11 <= p_180709_3_.func_177958_n() + var21 && var8; ++var11) {
               for(int var12 = p_180709_3_.func_177952_p() - var21; var12 <= p_180709_3_.func_177952_p() + var21 && var8; ++var12) {
                  if(var9 >= 0 && var9 < 256) {
                     Block var13 = p_180709_1_.func_180495_p(new BlockPos(var11, var9, var12)).func_177230_c();
                     if(var13.func_149688_o() != Material.field_151579_a && var13.func_149688_o() != Material.field_151584_j) {
                        var8 = false;
                     }
                  } else {
                     var8 = false;
                  }
               }
            }
         }

         if(!var8) {
            return false;
         } else {
            Block var20 = p_180709_1_.func_180495_p(p_180709_3_.func_177977_b()).func_177230_c();
            if((var20 == Blocks.field_150349_c || var20 == Blocks.field_150346_d || var20 == Blocks.field_150458_ak) && p_180709_3_.func_177956_o() < 256 - var4 - 1) {
               this.func_175921_a(p_180709_1_, p_180709_3_.func_177977_b());
               var21 = p_180709_2_.nextInt(2);
               var11 = 1;
               byte var22 = 0;

               int var14;
               int var23;
               for(var23 = 0; var23 <= var6; ++var23) {
                  var14 = p_180709_3_.func_177956_o() + var4 - var23;

                  for(int var15 = p_180709_3_.func_177958_n() - var21; var15 <= p_180709_3_.func_177958_n() + var21; ++var15) {
                     int var16 = var15 - p_180709_3_.func_177958_n();

                     for(int var17 = p_180709_3_.func_177952_p() - var21; var17 <= p_180709_3_.func_177952_p() + var21; ++var17) {
                        int var18 = var17 - p_180709_3_.func_177952_p();
                        if(Math.abs(var16) != var21 || Math.abs(var18) != var21 || var21 <= 0) {
                           BlockPos var19 = new BlockPos(var15, var14, var17);
                           if(!p_180709_1_.func_180495_p(var19).func_177230_c().func_149730_j()) {
                              this.func_175905_a(p_180709_1_, var19, Blocks.field_150362_t, BlockPlanks.EnumType.SPRUCE.func_176839_a());
                           }
                        }
                     }
                  }

                  if(var21 >= var11) {
                     var21 = var22;
                     var22 = 1;
                     ++var11;
                     if(var11 > var7) {
                        var11 = var7;
                     }
                  } else {
                     ++var21;
                  }
               }

               var23 = p_180709_2_.nextInt(3);

               for(var14 = 0; var14 < var4 - var23; ++var14) {
                  Block var24 = p_180709_1_.func_180495_p(p_180709_3_.func_177981_b(var14)).func_177230_c();
                  if(var24.func_149688_o() == Material.field_151579_a || var24.func_149688_o() == Material.field_151584_j) {
                     this.func_175905_a(p_180709_1_, p_180709_3_.func_177981_b(var14), Blocks.field_150364_r, BlockPlanks.EnumType.SPRUCE.func_176839_a());
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
