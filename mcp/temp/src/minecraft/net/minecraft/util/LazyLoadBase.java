package net.minecraft.util;


public abstract class LazyLoadBase {

   private Object field_179283_a;
   private boolean field_179282_b = false;
   private static final String __OBFID = "CL_00002263";


   public Object func_179281_c() {
      if(!this.field_179282_b) {
         this.field_179282_b = true;
         this.field_179283_a = this.func_179280_b();
      }

      return this.field_179283_a;
   }

   protected abstract Object func_179280_b();
}
