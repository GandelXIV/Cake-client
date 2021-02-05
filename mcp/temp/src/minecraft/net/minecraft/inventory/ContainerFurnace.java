package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerFurnace extends Container {

   private final IInventory field_75158_e;
   private int field_178152_f;
   private int field_178153_g;
   private int field_178154_h;
   private int field_178155_i;
   private static final String __OBFID = "CL_00001748";


   public ContainerFurnace(InventoryPlayer p_i45794_1_, IInventory p_i45794_2_) {
      this.field_75158_e = p_i45794_2_;
      this.func_75146_a(new Slot(p_i45794_2_, 0, 56, 17));
      this.func_75146_a(new SlotFurnaceFuel(p_i45794_2_, 1, 56, 53));
      this.func_75146_a(new SlotFurnaceOutput(p_i45794_1_.field_70458_d, p_i45794_2_, 2, 116, 35));

      int var3;
      for(var3 = 0; var3 < 3; ++var3) {
         for(int var4 = 0; var4 < 9; ++var4) {
            this.func_75146_a(new Slot(p_i45794_1_, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
         }
      }

      for(var3 = 0; var3 < 9; ++var3) {
         this.func_75146_a(new Slot(p_i45794_1_, var3, 8 + var3 * 18, 142));
      }

   }

   public void func_75132_a(ICrafting p_75132_1_) {
      super.func_75132_a(p_75132_1_);
      p_75132_1_.func_175173_a(this, this.field_75158_e);
   }

   public void func_75142_b() {
      super.func_75142_b();

      for(int var1 = 0; var1 < this.field_75149_d.size(); ++var1) {
         ICrafting var2 = (ICrafting)this.field_75149_d.get(var1);
         if(this.field_178152_f != this.field_75158_e.func_174887_a_(2)) {
            var2.func_71112_a(this, 2, this.field_75158_e.func_174887_a_(2));
         }

         if(this.field_178154_h != this.field_75158_e.func_174887_a_(0)) {
            var2.func_71112_a(this, 0, this.field_75158_e.func_174887_a_(0));
         }

         if(this.field_178155_i != this.field_75158_e.func_174887_a_(1)) {
            var2.func_71112_a(this, 1, this.field_75158_e.func_174887_a_(1));
         }

         if(this.field_178153_g != this.field_75158_e.func_174887_a_(3)) {
            var2.func_71112_a(this, 3, this.field_75158_e.func_174887_a_(3));
         }
      }

      this.field_178152_f = this.field_75158_e.func_174887_a_(2);
      this.field_178154_h = this.field_75158_e.func_174887_a_(0);
      this.field_178155_i = this.field_75158_e.func_174887_a_(1);
      this.field_178153_g = this.field_75158_e.func_174887_a_(3);
   }

   public void func_75137_b(int p_75137_1_, int p_75137_2_) {
      this.field_75158_e.func_174885_b(p_75137_1_, p_75137_2_);
   }

   public boolean func_75145_c(EntityPlayer p_75145_1_) {
      return this.field_75158_e.func_70300_a(p_75145_1_);
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
         } else if(p_82846_2_ != 1 && p_82846_2_ != 0) {
            if(FurnaceRecipes.func_77602_a().func_151395_a(var5) != null) {
               if(!this.func_75135_a(var5, 0, 1, false)) {
                  return null;
               }
            } else if(TileEntityFurnace.func_145954_b(var5)) {
               if(!this.func_75135_a(var5, 1, 2, false)) {
                  return null;
               }
            } else if(p_82846_2_ >= 3 && p_82846_2_ < 30) {
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
}
