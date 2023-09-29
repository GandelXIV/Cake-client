package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPortal extends BlockBreakable {

   public static final PropertyEnum field_176550_a = PropertyEnum.func_177706_a("axis", EnumFacing.Axis.class, new EnumFacing.Axis[]{EnumFacing.Axis.X, EnumFacing.Axis.Z});
   private static final String __OBFID = "CL_00000284";


   public BlockPortal() {
      super(Material.field_151567_E, false);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176550_a, EnumFacing.Axis.X));
      this.func_149675_a(true);
   }

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      super.func_180650_b(p_180650_1_, p_180650_2_, p_180650_3_, p_180650_4_);
      if(p_180650_1_.field_73011_w.func_76569_d() && p_180650_1_.func_82736_K().func_82766_b("doMobSpawning") && p_180650_4_.nextInt(2000) < p_180650_1_.func_175659_aa().func_151525_a()) {
         int var5 = p_180650_2_.func_177956_o();

         BlockPos var6;
         for(var6 = p_180650_2_; !World.func_175683_a(p_180650_1_, var6) && var6.func_177956_o() > 0; var6 = var6.func_177977_b()) {
            ;
         }

         if(var5 > 0 && !p_180650_1_.func_180495_p(var6.func_177984_a()).func_177230_c().func_149721_r()) {
            Entity var7 = ItemMonsterPlacer.func_77840_a(p_180650_1_, 57, (double)var6.func_177958_n() + 0.5D, (double)var6.func_177956_o() + 1.1D, (double)var6.func_177952_p() + 0.5D);
            if(var7 != null) {
               var7.field_71088_bW = var7.func_82147_ab();
            }
         }
      }

   }

   public AxisAlignedBB func_180640_a(World p_180640_1_, BlockPos p_180640_2_, IBlockState p_180640_3_) {
      return null;
   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      EnumFacing.Axis var3 = (EnumFacing.Axis)p_180654_1_.func_180495_p(p_180654_2_).func_177229_b(field_176550_a);
      float var4 = 0.125F;
      float var5 = 0.125F;
      if(var3 == EnumFacing.Axis.X) {
         var4 = 0.5F;
      }

      if(var3 == EnumFacing.Axis.Z) {
         var5 = 0.5F;
      }

      this.func_149676_a(0.5F - var4, 0.0F, 0.5F - var5, 0.5F + var4, 1.0F, 0.5F + var5);
   }

   public static int func_176549_a(EnumFacing.Axis p_176549_0_) {
      return p_176549_0_ == EnumFacing.Axis.X?1:(p_176549_0_ == EnumFacing.Axis.Z?2:0);
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_176548_d(World p_176548_1_, BlockPos p_176548_2_) {
      BlockPortal.Size var3 = new BlockPortal.Size(p_176548_1_, p_176548_2_, EnumFacing.Axis.X);
      if(var3.func_150860_b() && var3.field_150864_e == 0) {
         var3.func_150859_c();
         return true;
      } else {
         BlockPortal.Size var4 = new BlockPortal.Size(p_176548_1_, p_176548_2_, EnumFacing.Axis.Z);
         if(var4.func_150860_b() && var4.field_150864_e == 0) {
            var4.func_150859_c();
            return true;
         } else {
            return false;
         }
      }
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      EnumFacing.Axis var5 = (EnumFacing.Axis)p_176204_3_.func_177229_b(field_176550_a);
      BlockPortal.Size var6;
      if(var5 == EnumFacing.Axis.X) {
         var6 = new BlockPortal.Size(p_176204_1_, p_176204_2_, EnumFacing.Axis.X);
         if(!var6.func_150860_b() || var6.field_150864_e < var6.field_150868_h * var6.field_150862_g) {
            p_176204_1_.func_175656_a(p_176204_2_, Blocks.field_150350_a.func_176223_P());
         }
      } else if(var5 == EnumFacing.Axis.Z) {
         var6 = new BlockPortal.Size(p_176204_1_, p_176204_2_, EnumFacing.Axis.Z);
         if(!var6.func_150860_b() || var6.field_150864_e < var6.field_150868_h * var6.field_150862_g) {
            p_176204_1_.func_175656_a(p_176204_2_, Blocks.field_150350_a.func_176223_P());
         }
      }

   }

   public boolean func_176225_a(IBlockAccess p_176225_1_, BlockPos p_176225_2_, EnumFacing p_176225_3_) {
      EnumFacing.Axis var4 = null;
      IBlockState var5 = p_176225_1_.func_180495_p(p_176225_2_);
      if(p_176225_1_.func_180495_p(p_176225_2_).func_177230_c() == this) {
         var4 = (EnumFacing.Axis)var5.func_177229_b(field_176550_a);
         if(var4 == null) {
            return false;
         }

         if(var4 == EnumFacing.Axis.Z && p_176225_3_ != EnumFacing.EAST && p_176225_3_ != EnumFacing.WEST) {
            return false;
         }

         if(var4 == EnumFacing.Axis.X && p_176225_3_ != EnumFacing.SOUTH && p_176225_3_ != EnumFacing.NORTH) {
            return false;
         }
      }

      boolean var6 = p_176225_1_.func_180495_p(p_176225_2_.func_177976_e()).func_177230_c() == this && p_176225_1_.func_180495_p(p_176225_2_.func_177985_f(2)).func_177230_c() != this;
      boolean var7 = p_176225_1_.func_180495_p(p_176225_2_.func_177974_f()).func_177230_c() == this && p_176225_1_.func_180495_p(p_176225_2_.func_177965_g(2)).func_177230_c() != this;
      boolean var8 = p_176225_1_.func_180495_p(p_176225_2_.func_177978_c()).func_177230_c() == this && p_176225_1_.func_180495_p(p_176225_2_.func_177964_d(2)).func_177230_c() != this;
      boolean var9 = p_176225_1_.func_180495_p(p_176225_2_.func_177968_d()).func_177230_c() == this && p_176225_1_.func_180495_p(p_176225_2_.func_177970_e(2)).func_177230_c() != this;
      boolean var10 = var6 || var7 || var4 == EnumFacing.Axis.X;
      boolean var11 = var8 || var9 || var4 == EnumFacing.Axis.Z;
      return var10 && p_176225_3_ == EnumFacing.WEST?true:(var10 && p_176225_3_ == EnumFacing.EAST?true:(var11 && p_176225_3_ == EnumFacing.NORTH?true:var11 && p_176225_3_ == EnumFacing.SOUTH));
   }

   public int func_149745_a(Random p_149745_1_) {
      return 0;
   }

   public EnumWorldBlockLayer func_180664_k() {
      return EnumWorldBlockLayer.TRANSLUCENT;
   }

   public void func_180634_a(World p_180634_1_, BlockPos p_180634_2_, IBlockState p_180634_3_, Entity p_180634_4_) {
      if(p_180634_4_.field_70154_o == null && p_180634_4_.field_70153_n == null) {
         p_180634_4_.func_70063_aa();
      }

   }

   public void func_180655_c(World p_180655_1_, BlockPos p_180655_2_, IBlockState p_180655_3_, Random p_180655_4_) {
      if(p_180655_4_.nextInt(100) == 0) {
         p_180655_1_.func_72980_b((double)p_180655_2_.func_177958_n() + 0.5D, (double)p_180655_2_.func_177956_o() + 0.5D, (double)p_180655_2_.func_177952_p() + 0.5D, "portal.portal", 0.5F, p_180655_4_.nextFloat() * 0.4F + 0.8F, false);
      }

      for(int var5 = 0; var5 < 4; ++var5) {
         double var6 = (double)((float)p_180655_2_.func_177958_n() + p_180655_4_.nextFloat());
         double var8 = (double)((float)p_180655_2_.func_177956_o() + p_180655_4_.nextFloat());
         double var10 = (double)((float)p_180655_2_.func_177952_p() + p_180655_4_.nextFloat());
         double var12 = ((double)p_180655_4_.nextFloat() - 0.5D) * 0.5D;
         double var14 = ((double)p_180655_4_.nextFloat() - 0.5D) * 0.5D;
         double var16 = ((double)p_180655_4_.nextFloat() - 0.5D) * 0.5D;
         int var18 = p_180655_4_.nextInt(2) * 2 - 1;
         if(p_180655_1_.func_180495_p(p_180655_2_.func_177976_e()).func_177230_c() != this && p_180655_1_.func_180495_p(p_180655_2_.func_177974_f()).func_177230_c() != this) {
            var6 = (double)p_180655_2_.func_177958_n() + 0.5D + 0.25D * (double)var18;
            var12 = (double)(p_180655_4_.nextFloat() * 2.0F * (float)var18);
         } else {
            var10 = (double)p_180655_2_.func_177952_p() + 0.5D + 0.25D * (double)var18;
            var16 = (double)(p_180655_4_.nextFloat() * 2.0F * (float)var18);
         }

         p_180655_1_.func_175688_a(EnumParticleTypes.PORTAL, var6, var8, var10, var12, var14, var16, new int[0]);
      }

   }

   public Item func_180665_b(World p_180665_1_, BlockPos p_180665_2_) {
      return null;
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176550_a, (p_176203_1_ & 3) == 2?EnumFacing.Axis.Z:EnumFacing.Axis.X);
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return func_176549_a((EnumFacing.Axis)p_176201_1_.func_177229_b(field_176550_a));
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176550_a});
   }


   public static class Size {

      private final World field_150867_a;
      private final EnumFacing.Axis field_150865_b;
      private final EnumFacing field_150866_c;
      private final EnumFacing field_150863_d;
      private int field_150864_e = 0;
      private BlockPos field_150861_f;
      private int field_150862_g;
      private int field_150868_h;
      private static final String __OBFID = "CL_00000285";


      public Size(World p_i45694_1_, BlockPos p_i45694_2_, EnumFacing.Axis p_i45694_3_) {
         this.field_150867_a = p_i45694_1_;
         this.field_150865_b = p_i45694_3_;
         if(p_i45694_3_ == EnumFacing.Axis.X) {
            this.field_150863_d = EnumFacing.EAST;
            this.field_150866_c = EnumFacing.WEST;
         } else {
            this.field_150863_d = EnumFacing.NORTH;
            this.field_150866_c = EnumFacing.SOUTH;
         }

         for(BlockPos var4 = p_i45694_2_; p_i45694_2_.func_177956_o() > var4.func_177956_o() - 21 && p_i45694_2_.func_177956_o() > 0 && this.func_150857_a(p_i45694_1_.func_180495_p(p_i45694_2_.func_177977_b()).func_177230_c()); p_i45694_2_ = p_i45694_2_.func_177977_b()) {
            ;
         }

         int var5 = this.func_180120_a(p_i45694_2_, this.field_150863_d) - 1;
         if(var5 >= 0) {
            this.field_150861_f = p_i45694_2_.func_177967_a(this.field_150863_d, var5);
            this.field_150868_h = this.func_180120_a(this.field_150861_f, this.field_150866_c);
            if(this.field_150868_h < 2 || this.field_150868_h > 21) {
               this.field_150861_f = null;
               this.field_150868_h = 0;
            }
         }

         if(this.field_150861_f != null) {
            this.field_150862_g = this.func_150858_a();
         }

      }

      protected int func_180120_a(BlockPos p_180120_1_, EnumFacing p_180120_2_) {
         int var3;
         for(var3 = 0; var3 < 22; ++var3) {
            BlockPos var4 = p_180120_1_.func_177967_a(p_180120_2_, var3);
            if(!this.func_150857_a(this.field_150867_a.func_180495_p(var4).func_177230_c()) || this.field_150867_a.func_180495_p(var4.func_177977_b()).func_177230_c() != Blocks.field_150343_Z) {
               break;
            }
         }

         Block var5 = this.field_150867_a.func_180495_p(p_180120_1_.func_177967_a(p_180120_2_, var3)).func_177230_c();
         return var5 == Blocks.field_150343_Z?var3:0;
      }

      protected int func_150858_a() {
         int var1;
         label56:
         for(this.field_150862_g = 0; this.field_150862_g < 21; ++this.field_150862_g) {
            for(var1 = 0; var1 < this.field_150868_h; ++var1) {
               BlockPos var2 = this.field_150861_f.func_177967_a(this.field_150866_c, var1).func_177981_b(this.field_150862_g);
               Block var3 = this.field_150867_a.func_180495_p(var2).func_177230_c();
               if(!this.func_150857_a(var3)) {
                  break label56;
               }

               if(var3 == Blocks.field_150427_aO) {
                  ++this.field_150864_e;
               }

               if(var1 == 0) {
                  var3 = this.field_150867_a.func_180495_p(var2.func_177972_a(this.field_150863_d)).func_177230_c();
                  if(var3 != Blocks.field_150343_Z) {
                     break label56;
                  }
               } else if(var1 == this.field_150868_h - 1) {
                  var3 = this.field_150867_a.func_180495_p(var2.func_177972_a(this.field_150866_c)).func_177230_c();
                  if(var3 != Blocks.field_150343_Z) {
                     break label56;
                  }
               }
            }
         }

         for(var1 = 0; var1 < this.field_150868_h; ++var1) {
            if(this.field_150867_a.func_180495_p(this.field_150861_f.func_177967_a(this.field_150866_c, var1).func_177981_b(this.field_150862_g)).func_177230_c() != Blocks.field_150343_Z) {
               this.field_150862_g = 0;
               break;
            }
         }

         if(this.field_150862_g <= 21 && this.field_150862_g >= 3) {
            return this.field_150862_g;
         } else {
            this.field_150861_f = null;
            this.field_150868_h = 0;
            this.field_150862_g = 0;
            return 0;
         }
      }

      protected boolean func_150857_a(Block p_150857_1_) {
         return p_150857_1_.field_149764_J == Material.field_151579_a || p_150857_1_ == Blocks.field_150480_ab || p_150857_1_ == Blocks.field_150427_aO;
      }

      public boolean func_150860_b() {
         return this.field_150861_f != null && this.field_150868_h >= 2 && this.field_150868_h <= 21 && this.field_150862_g >= 3 && this.field_150862_g <= 21;
      }

      public void func_150859_c() {
         for(int var1 = 0; var1 < this.field_150868_h; ++var1) {
            BlockPos var2 = this.field_150861_f.func_177967_a(this.field_150866_c, var1);

            for(int var3 = 0; var3 < this.field_150862_g; ++var3) {
               this.field_150867_a.func_180501_a(var2.func_177981_b(var3), Blocks.field_150427_aO.func_176223_P().func_177226_a(BlockPortal.field_176550_a, this.field_150865_b), 2);
            }
         }

      }
   }
}
