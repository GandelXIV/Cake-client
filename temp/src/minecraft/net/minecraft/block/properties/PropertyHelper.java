package net.minecraft.block.properties;

import com.google.common.base.Objects;
import net.minecraft.block.properties.IProperty;

public abstract class PropertyHelper implements IProperty {

   private final Class field_177704_a;
   private final String field_177703_b;
   private static final String __OBFID = "CL_00002018";


   protected PropertyHelper(String p_i45652_1_, Class p_i45652_2_) {
      this.field_177704_a = p_i45652_2_;
      this.field_177703_b = p_i45652_1_;
   }

   public String func_177701_a() {
      return this.field_177703_b;
   }

   public Class func_177699_b() {
      return this.field_177704_a;
   }

   public String toString() {
      return Objects.toStringHelper(this).add("name", this.field_177703_b).add("clazz", this.field_177704_a).add("values", this.func_177700_c()).toString();
   }

   public boolean equals(Object p_equals_1_) {
      if(this == p_equals_1_) {
         return true;
      } else if(p_equals_1_ != null && this.getClass() == p_equals_1_.getClass()) {
         PropertyHelper var2 = (PropertyHelper)p_equals_1_;
         return this.field_177704_a.equals(var2.field_177704_a) && this.field_177703_b.equals(var2.field_177703_b);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return 31 * this.field_177704_a.hashCode() + this.field_177703_b.hashCode();
   }
}
