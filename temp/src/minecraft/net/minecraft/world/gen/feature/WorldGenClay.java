package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenClay extends WorldGenerator {

   private Block field_150546_a;
   private int field_76517_b;
   private static final String __OBFID = "CL_00000405";


   public WorldGenClay(int p_i2011_1_) {
      this.field_150546_a = Blocks.field_150435_aG;
      this.field_76517_b = p_i2011_1_;
   }

   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      if(p_180709_1_.func_180495_p(p_180709_3_).func_177230_c().func_149688_o() != Material.field_151586_h) {
         return false;
      } else {
         int var4 = p_180709_2_.nextInt(this.field_76517_b - 2) + 2;
         byte var5 = 1;

         for(int var6 = p_180709_3_.func_177958_n() - var4; var6 <= p_180709_3_.func_177958_n() + var4; ++var6) {
            for(int var7 = p_180709_3_.func_177952_p() - var4; var7 <= p_180709_3_.func_177952_p() + var4; ++var7) {
               int var8 = var6 - p_180709_3_.func_177958_n();
               int var9 = var7 - p_180709_3_.func_177952_p();
               if(var8 * var8 + var9 * var9 <= var4 * var4) {
                  for(int var10 = p_180709_3_.func_177956_o() - var5; var10 <= p_180709_3_.func_177956_o() + var5; ++var10) {
                     BlockPos var11 = new BlockPos(var6, var10, var7);
                     Block var12 = p_180709_1_.func_180495_p(var11).func_177230_c();
                     if(var12 == Blocks.field_150346_d || var12 == Blocks.field_150435_aG) {
                        p_180709_1_.func_180501_a(var11, this.field_150546_a.func_176223_P(), 2);
                     }
                  }
               }
            }
         }

         return true;
      }
   }
}
