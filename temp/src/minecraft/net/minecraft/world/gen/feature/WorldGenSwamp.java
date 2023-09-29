package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenSwamp extends WorldGenAbstractTree {

   private static final String __OBFID = "CL_00000436";


   public WorldGenSwamp() {
      super(false);
   }

   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      int var4;
      for(var4 = p_180709_2_.nextInt(4) + 5; p_180709_1_.func_180495_p(p_180709_3_.func_177977_b()).func_177230_c().func_149688_o() == Material.field_151586_h; p_180709_3_ = p_180709_3_.func_177977_b()) {
         ;
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
               var7 = 3;
            }

            for(var8 = p_180709_3_.func_177958_n() - var7; var8 <= p_180709_3_.func_177958_n() + var7 && var5; ++var8) {
               for(var9 = p_180709_3_.func_177952_p() - var7; var9 <= p_180709_3_.func_177952_p() + var7 && var5; ++var9) {
                  if(var6 >= 0 && var6 < 256) {
                     Block var10 = p_180709_1_.func_180495_p(new BlockPos(var8, var6, var9)).func_177230_c();
                     if(var10.func_149688_o() != Material.field_151579_a && var10.func_149688_o() != Material.field_151584_j) {
                        if(var10 != Blocks.field_150355_j && var10 != Blocks.field_150358_i) {
                           var5 = false;
                        } else if(var6 > p_180709_3_.func_177956_o()) {
                           var5 = false;
                        }
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
            Block var17 = p_180709_1_.func_180495_p(p_180709_3_.func_177977_b()).func_177230_c();
            if((var17 == Blocks.field_150349_c || var17 == Blocks.field_150346_d) && p_180709_3_.func_177956_o() < 256 - var4 - 1) {
               this.func_175921_a(p_180709_1_, p_180709_3_.func_177977_b());

               int var11;
               BlockPos var14;
               int var18;
               int var20;
               for(var18 = p_180709_3_.func_177956_o() - 3 + var4; var18 <= p_180709_3_.func_177956_o() + var4; ++var18) {
                  var8 = var18 - (p_180709_3_.func_177956_o() + var4);
                  var9 = 2 - var8 / 2;

                  for(var20 = p_180709_3_.func_177958_n() - var9; var20 <= p_180709_3_.func_177958_n() + var9; ++var20) {
                     var11 = var20 - p_180709_3_.func_177958_n();

                     for(int var12 = p_180709_3_.func_177952_p() - var9; var12 <= p_180709_3_.func_177952_p() + var9; ++var12) {
                        int var13 = var12 - p_180709_3_.func_177952_p();
                        if(Math.abs(var11) != var9 || Math.abs(var13) != var9 || p_180709_2_.nextInt(2) != 0 && var8 != 0) {
                           var14 = new BlockPos(var20, var18, var12);
                           if(!p_180709_1_.func_180495_p(var14).func_177230_c().func_149730_j()) {
                              this.func_175906_a(p_180709_1_, var14, Blocks.field_150362_t);
                           }
                        }
                     }
                  }
               }

               for(var18 = 0; var18 < var4; ++var18) {
                  Block var19 = p_180709_1_.func_180495_p(p_180709_3_.func_177981_b(var18)).func_177230_c();
                  if(var19.func_149688_o() == Material.field_151579_a || var19.func_149688_o() == Material.field_151584_j || var19 == Blocks.field_150358_i || var19 == Blocks.field_150355_j) {
                     this.func_175906_a(p_180709_1_, p_180709_3_.func_177981_b(var18), Blocks.field_150364_r);
                  }
               }

               for(var18 = p_180709_3_.func_177956_o() - 3 + var4; var18 <= p_180709_3_.func_177956_o() + var4; ++var18) {
                  var8 = var18 - (p_180709_3_.func_177956_o() + var4);
                  var9 = 2 - var8 / 2;

                  for(var20 = p_180709_3_.func_177958_n() - var9; var20 <= p_180709_3_.func_177958_n() + var9; ++var20) {
                     for(var11 = p_180709_3_.func_177952_p() - var9; var11 <= p_180709_3_.func_177952_p() + var9; ++var11) {
                        BlockPos var21 = new BlockPos(var20, var18, var11);
                        if(p_180709_1_.func_180495_p(var21).func_177230_c().func_149688_o() == Material.field_151584_j) {
                           BlockPos var22 = var21.func_177976_e();
                           var14 = var21.func_177974_f();
                           BlockPos var15 = var21.func_177978_c();
                           BlockPos var16 = var21.func_177968_d();
                           if(p_180709_2_.nextInt(4) == 0 && p_180709_1_.func_180495_p(var22).func_177230_c().func_149688_o() == Material.field_151579_a) {
                              this.func_175922_a(p_180709_1_, var22, BlockVine.field_176275_S);
                           }

                           if(p_180709_2_.nextInt(4) == 0 && p_180709_1_.func_180495_p(var14).func_177230_c().func_149688_o() == Material.field_151579_a) {
                              this.func_175922_a(p_180709_1_, var14, BlockVine.field_176271_T);
                           }

                           if(p_180709_2_.nextInt(4) == 0 && p_180709_1_.func_180495_p(var15).func_177230_c().func_149688_o() == Material.field_151579_a) {
                              this.func_175922_a(p_180709_1_, var15, BlockVine.field_176272_Q);
                           }

                           if(p_180709_2_.nextInt(4) == 0 && p_180709_1_.func_180495_p(var16).func_177230_c().func_149688_o() == Material.field_151579_a) {
                              this.func_175922_a(p_180709_1_, var16, BlockVine.field_176276_R);
                           }
                        }
                     }
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

   private void func_175922_a(World p_175922_1_, BlockPos p_175922_2_, int p_175922_3_) {
      this.func_175905_a(p_175922_1_, p_175922_2_, Blocks.field_150395_bd, p_175922_3_);
      int var4 = 4;

      for(p_175922_2_ = p_175922_2_.func_177977_b(); p_175922_1_.func_180495_p(p_175922_2_).func_177230_c().func_149688_o() == Material.field_151579_a && var4 > 0; --var4) {
         this.func_175905_a(p_175922_1_, p_175922_2_, Blocks.field_150395_bd, p_175922_3_);
         p_175922_2_ = p_175922_2_.func_177977_b();
      }

   }
}
