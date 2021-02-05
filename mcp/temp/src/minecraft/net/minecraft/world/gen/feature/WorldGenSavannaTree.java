package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenSavannaTree extends WorldGenAbstractTree {

   private static final String __OBFID = "CL_00000432";


   public WorldGenSavannaTree(boolean p_i45463_1_) {
      super(p_i45463_1_);
   }

   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      int var4 = p_180709_2_.nextInt(3) + p_180709_2_.nextInt(3) + 5;
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
            Block var20 = p_180709_1_.func_180495_p(p_180709_3_.func_177977_b()).func_177230_c();
            if((var20 == Blocks.field_150349_c || var20 == Blocks.field_150346_d) && p_180709_3_.func_177956_o() < 256 - var4 - 1) {
               this.func_175921_a(p_180709_1_, p_180709_3_.func_177977_b());
               EnumFacing var21 = EnumFacing.Plane.HORIZONTAL.func_179518_a(p_180709_2_);
               var8 = var4 - p_180709_2_.nextInt(4) - 1;
               var9 = 3 - p_180709_2_.nextInt(3);
               int var10 = p_180709_3_.func_177958_n();
               int var11 = p_180709_3_.func_177952_p();
               int var12 = 0;

               int var14;
               for(int var13 = 0; var13 < var4; ++var13) {
                  var14 = p_180709_3_.func_177956_o() + var13;
                  if(var13 >= var8 && var9 > 0) {
                     var10 += var21.func_82601_c();
                     var11 += var21.func_82599_e();
                     --var9;
                  }

                  BlockPos var15 = new BlockPos(var10, var14, var11);
                  Material var16 = p_180709_1_.func_180495_p(var15).func_177230_c().func_149688_o();
                  if(var16 == Material.field_151579_a || var16 == Material.field_151584_j) {
                     this.func_175905_a(p_180709_1_, var15, Blocks.field_150363_s, BlockPlanks.EnumType.ACACIA.func_176839_a() - 4);
                     var12 = var14;
                  }
               }

               BlockPos var22 = new BlockPos(var10, var12, var11);

               int var24;
               for(var14 = -3; var14 <= 3; ++var14) {
                  for(var24 = -3; var24 <= 3; ++var24) {
                     if(Math.abs(var14) != 3 || Math.abs(var24) != 3) {
                        this.func_175924_b(p_180709_1_, var22.func_177982_a(var14, 0, var24));
                     }
                  }
               }

               var22 = var22.func_177984_a();

               for(var14 = -1; var14 <= 1; ++var14) {
                  for(var24 = -1; var24 <= 1; ++var24) {
                     this.func_175924_b(p_180709_1_, var22.func_177982_a(var14, 0, var24));
                  }
               }

               this.func_175924_b(p_180709_1_, var22.func_177965_g(2));
               this.func_175924_b(p_180709_1_, var22.func_177985_f(2));
               this.func_175924_b(p_180709_1_, var22.func_177970_e(2));
               this.func_175924_b(p_180709_1_, var22.func_177964_d(2));
               var10 = p_180709_3_.func_177958_n();
               var11 = p_180709_3_.func_177952_p();
               EnumFacing var23 = EnumFacing.Plane.HORIZONTAL.func_179518_a(p_180709_2_);
               if(var23 != var21) {
                  var14 = var8 - p_180709_2_.nextInt(2) - 1;
                  var24 = 1 + p_180709_2_.nextInt(3);
                  var12 = 0;

                  int var17;
                  for(int var25 = var14; var25 < var4 && var24 > 0; --var24) {
                     if(var25 >= 1) {
                        var17 = p_180709_3_.func_177956_o() + var25;
                        var10 += var23.func_82601_c();
                        var11 += var23.func_82599_e();
                        BlockPos var18 = new BlockPos(var10, var17, var11);
                        Material var19 = p_180709_1_.func_180495_p(var18).func_177230_c().func_149688_o();
                        if(var19 == Material.field_151579_a || var19 == Material.field_151584_j) {
                           this.func_175905_a(p_180709_1_, var18, Blocks.field_150363_s, BlockPlanks.EnumType.ACACIA.func_176839_a() - 4);
                           var12 = var17;
                        }
                     }

                     ++var25;
                  }

                  if(var12 > 0) {
                     BlockPos var26 = new BlockPos(var10, var12, var11);

                     int var27;
                     for(var17 = -2; var17 <= 2; ++var17) {
                        for(var27 = -2; var27 <= 2; ++var27) {
                           if(Math.abs(var17) != 2 || Math.abs(var27) != 2) {
                              this.func_175924_b(p_180709_1_, var26.func_177982_a(var17, 0, var27));
                           }
                        }
                     }

                     var26 = var26.func_177984_a();

                     for(var17 = -1; var17 <= 1; ++var17) {
                        for(var27 = -1; var27 <= 1; ++var27) {
                           this.func_175924_b(p_180709_1_, var26.func_177982_a(var17, 0, var27));
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

   private void func_175924_b(World p_175924_1_, BlockPos p_175924_2_) {
      Material var3 = p_175924_1_.func_180495_p(p_175924_2_).func_177230_c().func_149688_o();
      if(var3 == Material.field_151579_a || var3 == Material.field_151584_j) {
         this.func_175905_a(p_175924_1_, p_175924_2_, Blocks.field_150361_u, 0);
      }

   }
}
