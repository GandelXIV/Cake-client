package net.minecraft.command;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.EntityNotFoundException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.PlayerSelector;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class CommandSpreadPlayers extends CommandBase {

   private static final String __OBFID = "CL_00001080";


   public String func_71517_b() {
      return "spreadplayers";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.spreadplayers.usage";
   }

   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 6) {
         throw new WrongUsageException("commands.spreadplayers.usage", new Object[0]);
      } else {
         byte var3 = 0;
         BlockPos var4 = p_71515_1_.func_180425_c();
         double var10000 = (double)var4.func_177958_n();
         int var17 = var3 + 1;
         double var5 = func_175761_b(var10000, p_71515_2_[var3], true);
         double var7 = func_175761_b((double)var4.func_177952_p(), p_71515_2_[var17++], true);
         double var9 = func_180526_a(p_71515_2_[var17++], 0.0D);
         double var11 = func_180526_a(p_71515_2_[var17++], var9 + 1.0D);
         boolean var13 = func_180527_d(p_71515_2_[var17++]);
         ArrayList var14 = Lists.newArrayList();

         while(var17 < p_71515_2_.length) {
            String var15 = p_71515_2_[var17++];
            if(PlayerSelector.func_82378_b(var15)) {
               List var16 = PlayerSelector.func_179656_b(p_71515_1_, var15, Entity.class);
               if(var16.size() == 0) {
                  throw new EntityNotFoundException();
               }

               var14.addAll(var16);
            } else {
               EntityPlayerMP var18 = MinecraftServer.func_71276_C().func_71203_ab().func_152612_a(var15);
               if(var18 == null) {
                  throw new PlayerNotFoundException();
               }

               var14.add(var18);
            }
         }

         p_71515_1_.func_174794_a(CommandResultStats.Type.AFFECTED_ENTITIES, var14.size());
         if(var14.isEmpty()) {
            throw new EntityNotFoundException();
         } else {
            p_71515_1_.func_145747_a(new ChatComponentTranslation("commands.spreadplayers.spreading." + (var13?"teams":"players"), new Object[]{Integer.valueOf(var14.size()), Double.valueOf(var11), Double.valueOf(var5), Double.valueOf(var7), Double.valueOf(var9)}));
            this.func_110669_a(p_71515_1_, var14, new CommandSpreadPlayers.Position(var5, var7), var9, var11, ((Entity)var14.get(0)).field_70170_p, var13);
         }
      }
   }

   private void func_110669_a(ICommandSender p_110669_1_, List p_110669_2_, CommandSpreadPlayers.Position p_110669_3_, double p_110669_4_, double p_110669_6_, World p_110669_8_, boolean p_110669_9_) throws CommandException {
      Random var10 = new Random();
      double var11 = p_110669_3_.field_111101_a - p_110669_6_;
      double var13 = p_110669_3_.field_111100_b - p_110669_6_;
      double var15 = p_110669_3_.field_111101_a + p_110669_6_;
      double var17 = p_110669_3_.field_111100_b + p_110669_6_;
      CommandSpreadPlayers.Position[] var19 = this.func_110670_a(var10, p_110669_9_?this.func_110667_a(p_110669_2_):p_110669_2_.size(), var11, var13, var15, var17);
      int var20 = this.func_110668_a(p_110669_3_, p_110669_4_, p_110669_8_, var10, var11, var13, var15, var17, var19, p_110669_9_);
      double var21 = this.func_110671_a(p_110669_2_, p_110669_8_, var19, p_110669_9_);
      func_152373_a(p_110669_1_, this, "commands.spreadplayers.success." + (p_110669_9_?"teams":"players"), new Object[]{Integer.valueOf(var19.length), Double.valueOf(p_110669_3_.field_111101_a), Double.valueOf(p_110669_3_.field_111100_b)});
      if(var19.length > 1) {
         p_110669_1_.func_145747_a(new ChatComponentTranslation("commands.spreadplayers.info." + (p_110669_9_?"teams":"players"), new Object[]{String.format("%.2f", new Object[]{Double.valueOf(var21)}), Integer.valueOf(var20)}));
      }

   }

   private int func_110667_a(List p_110667_1_) {
      HashSet var2 = Sets.newHashSet();
      Iterator var3 = p_110667_1_.iterator();

      while(var3.hasNext()) {
         Entity var4 = (Entity)var3.next();
         if(var4 instanceof EntityPlayer) {
            var2.add(((EntityPlayer)var4).func_96124_cp());
         } else {
            var2.add((Object)null);
         }
      }

      return var2.size();
   }

   private int func_110668_a(CommandSpreadPlayers.Position p_110668_1_, double p_110668_2_, World p_110668_4_, Random p_110668_5_, double p_110668_6_, double p_110668_8_, double p_110668_10_, double p_110668_12_, CommandSpreadPlayers.Position[] p_110668_14_, boolean p_110668_15_) throws CommandException {
      boolean var16 = true;
      double var18 = 3.4028234663852886E38D;

      int var17;
      for(var17 = 0; var17 < 10000 && var16; ++var17) {
         var16 = false;
         var18 = 3.4028234663852886E38D;

         int var22;
         CommandSpreadPlayers.Position var23;
         for(int var20 = 0; var20 < p_110668_14_.length; ++var20) {
            CommandSpreadPlayers.Position var21 = p_110668_14_[var20];
            var22 = 0;
            var23 = new CommandSpreadPlayers.Position();

            for(int var24 = 0; var24 < p_110668_14_.length; ++var24) {
               if(var20 != var24) {
                  CommandSpreadPlayers.Position var25 = p_110668_14_[var24];
                  double var26 = var21.func_111099_a(var25);
                  var18 = Math.min(var26, var18);
                  if(var26 < p_110668_2_) {
                     ++var22;
                     var23.field_111101_a += var25.field_111101_a - var21.field_111101_a;
                     var23.field_111100_b += var25.field_111100_b - var21.field_111100_b;
                  }
               }
            }

            if(var22 > 0) {
               var23.field_111101_a /= (double)var22;
               var23.field_111100_b /= (double)var22;
               double var30 = (double)var23.func_111096_b();
               if(var30 > 0.0D) {
                  var23.func_111095_a();
                  var21.func_111094_b(var23);
               } else {
                  var21.func_111097_a(p_110668_5_, p_110668_6_, p_110668_8_, p_110668_10_, p_110668_12_);
               }

               var16 = true;
            }

            if(var21.func_111093_a(p_110668_6_, p_110668_8_, p_110668_10_, p_110668_12_)) {
               var16 = true;
            }
         }

         if(!var16) {
            CommandSpreadPlayers.Position[] var28 = p_110668_14_;
            int var29 = p_110668_14_.length;

            for(var22 = 0; var22 < var29; ++var22) {
               var23 = var28[var22];
               if(!var23.func_111098_b(p_110668_4_)) {
                  var23.func_111097_a(p_110668_5_, p_110668_6_, p_110668_8_, p_110668_10_, p_110668_12_);
                  var16 = true;
               }
            }
         }
      }

      if(var17 >= 10000) {
         throw new CommandException("commands.spreadplayers.failure." + (p_110668_15_?"teams":"players"), new Object[]{Integer.valueOf(p_110668_14_.length), Double.valueOf(p_110668_1_.field_111101_a), Double.valueOf(p_110668_1_.field_111100_b), String.format("%.2f", new Object[]{Double.valueOf(var18)})});
      } else {
         return var17;
      }
   }

   private double func_110671_a(List p_110671_1_, World p_110671_2_, CommandSpreadPlayers.Position[] p_110671_3_, boolean p_110671_4_) {
      double var5 = 0.0D;
      int var7 = 0;
      HashMap var8 = Maps.newHashMap();

      for(int var9 = 0; var9 < p_110671_1_.size(); ++var9) {
         Entity var10 = (Entity)p_110671_1_.get(var9);
         CommandSpreadPlayers.Position var11;
         if(p_110671_4_) {
            Team var12 = var10 instanceof EntityPlayer?((EntityPlayer)var10).func_96124_cp():null;
            if(!var8.containsKey(var12)) {
               var8.put(var12, p_110671_3_[var7++]);
            }

            var11 = (CommandSpreadPlayers.Position)var8.get(var12);
         } else {
            var11 = p_110671_3_[var7++];
         }

         var10.func_70634_a((double)((float)MathHelper.func_76128_c(var11.field_111101_a) + 0.5F), (double)var11.func_111092_a(p_110671_2_), (double)MathHelper.func_76128_c(var11.field_111100_b) + 0.5D);
         double var17 = Double.MAX_VALUE;

         for(int var14 = 0; var14 < p_110671_3_.length; ++var14) {
            if(var11 != p_110671_3_[var14]) {
               double var15 = var11.func_111099_a(p_110671_3_[var14]);
               var17 = Math.min(var15, var17);
            }
         }

         var5 += var17;
      }

      var5 /= (double)p_110671_1_.size();
      return var5;
   }

   private CommandSpreadPlayers.Position[] func_110670_a(Random p_110670_1_, int p_110670_2_, double p_110670_3_, double p_110670_5_, double p_110670_7_, double p_110670_9_) {
      CommandSpreadPlayers.Position[] var11 = new CommandSpreadPlayers.Position[p_110670_2_];

      for(int var12 = 0; var12 < var11.length; ++var12) {
         CommandSpreadPlayers.Position var13 = new CommandSpreadPlayers.Position();
         var13.func_111097_a(p_110670_1_, p_110670_3_, p_110670_5_, p_110670_7_, p_110670_9_);
         var11[var12] = var13;
      }

      return var11;
   }

   static class Position {

      double field_111101_a;
      double field_111100_b;
      private static final String __OBFID = "CL_00001105";


      Position() {}

      Position(double p_i1358_1_, double p_i1358_3_) {
         this.field_111101_a = p_i1358_1_;
         this.field_111100_b = p_i1358_3_;
      }

      double func_111099_a(CommandSpreadPlayers.Position p_111099_1_) {
         double var2 = this.field_111101_a - p_111099_1_.field_111101_a;
         double var4 = this.field_111100_b - p_111099_1_.field_111100_b;
         return Math.sqrt(var2 * var2 + var4 * var4);
      }

      void func_111095_a() {
         double var1 = (double)this.func_111096_b();
         this.field_111101_a /= var1;
         this.field_111100_b /= var1;
      }

      float func_111096_b() {
         return MathHelper.func_76133_a(this.field_111101_a * this.field_111101_a + this.field_111100_b * this.field_111100_b);
      }

      public void func_111094_b(CommandSpreadPlayers.Position p_111094_1_) {
         this.field_111101_a -= p_111094_1_.field_111101_a;
         this.field_111100_b -= p_111094_1_.field_111100_b;
      }

      public boolean func_111093_a(double p_111093_1_, double p_111093_3_, double p_111093_5_, double p_111093_7_) {
         boolean var9 = false;
         if(this.field_111101_a < p_111093_1_) {
            this.field_111101_a = p_111093_1_;
            var9 = true;
         } else if(this.field_111101_a > p_111093_5_) {
            this.field_111101_a = p_111093_5_;
            var9 = true;
         }

         if(this.field_111100_b < p_111093_3_) {
            this.field_111100_b = p_111093_3_;
            var9 = true;
         } else if(this.field_111100_b > p_111093_7_) {
            this.field_111100_b = p_111093_7_;
            var9 = true;
         }

         return var9;
      }

      public int func_111092_a(World p_111092_1_) {
         BlockPos var2 = new BlockPos(this.field_111101_a, 256.0D, this.field_111100_b);

         do {
            if(var2.func_177956_o() <= 0) {
               return 257;
            }

            var2 = var2.func_177977_b();
         } while(p_111092_1_.func_180495_p(var2).func_177230_c().func_149688_o() == Material.field_151579_a);

         return var2.func_177956_o() + 1;
      }

      public boolean func_111098_b(World p_111098_1_) {
         BlockPos var2 = new BlockPos(this.field_111101_a, 256.0D, this.field_111100_b);

         Material var3;
         do {
            if(var2.func_177956_o() <= 0) {
               return false;
            }

            var2 = var2.func_177977_b();
            var3 = p_111098_1_.func_180495_p(var2).func_177230_c().func_149688_o();
         } while(var3 == Material.field_151579_a);

         return !var3.func_76224_d() && var3 != Material.field_151581_o;
      }

      public void func_111097_a(Random p_111097_1_, double p_111097_2_, double p_111097_4_, double p_111097_6_, double p_111097_8_) {
         this.field_111101_a = MathHelper.func_82716_a(p_111097_1_, p_111097_2_, p_111097_6_);
         this.field_111100_b = MathHelper.func_82716_a(p_111097_1_, p_111097_4_, p_111097_8_);
      }
   }
}
