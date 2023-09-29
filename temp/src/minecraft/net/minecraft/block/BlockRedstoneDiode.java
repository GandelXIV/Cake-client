package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockRedstoneDiode extends BlockDirectional {

   protected final boolean field_149914_a;
   private static final String __OBFID = "CL_00000226";


   protected BlockRedstoneDiode(boolean p_i45400_1_) {
      super(Material.field_151594_q);
      this.field_149914_a = p_i45400_1_;
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_176196_c(World p_176196_1_, BlockPos p_176196_2_) {
      return World.func_175683_a(p_176196_1_, p_176196_2_.func_177977_b())?super.func_176196_c(p_176196_1_, p_176196_2_):false;
   }

   public boolean func_176409_d(World p_176409_1_, BlockPos p_176409_2_) {
      return World.func_175683_a(p_176409_1_, p_176409_2_.func_177977_b());
   }

   public void func_180645_a(World p_180645_1_, BlockPos p_180645_2_, IBlockState p_180645_3_, Random p_180645_4_) {}

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      if(!this.func_176405_b(p_180650_1_, p_180650_2_, p_180650_3_)) {
         boolean var5 = this.func_176404_e(p_180650_1_, p_180650_2_, p_180650_3_);
         if(this.field_149914_a && !var5) {
            p_180650_1_.func_180501_a(p_180650_2_, this.func_180675_k(p_180650_3_), 2);
         } else if(!this.field_149914_a) {
            p_180650_1_.func_180501_a(p_180650_2_, this.func_180674_e(p_180650_3_), 2);
            if(!var5) {
               p_180650_1_.func_175654_a(p_180650_2_, this.func_180674_e(p_180650_3_).func_177230_c(), this.func_176399_m(p_180650_3_), -1);
            }
         }

      }
   }

   public boolean func_176225_a(IBlockAccess p_176225_1_, BlockPos p_176225_2_, EnumFacing p_176225_3_) {
      return p_176225_3_.func_176740_k() != EnumFacing.Axis.Y;
   }

   protected boolean func_176406_l(IBlockState p_176406_1_) {
      return this.field_149914_a;
   }

   public int func_176211_b(IBlockAccess p_176211_1_, BlockPos p_176211_2_, IBlockState p_176211_3_, EnumFacing p_176211_4_) {
      return this.func_180656_a(p_176211_1_, p_176211_2_, p_176211_3_, p_176211_4_);
   }

   public int func_180656_a(IBlockAccess p_180656_1_, BlockPos p_180656_2_, IBlockState p_180656_3_, EnumFacing p_180656_4_) {
      return !this.func_176406_l(p_180656_3_)?0:(p_180656_3_.func_177229_b(field_176387_N) == p_180656_4_?this.func_176408_a(p_180656_1_, p_180656_2_, p_180656_3_):0);
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      if(this.func_176409_d(p_176204_1_, p_176204_2_)) {
         this.func_176398_g(p_176204_1_, p_176204_2_, p_176204_3_);
      } else {
         this.func_176226_b(p_176204_1_, p_176204_2_, p_176204_3_, 0);
         p_176204_1_.func_175698_g(p_176204_2_);
         EnumFacing[] var5 = EnumFacing.values();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            EnumFacing var8 = var5[var7];
            p_176204_1_.func_175685_c(p_176204_2_.func_177972_a(var8), this);
         }

      }
   }

   protected void func_176398_g(World p_176398_1_, BlockPos p_176398_2_, IBlockState p_176398_3_) {
      if(!this.func_176405_b(p_176398_1_, p_176398_2_, p_176398_3_)) {
         boolean var4 = this.func_176404_e(p_176398_1_, p_176398_2_, p_176398_3_);
         if((this.field_149914_a && !var4 || !this.field_149914_a && var4) && !p_176398_1_.func_175691_a(p_176398_2_, this)) {
            byte var5 = -1;
            if(this.func_176402_i(p_176398_1_, p_176398_2_, p_176398_3_)) {
               var5 = -3;
            } else if(this.field_149914_a) {
               var5 = -2;
            }

            p_176398_1_.func_175654_a(p_176398_2_, this, this.func_176403_d(p_176398_3_), var5);
         }

      }
   }

   public boolean func_176405_b(IBlockAccess p_176405_1_, BlockPos p_176405_2_, IBlockState p_176405_3_) {
      return false;
   }

   protected boolean func_176404_e(World p_176404_1_, BlockPos p_176404_2_, IBlockState p_176404_3_) {
      return this.func_176397_f(p_176404_1_, p_176404_2_, p_176404_3_) > 0;
   }

   protected int func_176397_f(World p_176397_1_, BlockPos p_176397_2_, IBlockState p_176397_3_) {
      EnumFacing var4 = (EnumFacing)p_176397_3_.func_177229_b(field_176387_N);
      BlockPos var5 = p_176397_2_.func_177972_a(var4);
      int var6 = p_176397_1_.func_175651_c(var5, var4);
      if(var6 >= 15) {
         return var6;
      } else {
         IBlockState var7 = p_176397_1_.func_180495_p(var5);
         return Math.max(var6, var7.func_177230_c() == Blocks.field_150488_af?((Integer)var7.func_177229_b(BlockRedstoneWire.field_176351_O)).intValue():0);
      }
   }

   protected int func_176407_c(IBlockAccess p_176407_1_, BlockPos p_176407_2_, IBlockState p_176407_3_) {
      EnumFacing var4 = (EnumFacing)p_176407_3_.func_177229_b(field_176387_N);
      EnumFacing var5 = var4.func_176746_e();
      EnumFacing var6 = var4.func_176735_f();
      return Math.max(this.func_176401_c(p_176407_1_, p_176407_2_.func_177972_a(var5), var5), this.func_176401_c(p_176407_1_, p_176407_2_.func_177972_a(var6), var6));
   }

   protected int func_176401_c(IBlockAccess p_176401_1_, BlockPos p_176401_2_, EnumFacing p_176401_3_) {
      IBlockState var4 = p_176401_1_.func_180495_p(p_176401_2_);
      Block var5 = var4.func_177230_c();
      return this.func_149908_a(var5)?(var5 == Blocks.field_150488_af?((Integer)var4.func_177229_b(BlockRedstoneWire.field_176351_O)).intValue():p_176401_1_.func_175627_a(p_176401_2_, p_176401_3_)):0;
   }

   public boolean func_149744_f() {
      return true;
   }

   public IBlockState func_180642_a(World p_180642_1_, BlockPos p_180642_2_, EnumFacing p_180642_3_, float p_180642_4_, float p_180642_5_, float p_180642_6_, int p_180642_7_, EntityLivingBase p_180642_8_) {
      return this.func_176223_P().func_177226_a(field_176387_N, p_180642_8_.func_174811_aO().func_176734_d());
   }

   public void func_180633_a(World p_180633_1_, BlockPos p_180633_2_, IBlockState p_180633_3_, EntityLivingBase p_180633_4_, ItemStack p_180633_5_) {
      if(this.func_176404_e(p_180633_1_, p_180633_2_, p_180633_3_)) {
         p_180633_1_.func_175684_a(p_180633_2_, this, 1);
      }

   }

   public void func_176213_c(World p_176213_1_, BlockPos p_176213_2_, IBlockState p_176213_3_) {
      this.func_176400_h(p_176213_1_, p_176213_2_, p_176213_3_);
   }

   protected void func_176400_h(World p_176400_1_, BlockPos p_176400_2_, IBlockState p_176400_3_) {
      EnumFacing var4 = (EnumFacing)p_176400_3_.func_177229_b(field_176387_N);
      BlockPos var5 = p_176400_2_.func_177972_a(var4.func_176734_d());
      p_176400_1_.func_180496_d(var5, this);
      p_176400_1_.func_175695_a(var5, this, var4);
   }

   public void func_176206_d(World p_176206_1_, BlockPos p_176206_2_, IBlockState p_176206_3_) {
      if(this.field_149914_a) {
         EnumFacing[] var4 = EnumFacing.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            EnumFacing var7 = var4[var6];
            p_176206_1_.func_175685_c(p_176206_2_.func_177972_a(var7), this);
         }
      }

      super.func_176206_d(p_176206_1_, p_176206_2_, p_176206_3_);
   }

   public boolean func_149662_c() {
      return false;
   }

   protected boolean func_149908_a(Block p_149908_1_) {
      return p_149908_1_.func_149744_f();
   }

   protected int func_176408_a(IBlockAccess p_176408_1_, BlockPos p_176408_2_, IBlockState p_176408_3_) {
      return 15;
   }

   public static boolean func_149909_d(Block p_149909_0_) {
      return Blocks.field_150413_aR.func_149907_e(p_149909_0_) || Blocks.field_150441_bU.func_149907_e(p_149909_0_);
   }

   public boolean func_149907_e(Block p_149907_1_) {
      return p_149907_1_ == this.func_180674_e(this.func_176223_P()).func_177230_c() || p_149907_1_ == this.func_180675_k(this.func_176223_P()).func_177230_c();
   }

   public boolean func_176402_i(World p_176402_1_, BlockPos p_176402_2_, IBlockState p_176402_3_) {
      EnumFacing var4 = ((EnumFacing)p_176402_3_.func_177229_b(field_176387_N)).func_176734_d();
      BlockPos var5 = p_176402_2_.func_177972_a(var4);
      return func_149909_d(p_176402_1_.func_180495_p(var5).func_177230_c())?p_176402_1_.func_180495_p(var5).func_177229_b(field_176387_N) != var4:false;
   }

   protected int func_176399_m(IBlockState p_176399_1_) {
      return this.func_176403_d(p_176399_1_);
   }

   protected abstract int func_176403_d(IBlockState var1);

   protected abstract IBlockState func_180674_e(IBlockState var1);

   protected abstract IBlockState func_180675_k(IBlockState var1);

   public boolean func_149667_c(Block p_149667_1_) {
      return this.func_149907_e(p_149667_1_);
   }

   public EnumWorldBlockLayer func_180664_k() {
      return EnumWorldBlockLayer.CUTOUT;
   }
}
