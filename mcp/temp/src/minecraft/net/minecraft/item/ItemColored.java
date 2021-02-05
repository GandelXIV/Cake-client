package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemColored extends ItemBlock {

   private final Block field_150944_b;
   private String[] field_150945_c;
   private static final String __OBFID = "CL_00000003";


   public ItemColored(Block p_i45332_1_, boolean p_i45332_2_) {
      super(p_i45332_1_);
      this.field_150944_b = p_i45332_1_;
      if(p_i45332_2_) {
         this.func_77656_e(0);
         this.func_77627_a(true);
      }

   }

   public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_) {
      return this.field_150944_b.func_180644_h(this.field_150944_b.func_176203_a(p_82790_1_.func_77960_j()));
   }

   public int func_77647_b(int p_77647_1_) {
      return p_77647_1_;
   }

   public ItemColored func_150943_a(String[] p_150943_1_) {
      this.field_150945_c = p_150943_1_;
      return this;
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      if(this.field_150945_c == null) {
         return super.func_77667_c(p_77667_1_);
      } else {
         int var2 = p_77667_1_.func_77960_j();
         return var2 >= 0 && var2 < this.field_150945_c.length?super.func_77667_c(p_77667_1_) + "." + this.field_150945_c[var2]:super.func_77667_c(p_77667_1_);
      }
   }
}
