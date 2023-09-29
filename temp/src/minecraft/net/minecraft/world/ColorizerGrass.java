package net.minecraft.world;


public class ColorizerGrass {

   private static int[] field_77481_a = new int[65536];
   private static final String __OBFID = "CL_00000138";


   public static void func_77479_a(int[] p_77479_0_) {
      field_77481_a = p_77479_0_;
   }

   public static int func_77480_a(double p_77480_0_, double p_77480_2_) {
      p_77480_2_ *= p_77480_0_;
      int var4 = (int)((1.0D - p_77480_0_) * 255.0D);
      int var5 = (int)((1.0D - p_77480_2_) * 255.0D);
      int var6 = var5 << 8 | var4;
      return var6 > field_77481_a.length?-65281:field_77481_a[var6];
   }

}
