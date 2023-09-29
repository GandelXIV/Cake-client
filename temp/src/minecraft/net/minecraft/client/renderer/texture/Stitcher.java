package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.client.renderer.StitcherException;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.MathHelper;

public class Stitcher {

   private final int field_147971_a;
   private final Set field_94319_a = Sets.newHashSetWithExpectedSize(256);
   private final List field_94317_b = Lists.newArrayListWithCapacity(256);
   private int field_94318_c;
   private int field_94315_d;
   private final int field_94316_e;
   private final int field_94313_f;
   private final boolean field_94314_g;
   private final int field_94323_h;
   private static final String __OBFID = "CL_00001054";


   public Stitcher(int p_i45095_1_, int p_i45095_2_, boolean p_i45095_3_, int p_i45095_4_, int p_i45095_5_) {
      this.field_147971_a = p_i45095_5_;
      this.field_94316_e = p_i45095_1_;
      this.field_94313_f = p_i45095_2_;
      this.field_94314_g = p_i45095_3_;
      this.field_94323_h = p_i45095_4_;
   }

   public int func_110935_a() {
      return this.field_94318_c;
   }

   public int func_110936_b() {
      return this.field_94315_d;
   }

   public void func_110934_a(TextureAtlasSprite p_110934_1_) {
      Stitcher.Holder var2 = new Stitcher.Holder(p_110934_1_, this.field_147971_a);
      if(this.field_94323_h > 0) {
         var2.func_94196_a(this.field_94323_h);
      }

      this.field_94319_a.add(var2);
   }

   public void func_94305_f() {
      Stitcher.Holder[] var1 = (Stitcher.Holder[])this.field_94319_a.toArray(new Stitcher.Holder[this.field_94319_a.size()]);
      Arrays.sort(var1);
      Stitcher.Holder[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Stitcher.Holder var5 = var2[var4];
         if(!this.func_94310_b(var5)) {
            String var6 = String.format("Unable to fit: %s - size: %dx%d - Maybe try a lowerresolution resourcepack?", new Object[]{var5.func_98150_a().func_94215_i(), Integer.valueOf(var5.func_98150_a().func_94211_a()), Integer.valueOf(var5.func_98150_a().func_94216_b())});
            throw new StitcherException(var5, var6);
         }
      }

      if(this.field_94314_g) {
         this.field_94318_c = MathHelper.func_151236_b(this.field_94318_c);
         this.field_94315_d = MathHelper.func_151236_b(this.field_94315_d);
      }

   }

   public List func_94309_g() {
      ArrayList var1 = Lists.newArrayList();
      Iterator var2 = this.field_94317_b.iterator();

      while(var2.hasNext()) {
         Stitcher.Slot var3 = (Stitcher.Slot)var2.next();
         var3.func_94184_a(var1);
      }

      ArrayList var7 = Lists.newArrayList();
      Iterator var8 = var1.iterator();

      while(var8.hasNext()) {
         Stitcher.Slot var4 = (Stitcher.Slot)var8.next();
         Stitcher.Holder var5 = var4.func_94183_a();
         TextureAtlasSprite var6 = var5.func_98150_a();
         var6.func_110971_a(this.field_94318_c, this.field_94315_d, var4.func_94186_b(), var4.func_94185_c(), var5.func_94195_e());
         var7.add(var6);
      }

      return var7;
   }

   private static int func_147969_b(int p_147969_0_, int p_147969_1_) {
      return (p_147969_0_ >> p_147969_1_) + ((p_147969_0_ & (1 << p_147969_1_) - 1) == 0?0:1) << p_147969_1_;
   }

   private boolean func_94310_b(Stitcher.Holder p_94310_1_) {
      for(int var2 = 0; var2 < this.field_94317_b.size(); ++var2) {
         if(((Stitcher.Slot)this.field_94317_b.get(var2)).func_94182_a(p_94310_1_)) {
            return true;
         }

         p_94310_1_.func_94194_d();
         if(((Stitcher.Slot)this.field_94317_b.get(var2)).func_94182_a(p_94310_1_)) {
            return true;
         }

         p_94310_1_.func_94194_d();
      }

      return this.func_94311_c(p_94310_1_);
   }

   private boolean func_94311_c(Stitcher.Holder p_94311_1_) {
      int var2 = Math.min(p_94311_1_.func_94197_a(), p_94311_1_.func_94199_b());
      boolean var3 = this.field_94318_c == 0 && this.field_94315_d == 0;
      boolean var4;
      int var5;
      if(this.field_94314_g) {
         var5 = MathHelper.func_151236_b(this.field_94318_c);
         int var6 = MathHelper.func_151236_b(this.field_94315_d);
         int var7 = MathHelper.func_151236_b(this.field_94318_c + var2);
         int var8 = MathHelper.func_151236_b(this.field_94315_d + var2);
         boolean var9 = var7 <= this.field_94316_e;
         boolean var10 = var8 <= this.field_94313_f;
         if(!var9 && !var10) {
            return false;
         }

         boolean var11 = var5 != var7;
         boolean var12 = var6 != var8;
         if(var11 ^ var12) {
            var4 = !var11;
         } else {
            var4 = var9 && var5 <= var6;
         }
      } else {
         boolean var13 = this.field_94318_c + var2 <= this.field_94316_e;
         boolean var14 = this.field_94315_d + var2 <= this.field_94313_f;
         if(!var13 && !var14) {
            return false;
         }

         var4 = var13 && (var3 || this.field_94318_c <= this.field_94315_d);
      }

      var5 = Math.max(p_94311_1_.func_94197_a(), p_94311_1_.func_94199_b());
      if(MathHelper.func_151236_b((var4?this.field_94315_d:this.field_94318_c) + var5) > (var4?this.field_94313_f:this.field_94316_e)) {
         return false;
      } else {
         Stitcher.Slot var15;
         if(var4) {
            if(p_94311_1_.func_94197_a() > p_94311_1_.func_94199_b()) {
               p_94311_1_.func_94194_d();
            }

            if(this.field_94315_d == 0) {
               this.field_94315_d = p_94311_1_.func_94199_b();
            }

            var15 = new Stitcher.Slot(this.field_94318_c, 0, p_94311_1_.func_94197_a(), this.field_94315_d);
            this.field_94318_c += p_94311_1_.func_94197_a();
         } else {
            var15 = new Stitcher.Slot(0, this.field_94315_d, this.field_94318_c, p_94311_1_.func_94199_b());
            this.field_94315_d += p_94311_1_.func_94199_b();
         }

         var15.func_94182_a(p_94311_1_);
         this.field_94317_b.add(var15);
         return true;
      }
   }

   public static class Holder implements Comparable {

      private final TextureAtlasSprite field_98151_a;
      private final int field_94204_c;
      private final int field_94201_d;
      private final int field_147968_d;
      private boolean field_94202_e;
      private float field_94205_a = 1.0F;
      private static final String __OBFID = "CL_00001055";


      public Holder(TextureAtlasSprite p_i45094_1_, int p_i45094_2_) {
         this.field_98151_a = p_i45094_1_;
         this.field_94204_c = p_i45094_1_.func_94211_a();
         this.field_94201_d = p_i45094_1_.func_94216_b();
         this.field_147968_d = p_i45094_2_;
         this.field_94202_e = Stitcher.func_147969_b(this.field_94201_d, p_i45094_2_) > Stitcher.func_147969_b(this.field_94204_c, p_i45094_2_);
      }

      public TextureAtlasSprite func_98150_a() {
         return this.field_98151_a;
      }

      public int func_94197_a() {
         return this.field_94202_e?Stitcher.func_147969_b((int)((float)this.field_94201_d * this.field_94205_a), this.field_147968_d):Stitcher.func_147969_b((int)((float)this.field_94204_c * this.field_94205_a), this.field_147968_d);
      }

      public int func_94199_b() {
         return this.field_94202_e?Stitcher.func_147969_b((int)((float)this.field_94204_c * this.field_94205_a), this.field_147968_d):Stitcher.func_147969_b((int)((float)this.field_94201_d * this.field_94205_a), this.field_147968_d);
      }

      public void func_94194_d() {
         this.field_94202_e = !this.field_94202_e;
      }

      public boolean func_94195_e() {
         return this.field_94202_e;
      }

      public void func_94196_a(int p_94196_1_) {
         if(this.field_94204_c > p_94196_1_ && this.field_94201_d > p_94196_1_) {
            this.field_94205_a = (float)p_94196_1_ / (float)Math.min(this.field_94204_c, this.field_94201_d);
         }
      }

      public String toString() {
         return "Holder{width=" + this.field_94204_c + ", height=" + this.field_94201_d + '}';
      }

      public int compareTo(Stitcher.Holder p_compareTo_1_) {
         int var2;
         if(this.func_94199_b() == p_compareTo_1_.func_94199_b()) {
            if(this.func_94197_a() == p_compareTo_1_.func_94197_a()) {
               if(this.field_98151_a.func_94215_i() == null) {
                  return p_compareTo_1_.field_98151_a.func_94215_i() == null?0:-1;
               }

               return this.field_98151_a.func_94215_i().compareTo(p_compareTo_1_.field_98151_a.func_94215_i());
            }

            var2 = this.func_94197_a() < p_compareTo_1_.func_94197_a()?1:-1;
         } else {
            var2 = this.func_94199_b() < p_compareTo_1_.func_94199_b()?1:-1;
         }

         return var2;
      }

      // $FF: synthetic method
      public int compareTo(Object p_compareTo_1_) {
         return this.compareTo((Stitcher.Holder)p_compareTo_1_);
      }
   }

   public static class Slot {

      private final int field_94192_a;
      private final int field_94190_b;
      private final int field_94191_c;
      private final int field_94188_d;
      private List field_94189_e;
      private Stitcher.Holder field_94187_f;
      private static final String __OBFID = "CL_00001056";


      public Slot(int p_i1277_1_, int p_i1277_2_, int p_i1277_3_, int p_i1277_4_) {
         this.field_94192_a = p_i1277_1_;
         this.field_94190_b = p_i1277_2_;
         this.field_94191_c = p_i1277_3_;
         this.field_94188_d = p_i1277_4_;
      }

      public Stitcher.Holder func_94183_a() {
         return this.field_94187_f;
      }

      public int func_94186_b() {
         return this.field_94192_a;
      }

      public int func_94185_c() {
         return this.field_94190_b;
      }

      public boolean func_94182_a(Stitcher.Holder p_94182_1_) {
         if(this.field_94187_f != null) {
            return false;
         } else {
            int var2 = p_94182_1_.func_94197_a();
            int var3 = p_94182_1_.func_94199_b();
            if(var2 <= this.field_94191_c && var3 <= this.field_94188_d) {
               if(var2 == this.field_94191_c && var3 == this.field_94188_d) {
                  this.field_94187_f = p_94182_1_;
                  return true;
               } else {
                  if(this.field_94189_e == null) {
                     this.field_94189_e = Lists.newArrayListWithCapacity(1);
                     this.field_94189_e.add(new Stitcher.Slot(this.field_94192_a, this.field_94190_b, var2, var3));
                     int var4 = this.field_94191_c - var2;
                     int var5 = this.field_94188_d - var3;
                     if(var5 > 0 && var4 > 0) {
                        int var6 = Math.max(this.field_94188_d, var4);
                        int var7 = Math.max(this.field_94191_c, var5);
                        if(var6 >= var7) {
                           this.field_94189_e.add(new Stitcher.Slot(this.field_94192_a, this.field_94190_b + var3, var2, var5));
                           this.field_94189_e.add(new Stitcher.Slot(this.field_94192_a + var2, this.field_94190_b, var4, this.field_94188_d));
                        } else {
                           this.field_94189_e.add(new Stitcher.Slot(this.field_94192_a + var2, this.field_94190_b, var4, var3));
                           this.field_94189_e.add(new Stitcher.Slot(this.field_94192_a, this.field_94190_b + var3, this.field_94191_c, var5));
                        }
                     } else if(var4 == 0) {
                        this.field_94189_e.add(new Stitcher.Slot(this.field_94192_a, this.field_94190_b + var3, var2, var5));
                     } else if(var5 == 0) {
                        this.field_94189_e.add(new Stitcher.Slot(this.field_94192_a + var2, this.field_94190_b, var4, var3));
                     }
                  }

                  Iterator var8 = this.field_94189_e.iterator();

                  Stitcher.Slot var9;
                  do {
                     if(!var8.hasNext()) {
                        return false;
                     }

                     var9 = (Stitcher.Slot)var8.next();
                  } while(!var9.func_94182_a(p_94182_1_));

                  return true;
               }
            } else {
               return false;
            }
         }
      }

      public void func_94184_a(List p_94184_1_) {
         if(this.field_94187_f != null) {
            p_94184_1_.add(this);
         } else if(this.field_94189_e != null) {
            Iterator var2 = this.field_94189_e.iterator();

            while(var2.hasNext()) {
               Stitcher.Slot var3 = (Stitcher.Slot)var2.next();
               var3.func_94184_a(p_94184_1_);
            }
         }

      }

      public String toString() {
         return "Slot{originX=" + this.field_94192_a + ", originY=" + this.field_94190_b + ", width=" + this.field_94191_c + ", height=" + this.field_94188_d + ", texture=" + this.field_94187_f + ", subSlots=" + this.field_94189_e + '}';
      }
   }
}
