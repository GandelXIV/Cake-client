package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;

public class CommandEntityData extends CommandBase {

   private static final String __OBFID = "CL_00002345";


   public String func_71517_b() {
      return "entitydata";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.entitydata.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 2) {
         throw new WrongUsageException("commands.entitydata.usage", new Object[0]);
      } else {
         Entity var3 = func_175768_b(p_71515_1_, p_71515_2_[0]);
         if(var3 instanceof EntityPlayer) {
            throw new CommandException("commands.entitydata.noPlayers", new Object[]{var3.func_145748_c_()});
         } else {
            NBTTagCompound var4 = new NBTTagCompound();
            var3.func_70109_d(var4);
            NBTTagCompound var5 = (NBTTagCompound)var4.func_74737_b();

            NBTTagCompound var6;
            try {
               var6 = JsonToNBT.func_180713_a(func_147178_a(p_71515_1_, p_71515_2_, 1).func_150260_c());
            } catch (NBTException var8) {
               throw new CommandException("commands.entitydata.tagError", new Object[]{var8.getMessage()});
            }

            var6.func_82580_o("UUIDMost");
            var6.func_82580_o("UUIDLeast");
            var4.func_179237_a(var6);
            if(var4.equals(var5)) {
               throw new CommandException("commands.entitydata.failed", new Object[]{var4.toString()});
            } else {
               var3.func_70020_e(var4);
               func_152373_a(p_71515_1_, this, "commands.entitydata.success", new Object[]{var4.toString()});
            }
         }
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length == 1?func_71530_a(p_180525_2_, MinecraftServer.func_71276_C().func_71213_z()):null;
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 0;
   }
}
