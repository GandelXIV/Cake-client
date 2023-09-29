package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ContainerWorkbench extends Container {

   public InventoryCrafting field_75162_e = new InventoryCrafting(this, 3, 3);
   public IInventory field_75160_f = new InventoryCraftResult();
   private World field_75161_g;
   private BlockPos field_178145_h;
   private static final String __OBFID = "CL_00001744";


   public ContainerWorkbench(InventoryPlayer p_i45800_1_, World p_i45800_2_, BlockPos p_i45800_3_) {
      this.field_75161_g = p_i45800_2_;
      this.field_178145_h = p_i45800_3_;
      this.func_75146_a(new SlotCrafting(p_i45800_1_.field_70458_d, this.field_75162_e, this.field_75160_f, 0, 124, 35));

      int var4;
      int var5;
      for(var4 = 0; var4 < 3; ++var4) {
         for(var5 = 0; var5 < 3; ++var5) {
            this.func_75146_a(new Slot(this.field_75162_e, var5 + var4 * 3, 30 + var5 * 18, 17 + var4 * 18));
         }
      }

      for(var4 = 0; var4 < 3; ++var4) {
         for(var5 = 0; var5 < 9; ++var5) {
            this.func_75146_a(new Slot(p_i45800_1_, var5 + var4 * 9 + 9, 8 + var5 * 18, 84 + var4 * 18));
         }
      }

      for(var4 = 0; var4 < 9; ++var4) {
         this.func_75146_a(new Slot(p_i45800_1_, var4, 8 + var4 * 18, 142));
      }

      this.func_75130_a(this.field_75162_e);
   }

   public void func_75130_a(IInventory p_75130_1_) {
      this.field_75160_f.func_70299_a(0, CraftingManager.func_77594_a().func_82787_a(this.field_75162_e, this.field_75161_g));
   }

   public void func_75134_a(EntityPlayer p_75134_1_) {
      super.func_75134_a(p_75134_1_);
      if(!this.field_75161_g.field_72995_K) {
         for(int var2 = 0; var2 < 9; ++var2) {
            ItemStack var3 = this.field_75162_e.func_70304_b(var2);
            if(var3 != null) {
               p_75134_1_.func_71019_a(var3, false);
            }
         }

      }
   }

   public boolean func_75145_c(EntityPlayer p_75145_1_) {
      return this.field_75161_g.func_180495_p(this.field_178145_h).func_177230_c() != Blocks.field_150462_ai?false:p_75145_1_.func_70092_e((double)this.field_178145_h.func_177958_n() + 0.5D, (double)this.field_178145_h.func_177956_o() + 0.5D, (double)this.field_178145_h.func_177952_p() + 0.5D) <= 64.0D;
   }

   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
      ItemStack var3 = null;
      Slot var4 = (Slot)this.field_75151_b.get(p_82846_2_);
      if(var4 != null && var4.func_75216_d()) {
         ItemStack var5 = var4.func_75211_c();
         var3 = var5.func_77946_l();
         if(p_82846_2_ == 0) {
            if(!this.func_75135_a(var5, 10, 46, true)) {
               return null;
            }

            var4.func_75220_a(var5, var3);
         } else if(p_82846_2_ >= 10 && p_82846_2_ < 37) {
            if(!this.func_75135_a(var5, 37, 46, false)) {
               return null;
            }
         } else if(p_82846_2_ >= 37 && p_82846_2_ < 46) {
            if(!this.func_75135_a(var5, 10, 37, false)) {
               return null;
            }
         } else if(!this.func_75135_a(var5, 10, 46, false)) {
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

   public boolean func_94530_a(ItemStack p_94530_1_, Slot p_94530_2_) {
      return p_94530_2_.field_75224_c != this.field_75160_f && super.func_94530_a(p_94530_1_, p_94530_2_);
   }
}
