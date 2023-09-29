package net.minecraft.command.common;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class CommandReplaceItem extends CommandBase {

   private static final Map field_175785_a = Maps.newHashMap();
   private static final String __OBFID = "CL_00002340";


   public String func_71517_b() {
      return "replaceitem";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.replaceitem.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 1) {
         throw new WrongUsageException("commands.replaceitem.usage", new Object[0]);
      } else {
         boolean var3;
         if(p_71515_2_[0].equals("entity")) {
            var3 = false;
         } else {
            if(!p_71515_2_[0].equals("block")) {
               throw new WrongUsageException("commands.replaceitem.usage", new Object[0]);
            }

            var3 = true;
         }

         byte var4;
         if(var3) {
            if(p_71515_2_.length < 6) {
               throw new WrongUsageException("commands.replaceitem.block.usage", new Object[0]);
            }

            var4 = 4;
         } else {
            if(p_71515_2_.length < 4) {
               throw new WrongUsageException("commands.replaceitem.entity.usage", new Object[0]);
            }

            var4 = 2;
         }

         int var16 = var4 + 1;
         int var5 = this.func_175783_e(p_71515_2_[var4]);

         Item var6;
         try {
            var6 = func_147179_f(p_71515_1_, p_71515_2_[var16]);
         } catch (NumberInvalidException var15) {
            if(Block.func_149684_b(p_71515_2_[var16]) != Blocks.field_150350_a) {
               throw var15;
            }

            var6 = null;
         }

         ++var16;
         int var7 = p_71515_2_.length > var16?func_175764_a(p_71515_2_[var16++], 1, 64):1;
         int var8 = p_71515_2_.length > var16?func_175755_a(p_71515_2_[var16++]):0;
         ItemStack var9 = new ItemStack(var6, var7, var8);
         if(p_71515_2_.length > var16) {
            String var10 = func_147178_a(p_71515_1_, p_71515_2_, var16).func_150260_c();

            try {
               var9.func_77982_d(JsonToNBT.func_180713_a(var10));
            } catch (NBTException var14) {
               throw new CommandException("commands.replaceitem.tagError", new Object[]{var14.getMessage()});
            }
         }

         if(var9.func_77973_b() == null) {
            var9 = null;
         }

         if(var3) {
            p_71515_1_.func_174794_a(CommandResultStats.Type.AFFECTED_ITEMS, 0);
            BlockPos var17 = func_175757_a(p_71515_1_, p_71515_2_, 1, false);
            World var11 = p_71515_1_.func_130014_f_();
            TileEntity var12 = var11.func_175625_s(var17);
            if(var12 == null || !(var12 instanceof IInventory)) {
               throw new CommandException("commands.replaceitem.noContainer", new Object[]{Integer.valueOf(var17.func_177958_n()), Integer.valueOf(var17.func_177956_o()), Integer.valueOf(var17.func_177952_p())});
            }

            IInventory var13 = (IInventory)var12;
            if(var5 >= 0 && var5 < var13.func_70302_i_()) {
               var13.func_70299_a(var5, var9);
            }
         } else {
            Entity var18 = func_175768_b(p_71515_1_, p_71515_2_[1]);
            p_71515_1_.func_174794_a(CommandResultStats.Type.AFFECTED_ITEMS, 0);
            if(var18 instanceof EntityPlayer) {
               ((EntityPlayer)var18).field_71069_bz.func_75142_b();
            }

            if(!var18.func_174820_d(var5, var9)) {
               throw new CommandException("commands.replaceitem.failed", new Object[]{Integer.valueOf(var5), Integer.valueOf(var7), var9 == null?"Air":var9.func_151000_E()});
            }

            if(var18 instanceof EntityPlayer) {
               ((EntityPlayer)var18).field_71069_bz.func_75142_b();
            }
         }

         p_71515_1_.func_174794_a(CommandResultStats.Type.AFFECTED_ITEMS, var7);
         func_152373_a(p_71515_1_, this, "commands.replaceitem.success", new Object[]{Integer.valueOf(var5), Integer.valueOf(var7), var9 == null?"Air":var9.func_151000_E()});
      }
   }

   private int func_175783_e(String p_175783_1_) throws CommandException {
      if(!field_175785_a.containsKey(p_175783_1_)) {
         throw new CommandException("commands.generic.parameter.invalid", new Object[]{p_175783_1_});
      } else {
         return ((Integer)field_175785_a.get(p_175783_1_)).intValue();
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length == 1?func_71530_a(p_180525_2_, new String[]{"entity", "block"}):(p_180525_2_.length == 2 && p_180525_2_[0].equals("entity")?func_71530_a(p_180525_2_, this.func_175784_d()):((p_180525_2_.length != 3 || !p_180525_2_[0].equals("entity")) && (p_180525_2_.length != 5 || !p_180525_2_[0].equals("block"))?((p_180525_2_.length != 4 || !p_180525_2_[0].equals("entity")) && (p_180525_2_.length != 6 || !p_180525_2_[0].equals("block"))?null:func_175762_a(p_180525_2_, Item.field_150901_e.func_148742_b())):func_175762_a(p_180525_2_, field_175785_a.keySet())));
   }

   protected String[] func_175784_d() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_1_.length > 0 && p_82358_1_[0].equals("entity") && p_82358_2_ == 1;
   }

   static {
      int var0;
      for(var0 = 0; var0 < 54; ++var0) {
         field_175785_a.put("slot.container." + var0, Integer.valueOf(var0));
      }

      for(var0 = 0; var0 < 9; ++var0) {
         field_175785_a.put("slot.hotbar." + var0, Integer.valueOf(var0));
      }

      for(var0 = 0; var0 < 27; ++var0) {
         field_175785_a.put("slot.inventory." + var0, Integer.valueOf(9 + var0));
      }

      for(var0 = 0; var0 < 27; ++var0) {
         field_175785_a.put("slot.enderchest." + var0, Integer.valueOf(200 + var0));
      }

      for(var0 = 0; var0 < 8; ++var0) {
         field_175785_a.put("slot.villager." + var0, Integer.valueOf(300 + var0));
      }

      for(var0 = 0; var0 < 15; ++var0) {
         field_175785_a.put("slot.horse." + var0, Integer.valueOf(500 + var0));
      }

      field_175785_a.put("slot.weapon", Integer.valueOf(99));
      field_175785_a.put("slot.armor.head", Integer.valueOf(103));
      field_175785_a.put("slot.armor.chest", Integer.valueOf(102));
      field_175785_a.put("slot.armor.legs", Integer.valueOf(101));
      field_175785_a.put("slot.armor.feet", Integer.valueOf(100));
      field_175785_a.put("slot.horse.saddle", Integer.valueOf(400));
      field_175785_a.put("slot.horse.armor", Integer.valueOf(401));
      field_175785_a.put("slot.horse.chest", Integer.valueOf(499));
   }
}
