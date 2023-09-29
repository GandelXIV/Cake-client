package net.minecraft.command;

import java.util.Iterator;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.S19PacketEntityStatus;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.GameRules;

public class CommandGameRule extends CommandBase {

   private static final String __OBFID = "CL_00000475";


   public String func_71517_b() {
      return "gamerule";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.gamerule.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      GameRules var3 = this.func_82366_d();
      String var4 = p_71515_2_.length > 0?p_71515_2_[0]:"";
      String var5 = p_71515_2_.length > 1?func_180529_a(p_71515_2_, 1):"";
      switch(p_71515_2_.length) {
      case 0:
         p_71515_1_.func_145747_a(new ChatComponentText(func_71527_a(var3.func_82763_b())));
         break;
      case 1:
         if(!var3.func_82765_e(var4)) {
            throw new CommandException("commands.gamerule.norule", new Object[]{var4});
         }

         String var6 = var3.func_82767_a(var4);
         p_71515_1_.func_145747_a((new ChatComponentText(var4)).func_150258_a(" = ").func_150258_a(var6));
         p_71515_1_.func_174794_a(CommandResultStats.Type.QUERY_RESULT, var3.func_180263_c(var4));
         break;
      default:
         if(var3.func_180264_a(var4, GameRules.ValueType.BOOLEAN_VALUE) && !"true".equals(var5) && !"false".equals(var5)) {
            throw new CommandException("commands.generic.boolean.invalid", new Object[]{var5});
         }

         var3.func_82764_b(var4, var5);
         func_175773_a(var3, var4);
         func_152373_a(p_71515_1_, this, "commands.gamerule.success", new Object[0]);
      }

   }

   public static void func_175773_a(GameRules p_175773_0_, String p_175773_1_) {
      if("reducedDebugInfo".equals(p_175773_1_)) {
         int var2 = p_175773_0_.func_82766_b(p_175773_1_)?22:23;
         Iterator var3 = MinecraftServer.func_71276_C().func_71203_ab().field_72404_b.iterator();

         while(var3.hasNext()) {
            EntityPlayerMP var4 = (EntityPlayerMP)var3.next();
            var4.field_71135_a.func_147359_a(new S19PacketEntityStatus(var4, (byte)var2));
         }
      }

   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      if(p_180525_2_.length == 1) {
         return func_71530_a(p_180525_2_, this.func_82366_d().func_82763_b());
      } else {
         if(p_180525_2_.length == 2) {
            GameRules var4 = this.func_82366_d();
            if(var4.func_180264_a(p_180525_2_[0], GameRules.ValueType.BOOLEAN_VALUE)) {
               return func_71530_a(p_180525_2_, new String[]{"true", "false"});
            }
         }

         return null;
      }
   }

   private GameRules func_82366_d() {
      return MinecraftServer.func_71276_C().func_71218_a(0).func_82736_K();
   }
}
