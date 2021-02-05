package net.minecraft.pathfinding;

import net.minecraft.util.MathHelper;

public class PathPoint {

   public final int field_75839_a;
   public final int field_75837_b;
   public final int field_75838_c;
   private final int field_75840_j;
   int field_75835_d = -1;
   float field_75836_e;
   float field_75833_f;
   float field_75834_g;
   PathPoint field_75841_h;
   public boolean field_75842_i;
   private static final String __OBFID = "CL_00000574";


   public PathPoint(int p_i2135_1_, int p_i2135_2_, int p_i2135_3_) {
      this.field_75839_a = p_i2135_1_;
      this.field_75837_b = p_i2135_2_;
      this.field_75838_c = p_i2135_3_;
      this.field_75840_j = func_75830_a(p_i2135_1_, p_i2135_2_, p_i2135_3_);
   }

   public static int func_75830_a(int p_75830_0_, int p_75830_1_, int p_75830_2_) {
      return p_75830_1_ & 255 | (p_75830_0_ & 32767) << 8 | (p_75830_2_ & 32767) << 24 | (p_75830_0_ < 0?Integer.MIN_VALUE:0) | (p_75830_2_ < 0?'\u8000':0);
   }

   public float func_75829_a(PathPoint p_75829_1_) {
      float var2 = (float)(p_75829_1_.field_75839_a - this.field_75839_a);
      float var3 = (float)(p_75829_1_.field_75837_b - this.field_75837_b);
      float var4 = (float)(p_75829_1_.field_75838_c - this.field_75838_c);
      return MathHelper.func_76129_c(var2 * var2 + var3 * var3 + var4 * var4);
   }

   public float func_75832_b(PathPoint p_75832_1_) {
      float var2 = (float)(p_75832_1_.field_75839_a - this.field_75839_a);
      float var3 = (float)(p_75832_1_.field_75837_b - this.field_75837_b);
      float var4 = (float)(p_75832_1_.field_75838_c - this.field_75838_c);
      return var2 * var2 + var3 * var3 + var4 * var4;
   }

   public boolean equals(Object p_equals_1_) {
      if(!(p_equals_1_ instanceof PathPoint)) {
         return false;
      } else {
         PathPoint var2 = (PathPoint)p_equals_1_;
         return this.field_75840_j == var2.field_75840_j && this.field_75839_a == var2.field_75839_a && this.field_75837_b == var2.field_75837_b && this.field_75838_c == var2.field_75838_c;
      }
   }

   public int hashCode() {
      return this.field_75840_j;
   }

   public boolean func_75831_a() {
      return this.field_75835_d >= 0;
   }

   public String toString() {
      return this.field_75839_a + ", " + this.field_75837_b + ", " + this.field_75838_c;
   }
}
