package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenGlowStone1 extends WorldGenerator {

   private static final String __OBFID = "CL_00000419";


   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      if(!p_180709_1_.func_175623_d(p_180709_3_)) {
         return false;
      } else if(p_180709_1_.func_180495_p(p_180709_3_.func_177984_a()).func_177230_c() != Blocks.field_150424_aL) {
         return false;
      } else {
         p_180709_1_.func_180501_a(p_180709_3_, Blocks.field_150426_aN.func_176223_P(), 2);

         for(int var4 = 0; var4 < 1500; ++var4) {
            BlockPos var5 = p_180709_3_.func_177982_a(p_180709_2_.nextInt(8) - p_180709_2_.nextInt(8), -p_180709_2_.nextInt(12), p_180709_2_.nextInt(8) - p_180709_2_.nextInt(8));
            if(p_180709_1_.func_180495_p(var5).func_177230_c().func_149688_o() == Material.field_151579_a) {
               int var6 = 0;
               EnumFacing[] var7 = EnumFacing.values();
               int var8 = var7.length;

               for(int var9 = 0; var9 < var8; ++var9) {
                  EnumFacing var10 = var7[var9];
                  if(p_180709_1_.func_180495_p(var5.func_177972_a(var10)).func_177230_c() == Blocks.field_150426_aN) {
                     ++var6;
                  }

                  if(var6 > 1) {
                     break;
                  }
               }

               if(var6 == 1) {
                  p_180709_1_.func_180501_a(var5, Blocks.field_150426_aN.func_176223_P(), 2);
               }
            }
         }

         return true;
      }
   }
}
