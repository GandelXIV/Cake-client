package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class BlockNetherrack extends Block {

   private static final String __OBFID = "CL_00000275";


   public BlockNetherrack() {
      super(Material.field_151576_e);
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public MapColor func_180659_g(IBlockState p_180659_1_) {
      return MapColor.field_151655_K;
   }
}
