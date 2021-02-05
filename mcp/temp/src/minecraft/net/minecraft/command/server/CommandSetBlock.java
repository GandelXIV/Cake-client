package net.minecraft.command.server;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class CommandSetBlock extends CommandBase {

   private static final String __OBFID = "CL_00000949";


   public String func_71517_b() {
      return "setblock";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.setblock.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 4) {
         throw new WrongUsageException("commands.setblock.usage", new Object[0]);
      } else {
         p_71515_1_.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
         BlockPos var3 = func_175757_a(p_71515_1_, p_71515_2_, 0, false);
         Block var4 = CommandBase.func_147180_g(p_71515_1_, p_71515_2_[3]);
         int var5 = 0;
         if(p_71515_2_.length >= 5) {
            var5 = func_175764_a(p_71515_2_[4], 0, 15);
         }

         World var6 = p_71515_1_.func_130014_f_();
         if(!var6.func_175667_e(var3)) {
            throw new CommandException("commands.setblock.outOfWorld", new Object[0]);
         } else {
            NBTTagCompound var7 = new NBTTagCompound();
            boolean var8 = false;
            if(p_71515_2_.length >= 7 && var4.func_149716_u()) {
               String var9 = func_147178_a(p_71515_1_, p_71515_2_, 6).func_150260_c();

               try {
                  var7 = JsonToNBT.func_180713_a(var9);
                  var8 = true;
               } catch (NBTException var12) {
                  throw new CommandException("commands.setblock.tagError", new Object[]{var12.getMessage()});
               }
            }

            if(p_71515_2_.length >= 6) {
               if(p_71515_2_[5].equals("destroy")) {
                  var6.func_175655_b(var3, true);
                  if(var4 == Blocks.field_150350_a) {
                     func_152373_a(p_71515_1_, this, "commands.setblock.success", new Object[0]);
                     return;
                  }
               } else if(p_71515_2_[5].equals("keep") && !var6.func_175623_d(var3)) {
                  throw new CommandException("commands.setblock.noChange", new Object[0]);
               }
            }

            TileEntity var13 = var6.func_175625_s(var3);
            if(var13 != null) {
               if(var13 instanceof IInventory) {
                  ((IInventory)var13).func_174888_l();
               }

               var6.func_180501_a(var3, Blocks.field_150350_a.func_176223_P(), var4 == Blocks.field_150350_a?2:4);
            }

            IBlockState var10 = var4.func_176203_a(var5);
            if(!var6.func_180501_a(var3, var10, 2)) {
               throw new CommandException("commands.setblock.noChange", new Object[0]);
            } else {
               if(var8) {
                  TileEntity var11 = var6.func_175625_s(var3);
                  if(var11 != null) {
                     var7.func_74768_a("x", var3.func_177958_n());
                     var7.func_74768_a("y", var3.func_177956_o());
                     var7.func_74768_a("z", var3.func_177952_p());
                     var11.func_145839_a(var7);
                  }
               }

               var6.func_175722_b(var3, var10.func_177230_c());
               p_71515_1_.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, 1);
               func_152373_a(p_71515_1_, this, "commands.setblock.success", new Object[0]);
            }
         }
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length > 0 && p_180525_2_.length <= 3?func_175771_a(p_180525_2_, 0, p_180525_3_):(p_180525_2_.length == 4?func_175762_a(p_180525_2_, Block.field_149771_c.func_148742_b()):(p_180525_2_.length == 6?func_71530_a(p_180525_2_, new String[]{"replace", "destroy", "keep"}):null));
   }
}
