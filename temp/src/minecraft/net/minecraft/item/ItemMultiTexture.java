package net.minecraft.item;

import com.google.common.base.Function;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMultiTexture extends ItemBlock {

   protected final Block field_179227_b;
   protected final Function field_179228_c;
   private static final String __OBFID = "CL_00000051";


   public ItemMultiTexture(Block p_i45784_1_, Block p_i45784_2_, Function p_i45784_3_) {
      super(p_i45784_1_);
      this.field_179227_b = p_i45784_2_;
      this.field_179228_c = p_i45784_3_;
      this.func_77656_e(0);
      this.func_77627_a(true);
   }

   public ItemMultiTexture(Block p_i45346_1_, Block p_i45346_2_, final String[] p_i45346_3_) {
      this(p_i45346_1_, p_i45346_2_, new Function() {

         private static final String __OBFID = "CL_00002161";

         public String func_179541_a(ItemStack p_179541_1_) {
            int var2 = p_179541_1_.func_77960_j();
            if(var2 < 0 || var2 >= p_i45346_3_.length) {
               var2 = 0;
            }

            return p_i45346_3_[var2];
         }
         // $FF: synthetic method
         public Object apply(Object p_apply_1_) {
            return this.func_179541_a((ItemStack)p_apply_1_);
         }
      });
   }

   public int func_77647_b(int p_77647_1_) {
      return p_77647_1_;
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      return super.func_77658_a() + "." + (String)this.field_179228_c.apply(p_77667_1_);
   }
}
