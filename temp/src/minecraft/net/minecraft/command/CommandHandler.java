package net.minecraft.command;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerSelector;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandHandler implements ICommandManager {

   private static final Logger field_147175_a = LogManager.getLogger();
   private final Map field_71562_a = Maps.newHashMap();
   private final Set field_71561_b = Sets.newHashSet();
   private static final String __OBFID = "CL_00001765";


   public int func_71556_a(ICommandSender p_71556_1_, String p_71556_2_) {
      p_71556_2_ = p_71556_2_.trim();
      if(p_71556_2_.startsWith("/")) {
         p_71556_2_ = p_71556_2_.substring(1);
      }

      String[] var3 = p_71556_2_.split(" ");
      String var4 = var3[0];
      var3 = func_71559_a(var3);
      ICommand var5 = (ICommand)this.field_71562_a.get(var4);
      int var6 = this.func_82370_a(var5, var3);
      int var7 = 0;
      ChatComponentTranslation var8;
      if(var5 == null) {
         var8 = new ChatComponentTranslation("commands.generic.notFound", new Object[0]);
         var8.func_150256_b().func_150238_a(EnumChatFormatting.RED);
         p_71556_1_.func_145747_a(var8);
      } else if(var5.func_71519_b(p_71556_1_)) {
         if(var6 > -1) {
            List var12 = PlayerSelector.func_179656_b(p_71556_1_, var3[var6], Entity.class);
            String var9 = var3[var6];
            p_71556_1_.func_174794_a(CommandResultStats.Type.AFFECTED_ENTITIES, var12.size());
            Iterator var10 = var12.iterator();

            while(var10.hasNext()) {
               Entity var11 = (Entity)var10.next();
               var3[var6] = var11.func_110124_au().toString();
               if(this.func_175786_a(p_71556_1_, var3, var5, p_71556_2_)) {
                  ++var7;
               }
            }

            var3[var6] = var9;
         } else {
            p_71556_1_.func_174794_a(CommandResultStats.Type.AFFECTED_ENTITIES, 1);
            if(this.func_175786_a(p_71556_1_, var3, var5, p_71556_2_)) {
               ++var7;
            }
         }
      } else {
         var8 = new ChatComponentTranslation("commands.generic.permission", new Object[0]);
         var8.func_150256_b().func_150238_a(EnumChatFormatting.RED);
         p_71556_1_.func_145747_a(var8);
      }

      p_71556_1_.func_174794_a(CommandResultStats.Type.SUCCESS_COUNT, var7);
      return var7;
   }

   protected boolean func_175786_a(ICommandSender p_175786_1_, String[] p_175786_2_, ICommand p_175786_3_, String p_175786_4_) {
      ChatComponentTranslation var6;
      try {
         p_175786_3_.func_71515_b(p_175786_1_, p_175786_2_);
         return true;
      } catch (WrongUsageException var7) {
         var6 = new ChatComponentTranslation("commands.generic.usage", new Object[]{new ChatComponentTranslation(var7.getMessage(), var7.func_74844_a())});
         var6.func_150256_b().func_150238_a(EnumChatFormatting.RED);
         p_175786_1_.func_145747_a(var6);
      } catch (CommandException var8) {
         var6 = new ChatComponentTranslation(var8.getMessage(), var8.func_74844_a());
         var6.func_150256_b().func_150238_a(EnumChatFormatting.RED);
         p_175786_1_.func_145747_a(var6);
      } catch (Throwable var9) {
         var6 = new ChatComponentTranslation("commands.generic.exception", new Object[0]);
         var6.func_150256_b().func_150238_a(EnumChatFormatting.RED);
         p_175786_1_.func_145747_a(var6);
         field_147175_a.error("Couldn\'t process command: \'" + p_175786_4_ + "\'", var9);
      }

      return false;
   }

   public ICommand func_71560_a(ICommand p_71560_1_) {
      this.field_71562_a.put(p_71560_1_.func_71517_b(), p_71560_1_);
      this.field_71561_b.add(p_71560_1_);
      Iterator var2 = p_71560_1_.func_71514_a().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         ICommand var4 = (ICommand)this.field_71562_a.get(var3);
         if(var4 == null || !var4.func_71517_b().equals(var3)) {
            this.field_71562_a.put(var3, p_71560_1_);
         }
      }

      return p_71560_1_;
   }

   private static String[] func_71559_a(String[] p_71559_0_) {
      String[] var1 = new String[p_71559_0_.length - 1];
      System.arraycopy(p_71559_0_, 1, var1, 0, p_71559_0_.length - 1);
      return var1;
   }

   public List func_180524_a(ICommandSender p_180524_1_, String p_180524_2_, BlockPos p_180524_3_) {
      String[] var4 = p_180524_2_.split(" ", -1);
      String var5 = var4[0];
      if(var4.length == 1) {
         ArrayList var9 = Lists.newArrayList();
         Iterator var7 = this.field_71562_a.entrySet().iterator();

         while(var7.hasNext()) {
            Entry var8 = (Entry)var7.next();
            if(CommandBase.func_71523_a(var5, (String)var8.getKey()) && ((ICommand)var8.getValue()).func_71519_b(p_180524_1_)) {
               var9.add(var8.getKey());
            }
         }

         return var9;
      } else {
         if(var4.length > 1) {
            ICommand var6 = (ICommand)this.field_71562_a.get(var5);
            if(var6 != null && var6.func_71519_b(p_180524_1_)) {
               return var6.func_180525_a(p_180524_1_, func_71559_a(var4), p_180524_3_);
            }
         }

         return null;
      }
   }

   public List func_71557_a(ICommandSender p_71557_1_) {
      ArrayList var2 = Lists.newArrayList();
      Iterator var3 = this.field_71561_b.iterator();

      while(var3.hasNext()) {
         ICommand var4 = (ICommand)var3.next();
         if(var4.func_71519_b(p_71557_1_)) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public Map func_71555_a() {
      return this.field_71562_a;
   }

   private int func_82370_a(ICommand p_82370_1_, String[] p_82370_2_) {
      if(p_82370_1_ == null) {
         return -1;
      } else {
         for(int var3 = 0; var3 < p_82370_2_.length; ++var3) {
            if(p_82370_1_.func_82358_a(p_82370_2_, var3) && PlayerSelector.func_82377_a(p_82370_2_[var3])) {
               return var3;
            }
         }

         return -1;
      }
   }

}
