package net.minecraft.command;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.NextTickListEntry;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class CommandClone extends CommandBase {

   private static final String __OBFID = "CL_00002348";


   public String func_71517_b() {
      return "clone";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.clone.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 9) {
         throw new WrongUsageException("commands.clone.usage", new Object[0]);
      } else {
         p_71515_1_.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
         BlockPos var3 = func_175757_a(p_71515_1_, p_71515_2_, 0, false);
         BlockPos var4 = func_175757_a(p_71515_1_, p_71515_2_, 3, false);
         BlockPos var5 = func_175757_a(p_71515_1_, p_71515_2_, 6, false);
         StructureBoundingBox var6 = new StructureBoundingBox(var3, var4);
         StructureBoundingBox var7 = new StructureBoundingBox(var5, var5.func_177971_a(var6.func_175896_b()));
         int var8 = var6.func_78883_b() * var6.func_78882_c() * var6.func_78880_d();
         if(var8 > '\u8000') {
            throw new CommandException("commands.clone.tooManyBlocks", new Object[]{Integer.valueOf(var8), Integer.valueOf('\u8000')});
         } else {
            boolean var9 = false;
            Block var10 = null;
            int var11 = -1;
            if((p_71515_2_.length < 11 || !p_71515_2_[10].equals("force") && !p_71515_2_[10].equals("move")) && var6.func_78884_a(var7)) {
               throw new CommandException("commands.clone.noOverlap", new Object[0]);
            } else {
               if(p_71515_2_.length >= 11 && p_71515_2_[10].equals("move")) {
                  var9 = true;
               }

               if(var6.field_78895_b >= 0 && var6.field_78894_e < 256 && var7.field_78895_b >= 0 && var7.field_78894_e < 256) {
                  World var12 = p_71515_1_.func_130014_f_();
                  if(var12.func_175711_a(var6) && var12.func_175711_a(var7)) {
                     boolean var13 = false;
                     if(p_71515_2_.length >= 10) {
                        if(p_71515_2_[9].equals("masked")) {
                           var13 = true;
                        } else if(p_71515_2_[9].equals("filtered")) {
                           if(p_71515_2_.length < 12) {
                              throw new WrongUsageException("commands.clone.usage", new Object[0]);
                           }

                           var10 = func_147180_g(p_71515_1_, p_71515_2_[11]);
                           if(p_71515_2_.length >= 13) {
                              var11 = func_175764_a(p_71515_2_[12], 0, 15);
                           }
                        }
                     }

                     ArrayList var14 = Lists.newArrayList();
                     ArrayList var15 = Lists.newArrayList();
                     ArrayList var16 = Lists.newArrayList();
                     LinkedList var17 = Lists.newLinkedList();
                     BlockPos var18 = new BlockPos(var7.field_78897_a - var6.field_78897_a, var7.field_78895_b - var6.field_78895_b, var7.field_78896_c - var6.field_78896_c);

                     for(int var19 = var6.field_78896_c; var19 <= var6.field_78892_f; ++var19) {
                        for(int var20 = var6.field_78895_b; var20 <= var6.field_78894_e; ++var20) {
                           for(int var21 = var6.field_78897_a; var21 <= var6.field_78893_d; ++var21) {
                              BlockPos var22 = new BlockPos(var21, var20, var19);
                              BlockPos var23 = var22.func_177971_a(var18);
                              IBlockState var24 = var12.func_180495_p(var22);
                              if((!var13 || var24.func_177230_c() != Blocks.field_150350_a) && (var10 == null || var24.func_177230_c() == var10 && (var11 < 0 || var24.func_177230_c().func_176201_c(var24) == var11))) {
                                 TileEntity var25 = var12.func_175625_s(var22);
                                 if(var25 != null) {
                                    NBTTagCompound var26 = new NBTTagCompound();
                                    var25.func_145841_b(var26);
                                    var15.add(new CommandClone.StaticCloneData(var23, var24, var26));
                                    var17.addLast(var22);
                                 } else if(!var24.func_177230_c().func_149730_j() && !var24.func_177230_c().func_149686_d()) {
                                    var16.add(new CommandClone.StaticCloneData(var23, var24, (NBTTagCompound)null));
                                    var17.addFirst(var22);
                                 } else {
                                    var14.add(new CommandClone.StaticCloneData(var23, var24, (NBTTagCompound)null));
                                    var17.addLast(var22);
                                 }
                              }
                           }
                        }
                     }

                     if(var9) {
                        Iterator var27;
                        BlockPos var29;
                        for(var27 = var17.iterator(); var27.hasNext(); var12.func_180501_a(var29, Blocks.field_180401_cv.func_176223_P(), 2)) {
                           var29 = (BlockPos)var27.next();
                           TileEntity var31 = var12.func_175625_s(var29);
                           if(var31 instanceof IInventory) {
                              ((IInventory)var31).func_174888_l();
                           }
                        }

                        var27 = var17.iterator();

                        while(var27.hasNext()) {
                           var29 = (BlockPos)var27.next();
                           var12.func_180501_a(var29, Blocks.field_150350_a.func_176223_P(), 3);
                        }
                     }

                     ArrayList var28 = Lists.newArrayList();
                     var28.addAll(var14);
                     var28.addAll(var15);
                     var28.addAll(var16);
                     List var30 = Lists.reverse(var28);

                     Iterator var32;
                     CommandClone.StaticCloneData var34;
                     TileEntity var36;
                     for(var32 = var30.iterator(); var32.hasNext(); var12.func_180501_a(var34.field_179537_a, Blocks.field_180401_cv.func_176223_P(), 2)) {
                        var34 = (CommandClone.StaticCloneData)var32.next();
                        var36 = var12.func_175625_s(var34.field_179537_a);
                        if(var36 instanceof IInventory) {
                           ((IInventory)var36).func_174888_l();
                        }
                     }

                     var8 = 0;
                     var32 = var28.iterator();

                     while(var32.hasNext()) {
                        var34 = (CommandClone.StaticCloneData)var32.next();
                        if(var12.func_180501_a(var34.field_179537_a, var34.field_179535_b, 2)) {
                           ++var8;
                        }
                     }

                     for(var32 = var15.iterator(); var32.hasNext(); var12.func_180501_a(var34.field_179537_a, var34.field_179535_b, 2)) {
                        var34 = (CommandClone.StaticCloneData)var32.next();
                        var36 = var12.func_175625_s(var34.field_179537_a);
                        if(var34.field_179536_c != null && var36 != null) {
                           var34.field_179536_c.func_74768_a("x", var34.field_179537_a.func_177958_n());
                           var34.field_179536_c.func_74768_a("y", var34.field_179537_a.func_177956_o());
                           var34.field_179536_c.func_74768_a("z", var34.field_179537_a.func_177952_p());
                           var36.func_145839_a(var34.field_179536_c);
                           var36.func_70296_d();
                        }
                     }

                     var32 = var30.iterator();

                     while(var32.hasNext()) {
                        var34 = (CommandClone.StaticCloneData)var32.next();
                        var12.func_175722_b(var34.field_179537_a, var34.field_179535_b.func_177230_c());
                     }

                     List var33 = var12.func_175712_a(var6, false);
                     if(var33 != null) {
                        Iterator var35 = var33.iterator();

                        while(var35.hasNext()) {
                           NextTickListEntry var37 = (NextTickListEntry)var35.next();
                           if(var6.func_175898_b(var37.field_180282_a)) {
                              BlockPos var38 = var37.field_180282_a.func_177971_a(var18);
                              var12.func_180497_b(var38, var37.func_151351_a(), (int)(var37.field_77180_e - var12.func_72912_H().func_82573_f()), var37.field_82754_f);
                           }
                        }
                     }

                     if(var8 <= 0) {
                        throw new CommandException("commands.clone.failed", new Object[0]);
                     } else {
                        p_71515_1_.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, var8);
                        func_152373_a(p_71515_1_, this, "commands.clone.success", new Object[]{Integer.valueOf(var8)});
                     }
                  } else {
                     throw new CommandException("commands.clone.outOfWorld", new Object[0]);
                  }
               } else {
                  throw new CommandException("commands.clone.outOfWorld", new Object[0]);
               }
            }
         }
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length > 0 && p_180525_2_.length <= 3?func_175771_a(p_180525_2_, 0, p_180525_3_):(p_180525_2_.length > 3 && p_180525_2_.length <= 6?func_175771_a(p_180525_2_, 3, p_180525_3_):(p_180525_2_.length > 6 && p_180525_2_.length <= 9?func_175771_a(p_180525_2_, 6, p_180525_3_):(p_180525_2_.length == 10?func_71530_a(p_180525_2_, new String[]{"replace", "masked", "filtered"}):(p_180525_2_.length == 11?func_71530_a(p_180525_2_, new String[]{"normal", "force", "move"}):(p_180525_2_.length == 12 && "filtered".equals(p_180525_2_[9])?func_175762_a(p_180525_2_, Block.field_149771_c.func_148742_b()):null)))));
   }

   static class StaticCloneData {

      public final BlockPos field_179537_a;
      public final IBlockState field_179535_b;
      public final NBTTagCompound field_179536_c;
      private static final String __OBFID = "CL_00002347";


      public StaticCloneData(BlockPos p_i46037_1_, IBlockState p_i46037_2_, NBTTagCompound p_i46037_3_) {
         this.field_179537_a = p_i46037_1_;
         this.field_179535_b = p_i46037_2_;
         this.field_179536_c = p_i46037_3_;
      }
   }
}
