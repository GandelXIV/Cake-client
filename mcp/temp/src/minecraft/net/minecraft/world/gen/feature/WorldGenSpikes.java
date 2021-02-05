package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSpikes extends WorldGenerator {

   private Block field_150520_a;
   private static final String __OBFID = "CL_00000433";


   public WorldGenSpikes(Block p_i45464_1_) {
      this.field_150520_a = p_i45464_1_;
   }

   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      if(p_180709_1_.func_175623_d(p_180709_3_) && p_180709_1_.func_180495_p(p_180709_3_.func_177977_b()).func_177230_c() == this.field_150520_a) {
         int var4 = p_180709_2_.nextInt(32) + 6;
         int var5 = p_180709_2_.nextInt(4) + 1;

         int var6;
         int var7;
         int var8;
         int var9;
         for(var6 = p_180709_3_.func_177958_n() - var5; var6 <= p_180709_3_.func_177958_n() + var5; ++var6) {
            for(var7 = p_180709_3_.func_177952_p() - var5; var7 <= p_180709_3_.func_177952_p() + var5; ++var7) {
               var8 = var6 - p_180709_3_.func_177958_n();
               var9 = var7 - p_180709_3_.func_177952_p();
               if(var8 * var8 + var9 * var9 <= var5 * var5 + 1 && p_180709_1_.func_180495_p(new BlockPos(var6, p_180709_3_.func_177956_o() - 1, var7)).func_177230_c() != this.field_150520_a) {
                  return false;
               }
            }
         }

         for(var6 = p_180709_3_.func_177956_o(); var6 < p_180709_3_.func_177956_o() + var4 && var6 < 256; ++var6) {
            for(var7 = p_180709_3_.func_177958_n() - var5; var7 <= p_180709_3_.func_177958_n() + var5; ++var7) {
               for(var8 = p_180709_3_.func_177952_p() - var5; var8 <= p_180709_3_.func_177952_p() + var5; ++var8) {
                  var9 = var7 - p_180709_3_.func_177958_n();
                  int var10 = var8 - p_180709_3_.func_177952_p();
                  if(var9 * var9 + var10 * var10 <= var5 * var5 + 1) {
                     p_180709_1_.func_180501_a(new BlockPos(var7, var6, var8), Blocks.field_150343_Z.func_176223_P(), 2);
                  }
               }
            }
         }

         EntityEnderCrystal var11 = new EntityEnderCrystal(p_180709_1_);
         var11.func_70012_b((double)((float)p_180709_3_.func_177958_n() + 0.5F), (double)(p_180709_3_.func_177956_o() + var4), (double)((float)p_180709_3_.func_177952_p() + 0.5F), p_180709_2_.nextFloat() * 360.0F, 0.0F);
         p_180709_1_.func_72838_d(var11);
         p_180709_1_.func_180501_a(p_180709_3_.func_177981_b(var4), Blocks.field_150357_h.func_176223_P(), 2);
         return true;
      } else {
         return false;
      }
   }
}
