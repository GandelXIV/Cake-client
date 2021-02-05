package net.minecraft.command;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandNotFoundException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;

public class CommandHelp extends CommandBase {

   private static final String __OBFID = "CL_00000529";


   public String func_71517_b() {
      return "help";
   }

   public int func_82362_a() {
      return 0;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.help.usage";
   }

   public List func_71514_a() {
      return Arrays.asList(new String[]{"?"});
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      List var3 = this.func_71534_d(p_71515_1_);
      boolean var4 = true;
      int var5 = (var3.size() - 1) / 7;
      boolean var6 = false;

      int var13;
      try {
         var13 = p_71515_2_.length == 0?0:func_175764_a(p_71515_2_[0], 1, var5 + 1) - 1;
      } catch (NumberInvalidException var12) {
         Map var8 = this.func_71535_c();
         ICommand var9 = (ICommand)var8.get(p_71515_2_[0]);
         if(var9 != null) {
            throw new WrongUsageException(var9.func_71518_a(p_71515_1_), new Object[0]);
         }

         if(MathHelper.func_82715_a(p_71515_2_[0], -1) != -1) {
            throw var12;
         }

         throw new CommandNotFoundException();
      }

      int var7 = Math.min((var13 + 1) * 7, var3.size());
      ChatComponentTranslation var14 = new ChatComponentTranslation("commands.help.header", new Object[]{Integer.valueOf(var13 + 1), Integer.valueOf(var5 + 1)});
      var14.func_150256_b().func_150238_a(EnumChatFormatting.DARK_GREEN);
      p_71515_1_.func_145747_a(var14);

      for(int var15 = var13 * 7; var15 < var7; ++var15) {
         ICommand var10 = (ICommand)var3.get(var15);
         ChatComponentTranslation var11 = new ChatComponentTranslation(var10.func_71518_a(p_71515_1_), new Object[0]);
         var11.func_150256_b().func_150241_a(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/" + var10.func_71517_b() + " "));
         p_71515_1_.func_145747_a(var11);
      }

      if(var13 == 0 && p_71515_1_ instanceof EntityPlayer) {
         ChatComponentTranslation var16 = new ChatComponentTranslation("commands.help.footer", new Object[0]);
         var16.func_150256_b().func_150238_a(EnumChatFormatting.GREEN);
         p_71515_1_.func_145747_a(var16);
      }

   }

   protected List func_71534_d(ICommandSender p_71534_1_) {
      List var2 = MinecraftServer.func_71276_C().func_71187_D().func_71557_a(p_71534_1_);
      Collections.sort(var2);
      return var2;
   }

   protected Map func_71535_c() {
      return MinecraftServer.func_71276_C().func_71187_D().func_71555_a();
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      if(p_180525_2_.length == 1) {
         Set var4 = this.func_71535_c().keySet();
         return func_71530_a(p_180525_2_, (String[])var4.toArray(new String[var4.size()]));
      } else {
         return null;
      }
   }
}
