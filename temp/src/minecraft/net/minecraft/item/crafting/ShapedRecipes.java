package net.minecraft.item.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ShapedRecipes implements IRecipe {

   private final int field_77576_b;
   private final int field_77577_c;
   private final ItemStack[] field_77574_d;
   private final ItemStack field_77575_e;
   private boolean field_92101_f;
   private static final String __OBFID = "CL_00000093";


   public ShapedRecipes(int p_i1917_1_, int p_i1917_2_, ItemStack[] p_i1917_3_, ItemStack p_i1917_4_) {
      this.field_77576_b = p_i1917_1_;
      this.field_77577_c = p_i1917_2_;
      this.field_77574_d = p_i1917_3_;
      this.field_77575_e = p_i1917_4_;
   }

   public ItemStack func_77571_b() {
      return this.field_77575_e;
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

   public boolean func_77569_a(InventoryCrafting p_77569_1_, World p_77569_2_) {
      for(int var3 = 0; var3 <= 3 - this.field_77576_b; ++var3) {
         for(int var4 = 0; var4 <= 3 - this.field_77577_c; ++var4) {
            if(this.func_77573_a(p_77569_1_, var3, var4, true)) {
               return true;
            }

            if(this.func_77573_a(p_77569_1_, var3, var4, false)) {
               return true;
            }
         }
      }

      return false;
   }

   private boolean func_77573_a(InventoryCrafting p_77573_1_, int p_77573_2_, int p_77573_3_, boolean p_77573_4_) {
      for(int var5 = 0; var5 < 3; ++var5) {
         for(int var6 = 0; var6 < 3; ++var6) {
            int var7 = var5 - p_77573_2_;
            int var8 = var6 - p_77573_3_;
            ItemStack var9 = null;
            if(var7 >= 0 && var8 >= 0 && var7 < this.field_77576_b && var8 < this.field_77577_c) {
               if(p_77573_4_) {
                  var9 = this.field_77574_d[this.field_77576_b - var7 - 1 + var8 * this.field_77576_b];
               } else {
                  var9 = this.field_77574_d[var7 + var8 * this.field_77576_b];
               }
            }

            ItemStack var10 = p_77573_1_.func_70463_b(var5, var6);
            if(var10 != null || var9 != null) {
               if(var10 == null && var9 != null || var10 != null && var9 == null) {
                  return false;
               }

               if(var9.func_77973_b() != var10.func_77973_b()) {
                  return false;
               }

               if(var9.func_77960_j() != 32767 && var9.func_77960_j() != var10.func_77960_j()) {
                  return false;
               }
            }
         }
      }

      return true;
   }

   public ItemStack func_77572_b(InventoryCrafting p_77572_1_) {
      ItemStack var2 = this.func_77571_b().func_77946_l();
      if(this.field_92101_f) {
         for(int var3 = 0; var3 < p_77572_1_.func_70302_i_(); ++var3) {
            ItemStack var4 = p_77572_1_.func_70301_a(var3);
            if(var4 != null && var4.func_77942_o()) {
               var2.func_77982_d((NBTTagCompound)var4.func_77978_p().func_74737_b());
            }
         }
      }

      return var2;
   }

   public int func_77570_a() {
      return this.field_77576_b * this.field_77577_c;
   }

   public ShapedRecipes func_92100_c() {
      this.field_92101_f = true;
      return this;
   }
}
