package net.minecraft.item.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class RecipesArmor {

   private String[][] field_77611_a = new String[][]{{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
   private Item[][] field_77610_b;
   private static final String __OBFID = "CL_00000080";


   public RecipesArmor() {
      this.field_77610_b = new Item[][]{{Items.field_151116_aA, Items.field_151042_j, Items.field_151045_i, Items.field_151043_k}, {Items.field_151024_Q, Items.field_151028_Y, Items.field_151161_ac, Items.field_151169_ag}, {Items.field_151027_R, Items.field_151030_Z, Items.field_151163_ad, Items.field_151171_ah}, {Items.field_151026_S, Items.field_151165_aa, Items.field_151173_ae, Items.field_151149_ai}, {Items.field_151021_T, Items.field_151167_ab, Items.field_151175_af, Items.field_151151_aj}};
   }

   public void func_77609_a(CraftingManager p_77609_1_) {
      for(int var2 = 0; var2 < this.field_77610_b[0].length; ++var2) {
         Item var3 = this.field_77610_b[0][var2];

         for(int var4 = 0; var4 < this.field_77610_b.length - 1; ++var4) {
            Item var5 = this.field_77610_b[var4 + 1][var2];
            p_77609_1_.func_92103_a(new ItemStack(var5), new Object[]{this.field_77611_a[var4], Character.valueOf('X'), var3});
         }
      }

   }
}
