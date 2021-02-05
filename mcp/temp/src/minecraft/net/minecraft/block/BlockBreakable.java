package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;

public class BlockBreakable extends Block {

   private boolean field_149996_a;
   private static final String __OBFID = "CL_00000254";


   protected BlockBreakable(Material p_i45712_1_, boolean p_i45712_2_) {
      super(p_i45712_1_);
      this.field_149996_a = p_i45712_2_;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_176225_a(IBlockAccess p_176225_1_, BlockPos p_176225_2_, EnumFacing p_176225_3_) {
      IBlockState var4 = p_176225_1_.func_180495_p(p_176225_2_);
      Block var5 = var4.func_177230_c();
      if(this == Blocks.field_150359_w || this == Blocks.field_150399_cn) {
         if(p_176225_1_.func_180495_p(p_176225_2_.func_177972_a(p_176225_3_.func_176734_d())) != var4) {
            return true;
         }

         if(var5 == this) {
            return false;
         }
      }

      return !this.field_149996_a && var5 == this?false:super.func_176225_a(p_176225_1_, p_176225_2_, p_176225_3_);
   }
}
