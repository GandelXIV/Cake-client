package net.minecraft.command;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.profiler.Profiler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandDebug extends CommandBase {

   private static final Logger field_147208_a = LogManager.getLogger();
   private long field_147206_b;
   private int field_147207_c;
   private static final String __OBFID = "CL_00000270";


   public String func_71517_b() {
      return "debug";
   }

   public int func_82362_a() {
      return 3;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.debug.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 1) {
         throw new WrongUsageException("commands.debug.usage", new Object[0]);
      } else {
         if(p_71515_2_[0].equals("start")) {
            if(p_71515_2_.length != 1) {
               throw new WrongUsageException("commands.debug.usage", new Object[0]);
            }

            func_152373_a(p_71515_1_, this, "commands.debug.start", new Object[0]);
            MinecraftServer.func_71276_C().func_71223_ag();
            this.field_147206_b = MinecraftServer.func_130071_aq();
            this.field_147207_c = MinecraftServer.func_71276_C().func_71259_af();
         } else if(p_71515_2_[0].equals("stop")) {
            if(p_71515_2_.length != 1) {
               throw new WrongUsageException("commands.debug.usage", new Object[0]);
            }

            if(!MinecraftServer.func_71276_C().field_71304_b.field_76327_a) {
               throw new CommandException("commands.debug.notStarted", new Object[0]);
            }

            long var3 = MinecraftServer.func_130071_aq();
            int var5 = MinecraftServer.func_71276_C().func_71259_af();
            long var6 = var3 - this.field_147206_b;
            int var8 = var5 - this.field_147207_c;
            this.func_147205_a(var6, var8);
            MinecraftServer.func_71276_C().field_71304_b.field_76327_a = false;
            func_152373_a(p_71515_1_, this, "commands.debug.stop", new Object[]{Float.valueOf((float)var6 / 1000.0F), Integer.valueOf(var8)});
         } else if(p_71515_2_[0].equals("chunk")) {
            if(p_71515_2_.length != 4) {
               throw new WrongUsageException("commands.debug.usage", new Object[0]);
            }

            func_175757_a(p_71515_1_, p_71515_2_, 1, true);
         }

      }
   }

   private void func_147205_a(long p_147205_1_, int p_147205_3_) {
      File var4 = new File(MinecraftServer.func_71276_C().func_71209_f("debug"), "profile-results-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + ".txt");
      var4.getParentFile().mkdirs();

      try {
         FileWriter var5 = new FileWriter(var4);
         var5.write(this.func_147204_b(p_147205_1_, p_147205_3_));
         var5.close();
      } catch (Throwable var6) {
         field_147208_a.error("Could not save profiler results to " + var4, var6);
      }

   }

   private String func_147204_b(long p_147204_1_, int p_147204_3_) {
      StringBuilder var4 = new StringBuilder();
      var4.append("---- Minecraft Profiler Results ----\n");
      var4.append("// ");
      var4.append(func_147203_d());
      var4.append("\n\n");
      var4.append("Time span: ").append(p_147204_1_).append(" ms\n");
      var4.append("Tick span: ").append(p_147204_3_).append(" ticks\n");
      var4.append("// This is approximately ").append(String.format("%.2f", new Object[]{Float.valueOf((float)p_147204_3_ / ((float)p_147204_1_ / 1000.0F))})).append(" ticks per second. It should be ").append(20).append(" ticks per second\n\n");
      var4.append("--- BEGIN PROFILE DUMP ---\n\n");
      this.func_147202_a(0, "root", var4);
      var4.append("--- END PROFILE DUMP ---\n\n");
      return var4.toString();
   }

   private void func_147202_a(int p_147202_1_, String p_147202_2_, StringBuilder p_147202_3_) {
      List var4 = MinecraftServer.func_71276_C().field_71304_b.func_76321_b(p_147202_2_);
      if(var4 != null && var4.size() >= 3) {
         for(int var5 = 1; var5 < var4.size(); ++var5) {
            Profiler.Result var6 = (Profiler.Result)var4.get(var5);
            p_147202_3_.append(String.format("[%02d] ", new Object[]{Integer.valueOf(p_147202_1_)}));

            for(int var7 = 0; var7 < p_147202_1_; ++var7) {
               p_147202_3_.append(" ");
            }

            p_147202_3_.append(var6.field_76331_c).append(" - ").append(String.format("%.2f", new Object[]{Double.valueOf(var6.field_76332_a)})).append("%/").append(String.format("%.2f", new Object[]{Double.valueOf(var6.field_76330_b)})).append("%\n");
            if(!var6.field_76331_c.equals("unspecified")) {
               try {
                  this.func_147202_a(p_147202_1_ + 1, p_147202_2_ + "." + var6.field_76331_c, p_147202_3_);
               } catch (Exception var8) {
                  p_147202_3_.append("[[ EXCEPTION ").append(var8).append(" ]]");
               }
            }
         }

      }
   }

   private static String func_147203_d() {
      String[] var0 = new String[]{"Shiny numbers!", "Am I not running fast enough? :(", "I\'m working as hard as I can!", "Will I ever be good enough for you? :(", "Speedy. Zoooooom!", "Hello world", "40% better than a crash report.", "Now with extra numbers", "Now with less numbers", "Now with the same numbers", "You should add flames to things, it makes them go faster!", "Do you feel the need for... optimization?", "*cracks redstone whip*", "Maybe if you treated it better then it\'ll have more motivation to work faster! Poor server."};

      try {
         return var0[(int)(System.nanoTime() % (long)var0.length)];
      } catch (Throwable var2) {
         return "Witty comment unavailable :(";
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length == 1?func_71530_a(p_180525_2_, new String[]{"start", "stop"}):null;
   }

}
