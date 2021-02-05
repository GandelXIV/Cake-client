package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenReed extends WorldGenerator {

   private static final String __OBFID = "CL_00000429";


   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      for(int var4 = 0; var4 < 20; ++var4) {
         BlockPos var5 = p_180709_3_.func_177982_a(p_180709_2_.nextInt(4) - p_180709_2_.nextInt(4), 0, p_180709_2_.nextInt(4) - p_180709_2_.nextInt(4));
         if(p_180709_1_.func_175623_d(var5)) {
            BlockPos var6 = var5.func_177977_b();
            if(p_180709_1_.func_180495_p(var6.func_177976_e()).func_177230_c().func_149688_o() == Material.field_151586_h || p_180709_1_.func_180495_p(var6.func_177974_f()).func_177230_c().func_149688_o() == Material.field_151586_h || p_180709_1_.func_180495_p(var6.func_177978_c()).func_177230_c().func_149688_o() == Material.field_151586_h || p_180709_1_.func_180495_p(var6.func_177968_d()).func_177230_c().func_149688_o() == Material.field_151586_h) {
               int var7 = 2 + p_180709_2_.nextInt(p_180709_2_.nextInt(3) + 1);

               for(int var8 = 0; var8 < var7; ++var8) {
                  if(Blocks.field_150436_aH.func_176354_d(p_180709_1_, var5)) {
                     p_180709_1_.func_180501_a(var5.func_177981_b(var8), Blocks.field_150436_aH.func_176223_P(), 2);
                  }
               }
            }
         }
      }

      return true;
   }
}
