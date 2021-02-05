package net.minecraft.command.server;

import java.util.Arrays;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class CommandMessage extends CommandBase {

   private static final String __OBFID = "CL_00000641";


   public List func_71514_a() {
      return Arrays.asList(new String[]{"w", "msg"});
   }

   public String func_71517_b() {
      return "tell";
   }

   public int func_82362_a() {
      return 0;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.message.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 2) {
         throw new WrongUsageException("commands.message.usage", new Object[0]);
      } else {
         EntityPlayerMP var3 = func_82359_c(p_71515_1_, p_71515_2_[0]);
         if(var3 == p_71515_1_) {
            throw new PlayerNotFoundException("commands.message.sameTarget", new Object[0]);
         } else {
            IChatComponent var4 = func_147176_a(p_71515_1_, p_71515_2_, 1, !(p_71515_1_ instanceof EntityPlayer));
            ChatComponentTranslation var5 = new ChatComponentTranslation("commands.message.display.incoming", new Object[]{p_71515_1_.func_145748_c_(), var4.func_150259_f()});
            ChatComponentTranslation var6 = new ChatComponentTranslation("commands.message.display.outgoing", new Object[]{var3.func_145748_c_(), var4.func_150259_f()});
            var5.func_150256_b().func_150238_a(EnumChatFormatting.GRAY).func_150217_b(Boolean.valueOf(true));
            var6.func_150256_b().func_150238_a(EnumChatFormatting.GRAY).func_150217_b(Boolean.valueOf(true));
            var3.func_145747_a(var5);
            p_71515_1_.func_145747_a(var6);
         }
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return func_71530_a(p_180525_2_, MinecraftServer.func_71276_C().func_71213_z());
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 0;
   }
}
