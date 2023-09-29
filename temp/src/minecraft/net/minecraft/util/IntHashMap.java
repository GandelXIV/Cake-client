package net.minecraft.util;


public class IntHashMap {

   private transient IntHashMap.Entry[] field_76055_a = new IntHashMap.Entry[16];
   private transient int field_76053_b;
   private int field_76054_c = 12;
   private final float field_76051_d = 0.75F;
   private static final String __OBFID = "CL_00001490";


   private static int func_76044_g(int p_76044_0_) {
      p_76044_0_ ^= p_76044_0_ >>> 20 ^ p_76044_0_ >>> 12;
      return p_76044_0_ ^ p_76044_0_ >>> 7 ^ p_76044_0_ >>> 4;
   }

   private static int func_76043_a(int p_76043_0_, int p_76043_1_) {
      return p_76043_0_ & p_76043_1_ - 1;
   }

   public Object func_76041_a(int p_76041_1_) {
      int var2 = func_76044_g(p_76041_1_);

      for(IntHashMap.Entry var3 = this.field_76055_a[func_76043_a(var2, this.field_76055_a.length)]; var3 != null; var3 = var3.field_76034_c) {
         if(var3.field_76035_a == p_76041_1_) {
            return var3.field_76033_b;
         }
      }

      return null;
   }

   public boolean func_76037_b(int p_76037_1_) {
      return this.func_76045_c(p_76037_1_) != null;
   }

   final IntHashMap.Entry func_76045_c(int p_76045_1_) {
      int var2 = func_76044_g(p_76045_1_);

      for(IntHashMap.Entry var3 = this.field_76055_a[func_76043_a(var2, this.field_76055_a.length)]; var3 != null; var3 = var3.field_76034_c) {
         if(var3.field_76035_a == p_76045_1_) {
            return var3;
         }
      }

      return null;
   }

   public void func_76038_a(int p_76038_1_, Object p_76038_2_) {
      int var3 = func_76044_g(p_76038_1_);
      int var4 = func_76043_a(var3, this.field_76055_a.length);

      for(IntHashMap.Entry var5 = this.field_76055_a[var4]; var5 != null; var5 = var5.field_76034_c) {
         if(var5.field_76035_a == p_76038_1_) {
            var5.field_76033_b = p_76038_2_;
            return;
         }
      }

      this.func_76040_a(var3, p_76038_1_, p_76038_2_, var4);
   }

   private void func_76047_h(int p_76047_1_) {
      IntHashMap.Entry[] var2 = this.field_76055_a;
      int var3 = var2.length;
      if(var3 == 1073741824) {
         this.field_76054_c = Integer.MAX_VALUE;
      } else {
         IntHashMap.Entry[] var4 = new IntHashMap.Entry[p_76047_1_];
         this.func_76048_a(var4);
         this.field_76055_a = var4;
         this.field_76054_c = (int)((float)p_76047_1_ * this.field_76051_d);
      }
   }

   private void func_76048_a(IntHashMap.Entry[] p_76048_1_) {
      IntHashMap.Entry[] var2 = this.field_76055_a;
      int var3 = p_76048_1_.length;

      for(int var4 = 0; var4 < var2.length; ++var4) {
         IntHashMap.Entry var5 = var2[var4];
         if(var5 != null) {
            var2[var4] = null;

            IntHashMap.Entry var6;
            do {
               var6 = var5.field_76034_c;
               int var7 = func_76043_a(var5.field_76032_d, var3);
               var5.field_76034_c = p_76048_1_[var7];
               p_76048_1_[var7] = var5;
               var5 = var6;
            } while(var6 != null);
         }
      }

   }

   public Object func_76049_d(int p_76049_1_) {
      IntHashMap.Entry var2 = this.func_76036_e(p_76049_1_);
      return var2 == null?null:var2.field_76033_b;
   }

   final IntHashMap.Entry func_76036_e(int p_76036_1_) {
      int var2 = func_76044_g(p_76036_1_);
      int var3 = func_76043_a(var2, this.field_76055_a.length);
      IntHashMap.Entry var4 = this.field_76055_a[var3];

      IntHashMap.Entry var5;
      IntHashMap.Entry var6;
      for(var5 = var4; var5 != null; var5 = var6) {
         var6 = var5.field_76034_c;
         if(var5.field_76035_a == p_76036_1_) {
            --this.field_76053_b;
            if(var4 == var5) {
               this.field_76055_a[var3] = var6;
            } else {
               var4.field_76034_c = var6;
            }

            return var5;
         }

         var4 = var5;
      }

      return var5;
   }

   public void func_76046_c() {
      IntHashMap.Entry[] var1 = this.field_76055_a;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = null;
      }

      this.field_76053_b = 0;
   }

   private void func_76040_a(int p_76040_1_, int p_76040_2_, Object p_76040_3_, int p_76040_4_) {
      IntHashMap.Entry var5 = this.field_76055_a[p_76040_4_];
      this.field_76055_a[p_76040_4_] = new IntHashMap.Entry(p_76040_1_, p_76040_2_, p_76040_3_, var5);
      if(this.field_76053_b++ >= this.field_76054_c) {
         this.func_76047_h(2 * this.field_76055_a.length);
      }

   }

   static class Entry {

      final int field_76035_a;
      Object field_76033_b;
      IntHashMap.Entry field_76034_c;
      final int field_76032_d;
      private static final String __OBFID = "CL_00001491";


      Entry(int p_i1552_1_, int p_i1552_2_, Object p_i1552_3_, IntHashMap.Entry p_i1552_4_) {
         this.field_76033_b = p_i1552_3_;
         this.field_76034_c = p_i1552_4_;
         this.field_76035_a = p_i1552_2_;
         this.field_76032_d = p_i1552_1_;
      }

      public final int func_76031_a() {
         return this.field_76035_a;
      }

      public final Object func_76030_b() {
         return this.field_76033_b;
      }

      public final boolean equals(Object p_equals_1_) {
         if(!(p_equals_1_ instanceof IntHashMap.Entry)) {
            return false;
         } else {
            IntHashMap.Entry var2 = (IntHashMap.Entry)p_equals_1_;
            Integer var3 = Integer.valueOf(this.func_76031_a());
            Integer var4 = Integer.valueOf(var2.func_76031_a());
            if(var3 == var4 || var3 != null && var3.equals(var4)) {
               Object var5 = this.func_76030_b();
               Object var6 = var2.func_76030_b();
               if(var5 == var6 || var5 != null && var5.equals(var6)) {
                  return true;
               }
            }

            return false;
         }
      }

      public final int hashCode() {
         return IntHashMap.func_76044_g(this.field_76035_a);
      }

      public final String toString() {
         return this.func_76031_a() + "=" + this.func_76030_b();
      }
   }
}
