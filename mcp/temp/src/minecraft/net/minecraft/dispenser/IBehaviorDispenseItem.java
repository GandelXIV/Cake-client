package net.minecraft.dispenser;

import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.ItemStack;

public interface IBehaviorDispenseItem {

   IBehaviorDispenseItem field_82483_a = new IBehaviorDispenseItem() {

      private static final String __OBFID = "CL_00001200";

      public ItemStack func_82482_a(IBlockSource p_82482_1_, ItemStack p_82482_2_) {
         return p_82482_2_;
      }
   };


   ItemStack func_82482_a(IBlockSource var1, ItemStack var2);

}
