package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;

public class CommandServerKick extends CommandBase {

   private static final String __OBFID = "CL_00000550";


   public String func_71517_b() {
      return "kick";
   }

   public int func_82362_a() {
      return 3;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.kick.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length > 0 && p_71515_2_[0].length() > 1) {
         EntityPlayerMP var3 = MinecraftServer.func_71276_C().func_71203_ab().func_152612_a(p_71515_2_[0]);
         String var4 = "Kicked by an operator.";
         boolean var5 = false;
         if(var3 == null) {
            throw new PlayerNotFoundException();
         } else {
            if(p_71515_2_.length >= 2) {
               var4 = func_147178_a(p_71515_1_, p_71515_2_, 1).func_150260_c();
               var5 = true;
            }

            var3.field_71135_a.func_147360_c(var4);
            if(var5) {
               func_152373_a(p_71515_1_, this, "commands.kick.success.reason", new Object[]{var3.func_70005_c_(), var4});
            } else {
               func_152373_a(p_71515_1_, this, "commands.kick.success", new Object[]{var3.func_70005_c_()});
            }

         }
      } else {
         throw new WrongUsageException("commands.kick.usage", new Object[0]);
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length >= 1?func_71530_a(p_180525_2_, MinecraftServer.func_71276_C().func_71213_z()):null;
   }
}
