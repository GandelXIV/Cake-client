package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;

public class CommandEffect extends CommandBase {

   private static final String __OBFID = "CL_00000323";


   public String func_71517_b() {
      return "effect";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.effect.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 2) {
         throw new WrongUsageException("commands.effect.usage", new Object[0]);
      } else {
         EntityLivingBase var3 = (EntityLivingBase)func_175759_a(p_71515_1_, p_71515_2_[0], EntityLivingBase.class);
         if(p_71515_2_[1].equals("clear")) {
            if(var3.func_70651_bq().isEmpty()) {
               throw new CommandException("commands.effect.failure.notActive.all", new Object[]{var3.func_70005_c_()});
            } else {
               var3.func_70674_bp();
               func_152373_a(p_71515_1_, this, "commands.effect.success.removed.all", new Object[]{var3.func_70005_c_()});
            }
         } else {
            int var4;
            try {
               var4 = func_180528_a(p_71515_2_[1], 1);
            } catch (NumberInvalidException var11) {
               Potion var6 = Potion.func_180142_b(p_71515_2_[1]);
               if(var6 == null) {
                  throw var11;
               }

               var4 = var6.field_76415_H;
            }

            int var5 = 600;
            int var12 = 30;
            int var7 = 0;
            if(var4 >= 0 && var4 < Potion.field_76425_a.length && Potion.field_76425_a[var4] != null) {
               Potion var8 = Potion.field_76425_a[var4];
               if(p_71515_2_.length >= 3) {
                  var12 = func_175764_a(p_71515_2_[2], 0, 1000000);
                  if(var8.func_76403_b()) {
                     var5 = var12;
                  } else {
                     var5 = var12 * 20;
                  }
               } else if(var8.func_76403_b()) {
                  var5 = 1;
               }

               if(p_71515_2_.length >= 4) {
                  var7 = func_175764_a(p_71515_2_[3], 0, 255);
               }

               boolean var9 = true;
               if(p_71515_2_.length >= 5 && "true".equalsIgnoreCase(p_71515_2_[4])) {
                  var9 = false;
               }

               if(var12 > 0) {
                  PotionEffect var10 = new PotionEffect(var4, var5, var7, false, var9);
                  var3.func_70690_d(var10);
                  func_152373_a(p_71515_1_, this, "commands.effect.success", new Object[]{new ChatComponentTranslation(var10.func_76453_d(), new Object[0]), Integer.valueOf(var4), Integer.valueOf(var7), var3.func_70005_c_(), Integer.valueOf(var12)});
               } else if(var3.func_82165_m(var4)) {
                  var3.func_82170_o(var4);
                  func_152373_a(p_71515_1_, this, "commands.effect.success.removed", new Object[]{new ChatComponentTranslation(var8.func_76393_a(), new Object[0]), var3.func_70005_c_()});
               } else {
                  throw new CommandException("commands.effect.failure.notActive", new Object[]{new ChatComponentTranslation(var8.func_76393_a(), new Object[0]), var3.func_70005_c_()});
               }
            } else {
               throw new NumberInvalidException("commands.effect.notFound", new Object[]{Integer.valueOf(var4)});
            }
         }
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length == 1?func_71530_a(p_180525_2_, this.func_98152_d()):(p_180525_2_.length == 2?func_71530_a(p_180525_2_, Potion.func_180141_c()):(p_180525_2_.length == 5?func_71530_a(p_180525_2_, new String[]{"true", "false"}):null));
   }

   protected String[] func_98152_d() {
      return MinecraftServer.func_71276_C().func_71213_z();
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 0;
   }
}
