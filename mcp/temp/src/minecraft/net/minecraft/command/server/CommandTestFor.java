package net.minecraft.command.server;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.command.server.CommandTestForBlock;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;

public class CommandTestFor extends CommandBase {

   private static final String __OBFID = "CL_00001182";


   public String func_71517_b() {
      return "testfor";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.testfor.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 1) {
         throw new WrongUsageException("commands.testfor.usage", new Object[0]);
      } else {
         Entity var3 = func_175768_b(p_71515_1_, p_71515_2_[0]);
         NBTTagCompound var4 = null;
         if(p_71515_2_.length >= 2) {
            try {
               var4 = JsonToNBT.func_180713_a(func_180529_a(p_71515_2_, 1));
            } catch (NBTException var6) {
               throw new CommandException("commands.testfor.tagError", new Object[]{var6.getMessage()});
            }
         }

         if(var4 != null) {
            NBTTagCompound var5 = new NBTTagCompound();
            var3.func_70109_d(var5);
            if(!CommandTestForBlock.func_175775_a(var4, var5, true)) {
               throw new CommandException("commands.testfor.failure", new Object[]{var3.func_70005_c_()});
            }
         }

         func_152373_a(p_71515_1_, this, "commands.testfor.success", new Object[]{var3.func_70005_c_()});
      }
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 0;
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length == 1?func_71530_a(p_180525_2_, MinecraftServer.func_71276_C().func_71213_z()):null;
   }
}
