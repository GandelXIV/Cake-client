package net.minecraft.tileentity;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockHopper;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerHopper;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.IHopper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class TileEntityHopper extends TileEntityLockable implements IHopper, IUpdatePlayerListBox {

   private ItemStack[] field_145900_a = new ItemStack[5];
   private String field_145902_i;
   private int field_145901_j = -1;
   private static final String __OBFID = "CL_00000359";


   public void func_145839_a(NBTTagCompound p_145839_1_) {
      super.func_145839_a(p_145839_1_);
      NBTTagList var2 = p_145839_1_.func_150295_c("Items", 10);
      this.field_145900_a = new ItemStack[this.func_70302_i_()];
      if(p_145839_1_.func_150297_b("CustomName", 8)) {
         this.field_145902_i = p_145839_1_.func_74779_i("CustomName");
      }

      this.field_145901_j = p_145839_1_.func_74762_e("TransferCooldown");

      for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
         NBTTagCompound var4 = var2.func_150305_b(var3);
         byte var5 = var4.func_74771_c("Slot");
         if(var5 >= 0 && var5 < this.field_145900_a.length) {
            this.field_145900_a[var5] = ItemStack.func_77949_a(var4);
         }
      }

   }

   public void func_145841_b(NBTTagCompound p_145841_1_) {
      super.func_145841_b(p_145841_1_);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.field_145900_a.length; ++var3) {
         if(this.field_145900_a[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.func_74774_a("Slot", (byte)var3);
            this.field_145900_a[var3].func_77955_b(var4);
            var2.func_74742_a(var4);
         }
      }

      p_145841_1_.func_74782_a("Items", var2);
      p_145841_1_.func_74768_a("TransferCooldown", this.field_145901_j);
      if(this.func_145818_k_()) {
         p_145841_1_.func_74778_a("CustomName", this.field_145902_i);
      }

   }

   public void func_70296_d() {
      super.func_70296_d();
   }

   public int func_70302_i_() {
      return this.field_145900_a.length;
   }

   public ItemStack func_70301_a(int p_70301_1_) {
      return this.field_145900_a[p_70301_1_];
   }

   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
      if(this.field_145900_a[p_70298_1_] != null) {
         ItemStack var3;
         if(this.field_145900_a[p_70298_1_].field_77994_a <= p_70298_2_) {
            var3 = this.field_145900_a[p_70298_1_];
            this.field_145900_a[p_70298_1_] = null;
            return var3;
         } else {
            var3 = this.field_145900_a[p_70298_1_].func_77979_a(p_70298_2_);
            if(this.field_145900_a[p_70298_1_].field_77994_a == 0) {
               this.field_145900_a[p_70298_1_] = null;
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack func_70304_b(int p_70304_1_) {
      if(this.field_145900_a[p_70304_1_] != null) {
         ItemStack var2 = this.field_145900_a[p_70304_1_];
         this.field_145900_a[p_70304_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
      this.field_145900_a[p_70299_1_] = p_70299_2_;
      if(p_70299_2_ != null && p_70299_2_.field_77994_a > this.func_70297_j_()) {
         p_70299_2_.field_77994_a = this.func_70297_j_();
      }

   }

   public String func_70005_c_() {
      return this.func_145818_k_()?this.field_145902_i:"container.hopper";
   }

   public boolean func_145818_k_() {
      return this.field_145902_i != null && this.field_145902_i.length() > 0;
   }

   public void func_145886_a(String p_145886_1_) {
      this.field_145902_i = p_145886_1_;
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

   public void func_73660_a() {
      if(this.field_145850_b != null && !this.field_145850_b.field_72995_K) {
         --this.field_145901_j;
         if(!this.func_145888_j()) {
            this.func_145896_c(0);
            this.func_145887_i();
         }

      }
   }

   public boolean func_145887_i() {
      if(this.field_145850_b != null && !this.field_145850_b.field_72995_K) {
         if(!this.func_145888_j() && BlockHopper.func_149917_c(this.func_145832_p())) {
            boolean var1 = false;
            if(!this.func_152104_k()) {
               var1 = this.func_145883_k();
            }

            if(!this.func_152105_l()) {
               var1 = func_145891_a(this) || var1;
            }

            if(var1) {
               this.func_145896_c(8);
               this.func_70296_d();
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private boolean func_152104_k() {
      ItemStack[] var1 = this.field_145900_a;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         ItemStack var4 = var1[var3];
         if(var4 != null) {
            return false;
         }
      }

      return true;
   }

   private boolean func_152105_l() {
      ItemStack[] var1 = this.field_145900_a;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         ItemStack var4 = var1[var3];
         if(var4 == null || var4.field_77994_a != var4.func_77976_d()) {
            return false;
         }
      }

      return true;
   }

   private boolean func_145883_k() {
      IInventory var1 = this.func_145895_l();
      if(var1 == null) {
         return false;
      } else {
         EnumFacing var2 = BlockHopper.func_176428_b(this.func_145832_p()).func_176734_d();
         if(this.func_174919_a(var1, var2)) {
            return false;
         } else {
            for(int var3 = 0; var3 < this.func_70302_i_(); ++var3) {
               if(this.func_70301_a(var3) != null) {
                  ItemStack var4 = this.func_70301_a(var3).func_77946_l();
                  ItemStack var5 = func_174918_a(var1, this.func_70298_a(var3, 1), var2);
                  if(var5 == null || var5.field_77994_a == 0) {
                     var1.func_70296_d();
                     return true;
                  }

                  this.func_70299_a(var3, var4);
               }
            }

            return false;
         }
      }
   }

   private boolean func_174919_a(IInventory p_174919_1_, EnumFacing p_174919_2_) {
      if(p_174919_1_ instanceof ISidedInventory) {
         ISidedInventory var3 = (ISidedInventory)p_174919_1_;
         int[] var4 = var3.func_180463_a(p_174919_2_);

         for(int var5 = 0; var5 < var4.length; ++var5) {
            ItemStack var6 = var3.func_70301_a(var4[var5]);
            if(var6 == null || var6.field_77994_a != var6.func_77976_d()) {
               return false;
            }
         }
      } else {
         int var7 = p_174919_1_.func_70302_i_();

         for(int var8 = 0; var8 < var7; ++var8) {
            ItemStack var9 = p_174919_1_.func_70301_a(var8);
            if(var9 == null || var9.field_77994_a != var9.func_77976_d()) {
               return false;
            }
         }
      }

      return true;
   }

   private static boolean func_174917_b(IInventory p_174917_0_, EnumFacing p_174917_1_) {
      if(p_174917_0_ instanceof ISidedInventory) {
         ISidedInventory var2 = (ISidedInventory)p_174917_0_;
         int[] var3 = var2.func_180463_a(p_174917_1_);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if(var2.func_70301_a(var3[var4]) != null) {
               return false;
            }
         }
      } else {
         int var5 = p_174917_0_.func_70302_i_();

         for(int var6 = 0; var6 < var5; ++var6) {
            if(p_174917_0_.func_70301_a(var6) != null) {
               return false;
            }
         }
      }

      return true;
   }

   public static boolean func_145891_a(IHopper p_145891_0_) {
      IInventory var1 = func_145884_b(p_145891_0_);
      if(var1 != null) {
         EnumFacing var2 = EnumFacing.DOWN;
         if(func_174917_b(var1, var2)) {
            return false;
         }

         if(var1 instanceof ISidedInventory) {
            ISidedInventory var3 = (ISidedInventory)var1;
            int[] var4 = var3.func_180463_a(var2);

            for(int var5 = 0; var5 < var4.length; ++var5) {
               if(func_174915_a(p_145891_0_, var1, var4[var5], var2)) {
                  return true;
               }
            }
         } else {
            int var7 = var1.func_70302_i_();

            for(int var8 = 0; var8 < var7; ++var8) {
               if(func_174915_a(p_145891_0_, var1, var8, var2)) {
                  return true;
               }
            }
         }
      } else {
         EntityItem var6 = func_145897_a(p_145891_0_.func_145831_w(), p_145891_0_.func_96107_aA(), p_145891_0_.func_96109_aB() + 1.0D, p_145891_0_.func_96108_aC());
         if(var6 != null) {
            return func_145898_a(p_145891_0_, var6);
         }
      }

      return false;
   }

   private static boolean func_174915_a(IHopper p_174915_0_, IInventory p_174915_1_, int p_174915_2_, EnumFacing p_174915_3_) {
      ItemStack var4 = p_174915_1_.func_70301_a(p_174915_2_);
      if(var4 != null && func_174921_b(p_174915_1_, var4, p_174915_2_, p_174915_3_)) {
         ItemStack var5 = var4.func_77946_l();
         ItemStack var6 = func_174918_a(p_174915_0_, p_174915_1_.func_70298_a(p_174915_2_, 1), (EnumFacing)null);
         if(var6 == null || var6.field_77994_a == 0) {
            p_174915_1_.func_70296_d();
            return true;
         }

         p_174915_1_.func_70299_a(p_174915_2_, var5);
      }

      return false;
   }

   public static boolean func_145898_a(IInventory p_145898_0_, EntityItem p_145898_1_) {
      boolean var2 = false;
      if(p_145898_1_ == null) {
         return false;
      } else {
         ItemStack var3 = p_145898_1_.func_92059_d().func_77946_l();
         ItemStack var4 = func_174918_a(p_145898_0_, var3, (EnumFacing)null);
         if(var4 != null && var4.field_77994_a != 0) {
            p_145898_1_.func_92058_a(var4);
         } else {
            var2 = true;
            p_145898_1_.func_70106_y();
         }

         return var2;
      }
   }

   public static ItemStack func_174918_a(IInventory p_174918_0_, ItemStack p_174918_1_, EnumFacing p_174918_2_) {
      if(p_174918_0_ instanceof ISidedInventory && p_174918_2_ != null) {
         ISidedInventory var6 = (ISidedInventory)p_174918_0_;
         int[] var7 = var6.func_180463_a(p_174918_2_);

         for(int var5 = 0; var5 < var7.length && p_174918_1_ != null && p_174918_1_.field_77994_a > 0; ++var5) {
            p_174918_1_ = func_174916_c(p_174918_0_, p_174918_1_, var7[var5], p_174918_2_);
         }
      } else {
         int var3 = p_174918_0_.func_70302_i_();

         for(int var4 = 0; var4 < var3 && p_174918_1_ != null && p_174918_1_.field_77994_a > 0; ++var4) {
            p_174918_1_ = func_174916_c(p_174918_0_, p_174918_1_, var4, p_174918_2_);
         }
      }

      if(p_174918_1_ != null && p_174918_1_.field_77994_a == 0) {
         p_174918_1_ = null;
      }

      return p_174918_1_;
   }

   private static boolean func_174920_a(IInventory p_174920_0_, ItemStack p_174920_1_, int p_174920_2_, EnumFacing p_174920_3_) {
      return !p_174920_0_.func_94041_b(p_174920_2_, p_174920_1_)?false:!(p_174920_0_ instanceof ISidedInventory) || ((ISidedInventory)p_174920_0_).func_180462_a(p_174920_2_, p_174920_1_, p_174920_3_);
   }

   private static boolean func_174921_b(IInventory p_174921_0_, ItemStack p_174921_1_, int p_174921_2_, EnumFacing p_174921_3_) {
      return !(p_174921_0_ instanceof ISidedInventory) || ((ISidedInventory)p_174921_0_).func_180461_b(p_174921_2_, p_174921_1_, p_174921_3_);
   }

   private static ItemStack func_174916_c(IInventory p_174916_0_, ItemStack p_174916_1_, int p_174916_2_, EnumFacing p_174916_3_) {
      ItemStack var4 = p_174916_0_.func_70301_a(p_174916_2_);
      if(func_174920_a(p_174916_0_, p_174916_1_, p_174916_2_, p_174916_3_)) {
         boolean var5 = false;
         if(var4 == null) {
            p_174916_0_.func_70299_a(p_174916_2_, p_174916_1_);
            p_174916_1_ = null;
            var5 = true;
         } else if(func_145894_a(var4, p_174916_1_)) {
            int var6 = p_174916_1_.func_77976_d() - var4.field_77994_a;
            int var7 = Math.min(p_174916_1_.field_77994_a, var6);
            p_174916_1_.field_77994_a -= var7;
            var4.field_77994_a += var7;
            var5 = var7 > 0;
         }

         if(var5) {
            if(p_174916_0_ instanceof TileEntityHopper) {
               TileEntityHopper var8 = (TileEntityHopper)p_174916_0_;
               if(var8.func_174914_o()) {
                  var8.func_145896_c(8);
               }

               p_174916_0_.func_70296_d();
            }

            p_174916_0_.func_70296_d();
         }
      }

      return p_174916_1_;
   }

   private IInventory func_145895_l() {
      EnumFacing var1 = BlockHopper.func_176428_b(this.func_145832_p());
      return func_145893_b(this.func_145831_w(), (double)(this.field_174879_c.func_177958_n() + var1.func_82601_c()), (double)(this.field_174879_c.func_177956_o() + var1.func_96559_d()), (double)(this.field_174879_c.func_177952_p() + var1.func_82599_e()));
   }

   public static IInventory func_145884_b(IHopper p_145884_0_) {
      return func_145893_b(p_145884_0_.func_145831_w(), p_145884_0_.func_96107_aA(), p_145884_0_.func_96109_aB() + 1.0D, p_145884_0_.func_96108_aC());
   }

   public static EntityItem func_145897_a(World p_145897_0_, double p_145897_1_, double p_145897_3_, double p_145897_5_) {
      List var7 = p_145897_0_.func_175647_a(EntityItem.class, new AxisAlignedBB(p_145897_1_, p_145897_3_, p_145897_5_, p_145897_1_ + 1.0D, p_145897_3_ + 1.0D, p_145897_5_ + 1.0D), IEntitySelector.field_94557_a);
      return var7.size() > 0?(EntityItem)var7.get(0):null;
   }

   public static IInventory func_145893_b(World p_145893_0_, double p_145893_1_, double p_145893_3_, double p_145893_5_) {
      Object var7 = null;
      int var8 = MathHelper.func_76128_c(p_145893_1_);
      int var9 = MathHelper.func_76128_c(p_145893_3_);
      int var10 = MathHelper.func_76128_c(p_145893_5_);
      BlockPos var11 = new BlockPos(var8, var9, var10);
      TileEntity var12 = p_145893_0_.func_175625_s(new BlockPos(var8, var9, var10));
      if(var12 instanceof IInventory) {
         var7 = (IInventory)var12;
         if(var7 instanceof TileEntityChest) {
            Block var13 = p_145893_0_.func_180495_p(new BlockPos(var8, var9, var10)).func_177230_c();
            if(var13 instanceof BlockChest) {
               var7 = ((BlockChest)var13).func_180676_d(p_145893_0_, var11);
            }
         }
      }

      if(var7 == null) {
         List var14 = p_145893_0_.func_175674_a((Entity)null, new AxisAlignedBB(p_145893_1_, p_145893_3_, p_145893_5_, p_145893_1_ + 1.0D, p_145893_3_ + 1.0D, p_145893_5_ + 1.0D), IEntitySelector.field_96566_b);
         if(var14.size() > 0) {
            var7 = (IInventory)var14.get(p_145893_0_.field_73012_v.nextInt(var14.size()));
         }
      }

      return (IInventory)var7;
   }

   private static boolean func_145894_a(ItemStack p_145894_0_, ItemStack p_145894_1_) {
      return p_145894_0_.func_77973_b() != p_145894_1_.func_77973_b()?false:(p_145894_0_.func_77960_j() != p_145894_1_.func_77960_j()?false:(p_145894_0_.field_77994_a > p_145894_0_.func_77976_d()?false:ItemStack.func_77970_a(p_145894_0_, p_145894_1_)));
   }

   public double func_96107_aA() {
      return (double)this.field_174879_c.func_177958_n();
   }

   public double func_96109_aB() {
      return (double)this.field_174879_c.func_177956_o();
   }

   public double func_96108_aC() {
      return (double)this.field_174879_c.func_177952_p();
   }

   public void func_145896_c(int p_145896_1_) {
      this.field_145901_j = p_145896_1_;
   }

   public boolean func_145888_j() {
      return this.field_145901_j > 0;
   }

   public boolean func_174914_o() {
      return this.field_145901_j <= 1;
   }

   public String func_174875_k() {
      return "minecraft:hopper";
   }

   public Container func_174876_a(InventoryPlayer p_174876_1_, EntityPlayer p_174876_2_) {
      return new ContainerHopper(p_174876_1_, this, p_174876_2_);
   }

   public int func_174887_a_(int p_174887_1_) {
      return 0;
   }

   public void func_174885_b(int p_174885_1_, int p_174885_2_) {}

   public int func_174890_g() {
      return 0;
   }

   public void func_174888_l() {
      for(int var1 = 0; var1 < this.field_145900_a.length; ++var1) {
         this.field_145900_a[var1] = null;
      }

   }
}
