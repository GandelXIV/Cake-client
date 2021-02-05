package net.minecraft.block;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;

public class BlockFire extends Block {

   public static final PropertyInteger field_176543_a = PropertyInteger.func_177719_a("age", 0, 15);
   public static final PropertyBool field_176540_b = PropertyBool.func_177716_a("flip");
   public static final PropertyBool field_176544_M = PropertyBool.func_177716_a("alt");
   public static final PropertyBool field_176545_N = PropertyBool.func_177716_a("north");
   public static final PropertyBool field_176546_O = PropertyBool.func_177716_a("east");
   public static final PropertyBool field_176541_P = PropertyBool.func_177716_a("south");
   public static final PropertyBool field_176539_Q = PropertyBool.func_177716_a("west");
   public static final PropertyInteger field_176542_R = PropertyInteger.func_177719_a("upper", 0, 2);
   private final Map field_149849_a = Maps.newIdentityHashMap();
   private final Map field_149848_b = Maps.newIdentityHashMap();
   private static final String __OBFID = "CL_00000245";


   public IBlockState func_176221_a(IBlockState p_176221_1_, IBlockAccess p_176221_2_, BlockPos p_176221_3_) {
      int var4 = p_176221_3_.func_177958_n();
      int var5 = p_176221_3_.func_177956_o();
      int var6 = p_176221_3_.func_177952_p();
      if(!World.func_175683_a(p_176221_2_, p_176221_3_.func_177977_b()) && !Blocks.field_150480_ab.func_176535_e(p_176221_2_, p_176221_3_.func_177977_b())) {
         boolean var7 = (var4 + var5 + var6 & 1) == 1;
         boolean var8 = (var4 / 2 + var5 / 2 + var6 / 2 & 1) == 1;
         int var9 = 0;
         if(this.func_176535_e(p_176221_2_, p_176221_3_.func_177984_a())) {
            var9 = var7?1:2;
         }

         return p_176221_1_.func_177226_a(field_176545_N, Boolean.valueOf(this.func_176535_e(p_176221_2_, p_176221_3_.func_177978_c()))).func_177226_a(field_176546_O, Boolean.valueOf(this.func_176535_e(p_176221_2_, p_176221_3_.func_177974_f()))).func_177226_a(field_176541_P, Boolean.valueOf(this.func_176535_e(p_176221_2_, p_176221_3_.func_177968_d()))).func_177226_a(field_176539_Q, Boolean.valueOf(this.func_176535_e(p_176221_2_, p_176221_3_.func_177976_e()))).func_177226_a(field_176542_R, Integer.valueOf(var9)).func_177226_a(field_176540_b, Boolean.valueOf(var8)).func_177226_a(field_176544_M, Boolean.valueOf(var7));
      } else {
         return this.func_176223_P();
      }
   }

   protected BlockFire() {
      super(Material.field_151581_o);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176543_a, Integer.valueOf(0)).func_177226_a(field_176540_b, Boolean.valueOf(false)).func_177226_a(field_176544_M, Boolean.valueOf(false)).func_177226_a(field_176545_N, Boolean.valueOf(false)).func_177226_a(field_176546_O, Boolean.valueOf(false)).func_177226_a(field_176541_P, Boolean.valueOf(false)).func_177226_a(field_176539_Q, Boolean.valueOf(false)).func_177226_a(field_176542_R, Integer.valueOf(0)));
      this.func_149675_a(true);
   }

   public static void func_149843_e() {
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150344_f, 5, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150373_bw, 5, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150376_bx, 5, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_180390_bo, 5, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_180391_bp, 5, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_180392_bq, 5, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_180386_br, 5, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_180385_bs, 5, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_180387_bt, 5, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_180407_aO, 5, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_180408_aP, 5, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_180404_aQ, 5, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_180403_aR, 5, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_180406_aS, 5, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_180405_aT, 5, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150476_ad, 5, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150487_bG, 5, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150485_bF, 5, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150481_bH, 5, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150364_r, 5, 5);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150363_s, 5, 5);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150362_t, 30, 60);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150361_u, 30, 60);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150342_X, 30, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150335_W, 15, 100);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150329_H, 60, 100);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150398_cm, 60, 100);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150327_N, 60, 100);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150328_O, 60, 100);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150330_I, 60, 100);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150325_L, 30, 60);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150395_bd, 15, 100);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150402_ci, 5, 5);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150407_cf, 60, 20);
      Blocks.field_150480_ab.func_180686_a(Blocks.field_150404_cg, 60, 20);
   }

   public void func_180686_a(Block p_180686_1_, int p_180686_2_, int p_180686_3_) {
      this.field_149849_a.put(p_180686_1_, Integer.valueOf(p_180686_2_));
      this.field_149848_b.put(p_180686_1_, Integer.valueOf(p_180686_3_));
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

   public int func_149745_a(Random p_149745_1_) {
      return 0;
   }

   public int func_149738_a(World p_149738_1_) {
      return 30;
   }

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      if(p_180650_1_.func_82736_K().func_82766_b("doFireTick")) {
         if(!this.func_176196_c(p_180650_1_, p_180650_2_)) {
            p_180650_1_.func_175698_g(p_180650_2_);
         }

         Block var5 = p_180650_1_.func_180495_p(p_180650_2_.func_177977_b()).func_177230_c();
         boolean var6 = var5 == Blocks.field_150424_aL;
         if(p_180650_1_.field_73011_w instanceof WorldProviderEnd && var5 == Blocks.field_150357_h) {
            var6 = true;
         }

         if(!var6 && p_180650_1_.func_72896_J() && this.func_176537_d(p_180650_1_, p_180650_2_)) {
            p_180650_1_.func_175698_g(p_180650_2_);
         } else {
            int var7 = ((Integer)p_180650_3_.func_177229_b(field_176543_a)).intValue();
            if(var7 < 15) {
               p_180650_3_ = p_180650_3_.func_177226_a(field_176543_a, Integer.valueOf(var7 + p_180650_4_.nextInt(3) / 2));
               p_180650_1_.func_180501_a(p_180650_2_, p_180650_3_, 4);
            }

            p_180650_1_.func_175684_a(p_180650_2_, this, this.func_149738_a(p_180650_1_) + p_180650_4_.nextInt(10));
            if(!var6) {
               if(!this.func_176533_e(p_180650_1_, p_180650_2_)) {
                  if(!World.func_175683_a(p_180650_1_, p_180650_2_.func_177977_b()) || var7 > 3) {
                     p_180650_1_.func_175698_g(p_180650_2_);
                  }

                  return;
               }

               if(!this.func_176535_e(p_180650_1_, p_180650_2_.func_177977_b()) && var7 == 15 && p_180650_4_.nextInt(4) == 0) {
                  p_180650_1_.func_175698_g(p_180650_2_);
                  return;
               }
            }

            boolean var8 = p_180650_1_.func_180502_D(p_180650_2_);
            byte var9 = 0;
            if(var8) {
               var9 = -50;
            }

            this.func_176536_a(p_180650_1_, p_180650_2_.func_177974_f(), 300 + var9, p_180650_4_, var7);
            this.func_176536_a(p_180650_1_, p_180650_2_.func_177976_e(), 300 + var9, p_180650_4_, var7);
            this.func_176536_a(p_180650_1_, p_180650_2_.func_177977_b(), 250 + var9, p_180650_4_, var7);
            this.func_176536_a(p_180650_1_, p_180650_2_.func_177984_a(), 250 + var9, p_180650_4_, var7);
            this.func_176536_a(p_180650_1_, p_180650_2_.func_177978_c(), 300 + var9, p_180650_4_, var7);
            this.func_176536_a(p_180650_1_, p_180650_2_.func_177968_d(), 300 + var9, p_180650_4_, var7);

            for(int var10 = -1; var10 <= 1; ++var10) {
               for(int var11 = -1; var11 <= 1; ++var11) {
                  for(int var12 = -1; var12 <= 4; ++var12) {
                     if(var10 != 0 || var12 != 0 || var11 != 0) {
                        int var13 = 100;
                        if(var12 > 1) {
                           var13 += (var12 - 1) * 100;
                        }

                        BlockPos var14 = p_180650_2_.func_177982_a(var10, var12, var11);
                        int var15 = this.func_176538_m(p_180650_1_, var14);
                        if(var15 > 0) {
                           int var16 = (var15 + 40 + p_180650_1_.func_175659_aa().func_151525_a() * 7) / (var7 + 30);
                           if(var8) {
                              var16 /= 2;
                           }

                           if(var16 > 0 && p_180650_4_.nextInt(var13) <= var16 && (!p_180650_1_.func_72896_J() || !this.func_176537_d(p_180650_1_, var14))) {
                              int var17 = var7 + p_180650_4_.nextInt(5) / 4;
                              if(var17 > 15) {
                                 var17 = 15;
                              }

                              p_180650_1_.func_180501_a(var14, p_180650_3_.func_177226_a(field_176543_a, Integer.valueOf(var17)), 3);
                           }
                        }
                     }
                  }
               }
            }

         }
      }
   }

   protected boolean func_176537_d(World p_176537_1_, BlockPos p_176537_2_) {
      return p_176537_1_.func_175727_C(p_176537_2_) || p_176537_1_.func_175727_C(p_176537_2_.func_177976_e()) || p_176537_1_.func_175727_C(p_176537_2_.func_177974_f()) || p_176537_1_.func_175727_C(p_176537_2_.func_177978_c()) || p_176537_1_.func_175727_C(p_176537_2_.func_177968_d());
   }

   public boolean func_149698_L() {
      return false;
   }

   private int func_176532_c(Block p_176532_1_) {
      Integer var2 = (Integer)this.field_149848_b.get(p_176532_1_);
      return var2 == null?0:var2.intValue();
   }

   private int func_176534_d(Block p_176534_1_) {
      Integer var2 = (Integer)this.field_149849_a.get(p_176534_1_);
      return var2 == null?0:var2.intValue();
   }

   private void func_176536_a(World p_176536_1_, BlockPos p_176536_2_, int p_176536_3_, Random p_176536_4_, int p_176536_5_) {
      int var6 = this.func_176532_c(p_176536_1_.func_180495_p(p_176536_2_).func_177230_c());
      if(p_176536_4_.nextInt(p_176536_3_) < var6) {
         IBlockState var7 = p_176536_1_.func_180495_p(p_176536_2_);
         if(p_176536_4_.nextInt(p_176536_5_ + 10) < 5 && !p_176536_1_.func_175727_C(p_176536_2_)) {
            int var8 = p_176536_5_ + p_176536_4_.nextInt(5) / 4;
            if(var8 > 15) {
               var8 = 15;
            }

            p_176536_1_.func_180501_a(p_176536_2_, this.func_176223_P().func_177226_a(field_176543_a, Integer.valueOf(var8)), 3);
         } else {
            p_176536_1_.func_175698_g(p_176536_2_);
         }

         if(var7.func_177230_c() == Blocks.field_150335_W) {
            Blocks.field_150335_W.func_176206_d(p_176536_1_, p_176536_2_, var7.func_177226_a(BlockTNT.field_176246_a, Boolean.valueOf(true)));
         }
      }

   }

   private boolean func_176533_e(World p_176533_1_, BlockPos p_176533_2_) {
      EnumFacing[] var3 = EnumFacing.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EnumFacing var6 = var3[var5];
         if(this.func_176535_e(p_176533_1_, p_176533_2_.func_177972_a(var6))) {
            return true;
         }
      }

      return false;
   }

   private int func_176538_m(World p_176538_1_, BlockPos p_176538_2_) {
      if(!p_176538_1_.func_175623_d(p_176538_2_)) {
         return 0;
      } else {
         int var3 = 0;
         EnumFacing[] var4 = EnumFacing.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            EnumFacing var7 = var4[var6];
            var3 = Math.max(this.func_176534_d(p_176538_1_.func_180495_p(p_176538_2_.func_177972_a(var7)).func_177230_c()), var3);
         }

         return var3;
      }
   }

   public boolean func_149703_v() {
      return false;
   }

   public boolean func_176535_e(IBlockAccess p_176535_1_, BlockPos p_176535_2_) {
      return this.func_176534_d(p_176535_1_.func_180495_p(p_176535_2_).func_177230_c()) > 0;
   }

   public boolean func_176196_c(World p_176196_1_, BlockPos p_176196_2_) {
      return World.func_175683_a(p_176196_1_, p_176196_2_.func_177977_b()) || this.func_176533_e(p_176196_1_, p_176196_2_);
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      if(!World.func_175683_a(p_176204_1_, p_176204_2_.func_177977_b()) && !this.func_176533_e(p_176204_1_, p_176204_2_)) {
         p_176204_1_.func_175698_g(p_176204_2_);
      }

   }

   public void func_176213_c(World p_176213_1_, BlockPos p_176213_2_, IBlockState p_176213_3_) {
      if(p_176213_1_.field_73011_w.func_177502_q() > 0 || !Blocks.field_150427_aO.func_176548_d(p_176213_1_, p_176213_2_)) {
         if(!World.func_175683_a(p_176213_1_, p_176213_2_.func_177977_b()) && !this.func_176533_e(p_176213_1_, p_176213_2_)) {
            p_176213_1_.func_175698_g(p_176213_2_);
         } else {
            p_176213_1_.func_175684_a(p_176213_2_, this, this.func_149738_a(p_176213_1_) + p_176213_1_.field_73012_v.nextInt(10));
         }
      }
   }

   public void func_180655_c(World p_180655_1_, BlockPos p_180655_2_, IBlockState p_180655_3_, Random p_180655_4_) {
      if(p_180655_4_.nextInt(24) == 0) {
         p_180655_1_.func_72980_b((double)((float)p_180655_2_.func_177958_n() + 0.5F), (double)((float)p_180655_2_.func_177956_o() + 0.5F), (double)((float)p_180655_2_.func_177952_p() + 0.5F), "fire.fire", 1.0F + p_180655_4_.nextFloat(), p_180655_4_.nextFloat() * 0.7F + 0.3F, false);
      }

      int var5;
      double var6;
      double var8;
      double var10;
      if(!World.func_175683_a(p_180655_1_, p_180655_2_.func_177977_b()) && !Blocks.field_150480_ab.func_176535_e(p_180655_1_, p_180655_2_.func_177977_b())) {
         if(Blocks.field_150480_ab.func_176535_e(p_180655_1_, p_180655_2_.func_177976_e())) {
            for(var5 = 0; var5 < 2; ++var5) {
               var6 = (double)p_180655_2_.func_177958_n() + p_180655_4_.nextDouble() * 0.10000000149011612D;
               var8 = (double)p_180655_2_.func_177956_o() + p_180655_4_.nextDouble();
               var10 = (double)p_180655_2_.func_177952_p() + p_180655_4_.nextDouble();
               p_180655_1_.func_175688_a(EnumParticleTypes.SMOKE_LARGE, var6, var8, var10, 0.0D, 0.0D, 0.0D, new int[0]);
            }
         }

         if(Blocks.field_150480_ab.func_176535_e(p_180655_1_, p_180655_2_.func_177974_f())) {
            for(var5 = 0; var5 < 2; ++var5) {
               var6 = (double)(p_180655_2_.func_177958_n() + 1) - p_180655_4_.nextDouble() * 0.10000000149011612D;
               var8 = (double)p_180655_2_.func_177956_o() + p_180655_4_.nextDouble();
               var10 = (double)p_180655_2_.func_177952_p() + p_180655_4_.nextDouble();
               p_180655_1_.func_175688_a(EnumParticleTypes.SMOKE_LARGE, var6, var8, var10, 0.0D, 0.0D, 0.0D, new int[0]);
            }
         }

         if(Blocks.field_150480_ab.func_176535_e(p_180655_1_, p_180655_2_.func_177978_c())) {
            for(var5 = 0; var5 < 2; ++var5) {
               var6 = (double)p_180655_2_.func_177958_n() + p_180655_4_.nextDouble();
               var8 = (double)p_180655_2_.func_177956_o() + p_180655_4_.nextDouble();
               var10 = (double)p_180655_2_.func_177952_p() + p_180655_4_.nextDouble() * 0.10000000149011612D;
               p_180655_1_.func_175688_a(EnumParticleTypes.SMOKE_LARGE, var6, var8, var10, 0.0D, 0.0D, 0.0D, new int[0]);
            }
         }

         if(Blocks.field_150480_ab.func_176535_e(p_180655_1_, p_180655_2_.func_177968_d())) {
            for(var5 = 0; var5 < 2; ++var5) {
               var6 = (double)p_180655_2_.func_177958_n() + p_180655_4_.nextDouble();
               var8 = (double)p_180655_2_.func_177956_o() + p_180655_4_.nextDouble();
               var10 = (double)(p_180655_2_.func_177952_p() + 1) - p_180655_4_.nextDouble() * 0.10000000149011612D;
               p_180655_1_.func_175688_a(EnumParticleTypes.SMOKE_LARGE, var6, var8, var10, 0.0D, 0.0D, 0.0D, new int[0]);
            }
         }

         if(Blocks.field_150480_ab.func_176535_e(p_180655_1_, p_180655_2_.func_177984_a())) {
            for(var5 = 0; var5 < 2; ++var5) {
               var6 = (double)p_180655_2_.func_177958_n() + p_180655_4_.nextDouble();
               var8 = (double)(p_180655_2_.func_177956_o() + 1) - p_180655_4_.nextDouble() * 0.10000000149011612D;
               var10 = (double)p_180655_2_.func_177952_p() + p_180655_4_.nextDouble();
               p_180655_1_.func_175688_a(EnumParticleTypes.SMOKE_LARGE, var6, var8, var10, 0.0D, 0.0D, 0.0D, new int[0]);
            }
         }
      } else {
         for(var5 = 0; var5 < 3; ++var5) {
            var6 = (double)p_180655_2_.func_177958_n() + p_180655_4_.nextDouble();
            var8 = (double)p_180655_2_.func_177956_o() + p_180655_4_.nextDouble() * 0.5D + 0.5D;
            var10 = (double)p_180655_2_.func_177952_p() + p_180655_4_.nextDouble();
            p_180655_1_.func_175688_a(EnumParticleTypes.SMOKE_LARGE, var6, var8, var10, 0.0D, 0.0D, 0.0D, new int[0]);
         }
      }

   }

   public MapColor func_180659_g(IBlockState p_180659_1_) {
      return MapColor.field_151656_f;
   }

   public EnumWorldBlockLayer func_180664_k() {
      return EnumWorldBlockLayer.CUTOUT;
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176543_a, Integer.valueOf(p_176203_1_));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((Integer)p_176201_1_.func_177229_b(field_176543_a)).intValue();
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176543_a, field_176545_N, field_176546_O, field_176541_P, field_176539_Q, field_176542_R, field_176540_b, field_176544_M});
   }

}
