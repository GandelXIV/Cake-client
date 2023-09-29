package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDeadBush extends WorldGenerator {

   private static final String __OBFID = "CL_00000406";


   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      Block var4;
      while(((var4 = p_180709_1_.func_180495_p(p_180709_3_).func_177230_c()).func_149688_o() == Material.field_151579_a || var4.func_149688_o() == Material.field_151584_j) && p_180709_3_.func_177956_o() > 0) {
         p_180709_3_ = p_180709_3_.func_177977_b();
      }

      for(int var5 = 0; var5 < 4; ++var5) {
         BlockPos var6 = p_180709_3_.func_177982_a(p_180709_2_.nextInt(8) - p_180709_2_.nextInt(8), p_180709_2_.nextInt(4) - p_180709_2_.nextInt(4), p_180709_2_.nextInt(8) - p_180709_2_.nextInt(8));
         if(p_180709_1_.func_175623_d(var6) && Blocks.field_150330_I.func_180671_f(p_180709_1_, var6, Blocks.field_150330_I.func_176223_P())) {
            p_180709_1_.func_180501_a(var6, Blocks.field_150330_I.func_176223_P(), 2);
         }
      }

      return true;
   }
}
