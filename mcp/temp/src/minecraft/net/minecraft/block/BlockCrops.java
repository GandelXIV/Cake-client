package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockCrops extends BlockBush implements IGrowable {

   public static final PropertyInteger field_176488_a = PropertyInteger.func_177719_a("age", 0, 7);
   private static final String __OBFID = "CL_00000222";


   protected BlockCrops() {
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176488_a, Integer.valueOf(0)));
      this.func_149675_a(true);
      float var1 = 0.5F;
      this.func_149676_a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
      this.func_149647_a((CreativeTabs)null);
      this.func_149711_c(0.0F);
      this.func_149672_a(field_149779_h);
      this.func_149649_H();
   }

   protected boolean func_149854_a(Block p_149854_1_) {
      return p_149854_1_ == Blocks.field_150458_ak;
   }

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      super.func_180650_b(p_180650_1_, p_180650_2_, p_180650_3_, p_180650_4_);
      if(p_180650_1_.func_175671_l(p_180650_2_.func_177984_a()) >= 9) {
         int var5 = ((Integer)p_180650_3_.func_177229_b(field_176488_a)).intValue();
         if(var5 < 7) {
            float var6 = func_180672_a(this, p_180650_1_, p_180650_2_);
            if(p_180650_4_.nextInt((int)(25.0F / var6) + 1) == 0) {
               p_180650_1_.func_180501_a(p_180650_2_, p_180650_3_.func_177226_a(field_176488_a, Integer.valueOf(var5 + 1)), 2);
            }
         }
      }

   }

   public void func_176487_g(World p_176487_1_, BlockPos p_176487_2_, IBlockState p_176487_3_) {
      int var4 = ((Integer)p_176487_3_.func_177229_b(field_176488_a)).intValue() + MathHelper.func_76136_a(p_176487_1_.field_73012_v, 2, 5);
      if(var4 > 7) {
         var4 = 7;
      }

      p_176487_1_.func_180501_a(p_176487_2_, p_176487_3_.func_177226_a(field_176488_a, Integer.valueOf(var4)), 2);
   }

   protected static float func_180672_a(Block p_180672_0_, World p_180672_1_, BlockPos p_180672_2_) {
      float var3 = 1.0F;
      BlockPos var4 = p_180672_2_.func_177977_b();

      for(int var5 = -1; var5 <= 1; ++var5) {
         for(int var6 = -1; var6 <= 1; ++var6) {
            float var7 = 0.0F;
            IBlockState var8 = p_180672_1_.func_180495_p(var4.func_177982_a(var5, 0, var6));
            if(var8.func_177230_c() == Blocks.field_150458_ak) {
               var7 = 1.0F;
               if(((Integer)var8.func_177229_b(BlockFarmland.field_176531_a)).intValue() > 0) {
                  var7 = 3.0F;
               }
            }

            if(var5 != 0 || var6 != 0) {
               var7 /= 4.0F;
            }

            var3 += var7;
         }
      }

      BlockPos var12 = p_180672_2_.func_177978_c();
      BlockPos var13 = p_180672_2_.func_177968_d();
      BlockPos var14 = p_180672_2_.func_177976_e();
      BlockPos var15 = p_180672_2_.func_177974_f();
      boolean var9 = p_180672_0_ == p_180672_1_.func_180495_p(var14).func_177230_c() || p_180672_0_ == p_180672_1_.func_180495_p(var15).func_177230_c();
      boolean var10 = p_180672_0_ == p_180672_1_.func_180495_p(var12).func_177230_c() || p_180672_0_ == p_180672_1_.func_180495_p(var13).func_177230_c();
      if(var9 && var10) {
         var3 /= 2.0F;
      } else {
         boolean var11 = p_180672_0_ == p_180672_1_.func_180495_p(var14.func_177978_c()).func_177230_c() || p_180672_0_ == p_180672_1_.func_180495_p(var15.func_177978_c()).func_177230_c() || p_180672_0_ == p_180672_1_.func_180495_p(var15.func_177968_d()).func_177230_c() || p_180672_0_ == p_180672_1_.func_180495_p(var14.func_177968_d()).func_177230_c();
         if(var11) {
            var3 /= 2.0F;
         }
      }

      return var3;
   }

   public boolean func_180671_f(World p_180671_1_, BlockPos p_180671_2_, IBlockState p_180671_3_) {
      return (p_180671_1_.func_175699_k(p_180671_2_) >= 8 || p_180671_1_.func_175678_i(p_180671_2_)) && this.func_149854_a(p_180671_1_.func_180495_p(p_180671_2_.func_177977_b()).func_177230_c());
   }

   protected Item func_149866_i() {
      return Items.field_151014_N;
   }

   protected Item func_149865_P() {
      return Items.field_151015_O;
   }

   public void func_180653_a(World p_180653_1_, BlockPos p_180653_2_, IBlockState p_180653_3_, float p_180653_4_, int p_180653_5_) {
      super.func_180653_a(p_180653_1_, p_180653_2_, p_180653_3_, p_180653_4_, 0);
      if(!p_180653_1_.field_72995_K) {
         int var6 = ((Integer)p_180653_3_.func_177229_b(field_176488_a)).intValue();
         if(var6 >= 7) {
            int var7 = 3 + p_180653_5_;

            for(int var8 = 0; var8 < var7; ++var8) {
               if(p_180653_1_.field_73012_v.nextInt(15) <= var6) {
                  func_180635_a(p_180653_1_, p_180653_2_, new ItemStack(this.func_149866_i(), 1, 0));
               }
            }
         }

      }
   }

   public Item func_180660_a(IBlockState p_180660_1_, Random p_180660_2_, int p_180660_3_) {
      return ((Integer)p_180660_1_.func_177229_b(field_176488_a)).intValue() == 7?this.func_149865_P():this.func_149866_i();
   }

   public Item func_180665_b(World p_180665_1_, BlockPos p_180665_2_) {
      return this.func_149866_i();
   }

   public boolean func_176473_a(World p_176473_1_, BlockPos p_176473_2_, IBlockState p_176473_3_, boolean p_176473_4_) {
      return ((Integer)p_176473_3_.func_177229_b(field_176488_a)).intValue() < 7;
   }

   public boolean func_180670_a(World p_180670_1_, Random p_180670_2_, BlockPos p_180670_3_, IBlockState p_180670_4_) {
      return true;
   }

   public void func_176474_b(World p_176474_1_, Random p_176474_2_, BlockPos p_176474_3_, IBlockState p_176474_4_) {
      this.func_176487_g(p_176474_1_, p_176474_3_, p_176474_4_);
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176488_a, Integer.valueOf(p_176203_1_));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((Integer)p_176201_1_.func_177229_b(field_176488_a)).intValue();
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176488_a});
   }

}
