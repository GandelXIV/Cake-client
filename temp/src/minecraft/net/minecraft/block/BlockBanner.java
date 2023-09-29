package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBanner extends BlockContainer {

   public static final PropertyDirection field_176449_a = PropertyDirection.func_177712_a("facing", EnumFacing.Plane.HORIZONTAL);
   public static final PropertyInteger field_176448_b = PropertyInteger.func_177719_a("rotation", 0, 15);
   private static final String __OBFID = "CL_00002143";


   protected BlockBanner() {
      super(Material.field_151575_d);
      float var1 = 0.25F;
      float var2 = 1.0F;
      this.func_149676_a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
   }

   public AxisAlignedBB func_180640_a(World p_180640_1_, BlockPos p_180640_2_, IBlockState p_180640_3_) {
      return null;
   }

   public AxisAlignedBB func_180646_a(World p_180646_1_, BlockPos p_180646_2_) {
      this.func_180654_a(p_180646_1_, p_180646_2_);
      return super.func_180646_a(p_180646_1_, p_180646_2_);
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_176205_b(IBlockAccess p_176205_1_, BlockPos p_176205_2_) {
      return true;
   }

   public boolean func_149662_c() {
      return false;
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntityBanner();
   }

   public Item func_180660_a(IBlockState p_180660_1_, Random p_180660_2_, int p_180660_3_) {
      return Items.field_179564_cE;
   }

   public Item func_180665_b(World p_180665_1_, BlockPos p_180665_2_) {
      return Items.field_179564_cE;
   }

   public void func_180653_a(World p_180653_1_, BlockPos p_180653_2_, IBlockState p_180653_3_, float p_180653_4_, int p_180653_5_) {
      TileEntity var6 = p_180653_1_.func_175625_s(p_180653_2_);
      if(var6 instanceof TileEntityBanner) {
         ItemStack var7 = new ItemStack(Items.field_179564_cE, 1, ((TileEntityBanner)var6).func_175115_b());
         NBTTagCompound var8 = new NBTTagCompound();
         var6.func_145841_b(var8);
         var8.func_82580_o("x");
         var8.func_82580_o("y");
         var8.func_82580_o("z");
         var8.func_82580_o("id");
         var7.func_77983_a("BlockEntityTag", var8);
         func_180635_a(p_180653_1_, p_180653_2_, var7);
      } else {
         super.func_180653_a(p_180653_1_, p_180653_2_, p_180653_3_, p_180653_4_, p_180653_5_);
      }

   }

   public void func_180657_a(World p_180657_1_, EntityPlayer p_180657_2_, BlockPos p_180657_3_, IBlockState p_180657_4_, TileEntity p_180657_5_) {
      if(p_180657_5_ instanceof TileEntityBanner) {
         ItemStack var6 = new ItemStack(Items.field_179564_cE, 1, ((TileEntityBanner)p_180657_5_).func_175115_b());
         NBTTagCompound var7 = new NBTTagCompound();
         p_180657_5_.func_145841_b(var7);
         var7.func_82580_o("x");
         var7.func_82580_o("y");
         var7.func_82580_o("z");
         var7.func_82580_o("id");
         var6.func_77983_a("BlockEntityTag", var7);
         func_180635_a(p_180657_1_, p_180657_3_, var6);
      } else {
         super.func_180657_a(p_180657_1_, p_180657_2_, p_180657_3_, p_180657_4_, (TileEntity)null);
      }

   }


   public static class BlockBannerHanging extends BlockBanner {

      private static final String __OBFID = "CL_00002140";


      public BlockBannerHanging() {
         this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176449_a, EnumFacing.NORTH));
      }

      public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
         EnumFacing var3 = (EnumFacing)p_180654_1_.func_180495_p(p_180654_2_).func_177229_b(field_176449_a);
         float var4 = 0.0F;
         float var5 = 0.78125F;
         float var6 = 0.0F;
         float var7 = 1.0F;
         float var8 = 0.125F;
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         switch(BlockBanner.SwitchEnumFacing.field_180370_a[var3.ordinal()]) {
         case 1:
         default:
            this.func_149676_a(var6, var4, 1.0F - var8, var7, var5, 1.0F);
            break;
         case 2:
            this.func_149676_a(var6, var4, 0.0F, var7, var5, var8);
            break;
         case 3:
            this.func_149676_a(1.0F - var8, var4, var6, 1.0F, var5, var7);
            break;
         case 4:
            this.func_149676_a(0.0F, var4, var6, var8, var5, var7);
         }

      }

      public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
         EnumFacing var5 = (EnumFacing)p_176204_3_.func_177229_b(field_176449_a);
         if(!p_176204_1_.func_180495_p(p_176204_2_.func_177972_a(var5.func_176734_d())).func_177230_c().func_149688_o().func_76220_a()) {
            this.func_176226_b(p_176204_1_, p_176204_2_, p_176204_3_, 0);
            p_176204_1_.func_175698_g(p_176204_2_);
         }

         super.func_176204_a(p_176204_1_, p_176204_2_, p_176204_3_, p_176204_4_);
      }

      public IBlockState func_176203_a(int p_176203_1_) {
         EnumFacing var2 = EnumFacing.func_82600_a(p_176203_1_);
         if(var2.func_176740_k() == EnumFacing.Axis.Y) {
            var2 = EnumFacing.NORTH;
         }

         return this.func_176223_P().func_177226_a(field_176449_a, var2);
      }

      public int func_176201_c(IBlockState p_176201_1_) {
         return ((EnumFacing)p_176201_1_.func_177229_b(field_176449_a)).func_176745_a();
      }

      protected BlockState func_180661_e() {
         return new BlockState(this, new IProperty[]{field_176449_a});
      }
   }

   public static class BlockBannerStanding extends BlockBanner {

      private static final String __OBFID = "CL_00002141";


      public BlockBannerStanding() {
         this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176448_b, Integer.valueOf(0)));
      }

      public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
         if(!p_176204_1_.func_180495_p(p_176204_2_.func_177977_b()).func_177230_c().func_149688_o().func_76220_a()) {
            this.func_176226_b(p_176204_1_, p_176204_2_, p_176204_3_, 0);
            p_176204_1_.func_175698_g(p_176204_2_);
         }

         super.func_176204_a(p_176204_1_, p_176204_2_, p_176204_3_, p_176204_4_);
      }

      public IBlockState func_176203_a(int p_176203_1_) {
         return this.func_176223_P().func_177226_a(field_176448_b, Integer.valueOf(p_176203_1_));
      }

      public int func_176201_c(IBlockState p_176201_1_) {
         return ((Integer)p_176201_1_.func_177229_b(field_176448_b)).intValue();
      }

      protected BlockState func_180661_e() {
         return new BlockState(this, new IProperty[]{field_176448_b});
      }
   }

   // $FF: synthetic class
   static final class SwitchEnumFacing {

      // $FF: synthetic field
      static final int[] field_180370_a = new int[EnumFacing.values().length];
      private static final String __OBFID = "CL_00002142";


      static {
         try {
            field_180370_a[EnumFacing.NORTH.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_180370_a[EnumFacing.SOUTH.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_180370_a[EnumFacing.WEST.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_180370_a[EnumFacing.EAST.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
