package net.minecraft.block;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;

public class BlockSlime extends BlockBreakable {

   private static final String __OBFID = "CL_00002063";


   public BlockSlime() {
      super(Material.field_151571_B, false);
      this.func_149647_a(CreativeTabs.field_78031_c);
      this.field_149765_K = 0.8F;
   }

   public EnumWorldBlockLayer func_180664_k() {
      return EnumWorldBlockLayer.TRANSLUCENT;
   }

   public void func_180658_a(World p_180658_1_, BlockPos p_180658_2_, Entity p_180658_3_, float p_180658_4_) {
      if(p_180658_3_.func_70093_af()) {
         super.func_180658_a(p_180658_1_, p_180658_2_, p_180658_3_, p_180658_4_);
      } else {
         p_180658_3_.func_180430_e(p_180658_4_, 0.0F);
      }

   }

   public void func_176216_a(World p_176216_1_, Entity p_176216_2_) {
      if(p_176216_2_.func_70093_af()) {
         super.func_176216_a(p_176216_1_, p_176216_2_);
      } else if(p_176216_2_.field_70181_x < 0.0D) {
         p_176216_2_.field_70181_x = -p_176216_2_.field_70181_x;
      }

   }

   public void func_176199_a(World p_176199_1_, BlockPos p_176199_2_, Entity p_176199_3_) {
      if(Math.abs(p_176199_3_.field_70181_x) < 0.1D && !p_176199_3_.func_70093_af()) {
         double var4 = 0.4D + Math.abs(p_176199_3_.field_70181_x) * 0.2D;
         p_176199_3_.field_70159_w *= var4;
         p_176199_3_.field_70179_y *= var4;
      }

      super.func_176199_a(p_176199_1_, p_176199_2_, p_176199_3_);
   }
}
