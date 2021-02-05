package net.minecraft.util;

import java.util.Random;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;

public class WeightedRandomFishable extends WeightedRandom.Item {

   private final ItemStack field_150711_b;
   private float field_150712_c;
   private boolean field_150710_d;
   private static final String __OBFID = "CL_00001664";


   public WeightedRandomFishable(ItemStack p_i45317_1_, int p_i45317_2_) {
      super(p_i45317_2_);
      this.field_150711_b = p_i45317_1_;
   }

   public ItemStack func_150708_a(Random p_150708_1_) {
      ItemStack var2 = this.field_150711_b.func_77946_l();
      if(this.field_150712_c > 0.0F) {
         int var3 = (int)(this.field_150712_c * (float)this.field_150711_b.func_77958_k());
         int var4 = var2.func_77958_k() - p_150708_1_.nextInt(p_150708_1_.nextInt(var3) + 1);
         if(var4 > var3) {
            var4 = var3;
         }

         if(var4 < 1) {
            var4 = 1;
         }

         var2.func_77964_b(var4);
      }

      if(this.field_150710_d) {
         EnchantmentHelper.func_77504_a(p_150708_1_, var2, 30);
      }

      return var2;
   }

   public WeightedRandomFishable func_150709_a(float p_150709_1_) {
      this.field_150712_c = p_150709_1_;
      return this;
   }

   public WeightedRandomFishable func_150707_a() {
      this.field_150710_d = true;
      return this;
   }
}
