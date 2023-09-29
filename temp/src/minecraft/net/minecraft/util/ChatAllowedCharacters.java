package net.minecraft.util;


public class ChatAllowedCharacters {

   public static final char[] field_71567_b = new char[]{'/', '\n', '\r', '\t', '\u0000', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':'};
   private static final String __OBFID = "CL_00001606";


   public static boolean func_71566_a(char p_71566_0_) {
      return p_71566_0_ != 167 && p_71566_0_ >= 32 && p_71566_0_ != 127;
   }

   public static String func_71565_a(String p_71565_0_) {
      StringBuilder var1 = new StringBuilder();
      char[] var2 = p_71565_0_.toCharArray();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         char var5 = var2[var4];
         if(func_71566_a(var5)) {
            var1.append(var5);
         }
      }

      return var1.toString();
   }

}
