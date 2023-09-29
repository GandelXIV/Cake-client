package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;

public class CommandSetSpawnpoint extends CommandBase {

   private static final String __OBFID = "CL_00001026";


   public String func_71517_b() {
      return "spawnpoint";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.spawnpoint.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length > 0 && p_71515_2_.length < 4) {
         throw new WrongUsageException("commands.spawnpoint.usage", new Object[0]);
      } else {
         EntityPlayerMP var3 = p_71515_2_.length > 0?func_82359_c(p_71515_1_, p_71515_2_[0]):func_71521_c(p_71515_1_);
         BlockPos var4 = p_71515_2_.length > 3?func_175757_a(p_71515_1_, p_71515_2_, 1, true):var3.func_180425_c();
         if(var3.field_70170_p != null) {
            var3.func_180473_a(var4, true);
            func_152373_a(p_71515_1_, this, "commands.spawnpoint.success", new Object[]{var3.func_70005_c_(), Integer.valueOf(var4.func_177958_n()), Integer.valueOf(var4.func_177956_o()), Integer.valueOf(var4.func_177952_p())});
         }

      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length == 1?func_71530_a(p_180525_2_, MinecraftServer.func_71276_C().func_71213_z()):(p_180525_2_.length > 1 && p_180525_2_.length <= 4?func_175771_a(p_180525_2_, 1, p_180525_3_):null);
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 0;
   }
}
