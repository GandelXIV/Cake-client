package net.minecraft.block;

import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLever extends Block {

   public static final PropertyEnum field_176360_a = PropertyEnum.func_177709_a("facing", BlockLever.EnumOrientation.class);
   public static final PropertyBool field_176359_b = PropertyBool.func_177716_a("powered");
   private static final String __OBFID = "CL_00000264";


   protected BlockLever() {
      super(Material.field_151594_q);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176360_a, BlockLever.EnumOrientation.NORTH).func_177226_a(field_176359_b, Boolean.valueOf(false)));
      this.func_149647_a(CreativeTabs.field_78028_d);
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

   public boolean func_176198_a(World p_176198_1_, BlockPos p_176198_2_, EnumFacing p_176198_3_) {
      return p_176198_3_ == EnumFacing.UP && World.func_175683_a(p_176198_1_, p_176198_2_.func_177977_b())?true:this.func_176358_d(p_176198_1_, p_176198_2_.func_177972_a(p_176198_3_.func_176734_d()));
   }

   public boolean func_176196_c(World p_176196_1_, BlockPos p_176196_2_) {
      return this.func_176358_d(p_176196_1_, p_176196_2_.func_177976_e())?true:(this.func_176358_d(p_176196_1_, p_176196_2_.func_177974_f())?true:(this.func_176358_d(p_176196_1_, p_176196_2_.func_177978_c())?true:(this.func_176358_d(p_176196_1_, p_176196_2_.func_177968_d())?true:(World.func_175683_a(p_176196_1_, p_176196_2_.func_177977_b())?true:this.func_176358_d(p_176196_1_, p_176196_2_.func_177984_a())))));
   }

   protected boolean func_176358_d(World p_176358_1_, BlockPos p_176358_2_) {
      return p_176358_1_.func_180495_p(p_176358_2_).func_177230_c().func_149721_r();
   }

   public IBlockState func_180642_a(World p_180642_1_, BlockPos p_180642_2_, EnumFacing p_180642_3_, float p_180642_4_, float p_180642_5_, float p_180642_6_, int p_180642_7_, EntityLivingBase p_180642_8_) {
      IBlockState var9 = this.func_176223_P().func_177226_a(field_176359_b, Boolean.valueOf(false));
      if(this.func_176358_d(p_180642_1_, p_180642_2_.func_177972_a(p_180642_3_.func_176734_d()))) {
         return var9.func_177226_a(field_176360_a, BlockLever.EnumOrientation.func_176856_a(p_180642_3_, p_180642_8_.func_174811_aO()));
      } else {
         Iterator var10 = EnumFacing.Plane.HORIZONTAL.iterator();

         EnumFacing var11;
         do {
            if(!var10.hasNext()) {
               if(World.func_175683_a(p_180642_1_, p_180642_2_.func_177977_b())) {
                  return var9.func_177226_a(field_176360_a, BlockLever.EnumOrientation.func_176856_a(EnumFacing.UP, p_180642_8_.func_174811_aO()));
               }

               return var9;
            }

            var11 = (EnumFacing)var10.next();
         } while(var11 == p_180642_3_ || !this.func_176358_d(p_180642_1_, p_180642_2_.func_177972_a(var11.func_176734_d())));

         return var9.func_177226_a(field_176360_a, BlockLever.EnumOrientation.func_176856_a(var11, p_180642_8_.func_174811_aO()));
      }
   }

   public static int func_176357_a(EnumFacing p_176357_0_) {
      switch(BlockLever.SwitchEnumFacing.field_180165_a[p_176357_0_.ordinal()]) {
      case 1:
         return 0;
      case 2:
         return 5;
      case 3:
         return 4;
      case 4:
         return 3;
      case 5:
         return 2;
      case 6:
         return 1;
      default:
         return -1;
      }
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      if(this.func_176356_e(p_176204_1_, p_176204_2_) && !this.func_176358_d(p_176204_1_, p_176204_2_.func_177972_a(((BlockLever.EnumOrientation)p_176204_3_.func_177229_b(field_176360_a)).func_176852_c().func_176734_d()))) {
         this.func_176226_b(p_176204_1_, p_176204_2_, p_176204_3_, 0);
         p_176204_1_.func_175698_g(p_176204_2_);
      }

   }

   private boolean func_176356_e(World p_176356_1_, BlockPos p_176356_2_) {
      if(this.func_176196_c(p_176356_1_, p_176356_2_)) {
         return true;
      } else {
         this.func_176226_b(p_176356_1_, p_176356_2_, p_176356_1_.func_180495_p(p_176356_2_), 0);
         p_176356_1_.func_175698_g(p_176356_2_);
         return false;
      }
   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      float var3 = 0.1875F;
      switch(BlockLever.SwitchEnumFacing.field_180163_b[((BlockLever.EnumOrientation)p_180654_1_.func_180495_p(p_180654_2_).func_177229_b(field_176360_a)).ordinal()]) {
      case 1:
         this.func_149676_a(0.0F, 0.2F, 0.5F - var3, var3 * 2.0F, 0.8F, 0.5F + var3);
         break;
      case 2:
         this.func_149676_a(1.0F - var3 * 2.0F, 0.2F, 0.5F - var3, 1.0F, 0.8F, 0.5F + var3);
         break;
      case 3:
         this.func_149676_a(0.5F - var3, 0.2F, 0.0F, 0.5F + var3, 0.8F, var3 * 2.0F);
         break;
      case 4:
         this.func_149676_a(0.5F - var3, 0.2F, 1.0F - var3 * 2.0F, 0.5F + var3, 0.8F, 1.0F);
         break;
      case 5:
      case 6:
         var3 = 0.25F;
         this.func_149676_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.6F, 0.5F + var3);
         break;
      case 7:
      case 8:
         var3 = 0.25F;
         this.func_149676_a(0.5F - var3, 0.4F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
      }

   }

   public boolean func_180639_a(World p_180639_1_, BlockPos p_180639_2_, IBlockState p_180639_3_, EntityPlayer p_180639_4_, EnumFacing p_180639_5_, float p_180639_6_, float p_180639_7_, float p_180639_8_) {
      if(p_180639_1_.field_72995_K) {
         return true;
      } else {
         p_180639_3_ = p_180639_3_.func_177231_a(field_176359_b);
         p_180639_1_.func_180501_a(p_180639_2_, p_180639_3_, 3);
         p_180639_1_.func_72908_a((double)p_180639_2_.func_177958_n() + 0.5D, (double)p_180639_2_.func_177956_o() + 0.5D, (double)p_180639_2_.func_177952_p() + 0.5D, "random.click", 0.3F, ((Boolean)p_180639_3_.func_177229_b(field_176359_b)).booleanValue()?0.6F:0.5F);
         p_180639_1_.func_175685_c(p_180639_2_, this);
         EnumFacing var9 = ((BlockLever.EnumOrientation)p_180639_3_.func_177229_b(field_176360_a)).func_176852_c();
         p_180639_1_.func_175685_c(p_180639_2_.func_177972_a(var9.func_176734_d()), this);
         return true;
      }
   }

   public void func_180663_b(World p_180663_1_, BlockPos p_180663_2_, IBlockState p_180663_3_) {
      if(((Boolean)p_180663_3_.func_177229_b(field_176359_b)).booleanValue()) {
         p_180663_1_.func_175685_c(p_180663_2_, this);
         EnumFacing var4 = ((BlockLever.EnumOrientation)p_180663_3_.func_177229_b(field_176360_a)).func_176852_c();
         p_180663_1_.func_175685_c(p_180663_2_.func_177972_a(var4.func_176734_d()), this);
      }

      super.func_180663_b(p_180663_1_, p_180663_2_, p_180663_3_);
   }

   public int func_180656_a(IBlockAccess p_180656_1_, BlockPos p_180656_2_, IBlockState p_180656_3_, EnumFacing p_180656_4_) {
      return ((Boolean)p_180656_3_.func_177229_b(field_176359_b)).booleanValue()?15:0;
   }

   public int func_176211_b(IBlockAccess p_176211_1_, BlockPos p_176211_2_, IBlockState p_176211_3_, EnumFacing p_176211_4_) {
      return !((Boolean)p_176211_3_.func_177229_b(field_176359_b)).booleanValue()?0:(((BlockLever.EnumOrientation)p_176211_3_.func_177229_b(field_176360_a)).func_176852_c() == p_176211_4_?15:0);
   }

   public boolean func_149744_f() {
      return true;
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176360_a, BlockLever.EnumOrientation.func_176853_a(p_176203_1_ & 7)).func_177226_a(field_176359_b, Boolean.valueOf((p_176203_1_ & 8) > 0));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      byte var2 = 0;
      int var3 = var2 | ((BlockLever.EnumOrientation)p_176201_1_.func_177229_b(field_176360_a)).func_176855_a();
      if(((Boolean)p_176201_1_.func_177229_b(field_176359_b)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176360_a, field_176359_b});
   }


   public static enum EnumOrientation implements IStringSerializable {

      DOWN_X("DOWN_X", 0, 0, "down_x", EnumFacing.DOWN),
      EAST("EAST", 1, 1, "east", EnumFacing.EAST),
      WEST("WEST", 2, 2, "west", EnumFacing.WEST),
      SOUTH("SOUTH", 3, 3, "south", EnumFacing.SOUTH),
      NORTH("NORTH", 4, 4, "north", EnumFacing.NORTH),
      UP_Z("UP_Z", 5, 5, "up_z", EnumFacing.UP),
      UP_X("UP_X", 6, 6, "up_x", EnumFacing.UP),
      DOWN_Z("DOWN_Z", 7, 7, "down_z", EnumFacing.DOWN);
      private static final BlockLever.EnumOrientation[] field_176869_i = new BlockLever.EnumOrientation[values().length];
      private final int field_176866_j;
      private final String field_176867_k;
      private final EnumFacing field_176864_l;
      // $FF: synthetic field
      private static final BlockLever.EnumOrientation[] $VALUES = new BlockLever.EnumOrientation[]{DOWN_X, EAST, WEST, SOUTH, NORTH, UP_Z, UP_X, DOWN_Z};
      private static final String __OBFID = "CL_00002102";


      private EnumOrientation(String p_i45709_1_, int p_i45709_2_, int p_i45709_3_, String p_i45709_4_, EnumFacing p_i45709_5_) {
         this.field_176866_j = p_i45709_3_;
         this.field_176867_k = p_i45709_4_;
         this.field_176864_l = p_i45709_5_;
      }

      public int func_176855_a() {
         return this.field_176866_j;
      }

      public EnumFacing func_176852_c() {
         return this.field_176864_l;
      }

      public String toString() {
         return this.field_176867_k;
      }

      public static BlockLever.EnumOrientation func_176853_a(int p_176853_0_) {
         if(p_176853_0_ < 0 || p_176853_0_ >= field_176869_i.length) {
            p_176853_0_ = 0;
         }

         return field_176869_i[p_176853_0_];
      }

      public static BlockLever.EnumOrientation func_176856_a(EnumFacing p_176856_0_, EnumFacing p_176856_1_) {
         switch(BlockLever.SwitchEnumFacing.field_180165_a[p_176856_0_.ordinal()]) {
         case 1:
            switch(BlockLever.SwitchEnumFacing.field_180164_c[p_176856_1_.func_176740_k().ordinal()]) {
            case 1:
               return DOWN_X;
            case 2:
               return DOWN_Z;
            default:
               throw new IllegalArgumentException("Invalid entityFacing " + p_176856_1_ + " for facing " + p_176856_0_);
            }
         case 2:
            switch(BlockLever.SwitchEnumFacing.field_180164_c[p_176856_1_.func_176740_k().ordinal()]) {
            case 1:
               return UP_X;
            case 2:
               return UP_Z;
            default:
               throw new IllegalArgumentException("Invalid entityFacing " + p_176856_1_ + " for facing " + p_176856_0_);
            }
         case 3:
            return NORTH;
         case 4:
            return SOUTH;
         case 5:
            return WEST;
         case 6:
            return EAST;
         default:
            throw new IllegalArgumentException("Invalid facing: " + p_176856_0_);
         }
      }

      public String func_176610_l() {
         return this.field_176867_k;
      }

      static {
         BlockLever.EnumOrientation[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            BlockLever.EnumOrientation var3 = var0[var2];
            field_176869_i[var3.func_176855_a()] = var3;
         }

      }
   }

   // $FF: synthetic class
   static final class SwitchEnumFacing {

      // $FF: synthetic field
      static final int[] field_180165_a;
      // $FF: synthetic field
      static final int[] field_180163_b;
      // $FF: synthetic field
      static final int[] field_180164_c = new int[EnumFacing.Axis.values().length];
      private static final String __OBFID = "CL_00002103";


      static {
         try {
            field_180164_c[EnumFacing.Axis.X.ordinal()] = 1;
         } catch (NoSuchFieldError var16) {
            ;
         }

         try {
            field_180164_c[EnumFacing.Axis.Z.ordinal()] = 2;
         } catch (NoSuchFieldError var15) {
            ;
         }

         field_180163_b = new int[BlockLever.EnumOrientation.values().length];

         try {
            field_180163_b[BlockLever.EnumOrientation.EAST.ordinal()] = 1;
         } catch (NoSuchFieldError var14) {
            ;
         }

         try {
            field_180163_b[BlockLever.EnumOrientation.WEST.ordinal()] = 2;
         } catch (NoSuchFieldError var13) {
            ;
         }

         try {
            field_180163_b[BlockLever.EnumOrientation.SOUTH.ordinal()] = 3;
         } catch (NoSuchFieldError var12) {
            ;
         }

         try {
            field_180163_b[BlockLever.EnumOrientation.NORTH.ordinal()] = 4;
         } catch (NoSuchFieldError var11) {
            ;
         }

         try {
            field_180163_b[BlockLever.EnumOrientation.UP_Z.ordinal()] = 5;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            field_180163_b[BlockLever.EnumOrientation.UP_X.ordinal()] = 6;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            field_180163_b[BlockLever.EnumOrientation.DOWN_X.ordinal()] = 7;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            field_180163_b[BlockLever.EnumOrientation.DOWN_Z.ordinal()] = 8;
         } catch (NoSuchFieldError var7) {
            ;
         }

         field_180165_a = new int[EnumFacing.values().length];

         try {
            field_180165_a[EnumFacing.DOWN.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            field_180165_a[EnumFacing.UP.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            field_180165_a[EnumFacing.NORTH.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_180165_a[EnumFacing.SOUTH.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_180165_a[EnumFacing.WEST.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_180165_a[EnumFacing.EAST.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
