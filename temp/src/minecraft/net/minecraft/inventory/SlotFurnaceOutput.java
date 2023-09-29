package net.minecraft.inventory;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.MathHelper;

public class SlotFurnaceOutput extends Slot {

   private EntityPlayer field_75229_a;
   private int field_75228_b;
   private static final String __OBFID = "CL_00002183";


   public SlotFurnaceOutput(EntityPlayer p_i45793_1_, IInventory p_i45793_2_, int p_i45793_3_, int p_i45793_4_, int p_i45793_5_) {
      super(p_i45793_2_, p_i45793_3_, p_i45793_4_, p_i45793_5_);
      this.field_75229_a = p_i45793_1_;
   }

   public boolean func_75214_a(ItemStack p_75214_1_) {
      return false;
   }

   public ItemStack func_75209_a(int p_75209_1_) {
      if(this.func_75216_d()) {
         this.field_75228_b += Math.min(p_75209_1_, this.func_75211_c().field_77994_a);
      }

      return super.func_75209_a(p_75209_1_);
   }

   public void func_82870_a(EntityPlayer p_82870_1_, ItemStack p_82870_2_) {
      this.func_75208_c(p_82870_2_);
      super.func_82870_a(p_82870_1_, p_82870_2_);
   }

   protected void func_75210_a(ItemStack p_75210_1_, int p_75210_2_) {
      this.field_75228_b += p_75210_2_;
      this.func_75208_c(p_75210_1_);
   }

   protected void func_75208_c(ItemStack p_75208_1_) {
      p_75208_1_.func_77980_a(this.field_75229_a.field_70170_p, this.field_75229_a, this.field_75228_b);
      if(!this.field_75229_a.field_70170_p.field_72995_K) {
         int var2 = this.field_75228_b;
         float var3 = FurnaceRecipes.func_77602_a().func_151398_b(p_75208_1_);
         int var4;
         if(var3 == 0.0F) {
            var2 = 0;
         } else if(var3 < 1.0F) {
            var4 = MathHelper.func_76141_d((float)var2 * var3);
            if(var4 < MathHelper.func_76123_f((float)var2 * var3) && Math.random() < (double)((float)var2 * var3 - (float)var4)) {
               ++var4;
            }

            var2 = var4;
         }

         while(var2 > 0) {
            var4 = EntityXPOrb.func_70527_a(var2);
            var2 -= var4;
            this.field_75229_a.field_70170_p.func_72838_d(new EntityXPOrb(this.field_75229_a.field_70170_p, this.field_75229_a.field_70165_t, this.field_75229_a.field_70163_u + 0.5D, this.field_75229_a.field_70161_v + 0.5D, var4));
         }
      }

      this.field_75228_b = 0;
      if(p_75208_1_.func_77973_b() == Items.field_151042_j) {
         this.field_75229_a.func_71029_a(AchievementList.field_76016_k);
      }

      if(p_75208_1_.func_77973_b() == Items.field_179566_aV) {
         this.field_75229_a.func_71029_a(AchievementList.field_76026_p);
      }

   }
}
