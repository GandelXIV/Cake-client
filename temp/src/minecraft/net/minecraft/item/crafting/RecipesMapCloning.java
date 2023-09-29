package net.minecraft.item.crafting;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class RecipesMapCloning implements IRecipe {

   private static final String __OBFID = "CL_00000087";


   public boolean func_77569_a(InventoryCrafting p_77569_1_, World p_77569_2_) {
      int var3 = 0;
      ItemStack var4 = null;

      for(int var5 = 0; var5 < p_77569_1_.func_70302_i_(); ++var5) {
         ItemStack var6 = p_77569_1_.func_70301_a(var5);
         if(var6 != null) {
            if(var6.func_77973_b() == Items.field_151098_aY) {
               if(var4 != null) {
                  return false;
               }

               var4 = var6;
            } else {
               if(var6.func_77973_b() != Items.field_151148_bJ) {
                  return false;
               }

               ++var3;
            }
         }
      }

      return var4 != null && var3 > 0;
   }

   public ItemStack func_77572_b(InventoryCrafting p_77572_1_) {
      int var2 = 0;
      ItemStack var3 = null;

      for(int var4 = 0; var4 < p_77572_1_.func_70302_i_(); ++var4) {
         ItemStack var5 = p_77572_1_.func_70301_a(var4);
         if(var5 != null) {
            if(var5.func_77973_b() == Items.field_151098_aY) {
               if(var3 != null) {
                  return null;
               }

               var3 = var5;
            } else {
               if(var5.func_77973_b() != Items.field_151148_bJ) {
                  return null;
               }

               ++var2;
            }
         }
      }

      if(var3 != null && var2 >= 1) {
         ItemStack var6 = new ItemStack(Items.field_151098_aY, var2 + 1, var3.func_77960_j());
         if(var3.func_82837_s()) {
            var6.func_151001_c(var3.func_82833_r());
         }

         return var6;
      } else {
         return null;
      }
   }

   public int func_77570_a() {
      return 9;
   }

   public ItemStack func_77571_b() {
      return null;
   }

   public ItemStack[] func_179532_b(InventoryCrafting p_179532_1_) {
      ItemStack[] var2 = new ItemStack[p_179532_1_.func_70302_i_()];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         ItemStack var4 = p_179532_1_.func_70301_a(var3);
         if(var4 != null && var4.func_77973_b().func_77634_r()) {
            var2[var3] = new ItemStack(var4.func_77973_b().func_77668_q());
         }
      }

      return var2;
   }
}
