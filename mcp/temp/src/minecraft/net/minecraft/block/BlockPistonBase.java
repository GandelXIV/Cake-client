package net.minecraft.block;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.block.BlockPistonMoving;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockPistonStructureHelper;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPistonBase extends Block {

   public static final PropertyDirection field_176321_a = PropertyDirection.func_177714_a("facing");
   public static final PropertyBool field_176320_b = PropertyBool.func_177716_a("extended");
   private final boolean field_150082_a;
   private static final String __OBFID = "CL_00000366";


   public BlockPistonBase(boolean p_i45443_1_) {
      super(Material.field_76233_E);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176321_a, EnumFacing.NORTH).func_177226_a(field_176320_b, Boolean.valueOf(false)));
      this.field_150082_a = p_i45443_1_;
      this.func_149672_a(field_149780_i);
      this.func_149711_c(0.5F);
      this.func_149647_a(CreativeTabs.field_78028_d);
   }

   public boolean func_149662_c() {
      return false;
   }

   public void func_180633_a(World p_180633_1_, BlockPos p_180633_2_, IBlockState p_180633_3_, EntityLivingBase p_180633_4_, ItemStack p_180633_5_) {
      p_180633_1_.func_180501_a(p_180633_2_, p_180633_3_.func_177226_a(field_176321_a, func_180695_a(p_180633_1_, p_180633_2_, p_180633_4_)), 2);
      if(!p_180633_1_.field_72995_K) {
         this.func_176316_e(p_180633_1_, p_180633_2_, p_180633_3_);
      }

   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      if(!p_176204_1_.field_72995_K) {
         this.func_176316_e(p_176204_1_, p_176204_2_, p_176204_3_);
      }

   }

   public void func_176213_c(World p_176213_1_, BlockPos p_176213_2_, IBlockState p_176213_3_) {
      if(!p_176213_1_.field_72995_K && p_176213_1_.func_175625_s(p_176213_2_) == null) {
         this.func_176316_e(p_176213_1_, p_176213_2_, p_176213_3_);
      }

   }

   public IBlockState func_180642_a(World p_180642_1_, BlockPos p_180642_2_, EnumFacing p_180642_3_, float p_180642_4_, float p_180642_5_, float p_180642_6_, int p_180642_7_, EntityLivingBase p_180642_8_) {
      return this.func_176223_P().func_177226_a(field_176321_a, func_180695_a(p_180642_1_, p_180642_2_, p_180642_8_)).func_177226_a(field_176320_b, Boolean.valueOf(false));
   }

   private void func_176316_e(World p_176316_1_, BlockPos p_176316_2_, IBlockState p_176316_3_) {
      EnumFacing var4 = (EnumFacing)p_176316_3_.func_177229_b(field_176321_a);
      boolean var5 = this.func_176318_b(p_176316_1_, p_176316_2_, var4);
      if(var5 && !((Boolean)p_176316_3_.func_177229_b(field_176320_b)).booleanValue()) {
         if((new BlockPistonStructureHelper(p_176316_1_, p_176316_2_, var4, true)).func_177253_a()) {
            p_176316_1_.func_175641_c(p_176316_2_, this, 0, var4.func_176745_a());
         }
      } else if(!var5 && ((Boolean)p_176316_3_.func_177229_b(field_176320_b)).booleanValue()) {
         p_176316_1_.func_180501_a(p_176316_2_, p_176316_3_.func_177226_a(field_176320_b, Boolean.valueOf(false)), 2);
         p_176316_1_.func_175641_c(p_176316_2_, this, 1, var4.func_176745_a());
      }

   }

   private boolean func_176318_b(World p_176318_1_, BlockPos p_176318_2_, EnumFacing p_176318_3_) {
      EnumFacing[] var4 = EnumFacing.values();
      int var5 = var4.length;

      int var6;
      for(var6 = 0; var6 < var5; ++var6) {
         EnumFacing var7 = var4[var6];
         if(var7 != p_176318_3_ && p_176318_1_.func_175709_b(p_176318_2_.func_177972_a(var7), var7)) {
            return true;
         }
      }

      if(p_176318_1_.func_175709_b(p_176318_2_, EnumFacing.NORTH)) {
         return true;
      } else {
         BlockPos var9 = p_176318_2_.func_177984_a();
         EnumFacing[] var10 = EnumFacing.values();
         var6 = var10.length;

         for(int var11 = 0; var11 < var6; ++var11) {
            EnumFacing var8 = var10[var11];
            if(var8 != EnumFacing.DOWN && p_176318_1_.func_175709_b(var9.func_177972_a(var8), var8)) {
               return true;
            }
         }

         return false;
      }
   }

   public boolean func_180648_a(World p_180648_1_, BlockPos p_180648_2_, IBlockState p_180648_3_, int p_180648_4_, int p_180648_5_) {
      EnumFacing var6 = (EnumFacing)p_180648_3_.func_177229_b(field_176321_a);
      if(!p_180648_1_.field_72995_K) {
         boolean var7 = this.func_176318_b(p_180648_1_, p_180648_2_, var6);
         if(var7 && p_180648_4_ == 1) {
            p_180648_1_.func_180501_a(p_180648_2_, p_180648_3_.func_177226_a(field_176320_b, Boolean.valueOf(true)), 2);
            return false;
         }

         if(!var7 && p_180648_4_ == 0) {
            return false;
         }
      }

      if(p_180648_4_ == 0) {
         if(!this.func_176319_a(p_180648_1_, p_180648_2_, var6, true)) {
            return false;
         }

         p_180648_1_.func_180501_a(p_180648_2_, p_180648_3_.func_177226_a(field_176320_b, Boolean.valueOf(true)), 2);
         p_180648_1_.func_72908_a((double)p_180648_2_.func_177958_n() + 0.5D, (double)p_180648_2_.func_177956_o() + 0.5D, (double)p_180648_2_.func_177952_p() + 0.5D, "tile.piston.out", 0.5F, p_180648_1_.field_73012_v.nextFloat() * 0.25F + 0.6F);
      } else if(p_180648_4_ == 1) {
         TileEntity var13 = p_180648_1_.func_175625_s(p_180648_2_.func_177972_a(var6));
         if(var13 instanceof TileEntityPiston) {
            ((TileEntityPiston)var13).func_145866_f();
         }

         p_180648_1_.func_180501_a(p_180648_2_, Blocks.field_180384_M.func_176223_P().func_177226_a(BlockPistonMoving.field_176426_a, var6).func_177226_a(BlockPistonMoving.field_176425_b, this.field_150082_a?BlockPistonExtension.EnumPistonType.STICKY:BlockPistonExtension.EnumPistonType.DEFAULT), 3);
         p_180648_1_.func_175690_a(p_180648_2_, BlockPistonMoving.func_176423_a(this.func_176203_a(p_180648_5_), var6, false, true));
         if(this.field_150082_a) {
            BlockPos var8 = p_180648_2_.func_177982_a(var6.func_82601_c() * 2, var6.func_96559_d() * 2, var6.func_82599_e() * 2);
            Block var9 = p_180648_1_.func_180495_p(var8).func_177230_c();
            boolean var10 = false;
            if(var9 == Blocks.field_180384_M) {
               TileEntity var11 = p_180648_1_.func_175625_s(var8);
               if(var11 instanceof TileEntityPiston) {
                  TileEntityPiston var12 = (TileEntityPiston)var11;
                  if(var12.func_174930_e() == var6 && var12.func_145868_b()) {
                     var12.func_145866_f();
                     var10 = true;
                  }
               }
            }

            if(!var10 && var9.func_149688_o() != Material.field_151579_a && func_180696_a(var9, p_180648_1_, var8, var6.func_176734_d(), false) && (var9.func_149656_h() == 0 || var9 == Blocks.field_150331_J || var9 == Blocks.field_150320_F)) {
               this.func_176319_a(p_180648_1_, p_180648_2_, var6, false);
            }
         } else {
            p_180648_1_.func_175698_g(p_180648_2_.func_177972_a(var6));
         }

         p_180648_1_.func_72908_a((double)p_180648_2_.func_177958_n() + 0.5D, (double)p_180648_2_.func_177956_o() + 0.5D, (double)p_180648_2_.func_177952_p() + 0.5D, "tile.piston.in", 0.5F, p_180648_1_.field_73012_v.nextFloat() * 0.15F + 0.6F);
      }

      return true;
   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      IBlockState var3 = p_180654_1_.func_180495_p(p_180654_2_);
      if(var3.func_177230_c() == this && ((Boolean)var3.func_177229_b(field_176320_b)).booleanValue()) {
         float var4 = 0.25F;
         EnumFacing var5 = (EnumFacing)var3.func_177229_b(field_176321_a);
         if(var5 != null) {
            switch(BlockPistonBase.SwitchEnumFacing.field_177243_a[var5.ordinal()]) {
            case 1:
               this.func_149676_a(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
               break;
            case 2:
               this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
               break;
            case 3:
               this.func_149676_a(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
               break;
            case 4:
               this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
               break;
            case 5:
               this.func_149676_a(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
               break;
            case 6:
               this.func_149676_a(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
            }
         }
      } else {
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

   }

   public void func_149683_g() {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void func_180638_a(World p_180638_1_, BlockPos p_180638_2_, IBlockState p_180638_3_, AxisAlignedBB p_180638_4_, List p_180638_5_, Entity p_180638_6_) {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
   }

   public AxisAlignedBB func_180640_a(World p_180640_1_, BlockPos p_180640_2_, IBlockState p_180640_3_) {
      this.func_180654_a(p_180640_1_, p_180640_2_);
      return super.func_180640_a(p_180640_1_, p_180640_2_, p_180640_3_);
   }

   public boolean func_149686_d() {
      return false;
   }

   public static EnumFacing func_176317_b(int p_176317_0_) {
      int var1 = p_176317_0_ & 7;
      return var1 > 5?null:EnumFacing.func_82600_a(var1);
   }

   public static EnumFacing func_180695_a(World p_180695_0_, BlockPos p_180695_1_, EntityLivingBase p_180695_2_) {
      if(MathHelper.func_76135_e((float)p_180695_2_.field_70165_t - (float)p_180695_1_.func_177958_n()) < 2.0F && MathHelper.func_76135_e((float)p_180695_2_.field_70161_v - (float)p_180695_1_.func_177952_p()) < 2.0F) {
         double var3 = p_180695_2_.field_70163_u + (double)p_180695_2_.func_70047_e();
         if(var3 - (double)p_180695_1_.func_177956_o() > 2.0D) {
            return EnumFacing.UP;
         }

         if((double)p_180695_1_.func_177956_o() - var3 > 0.0D) {
            return EnumFacing.DOWN;
         }
      }

      return p_180695_2_.func_174811_aO().func_176734_d();
   }

   public static boolean func_180696_a(Block p_180696_0_, World p_180696_1_, BlockPos p_180696_2_, EnumFacing p_180696_3_, boolean p_180696_4_) {
      if(p_180696_0_ == Blocks.field_150343_Z) {
         return false;
      } else if(!p_180696_1_.func_175723_af().func_177746_a(p_180696_2_)) {
         return false;
      } else if(p_180696_2_.func_177956_o() >= 0 && (p_180696_3_ != EnumFacing.DOWN || p_180696_2_.func_177956_o() != 0)) {
         if(p_180696_2_.func_177956_o() <= p_180696_1_.func_72800_K() - 1 && (p_180696_3_ != EnumFacing.UP || p_180696_2_.func_177956_o() != p_180696_1_.func_72800_K() - 1)) {
            if(p_180696_0_ != Blocks.field_150331_J && p_180696_0_ != Blocks.field_150320_F) {
               if(p_180696_0_.func_176195_g(p_180696_1_, p_180696_2_) == -1.0F) {
                  return false;
               }

               if(p_180696_0_.func_149656_h() == 2) {
                  return false;
               }

               if(p_180696_0_.func_149656_h() == 1) {
                  if(!p_180696_4_) {
                     return false;
                  }

                  return true;
               }
            } else if(((Boolean)p_180696_1_.func_180495_p(p_180696_2_).func_177229_b(field_176320_b)).booleanValue()) {
               return false;
            }

            return !(p_180696_0_ instanceof ITileEntityProvider);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private boolean func_176319_a(World p_176319_1_, BlockPos p_176319_2_, EnumFacing p_176319_3_, boolean p_176319_4_) {
      if(!p_176319_4_) {
         p_176319_1_.func_175698_g(p_176319_2_.func_177972_a(p_176319_3_));
      }

      BlockPistonStructureHelper var5 = new BlockPistonStructureHelper(p_176319_1_, p_176319_2_, p_176319_3_, p_176319_4_);
      List var6 = var5.func_177254_c();
      List var7 = var5.func_177252_d();
      if(!var5.func_177253_a()) {
         return false;
      } else {
         int var8 = var6.size() + var7.size();
         Block[] var9 = new Block[var8];
         EnumFacing var10 = p_176319_4_?p_176319_3_:p_176319_3_.func_176734_d();

         int var11;
         BlockPos var12;
         for(var11 = var7.size() - 1; var11 >= 0; --var11) {
            var12 = (BlockPos)var7.get(var11);
            Block var13 = p_176319_1_.func_180495_p(var12).func_177230_c();
            var13.func_176226_b(p_176319_1_, var12, p_176319_1_.func_180495_p(var12), 0);
            p_176319_1_.func_175698_g(var12);
            --var8;
            var9[var8] = var13;
         }

         IBlockState var19;
         for(var11 = var6.size() - 1; var11 >= 0; --var11) {
            var12 = (BlockPos)var6.get(var11);
            var19 = p_176319_1_.func_180495_p(var12);
            Block var14 = var19.func_177230_c();
            var14.func_176201_c(var19);
            p_176319_1_.func_175698_g(var12);
            var12 = var12.func_177972_a(var10);
            p_176319_1_.func_180501_a(var12, Blocks.field_180384_M.func_176223_P().func_177226_a(field_176321_a, p_176319_3_), 4);
            p_176319_1_.func_175690_a(var12, BlockPistonMoving.func_176423_a(var19, p_176319_3_, p_176319_4_, false));
            --var8;
            var9[var8] = var14;
         }

         BlockPos var16 = p_176319_2_.func_177972_a(p_176319_3_);
         if(p_176319_4_) {
            BlockPistonExtension.EnumPistonType var17 = this.field_150082_a?BlockPistonExtension.EnumPistonType.STICKY:BlockPistonExtension.EnumPistonType.DEFAULT;
            var19 = Blocks.field_150332_K.func_176223_P().func_177226_a(BlockPistonExtension.field_176326_a, p_176319_3_).func_177226_a(BlockPistonExtension.field_176325_b, var17);
            IBlockState var20 = Blocks.field_180384_M.func_176223_P().func_177226_a(BlockPistonMoving.field_176426_a, p_176319_3_).func_177226_a(BlockPistonMoving.field_176425_b, this.field_150082_a?BlockPistonExtension.EnumPistonType.STICKY:BlockPistonExtension.EnumPistonType.DEFAULT);
            p_176319_1_.func_180501_a(var16, var20, 4);
            p_176319_1_.func_175690_a(var16, BlockPistonMoving.func_176423_a(var19, p_176319_3_, true, false));
         }

         int var18;
         for(var18 = var7.size() - 1; var18 >= 0; --var18) {
            p_176319_1_.func_175685_c((BlockPos)var7.get(var18), var9[var8++]);
         }

         for(var18 = var6.size() - 1; var18 >= 0; --var18) {
            p_176319_1_.func_175685_c((BlockPos)var6.get(var18), var9[var8++]);
         }

         if(p_176319_4_) {
            p_176319_1_.func_175685_c(var16, Blocks.field_150332_K);
            p_176319_1_.func_175685_c(p_176319_2_, this);
         }

         return true;
      }
   }

   public IBlockState func_176217_b(IBlockState p_176217_1_) {
      return this.func_176223_P().func_177226_a(field_176321_a, EnumFacing.UP);
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176321_a, func_176317_b(p_176203_1_)).func_177226_a(field_176320_b, Boolean.valueOf((p_176203_1_ & 8) > 0));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      byte var2 = 0;
      int var3 = var2 | ((EnumFacing)p_176201_1_.func_177229_b(field_176321_a)).func_176745_a();
      if(((Boolean)p_176201_1_.func_177229_b(field_176320_b)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176321_a, field_176320_b});
   }


   // $FF: synthetic class
   static final class SwitchEnumFacing {

      // $FF: synthetic field
      static final int[] field_177243_a = new int[EnumFacing.values().length];
      private static final String __OBFID = "CL_00002037";


      static {
         try {
            field_177243_a[EnumFacing.DOWN.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            field_177243_a[EnumFacing.UP.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            field_177243_a[EnumFacing.NORTH.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_177243_a[EnumFacing.SOUTH.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_177243_a[EnumFacing.WEST.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_177243_a[EnumFacing.EAST.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
