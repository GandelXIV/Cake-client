package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDragonEgg extends Block {

   private static final String __OBFID = "CL_00000232";


   public BlockDragonEgg() {
      super(Material.field_151566_D);
      this.func_149676_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
   }

   public void func_176213_c(World p_176213_1_, BlockPos p_176213_2_, IBlockState p_176213_3_) {
      p_176213_1_.func_175684_a(p_176213_2_, this, this.func_149738_a(p_176213_1_));
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      p_176204_1_.func_175684_a(p_176204_2_, this, this.func_149738_a(p_176204_1_));
   }

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      this.func_180683_d(p_180650_1_, p_180650_2_);
   }

   private void func_180683_d(World p_180683_1_, BlockPos p_180683_2_) {
      if(BlockFalling.func_180685_d(p_180683_1_, p_180683_2_.func_177977_b()) && p_180683_2_.func_177956_o() >= 0) {
         byte var3 = 32;
         if(!BlockFalling.field_149832_M && p_180683_1_.func_175707_a(p_180683_2_.func_177982_a(-var3, -var3, -var3), p_180683_2_.func_177982_a(var3, var3, var3))) {
            p_180683_1_.func_72838_d(new EntityFallingBlock(p_180683_1_, (double)((float)p_180683_2_.func_177958_n() + 0.5F), (double)p_180683_2_.func_177956_o(), (double)((float)p_180683_2_.func_177952_p() + 0.5F), this.func_176223_P()));
         } else {
            p_180683_1_.func_175698_g(p_180683_2_);

            BlockPos var4;
            for(var4 = p_180683_2_; BlockFalling.func_180685_d(p_180683_1_, var4) && var4.func_177956_o() > 0; var4 = var4.func_177977_b()) {
               ;
            }

            if(var4.func_177956_o() > 0) {
               p_180683_1_.func_180501_a(var4, this.func_176223_P(), 2);
            }
         }

      }
   }

   public boolean func_180639_a(World p_180639_1_, BlockPos p_180639_2_, IBlockState p_180639_3_, EntityPlayer p_180639_4_, EnumFacing p_180639_5_, float p_180639_6_, float p_180639_7_, float p_180639_8_) {
      this.func_180684_e(p_180639_1_, p_180639_2_);
      return true;
   }

   public void func_180649_a(World p_180649_1_, BlockPos p_180649_2_, EntityPlayer p_180649_3_) {
      this.func_180684_e(p_180649_1_, p_180649_2_);
   }

   private void func_180684_e(World p_180684_1_, BlockPos p_180684_2_) {
      IBlockState var3 = p_180684_1_.func_180495_p(p_180684_2_);
      if(var3.func_177230_c() == this) {
         for(int var4 = 0; var4 < 1000; ++var4) {
            BlockPos var5 = p_180684_2_.func_177982_a(p_180684_1_.field_73012_v.nextInt(16) - p_180684_1_.field_73012_v.nextInt(16), p_180684_1_.field_73012_v.nextInt(8) - p_180684_1_.field_73012_v.nextInt(8), p_180684_1_.field_73012_v.nextInt(16) - p_180684_1_.field_73012_v.nextInt(16));
            if(p_180684_1_.func_180495_p(var5).func_177230_c().field_149764_J == Material.field_151579_a) {
               if(p_180684_1_.field_72995_K) {
                  for(int var6 = 0; var6 < 128; ++var6) {
                     double var7 = p_180684_1_.field_73012_v.nextDouble();
                     float var9 = (p_180684_1_.field_73012_v.nextFloat() - 0.5F) * 0.2F;
                     float var10 = (p_180684_1_.field_73012_v.nextFloat() - 0.5F) * 0.2F;
                     float var11 = (p_180684_1_.field_73012_v.nextFloat() - 0.5F) * 0.2F;
                     double var12 = (double)var5.func_177958_n() + (double)(p_180684_2_.func_177958_n() - var5.func_177958_n()) * var7 + (p_180684_1_.field_73012_v.nextDouble() - 0.5D) * 1.0D + 0.5D;
                     double var14 = (double)var5.func_177956_o() + (double)(p_180684_2_.func_177956_o() - var5.func_177956_o()) * var7 + p_180684_1_.field_73012_v.nextDouble() * 1.0D - 0.5D;
                     double var16 = (double)var5.func_177952_p() + (double)(p_180684_2_.func_177952_p() - var5.func_177952_p()) * var7 + (p_180684_1_.field_73012_v.nextDouble() - 0.5D) * 1.0D + 0.5D;
                     p_180684_1_.func_175688_a(EnumParticleTypes.PORTAL, var12, var14, var16, (double)var9, (double)var10, (double)var11, new int[0]);
                  }
               } else {
                  p_180684_1_.func_180501_a(var5, var3, 2);
                  p_180684_1_.func_175698_g(p_180684_2_);
               }

               return;
            }
         }

      }
   }

   public int func_149738_a(World p_149738_1_) {
      return 5;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_176225_a(IBlockAccess p_176225_1_, BlockPos p_176225_2_, EnumFacing p_176225_3_) {
      return true;
   }

   public Item func_180665_b(World p_180665_1_, BlockPos p_180665_2_) {
      return null;
   }
}
