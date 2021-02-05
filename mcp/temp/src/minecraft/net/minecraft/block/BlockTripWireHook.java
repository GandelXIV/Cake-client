package net.minecraft.block;

import com.google.common.base.Objects;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTripWire;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTripWireHook extends Block {

   public static final PropertyDirection field_176264_a = PropertyDirection.func_177712_a("facing", EnumFacing.Plane.HORIZONTAL);
   public static final PropertyBool field_176263_b = PropertyBool.func_177716_a("powered");
   public static final PropertyBool field_176265_M = PropertyBool.func_177716_a("attached");
   public static final PropertyBool field_176266_N = PropertyBool.func_177716_a("suspended");
   private static final String __OBFID = "CL_00000329";


   public BlockTripWireHook() {
      super(Material.field_151594_q);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176264_a, EnumFacing.NORTH).func_177226_a(field_176263_b, Boolean.valueOf(false)).func_177226_a(field_176265_M, Boolean.valueOf(false)).func_177226_a(field_176266_N, Boolean.valueOf(false)));
      this.func_149647_a(CreativeTabs.field_78028_d);
      this.func_149675_a(true);
   }

   public IBlockState func_176221_a(IBlockState p_176221_1_, IBlockAccess p_176221_2_, BlockPos p_176221_3_) {
      return p_176221_1_.func_177226_a(field_176266_N, Boolean.valueOf(!World.func_175683_a(p_176221_2_, p_176221_3_.func_177977_b())));
   }

   public AxisAlignedBB func_180640_a(World p_180640_1_, BlockPos p_180640_2_, IBlockState p_180640_3_) {
      return null;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_176198_a(World p_176198_1_, BlockPos p_176198_2_, EnumFacing p_176198_3_) {
      return p_176198_3_.func_176740_k().func_176722_c() && p_176198_1_.func_180495_p(p_176198_2_.func_177972_a(p_176198_3_.func_176734_d())).func_177230_c().func_149721_r();
   }

   public boolean func_176196_c(World p_176196_1_, BlockPos p_176196_2_) {
      Iterator var3 = EnumFacing.Plane.HORIZONTAL.iterator();

      EnumFacing var4;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         var4 = (EnumFacing)var3.next();
      } while(!p_176196_1_.func_180495_p(p_176196_2_.func_177972_a(var4)).func_177230_c().func_149721_r());

      return true;
   }

   public IBlockState func_180642_a(World p_180642_1_, BlockPos p_180642_2_, EnumFacing p_180642_3_, float p_180642_4_, float p_180642_5_, float p_180642_6_, int p_180642_7_, EntityLivingBase p_180642_8_) {
      IBlockState var9 = this.func_176223_P().func_177226_a(field_176263_b, Boolean.valueOf(false)).func_177226_a(field_176265_M, Boolean.valueOf(false)).func_177226_a(field_176266_N, Boolean.valueOf(false));
      if(p_180642_3_.func_176740_k().func_176722_c()) {
         var9 = var9.func_177226_a(field_176264_a, p_180642_3_);
      }

      return var9;
   }

   public void func_180633_a(World p_180633_1_, BlockPos p_180633_2_, IBlockState p_180633_3_, EntityLivingBase p_180633_4_, ItemStack p_180633_5_) {
      this.func_176260_a(p_180633_1_, p_180633_2_, p_180633_3_, false, false, -1, (IBlockState)null);
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      if(p_176204_4_ != this) {
         if(this.func_176261_e(p_176204_1_, p_176204_2_, p_176204_3_)) {
            EnumFacing var5 = (EnumFacing)p_176204_3_.func_177229_b(field_176264_a);
            if(!p_176204_1_.func_180495_p(p_176204_2_.func_177972_a(var5.func_176734_d())).func_177230_c().func_149721_r()) {
               this.func_176226_b(p_176204_1_, p_176204_2_, p_176204_3_, 0);
               p_176204_1_.func_175698_g(p_176204_2_);
            }
         }

      }
   }

   public void func_176260_a(World p_176260_1_, BlockPos p_176260_2_, IBlockState p_176260_3_, boolean p_176260_4_, boolean p_176260_5_, int p_176260_6_, IBlockState p_176260_7_) {
      EnumFacing var8 = (EnumFacing)p_176260_3_.func_177229_b(field_176264_a);
      boolean var9 = ((Boolean)p_176260_3_.func_177229_b(field_176265_M)).booleanValue();
      boolean var10 = ((Boolean)p_176260_3_.func_177229_b(field_176263_b)).booleanValue();
      boolean var11 = !World.func_175683_a(p_176260_1_, p_176260_2_.func_177977_b());
      boolean var12 = !p_176260_4_;
      boolean var13 = false;
      int var14 = 0;
      IBlockState[] var15 = new IBlockState[42];

      BlockPos var17;
      for(int var16 = 1; var16 < 42; ++var16) {
         var17 = p_176260_2_.func_177967_a(var8, var16);
         IBlockState var18 = p_176260_1_.func_180495_p(var17);
         if(var18.func_177230_c() == Blocks.field_150479_bC) {
            if(var18.func_177229_b(field_176264_a) == var8.func_176734_d()) {
               var14 = var16;
            }
            break;
         }

         if(var18.func_177230_c() != Blocks.field_150473_bD && var16 != p_176260_6_) {
            var15[var16] = null;
            var12 = false;
         } else {
            if(var16 == p_176260_6_) {
               var18 = (IBlockState)Objects.firstNonNull(p_176260_7_, var18);
            }

            boolean var19 = !((Boolean)var18.func_177229_b(BlockTripWire.field_176295_N)).booleanValue();
            boolean var20 = ((Boolean)var18.func_177229_b(BlockTripWire.field_176293_a)).booleanValue();
            boolean var21 = ((Boolean)var18.func_177229_b(BlockTripWire.field_176290_b)).booleanValue();
            var12 &= var21 == var11;
            var13 |= var19 && var20;
            var15[var16] = var18;
            if(var16 == p_176260_6_) {
               p_176260_1_.func_175684_a(p_176260_2_, this, this.func_149738_a(p_176260_1_));
               var12 &= var19;
            }
         }
      }

      var12 &= var14 > 1;
      var13 &= var12;
      IBlockState var22 = this.func_176223_P().func_177226_a(field_176265_M, Boolean.valueOf(var12)).func_177226_a(field_176263_b, Boolean.valueOf(var13));
      if(var14 > 0) {
         var17 = p_176260_2_.func_177967_a(var8, var14);
         EnumFacing var24 = var8.func_176734_d();
         p_176260_1_.func_180501_a(var17, var22.func_177226_a(field_176264_a, var24), 3);
         this.func_176262_b(p_176260_1_, var17, var24);
         this.func_180694_a(p_176260_1_, var17, var12, var13, var9, var10);
      }

      this.func_180694_a(p_176260_1_, p_176260_2_, var12, var13, var9, var10);
      if(!p_176260_4_) {
         p_176260_1_.func_180501_a(p_176260_2_, var22.func_177226_a(field_176264_a, var8), 3);
         if(p_176260_5_) {
            this.func_176262_b(p_176260_1_, p_176260_2_, var8);
         }
      }

      if(var9 != var12) {
         for(int var23 = 1; var23 < var14; ++var23) {
            BlockPos var25 = p_176260_2_.func_177967_a(var8, var23);
            IBlockState var26 = var15[var23];
            if(var26 != null && p_176260_1_.func_180495_p(var25).func_177230_c() != Blocks.field_150350_a) {
               p_176260_1_.func_180501_a(var25, var26.func_177226_a(field_176265_M, Boolean.valueOf(var12)), 3);
            }
         }
      }

   }

   public void func_180645_a(World p_180645_1_, BlockPos p_180645_2_, IBlockState p_180645_3_, Random p_180645_4_) {}

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      this.func_176260_a(p_180650_1_, p_180650_2_, p_180650_3_, false, true, -1, (IBlockState)null);
   }

   private void func_180694_a(World p_180694_1_, BlockPos p_180694_2_, boolean p_180694_3_, boolean p_180694_4_, boolean p_180694_5_, boolean p_180694_6_) {
      if(p_180694_4_ && !p_180694_6_) {
         p_180694_1_.func_72908_a((double)p_180694_2_.func_177958_n() + 0.5D, (double)p_180694_2_.func_177956_o() + 0.1D, (double)p_180694_2_.func_177952_p() + 0.5D, "random.click", 0.4F, 0.6F);
      } else if(!p_180694_4_ && p_180694_6_) {
         p_180694_1_.func_72908_a((double)p_180694_2_.func_177958_n() + 0.5D, (double)p_180694_2_.func_177956_o() + 0.1D, (double)p_180694_2_.func_177952_p() + 0.5D, "random.click", 0.4F, 0.5F);
      } else if(p_180694_3_ && !p_180694_5_) {
         p_180694_1_.func_72908_a((double)p_180694_2_.func_177958_n() + 0.5D, (double)p_180694_2_.func_177956_o() + 0.1D, (double)p_180694_2_.func_177952_p() + 0.5D, "random.click", 0.4F, 0.7F);
      } else if(!p_180694_3_ && p_180694_5_) {
         p_180694_1_.func_72908_a((double)p_180694_2_.func_177958_n() + 0.5D, (double)p_180694_2_.func_177956_o() + 0.1D, (double)p_180694_2_.func_177952_p() + 0.5D, "random.bowhit", 0.4F, 1.2F / (p_180694_1_.field_73012_v.nextFloat() * 0.2F + 0.9F));
      }

   }

   private void func_176262_b(World p_176262_1_, BlockPos p_176262_2_, EnumFacing p_176262_3_) {
      p_176262_1_.func_175685_c(p_176262_2_, this);
      p_176262_1_.func_175685_c(p_176262_2_.func_177972_a(p_176262_3_.func_176734_d()), this);
   }

   private boolean func_176261_e(World p_176261_1_, BlockPos p_176261_2_, IBlockState p_176261_3_) {
      if(!this.func_176196_c(p_176261_1_, p_176261_2_)) {
         this.func_176226_b(p_176261_1_, p_176261_2_, p_176261_3_, 0);
         p_176261_1_.func_175698_g(p_176261_2_);
         return false;
      } else {
         return true;
      }
   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      float var3 = 0.1875F;
      switch(BlockTripWireHook.SwitchEnumFacing.field_177056_a[((EnumFacing)p_180654_1_.func_180495_p(p_180654_2_).func_177229_b(field_176264_a)).ordinal()]) {
      case 1:
         this.func_149676_a(0.0F, 0.2F, 0.5F - var3, var3 * 2.0F, 0.8F, 0.5F + var3);
         break;
      case 2:
         this.func_149676_a(1.0F - var3 * 2.0F, 0.2F, 0.5F - var3, 1.0F, 0.8F, 0.5F + var3);
         break;
      case 3:
         this.func_149676_a(0.5F - var3, 0.2F, 0.0F, 0.5F + var3, 0.8F, var3 * 2.0F);
         break;
      case 4:
         this.func_149676_a(0.5F - var3, 0.2F, 1.0F - var3 * 2.0F, 0.5F + var3, 0.8F, 1.0F);
      }

   }

   public void func_180663_b(World p_180663_1_, BlockPos p_180663_2_, IBlockState p_180663_3_) {
      boolean var4 = ((Boolean)p_180663_3_.func_177229_b(field_176265_M)).booleanValue();
      boolean var5 = ((Boolean)p_180663_3_.func_177229_b(field_176263_b)).booleanValue();
      if(var4 || var5) {
         this.func_176260_a(p_180663_1_, p_180663_2_, p_180663_3_, true, false, -1, (IBlockState)null);
      }

      if(var5) {
         p_180663_1_.func_175685_c(p_180663_2_, this);
         p_180663_1_.func_175685_c(p_180663_2_.func_177972_a(((EnumFacing)p_180663_3_.func_177229_b(field_176264_a)).func_176734_d()), this);
      }

      super.func_180663_b(p_180663_1_, p_180663_2_, p_180663_3_);
   }

   public int func_180656_a(IBlockAccess p_180656_1_, BlockPos p_180656_2_, IBlockState p_180656_3_, EnumFacing p_180656_4_) {
      return ((Boolean)p_180656_3_.func_177229_b(field_176263_b)).booleanValue()?15:0;
   }

   public int func_176211_b(IBlockAccess p_176211_1_, BlockPos p_176211_2_, IBlockState p_176211_3_, EnumFacing p_176211_4_) {
      return !((Boolean)p_176211_3_.func_177229_b(field_176263_b)).booleanValue()?0:(p_176211_3_.func_177229_b(field_176264_a) == p_176211_4_?15:0);
   }

   public boolean func_149744_f() {
      return true;
   }

   public EnumWorldBlockLayer func_180664_k() {
      return EnumWorldBlockLayer.CUTOUT_MIPPED;
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176264_a, EnumFacing.func_176731_b(p_176203_1_ & 3)).func_177226_a(field_176263_b, Boolean.valueOf((p_176203_1_ & 8) > 0)).func_177226_a(field_176265_M, Boolean.valueOf((p_176203_1_ & 4) > 0));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      byte var2 = 0;
      int var3 = var2 | ((EnumFacing)p_176201_1_.func_177229_b(field_176264_a)).func_176736_b();
      if(((Boolean)p_176201_1_.func_177229_b(field_176263_b)).booleanValue()) {
         var3 |= 8;
      }

      if(((Boolean)p_176201_1_.func_177229_b(field_176265_M)).booleanValue()) {
         var3 |= 4;
      }

      return var3;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176264_a, field_176263_b, field_176265_M, field_176266_N});
   }


   // $FF: synthetic class
   static final class SwitchEnumFacing {

      // $FF: synthetic field
      static final int[] field_177056_a = new int[EnumFacing.values().length];
      private static final String __OBFID = "CL_00002050";


      static {
         try {
            field_177056_a[EnumFacing.EAST.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_177056_a[EnumFacing.WEST.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_177056_a[EnumFacing.SOUTH.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_177056_a[EnumFacing.NORTH.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
