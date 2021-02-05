package net.minecraft.crash;

import com.google.common.collect.Lists;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.world.gen.layer.IntCache;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CrashReport {

   private static final Logger field_147150_a = LogManager.getLogger();
   private final String field_71513_a;
   private final Throwable field_71511_b;
   private final CrashReportCategory field_85061_c = new CrashReportCategory(this, "System Details");
   private final List field_71512_c = Lists.newArrayList();
   private File field_71510_d;
   private boolean field_85059_f = true;
   private StackTraceElement[] field_85060_g = new StackTraceElement[0];
   private static final String __OBFID = "CL_00000990";


   public CrashReport(String p_i1348_1_, Throwable p_i1348_2_) {
      this.field_71513_a = p_i1348_1_;
      this.field_71511_b = p_i1348_2_;
      this.func_71504_g();
   }

   private void func_71504_g() {
      this.field_85061_c.func_71500_a("Minecraft Version", new Callable() {

         private static final String __OBFID = "CL_00001197";

         public String call() {
            return "1.8";
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      this.field_85061_c.func_71500_a("Operating System", new Callable() {

         private static final String __OBFID = "CL_00001222";

         public String call() {
            return System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ") version " + System.getProperty("os.version");
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      this.field_85061_c.func_71500_a("Java Version", new Callable() {

         private static final String __OBFID = "CL_00001248";

         public String call() {
            return System.getProperty("java.version") + ", " + System.getProperty("java.vendor");
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      this.field_85061_c.func_71500_a("Java VM Version", new Callable() {

         private static final String __OBFID = "CL_00001275";

         public String call() {
            return System.getProperty("java.vm.name") + " (" + System.getProperty("java.vm.info") + "), " + System.getProperty("java.vm.vendor");
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      this.field_85061_c.func_71500_a("Memory", new Callable() {

         private static final String __OBFID = "CL_00001302";

         public String call() {
            Runtime var1 = Runtime.getRuntime();
            long var2 = var1.maxMemory();
            long var4 = var1.totalMemory();
            long var6 = var1.freeMemory();
            long var8 = var2 / 1024L / 1024L;
            long var10 = var4 / 1024L / 1024L;
            long var12 = var6 / 1024L / 1024L;
            return var6 + " bytes (" + var12 + " MB) / " + var4 + " bytes (" + var10 + " MB) up to " + var2 + " bytes (" + var8 + " MB)";
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      this.field_85061_c.func_71500_a("JVM Flags", new Callable() {

         private static final String __OBFID = "CL_00001329";

         public String call() {
            RuntimeMXBean var1 = ManagementFactory.getRuntimeMXBean();
            List var2 = var1.getInputArguments();
            int var3 = 0;
            StringBuilder var4 = new StringBuilder();
            Iterator var5 = var2.iterator();

            while(var5.hasNext()) {
               String var6 = (String)var5.next();
               if(var6.startsWith("-X")) {
                  if(var3++ > 0) {
                     var4.append(" ");
                  }

                  var4.append(var6);
               }
            }

            return String.format("%d total; %s", new Object[]{Integer.valueOf(var3), var4.toString()});
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      this.field_85061_c.func_71500_a("IntCache", new Callable() {

         private static final String __OBFID = "CL_00001355";

         public String call() {
            return IntCache.func_85144_b();
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
   }

   public String func_71501_a() {
      return this.field_71513_a;
   }

   public Throwable func_71505_b() {
      return this.field_71511_b;
   }

   public void func_71506_a(StringBuilder p_71506_1_) {
      if((this.field_85060_g == null || this.field_85060_g.length <= 0) && this.field_71512_c.size() > 0) {
         this.field_85060_g = (StackTraceElement[])ArrayUtils.subarray(((CrashReportCategory)this.field_71512_c.get(0)).func_147152_a(), 0, 1);
      }

      if(this.field_85060_g != null && this.field_85060_g.length > 0) {
         p_71506_1_.append("-- Head --\n");
         p_71506_1_.append("Stacktrace:\n");
         StackTraceElement[] var2 = this.field_85060_g;
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            StackTraceElement var5 = var2[var4];
            p_71506_1_.append("\t").append("at ").append(var5.toString());
            p_71506_1_.append("\n");
         }

         p_71506_1_.append("\n");
      }

      Iterator var6 = this.field_71512_c.iterator();

      while(var6.hasNext()) {
         CrashReportCategory var7 = (CrashReportCategory)var6.next();
         var7.func_85072_a(p_71506_1_);
         p_71506_1_.append("\n\n");
      }

      this.field_85061_c.func_85072_a(p_71506_1_);
   }

   public String func_71498_d() {
      StringWriter var1 = null;
      PrintWriter var2 = null;
      Object var3 = this.field_71511_b;
      if(((Throwable)var3).getMessage() == null) {
         if(var3 instanceof NullPointerException) {
            var3 = new NullPointerException(this.field_71513_a);
         } else if(var3 instanceof StackOverflowError) {
            var3 = new StackOverflowError(this.field_71513_a);
         } else if(var3 instanceof OutOfMemoryError) {
            var3 = new OutOfMemoryError(this.field_71513_a);
         }

         ((Throwable)var3).setStackTrace(this.field_71511_b.getStackTrace());
      }

      String var4 = ((Throwable)var3).toString();

      try {
         var1 = new StringWriter();
         var2 = new PrintWriter(var1);
         ((Throwable)var3).printStackTrace(var2);
         var4 = var1.toString();
      } finally {
         IOUtils.closeQuietly(var1);
         IOUtils.closeQuietly(var2);
      }

      return var4;
   }

   public String func_71502_e() {
      StringBuilder var1 = new StringBuilder();
      var1.append("---- Minecraft Crash Report ----\n");
      var1.append("// ");
      var1.append(func_71503_h());
      var1.append("\n\n");
      var1.append("Time: ");
      var1.append((new SimpleDateFormat()).format(new Date()));
      var1.append("\n");
      var1.append("Description: ");
      var1.append(this.field_71513_a);
      var1.append("\n\n");
      var1.append(this.func_71498_d());
      var1.append("\n\nA detailed walkthrough of the error, its code path and all known details is as follows:\n");

      for(int var2 = 0; var2 < 87; ++var2) {
         var1.append("-");
      }

      var1.append("\n\n");
      this.func_71506_a(var1);
      return var1.toString();
   }

   public File func_71497_f() {
      return this.field_71510_d;
   }

   public boolean func_147149_a(File p_147149_1_) {
      if(this.field_71510_d != null) {
         return false;
      } else {
         if(p_147149_1_.getParentFile() != null) {
            p_147149_1_.getParentFile().mkdirs();
         }

         try {
            FileWriter var2 = new FileWriter(p_147149_1_);
            var2.write(this.func_71502_e());
            var2.close();
            this.field_71510_d = p_147149_1_;
            return true;
         } catch (Throwable var3) {
            field_147150_a.error("Could not save crash report to " + p_147149_1_, var3);
            return false;
         }
      }
   }

   public CrashReportCategory func_85056_g() {
      return this.field_85061_c;
   }

   public CrashReportCategory func_85058_a(String p_85058_1_) {
      return this.func_85057_a(p_85058_1_, 1);
   }

   public CrashReportCategory func_85057_a(String p_85057_1_, int p_85057_2_) {
      CrashReportCategory var3 = new CrashReportCategory(this, p_85057_1_);
      if(this.field_85059_f) {
         int var4 = var3.func_85073_a(p_85057_2_);
         StackTraceElement[] var5 = this.field_71511_b.getStackTrace();
         StackTraceElement var6 = null;
         StackTraceElement var7 = null;
         int var8 = var5.length - var4;
         if(var8 < 0) {
            System.out.println("Negative index in crash report handler (" + var5.length + "/" + var4 + ")");
         }

         if(var5 != null && 0 <= var8 && var8 < var5.length) {
            var6 = var5[var8];
            if(var5.length + 1 - var4 < var5.length) {
               var7 = var5[var5.length + 1 - var4];
            }
         }

         this.field_85059_f = var3.func_85069_a(var6, var7);
         if(var4 > 0 && !this.field_71512_c.isEmpty()) {
            CrashReportCategory var9 = (CrashReportCategory)this.field_71512_c.get(this.field_71512_c.size() - 1);
            var9.func_85070_b(var4);
         } else if(var5 != null && var5.length >= var4 && 0 <= var8 && var8 < var5.length) {
            this.field_85060_g = new StackTraceElement[var8];
            System.arraycopy(var5, 0, this.field_85060_g, 0, this.field_85060_g.length);
         } else {
            this.field_85059_f = false;
         }
      }

      this.field_71512_c.add(var3);
      return var3;
   }

   private static String func_71503_h() {
      String[] var0 = new String[]{"Who set us up the TNT?", "Everything\'s going to plan. No, really, that was supposed to happen.", "Uh... Did I do that?", "Oops.", "Why did you do that?", "I feel sad now :(", "My bad.", "I\'m sorry, Dave.", "I let you down. Sorry :(", "On the bright side, I bought you a teddy bear!", "Daisy, daisy...", "Oh - I know what I did wrong!", "Hey, that tickles! Hehehe!", "I blame Dinnerbone.", "You should try our sister game, Minceraft!", "Don\'t be sad. I\'ll do better next time, I promise!", "Don\'t be sad, have a hug! <3", "I just don\'t know what went wrong :(", "Shall we play a game?", "Quite honestly, I wouldn\'t worry myself about that.", "I bet Cylons wouldn\'t have this problem.", "Sorry :(", "Surprise! Haha. Well, this is awkward.", "Would you like a cupcake?", "Hi. I\'m Minecraft, and I\'m a crashaholic.", "Ooh. Shiny.", "This doesn\'t make any sense!", "Why is it breaking :(", "Don\'t do that.", "Ouch. That hurt :(", "You\'re mean.", "This is a token for 1 free hug. Redeem at your nearest Mojangsta: [~~HUG~~]", "There are four lights!", "But it works on my machine."};

      try {
         return var0[(int)(System.nanoTime() % (long)var0.length)];
      } catch (Throwable var2) {
         return "Witty comment unavailable :(";
      }
   }

   public static CrashReport func_85055_a(Throwable p_85055_0_, String p_85055_1_) {
      CrashReport var2;
      if(p_85055_0_ instanceof ReportedException) {
         var2 = ((ReportedException)p_85055_0_).func_71575_a();
      } else {
         var2 = new CrashReport(p_85055_1_, p_85055_0_);
      }

      return var2;
   }

}
