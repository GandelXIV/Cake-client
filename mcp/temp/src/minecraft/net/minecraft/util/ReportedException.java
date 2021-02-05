package net.minecraft.util;

import net.minecraft.crash.CrashReport;

public class ReportedException extends RuntimeException {

   private final CrashReport field_71576_a;
   private static final String __OBFID = "CL_00001579";


   public ReportedException(CrashReport p_i1356_1_) {
      this.field_71576_a = p_i1356_1_;
   }

   public CrashReport func_71575_a() {
      return this.field_71576_a;
   }

   public Throwable getCause() {
      return this.field_71576_a.func_71505_b();
   }

   public String getMessage() {
      return this.field_71576_a.func_71501_a();
   }
}
