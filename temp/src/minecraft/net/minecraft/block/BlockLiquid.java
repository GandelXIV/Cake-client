package net.minecraft.block;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColorHelper;

public abstract class BlockLiquid extends Block {

   public static final PropertyInteger field_176367_b = PropertyInteger.func_177719_a("level", 0, 15);
   private static final String __OBFID = "CL_00000265";


   protected BlockLiquid(Material p_i45413_1_) {
      super(p_i45413_1_);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176367_b, Integer.valueOf(0)));
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      this.func_149675_a(true);
   }

   public boolean func_176205_b(IBlockAccess p_176205_1_, BlockPos p_176205_2_) {
      return this.field_149764_J != Material.field_151587_i;
   }

   public int func_180662_a(IBlockAccess p_180662_1_, BlockPos p_180662_2_, int p_180662_3_) {
      return this.field_149764_J == Material.field_151586_h?BiomeColorHelper.func_180288_c(p_180662_1_, p_180662_2_):16777215;
   }

   public static float func_149801_b(int p_149801_0_) {
      if(p_149801_0_ >= 8) {
         p_149801_0_ = 0;
      }

      return (float)(p_149801_0_ + 1) / 9.0F;
   }

   protected int func_176362_e(IBlockAccess p_176362_1_, BlockPos p_176362_2_) {
      return p_176362_1_.func_180495_p(p_176362_2_).func_177230_c().func_149688_o() == this.field_149764_J?((Integer)p_176362_1_.func_180495_p(p_176362_2_).func_177229_b(field_176367_b)).intValue():-1;
   }

   protected int func_176366_f(IBlockAccess p_176366_1_, BlockPos p_176366_2_) {
      int var3 = this.func_176362_e(p_176366_1_, p_176366_2_);
      return var3 >= 8?0:var3;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_176209_a(IBlockState p_176209_1_, boolean p_176209_2_) {
      return p_176209_2_ && ((Integer)p_176209_1_.func_177229_b(field_176367_b)).intValue() == 0;
   }

   public boolean func_176212_b(IBlockAccess p_176212_1_, BlockPos p_176212_2_, EnumFacing p_176212_3_) {
      Material var4 = p_176212_1_.func_180495_p(p_176212_2_).func_177230_c().func_149688_o();
      return var4 == this.field_149764_J?false:(p_176212_3_ == EnumFacing.UP?true:(var4 == Material.field_151588_w?false:super.func_176212_b(p_176212_1_, p_176212_2_, p_176212_3_)));
   }

   public boolean func_176225_a(IBlockAccess p_176225_1_, BlockPos p_176225_2_, EnumFacing p_176225_3_) {
      return p_176225_1_.func_180495_p(p_176225_2_).func_177230_c().func_149688_o() == this.field_149764_J?false:(p_176225_3_ == EnumFacing.UP?true:super.func_176225_a(p_176225_1_, p_176225_2_, p_176225_3_));
   }

   public boolean func_176364_g(IBlockAccess p_176364_1_, BlockPos p_176364_2_) {
      for(int var3 = -1; var3 <= 1; ++var3) {
         for(int var4 = -1; var4 <= 1; ++var4) {
            IBlockState var5 = p_176364_1_.func_180495_p(p_176364_2_.func_177982_a(var3, 0, var4));
            Block var6 = var5.func_177230_c();
            Material var7 = var6.func_149688_o();
            if(var7 != this.field_149764_J && !var6.func_149730_j()) {
               return true;
            }
         }
      }

      return false;
   }

   public AxisAlignedBB func_180640_a(World p_180640_1_, BlockPos p_180640_2_, IBlockState p_180640_3_) {
      return null;
   }

   public int func_149645_b() {
      return 1;
   }

   public Item func_180660_a(IBlockState p_180660_1_, Random p_180660_2_, int p_180660_3_) {
      return null;
   }

   public int func_149745_a(Random p_149745_1_) {
      return 0;
   }

   protected Vec3 func_180687_h(IBlockAccess p_180687_1_, BlockPos p_180687_2_) {
      Vec3 var3 = new Vec3(0.0D, 0.0D, 0.0D);
      int var4 = this.func_176366_f(p_180687_1_, p_180687_2_);
      Iterator var5 = EnumFacing.Plane.HORIZONTAL.iterator();

      EnumFacing var6;
      BlockPos var7;
      while(var5.hasNext()) {
         var6 = (EnumFacing)var5.next();
         var7 = p_180687_2_.func_177972_a(var6);
         int var8 = this.func_176366_f(p_180687_1_, var7);
         int var9;
         if(var8 < 0) {
            if(!p_180687_1_.func_180495_p(var7).func_177230_c().func_149688_o().func_76230_c()) {
               var8 = this.func_176366_f(p_180687_1_, var7.func_177977_b());
               if(var8 >= 0) {
                  var9 = var8 - (var4 - 8);
                  var3 = var3.func_72441_c((double)((var7.func_177958_n() - p_180687_2_.func_177958_n()) * var9), (double)((var7.func_177956_o() - p_180687_2_.func_177956_o()) * var9), (double)((var7.func_177952_p() - p_180687_2_.func_177952_p()) * var9));
               }
            }
         } else if(var8 >= 0) {
            var9 = var8 - var4;
            var3 = var3.func_72441_c((double)((var7.func_177958_n() - p_180687_2_.func_177958_n()) * var9), (double)((var7.func_177956_o() - p_180687_2_.func_177956_o()) * var9), (double)((var7.func_177952_p() - p_180687_2_.func_177952_p()) * var9));
         }
      }

      if(((Integer)p_180687_1_.func_180495_p(p_180687_2_).func_177229_b(field_176367_b)).intValue() >= 8) {
         var5 = EnumFacing.Plane.HORIZONTAL.iterator();

         while(var5.hasNext()) {
            var6 = (EnumFacing)var5.next();
            var7 = p_180687_2_.func_177972_a(var6);
            if(this.func_176212_b(p_180687_1_, var7, var6) || this.func_176212_b(p_180687_1_, var7.func_177984_a(), var6)) {
               var3 = var3.func_72432_b().func_72441_c(0.0D, -6.0D, 0.0D);
               break;
            }
         }
      }

      return var3.func_72432_b();
   }

   public Vec3 func_176197_a(World p_176197_1_, BlockPos p_176197_2_, Entity p_176197_3_, Vec3 p_176197_4_) {
      return p_176197_4_.func_178787_e(this.func_180687_h(p_176197_1_, p_176197_2_));
   }

   public int func_149738_a(World p_149738_1_) {
      return this.field_149764_J == Material.field_151586_h?5:(this.field_149764_J == Material.field_151587_i?(p_149738_1_.field_73011_w.func_177495_o()?10:30):0);
   }

   public int func_176207_c(IBlockAccess p_176207_1_, BlockPos p_176207_2_) {
      int var3 = p_176207_1_.func_175626_b(p_176207_2_, 0);
      int var4 = p_176207_1_.func_175626_b(p_176207_2_.func_177984_a(), 0);
      int var5 = var3 & 255;
      int var6 = var4 & 255;
      int var7 = var3 >> 16 & 255;
      int var8 = var4 >> 16 & 255;
      return (var5 > var6?var5:var6) | (var7 > var8?var7:var8) << 16;
   }

   public EnumWorldBlockLayer func_180664_k() {
      return this.field_149764_J == Material.field_151586_h?EnumWorldBlockLayer.TRANSLUCENT:EnumWorldBlockLayer.SOLID;
   }

   public void func_180655_c(World p_180655_1_, BlockPos p_180655_2_, IBlockState p_180655_3_, Random p_180655_4_) {
      double var5 = (double)p_180655_2_.func_177958_n();
      double var7 = (double)p_180655_2_.func_177956_o();
      double var9 = (double)p_180655_2_.func_177952_p();
      if(this.field_149764_J == Material.field_151586_h) {
         int var11 = ((Integer)p_180655_3_.func_177229_b(field_176367_b)).intValue();
         if(var11 > 0 && var11 < 8) {
            if(p_180655_4_.nextInt(64) == 0) {
               p_180655_1_.func_72980_b(var5 + 0.5D, var7 + 0.5D, var9 + 0.5D, "liquid.water", p_180655_4_.nextFloat() * 0.25F + 0.75F, p_180655_4_.nextFloat() * 1.0F + 0.5F, false);
            }
         } else if(p_180655_4_.nextInt(10) == 0) {
            p_180655_1_.func_175688_a(EnumParticleTypes.SUSPENDED, var5 + (double)p_180655_4_.nextFloat(), var7 + (double)p_180655_4_.nextFloat(), var9 + (double)p_180655_4_.nextFloat(), 0.0D, 0.0D, 0.0D, new int[0]);
         }
      }

      if(this.field_149764_J == Material.field_151587_i && p_180655_1_.func_180495_p(p_180655_2_.func_177984_a()).func_177230_c().func_149688_o() == Material.field_151579_a && !p_180655_1_.func_180495_p(p_180655_2_.func_177984_a()).func_177230_c().func_149662_c()) {
         if(p_180655_4_.nextInt(100) == 0) {
            double var18 = var5 + (double)p_180655_4_.nextFloat();
            double var13 = var7 + this.field_149756_F;
            double var15 = var9 + (double)p_180655_4_.nextFloat();
            p_180655_1_.func_175688_a(EnumParticleTypes.LAVA, var18, var13, var15, 0.0D, 0.0D, 0.0D, new int[0]);
            p_180655_1_.func_72980_b(var18, var13, var15, "liquid.lavapop", 0.2F + p_180655_4_.nextFloat() * 0.2F, 0.9F + p_180655_4_.nextFloat() * 0.15F, false);
         }

         if(p_180655_4_.nextInt(200) == 0) {
            p_180655_1_.func_72980_b(var5, var7, var9, "liquid.lava", 0.2F + p_180655_4_.nextFloat() * 0.2F, 0.9F + p_180655_4_.nextFloat() * 0.15F, false);
         }
      }

      if(p_180655_4_.nextInt(10) == 0 && World.func_175683_a(p_180655_1_, p_180655_2_.func_177977_b())) {
         Material var19 = p_180655_1_.func_180495_p(p_180655_2_.func_177979_c(2)).func_177230_c().func_149688_o();
         if(!var19.func_76230_c() && !var19.func_76224_d()) {
            double var12 = var5 + (double)p_180655_4_.nextFloat();
            double var14 = var7 - 1.05D;
            double var16 = var9 + (double)p_180655_4_.nextFloat();
            if(this.field_149764_J == Material.field_151586_h) {
               p_180655_1_.func_175688_a(EnumParticleTypes.DRIP_WATER, var12, var14, var16, 0.0D, 0.0D, 0.0D, new int[0]);
            } else {
               p_180655_1_.func_175688_a(EnumParticleTypes.DRIP_LAVA, var12, var14, var16, 0.0D, 0.0D, 0.0D, new int[0]);
            }
         }
      }

   }

   public static double func_180689_a(IBlockAccess p_180689_0_, BlockPos p_180689_1_, Material p_180689_2_) {
      Vec3 var3 = func_176361_a(p_180689_2_).func_180687_h(p_180689_0_, p_180689_1_);
      return var3.field_72450_a == 0.0D && var3.field_72449_c == 0.0D?-1000.0D:Math.atan2(var3.field_72449_c, var3.field_72450_a) - 1.5707963267948966D;
   }

   public void func_176213_c(World p_176213_1_, BlockPos p_176213_2_, IBlockState p_176213_3_) {
      this.func_176365_e(p_176213_1_, p_176213_2_, p_176213_3_);
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      this.func_176365_e(p_176204_1_, p_176204_2_, p_176204_3_);
   }

   public boolean func_176365_e(World p_176365_1_, BlockPos p_176365_2_, IBlockState p_176365_3_) {
      if(this.field_149764_J == Material.field_151587_i) {
         boolean var4 = false;
         EnumFacing[] var5 = EnumFacing.values();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            EnumFacing var8 = var5[var7];
            if(var8 != EnumFacing.DOWN && p_176365_1_.func_180495_p(p_176365_2_.func_177972_a(var8)).func_177230_c().func_149688_o() == Material.field_151586_h) {
               var4 = true;
               break;
            }
         }

         if(var4) {
            Integer var9 = (Integer)p_176365_3_.func_177229_b(field_176367_b);
            if(var9.intValue() == 0) {
               p_176365_1_.func_175656_a(p_176365_2_, Blocks.field_150343_Z.func_176223_P());
               this.func_180688_d(p_176365_1_, p_176365_2_);
               return true;
            }

            if(var9.intValue() <= 4) {
               p_176365_1_.func_175656_a(p_176365_2_, Blocks.field_150347_e.func_176223_P());
               this.func_180688_d(p_176365_1_, p_176365_2_);
               return true;
            }
         }
      }

      return false;
   }

   protected void func_180688_d(World p_180688_1_, BlockPos p_180688_2_) {
      double var3 = (double)p_180688_2_.func_177958_n();
      double var5 = (double)p_180688_2_.func_177956_o();
      double var7 = (double)p_180688_2_.func_177952_p();
      p_180688_1_.func_72908_a(var3 + 0.5D, var5 + 0.5D, var7 + 0.5D, "random.fizz", 0.5F, 2.6F + (p_180688_1_.field_73012_v.nextFloat() - p_180688_1_.field_73012_v.nextFloat()) * 0.8F);

      for(int var9 = 0; var9 < 8; ++var9) {
         p_180688_1_.func_175688_a(EnumParticleTypes.SMOKE_LARGE, var3 + Math.random(), var5 + 1.2D, var7 + Math.random(), 0.0D, 0.0D, 0.0D, new int[0]);
      }

   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176367_b, Integer.valueOf(p_176203_1_));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((Integer)p_176201_1_.func_177229_b(field_176367_b)).intValue();
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176367_b});
   }

   public static BlockDynamicLiquid func_176361_a(Material p_176361_0_) {
      if(p_176361_0_ == Material.field_151586_h) {
         return Blocks.field_150358_i;
      } else if(p_176361_0_ == Material.field_151587_i) {
         return Blocks.field_150356_k;
      } else {
         throw new IllegalArgumentException("Invalid material");
      }
   }

   public static BlockStaticLiquid func_176363_b(Material p_176363_0_) {
      if(p_176363_0_ == Material.field_151586_h) {
         return Blocks.field_150355_j;
      } else if(p_176363_0_ == Material.field_151587_i) {
         return Blocks.field_150353_l;
      } else {
         throw new IllegalArgumentException("Invalid material");
      }
   }

}
