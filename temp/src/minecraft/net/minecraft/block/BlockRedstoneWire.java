package net.minecraft.block;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRedstoneWire extends Block {

   public static final PropertyEnum field_176348_a = PropertyEnum.func_177709_a("north", BlockRedstoneWire.EnumAttachPosition.class);
   public static final PropertyEnum field_176347_b = PropertyEnum.func_177709_a("east", BlockRedstoneWire.EnumAttachPosition.class);
   public static final PropertyEnum field_176349_M = PropertyEnum.func_177709_a("south", BlockRedstoneWire.EnumAttachPosition.class);
   public static final PropertyEnum field_176350_N = PropertyEnum.func_177709_a("west", BlockRedstoneWire.EnumAttachPosition.class);
   public static final PropertyInteger field_176351_O = PropertyInteger.func_177719_a("power", 0, 15);
   private boolean field_150181_a = true;
   private final Set field_150179_b = Sets.newHashSet();
   private static final String __OBFID = "CL_00000295";


   public BlockRedstoneWire() {
      super(Material.field_151594_q);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176348_a, BlockRedstoneWire.EnumAttachPosition.NONE).func_177226_a(field_176347_b, BlockRedstoneWire.EnumAttachPosition.NONE).func_177226_a(field_176349_M, BlockRedstoneWire.EnumAttachPosition.NONE).func_177226_a(field_176350_N, BlockRedstoneWire.EnumAttachPosition.NONE).func_177226_a(field_176351_O, Integer.valueOf(0)));
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
   }

   public IBlockState func_176221_a(IBlockState p_176221_1_, IBlockAccess p_176221_2_, BlockPos p_176221_3_) {
      p_176221_1_ = p_176221_1_.func_177226_a(field_176350_N, this.func_176341_c(p_176221_2_, p_176221_3_, EnumFacing.WEST));
      p_176221_1_ = p_176221_1_.func_177226_a(field_176347_b, this.func_176341_c(p_176221_2_, p_176221_3_, EnumFacing.EAST));
      p_176221_1_ = p_176221_1_.func_177226_a(field_176348_a, this.func_176341_c(p_176221_2_, p_176221_3_, EnumFacing.NORTH));
      p_176221_1_ = p_176221_1_.func_177226_a(field_176349_M, this.func_176341_c(p_176221_2_, p_176221_3_, EnumFacing.SOUTH));
      return p_176221_1_;
   }

   private BlockRedstoneWire.EnumAttachPosition func_176341_c(IBlockAccess p_176341_1_, BlockPos p_176341_2_, EnumFacing p_176341_3_) {
      BlockPos var4 = p_176341_2_.func_177972_a(p_176341_3_);
      Block var5 = p_176341_1_.func_180495_p(p_176341_2_.func_177972_a(p_176341_3_)).func_177230_c();
      if(!func_176343_a(p_176341_1_.func_180495_p(var4), p_176341_3_) && (var5.func_149637_q() || !func_176346_d(p_176341_1_.func_180495_p(var4.func_177977_b())))) {
         Block var6 = p_176341_1_.func_180495_p(p_176341_2_.func_177984_a()).func_177230_c();
         return !var6.func_149637_q() && var5.func_149637_q() && func_176346_d(p_176341_1_.func_180495_p(var4.func_177984_a()))?BlockRedstoneWire.EnumAttachPosition.UP:BlockRedstoneWire.EnumAttachPosition.NONE;
      } else {
         return BlockRedstoneWire.EnumAttachPosition.SIDE;
      }
   }

   public AxisAlignedBB func_180640_a(World p_180640_1_, BlockPos p_180640_2_, IBlockState p_180640_3_) {
      return null;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public int func_180662_a(IBlockAccess p_180662_1_, BlockPos p_180662_2_, int p_180662_3_) {
      IBlockState var4 = p_180662_1_.func_180495_p(p_180662_2_);
      return var4.func_177230_c() != this?super.func_180662_a(p_180662_1_, p_180662_2_, p_180662_3_):this.func_176337_b(((Integer)var4.func_177229_b(field_176351_O)).intValue());
   }

   public boolean func_176196_c(World p_176196_1_, BlockPos p_176196_2_) {
      return World.func_175683_a(p_176196_1_, p_176196_2_.func_177977_b()) || p_176196_1_.func_180495_p(p_176196_2_.func_177977_b()).func_177230_c() == Blocks.field_150426_aN;
   }

   private IBlockState func_176338_e(World p_176338_1_, BlockPos p_176338_2_, IBlockState p_176338_3_) {
      p_176338_3_ = this.func_176345_a(p_176338_1_, p_176338_2_, p_176338_2_, p_176338_3_);
      ArrayList var4 = Lists.newArrayList(this.field_150179_b);
      this.field_150179_b.clear();
      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         BlockPos var6 = (BlockPos)var5.next();
         p_176338_1_.func_175685_c(var6, this);
      }

      return p_176338_3_;
   }

   private IBlockState func_176345_a(World p_176345_1_, BlockPos p_176345_2_, BlockPos p_176345_3_, IBlockState p_176345_4_) {
      IBlockState var5 = p_176345_4_;
      int var6 = ((Integer)p_176345_4_.func_177229_b(field_176351_O)).intValue();
      byte var7 = 0;
      int var14 = this.func_176342_a(p_176345_1_, p_176345_3_, var7);
      this.field_150181_a = false;
      int var8 = p_176345_1_.func_175687_A(p_176345_2_);
      this.field_150181_a = true;
      if(var8 > 0 && var8 > var14 - 1) {
         var14 = var8;
      }

      int var9 = 0;
      Iterator var10 = EnumFacing.Plane.HORIZONTAL.iterator();

      while(var10.hasNext()) {
         EnumFacing var11 = (EnumFacing)var10.next();
         BlockPos var12 = p_176345_2_.func_177972_a(var11);
         boolean var13 = var12.func_177958_n() != p_176345_3_.func_177958_n() || var12.func_177952_p() != p_176345_3_.func_177952_p();
         if(var13) {
            var9 = this.func_176342_a(p_176345_1_, var12, var9);
         }

         if(p_176345_1_.func_180495_p(var12).func_177230_c().func_149721_r() && !p_176345_1_.func_180495_p(p_176345_2_.func_177984_a()).func_177230_c().func_149721_r()) {
            if(var13 && p_176345_2_.func_177956_o() >= p_176345_3_.func_177956_o()) {
               var9 = this.func_176342_a(p_176345_1_, var12.func_177984_a(), var9);
            }
         } else if(!p_176345_1_.func_180495_p(var12).func_177230_c().func_149721_r() && var13 && p_176345_2_.func_177956_o() <= p_176345_3_.func_177956_o()) {
            var9 = this.func_176342_a(p_176345_1_, var12.func_177977_b(), var9);
         }
      }

      if(var9 > var14) {
         var14 = var9 - 1;
      } else if(var14 > 0) {
         --var14;
      } else {
         var14 = 0;
      }

      if(var8 > var14 - 1) {
         var14 = var8;
      }

      if(var6 != var14) {
         p_176345_4_ = p_176345_4_.func_177226_a(field_176351_O, Integer.valueOf(var14));
         if(p_176345_1_.func_180495_p(p_176345_2_) == var5) {
            p_176345_1_.func_180501_a(p_176345_2_, p_176345_4_, 2);
         }

         this.field_150179_b.add(p_176345_2_);
         EnumFacing[] var15 = EnumFacing.values();
         int var16 = var15.length;

         for(int var17 = 0; var17 < var16; ++var17) {
            EnumFacing var18 = var15[var17];
            this.field_150179_b.add(p_176345_2_.func_177972_a(var18));
         }
      }

      return p_176345_4_;
   }

   private void func_176344_d(World p_176344_1_, BlockPos p_176344_2_) {
      if(p_176344_1_.func_180495_p(p_176344_2_).func_177230_c() == this) {
         p_176344_1_.func_175685_c(p_176344_2_, this);
         EnumFacing[] var3 = EnumFacing.values();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            EnumFacing var6 = var3[var5];
            p_176344_1_.func_175685_c(p_176344_2_.func_177972_a(var6), this);
         }

      }
   }

   public void func_176213_c(World p_176213_1_, BlockPos p_176213_2_, IBlockState p_176213_3_) {
      if(!p_176213_1_.field_72995_K) {
         this.func_176338_e(p_176213_1_, p_176213_2_, p_176213_3_);
         Iterator var4 = EnumFacing.Plane.VERTICAL.iterator();

         EnumFacing var5;
         while(var4.hasNext()) {
            var5 = (EnumFacing)var4.next();
            p_176213_1_.func_175685_c(p_176213_2_.func_177972_a(var5), this);
         }

         var4 = EnumFacing.Plane.HORIZONTAL.iterator();

         while(var4.hasNext()) {
            var5 = (EnumFacing)var4.next();
            this.func_176344_d(p_176213_1_, p_176213_2_.func_177972_a(var5));
         }

         var4 = EnumFacing.Plane.HORIZONTAL.iterator();

         while(var4.hasNext()) {
            var5 = (EnumFacing)var4.next();
            BlockPos var6 = p_176213_2_.func_177972_a(var5);
            if(p_176213_1_.func_180495_p(var6).func_177230_c().func_149721_r()) {
               this.func_176344_d(p_176213_1_, var6.func_177984_a());
            } else {
               this.func_176344_d(p_176213_1_, var6.func_177977_b());
            }
         }

      }
   }

   public void func_180663_b(World p_180663_1_, BlockPos p_180663_2_, IBlockState p_180663_3_) {
      super.func_180663_b(p_180663_1_, p_180663_2_, p_180663_3_);
      if(!p_180663_1_.field_72995_K) {
         EnumFacing[] var4 = EnumFacing.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            EnumFacing var7 = var4[var6];
            p_180663_1_.func_175685_c(p_180663_2_.func_177972_a(var7), this);
         }

         this.func_176338_e(p_180663_1_, p_180663_2_, p_180663_3_);
         Iterator var8 = EnumFacing.Plane.HORIZONTAL.iterator();

         EnumFacing var9;
         while(var8.hasNext()) {
            var9 = (EnumFacing)var8.next();
            this.func_176344_d(p_180663_1_, p_180663_2_.func_177972_a(var9));
         }

         var8 = EnumFacing.Plane.HORIZONTAL.iterator();

         while(var8.hasNext()) {
            var9 = (EnumFacing)var8.next();
            BlockPos var10 = p_180663_2_.func_177972_a(var9);
            if(p_180663_1_.func_180495_p(var10).func_177230_c().func_149721_r()) {
               this.func_176344_d(p_180663_1_, var10.func_177984_a());
            } else {
               this.func_176344_d(p_180663_1_, var10.func_177977_b());
            }
         }

      }
   }

   private int func_176342_a(World p_176342_1_, BlockPos p_176342_2_, int p_176342_3_) {
      if(p_176342_1_.func_180495_p(p_176342_2_).func_177230_c() != this) {
         return p_176342_3_;
      } else {
         int var4 = ((Integer)p_176342_1_.func_180495_p(p_176342_2_).func_177229_b(field_176351_O)).intValue();
         return var4 > p_176342_3_?var4:p_176342_3_;
      }
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      if(!p_176204_1_.field_72995_K) {
         if(this.func_176196_c(p_176204_1_, p_176204_2_)) {
            this.func_176338_e(p_176204_1_, p_176204_2_, p_176204_3_);
         } else {
            this.func_176226_b(p_176204_1_, p_176204_2_, p_176204_3_, 0);
            p_176204_1_.func_175698_g(p_176204_2_);
         }

      }
   }

   public Item func_180660_a(IBlockState p_180660_1_, Random p_180660_2_, int p_180660_3_) {
      return Items.field_151137_ax;
   }

   public int func_176211_b(IBlockAccess p_176211_1_, BlockPos p_176211_2_, IBlockState p_176211_3_, EnumFacing p_176211_4_) {
      return !this.field_150181_a?0:this.func_180656_a(p_176211_1_, p_176211_2_, p_176211_3_, p_176211_4_);
   }

   public int func_180656_a(IBlockAccess p_180656_1_, BlockPos p_180656_2_, IBlockState p_180656_3_, EnumFacing p_180656_4_) {
      if(!this.field_150181_a) {
         return 0;
      } else {
         int var5 = ((Integer)p_180656_3_.func_177229_b(field_176351_O)).intValue();
         if(var5 == 0) {
            return 0;
         } else if(p_180656_4_ == EnumFacing.UP) {
            return var5;
         } else {
            EnumSet var6 = EnumSet.noneOf(EnumFacing.class);
            Iterator var7 = EnumFacing.Plane.HORIZONTAL.iterator();

            while(var7.hasNext()) {
               EnumFacing var8 = (EnumFacing)var7.next();
               if(this.func_176339_d(p_180656_1_, p_180656_2_, var8)) {
                  var6.add(var8);
               }
            }

            if(p_180656_4_.func_176740_k().func_176722_c() && var6.isEmpty()) {
               return var5;
            } else if(var6.contains(p_180656_4_) && !var6.contains(p_180656_4_.func_176735_f()) && !var6.contains(p_180656_4_.func_176746_e())) {
               return var5;
            } else {
               return 0;
            }
         }
      }
   }

   private boolean func_176339_d(IBlockAccess p_176339_1_, BlockPos p_176339_2_, EnumFacing p_176339_3_) {
      BlockPos var4 = p_176339_2_.func_177972_a(p_176339_3_);
      IBlockState var5 = p_176339_1_.func_180495_p(var4);
      Block var6 = var5.func_177230_c();
      boolean var7 = var6.func_149721_r();
      boolean var8 = p_176339_1_.func_180495_p(p_176339_2_.func_177984_a()).func_177230_c().func_149721_r();
      return !var8 && var7 && func_176340_e(p_176339_1_, var4.func_177984_a())?true:(func_176343_a(var5, p_176339_3_)?true:(var6 == Blocks.field_150416_aS && var5.func_177229_b(BlockRedstoneDiode.field_176387_N) == p_176339_3_?true:!var7 && func_176340_e(p_176339_1_, var4.func_177977_b())));
   }

   protected static boolean func_176340_e(IBlockAccess p_176340_0_, BlockPos p_176340_1_) {
      return func_176346_d(p_176340_0_.func_180495_p(p_176340_1_));
   }

   protected static boolean func_176346_d(IBlockState p_176346_0_) {
      return func_176343_a(p_176346_0_, (EnumFacing)null);
   }

   protected static boolean func_176343_a(IBlockState p_176343_0_, EnumFacing p_176343_1_) {
      Block var2 = p_176343_0_.func_177230_c();
      if(var2 == Blocks.field_150488_af) {
         return true;
      } else if(Blocks.field_150413_aR.func_149907_e(var2)) {
         EnumFacing var3 = (EnumFacing)p_176343_0_.func_177229_b(BlockRedstoneRepeater.field_176387_N);
         return var3 == p_176343_1_ || var3.func_176734_d() == p_176343_1_;
      } else {
         return var2.func_149744_f() && p_176343_1_ != null;
      }
   }

   public boolean func_149744_f() {
      return this.field_150181_a;
   }

   private int func_176337_b(int p_176337_1_) {
      float var2 = (float)p_176337_1_ / 15.0F;
      float var3 = var2 * 0.6F + 0.4F;
      if(p_176337_1_ == 0) {
         var3 = 0.3F;
      }

      float var4 = var2 * var2 * 0.7F - 0.5F;
      float var5 = var2 * var2 * 0.6F - 0.7F;
      if(var4 < 0.0F) {
         var4 = 0.0F;
      }

      if(var5 < 0.0F) {
         var5 = 0.0F;
      }

      int var6 = MathHelper.func_76125_a((int)(var3 * 255.0F), 0, 255);
      int var7 = MathHelper.func_76125_a((int)(var4 * 255.0F), 0, 255);
      int var8 = MathHelper.func_76125_a((int)(var5 * 255.0F), 0, 255);
      return -16777216 | var6 << 16 | var7 << 8 | var8;
   }

   public void func_180655_c(World p_180655_1_, BlockPos p_180655_2_, IBlockState p_180655_3_, Random p_180655_4_) {
      int var5 = ((Integer)p_180655_3_.func_177229_b(field_176351_O)).intValue();
      if(var5 != 0) {
         double var6 = (double)p_180655_2_.func_177958_n() + 0.5D + ((double)p_180655_4_.nextFloat() - 0.5D) * 0.2D;
         double var8 = (double)((float)p_180655_2_.func_177956_o() + 0.0625F);
         double var10 = (double)p_180655_2_.func_177952_p() + 0.5D + ((double)p_180655_4_.nextFloat() - 0.5D) * 0.2D;
         float var12 = (float)var5 / 15.0F;
         float var13 = var12 * 0.6F + 0.4F;
         float var14 = Math.max(0.0F, var12 * var12 * 0.7F - 0.5F);
         float var15 = Math.max(0.0F, var12 * var12 * 0.6F - 0.7F);
         p_180655_1_.func_175688_a(EnumParticleTypes.REDSTONE, var6, var8, var10, (double)var13, (double)var14, (double)var15, new int[0]);
      }
   }

   public Item func_180665_b(World p_180665_1_, BlockPos p_180665_2_) {
      return Items.field_151137_ax;
   }

   public EnumWorldBlockLayer func_180664_k() {
      return EnumWorldBlockLayer.CUTOUT;
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176351_O, Integer.valueOf(p_176203_1_));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((Integer)p_176201_1_.func_177229_b(field_176351_O)).intValue();
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176348_a, field_176347_b, field_176349_M, field_176350_N, field_176351_O});
   }


   static enum EnumAttachPosition implements IStringSerializable {

      UP("UP", 0, "up"),
      SIDE("SIDE", 1, "side"),
      NONE("NONE", 2, "none");
      private final String field_176820_d;
      // $FF: synthetic field
      private static final BlockRedstoneWire.EnumAttachPosition[] $VALUES = new BlockRedstoneWire.EnumAttachPosition[]{UP, SIDE, NONE};
      private static final String __OBFID = "CL_00002070";


      private EnumAttachPosition(String p_i45689_1_, int p_i45689_2_, String p_i45689_3_) {
         this.field_176820_d = p_i45689_3_;
      }

      public String toString() {
         return this.func_176610_l();
      }

      public String func_176610_l() {
         return this.field_176820_d;
      }

   }
}
