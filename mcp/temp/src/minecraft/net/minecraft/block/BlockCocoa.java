package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCocoa extends BlockDirectional implements IGrowable {

   public static final PropertyInteger field_176501_a = PropertyInteger.func_177719_a("age", 0, 2);
   private static final String __OBFID = "CL_00000216";


   public BlockCocoa() {
      super(Material.field_151585_k);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176387_N, EnumFacing.NORTH).func_177226_a(field_176501_a, Integer.valueOf(0)));
      this.func_149675_a(true);
   }

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      if(!this.func_176499_e(p_180650_1_, p_180650_2_, p_180650_3_)) {
         this.func_176500_f(p_180650_1_, p_180650_2_, p_180650_3_);
      } else if(p_180650_1_.field_73012_v.nextInt(5) == 0) {
         int var5 = ((Integer)p_180650_3_.func_177229_b(field_176501_a)).intValue();
         if(var5 < 2) {
            p_180650_1_.func_180501_a(p_180650_2_, p_180650_3_.func_177226_a(field_176501_a, Integer.valueOf(var5 + 1)), 2);
         }
      }

   }

   public boolean func_176499_e(World p_176499_1_, BlockPos p_176499_2_, IBlockState p_176499_3_) {
      p_176499_2_ = p_176499_2_.func_177972_a((EnumFacing)p_176499_3_.func_177229_b(field_176387_N));
      IBlockState var4 = p_176499_1_.func_180495_p(p_176499_2_);
      return var4.func_177230_c() == Blocks.field_150364_r && var4.func_177229_b(BlockPlanks.field_176383_a) == BlockPlanks.EnumType.JUNGLE;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public AxisAlignedBB func_180640_a(World p_180640_1_, BlockPos p_180640_2_, IBlockState p_180640_3_) {
      this.func_180654_a(p_180640_1_, p_180640_2_);
      return super.func_180640_a(p_180640_1_, p_180640_2_, p_180640_3_);
   }

   public AxisAlignedBB func_180646_a(World p_180646_1_, BlockPos p_180646_2_) {
      this.func_180654_a(p_180646_1_, p_180646_2_);
      return super.func_180646_a(p_180646_1_, p_180646_2_);
   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      IBlockState var3 = p_180654_1_.func_180495_p(p_180654_2_);
      EnumFacing var4 = (EnumFacing)var3.func_177229_b(field_176387_N);
      int var5 = ((Integer)var3.func_177229_b(field_176501_a)).intValue();
      int var6 = 4 + var5 * 2;
      int var7 = 5 + var5 * 2;
      float var8 = (float)var6 / 2.0F;
      switch(BlockCocoa.SwitchEnumFacing.field_180415_a[var4.ordinal()]) {
      case 1:
         this.func_149676_a((8.0F - var8) / 16.0F, (12.0F - (float)var7) / 16.0F, (15.0F - (float)var6) / 16.0F, (8.0F + var8) / 16.0F, 0.75F, 0.9375F);
         break;
      case 2:
         this.func_149676_a((8.0F - var8) / 16.0F, (12.0F - (float)var7) / 16.0F, 0.0625F, (8.0F + var8) / 16.0F, 0.75F, (1.0F + (float)var6) / 16.0F);
         break;
      case 3:
         this.func_149676_a(0.0625F, (12.0F - (float)var7) / 16.0F, (8.0F - var8) / 16.0F, (1.0F + (float)var6) / 16.0F, 0.75F, (8.0F + var8) / 16.0F);
         break;
      case 4:
         this.func_149676_a((15.0F - (float)var6) / 16.0F, (12.0F - (float)var7) / 16.0F, (8.0F - var8) / 16.0F, 0.9375F, 0.75F, (8.0F + var8) / 16.0F);
      }

   }

   public void func_180633_a(World p_180633_1_, BlockPos p_180633_2_, IBlockState p_180633_3_, EntityLivingBase p_180633_4_, ItemStack p_180633_5_) {
      EnumFacing var6 = EnumFacing.func_176733_a((double)p_180633_4_.field_70177_z);
      p_180633_1_.func_180501_a(p_180633_2_, p_180633_3_.func_177226_a(field_176387_N, var6), 2);
   }

   public IBlockState func_180642_a(World p_180642_1_, BlockPos p_180642_2_, EnumFacing p_180642_3_, float p_180642_4_, float p_180642_5_, float p_180642_6_, int p_180642_7_, EntityLivingBase p_180642_8_) {
      if(!p_180642_3_.func_176740_k().func_176722_c()) {
         p_180642_3_ = EnumFacing.NORTH;
      }

      return this.func_176223_P().func_177226_a(field_176387_N, p_180642_3_.func_176734_d()).func_177226_a(field_176501_a, Integer.valueOf(0));
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      if(!this.func_176499_e(p_176204_1_, p_176204_2_, p_176204_3_)) {
         this.func_176500_f(p_176204_1_, p_176204_2_, p_176204_3_);
      }

   }

   private void func_176500_f(World p_176500_1_, BlockPos p_176500_2_, IBlockState p_176500_3_) {
      p_176500_1_.func_180501_a(p_176500_2_, Blocks.field_150350_a.func_176223_P(), 3);
      this.func_176226_b(p_176500_1_, p_176500_2_, p_176500_3_, 0);
   }

   public void func_180653_a(World p_180653_1_, BlockPos p_180653_2_, IBlockState p_180653_3_, float p_180653_4_, int p_180653_5_) {
      int var6 = ((Integer)p_180653_3_.func_177229_b(field_176501_a)).intValue();
      byte var7 = 1;
      if(var6 >= 2) {
         var7 = 3;
      }

      for(int var8 = 0; var8 < var7; ++var8) {
         func_180635_a(p_180653_1_, p_180653_2_, new ItemStack(Items.field_151100_aR, 1, EnumDyeColor.BROWN.func_176767_b()));
      }

   }

   public Item func_180665_b(World p_180665_1_, BlockPos p_180665_2_) {
      return Items.field_151100_aR;
   }

   public int func_176222_j(World p_176222_1_, BlockPos p_176222_2_) {
      return EnumDyeColor.BROWN.func_176767_b();
   }

   public boolean func_176473_a(World p_176473_1_, BlockPos p_176473_2_, IBlockState p_176473_3_, boolean p_176473_4_) {
      return ((Integer)p_176473_3_.func_177229_b(field_176501_a)).intValue() < 2;
   }

   public boolean func_180670_a(World p_180670_1_, Random p_180670_2_, BlockPos p_180670_3_, IBlockState p_180670_4_) {
      return true;
   }

   public void func_176474_b(World p_176474_1_, Random p_176474_2_, BlockPos p_176474_3_, IBlockState p_176474_4_) {
      p_176474_1_.func_180501_a(p_176474_3_, p_176474_4_.func_177226_a(field_176501_a, Integer.valueOf(((Integer)p_176474_4_.func_177229_b(field_176501_a)).intValue() + 1)), 2);
   }

   public EnumWorldBlockLayer func_180664_k() {
      return EnumWorldBlockLayer.CUTOUT;
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176387_N, EnumFacing.func_176731_b(p_176203_1_)).func_177226_a(field_176501_a, Integer.valueOf((p_176203_1_ & 15) >> 2));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      byte var2 = 0;
      int var3 = var2 | ((EnumFacing)p_176201_1_.func_177229_b(field_176387_N)).func_176736_b();
      var3 |= ((Integer)p_176201_1_.func_177229_b(field_176501_a)).intValue() << 2;
      return var3;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176387_N, field_176501_a});
   }


   // $FF: synthetic class
   static final class SwitchEnumFacing {

      // $FF: synthetic field
      static final int[] field_180415_a = new int[EnumFacing.values().length];
      private static final String __OBFID = "CL_00002130";


      static {
         try {
            field_180415_a[EnumFacing.SOUTH.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_180415_a[EnumFacing.NORTH.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_180415_a[EnumFacing.WEST.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_180415_a[EnumFacing.EAST.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
