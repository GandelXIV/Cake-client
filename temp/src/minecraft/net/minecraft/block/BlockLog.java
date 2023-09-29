package net.minecraft.block;

import java.util.Iterator;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;

public abstract class BlockLog extends BlockRotatedPillar {

   public static final PropertyEnum field_176299_a = PropertyEnum.func_177709_a("axis", BlockLog.EnumAxis.class);
   private static final String __OBFID = "CL_00000266";


   public BlockLog() {
      super(Material.field_151575_d);
      this.func_149647_a(CreativeTabs.field_78030_b);
      this.func_149711_c(2.0F);
      this.func_149672_a(field_149766_f);
   }

   public void func_180663_b(World p_180663_1_, BlockPos p_180663_2_, IBlockState p_180663_3_) {
      byte var4 = 4;
      int var5 = var4 + 1;
      if(p_180663_1_.func_175707_a(p_180663_2_.func_177982_a(-var5, -var5, -var5), p_180663_2_.func_177982_a(var5, var5, var5))) {
         Iterator var6 = BlockPos.func_177980_a(p_180663_2_.func_177982_a(-var4, -var4, -var4), p_180663_2_.func_177982_a(var4, var4, var4)).iterator();

         while(var6.hasNext()) {
            BlockPos var7 = (BlockPos)var6.next();
            IBlockState var8 = p_180663_1_.func_180495_p(var7);
            if(var8.func_177230_c().func_149688_o() == Material.field_151584_j && !((Boolean)var8.func_177229_b(BlockLeaves.field_176236_b)).booleanValue()) {
               p_180663_1_.func_180501_a(var7, var8.func_177226_a(BlockLeaves.field_176236_b, Boolean.valueOf(true)), 4);
            }
         }

      }
   }

   public IBlockState func_180642_a(World p_180642_1_, BlockPos p_180642_2_, EnumFacing p_180642_3_, float p_180642_4_, float p_180642_5_, float p_180642_6_, int p_180642_7_, EntityLivingBase p_180642_8_) {
      return super.func_180642_a(p_180642_1_, p_180642_2_, p_180642_3_, p_180642_4_, p_180642_5_, p_180642_6_, p_180642_7_, p_180642_8_).func_177226_a(field_176299_a, BlockLog.EnumAxis.func_176870_a(p_180642_3_.func_176740_k()));
   }


   public static enum EnumAxis implements IStringSerializable {

      X("X", 0, "x"),
      Y("Y", 1, "y"),
      Z("Z", 2, "z"),
      NONE("NONE", 3, "none");
      private final String field_176874_e;
      // $FF: synthetic field
      private static final BlockLog.EnumAxis[] $VALUES = new BlockLog.EnumAxis[]{X, Y, Z, NONE};
      private static final String __OBFID = "CL_00002100";


      private EnumAxis(String p_i45708_1_, int p_i45708_2_, String p_i45708_3_) {
         this.field_176874_e = p_i45708_3_;
      }

      public String toString() {
         return this.field_176874_e;
      }

      public static BlockLog.EnumAxis func_176870_a(EnumFacing.Axis p_176870_0_) {
         switch(BlockLog.SwitchAxis.field_180167_a[p_176870_0_.ordinal()]) {
         case 1:
            return X;
         case 2:
            return Y;
         case 3:
            return Z;
         default:
            return NONE;
         }
      }

      public String func_176610_l() {
         return this.field_176874_e;
      }

   }

   // $FF: synthetic class
   static final class SwitchAxis {

      // $FF: synthetic field
      static final int[] field_180167_a = new int[EnumFacing.Axis.values().length];
      private static final String __OBFID = "CL_00002101";


      static {
         try {
            field_180167_a[EnumFacing.Axis.X.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_180167_a[EnumFacing.Axis.Y.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_180167_a[EnumFacing.Axis.Z.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
