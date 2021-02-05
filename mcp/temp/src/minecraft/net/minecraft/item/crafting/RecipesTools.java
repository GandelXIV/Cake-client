package net.minecraft.item.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class RecipesTools {

   private String[][] field_77588_a = new String[][]{{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
   private Object[][] field_77587_b;
   private static final String __OBFID = "CL_00000096";


   public RecipesTools() {
      this.field_77587_b = new Object[][]{{Blocks.field_150344_f, Blocks.field_150347_e, Items.field_151042_j, Items.field_151045_i, Items.field_151043_k}, {Items.field_151039_o, Items.field_151050_s, Items.field_151035_b, Items.field_151046_w, Items.field_151005_D}, {Items.field_151038_n, Items.field_151051_r, Items.field_151037_a, Items.field_151047_v, Items.field_151011_C}, {Items.field_151053_p, Items.field_151049_t, Items.field_151036_c, Items.field_151056_x, Items.field_151006_E}, {Items.field_151017_I, Items.field_151018_J, Items.field_151019_K, Items.field_151012_L, Items.field_151013_M}};
   }

   public void func_77586_a(CraftingManager p_77586_1_) {
      for(int var2 = 0; var2 < this.field_77587_b[0].length; ++var2) {
         Object var3 = this.field_77587_b[0][var2];

         for(int var4 = 0; var4 < this.field_77587_b.length - 1; ++var4) {
            Item var5 = (Item)this.field_77587_b[var4 + 1][var2];
            p_77586_1_.func_92103_a(new ItemStack(var5), new Object[]{this.field_77588_a[var4], Character.valueOf('#'), Items.field_151055_y, Character.valueOf('X'), var3});
         }
      }

      p_77586_1_.func_92103_a(new ItemStack(Items.field_151097_aZ), new Object[]{" #", "# ", Character.valueOf('#'), Items.field_151042_j});
   }
}
