package net.minecraft.block;

import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class BlockTorch extends Block {

   public static final PropertyDirection field_176596_a = PropertyDirection.func_177712_a("facing", new Predicate() {

      private static final String __OBFID = "CL_00002054";

      public boolean func_176601_a(EnumFacing p_176601_1_) {
         return p_176601_1_ != EnumFacing.DOWN;
      }
      // $FF: synthetic method
      public boolean apply(Object p_apply_1_) {
         return this.func_176601_a((EnumFacing)p_apply_1_);
      }
   });
   private static final String __OBFID = "CL_00000325";


   protected BlockTorch() {
      super(Material.field_151594_q);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176596_a, EnumFacing.UP));
      this.func_149675_a(true);
      this.func_149647_a(CreativeTabs.field_78031_c);
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

   private boolean func_176594_d(World p_176594_1_, BlockPos p_176594_2_) {
      if(World.func_175683_a(p_176594_1_, p_176594_2_)) {
         return true;
      } else {
         Block var3 = p_176594_1_.func_180495_p(p_176594_2_).func_177230_c();
         return var3 instanceof BlockFence || var3 == Blocks.field_150359_w || var3 == Blocks.field_150463_bK || var3 == Blocks.field_150399_cn;
      }
   }

   public boolean func_176196_c(World p_176196_1_, BlockPos p_176196_2_) {
      Iterator var3 = field_176596_a.func_177700_c().iterator();

      EnumFacing var4;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         var4 = (EnumFacing)var3.next();
      } while(!this.func_176595_b(p_176196_1_, p_176196_2_, var4));

      return true;
   }

   private boolean func_176595_b(World p_176595_1_, BlockPos p_176595_2_, EnumFacing p_176595_3_) {
      BlockPos var4 = p_176595_2_.func_177972_a(p_176595_3_.func_176734_d());
      boolean var5 = p_176595_3_.func_176740_k().func_176722_c();
      return var5 && p_176595_1_.func_175677_d(var4, true) || p_176595_3_.equals(EnumFacing.UP) && this.func_176594_d(p_176595_1_, var4);
   }

   public IBlockState func_180642_a(World p_180642_1_, BlockPos p_180642_2_, EnumFacing p_180642_3_, float p_180642_4_, float p_180642_5_, float p_180642_6_, int p_180642_7_, EntityLivingBase p_180642_8_) {
      if(this.func_176595_b(p_180642_1_, p_180642_2_, p_180642_3_)) {
         return this.func_176223_P().func_177226_a(field_176596_a, p_180642_3_);
      } else {
         Iterator var9 = EnumFacing.Plane.HORIZONTAL.iterator();

         EnumFacing var10;
         do {
            if(!var9.hasNext()) {
               return this.func_176223_P();
            }

            var10 = (EnumFacing)var9.next();
         } while(!p_180642_1_.func_175677_d(p_180642_2_.func_177972_a(var10.func_176734_d()), true));

         return this.func_176223_P().func_177226_a(field_176596_a, var10);
      }
   }

   public void func_176213_c(World p_176213_1_, BlockPos p_176213_2_, IBlockState p_176213_3_) {
      this.func_176593_f(p_176213_1_, p_176213_2_, p_176213_3_);
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      this.func_176592_e(p_176204_1_, p_176204_2_, p_176204_3_);
   }

   protected boolean func_176592_e(World p_176592_1_, BlockPos p_176592_2_, IBlockState p_176592_3_) {
      if(!this.func_176593_f(p_176592_1_, p_176592_2_, p_176592_3_)) {
         return true;
      } else {
         EnumFacing var4 = (EnumFacing)p_176592_3_.func_177229_b(field_176596_a);
         EnumFacing.Axis var5 = var4.func_176740_k();
         EnumFacing var6 = var4.func_176734_d();
         boolean var7 = false;
         if(var5.func_176722_c() && !p_176592_1_.func_175677_d(p_176592_2_.func_177972_a(var6), true)) {
            var7 = true;
         } else if(var5.func_176720_b() && !this.func_176594_d(p_176592_1_, p_176592_2_.func_177972_a(var6))) {
            var7 = true;
         }

         if(var7) {
            this.func_176226_b(p_176592_1_, p_176592_2_, p_176592_3_, 0);
            p_176592_1_.func_175698_g(p_176592_2_);
            return true;
         } else {
            return false;
         }
      }
   }

   protected boolean func_176593_f(World p_176593_1_, BlockPos p_176593_2_, IBlockState p_176593_3_) {
      if(p_176593_3_.func_177230_c() == this && this.func_176595_b(p_176593_1_, p_176593_2_, (EnumFacing)p_176593_3_.func_177229_b(field_176596_a))) {
         return true;
      } else {
         if(p_176593_1_.func_180495_p(p_176593_2_).func_177230_c() == this) {
            this.func_176226_b(p_176593_1_, p_176593_2_, p_176593_3_, 0);
            p_176593_1_.func_175698_g(p_176593_2_);
         }

         return false;
      }
   }

   public MovingObjectPosition func_180636_a(World p_180636_1_, BlockPos p_180636_2_, Vec3 p_180636_3_, Vec3 p_180636_4_) {
      EnumFacing var5 = (EnumFacing)p_180636_1_.func_180495_p(p_180636_2_).func_177229_b(field_176596_a);
      float var6 = 0.15F;
      if(var5 == EnumFacing.EAST) {
         this.func_149676_a(0.0F, 0.2F, 0.5F - var6, var6 * 2.0F, 0.8F, 0.5F + var6);
      } else if(var5 == EnumFacing.WEST) {
         this.func_149676_a(1.0F - var6 * 2.0F, 0.2F, 0.5F - var6, 1.0F, 0.8F, 0.5F + var6);
      } else if(var5 == EnumFacing.SOUTH) {
         this.func_149676_a(0.5F - var6, 0.2F, 0.0F, 0.5F + var6, 0.8F, var6 * 2.0F);
      } else if(var5 == EnumFacing.NORTH) {
         this.func_149676_a(0.5F - var6, 0.2F, 1.0F - var6 * 2.0F, 0.5F + var6, 0.8F, 1.0F);
      } else {
         var6 = 0.1F;
         this.func_149676_a(0.5F - var6, 0.0F, 0.5F - var6, 0.5F + var6, 0.6F, 0.5F + var6);
      }

      return super.func_180636_a(p_180636_1_, p_180636_2_, p_180636_3_, p_180636_4_);
   }

   public void func_180655_c(World p_180655_1_, BlockPos p_180655_2_, IBlockState p_180655_3_, Random p_180655_4_) {
      EnumFacing var5 = (EnumFacing)p_180655_3_.func_177229_b(field_176596_a);
      double var6 = (double)p_180655_2_.func_177958_n() + 0.5D;
      double var8 = (double)p_180655_2_.func_177956_o() + 0.7D;
      double var10 = (double)p_180655_2_.func_177952_p() + 0.5D;
      double var12 = 0.22D;
      double var14 = 0.27D;
      if(var5.func_176740_k().func_176722_c()) {
         EnumFacing var16 = var5.func_176734_d();
         p_180655_1_.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, var6 + var14 * (double)var16.func_82601_c(), var8 + var12, var10 + var14 * (double)var16.func_82599_e(), 0.0D, 0.0D, 0.0D, new int[0]);
         p_180655_1_.func_175688_a(EnumParticleTypes.FLAME, var6 + var14 * (double)var16.func_82601_c(), var8 + var12, var10 + var14 * (double)var16.func_82599_e(), 0.0D, 0.0D, 0.0D, new int[0]);
      } else {
         p_180655_1_.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, var6, var8, var10, 0.0D, 0.0D, 0.0D, new int[0]);
         p_180655_1_.func_175688_a(EnumParticleTypes.FLAME, var6, var8, var10, 0.0D, 0.0D, 0.0D, new int[0]);
      }

   }

   public EnumWorldBlockLayer func_180664_k() {
      return EnumWorldBlockLayer.CUTOUT;
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      IBlockState var2 = this.func_176223_P();
      switch(p_176203_1_) {
      case 1:
         var2 = var2.func_177226_a(field_176596_a, EnumFacing.EAST);
         break;
      case 2:
         var2 = var2.func_177226_a(field_176596_a, EnumFacing.WEST);
         break;
      case 3:
         var2 = var2.func_177226_a(field_176596_a, EnumFacing.SOUTH);
         break;
      case 4:
         var2 = var2.func_177226_a(field_176596_a, EnumFacing.NORTH);
         break;
      case 5:
      default:
         var2 = var2.func_177226_a(field_176596_a, EnumFacing.UP);
      }

      return var2;
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      byte var2 = 0;
      int var3;
      switch(BlockTorch.SwitchEnumFacing.field_176609_a[((EnumFacing)p_176201_1_.func_177229_b(field_176596_a)).ordinal()]) {
      case 1:
         var3 = var2 | 1;
         break;
      case 2:
         var3 = var2 | 2;
         break;
      case 3:
         var3 = var2 | 3;
         break;
      case 4:
         var3 = var2 | 4;
         break;
      case 5:
      case 6:
      default:
         var3 = var2 | 5;
      }

      return var3;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176596_a});
   }


   // $FF: synthetic class
   static final class SwitchEnumFacing {

      // $FF: synthetic field
      static final int[] field_176609_a = new int[EnumFacing.values().length];
      private static final String __OBFID = "CL_00002053";


      static {
         try {
            field_176609_a[EnumFacing.EAST.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            field_176609_a[EnumFacing.WEST.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            field_176609_a[EnumFacing.SOUTH.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_176609_a[EnumFacing.NORTH.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_176609_a[EnumFacing.DOWN.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_176609_a[EnumFacing.UP.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
