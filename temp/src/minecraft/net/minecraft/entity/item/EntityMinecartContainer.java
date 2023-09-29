package net.minecraft.entity.item;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.LockCode;
import net.minecraft.world.World;

public abstract class EntityMinecartContainer extends EntityMinecart implements ILockableContainer {

   private ItemStack[] field_94113_a = new ItemStack[36];
   private boolean field_94112_b = true;
   private static final String __OBFID = "CL_00001674";


   public EntityMinecartContainer(World p_i1716_1_) {
      super(p_i1716_1_);
   }

   public EntityMinecartContainer(World p_i1717_1_, double p_i1717_2_, double p_i1717_4_, double p_i1717_6_) {
      super(p_i1717_1_, p_i1717_2_, p_i1717_4_, p_i1717_6_);
   }

   public void func_94095_a(DamageSource p_94095_1_) {
      super.func_94095_a(p_94095_1_);
      InventoryHelper.func_180176_a(this.field_70170_p, this, this);
   }

   public ItemStack func_70301_a(int p_70301_1_) {
      return this.field_94113_a[p_70301_1_];
   }

   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
      if(this.field_94113_a[p_70298_1_] != null) {
         ItemStack var3;
         if(this.field_94113_a[p_70298_1_].field_77994_a <= p_70298_2_) {
            var3 = this.field_94113_a[p_70298_1_];
            this.field_94113_a[p_70298_1_] = null;
            return var3;
         } else {
            var3 = this.field_94113_a[p_70298_1_].func_77979_a(p_70298_2_);
            if(this.field_94113_a[p_70298_1_].field_77994_a == 0) {
               this.field_94113_a[p_70298_1_] = null;
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack func_70304_b(int p_70304_1_) {
      if(this.field_94113_a[p_70304_1_] != null) {
         ItemStack var2 = this.field_94113_a[p_70304_1_];
         this.field_94113_a[p_70304_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
      this.field_94113_a[p_70299_1_] = p_70299_2_;
      if(p_70299_2_ != null && p_70299_2_.field_77994_a > this.func_70297_j_()) {
         p_70299_2_.field_77994_a = this.func_70297_j_();
      }

   }

   public void func_70296_d() {}

   public boolean func_70300_a(EntityPlayer p_70300_1_) {
      return this.field_70128_L?false:p_70300_1_.func_70068_e(this) <= 64.0D;
   }

   public void func_174889_b(EntityPlayer p_174889_1_) {}

   public void func_174886_c(EntityPlayer p_174886_1_) {}

   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
      return true;
   }

   public String func_70005_c_() {
      return this.func_145818_k_()?this.func_95999_t():"container.minecart";
   }

   public int func_70297_j_() {
      return 64;
   }

   public void func_71027_c(int p_71027_1_) {
      this.field_94112_b = false;
      super.func_71027_c(p_71027_1_);
   }

   public void func_70106_y() {
      if(this.field_94112_b) {
         InventoryHelper.func_180176_a(this.field_70170_p, this, this);
      }

      super.func_70106_y();
   }

   protected void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.field_94113_a.length; ++var3) {
         if(this.field_94113_a[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.func_74774_a("Slot", (byte)var3);
            this.field_94113_a[var3].func_77955_b(var4);
            var2.func_74742_a(var4);
         }
      }

      p_70014_1_.func_74782_a("Items", var2);
   }

   protected void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      NBTTagList var2 = p_70037_1_.func_150295_c("Items", 10);
      this.field_94113_a = new ItemStack[this.func_70302_i_()];

      for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
         NBTTagCompound var4 = var2.func_150305_b(var3);
         int var5 = var4.func_74771_c("Slot") & 255;
         if(var5 >= 0 && var5 < this.field_94113_a.length) {
            this.field_94113_a[var5] = ItemStack.func_77949_a(var4);
         }
      }

   }

   public boolean func_130002_c(EntityPlayer p_130002_1_) {
      if(!this.field_70170_p.field_72995_K) {
         p_130002_1_.func_71007_a(this);
      }

      return true;
   }

   protected void func_94101_h() {
      int var1 = 15 - Container.func_94526_b(this);
      float var2 = 0.98F + (float)var1 * 0.001F;
      this.field_70159_w *= (double)var2;
      this.field_70181_x *= 0.0D;
      this.field_70179_y *= (double)var2;
   }

   public int func_174887_a_(int p_174887_1_) {
      return 0;
   }

   public void func_174885_b(int p_174885_1_, int p_174885_2_) {}

   public int func_174890_g() {
      return 0;
   }

   public boolean func_174893_q_() {
      return false;
   }

   public void func_174892_a(LockCode p_174892_1_) {}

   public LockCode func_174891_i() {
      return LockCode.field_180162_a;
   }

   public void func_174888_l() {
      for(int var1 = 0; var1 < this.field_94113_a.length; ++var1) {
         this.field_94113_a[var1] = null;
      }

   }
}
