package net.minecraft.block;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;

public class BlockCactus extends Block {

   public static final PropertyInteger field_176587_a = PropertyInteger.func_177719_a("age", 0, 15);
   private static final String __OBFID = "CL_00000210";


   protected BlockCactus() {
      super(Material.field_151570_A);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176587_a, Integer.valueOf(0)));
      this.func_149675_a(true);
      this.func_149647_a(CreativeTabs.field_78031_c);
   }

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      BlockPos var5 = p_180650_2_.func_177984_a();
      if(p_180650_1_.func_175623_d(var5)) {
         int var6;
         for(var6 = 1; p_180650_1_.func_180495_p(p_180650_2_.func_177979_c(var6)).func_177230_c() == this; ++var6) {
            ;
         }

         if(var6 < 3) {
            int var7 = ((Integer)p_180650_3_.func_177229_b(field_176587_a)).intValue();
            if(var7 == 15) {
               p_180650_1_.func_175656_a(var5, this.func_176223_P());
               IBlockState var8 = p_180650_3_.func_177226_a(field_176587_a, Integer.valueOf(0));
               p_180650_1_.func_180501_a(p_180650_2_, var8, 4);
               this.func_176204_a(p_180650_1_, var5, var8, this);
            } else {
               p_180650_1_.func_180501_a(p_180650_2_, p_180650_3_.func_177226_a(field_176587_a, Integer.valueOf(var7 + 1)), 4);
            }

         }
      }
   }

   public AxisAlignedBB func_180640_a(World p_180640_1_, BlockPos p_180640_2_, IBlockState p_180640_3_) {
      float var4 = 0.0625F;
      return new AxisAlignedBB((double)((float)p_180640_2_.func_177958_n() + var4), (double)p_180640_2_.func_177956_o(), (double)((float)p_180640_2_.func_177952_p() + var4), (double)((float)(p_180640_2_.func_177958_n() + 1) - var4), (double)((float)(p_180640_2_.func_177956_o() + 1) - var4), (double)((float)(p_180640_2_.func_177952_p() + 1) - var4));
   }

   public AxisAlignedBB func_180646_a(World p_180646_1_, BlockPos p_180646_2_) {
      float var3 = 0.0625F;
      return new AxisAlignedBB((double)((float)p_180646_2_.func_177958_n() + var3), (double)p_180646_2_.func_177956_o(), (double)((float)p_180646_2_.func_177952_p() + var3), (double)((float)(p_180646_2_.func_177958_n() + 1) - var3), (double)(p_180646_2_.func_177956_o() + 1), (double)((float)(p_180646_2_.func_177952_p() + 1) - var3));
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_176196_c(World p_176196_1_, BlockPos p_176196_2_) {
      return super.func_176196_c(p_176196_1_, p_176196_2_)?this.func_176586_d(p_176196_1_, p_176196_2_):false;
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      if(!this.func_176586_d(p_176204_1_, p_176204_2_)) {
         p_176204_1_.func_175655_b(p_176204_2_, true);
      }

   }

   public boolean func_176586_d(World p_176586_1_, BlockPos p_176586_2_) {
      Iterator var3 = EnumFacing.Plane.HORIZONTAL.iterator();

      while(var3.hasNext()) {
         EnumFacing var4 = (EnumFacing)var3.next();
         if(p_176586_1_.func_180495_p(p_176586_2_.func_177972_a(var4)).func_177230_c().func_149688_o().func_76220_a()) {
            return false;
         }
      }

      Block var5 = p_176586_1_.func_180495_p(p_176586_2_.func_177977_b()).func_177230_c();
      return var5 == Blocks.field_150434_aF || var5 == Blocks.field_150354_m;
   }

   public void func_180634_a(World p_180634_1_, BlockPos p_180634_2_, IBlockState p_180634_3_, Entity p_180634_4_) {
      p_180634_4_.func_70097_a(DamageSource.field_76367_g, 1.0F);
   }

   public EnumWorldBlockLayer func_180664_k() {
      return EnumWorldBlockLayer.CUTOUT;
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176587_a, Integer.valueOf(p_176203_1_));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((Integer)p_176201_1_.func_177229_b(field_176587_a)).intValue();
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176587_a});
   }

}
