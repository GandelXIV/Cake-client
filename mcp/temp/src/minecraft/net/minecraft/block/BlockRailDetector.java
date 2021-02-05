package net.minecraft.block;

import com.google.common.base.Predicate;
import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityMinecartCommandBlock;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRailDetector extends BlockRailBase {

   public static final PropertyEnum field_176573_b = PropertyEnum.func_177708_a("shape", BlockRailBase.EnumRailDirection.class, new Predicate() {

      private static final String __OBFID = "CL_00002126";

      public boolean func_180344_a(BlockRailBase.EnumRailDirection p_180344_1_) {
         return p_180344_1_ != BlockRailBase.EnumRailDirection.NORTH_EAST && p_180344_1_ != BlockRailBase.EnumRailDirection.NORTH_WEST && p_180344_1_ != BlockRailBase.EnumRailDirection.SOUTH_EAST && p_180344_1_ != BlockRailBase.EnumRailDirection.SOUTH_WEST;
      }
      // $FF: synthetic method
      public boolean apply(Object p_apply_1_) {
         return this.func_180344_a((BlockRailBase.EnumRailDirection)p_apply_1_);
      }
   });
   public static final PropertyBool field_176574_M = PropertyBool.func_177716_a("powered");
   private static final String __OBFID = "CL_00000225";


   public BlockRailDetector() {
      super(true);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176574_M, Boolean.valueOf(false)).func_177226_a(field_176573_b, BlockRailBase.EnumRailDirection.NORTH_SOUTH));
      this.func_149675_a(true);
   }

   public int func_149738_a(World p_149738_1_) {
      return 20;
   }

   public boolean func_149744_f() {
      return true;
   }

   public void func_180634_a(World p_180634_1_, BlockPos p_180634_2_, IBlockState p_180634_3_, Entity p_180634_4_) {
      if(!p_180634_1_.field_72995_K) {
         if(!((Boolean)p_180634_3_.func_177229_b(field_176574_M)).booleanValue()) {
            this.func_176570_e(p_180634_1_, p_180634_2_, p_180634_3_);
         }
      }
   }

   public void func_180645_a(World p_180645_1_, BlockPos p_180645_2_, IBlockState p_180645_3_, Random p_180645_4_) {}

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      if(!p_180650_1_.field_72995_K && ((Boolean)p_180650_3_.func_177229_b(field_176574_M)).booleanValue()) {
         this.func_176570_e(p_180650_1_, p_180650_2_, p_180650_3_);
      }
   }

   public int func_180656_a(IBlockAccess p_180656_1_, BlockPos p_180656_2_, IBlockState p_180656_3_, EnumFacing p_180656_4_) {
      return ((Boolean)p_180656_3_.func_177229_b(field_176574_M)).booleanValue()?15:0;
   }

   public int func_176211_b(IBlockAccess p_176211_1_, BlockPos p_176211_2_, IBlockState p_176211_3_, EnumFacing p_176211_4_) {
      return !((Boolean)p_176211_3_.func_177229_b(field_176574_M)).booleanValue()?0:(p_176211_4_ == EnumFacing.UP?15:0);
   }

   private void func_176570_e(World p_176570_1_, BlockPos p_176570_2_, IBlockState p_176570_3_) {
      boolean var4 = ((Boolean)p_176570_3_.func_177229_b(field_176574_M)).booleanValue();
      boolean var5 = false;
      List var6 = this.func_176571_a(p_176570_1_, p_176570_2_, EntityMinecart.class, new Predicate[0]);
      if(!var6.isEmpty()) {
         var5 = true;
      }

      if(var5 && !var4) {
         p_176570_1_.func_180501_a(p_176570_2_, p_176570_3_.func_177226_a(field_176574_M, Boolean.valueOf(true)), 3);
         p_176570_1_.func_175685_c(p_176570_2_, this);
         p_176570_1_.func_175685_c(p_176570_2_.func_177977_b(), this);
         p_176570_1_.func_175704_b(p_176570_2_, p_176570_2_);
      }

      if(!var5 && var4) {
         p_176570_1_.func_180501_a(p_176570_2_, p_176570_3_.func_177226_a(field_176574_M, Boolean.valueOf(false)), 3);
         p_176570_1_.func_175685_c(p_176570_2_, this);
         p_176570_1_.func_175685_c(p_176570_2_.func_177977_b(), this);
         p_176570_1_.func_175704_b(p_176570_2_, p_176570_2_);
      }

      if(var5) {
         p_176570_1_.func_175684_a(p_176570_2_, this, this.func_149738_a(p_176570_1_));
      }

      p_176570_1_.func_175666_e(p_176570_2_, this);
   }

   public void func_176213_c(World p_176213_1_, BlockPos p_176213_2_, IBlockState p_176213_3_) {
      super.func_176213_c(p_176213_1_, p_176213_2_, p_176213_3_);
      this.func_176570_e(p_176213_1_, p_176213_2_, p_176213_3_);
   }

   public IProperty func_176560_l() {
      return field_176573_b;
   }

   public boolean func_149740_M() {
      return true;
   }

   public int func_180641_l(World p_180641_1_, BlockPos p_180641_2_) {
      if(((Boolean)p_180641_1_.func_180495_p(p_180641_2_).func_177229_b(field_176574_M)).booleanValue()) {
         List var3 = this.func_176571_a(p_180641_1_, p_180641_2_, EntityMinecartCommandBlock.class, new Predicate[0]);
         if(!var3.isEmpty()) {
            return ((EntityMinecartCommandBlock)var3.get(0)).func_145822_e().func_145760_g();
         }

         List var4 = this.func_176571_a(p_180641_1_, p_180641_2_, EntityMinecart.class, new Predicate[]{IEntitySelector.field_96566_b});
         if(!var4.isEmpty()) {
            return Container.func_94526_b((IInventory)var4.get(0));
         }
      }

      return 0;
   }

   protected List func_176571_a(World p_176571_1_, BlockPos p_176571_2_, Class p_176571_3_, Predicate ... p_176571_4_) {
      AxisAlignedBB var5 = this.func_176572_a(p_176571_2_);
      return p_176571_4_.length != 1?p_176571_1_.func_72872_a(p_176571_3_, var5):p_176571_1_.func_175647_a(p_176571_3_, var5, p_176571_4_[0]);
   }

   private AxisAlignedBB func_176572_a(BlockPos p_176572_1_) {
      float var2 = 0.2F;
      return new AxisAlignedBB((double)((float)p_176572_1_.func_177958_n() + 0.2F), (double)p_176572_1_.func_177956_o(), (double)((float)p_176572_1_.func_177952_p() + 0.2F), (double)((float)(p_176572_1_.func_177958_n() + 1) - 0.2F), (double)((float)(p_176572_1_.func_177956_o() + 1) - 0.2F), (double)((float)(p_176572_1_.func_177952_p() + 1) - 0.2F));
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176573_b, BlockRailBase.EnumRailDirection.func_177016_a(p_176203_1_ & 7)).func_177226_a(field_176574_M, Boolean.valueOf((p_176203_1_ & 8) > 0));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      byte var2 = 0;
      int var3 = var2 | ((BlockRailBase.EnumRailDirection)p_176201_1_.func_177229_b(field_176573_b)).func_177015_a();
      if(((Boolean)p_176201_1_.func_177229_b(field_176574_M)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176573_b, field_176574_M});
   }

}
