package net.minecraft.inventory;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;

public abstract class Container {

   public List field_75153_a = Lists.newArrayList();
   public List field_75151_b = Lists.newArrayList();
   public int field_75152_c;
   private short field_75150_e;
   private int field_94535_f = -1;
   private int field_94536_g;
   private final Set field_94537_h = Sets.newHashSet();
   protected List field_75149_d = Lists.newArrayList();
   private Set field_75148_f = Sets.newHashSet();
   private static final String __OBFID = "CL_00001730";


   protected Slot func_75146_a(Slot p_75146_1_) {
      p_75146_1_.field_75222_d = this.field_75151_b.size();
      this.field_75151_b.add(p_75146_1_);
      this.field_75153_a.add((Object)null);
      return p_75146_1_;
   }

   public void func_75132_a(ICrafting p_75132_1_) {
      if(this.field_75149_d.contains(p_75132_1_)) {
         throw new IllegalArgumentException("Listener already listening");
      } else {
         this.field_75149_d.add(p_75132_1_);
         p_75132_1_.func_71110_a(this, this.func_75138_a());
         this.func_75142_b();
      }
   }

   public void func_82847_b(ICrafting p_82847_1_) {
      this.field_75149_d.remove(p_82847_1_);
   }

   public List func_75138_a() {
      ArrayList var1 = Lists.newArrayList();

      for(int var2 = 0; var2 < this.field_75151_b.size(); ++var2) {
         var1.add(((Slot)this.field_75151_b.get(var2)).func_75211_c());
      }

      return var1;
   }

   public void func_75142_b() {
      for(int var1 = 0; var1 < this.field_75151_b.size(); ++var1) {
         ItemStack var2 = ((Slot)this.field_75151_b.get(var1)).func_75211_c();
         ItemStack var3 = (ItemStack)this.field_75153_a.get(var1);
         if(!ItemStack.func_77989_b(var3, var2)) {
            var3 = var2 == null?null:var2.func_77946_l();
            this.field_75153_a.set(var1, var3);

            for(int var4 = 0; var4 < this.field_75149_d.size(); ++var4) {
               ((ICrafting)this.field_75149_d.get(var4)).func_71111_a(this, var1, var3);
            }
         }
      }

   }

   public boolean func_75140_a(EntityPlayer p_75140_1_, int p_75140_2_) {
      return false;
   }

   public Slot func_75147_a(IInventory p_75147_1_, int p_75147_2_) {
      for(int var3 = 0; var3 < this.field_75151_b.size(); ++var3) {
         Slot var4 = (Slot)this.field_75151_b.get(var3);
         if(var4.func_75217_a(p_75147_1_, p_75147_2_)) {
            return var4;
         }
      }

      return null;
   }

   public Slot func_75139_a(int p_75139_1_) {
      return (Slot)this.field_75151_b.get(p_75139_1_);
   }

   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
      Slot var3 = (Slot)this.field_75151_b.get(p_82846_2_);
      return var3 != null?var3.func_75211_c():null;
   }

   public ItemStack func_75144_a(int p_75144_1_, int p_75144_2_, int p_75144_3_, EntityPlayer p_75144_4_) {
      ItemStack var5 = null;
      InventoryPlayer var6 = p_75144_4_.field_71071_by;
      int var9;
      ItemStack var17;
      if(p_75144_3_ == 5) {
         int var7 = this.field_94536_g;
         this.field_94536_g = func_94532_c(p_75144_2_);
         if((var7 != 1 || this.field_94536_g != 2) && var7 != this.field_94536_g) {
            this.func_94533_d();
         } else if(var6.func_70445_o() == null) {
            this.func_94533_d();
         } else if(this.field_94536_g == 0) {
            this.field_94535_f = func_94529_b(p_75144_2_);
            if(func_180610_a(this.field_94535_f, p_75144_4_)) {
               this.field_94536_g = 1;
               this.field_94537_h.clear();
            } else {
               this.func_94533_d();
            }
         } else if(this.field_94536_g == 1) {
            Slot var8 = (Slot)this.field_75151_b.get(p_75144_1_);
            if(var8 != null && func_94527_a(var8, var6.func_70445_o(), true) && var8.func_75214_a(var6.func_70445_o()) && var6.func_70445_o().field_77994_a > this.field_94537_h.size() && this.func_94531_b(var8)) {
               this.field_94537_h.add(var8);
            }
         } else if(this.field_94536_g == 2) {
            if(!this.field_94537_h.isEmpty()) {
               var17 = var6.func_70445_o().func_77946_l();
               var9 = var6.func_70445_o().field_77994_a;
               Iterator var10 = this.field_94537_h.iterator();

               while(var10.hasNext()) {
                  Slot var11 = (Slot)var10.next();
                  if(var11 != null && func_94527_a(var11, var6.func_70445_o(), true) && var11.func_75214_a(var6.func_70445_o()) && var6.func_70445_o().field_77994_a >= this.field_94537_h.size() && this.func_94531_b(var11)) {
                     ItemStack var12 = var17.func_77946_l();
                     int var13 = var11.func_75216_d()?var11.func_75211_c().field_77994_a:0;
                     func_94525_a(this.field_94537_h, this.field_94535_f, var12, var13);
                     if(var12.field_77994_a > var12.func_77976_d()) {
                        var12.field_77994_a = var12.func_77976_d();
                     }

                     if(var12.field_77994_a > var11.func_178170_b(var12)) {
                        var12.field_77994_a = var11.func_178170_b(var12);
                     }

                     var9 -= var12.field_77994_a - var13;
                     var11.func_75215_d(var12);
                  }
               }

               var17.field_77994_a = var9;
               if(var17.field_77994_a <= 0) {
                  var17 = null;
               }

               var6.func_70437_b(var17);
            }

            this.func_94533_d();
         } else {
            this.func_94533_d();
         }
      } else if(this.field_94536_g != 0) {
         this.func_94533_d();
      } else {
         Slot var16;
         int var21;
         ItemStack var23;
         if((p_75144_3_ == 0 || p_75144_3_ == 1) && (p_75144_2_ == 0 || p_75144_2_ == 1)) {
            if(p_75144_1_ == -999) {
               if(var6.func_70445_o() != null) {
                  if(p_75144_2_ == 0) {
                     p_75144_4_.func_71019_a(var6.func_70445_o(), true);
                     var6.func_70437_b((ItemStack)null);
                  }

                  if(p_75144_2_ == 1) {
                     p_75144_4_.func_71019_a(var6.func_70445_o().func_77979_a(1), true);
                     if(var6.func_70445_o().field_77994_a == 0) {
                        var6.func_70437_b((ItemStack)null);
                     }
                  }
               }
            } else if(p_75144_3_ == 1) {
               if(p_75144_1_ < 0) {
                  return null;
               }

               var16 = (Slot)this.field_75151_b.get(p_75144_1_);
               if(var16 != null && var16.func_82869_a(p_75144_4_)) {
                  var17 = this.func_82846_b(p_75144_4_, p_75144_1_);
                  if(var17 != null) {
                     Item var19 = var17.func_77973_b();
                     var5 = var17.func_77946_l();
                     if(var16.func_75211_c() != null && var16.func_75211_c().func_77973_b() == var19) {
                        this.func_75133_b(p_75144_1_, p_75144_2_, true, p_75144_4_);
                     }
                  }
               }
            } else {
               if(p_75144_1_ < 0) {
                  return null;
               }

               var16 = (Slot)this.field_75151_b.get(p_75144_1_);
               if(var16 != null) {
                  var17 = var16.func_75211_c();
                  ItemStack var20 = var6.func_70445_o();
                  if(var17 != null) {
                     var5 = var17.func_77946_l();
                  }

                  if(var17 == null) {
                     if(var20 != null && var16.func_75214_a(var20)) {
                        var21 = p_75144_2_ == 0?var20.field_77994_a:1;
                        if(var21 > var16.func_178170_b(var20)) {
                           var21 = var16.func_178170_b(var20);
                        }

                        if(var20.field_77994_a >= var21) {
                           var16.func_75215_d(var20.func_77979_a(var21));
                        }

                        if(var20.field_77994_a == 0) {
                           var6.func_70437_b((ItemStack)null);
                        }
                     }
                  } else if(var16.func_82869_a(p_75144_4_)) {
                     if(var20 == null) {
                        var21 = p_75144_2_ == 0?var17.field_77994_a:(var17.field_77994_a + 1) / 2;
                        var23 = var16.func_75209_a(var21);
                        var6.func_70437_b(var23);
                        if(var17.field_77994_a == 0) {
                           var16.func_75215_d((ItemStack)null);
                        }

                        var16.func_82870_a(p_75144_4_, var6.func_70445_o());
                     } else if(var16.func_75214_a(var20)) {
                        if(var17.func_77973_b() == var20.func_77973_b() && var17.func_77960_j() == var20.func_77960_j() && ItemStack.func_77970_a(var17, var20)) {
                           var21 = p_75144_2_ == 0?var20.field_77994_a:1;
                           if(var21 > var16.func_178170_b(var20) - var17.field_77994_a) {
                              var21 = var16.func_178170_b(var20) - var17.field_77994_a;
                           }

                           if(var21 > var20.func_77976_d() - var17.field_77994_a) {
                              var21 = var20.func_77976_d() - var17.field_77994_a;
                           }

                           var20.func_77979_a(var21);
                           if(var20.field_77994_a == 0) {
                              var6.func_70437_b((ItemStack)null);
                           }

                           var17.field_77994_a += var21;
                        } else if(var20.field_77994_a <= var16.func_178170_b(var20)) {
                           var16.func_75215_d(var20);
                           var6.func_70437_b(var17);
                        }
                     } else if(var17.func_77973_b() == var20.func_77973_b() && var20.func_77976_d() > 1 && (!var17.func_77981_g() || var17.func_77960_j() == var20.func_77960_j()) && ItemStack.func_77970_a(var17, var20)) {
                        var21 = var17.field_77994_a;
                        if(var21 > 0 && var21 + var20.field_77994_a <= var20.func_77976_d()) {
                           var20.field_77994_a += var21;
                           var17 = var16.func_75209_a(var21);
                           if(var17.field_77994_a == 0) {
                              var16.func_75215_d((ItemStack)null);
                           }

                           var16.func_82870_a(p_75144_4_, var6.func_70445_o());
                        }
                     }
                  }

                  var16.func_75218_e();
               }
            }
         } else if(p_75144_3_ == 2 && p_75144_2_ >= 0 && p_75144_2_ < 9) {
            var16 = (Slot)this.field_75151_b.get(p_75144_1_);
            if(var16.func_82869_a(p_75144_4_)) {
               var17 = var6.func_70301_a(p_75144_2_);
               boolean var18 = var17 == null || var16.field_75224_c == var6 && var16.func_75214_a(var17);
               var21 = -1;
               if(!var18) {
                  var21 = var6.func_70447_i();
                  var18 |= var21 > -1;
               }

               if(var16.func_75216_d() && var18) {
                  var23 = var16.func_75211_c();
                  var6.func_70299_a(p_75144_2_, var23.func_77946_l());
                  if((var16.field_75224_c != var6 || !var16.func_75214_a(var17)) && var17 != null) {
                     if(var21 > -1) {
                        var6.func_70441_a(var17);
                        var16.func_75209_a(var23.field_77994_a);
                        var16.func_75215_d((ItemStack)null);
                        var16.func_82870_a(p_75144_4_, var23);
                     }
                  } else {
                     var16.func_75209_a(var23.field_77994_a);
                     var16.func_75215_d(var17);
                     var16.func_82870_a(p_75144_4_, var23);
                  }
               } else if(!var16.func_75216_d() && var17 != null && var16.func_75214_a(var17)) {
                  var6.func_70299_a(p_75144_2_, (ItemStack)null);
                  var16.func_75215_d(var17);
               }
            }
         } else if(p_75144_3_ == 3 && p_75144_4_.field_71075_bZ.field_75098_d && var6.func_70445_o() == null && p_75144_1_ >= 0) {
            var16 = (Slot)this.field_75151_b.get(p_75144_1_);
            if(var16 != null && var16.func_75216_d()) {
               var17 = var16.func_75211_c().func_77946_l();
               var17.field_77994_a = var17.func_77976_d();
               var6.func_70437_b(var17);
            }
         } else if(p_75144_3_ == 4 && var6.func_70445_o() == null && p_75144_1_ >= 0) {
            var16 = (Slot)this.field_75151_b.get(p_75144_1_);
            if(var16 != null && var16.func_75216_d() && var16.func_82869_a(p_75144_4_)) {
               var17 = var16.func_75209_a(p_75144_2_ == 0?1:var16.func_75211_c().field_77994_a);
               var16.func_82870_a(p_75144_4_, var17);
               p_75144_4_.func_71019_a(var17, true);
            }
         } else if(p_75144_3_ == 6 && p_75144_1_ >= 0) {
            var16 = (Slot)this.field_75151_b.get(p_75144_1_);
            var17 = var6.func_70445_o();
            if(var17 != null && (var16 == null || !var16.func_75216_d() || !var16.func_82869_a(p_75144_4_))) {
               var9 = p_75144_2_ == 0?0:this.field_75151_b.size() - 1;
               var21 = p_75144_2_ == 0?1:-1;

               for(int var22 = 0; var22 < 2; ++var22) {
                  for(int var24 = var9; var24 >= 0 && var24 < this.field_75151_b.size() && var17.field_77994_a < var17.func_77976_d(); var24 += var21) {
                     Slot var25 = (Slot)this.field_75151_b.get(var24);
                     if(var25.func_75216_d() && func_94527_a(var25, var17, true) && var25.func_82869_a(p_75144_4_) && this.func_94530_a(var17, var25) && (var22 != 0 || var25.func_75211_c().field_77994_a != var25.func_75211_c().func_77976_d())) {
                        int var14 = Math.min(var17.func_77976_d() - var17.field_77994_a, var25.func_75211_c().field_77994_a);
                        ItemStack var15 = var25.func_75209_a(var14);
                        var17.field_77994_a += var14;
                        if(var15.field_77994_a <= 0) {
                           var25.func_75215_d((ItemStack)null);
                        }

                        var25.func_82870_a(p_75144_4_, var15);
                     }
                  }
               }
            }

            this.func_75142_b();
         }
      }

      return var5;
   }

   public boolean func_94530_a(ItemStack p_94530_1_, Slot p_94530_2_) {
      return true;
   }

   protected void func_75133_b(int p_75133_1_, int p_75133_2_, boolean p_75133_3_, EntityPlayer p_75133_4_) {
      this.func_75144_a(p_75133_1_, p_75133_2_, 1, p_75133_4_);
   }

   public void func_75134_a(EntityPlayer p_75134_1_) {
      InventoryPlayer var2 = p_75134_1_.field_71071_by;
      if(var2.func_70445_o() != null) {
         p_75134_1_.func_71019_a(var2.func_70445_o(), false);
         var2.func_70437_b((ItemStack)null);
      }

   }

   public void func_75130_a(IInventory p_75130_1_) {
      this.func_75142_b();
   }

   public void func_75141_a(int p_75141_1_, ItemStack p_75141_2_) {
      this.func_75139_a(p_75141_1_).func_75215_d(p_75141_2_);
   }

   public void func_75131_a(ItemStack[] p_75131_1_) {
      for(int var2 = 0; var2 < p_75131_1_.length; ++var2) {
         this.func_75139_a(var2).func_75215_d(p_75131_1_[var2]);
      }

   }

   public void func_75137_b(int p_75137_1_, int p_75137_2_) {}

   public short func_75136_a(InventoryPlayer p_75136_1_) {
      ++this.field_75150_e;
      return this.field_75150_e;
   }

   public boolean func_75129_b(EntityPlayer p_75129_1_) {
      return !this.field_75148_f.contains(p_75129_1_);
   }

   public void func_75128_a(EntityPlayer p_75128_1_, boolean p_75128_2_) {
      if(p_75128_2_) {
         this.field_75148_f.remove(p_75128_1_);
      } else {
         this.field_75148_f.add(p_75128_1_);
      }

   }

   public abstract boolean func_75145_c(EntityPlayer var1);

   protected boolean func_75135_a(ItemStack p_75135_1_, int p_75135_2_, int p_75135_3_, boolean p_75135_4_) {
      boolean var5 = false;
      int var6 = p_75135_2_;
      if(p_75135_4_) {
         var6 = p_75135_3_ - 1;
      }

      Slot var7;
      ItemStack var8;
      if(p_75135_1_.func_77985_e()) {
         while(p_75135_1_.field_77994_a > 0 && (!p_75135_4_ && var6 < p_75135_3_ || p_75135_4_ && var6 >= p_75135_2_)) {
            var7 = (Slot)this.field_75151_b.get(var6);
            var8 = var7.func_75211_c();
            if(var8 != null && var8.func_77973_b() == p_75135_1_.func_77973_b() && (!p_75135_1_.func_77981_g() || p_75135_1_.func_77960_j() == var8.func_77960_j()) && ItemStack.func_77970_a(p_75135_1_, var8)) {
               int var9 = var8.field_77994_a + p_75135_1_.field_77994_a;
               if(var9 <= p_75135_1_.func_77976_d()) {
                  p_75135_1_.field_77994_a = 0;
                  var8.field_77994_a = var9;
                  var7.func_75218_e();
                  var5 = true;
               } else if(var8.field_77994_a < p_75135_1_.func_77976_d()) {
                  p_75135_1_.field_77994_a -= p_75135_1_.func_77976_d() - var8.field_77994_a;
                  var8.field_77994_a = p_75135_1_.func_77976_d();
                  var7.func_75218_e();
                  var5 = true;
               }
            }

            if(p_75135_4_) {
               --var6;
            } else {
               ++var6;
            }
         }
      }

      if(p_75135_1_.field_77994_a > 0) {
         if(p_75135_4_) {
            var6 = p_75135_3_ - 1;
         } else {
            var6 = p_75135_2_;
         }

         while(!p_75135_4_ && var6 < p_75135_3_ || p_75135_4_ && var6 >= p_75135_2_) {
            var7 = (Slot)this.field_75151_b.get(var6);
            var8 = var7.func_75211_c();
            if(var8 == null) {
               var7.func_75215_d(p_75135_1_.func_77946_l());
               var7.func_75218_e();
               p_75135_1_.field_77994_a = 0;
               var5 = true;
               break;
            }

            if(p_75135_4_) {
               --var6;
            } else {
               ++var6;
            }
         }
      }

      return var5;
   }

   public static int func_94529_b(int p_94529_0_) {
      return p_94529_0_ >> 2 & 3;
   }

   public static int func_94532_c(int p_94532_0_) {
      return p_94532_0_ & 3;
   }

   public static int func_94534_d(int p_94534_0_, int p_94534_1_) {
      return p_94534_0_ & 3 | (p_94534_1_ & 3) << 2;
   }

   public static boolean func_180610_a(int p_180610_0_, EntityPlayer p_180610_1_) {
      return p_180610_0_ == 0?true:(p_180610_0_ == 1?true:p_180610_0_ == 2 && p_180610_1_.field_71075_bZ.field_75098_d);
   }

   protected void func_94533_d() {
      this.field_94536_g = 0;
      this.field_94537_h.clear();
   }

   public static boolean func_94527_a(Slot p_94527_0_, ItemStack p_94527_1_, boolean p_94527_2_) {
      boolean var3 = p_94527_0_ == null || !p_94527_0_.func_75216_d();
      if(p_94527_0_ != null && p_94527_0_.func_75216_d() && p_94527_1_ != null && p_94527_1_.func_77969_a(p_94527_0_.func_75211_c()) && ItemStack.func_77970_a(p_94527_0_.func_75211_c(), p_94527_1_)) {
         int var10002 = p_94527_2_?0:p_94527_1_.field_77994_a;
         var3 |= p_94527_0_.func_75211_c().field_77994_a + var10002 <= p_94527_1_.func_77976_d();
      }

      return var3;
   }

   public static void func_94525_a(Set p_94525_0_, int p_94525_1_, ItemStack p_94525_2_, int p_94525_3_) {
      switch(p_94525_1_) {
      case 0:
         p_94525_2_.field_77994_a = MathHelper.func_76141_d((float)p_94525_2_.field_77994_a / (float)p_94525_0_.size());
         break;
      case 1:
         p_94525_2_.field_77994_a = 1;
         break;
      case 2:
         p_94525_2_.field_77994_a = p_94525_2_.func_77973_b().func_77639_j();
      }

      p_94525_2_.field_77994_a += p_94525_3_;
   }

   public boolean func_94531_b(Slot p_94531_1_) {
      return true;
   }

   public static int func_178144_a(TileEntity p_178144_0_) {
      return p_178144_0_ instanceof IInventory?func_94526_b((IInventory)p_178144_0_):0;
   }

   public static int func_94526_b(IInventory p_94526_0_) {
      if(p_94526_0_ == null) {
         return 0;
      } else {
         int var1 = 0;
         float var2 = 0.0F;

         for(int var3 = 0; var3 < p_94526_0_.func_70302_i_(); ++var3) {
            ItemStack var4 = p_94526_0_.func_70301_a(var3);
            if(var4 != null) {
               var2 += (float)var4.field_77994_a / (float)Math.min(p_94526_0_.func_70297_j_(), var4.func_77976_d());
               ++var1;
            }
         }

         var2 /= (float)p_94526_0_.func_70302_i_();
         return MathHelper.func_76141_d(var2 * 14.0F) + (var1 > 0?1:0);
      }
   }
}
