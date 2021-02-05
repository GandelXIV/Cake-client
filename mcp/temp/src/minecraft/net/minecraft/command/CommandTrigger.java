package net.minecraft.command;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.scoreboard.IScoreObjectiveCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;

public class CommandTrigger extends CommandBase {

   private static final String __OBFID = "CL_00002337";


   public String func_71517_b() {
      return "trigger";
   }

   public int func_82362_a() {
      return 0;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.trigger.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 3) {
         throw new WrongUsageException("commands.trigger.usage", new Object[0]);
      } else {
         EntityPlayerMP var3;
         if(p_71515_1_ instanceof EntityPlayerMP) {
            var3 = (EntityPlayerMP)p_71515_1_;
         } else {
            Entity var4 = p_71515_1_.func_174793_f();
            if(!(var4 instanceof EntityPlayerMP)) {
               throw new CommandException("commands.trigger.invalidPlayer", new Object[0]);
            }

            var3 = (EntityPlayerMP)var4;
         }

         Scoreboard var8 = MinecraftServer.func_71276_C().func_71218_a(0).func_96441_U();
         ScoreObjective var5 = var8.func_96518_b(p_71515_2_[0]);
         if(var5 != null && var5.func_96680_c() == IScoreObjectiveCriteria.field_178791_c) {
            int var6 = func_175755_a(p_71515_2_[2]);
            if(!var8.func_178819_b(var3.func_70005_c_(), var5)) {
               throw new CommandException("commands.trigger.invalidObjective", new Object[]{p_71515_2_[0]});
            } else {
               Score var7 = var8.func_96529_a(var3.func_70005_c_(), var5);
               if(var7.func_178816_g()) {
                  throw new CommandException("commands.trigger.disabled", new Object[]{p_71515_2_[0]});
               } else {
                  if("set".equals(p_71515_2_[1])) {
                     var7.func_96647_c(var6);
                  } else {
                     if(!"add".equals(p_71515_2_[1])) {
                        throw new CommandException("commands.trigger.invalidMode", new Object[]{p_71515_2_[1]});
                     }

                     var7.func_96649_a(var6);
                  }

                  var7.func_178815_a(true);
                  if(var3.field_71134_c.func_73083_d()) {
                     func_152373_a(p_71515_1_, this, "commands.trigger.success", new Object[]{p_71515_2_[0], p_71515_2_[1], p_71515_2_[2]});
                  }

               }
            }
         } else {
            throw new CommandException("commands.trigger.invalidObjective", new Object[]{p_71515_2_[0]});
         }
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      if(p_180525_2_.length == 1) {
         Scoreboard var4 = MinecraftServer.func_71276_C().func_71218_a(0).func_96441_U();
         ArrayList var5 = Lists.newArrayList();
         Iterator var6 = var4.func_96514_c().iterator();

         while(var6.hasNext()) {
            ScoreObjective var7 = (ScoreObjective)var6.next();
            if(var7.func_96680_c() == IScoreObjectiveCriteria.field_178791_c) {
               var5.add(var7.func_96679_b());
            }
         }

         return func_71530_a(p_180525_2_, (String[])var5.toArray(new String[var5.size()]));
      } else {
         return p_180525_2_.length == 2?func_71530_a(p_180525_2_, new String[]{"add", "set"}):null;
      }
   }
}
