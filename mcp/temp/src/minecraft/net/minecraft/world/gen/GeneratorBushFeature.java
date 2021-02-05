package net.minecraft.world.gen;

import java.util.Random;
import net.minecraft.block.BlockBush;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GeneratorBushFeature extends WorldGenerator {

   private BlockBush field_175908_a;
   private static final String __OBFID = "CL_00002000";


   public GeneratorBushFeature(BlockBush p_i45633_1_) {
      this.field_175908_a = p_i45633_1_;
   }

   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      for(int var4 = 0; var4 < 64; ++var4) {
         BlockPos var5 = p_180709_3_.func_177982_a(p_180709_2_.nextInt(8) - p_180709_2_.nextInt(8), p_180709_2_.nextInt(4) - p_180709_2_.nextInt(4), p_180709_2_.nextInt(8) - p_180709_2_.nextInt(8));
         if(p_180709_1_.func_175623_d(var5) && (!p_180709_1_.field_73011_w.func_177495_o() || var5.func_177956_o() < 255) && this.field_175908_a.func_180671_f(p_180709_1_, var5, this.field_175908_a.func_176223_P())) {
            p_180709_1_.func_180501_a(var5, this.field_175908_a.func_176223_P(), 2);
         }
      }

      return true;
   }
}
