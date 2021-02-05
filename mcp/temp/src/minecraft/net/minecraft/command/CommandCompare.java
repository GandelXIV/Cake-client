package net.minecraft.command;

import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class CommandCompare extends CommandBase {

   private static final String __OBFID = "CL_00002346";


   public String func_71517_b() {
      return "testforblocks";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.compare.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 9) {
         throw new WrongUsageException("commands.compare.usage", new Object[0]);
      } else {
         p_71515_1_.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
         BlockPos var3 = func_175757_a(p_71515_1_, p_71515_2_, 0, false);
         BlockPos var4 = func_175757_a(p_71515_1_, p_71515_2_, 3, false);
         BlockPos var5 = func_175757_a(p_71515_1_, p_71515_2_, 6, false);
         StructureBoundingBox var6 = new StructureBoundingBox(var3, var4);
         StructureBoundingBox var7 = new StructureBoundingBox(var5, var5.func_177971_a(var6.func_175896_b()));
         int var8 = var6.func_78883_b() * var6.func_78882_c() * var6.func_78880_d();
         if(var8 > 524288) {
            throw new CommandException("commands.compare.tooManyBlocks", new Object[]{Integer.valueOf(var8), Integer.valueOf(524288)});
         } else if(var6.field_78895_b >= 0 && var6.field_78894_e < 256 && var7.field_78895_b >= 0 && var7.field_78894_e < 256) {
            World var9 = p_71515_1_.func_130014_f_();
            if(var9.func_175711_a(var6) && var9.func_175711_a(var7)) {
               boolean var10 = false;
               if(p_71515_2_.length > 9 && p_71515_2_[9].equals("masked")) {
                  var10 = true;
               }

               var8 = 0;
               BlockPos var11 = new BlockPos(var7.field_78897_a - var6.field_78897_a, var7.field_78895_b - var6.field_78895_b, var7.field_78896_c - var6.field_78896_c);

               for(int var12 = var6.field_78896_c; var12 <= var6.field_78892_f; ++var12) {
                  for(int var13 = var6.field_78895_b; var13 <= var6.field_78894_e; ++var13) {
                     for(int var14 = var6.field_78897_a; var14 <= var6.field_78893_d; ++var14) {
                        BlockPos var15 = new BlockPos(var14, var13, var12);
                        BlockPos var16 = var15.func_177971_a(var11);
                        boolean var17 = false;
                        IBlockState var18 = var9.func_180495_p(var15);
                        if(!var10 || var18.func_177230_c() != Blocks.field_150350_a) {
                           if(var18 == var9.func_180495_p(var16)) {
                              TileEntity var19 = var9.func_175625_s(var15);
                              TileEntity var20 = var9.func_175625_s(var16);
                              if(var19 != null && var20 != null) {
                                 NBTTagCompound var21 = new NBTTagCompound();
                                 var19.func_145841_b(var21);
                                 var21.func_82580_o("x");
                                 var21.func_82580_o("y");
                                 var21.func_82580_o("z");
                                 NBTTagCompound var22 = new NBTTagCompound();
                                 var20.func_145841_b(var22);
                                 var22.func_82580_o("x");
                                 var22.func_82580_o("y");
                                 var22.func_82580_o("z");
                                 if(!var21.equals(var22)) {
                                    var17 = true;
                                 }
                              } else if(var19 != null) {
                                 var17 = true;
                              }
                           } else {
                              var17 = true;
                           }

                           ++var8;
                           if(var17) {
                              throw new CommandException("commands.compare.failed", new Object[0]);
                           }
                        }
                     }
                  }
               }

               p_71515_1_.func_174794_a(CommandResultStats.Type.AFFECTED_BLOCKS, var8);
               func_152373_a(p_71515_1_, this, "commands.compare.success", new Object[]{Integer.valueOf(var8)});
            } else {
               throw new CommandException("commands.compare.outOfWorld", new Object[0]);
            }
         } else {
            throw new CommandException("commands.compare.outOfWorld", new Object[0]);
         }
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length > 0 && p_180525_2_.length <= 3?func_175771_a(p_180525_2_, 0, p_180525_3_):(p_180525_2_.length > 3 && p_180525_2_.length <= 6?func_175771_a(p_180525_2_, 3, p_180525_3_):(p_180525_2_.length > 6 && p_180525_2_.length <= 9?func_175771_a(p_180525_2_, 6, p_180525_3_):(p_180525_2_.length == 10?func_71530_a(p_180525_2_, new String[]{"masked", "all"}):null)));
   }
}
