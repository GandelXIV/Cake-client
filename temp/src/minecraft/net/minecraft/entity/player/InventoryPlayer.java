package net.minecraft.entity.player;

import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.command.server.CommandTestForBlock;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ReportedException;

public class InventoryPlayer implements IInventory {

   public ItemStack[] field_70462_a = new ItemStack[36];
   public ItemStack[] field_70460_b = new ItemStack[4];
   public int field_70461_c;
   public EntityPlayer field_70458_d;
   private ItemStack field_70457_g;
   public boolean field_70459_e;
   private static final String __OBFID = "CL_00001709";


   public InventoryPlayer(EntityPlayer p_i1750_1_) {
      this.field_70458_d = p_i1750_1_;
   }

   public ItemStack func_70448_g() {
      return this.field_70461_c < 9 && this.field_70461_c >= 0?this.field_70462_a[this.field_70461_c]:null;
   }

   public static int func_70451_h() {
      return 9;
   }

   private int func_146029_c(Item p_146029_1_) {
      for(int var2 = 0; var2 < this.field_70462_a.length; ++var2) {
         if(this.field_70462_a[var2] != null && this.field_70462_a[var2].func_77973_b() == p_146029_1_) {
            return var2;
         }
      }

      return -1;
   }

   private int func_146024_c(Item p_146024_1_, int p_146024_2_) {
      for(int var3 = 0; var3 < this.field_70462_a.length; ++var3) {
         if(this.field_70462_a[var3] != null && this.field_70462_a[var3].func_77973_b() == p_146024_1_ && this.field_70462_a[var3].func_77960_j() == p_146024_2_) {
            return var3;
         }
      }

      return -1;
   }

   private int func_70432_d(ItemStack p_70432_1_) {
      for(int var2 = 0; var2 < this.field_70462_a.length; ++var2) {
         if(this.field_70462_a[var2] != null && this.field_70462_a[var2].func_77973_b() == p_70432_1_.func_77973_b() && this.field_70462_a[var2].func_77985_e() && this.field_70462_a[var2].field_77994_a < this.field_70462_a[var2].func_77976_d() && this.field_70462_a[var2].field_77994_a < this.func_70297_j_() && (!this.field_70462_a[var2].func_77981_g() || this.field_70462_a[var2].func_77960_j() == p_70432_1_.func_77960_j()) && ItemStack.func_77970_a(this.field_70462_a[var2], p_70432_1_)) {
            return var2;
         }
      }

      return -1;
   }

   public int func_70447_i() {
      for(int var1 = 0; var1 < this.field_70462_a.length; ++var1) {
         if(this.field_70462_a[var1] == null) {
            return var1;
         }
      }

      return -1;
   }

   public void func_146030_a(Item p_146030_1_, int p_146030_2_, boolean p_146030_3_, boolean p_146030_4_) {
      ItemStack var5 = this.func_70448_g();
      int var6 = p_146030_3_?this.func_146024_c(p_146030_1_, p_146030_2_):this.func_146029_c(p_146030_1_);
      if(var6 >= 0 && var6 < 9) {
         this.field_70461_c = var6;
      } else if(p_146030_4_ && p_146030_1_ != null) {
         int var7 = this.func_70447_i();
         if(var7 >= 0 && var7 < 9) {
            this.field_70461_c = var7;
         }

         if(var5 == null || !var5.func_77956_u() || this.func_146024_c(var5.func_77973_b(), var5.func_77952_i()) != this.field_70461_c) {
            int var8 = this.func_146024_c(p_146030_1_, p_146030_2_);
            int var9;
            if(var8 >= 0) {
               var9 = this.field_70462_a[var8].field_77994_a;
               this.field_70462_a[var8] = this.field_70462_a[this.field_70461_c];
            } else {
               var9 = 1;
            }

            this.field_70462_a[this.field_70461_c] = new ItemStack(p_146030_1_, var9, p_146030_2_);
         }

      }
   }

   public void func_70453_c(int p_70453_1_) {
      if(p_70453_1_ > 0) {
         p_70453_1_ = 1;
      }

      if(p_70453_1_ < 0) {
         p_70453_1_ = -1;
      }

      for(this.field_70461_c -= p_70453_1_; this.field_70461_c < 0; this.field_70461_c += 9) {
         ;
      }

      while(this.field_70461_c >= 9) {
         this.field_70461_c -= 9;
      }

   }

   public int func_174925_a(Item p_174925_1_, int p_174925_2_, int p_174925_3_, NBTTagCompound p_174925_4_) {
      int var5 = 0;

      int var6;
      ItemStack var7;
      int var8;
      for(var6 = 0; var6 < this.field_70462_a.length; ++var6) {
         var7 = this.field_70462_a[var6];
         if(var7 != null && (p_174925_1_ == null || var7.func_77973_b() == p_174925_1_) && (p_174925_2_ <= -1 || var7.func_77960_j() == p_174925_2_) && (p_174925_4_ == null || CommandTestForBlock.func_175775_a(p_174925_4_, var7.func_77978_p(), true))) {
            var8 = p_174925_3_ <= 0?var7.field_77994_a:Math.min(p_174925_3_ - var5, var7.field_77994_a);
            var5 += var8;
            if(p_174925_3_ != 0) {
               this.field_70462_a[var6].field_77994_a -= var8;
               if(this.field_70462_a[var6].field_77994_a == 0) {
                  this.field_70462_a[var6] = null;
               }

               if(p_174925_3_ > 0 && var5 >= p_174925_3_) {
                  return var5;
               }
            }
         }
      }

      for(var6 = 0; var6 < this.field_70460_b.length; ++var6) {
         var7 = this.field_70460_b[var6];
         if(var7 != null && (p_174925_1_ == null || var7.func_77973_b() == p_174925_1_) && (p_174925_2_ <= -1 || var7.func_77960_j() == p_174925_2_) && (p_174925_4_ == null || CommandTestForBlock.func_175775_a(p_174925_4_, var7.func_77978_p(), false))) {
            var8 = p_174925_3_ <= 0?var7.field_77994_a:Math.min(p_174925_3_ - var5, var7.field_77994_a);
            var5 += var8;
            if(p_174925_3_ != 0) {
               this.field_70460_b[var6].field_77994_a -= var8;
               if(this.field_70460_b[var6].field_77994_a == 0) {
                  this.field_70460_b[var6] = null;
               }

               if(p_174925_3_ > 0 && var5 >= p_174925_3_) {
                  return var5;
               }
            }
         }
      }

      if(this.field_70457_g != null) {
         if(p_174925_1_ != null && this.field_70457_g.func_77973_b() != p_174925_1_) {
            return var5;
         }

         if(p_174925_2_ > -1 && this.field_70457_g.func_77960_j() != p_174925_2_) {
            return var5;
         }

         if(p_174925_4_ != null && !CommandTestForBlock.func_175775_a(p_174925_4_, this.field_70457_g.func_77978_p(), false)) {
            return var5;
         }

         var6 = p_174925_3_ <= 0?this.field_70457_g.field_77994_a:Math.min(p_174925_3_ - var5, this.field_70457_g.field_77994_a);
         var5 += var6;
         if(p_174925_3_ != 0) {
            this.field_70457_g.field_77994_a -= var6;
            if(this.field_70457_g.field_77994_a == 0) {
               this.field_70457_g = null;
            }

            if(p_174925_3_ > 0 && var5 >= p_174925_3_) {
               return var5;
            }
         }
      }

      return var5;
   }

   private int func_70452_e(ItemStack p_70452_1_) {
      Item var2 = p_70452_1_.func_77973_b();
      int var3 = p_70452_1_.field_77994_a;
      int var4 = this.func_70432_d(p_70452_1_);
      if(var4 < 0) {
         var4 = this.func_70447_i();
      }

      if(var4 < 0) {
         return var3;
      } else {
         if(this.field_70462_a[var4] == null) {
            this.field_70462_a[var4] = new ItemStack(var2, 0, p_70452_1_.func_77960_j());
            if(p_70452_1_.func_77942_o()) {
               this.field_70462_a[var4].func_77982_d((NBTTagCompound)p_70452_1_.func_77978_p().func_74737_b());
            }
         }

         int var5 = var3;
         if(var3 > this.field_70462_a[var4].func_77976_d() - this.field_70462_a[var4].field_77994_a) {
            var5 = this.field_70462_a[var4].func_77976_d() - this.field_70462_a[var4].field_77994_a;
         }

         if(var5 > this.func_70297_j_() - this.field_70462_a[var4].field_77994_a) {
            var5 = this.func_70297_j_() - this.field_70462_a[var4].field_77994_a;
         }

         if(var5 == 0) {
            return var3;
         } else {
            var3 -= var5;
            this.field_70462_a[var4].field_77994_a += var5;
            this.field_70462_a[var4].field_77992_b = 5;
            return var3;
         }
      }
   }

   public void func_70429_k() {
      for(int var1 = 0; var1 < this.field_70462_a.length; ++var1) {
         if(this.field_70462_a[var1] != null) {
            this.field_70462_a[var1].func_77945_a(this.field_70458_d.field_70170_p, this.field_70458_d, var1, this.field_70461_c == var1);
         }
      }

   }

   public boolean func_146026_a(Item p_146026_1_) {
      int var2 = this.func_146029_c(p_146026_1_);
      if(var2 < 0) {
         return false;
      } else {
         if(--this.field_70462_a[var2].field_77994_a <= 0) {
            this.field_70462_a[var2] = null;
         }

         return true;
      }
   }

   public boolean func_146028_b(Item p_146028_1_) {
      int var2 = this.func_146029_c(p_146028_1_);
      return var2 >= 0;
   }

   public boolean func_70441_a(final ItemStack p_70441_1_) {
      if(p_70441_1_ != null && p_70441_1_.field_77994_a != 0 && p_70441_1_.func_77973_b() != null) {
         try {
            int var2;
            if(p_70441_1_.func_77951_h()) {
               var2 = this.func_70447_i();
               if(var2 >= 0) {
                  this.field_70462_a[var2] = ItemStack.func_77944_b(p_70441_1_);
                  this.field_70462_a[var2].field_77992_b = 5;
                  p_70441_1_.field_77994_a = 0;
                  return true;
               } else if(this.field_70458_d.field_71075_bZ.field_75098_d) {
                  p_70441_1_.field_77994_a = 0;
                  return true;
               } else {
                  return false;
               }
            } else {
               do {
                  var2 = p_70441_1_.field_77994_a;
                  p_70441_1_.field_77994_a = this.func_70452_e(p_70441_1_);
               } while(p_70441_1_.field_77994_a > 0 && p_70441_1_.field_77994_a < var2);

               if(p_70441_1_.field_77994_a == var2 && this.field_70458_d.field_71075_bZ.field_75098_d) {
                  p_70441_1_.field_77994_a = 0;
                  return true;
               } else {
                  return p_70441_1_.field_77994_a < var2;
               }
            }
         } catch (Throwable var5) {
            CrashReport var3 = CrashReport.func_85055_a(var5, "Adding item to inventory");
            CrashReportCategory var4 = var3.func_85058_a("Item being added");
            var4.func_71507_a("Item ID", Integer.valueOf(Item.func_150891_b(p_70441_1_.func_77973_b())));
            var4.func_71507_a("Item data", Integer.valueOf(p_70441_1_.func_77960_j()));
            var4.func_71500_a("Item name", new Callable() {

               private static final String __OBFID = "CL_00001710";

               public String call() {
                  return p_70441_1_.func_82833_r();
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            throw new ReportedException(var3);
         }
      } else {
         return false;
      }
   }

   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
      ItemStack[] var3 = this.field_70462_a;
      if(p_70298_1_ >= this.field_70462_a.length) {
         var3 = this.field_70460_b;
         p_70298_1_ -= this.field_70462_a.length;
      }

      if(var3[p_70298_1_] != null) {
         ItemStack var4;
         if(var3[p_70298_1_].field_77994_a <= p_70298_2_) {
            var4 = var3[p_70298_1_];
            var3[p_70298_1_] = null;
            return var4;
         } else {
            var4 = var3[p_70298_1_].func_77979_a(p_70298_2_);
            if(var3[p_70298_1_].field_77994_a == 0) {
               var3[p_70298_1_] = null;
            }

            return var4;
         }
      } else {
         return null;
      }
   }

   public ItemStack func_70304_b(int p_70304_1_) {
      ItemStack[] var2 = this.field_70462_a;
      if(p_70304_1_ >= this.field_70462_a.length) {
         var2 = this.field_70460_b;
         p_70304_1_ -= this.field_70462_a.length;
      }

      if(var2[p_70304_1_] != null) {
         ItemStack var3 = var2[p_70304_1_];
         var2[p_70304_1_] = null;
         return var3;
      } else {
         return null;
      }
   }

   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
      ItemStack[] var3 = this.field_70462_a;
      if(p_70299_1_ >= var3.length) {
         p_70299_1_ -= var3.length;
         var3 = this.field_70460_b;
      }

      var3[p_70299_1_] = p_70299_2_;
   }

   public float func_146023_a(Block p_146023_1_) {
      float var2 = 1.0F;
      if(this.field_70462_a[this.field_70461_c] != null) {
         var2 *= this.field_70462_a[this.field_70461_c].func_150997_a(p_146023_1_);
      }

      return var2;
   }

   public NBTTagList func_70442_a(NBTTagList p_70442_1_) {
      int var2;
      NBTTagCompound var3;
      for(var2 = 0; var2 < this.field_70462_a.length; ++var2) {
         if(this.field_70462_a[var2] != null) {
            var3 = new NBTTagCompound();
            var3.func_74774_a("Slot", (byte)var2);
            this.field_70462_a[var2].func_77955_b(var3);
            p_70442_1_.func_74742_a(var3);
         }
      }

      for(var2 = 0; var2 < this.field_70460_b.length; ++var2) {
         if(this.field_70460_b[var2] != null) {
            var3 = new NBTTagCompound();
            var3.func_74774_a("Slot", (byte)(var2 + 100));
            this.field_70460_b[var2].func_77955_b(var3);
            p_70442_1_.func_74742_a(var3);
         }
      }

      return p_70442_1_;
   }

   public void func_70443_b(NBTTagList p_70443_1_) {
      this.field_70462_a = new ItemStack[36];
      this.field_70460_b = new ItemStack[4];

      for(int var2 = 0; var2 < p_70443_1_.func_74745_c(); ++var2) {
         NBTTagCompound var3 = p_70443_1_.func_150305_b(var2);
         int var4 = var3.func_74771_c("Slot") & 255;
         ItemStack var5 = ItemStack.func_77949_a(var3);
         if(var5 != null) {
            if(var4 >= 0 && var4 < this.field_70462_a.length) {
               this.field_70462_a[var4] = var5;
            }

            if(var4 >= 100 && var4 < this.field_70460_b.length + 100) {
               this.field_70460_b[var4 - 100] = var5;
            }
         }
      }

   }

   public int func_70302_i_() {
      return this.field_70462_a.length + 4;
   }

   public ItemStack func_70301_a(int p_70301_1_) {
      ItemStack[] var2 = this.field_70462_a;
      if(p_70301_1_ >= var2.length) {
         p_70301_1_ -= var2.length;
         var2 = this.field_70460_b;
      }

      return var2[p_70301_1_];
   }

   public String func_70005_c_() {
      return "container.inventory";
   }

   public boolean func_145818_k_() {
      return false;
   }

   public IChatComponent func_145748_c_() {
      return (IChatComponent)(this.func_145818_k_()?new ChatComponentText(this.func_70005_c_()):new ChatComponentTranslation(this.func_70005_c_(), new Object[0]));
   }

   public int func_70297_j_() {
      return 64;
   }

   public boolean func_146025_b(Block p_146025_1_) {
      if(p_146025_1_.func_149688_o().func_76229_l()) {
         return true;
      } else {
         ItemStack var2 = this.func_70301_a(this.field_70461_c);
         return var2 != null?var2.func_150998_b(p_146025_1_):false;
      }
   }

   public ItemStack func_70440_f(int p_70440_1_) {
      return this.field_70460_b[p_70440_1_];
   }

   public int func_70430_l() {
      int var1 = 0;

      for(int var2 = 0; var2 < this.field_70460_b.length; ++var2) {
         if(this.field_70460_b[var2] != null && this.field_70460_b[var2].func_77973_b() instanceof ItemArmor) {
            int var3 = ((ItemArmor)this.field_70460_b[var2].func_77973_b()).field_77879_b;
            var1 += var3;
         }
      }

      return var1;
   }

   public void func_70449_g(float p_70449_1_) {
      p_70449_1_ /= 4.0F;
      if(p_70449_1_ < 1.0F) {
         p_70449_1_ = 1.0F;
      }

      for(int var2 = 0; var2 < this.field_70460_b.length; ++var2) {
         if(this.field_70460_b[var2] != null && this.field_70460_b[var2].func_77973_b() instanceof ItemArmor) {
            this.field_70460_b[var2].func_77972_a((int)p_70449_1_, this.field_70458_d);
            if(this.field_70460_b[var2].field_77994_a == 0) {
               this.field_70460_b[var2] = null;
            }
         }
      }

   }

   public void func_70436_m() {
      int var1;
      for(var1 = 0; var1 < this.field_70462_a.length; ++var1) {
         if(this.field_70462_a[var1] != null) {
            this.field_70458_d.func_146097_a(this.field_70462_a[var1], true, false);
            this.field_70462_a[var1] = null;
         }
      }

      for(var1 = 0; var1 < this.field_70460_b.length; ++var1) {
         if(this.field_70460_b[var1] != null) {
            this.field_70458_d.func_146097_a(this.field_70460_b[var1], true, false);
            this.field_70460_b[var1] = null;
         }
      }

   }

   public void func_70296_d() {
      this.field_70459_e = true;
   }

   public void func_70437_b(ItemStack p_70437_1_) {
      this.field_70457_g = p_70437_1_;
   }

   public ItemStack func_70445_o() {
      return this.field_70457_g;
   }

   public boolean func_70300_a(EntityPlayer p_70300_1_) {
      return this.field_70458_d.field_70128_L?false:p_70300_1_.func_70068_e(this.field_70458_d) <= 64.0D;
   }

   public boolean func_70431_c(ItemStack p_70431_1_) {
      int var2;
      for(var2 = 0; var2 < this.field_70460_b.length; ++var2) {
         if(this.field_70460_b[var2] != null && this.field_70460_b[var2].func_77969_a(p_70431_1_)) {
            return true;
         }
      }

      for(var2 = 0; var2 < this.field_70462_a.length; ++var2) {
         if(this.field_70462_a[var2] != null && this.field_70462_a[var2].func_77969_a(p_70431_1_)) {
            return true;
         }
      }

      return false;
   }

   public void func_174889_b(EntityPlayer p_174889_1_) {}

   public void func_174886_c(EntityPlayer p_174886_1_) {}

   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
      return true;
   }

   public void func_70455_b(InventoryPlayer p_70455_1_) {
      int var2;
      for(var2 = 0; var2 < this.field_70462_a.length; ++var2) {
         this.field_70462_a[var2] = ItemStack.func_77944_b(p_70455_1_.field_70462_a[var2]);
      }

      for(var2 = 0; var2 < this.field_70460_b.length; ++var2) {
         this.field_70460_b[var2] = ItemStack.func_77944_b(p_70455_1_.field_70460_b[var2]);
      }

      this.field_70461_c = p_70455_1_.field_70461_c;
   }

   public int func_174887_a_(int p_174887_1_) {
      return 0;
   }

   public void func_174885_b(int p_174885_1_, int p_174885_2_) {}

   public int func_174890_g() {
      return 0;
   }

   public void func_174888_l() {
      int var1;
      for(var1 = 0; var1 < this.field_70462_a.length; ++var1) {
         this.field_70462_a[var1] = null;
      }

      for(var1 = 0; var1 < this.field_70460_b.length; ++var1) {
         this.field_70460_b[var1] = null;
      }

   }
}
