package net.minecraft.item;

import net.minecraft.block.BlockLeaves;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemLeaves extends ItemBlock {

   private final BlockLeaves field_150940_b;
   private static final String __OBFID = "CL_00000046";


   public ItemLeaves(BlockLeaves p_i45344_1_) {
      super(p_i45344_1_);
      this.field_150940_b = p_i45344_1_;
      this.func_77656_e(0);
      this.func_77627_a(true);
   }

   public int func_77647_b(int p_77647_1_) {
      return p_77647_1_ | 4;
   }

   public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_) {
      return this.field_150940_b.func_180644_h(this.field_150940_b.func_176203_a(p_82790_1_.func_77960_j()));
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      return super.func_77658_a() + "." + this.field_150940_b.func_176233_b(p_77667_1_.func_77960_j()).func_176840_c();
   }
}
