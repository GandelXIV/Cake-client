package net.minecraft.inventory;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryMerchant;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotMerchantResult;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerMerchant extends Container {

   private IMerchant field_75178_e;
   private InventoryMerchant field_75176_f;
   private final World field_75177_g;
   private static final String __OBFID = "CL_00001757";


   public ContainerMerchant(InventoryPlayer p_i1821_1_, IMerchant p_i1821_2_, World p_i1821_3_) {
      this.field_75178_e = p_i1821_2_;
      this.field_75177_g = p_i1821_3_;
      this.field_75176_f = new InventoryMerchant(p_i1821_1_.field_70458_d, p_i1821_2_);
      this.func_75146_a(new Slot(this.field_75176_f, 0, 36, 53));
      this.func_75146_a(new Slot(this.field_75176_f, 1, 62, 53));
      this.func_75146_a(new SlotMerchantResult(p_i1821_1_.field_70458_d, p_i1821_2_, this.field_75176_f, 2, 120, 53));

      int var4;
      for(var4 = 0; var4 < 3; ++var4) {
         for(int var5 = 0; var5 < 9; ++var5) {
            this.func_75146_a(new Slot(p_i1821_1_, var5 + var4 * 9 + 9, 8 + var5 * 18, 84 + var4 * 18));
         }
      }

      for(var4 = 0; var4 < 9; ++var4) {
         this.func_75146_a(new Slot(p_i1821_1_, var4, 8 + var4 * 18, 142));
      }

   }

   public InventoryMerchant func_75174_d() {
      return this.field_75176_f;
   }

   public void func_75132_a(ICrafting p_75132_1_) {
      super.func_75132_a(p_75132_1_);
   }

   public void func_75142_b() {
      super.func_75142_b();
   }

   public void func_75130_a(IInventory p_75130_1_) {
      this.field_75176_f.func_70470_g();
      super.func_75130_a(p_75130_1_);
   }

   public void func_75175_c(int p_75175_1_) {
      this.field_75176_f.func_70471_c(p_75175_1_);
   }

   public void func_75137_b(int p_75137_1_, int p_75137_2_) {}

   public boolean func_75145_c(EntityPlayer p_75145_1_) {
      return this.field_75178_e.func_70931_l_() == p_75145_1_;
   }

   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
      ItemStack var3 = null;
      Slot var4 = (Slot)this.field_75151_b.get(p_82846_2_);
      if(var4 != null && var4.func_75216_d()) {
         ItemStack var5 = var4.func_75211_c();
         var3 = var5.func_77946_l();
         if(p_82846_2_ == 2) {
            if(!this.func_75135_a(var5, 3, 39, true)) {
               return null;
            }

            var4.func_75220_a(var5, var3);
         } else if(p_82846_2_ != 0 && p_82846_2_ != 1) {
            if(p_82846_2_ >= 3 && p_82846_2_ < 30) {
               if(!this.func_75135_a(var5, 30, 39, false)) {
                  return null;
               }
            } else if(p_82846_2_ >= 30 && p_82846_2_ < 39 && !this.func_75135_a(var5, 3, 30, false)) {
               return null;
            }
         } else if(!this.func_75135_a(var5, 3, 39, false)) {
            return null;
         }

         if(var5.field_77994_a == 0) {
            var4.func_75215_d((ItemStack)null);
         } else {
            var4.func_75218_e();
         }

         if(var5.field_77994_a == var3.field_77994_a) {
            return null;
         }

         var4.func_82870_a(p_82846_1_, var5);
      }

      return var3;
   }

   public void func_75134_a(EntityPlayer p_75134_1_) {
      super.func_75134_a(p_75134_1_);
      this.field_75178_e.func_70932_a_((EntityPlayer)null);
      super.func_75134_a(p_75134_1_);
      if(!this.field_75177_g.field_72995_K) {
         ItemStack var2 = this.field_75176_f.func_70304_b(0);
         if(var2 != null) {
            p_75134_1_.func_71019_a(var2, false);
         }

         var2 = this.field_75176_f.func_70304_b(1);
         if(var2 != null) {
            p_75134_1_.func_71019_a(var2, false);
         }

      }
   }
}
