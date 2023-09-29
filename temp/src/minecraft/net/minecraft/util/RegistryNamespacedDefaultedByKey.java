package net.minecraft.util;

import net.minecraft.util.RegistryNamespaced;
import org.apache.commons.lang3.Validate;

public class RegistryNamespacedDefaultedByKey extends RegistryNamespaced {

   private final Object field_148760_d;
   private Object field_148761_e;
   private static final String __OBFID = "CL_00001196";


   public RegistryNamespacedDefaultedByKey(Object p_i46017_1_) {
      this.field_148760_d = p_i46017_1_;
   }

   public void func_177775_a(int p_177775_1_, Object p_177775_2_, Object p_177775_3_) {
      if(this.field_148760_d.equals(p_177775_2_)) {
         this.field_148761_e = p_177775_3_;
      }

      super.func_177775_a(p_177775_1_, p_177775_2_, p_177775_3_);
   }

   public void func_177776_a() {
      Validate.notNull(this.field_148760_d);
   }

   public Object func_82594_a(Object p_82594_1_) {
      Object var2 = super.func_82594_a(p_82594_1_);
      return var2 == null?this.field_148761_e:var2;
   }

   public Object func_148754_a(int p_148754_1_) {
      Object var2 = super.func_148754_a(p_148754_1_);
      return var2 == null?this.field_148761_e:var2;
   }
}
