package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerHopper extends Container {

   private final IInventory field_94538_a;
   private static final String __OBFID = "CL_00001750";


   public ContainerHopper(InventoryPlayer p_i45792_1_, IInventory p_i45792_2_, EntityPlayer p_i45792_3_) {
      this.field_94538_a = p_i45792_2_;
      p_i45792_2_.func_174889_b(p_i45792_3_);
      byte var4 = 51;

      int var5;
      for(var5 = 0; var5 < p_i45792_2_.func_70302_i_(); ++var5) {
         this.func_75146_a(new Slot(p_i45792_2_, var5, 44 + var5 * 18, 20));
      }

      for(var5 = 0; var5 < 3; ++var5) {
         for(int var6 = 0; var6 < 9; ++var6) {
            this.func_75146_a(new Slot(p_i45792_1_, var6 + var5 * 9 + 9, 8 + var6 * 18, var5 * 18 + var4));
         }
      }

      for(var5 = 0; var5 < 9; ++var5) {
         this.func_75146_a(new Slot(p_i45792_1_, var5, 8 + var5 * 18, 58 + var4));
      }

   }

   public boolean func_75145_c(EntityPlayer p_75145_1_) {
      return this.field_94538_a.func_70300_a(p_75145_1_);
   }

   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
      ItemStack var3 = null;
      Slot var4 = (Slot)this.field_75151_b.get(p_82846_2_);
      if(var4 != null && var4.func_75216_d()) {
         ItemStack var5 = var4.func_75211_c();
         var3 = var5.func_77946_l();
         if(p_82846_2_ < this.field_94538_a.func_70302_i_()) {
            if(!this.func_75135_a(var5, this.field_94538_a.func_70302_i_(), this.field_75151_b.size(), true)) {
               return null;
            }
         } else if(!this.func_75135_a(var5, 0, this.field_94538_a.func_70302_i_(), false)) {
            return null;
         }

         if(var5.field_77994_a == 0) {
            var4.func_75215_d((ItemStack)null);
         } else {
            var4.func_75218_e();
         }
      }

      return var3;
   }

   public void func_75134_a(EntityPlayer p_75134_1_) {
      super.func_75134_a(p_75134_1_);
      this.field_94538_a.func_174886_c(p_75134_1_);
   }
}
