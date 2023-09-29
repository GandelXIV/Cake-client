package net.minecraft.util;

import java.util.Random;
import java.util.UUID;
import net.minecraft.util.Vec3i;

public class MathHelper {

   public static final float field_180189_a = func_76129_c(2.0F);
   private static final float[] field_76144_a = new float[65536];
   private static final int[] field_151242_b;
   private static final String __OBFID = "CL_00001496";


   public static float func_76126_a(float p_76126_0_) {
      return field_76144_a[(int)(p_76126_0_ * 10430.378F) & '\uffff'];
   }

   public static float func_76134_b(float p_76134_0_) {
      return field_76144_a[(int)(p_76134_0_ * 10430.378F + 16384.0F) & '\uffff'];
   }

   public static float func_76129_c(float p_76129_0_) {
      return (float)Math.sqrt((double)p_76129_0_);
   }

   public static float func_76133_a(double p_76133_0_) {
      return (float)Math.sqrt(p_76133_0_);
   }

   public static int func_76141_d(float p_76141_0_) {
      int var1 = (int)p_76141_0_;
      return p_76141_0_ < (float)var1?var1 - 1:var1;
   }

   public static int func_76140_b(double p_76140_0_) {
      return (int)(p_76140_0_ + 1024.0D) - 1024;
   }

   public static int func_76128_c(double p_76128_0_) {
      int var2 = (int)p_76128_0_;
      return p_76128_0_ < (double)var2?var2 - 1:var2;
   }

   public static long func_76124_d(double p_76124_0_) {
      long var2 = (long)p_76124_0_;
      return p_76124_0_ < (double)var2?var2 - 1L:var2;
   }

   public static int func_154353_e(double p_154353_0_) {
      return (int)(p_154353_0_ >= 0.0D?p_154353_0_:-p_154353_0_ + 1.0D);
   }

   public static float func_76135_e(float p_76135_0_) {
      return p_76135_0_ >= 0.0F?p_76135_0_:-p_76135_0_;
   }

   public static int func_76130_a(int p_76130_0_) {
      return p_76130_0_ >= 0?p_76130_0_:-p_76130_0_;
   }

   public static int func_76123_f(float p_76123_0_) {
      int var1 = (int)p_76123_0_;
      return p_76123_0_ > (float)var1?var1 + 1:var1;
   }

   public static int func_76143_f(double p_76143_0_) {
      int var2 = (int)p_76143_0_;
      return p_76143_0_ > (double)var2?var2 + 1:var2;
   }

   public static int func_76125_a(int p_76125_0_, int p_76125_1_, int p_76125_2_) {
      return p_76125_0_ < p_76125_1_?p_76125_1_:(p_76125_0_ > p_76125_2_?p_76125_2_:p_76125_0_);
   }

   public static float func_76131_a(float p_76131_0_, float p_76131_1_, float p_76131_2_) {
      return p_76131_0_ < p_76131_1_?p_76131_1_:(p_76131_0_ > p_76131_2_?p_76131_2_:p_76131_0_);
   }

   public static double func_151237_a(double p_151237_0_, double p_151237_2_, double p_151237_4_) {
      return p_151237_0_ < p_151237_2_?p_151237_2_:(p_151237_0_ > p_151237_4_?p_151237_4_:p_151237_0_);
   }

   public static double func_151238_b(double p_151238_0_, double p_151238_2_, double p_151238_4_) {
      return p_151238_4_ < 0.0D?p_151238_0_:(p_151238_4_ > 1.0D?p_151238_2_:p_151238_0_ + (p_151238_2_ - p_151238_0_) * p_151238_4_);
   }

   public static double func_76132_a(double p_76132_0_, double p_76132_2_) {
      if(p_76132_0_ < 0.0D) {
         p_76132_0_ = -p_76132_0_;
      }

      if(p_76132_2_ < 0.0D) {
         p_76132_2_ = -p_76132_2_;
      }

      return p_76132_0_ > p_76132_2_?p_76132_0_:p_76132_2_;
   }

   public static int func_76137_a(int p_76137_0_, int p_76137_1_) {
      return p_76137_0_ < 0?-((-p_76137_0_ - 1) / p_76137_1_) - 1:p_76137_0_ / p_76137_1_;
   }

   public static int func_76136_a(Random p_76136_0_, int p_76136_1_, int p_76136_2_) {
      return p_76136_1_ >= p_76136_2_?p_76136_1_:p_76136_0_.nextInt(p_76136_2_ - p_76136_1_ + 1) + p_76136_1_;
   }

   public static float func_151240_a(Random p_151240_0_, float p_151240_1_, float p_151240_2_) {
      return p_151240_1_ >= p_151240_2_?p_151240_1_:p_151240_0_.nextFloat() * (p_151240_2_ - p_151240_1_) + p_151240_1_;
   }

   public static double func_82716_a(Random p_82716_0_, double p_82716_1_, double p_82716_3_) {
      return p_82716_1_ >= p_82716_3_?p_82716_1_:p_82716_0_.nextDouble() * (p_82716_3_ - p_82716_1_) + p_82716_1_;
   }

   public static double func_76127_a(long[] p_76127_0_) {
      long var1 = 0L;
      long[] var3 = p_76127_0_;
      int var4 = p_76127_0_.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         long var6 = var3[var5];
         var1 += var6;
      }

      return (double)var1 / (double)p_76127_0_.length;
   }

   public static boolean func_180185_a(float p_180185_0_, float p_180185_1_) {
      return func_76135_e(p_180185_1_ - p_180185_0_) < 1.0E-5F;
   }

   public static int func_180184_b(int p_180184_0_, int p_180184_1_) {
      return (p_180184_0_ % p_180184_1_ + p_180184_1_) % p_180184_1_;
   }

   public static float func_76142_g(float p_76142_0_) {
      p_76142_0_ %= 360.0F;
      if(p_76142_0_ >= 180.0F) {
         p_76142_0_ -= 360.0F;
      }

      if(p_76142_0_ < -180.0F) {
         p_76142_0_ += 360.0F;
      }

      return p_76142_0_;
   }

   public static double func_76138_g(double p_76138_0_) {
      p_76138_0_ %= 360.0D;
      if(p_76138_0_ >= 180.0D) {
         p_76138_0_ -= 360.0D;
      }

      if(p_76138_0_ < -180.0D) {
         p_76138_0_ += 360.0D;
      }

      return p_76138_0_;
   }

   public static int func_82715_a(String p_82715_0_, int p_82715_1_) {
      try {
         return Integer.parseInt(p_82715_0_);
      } catch (Throwable var3) {
         return p_82715_1_;
      }
   }

   public static int func_82714_a(String p_82714_0_, int p_82714_1_, int p_82714_2_) {
      return Math.max(p_82714_2_, func_82715_a(p_82714_0_, p_82714_1_));
   }

   public static double func_82712_a(String p_82712_0_, double p_82712_1_) {
      try {
         return Double.parseDouble(p_82712_0_);
      } catch (Throwable var4) {
         return p_82712_1_;
      }
   }

   public static double func_82713_a(String p_82713_0_, double p_82713_1_, double p_82713_3_) {
      return Math.max(p_82713_3_, func_82712_a(p_82713_0_, p_82713_1_));
   }

   public static int func_151236_b(int p_151236_0_) {
      int var1 = p_151236_0_ - 1;
      var1 |= var1 >> 1;
      var1 |= var1 >> 2;
      var1 |= var1 >> 4;
      var1 |= var1 >> 8;
      var1 |= var1 >> 16;
      return var1 + 1;
   }

   private static boolean func_151235_d(int p_151235_0_) {
      return p_151235_0_ != 0 && (p_151235_0_ & p_151235_0_ - 1) == 0;
   }

   private static int func_151241_e(int p_151241_0_) {
      p_151241_0_ = func_151235_d(p_151241_0_)?p_151241_0_:func_151236_b(p_151241_0_);
      return field_151242_b[(int)((long)p_151241_0_ * 125613361L >> 27) & 31];
   }

   public static int func_151239_c(int p_151239_0_) {
      return func_151241_e(p_151239_0_) - (func_151235_d(p_151239_0_)?0:1);
   }

   public static int func_154354_b(int p_154354_0_, int p_154354_1_) {
      if(p_154354_1_ == 0) {
         return 0;
      } else if(p_154354_0_ == 0) {
         return p_154354_1_;
      } else {
         if(p_154354_0_ < 0) {
            p_154354_1_ *= -1;
         }

         int var2 = p_154354_0_ % p_154354_1_;
         return var2 == 0?p_154354_0_:p_154354_0_ + p_154354_1_ - var2;
      }
   }

   public static int func_180183_b(float p_180183_0_, float p_180183_1_, float p_180183_2_) {
      return func_180181_b(func_76141_d(p_180183_0_ * 255.0F), func_76141_d(p_180183_1_ * 255.0F), func_76141_d(p_180183_2_ * 255.0F));
   }

   public static int func_180181_b(int p_180181_0_, int p_180181_1_, int p_180181_2_) {
      int var3 = (p_180181_0_ << 8) + p_180181_1_;
      var3 = (var3 << 8) + p_180181_2_;
      return var3;
   }

   public static int func_180188_d(int p_180188_0_, int p_180188_1_) {
      int var2 = (p_180188_0_ & 16711680) >> 16;
      int var3 = (p_180188_1_ & 16711680) >> 16;
      int var4 = (p_180188_0_ & '\uff00') >> 8;
      int var5 = (p_180188_1_ & '\uff00') >> 8;
      int var6 = (p_180188_0_ & 255) >> 0;
      int var7 = (p_180188_1_ & 255) >> 0;
      int var8 = (int)((float)var2 * (float)var3 / 255.0F);
      int var9 = (int)((float)var4 * (float)var5 / 255.0F);
      int var10 = (int)((float)var6 * (float)var7 / 255.0F);
      return p_180188_0_ & -16777216 | var8 << 16 | var9 << 8 | var10;
   }

   public static long func_180186_a(Vec3i p_180186_0_) {
      return func_180187_c(p_180186_0_.func_177958_n(), p_180186_0_.func_177956_o(), p_180186_0_.func_177952_p());
   }

   public static long func_180187_c(int p_180187_0_, int p_180187_1_, int p_180187_2_) {
      long var3 = (long)(p_180187_0_ * 3129871) ^ (long)p_180187_2_ * 116129781L ^ (long)p_180187_1_;
      var3 = var3 * var3 * 42317861L + var3 * 11L;
      return var3;
   }

   public static UUID func_180182_a(Random p_180182_0_) {
      long var1 = p_180182_0_.nextLong() & -61441L | 16384L;
      long var3 = p_180182_0_.nextLong() & 4611686018427387903L | Long.MIN_VALUE;
      return new UUID(var1, var3);
   }

   static {
      for(int var0 = 0; var0 < 65536; ++var0) {
         field_76144_a[var0] = (float)Math.sin((double)var0 * 3.141592653589793D * 2.0D / 65536.0D);
      }

      field_151242_b = new int[]{0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9};
   }
}
