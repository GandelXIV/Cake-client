package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;

public class CommandClearInventory extends CommandBase {

   private static final String __OBFID = "CL_00000218";


   public String func_71517_b() {
      return "clear";
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.clear.usage";
   }

   public int func_82362_a() {
      return 2;
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      EntityPlayerMP var3 = p_71515_2_.length == 0?func_71521_c(p_71515_1_):func_82359_c(p_71515_1_, p_71515_2_[0]);
      Item var4 = p_71515_2_.length >= 2?func_147179_f(p_71515_1_, p_71515_2_[1]):null;
      int var5 = p_71515_2_.length >= 3?func_180528_a(p_71515_2_[2], -1):-1;
      int var6 = p_71515_2_.length >= 4?func_180528_a(p_71515_2_[3], -1):-1;
      NBTTagCompound var7 = null;
      if(p_71515_2_.length >= 5) {
         try {
            var7 = JsonToNBT.func_180713_a(func_180529_a(p_71515_2_, 4));
         } catch (NBTException var9) {
            throw new CommandException("commands.clear.tagError", new Object[]{var9.getMessage()});
         }
      }

      if(p_71515_2_.length >= 2 && var4 == null) {
         throw new CommandException("commands.clear.failure", new Object[]{var3.func_70005_c_()});
      } else {
         int var8 = var3.field_71071_by.func_174925_a(var4, var5, var6, var7);
         var3.field_71069_bz.func_75142_b();
         if(!var3.field_71075_bZ.field_75098_d) {
            var3.func_71113_k();
         }

         p_71515_1_.func_174794_a(CommandResultStats.Type.AFFECTED_ITEMS, var8);
         if(var8 == 0) {
            throw new CommandException("commands.clear.failure", new Object[]{var3.func_70005_c_()});
         } else {
            if(var6 == 0) {
               p_71515_1_.func_145747_a(new ChatComponentTranslation("commands.clear.testing", new Object[]{var3.func_70005_c_(), Integer.valueOf(var8)}));
            } else {
               func_152373_a(p_71515_1_, this, "commands.clear.success", new Object[]{var3.func_70005_c_(), Integer.valueOf(var8)});
            }

         }
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length == 1?func_71530_a(p_180525_2_, this.func_147209_d()):(p_180525_2_.length == 2?func_175762_a(p_180525_2_, Item.field_150901_e.func_148742_b()):null);
   }

   protected String[] func_147209_d() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 0;
   }
}
