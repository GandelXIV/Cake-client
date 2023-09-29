package net.minecraft.world.gen;

import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGeneratorOctaves;

public class ChunkProviderEnd implements IChunkProvider {

   private Random field_73204_i;
   private NoiseGeneratorOctaves field_73201_j;
   private NoiseGeneratorOctaves field_73202_k;
   private NoiseGeneratorOctaves field_73199_l;
   public NoiseGeneratorOctaves field_73196_a;
   public NoiseGeneratorOctaves field_73194_b;
   private World field_73200_m;
   private double[] field_73197_n;
   private BiomeGenBase[] field_73198_o;
   double[] field_73195_c;
   double[] field_73192_d;
   double[] field_73193_e;
   double[] field_73190_f;
   double[] field_73191_g;
   private static final String __OBFID = "CL_00000397";


   public ChunkProviderEnd(World p_i2007_1_, long p_i2007_2_) {
      this.field_73200_m = p_i2007_1_;
      this.field_73204_i = new Random(p_i2007_2_);
      this.field_73201_j = new NoiseGeneratorOctaves(this.field_73204_i, 16);
      this.field_73202_k = new NoiseGeneratorOctaves(this.field_73204_i, 16);
      this.field_73199_l = new NoiseGeneratorOctaves(this.field_73204_i, 8);
      this.field_73196_a = new NoiseGeneratorOctaves(this.field_73204_i, 10);
      this.field_73194_b = new NoiseGeneratorOctaves(this.field_73204_i, 16);
   }

   public void func_180520_a(int p_180520_1_, int p_180520_2_, ChunkPrimer p_180520_3_) {
      byte var4 = 2;
      int var5 = var4 + 1;
      byte var6 = 33;
      int var7 = var4 + 1;
      this.field_73197_n = this.func_73187_a(this.field_73197_n, p_180520_1_ * var4, 0, p_180520_2_ * var4, var5, var6, var7);

      for(int var8 = 0; var8 < var4; ++var8) {
         for(int var9 = 0; var9 < var4; ++var9) {
            for(int var10 = 0; var10 < 32; ++var10) {
               double var11 = 0.25D;
               double var13 = this.field_73197_n[((var8 + 0) * var7 + var9 + 0) * var6 + var10 + 0];
               double var15 = this.field_73197_n[((var8 + 0) * var7 + var9 + 1) * var6 + var10 + 0];
               double var17 = this.field_73197_n[((var8 + 1) * var7 + var9 + 0) * var6 + var10 + 0];
               double var19 = this.field_73197_n[((var8 + 1) * var7 + var9 + 1) * var6 + var10 + 0];
               double var21 = (this.field_73197_n[((var8 + 0) * var7 + var9 + 0) * var6 + var10 + 1] - var13) * var11;
               double var23 = (this.field_73197_n[((var8 + 0) * var7 + var9 + 1) * var6 + var10 + 1] - var15) * var11;
               double var25 = (this.field_73197_n[((var8 + 1) * var7 + var9 + 0) * var6 + var10 + 1] - var17) * var11;
               double var27 = (this.field_73197_n[((var8 + 1) * var7 + var9 + 1) * var6 + var10 + 1] - var19) * var11;

               for(int var29 = 0; var29 < 4; ++var29) {
                  double var30 = 0.125D;
                  double var32 = var13;
                  double var34 = var15;
                  double var36 = (var17 - var13) * var30;
                  double var38 = (var19 - var15) * var30;

                  for(int var40 = 0; var40 < 8; ++var40) {
                     double var41 = 0.125D;
                     double var43 = var32;
                     double var45 = (var34 - var32) * var41;

                     for(int var47 = 0; var47 < 8; ++var47) {
                        IBlockState var48 = null;
                        if(var43 > 0.0D) {
                           var48 = Blocks.field_150377_bs.func_176223_P();
                        }

                        int var49 = var40 + var8 * 8;
                        int var50 = var29 + var10 * 4;
                        int var51 = var47 + var9 * 8;
                        p_180520_3_.func_177855_a(var49, var50, var51, var48);
                        var43 += var45;
                     }

                     var32 += var36;
                     var34 += var38;
                  }

                  var13 += var21;
                  var15 += var23;
                  var17 += var25;
                  var19 += var27;
               }
            }
         }
      }

   }

   public void func_180519_a(ChunkPrimer p_180519_1_) {
      for(int var2 = 0; var2 < 16; ++var2) {
         for(int var3 = 0; var3 < 16; ++var3) {
            byte var4 = 1;
            int var5 = -1;
            IBlockState var6 = Blocks.field_150377_bs.func_176223_P();
            IBlockState var7 = Blocks.field_150377_bs.func_176223_P();

            for(int var8 = 127; var8 >= 0; --var8) {
               IBlockState var9 = p_180519_1_.func_177856_a(var2, var8, var3);
               if(var9.func_177230_c().func_149688_o() == Material.field_151579_a) {
                  var5 = -1;
               } else if(var9.func_177230_c() == Blocks.field_150348_b) {
                  if(var5 == -1) {
                     if(var4 <= 0) {
                        var6 = Blocks.field_150350_a.func_176223_P();
                        var7 = Blocks.field_150377_bs.func_176223_P();
                     }

                     var5 = var4;
                     if(var8 >= 0) {
                        p_180519_1_.func_177855_a(var2, var8, var3, var6);
                     } else {
                        p_180519_1_.func_177855_a(var2, var8, var3, var7);
                     }
                  } else if(var5 > 0) {
                     --var5;
                     p_180519_1_.func_177855_a(var2, var8, var3, var7);
                  }
               }
            }
         }
      }

   }

   public Chunk func_73154_d(int p_73154_1_, int p_73154_2_) {
      this.field_73204_i.setSeed((long)p_73154_1_ * 341873128712L + (long)p_73154_2_ * 132897987541L);
      ChunkPrimer var3 = new ChunkPrimer();
      this.field_73198_o = this.field_73200_m.func_72959_q().func_76933_b(this.field_73198_o, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16);
      this.func_180520_a(p_73154_1_, p_73154_2_, var3);
      this.func_180519_a(var3);
      Chunk var4 = new Chunk(this.field_73200_m, var3, p_73154_1_, p_73154_2_);
      byte[] var5 = var4.func_76605_m();

      for(int var6 = 0; var6 < var5.length; ++var6) {
         var5[var6] = (byte)this.field_73198_o[var6].field_76756_M;
      }

      var4.func_76603_b();
      return var4;
   }

   private double[] func_73187_a(double[] p_73187_1_, int p_73187_2_, int p_73187_3_, int p_73187_4_, int p_73187_5_, int p_73187_6_, int p_73187_7_) {
      if(p_73187_1_ == null) {
         p_73187_1_ = new double[p_73187_5_ * p_73187_6_ * p_73187_7_];
      }

      double var8 = 684.412D;
      double var10 = 684.412D;
      this.field_73190_f = this.field_73196_a.func_76305_a(this.field_73190_f, p_73187_2_, p_73187_4_, p_73187_5_, p_73187_7_, 1.121D, 1.121D, 0.5D);
      this.field_73191_g = this.field_73194_b.func_76305_a(this.field_73191_g, p_73187_2_, p_73187_4_, p_73187_5_, p_73187_7_, 200.0D, 200.0D, 0.5D);
      var8 *= 2.0D;
      this.field_73195_c = this.field_73199_l.func_76304_a(this.field_73195_c, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, var8 / 80.0D, var10 / 160.0D, var8 / 80.0D);
      this.field_73192_d = this.field_73201_j.func_76304_a(this.field_73192_d, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, var8, var10, var8);
      this.field_73193_e = this.field_73202_k.func_76304_a(this.field_73193_e, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, var8, var10, var8);
      int var12 = 0;

      for(int var13 = 0; var13 < p_73187_5_; ++var13) {
         for(int var14 = 0; var14 < p_73187_7_; ++var14) {
            float var15 = (float)(var13 + p_73187_2_) / 1.0F;
            float var16 = (float)(var14 + p_73187_4_) / 1.0F;
            float var17 = 100.0F - MathHelper.func_76129_c(var15 * var15 + var16 * var16) * 8.0F;
            if(var17 > 80.0F) {
               var17 = 80.0F;
            }

            if(var17 < -100.0F) {
               var17 = -100.0F;
            }

            for(int var18 = 0; var18 < p_73187_6_; ++var18) {
               double var19 = 0.0D;
               double var21 = this.field_73192_d[var12] / 512.0D;
               double var23 = this.field_73193_e[var12] / 512.0D;
               double var25 = (this.field_73195_c[var12] / 10.0D + 1.0D) / 2.0D;
               if(var25 < 0.0D) {
                  var19 = var21;
               } else if(var25 > 1.0D) {
                  var19 = var23;
               } else {
                  var19 = var21 + (var23 - var21) * var25;
               }

               var19 -= 8.0D;
               var19 += (double)var17;
               byte var27 = 2;
               double var28;
               if(var18 > p_73187_6_ / 2 - var27) {
                  var28 = (double)((float)(var18 - (p_73187_6_ / 2 - var27)) / 64.0F);
                  var28 = MathHelper.func_151237_a(var28, 0.0D, 1.0D);
                  var19 = var19 * (1.0D - var28) + -3000.0D * var28;
               }

               var27 = 8;
               if(var18 < var27) {
                  var28 = (double)((float)(var27 - var18) / ((float)var27 - 1.0F));
                  var19 = var19 * (1.0D - var28) + -30.0D * var28;
               }

               p_73187_1_[var12] = var19;
               ++var12;
            }
         }
      }

      return p_73187_1_;
   }

   public boolean func_73149_a(int p_73149_1_, int p_73149_2_) {
      return true;
   }

   public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
      BlockFalling.field_149832_M = true;
      BlockPos var4 = new BlockPos(p_73153_2_ * 16, 0, p_73153_3_ * 16);
      this.field_73200_m.func_180494_b(var4.func_177982_a(16, 0, 16)).func_180624_a(this.field_73200_m, this.field_73200_m.field_73012_v, var4);
      BlockFalling.field_149832_M = false;
   }

   public boolean func_177460_a(IChunkProvider p_177460_1_, Chunk p_177460_2_, int p_177460_3_, int p_177460_4_) {
      return false;
   }

   public boolean func_73151_a(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
      return true;
   }

   public void func_104112_b() {}

   public boolean func_73156_b() {
      return false;
   }

   public boolean func_73157_c() {
      return true;
   }

   public String func_73148_d() {
      return "RandomLevelSource";
   }

   public List func_177458_a(EnumCreatureType p_177458_1_, BlockPos p_177458_2_) {
      return this.field_73200_m.func_180494_b(p_177458_2_).func_76747_a(p_177458_1_);
   }

   public BlockPos func_180513_a(World p_180513_1_, String p_180513_2_, BlockPos p_180513_3_) {
      return null;
   }

   public int func_73152_e() {
      return 0;
   }

   public void func_180514_a(Chunk p_180514_1_, int p_180514_2_, int p_180514_3_) {}

   public Chunk func_177459_a(BlockPos p_177459_1_) {
      return this.func_73154_d(p_177459_1_.func_177958_n() >> 4, p_177459_1_.func_177952_p() >> 4);
   }
}
