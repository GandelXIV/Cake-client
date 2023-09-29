package net.minecraft.command;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.S29PacketSoundEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;

public class CommandPlaySound extends CommandBase {

   private static final String __OBFID = "CL_00000774";


   public String func_71517_b() {
      return "playsound";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.playsound.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 2) {
         throw new WrongUsageException(this.func_71518_a(p_71515_1_), new Object[0]);
      } else {
         byte var3 = 0;
         int var31 = var3 + 1;
         String var4 = p_71515_2_[var3];
         EntityPlayerMP var5 = func_82359_c(p_71515_1_, p_71515_2_[var31++]);
         Vec3 var6 = p_71515_1_.func_174791_d();
         double var7 = var6.field_72450_a;
         if(p_71515_2_.length > var31) {
            var7 = func_175761_b(var7, p_71515_2_[var31++], true);
         }

         double var9 = var6.field_72448_b;
         if(p_71515_2_.length > var31) {
            var9 = func_175769_b(var9, p_71515_2_[var31++], 0, 0, false);
         }

         double var11 = var6.field_72449_c;
         if(p_71515_2_.length > var31) {
            var11 = func_175761_b(var11, p_71515_2_[var31++], true);
         }

         double var13 = 1.0D;
         if(p_71515_2_.length > var31) {
            var13 = func_175756_a(p_71515_2_[var31++], 0.0D, 3.4028234663852886E38D);
         }

         double var15 = 1.0D;
         if(p_71515_2_.length > var31) {
            var15 = func_175756_a(p_71515_2_[var31++], 0.0D, 2.0D);
         }

         double var17 = 0.0D;
         if(p_71515_2_.length > var31) {
            var17 = func_175756_a(p_71515_2_[var31], 0.0D, 1.0D);
         }

         double var19 = var13 > 1.0D?var13 * 16.0D:16.0D;
         double var21 = var5.func_70011_f(var7, var9, var11);
         if(var21 > var19) {
            if(var17 <= 0.0D) {
               throw new CommandException("commands.playsound.playerTooFar", new Object[]{var5.func_70005_c_()});
            }

            double var23 = var7 - var5.field_70165_t;
            double var25 = var9 - var5.field_70163_u;
            double var27 = var11 - var5.field_70161_v;
            double var29 = Math.sqrt(var23 * var23 + var25 * var25 + var27 * var27);
            if(var29 > 0.0D) {
               var7 = var5.field_70165_t + var23 / var29 * 2.0D;
               var9 = var5.field_70163_u + var25 / var29 * 2.0D;
               var11 = var5.field_70161_v + var27 / var29 * 2.0D;
            }

            var13 = var17;
         }

         var5.field_71135_a.func_147359_a(new S29PacketSoundEffect(var4, var7, var9, var11, (float)var13, (float)var15));
         func_152373_a(p_71515_1_, this, "commands.playsound.success", new Object[]{var4, var5.func_70005_c_()});
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length == 2?func_71530_a(p_180525_2_, MinecraftServer.func_71276_C().func_71213_z()):(p_180525_2_.length > 2 && p_180525_2_.length <= 5?func_175771_a(p_180525_2_, 2, p_180525_3_):null);
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 1;
   }
}
