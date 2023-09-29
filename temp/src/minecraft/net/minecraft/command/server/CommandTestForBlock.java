package net.minecraft.command.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class CommandTestForBlock extends CommandBase {

   private static final String __OBFID = "CL_00001181";


   public String func_71517_b() {
      return "testforblock";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.testforblock.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 4) {
         throw new WrongUsageException("commands.testforblock.usage", new Object[0]);
      } else {
         p_71515_1_.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
         BlockPos var3 = func_175757_a(p_71515_1_, p_71515_2_, 0, false);
         Block var4 = Block.func_149684_b(p_71515_2_[3]);
         if(var4 == null) {
            throw new NumberInvalidException("commands.setblock.notFound", new Object[]{p_71515_2_[3]});
         } else {
            int var5 = -1;
            if(p_71515_2_.length >= 5) {
               var5 = func_175764_a(p_71515_2_[4], -1, 15);
            }

            World var6 = p_71515_1_.func_130014_f_();
            if(!var6.func_175667_e(var3)) {
               throw new CommandException("commands.testforblock.outOfWorld", new Object[0]);
            } else {
               NBTTagCompound var7 = new NBTTagCompound();
               boolean var8 = false;
               if(p_71515_2_.length >= 6 && var4.func_149716_u()) {
                  String var9 = func_147178_a(p_71515_1_, p_71515_2_, 5).func_150260_c();

                  try {
                     var7 = JsonToNBT.func_180713_a(var9);
                     var8 = true;
                  } catch (NBTException var13) {
                     throw new CommandException("commands.setblock.tagError", new Object[]{var13.getMessage()});
                  }
               }

               IBlockState var14 = var6.func_180495_p(var3);
               Block var10 = var14.func_177230_c();
               if(var10 != var4) {
                  throw new CommandException("commands.testforblock.failed.tile", new Object[]{Integer.valueOf(var3.func_177958_n()), Integer.valueOf(var3.func_177956_o()), Integer.valueOf(var3.func_177952_p()), var10.func_149732_F(), var4.func_149732_F()});
               } else {
                  if(var5 > -1) {
                     int var11 = var14.func_177230_c().func_176201_c(var14);
                     if(var11 != var5) {
                        throw new CommandException("commands.testforblock.failed.data", new Object[]{Integer.valueOf(var3.func_177958_n()), Integer.valueOf(var3.func_177956_o()), Integer.valueOf(var3.func_177952_p()), Integer.valueOf(var11), Integer.valueOf(var5)});
                     }
                  }

                  if(var8) {
                     TileEntity var15 = var6.func_175625_s(var3);
                     if(var15 == null) {
                        throw new CommandException("commands.testforblock.failed.tileEntity", new Object[]{Integer.valueOf(var3.func_177958_n()), Integer.valueOf(var3.func_177956_o()), Integer.valueOf(var3.func_177952_p())});
                     }

                     NBTTagCompound var12 = new NBTTagCompound();
                     var15.func_145841_b(var12);
                     if(!func_175775_a(var7, var12, true)) {
                        throw new CommandException("commands.testforblock.failed.nbt", new Object[]{Integer.valueOf(var3.func_177958_n()), Integer.valueOf(var3.func_177956_o()), Integer.valueOf(var3.func_177952_p())});
                     }
                  }

                  p_71515_1_.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, 1);
                  func_152373_a(p_71515_1_, this, "commands.testforblock.success", new Object[]{Integer.valueOf(var3.func_177958_n()), Integer.valueOf(var3.func_177956_o()), Integer.valueOf(var3.func_177952_p())});
               }
            }
         }
      }
   }

   public static boolean func_175775_a(NBTBase p_175775_0_, NBTBase p_175775_1_, boolean p_175775_2_) {
      if(p_175775_0_ == p_175775_1_) {
         return true;
      } else if(p_175775_0_ == null) {
         return true;
      } else if(p_175775_1_ == null) {
         return false;
      } else if(!p_175775_0_.getClass().equals(p_175775_1_.getClass())) {
         return false;
      } else if(p_175775_0_ instanceof NBTTagCompound) {
         NBTTagCompound var9 = (NBTTagCompound)p_175775_0_;
         NBTTagCompound var10 = (NBTTagCompound)p_175775_1_;
         Iterator var11 = var9.func_150296_c().iterator();

         String var12;
         NBTBase var13;
         do {
            if(!var11.hasNext()) {
               return true;
            }

            var12 = (String)var11.next();
            var13 = var9.func_74781_a(var12);
         } while(func_175775_a(var13, var10.func_74781_a(var12), p_175775_2_));

         return false;
      } else if(p_175775_0_ instanceof NBTTagList && p_175775_2_) {
         NBTTagList var3 = (NBTTagList)p_175775_0_;
         NBTTagList var4 = (NBTTagList)p_175775_1_;
         if(var3.func_74745_c() == 0) {
            return var4.func_74745_c() == 0;
         } else {
            int var5 = 0;

            while(var5 < var3.func_74745_c()) {
               NBTBase var6 = var3.func_179238_g(var5);
               boolean var7 = false;
               int var8 = 0;

               while(true) {
                  if(var8 < var4.func_74745_c()) {
                     if(!func_175775_a(var6, var4.func_179238_g(var8), p_175775_2_)) {
                        ++var8;
                        continue;
                     }

                     var7 = true;
                  }

                  if(!var7) {
                     return false;
                  }

                  ++var5;
                  break;
               }
            }

            return true;
         }
      } else {
         return p_175775_0_.equals(p_175775_1_);
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length > 0 && p_180525_2_.length <= 3?func_175771_a(p_180525_2_, 0, p_180525_3_):(p_180525_2_.length == 4?func_175762_a(p_180525_2_, Block.field_149771_c.func_148742_b()):null);
   }
}
