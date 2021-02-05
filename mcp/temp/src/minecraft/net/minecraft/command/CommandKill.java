package net.minecraft.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;

public class CommandKill extends CommandBase {

   private static final String __OBFID = "CL_00000570";


   public String func_71517_b() {
      return "kill";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.kill.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length == 0) {
         EntityPlayerMP var4 = func_71521_c(p_71515_1_);
         var4.func_174812_G();
         func_152373_a(p_71515_1_, this, "commands.kill.successful", new Object[]{var4.func_145748_c_()});
      } else {
         Entity var3 = func_175768_b(p_71515_1_, p_71515_2_[0]);
         var3.func_174812_G();
         func_152373_a(p_71515_1_, this, "commands.kill.successful", new Object[]{var3.func_145748_c_()});
      }
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 0;
   }
}
