package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract class WorldGenerator {

   private final boolean field_76488_a;
   private static final String __OBFID = "CL_00000409";


   public WorldGenerator() {
      this(false);
   }

   public WorldGenerator(boolean p_i2013_1_) {
      this.field_76488_a = p_i2013_1_;
   }

   public abstract boolean func_180709_b(World var1, Random var2, BlockPos var3);

   public void func_175904_e() {}

   protected void func_175906_a(World p_175906_1_, BlockPos p_175906_2_, Block p_175906_3_) {
      this.func_175905_a(p_175906_1_, p_175906_2_, p_175906_3_, 0);
   }

   protected void func_175905_a(World p_175905_1_, BlockPos p_175905_2_, Block p_175905_3_, int p_175905_4_) {
      this.func_175903_a(p_175905_1_, p_175905_2_, p_175905_3_.func_176203_a(p_175905_4_));
   }

   protected void func_175903_a(World p_175903_1_, BlockPos p_175903_2_, IBlockState p_175903_3_) {
      if(this.field_76488_a) {
         p_175903_1_.func_180501_a(p_175903_2_, p_175903_3_, 3);
      } else {
         p_175903_1_.func_180501_a(p_175903_2_, p_175903_3_, 2);
      }

   }
}
