package net.minecraft.world.chunk;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

public class ChunkPrimer {

   private final short[] field_177860_a = new short[65536];
   private final IBlockState field_177859_b;
   private static final String __OBFID = "CL_00002007";


   public ChunkPrimer() {
      this.field_177859_b = Blocks.field_150350_a.func_176223_P();
   }

   public IBlockState func_177856_a(int p_177856_1_, int p_177856_2_, int p_177856_3_) {
      int var4 = p_177856_1_ << 12 | p_177856_3_ << 8 | p_177856_2_;
      return this.func_177858_a(var4);
   }

   public IBlockState func_177858_a(int p_177858_1_) {
      if(p_177858_1_ >= 0 && p_177858_1_ < this.field_177860_a.length) {
         IBlockState var2 = (IBlockState)Block.field_176229_d.func_148745_a(this.field_177860_a[p_177858_1_]);
         return var2 != null?var2:this.field_177859_b;
      } else {
         throw new IndexOutOfBoundsException("The coordinate is out of range");
      }
   }

   public void func_177855_a(int p_177855_1_, int p_177855_2_, int p_177855_3_, IBlockState p_177855_4_) {
      int var5 = p_177855_1_ << 12 | p_177855_3_ << 8 | p_177855_2_;
      this.func_177857_a(var5, p_177855_4_);
   }

   public void func_177857_a(int p_177857_1_, IBlockState p_177857_2_) {
      if(p_177857_1_ >= 0 && p_177857_1_ < this.field_177860_a.length) {
         this.field_177860_a[p_177857_1_] = (short)Block.field_176229_d.func_148747_b(p_177857_2_);
      } else {
         throw new IndexOutOfBoundsException("The coordinate is out of range");
      }
   }
}
