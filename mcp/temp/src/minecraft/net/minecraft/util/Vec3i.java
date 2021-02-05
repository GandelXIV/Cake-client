package net.minecraft.util;

import com.google.common.base.Objects;
import net.minecraft.util.MathHelper;

public class Vec3i implements Comparable {

   public static final Vec3i field_177959_e = new Vec3i(0, 0, 0);
   private final int field_177962_a;
   private final int field_177960_b;
   private final int field_177961_c;
   private static final String __OBFID = "CL_00002315";


   public Vec3i(int p_i46007_1_, int p_i46007_2_, int p_i46007_3_) {
      this.field_177962_a = p_i46007_1_;
      this.field_177960_b = p_i46007_2_;
      this.field_177961_c = p_i46007_3_;
   }

   public Vec3i(double p_i46008_1_, double p_i46008_3_, double p_i46008_5_) {
      this(MathHelper.func_76128_c(p_i46008_1_), MathHelper.func_76128_c(p_i46008_3_), MathHelper.func_76128_c(p_i46008_5_));
   }

   public boolean equals(Object p_equals_1_) {
      if(this == p_equals_1_) {
         return true;
      } else if(!(p_equals_1_ instanceof Vec3i)) {
         return false;
      } else {
         Vec3i var2 = (Vec3i)p_equals_1_;
         return this.func_177958_n() != var2.func_177958_n()?false:(this.func_177956_o() != var2.func_177956_o()?false:this.func_177952_p() == var2.func_177952_p());
      }
   }

   public int hashCode() {
      return (this.func_177956_o() + this.func_177952_p() * 31) * 31 + this.func_177958_n();
   }

   public int func_177953_g(Vec3i p_177953_1_) {
      return this.func_177956_o() == p_177953_1_.func_177956_o()?(this.func_177952_p() == p_177953_1_.func_177952_p()?this.func_177958_n() - p_177953_1_.func_177958_n():this.func_177952_p() - p_177953_1_.func_177952_p()):this.func_177956_o() - p_177953_1_.func_177956_o();
   }

   public int func_177958_n() {
      return this.field_177962_a;
   }

   public int func_177956_o() {
      return this.field_177960_b;
   }

   public int func_177952_p() {
      return this.field_177961_c;
   }

   public Vec3i func_177955_d(Vec3i p_177955_1_) {
      return new Vec3i(this.func_177956_o() * p_177955_1_.func_177952_p() - this.func_177952_p() * p_177955_1_.func_177956_o(), this.func_177952_p() * p_177955_1_.func_177958_n() - this.func_177958_n() * p_177955_1_.func_177952_p(), this.func_177958_n() * p_177955_1_.func_177956_o() - this.func_177956_o() * p_177955_1_.func_177958_n());
   }

   public double func_177954_c(double p_177954_1_, double p_177954_3_, double p_177954_5_) {
      double var7 = (double)this.func_177958_n() - p_177954_1_;
      double var9 = (double)this.func_177956_o() - p_177954_3_;
      double var11 = (double)this.func_177952_p() - p_177954_5_;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public double func_177957_d(double p_177957_1_, double p_177957_3_, double p_177957_5_) {
      double var7 = (double)this.func_177958_n() + 0.5D - p_177957_1_;
      double var9 = (double)this.func_177956_o() + 0.5D - p_177957_3_;
      double var11 = (double)this.func_177952_p() + 0.5D - p_177957_5_;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public double func_177951_i(Vec3i p_177951_1_) {
      return this.func_177954_c((double)p_177951_1_.func_177958_n(), (double)p_177951_1_.func_177956_o(), (double)p_177951_1_.func_177952_p());
   }

   public String toString() {
      return Objects.toStringHelper(this).add("x", this.func_177958_n()).add("y", this.func_177956_o()).add("z", this.func_177952_p()).toString();
   }

   // $FF: synthetic method
   public int compareTo(Object p_compareTo_1_) {
      return this.func_177953_g((Vec3i)p_compareTo_1_);
   }

}
