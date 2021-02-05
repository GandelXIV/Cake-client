package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;

public class ItemAnvilBlock extends ItemMultiTexture {

   private static final String __OBFID = "CL_00001764";


   public ItemAnvilBlock(Block p_i1826_1_) {
      super(p_i1826_1_, p_i1826_1_, new String[]{"intact", "slightlyDamaged", "veryDamaged"});
   }

   public int func_77647_b(int p_77647_1_) {
      return p_77647_1_ << 2;
   }
}
