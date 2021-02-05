package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class BlockRedstoneOre extends Block {

   private final boolean field_150187_a;
   private static final String __OBFID = "CL_00000294";


   public BlockRedstoneOre(boolean p_i45420_1_) {
      super(Material.field_151576_e);
      if(p_i45420_1_) {
         this.func_149675_a(true);
      }

      this.field_150187_a = p_i45420_1_;
   }

   public int func_149738_a(World p_149738_1_) {
      return 30;
   }

   public void func_180649_a(World p_180649_1_, BlockPos p_180649_2_, EntityPlayer p_180649_3_) {
      this.func_176352_d(p_180649_1_, p_180649_2_);
      super.func_180649_a(p_180649_1_, p_180649_2_, p_180649_3_);
   }

   public void func_176199_a(World p_176199_1_, BlockPos p_176199_2_, Entity p_176199_3_) {
      this.func_176352_d(p_176199_1_, p_176199_2_);
      super.func_176199_a(p_176199_1_, p_176199_2_, p_176199_3_);
   }

   public boolean func_180639_a(World p_180639_1_, BlockPos p_180639_2_, IBlockState p_180639_3_, EntityPlayer p_180639_4_, EnumFacing p_180639_5_, float p_180639_6_, float p_180639_7_, float p_180639_8_) {
      this.func_176352_d(p_180639_1_, p_180639_2_);
      return super.func_180639_a(p_180639_1_, p_180639_2_, p_180639_3_, p_180639_4_, p_180639_5_, p_180639_6_, p_180639_7_, p_180639_8_);
   }

   private void func_176352_d(World p_176352_1_, BlockPos p_176352_2_) {
      this.func_180691_e(p_176352_1_, p_176352_2_);
      if(this == Blocks.field_150450_ax) {
         p_176352_1_.func_175656_a(p_176352_2_, Blocks.field_150439_ay.func_176223_P());
      }

   }

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      if(this == Blocks.field_150439_ay) {
         p_180650_1_.func_175656_a(p_180650_2_, Blocks.field_150450_ax.func_176223_P());
      }

   }

   public Item func_180660_a(IBlockState p_180660_1_, Random p_180660_2_, int p_180660_3_) {
      return Items.field_151137_ax;
   }

   public int func_149679_a(int p_149679_1_, Random p_149679_2_) {
      return this.func_149745_a(p_149679_2_) + p_149679_2_.nextInt(p_149679_1_ + 1);
   }

   public int func_149745_a(Random p_149745_1_) {
      return 4 + p_149745_1_.nextInt(2);
   }

   public void func_180653_a(World p_180653_1_, BlockPos p_180653_2_, IBlockState p_180653_3_, float p_180653_4_, int p_180653_5_) {
      super.func_180653_a(p_180653_1_, p_180653_2_, p_180653_3_, p_180653_4_, p_180653_5_);
      if(this.func_180660_a(p_180653_3_, p_180653_1_.field_73012_v, p_180653_5_) != Item.func_150898_a(this)) {
         int var6 = 1 + p_180653_1_.field_73012_v.nextInt(5);
         this.func_180637_b(p_180653_1_, p_180653_2_, var6);
      }

   }

   public void func_180655_c(World p_180655_1_, BlockPos p_180655_2_, IBlockState p_180655_3_, Random p_180655_4_) {
      if(this.field_150187_a) {
         this.func_180691_e(p_180655_1_, p_180655_2_);
      }

   }

   private void func_180691_e(World p_180691_1_, BlockPos p_180691_2_) {
      Random var3 = p_180691_1_.field_73012_v;
      double var4 = 0.0625D;

      for(int var6 = 0; var6 < 6; ++var6) {
         double var7 = (double)((float)p_180691_2_.func_177958_n() + var3.nextFloat());
         double var9 = (double)((float)p_180691_2_.func_177956_o() + var3.nextFloat());
         double var11 = (double)((float)p_180691_2_.func_177952_p() + var3.nextFloat());
         if(var6 == 0 && !p_180691_1_.func_180495_p(p_180691_2_.func_177984_a()).func_177230_c().func_149662_c()) {
            var9 = (double)p_180691_2_.func_177956_o() + var4 + 1.0D;
         }

         if(var6 == 1 && !p_180691_1_.func_180495_p(p_180691_2_.func_177977_b()).func_177230_c().func_149662_c()) {
            var9 = (double)p_180691_2_.func_177956_o() - var4;
         }

         if(var6 == 2 && !p_180691_1_.func_180495_p(p_180691_2_.func_177968_d()).func_177230_c().func_149662_c()) {
            var11 = (double)p_180691_2_.func_177952_p() + var4 + 1.0D;
         }

         if(var6 == 3 && !p_180691_1_.func_180495_p(p_180691_2_.func_177978_c()).func_177230_c().func_149662_c()) {
            var11 = (double)p_180691_2_.func_177952_p() - var4;
         }

         if(var6 == 4 && !p_180691_1_.func_180495_p(p_180691_2_.func_177974_f()).func_177230_c().func_149662_c()) {
            var7 = (double)p_180691_2_.func_177958_n() + var4 + 1.0D;
         }

         if(var6 == 5 && !p_180691_1_.func_180495_p(p_180691_2_.func_177976_e()).func_177230_c().func_149662_c()) {
            var7 = (double)p_180691_2_.func_177958_n() - var4;
         }

         if(var7 < (double)p_180691_2_.func_177958_n() || var7 > (double)(p_180691_2_.func_177958_n() + 1) || var9 < 0.0D || var9 > (double)(p_180691_2_.func_177956_o() + 1) || var11 < (double)p_180691_2_.func_177952_p() || var11 > (double)(p_180691_2_.func_177952_p() + 1)) {
            p_180691_1_.func_175688_a(EnumParticleTypes.REDSTONE, var7, var9, var11, 0.0D, 0.0D, 0.0D, new int[0]);
         }
      }

   }

   protected ItemStack func_180643_i(IBlockState p_180643_1_) {
      return new ItemStack(Blocks.field_150450_ax);
   }
}
