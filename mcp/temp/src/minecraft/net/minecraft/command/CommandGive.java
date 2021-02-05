package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;

public class CommandGive extends CommandBase {

   private static final String __OBFID = "CL_00000502";


   public String func_71517_b() {
      return "give";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.give.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 2) {
         throw new WrongUsageException("commands.give.usage", new Object[0]);
      } else {
         EntityPlayerMP var3 = func_82359_c(p_71515_1_, p_71515_2_[0]);
         Item var4 = func_147179_f(p_71515_1_, p_71515_2_[1]);
         int var5 = p_71515_2_.length >= 3?func_175764_a(p_71515_2_[2], 1, 64):1;
         int var6 = p_71515_2_.length >= 4?func_175755_a(p_71515_2_[3]):0;
         ItemStack var7 = new ItemStack(var4, var5, var6);
         if(p_71515_2_.length >= 5) {
            String var8 = func_147178_a(p_71515_1_, p_71515_2_, 4).func_150260_c();

            try {
               var7.func_77982_d(JsonToNBT.func_180713_a(var8));
            } catch (NBTException var10) {
               throw new CommandException("commands.give.tagError", new Object[]{var10.getMessage()});
            }
         }

         boolean var11 = var3.field_71071_by.func_70441_a(var7);
         if(var11) {
            var3.field_70170_p.func_72956_a(var3, "random.pop", 0.2F, ((var3.func_70681_au().nextFloat() - var3.func_70681_au().nextFloat()) * 0.7F + 1.0F) * 2.0F);
            var3.field_71069_bz.func_75142_b();
         }

         EntityItem var9;
         if(var11 && var7.field_77994_a <= 0) {
            var7.field_77994_a = 1;
            p_71515_1_.func_174794_a(CommandResultStats.Type.AFFECTED_ITEMS, var5);
            var9 = var3.func_71019_a(var7, false);
            if(var9 != null) {
               var9.func_174870_v();
            }
         } else {
            p_71515_1_.func_174794_a(CommandResultStats.Type.AFFECTED_ITEMS, var5 - var7.field_77994_a);
            var9 = var3.func_71019_a(var7, false);
            if(var9 != null) {
               var9.func_174868_q();
               var9.func_145797_a(var3.func_70005_c_());
            }
         }

         func_152373_a(p_71515_1_, this, "commands.give.success", new Object[]{var7.func_151000_E(), Integer.valueOf(var5), var3.func_70005_c_()});
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length == 1?func_71530_a(p_180525_2_, this.func_71536_c()):(p_180525_2_.length == 2?func_175762_a(p_180525_2_, Item.field_150901_e.func_148742_b()):null);
   }

   protected String[] func_71536_c() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 0;
   }
}
