package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class CommandParticle extends CommandBase {

   private static final String __OBFID = "CL_00002341";


   public String func_71517_b() {
      return "particle";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.particle.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 8) {
         throw new WrongUsageException("commands.particle.usage", new Object[0]);
      } else {
         boolean var3 = false;
         EnumParticleTypes var4 = null;
         EnumParticleTypes[] var5 = EnumParticleTypes.values();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            EnumParticleTypes var8 = var5[var7];
            if(var8.func_179343_f()) {
               if(p_71515_2_[0].startsWith(var8.func_179346_b())) {
                  var3 = true;
                  var4 = var8;
                  break;
               }
            } else if(p_71515_2_[0].equals(var8.func_179346_b())) {
               var3 = true;
               var4 = var8;
               break;
            }
         }

         if(!var3) {
            throw new CommandException("commands.particle.notFound", new Object[]{p_71515_2_[0]});
         } else {
            String var30 = p_71515_2_[0];
            Vec3 var31 = p_71515_1_.func_174791_d();
            double var32 = (double)((float)func_175761_b(var31.field_72450_a, p_71515_2_[1], true));
            double var9 = (double)((float)func_175761_b(var31.field_72448_b, p_71515_2_[2], true));
            double var11 = (double)((float)func_175761_b(var31.field_72449_c, p_71515_2_[3], true));
            double var13 = (double)((float)func_175765_c(p_71515_2_[4]));
            double var15 = (double)((float)func_175765_c(p_71515_2_[5]));
            double var17 = (double)((float)func_175765_c(p_71515_2_[6]));
            double var19 = (double)((float)func_175765_c(p_71515_2_[7]));
            int var21 = 0;
            if(p_71515_2_.length > 8) {
               var21 = func_180528_a(p_71515_2_[8], 0);
            }

            boolean var22 = false;
            if(p_71515_2_.length > 9 && "force".equals(p_71515_2_[9])) {
               var22 = true;
            }

            World var23 = p_71515_1_.func_130014_f_();
            if(var23 instanceof WorldServer) {
               WorldServer var24 = (WorldServer)var23;
               int[] var25 = new int[var4.func_179345_d()];
               if(var4.func_179343_f()) {
                  String[] var26 = p_71515_2_[0].split("_", 3);

                  for(int var27 = 1; var27 < var26.length; ++var27) {
                     try {
                        var25[var27 - 1] = Integer.parseInt(var26[var27]);
                     } catch (NumberFormatException var29) {
                        throw new CommandException("commands.particle.notFound", new Object[]{p_71515_2_[0]});
                     }
                  }
               }

               var24.func_180505_a(var4, var22, var32, var9, var11, var21, var13, var15, var17, var19, var25);
               func_152373_a(p_71515_1_, this, "commands.particle.success", new Object[]{var30, Integer.valueOf(Math.max(var21, 1))});
            }

         }
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length == 1?func_71530_a(p_180525_2_, EnumParticleTypes.func_179349_a()):(p_180525_2_.length > 1 && p_180525_2_.length <= 4?func_175771_a(p_180525_2_, 1, p_180525_3_):(p_180525_2_.length == 9?func_71530_a(p_180525_2_, new String[]{"normal", "force"}):null));
   }
}
