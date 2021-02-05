package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockButton extends Block {

   public static final PropertyDirection field_176585_a = PropertyDirection.func_177714_a("facing");
   public static final PropertyBool field_176584_b = PropertyBool.func_177716_a("powered");
   private final boolean field_150047_a;
   private static final String __OBFID = "CL_00000209";


   protected BlockButton(boolean p_i45396_1_) {
      super(Material.field_151594_q);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176585_a, EnumFacing.NORTH).func_177226_a(field_176584_b, Boolean.valueOf(false)));
      this.func_149675_a(true);
      this.func_149647_a(CreativeTabs.field_78028_d);
      this.field_150047_a = p_i45396_1_;
   }

   public AxisAlignedBB func_180640_a(World p_180640_1_, BlockPos p_180640_2_, IBlockState p_180640_3_) {
      return null;
   }

   public int func_149738_a(World p_149738_1_) {
      return this.field_150047_a?30:20;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_176198_a(World p_176198_1_, BlockPos p_176198_2_, EnumFacing p_176198_3_) {
      return p_176198_1_.func_180495_p(p_176198_2_.func_177972_a(p_176198_3_.func_176734_d())).func_177230_c().func_149721_r();
   }

   public boolean func_176196_c(World p_176196_1_, BlockPos p_176196_2_) {
      EnumFacing[] var3 = EnumFacing.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EnumFacing var6 = var3[var5];
         if(p_176196_1_.func_180495_p(p_176196_2_.func_177972_a(var6)).func_177230_c().func_149721_r()) {
            return true;
         }
      }

      return false;
   }

   public IBlockState func_180642_a(World p_180642_1_, BlockPos p_180642_2_, EnumFacing p_180642_3_, float p_180642_4_, float p_180642_5_, float p_180642_6_, int p_180642_7_, EntityLivingBase p_180642_8_) {
      return p_180642_1_.func_180495_p(p_180642_2_.func_177972_a(p_180642_3_.func_176734_d())).func_177230_c().func_149721_r()?this.func_176223_P().func_177226_a(field_176585_a, p_180642_3_).func_177226_a(field_176584_b, Boolean.valueOf(false)):this.func_176223_P().func_177226_a(field_176585_a, EnumFacing.DOWN).func_177226_a(field_176584_b, Boolean.valueOf(false));
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      if(this.func_176583_e(p_176204_1_, p_176204_2_, p_176204_3_)) {
         EnumFacing var5 = (EnumFacing)p_176204_3_.func_177229_b(field_176585_a);
         if(!p_176204_1_.func_180495_p(p_176204_2_.func_177972_a(var5.func_176734_d())).func_177230_c().func_149721_r()) {
            this.func_176226_b(p_176204_1_, p_176204_2_, p_176204_3_, 0);
            p_176204_1_.func_175698_g(p_176204_2_);
         }
      }

   }

   private boolean func_176583_e(World p_176583_1_, BlockPos p_176583_2_, IBlockState p_176583_3_) {
      if(!this.func_176196_c(p_176583_1_, p_176583_2_)) {
         this.func_176226_b(p_176583_1_, p_176583_2_, p_176583_3_, 0);
         p_176583_1_.func_175698_g(p_176583_2_);
         return false;
      } else {
         return true;
      }
   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      this.func_180681_d(p_180654_1_.func_180495_p(p_180654_2_));
   }

   private void func_180681_d(IBlockState p_180681_1_) {
      EnumFacing var2 = (EnumFacing)p_180681_1_.func_177229_b(field_176585_a);
      boolean var3 = ((Boolean)p_180681_1_.func_177229_b(field_176584_b)).booleanValue();
      float var4 = 0.25F;
      float var5 = 0.375F;
      float var6 = (float)(var3?1:2) / 16.0F;
      float var7 = 0.125F;
      float var8 = 0.1875F;
      switch(BlockButton.SwitchEnumFacing.field_180420_a[var2.ordinal()]) {
      case 1:
         this.func_149676_a(0.0F, 0.375F, 0.3125F, var6, 0.625F, 0.6875F);
         break;
      case 2:
         this.func_149676_a(1.0F - var6, 0.375F, 0.3125F, 1.0F, 0.625F, 0.6875F);
         break;
      case 3:
         this.func_149676_a(0.3125F, 0.375F, 0.0F, 0.6875F, 0.625F, var6);
         break;
      case 4:
         this.func_149676_a(0.3125F, 0.375F, 1.0F - var6, 0.6875F, 0.625F, 1.0F);
         break;
      case 5:
         this.func_149676_a(0.3125F, 0.0F, 0.375F, 0.6875F, 0.0F + var6, 0.625F);
         break;
      case 6:
         this.func_149676_a(0.3125F, 1.0F - var6, 0.375F, 0.6875F, 1.0F, 0.625F);
      }

   }

   public boolean func_180639_a(World p_180639_1_, BlockPos p_180639_2_, IBlockState p_180639_3_, EntityPlayer p_180639_4_, EnumFacing p_180639_5_, float p_180639_6_, float p_180639_7_, float p_180639_8_) {
      if(((Boolean)p_180639_3_.func_177229_b(field_176584_b)).booleanValue()) {
         return true;
      } else {
         p_180639_1_.func_180501_a(p_180639_2_, p_180639_3_.func_177226_a(field_176584_b, Boolean.valueOf(true)), 3);
         p_180639_1_.func_175704_b(p_180639_2_, p_180639_2_);
         p_180639_1_.func_72908_a((double)p_180639_2_.func_177958_n() + 0.5D, (double)p_180639_2_.func_177956_o() + 0.5D, (double)p_180639_2_.func_177952_p() + 0.5D, "random.click", 0.3F, 0.6F);
         this.func_176582_b(p_180639_1_, p_180639_2_, (EnumFacing)p_180639_3_.func_177229_b(field_176585_a));
         p_180639_1_.func_175684_a(p_180639_2_, this, this.func_149738_a(p_180639_1_));
         return true;
      }
   }

   public void func_180663_b(World p_180663_1_, BlockPos p_180663_2_, IBlockState p_180663_3_) {
      if(((Boolean)p_180663_3_.func_177229_b(field_176584_b)).booleanValue()) {
         this.func_176582_b(p_180663_1_, p_180663_2_, (EnumFacing)p_180663_3_.func_177229_b(field_176585_a));
      }

      super.func_180663_b(p_180663_1_, p_180663_2_, p_180663_3_);
   }

   public int func_180656_a(IBlockAccess p_180656_1_, BlockPos p_180656_2_, IBlockState p_180656_3_, EnumFacing p_180656_4_) {
      return ((Boolean)p_180656_3_.func_177229_b(field_176584_b)).booleanValue()?15:0;
   }

   public int func_176211_b(IBlockAccess p_176211_1_, BlockPos p_176211_2_, IBlockState p_176211_3_, EnumFacing p_176211_4_) {
      return !((Boolean)p_176211_3_.func_177229_b(field_176584_b)).booleanValue()?0:(p_176211_3_.func_177229_b(field_176585_a) == p_176211_4_?15:0);
   }

   public boolean func_149744_f() {
      return true;
   }

   public void func_180645_a(World p_180645_1_, BlockPos p_180645_2_, IBlockState p_180645_3_, Random p_180645_4_) {}

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      if(!p_180650_1_.field_72995_K) {
         if(((Boolean)p_180650_3_.func_177229_b(field_176584_b)).booleanValue()) {
            if(this.field_150047_a) {
               this.func_180680_f(p_180650_1_, p_180650_2_, p_180650_3_);
            } else {
               p_180650_1_.func_175656_a(p_180650_2_, p_180650_3_.func_177226_a(field_176584_b, Boolean.valueOf(false)));
               this.func_176582_b(p_180650_1_, p_180650_2_, (EnumFacing)p_180650_3_.func_177229_b(field_176585_a));
               p_180650_1_.func_72908_a((double)p_180650_2_.func_177958_n() + 0.5D, (double)p_180650_2_.func_177956_o() + 0.5D, (double)p_180650_2_.func_177952_p() + 0.5D, "random.click", 0.3F, 0.5F);
               p_180650_1_.func_175704_b(p_180650_2_, p_180650_2_);
            }

         }
      }
   }

   public void func_149683_g() {
      float var1 = 0.1875F;
      float var2 = 0.125F;
      float var3 = 0.125F;
      this.func_149676_a(0.5F - var1, 0.5F - var2, 0.5F - var3, 0.5F + var1, 0.5F + var2, 0.5F + var3);
   }

   public void func_180634_a(World p_180634_1_, BlockPos p_180634_2_, IBlockState p_180634_3_, Entity p_180634_4_) {
      if(!p_180634_1_.field_72995_K) {
         if(this.field_150047_a) {
            if(!((Boolean)p_180634_3_.func_177229_b(field_176584_b)).booleanValue()) {
               this.func_180680_f(p_180634_1_, p_180634_2_, p_180634_3_);
            }
         }
      }
   }

   private void func_180680_f(World p_180680_1_, BlockPos p_180680_2_, IBlockState p_180680_3_) {
      this.func_180681_d(p_180680_3_);
      List var4 = p_180680_1_.func_72872_a(EntityArrow.class, new AxisAlignedBB((double)p_180680_2_.func_177958_n() + this.field_149759_B, (double)p_180680_2_.func_177956_o() + this.field_149760_C, (double)p_180680_2_.func_177952_p() + this.field_149754_D, (double)p_180680_2_.func_177958_n() + this.field_149755_E, (double)p_180680_2_.func_177956_o() + this.field_149756_F, (double)p_180680_2_.func_177952_p() + this.field_149757_G));
      boolean var5 = !var4.isEmpty();
      boolean var6 = ((Boolean)p_180680_3_.func_177229_b(field_176584_b)).booleanValue();
      if(var5 && !var6) {
         p_180680_1_.func_175656_a(p_180680_2_, p_180680_3_.func_177226_a(field_176584_b, Boolean.valueOf(true)));
         this.func_176582_b(p_180680_1_, p_180680_2_, (EnumFacing)p_180680_3_.func_177229_b(field_176585_a));
         p_180680_1_.func_175704_b(p_180680_2_, p_180680_2_);
         p_180680_1_.func_72908_a((double)p_180680_2_.func_177958_n() + 0.5D, (double)p_180680_2_.func_177956_o() + 0.5D, (double)p_180680_2_.func_177952_p() + 0.5D, "random.click", 0.3F, 0.6F);
      }

      if(!var5 && var6) {
         p_180680_1_.func_175656_a(p_180680_2_, p_180680_3_.func_177226_a(field_176584_b, Boolean.valueOf(false)));
         this.func_176582_b(p_180680_1_, p_180680_2_, (EnumFacing)p_180680_3_.func_177229_b(field_176585_a));
         p_180680_1_.func_175704_b(p_180680_2_, p_180680_2_);
         p_180680_1_.func_72908_a((double)p_180680_2_.func_177958_n() + 0.5D, (double)p_180680_2_.func_177956_o() + 0.5D, (double)p_180680_2_.func_177952_p() + 0.5D, "random.click", 0.3F, 0.5F);
      }

      if(var5) {
         p_180680_1_.func_175684_a(p_180680_2_, this, this.func_149738_a(p_180680_1_));
      }

   }

   private void func_176582_b(World p_176582_1_, BlockPos p_176582_2_, EnumFacing p_176582_3_) {
      p_176582_1_.func_175685_c(p_176582_2_, this);
      p_176582_1_.func_175685_c(p_176582_2_.func_177972_a(p_176582_3_.func_176734_d()), this);
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      EnumFacing var2;
      switch(p_176203_1_ & 7) {
      case 0:
         var2 = EnumFacing.DOWN;
         break;
      case 1:
         var2 = EnumFacing.EAST;
         break;
      case 2:
         var2 = EnumFacing.WEST;
         break;
      case 3:
         var2 = EnumFacing.SOUTH;
         break;
      case 4:
         var2 = EnumFacing.NORTH;
         break;
      case 5:
      default:
         var2 = EnumFacing.UP;
      }

      return this.func_176223_P().func_177226_a(field_176585_a, var2).func_177226_a(field_176584_b, Boolean.valueOf((p_176203_1_ & 8) > 0));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      int var2;
      switch(BlockButton.SwitchEnumFacing.field_180420_a[((EnumFacing)p_176201_1_.func_177229_b(field_176585_a)).ordinal()]) {
      case 1:
         var2 = 1;
         break;
      case 2:
         var2 = 2;
         break;
      case 3:
         var2 = 3;
         break;
      case 4:
         var2 = 4;
         break;
      case 5:
      default:
         var2 = 5;
         break;
      case 6:
         var2 = 0;
      }

      if(((Boolean)p_176201_1_.func_177229_b(field_176584_b)).booleanValue()) {
         var2 |= 8;
      }

      return var2;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176585_a, field_176584_b});
   }


   // $FF: synthetic class
   static final class SwitchEnumFacing {

      // $FF: synthetic field
      static final int[] field_180420_a = new int[EnumFacing.values().length];
      private static final String __OBFID = "CL_00002131";


      static {
         try {
            field_180420_a[EnumFacing.EAST.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            field_180420_a[EnumFacing.WEST.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            field_180420_a[EnumFacing.SOUTH.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_180420_a[EnumFacing.NORTH.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_180420_a[EnumFacing.UP.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_180420_a[EnumFacing.DOWN.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
