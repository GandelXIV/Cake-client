package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTrapDoor extends Block {

   public static final PropertyDirection field_176284_a = PropertyDirection.func_177712_a("facing", EnumFacing.Plane.HORIZONTAL);
   public static final PropertyBool field_176283_b = PropertyBool.func_177716_a("open");
   public static final PropertyEnum field_176285_M = PropertyEnum.func_177709_a("half", BlockTrapDoor.DoorHalf.class);
   private static final String __OBFID = "CL_00000327";


   protected BlockTrapDoor(Material p_i45434_1_) {
      super(p_i45434_1_);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176284_a, EnumFacing.NORTH).func_177226_a(field_176283_b, Boolean.valueOf(false)).func_177226_a(field_176285_M, BlockTrapDoor.DoorHalf.BOTTOM));
      float var2 = 0.5F;
      float var3 = 1.0F;
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      this.func_149647_a(CreativeTabs.field_78028_d);
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_176205_b(IBlockAccess p_176205_1_, BlockPos p_176205_2_) {
      return !((Boolean)p_176205_1_.func_180495_p(p_176205_2_).func_177229_b(field_176283_b)).booleanValue();
   }

   public AxisAlignedBB func_180646_a(World p_180646_1_, BlockPos p_180646_2_) {
      this.func_180654_a(p_180646_1_, p_180646_2_);
      return super.func_180646_a(p_180646_1_, p_180646_2_);
   }

   public AxisAlignedBB func_180640_a(World p_180640_1_, BlockPos p_180640_2_, IBlockState p_180640_3_) {
      this.func_180654_a(p_180640_1_, p_180640_2_);
      return super.func_180640_a(p_180640_1_, p_180640_2_, p_180640_3_);
   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      this.func_180693_d(p_180654_1_.func_180495_p(p_180654_2_));
   }

   public void func_149683_g() {
      float var1 = 0.1875F;
      this.func_149676_a(0.0F, 0.40625F, 0.0F, 1.0F, 0.59375F, 1.0F);
   }

   public void func_180693_d(IBlockState p_180693_1_) {
      if(p_180693_1_.func_177230_c() == this) {
         boolean var2 = p_180693_1_.func_177229_b(field_176285_M) == BlockTrapDoor.DoorHalf.TOP;
         Boolean var3 = (Boolean)p_180693_1_.func_177229_b(field_176283_b);
         EnumFacing var4 = (EnumFacing)p_180693_1_.func_177229_b(field_176284_a);
         float var5 = 0.1875F;
         if(var2) {
            this.func_149676_a(0.0F, 0.8125F, 0.0F, 1.0F, 1.0F, 1.0F);
         } else {
            this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.1875F, 1.0F);
         }

         if(var3.booleanValue()) {
            if(var4 == EnumFacing.NORTH) {
               this.func_149676_a(0.0F, 0.0F, 0.8125F, 1.0F, 1.0F, 1.0F);
            }

            if(var4 == EnumFacing.SOUTH) {
               this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1875F);
            }

            if(var4 == EnumFacing.WEST) {
               this.func_149676_a(0.8125F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }

            if(var4 == EnumFacing.EAST) {
               this.func_149676_a(0.0F, 0.0F, 0.0F, 0.1875F, 1.0F, 1.0F);
            }
         }

      }
   }

   public boolean func_180639_a(World p_180639_1_, BlockPos p_180639_2_, IBlockState p_180639_3_, EntityPlayer p_180639_4_, EnumFacing p_180639_5_, float p_180639_6_, float p_180639_7_, float p_180639_8_) {
      if(this.field_149764_J == Material.field_151573_f) {
         return true;
      } else {
         p_180639_3_ = p_180639_3_.func_177231_a(field_176283_b);
         p_180639_1_.func_180501_a(p_180639_2_, p_180639_3_, 2);
         p_180639_1_.func_180498_a(p_180639_4_, ((Boolean)p_180639_3_.func_177229_b(field_176283_b)).booleanValue()?1003:1006, p_180639_2_, 0);
         return true;
      }
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      if(!p_176204_1_.field_72995_K) {
         BlockPos var5 = p_176204_2_.func_177972_a(((EnumFacing)p_176204_3_.func_177229_b(field_176284_a)).func_176734_d());
         if(!func_150119_a(p_176204_1_.func_180495_p(var5).func_177230_c())) {
            p_176204_1_.func_175698_g(p_176204_2_);
            this.func_176226_b(p_176204_1_, p_176204_2_, p_176204_3_, 0);
         } else {
            boolean var6 = p_176204_1_.func_175640_z(p_176204_2_);
            if(var6 || p_176204_4_.func_149744_f()) {
               boolean var7 = ((Boolean)p_176204_3_.func_177229_b(field_176283_b)).booleanValue();
               if(var7 != var6) {
                  p_176204_1_.func_180501_a(p_176204_2_, p_176204_3_.func_177226_a(field_176283_b, Boolean.valueOf(var6)), 2);
                  p_176204_1_.func_180498_a((EntityPlayer)null, var6?1003:1006, p_176204_2_, 0);
               }
            }

         }
      }
   }

   public MovingObjectPosition func_180636_a(World p_180636_1_, BlockPos p_180636_2_, Vec3 p_180636_3_, Vec3 p_180636_4_) {
      this.func_180654_a(p_180636_1_, p_180636_2_);
      return super.func_180636_a(p_180636_1_, p_180636_2_, p_180636_3_, p_180636_4_);
   }

   public IBlockState func_180642_a(World p_180642_1_, BlockPos p_180642_2_, EnumFacing p_180642_3_, float p_180642_4_, float p_180642_5_, float p_180642_6_, int p_180642_7_, EntityLivingBase p_180642_8_) {
      IBlockState var9 = this.func_176223_P();
      if(p_180642_3_.func_176740_k().func_176722_c()) {
         var9 = var9.func_177226_a(field_176284_a, p_180642_3_).func_177226_a(field_176283_b, Boolean.valueOf(false));
         var9 = var9.func_177226_a(field_176285_M, p_180642_5_ > 0.5F?BlockTrapDoor.DoorHalf.TOP:BlockTrapDoor.DoorHalf.BOTTOM);
      }

      return var9;
   }

   public boolean func_176198_a(World p_176198_1_, BlockPos p_176198_2_, EnumFacing p_176198_3_) {
      return !p_176198_3_.func_176740_k().func_176720_b() && func_150119_a(p_176198_1_.func_180495_p(p_176198_2_.func_177972_a(p_176198_3_.func_176734_d())).func_177230_c());
   }

   protected static EnumFacing func_176281_b(int p_176281_0_) {
      switch(p_176281_0_ & 3) {
      case 0:
         return EnumFacing.NORTH;
      case 1:
         return EnumFacing.SOUTH;
      case 2:
         return EnumFacing.WEST;
      case 3:
      default:
         return EnumFacing.EAST;
      }
   }

   protected static int func_176282_a(EnumFacing p_176282_0_) {
      switch(BlockTrapDoor.SwitchEnumFacing.field_177058_a[p_176282_0_.ordinal()]) {
      case 1:
         return 0;
      case 2:
         return 1;
      case 3:
         return 2;
      case 4:
      default:
         return 3;
      }
   }

   private static boolean func_150119_a(Block p_150119_0_) {
      return p_150119_0_.field_149764_J.func_76218_k() && p_150119_0_.func_149686_d() || p_150119_0_ == Blocks.field_150426_aN || p_150119_0_ instanceof BlockSlab || p_150119_0_ instanceof BlockStairs;
   }

   public EnumWorldBlockLayer func_180664_k() {
      return EnumWorldBlockLayer.CUTOUT;
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176284_a, func_176281_b(p_176203_1_)).func_177226_a(field_176283_b, Boolean.valueOf((p_176203_1_ & 4) != 0)).func_177226_a(field_176285_M, (p_176203_1_ & 8) == 0?BlockTrapDoor.DoorHalf.BOTTOM:BlockTrapDoor.DoorHalf.TOP);
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      byte var2 = 0;
      int var3 = var2 | func_176282_a((EnumFacing)p_176201_1_.func_177229_b(field_176284_a));
      if(((Boolean)p_176201_1_.func_177229_b(field_176283_b)).booleanValue()) {
         var3 |= 4;
      }

      if(p_176201_1_.func_177229_b(field_176285_M) == BlockTrapDoor.DoorHalf.TOP) {
         var3 |= 8;
      }

      return var3;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176284_a, field_176283_b, field_176285_M});
   }


   public static enum DoorHalf implements IStringSerializable {

      TOP("TOP", 0, "top"),
      BOTTOM("BOTTOM", 1, "bottom");
      private final String field_176671_c;
      // $FF: synthetic field
      private static final BlockTrapDoor.DoorHalf[] $VALUES = new BlockTrapDoor.DoorHalf[]{TOP, BOTTOM};
      private static final String __OBFID = "CL_00002051";


      private DoorHalf(String p_i45674_1_, int p_i45674_2_, String p_i45674_3_) {
         this.field_176671_c = p_i45674_3_;
      }

      public String toString() {
         return this.field_176671_c;
      }

      public String func_176610_l() {
         return this.field_176671_c;
      }

   }

   // $FF: synthetic class
   static final class SwitchEnumFacing {

      // $FF: synthetic field
      static final int[] field_177058_a = new int[EnumFacing.values().length];
      private static final String __OBFID = "CL_00002052";


      static {
         try {
            field_177058_a[EnumFacing.NORTH.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_177058_a[EnumFacing.SOUTH.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_177058_a[EnumFacing.WEST.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_177058_a[EnumFacing.EAST.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
