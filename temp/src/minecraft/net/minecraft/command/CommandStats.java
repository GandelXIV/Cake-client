package net.minecraft.command;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class CommandStats extends CommandBase {

   private static final String __OBFID = "CL_00002339";


   public String func_71517_b() {
      return "stats";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.stats.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 1) {
         throw new WrongUsageException("commands.stats.usage", new Object[0]);
      } else {
         boolean var3;
         if(p_71515_2_[0].equals("entity")) {
            var3 = false;
         } else {
            if(!p_71515_2_[0].equals("block")) {
               throw new WrongUsageException("commands.stats.usage", new Object[0]);
            }

            var3 = true;
         }

         byte var4;
         if(var3) {
            if(p_71515_2_.length < 5) {
               throw new WrongUsageException("commands.stats.block.usage", new Object[0]);
            }

            var4 = 4;
         } else {
            if(p_71515_2_.length < 3) {
               throw new WrongUsageException("commands.stats.entity.usage", new Object[0]);
            }

            var4 = 2;
         }

         int var11 = var4 + 1;
         String var5 = p_71515_2_[var4];
         if("set".equals(var5)) {
            if(p_71515_2_.length < var11 + 3) {
               if(var11 == 5) {
                  throw new WrongUsageException("commands.stats.block.set.usage", new Object[0]);
               }

               throw new WrongUsageException("commands.stats.entity.set.usage", new Object[0]);
            }
         } else {
            if(!"clear".equals(var5)) {
               throw new WrongUsageException("commands.stats.usage", new Object[0]);
            }

            if(p_71515_2_.length < var11 + 1) {
               if(var11 == 5) {
                  throw new WrongUsageException("commands.stats.block.clear.usage", new Object[0]);
               }

               throw new WrongUsageException("commands.stats.entity.clear.usage", new Object[0]);
            }
         }

         CommandResultStats.Type var6 = CommandResultStats.Type.func_179635_a(p_71515_2_[var11++]);
         if(var6 == null) {
            throw new CommandException("commands.stats.failed", new Object[0]);
         } else {
            World var7 = p_71515_1_.func_130014_f_();
            CommandResultStats var8;
            BlockPos var9;
            TileEntity var10;
            if(var3) {
               var9 = func_175757_a(p_71515_1_, p_71515_2_, 1, false);
               var10 = var7.func_175625_s(var9);
               if(var10 == null) {
                  throw new CommandException("commands.stats.noCompatibleBlock", new Object[]{Integer.valueOf(var9.func_177958_n()), Integer.valueOf(var9.func_177956_o()), Integer.valueOf(var9.func_177952_p())});
               }

               if(var10 instanceof TileEntityCommandBlock) {
                  var8 = ((TileEntityCommandBlock)var10).func_175124_c();
               } else {
                  if(!(var10 instanceof TileEntitySign)) {
                     throw new CommandException("commands.stats.noCompatibleBlock", new Object[]{Integer.valueOf(var9.func_177958_n()), Integer.valueOf(var9.func_177956_o()), Integer.valueOf(var9.func_177952_p())});
                  }

                  var8 = ((TileEntitySign)var10).func_174880_d();
               }
            } else {
               Entity var12 = func_175768_b(p_71515_1_, p_71515_2_[1]);
               var8 = var12.func_174807_aT();
            }

            if("set".equals(var5)) {
               String var13 = p_71515_2_[var11++];
               String var14 = p_71515_2_[var11];
               if(var13.length() == 0 || var14.length() == 0) {
                  throw new CommandException("commands.stats.failed", new Object[0]);
               }

               CommandResultStats.func_179667_a(var8, var6, var13, var14);
               func_152373_a(p_71515_1_, this, "commands.stats.success", new Object[]{var6.func_179637_b(), var14, var13});
            } else if("clear".equals(var5)) {
               CommandResultStats.func_179667_a(var8, var6, (String)null, (String)null);
               func_152373_a(p_71515_1_, this, "commands.stats.cleared", new Object[]{var6.func_179637_b()});
            }

            if(var3) {
               var9 = func_175757_a(p_71515_1_, p_71515_2_, 1, false);
               var10 = var7.func_175625_s(var9);
               var10.func_70296_d();
            }

         }
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length == 1?func_71530_a(p_180525_2_, new String[]{"entity", "block"}):(p_180525_2_.length == 2 && p_180525_2_[0].equals("entity")?func_71530_a(p_180525_2_, this.func_175776_d()):((p_180525_2_.length != 3 || !p_180525_2_[0].equals("entity")) && (p_180525_2_.length != 5 || !p_180525_2_[0].equals("block"))?((p_180525_2_.length != 4 || !p_180525_2_[0].equals("entity")) && (p_180525_2_.length != 6 || !p_180525_2_[0].equals("block"))?((p_180525_2_.length != 6 || !p_180525_2_[0].equals("entity")) && (p_180525_2_.length != 8 || !p_180525_2_[0].equals("block"))?null:func_175762_a(p_180525_2_, this.func_175777_e())):func_71530_a(p_180525_2_, CommandResultStats.Type.func_179634_c())):func_71530_a(p_180525_2_, new String[]{"set", "clear"})));
   }

   protected String[] func_175776_d() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }

   protected List func_175777_e() {
      Collection var1 = MinecraftServer.func_71276_C().func_71218_a(0).func_96441_U().func_96514_c();
      ArrayList var2 = Lists.newArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         ScoreObjective var4 = (ScoreObjective)var3.next();
         if(!var4.func_96680_c().func_96637_b()) {
            var2.add(var4.func_96679_b());
         }
      }

      return var2;
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_1_.length > 0 && p_82358_1_[0].equals("entity") && p_82358_2_ == 1;
   }
}
