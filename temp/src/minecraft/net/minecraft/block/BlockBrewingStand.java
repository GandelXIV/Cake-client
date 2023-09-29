package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;

public class BlockBrewingStand extends BlockContainer {

   public static final PropertyBool[] field_176451_a = new PropertyBool[]{PropertyBool.func_177716_a("has_bottle_0"), PropertyBool.func_177716_a("has_bottle_1"), PropertyBool.func_177716_a("has_bottle_2")};
   private final Random field_149961_a = new Random();
   private static final String __OBFID = "CL_00000207";


   public BlockBrewingStand() {
      super(Material.field_151573_f);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176451_a[0], Boolean.valueOf(false)).func_177226_a(field_176451_a[1], Boolean.valueOf(false)).func_177226_a(field_176451_a[2], Boolean.valueOf(false)));
   }

   public boolean func_149662_c() {
      return false;
   }

   public int func_149645_b() {
      return 3;
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntityBrewingStand();
   }

   public boolean func_149686_d() {
      return false;
   }

   public void func_180638_a(World p_180638_1_, BlockPos p_180638_2_, IBlockState p_180638_3_, AxisAlignedBB p_180638_4_, List p_180638_5_, Entity p_180638_6_) {
      this.func_149676_a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
      super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
      this.func_149683_g();
      super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
   }

   public void func_149683_g() {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
   }

   public boolean func_180639_a(World p_180639_1_, BlockPos p_180639_2_, IBlockState p_180639_3_, EntityPlayer p_180639_4_, EnumFacing p_180639_5_, float p_180639_6_, float p_180639_7_, float p_180639_8_) {
      if(p_180639_1_.field_72995_K) {
         return true;
      } else {
         TileEntity var9 = p_180639_1_.func_175625_s(p_180639_2_);
         if(var9 instanceof TileEntityBrewingStand) {
            p_180639_4_.func_71007_a((TileEntityBrewingStand)var9);
         }

         return true;
      }
   }

   public void func_180633_a(World p_180633_1_, BlockPos p_180633_2_, IBlockState p_180633_3_, EntityLivingBase p_180633_4_, ItemStack p_180633_5_) {
      if(p_180633_5_.func_82837_s()) {
         TileEntity var6 = p_180633_1_.func_175625_s(p_180633_2_);
         if(var6 instanceof TileEntityBrewingStand) {
            ((TileEntityBrewingStand)var6).func_145937_a(p_180633_5_.func_82833_r());
         }
      }

   }

   public void func_180655_c(World p_180655_1_, BlockPos p_180655_2_, IBlockState p_180655_3_, Random p_180655_4_) {
      double var5 = (double)((float)p_180655_2_.func_177958_n() + 0.4F + p_180655_4_.nextFloat() * 0.2F);
      double var7 = (double)((float)p_180655_2_.func_177956_o() + 0.7F + p_180655_4_.nextFloat() * 0.3F);
      double var9 = (double)((float)p_180655_2_.func_177952_p() + 0.4F + p_180655_4_.nextFloat() * 0.2F);
      p_180655_1_.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, var5, var7, var9, 0.0D, 0.0D, 0.0D, new int[0]);
   }

   public void func_180663_b(World p_180663_1_, BlockPos p_180663_2_, IBlockState p_180663_3_) {
      TileEntity var4 = p_180663_1_.func_175625_s(p_180663_2_);
      if(var4 instanceof TileEntityBrewingStand) {
         InventoryHelper.func_180175_a(p_180663_1_, p_180663_2_, (TileEntityBrewingStand)var4);
      }

      super.func_180663_b(p_180663_1_, p_180663_2_, p_180663_3_);
   }

   public Item func_180660_a(IBlockState p_180660_1_, Random p_180660_2_, int p_180660_3_) {
      return Items.field_151067_bt;
   }

   public Item func_180665_b(World p_180665_1_, BlockPos p_180665_2_) {
      return Items.field_151067_bt;
   }

   public boolean func_149740_M() {
      return true;
   }

   public int func_180641_l(World p_180641_1_, BlockPos p_180641_2_) {
      return Container.func_178144_a(p_180641_1_.func_175625_s(p_180641_2_));
   }

   public EnumWorldBlockLayer func_180664_k() {
      return EnumWorldBlockLayer.CUTOUT;
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      IBlockState var2 = this.func_176223_P();

      for(int var3 = 0; var3 < 3; ++var3) {
         var2 = var2.func_177226_a(field_176451_a[var3], Boolean.valueOf((p_176203_1_ & 1 << var3) > 0));
      }

      return var2;
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      int var2 = 0;

      for(int var3 = 0; var3 < 3; ++var3) {
         if(((Boolean)p_176201_1_.func_177229_b(field_176451_a[var3])).booleanValue()) {
            var2 |= 1 << var3;
         }
      }

      return var2;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176451_a[0], field_176451_a[1], field_176451_a[2]});
   }

}
