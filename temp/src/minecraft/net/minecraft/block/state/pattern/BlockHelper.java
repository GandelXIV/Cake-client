package net.minecraft.block.state.pattern;

import com.google.common.base.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

public class BlockHelper implements Predicate {

   private final Block field_177644_a;
   private static final String __OBFID = "CL_00002020";


   private BlockHelper(Block p_i45654_1_) {
      this.field_177644_a = p_i45654_1_;
   }

   public static BlockHelper func_177642_a(Block p_177642_0_) {
      return new BlockHelper(p_177642_0_);
   }

   public boolean func_177643_a(IBlockState p_177643_1_) {
      return p_177643_1_ != null && p_177643_1_.func_177230_c() == this.field_177644_a;
   }

   // $FF: synthetic method
   public boolean apply(Object p_apply_1_) {
      return this.func_177643_a((IBlockState)p_apply_1_);
   }
}
