package net.minecraft.block;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemLead;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFence extends Block {

   public static final PropertyBool field_176526_a = PropertyBool.func_177716_a("north");
   public static final PropertyBool field_176525_b = PropertyBool.func_177716_a("east");
   public static final PropertyBool field_176527_M = PropertyBool.func_177716_a("south");
   public static final PropertyBool field_176528_N = PropertyBool.func_177716_a("west");
   private static final String __OBFID = "CL_00000242";


   public BlockFence(Material p_i45721_1_) {
      super(p_i45721_1_);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176526_a, Boolean.valueOf(false)).func_177226_a(field_176525_b, Boolean.valueOf(false)).func_177226_a(field_176527_M, Boolean.valueOf(false)).func_177226_a(field_176528_N, Boolean.valueOf(false)));
      this.func_149647_a(CreativeTabs.field_78031_c);
   }

   public void func_180638_a(World p_180638_1_, BlockPos p_180638_2_, IBlockState p_180638_3_, AxisAlignedBB p_180638_4_, List p_180638_5_, Entity p_180638_6_) {
      boolean var7 = this.func_176524_e(p_180638_1_, p_180638_2_.func_177978_c());
      boolean var8 = this.func_176524_e(p_180638_1_, p_180638_2_.func_177968_d());
      boolean var9 = this.func_176524_e(p_180638_1_, p_180638_2_.func_177976_e());
      boolean var10 = this.func_176524_e(p_180638_1_, p_180638_2_.func_177974_f());
      float var11 = 0.375F;
      float var12 = 0.625F;
      float var13 = 0.375F;
      float var14 = 0.625F;
      if(var7) {
         var13 = 0.0F;
      }

      if(var8) {
         var14 = 1.0F;
      }

      if(var7 || var8) {
         this.func_149676_a(var11, 0.0F, var13, var12, 1.5F, var14);
         super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
      }

      var13 = 0.375F;
      var14 = 0.625F;
      if(var9) {
         var11 = 0.0F;
      }

      if(var10) {
         var12 = 1.0F;
      }

      if(var9 || var10 || !var7 && !var8) {
         this.func_149676_a(var11, 0.0F, var13, var12, 1.5F, var14);
         super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
      }

      if(var7) {
         var13 = 0.0F;
      }

      if(var8) {
         var14 = 1.0F;
      }

      this.func_149676_a(var11, 0.0F, var13, var12, 1.0F, var14);
   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      boolean var3 = this.func_176524_e(p_180654_1_, p_180654_2_.func_177978_c());
      boolean var4 = this.func_176524_e(p_180654_1_, p_180654_2_.func_177968_d());
      boolean var5 = this.func_176524_e(p_180654_1_, p_180654_2_.func_177976_e());
      boolean var6 = this.func_176524_e(p_180654_1_, p_180654_2_.func_177974_f());
      float var7 = 0.375F;
      float var8 = 0.625F;
      float var9 = 0.375F;
      float var10 = 0.625F;
      if(var3) {
         var9 = 0.0F;
      }

      if(var4) {
         var10 = 1.0F;
      }

      if(var5) {
         var7 = 0.0F;
      }

      if(var6) {
         var8 = 1.0F;
      }

      this.func_149676_a(var7, 0.0F, var9, var8, 1.0F, var10);
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_176205_b(IBlockAccess p_176205_1_, BlockPos p_176205_2_) {
      return false;
   }

   public boolean func_176524_e(IBlockAccess p_176524_1_, BlockPos p_176524_2_) {
      Block var3 = p_176524_1_.func_180495_p(p_176524_2_).func_177230_c();
      return var3 == Blocks.field_180401_cv?false:((!(var3 instanceof BlockFence) || var3.field_149764_J != this.field_149764_J) && !(var3 instanceof BlockFenceGate)?(var3.field_149764_J.func_76218_k() && var3.func_149686_d()?var3.field_149764_J != Material.field_151572_C:false):true);
   }

   public boolean func_176225_a(IBlockAccess p_176225_1_, BlockPos p_176225_2_, EnumFacing p_176225_3_) {
      return true;
   }

   public boolean func_180639_a(World p_180639_1_, BlockPos p_180639_2_, IBlockState p_180639_3_, EntityPlayer p_180639_4_, EnumFacing p_180639_5_, float p_180639_6_, float p_180639_7_, float p_180639_8_) {
      return p_180639_1_.field_72995_K?true:ItemLead.func_180618_a(p_180639_4_, p_180639_1_, p_180639_2_);
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return 0;
   }

   public IBlockState func_176221_a(IBlockState p_176221_1_, IBlockAccess p_176221_2_, BlockPos p_176221_3_) {
      return p_176221_1_.func_177226_a(field_176526_a, Boolean.valueOf(this.func_176524_e(p_176221_2_, p_176221_3_.func_177978_c()))).func_177226_a(field_176525_b, Boolean.valueOf(this.func_176524_e(p_176221_2_, p_176221_3_.func_177974_f()))).func_177226_a(field_176527_M, Boolean.valueOf(this.func_176524_e(p_176221_2_, p_176221_3_.func_177968_d()))).func_177226_a(field_176528_N, Boolean.valueOf(this.func_176524_e(p_176221_2_, p_176221_3_.func_177976_e())));
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176526_a, field_176525_b, field_176528_N, field_176527_M});
   }

}
