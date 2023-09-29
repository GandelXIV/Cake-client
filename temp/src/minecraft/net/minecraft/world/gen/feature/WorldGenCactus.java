package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCactus extends WorldGenerator {

   private static final String __OBFID = "CL_00000404";


   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      for(int var4 = 0; var4 < 10; ++var4) {
         BlockPos var5 = p_180709_3_.func_177982_a(p_180709_2_.nextInt(8) - p_180709_2_.nextInt(8), p_180709_2_.nextInt(4) - p_180709_2_.nextInt(4), p_180709_2_.nextInt(8) - p_180709_2_.nextInt(8));
         if(p_180709_1_.func_175623_d(var5)) {
            int var6 = 1 + p_180709_2_.nextInt(p_180709_2_.nextInt(3) + 1);

            for(int var7 = 0; var7 < var6; ++var7) {
               if(Blocks.field_150434_aF.func_176586_d(p_180709_1_, var5)) {
                  p_180709_1_.func_180501_a(var5.func_177981_b(var7), Blocks.field_150434_aF.func_176223_P(), 2);
               }
            }
         }
      }

      return true;
   }
}
