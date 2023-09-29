package net.minecraft.block;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
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
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStairs extends Block {

   public static final PropertyDirection field_176309_a = PropertyDirection.func_177712_a("facing", EnumFacing.Plane.HORIZONTAL);
   public static final PropertyEnum field_176308_b = PropertyEnum.func_177709_a("half", BlockStairs.EnumHalf.class);
   public static final PropertyEnum field_176310_M = PropertyEnum.func_177709_a("shape", BlockStairs.EnumShape.class);
   private static final int[][] field_150150_a = new int[][]{{4, 5}, {5, 7}, {6, 7}, {4, 6}, {0, 1}, {1, 3}, {2, 3}, {0, 2}};
   private final Block field_150149_b;
   private final IBlockState field_150151_M;
   private boolean field_150152_N;
   private int field_150153_O;
   private static final String __OBFID = "CL_00000314";


   protected BlockStairs(IBlockState p_i45684_1_) {
      super(p_i45684_1_.func_177230_c().field_149764_J);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176309_a, EnumFacing.NORTH).func_177226_a(field_176308_b, BlockStairs.EnumHalf.BOTTOM).func_177226_a(field_176310_M, BlockStairs.EnumShape.STRAIGHT));
      this.field_150149_b = p_i45684_1_.func_177230_c();
      this.field_150151_M = p_i45684_1_;
      this.func_149711_c(this.field_150149_b.field_149782_v);
      this.func_149752_b(this.field_150149_b.field_149781_w / 3.0F);
      this.func_149672_a(this.field_150149_b.field_149762_H);
      this.func_149713_g(255);
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      if(this.field_150152_N) {
         this.func_149676_a(0.5F * (float)(this.field_150153_O % 2), 0.5F * (float)(this.field_150153_O / 4 % 2), 0.5F * (float)(this.field_150153_O / 2 % 2), 0.5F + 0.5F * (float)(this.field_150153_O % 2), 0.5F + 0.5F * (float)(this.field_150153_O / 4 % 2), 0.5F + 0.5F * (float)(this.field_150153_O / 2 % 2));
      } else {
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public void func_176303_e(IBlockAccess p_176303_1_, BlockPos p_176303_2_) {
      if(p_176303_1_.func_180495_p(p_176303_2_).func_177229_b(field_176308_b) == BlockStairs.EnumHalf.TOP) {
         this.func_149676_a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

   }

   public static boolean func_150148_a(Block p_150148_0_) {
      return p_150148_0_ instanceof BlockStairs;
   }

   public static boolean func_176302_a(IBlockAccess p_176302_0_, BlockPos p_176302_1_, IBlockState p_176302_2_) {
      IBlockState var3 = p_176302_0_.func_180495_p(p_176302_1_);
      Block var4 = var3.func_177230_c();
      return func_150148_a(var4) && var3.func_177229_b(field_176308_b) == p_176302_2_.func_177229_b(field_176308_b) && var3.func_177229_b(field_176309_a) == p_176302_2_.func_177229_b(field_176309_a);
   }

   public int func_176307_f(IBlockAccess p_176307_1_, BlockPos p_176307_2_) {
      IBlockState var3 = p_176307_1_.func_180495_p(p_176307_2_);
      EnumFacing var4 = (EnumFacing)var3.func_177229_b(field_176309_a);
      BlockStairs.EnumHalf var5 = (BlockStairs.EnumHalf)var3.func_177229_b(field_176308_b);
      boolean var6 = var5 == BlockStairs.EnumHalf.TOP;
      IBlockState var7;
      Block var8;
      EnumFacing var9;
      if(var4 == EnumFacing.EAST) {
         var7 = p_176307_1_.func_180495_p(p_176307_2_.func_177974_f());
         var8 = var7.func_177230_c();
         if(func_150148_a(var8) && var5 == var7.func_177229_b(field_176308_b)) {
            var9 = (EnumFacing)var7.func_177229_b(field_176309_a);
            if(var9 == EnumFacing.NORTH && !func_176302_a(p_176307_1_, p_176307_2_.func_177968_d(), var3)) {
               return var6?1:2;
            }

            if(var9 == EnumFacing.SOUTH && !func_176302_a(p_176307_1_, p_176307_2_.func_177978_c(), var3)) {
               return var6?2:1;
            }
         }
      } else if(var4 == EnumFacing.WEST) {
         var7 = p_176307_1_.func_180495_p(p_176307_2_.func_177976_e());
         var8 = var7.func_177230_c();
         if(func_150148_a(var8) && var5 == var7.func_177229_b(field_176308_b)) {
            var9 = (EnumFacing)var7.func_177229_b(field_176309_a);
            if(var9 == EnumFacing.NORTH && !func_176302_a(p_176307_1_, p_176307_2_.func_177968_d(), var3)) {
               return var6?2:1;
            }

            if(var9 == EnumFacing.SOUTH && !func_176302_a(p_176307_1_, p_176307_2_.func_177978_c(), var3)) {
               return var6?1:2;
            }
         }
      } else if(var4 == EnumFacing.SOUTH) {
         var7 = p_176307_1_.func_180495_p(p_176307_2_.func_177968_d());
         var8 = var7.func_177230_c();
         if(func_150148_a(var8) && var5 == var7.func_177229_b(field_176308_b)) {
            var9 = (EnumFacing)var7.func_177229_b(field_176309_a);
            if(var9 == EnumFacing.WEST && !func_176302_a(p_176307_1_, p_176307_2_.func_177974_f(), var3)) {
               return var6?2:1;
            }

            if(var9 == EnumFacing.EAST && !func_176302_a(p_176307_1_, p_176307_2_.func_177976_e(), var3)) {
               return var6?1:2;
            }
         }
      } else if(var4 == EnumFacing.NORTH) {
         var7 = p_176307_1_.func_180495_p(p_176307_2_.func_177978_c());
         var8 = var7.func_177230_c();
         if(func_150148_a(var8) && var5 == var7.func_177229_b(field_176308_b)) {
            var9 = (EnumFacing)var7.func_177229_b(field_176309_a);
            if(var9 == EnumFacing.WEST && !func_176302_a(p_176307_1_, p_176307_2_.func_177974_f(), var3)) {
               return var6?1:2;
            }

            if(var9 == EnumFacing.EAST && !func_176302_a(p_176307_1_, p_176307_2_.func_177976_e(), var3)) {
               return var6?2:1;
            }
         }
      }

      return 0;
   }

   public int func_176305_g(IBlockAccess p_176305_1_, BlockPos p_176305_2_) {
      IBlockState var3 = p_176305_1_.func_180495_p(p_176305_2_);
      EnumFacing var4 = (EnumFacing)var3.func_177229_b(field_176309_a);
      BlockStairs.EnumHalf var5 = (BlockStairs.EnumHalf)var3.func_177229_b(field_176308_b);
      boolean var6 = var5 == BlockStairs.EnumHalf.TOP;
      IBlockState var7;
      Block var8;
      EnumFacing var9;
      if(var4 == EnumFacing.EAST) {
         var7 = p_176305_1_.func_180495_p(p_176305_2_.func_177976_e());
         var8 = var7.func_177230_c();
         if(func_150148_a(var8) && var5 == var7.func_177229_b(field_176308_b)) {
            var9 = (EnumFacing)var7.func_177229_b(field_176309_a);
            if(var9 == EnumFacing.NORTH && !func_176302_a(p_176305_1_, p_176305_2_.func_177978_c(), var3)) {
               return var6?1:2;
            }

            if(var9 == EnumFacing.SOUTH && !func_176302_a(p_176305_1_, p_176305_2_.func_177968_d(), var3)) {
               return var6?2:1;
            }
         }
      } else if(var4 == EnumFacing.WEST) {
         var7 = p_176305_1_.func_180495_p(p_176305_2_.func_177974_f());
         var8 = var7.func_177230_c();
         if(func_150148_a(var8) && var5 == var7.func_177229_b(field_176308_b)) {
            var9 = (EnumFacing)var7.func_177229_b(field_176309_a);
            if(var9 == EnumFacing.NORTH && !func_176302_a(p_176305_1_, p_176305_2_.func_177978_c(), var3)) {
               return var6?2:1;
            }

            if(var9 == EnumFacing.SOUTH && !func_176302_a(p_176305_1_, p_176305_2_.func_177968_d(), var3)) {
               return var6?1:2;
            }
         }
      } else if(var4 == EnumFacing.SOUTH) {
         var7 = p_176305_1_.func_180495_p(p_176305_2_.func_177978_c());
         var8 = var7.func_177230_c();
         if(func_150148_a(var8) && var5 == var7.func_177229_b(field_176308_b)) {
            var9 = (EnumFacing)var7.func_177229_b(field_176309_a);
            if(var9 == EnumFacing.WEST && !func_176302_a(p_176305_1_, p_176305_2_.func_177976_e(), var3)) {
               return var6?2:1;
            }

            if(var9 == EnumFacing.EAST && !func_176302_a(p_176305_1_, p_176305_2_.func_177974_f(), var3)) {
               return var6?1:2;
            }
         }
      } else if(var4 == EnumFacing.NORTH) {
         var7 = p_176305_1_.func_180495_p(p_176305_2_.func_177968_d());
         var8 = var7.func_177230_c();
         if(func_150148_a(var8) && var5 == var7.func_177229_b(field_176308_b)) {
            var9 = (EnumFacing)var7.func_177229_b(field_176309_a);
            if(var9 == EnumFacing.WEST && !func_176302_a(p_176305_1_, p_176305_2_.func_177976_e(), var3)) {
               return var6?1:2;
            }

            if(var9 == EnumFacing.EAST && !func_176302_a(p_176305_1_, p_176305_2_.func_177974_f(), var3)) {
               return var6?2:1;
            }
         }
      }

      return 0;
   }

   public boolean func_176306_h(IBlockAccess p_176306_1_, BlockPos p_176306_2_) {
      IBlockState var3 = p_176306_1_.func_180495_p(p_176306_2_);
      EnumFacing var4 = (EnumFacing)var3.func_177229_b(field_176309_a);
      BlockStairs.EnumHalf var5 = (BlockStairs.EnumHalf)var3.func_177229_b(field_176308_b);
      boolean var6 = var5 == BlockStairs.EnumHalf.TOP;
      float var7 = 0.5F;
      float var8 = 1.0F;
      if(var6) {
         var7 = 0.0F;
         var8 = 0.5F;
      }

      float var9 = 0.0F;
      float var10 = 1.0F;
      float var11 = 0.0F;
      float var12 = 0.5F;
      boolean var13 = true;
      IBlockState var14;
      Block var15;
      EnumFacing var16;
      if(var4 == EnumFacing.EAST) {
         var9 = 0.5F;
         var12 = 1.0F;
         var14 = p_176306_1_.func_180495_p(p_176306_2_.func_177974_f());
         var15 = var14.func_177230_c();
         if(func_150148_a(var15) && var5 == var14.func_177229_b(field_176308_b)) {
            var16 = (EnumFacing)var14.func_177229_b(field_176309_a);
            if(var16 == EnumFacing.NORTH && !func_176302_a(p_176306_1_, p_176306_2_.func_177968_d(), var3)) {
               var12 = 0.5F;
               var13 = false;
            } else if(var16 == EnumFacing.SOUTH && !func_176302_a(p_176306_1_, p_176306_2_.func_177978_c(), var3)) {
               var11 = 0.5F;
               var13 = false;
            }
         }
      } else if(var4 == EnumFacing.WEST) {
         var10 = 0.5F;
         var12 = 1.0F;
         var14 = p_176306_1_.func_180495_p(p_176306_2_.func_177976_e());
         var15 = var14.func_177230_c();
         if(func_150148_a(var15) && var5 == var14.func_177229_b(field_176308_b)) {
            var16 = (EnumFacing)var14.func_177229_b(field_176309_a);
            if(var16 == EnumFacing.NORTH && !func_176302_a(p_176306_1_, p_176306_2_.func_177968_d(), var3)) {
               var12 = 0.5F;
               var13 = false;
            } else if(var16 == EnumFacing.SOUTH && !func_176302_a(p_176306_1_, p_176306_2_.func_177978_c(), var3)) {
               var11 = 0.5F;
               var13 = false;
            }
         }
      } else if(var4 == EnumFacing.SOUTH) {
         var11 = 0.5F;
         var12 = 1.0F;
         var14 = p_176306_1_.func_180495_p(p_176306_2_.func_177968_d());
         var15 = var14.func_177230_c();
         if(func_150148_a(var15) && var5 == var14.func_177229_b(field_176308_b)) {
            var16 = (EnumFacing)var14.func_177229_b(field_176309_a);
            if(var16 == EnumFacing.WEST && !func_176302_a(p_176306_1_, p_176306_2_.func_177974_f(), var3)) {
               var10 = 0.5F;
               var13 = false;
            } else if(var16 == EnumFacing.EAST && !func_176302_a(p_176306_1_, p_176306_2_.func_177976_e(), var3)) {
               var9 = 0.5F;
               var13 = false;
            }
         }
      } else if(var4 == EnumFacing.NORTH) {
         var14 = p_176306_1_.func_180495_p(p_176306_2_.func_177978_c());
         var15 = var14.func_177230_c();
         if(func_150148_a(var15) && var5 == var14.func_177229_b(field_176308_b)) {
            var16 = (EnumFacing)var14.func_177229_b(field_176309_a);
            if(var16 == EnumFacing.WEST && !func_176302_a(p_176306_1_, p_176306_2_.func_177974_f(), var3)) {
               var10 = 0.5F;
               var13 = false;
            } else if(var16 == EnumFacing.EAST && !func_176302_a(p_176306_1_, p_176306_2_.func_177976_e(), var3)) {
               var9 = 0.5F;
               var13 = false;
            }
         }
      }

      this.func_149676_a(var9, var7, var11, var10, var8, var12);
      return var13;
   }

   public boolean func_176304_i(IBlockAccess p_176304_1_, BlockPos p_176304_2_) {
      IBlockState var3 = p_176304_1_.func_180495_p(p_176304_2_);
      EnumFacing var4 = (EnumFacing)var3.func_177229_b(field_176309_a);
      BlockStairs.EnumHalf var5 = (BlockStairs.EnumHalf)var3.func_177229_b(field_176308_b);
      boolean var6 = var5 == BlockStairs.EnumHalf.TOP;
      float var7 = 0.5F;
      float var8 = 1.0F;
      if(var6) {
         var7 = 0.0F;
         var8 = 0.5F;
      }

      float var9 = 0.0F;
      float var10 = 0.5F;
      float var11 = 0.5F;
      float var12 = 1.0F;
      boolean var13 = false;
      IBlockState var14;
      Block var15;
      EnumFacing var16;
      if(var4 == EnumFacing.EAST) {
         var14 = p_176304_1_.func_180495_p(p_176304_2_.func_177976_e());
         var15 = var14.func_177230_c();
         if(func_150148_a(var15) && var5 == var14.func_177229_b(field_176308_b)) {
            var16 = (EnumFacing)var14.func_177229_b(field_176309_a);
            if(var16 == EnumFacing.NORTH && !func_176302_a(p_176304_1_, p_176304_2_.func_177978_c(), var3)) {
               var11 = 0.0F;
               var12 = 0.5F;
               var13 = true;
            } else if(var16 == EnumFacing.SOUTH && !func_176302_a(p_176304_1_, p_176304_2_.func_177968_d(), var3)) {
               var11 = 0.5F;
               var12 = 1.0F;
               var13 = true;
            }
         }
      } else if(var4 == EnumFacing.WEST) {
         var14 = p_176304_1_.func_180495_p(p_176304_2_.func_177974_f());
         var15 = var14.func_177230_c();
         if(func_150148_a(var15) && var5 == var14.func_177229_b(field_176308_b)) {
            var9 = 0.5F;
            var10 = 1.0F;
            var16 = (EnumFacing)var14.func_177229_b(field_176309_a);
            if(var16 == EnumFacing.NORTH && !func_176302_a(p_176304_1_, p_176304_2_.func_177978_c(), var3)) {
               var11 = 0.0F;
               var12 = 0.5F;
               var13 = true;
            } else if(var16 == EnumFacing.SOUTH && !func_176302_a(p_176304_1_, p_176304_2_.func_177968_d(), var3)) {
               var11 = 0.5F;
               var12 = 1.0F;
               var13 = true;
            }
         }
      } else if(var4 == EnumFacing.SOUTH) {
         var14 = p_176304_1_.func_180495_p(p_176304_2_.func_177978_c());
         var15 = var14.func_177230_c();
         if(func_150148_a(var15) && var5 == var14.func_177229_b(field_176308_b)) {
            var11 = 0.0F;
            var12 = 0.5F;
            var16 = (EnumFacing)var14.func_177229_b(field_176309_a);
            if(var16 == EnumFacing.WEST && !func_176302_a(p_176304_1_, p_176304_2_.func_177976_e(), var3)) {
               var13 = true;
            } else if(var16 == EnumFacing.EAST && !func_176302_a(p_176304_1_, p_176304_2_.func_177974_f(), var3)) {
               var9 = 0.5F;
               var10 = 1.0F;
               var13 = true;
            }
         }
      } else if(var4 == EnumFacing.NORTH) {
         var14 = p_176304_1_.func_180495_p(p_176304_2_.func_177968_d());
         var15 = var14.func_177230_c();
         if(func_150148_a(var15) && var5 == var14.func_177229_b(field_176308_b)) {
            var16 = (EnumFacing)var14.func_177229_b(field_176309_a);
            if(var16 == EnumFacing.WEST && !func_176302_a(p_176304_1_, p_176304_2_.func_177976_e(), var3)) {
               var13 = true;
            } else if(var16 == EnumFacing.EAST && !func_176302_a(p_176304_1_, p_176304_2_.func_177974_f(), var3)) {
               var9 = 0.5F;
               var10 = 1.0F;
               var13 = true;
            }
         }
      }

      if(var13) {
         this.func_149676_a(var9, var7, var11, var10, var8, var12);
      }

      return var13;
   }

   public void func_180638_a(World p_180638_1_, BlockPos p_180638_2_, IBlockState p_180638_3_, AxisAlignedBB p_180638_4_, List p_180638_5_, Entity p_180638_6_) {
      this.func_176303_e(p_180638_1_, p_180638_2_);
      super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
      boolean var7 = this.func_176306_h(p_180638_1_, p_180638_2_);
      super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
      if(var7 && this.func_176304_i(p_180638_1_, p_180638_2_)) {
         super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
      }

      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void func_180655_c(World p_180655_1_, BlockPos p_180655_2_, IBlockState p_180655_3_, Random p_180655_4_) {
      this.field_150149_b.func_180655_c(p_180655_1_, p_180655_2_, p_180655_3_, p_180655_4_);
   }

   public void func_180649_a(World p_180649_1_, BlockPos p_180649_2_, EntityPlayer p_180649_3_) {
      this.field_150149_b.func_180649_a(p_180649_1_, p_180649_2_, p_180649_3_);
   }

   public void func_176206_d(World p_176206_1_, BlockPos p_176206_2_, IBlockState p_176206_3_) {
      this.field_150149_b.func_176206_d(p_176206_1_, p_176206_2_, p_176206_3_);
   }

   public int func_176207_c(IBlockAccess p_176207_1_, BlockPos p_176207_2_) {
      return this.field_150149_b.func_176207_c(p_176207_1_, p_176207_2_);
   }

   public float func_149638_a(Entity p_149638_1_) {
      return this.field_150149_b.func_149638_a(p_149638_1_);
   }

   public EnumWorldBlockLayer func_180664_k() {
      return this.field_150149_b.func_180664_k();
   }

   public int func_149738_a(World p_149738_1_) {
      return this.field_150149_b.func_149738_a(p_149738_1_);
   }

   public AxisAlignedBB func_180646_a(World p_180646_1_, BlockPos p_180646_2_) {
      return this.field_150149_b.func_180646_a(p_180646_1_, p_180646_2_);
   }

   public Vec3 func_176197_a(World p_176197_1_, BlockPos p_176197_2_, Entity p_176197_3_, Vec3 p_176197_4_) {
      return this.field_150149_b.func_176197_a(p_176197_1_, p_176197_2_, p_176197_3_, p_176197_4_);
   }

   public boolean func_149703_v() {
      return this.field_150149_b.func_149703_v();
   }

   public boolean func_176209_a(IBlockState p_176209_1_, boolean p_176209_2_) {
      return this.field_150149_b.func_176209_a(p_176209_1_, p_176209_2_);
   }

   public boolean func_176196_c(World p_176196_1_, BlockPos p_176196_2_) {
      return this.field_150149_b.func_176196_c(p_176196_1_, p_176196_2_);
   }

   public void func_176213_c(World p_176213_1_, BlockPos p_176213_2_, IBlockState p_176213_3_) {
      this.func_176204_a(p_176213_1_, p_176213_2_, this.field_150151_M, Blocks.field_150350_a);
      this.field_150149_b.func_176213_c(p_176213_1_, p_176213_2_, this.field_150151_M);
   }

   public void func_180663_b(World p_180663_1_, BlockPos p_180663_2_, IBlockState p_180663_3_) {
      this.field_150149_b.func_180663_b(p_180663_1_, p_180663_2_, this.field_150151_M);
   }

   public void func_176199_a(World p_176199_1_, BlockPos p_176199_2_, Entity p_176199_3_) {
      this.field_150149_b.func_176199_a(p_176199_1_, p_176199_2_, p_176199_3_);
   }

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      this.field_150149_b.func_180650_b(p_180650_1_, p_180650_2_, p_180650_3_, p_180650_4_);
   }

   public boolean func_180639_a(World p_180639_1_, BlockPos p_180639_2_, IBlockState p_180639_3_, EntityPlayer p_180639_4_, EnumFacing p_180639_5_, float p_180639_6_, float p_180639_7_, float p_180639_8_) {
      return this.field_150149_b.func_180639_a(p_180639_1_, p_180639_2_, this.field_150151_M, p_180639_4_, EnumFacing.DOWN, 0.0F, 0.0F, 0.0F);
   }

   public void func_180652_a(World p_180652_1_, BlockPos p_180652_2_, Explosion p_180652_3_) {
      this.field_150149_b.func_180652_a(p_180652_1_, p_180652_2_, p_180652_3_);
   }

   public MapColor func_180659_g(IBlockState p_180659_1_) {
      return this.field_150149_b.func_180659_g(this.field_150151_M);
   }

   public IBlockState func_180642_a(World p_180642_1_, BlockPos p_180642_2_, EnumFacing p_180642_3_, float p_180642_4_, float p_180642_5_, float p_180642_6_, int p_180642_7_, EntityLivingBase p_180642_8_) {
      IBlockState var9 = super.func_180642_a(p_180642_1_, p_180642_2_, p_180642_3_, p_180642_4_, p_180642_5_, p_180642_6_, p_180642_7_, p_180642_8_);
      var9 = var9.func_177226_a(field_176309_a, p_180642_8_.func_174811_aO()).func_177226_a(field_176310_M, BlockStairs.EnumShape.STRAIGHT);
      return p_180642_3_ != EnumFacing.DOWN && (p_180642_3_ == EnumFacing.UP || (double)p_180642_5_ <= 0.5D)?var9.func_177226_a(field_176308_b, BlockStairs.EnumHalf.BOTTOM):var9.func_177226_a(field_176308_b, BlockStairs.EnumHalf.TOP);
   }

   public MovingObjectPosition func_180636_a(World p_180636_1_, BlockPos p_180636_2_, Vec3 p_180636_3_, Vec3 p_180636_4_) {
      MovingObjectPosition[] var5 = new MovingObjectPosition[8];
      IBlockState var6 = p_180636_1_.func_180495_p(p_180636_2_);
      int var7 = ((EnumFacing)var6.func_177229_b(field_176309_a)).func_176736_b();
      boolean var8 = var6.func_177229_b(field_176308_b) == BlockStairs.EnumHalf.TOP;
      int[] var9 = field_150150_a[var7 + (var8?4:0)];
      this.field_150152_N = true;

      for(int var10 = 0; var10 < 8; ++var10) {
         this.field_150153_O = var10;
         if(Arrays.binarySearch(var9, var10) < 0) {
            var5[var10] = super.func_180636_a(p_180636_1_, p_180636_2_, p_180636_3_, p_180636_4_);
         }
      }

      int[] var19 = var9;
      int var11 = var9.length;

      for(int var12 = 0; var12 < var11; ++var12) {
         int var13 = var19[var12];
         var5[var13] = null;
      }

      MovingObjectPosition var20 = null;
      double var21 = 0.0D;
      MovingObjectPosition[] var22 = var5;
      int var14 = var5.length;

      for(int var15 = 0; var15 < var14; ++var15) {
         MovingObjectPosition var16 = var22[var15];
         if(var16 != null) {
            double var17 = var16.field_72307_f.func_72436_e(p_180636_4_);
            if(var17 > var21) {
               var20 = var16;
               var21 = var17;
            }
         }
      }

      return var20;
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      IBlockState var2 = this.func_176223_P().func_177226_a(field_176308_b, (p_176203_1_ & 4) > 0?BlockStairs.EnumHalf.TOP:BlockStairs.EnumHalf.BOTTOM);
      var2 = var2.func_177226_a(field_176309_a, EnumFacing.func_82600_a(5 - (p_176203_1_ & 3)));
      return var2;
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      int var2 = 0;
      if(p_176201_1_.func_177229_b(field_176308_b) == BlockStairs.EnumHalf.TOP) {
         var2 |= 4;
      }

      var2 |= 5 - ((EnumFacing)p_176201_1_.func_177229_b(field_176309_a)).func_176745_a();
      return var2;
   }

   public IBlockState func_176221_a(IBlockState p_176221_1_, IBlockAccess p_176221_2_, BlockPos p_176221_3_) {
      if(this.func_176306_h(p_176221_2_, p_176221_3_)) {
         switch(this.func_176305_g(p_176221_2_, p_176221_3_)) {
         case 0:
            p_176221_1_ = p_176221_1_.func_177226_a(field_176310_M, BlockStairs.EnumShape.STRAIGHT);
            break;
         case 1:
            p_176221_1_ = p_176221_1_.func_177226_a(field_176310_M, BlockStairs.EnumShape.INNER_RIGHT);
            break;
         case 2:
            p_176221_1_ = p_176221_1_.func_177226_a(field_176310_M, BlockStairs.EnumShape.INNER_LEFT);
         }
      } else {
         switch(this.func_176307_f(p_176221_2_, p_176221_3_)) {
         case 0:
            p_176221_1_ = p_176221_1_.func_177226_a(field_176310_M, BlockStairs.EnumShape.STRAIGHT);
            break;
         case 1:
            p_176221_1_ = p_176221_1_.func_177226_a(field_176310_M, BlockStairs.EnumShape.OUTER_RIGHT);
            break;
         case 2:
            p_176221_1_ = p_176221_1_.func_177226_a(field_176310_M, BlockStairs.EnumShape.OUTER_LEFT);
         }
      }

      return p_176221_1_;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176309_a, field_176308_b, field_176310_M});
   }


   public static enum EnumHalf implements IStringSerializable {

      TOP("TOP", 0, "top"),
      BOTTOM("BOTTOM", 1, "bottom");
      private final String field_176709_c;
      // $FF: synthetic field
      private static final BlockStairs.EnumHalf[] $VALUES = new BlockStairs.EnumHalf[]{TOP, BOTTOM};
      private static final String __OBFID = "CL_00002062";


      private EnumHalf(String p_i45683_1_, int p_i45683_2_, String p_i45683_3_) {
         this.field_176709_c = p_i45683_3_;
      }

      public String toString() {
         return this.field_176709_c;
      }

      public String func_176610_l() {
         return this.field_176709_c;
      }

   }

   public static enum EnumShape implements IStringSerializable {

      STRAIGHT("STRAIGHT", 0, "straight"),
      INNER_LEFT("INNER_LEFT", 1, "inner_left"),
      INNER_RIGHT("INNER_RIGHT", 2, "inner_right"),
      OUTER_LEFT("OUTER_LEFT", 3, "outer_left"),
      OUTER_RIGHT("OUTER_RIGHT", 4, "outer_right");
      private final String field_176699_f;
      // $FF: synthetic field
      private static final BlockStairs.EnumShape[] $VALUES = new BlockStairs.EnumShape[]{STRAIGHT, INNER_LEFT, INNER_RIGHT, OUTER_LEFT, OUTER_RIGHT};
      private static final String __OBFID = "CL_00002061";


      private EnumShape(String p_i45682_1_, int p_i45682_2_, String p_i45682_3_) {
         this.field_176699_f = p_i45682_3_;
      }

      public String toString() {
         return this.field_176699_f;
      }

      public String func_176610_l() {
         return this.field_176699_f;
      }

   }
}
