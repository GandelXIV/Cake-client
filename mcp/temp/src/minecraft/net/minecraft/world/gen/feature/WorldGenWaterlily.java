package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWaterlily extends WorldGenerator {

   private static final String __OBFID = "CL_00000189";


   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      for(int var4 = 0; var4 < 10; ++var4) {
         int var5 = p_180709_3_.func_177958_n() + p_180709_2_.nextInt(8) - p_180709_2_.nextInt(8);
         int var6 = p_180709_3_.func_177956_o() + p_180709_2_.nextInt(4) - p_180709_2_.nextInt(4);
         int var7 = p_180709_3_.func_177952_p() + p_180709_2_.nextInt(8) - p_180709_2_.nextInt(8);
         if(p_180709_1_.func_175623_d(new BlockPos(var5, var6, var7)) && Blocks.field_150392_bi.func_176196_c(p_180709_1_, new BlockPos(var5, var6, var7))) {
            p_180709_1_.func_180501_a(new BlockPos(var5, var6, var7), Blocks.field_150392_bi.func_176223_P(), 2);
         }
      }

      return true;
   }
}
