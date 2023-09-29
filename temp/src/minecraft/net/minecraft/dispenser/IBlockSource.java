package net.minecraft.dispenser;

import net.minecraft.block.Block;
import net.minecraft.dispenser.ILocatableSource;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;

public interface IBlockSource extends ILocatableSource {

   double func_82615_a();

   double func_82617_b();

   double func_82616_c();

   BlockPos func_180699_d();

   Block func_179316_e();

   int func_82620_h();

   TileEntity func_150835_j();
}
