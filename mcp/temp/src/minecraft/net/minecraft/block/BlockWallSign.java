package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSign;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWallSign extends BlockSign {

   public static final PropertyDirection field_176412_a = PropertyDirection.func_177712_a("facing", EnumFacing.Plane.HORIZONTAL);
   private static final String __OBFID = "CL_00002047";


   public BlockWallSign() {
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176412_a, EnumFacing.NORTH));
   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      EnumFacing var3 = (EnumFacing)p_180654_1_.func_180495_p(p_180654_2_).func_177229_b(field_176412_a);
      float var4 = 0.28125F;
      float var5 = 0.78125F;
      float var6 = 0.0F;
      float var7 = 1.0F;
      float var8 = 0.125F;
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      switch(BlockWallSign.SwitchEnumFacing.field_177331_a[var3.ordinal()]) {
      case 1:
         this.func_149676_a(var6, var4, 1.0F - var8, var7, var5, 1.0F);
         break;
      case 2:
         this.func_149676_a(var6, var4, 0.0F, var7, var5, var8);
         break;
      case 3:
         this.func_149676_a(1.0F - var8, var4, var6, 1.0F, var5, var7);
         break;
      case 4:
         this.func_149676_a(0.0F, var4, var6, var8, var5, var7);
      }

   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      EnumFacing var5 = (EnumFacing)p_176204_3_.func_177229_b(field_176412_a);
      if(!p_176204_1_.func_180495_p(p_176204_2_.func_177972_a(var5.func_176734_d())).func_177230_c().func_149688_o().func_76220_a()) {
         this.func_176226_b(p_176204_1_, p_176204_2_, p_176204_3_, 0);
         p_176204_1_.func_175698_g(p_176204_2_);
      }

      super.func_176204_a(p_176204_1_, p_176204_2_, p_176204_3_, p_176204_4_);
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      EnumFacing var2 = EnumFacing.func_82600_a(p_176203_1_);
      if(var2.func_176740_k() == EnumFacing.Axis.Y) {
         var2 = EnumFacing.NORTH;
      }

      return this.func_176223_P().func_177226_a(field_176412_a, var2);
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((EnumFacing)p_176201_1_.func_177229_b(field_176412_a)).func_176745_a();
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176412_a});
   }


   // $FF: synthetic class
   static final class SwitchEnumFacing {

      // $FF: synthetic field
      static final int[] field_177331_a = new int[EnumFacing.values().length];
      private static final String __OBFID = "CL_00002046";


      static {
         try {
            field_177331_a[EnumFacing.NORTH.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_177331_a[EnumFacing.SOUTH.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_177331_a[EnumFacing.WEST.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_177331_a[EnumFacing.EAST.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
