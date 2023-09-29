package net.minecraft.block;

import net.minecraft.block.BlockCompressed;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;

public class BlockCompressedPowered extends BlockCompressed {

   private static final String __OBFID = "CL_00000287";


   public BlockCompressedPowered(MapColor p_i45416_1_) {
      super(p_i45416_1_);
      this.func_149647_a(CreativeTabs.field_78028_d);
   }

   public boolean func_149744_f() {
      return true;
   }

   public int func_180656_a(IBlockAccess p_180656_1_, BlockPos p_180656_2_, IBlockState p_180656_3_, EnumFacing p_180656_4_) {
      return 15;
   }
}
