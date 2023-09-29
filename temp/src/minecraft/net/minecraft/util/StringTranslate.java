package net.minecraft.util;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.io.InputStream;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

public class StringTranslate {

   private static final Pattern field_111053_a = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");
   private static final Splitter field_135065_b = Splitter.on('=').limit(2);
   private static StringTranslate field_74817_a = new StringTranslate();
   private final Map field_74816_c = Maps.newHashMap();
   private long field_150511_e;
   private static final String __OBFID = "CL_00001212";


   public StringTranslate() {
      try {
         InputStream var1 = StringTranslate.class.getResourceAsStream("/assets/minecraft/lang/en_US.lang");
         Iterator var2 = IOUtils.readLines(var1, Charsets.UTF_8).iterator();

         while(var2.hasNext()) {
            String var3 = (String)var2.next();
            if(!var3.isEmpty() && var3.charAt(0) != 35) {
               String[] var4 = (String[])Iterables.toArray(field_135065_b.split(var3), String.class);
               if(var4 != null && var4.length == 2) {
                  String var5 = var4[0];
                  String var6 = field_111053_a.matcher(var4[1]).replaceAll("%$1s");
                  this.field_74816_c.put(var5, var6);
               }
            }
         }

         this.field_150511_e = System.currentTimeMillis();
      } catch (IOException var7) {
         ;
      }

   }

   static StringTranslate func_74808_a() {
      return field_74817_a;
   }

   public static synchronized void func_135063_a(Map p_135063_0_) {
      field_74817_a.field_74816_c.clear();
      field_74817_a.field_74816_c.putAll(p_135063_0_);
      field_74817_a.field_150511_e = System.currentTimeMillis();
   }

   public synchronized String func_74805_b(String p_74805_1_) {
      return this.func_135064_c(p_74805_1_);
   }

   public synchronized String func_74803_a(String p_74803_1_, Object ... p_74803_2_) {
      String var3 = this.func_135064_c(p_74803_1_);

      try {
         return String.format(var3, p_74803_2_);
      } catch (IllegalFormatException var5) {
         return "Format error: " + var3;
      }
   }

   private String func_135064_c(String p_135064_1_) {
      String var2 = (String)this.field_74816_c.get(p_135064_1_);
      return var2 == null?p_135064_1_:var2;
   }

   public synchronized boolean func_94520_b(String p_94520_1_) {
      return this.field_74816_c.containsKey(p_94520_1_);
   }

   public long func_150510_c() {
      return this.field_150511_e;
   }

}
