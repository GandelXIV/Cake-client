package net.minecraft.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.WeightedRandom;

public class EnchantmentData extends WeightedRandom.Item {

   public final Enchantment field_76302_b;
   public final int field_76303_c;
   private static final String __OBFID = "CL_00000115";


   public EnchantmentData(Enchantment p_i1930_1_, int p_i1930_2_) {
      super(p_i1930_1_.func_77324_c());
      this.field_76302_b = p_i1930_1_;
      this.field_76303_c = p_i1930_2_;
   }
}
