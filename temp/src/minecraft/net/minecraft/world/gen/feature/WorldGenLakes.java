package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLakes extends WorldGenerator {

   private Block field_150556_a;
   private static final String __OBFID = "CL_00000418";


   public WorldGenLakes(Block p_i45455_1_) {
      this.field_150556_a = p_i45455_1_;
   }

   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      for(p_180709_3_ = p_180709_3_.func_177982_a(-8, 0, -8); p_180709_3_.func_177956_o() > 5 && p_180709_1_.func_175623_d(p_180709_3_); p_180709_3_ = p_180709_3_.func_177977_b()) {
         ;
      }

      if(p_180709_3_.func_177956_o() <= 4) {
         return false;
      } else {
         p_180709_3_ = p_180709_3_.func_177979_c(4);
         boolean[] var4 = new boolean[2048];
         int var5 = p_180709_2_.nextInt(4) + 4;

         int var6;
         for(var6 = 0; var6 < var5; ++var6) {
            double var7 = p_180709_2_.nextDouble() * 6.0D + 3.0D;
            double var9 = p_180709_2_.nextDouble() * 4.0D + 2.0D;
            double var11 = p_180709_2_.nextDouble() * 6.0D + 3.0D;
            double var13 = p_180709_2_.nextDouble() * (16.0D - var7 - 2.0D) + 1.0D + var7 / 2.0D;
            double var15 = p_180709_2_.nextDouble() * (8.0D - var9 - 4.0D) + 2.0D + var9 / 2.0D;
            double var17 = p_180709_2_.nextDouble() * (16.0D - var11 - 2.0D) + 1.0D + var11 / 2.0D;

            for(int var19 = 1; var19 < 15; ++var19) {
               for(int var20 = 1; var20 < 15; ++var20) {
                  for(int var21 = 1; var21 < 7; ++var21) {
                     double var22 = ((double)var19 - var13) / (var7 / 2.0D);
                     double var24 = ((double)var21 - var15) / (var9 / 2.0D);
                     double var26 = ((double)var20 - var17) / (var11 / 2.0D);
                     double var28 = var22 * var22 + var24 * var24 + var26 * var26;
                     if(var28 < 1.0D) {
                        var4[(var19 * 16 + var20) * 8 + var21] = true;
                     }
                  }
               }
            }
         }

         int var8;
         int var30;
         boolean var32;
         for(var6 = 0; var6 < 16; ++var6) {
            for(var30 = 0; var30 < 16; ++var30) {
               for(var8 = 0; var8 < 8; ++var8) {
                  var32 = !var4[(var6 * 16 + var30) * 8 + var8] && (var6 < 15 && var4[((var6 + 1) * 16 + var30) * 8 + var8] || var6 > 0 && var4[((var6 - 1) * 16 + var30) * 8 + var8] || var30 < 15 && var4[(var6 * 16 + var30 + 1) * 8 + var8] || var30 > 0 && var4[(var6 * 16 + (var30 - 1)) * 8 + var8] || var8 < 7 && var4[(var6 * 16 + var30) * 8 + var8 + 1] || var8 > 0 && var4[(var6 * 16 + var30) * 8 + (var8 - 1)]);
                  if(var32) {
                     Material var10 = p_180709_1_.func_180495_p(p_180709_3_.func_177982_a(var6, var8, var30)).func_177230_c().func_149688_o();
                     if(var8 >= 4 && var10.func_76224_d()) {
                        return false;
                     }

                     if(var8 < 4 && !var10.func_76220_a() && p_180709_1_.func_180495_p(p_180709_3_.func_177982_a(var6, var8, var30)).func_177230_c() != this.field_150556_a) {
                        return false;
                     }
                  }
               }
            }
         }

         for(var6 = 0; var6 < 16; ++var6) {
            for(var30 = 0; var30 < 16; ++var30) {
               for(var8 = 0; var8 < 8; ++var8) {
                  if(var4[(var6 * 16 + var30) * 8 + var8]) {
                     p_180709_1_.func_180501_a(p_180709_3_.func_177982_a(var6, var8, var30), var8 >= 4?Blocks.field_150350_a.func_176223_P():this.field_150556_a.func_176223_P(), 2);
                  }
               }
            }
         }

         for(var6 = 0; var6 < 16; ++var6) {
            for(var30 = 0; var30 < 16; ++var30) {
               for(var8 = 4; var8 < 8; ++var8) {
                  if(var4[(var6 * 16 + var30) * 8 + var8]) {
                     BlockPos var33 = p_180709_3_.func_177982_a(var6, var8 - 1, var30);
                     if(p_180709_1_.func_180495_p(var33).func_177230_c() == Blocks.field_150346_d && p_180709_1_.func_175642_b(EnumSkyBlock.SKY, p_180709_3_.func_177982_a(var6, var8, var30)) > 0) {
                        BiomeGenBase var34 = p_180709_1_.func_180494_b(var33);
                        if(var34.field_76752_A.func_177230_c() == Blocks.field_150391_bh) {
                           p_180709_1_.func_180501_a(var33, Blocks.field_150391_bh.func_176223_P(), 2);
                        } else {
                           p_180709_1_.func_180501_a(var33, Blocks.field_150349_c.func_176223_P(), 2);
                        }
                     }
                  }
               }
            }
         }

         if(this.field_150556_a.func_149688_o() == Material.field_151587_i) {
            for(var6 = 0; var6 < 16; ++var6) {
               for(var30 = 0; var30 < 16; ++var30) {
                  for(var8 = 0; var8 < 8; ++var8) {
                     var32 = !var4[(var6 * 16 + var30) * 8 + var8] && (var6 < 15 && var4[((var6 + 1) * 16 + var30) * 8 + var8] || var6 > 0 && var4[((var6 - 1) * 16 + var30) * 8 + var8] || var30 < 15 && var4[(var6 * 16 + var30 + 1) * 8 + var8] || var30 > 0 && var4[(var6 * 16 + (var30 - 1)) * 8 + var8] || var8 < 7 && var4[(var6 * 16 + var30) * 8 + var8 + 1] || var8 > 0 && var4[(var6 * 16 + var30) * 8 + (var8 - 1)]);
                     if(var32 && (var8 < 4 || p_180709_2_.nextInt(2) != 0) && p_180709_1_.func_180495_p(p_180709_3_.func_177982_a(var6, var8, var30)).func_177230_c().func_149688_o().func_76220_a()) {
                        p_180709_1_.func_180501_a(p_180709_3_.func_177982_a(var6, var8, var30), Blocks.field_150348_b.func_176223_P(), 2);
                     }
                  }
               }
            }
         }

         if(this.field_150556_a.func_149688_o() == Material.field_151586_h) {
            for(var6 = 0; var6 < 16; ++var6) {
               for(var30 = 0; var30 < 16; ++var30) {
                  byte var31 = 4;
                  if(p_180709_1_.func_175675_v(p_180709_3_.func_177982_a(var6, var31, var30))) {
                     p_180709_1_.func_180501_a(p_180709_3_.func_177982_a(var6, var31, var30), Blocks.field_150432_aD.func_176223_P(), 2);
                  }
               }
            }
         }

         return true;
      }
   }
}
