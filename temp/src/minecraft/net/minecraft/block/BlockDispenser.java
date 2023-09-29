package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockSourceImpl;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.PositionImpl;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.RegistryDefaulted;
import net.minecraft.world.World;

public class BlockDispenser extends BlockContainer {

   public static final PropertyDirection field_176441_a = PropertyDirection.func_177714_a("facing");
   public static final PropertyBool field_176440_b = PropertyBool.func_177716_a("triggered");
   public static final RegistryDefaulted field_149943_a = new RegistryDefaulted(new BehaviorDefaultDispenseItem());
   protected Random field_149942_b = new Random();
   private static final String __OBFID = "CL_00000229";


   protected BlockDispenser() {
      super(Material.field_151576_e);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176441_a, EnumFacing.NORTH).func_177226_a(field_176440_b, Boolean.valueOf(false)));
      this.func_149647_a(CreativeTabs.field_78028_d);
   }

   public int func_149738_a(World p_149738_1_) {
      return 4;
   }

   public void func_176213_c(World p_176213_1_, BlockPos p_176213_2_, IBlockState p_176213_3_) {
      super.func_176213_c(p_176213_1_, p_176213_2_, p_176213_3_);
      this.func_176438_e(p_176213_1_, p_176213_2_, p_176213_3_);
   }

   private void func_176438_e(World p_176438_1_, BlockPos p_176438_2_, IBlockState p_176438_3_) {
      if(!p_176438_1_.field_72995_K) {
         EnumFacing var4 = (EnumFacing)p_176438_3_.func_177229_b(field_176441_a);
         boolean var5 = p_176438_1_.func_180495_p(p_176438_2_.func_177978_c()).func_177230_c().func_149730_j();
         boolean var6 = p_176438_1_.func_180495_p(p_176438_2_.func_177968_d()).func_177230_c().func_149730_j();
         if(var4 == EnumFacing.NORTH && var5 && !var6) {
            var4 = EnumFacing.SOUTH;
         } else if(var4 == EnumFacing.SOUTH && var6 && !var5) {
            var4 = EnumFacing.NORTH;
         } else {
            boolean var7 = p_176438_1_.func_180495_p(p_176438_2_.func_177976_e()).func_177230_c().func_149730_j();
            boolean var8 = p_176438_1_.func_180495_p(p_176438_2_.func_177974_f()).func_177230_c().func_149730_j();
            if(var4 == EnumFacing.WEST && var7 && !var8) {
               var4 = EnumFacing.EAST;
            } else if(var4 == EnumFacing.EAST && var8 && !var7) {
               var4 = EnumFacing.WEST;
            }
         }

         p_176438_1_.func_180501_a(p_176438_2_, p_176438_3_.func_177226_a(field_176441_a, var4).func_177226_a(field_176440_b, Boolean.valueOf(false)), 2);
      }
   }

   public boolean func_180639_a(World p_180639_1_, BlockPos p_180639_2_, IBlockState p_180639_3_, EntityPlayer p_180639_4_, EnumFacing p_180639_5_, float p_180639_6_, float p_180639_7_, float p_180639_8_) {
      if(p_180639_1_.field_72995_K) {
         return true;
      } else {
         TileEntity var9 = p_180639_1_.func_175625_s(p_180639_2_);
         if(var9 instanceof TileEntityDispenser) {
            p_180639_4_.func_71007_a((TileEntityDispenser)var9);
         }

         return true;
      }
   }

   protected void func_176439_d(World p_176439_1_, BlockPos p_176439_2_) {
      BlockSourceImpl var3 = new BlockSourceImpl(p_176439_1_, p_176439_2_);
      TileEntityDispenser var4 = (TileEntityDispenser)var3.func_150835_j();
      if(var4 != null) {
         int var5 = var4.func_146017_i();
         if(var5 < 0) {
            p_176439_1_.func_175718_b(1001, p_176439_2_, 0);
         } else {
            ItemStack var6 = var4.func_70301_a(var5);
            IBehaviorDispenseItem var7 = this.func_149940_a(var6);
            if(var7 != IBehaviorDispenseItem.field_82483_a) {
               ItemStack var8 = var7.func_82482_a(var3, var6);
               var4.func_70299_a(var5, var8.field_77994_a == 0?null:var8);
            }

         }
      }
   }

   protected IBehaviorDispenseItem func_149940_a(ItemStack p_149940_1_) {
      return (IBehaviorDispenseItem)field_149943_a.func_82594_a(p_149940_1_ == null?null:p_149940_1_.func_77973_b());
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      boolean var5 = p_176204_1_.func_175640_z(p_176204_2_) || p_176204_1_.func_175640_z(p_176204_2_.func_177984_a());
      boolean var6 = ((Boolean)p_176204_3_.func_177229_b(field_176440_b)).booleanValue();
      if(var5 && !var6) {
         p_176204_1_.func_175684_a(p_176204_2_, this, this.func_149738_a(p_176204_1_));
         p_176204_1_.func_180501_a(p_176204_2_, p_176204_3_.func_177226_a(field_176440_b, Boolean.valueOf(true)), 4);
      } else if(!var5 && var6) {
         p_176204_1_.func_180501_a(p_176204_2_, p_176204_3_.func_177226_a(field_176440_b, Boolean.valueOf(false)), 4);
      }

   }

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      if(!p_180650_1_.field_72995_K) {
         this.func_176439_d(p_180650_1_, p_180650_2_);
      }

   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntityDispenser();
   }

   public IBlockState func_180642_a(World p_180642_1_, BlockPos p_180642_2_, EnumFacing p_180642_3_, float p_180642_4_, float p_180642_5_, float p_180642_6_, int p_180642_7_, EntityLivingBase p_180642_8_) {
      return this.func_176223_P().func_177226_a(field_176441_a, BlockPistonBase.func_180695_a(p_180642_1_, p_180642_2_, p_180642_8_)).func_177226_a(field_176440_b, Boolean.valueOf(false));
   }

   public void func_180633_a(World p_180633_1_, BlockPos p_180633_2_, IBlockState p_180633_3_, EntityLivingBase p_180633_4_, ItemStack p_180633_5_) {
      p_180633_1_.func_180501_a(p_180633_2_, p_180633_3_.func_177226_a(field_176441_a, BlockPistonBase.func_180695_a(p_180633_1_, p_180633_2_, p_180633_4_)), 2);
      if(p_180633_5_.func_82837_s()) {
         TileEntity var6 = p_180633_1_.func_175625_s(p_180633_2_);
         if(var6 instanceof TileEntityDispenser) {
            ((TileEntityDispenser)var6).func_146018_a(p_180633_5_.func_82833_r());
         }
      }

   }

   public void func_180663_b(World p_180663_1_, BlockPos p_180663_2_, IBlockState p_180663_3_) {
      TileEntity var4 = p_180663_1_.func_175625_s(p_180663_2_);
      if(var4 instanceof TileEntityDispenser) {
         InventoryHelper.func_180175_a(p_180663_1_, p_180663_2_, (TileEntityDispenser)var4);
         p_180663_1_.func_175666_e(p_180663_2_, this);
      }

      super.func_180663_b(p_180663_1_, p_180663_2_, p_180663_3_);
   }

   public static IPosition func_149939_a(IBlockSource p_149939_0_) {
      EnumFacing var1 = func_149937_b(p_149939_0_.func_82620_h());
      double var2 = p_149939_0_.func_82615_a() + 0.7D * (double)var1.func_82601_c();
      double var4 = p_149939_0_.func_82617_b() + 0.7D * (double)var1.func_96559_d();
      double var6 = p_149939_0_.func_82616_c() + 0.7D * (double)var1.func_82599_e();
      return new PositionImpl(var2, var4, var6);
   }

   public static EnumFacing func_149937_b(int p_149937_0_) {
      return EnumFacing.func_82600_a(p_149937_0_ & 7);
   }

   public boolean func_149740_M() {
      return true;
   }

   public int func_180641_l(World p_180641_1_, BlockPos p_180641_2_) {
      return Container.func_178144_a(p_180641_1_.func_175625_s(p_180641_2_));
   }

   public int func_149645_b() {
      return 3;
   }

   public IBlockState func_176217_b(IBlockState p_176217_1_) {
      return this.func_176223_P().func_177226_a(field_176441_a, EnumFacing.SOUTH);
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176441_a, func_149937_b(p_176203_1_)).func_177226_a(field_176440_b, Boolean.valueOf((p_176203_1_ & 8) > 0));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      byte var2 = 0;
      int var3 = var2 | ((EnumFacing)p_176201_1_.func_177229_b(field_176441_a)).func_176745_a();
      if(((Boolean)p_176201_1_.func_177229_b(field_176440_b)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176441_a, field_176440_b});
   }

}
