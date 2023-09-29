package net.minecraft.command;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
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

public class CommandFill extends CommandBase {

   private static final String __OBFID = "CL_00002342";


   public String func_71517_b() {
      return "fill";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.fill.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 7) {
         throw new WrongUsageException("commands.fill.usage", new Object[0]);
      } else {
         p_71515_1_.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
         BlockPos var3 = func_175757_a(p_71515_1_, p_71515_2_, 0, false);
         BlockPos var4 = func_175757_a(p_71515_1_, p_71515_2_, 3, false);
         Block var5 = CommandBase.func_147180_g(p_71515_1_, p_71515_2_[6]);
         int var6 = 0;
         if(p_71515_2_.length >= 8) {
            var6 = func_175764_a(p_71515_2_[7], 0, 15);
         }

         BlockPos var7 = new BlockPos(Math.min(var3.func_177958_n(), var4.func_177958_n()), Math.min(var3.func_177956_o(), var4.func_177956_o()), Math.min(var3.func_177952_p(), var4.func_177952_p()));
         BlockPos var8 = new BlockPos(Math.max(var3.func_177958_n(), var4.func_177958_n()), Math.max(var3.func_177956_o(), var4.func_177956_o()), Math.max(var3.func_177952_p(), var4.func_177952_p()));
         int var9 = (var8.func_177958_n() - var7.func_177958_n() + 1) * (var8.func_177956_o() - var7.func_177956_o() + 1) * (var8.func_177952_p() - var7.func_177952_p() + 1);
         if(var9 > '\u8000') {
            throw new CommandException("commands.fill.tooManyBlocks", new Object[]{Integer.valueOf(var9), Integer.valueOf('\u8000')});
         } else if(var7.func_177956_o() >= 0 && var8.func_177956_o() < 256) {
            World var10 = p_71515_1_.func_130014_f_();

            for(int var11 = var7.func_177952_p(); var11 < var8.func_177952_p() + 16; var11 += 16) {
               for(int var12 = var7.func_177958_n(); var12 < var8.func_177958_n() + 16; var12 += 16) {
                  if(!var10.func_175667_e(new BlockPos(var12, var8.func_177956_o() - var7.func_177956_o(), var11))) {
                     throw new CommandException("commands.fill.outOfWorld", new Object[0]);
                  }
               }
            }

            NBTTagCompound var22 = new NBTTagCompound();
            boolean var23 = false;
            if(p_71515_2_.length >= 10 && var5.func_149716_u()) {
               String var13 = func_147178_a(p_71515_1_, p_71515_2_, 9).func_150260_c();

               try {
                  var22 = JsonToNBT.func_180713_a(var13);
                  var23 = true;
               } catch (NBTException var21) {
                  throw new CommandException("commands.fill.tagError", new Object[]{var21.getMessage()});
               }
            }

            ArrayList var24 = Lists.newArrayList();
            var9 = 0;

            for(int var14 = var7.func_177952_p(); var14 <= var8.func_177952_p(); ++var14) {
               for(int var15 = var7.func_177956_o(); var15 <= var8.func_177956_o(); ++var15) {
                  for(int var16 = var7.func_177958_n(); var16 <= var8.func_177958_n(); ++var16) {
                     BlockPos var17 = new BlockPos(var16, var15, var14);
                     IBlockState var19;
                     if(p_71515_2_.length >= 9) {
                        if(!p_71515_2_[8].equals("outline") && !p_71515_2_[8].equals("hollow")) {
                           if(p_71515_2_[8].equals("destroy")) {
                              var10.func_175655_b(var17, true);
                           } else if(p_71515_2_[8].equals("keep")) {
                              if(!var10.func_175623_d(var17)) {
                                 continue;
                              }
                           } else if(p_71515_2_[8].equals("replace") && !var5.func_149716_u()) {
                              if(p_71515_2_.length > 9) {
                                 Block var18 = CommandBase.func_147180_g(p_71515_1_, p_71515_2_[9]);
                                 if(var10.func_180495_p(var17).func_177230_c() != var18) {
                                    continue;
                                 }
                              }

                              if(p_71515_2_.length > 10) {
                                 int var28 = CommandBase.func_175755_a(p_71515_2_[10]);
                                 var19 = var10.func_180495_p(var17);
                                 if(var19.func_177230_c().func_176201_c(var19) != var28) {
                                    continue;
                                 }
                              }
                           }
                        } else if(var16 != var7.func_177958_n() && var16 != var8.func_177958_n() && var15 != var7.func_177956_o() && var15 != var8.func_177956_o() && var14 != var7.func_177952_p() && var14 != var8.func_177952_p()) {
                           if(p_71515_2_[8].equals("hollow")) {
                              var10.func_180501_a(var17, Blocks.field_150350_a.func_176223_P(), 2);
                              var24.add(var17);
                           }
                           continue;
                        }
                     }

                     TileEntity var29 = var10.func_175625_s(var17);
                     if(var29 != null) {
                        if(var29 instanceof IInventory) {
                           ((IInventory)var29).func_174888_l();
                        }

                        var10.func_180501_a(var17, Blocks.field_180401_cv.func_176223_P(), var5 == Blocks.field_180401_cv?2:4);
                     }

                     var19 = var5.func_176203_a(var6);
                     if(var10.func_180501_a(var17, var19, 2)) {
                        var24.add(var17);
                        ++var9;
                        if(var23) {
                           TileEntity var20 = var10.func_175625_s(var17);
                           if(var20 != null) {
                              var22.func_74768_a("x", var17.func_177958_n());
                              var22.func_74768_a("y", var17.func_177956_o());
                              var22.func_74768_a("z", var17.func_177952_p());
                              var20.func_145839_a(var22);
                           }
                        }
                     }
                  }
               }
            }

            Iterator var25 = var24.iterator();

            while(var25.hasNext()) {
               BlockPos var26 = (BlockPos)var25.next();
               Block var27 = var10.func_180495_p(var26).func_177230_c();
               var10.func_175722_b(var26, var27);
            }

            if(var9 <= 0) {
               throw new CommandException("commands.fill.failed", new Object[0]);
            } else {
               p_71515_1_.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, var9);
               func_152373_a(p_71515_1_, this, "commands.fill.success", new Object[]{Integer.valueOf(var9)});
            }
         } else {
            throw new CommandException("commands.fill.outOfWorld", new Object[0]);
         }
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length > 0 && p_180525_2_.length <= 3?func_175771_a(p_180525_2_, 0, p_180525_3_):(p_180525_2_.length > 3 && p_180525_2_.length <= 6?func_175771_a(p_180525_2_, 3, p_180525_3_):(p_180525_2_.length == 7?func_175762_a(p_180525_2_, Block.field_149771_c.func_148742_b()):(p_180525_2_.length == 9?func_71530_a(p_180525_2_, new String[]{"replace", "destroy", "keep", "hollow", "outline"}):null)));
   }
}
