package net.minecraft.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.util.ResourceLocation;

public class EnchantmentArrowInfinite extends Enchantment {

   private static final String __OBFID = "CL_00000100";


   public EnchantmentArrowInfinite(int p_i45776_1_, ResourceLocation p_i45776_2_, int p_i45776_3_) {
      super(p_i45776_1_, p_i45776_2_, p_i45776_3_, EnumEnchantmentType.BOW);
      this.func_77322_b("arrowInfinite");
   }

   public int func_77321_a(int p_77321_1_) {
      return 20;
   }

   public int func_77317_b(int p_77317_1_) {
      return 50;
   }

   public int func_77325_b() {
      return 1;
   }
}
