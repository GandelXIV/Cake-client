package net.minecraft.util;

import java.util.regex.Pattern;

public class StringUtils {

   private static final Pattern field_76339_a = Pattern.compile("(?i)\\u00A7[0-9A-FK-OR]");
   private static final String __OBFID = "CL_00001501";


   public static String func_76337_a(int p_76337_0_) {
      int var1 = p_76337_0_ / 20;
      int var2 = var1 / 60;
      var1 %= 60;
      return var1 < 10?var2 + ":0" + var1:var2 + ":" + var1;
   }

   public static String func_76338_a(String p_76338_0_) {
      return field_76339_a.matcher(p_76338_0_).replaceAll("");
   }

   public static boolean func_151246_b(String p_151246_0_) {
      return org.apache.commons.lang3.StringUtils.isEmpty(p_151246_0_);
   }

}
