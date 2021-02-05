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

public class WorldGenCanopyTree extends WorldGenAbstractTree {

   private static final String __OBFID = "CL_00000430";


   public WorldGenCanopyTree(boolean p_i45461_1_) {
      super(p_i45461_1_);
   }

   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      int var4 = p_180709_2_.nextInt(3) + p_180709_2_.nextInt(2) + 6;
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
            Block var18 = p_180709_1_.func_180495_p(p_180709_3_.func_177977_b()).func_177230_c();
            if((var18 == Blocks.field_150349_c || var18 == Blocks.field_150346_d) && p_180709_3_.func_177956_o() < 256 - var4 - 1) {
               this.func_175921_a(p_180709_1_, p_180709_3_.func_177977_b());
               this.func_175921_a(p_180709_1_, p_180709_3_.func_177982_a(1, -1, 0));
               this.func_175921_a(p_180709_1_, p_180709_3_.func_177982_a(1, -1, 1));
               this.func_175921_a(p_180709_1_, p_180709_3_.func_177982_a(0, -1, 1));
               EnumFacing var19 = EnumFacing.Plane.HORIZONTAL.func_179518_a(p_180709_2_);
               var8 = var4 - p_180709_2_.nextInt(4);
               var9 = 2 - p_180709_2_.nextInt(3);
               int var10 = p_180709_3_.func_177958_n();
               int var11 = p_180709_3_.func_177952_p();
               int var12 = 0;

               int var13;
               int var14;
               for(var13 = 0; var13 < var4; ++var13) {
                  var14 = p_180709_3_.func_177956_o() + var13;
                  if(var13 >= var8 && var9 > 0) {
                     var10 += var19.func_82601_c();
                     var11 += var19.func_82599_e();
                     --var9;
                  }

                  BlockPos var15 = new BlockPos(var10, var14, var11);
                  Material var16 = p_180709_1_.func_180495_p(var15).func_177230_c().func_149688_o();
                  if(var16 == Material.field_151579_a || var16 == Material.field_151584_j) {
                     this.func_175905_a(p_180709_1_, var15, Blocks.field_150363_s, BlockPlanks.EnumType.DARK_OAK.func_176839_a() - 4);
                     this.func_175905_a(p_180709_1_, var15.func_177974_f(), Blocks.field_150363_s, BlockPlanks.EnumType.DARK_OAK.func_176839_a() - 4);
                     this.func_175905_a(p_180709_1_, var15.func_177968_d(), Blocks.field_150363_s, BlockPlanks.EnumType.DARK_OAK.func_176839_a() - 4);
                     this.func_175905_a(p_180709_1_, var15.func_177974_f().func_177968_d(), Blocks.field_150363_s, BlockPlanks.EnumType.DARK_OAK.func_176839_a() - 4);
                     var12 = var14;
                  }
               }

               for(var13 = -2; var13 <= 0; ++var13) {
                  for(var14 = -2; var14 <= 0; ++var14) {
                     byte var20 = -1;
                     this.func_150526_a(p_180709_1_, var10 + var13, var12 + var20, var11 + var14);
                     this.func_150526_a(p_180709_1_, 1 + var10 - var13, var12 + var20, var11 + var14);
                     this.func_150526_a(p_180709_1_, var10 + var13, var12 + var20, 1 + var11 - var14);
                     this.func_150526_a(p_180709_1_, 1 + var10 - var13, var12 + var20, 1 + var11 - var14);
                     if((var13 > -2 || var14 > -1) && (var13 != -1 || var14 != -2)) {
                        byte var21 = 1;
                        this.func_150526_a(p_180709_1_, var10 + var13, var12 + var21, var11 + var14);
                        this.func_150526_a(p_180709_1_, 1 + var10 - var13, var12 + var21, var11 + var14);
                        this.func_150526_a(p_180709_1_, var10 + var13, var12 + var21, 1 + var11 - var14);
                        this.func_150526_a(p_180709_1_, 1 + var10 - var13, var12 + var21, 1 + var11 - var14);
                     }
                  }
               }

               if(p_180709_2_.nextBoolean()) {
                  this.func_150526_a(p_180709_1_, var10, var12 + 2, var11);
                  this.func_150526_a(p_180709_1_, var10 + 1, var12 + 2, var11);
                  this.func_150526_a(p_180709_1_, var10 + 1, var12 + 2, var11 + 1);
                  this.func_150526_a(p_180709_1_, var10, var12 + 2, var11 + 1);
               }

               for(var13 = -3; var13 <= 4; ++var13) {
                  for(var14 = -3; var14 <= 4; ++var14) {
                     if((var13 != -3 || var14 != -3) && (var13 != -3 || var14 != 4) && (var13 != 4 || var14 != -3) && (var13 != 4 || var14 != 4) && (Math.abs(var13) < 3 || Math.abs(var14) < 3)) {
                        this.func_150526_a(p_180709_1_, var10 + var13, var12, var11 + var14);
                     }
                  }
               }

               for(var13 = -1; var13 <= 2; ++var13) {
                  for(var14 = -1; var14 <= 2; ++var14) {
                     if((var13 < 0 || var13 > 1 || var14 < 0 || var14 > 1) && p_180709_2_.nextInt(3) <= 0) {
                        int var22 = p_180709_2_.nextInt(3) + 2;

                        int var23;
                        for(var23 = 0; var23 < var22; ++var23) {
                           this.func_175905_a(p_180709_1_, new BlockPos(p_180709_3_.func_177958_n() + var13, var12 - var23 - 1, p_180709_3_.func_177952_p() + var14), Blocks.field_150363_s, BlockPlanks.EnumType.DARK_OAK.func_176839_a() - 4);
                        }

                        int var17;
                        for(var23 = -1; var23 <= 1; ++var23) {
                           for(var17 = -1; var17 <= 1; ++var17) {
                              this.func_150526_a(p_180709_1_, var10 + var13 + var23, var12 - 0, var11 + var14 + var17);
                           }
                        }

                        for(var23 = -2; var23 <= 2; ++var23) {
                           for(var17 = -2; var17 <= 2; ++var17) {
                              if(Math.abs(var23) != 2 || Math.abs(var17) != 2) {
                                 this.func_150526_a(p_180709_1_, var10 + var13 + var23, var12 - 1, var11 + var14 + var17);
                              }
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

   private void func_150526_a(World p_150526_1_, int p_150526_2_, int p_150526_3_, int p_150526_4_) {
      Block var5 = p_150526_1_.func_180495_p(new BlockPos(p_150526_2_, p_150526_3_, p_150526_4_)).func_177230_c();
      if(var5.func_149688_o() == Material.field_151579_a) {
         this.func_175905_a(p_150526_1_, new BlockPos(p_150526_2_, p_150526_3_, p_150526_4_), Blocks.field_150361_u, 1);
      }

   }
}
