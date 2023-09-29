package net.minecraft.command.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;

public class CommandAchievement extends CommandBase {

   private static final String __OBFID = "CL_00000113";


   public String func_71517_b() {
      return "achievement";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.achievement.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 2) {
         throw new WrongUsageException("commands.achievement.usage", new Object[0]);
      } else {
         final StatBase var3 = StatList.func_151177_a(p_71515_2_[1]);
         if(var3 == null && !p_71515_2_[1].equals("*")) {
            throw new CommandException("commands.achievement.unknownAchievement", new Object[]{p_71515_2_[1]});
         } else {
            final EntityPlayerMP var4 = p_71515_2_.length >= 3?func_82359_c(p_71515_1_, p_71515_2_[2]):func_71521_c(p_71515_1_);
            boolean var5 = p_71515_2_[0].equalsIgnoreCase("give");
            boolean var6 = p_71515_2_[0].equalsIgnoreCase("take");
            if(var5 || var6) {
               if(var3 == null) {
                  Iterator var11;
                  Achievement var12;
                  if(var5) {
                     var11 = AchievementList.field_76007_e.iterator();

                     while(var11.hasNext()) {
                        var12 = (Achievement)var11.next();
                        var4.func_71029_a(var12);
                     }

                     func_152373_a(p_71515_1_, this, "commands.achievement.give.success.all", new Object[]{var4.func_70005_c_()});
                  } else if(var6) {
                     var11 = Lists.reverse(AchievementList.field_76007_e).iterator();

                     while(var11.hasNext()) {
                        var12 = (Achievement)var11.next();
                        var4.func_175145_a(var12);
                     }

                     func_152373_a(p_71515_1_, this, "commands.achievement.take.success.all", new Object[]{var4.func_70005_c_()});
                  }

               } else {
                  if(var3 instanceof Achievement) {
                     Achievement var7 = (Achievement)var3;
                     ArrayList var8;
                     Iterator var9;
                     Achievement var10;
                     if(var5) {
                        if(var4.func_147099_x().func_77443_a(var7)) {
                           throw new CommandException("commands.achievement.alreadyHave", new Object[]{var4.func_70005_c_(), var3.func_150955_j()});
                        }

                        for(var8 = Lists.newArrayList(); var7.field_75992_c != null && !var4.func_147099_x().func_77443_a(var7.field_75992_c); var7 = var7.field_75992_c) {
                           var8.add(var7.field_75992_c);
                        }

                        var9 = Lists.reverse(var8).iterator();

                        while(var9.hasNext()) {
                           var10 = (Achievement)var9.next();
                           var4.func_71029_a(var10);
                        }
                     } else if(var6) {
                        if(!var4.func_147099_x().func_77443_a(var7)) {
                           throw new CommandException("commands.achievement.dontHave", new Object[]{var4.func_70005_c_(), var3.func_150955_j()});
                        }

                        for(var8 = Lists.newArrayList(Iterators.filter(AchievementList.field_76007_e.iterator(), new Predicate() {

                           private static final String __OBFID = "CL_00002350";

                           public boolean func_179605_a(Achievement p_179605_1_) {
                              return var4.func_147099_x().func_77443_a(p_179605_1_) && p_179605_1_ != var3;
                           }
                           // $FF: synthetic method
                           public boolean apply(Object p_apply_1_) {
                              return this.func_179605_a((Achievement)p_apply_1_);
                           }
                        })); var7.field_75992_c != null && var4.func_147099_x().func_77443_a(var7.field_75992_c); var7 = var7.field_75992_c) {
                           var8.remove(var7.field_75992_c);
                        }

                        var9 = var8.iterator();

                        while(var9.hasNext()) {
                           var10 = (Achievement)var9.next();
                           var4.func_175145_a(var10);
                        }
                     }
                  }

                  if(var5) {
                     var4.func_71029_a(var3);
                     func_152373_a(p_71515_1_, this, "commands.achievement.give.success.one", new Object[]{var4.func_70005_c_(), var3.func_150955_j()});
                  } else if(var6) {
                     var4.func_175145_a(var3);
                     func_152373_a(p_71515_1_, this, "commands.achievement.take.success.one", new Object[]{var3.func_150955_j(), var4.func_70005_c_()});
                  }

               }
            }
         }
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      if(p_180525_2_.length == 1) {
         return func_71530_a(p_180525_2_, new String[]{"give", "take"});
      } else if(p_180525_2_.length != 2) {
         return p_180525_2_.length == 3?func_71530_a(p_180525_2_, MinecraftServer.func_71276_C().func_71213_z()):null;
      } else {
         ArrayList var4 = Lists.newArrayList();
         Iterator var5 = StatList.field_75940_b.iterator();

         while(var5.hasNext()) {
            StatBase var6 = (StatBase)var5.next();
            var4.add(var6.field_75975_e);
         }

         return func_175762_a(p_180525_2_, var4);
      }
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 2;
   }
}
