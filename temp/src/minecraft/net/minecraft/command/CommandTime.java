package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.WorldServer;

public class CommandTime extends CommandBase {

   private static final String __OBFID = "CL_00001183";


   public String func_71517_b() {
      return "time";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.time.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length > 1) {
         int var3;
         if(p_71515_2_[0].equals("set")) {
            if(p_71515_2_[1].equals("day")) {
               var3 = 1000;
            } else if(p_71515_2_[1].equals("night")) {
               var3 = 13000;
            } else {
               var3 = func_180528_a(p_71515_2_[1], 0);
            }

            this.func_71552_a(p_71515_1_, var3);
            func_152373_a(p_71515_1_, this, "commands.time.set", new Object[]{Integer.valueOf(var3)});
            return;
         }

         if(p_71515_2_[0].equals("add")) {
            var3 = func_180528_a(p_71515_2_[1], 0);
            this.func_71553_b(p_71515_1_, var3);
            func_152373_a(p_71515_1_, this, "commands.time.added", new Object[]{Integer.valueOf(var3)});
            return;
         }

         if(p_71515_2_[0].equals("query")) {
            if(p_71515_2_[1].equals("daytime")) {
               var3 = (int)(p_71515_1_.func_130014_f_().func_72820_D() % 2147483647L);
               p_71515_1_.func_174794_a(CommandResultStats.Type.QUERY_RESULT, var3);
               func_152373_a(p_71515_1_, this, "commands.time.query", new Object[]{Integer.valueOf(var3)});
               return;
            }

            if(p_71515_2_[1].equals("gametime")) {
               var3 = (int)(p_71515_1_.func_130014_f_().func_82737_E() % 2147483647L);
               p_71515_1_.func_174794_a(CommandResultStats.Type.QUERY_RESULT, var3);
               func_152373_a(p_71515_1_, this, "commands.time.query", new Object[]{Integer.valueOf(var3)});
               return;
            }
         }
      }

      throw new WrongUsageException("commands.time.usage", new Object[0]);
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length == 1?func_71530_a(p_180525_2_, new String[]{"set", "add", "query"}):(p_180525_2_.length == 2 && p_180525_2_[0].equals("set")?func_71530_a(p_180525_2_, new String[]{"day", "night"}):(p_180525_2_.length == 2 && p_180525_2_[0].equals("query")?func_71530_a(p_180525_2_, new String[]{"daytime", "gametime"}):null));
   }

   protected void func_71552_a(ICommandSender p_71552_1_, int p_71552_2_) {
      for(int var3 = 0; var3 < MinecraftServer.func_71276_C().field_71305_c.length; ++var3) {
         MinecraftServer.func_71276_C().field_71305_c[var3].func_72877_b((long)p_71552_2_);
      }

   }

   protected void func_71553_b(ICommandSender p_71553_1_, int p_71553_2_) {
      for(int var3 = 0; var3 < MinecraftServer.func_71276_C().field_71305_c.length; ++var3) {
         WorldServer var4 = MinecraftServer.func_71276_C().field_71305_c[var3];
         var4.func_72877_b(var4.func_72820_D() + (long)p_71553_2_);
      }

   }
}
