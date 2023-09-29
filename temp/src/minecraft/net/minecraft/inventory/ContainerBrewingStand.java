package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;

public class ContainerBrewingStand extends Container {

   private IInventory field_75188_e;
   private final Slot field_75186_f;
   private int field_75187_g;
   private static final String __OBFID = "CL_00001737";


   public ContainerBrewingStand(InventoryPlayer p_i45802_1_, IInventory p_i45802_2_) {
      this.field_75188_e = p_i45802_2_;
      this.func_75146_a(new ContainerBrewingStand.Potion(p_i45802_1_.field_70458_d, p_i45802_2_, 0, 56, 46));
      this.func_75146_a(new ContainerBrewingStand.Potion(p_i45802_1_.field_70458_d, p_i45802_2_, 1, 79, 53));
      this.func_75146_a(new ContainerBrewingStand.Potion(p_i45802_1_.field_70458_d, p_i45802_2_, 2, 102, 46));
      this.field_75186_f = this.func_75146_a(new ContainerBrewingStand.Ingredient(p_i45802_2_, 3, 79, 17));

      int var3;
      for(var3 = 0; var3 < 3; ++var3) {
         for(int var4 = 0; var4 < 9; ++var4) {
            this.func_75146_a(new Slot(p_i45802_1_, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
         }
      }

      for(var3 = 0; var3 < 9; ++var3) {
         this.func_75146_a(new Slot(p_i45802_1_, var3, 8 + var3 * 18, 142));
      }

   }

   public void func_75132_a(ICrafting p_75132_1_) {
      super.func_75132_a(p_75132_1_);
      p_75132_1_.func_175173_a(this, this.field_75188_e);
   }

   public void func_75142_b() {
      super.func_75142_b();

      for(int var1 = 0; var1 < this.field_75149_d.size(); ++var1) {
         ICrafting var2 = (ICrafting)this.field_75149_d.get(var1);
         if(this.field_75187_g != this.field_75188_e.func_174887_a_(0)) {
            var2.func_71112_a(this, 0, this.field_75188_e.func_174887_a_(0));
         }
      }

      this.field_75187_g = this.field_75188_e.func_174887_a_(0);
   }

   public void func_75137_b(int p_75137_1_, int p_75137_2_) {
      this.field_75188_e.func_174885_b(p_75137_1_, p_75137_2_);
   }

   public boolean func_75145_c(EntityPlayer p_75145_1_) {
      return this.field_75188_e.func_70300_a(p_75145_1_);
   }

   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
      ItemStack var3 = null;
      Slot var4 = (Slot)this.field_75151_b.get(p_82846_2_);
      if(var4 != null && var4.func_75216_d()) {
         ItemStack var5 = var4.func_75211_c();
         var3 = var5.func_77946_l();
         if((p_82846_2_ < 0 || p_82846_2_ > 2) && p_82846_2_ != 3) {
            if(!this.field_75186_f.func_75216_d() && this.field_75186_f.func_75214_a(var5)) {
               if(!this.func_75135_a(var5, 3, 4, false)) {
                  return null;
               }
            } else if(ContainerBrewingStand.Potion.func_75243_a_(var3)) {
               if(!this.func_75135_a(var5, 0, 3, false)) {
                  return null;
               }
            } else if(p_82846_2_ >= 4 && p_82846_2_ < 31) {
               if(!this.func_75135_a(var5, 31, 40, false)) {
                  return null;
               }
            } else if(p_82846_2_ >= 31 && p_82846_2_ < 40) {
               if(!this.func_75135_a(var5, 4, 31, false)) {
                  return null;
               }
            } else if(!this.func_75135_a(var5, 4, 40, false)) {
               return null;
            }
         } else {
            if(!this.func_75135_a(var5, 4, 40, true)) {
               return null;
            }

            var4.func_75220_a(var5, var3);
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

   class Ingredient extends Slot {

      private static final String __OBFID = "CL_00001738";


      public Ingredient(IInventory p_i1803_2_, int p_i1803_3_, int p_i1803_4_, int p_i1803_5_) {
         super(p_i1803_2_, p_i1803_3_, p_i1803_4_, p_i1803_5_);
      }

      public boolean func_75214_a(ItemStack p_75214_1_) {
         return p_75214_1_ != null?p_75214_1_.func_77973_b().func_150892_m(p_75214_1_):false;
      }

      public int func_75219_a() {
         return 64;
      }
   }

   static class Potion extends Slot {

      private EntityPlayer field_75244_a;
      private static final String __OBFID = "CL_00001740";


      public Potion(EntityPlayer p_i1804_1_, IInventory p_i1804_2_, int p_i1804_3_, int p_i1804_4_, int p_i1804_5_) {
         super(p_i1804_2_, p_i1804_3_, p_i1804_4_, p_i1804_5_);
         this.field_75244_a = p_i1804_1_;
      }

      public boolean func_75214_a(ItemStack p_75214_1_) {
         return func_75243_a_(p_75214_1_);
      }

      public int func_75219_a() {
         return 1;
      }

      public void func_82870_a(EntityPlayer p_82870_1_, ItemStack p_82870_2_) {
         if(p_82870_2_.func_77973_b() == Items.field_151068_bn && p_82870_2_.func_77960_j() > 0) {
            this.field_75244_a.func_71029_a(AchievementList.field_76001_A);
         }

         super.func_82870_a(p_82870_1_, p_82870_2_);
      }

      public static boolean func_75243_a_(ItemStack p_75243_0_) {
         return p_75243_0_ != null && (p_75243_0_.func_77973_b() == Items.field_151068_bn || p_75243_0_.func_77973_b() == Items.field_151069_bo);
      }
   }
}
