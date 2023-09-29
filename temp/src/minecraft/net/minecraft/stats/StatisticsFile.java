package net.minecraft.stats;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.S37PacketStatistics;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.stats.StatList;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IJsonSerializable;
import net.minecraft.util.TupleIntJsonSerializable;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StatisticsFile extends StatFileWriter {

   private static final Logger field_150889_b = LogManager.getLogger();
   private final MinecraftServer field_150890_c;
   private final File field_150887_d;
   private final Set field_150888_e = Sets.newHashSet();
   private int field_150885_f = -300;
   private boolean field_150886_g = false;
   private static final String __OBFID = "CL_00001471";


   public StatisticsFile(MinecraftServer p_i45306_1_, File p_i45306_2_) {
      this.field_150890_c = p_i45306_1_;
      this.field_150887_d = p_i45306_2_;
   }

   public void func_150882_a() {
      if(this.field_150887_d.isFile()) {
         try {
            this.field_150875_a.clear();
            this.field_150875_a.putAll(this.func_150881_a(FileUtils.readFileToString(this.field_150887_d)));
         } catch (IOException var2) {
            field_150889_b.error("Couldn\'t read statistics file " + this.field_150887_d, var2);
         } catch (JsonParseException var3) {
            field_150889_b.error("Couldn\'t parse statistics file " + this.field_150887_d, var3);
         }
      }

   }

   public void func_150883_b() {
      try {
         FileUtils.writeStringToFile(this.field_150887_d, func_150880_a(this.field_150875_a));
      } catch (IOException var2) {
         field_150889_b.error("Couldn\'t save stats", var2);
      }

   }

   public void func_150873_a(EntityPlayer p_150873_1_, StatBase p_150873_2_, int p_150873_3_) {
      int var4 = p_150873_2_.func_75967_d()?this.func_77444_a(p_150873_2_):0;
      super.func_150873_a(p_150873_1_, p_150873_2_, p_150873_3_);
      this.field_150888_e.add(p_150873_2_);
      if(p_150873_2_.func_75967_d() && var4 == 0 && p_150873_3_ > 0) {
         this.field_150886_g = true;
         if(this.field_150890_c.func_147136_ar()) {
            this.field_150890_c.func_71203_ab().func_148539_a(new ChatComponentTranslation("chat.type.achievement", new Object[]{p_150873_1_.func_145748_c_(), p_150873_2_.func_150955_j()}));
         }
      }

      if(p_150873_2_.func_75967_d() && var4 > 0 && p_150873_3_ == 0) {
         this.field_150886_g = true;
         if(this.field_150890_c.func_147136_ar()) {
            this.field_150890_c.func_71203_ab().func_148539_a(new ChatComponentTranslation("chat.type.achievement.taken", new Object[]{p_150873_1_.func_145748_c_(), p_150873_2_.func_150955_j()}));
         }
      }

   }

   public Set func_150878_c() {
      HashSet var1 = Sets.newHashSet(this.field_150888_e);
      this.field_150888_e.clear();
      this.field_150886_g = false;
      return var1;
   }

   public Map func_150881_a(String p_150881_1_) {
      JsonElement var2 = (new JsonParser()).parse(p_150881_1_);
      if(!var2.isJsonObject()) {
         return Maps.newHashMap();
      } else {
         JsonObject var3 = var2.getAsJsonObject();
         HashMap var4 = Maps.newHashMap();
         Iterator var5 = var3.entrySet().iterator();

         while(var5.hasNext()) {
            Entry var6 = (Entry)var5.next();
            StatBase var7 = StatList.func_151177_a((String)var6.getKey());
            if(var7 != null) {
               TupleIntJsonSerializable var8 = new TupleIntJsonSerializable();
               if(((JsonElement)var6.getValue()).isJsonPrimitive() && ((JsonElement)var6.getValue()).getAsJsonPrimitive().isNumber()) {
                  var8.func_151188_a(((JsonElement)var6.getValue()).getAsInt());
               } else if(((JsonElement)var6.getValue()).isJsonObject()) {
                  JsonObject var9 = ((JsonElement)var6.getValue()).getAsJsonObject();
                  if(var9.has("value") && var9.get("value").isJsonPrimitive() && var9.get("value").getAsJsonPrimitive().isNumber()) {
                     var8.func_151188_a(var9.getAsJsonPrimitive("value").getAsInt());
                  }

                  if(var9.has("progress") && var7.func_150954_l() != null) {
                     try {
                        Constructor var10 = var7.func_150954_l().getConstructor(new Class[0]);
                        IJsonSerializable var11 = (IJsonSerializable)var10.newInstance(new Object[0]);
                        var11.func_152753_a(var9.get("progress"));
                        var8.func_151190_a(var11);
                     } catch (Throwable var12) {
                        field_150889_b.warn("Invalid statistic progress in " + this.field_150887_d, var12);
                     }
                  }
               }

               var4.put(var7, var8);
            } else {
               field_150889_b.warn("Invalid statistic in " + this.field_150887_d + ": Don\'t know what " + (String)var6.getKey() + " is");
            }
         }

         return var4;
      }
   }

   public static String func_150880_a(Map p_150880_0_) {
      JsonObject var1 = new JsonObject();
      Iterator var2 = p_150880_0_.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(((TupleIntJsonSerializable)var3.getValue()).func_151187_b() != null) {
            JsonObject var4 = new JsonObject();
            var4.addProperty("value", Integer.valueOf(((TupleIntJsonSerializable)var3.getValue()).func_151189_a()));

            try {
               var4.add("progress", ((TupleIntJsonSerializable)var3.getValue()).func_151187_b().func_151003_a());
            } catch (Throwable var6) {
               field_150889_b.warn("Couldn\'t save statistic " + ((StatBase)var3.getKey()).func_150951_e() + ": error serializing progress", var6);
            }

            var1.add(((StatBase)var3.getKey()).field_75975_e, var4);
         } else {
            var1.addProperty(((StatBase)var3.getKey()).field_75975_e, Integer.valueOf(((TupleIntJsonSerializable)var3.getValue()).func_151189_a()));
         }
      }

      return var1.toString();
   }

   public void func_150877_d() {
      Iterator var1 = this.field_150875_a.keySet().iterator();

      while(var1.hasNext()) {
         StatBase var2 = (StatBase)var1.next();
         this.field_150888_e.add(var2);
      }

   }

   public void func_150876_a(EntityPlayerMP p_150876_1_) {
      int var2 = this.field_150890_c.func_71259_af();
      HashMap var3 = Maps.newHashMap();
      if(this.field_150886_g || var2 - this.field_150885_f > 300) {
         this.field_150885_f = var2;
         Iterator var4 = this.func_150878_c().iterator();

         while(var4.hasNext()) {
            StatBase var5 = (StatBase)var4.next();
            var3.put(var5, Integer.valueOf(this.func_77444_a(var5)));
         }
      }

      p_150876_1_.field_71135_a.func_147359_a(new S37PacketStatistics(var3));
   }

   public void func_150884_b(EntityPlayerMP p_150884_1_) {
      HashMap var2 = Maps.newHashMap();
      Iterator var3 = AchievementList.field_76007_e.iterator();

      while(var3.hasNext()) {
         Achievement var4 = (Achievement)var3.next();
         if(this.func_77443_a(var4)) {
            var2.put(var4, Integer.valueOf(this.func_77444_a(var4)));
            this.field_150888_e.remove(var4);
         }
      }

      p_150884_1_.field_71135_a.func_147359_a(new S37PacketStatistics(var2));
   }

   public boolean func_150879_e() {
      return this.field_150886_g;
   }

}
