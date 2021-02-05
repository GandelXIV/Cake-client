package net.minecraft.inventory;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryMerchant;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.village.MerchantRecipe;

public class SlotMerchantResult extends Slot {

   private final InventoryMerchant field_75233_a;
   private EntityPlayer field_75232_b;
   private int field_75231_g;
   private final IMerchant field_75234_h;
   private static final String __OBFID = "CL_00001758";


   public SlotMerchantResult(EntityPlayer p_i1822_1_, IMerchant p_i1822_2_, InventoryMerchant p_i1822_3_, int p_i1822_4_, int p_i1822_5_, int p_i1822_6_) {
      super(p_i1822_3_, p_i1822_4_, p_i1822_5_, p_i1822_6_);
      this.field_75232_b = p_i1822_1_;
      this.field_75234_h = p_i1822_2_;
      this.field_75233_a = p_i1822_3_;
   }

   public boolean func_75214_a(ItemStack p_75214_1_) {
      return false;
   }

   public ItemStack func_75209_a(int p_75209_1_) {
      if(this.func_75216_d()) {
         this.field_75231_g += Math.min(p_75209_1_, this.func_75211_c().field_77994_a);
      }

      return super.func_75209_a(p_75209_1_);
   }

   protected void func_75210_a(ItemStack p_75210_1_, int p_75210_2_) {
      this.field_75231_g += p_75210_2_;
      this.func_75208_c(p_75210_1_);
   }

   protected void func_75208_c(ItemStack p_75208_1_) {
      p_75208_1_.func_77980_a(this.field_75232_b.field_70170_p, this.field_75232_b, this.field_75231_g);
      this.field_75231_g = 0;
   }

   public void func_82870_a(EntityPlayer p_82870_1_, ItemStack p_82870_2_) {
      this.func_75208_c(p_82870_2_);
      MerchantRecipe var3 = this.field_75233_a.func_70468_h();
      if(var3 != null) {
         ItemStack var4 = this.field_75233_a.func_70301_a(0);
         ItemStack var5 = this.field_75233_a.func_70301_a(1);
         if(this.func_75230_a(var3, var4, var5) || this.func_75230_a(var3, var5, var4)) {
            this.field_75234_h.func_70933_a(var3);
            p_82870_1_.func_71029_a(StatList.field_180206_G);
            if(var4 != null && var4.field_77994_a <= 0) {
               var4 = null;
            }

            if(var5 != null && var5.field_77994_a <= 0) {
               var5 = null;
            }

            this.field_75233_a.func_70299_a(0, var4);
            this.field_75233_a.func_70299_a(1, var5);
         }
      }

   }

   private boolean func_75230_a(MerchantRecipe p_75230_1_, ItemStack p_75230_2_, ItemStack p_75230_3_) {
      ItemStack var4 = p_75230_1_.func_77394_a();
      ItemStack var5 = p_75230_1_.func_77396_b();
      if(p_75230_2_ != null && p_75230_2_.func_77973_b() == var4.func_77973_b()) {
         if(var5 != null && p_75230_3_ != null && var5.func_77973_b() == p_75230_3_.func_77973_b()) {
            p_75230_2_.field_77994_a -= var4.field_77994_a;
            p_75230_3_.field_77994_a -= var5.field_77994_a;
            return true;
         }

         if(var5 == null && p_75230_3_ == null) {
            p_75230_2_.field_77994_a -= var4.field_77994_a;
            return true;
         }
      }

      return false;
   }
}
