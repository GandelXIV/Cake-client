package net.minecraft.command.server;

import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;

public class CommandOp extends CommandBase {

   private static final String __OBFID = "CL_00000694";


   public String func_71517_b() {
      return "op";
   }

   public int func_82362_a() {
      return 3;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.op.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length == 1 && p_71515_2_[0].length() > 0) {
         MinecraftServer var3 = MinecraftServer.func_71276_C();
         GameProfile var4 = var3.func_152358_ax().func_152655_a(p_71515_2_[0]);
         if(var4 == null) {
            throw new CommandException("commands.op.failed", new Object[]{p_71515_2_[0]});
         } else {
            var3.func_71203_ab().func_152605_a(var4);
            func_152373_a(p_71515_1_, this, "commands.op.success", new Object[]{p_71515_2_[0]});
         }
      } else {
         throw new WrongUsageException("commands.op.usage", new Object[0]);
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      if(p_180525_2_.length == 1) {
         String var4 = p_180525_2_[p_180525_2_.length - 1];
         ArrayList var5 = Lists.newArrayList();
         GameProfile[] var6 = MinecraftServer.func_71276_C().func_152357_F();
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            GameProfile var9 = var6[var8];
            if(!MinecraftServer.func_71276_C().func_71203_ab().func_152596_g(var9) && func_71523_a(var4, var9.getName())) {
               var5.add(var9.getName());
            }
         }

         return var5;
      } else {
         return null;
      }
   }
}
