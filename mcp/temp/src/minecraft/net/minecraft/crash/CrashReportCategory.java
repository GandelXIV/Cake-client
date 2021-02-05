package net.minecraft.crash;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.crash.CrashReport;
import net.minecraft.util.BlockPos;

public class CrashReportCategory {

   private final CrashReport field_85078_a;
   private final String field_85076_b;
   private final List field_85077_c = Lists.newArrayList();
   private StackTraceElement[] field_85075_d = new StackTraceElement[0];
   private static final String __OBFID = "CL_00001409";


   public CrashReportCategory(CrashReport p_i1353_1_, String p_i1353_2_) {
      this.field_85078_a = p_i1353_1_;
      this.field_85076_b = p_i1353_2_;
   }

   public static String func_85074_a(double p_85074_0_, double p_85074_2_, double p_85074_4_) {
      return String.format("%.2f,%.2f,%.2f - %s", new Object[]{Double.valueOf(p_85074_0_), Double.valueOf(p_85074_2_), Double.valueOf(p_85074_4_), func_180522_a(new BlockPos(p_85074_0_, p_85074_2_, p_85074_4_))});
   }

   public static String func_180522_a(BlockPos p_180522_0_) {
      int var1 = p_180522_0_.func_177958_n();
      int var2 = p_180522_0_.func_177956_o();
      int var3 = p_180522_0_.func_177952_p();
      StringBuilder var4 = new StringBuilder();

      try {
         var4.append(String.format("World: (%d,%d,%d)", new Object[]{Integer.valueOf(var1), Integer.valueOf(var2), Integer.valueOf(var3)}));
      } catch (Throwable var17) {
         var4.append("(Error finding world loc)");
      }

      var4.append(", ");

      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      try {
         var5 = var1 >> 4;
         var6 = var3 >> 4;
         var7 = var1 & 15;
         var8 = var2 >> 4;
         var9 = var3 & 15;
         var10 = var5 << 4;
         var11 = var6 << 4;
         var12 = (var5 + 1 << 4) - 1;
         var13 = (var6 + 1 << 4) - 1;
         var4.append(String.format("Chunk: (at %d,%d,%d in %d,%d; contains blocks %d,0,%d to %d,255,%d)", new Object[]{Integer.valueOf(var7), Integer.valueOf(var8), Integer.valueOf(var9), Integer.valueOf(var5), Integer.valueOf(var6), Integer.valueOf(var10), Integer.valueOf(var11), Integer.valueOf(var12), Integer.valueOf(var13)}));
      } catch (Throwable var16) {
         var4.append("(Error finding chunk loc)");
      }

      var4.append(", ");

      try {
         var5 = var1 >> 9;
         var6 = var3 >> 9;
         var7 = var5 << 5;
         var8 = var6 << 5;
         var9 = (var5 + 1 << 5) - 1;
         var10 = (var6 + 1 << 5) - 1;
         var11 = var5 << 9;
         var12 = var6 << 9;
         var13 = (var5 + 1 << 9) - 1;
         int var14 = (var6 + 1 << 9) - 1;
         var4.append(String.format("Region: (%d,%d; contains chunks %d,%d to %d,%d, blocks %d,0,%d to %d,255,%d)", new Object[]{Integer.valueOf(var5), Integer.valueOf(var6), Integer.valueOf(var7), Integer.valueOf(var8), Integer.valueOf(var9), Integer.valueOf(var10), Integer.valueOf(var11), Integer.valueOf(var12), Integer.valueOf(var13), Integer.valueOf(var14)}));
      } catch (Throwable var15) {
         var4.append("(Error finding world loc)");
      }

      return var4.toString();
   }

   public void func_71500_a(String p_71500_1_, Callable p_71500_2_) {
      try {
         this.func_71507_a(p_71500_1_, p_71500_2_.call());
      } catch (Throwable var4) {
         this.func_71499_a(p_71500_1_, var4);
      }

   }

   public void func_71507_a(String p_71507_1_, Object p_71507_2_) {
      this.field_85077_c.add(new CrashReportCategory.Entry(p_71507_1_, p_71507_2_));
   }

   public void func_71499_a(String p_71499_1_, Throwable p_71499_2_) {
      this.func_71507_a(p_71499_1_, p_71499_2_);
   }

   public int func_85073_a(int p_85073_1_) {
      StackTraceElement[] var2 = Thread.currentThread().getStackTrace();
      if(var2.length <= 0) {
         return 0;
      } else {
         this.field_85075_d = new StackTraceElement[var2.length - 3 - p_85073_1_];
         System.arraycopy(var2, 3 + p_85073_1_, this.field_85075_d, 0, this.field_85075_d.length);
         return this.field_85075_d.length;
      }
   }

   public boolean func_85069_a(StackTraceElement p_85069_1_, StackTraceElement p_85069_2_) {
      if(this.field_85075_d.length != 0 && p_85069_1_ != null) {
         StackTraceElement var3 = this.field_85075_d[0];
         if(var3.isNativeMethod() == p_85069_1_.isNativeMethod() && var3.getClassName().equals(p_85069_1_.getClassName()) && var3.getFileName().equals(p_85069_1_.getFileName()) && var3.getMethodName().equals(p_85069_1_.getMethodName())) {
            if(p_85069_2_ != null != this.field_85075_d.length > 1) {
               return false;
            } else if(p_85069_2_ != null && !this.field_85075_d[1].equals(p_85069_2_)) {
               return false;
            } else {
               this.field_85075_d[0] = p_85069_1_;
               return true;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public void func_85070_b(int p_85070_1_) {
      StackTraceElement[] var2 = new StackTraceElement[this.field_85075_d.length - p_85070_1_];
      System.arraycopy(this.field_85075_d, 0, var2, 0, var2.length);
      this.field_85075_d = var2;
   }

   public void func_85072_a(StringBuilder p_85072_1_) {
      p_85072_1_.append("-- ").append(this.field_85076_b).append(" --\n");
      p_85072_1_.append("Details:");
      Iterator var2 = this.field_85077_c.iterator();

      while(var2.hasNext()) {
         CrashReportCategory.Entry var3 = (CrashReportCategory.Entry)var2.next();
         p_85072_1_.append("\n\t");
         p_85072_1_.append(var3.func_85089_a());
         p_85072_1_.append(": ");
         p_85072_1_.append(var3.func_85090_b());
      }

      if(this.field_85075_d != null && this.field_85075_d.length > 0) {
         p_85072_1_.append("\nStacktrace:");
         StackTraceElement[] var6 = this.field_85075_d;
         int var7 = var6.length;

         for(int var4 = 0; var4 < var7; ++var4) {
            StackTraceElement var5 = var6[var4];
            p_85072_1_.append("\n\tat ");
            p_85072_1_.append(var5.toString());
         }
      }

   }

   public StackTraceElement[] func_147152_a() {
      return this.field_85075_d;
   }

   public static void func_180523_a(CrashReportCategory p_180523_0_, final BlockPos p_180523_1_, final Block p_180523_2_, final int p_180523_3_) {
      final int var4 = Block.func_149682_b(p_180523_2_);
      p_180523_0_.func_71500_a("Block type", new Callable() {

         private static final String __OBFID = "CL_00001426";

         public String call() {
            try {
               return String.format("ID #%d (%s // %s)", new Object[]{Integer.valueOf(var4), p_180523_2_.func_149739_a(), p_180523_2_.getClass().getCanonicalName()});
            } catch (Throwable var2) {
               return "ID #" + var4;
            }
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      p_180523_0_.func_71500_a("Block data value", new Callable() {

         private static final String __OBFID = "CL_00001441";

         public String call() {
            if(p_180523_3_ < 0) {
               return "Unknown? (Got " + p_180523_3_ + ")";
            } else {
               String var1 = String.format("%4s", new Object[]{Integer.toBinaryString(p_180523_3_)}).replace(" ", "0");
               return String.format("%1$d / 0x%1$X / 0b%2$s", new Object[]{Integer.valueOf(p_180523_3_), var1});
            }
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      p_180523_0_.func_71500_a("Block location", new Callable() {

         private static final String __OBFID = "CL_00001465";

         public String call() {
            return CrashReportCategory.func_180522_a(p_180523_1_);
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
   }

   public static void func_175750_a(CrashReportCategory p_175750_0_, final BlockPos p_175750_1_, final IBlockState p_175750_2_) {
      p_175750_0_.func_71500_a("Block", new Callable() {

         private static final String __OBFID = "CL_00002617";

         public String func_175753_a() {
            return p_175750_2_.toString();
         }
         // $FF: synthetic method
         public Object call() {
            return this.func_175753_a();
         }
      });
      p_175750_0_.func_71500_a("Block location", new Callable() {

         private static final String __OBFID = "CL_00002616";

         public String func_175751_a() {
            return CrashReportCategory.func_180522_a(p_175750_1_);
         }
         // $FF: synthetic method
         public Object call() {
            return this.func_175751_a();
         }
      });
   }

   static class Entry {

      private final String field_85092_a;
      private final String field_85091_b;
      private static final String __OBFID = "CL_00001489";


      public Entry(String p_i1352_1_, Object p_i1352_2_) {
         this.field_85092_a = p_i1352_1_;
         if(p_i1352_2_ == null) {
            this.field_85091_b = "~~NULL~~";
         } else if(p_i1352_2_ instanceof Throwable) {
            Throwable var3 = (Throwable)p_i1352_2_;
            this.field_85091_b = "~~ERROR~~ " + var3.getClass().getSimpleName() + ": " + var3.getMessage();
         } else {
            this.field_85091_b = p_i1352_2_.toString();
         }

      }

      public String func_85089_a() {
         return this.field_85092_a;
      }

      public String func_85090_b() {
         return this.field_85091_b;
      }
   }
}
