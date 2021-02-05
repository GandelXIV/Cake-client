package net.minecraft.inventory;

import java.util.List;
import java.util.Random;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ContainerEnchantment extends Container {

   public IInventory field_75168_e;
   private World field_75172_h;
   private BlockPos field_178150_j;
   private Random field_75169_l;
   public int field_178149_f;
   public int[] field_75167_g;
   public int[] field_178151_h;
   private static final String __OBFID = "CL_00001745";


   public ContainerEnchantment(InventoryPlayer p_i45797_1_, World p_i45797_2_) {
      this(p_i45797_1_, p_i45797_2_, BlockPos.field_177992_a);
   }

   public ContainerEnchantment(InventoryPlayer p_i45798_1_, World p_i45798_2_, BlockPos p_i45798_3_) {
      this.field_75168_e = new InventoryBasic("Enchant", true, 2) {

         private static final String __OBFID = "CL_00001746";

         public int func_70297_j_() {
            return 64;
         }
         public void func_70296_d() {
            super.func_70296_d();
            ContainerEnchantment.this.func_75130_a(this);
         }
      };
      this.field_75169_l = new Random();
      this.field_75167_g = new int[3];
      this.field_178151_h = new int[]{-1, -1, -1};
      this.field_75172_h = p_i45798_2_;
      this.field_178150_j = p_i45798_3_;
      this.field_178149_f = p_i45798_1_.field_70458_d.func_175138_ci();
      this.func_75146_a(new Slot(this.field_75168_e, 0, 15, 47) {

         private static final String __OBFID = "CL_00001747";

         public boolean func_75214_a(ItemStack p_75214_1_) {
            return true;
         }
         public int func_75219_a() {
            return 1;
         }
      });
      this.func_75146_a(new Slot(this.field_75168_e, 1, 35, 47) {

         private static final String __OBFID = "CL_00002185";

         public boolean func_75214_a(ItemStack p_75214_1_) {
            return p_75214_1_.func_77973_b() == Items.field_151100_aR && EnumDyeColor.func_176766_a(p_75214_1_.func_77960_j()) == EnumDyeColor.BLUE;
         }
      });

      int var4;
      for(var4 = 0; var4 < 3; ++var4) {
         for(int var5 = 0; var5 < 9; ++var5) {
            this.func_75146_a(new Slot(p_i45798_1_, var5 + var4 * 9 + 9, 8 + var5 * 18, 84 + var4 * 18));
         }
      }

      for(var4 = 0; var4 < 9; ++var4) {
         this.func_75146_a(new Slot(p_i45798_1_, var4, 8 + var4 * 18, 142));
      }

   }

   public void func_75132_a(ICrafting p_75132_1_) {
      super.func_75132_a(p_75132_1_);
      p_75132_1_.func_71112_a(this, 0, this.field_75167_g[0]);
      p_75132_1_.func_71112_a(this, 1, this.field_75167_g[1]);
      p_75132_1_.func_71112_a(this, 2, this.field_75167_g[2]);
      p_75132_1_.func_71112_a(this, 3, this.field_178149_f & -16);
      p_75132_1_.func_71112_a(this, 4, this.field_178151_h[0]);
      p_75132_1_.func_71112_a(this, 5, this.field_178151_h[1]);
      p_75132_1_.func_71112_a(this, 6, this.field_178151_h[2]);
   }

   public void func_75142_b() {
      super.func_75142_b();

      for(int var1 = 0; var1 < this.field_75149_d.size(); ++var1) {
         ICrafting var2 = (ICrafting)this.field_75149_d.get(var1);
         var2.func_71112_a(this, 0, this.field_75167_g[0]);
         var2.func_71112_a(this, 1, this.field_75167_g[1]);
         var2.func_71112_a(this, 2, this.field_75167_g[2]);
         var2.func_71112_a(this, 3, this.field_178149_f & -16);
         var2.func_71112_a(this, 4, this.field_178151_h[0]);
         var2.func_71112_a(this, 5, this.field_178151_h[1]);
         var2.func_71112_a(this, 6, this.field_178151_h[2]);
      }

   }

   public void func_75137_b(int p_75137_1_, int p_75137_2_) {
      if(p_75137_1_ >= 0 && p_75137_1_ <= 2) {
         this.field_75167_g[p_75137_1_] = p_75137_2_;
      } else if(p_75137_1_ == 3) {
         this.field_178149_f = p_75137_2_;
      } else if(p_75137_1_ >= 4 && p_75137_1_ <= 6) {
         this.field_178151_h[p_75137_1_ - 4] = p_75137_2_;
      } else {
         super.func_75137_b(p_75137_1_, p_75137_2_);
      }

   }

   public void func_75130_a(IInventory p_75130_1_) {
      if(p_75130_1_ == this.field_75168_e) {
         ItemStack var2 = p_75130_1_.func_70301_a(0);
         int var3;
         if(var2 != null && var2.func_77956_u()) {
            if(!this.field_75172_h.field_72995_K) {
               var3 = 0;

               int var4;
               for(var4 = -1; var4 <= 1; ++var4) {
                  for(int var5 = -1; var5 <= 1; ++var5) {
                     if((var4 != 0 || var5 != 0) && this.field_75172_h.func_175623_d(this.field_178150_j.func_177982_a(var5, 0, var4)) && this.field_75172_h.func_175623_d(this.field_178150_j.func_177982_a(var5, 1, var4))) {
                        if(this.field_75172_h.func_180495_p(this.field_178150_j.func_177982_a(var5 * 2, 0, var4 * 2)).func_177230_c() == Blocks.field_150342_X) {
                           ++var3;
                        }

                        if(this.field_75172_h.func_180495_p(this.field_178150_j.func_177982_a(var5 * 2, 1, var4 * 2)).func_177230_c() == Blocks.field_150342_X) {
                           ++var3;
                        }

                        if(var5 != 0 && var4 != 0) {
                           if(this.field_75172_h.func_180495_p(this.field_178150_j.func_177982_a(var5 * 2, 0, var4)).func_177230_c() == Blocks.field_150342_X) {
                              ++var3;
                           }

                           if(this.field_75172_h.func_180495_p(this.field_178150_j.func_177982_a(var5 * 2, 1, var4)).func_177230_c() == Blocks.field_150342_X) {
                              ++var3;
                           }

                           if(this.field_75172_h.func_180495_p(this.field_178150_j.func_177982_a(var5, 0, var4 * 2)).func_177230_c() == Blocks.field_150342_X) {
                              ++var3;
                           }

                           if(this.field_75172_h.func_180495_p(this.field_178150_j.func_177982_a(var5, 1, var4 * 2)).func_177230_c() == Blocks.field_150342_X) {
                              ++var3;
                           }
                        }
                     }
                  }
               }

               this.field_75169_l.setSeed((long)this.field_178149_f);

               for(var4 = 0; var4 < 3; ++var4) {
                  this.field_75167_g[var4] = EnchantmentHelper.func_77514_a(this.field_75169_l, var4, var3, var2);
                  this.field_178151_h[var4] = -1;
                  if(this.field_75167_g[var4] < var4 + 1) {
                     this.field_75167_g[var4] = 0;
                  }
               }

               for(var4 = 0; var4 < 3; ++var4) {
                  if(this.field_75167_g[var4] > 0) {
                     List var7 = this.func_178148_a(var2, var4, this.field_75167_g[var4]);
                     if(var7 != null && !var7.isEmpty()) {
                        EnchantmentData var6 = (EnchantmentData)var7.get(this.field_75169_l.nextInt(var7.size()));
                        this.field_178151_h[var4] = var6.field_76302_b.field_77352_x | var6.field_76303_c << 8;
                     }
                  }
               }

               this.func_75142_b();
            }
         } else {
            for(var3 = 0; var3 < 3; ++var3) {
               this.field_75167_g[var3] = 0;
               this.field_178151_h[var3] = -1;
            }
         }
      }

   }

   public boolean func_75140_a(EntityPlayer p_75140_1_, int p_75140_2_) {
      ItemStack var3 = this.field_75168_e.func_70301_a(0);
      ItemStack var4 = this.field_75168_e.func_70301_a(1);
      int var5 = p_75140_2_ + 1;
      if((var4 == null || var4.field_77994_a < var5) && !p_75140_1_.field_71075_bZ.field_75098_d) {
         return false;
      } else if(this.field_75167_g[p_75140_2_] > 0 && var3 != null && (p_75140_1_.field_71068_ca >= var5 && p_75140_1_.field_71068_ca >= this.field_75167_g[p_75140_2_] || p_75140_1_.field_71075_bZ.field_75098_d)) {
         if(!this.field_75172_h.field_72995_K) {
            List var6 = this.func_178148_a(var3, p_75140_2_, this.field_75167_g[p_75140_2_]);
            boolean var7 = var3.func_77973_b() == Items.field_151122_aG;
            if(var6 != null) {
               p_75140_1_.func_71013_b(var5);
               if(var7) {
                  var3.func_150996_a(Items.field_151134_bR);
               }

               for(int var8 = 0; var8 < var6.size(); ++var8) {
                  EnchantmentData var9 = (EnchantmentData)var6.get(var8);
                  if(var7) {
                     Items.field_151134_bR.func_92115_a(var3, var9);
                  } else {
                     var3.func_77966_a(var9.field_76302_b, var9.field_76303_c);
                  }
               }

               if(!p_75140_1_.field_71075_bZ.field_75098_d) {
                  var4.field_77994_a -= var5;
                  if(var4.field_77994_a <= 0) {
                     this.field_75168_e.func_70299_a(1, (ItemStack)null);
                  }
               }

               this.field_75168_e.func_70296_d();
               this.field_178149_f = p_75140_1_.func_175138_ci();
               this.func_75130_a(this.field_75168_e);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   private List func_178148_a(ItemStack p_178148_1_, int p_178148_2_, int p_178148_3_) {
      this.field_75169_l.setSeed((long)(this.field_178149_f + p_178148_2_));
      List var4 = EnchantmentHelper.func_77513_b(this.field_75169_l, p_178148_1_, p_178148_3_);
      if(p_178148_1_.func_77973_b() == Items.field_151122_aG && var4 != null && var4.size() > 1) {
         var4.remove(this.field_75169_l.nextInt(var4.size()));
      }

      return var4;
   }

   public int func_178147_e() {
      ItemStack var1 = this.field_75168_e.func_70301_a(1);
      return var1 == null?0:var1.field_77994_a;
   }

   public void func_75134_a(EntityPlayer p_75134_1_) {
      super.func_75134_a(p_75134_1_);
      if(!this.field_75172_h.field_72995_K) {
         for(int var2 = 0; var2 < this.field_75168_e.func_70302_i_(); ++var2) {
            ItemStack var3 = this.field_75168_e.func_70304_b(var2);
            if(var3 != null) {
               p_75134_1_.func_71019_a(var3, false);
            }
         }

      }
   }

   public boolean func_75145_c(EntityPlayer p_75145_1_) {
      return this.field_75172_h.func_180495_p(this.field_178150_j).func_177230_c() != Blocks.field_150381_bn?false:p_75145_1_.func_70092_e((double)this.field_178150_j.func_177958_n() + 0.5D, (double)this.field_178150_j.func_177956_o() + 0.5D, (double)this.field_178150_j.func_177952_p() + 0.5D) <= 64.0D;
   }

   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
      ItemStack var3 = null;
      Slot var4 = (Slot)this.field_75151_b.get(p_82846_2_);
      if(var4 != null && var4.func_75216_d()) {
         ItemStack var5 = var4.func_75211_c();
         var3 = var5.func_77946_l();
         if(p_82846_2_ == 0) {
            if(!this.func_75135_a(var5, 2, 38, true)) {
               return null;
            }
         } else if(p_82846_2_ == 1) {
            if(!this.func_75135_a(var5, 2, 38, true)) {
               return null;
            }
         } else if(var5.func_77973_b() == Items.field_151100_aR && EnumDyeColor.func_176766_a(var5.func_77960_j()) == EnumDyeColor.BLUE) {
            if(!this.func_75135_a(var5, 1, 2, true)) {
               return null;
            }
         } else {
            if(((Slot)this.field_75151_b.get(0)).func_75216_d() || !((Slot)this.field_75151_b.get(0)).func_75214_a(var5)) {
               return null;
            }

            if(var5.func_77942_o() && var5.field_77994_a == 1) {
               ((Slot)this.field_75151_b.get(0)).func_75215_d(var5.func_77946_l());
               var5.field_77994_a = 0;
            } else if(var5.field_77994_a >= 1) {
               ((Slot)this.field_75151_b.get(0)).func_75215_d(new ItemStack(var5.func_77973_b(), 1, var5.func_77960_j()));
               --var5.field_77994_a;
            }
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
}
