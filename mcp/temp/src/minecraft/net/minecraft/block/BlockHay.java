package net.minecraft.block;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockHay extends BlockRotatedPillar {

   private static final String __OBFID = "CL_00000256";


   public BlockHay() {
      super(Material.field_151577_b);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176298_M, EnumFacing.Axis.Y));
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      EnumFacing.Axis var2 = EnumFacing.Axis.Y;
      int var3 = p_176203_1_ & 12;
      if(var3 == 4) {
         var2 = EnumFacing.Axis.X;
      } else if(var3 == 8) {
         var2 = EnumFacing.Axis.Z;
      }

      return this.func_176223_P().func_177226_a(field_176298_M, var2);
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      int var2 = 0;
      EnumFacing.Axis var3 = (EnumFacing.Axis)p_176201_1_.func_177229_b(field_176298_M);
      if(var3 == EnumFacing.Axis.X) {
         var2 |= 4;
      } else if(var3 == EnumFacing.Axis.Z) {
         var2 |= 8;
      }

      return var2;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176298_M});
   }

   protected ItemStack func_180643_i(IBlockState p_180643_1_) {
      return new ItemStack(Item.func_150898_a(this), 1, 0);
   }

   public IBlockState func_180642_a(World p_180642_1_, BlockPos p_180642_2_, EnumFacing p_180642_3_, float p_180642_4_, float p_180642_5_, float p_180642_6_, int p_180642_7_, EntityLivingBase p_180642_8_) {
      return super.func_180642_a(p_180642_1_, p_180642_2_, p_180642_3_, p_180642_4_, p_180642_5_, p_180642_6_, p_180642_7_, p_180642_8_).func_177226_a(field_176298_M, p_180642_3_.func_176740_k());
   }
}
