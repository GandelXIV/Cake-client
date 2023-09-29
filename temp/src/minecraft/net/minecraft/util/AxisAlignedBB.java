package net.minecraft.util;

import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class AxisAlignedBB {

   public final double field_72340_a;
   public final double field_72338_b;
   public final double field_72339_c;
   public final double field_72336_d;
   public final double field_72337_e;
   public final double field_72334_f;
   private static final String __OBFID = "CL_00000607";


   public AxisAlignedBB(double p_i2300_1_, double p_i2300_3_, double p_i2300_5_, double p_i2300_7_, double p_i2300_9_, double p_i2300_11_) {
      this.field_72340_a = Math.min(p_i2300_1_, p_i2300_7_);
      this.field_72338_b = Math.min(p_i2300_3_, p_i2300_9_);
      this.field_72339_c = Math.min(p_i2300_5_, p_i2300_11_);
      this.field_72336_d = Math.max(p_i2300_1_, p_i2300_7_);
      this.field_72337_e = Math.max(p_i2300_3_, p_i2300_9_);
      this.field_72334_f = Math.max(p_i2300_5_, p_i2300_11_);
   }

   public AxisAlignedBB(BlockPos p_i45554_1_, BlockPos p_i45554_2_) {
      this.field_72340_a = (double)p_i45554_1_.func_177958_n();
      this.field_72338_b = (double)p_i45554_1_.func_177956_o();
      this.field_72339_c = (double)p_i45554_1_.func_177952_p();
      this.field_72336_d = (double)p_i45554_2_.func_177958_n();
      this.field_72337_e = (double)p_i45554_2_.func_177956_o();
      this.field_72334_f = (double)p_i45554_2_.func_177952_p();
   }

   public AxisAlignedBB func_72321_a(double p_72321_1_, double p_72321_3_, double p_72321_5_) {
      double var7 = this.field_72340_a;
      double var9 = this.field_72338_b;
      double var11 = this.field_72339_c;
      double var13 = this.field_72336_d;
      double var15 = this.field_72337_e;
      double var17 = this.field_72334_f;
      if(p_72321_1_ < 0.0D) {
         var7 += p_72321_1_;
      } else if(p_72321_1_ > 0.0D) {
         var13 += p_72321_1_;
      }

      if(p_72321_3_ < 0.0D) {
         var9 += p_72321_3_;
      } else if(p_72321_3_ > 0.0D) {
         var15 += p_72321_3_;
      }

      if(p_72321_5_ < 0.0D) {
         var11 += p_72321_5_;
      } else if(p_72321_5_ > 0.0D) {
         var17 += p_72321_5_;
      }

      return new AxisAlignedBB(var7, var9, var11, var13, var15, var17);
   }

   public AxisAlignedBB func_72314_b(double p_72314_1_, double p_72314_3_, double p_72314_5_) {
      double var7 = this.field_72340_a - p_72314_1_;
      double var9 = this.field_72338_b - p_72314_3_;
      double var11 = this.field_72339_c - p_72314_5_;
      double var13 = this.field_72336_d + p_72314_1_;
      double var15 = this.field_72337_e + p_72314_3_;
      double var17 = this.field_72334_f + p_72314_5_;
      return new AxisAlignedBB(var7, var9, var11, var13, var15, var17);
   }

   public AxisAlignedBB func_111270_a(AxisAlignedBB p_111270_1_) {
      double var2 = Math.min(this.field_72340_a, p_111270_1_.field_72340_a);
      double var4 = Math.min(this.field_72338_b, p_111270_1_.field_72338_b);
      double var6 = Math.min(this.field_72339_c, p_111270_1_.field_72339_c);
      double var8 = Math.max(this.field_72336_d, p_111270_1_.field_72336_d);
      double var10 = Math.max(this.field_72337_e, p_111270_1_.field_72337_e);
      double var12 = Math.max(this.field_72334_f, p_111270_1_.field_72334_f);
      return new AxisAlignedBB(var2, var4, var6, var8, var10, var12);
   }

   public static AxisAlignedBB func_178781_a(double p_178781_0_, double p_178781_2_, double p_178781_4_, double p_178781_6_, double p_178781_8_, double p_178781_10_) {
      double var12 = Math.min(p_178781_0_, p_178781_6_);
      double var14 = Math.min(p_178781_2_, p_178781_8_);
      double var16 = Math.min(p_178781_4_, p_178781_10_);
      double var18 = Math.max(p_178781_0_, p_178781_6_);
      double var20 = Math.max(p_178781_2_, p_178781_8_);
      double var22 = Math.max(p_178781_4_, p_178781_10_);
      return new AxisAlignedBB(var12, var14, var16, var18, var20, var22);
   }

   public AxisAlignedBB func_72317_d(double p_72317_1_, double p_72317_3_, double p_72317_5_) {
      return new AxisAlignedBB(this.field_72340_a + p_72317_1_, this.field_72338_b + p_72317_3_, this.field_72339_c + p_72317_5_, this.field_72336_d + p_72317_1_, this.field_72337_e + p_72317_3_, this.field_72334_f + p_72317_5_);
   }

   public double func_72316_a(AxisAlignedBB p_72316_1_, double p_72316_2_) {
      if(p_72316_1_.field_72337_e > this.field_72338_b && p_72316_1_.field_72338_b < this.field_72337_e && p_72316_1_.field_72334_f > this.field_72339_c && p_72316_1_.field_72339_c < this.field_72334_f) {
         double var4;
         if(p_72316_2_ > 0.0D && p_72316_1_.field_72336_d <= this.field_72340_a) {
            var4 = this.field_72340_a - p_72316_1_.field_72336_d;
            if(var4 < p_72316_2_) {
               p_72316_2_ = var4;
            }
         } else if(p_72316_2_ < 0.0D && p_72316_1_.field_72340_a >= this.field_72336_d) {
            var4 = this.field_72336_d - p_72316_1_.field_72340_a;
            if(var4 > p_72316_2_) {
               p_72316_2_ = var4;
            }
         }

         return p_72316_2_;
      } else {
         return p_72316_2_;
      }
   }

   public double func_72323_b(AxisAlignedBB p_72323_1_, double p_72323_2_) {
      if(p_72323_1_.field_72336_d > this.field_72340_a && p_72323_1_.field_72340_a < this.field_72336_d && p_72323_1_.field_72334_f > this.field_72339_c && p_72323_1_.field_72339_c < this.field_72334_f) {
         double var4;
         if(p_72323_2_ > 0.0D && p_72323_1_.field_72337_e <= this.field_72338_b) {
            var4 = this.field_72338_b - p_72323_1_.field_72337_e;
            if(var4 < p_72323_2_) {
               p_72323_2_ = var4;
            }
         } else if(p_72323_2_ < 0.0D && p_72323_1_.field_72338_b >= this.field_72337_e) {
            var4 = this.field_72337_e - p_72323_1_.field_72338_b;
            if(var4 > p_72323_2_) {
               p_72323_2_ = var4;
            }
         }

         return p_72323_2_;
      } else {
         return p_72323_2_;
      }
   }

   public double func_72322_c(AxisAlignedBB p_72322_1_, double p_72322_2_) {
      if(p_72322_1_.field_72336_d > this.field_72340_a && p_72322_1_.field_72340_a < this.field_72336_d && p_72322_1_.field_72337_e > this.field_72338_b && p_72322_1_.field_72338_b < this.field_72337_e) {
         double var4;
         if(p_72322_2_ > 0.0D && p_72322_1_.field_72334_f <= this.field_72339_c) {
            var4 = this.field_72339_c - p_72322_1_.field_72334_f;
            if(var4 < p_72322_2_) {
               p_72322_2_ = var4;
            }
         } else if(p_72322_2_ < 0.0D && p_72322_1_.field_72339_c >= this.field_72334_f) {
            var4 = this.field_72334_f - p_72322_1_.field_72339_c;
            if(var4 > p_72322_2_) {
               p_72322_2_ = var4;
            }
         }

         return p_72322_2_;
      } else {
         return p_72322_2_;
      }
   }

   public boolean func_72326_a(AxisAlignedBB p_72326_1_) {
      return p_72326_1_.field_72336_d > this.field_72340_a && p_72326_1_.field_72340_a < this.field_72336_d?(p_72326_1_.field_72337_e > this.field_72338_b && p_72326_1_.field_72338_b < this.field_72337_e?p_72326_1_.field_72334_f > this.field_72339_c && p_72326_1_.field_72339_c < this.field_72334_f:false):false;
   }

   public boolean func_72318_a(Vec3 p_72318_1_) {
      return p_72318_1_.field_72450_a > this.field_72340_a && p_72318_1_.field_72450_a < this.field_72336_d?(p_72318_1_.field_72448_b > this.field_72338_b && p_72318_1_.field_72448_b < this.field_72337_e?p_72318_1_.field_72449_c > this.field_72339_c && p_72318_1_.field_72449_c < this.field_72334_f:false):false;
   }

   public double func_72320_b() {
      double var1 = this.field_72336_d - this.field_72340_a;
      double var3 = this.field_72337_e - this.field_72338_b;
      double var5 = this.field_72334_f - this.field_72339_c;
      return (var1 + var3 + var5) / 3.0D;
   }

   public AxisAlignedBB func_72331_e(double p_72331_1_, double p_72331_3_, double p_72331_5_) {
      double var7 = this.field_72340_a + p_72331_1_;
      double var9 = this.field_72338_b + p_72331_3_;
      double var11 = this.field_72339_c + p_72331_5_;
      double var13 = this.field_72336_d - p_72331_1_;
      double var15 = this.field_72337_e - p_72331_3_;
      double var17 = this.field_72334_f - p_72331_5_;
      return new AxisAlignedBB(var7, var9, var11, var13, var15, var17);
   }

   public MovingObjectPosition func_72327_a(Vec3 p_72327_1_, Vec3 p_72327_2_) {
      Vec3 var3 = p_72327_1_.func_72429_b(p_72327_2_, this.field_72340_a);
      Vec3 var4 = p_72327_1_.func_72429_b(p_72327_2_, this.field_72336_d);
      Vec3 var5 = p_72327_1_.func_72435_c(p_72327_2_, this.field_72338_b);
      Vec3 var6 = p_72327_1_.func_72435_c(p_72327_2_, this.field_72337_e);
      Vec3 var7 = p_72327_1_.func_72434_d(p_72327_2_, this.field_72339_c);
      Vec3 var8 = p_72327_1_.func_72434_d(p_72327_2_, this.field_72334_f);
      if(!this.func_72333_b(var3)) {
         var3 = null;
      }

      if(!this.func_72333_b(var4)) {
         var4 = null;
      }

      if(!this.func_72315_c(var5)) {
         var5 = null;
      }

      if(!this.func_72315_c(var6)) {
         var6 = null;
      }

      if(!this.func_72319_d(var7)) {
         var7 = null;
      }

      if(!this.func_72319_d(var8)) {
         var8 = null;
      }

      Vec3 var9 = null;
      if(var3 != null) {
         var9 = var3;
      }

      if(var4 != null && (var9 == null || p_72327_1_.func_72436_e(var4) < p_72327_1_.func_72436_e(var9))) {
         var9 = var4;
      }

      if(var5 != null && (var9 == null || p_72327_1_.func_72436_e(var5) < p_72327_1_.func_72436_e(var9))) {
         var9 = var5;
      }

      if(var6 != null && (var9 == null || p_72327_1_.func_72436_e(var6) < p_72327_1_.func_72436_e(var9))) {
         var9 = var6;
      }

      if(var7 != null && (var9 == null || p_72327_1_.func_72436_e(var7) < p_72327_1_.func_72436_e(var9))) {
         var9 = var7;
      }

      if(var8 != null && (var9 == null || p_72327_1_.func_72436_e(var8) < p_72327_1_.func_72436_e(var9))) {
         var9 = var8;
      }

      if(var9 == null) {
         return null;
      } else {
         EnumFacing var10 = null;
         if(var9 == var3) {
            var10 = EnumFacing.WEST;
         } else if(var9 == var4) {
            var10 = EnumFacing.EAST;
         } else if(var9 == var5) {
            var10 = EnumFacing.DOWN;
         } else if(var9 == var6) {
            var10 = EnumFacing.UP;
         } else if(var9 == var7) {
            var10 = EnumFacing.NORTH;
         } else {
            var10 = EnumFacing.SOUTH;
         }

         return new MovingObjectPosition(var9, var10);
      }
   }

   private boolean func_72333_b(Vec3 p_72333_1_) {
      return p_72333_1_ == null?false:p_72333_1_.field_72448_b >= this.field_72338_b && p_72333_1_.field_72448_b <= this.field_72337_e && p_72333_1_.field_72449_c >= this.field_72339_c && p_72333_1_.field_72449_c <= this.field_72334_f;
   }

   private boolean func_72315_c(Vec3 p_72315_1_) {
      return p_72315_1_ == null?false:p_72315_1_.field_72450_a >= this.field_72340_a && p_72315_1_.field_72450_a <= this.field_72336_d && p_72315_1_.field_72449_c >= this.field_72339_c && p_72315_1_.field_72449_c <= this.field_72334_f;
   }

   private boolean func_72319_d(Vec3 p_72319_1_) {
      return p_72319_1_ == null?false:p_72319_1_.field_72450_a >= this.field_72340_a && p_72319_1_.field_72450_a <= this.field_72336_d && p_72319_1_.field_72448_b >= this.field_72338_b && p_72319_1_.field_72448_b <= this.field_72337_e;
   }

   public String toString() {
      return "box[" + this.field_72340_a + ", " + this.field_72338_b + ", " + this.field_72339_c + " -> " + this.field_72336_d + ", " + this.field_72337_e + ", " + this.field_72334_f + "]";
   }
}
