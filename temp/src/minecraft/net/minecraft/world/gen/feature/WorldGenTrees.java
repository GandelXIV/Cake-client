package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenTrees extends WorldGenAbstractTree {

   private final int field_76533_a;
   private final boolean field_76531_b;
   private final int field_76532_c;
   private final int field_76530_d;
   private static final String __OBFID = "CL_00000438";


   public WorldGenTrees(boolean p_i2027_1_) {
      this(p_i2027_1_, 4, 0, 0, false);
   }

   public WorldGenTrees(boolean p_i2028_1_, int p_i2028_2_, int p_i2028_3_, int p_i2028_4_, boolean p_i2028_5_) {
      super(p_i2028_1_);
      this.field_76533_a = p_i2028_2_;
      this.field_76532_c = p_i2028_3_;
      this.field_76530_d = p_i2028_4_;
      this.field_76531_b = p_i2028_5_;
   }

   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      int var4 = p_180709_2_.nextInt(3) + this.field_76533_a;
      boolean var5 = true;
      if(p_180709_3_.func_177956_o() >= 1 && p_180709_3_.func_177956_o() + var4 + 1 <= 256) {
         byte var7;
         int var9;
         for(int var6 = p_180709_3_.func_177956_o(); var6 <= p_180709_3_.func_177956_o() + 1 + var4; ++var6) {
            var7 = 1;
            if(var6 == p_180709_3_.func_177956_o()) {
               var7 = 0;
            }

            if(var6 >= p_180709_3_.func_177956_o() + 1 + var4 - 2) {
               var7 = 2;
            }

            for(int var8 = p_180709_3_.func_177958_n() - var7; var8 <= p_180709_3_.func_177958_n() + var7 && var5; ++var8) {
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
            Block var19 = p_180709_1_.func_180495_p(p_180709_3_.func_177977_b()).func_177230_c();
            if((var19 == Blocks.field_150349_c || var19 == Blocks.field_150346_d || var19 == Blocks.field_150458_ak) && p_180709_3_.func_177956_o() < 256 - var4 - 1) {
               this.func_175921_a(p_180709_1_, p_180709_3_.func_177977_b());
               var7 = 3;
               byte var20 = 0;

               int var10;
               int var11;
               int var12;
               int var13;
               BlockPos var16;
               for(var9 = p_180709_3_.func_177956_o() - var7 + var4; var9 <= p_180709_3_.func_177956_o() + var4; ++var9) {
                  var10 = var9 - (p_180709_3_.func_177956_o() + var4);
                  var11 = var20 + 1 - var10 / 2;

                  for(var12 = p_180709_3_.func_177958_n() - var11; var12 <= p_180709_3_.func_177958_n() + var11; ++var12) {
                     var13 = var12 - p_180709_3_.func_177958_n();

                     for(int var14 = p_180709_3_.func_177952_p() - var11; var14 <= p_180709_3_.func_177952_p() + var11; ++var14) {
                        int var15 = var14 - p_180709_3_.func_177952_p();
                        if(Math.abs(var13) != var11 || Math.abs(var15) != var11 || p_180709_2_.nextInt(2) != 0 && var10 != 0) {
                           var16 = new BlockPos(var12, var9, var14);
                           Block var17 = p_180709_1_.func_180495_p(var16).func_177230_c();
                           if(var17.func_149688_o() == Material.field_151579_a || var17.func_149688_o() == Material.field_151584_j || var17.func_149688_o() == Material.field_151582_l) {
                              this.func_175905_a(p_180709_1_, var16, Blocks.field_150362_t, this.field_76530_d);
                           }
                        }
                     }
                  }
               }

               for(var9 = 0; var9 < var4; ++var9) {
                  Block var21 = p_180709_1_.func_180495_p(p_180709_3_.func_177981_b(var9)).func_177230_c();
                  if(var21.func_149688_o() == Material.field_151579_a || var21.func_149688_o() == Material.field_151584_j || var21.func_149688_o() == Material.field_151582_l) {
                     this.func_175905_a(p_180709_1_, p_180709_3_.func_177981_b(var9), Blocks.field_150364_r, this.field_76532_c);
                     if(this.field_76531_b && var9 > 0) {
                        if(p_180709_2_.nextInt(3) > 0 && p_180709_1_.func_175623_d(p_180709_3_.func_177982_a(-1, var9, 0))) {
                           this.func_175905_a(p_180709_1_, p_180709_3_.func_177982_a(-1, var9, 0), Blocks.field_150395_bd, BlockVine.field_176275_S);
                        }

                        if(p_180709_2_.nextInt(3) > 0 && p_180709_1_.func_175623_d(p_180709_3_.func_177982_a(1, var9, 0))) {
                           this.func_175905_a(p_180709_1_, p_180709_3_.func_177982_a(1, var9, 0), Blocks.field_150395_bd, BlockVine.field_176271_T);
                        }

                        if(p_180709_2_.nextInt(3) > 0 && p_180709_1_.func_175623_d(p_180709_3_.func_177982_a(0, var9, -1))) {
                           this.func_175905_a(p_180709_1_, p_180709_3_.func_177982_a(0, var9, -1), Blocks.field_150395_bd, BlockVine.field_176272_Q);
                        }

                        if(p_180709_2_.nextInt(3) > 0 && p_180709_1_.func_175623_d(p_180709_3_.func_177982_a(0, var9, 1))) {
                           this.func_175905_a(p_180709_1_, p_180709_3_.func_177982_a(0, var9, 1), Blocks.field_150395_bd, BlockVine.field_176276_R);
                        }
                     }
                  }
               }

               if(this.field_76531_b) {
                  for(var9 = p_180709_3_.func_177956_o() - 3 + var4; var9 <= p_180709_3_.func_177956_o() + var4; ++var9) {
                     var10 = var9 - (p_180709_3_.func_177956_o() + var4);
                     var11 = 2 - var10 / 2;

                     for(var12 = p_180709_3_.func_177958_n() - var11; var12 <= p_180709_3_.func_177958_n() + var11; ++var12) {
                        for(var13 = p_180709_3_.func_177952_p() - var11; var13 <= p_180709_3_.func_177952_p() + var11; ++var13) {
                           BlockPos var23 = new BlockPos(var12, var9, var13);
                           if(p_180709_1_.func_180495_p(var23).func_177230_c().func_149688_o() == Material.field_151584_j) {
                              BlockPos var24 = var23.func_177976_e();
                              var16 = var23.func_177974_f();
                              BlockPos var25 = var23.func_177978_c();
                              BlockPos var18 = var23.func_177968_d();
                              if(p_180709_2_.nextInt(4) == 0 && p_180709_1_.func_180495_p(var24).func_177230_c().func_149688_o() == Material.field_151579_a) {
                                 this.func_175923_a(p_180709_1_, var24, BlockVine.field_176275_S);
                              }

                              if(p_180709_2_.nextInt(4) == 0 && p_180709_1_.func_180495_p(var16).func_177230_c().func_149688_o() == Material.field_151579_a) {
                                 this.func_175923_a(p_180709_1_, var16, BlockVine.field_176271_T);
                              }

                              if(p_180709_2_.nextInt(4) == 0 && p_180709_1_.func_180495_p(var25).func_177230_c().func_149688_o() == Material.field_151579_a) {
                                 this.func_175923_a(p_180709_1_, var25, BlockVine.field_176272_Q);
                              }

                              if(p_180709_2_.nextInt(4) == 0 && p_180709_1_.func_180495_p(var18).func_177230_c().func_149688_o() == Material.field_151579_a) {
                                 this.func_175923_a(p_180709_1_, var18, BlockVine.field_176276_R);
                              }
                           }
                        }
                     }
                  }

                  if(p_180709_2_.nextInt(5) == 0 && var4 > 5) {
                     for(var9 = 0; var9 < 2; ++var9) {
                        for(var10 = 0; var10 < 4; ++var10) {
                           if(p_180709_2_.nextInt(4 - var9) == 0) {
                              var11 = p_180709_2_.nextInt(3);
                              EnumFacing var22 = EnumFacing.func_176731_b(var10).func_176734_d();
                              this.func_175905_a(p_180709_1_, p_180709_3_.func_177982_a(var22.func_82601_c(), var4 - 5 + var9, var22.func_82599_e()), Blocks.field_150375_by, var11 << 2 | EnumFacing.func_176731_b(var10).func_176736_b());
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

   private void func_175923_a(World p_175923_1_, BlockPos p_175923_2_, int p_175923_3_) {
      this.func_175905_a(p_175923_1_, p_175923_2_, Blocks.field_150395_bd, p_175923_3_);
      int var4 = 4;

      for(p_175923_2_ = p_175923_2_.func_177977_b(); p_175923_1_.func_180495_p(p_175923_2_).func_177230_c().func_149688_o() == Material.field_151579_a && var4 > 0; --var4) {
         this.func_175905_a(p_175923_1_, p_175923_2_, Blocks.field_150395_bd, p_175923_3_);
         p_175923_2_ = p_175923_2_.func_177977_b();
      }

   }
}
