package net.minecraft.command.server;

import java.util.EnumSet;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

public class CommandTeleport extends CommandBase {

   private static final String __OBFID = "CL_00001180";


   public String func_71517_b() {
      return "tp";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.tp.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 1) {
         throw new WrongUsageException("commands.tp.usage", new Object[0]);
      } else {
         byte var3 = 0;
         Object var4;
         if(p_71515_2_.length != 2 && p_71515_2_.length != 4 && p_71515_2_.length != 6) {
            var4 = func_71521_c(p_71515_1_);
         } else {
            var4 = func_175768_b(p_71515_1_, p_71515_2_[0]);
            var3 = 1;
         }

         if(p_71515_2_.length != 1 && p_71515_2_.length != 2) {
            if(p_71515_2_.length < var3 + 3) {
               throw new WrongUsageException("commands.tp.usage", new Object[0]);
            } else if(((Entity)var4).field_70170_p != null) {
               int var14 = var3 + 1;
               CommandBase.CoordinateArg var6 = func_175770_a(((Entity)var4).field_70165_t, p_71515_2_[var3], true);
               CommandBase.CoordinateArg var7 = func_175767_a(((Entity)var4).field_70163_u, p_71515_2_[var14++], 0, 0, false);
               CommandBase.CoordinateArg var8 = func_175770_a(((Entity)var4).field_70161_v, p_71515_2_[var14++], true);
               CommandBase.CoordinateArg var9 = func_175770_a((double)((Entity)var4).field_70177_z, p_71515_2_.length > var14?p_71515_2_[var14++]:"~", false);
               CommandBase.CoordinateArg var10 = func_175770_a((double)((Entity)var4).field_70125_A, p_71515_2_.length > var14?p_71515_2_[var14]:"~", false);
               float var12;
               if(var4 instanceof EntityPlayerMP) {
                  EnumSet var11 = EnumSet.noneOf(S08PacketPlayerPosLook.EnumFlags.class);
                  if(var6.func_179630_c()) {
                     var11.add(S08PacketPlayerPosLook.EnumFlags.X);
                  }

                  if(var7.func_179630_c()) {
                     var11.add(S08PacketPlayerPosLook.EnumFlags.Y);
                  }

                  if(var8.func_179630_c()) {
                     var11.add(S08PacketPlayerPosLook.EnumFlags.Z);
                  }

                  if(var10.func_179630_c()) {
                     var11.add(S08PacketPlayerPosLook.EnumFlags.X_ROT);
                  }

                  if(var9.func_179630_c()) {
                     var11.add(S08PacketPlayerPosLook.EnumFlags.Y_ROT);
                  }

                  var12 = (float)var9.func_179629_b();
                  if(!var9.func_179630_c()) {
                     var12 = MathHelper.func_76142_g(var12);
                  }

                  float var13 = (float)var10.func_179629_b();
                  if(!var10.func_179630_c()) {
                     var13 = MathHelper.func_76142_g(var13);
                  }

                  if(var13 > 90.0F || var13 < -90.0F) {
                     var13 = MathHelper.func_76142_g(180.0F - var13);
                     var12 = MathHelper.func_76142_g(var12 + 180.0F);
                  }

                  ((Entity)var4).func_70078_a((Entity)null);
                  ((EntityPlayerMP)var4).field_71135_a.func_175089_a(var6.func_179629_b(), var7.func_179629_b(), var8.func_179629_b(), var12, var13, var11);
                  ((Entity)var4).func_70034_d(var12);
               } else {
                  float var15 = (float)MathHelper.func_76138_g(var9.func_179628_a());
                  var12 = (float)MathHelper.func_76138_g(var10.func_179628_a());
                  if(var12 > 90.0F || var12 < -90.0F) {
                     var12 = MathHelper.func_76142_g(180.0F - var12);
                     var15 = MathHelper.func_76142_g(var15 + 180.0F);
                  }

                  ((Entity)var4).func_70012_b(var6.func_179628_a(), var7.func_179628_a(), var8.func_179628_a(), var15, var12);
                  ((Entity)var4).func_70034_d(var15);
               }

               func_152373_a(p_71515_1_, this, "commands.tp.success.coordinates", new Object[]{((Entity)var4).func_70005_c_(), Double.valueOf(var6.func_179628_a()), Double.valueOf(var7.func_179628_a()), Double.valueOf(var8.func_179628_a())});
            }
         } else {
            Entity var5 = func_175768_b(p_71515_1_, p_71515_2_[p_71515_2_.length - 1]);
            if(var5.field_70170_p != ((Entity)var4).field_70170_p) {
               throw new CommandException("commands.tp.notSameDimension", new Object[0]);
            } else {
               ((Entity)var4).func_70078_a((Entity)null);
               if(var4 instanceof EntityPlayerMP) {
                  ((EntityPlayerMP)var4).field_71135_a.func_147364_a(var5.field_70165_t, var5.field_70163_u, var5.field_70161_v, var5.field_70177_z, var5.field_70125_A);
               } else {
                  ((Entity)var4).func_70012_b(var5.field_70165_t, var5.field_70163_u, var5.field_70161_v, var5.field_70177_z, var5.field_70125_A);
               }

               func_152373_a(p_71515_1_, this, "commands.tp.success", new Object[]{((Entity)var4).func_70005_c_(), var5.func_70005_c_()});
            }
         }
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length != 1 && p_180525_2_.length != 2?null:func_71530_a(p_180525_2_, MinecraftServer.func_71276_C().func_71213_z());
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 0;
   }
}
