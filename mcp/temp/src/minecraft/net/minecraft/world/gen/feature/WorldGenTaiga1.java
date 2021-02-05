package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenTaiga1 extends WorldGenAbstractTree {

   private static final String __OBFID = "CL_00000427";


   public WorldGenTaiga1() {
      super(false);
   }

   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      int var4 = p_180709_2_.nextInt(5) + 7;
      int var5 = var4 - p_180709_2_.nextInt(2) - 3;
      int var6 = var4 - var5;
      int var7 = 1 + p_180709_2_.nextInt(var6 + 1);
      boolean var8 = true;
      if(p_180709_3_.func_177956_o() >= 1 && p_180709_3_.func_177956_o() + var4 + 1 <= 256) {
         int var11;
         int var12;
         int var18;
         for(int var9 = p_180709_3_.func_177956_o(); var9 <= p_180709_3_.func_177956_o() + 1 + var4 && var8; ++var9) {
            boolean var10 = true;
            if(var9 - p_180709_3_.func_177956_o() < var5) {
               var18 = 0;
            } else {
               var18 = var7;
            }

            for(var11 = p_180709_3_.func_177958_n() - var18; var11 <= p_180709_3_.func_177958_n() + var18 && var8; ++var11) {
               for(var12 = p_180709_3_.func_177952_p() - var18; var12 <= p_180709_3_.func_177952_p() + var18 && var8; ++var12) {
                  if(var9 >= 0 && var9 < 256) {
                     if(!this.func_150523_a(p_180709_1_.func_180495_p(new BlockPos(var11, var9, var12)).func_177230_c())) {
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
            Block var17 = p_180709_1_.func_180495_p(p_180709_3_.func_177977_b()).func_177230_c();
            if((var17 == Blocks.field_150349_c || var17 == Blocks.field_150346_d) && p_180709_3_.func_177956_o() < 256 - var4 - 1) {
               this.func_175921_a(p_180709_1_, p_180709_3_.func_177977_b());
               var18 = 0;

               for(var11 = p_180709_3_.func_177956_o() + var4; var11 >= p_180709_3_.func_177956_o() + var5; --var11) {
                  for(var12 = p_180709_3_.func_177958_n() - var18; var12 <= p_180709_3_.func_177958_n() + var18; ++var12) {
                     int var13 = var12 - p_180709_3_.func_177958_n();

                     for(int var14 = p_180709_3_.func_177952_p() - var18; var14 <= p_180709_3_.func_177952_p() + var18; ++var14) {
                        int var15 = var14 - p_180709_3_.func_177952_p();
                        if(Math.abs(var13) != var18 || Math.abs(var15) != var18 || var18 <= 0) {
                           BlockPos var16 = new BlockPos(var12, var11, var14);
                           if(!p_180709_1_.func_180495_p(var16).func_177230_c().func_149730_j()) {
                              this.func_175905_a(p_180709_1_, var16, Blocks.field_150362_t, BlockPlanks.EnumType.SPRUCE.func_176839_a());
                           }
                        }
                     }
                  }

                  if(var18 >= 1 && var11 == p_180709_3_.func_177956_o() + var5 + 1) {
                     --var18;
                  } else if(var18 < var7) {
                     ++var18;
                  }
               }

               for(var11 = 0; var11 < var4 - 1; ++var11) {
                  Block var19 = p_180709_1_.func_180495_p(p_180709_3_.func_177981_b(var11)).func_177230_c();
                  if(var19.func_149688_o() == Material.field_151579_a || var19.func_149688_o() == Material.field_151584_j) {
                     this.func_175905_a(p_180709_1_, p_180709_3_.func_177981_b(var11), Blocks.field_150364_r, BlockPlanks.EnumType.SPRUCE.func_176839_a());
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
