package net.minecraft.util;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Cartesian {

   private static final String __OBFID = "CL_00002327";


   public static Iterable func_179318_a(Class p_179318_0_, Iterable p_179318_1_) {
      return new Cartesian.Product(p_179318_0_, (Iterable[])func_179322_b(Iterable.class, p_179318_1_), null);
   }

   public static Iterable func_179321_a(Iterable p_179321_0_) {
      return func_179323_b(func_179318_a(Object.class, p_179321_0_));
   }

   private static Iterable func_179323_b(Iterable p_179323_0_) {
      return Iterables.transform(p_179323_0_, new Cartesian.GetList(null));
   }

   private static Object[] func_179322_b(Class p_179322_0_, Iterable p_179322_1_) {
      ArrayList var2 = Lists.newArrayList();
      Iterator var3 = p_179322_1_.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         var2.add(var4);
      }

      return (Object[])var2.toArray(func_179319_b(p_179322_0_, var2.size()));
   }

   private static Object[] func_179319_b(Class p_179319_0_, int p_179319_1_) {
      return (Object[])((Object[])Array.newInstance(p_179319_0_, p_179319_1_));
   }

   static class GetList implements Function {

      private static final String __OBFID = "CL_00002325";


      private GetList() {}

      public List func_179324_a(Object[] p_179324_1_) {
         return Arrays.asList((Object[])p_179324_1_);
      }

      // $FF: synthetic method
      public Object apply(Object p_apply_1_) {
         return this.func_179324_a((Object[])p_apply_1_);
      }

      // $FF: synthetic method
      GetList(Object p_i46022_1_) {
         this();
      }
   }

   static class Product implements Iterable {

      private final Class field_179429_a;
      private final Iterable[] field_179428_b;
      private static final String __OBFID = "CL_00002324";


      private Product(Class p_i46020_1_, Iterable[] p_i46020_2_) {
         this.field_179429_a = p_i46020_1_;
         this.field_179428_b = p_i46020_2_;
      }

      public Iterator iterator() {
         return (Iterator)(this.field_179428_b.length <= 0?Collections.singletonList((Object[])Cartesian.func_179319_b(this.field_179429_a, 0)).iterator():new Cartesian.Product.ProductIterator(this.field_179429_a, this.field_179428_b, null));
      }

      // $FF: synthetic method
      Product(Class p_i46021_1_, Iterable[] p_i46021_2_, Object p_i46021_3_) {
         this(p_i46021_1_, p_i46021_2_);
      }

      static class ProductIterator extends UnmodifiableIterator {

         private int field_179426_a;
         private final Iterable[] field_179424_b;
         private final Iterator[] field_179425_c;
         private final Object[] field_179423_d;
         private static final String __OBFID = "CL_00002323";


         private ProductIterator(Class p_i46018_1_, Iterable[] p_i46018_2_) {
            this.field_179426_a = -2;
            this.field_179424_b = p_i46018_2_;
            this.field_179425_c = (Iterator[])Cartesian.func_179319_b(Iterator.class, this.field_179424_b.length);

            for(int var3 = 0; var3 < this.field_179424_b.length; ++var3) {
               this.field_179425_c[var3] = p_i46018_2_[var3].iterator();
            }

            this.field_179423_d = Cartesian.func_179319_b(p_i46018_1_, this.field_179425_c.length);
         }

         private void func_179422_b() {
            this.field_179426_a = -1;
            Arrays.fill(this.field_179425_c, (Object)null);
            Arrays.fill(this.field_179423_d, (Object)null);
         }

         public boolean hasNext() {
            if(this.field_179426_a == -2) {
               this.field_179426_a = 0;
               Iterator[] var5 = this.field_179425_c;
               int var2 = var5.length;

               for(int var3 = 0; var3 < var2; ++var3) {
                  Iterator var4 = var5[var3];
                  if(!var4.hasNext()) {
                     this.func_179422_b();
                     break;
                  }
               }

               return true;
            } else {
               if(this.field_179426_a >= this.field_179425_c.length) {
                  for(this.field_179426_a = this.field_179425_c.length - 1; this.field_179426_a >= 0; --this.field_179426_a) {
                     Iterator var1 = this.field_179425_c[this.field_179426_a];
                     if(var1.hasNext()) {
                        break;
                     }

                     if(this.field_179426_a == 0) {
                        this.func_179422_b();
                        break;
                     }

                     var1 = this.field_179424_b[this.field_179426_a].iterator();
                     this.field_179425_c[this.field_179426_a] = var1;
                     if(!var1.hasNext()) {
                        this.func_179422_b();
                        break;
                     }
                  }
               }

               return this.field_179426_a >= 0;
            }
         }

         public Object[] func_179421_a() {
            if(!this.hasNext()) {
               throw new NoSuchElementException();
            } else {
               while(this.field_179426_a < this.field_179425_c.length) {
                  this.field_179423_d[this.field_179426_a] = this.field_179425_c[this.field_179426_a].next();
                  ++this.field_179426_a;
               }

               return (Object[])this.field_179423_d.clone();
            }
         }

         // $FF: synthetic method
         public Object next() {
            return this.func_179421_a();
         }

         // $FF: synthetic method
         ProductIterator(Class p_i46019_1_, Iterable[] p_i46019_2_, Object p_i46019_3_) {
            this(p_i46019_1_, p_i46019_2_);
         }
      }
   }
}
