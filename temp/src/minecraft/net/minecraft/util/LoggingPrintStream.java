package net.minecraft.util;

import java.io.OutputStream;
import java.io.PrintStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingPrintStream extends PrintStream {

   private static final Logger field_179884_a = LogManager.getLogger();
   private final String field_179883_b;
   private static final String __OBFID = "CL_00002275";


   public LoggingPrintStream(String p_i45927_1_, OutputStream p_i45927_2_) {
      super(p_i45927_2_);
      this.field_179883_b = p_i45927_1_;
   }

   public void println(String p_println_1_) {
      this.func_179882_a(p_println_1_);
   }

   public void println(Object p_println_1_) {
      this.func_179882_a(String.valueOf(p_println_1_));
   }

   private void func_179882_a(String p_179882_1_) {
      StackTraceElement[] var2 = Thread.currentThread().getStackTrace();
      StackTraceElement var3 = var2[Math.min(3, var2.length)];
      field_179884_a.info("[{}]@.({}:{}): {}", new Object[]{this.field_179883_b, var3.getFileName(), Integer.valueOf(var3.getLineNumber()), p_179882_1_});
   }

}
