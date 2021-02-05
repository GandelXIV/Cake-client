package net.minecraft.command;

import java.util.List;
import java.util.Random;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;

public class CommandWeather extends CommandBase {

   private static final String __OBFID = "CL_00001185";


   public String func_71517_b() {
      return "weather";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.weather.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length >= 1 && p_71515_2_.length <= 2) {
         int var3 = (300 + (new Random()).nextInt(600)) * 20;
         if(p_71515_2_.length >= 2) {
            var3 = func_175764_a(p_71515_2_[1], 1, 1000000) * 20;
         }

         WorldServer var4 = MinecraftServer.func_71276_C().field_71305_c[0];
         WorldInfo var5 = var4.func_72912_H();
         if("clear".equalsIgnoreCase(p_71515_2_[0])) {
            var5.func_176142_i(var3);
            var5.func_76080_g(0);
            var5.func_76090_f(0);
            var5.func_76084_b(false);
            var5.func_76069_a(false);
            func_152373_a(p_71515_1_, this, "commands.weather.clear", new Object[0]);
         } else if("rain".equalsIgnoreCase(p_71515_2_[0])) {
            var5.func_176142_i(0);
            var5.func_76080_g(var3);
            var5.func_76090_f(var3);
            var5.func_76084_b(true);
            var5.func_76069_a(false);
            func_152373_a(p_71515_1_, this, "commands.weather.rain", new Object[0]);
         } else {
            if(!"thunder".equalsIgnoreCase(p_71515_2_[0])) {
               throw new WrongUsageException("commands.weather.usage", new Object[0]);
            }

            var5.func_176142_i(0);
            var5.func_76080_g(var3);
            var5.func_76090_f(var3);
            var5.func_76084_b(true);
            var5.func_76069_a(true);
            func_152373_a(p_71515_1_, this, "commands.weather.thunder", new Object[0]);
         }

      } else {
         throw new WrongUsageException("commands.weather.usage", new Object[0]);
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length == 1?func_71530_a(p_180525_2_, new String[]{"clear", "rain", "thunder"}):null;
   }
}
