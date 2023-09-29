package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.border.WorldBorder;

public class CommandWorldBorder extends CommandBase {

   private static final String __OBFID = "CL_00002336";


   public String func_71517_b() {
      return "worldborder";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.worldborder.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 1) {
         throw new WrongUsageException("commands.worldborder.usage", new Object[0]);
      } else {
         WorldBorder var3 = this.func_175772_d();
         double var4;
         double var6;
         long var8;
         if(p_71515_2_[0].equals("set")) {
            if(p_71515_2_.length != 2 && p_71515_2_.length != 3) {
               throw new WrongUsageException("commands.worldborder.set.usage", new Object[0]);
            }

            var4 = var3.func_177751_j();
            var6 = func_175756_a(p_71515_2_[1], 1.0D, 6.0E7D);
            var8 = p_71515_2_.length > 2?func_175760_a(p_71515_2_[2], 0L, 9223372036854775L) * 1000L:0L;
            if(var8 > 0L) {
               var3.func_177738_a(var4, var6, var8);
               if(var4 > var6) {
                  func_152373_a(p_71515_1_, this, "commands.worldborder.setSlowly.shrink.success", new Object[]{String.format("%.1f", new Object[]{Double.valueOf(var6)}), String.format("%.1f", new Object[]{Double.valueOf(var4)}), Long.toString(var8 / 1000L)});
               } else {
                  func_152373_a(p_71515_1_, this, "commands.worldborder.setSlowly.grow.success", new Object[]{String.format("%.1f", new Object[]{Double.valueOf(var6)}), String.format("%.1f", new Object[]{Double.valueOf(var4)}), Long.toString(var8 / 1000L)});
               }
            } else {
               var3.func_177750_a(var6);
               func_152373_a(p_71515_1_, this, "commands.worldborder.set.success", new Object[]{String.format("%.1f", new Object[]{Double.valueOf(var6)}), String.format("%.1f", new Object[]{Double.valueOf(var4)})});
            }
         } else if(p_71515_2_[0].equals("add")) {
            if(p_71515_2_.length != 2 && p_71515_2_.length != 3) {
               throw new WrongUsageException("commands.worldborder.add.usage", new Object[0]);
            }

            var4 = var3.func_177741_h();
            var6 = var4 + func_175756_a(p_71515_2_[1], -var4, 6.0E7D - var4);
            var8 = var3.func_177732_i() + (p_71515_2_.length > 2?func_175760_a(p_71515_2_[2], 0L, 9223372036854775L) * 1000L:0L);
            if(var8 > 0L) {
               var3.func_177738_a(var4, var6, var8);
               if(var4 > var6) {
                  func_152373_a(p_71515_1_, this, "commands.worldborder.setSlowly.shrink.success", new Object[]{String.format("%.1f", new Object[]{Double.valueOf(var6)}), String.format("%.1f", new Object[]{Double.valueOf(var4)}), Long.toString(var8 / 1000L)});
               } else {
                  func_152373_a(p_71515_1_, this, "commands.worldborder.setSlowly.grow.success", new Object[]{String.format("%.1f", new Object[]{Double.valueOf(var6)}), String.format("%.1f", new Object[]{Double.valueOf(var4)}), Long.toString(var8 / 1000L)});
               }
            } else {
               var3.func_177750_a(var6);
               func_152373_a(p_71515_1_, this, "commands.worldborder.set.success", new Object[]{String.format("%.1f", new Object[]{Double.valueOf(var6)}), String.format("%.1f", new Object[]{Double.valueOf(var4)})});
            }
         } else if(p_71515_2_[0].equals("center")) {
            if(p_71515_2_.length != 3) {
               throw new WrongUsageException("commands.worldborder.center.usage", new Object[0]);
            }

            BlockPos var10 = p_71515_1_.func_180425_c();
            double var5 = func_175761_b((double)var10.func_177958_n() + 0.5D, p_71515_2_[1], true);
            double var7 = func_175761_b((double)var10.func_177952_p() + 0.5D, p_71515_2_[2], true);
            var3.func_177739_c(var5, var7);
            func_152373_a(p_71515_1_, this, "commands.worldborder.center.success", new Object[]{Double.valueOf(var5), Double.valueOf(var7)});
         } else if(p_71515_2_[0].equals("damage")) {
            if(p_71515_2_.length < 2) {
               throw new WrongUsageException("commands.worldborder.damage.usage", new Object[0]);
            }

            if(p_71515_2_[1].equals("buffer")) {
               if(p_71515_2_.length != 3) {
                  throw new WrongUsageException("commands.worldborder.damage.buffer.usage", new Object[0]);
               }

               var4 = func_180526_a(p_71515_2_[2], 0.0D);
               var6 = var3.func_177742_m();
               var3.func_177724_b(var4);
               func_152373_a(p_71515_1_, this, "commands.worldborder.damage.buffer.success", new Object[]{String.format("%.1f", new Object[]{Double.valueOf(var4)}), String.format("%.1f", new Object[]{Double.valueOf(var6)})});
            } else if(p_71515_2_[1].equals("amount")) {
               if(p_71515_2_.length != 3) {
                  throw new WrongUsageException("commands.worldborder.damage.amount.usage", new Object[0]);
               }

               var4 = func_180526_a(p_71515_2_[2], 0.0D);
               var6 = var3.func_177727_n();
               var3.func_177744_c(var4);
               func_152373_a(p_71515_1_, this, "commands.worldborder.damage.amount.success", new Object[]{String.format("%.2f", new Object[]{Double.valueOf(var4)}), String.format("%.2f", new Object[]{Double.valueOf(var6)})});
            }
         } else if(p_71515_2_[0].equals("warning")) {
            if(p_71515_2_.length < 2) {
               throw new WrongUsageException("commands.worldborder.warning.usage", new Object[0]);
            }

            int var11 = func_180528_a(p_71515_2_[2], 0);
            int var12;
            if(p_71515_2_[1].equals("time")) {
               if(p_71515_2_.length != 3) {
                  throw new WrongUsageException("commands.worldborder.warning.time.usage", new Object[0]);
               }

               var12 = var3.func_177740_p();
               var3.func_177723_b(var11);
               func_152373_a(p_71515_1_, this, "commands.worldborder.warning.time.success", new Object[]{Integer.valueOf(var11), Integer.valueOf(var12)});
            } else if(p_71515_2_[1].equals("distance")) {
               if(p_71515_2_.length != 3) {
                  throw new WrongUsageException("commands.worldborder.warning.distance.usage", new Object[0]);
               }

               var12 = var3.func_177748_q();
               var3.func_177747_c(var11);
               func_152373_a(p_71515_1_, this, "commands.worldborder.warning.distance.success", new Object[]{Integer.valueOf(var11), Integer.valueOf(var12)});
            }
         } else if(p_71515_2_[0].equals("get")) {
            var4 = var3.func_177741_h();
            p_71515_1_.func_174794_a(CommandResultStats.Type.QUERY_RESULT, MathHelper.func_76128_c(var4 + 0.5D));
            p_71515_1_.func_145747_a(new ChatComponentTranslation("commands.worldborder.get.success", new Object[]{String.format("%.0f", new Object[]{Double.valueOf(var4)})}));
         }

      }
   }

   protected WorldBorder func_175772_d() {
      return MinecraftServer.func_71276_C().field_71305_c[0].func_175723_af();
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length == 1?func_71530_a(p_180525_2_, new String[]{"set", "center", "damage", "warning", "add", "get"}):(p_180525_2_.length == 2 && p_180525_2_[0].equals("damage")?func_71530_a(p_180525_2_, new String[]{"buffer", "amount"}):(p_180525_2_.length == 2 && p_180525_2_[0].equals("warning")?func_71530_a(p_180525_2_, new String[]{"time", "distance"}):null));
   }
}
