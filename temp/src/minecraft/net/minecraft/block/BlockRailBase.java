package net.minecraft.block;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
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

public abstract class BlockRailBase extends Block {

   protected final boolean field_150053_a;
   private static final String __OBFID = "CL_00000195";


   public static boolean func_176562_d(World p_176562_0_, BlockPos p_176562_1_) {
      return func_176563_d(p_176562_0_.func_180495_p(p_176562_1_));
   }

   public static boolean func_176563_d(IBlockState p_176563_0_) {
      Block var1 = p_176563_0_.func_177230_c();
      return var1 == Blocks.field_150448_aq || var1 == Blocks.field_150318_D || var1 == Blocks.field_150319_E || var1 == Blocks.field_150408_cc;
   }

   protected BlockRailBase(boolean p_i45389_1_) {
      super(Material.field_151594_q);
      this.field_150053_a = p_i45389_1_;
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      this.func_149647_a(CreativeTabs.field_78029_e);
   }

   public AxisAlignedBB func_180640_a(World p_180640_1_, BlockPos p_180640_2_, IBlockState p_180640_3_) {
      return null;
   }

   public boolean func_149662_c() {
      return false;
   }

   public MovingObjectPosition func_180636_a(World p_180636_1_, BlockPos p_180636_2_, Vec3 p_180636_3_, Vec3 p_180636_4_) {
      this.func_180654_a(p_180636_1_, p_180636_2_);
      return super.func_180636_a(p_180636_1_, p_180636_2_, p_180636_3_, p_180636_4_);
   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      IBlockState var3 = p_180654_1_.func_180495_p(p_180654_2_);
      BlockRailBase.EnumRailDirection var4 = var3.func_177230_c() == this?(BlockRailBase.EnumRailDirection)var3.func_177229_b(this.func_176560_l()):null;
      if(var4 != null && var4.func_177018_c()) {
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
      } else {
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      }

   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_176196_c(World p_176196_1_, BlockPos p_176196_2_) {
      return World.func_175683_a(p_176196_1_, p_176196_2_.func_177977_b());
   }

   public void func_176213_c(World p_176213_1_, BlockPos p_176213_2_, IBlockState p_176213_3_) {
      if(!p_176213_1_.field_72995_K) {
         p_176213_3_ = this.func_176564_a(p_176213_1_, p_176213_2_, p_176213_3_, true);
         if(this.field_150053_a) {
            this.func_176204_a(p_176213_1_, p_176213_2_, p_176213_3_, this);
         }
      }

   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      if(!p_176204_1_.field_72995_K) {
         BlockRailBase.EnumRailDirection var5 = (BlockRailBase.EnumRailDirection)p_176204_3_.func_177229_b(this.func_176560_l());
         boolean var6 = false;
         if(!World.func_175683_a(p_176204_1_, p_176204_2_.func_177977_b())) {
            var6 = true;
         }

         if(var5 == BlockRailBase.EnumRailDirection.ASCENDING_EAST && !World.func_175683_a(p_176204_1_, p_176204_2_.func_177974_f())) {
            var6 = true;
         } else if(var5 == BlockRailBase.EnumRailDirection.ASCENDING_WEST && !World.func_175683_a(p_176204_1_, p_176204_2_.func_177976_e())) {
            var6 = true;
         } else if(var5 == BlockRailBase.EnumRailDirection.ASCENDING_NORTH && !World.func_175683_a(p_176204_1_, p_176204_2_.func_177978_c())) {
            var6 = true;
         } else if(var5 == BlockRailBase.EnumRailDirection.ASCENDING_SOUTH && !World.func_175683_a(p_176204_1_, p_176204_2_.func_177968_d())) {
            var6 = true;
         }

         if(var6) {
            this.func_176226_b(p_176204_1_, p_176204_2_, p_176204_3_, 0);
            p_176204_1_.func_175698_g(p_176204_2_);
         } else {
            this.func_176561_b(p_176204_1_, p_176204_2_, p_176204_3_, p_176204_4_);
         }

      }
   }

   protected void func_176561_b(World p_176561_1_, BlockPos p_176561_2_, IBlockState p_176561_3_, Block p_176561_4_) {}

   protected IBlockState func_176564_a(World p_176564_1_, BlockPos p_176564_2_, IBlockState p_176564_3_, boolean p_176564_4_) {
      return p_176564_1_.field_72995_K?p_176564_3_:(new BlockRailBase.Rail(p_176564_1_, p_176564_2_, p_176564_3_)).func_180364_a(p_176564_1_.func_175640_z(p_176564_2_), p_176564_4_).func_180362_b();
   }

   public int func_149656_h() {
      return 0;
   }

   public EnumWorldBlockLayer func_180664_k() {
      return EnumWorldBlockLayer.CUTOUT;
   }

   public void func_180663_b(World p_180663_1_, BlockPos p_180663_2_, IBlockState p_180663_3_) {
      super.func_180663_b(p_180663_1_, p_180663_2_, p_180663_3_);
      if(((BlockRailBase.EnumRailDirection)p_180663_3_.func_177229_b(this.func_176560_l())).func_177018_c()) {
         p_180663_1_.func_175685_c(p_180663_2_.func_177984_a(), this);
      }

      if(this.field_150053_a) {
         p_180663_1_.func_175685_c(p_180663_2_, this);
         p_180663_1_.func_175685_c(p_180663_2_.func_177977_b(), this);
      }

   }

   public abstract IProperty func_176560_l();

   public static enum EnumRailDirection implements IStringSerializable {

      NORTH_SOUTH("NORTH_SOUTH", 0, 0, "north_south"),
      EAST_WEST("EAST_WEST", 1, 1, "east_west"),
      ASCENDING_EAST("ASCENDING_EAST", 2, 2, "ascending_east"),
      ASCENDING_WEST("ASCENDING_WEST", 3, 3, "ascending_west"),
      ASCENDING_NORTH("ASCENDING_NORTH", 4, 4, "ascending_north"),
      ASCENDING_SOUTH("ASCENDING_SOUTH", 5, 5, "ascending_south"),
      SOUTH_EAST("SOUTH_EAST", 6, 6, "south_east"),
      SOUTH_WEST("SOUTH_WEST", 7, 7, "south_west"),
      NORTH_WEST("NORTH_WEST", 8, 8, "north_west"),
      NORTH_EAST("NORTH_EAST", 9, 9, "north_east");
      private static final BlockRailBase.EnumRailDirection[] field_177030_k = new BlockRailBase.EnumRailDirection[values().length];
      private final int field_177027_l;
      private final String field_177028_m;
      // $FF: synthetic field
      private static final BlockRailBase.EnumRailDirection[] $VALUES = new BlockRailBase.EnumRailDirection[]{NORTH_SOUTH, EAST_WEST, ASCENDING_EAST, ASCENDING_WEST, ASCENDING_NORTH, ASCENDING_SOUTH, SOUTH_EAST, SOUTH_WEST, NORTH_WEST, NORTH_EAST};
      private static final String __OBFID = "CL_00002137";


      private EnumRailDirection(String p_i45738_1_, int p_i45738_2_, int p_i45738_3_, String p_i45738_4_) {
         this.field_177027_l = p_i45738_3_;
         this.field_177028_m = p_i45738_4_;
      }

      public int func_177015_a() {
         return this.field_177027_l;
      }

      public String toString() {
         return this.field_177028_m;
      }

      public boolean func_177018_c() {
         return this == ASCENDING_NORTH || this == ASCENDING_EAST || this == ASCENDING_SOUTH || this == ASCENDING_WEST;
      }

      public static BlockRailBase.EnumRailDirection func_177016_a(int p_177016_0_) {
         if(p_177016_0_ < 0 || p_177016_0_ >= field_177030_k.length) {
            p_177016_0_ = 0;
         }

         return field_177030_k[p_177016_0_];
      }

      public String func_176610_l() {
         return this.field_177028_m;
      }

      static {
         BlockRailBase.EnumRailDirection[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            BlockRailBase.EnumRailDirection var3 = var0[var2];
            field_177030_k[var3.func_177015_a()] = var3;
         }

      }
   }

   public class Rail {

      private final World field_150660_b;
      private final BlockPos field_180367_c;
      private final BlockRailBase field_180365_d;
      private IBlockState field_180366_e;
      private final boolean field_150656_f;
      private final List field_150657_g = Lists.newArrayList();
      private static final String __OBFID = "CL_00000196";


      public Rail(World p_i45739_2_, BlockPos p_i45739_3_, IBlockState p_i45739_4_) {
         this.field_150660_b = p_i45739_2_;
         this.field_180367_c = p_i45739_3_;
         this.field_180366_e = p_i45739_4_;
         this.field_180365_d = (BlockRailBase)p_i45739_4_.func_177230_c();
         BlockRailBase.EnumRailDirection var5 = (BlockRailBase.EnumRailDirection)p_i45739_4_.func_177229_b(BlockRailBase.this.func_176560_l());
         this.field_150656_f = this.field_180365_d.field_150053_a;
         this.func_180360_a(var5);
      }

      private void func_180360_a(BlockRailBase.EnumRailDirection p_180360_1_) {
         this.field_150657_g.clear();
         switch(BlockRailBase.SwitchEnumRailDirection.field_180371_a[p_180360_1_.ordinal()]) {
         case 1:
            this.field_150657_g.add(this.field_180367_c.func_177978_c());
            this.field_150657_g.add(this.field_180367_c.func_177968_d());
            break;
         case 2:
            this.field_150657_g.add(this.field_180367_c.func_177976_e());
            this.field_150657_g.add(this.field_180367_c.func_177974_f());
            break;
         case 3:
            this.field_150657_g.add(this.field_180367_c.func_177976_e());
            this.field_150657_g.add(this.field_180367_c.func_177974_f().func_177984_a());
            break;
         case 4:
            this.field_150657_g.add(this.field_180367_c.func_177976_e().func_177984_a());
            this.field_150657_g.add(this.field_180367_c.func_177974_f());
            break;
         case 5:
            this.field_150657_g.add(this.field_180367_c.func_177978_c().func_177984_a());
            this.field_150657_g.add(this.field_180367_c.func_177968_d());
            break;
         case 6:
            this.field_150657_g.add(this.field_180367_c.func_177978_c());
            this.field_150657_g.add(this.field_180367_c.func_177968_d().func_177984_a());
            break;
         case 7:
            this.field_150657_g.add(this.field_180367_c.func_177974_f());
            this.field_150657_g.add(this.field_180367_c.func_177968_d());
            break;
         case 8:
            this.field_150657_g.add(this.field_180367_c.func_177976_e());
            this.field_150657_g.add(this.field_180367_c.func_177968_d());
            break;
         case 9:
            this.field_150657_g.add(this.field_180367_c.func_177976_e());
            this.field_150657_g.add(this.field_180367_c.func_177978_c());
            break;
         case 10:
            this.field_150657_g.add(this.field_180367_c.func_177974_f());
            this.field_150657_g.add(this.field_180367_c.func_177978_c());
         }

      }

      private void func_150651_b() {
         for(int var1 = 0; var1 < this.field_150657_g.size(); ++var1) {
            BlockRailBase.Rail var2 = this.func_180697_b((BlockPos)this.field_150657_g.get(var1));
            if(var2 != null && var2.func_150653_a(this)) {
               this.field_150657_g.set(var1, var2.field_180367_c);
            } else {
               this.field_150657_g.remove(var1--);
            }
         }

      }

      private boolean func_180359_a(BlockPos p_180359_1_) {
         return BlockRailBase.func_176562_d(this.field_150660_b, p_180359_1_) || BlockRailBase.func_176562_d(this.field_150660_b, p_180359_1_.func_177984_a()) || BlockRailBase.func_176562_d(this.field_150660_b, p_180359_1_.func_177977_b());
      }

      private BlockRailBase.Rail func_180697_b(BlockPos p_180697_1_) {
         IBlockState var3 = this.field_150660_b.func_180495_p(p_180697_1_);
         if(BlockRailBase.func_176563_d(var3)) {
            return BlockRailBase.this.new Rail(this.field_150660_b, p_180697_1_, var3);
         } else {
            BlockPos var2 = p_180697_1_.func_177984_a();
            var3 = this.field_150660_b.func_180495_p(var2);
            if(BlockRailBase.func_176563_d(var3)) {
               return BlockRailBase.this.new Rail(this.field_150660_b, var2, var3);
            } else {
               var2 = p_180697_1_.func_177977_b();
               var3 = this.field_150660_b.func_180495_p(var2);
               return BlockRailBase.func_176563_d(var3)?BlockRailBase.this.new Rail(this.field_150660_b, var2, var3):null;
            }
         }
      }

      private boolean func_150653_a(BlockRailBase.Rail p_150653_1_) {
         return this.func_180363_c(p_150653_1_.field_180367_c);
      }

      private boolean func_180363_c(BlockPos p_180363_1_) {
         for(int var2 = 0; var2 < this.field_150657_g.size(); ++var2) {
            BlockPos var3 = (BlockPos)this.field_150657_g.get(var2);
            if(var3.func_177958_n() == p_180363_1_.func_177958_n() && var3.func_177952_p() == p_180363_1_.func_177952_p()) {
               return true;
            }
         }

         return false;
      }

      protected int func_150650_a() {
         int var1 = 0;
         Iterator var2 = EnumFacing.Plane.HORIZONTAL.iterator();

         while(var2.hasNext()) {
            EnumFacing var3 = (EnumFacing)var2.next();
            if(this.func_180359_a(this.field_180367_c.func_177972_a(var3))) {
               ++var1;
            }
         }

         return var1;
      }

      private boolean func_150649_b(BlockRailBase.Rail p_150649_1_) {
         return this.func_150653_a(p_150649_1_) || this.field_150657_g.size() != 2;
      }

      private void func_150645_c(BlockRailBase.Rail p_150645_1_) {
         this.field_150657_g.add(p_150645_1_.field_180367_c);
         BlockPos var2 = this.field_180367_c.func_177978_c();
         BlockPos var3 = this.field_180367_c.func_177968_d();
         BlockPos var4 = this.field_180367_c.func_177976_e();
         BlockPos var5 = this.field_180367_c.func_177974_f();
         boolean var6 = this.func_180363_c(var2);
         boolean var7 = this.func_180363_c(var3);
         boolean var8 = this.func_180363_c(var4);
         boolean var9 = this.func_180363_c(var5);
         BlockRailBase.EnumRailDirection var10 = null;
         if(var6 || var7) {
            var10 = BlockRailBase.EnumRailDirection.NORTH_SOUTH;
         }

         if(var8 || var9) {
            var10 = BlockRailBase.EnumRailDirection.EAST_WEST;
         }

         if(!this.field_150656_f) {
            if(var7 && var9 && !var6 && !var8) {
               var10 = BlockRailBase.EnumRailDirection.SOUTH_EAST;
            }

            if(var7 && var8 && !var6 && !var9) {
               var10 = BlockRailBase.EnumRailDirection.SOUTH_WEST;
            }

            if(var6 && var8 && !var7 && !var9) {
               var10 = BlockRailBase.EnumRailDirection.NORTH_WEST;
            }

            if(var6 && var9 && !var7 && !var8) {
               var10 = BlockRailBase.EnumRailDirection.NORTH_EAST;
            }
         }

         if(var10 == BlockRailBase.EnumRailDirection.NORTH_SOUTH) {
            if(BlockRailBase.func_176562_d(this.field_150660_b, var2.func_177984_a())) {
               var10 = BlockRailBase.EnumRailDirection.ASCENDING_NORTH;
            }

            if(BlockRailBase.func_176562_d(this.field_150660_b, var3.func_177984_a())) {
               var10 = BlockRailBase.EnumRailDirection.ASCENDING_SOUTH;
            }
         }

         if(var10 == BlockRailBase.EnumRailDirection.EAST_WEST) {
            if(BlockRailBase.func_176562_d(this.field_150660_b, var5.func_177984_a())) {
               var10 = BlockRailBase.EnumRailDirection.ASCENDING_EAST;
            }

            if(BlockRailBase.func_176562_d(this.field_150660_b, var4.func_177984_a())) {
               var10 = BlockRailBase.EnumRailDirection.ASCENDING_WEST;
            }
         }

         if(var10 == null) {
            var10 = BlockRailBase.EnumRailDirection.NORTH_SOUTH;
         }

         this.field_180366_e = this.field_180366_e.func_177226_a(this.field_180365_d.func_176560_l(), var10);
         this.field_150660_b.func_180501_a(this.field_180367_c, this.field_180366_e, 3);
      }

      private boolean func_180361_d(BlockPos p_180361_1_) {
         BlockRailBase.Rail var2 = this.func_180697_b(p_180361_1_);
         if(var2 == null) {
            return false;
         } else {
            var2.func_150651_b();
            return var2.func_150649_b(this);
         }
      }

      public BlockRailBase.Rail func_180364_a(boolean p_180364_1_, boolean p_180364_2_) {
         BlockPos var3 = this.field_180367_c.func_177978_c();
         BlockPos var4 = this.field_180367_c.func_177968_d();
         BlockPos var5 = this.field_180367_c.func_177976_e();
         BlockPos var6 = this.field_180367_c.func_177974_f();
         boolean var7 = this.func_180361_d(var3);
         boolean var8 = this.func_180361_d(var4);
         boolean var9 = this.func_180361_d(var5);
         boolean var10 = this.func_180361_d(var6);
         BlockRailBase.EnumRailDirection var11 = null;
         if((var7 || var8) && !var9 && !var10) {
            var11 = BlockRailBase.EnumRailDirection.NORTH_SOUTH;
         }

         if((var9 || var10) && !var7 && !var8) {
            var11 = BlockRailBase.EnumRailDirection.EAST_WEST;
         }

         if(!this.field_150656_f) {
            if(var8 && var10 && !var7 && !var9) {
               var11 = BlockRailBase.EnumRailDirection.SOUTH_EAST;
            }

            if(var8 && var9 && !var7 && !var10) {
               var11 = BlockRailBase.EnumRailDirection.SOUTH_WEST;
            }

            if(var7 && var9 && !var8 && !var10) {
               var11 = BlockRailBase.EnumRailDirection.NORTH_WEST;
            }

            if(var7 && var10 && !var8 && !var9) {
               var11 = BlockRailBase.EnumRailDirection.NORTH_EAST;
            }
         }

         if(var11 == null) {
            if(var7 || var8) {
               var11 = BlockRailBase.EnumRailDirection.NORTH_SOUTH;
            }

            if(var9 || var10) {
               var11 = BlockRailBase.EnumRailDirection.EAST_WEST;
            }

            if(!this.field_150656_f) {
               if(p_180364_1_) {
                  if(var8 && var10) {
                     var11 = BlockRailBase.EnumRailDirection.SOUTH_EAST;
                  }

                  if(var9 && var8) {
                     var11 = BlockRailBase.EnumRailDirection.SOUTH_WEST;
                  }

                  if(var10 && var7) {
                     var11 = BlockRailBase.EnumRailDirection.NORTH_EAST;
                  }

                  if(var7 && var9) {
                     var11 = BlockRailBase.EnumRailDirection.NORTH_WEST;
                  }
               } else {
                  if(var7 && var9) {
                     var11 = BlockRailBase.EnumRailDirection.NORTH_WEST;
                  }

                  if(var10 && var7) {
                     var11 = BlockRailBase.EnumRailDirection.NORTH_EAST;
                  }

                  if(var9 && var8) {
                     var11 = BlockRailBase.EnumRailDirection.SOUTH_WEST;
                  }

                  if(var8 && var10) {
                     var11 = BlockRailBase.EnumRailDirection.SOUTH_EAST;
                  }
               }
            }
         }

         if(var11 == BlockRailBase.EnumRailDirection.NORTH_SOUTH) {
            if(BlockRailBase.func_176562_d(this.field_150660_b, var3.func_177984_a())) {
               var11 = BlockRailBase.EnumRailDirection.ASCENDING_NORTH;
            }

            if(BlockRailBase.func_176562_d(this.field_150660_b, var4.func_177984_a())) {
               var11 = BlockRailBase.EnumRailDirection.ASCENDING_SOUTH;
            }
         }

         if(var11 == BlockRailBase.EnumRailDirection.EAST_WEST) {
            if(BlockRailBase.func_176562_d(this.field_150660_b, var6.func_177984_a())) {
               var11 = BlockRailBase.EnumRailDirection.ASCENDING_EAST;
            }

            if(BlockRailBase.func_176562_d(this.field_150660_b, var5.func_177984_a())) {
               var11 = BlockRailBase.EnumRailDirection.ASCENDING_WEST;
            }
         }

         if(var11 == null) {
            var11 = BlockRailBase.EnumRailDirection.NORTH_SOUTH;
         }

         this.func_180360_a(var11);
         this.field_180366_e = this.field_180366_e.func_177226_a(this.field_180365_d.func_176560_l(), var11);
         if(p_180364_2_ || this.field_150660_b.func_180495_p(this.field_180367_c) != this.field_180366_e) {
            this.field_150660_b.func_180501_a(this.field_180367_c, this.field_180366_e, 3);

            for(int var12 = 0; var12 < this.field_150657_g.size(); ++var12) {
               BlockRailBase.Rail var13 = this.func_180697_b((BlockPos)this.field_150657_g.get(var12));
               if(var13 != null) {
                  var13.func_150651_b();
                  if(var13.func_150649_b(this)) {
                     var13.func_150645_c(this);
                  }
               }
            }
         }

         return this;
      }

      public IBlockState func_180362_b() {
         return this.field_180366_e;
      }
   }

   // $FF: synthetic class
   static final class SwitchEnumRailDirection {

      // $FF: synthetic field
      static final int[] field_180371_a = new int[BlockRailBase.EnumRailDirection.values().length];
      private static final String __OBFID = "CL_00002138";


      static {
         try {
            field_180371_a[BlockRailBase.EnumRailDirection.NORTH_SOUTH.ordinal()] = 1;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            field_180371_a[BlockRailBase.EnumRailDirection.EAST_WEST.ordinal()] = 2;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            field_180371_a[BlockRailBase.EnumRailDirection.ASCENDING_EAST.ordinal()] = 3;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            field_180371_a[BlockRailBase.EnumRailDirection.ASCENDING_WEST.ordinal()] = 4;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            field_180371_a[BlockRailBase.EnumRailDirection.ASCENDING_NORTH.ordinal()] = 5;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            field_180371_a[BlockRailBase.EnumRailDirection.ASCENDING_SOUTH.ordinal()] = 6;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            field_180371_a[BlockRailBase.EnumRailDirection.SOUTH_EAST.ordinal()] = 7;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_180371_a[BlockRailBase.EnumRailDirection.SOUTH_WEST.ordinal()] = 8;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_180371_a[BlockRailBase.EnumRailDirection.NORTH_WEST.ordinal()] = 9;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_180371_a[BlockRailBase.EnumRailDirection.NORTH_EAST.ordinal()] = 10;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
