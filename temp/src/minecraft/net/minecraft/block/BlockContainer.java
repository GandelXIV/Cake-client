package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract class BlockContainer extends Block implements ITileEntityProvider {

   private static final String __OBFID = "CL_00000193";


   protected BlockContainer(Material p_i45386_1_) {
      super(p_i45386_1_);
      this.field_149758_A = true;
   }

   public int func_149645_b() {
      return -1;
   }

   public void func_180663_b(World p_180663_1_, BlockPos p_180663_2_, IBlockState p_180663_3_) {
      super.func_180663_b(p_180663_1_, p_180663_2_, p_180663_3_);
      p_180663_1_.func_175713_t(p_180663_2_);
   }

   public boolean func_180648_a(World p_180648_1_, BlockPos p_180648_2_, IBlockState p_180648_3_, int p_180648_4_, int p_180648_5_) {
      super.func_180648_a(p_180648_1_, p_180648_2_, p_180648_3_, p_180648_4_, p_180648_5_);
      TileEntity var6 = p_180648_1_.func_175625_s(p_180648_2_);
      return var6 == null?false:var6.func_145842_c(p_180648_4_, p_180648_5_);
   }
}
