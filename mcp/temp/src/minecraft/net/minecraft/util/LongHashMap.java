package net.minecraft.util;


public class LongHashMap {

   private transient LongHashMap.Entry[] field_76169_a = new LongHashMap.Entry[4096];
   private transient int field_76167_b;
   private int field_180201_c;
   private int field_76168_c = 3072;
   private final float field_76165_d = 0.75F;
   private transient volatile int field_76166_e;
   private static final String __OBFID = "CL_00001492";


   public LongHashMap() {
      this.field_180201_c = this.field_76169_a.length - 1;
   }

   private static int func_76155_g(long p_76155_0_) {
      return func_76157_a((int)(p_76155_0_ ^ p_76155_0_ >>> 32));
   }

   private static int func_76157_a(int p_76157_0_) {
      p_76157_0_ ^= p_76157_0_ >>> 20 ^ p_76157_0_ >>> 12;
      return p_76157_0_ ^ p_76157_0_ >>> 7 ^ p_76157_0_ >>> 4;
   }

   private static int func_76158_a(int p_76158_0_, int p_76158_1_) {
      return p_76158_0_ & p_76158_1_;
   }

   public int func_76162_a() {
      return this.field_76167_b;
   }

   public Object func_76164_a(long p_76164_1_) {
      int var3 = func_76155_g(p_76164_1_);

      for(LongHashMap.Entry var4 = this.field_76169_a[func_76158_a(var3, this.field_180201_c)]; var4 != null; var4 = var4.field_76149_c) {
         if(var4.field_76150_a == p_76164_1_) {
            return var4.field_76148_b;
         }
      }

      return null;
   }

   public boolean func_76161_b(long p_76161_1_) {
      return this.func_76160_c(p_76161_1_) != null;
   }

   final LongHashMap.Entry func_76160_c(long p_76160_1_) {
      int var3 = func_76155_g(p_76160_1_);

      for(LongHashMap.Entry var4 = this.field_76169_a[func_76158_a(var3, this.field_180201_c)]; var4 != null; var4 = var4.field_76149_c) {
         if(var4.field_76150_a == p_76160_1_) {
            return var4;
         }
      }

      return null;
   }

   public void func_76163_a(long p_76163_1_, Object p_76163_3_) {
      int var4 = func_76155_g(p_76163_1_);
      int var5 = func_76158_a(var4, this.field_180201_c);

      for(LongHashMap.Entry var6 = this.field_76169_a[var5]; var6 != null; var6 = var6.field_76149_c) {
         if(var6.field_76150_a == p_76163_1_) {
            var6.field_76148_b = p_76163_3_;
            return;
         }
      }

      ++this.field_76166_e;
      this.func_76156_a(var4, p_76163_1_, p_76163_3_, var5);
   }

   private void func_76153_b(int p_76153_1_) {
      LongHashMap.Entry[] var2 = this.field_76169_a;
      int var3 = var2.length;
      if(var3 == 1073741824) {
         this.field_76168_c = Integer.MAX_VALUE;
      } else {
         LongHashMap.Entry[] var4 = new LongHashMap.Entry[p_76153_1_];
         this.func_76154_a(var4);
         this.field_76169_a = var4;
         this.field_180201_c = this.field_76169_a.length - 1;
         this.field_76168_c = (int)((float)p_76153_1_ * this.field_76165_d);
      }
   }

   private void func_76154_a(LongHashMap.Entry[] p_76154_1_) {
      LongHashMap.Entry[] var2 = this.field_76169_a;
      int var3 = p_76154_1_.length;

      for(int var4 = 0; var4 < var2.length; ++var4) {
         LongHashMap.Entry var5 = var2[var4];
         if(var5 != null) {
            var2[var4] = null;

            LongHashMap.Entry var6;
            do {
               var6 = var5.field_76149_c;
               int var7 = func_76158_a(var5.field_76147_d, var3 - 1);
               var5.field_76149_c = p_76154_1_[var7];
               p_76154_1_[var7] = var5;
               var5 = var6;
            } while(var6 != null);
         }
      }

   }

   public Object func_76159_d(long p_76159_1_) {
      LongHashMap.Entry var3 = this.func_76152_e(p_76159_1_);
      return var3 == null?null:var3.field_76148_b;
   }

   final LongHashMap.Entry func_76152_e(long p_76152_1_) {
      int var3 = func_76155_g(p_76152_1_);
      int var4 = func_76158_a(var3, this.field_180201_c);
      LongHashMap.Entry var5 = this.field_76169_a[var4];

      LongHashMap.Entry var6;
      LongHashMap.Entry var7;
      for(var6 = var5; var6 != null; var6 = var7) {
         var7 = var6.field_76149_c;
         if(var6.field_76150_a == p_76152_1_) {
            ++this.field_76166_e;
            --this.field_76167_b;
            if(var5 == var6) {
               this.field_76169_a[var4] = var7;
            } else {
               var5.field_76149_c = var7;
            }

            return var6;
         }

         var5 = var6;
      }

      return var6;
   }

   private void func_76156_a(int p_76156_1_, long p_76156_2_, Object p_76156_4_, int p_76156_5_) {
      LongHashMap.Entry var6 = this.field_76169_a[p_76156_5_];
      this.field_76169_a[p_76156_5_] = new LongHashMap.Entry(p_76156_1_, p_76156_2_, p_76156_4_, var6);
      if(this.field_76167_b++ >= this.field_76168_c) {
         this.func_76153_b(2 * this.field_76169_a.length);
      }

   }

   static class Entry {

      final long field_76150_a;
      Object field_76148_b;
      LongHashMap.Entry field_76149_c;
      final int field_76147_d;
      private static final String __OBFID = "CL_00001493";


      Entry(int p_i1553_1_, long p_i1553_2_, Object p_i1553_4_, LongHashMap.Entry p_i1553_5_) {
         this.field_76148_b = p_i1553_4_;
         this.field_76149_c = p_i1553_5_;
         this.field_76150_a = p_i1553_2_;
         this.field_76147_d = p_i1553_1_;
      }

      public final long func_76146_a() {
         return this.field_76150_a;
      }

      public final Object func_76145_b() {
         return this.field_76148_b;
      }

      public final boolean equals(Object p_equals_1_) {
         if(!(p_equals_1_ instanceof LongHashMap.Entry)) {
            return false;
         } else {
            LongHashMap.Entry var2 = (LongHashMap.Entry)p_equals_1_;
            Long var3 = Long.valueOf(this.func_76146_a());
            Long var4 = Long.valueOf(var2.func_76146_a());
            if(var3 == var4 || var3 != null && var3.equals(var4)) {
               Object var5 = this.func_76145_b();
               Object var6 = var2.func_76145_b();
               if(var5 == var6 || var5 != null && var5.equals(var6)) {
                  return true;
               }
            }

            return false;
         }
      }

      public final int hashCode() {
         return LongHashMap.func_76155_g(this.field_76150_a);
      }

      public final String toString() {
         return this.func_76146_a() + "=" + this.func_76145_b();
      }
   }
}
