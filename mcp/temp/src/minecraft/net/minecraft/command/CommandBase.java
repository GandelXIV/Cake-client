package net.minecraft.command;

import com.google.common.base.Functions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.primitives.Doubles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.command.CommandException;
import net.minecraft.command.EntityNotFoundException;
import net.minecraft.command.IAdminCommand;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.PlayerSelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;

public abstract class CommandBase implements ICommand {

   private static IAdminCommand field_71533_a;
   private static final String __OBFID = "CL_00001739";


   public int func_82362_a() {
      return 4;
   }

   public List func_71514_a() {
      return Collections.emptyList();
   }

   public boolean func_71519_b(ICommandSender p_71519_1_) {
      return p_71519_1_.func_70003_b(this.func_82362_a(), this.func_71517_b());
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return null;
   }

   public static int func_175755_a(String p_175755_0_) throws NumberInvalidException {
      try {
         return Integer.parseInt(p_175755_0_);
      } catch (NumberFormatException var2) {
         throw new NumberInvalidException("commands.generic.num.invalid", new Object[]{p_175755_0_});
      }
   }

   public static int func_180528_a(String p_180528_0_, int p_180528_1_) throws NumberInvalidException {
      return func_175764_a(p_180528_0_, p_180528_1_, Integer.MAX_VALUE);
   }

   public static int func_175764_a(String p_175764_0_, int p_175764_1_, int p_175764_2_) throws NumberInvalidException {
      int var3 = func_175755_a(p_175764_0_);
      if(var3 < p_175764_1_) {
         throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[]{Integer.valueOf(var3), Integer.valueOf(p_175764_1_)});
      } else if(var3 > p_175764_2_) {
         throw new NumberInvalidException("commands.generic.num.tooBig", new Object[]{Integer.valueOf(var3), Integer.valueOf(p_175764_2_)});
      } else {
         return var3;
      }
   }

   public static long func_175766_b(String p_175766_0_) throws NumberInvalidException {
      try {
         return Long.parseLong(p_175766_0_);
      } catch (NumberFormatException var2) {
         throw new NumberInvalidException("commands.generic.num.invalid", new Object[]{p_175766_0_});
      }
   }

   public static long func_175760_a(String p_175760_0_, long p_175760_1_, long p_175760_3_) throws NumberInvalidException {
      long var5 = func_175766_b(p_175760_0_);
      if(var5 < p_175760_1_) {
         throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[]{Long.valueOf(var5), Long.valueOf(p_175760_1_)});
      } else if(var5 > p_175760_3_) {
         throw new NumberInvalidException("commands.generic.num.tooBig", new Object[]{Long.valueOf(var5), Long.valueOf(p_175760_3_)});
      } else {
         return var5;
      }
   }

   public static BlockPos func_175757_a(ICommandSender p_175757_0_, String[] p_175757_1_, int p_175757_2_, boolean p_175757_3_) throws NumberInvalidException {
      BlockPos var4 = p_175757_0_.func_180425_c();
      return new BlockPos(func_175769_b((double)var4.func_177958_n(), p_175757_1_[p_175757_2_], -30000000, 30000000, p_175757_3_), func_175769_b((double)var4.func_177956_o(), p_175757_1_[p_175757_2_ + 1], 0, 256, false), func_175769_b((double)var4.func_177952_p(), p_175757_1_[p_175757_2_ + 2], -30000000, 30000000, p_175757_3_));
   }

   public static double func_175765_c(String p_175765_0_) throws NumberInvalidException {
      try {
         double var1 = Double.parseDouble(p_175765_0_);
         if(!Doubles.isFinite(var1)) {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[]{p_175765_0_});
         } else {
            return var1;
         }
      } catch (NumberFormatException var3) {
         throw new NumberInvalidException("commands.generic.num.invalid", new Object[]{p_175765_0_});
      }
   }

   public static double func_180526_a(String p_180526_0_, double p_180526_1_) throws NumberInvalidException {
      return func_175756_a(p_180526_0_, p_180526_1_, Double.MAX_VALUE);
   }

   public static double func_175756_a(String p_175756_0_, double p_175756_1_, double p_175756_3_) throws NumberInvalidException {
      double var5 = func_175765_c(p_175756_0_);
      if(var5 < p_175756_1_) {
         throw new NumberInvalidException("commands.generic.double.tooSmall", new Object[]{Double.valueOf(var5), Double.valueOf(p_175756_1_)});
      } else if(var5 > p_175756_3_) {
         throw new NumberInvalidException("commands.generic.double.tooBig", new Object[]{Double.valueOf(var5), Double.valueOf(p_175756_3_)});
      } else {
         return var5;
      }
   }

   public static boolean func_180527_d(String p_180527_0_) throws CommandException {
      if(!p_180527_0_.equals("true") && !p_180527_0_.equals("1")) {
         if(!p_180527_0_.equals("false") && !p_180527_0_.equals("0")) {
            throw new CommandException("commands.generic.boolean.invalid", new Object[]{p_180527_0_});
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public static EntityPlayerMP func_71521_c(ICommandSender p_71521_0_) throws PlayerNotFoundException {
      if(p_71521_0_ instanceof EntityPlayerMP) {
         return (EntityPlayerMP)p_71521_0_;
      } else {
         throw new PlayerNotFoundException("You must specify which player you wish to perform this action on.", new Object[0]);
      }
   }

   public static EntityPlayerMP func_82359_c(ICommandSender p_82359_0_, String p_82359_1_) throws PlayerNotFoundException {
      EntityPlayerMP var2 = PlayerSelector.func_82386_a(p_82359_0_, p_82359_1_);
      if(var2 == null) {
         try {
            var2 = MinecraftServer.func_71276_C().func_71203_ab().func_177451_a(UUID.fromString(p_82359_1_));
         } catch (IllegalArgumentException var4) {
            ;
         }
      }

      if(var2 == null) {
         var2 = MinecraftServer.func_71276_C().func_71203_ab().func_152612_a(p_82359_1_);
      }

      if(var2 == null) {
         throw new PlayerNotFoundException();
      } else {
         return var2;
      }
   }

   public static Entity func_175768_b(ICommandSender p_175768_0_, String p_175768_1_) throws EntityNotFoundException {
      return func_175759_a(p_175768_0_, p_175768_1_, Entity.class);
   }

   public static Entity func_175759_a(ICommandSender p_175759_0_, String p_175759_1_, Class p_175759_2_) throws EntityNotFoundException {
      Object var3 = PlayerSelector.func_179652_a(p_175759_0_, p_175759_1_, p_175759_2_);
      MinecraftServer var4 = MinecraftServer.func_71276_C();
      if(var3 == null) {
         var3 = var4.func_71203_ab().func_152612_a(p_175759_1_);
      }

      if(var3 == null) {
         try {
            UUID var5 = UUID.fromString(p_175759_1_);
            var3 = var4.func_175576_a(var5);
            if(var3 == null) {
               var3 = var4.func_71203_ab().func_177451_a(var5);
            }
         } catch (IllegalArgumentException var6) {
            throw new EntityNotFoundException("commands.generic.entity.invalidUuid", new Object[0]);
         }
      }

      if(var3 != null && p_175759_2_.isAssignableFrom(var3.getClass())) {
         return (Entity)var3;
      } else {
         throw new EntityNotFoundException();
      }
   }

   public static List func_175763_c(ICommandSender p_175763_0_, String p_175763_1_) throws EntityNotFoundException {
      return (List)(PlayerSelector.func_82378_b(p_175763_1_)?PlayerSelector.func_179656_b(p_175763_0_, p_175763_1_, Entity.class):Lists.newArrayList(new Entity[]{func_175768_b(p_175763_0_, p_175763_1_)}));
   }

   public static String func_96332_d(ICommandSender p_96332_0_, String p_96332_1_) throws PlayerNotFoundException {
      try {
         return func_82359_c(p_96332_0_, p_96332_1_).func_70005_c_();
      } catch (PlayerNotFoundException var3) {
         if(PlayerSelector.func_82378_b(p_96332_1_)) {
            throw var3;
         } else {
            return p_96332_1_;
         }
      }
   }

   public static String func_175758_e(ICommandSender p_175758_0_, String p_175758_1_) throws EntityNotFoundException {
      try {
         return func_82359_c(p_175758_0_, p_175758_1_).func_70005_c_();
      } catch (PlayerNotFoundException var5) {
         try {
            return func_175768_b(p_175758_0_, p_175758_1_).func_110124_au().toString();
         } catch (EntityNotFoundException var4) {
            if(PlayerSelector.func_82378_b(p_175758_1_)) {
               throw var4;
            } else {
               return p_175758_1_;
            }
         }
      }
   }

   public static IChatComponent func_147178_a(ICommandSender p_147178_0_, String[] p_147178_1_, int p_147178_2_) throws CommandException {
      return func_147176_a(p_147178_0_, p_147178_1_, p_147178_2_, false);
   }

   public static IChatComponent func_147176_a(ICommandSender p_147176_0_, String[] p_147176_1_, int p_147176_2_, boolean p_147176_3_) throws PlayerNotFoundException {
      ChatComponentText var4 = new ChatComponentText("");

      for(int var5 = p_147176_2_; var5 < p_147176_1_.length; ++var5) {
         if(var5 > p_147176_2_) {
            var4.func_150258_a(" ");
         }

         Object var6 = new ChatComponentText(p_147176_1_[var5]);
         if(p_147176_3_) {
            IChatComponent var7 = PlayerSelector.func_150869_b(p_147176_0_, p_147176_1_[var5]);
            if(var7 == null) {
               if(PlayerSelector.func_82378_b(p_147176_1_[var5])) {
                  throw new PlayerNotFoundException();
               }
            } else {
               var6 = var7;
            }
         }

         var4.func_150257_a((IChatComponent)var6);
      }

      return var4;
   }

   public static String func_180529_a(String[] p_180529_0_, int p_180529_1_) {
      StringBuilder var2 = new StringBuilder();

      for(int var3 = p_180529_1_; var3 < p_180529_0_.length; ++var3) {
         if(var3 > p_180529_1_) {
            var2.append(" ");
         }

         String var4 = p_180529_0_[var3];
         var2.append(var4);
      }

      return var2.toString();
   }

   public static CommandBase.CoordinateArg func_175770_a(double p_175770_0_, String p_175770_2_, boolean p_175770_3_) throws NumberInvalidException {
      return func_175767_a(p_175770_0_, p_175770_2_, -30000000, 30000000, p_175770_3_);
   }

   public static CommandBase.CoordinateArg func_175767_a(double p_175767_0_, String p_175767_2_, int p_175767_3_, int p_175767_4_, boolean p_175767_5_) throws NumberInvalidException {
      boolean var6 = p_175767_2_.startsWith("~");
      if(var6 && Double.isNaN(p_175767_0_)) {
         throw new NumberInvalidException("commands.generic.num.invalid", new Object[]{Double.valueOf(p_175767_0_)});
      } else {
         double var7 = 0.0D;
         if(!var6 || p_175767_2_.length() > 1) {
            boolean var9 = p_175767_2_.contains(".");
            if(var6) {
               p_175767_2_ = p_175767_2_.substring(1);
            }

            var7 += func_175765_c(p_175767_2_);
            if(!var9 && !var6 && p_175767_5_) {
               var7 += 0.5D;
            }
         }

         if(p_175767_3_ != 0 || p_175767_4_ != 0) {
            if(var7 < (double)p_175767_3_) {
               throw new NumberInvalidException("commands.generic.double.tooSmall", new Object[]{Double.valueOf(var7), Integer.valueOf(p_175767_3_)});
            }

            if(var7 > (double)p_175767_4_) {
               throw new NumberInvalidException("commands.generic.double.tooBig", new Object[]{Double.valueOf(var7), Integer.valueOf(p_175767_4_)});
            }
         }

         return new CommandBase.CoordinateArg(var7 + (var6?p_175767_0_:0.0D), var7, var6);
      }
   }

   public static double func_175761_b(double p_175761_0_, String p_175761_2_, boolean p_175761_3_) throws NumberInvalidException {
      return func_175769_b(p_175761_0_, p_175761_2_, -30000000, 30000000, p_175761_3_);
   }

   public static double func_175769_b(double p_175769_0_, String p_175769_2_, int p_175769_3_, int p_175769_4_, boolean p_175769_5_) throws NumberInvalidException {
      boolean var6 = p_175769_2_.startsWith("~");
      if(var6 && Double.isNaN(p_175769_0_)) {
         throw new NumberInvalidException("commands.generic.num.invalid", new Object[]{Double.valueOf(p_175769_0_)});
      } else {
         double var7 = var6?p_175769_0_:0.0D;
         if(!var6 || p_175769_2_.length() > 1) {
            boolean var9 = p_175769_2_.contains(".");
            if(var6) {
               p_175769_2_ = p_175769_2_.substring(1);
            }

            var7 += func_175765_c(p_175769_2_);
            if(!var9 && !var6 && p_175769_5_) {
               var7 += 0.5D;
            }
         }

         if(p_175769_3_ != 0 || p_175769_4_ != 0) {
            if(var7 < (double)p_175769_3_) {
               throw new NumberInvalidException("commands.generic.double.tooSmall", new Object[]{Double.valueOf(var7), Integer.valueOf(p_175769_3_)});
            }

            if(var7 > (double)p_175769_4_) {
               throw new NumberInvalidException("commands.generic.double.tooBig", new Object[]{Double.valueOf(var7), Integer.valueOf(p_175769_4_)});
            }
         }

         return var7;
      }
   }

   public static Item func_147179_f(ICommandSender p_147179_0_, String p_147179_1_) throws NumberInvalidException {
      ResourceLocation var2 = new ResourceLocation(p_147179_1_);
      Item var3 = (Item)Item.field_150901_e.func_82594_a(var2);
      if(var3 == null) {
         throw new NumberInvalidException("commands.give.notFound", new Object[]{var2});
      } else {
         return var3;
      }
   }

   public static Block func_147180_g(ICommandSender p_147180_0_, String p_147180_1_) throws NumberInvalidException {
      ResourceLocation var2 = new ResourceLocation(p_147180_1_);
      if(!Block.field_149771_c.func_148741_d(var2)) {
         throw new NumberInvalidException("commands.give.notFound", new Object[]{var2});
      } else {
         Block var3 = (Block)Block.field_149771_c.func_82594_a(var2);
         if(var3 == null) {
            throw new NumberInvalidException("commands.give.notFound", new Object[]{var2});
         } else {
            return var3;
         }
      }
   }

   public static String func_71527_a(Object[] p_71527_0_) {
      StringBuilder var1 = new StringBuilder();

      for(int var2 = 0; var2 < p_71527_0_.length; ++var2) {
         String var3 = p_71527_0_[var2].toString();
         if(var2 > 0) {
            if(var2 == p_71527_0_.length - 1) {
               var1.append(" and ");
            } else {
               var1.append(", ");
            }
         }

         var1.append(var3);
      }

      return var1.toString();
   }

   public static IChatComponent func_180530_a(List p_180530_0_) {
      ChatComponentText var1 = new ChatComponentText("");

      for(int var2 = 0; var2 < p_180530_0_.size(); ++var2) {
         if(var2 > 0) {
            if(var2 == p_180530_0_.size() - 1) {
               var1.func_150258_a(" and ");
            } else if(var2 > 0) {
               var1.func_150258_a(", ");
            }
         }

         var1.func_150257_a((IChatComponent)p_180530_0_.get(var2));
      }

      return var1;
   }

   public static String func_96333_a(Collection p_96333_0_) {
      return func_71527_a(p_96333_0_.toArray(new String[p_96333_0_.size()]));
   }

   public static List func_175771_a(String[] p_175771_0_, int p_175771_1_, BlockPos p_175771_2_) {
      if(p_175771_2_ == null) {
         return null;
      } else {
         String var3;
         if(p_175771_0_.length - 1 == p_175771_1_) {
            var3 = Integer.toString(p_175771_2_.func_177958_n());
         } else if(p_175771_0_.length - 1 == p_175771_1_ + 1) {
            var3 = Integer.toString(p_175771_2_.func_177956_o());
         } else {
            if(p_175771_0_.length - 1 != p_175771_1_ + 2) {
               return null;
            }

            var3 = Integer.toString(p_175771_2_.func_177952_p());
         }

         return Lists.newArrayList(new String[]{var3});
      }
   }

   public static boolean func_71523_a(String p_71523_0_, String p_71523_1_) {
      return p_71523_1_.regionMatches(true, 0, p_71523_0_, 0, p_71523_0_.length());
   }

   public static List func_71530_a(String[] p_71530_0_, String ... p_71530_1_) {
      return func_175762_a(p_71530_0_, Arrays.asList(p_71530_1_));
   }

   public static List func_175762_a(String[] p_175762_0_, Collection p_175762_1_) {
      String var2 = p_175762_0_[p_175762_0_.length - 1];
      ArrayList var3 = Lists.newArrayList();
      if(!p_175762_1_.isEmpty()) {
         Iterator var4 = Iterables.transform(p_175762_1_, Functions.toStringFunction()).iterator();

         while(var4.hasNext()) {
            String var5 = (String)var4.next();
            if(func_71523_a(var2, var5)) {
               var3.add(var5);
            }
         }

         if(var3.isEmpty()) {
            var4 = p_175762_1_.iterator();

            while(var4.hasNext()) {
               Object var6 = var4.next();
               if(var6 instanceof ResourceLocation && func_71523_a(var2, ((ResourceLocation)var6).func_110623_a())) {
                  var3.add(String.valueOf(var6));
               }
            }
         }
      }

      return var3;
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return false;
   }

   public static void func_152373_a(ICommandSender p_152373_0_, ICommand p_152373_1_, String p_152373_2_, Object ... p_152373_3_) {
      func_152374_a(p_152373_0_, p_152373_1_, 0, p_152373_2_, p_152373_3_);
   }

   public static void func_152374_a(ICommandSender p_152374_0_, ICommand p_152374_1_, int p_152374_2_, String p_152374_3_, Object ... p_152374_4_) {
      if(field_71533_a != null) {
         field_71533_a.func_152372_a(p_152374_0_, p_152374_1_, p_152374_2_, p_152374_3_, p_152374_4_);
      }

   }

   public static void func_71529_a(IAdminCommand p_71529_0_) {
      field_71533_a = p_71529_0_;
   }

   public int compareTo(ICommand p_compareTo_1_) {
      return this.func_71517_b().compareTo(p_compareTo_1_.func_71517_b());
   }

   // $FF: synthetic method
   public int compareTo(Object p_compareTo_1_) {
      return this.compareTo((ICommand)p_compareTo_1_);
   }

   public static class CoordinateArg {

      private final double field_179633_a;
      private final double field_179631_b;
      private final boolean field_179632_c;
      private static final String __OBFID = "CL_00002365";


      protected CoordinateArg(double p_i46051_1_, double p_i46051_3_, boolean p_i46051_5_) {
         this.field_179633_a = p_i46051_1_;
         this.field_179631_b = p_i46051_3_;
         this.field_179632_c = p_i46051_5_;
      }

      public double func_179628_a() {
         return this.field_179633_a;
      }

      public double func_179629_b() {
         return this.field_179631_b;
      }

      public boolean func_179630_c() {
         return this.field_179632_c;
      }
   }
}
