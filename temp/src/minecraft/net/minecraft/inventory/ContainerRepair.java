package net.minecraft.inventory;

import java.util.Iterator;
import java.util.Map;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ContainerRepair extends Container {

   private static final Logger field_148326_f = LogManager.getLogger();
   private IInventory field_82852_f;
   private IInventory field_82853_g;
   private World field_82860_h;
   private BlockPos field_178156_j;
   public int field_82854_e;
   private int field_82856_l;
   private String field_82857_m;
   private final EntityPlayer field_82855_n;
   private static final String __OBFID = "CL_00001732";


   public ContainerRepair(InventoryPlayer p_i45806_1_, World p_i45806_2_, EntityPlayer p_i45806_3_) {
      this(p_i45806_1_, p_i45806_2_, BlockPos.field_177992_a, p_i45806_3_);
   }

   public ContainerRepair(InventoryPlayer p_i45807_1_, final World p_i45807_2_, final BlockPos p_i45807_3_, EntityPlayer p_i45807_4_) {
      this.field_82852_f = new InventoryCraftResult();
      this.field_82853_g = new InventoryBasic("Repair", true, 2) {

         private static final String __OBFID = "CL_00001733";

         public void func_70296_d() {
            super.func_70296_d();
            ContainerRepair.this.func_75130_a(this);
         }
      };
      this.field_178156_j = p_i45807_3_;
      this.field_82860_h = p_i45807_2_;
      this.field_82855_n = p_i45807_4_;
      this.func_75146_a(new Slot(this.field_82853_g, 0, 27, 47));
      this.func_75146_a(new Slot(this.field_82853_g, 1, 76, 47));
      this.func_75146_a(new Slot(this.field_82852_f, 2, 134, 47) {

         private static final String __OBFID = "CL_00001734";

         public boolean func_75214_a(ItemStack p_75214_1_) {
            return false;
         }
         public boolean func_82869_a(EntityPlayer p_82869_1_) {
            return (p_82869_1_.field_71075_bZ.field_75098_d || p_82869_1_.field_71068_ca >= ContainerRepair.this.field_82854_e) && ContainerRepair.this.field_82854_e > 0 && this.func_75216_d();
         }
         public void func_82870_a(EntityPlayer p_82870_1_, ItemStack p_82870_2_) {
            if(!p_82870_1_.field_71075_bZ.field_75098_d) {
               p_82870_1_.func_82242_a(-ContainerRepair.this.field_82854_e);
            }

            ContainerRepair.this.field_82853_g.func_70299_a(0, (ItemStack)null);
            if(ContainerRepair.this.field_82856_l > 0) {
               ItemStack var3 = ContainerRepair.this.field_82853_g.func_70301_a(1);
               if(var3 != null && var3.field_77994_a > ContainerRepair.this.field_82856_l) {
                  var3.field_77994_a -= ContainerRepair.this.field_82856_l;
                  ContainerRepair.this.field_82853_g.func_70299_a(1, var3);
               } else {
                  ContainerRepair.this.field_82853_g.func_70299_a(1, (ItemStack)null);
               }
            } else {
               ContainerRepair.this.field_82853_g.func_70299_a(1, (ItemStack)null);
            }

            ContainerRepair.this.field_82854_e = 0;
            IBlockState var5 = p_i45807_2_.func_180495_p(p_i45807_3_);
            if(!p_82870_1_.field_71075_bZ.field_75098_d && !p_i45807_2_.field_72995_K && var5.func_177230_c() == Blocks.field_150467_bQ && p_82870_1_.func_70681_au().nextFloat() < 0.12F) {
               int var4 = ((Integer)var5.func_177229_b(BlockAnvil.field_176505_b)).intValue();
               ++var4;
               if(var4 > 2) {
                  p_i45807_2_.func_175698_g(p_i45807_3_);
                  p_i45807_2_.func_175718_b(1020, p_i45807_3_, 0);
               } else {
                  p_i45807_2_.func_180501_a(p_i45807_3_, var5.func_177226_a(BlockAnvil.field_176505_b, Integer.valueOf(var4)), 2);
                  p_i45807_2_.func_175718_b(1021, p_i45807_3_, 0);
               }
            } else if(!p_i45807_2_.field_72995_K) {
               p_i45807_2_.func_175718_b(1021, p_i45807_3_, 0);
            }

         }
      });

      int var5;
      for(var5 = 0; var5 < 3; ++var5) {
         for(int var6 = 0; var6 < 9; ++var6) {
            this.func_75146_a(new Slot(p_i45807_1_, var6 + var5 * 9 + 9, 8 + var6 * 18, 84 + var5 * 18));
         }
      }

      for(var5 = 0; var5 < 9; ++var5) {
         this.func_75146_a(new Slot(p_i45807_1_, var5, 8 + var5 * 18, 142));
      }

   }

   public void func_75130_a(IInventory p_75130_1_) {
      super.func_75130_a(p_75130_1_);
      if(p_75130_1_ == this.field_82853_g) {
         this.func_82848_d();
      }

   }

   public void func_82848_d() {
      boolean var1 = false;
      boolean var2 = true;
      boolean var3 = true;
      boolean var4 = true;
      boolean var5 = true;
      boolean var6 = true;
      boolean var7 = true;
      ItemStack var8 = this.field_82853_g.func_70301_a(0);
      this.field_82854_e = 1;
      int var9 = 0;
      byte var10 = 0;
      byte var11 = 0;
      if(var8 == null) {
         this.field_82852_f.func_70299_a(0, (ItemStack)null);
         this.field_82854_e = 0;
      } else {
         ItemStack var12 = var8.func_77946_l();
         ItemStack var13 = this.field_82853_g.func_70301_a(1);
         Map var14 = EnchantmentHelper.func_82781_a(var12);
         boolean var15 = false;
         int var25 = var10 + var8.func_82838_A() + (var13 == null?0:var13.func_82838_A());
         this.field_82856_l = 0;
         int var16;
         if(var13 != null) {
            var15 = var13.func_77973_b() == Items.field_151134_bR && Items.field_151134_bR.func_92110_g(var13).func_74745_c() > 0;
            int var17;
            int var18;
            if(var12.func_77984_f() && var12.func_77973_b().func_82789_a(var8, var13)) {
               var16 = Math.min(var12.func_77952_i(), var12.func_77958_k() / 4);
               if(var16 <= 0) {
                  this.field_82852_f.func_70299_a(0, (ItemStack)null);
                  this.field_82854_e = 0;
                  return;
               }

               for(var17 = 0; var16 > 0 && var17 < var13.field_77994_a; ++var17) {
                  var18 = var12.func_77952_i() - var16;
                  var12.func_77964_b(var18);
                  ++var9;
                  var16 = Math.min(var12.func_77952_i(), var12.func_77958_k() / 4);
               }

               this.field_82856_l = var17;
            } else {
               if(!var15 && (var12.func_77973_b() != var13.func_77973_b() || !var12.func_77984_f())) {
                  this.field_82852_f.func_70299_a(0, (ItemStack)null);
                  this.field_82854_e = 0;
                  return;
               }

               int var20;
               if(var12.func_77984_f() && !var15) {
                  var16 = var8.func_77958_k() - var8.func_77952_i();
                  var17 = var13.func_77958_k() - var13.func_77952_i();
                  var18 = var17 + var12.func_77958_k() * 12 / 100;
                  int var19 = var16 + var18;
                  var20 = var12.func_77958_k() - var19;
                  if(var20 < 0) {
                     var20 = 0;
                  }

                  if(var20 < var12.func_77960_j()) {
                     var12.func_77964_b(var20);
                     var9 += 2;
                  }
               }

               Map var26 = EnchantmentHelper.func_82781_a(var13);
               Iterator var27 = var26.keySet().iterator();

               while(var27.hasNext()) {
                  var18 = ((Integer)var27.next()).intValue();
                  Enchantment var28 = Enchantment.func_180306_c(var18);
                  if(var28 != null) {
                     var20 = var14.containsKey(Integer.valueOf(var18))?((Integer)var14.get(Integer.valueOf(var18))).intValue():0;
                     int var21 = ((Integer)var26.get(Integer.valueOf(var18))).intValue();
                     int var10000;
                     if(var20 == var21) {
                        ++var21;
                        var10000 = var21;
                     } else {
                        var10000 = Math.max(var21, var20);
                     }

                     var21 = var10000;
                     boolean var22 = var28.func_92089_a(var8);
                     if(this.field_82855_n.field_71075_bZ.field_75098_d || var8.func_77973_b() == Items.field_151134_bR) {
                        var22 = true;
                     }

                     Iterator var23 = var14.keySet().iterator();

                     while(var23.hasNext()) {
                        int var24 = ((Integer)var23.next()).intValue();
                        if(var24 != var18 && !var28.func_77326_a(Enchantment.func_180306_c(var24))) {
                           var22 = false;
                           ++var9;
                        }
                     }

                     if(var22) {
                        if(var21 > var28.func_77325_b()) {
                           var21 = var28.func_77325_b();
                        }

                        var14.put(Integer.valueOf(var18), Integer.valueOf(var21));
                        int var29 = 0;
                        switch(var28.func_77324_c()) {
                        case 1:
                           var29 = 8;
                           break;
                        case 2:
                           var29 = 4;
                        case 3:
                        case 4:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        default:
                           break;
                        case 5:
                           var29 = 2;
                           break;
                        case 10:
                           var29 = 1;
                        }

                        if(var15) {
                           var29 = Math.max(1, var29 / 2);
                        }

                        var9 += var29 * var21;
                     }
                  }
               }
            }
         }

         if(StringUtils.isBlank(this.field_82857_m)) {
            if(var8.func_82837_s()) {
               var11 = 1;
               var9 += var11;
               var12.func_135074_t();
            }
         } else if(!this.field_82857_m.equals(var8.func_82833_r())) {
            var11 = 1;
            var9 += var11;
            var12.func_151001_c(this.field_82857_m);
         }

         this.field_82854_e = var25 + var9;
         if(var9 <= 0) {
            var12 = null;
         }

         if(var11 == var9 && var11 > 0 && this.field_82854_e >= 40) {
            this.field_82854_e = 39;
         }

         if(this.field_82854_e >= 40 && !this.field_82855_n.field_71075_bZ.field_75098_d) {
            var12 = null;
         }

         if(var12 != null) {
            var16 = var12.func_82838_A();
            if(var13 != null && var16 < var13.func_82838_A()) {
               var16 = var13.func_82838_A();
            }

            var16 = var16 * 2 + 1;
            var12.func_82841_c(var16);
            EnchantmentHelper.func_82782_a(var14, var12);
         }

         this.field_82852_f.func_70299_a(0, var12);
         this.func_75142_b();
      }
   }

   public void func_75132_a(ICrafting p_75132_1_) {
      super.func_75132_a(p_75132_1_);
      p_75132_1_.func_71112_a(this, 0, this.field_82854_e);
   }

   public void func_75137_b(int p_75137_1_, int p_75137_2_) {
      if(p_75137_1_ == 0) {
         this.field_82854_e = p_75137_2_;
      }

   }

   public void func_75134_a(EntityPlayer p_75134_1_) {
      super.func_75134_a(p_75134_1_);
      if(!this.field_82860_h.field_72995_K) {
         for(int var2 = 0; var2 < this.field_82853_g.func_70302_i_(); ++var2) {
            ItemStack var3 = this.field_82853_g.func_70304_b(var2);
            if(var3 != null) {
               p_75134_1_.func_71019_a(var3, false);
            }
         }

      }
   }

   public boolean func_75145_c(EntityPlayer p_75145_1_) {
      return this.field_82860_h.func_180495_p(this.field_178156_j).func_177230_c() != Blocks.field_150467_bQ?false:p_75145_1_.func_70092_e((double)this.field_178156_j.func_177958_n() + 0.5D, (double)this.field_178156_j.func_177956_o() + 0.5D, (double)this.field_178156_j.func_177952_p() + 0.5D) <= 64.0D;
   }

   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
      ItemStack var3 = null;
      Slot var4 = (Slot)this.field_75151_b.get(p_82846_2_);
      if(var4 != null && var4.func_75216_d()) {
         ItemStack var5 = var4.func_75211_c();
         var3 = var5.func_77946_l();
         if(p_82846_2_ == 2) {
            if(!this.func_75135_a(var5, 3, 39, true)) {
               return null;
            }

            var4.func_75220_a(var5, var3);
         } else if(p_82846_2_ != 0 && p_82846_2_ != 1) {
            if(p_82846_2_ >= 3 && p_82846_2_ < 39 && !this.func_75135_a(var5, 0, 2, false)) {
               return null;
            }
         } else if(!this.func_75135_a(var5, 3, 39, false)) {
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

   public void func_82850_a(String p_82850_1_) {
      this.field_82857_m = p_82850_1_;
      if(this.func_75139_a(2).func_75216_d()) {
         ItemStack var2 = this.func_75139_a(2).func_75211_c();
         if(StringUtils.isBlank(p_82850_1_)) {
            var2.func_135074_t();
         } else {
            var2.func_151001_c(this.field_82857_m);
         }
      }

      this.func_82848_d();
   }

}
