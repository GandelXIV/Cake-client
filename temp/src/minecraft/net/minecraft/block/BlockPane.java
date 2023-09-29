package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPane extends Block {

   public static final PropertyBool field_176241_b = PropertyBool.func_177716_a("north");
   public static final PropertyBool field_176242_M = PropertyBool.func_177716_a("east");
   public static final PropertyBool field_176243_N = PropertyBool.func_177716_a("south");
   public static final PropertyBool field_176244_O = PropertyBool.func_177716_a("west");
   private final boolean field_150099_b;
   private static final String __OBFID = "CL_00000322";


   protected BlockPane(Material p_i45675_1_, boolean p_i45675_2_) {
      super(p_i45675_1_);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176241_b, Boolean.valueOf(false)).func_177226_a(field_176242_M, Boolean.valueOf(false)).func_177226_a(field_176243_N, Boolean.valueOf(false)).func_177226_a(field_176244_O, Boolean.valueOf(false)));
      this.field_150099_b = p_i45675_2_;
      this.func_149647_a(CreativeTabs.field_78031_c);
   }

   public IBlockState func_176221_a(IBlockState p_176221_1_, IBlockAccess p_176221_2_, BlockPos p_176221_3_) {
      return p_176221_1_.func_177226_a(field_176241_b, Boolean.valueOf(this.func_150098_a(p_176221_2_.func_180495_p(p_176221_3_.func_177978_c()).func_177230_c()))).func_177226_a(field_176243_N, Boolean.valueOf(this.func_150098_a(p_176221_2_.func_180495_p(p_176221_3_.func_177968_d()).func_177230_c()))).func_177226_a(field_176244_O, Boolean.valueOf(this.func_150098_a(p_176221_2_.func_180495_p(p_176221_3_.func_177976_e()).func_177230_c()))).func_177226_a(field_176242_M, Boolean.valueOf(this.func_150098_a(p_176221_2_.func_180495_p(p_176221_3_.func_177974_f()).func_177230_c())));
   }

   public Item func_180660_a(IBlockState p_180660_1_, Random p_180660_2_, int p_180660_3_) {
      return !this.field_150099_b?null:super.func_180660_a(p_180660_1_, p_180660_2_, p_180660_3_);
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_176225_a(IBlockAccess p_176225_1_, BlockPos p_176225_2_, EnumFacing p_176225_3_) {
      return p_176225_1_.func_180495_p(p_176225_2_).func_177230_c() == this?false:super.func_176225_a(p_176225_1_, p_176225_2_, p_176225_3_);
   }

   public void func_180638_a(World p_180638_1_, BlockPos p_180638_2_, IBlockState p_180638_3_, AxisAlignedBB p_180638_4_, List p_180638_5_, Entity p_180638_6_) {
      boolean var7 = this.func_150098_a(p_180638_1_.func_180495_p(p_180638_2_.func_177978_c()).func_177230_c());
      boolean var8 = this.func_150098_a(p_180638_1_.func_180495_p(p_180638_2_.func_177968_d()).func_177230_c());
      boolean var9 = this.func_150098_a(p_180638_1_.func_180495_p(p_180638_2_.func_177976_e()).func_177230_c());
      boolean var10 = this.func_150098_a(p_180638_1_.func_180495_p(p_180638_2_.func_177974_f()).func_177230_c());
      if((!var9 || !var10) && (var9 || var10 || var7 || var8)) {
         if(var9) {
            this.func_149676_a(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
            super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
         } else if(var10) {
            this.func_149676_a(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
            super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
         }
      } else {
         this.func_149676_a(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
         super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
      }

      if((!var7 || !var8) && (var9 || var10 || var7 || var8)) {
         if(var7) {
            this.func_149676_a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
            super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
         } else if(var8) {
            this.func_149676_a(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
            super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
         }
      } else {
         this.func_149676_a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
         super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
      }

   }

   public void func_149683_g() {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      float var3 = 0.4375F;
      float var4 = 0.5625F;
      float var5 = 0.4375F;
      float var6 = 0.5625F;
      boolean var7 = this.func_150098_a(p_180654_1_.func_180495_p(p_180654_2_.func_177978_c()).func_177230_c());
      boolean var8 = this.func_150098_a(p_180654_1_.func_180495_p(p_180654_2_.func_177968_d()).func_177230_c());
      boolean var9 = this.func_150098_a(p_180654_1_.func_180495_p(p_180654_2_.func_177976_e()).func_177230_c());
      boolean var10 = this.func_150098_a(p_180654_1_.func_180495_p(p_180654_2_.func_177974_f()).func_177230_c());
      if((!var9 || !var10) && (var9 || var10 || var7 || var8)) {
         if(var9) {
            var3 = 0.0F;
         } else if(var10) {
            var4 = 1.0F;
         }
      } else {
         var3 = 0.0F;
         var4 = 1.0F;
      }

      if((!var7 || !var8) && (var9 || var10 || var7 || var8)) {
         if(var7) {
            var5 = 0.0F;
         } else if(var8) {
            var6 = 1.0F;
         }
      } else {
         var5 = 0.0F;
         var6 = 1.0F;
      }

      this.func_149676_a(var3, 0.0F, var5, var4, 1.0F, var6);
   }

   public final boolean func_150098_a(Block p_150098_1_) {
      return p_150098_1_.func_149730_j() || p_150098_1_ == this || p_150098_1_ == Blocks.field_150359_w || p_150098_1_ == Blocks.field_150399_cn || p_150098_1_ == Blocks.field_150397_co || p_150098_1_ instanceof BlockPane;
   }

   protected boolean func_149700_E() {
      return true;
   }

   public EnumWorldBlockLayer func_180664_k() {
      return EnumWorldBlockLayer.CUTOUT_MIPPED;
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return 0;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176241_b, field_176242_M, field_176244_O, field_176243_N});
   }

}
