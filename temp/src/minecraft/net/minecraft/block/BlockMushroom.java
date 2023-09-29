package net.minecraft.block;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;

public class BlockMushroom extends BlockBush implements IGrowable {

   private static final String __OBFID = "CL_00000272";


   protected BlockMushroom() {
      float var1 = 0.2F;
      this.func_149676_a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var1 * 2.0F, 0.5F + var1);
      this.func_149675_a(true);
   }

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      if(p_180650_4_.nextInt(25) == 0) {
         int var5 = 5;
         boolean var6 = true;
         Iterator var7 = BlockPos.func_177975_b(p_180650_2_.func_177982_a(-4, -1, -4), p_180650_2_.func_177982_a(4, 1, 4)).iterator();

         while(var7.hasNext()) {
            BlockPos var8 = (BlockPos)var7.next();
            if(p_180650_1_.func_180495_p(var8).func_177230_c() == this) {
               --var5;
               if(var5 <= 0) {
                  return;
               }
            }
         }

         BlockPos var9 = p_180650_2_.func_177982_a(p_180650_4_.nextInt(3) - 1, p_180650_4_.nextInt(2) - p_180650_4_.nextInt(2), p_180650_4_.nextInt(3) - 1);

         for(int var10 = 0; var10 < 4; ++var10) {
            if(p_180650_1_.func_175623_d(var9) && this.func_180671_f(p_180650_1_, var9, this.func_176223_P())) {
               p_180650_2_ = var9;
            }

            var9 = p_180650_2_.func_177982_a(p_180650_4_.nextInt(3) - 1, p_180650_4_.nextInt(2) - p_180650_4_.nextInt(2), p_180650_4_.nextInt(3) - 1);
         }

         if(p_180650_1_.func_175623_d(var9) && this.func_180671_f(p_180650_1_, var9, this.func_176223_P())) {
            p_180650_1_.func_180501_a(var9, this.func_176223_P(), 2);
         }
      }

   }

   public boolean func_176196_c(World p_176196_1_, BlockPos p_176196_2_) {
      return super.func_176196_c(p_176196_1_, p_176196_2_) && this.func_180671_f(p_176196_1_, p_176196_2_, this.func_176223_P());
   }

   protected boolean func_149854_a(Block p_149854_1_) {
      return p_149854_1_.func_149730_j();
   }

   public boolean func_180671_f(World p_180671_1_, BlockPos p_180671_2_, IBlockState p_180671_3_) {
      if(p_180671_2_.func_177956_o() >= 0 && p_180671_2_.func_177956_o() < 256) {
         IBlockState var4 = p_180671_1_.func_180495_p(p_180671_2_.func_177977_b());
         return var4.func_177230_c() == Blocks.field_150391_bh?true:(var4.func_177230_c() == Blocks.field_150346_d && var4.func_177229_b(BlockDirt.field_176386_a) == BlockDirt.DirtType.PODZOL?true:p_180671_1_.func_175699_k(p_180671_2_) < 13 && this.func_149854_a(var4.func_177230_c()));
      } else {
         return false;
      }
   }

   public boolean func_176485_d(World p_176485_1_, BlockPos p_176485_2_, IBlockState p_176485_3_, Random p_176485_4_) {
      p_176485_1_.func_175698_g(p_176485_2_);
      WorldGenBigMushroom var5 = null;
      if(this == Blocks.field_150338_P) {
         var5 = new WorldGenBigMushroom(0);
      } else if(this == Blocks.field_150337_Q) {
         var5 = new WorldGenBigMushroom(1);
      }

      if(var5 != null && var5.func_180709_b(p_176485_1_, p_176485_4_, p_176485_2_)) {
         return true;
      } else {
         p_176485_1_.func_180501_a(p_176485_2_, p_176485_3_, 3);
         return false;
      }
   }

   public boolean func_176473_a(World p_176473_1_, BlockPos p_176473_2_, IBlockState p_176473_3_, boolean p_176473_4_) {
      return true;
   }

   public boolean func_180670_a(World p_180670_1_, Random p_180670_2_, BlockPos p_180670_3_, IBlockState p_180670_4_) {
      return (double)p_180670_2_.nextFloat() < 0.4D;
   }

   public void func_176474_b(World p_176474_1_, Random p_176474_2_, BlockPos p_176474_3_, IBlockState p_176474_4_) {
      this.func_176485_d(p_176474_1_, p_176474_3_, p_176474_4_, p_176474_2_);
   }
}
