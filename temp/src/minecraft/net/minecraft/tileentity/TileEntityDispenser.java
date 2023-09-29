package net.minecraft.tileentity;

import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerDispenser;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityLockable;

public class TileEntityDispenser extends TileEntityLockable implements IInventory {

   private static final Random field_174913_f = new Random();
   private ItemStack[] field_146022_i = new ItemStack[9];
   protected String field_146020_a;
   private static final String __OBFID = "CL_00000352";


   public int func_70302_i_() {
      return 9;
   }

   public ItemStack func_70301_a(int p_70301_1_) {
      return this.field_146022_i[p_70301_1_];
   }

   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
      if(this.field_146022_i[p_70298_1_] != null) {
         ItemStack var3;
         if(this.field_146022_i[p_70298_1_].field_77994_a <= p_70298_2_) {
            var3 = this.field_146022_i[p_70298_1_];
            this.field_146022_i[p_70298_1_] = null;
            this.func_70296_d();
            return var3;
         } else {
            var3 = this.field_146022_i[p_70298_1_].func_77979_a(p_70298_2_);
            if(this.field_146022_i[p_70298_1_].field_77994_a == 0) {
               this.field_146022_i[p_70298_1_] = null;
            }

            this.func_70296_d();
            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack func_70304_b(int p_70304_1_) {
      if(this.field_146022_i[p_70304_1_] != null) {
         ItemStack var2 = this.field_146022_i[p_70304_1_];
         this.field_146022_i[p_70304_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public int func_146017_i() {
      int var1 = -1;
      int var2 = 1;

      for(int var3 = 0; var3 < this.field_146022_i.length; ++var3) {
         if(this.field_146022_i[var3] != null && field_174913_f.nextInt(var2++) == 0) {
            var1 = var3;
         }
      }

      return var1;
   }

   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
      this.field_146022_i[p_70299_1_] = p_70299_2_;
      if(p_70299_2_ != null && p_70299_2_.field_77994_a > this.func_70297_j_()) {
         p_70299_2_.field_77994_a = this.func_70297_j_();
      }

      this.func_70296_d();
   }

   public int func_146019_a(ItemStack p_146019_1_) {
      for(int var2 = 0; var2 < this.field_146022_i.length; ++var2) {
         if(this.field_146022_i[var2] == null || this.field_146022_i[var2].func_77973_b() == null) {
            this.func_70299_a(var2, p_146019_1_);
            return var2;
         }
      }

      return -1;
   }

   public String func_70005_c_() {
      return this.func_145818_k_()?this.field_146020_a:"container.dispenser";
   }

   public void func_146018_a(String p_146018_1_) {
      this.field_146020_a = p_146018_1_;
   }

   public boolean func_145818_k_() {
      return this.field_146020_a != null;
   }

   public void func_145839_a(NBTTagCompound p_145839_1_) {
      super.func_145839_a(p_145839_1_);
      NBTTagList var2 = p_145839_1_.func_150295_c("Items", 10);
      this.field_146022_i = new ItemStack[this.func_70302_i_()];

      for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
         NBTTagCompound var4 = var2.func_150305_b(var3);
         int var5 = var4.func_74771_c("Slot") & 255;
         if(var5 >= 0 && var5 < this.field_146022_i.length) {
            this.field_146022_i[var5] = ItemStack.func_77949_a(var4);
         }
      }

      if(p_145839_1_.func_150297_b("CustomName", 8)) {
         this.field_146020_a = p_145839_1_.func_74779_i("CustomName");
      }

   }

   public void func_145841_b(NBTTagCompound p_145841_1_) {
      super.func_145841_b(p_145841_1_);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.field_146022_i.length; ++var3) {
         if(this.field_146022_i[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.func_74774_a("Slot", (byte)var3);
            this.field_146022_i[var3].func_77955_b(var4);
            var2.func_74742_a(var4);
         }
      }

      p_145841_1_.func_74782_a("Items", var2);
      if(this.func_145818_k_()) {
         p_145841_1_.func_74778_a("CustomName", this.field_146020_a);
      }

   }

   public int func_70297_j_() {
      return 64;
   }

   public boolean func_70300_a(EntityPlayer p_70300_1_) {
      return this.field_145850_b.func_175625_s(this.field_174879_c) != this?false:p_70300_1_.func_70092_e((double)this.field_174879_c.func_177958_n() + 0.5D, (double)this.field_174879_c.func_177956_o() + 0.5D, (double)this.field_174879_c.func_177952_p() + 0.5D) <= 64.0D;
   }

   public void func_174889_b(EntityPlayer p_174889_1_) {}

   public void func_174886_c(EntityPlayer p_174886_1_) {}

   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
      return true;
   }

   public String func_174875_k() {
      return "minecraft:dispenser";
   }

   public Container func_174876_a(InventoryPlayer p_174876_1_, EntityPlayer p_174876_2_) {
      return new ContainerDispenser(p_174876_1_, this);
   }

   public int func_174887_a_(int p_174887_1_) {
      return 0;
   }

   public void func_174885_b(int p_174885_1_, int p_174885_2_) {}

   public int func_174890_g() {
      return 0;
   }

   public void func_174888_l() {
      for(int var1 = 0; var1 < this.field_146022_i.length; ++var1) {
         this.field_146022_i[var1] = null;
      }

   }

}
