package net.minecraft.util;

import net.minecraft.util.MathHelper;

public class Vec3 {

   public final double field_72450_a;
   public final double field_72448_b;
   public final double field_72449_c;
   private static final String __OBFID = "CL_00000612";


   public Vec3(double p_i1108_1_, double p_i1108_3_, double p_i1108_5_) {
      if(p_i1108_1_ == -0.0D) {
         p_i1108_1_ = 0.0D;
      }

      if(p_i1108_3_ == -0.0D) {
         p_i1108_3_ = 0.0D;
      }

      if(p_i1108_5_ == -0.0D) {
         p_i1108_5_ = 0.0D;
      }

      this.field_72450_a = p_i1108_1_;
      this.field_72448_b = p_i1108_3_;
      this.field_72449_c = p_i1108_5_;
   }

   public Vec3 func_72444_a(Vec3 p_72444_1_) {
      return new Vec3(p_72444_1_.field_72450_a - this.field_72450_a, p_72444_1_.field_72448_b - this.field_72448_b, p_72444_1_.field_72449_c - this.field_72449_c);
   }

   public Vec3 func_72432_b() {
      double var1 = (double)MathHelper.func_76133_a(this.field_72450_a * this.field_72450_a + this.field_72448_b * this.field_72448_b + this.field_72449_c * this.field_72449_c);
      return var1 < 1.0E-4D?new Vec3(0.0D, 0.0D, 0.0D):new Vec3(this.field_72450_a / var1, this.field_72448_b / var1, this.field_72449_c / var1);
   }

   public double func_72430_b(Vec3 p_72430_1_) {
      return this.field_72450_a * p_72430_1_.field_72450_a + this.field_72448_b * p_72430_1_.field_72448_b + this.field_72449_c * p_72430_1_.field_72449_c;
   }

   public Vec3 func_72431_c(Vec3 p_72431_1_) {
      return new Vec3(this.field_72448_b * p_72431_1_.field_72449_c - this.field_72449_c * p_72431_1_.field_72448_b, this.field_72449_c * p_72431_1_.field_72450_a - this.field_72450_a * p_72431_1_.field_72449_c, this.field_72450_a * p_72431_1_.field_72448_b - this.field_72448_b * p_72431_1_.field_72450_a);
   }

   public Vec3 func_178788_d(Vec3 p_178788_1_) {
      return this.func_178786_a(p_178788_1_.field_72450_a, p_178788_1_.field_72448_b, p_178788_1_.field_72449_c);
   }

   public Vec3 func_178786_a(double p_178786_1_, double p_178786_3_, double p_178786_5_) {
      return this.func_72441_c(-p_178786_1_, -p_178786_3_, -p_178786_5_);
   }

   public Vec3 func_178787_e(Vec3 p_178787_1_) {
      return this.func_72441_c(p_178787_1_.field_72450_a, p_178787_1_.field_72448_b, p_178787_1_.field_72449_c);
   }

   public Vec3 func_72441_c(double p_72441_1_, double p_72441_3_, double p_72441_5_) {
      return new Vec3(this.field_72450_a + p_72441_1_, this.field_72448_b + p_72441_3_, this.field_72449_c + p_72441_5_);
   }

   public double func_72438_d(Vec3 p_72438_1_) {
      double var2 = p_72438_1_.field_72450_a - this.field_72450_a;
      double var4 = p_72438_1_.field_72448_b - this.field_72448_b;
      double var6 = p_72438_1_.field_72449_c - this.field_72449_c;
      return (double)MathHelper.func_76133_a(var2 * var2 + var4 * var4 + var6 * var6);
   }

   public double func_72436_e(Vec3 p_72436_1_) {
      double var2 = p_72436_1_.field_72450_a - this.field_72450_a;
      double var4 = p_72436_1_.field_72448_b - this.field_72448_b;
      double var6 = p_72436_1_.field_72449_c - this.field_72449_c;
      return var2 * var2 + var4 * var4 + var6 * var6;
   }

   public double func_72433_c() {
      return (double)MathHelper.func_76133_a(this.field_72450_a * this.field_72450_a + this.field_72448_b * this.field_72448_b + this.field_72449_c * this.field_72449_c);
   }

   public Vec3 func_72429_b(Vec3 p_72429_1_, double p_72429_2_) {
      double var4 = p_72429_1_.field_72450_a - this.field_72450_a;
      double var6 = p_72429_1_.field_72448_b - this.field_72448_b;
      double var8 = p_72429_1_.field_72449_c - this.field_72449_c;
      if(var4 * var4 < 1.0000000116860974E-7D) {
         return null;
      } else {
         double var10 = (p_72429_2_ - this.field_72450_a) / var4;
         return var10 >= 0.0D && var10 <= 1.0D?new Vec3(this.field_72450_a + var4 * var10, this.field_72448_b + var6 * var10, this.field_72449_c + var8 * var10):null;
      }
   }

   public Vec3 func_72435_c(Vec3 p_72435_1_, double p_72435_2_) {
      double var4 = p_72435_1_.field_72450_a - this.field_72450_a;
      double var6 = p_72435_1_.field_72448_b - this.field_72448_b;
      double var8 = p_72435_1_.field_72449_c - this.field_72449_c;
      if(var6 * var6 < 1.0000000116860974E-7D) {
         return null;
      } else {
         double var10 = (p_72435_2_ - this.field_72448_b) / var6;
         return var10 >= 0.0D && var10 <= 1.0D?new Vec3(this.field_72450_a + var4 * var10, this.field_72448_b + var6 * var10, this.field_72449_c + var8 * var10):null;
      }
   }

   public Vec3 func_72434_d(Vec3 p_72434_1_, double p_72434_2_) {
      double var4 = p_72434_1_.field_72450_a - this.field_72450_a;
      double var6 = p_72434_1_.field_72448_b - this.field_72448_b;
      double var8 = p_72434_1_.field_72449_c - this.field_72449_c;
      if(var8 * var8 < 1.0000000116860974E-7D) {
         return null;
      } else {
         double var10 = (p_72434_2_ - this.field_72449_c) / var8;
         return var10 >= 0.0D && var10 <= 1.0D?new Vec3(this.field_72450_a + var4 * var10, this.field_72448_b + var6 * var10, this.field_72449_c + var8 * var10):null;
      }
   }

   public String toString() {
      return "(" + this.field_72450_a + ", " + this.field_72448_b + ", " + this.field_72449_c + ")";
   }

   public Vec3 func_178789_a(float p_178789_1_) {
      float var2 = MathHelper.func_76134_b(p_178789_1_);
      float var3 = MathHelper.func_76126_a(p_178789_1_);
      double var4 = this.field_72450_a;
      double var6 = this.field_72448_b * (double)var2 + this.field_72449_c * (double)var3;
      double var8 = this.field_72449_c * (double)var2 - this.field_72448_b * (double)var3;
      return new Vec3(var4, var6, var8);
   }

   public Vec3 func_178785_b(float p_178785_1_) {
      float var2 = MathHelper.func_76134_b(p_178785_1_);
      float var3 = MathHelper.func_76126_a(p_178785_1_);
      double var4 = this.field_72450_a * (double)var2 + this.field_72449_c * (double)var3;
      double var6 = this.field_72448_b;
      double var8 = this.field_72449_c * (double)var2 - this.field_72450_a * (double)var3;
      return new Vec3(var4, var6, var8);
   }
}
