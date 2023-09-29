package net.minecraft.block;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockVine extends Block {

   public static final PropertyBool field_176277_a = PropertyBool.func_177716_a("up");
   public static final PropertyBool field_176273_b = PropertyBool.func_177716_a("north");
   public static final PropertyBool field_176278_M = PropertyBool.func_177716_a("east");
   public static final PropertyBool field_176279_N = PropertyBool.func_177716_a("south");
   public static final PropertyBool field_176280_O = PropertyBool.func_177716_a("west");
   public static final PropertyBool[] field_176274_P = new PropertyBool[]{field_176277_a, field_176273_b, field_176279_N, field_176280_O, field_176278_M};
   public static final int field_176272_Q = func_176270_b(EnumFacing.SOUTH);
   public static final int field_176276_R = func_176270_b(EnumFacing.NORTH);
   public static final int field_176275_S = func_176270_b(EnumFacing.EAST);
   public static final int field_176271_T = func_176270_b(EnumFacing.WEST);
   private static final String __OBFID = "CL_00000330";


   public BlockVine() {
      super(Material.field_151582_l);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176277_a, Boolean.valueOf(false)).func_177226_a(field_176273_b, Boolean.valueOf(false)).func_177226_a(field_176278_M, Boolean.valueOf(false)).func_177226_a(field_176279_N, Boolean.valueOf(false)).func_177226_a(field_176280_O, Boolean.valueOf(false)));
      this.func_149675_a(true);
      this.func_149647_a(CreativeTabs.field_78031_c);
   }

   public IBlockState func_176221_a(IBlockState p_176221_1_, IBlockAccess p_176221_2_, BlockPos p_176221_3_) {
      return p_176221_1_.func_177226_a(field_176277_a, Boolean.valueOf(p_176221_2_.func_180495_p(p_176221_3_.func_177984_a()).func_177230_c().func_149637_q()));
   }

   public void func_149683_g() {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_176200_f(World p_176200_1_, BlockPos p_176200_2_) {
      return true;
   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      float var3 = 0.0625F;
      float var4 = 1.0F;
      float var5 = 1.0F;
      float var6 = 1.0F;
      float var7 = 0.0F;
      float var8 = 0.0F;
      float var9 = 0.0F;
      boolean var10 = false;
      if(((Boolean)p_180654_1_.func_180495_p(p_180654_2_).func_177229_b(field_176280_O)).booleanValue()) {
         var7 = Math.max(var7, 0.0625F);
         var4 = 0.0F;
         var5 = 0.0F;
         var8 = 1.0F;
         var6 = 0.0F;
         var9 = 1.0F;
         var10 = true;
      }

      if(((Boolean)p_180654_1_.func_180495_p(p_180654_2_).func_177229_b(field_176278_M)).booleanValue()) {
         var4 = Math.min(var4, 0.9375F);
         var7 = 1.0F;
         var5 = 0.0F;
         var8 = 1.0F;
         var6 = 0.0F;
         var9 = 1.0F;
         var10 = true;
      }

      if(((Boolean)p_180654_1_.func_180495_p(p_180654_2_).func_177229_b(field_176273_b)).booleanValue()) {
         var9 = Math.max(var9, 0.0625F);
         var6 = 0.0F;
         var4 = 0.0F;
         var7 = 1.0F;
         var5 = 0.0F;
         var8 = 1.0F;
         var10 = true;
      }

      if(((Boolean)p_180654_1_.func_180495_p(p_180654_2_).func_177229_b(field_176279_N)).booleanValue()) {
         var6 = Math.min(var6, 0.9375F);
         var9 = 1.0F;
         var4 = 0.0F;
         var7 = 1.0F;
         var5 = 0.0F;
         var8 = 1.0F;
         var10 = true;
      }

      if(!var10 && this.func_150093_a(p_180654_1_.func_180495_p(p_180654_2_.func_177984_a()).func_177230_c())) {
         var5 = Math.min(var5, 0.9375F);
         var8 = 1.0F;
         var4 = 0.0F;
         var7 = 1.0F;
         var6 = 0.0F;
         var9 = 1.0F;
      }

      this.func_149676_a(var4, var5, var6, var7, var8, var9);
   }

   public AxisAlignedBB func_180640_a(World p_180640_1_, BlockPos p_180640_2_, IBlockState p_180640_3_) {
      return null;
   }

   public boolean func_176198_a(World p_176198_1_, BlockPos p_176198_2_, EnumFacing p_176198_3_) {
      switch(BlockVine.SwitchEnumFacing.field_177057_a[p_176198_3_.ordinal()]) {
      case 1:
         return this.func_150093_a(p_176198_1_.func_180495_p(p_176198_2_.func_177984_a()).func_177230_c());
      case 2:
      case 3:
      case 4:
      case 5:
         return this.func_150093_a(p_176198_1_.func_180495_p(p_176198_2_.func_177972_a(p_176198_3_.func_176734_d())).func_177230_c());
      default:
         return false;
      }
   }

   private boolean func_150093_a(Block p_150093_1_) {
      return p_150093_1_.func_149686_d() && p_150093_1_.field_149764_J.func_76230_c();
   }

   private boolean func_176269_e(World p_176269_1_, BlockPos p_176269_2_, IBlockState p_176269_3_) {
      IBlockState var4 = p_176269_3_;
      Iterator var5 = EnumFacing.Plane.HORIZONTAL.iterator();

      while(var5.hasNext()) {
         EnumFacing var6 = (EnumFacing)var5.next();
         PropertyBool var7 = func_176267_a(var6);
         if(((Boolean)p_176269_3_.func_177229_b(var7)).booleanValue() && !this.func_150093_a(p_176269_1_.func_180495_p(p_176269_2_.func_177972_a(var6)).func_177230_c())) {
            IBlockState var8 = p_176269_1_.func_180495_p(p_176269_2_.func_177984_a());
            if(var8.func_177230_c() != this || !((Boolean)var8.func_177229_b(var7)).booleanValue()) {
               p_176269_3_ = p_176269_3_.func_177226_a(var7, Boolean.valueOf(false));
            }
         }
      }

      if(func_176268_d(p_176269_3_) == 0) {
         return false;
      } else {
         if(var4 != p_176269_3_) {
            p_176269_1_.func_180501_a(p_176269_2_, p_176269_3_, 2);
         }

         return true;
      }
   }

   public int func_149635_D() {
      return ColorizerFoliage.func_77468_c();
   }

   public int func_180644_h(IBlockState p_180644_1_) {
      return ColorizerFoliage.func_77468_c();
   }

   public int func_180662_a(IBlockAccess p_180662_1_, BlockPos p_180662_2_, int p_180662_3_) {
      return p_180662_1_.func_180494_b(p_180662_2_).func_180625_c(p_180662_2_);
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      if(!p_176204_1_.field_72995_K && !this.func_176269_e(p_176204_1_, p_176204_2_, p_176204_3_)) {
         this.func_176226_b(p_176204_1_, p_176204_2_, p_176204_3_, 0);
         p_176204_1_.func_175698_g(p_176204_2_);
      }

   }

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      if(!p_180650_1_.field_72995_K) {
         if(p_180650_1_.field_73012_v.nextInt(4) == 0) {
            byte var5 = 4;
            int var6 = 5;
            boolean var7 = false;

            label189:
            for(int var8 = -var5; var8 <= var5; ++var8) {
               for(int var9 = -var5; var9 <= var5; ++var9) {
                  for(int var10 = -1; var10 <= 1; ++var10) {
                     if(p_180650_1_.func_180495_p(p_180650_2_.func_177982_a(var8, var10, var9)).func_177230_c() == this) {
                        --var6;
                        if(var6 <= 0) {
                           var7 = true;
                           break label189;
                        }
                     }
                  }
               }
            }

            EnumFacing var17 = EnumFacing.func_176741_a(p_180650_4_);
            EnumFacing var23;
            if(var17 == EnumFacing.UP && p_180650_2_.func_177956_o() < 255 && p_180650_1_.func_175623_d(p_180650_2_.func_177984_a())) {
               if(!var7) {
                  IBlockState var19 = p_180650_3_;
                  Iterator var22 = EnumFacing.Plane.HORIZONTAL.iterator();

                  while(var22.hasNext()) {
                     var23 = (EnumFacing)var22.next();
                     if(p_180650_4_.nextBoolean() || !this.func_150093_a(p_180650_1_.func_180495_p(p_180650_2_.func_177972_a(var23).func_177984_a()).func_177230_c())) {
                        var19 = var19.func_177226_a(func_176267_a(var23), Boolean.valueOf(false));
                     }
                  }

                  if(((Boolean)var19.func_177229_b(field_176273_b)).booleanValue() || ((Boolean)var19.func_177229_b(field_176278_M)).booleanValue() || ((Boolean)var19.func_177229_b(field_176279_N)).booleanValue() || ((Boolean)var19.func_177229_b(field_176280_O)).booleanValue()) {
                     p_180650_1_.func_180501_a(p_180650_2_.func_177984_a(), var19, 2);
                  }

               }
            } else {
               BlockPos var18;
               if(var17.func_176740_k().func_176722_c() && !((Boolean)p_180650_3_.func_177229_b(func_176267_a(var17))).booleanValue()) {
                  if(!var7) {
                     var18 = p_180650_2_.func_177972_a(var17);
                     Block var21 = p_180650_1_.func_180495_p(var18).func_177230_c();
                     if(var21.field_149764_J == Material.field_151579_a) {
                        var23 = var17.func_176746_e();
                        EnumFacing var24 = var17.func_176735_f();
                        boolean var25 = ((Boolean)p_180650_3_.func_177229_b(func_176267_a(var23))).booleanValue();
                        boolean var26 = ((Boolean)p_180650_3_.func_177229_b(func_176267_a(var24))).booleanValue();
                        BlockPos var27 = var18.func_177972_a(var23);
                        BlockPos var16 = var18.func_177972_a(var24);
                        if(var25 && this.func_150093_a(p_180650_1_.func_180495_p(var27).func_177230_c())) {
                           p_180650_1_.func_180501_a(var18, this.func_176223_P().func_177226_a(func_176267_a(var23), Boolean.valueOf(true)), 2);
                        } else if(var26 && this.func_150093_a(p_180650_1_.func_180495_p(var16).func_177230_c())) {
                           p_180650_1_.func_180501_a(var18, this.func_176223_P().func_177226_a(func_176267_a(var24), Boolean.valueOf(true)), 2);
                        } else if(var25 && p_180650_1_.func_175623_d(var27) && this.func_150093_a(p_180650_1_.func_180495_p(p_180650_2_.func_177972_a(var23)).func_177230_c())) {
                           p_180650_1_.func_180501_a(var27, this.func_176223_P().func_177226_a(func_176267_a(var17.func_176734_d()), Boolean.valueOf(true)), 2);
                        } else if(var26 && p_180650_1_.func_175623_d(var16) && this.func_150093_a(p_180650_1_.func_180495_p(p_180650_2_.func_177972_a(var24)).func_177230_c())) {
                           p_180650_1_.func_180501_a(var16, this.func_176223_P().func_177226_a(func_176267_a(var17.func_176734_d()), Boolean.valueOf(true)), 2);
                        } else if(this.func_150093_a(p_180650_1_.func_180495_p(var18.func_177984_a()).func_177230_c())) {
                           p_180650_1_.func_180501_a(var18, this.func_176223_P(), 2);
                        }
                     } else if(var21.field_149764_J.func_76218_k() && var21.func_149686_d()) {
                        p_180650_1_.func_180501_a(p_180650_2_, p_180650_3_.func_177226_a(func_176267_a(var17), Boolean.valueOf(true)), 2);
                     }

                  }
               } else {
                  if(p_180650_2_.func_177956_o() > 1) {
                     var18 = p_180650_2_.func_177977_b();
                     IBlockState var20 = p_180650_1_.func_180495_p(var18);
                     Block var11 = var20.func_177230_c();
                     IBlockState var12;
                     Iterator var13;
                     EnumFacing var14;
                     if(var11.field_149764_J == Material.field_151579_a) {
                        var12 = p_180650_3_;
                        var13 = EnumFacing.Plane.HORIZONTAL.iterator();

                        while(var13.hasNext()) {
                           var14 = (EnumFacing)var13.next();
                           if(p_180650_4_.nextBoolean()) {
                              var12 = var12.func_177226_a(func_176267_a(var14), Boolean.valueOf(false));
                           }
                        }

                        if(((Boolean)var12.func_177229_b(field_176273_b)).booleanValue() || ((Boolean)var12.func_177229_b(field_176278_M)).booleanValue() || ((Boolean)var12.func_177229_b(field_176279_N)).booleanValue() || ((Boolean)var12.func_177229_b(field_176280_O)).booleanValue()) {
                           p_180650_1_.func_180501_a(var18, var12, 2);
                        }
                     } else if(var11 == this) {
                        var12 = var20;
                        var13 = EnumFacing.Plane.HORIZONTAL.iterator();

                        while(var13.hasNext()) {
                           var14 = (EnumFacing)var13.next();
                           PropertyBool var15 = func_176267_a(var14);
                           if(p_180650_4_.nextBoolean() || !((Boolean)p_180650_3_.func_177229_b(var15)).booleanValue()) {
                              var12 = var12.func_177226_a(var15, Boolean.valueOf(false));
                           }
                        }

                        if(((Boolean)var12.func_177229_b(field_176273_b)).booleanValue() || ((Boolean)var12.func_177229_b(field_176278_M)).booleanValue() || ((Boolean)var12.func_177229_b(field_176279_N)).booleanValue() || ((Boolean)var12.func_177229_b(field_176280_O)).booleanValue()) {
                           p_180650_1_.func_180501_a(var18, var12, 2);
                        }
                     }
                  }

               }
            }
         }
      }
   }

   private static int func_176270_b(EnumFacing p_176270_0_) {
      return 1 << p_176270_0_.func_176736_b();
   }

   public IBlockState func_180642_a(World p_180642_1_, BlockPos p_180642_2_, EnumFacing p_180642_3_, float p_180642_4_, float p_180642_5_, float p_180642_6_, int p_180642_7_, EntityLivingBase p_180642_8_) {
      IBlockState var9 = this.func_176223_P().func_177226_a(field_176277_a, Boolean.valueOf(false)).func_177226_a(field_176273_b, Boolean.valueOf(false)).func_177226_a(field_176278_M, Boolean.valueOf(false)).func_177226_a(field_176279_N, Boolean.valueOf(false)).func_177226_a(field_176280_O, Boolean.valueOf(false));
      return p_180642_3_.func_176740_k().func_176722_c()?var9.func_177226_a(func_176267_a(p_180642_3_.func_176734_d()), Boolean.valueOf(true)):var9;
   }

   public Item func_180660_a(IBlockState p_180660_1_, Random p_180660_2_, int p_180660_3_) {
      return null;
   }

   public int func_149745_a(Random p_149745_1_) {
      return 0;
   }

   public void func_180657_a(World p_180657_1_, EntityPlayer p_180657_2_, BlockPos p_180657_3_, IBlockState p_180657_4_, TileEntity p_180657_5_) {
      if(!p_180657_1_.field_72995_K && p_180657_2_.func_71045_bC() != null && p_180657_2_.func_71045_bC().func_77973_b() == Items.field_151097_aZ) {
         p_180657_2_.func_71029_a(StatList.field_75934_C[Block.func_149682_b(this)]);
         func_180635_a(p_180657_1_, p_180657_3_, new ItemStack(Blocks.field_150395_bd, 1, 0));
      } else {
         super.func_180657_a(p_180657_1_, p_180657_2_, p_180657_3_, p_180657_4_, p_180657_5_);
      }

   }

   public EnumWorldBlockLayer func_180664_k() {
      return EnumWorldBlockLayer.CUTOUT;
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176273_b, Boolean.valueOf((p_176203_1_ & field_176276_R) > 0)).func_177226_a(field_176278_M, Boolean.valueOf((p_176203_1_ & field_176275_S) > 0)).func_177226_a(field_176279_N, Boolean.valueOf((p_176203_1_ & field_176272_Q) > 0)).func_177226_a(field_176280_O, Boolean.valueOf((p_176203_1_ & field_176271_T) > 0));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      int var2 = 0;
      if(((Boolean)p_176201_1_.func_177229_b(field_176273_b)).booleanValue()) {
         var2 |= field_176276_R;
      }

      if(((Boolean)p_176201_1_.func_177229_b(field_176278_M)).booleanValue()) {
         var2 |= field_176275_S;
      }

      if(((Boolean)p_176201_1_.func_177229_b(field_176279_N)).booleanValue()) {
         var2 |= field_176272_Q;
      }

      if(((Boolean)p_176201_1_.func_177229_b(field_176280_O)).booleanValue()) {
         var2 |= field_176271_T;
      }

      return var2;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176277_a, field_176273_b, field_176278_M, field_176279_N, field_176280_O});
   }

   public static PropertyBool func_176267_a(EnumFacing p_176267_0_) {
      switch(BlockVine.SwitchEnumFacing.field_177057_a[p_176267_0_.ordinal()]) {
      case 1:
         return field_176277_a;
      case 2:
         return field_176273_b;
      case 3:
         return field_176279_N;
      case 4:
         return field_176278_M;
      case 5:
         return field_176280_O;
      default:
         throw new IllegalArgumentException(p_176267_0_ + " is an invalid choice");
      }
   }

   public static int func_176268_d(IBlockState p_176268_0_) {
      int var1 = 0;
      PropertyBool[] var2 = field_176274_P;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         PropertyBool var5 = var2[var4];
         if(((Boolean)p_176268_0_.func_177229_b(var5)).booleanValue()) {
            ++var1;
         }
      }

      return var1;
   }


   // $FF: synthetic class
   static final class SwitchEnumFacing {

      // $FF: synthetic field
      static final int[] field_177057_a = new int[EnumFacing.values().length];
      private static final String __OBFID = "CL_00002049";


      static {
         try {
            field_177057_a[EnumFacing.UP.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            field_177057_a[EnumFacing.NORTH.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_177057_a[EnumFacing.SOUTH.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_177057_a[EnumFacing.EAST.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_177057_a[EnumFacing.WEST.ordinal()] = 5;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
