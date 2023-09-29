package net.minecraft.block.properties;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.HashSet;
import net.minecraft.block.properties.PropertyHelper;

public class PropertyInteger extends PropertyHelper {

   private final ImmutableSet field_177720_a;
   private static final String __OBFID = "CL_00002014";


   protected PropertyInteger(String p_i45648_1_, int p_i45648_2_, int p_i45648_3_) {
      super(p_i45648_1_, Integer.class);
      if(p_i45648_2_ < 0) {
         throw new IllegalArgumentException("Min value of " + p_i45648_1_ + " must be 0 or greater");
      } else if(p_i45648_3_ <= p_i45648_2_) {
         throw new IllegalArgumentException("Max value of " + p_i45648_1_ + " must be greater than min (" + p_i45648_2_ + ")");
      } else {
         HashSet var4 = Sets.newHashSet();

         for(int var5 = p_i45648_2_; var5 <= p_i45648_3_; ++var5) {
            var4.add(Integer.valueOf(var5));
         }

         this.field_177720_a = ImmutableSet.copyOf(var4);
      }
   }

   public Collection func_177700_c() {
      return this.field_177720_a;
   }

   public boolean equals(Object p_equals_1_) {
      if(this == p_equals_1_) {
         return true;
      } else if(p_equals_1_ != null && this.getClass() == p_equals_1_.getClass()) {
         if(!super.equals(p_equals_1_)) {
            return false;
         } else {
            PropertyInteger var2 = (PropertyInteger)p_equals_1_;
            return this.field_177720_a.equals(var2.field_177720_a);
         }
      } else {
         return false;
      }
   }

   public int hashCode() {
      int var1 = super.hashCode();
      var1 = 31 * var1 + this.field_177720_a.hashCode();
      return var1;
   }

   public static PropertyInteger func_177719_a(String p_177719_0_, int p_177719_1_, int p_177719_2_) {
      return new PropertyInteger(p_177719_0_, p_177719_1_, p_177719_2_);
   }

   public String func_177718_a(Integer p_177718_1_) {
      return p_177718_1_.toString();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String func_177702_a(Comparable p_177702_1_) {
      return this.func_177718_a((Integer)p_177702_1_);
   }
}
