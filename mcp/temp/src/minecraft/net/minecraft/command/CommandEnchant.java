package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;

public class CommandEnchant extends CommandBase {

   private static final String __OBFID = "CL_00000377";


   public String func_71517_b() {
      return "enchant";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.enchant.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 2) {
         throw new WrongUsageException("commands.enchant.usage", new Object[0]);
      } else {
         EntityPlayerMP var3 = func_82359_c(p_71515_1_, p_71515_2_[0]);
         p_71515_1_.func_174794_a(CommandResultStats.Type.AFFECTED_ITEMS, 0);

         int var4;
         try {
            var4 = func_180528_a(p_71515_2_[1], 0);
         } catch (NumberInvalidException var12) {
            Enchantment var6 = Enchantment.func_180305_b(p_71515_2_[1]);
            if(var6 == null) {
               throw var12;
            }

            var4 = var6.field_77352_x;
         }

         int var5 = 1;
         ItemStack var13 = var3.func_71045_bC();
         if(var13 == null) {
            throw new CommandException("commands.enchant.noItem", new Object[0]);
         } else {
            Enchantment var7 = Enchantment.func_180306_c(var4);
            if(var7 == null) {
               throw new NumberInvalidException("commands.enchant.notFound", new Object[]{Integer.valueOf(var4)});
            } else if(!var7.func_92089_a(var13)) {
               throw new CommandException("commands.enchant.cantEnchant", new Object[0]);
            } else {
               if(p_71515_2_.length >= 3) {
                  var5 = func_175764_a(p_71515_2_[2], var7.func_77319_d(), var7.func_77325_b());
               }

               if(var13.func_77942_o()) {
                  NBTTagList var8 = var13.func_77986_q();
                  if(var8 != null) {
                     for(int var9 = 0; var9 < var8.func_74745_c(); ++var9) {
                        short var10 = var8.func_150305_b(var9).func_74765_d("id");
                        if(Enchantment.func_180306_c(var10) != null) {
                           Enchantment var11 = Enchantment.func_180306_c(var10);
                           if(!var11.func_77326_a(var7)) {
                              throw new CommandException("commands.enchant.cantCombine", new Object[]{var7.func_77316_c(var5), var11.func_77316_c(var8.func_150305_b(var9).func_74765_d("lvl"))});
                           }
                        }
                     }
                  }
               }

               var13.func_77966_a(var7, var5);
               func_152373_a(p_71515_1_, this, "commands.enchant.success", new Object[0]);
               p_71515_1_.func_174794_a(CommandResultStats.Type.AFFECTED_ITEMS, 1);
            }
         }
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length == 1?func_71530_a(p_180525_2_, this.func_90022_d()):(p_180525_2_.length == 2?func_71530_a(p_180525_2_, Enchantment.func_180304_c()):null);
   }

   protected String[] func_90022_d() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 0;
   }
}
