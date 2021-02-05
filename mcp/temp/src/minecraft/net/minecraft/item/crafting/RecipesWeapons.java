package net.minecraft.item.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class RecipesWeapons {

   private String[][] field_77585_a = new String[][]{{"X", "X", "#"}};
   private Object[][] field_77584_b;
   private static final String __OBFID = "CL_00000097";


   public RecipesWeapons() {
      this.field_77584_b = new Object[][]{{Blocks.field_150344_f, Blocks.field_150347_e, Items.field_151042_j, Items.field_151045_i, Items.field_151043_k}, {Items.field_151041_m, Items.field_151052_q, Items.field_151040_l, Items.field_151048_u, Items.field_151010_B}};
   }

   public void func_77583_a(CraftingManager p_77583_1_) {
      for(int var2 = 0; var2 < this.field_77584_b[0].length; ++var2) {
         Object var3 = this.field_77584_b[0][var2];

         for(int var4 = 0; var4 < this.field_77584_b.length - 1; ++var4) {
            Item var5 = (Item)this.field_77584_b[var4 + 1][var2];
            p_77583_1_.func_92103_a(new ItemStack(var5), new Object[]{this.field_77585_a[var4], Character.valueOf('#'), Items.field_151055_y, Character.valueOf('X'), var3});
         }
      }

      p_77583_1_.func_92103_a(new ItemStack(Items.field_151031_f, 1), new Object[]{" #X", "# X", " #X", Character.valueOf('X'), Items.field_151007_F, Character.valueOf('#'), Items.field_151055_y});
      p_77583_1_.func_92103_a(new ItemStack(Items.field_151032_g, 4), new Object[]{"X", "#", "Y", Character.valueOf('Y'), Items.field_151008_G, Character.valueOf('X'), Items.field_151145_ak, Character.valueOf('#'), Items.field_151055_y});
   }
}
