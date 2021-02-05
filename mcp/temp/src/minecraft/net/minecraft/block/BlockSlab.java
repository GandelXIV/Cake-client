package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockSlab extends Block {

   public static final PropertyEnum field_176554_a = PropertyEnum.func_177709_a("half", BlockSlab.EnumBlockHalf.class);
   private static final String __OBFID = "CL_00000253";


   public BlockSlab(Material p_i45714_1_) {
      super(p_i45714_1_);
      if(this.func_176552_j()) {
         this.field_149787_q = true;
      } else {
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

      this.func_149713_g(255);
   }

   protected boolean func_149700_E() {
      return false;
   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      if(this.func_176552_j()) {
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         IBlockState var3 = p_180654_1_.func_180495_p(p_180654_2_);
         if(var3.func_177230_c() == this) {
            if(var3.func_177229_b(field_176554_a) == BlockSlab.EnumBlockHalf.TOP) {
               this.func_149676_a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
            } else {
               this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            }
         }

      }
   }

   public void func_149683_g() {
      if(this.func_176552_j()) {
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

   }

   public void func_180638_a(World p_180638_1_, BlockPos p_180638_2_, IBlockState p_180638_3_, AxisAlignedBB p_180638_4_, List p_180638_5_, Entity p_180638_6_) {
      this.func_180654_a(p_180638_1_, p_180638_2_);
      super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
   }

   public boolean func_149662_c() {
      return this.func_176552_j();
   }

   public IBlockState func_180642_a(World p_180642_1_, BlockPos p_180642_2_, EnumFacing p_180642_3_, float p_180642_4_, float p_180642_5_, float p_180642_6_, int p_180642_7_, EntityLivingBase p_180642_8_) {
      IBlockState var9 = super.func_180642_a(p_180642_1_, p_180642_2_, p_180642_3_, p_180642_4_, p_180642_5_, p_180642_6_, p_180642_7_, p_180642_8_).func_177226_a(field_176554_a, BlockSlab.EnumBlockHalf.BOTTOM);
      return this.func_176552_j()?var9:(p_180642_3_ != EnumFacing.DOWN && (p_180642_3_ == EnumFacing.UP || (double)p_180642_5_ <= 0.5D)?var9:var9.func_177226_a(field_176554_a, BlockSlab.EnumBlockHalf.TOP));
   }

   public int func_149745_a(Random p_149745_1_) {
      return this.func_176552_j()?2:1;
   }

   public boolean func_149686_d() {
      return this.func_176552_j();
   }

   public boolean func_176225_a(IBlockAccess p_176225_1_, BlockPos p_176225_2_, EnumFacing p_176225_3_) {
      if(this.func_176552_j()) {
         return super.func_176225_a(p_176225_1_, p_176225_2_, p_176225_3_);
      } else if(p_176225_3_ != EnumFacing.UP && p_176225_3_ != EnumFacing.DOWN && !super.func_176225_a(p_176225_1_, p_176225_2_, p_176225_3_)) {
         return false;
      } else {
         BlockPos var4 = p_176225_2_.func_177972_a(p_176225_3_.func_176734_d());
         IBlockState var5 = p_176225_1_.func_180495_p(p_176225_2_);
         IBlockState var6 = p_176225_1_.func_180495_p(var4);
         boolean var7 = func_150003_a(var5.func_177230_c()) && var5.func_177229_b(field_176554_a) == BlockSlab.EnumBlockHalf.TOP;
         boolean var8 = func_150003_a(var6.func_177230_c()) && var6.func_177229_b(field_176554_a) == BlockSlab.EnumBlockHalf.TOP;
         return var8?(p_176225_3_ == EnumFacing.DOWN?true:(p_176225_3_ == EnumFacing.UP && super.func_176225_a(p_176225_1_, p_176225_2_, p_176225_3_)?true:!func_150003_a(var5.func_177230_c()) || !var7)):(p_176225_3_ == EnumFacing.UP?true:(p_176225_3_ == EnumFacing.DOWN && super.func_176225_a(p_176225_1_, p_176225_2_, p_176225_3_)?true:!func_150003_a(var5.func_177230_c()) || var7));
      }
   }

   protected static boolean func_150003_a(Block p_150003_0_) {
      return p_150003_0_ == Blocks.field_150333_U || p_150003_0_ == Blocks.field_150376_bx || p_150003_0_ == Blocks.field_180389_cP;
   }

   public abstract String func_150002_b(int var1);

   public int func_176222_j(World p_176222_1_, BlockPos p_176222_2_) {
      return super.func_176222_j(p_176222_1_, p_176222_2_) & 7;
   }

   public abstract boolean func_176552_j();

   public abstract IProperty func_176551_l();

   public abstract Object func_176553_a(ItemStack var1);


   public static enum EnumBlockHalf implements IStringSerializable {

      TOP("TOP", 0, "top"),
      BOTTOM("BOTTOM", 1, "bottom");
      private final String field_176988_c;
      // $FF: synthetic field
      private static final BlockSlab.EnumBlockHalf[] $VALUES = new BlockSlab.EnumBlockHalf[]{TOP, BOTTOM};
      private static final String __OBFID = "CL_00002109";


      private EnumBlockHalf(String p_i45713_1_, int p_i45713_2_, String p_i45713_3_) {
         this.field_176988_c = p_i45713_3_;
      }

      public String toString() {
         return this.field_176988_c;
      }

      public String func_176610_l() {
         return this.field_176988_c;
      }

   }
}
