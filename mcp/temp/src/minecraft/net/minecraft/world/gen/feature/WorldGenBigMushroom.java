package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBigMushroom extends WorldGenerator {

   private int field_76523_a = -1;
   private static final String __OBFID = "CL_00000415";


   public WorldGenBigMushroom(int p_i2017_1_) {
      super(true);
      this.field_76523_a = p_i2017_1_;
   }

   public WorldGenBigMushroom() {
      super(false);
   }

   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      int var4 = p_180709_2_.nextInt(2);
      if(this.field_76523_a >= 0) {
         var4 = this.field_76523_a;
      }

      int var5 = p_180709_2_.nextInt(3) + 4;
      boolean var6 = true;
      if(p_180709_3_.func_177956_o() >= 1 && p_180709_3_.func_177956_o() + var5 + 1 < 256) {
         int var9;
         int var10;
         for(int var7 = p_180709_3_.func_177956_o(); var7 <= p_180709_3_.func_177956_o() + 1 + var5; ++var7) {
            byte var8 = 3;
            if(var7 <= p_180709_3_.func_177956_o() + 3) {
               var8 = 0;
            }

            for(var9 = p_180709_3_.func_177958_n() - var8; var9 <= p_180709_3_.func_177958_n() + var8 && var6; ++var9) {
               for(var10 = p_180709_3_.func_177952_p() - var8; var10 <= p_180709_3_.func_177952_p() + var8 && var6; ++var10) {
                  if(var7 >= 0 && var7 < 256) {
                     Block var11 = p_180709_1_.func_180495_p(new BlockPos(var9, var7, var10)).func_177230_c();
                     if(var11.func_149688_o() != Material.field_151579_a && var11.func_149688_o() != Material.field_151584_j) {
                        var6 = false;
                     }
                  } else {
                     var6 = false;
                  }
               }
            }
         }

         if(!var6) {
            return false;
         } else {
            Block var15 = p_180709_1_.func_180495_p(p_180709_3_.func_177977_b()).func_177230_c();
            if(var15 != Blocks.field_150346_d && var15 != Blocks.field_150349_c && var15 != Blocks.field_150391_bh) {
               return false;
            } else {
               int var16 = p_180709_3_.func_177956_o() + var5;
               if(var4 == 1) {
                  var16 = p_180709_3_.func_177956_o() + var5 - 3;
               }

               for(var9 = var16; var9 <= p_180709_3_.func_177956_o() + var5; ++var9) {
                  var10 = 1;
                  if(var9 < p_180709_3_.func_177956_o() + var5) {
                     ++var10;
                  }

                  if(var4 == 0) {
                     var10 = 3;
                  }

                  for(int var18 = p_180709_3_.func_177958_n() - var10; var18 <= p_180709_3_.func_177958_n() + var10; ++var18) {
                     for(int var12 = p_180709_3_.func_177952_p() - var10; var12 <= p_180709_3_.func_177952_p() + var10; ++var12) {
                        int var13 = 5;
                        if(var18 == p_180709_3_.func_177958_n() - var10) {
                           --var13;
                        }

                        if(var18 == p_180709_3_.func_177958_n() + var10) {
                           ++var13;
                        }

                        if(var12 == p_180709_3_.func_177952_p() - var10) {
                           var13 -= 3;
                        }

                        if(var12 == p_180709_3_.func_177952_p() + var10) {
                           var13 += 3;
                        }

                        if(var4 == 0 || var9 < p_180709_3_.func_177956_o() + var5) {
                           if((var18 == p_180709_3_.func_177958_n() - var10 || var18 == p_180709_3_.func_177958_n() + var10) && (var12 == p_180709_3_.func_177952_p() - var10 || var12 == p_180709_3_.func_177952_p() + var10)) {
                              continue;
                           }

                           if(var18 == p_180709_3_.func_177958_n() - (var10 - 1) && var12 == p_180709_3_.func_177952_p() - var10) {
                              var13 = 1;
                           }

                           if(var18 == p_180709_3_.func_177958_n() - var10 && var12 == p_180709_3_.func_177952_p() - (var10 - 1)) {
                              var13 = 1;
                           }

                           if(var18 == p_180709_3_.func_177958_n() + (var10 - 1) && var12 == p_180709_3_.func_177952_p() - var10) {
                              var13 = 3;
                           }

                           if(var18 == p_180709_3_.func_177958_n() + var10 && var12 == p_180709_3_.func_177952_p() - (var10 - 1)) {
                              var13 = 3;
                           }

                           if(var18 == p_180709_3_.func_177958_n() - (var10 - 1) && var12 == p_180709_3_.func_177952_p() + var10) {
                              var13 = 7;
                           }

                           if(var18 == p_180709_3_.func_177958_n() - var10 && var12 == p_180709_3_.func_177952_p() + (var10 - 1)) {
                              var13 = 7;
                           }

                           if(var18 == p_180709_3_.func_177958_n() + (var10 - 1) && var12 == p_180709_3_.func_177952_p() + var10) {
                              var13 = 9;
                           }

                           if(var18 == p_180709_3_.func_177958_n() + var10 && var12 == p_180709_3_.func_177952_p() + (var10 - 1)) {
                              var13 = 9;
                           }
                        }

                        if(var13 == 5 && var9 < p_180709_3_.func_177956_o() + var5) {
                           var13 = 0;
                        }

                        if(var13 != 0 || p_180709_3_.func_177956_o() >= p_180709_3_.func_177956_o() + var5 - 1) {
                           BlockPos var14 = new BlockPos(var18, var9, var12);
                           if(!p_180709_1_.func_180495_p(var14).func_177230_c().func_149730_j()) {
                              this.func_175905_a(p_180709_1_, var14, Block.func_149729_e(Block.func_149682_b(Blocks.field_150420_aW) + var4), var13);
                           }
                        }
                     }
                  }
               }

               for(var9 = 0; var9 < var5; ++var9) {
                  Block var17 = p_180709_1_.func_180495_p(p_180709_3_.func_177981_b(var9)).func_177230_c();
                  if(!var17.func_149730_j()) {
                     this.func_175905_a(p_180709_1_, p_180709_3_.func_177981_b(var9), Block.func_149729_e(Block.func_149682_b(Blocks.field_150420_aW) + var4), 10);
                  }
               }

               return true;
            }
         }
      } else {
         return false;
      }
   }
}
