package net.minecraft.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class WeightedRandom {

   private static final String __OBFID = "CL_00001503";


   public static int func_76272_a(Collection p_76272_0_) {
      int var1 = 0;

      WeightedRandom.Item var3;
      for(Iterator var2 = p_76272_0_.iterator(); var2.hasNext(); var1 += var3.field_76292_a) {
         var3 = (WeightedRandom.Item)var2.next();
      }

      return var1;
   }

   public static WeightedRandom.Item func_76273_a(Random p_76273_0_, Collection p_76273_1_, int p_76273_2_) {
      if(p_76273_2_ <= 0) {
         throw new IllegalArgumentException();
      } else {
         int var3 = p_76273_0_.nextInt(p_76273_2_);
         return func_180166_a(p_76273_1_, var3);
      }
   }

   public static WeightedRandom.Item func_180166_a(Collection p_180166_0_, int p_180166_1_) {
      Iterator var2 = p_180166_0_.iterator();

      WeightedRandom.Item var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (WeightedRandom.Item)var2.next();
         p_180166_1_ -= var3.field_76292_a;
      } while(p_180166_1_ >= 0);

      return var3;
   }

   public static WeightedRandom.Item func_76271_a(Random p_76271_0_, Collection p_76271_1_) {
      return func_76273_a(p_76271_0_, p_76271_1_, func_76272_a(p_76271_1_));
   }

   public static class Item {

      protected int field_76292_a;
      private static final String __OBFID = "CL_00001504";


      public Item(int p_i1556_1_) {
         this.field_76292_a = p_i1556_1_;
      }
   }
}
