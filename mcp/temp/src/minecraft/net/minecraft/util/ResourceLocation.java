package net.minecraft.util;

import org.apache.commons.lang3.Validate;

public class ResourceLocation {

   protected final String field_110626_a;
   protected final String field_110625_b;
   private static final String __OBFID = "CL_00001082";


   protected ResourceLocation(int p_i45928_1_, String ... p_i45928_2_) {
      this.field_110626_a = org.apache.commons.lang3.StringUtils.isEmpty(p_i45928_2_[0])?"minecraft":p_i45928_2_[0].toLowerCase();
      this.field_110625_b = p_i45928_2_[1];
      Validate.notNull(this.field_110625_b);
   }

   public ResourceLocation(String p_i1293_1_) {
      this(0, func_177516_a(p_i1293_1_));
   }

   public ResourceLocation(String p_i1292_1_, String p_i1292_2_) {
      this(0, new String[]{p_i1292_1_, p_i1292_2_});
   }

   protected static String[] func_177516_a(String p_177516_0_) {
      String[] var1 = new String[]{null, p_177516_0_};
      int var2 = p_177516_0_.indexOf(58);
      if(var2 >= 0) {
         var1[1] = p_177516_0_.substring(var2 + 1, p_177516_0_.length());
         if(var2 > 1) {
            var1[0] = p_177516_0_.substring(0, var2);
         }
      }

      return var1;
   }

   public String func_110623_a() {
      return this.field_110625_b;
   }

   public String func_110624_b() {
      return this.field_110626_a;
   }

   public String toString() {
      return this.field_110626_a + ':' + this.field_110625_b;
   }

   public boolean equals(Object p_equals_1_) {
      if(this == p_equals_1_) {
         return true;
      } else if(!(p_equals_1_ instanceof ResourceLocation)) {
         return false;
      } else {
         ResourceLocation var2 = (ResourceLocation)p_equals_1_;
         return this.field_110626_a.equals(var2.field_110626_a) && this.field_110625_b.equals(var2.field_110625_b);
      }
   }

   public int hashCode() {
      return 31 * this.field_110626_a.hashCode() + this.field_110625_b.hashCode();
   }
}
