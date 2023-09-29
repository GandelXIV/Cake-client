package net.minecraft.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public abstract class EntityAgeable extends EntityCreature {

   protected int field_175504_a;
   protected int field_175502_b;
   protected int field_175503_c;
   private float field_98056_d = -1.0F;
   private float field_98057_e;
   private static final String __OBFID = "CL_00001530";


   public EntityAgeable(World p_i1578_1_) {
      super(p_i1578_1_);
   }

   public abstract EntityAgeable func_90011_a(EntityAgeable var1);

   public boolean func_70085_c(EntityPlayer p_70085_1_) {
      ItemStack var2 = p_70085_1_.field_71071_by.func_70448_g();
      if(var2 != null && var2.func_77973_b() == Items.field_151063_bx) {
         if(!this.field_70170_p.field_72995_K) {
            Class var3 = EntityList.func_90035_a(var2.func_77960_j());
            if(var3 != null && this.getClass() == var3) {
               EntityAgeable var4 = this.func_90011_a(this);
               if(var4 != null) {
                  var4.func_70873_a(-24000);
                  var4.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
                  this.field_70170_p.func_72838_d(var4);
                  if(var2.func_82837_s()) {
                     var4.func_96094_a(var2.func_82833_r());
                  }

                  if(!p_70085_1_.field_71075_bZ.field_75098_d) {
                     --var2.field_77994_a;
                     if(var2.field_77994_a <= 0) {
                        p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, (ItemStack)null);
                     }
                  }
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(12, Byte.valueOf((byte)0));
   }

   public int func_70874_b() {
      return this.field_70170_p.field_72995_K?this.field_70180_af.func_75683_a(12):this.field_175504_a;
   }

   public void func_175501_a(int p_175501_1_, boolean p_175501_2_) {
      int var3 = this.func_70874_b();
      int var4 = var3;
      var3 += p_175501_1_ * 20;
      if(var3 > 0) {
         var3 = 0;
         if(var4 < 0) {
            this.func_175500_n();
         }
      }

      int var5 = var3 - var4;
      this.func_70873_a(var3);
      if(p_175501_2_) {
         this.field_175502_b += var5;
         if(this.field_175503_c == 0) {
            this.field_175503_c = 40;
         }
      }

      if(this.func_70874_b() == 0) {
         this.func_70873_a(this.field_175502_b);
      }

   }

   public void func_110195_a(int p_110195_1_) {
      this.func_175501_a(p_110195_1_, false);
   }

   public void func_70873_a(int p_70873_1_) {
      this.field_70180_af.func_75692_b(12, Byte.valueOf((byte)MathHelper.func_76125_a(p_70873_1_, -1, 1)));
      this.field_175504_a = p_70873_1_;
      this.func_98054_a(this.func_70631_g_());
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74768_a("Age", this.func_70874_b());
      p_70014_1_.func_74768_a("ForcedAge", this.field_175502_b);
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      this.func_70873_a(p_70037_1_.func_74762_e("Age"));
      this.field_175502_b = p_70037_1_.func_74762_e("ForcedAge");
   }

   public void func_70636_d() {
      super.func_70636_d();
      if(this.field_70170_p.field_72995_K) {
         if(this.field_175503_c > 0) {
            if(this.field_175503_c % 4 == 0) {
               this.field_70170_p.func_175688_a(EnumParticleTypes.VILLAGER_HAPPY, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, this.field_70163_u + 0.5D + (double)(this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, 0.0D, 0.0D, 0.0D, new int[0]);
            }

            --this.field_175503_c;
         }

         this.func_98054_a(this.func_70631_g_());
      } else {
         int var1 = this.func_70874_b();
         if(var1 < 0) {
            ++var1;
            this.func_70873_a(var1);
            if(var1 == 0) {
               this.func_175500_n();
            }
         } else if(var1 > 0) {
            --var1;
            this.func_70873_a(var1);
         }
      }

   }

   protected void func_175500_n() {}

   public boolean func_70631_g_() {
      return this.func_70874_b() < 0;
   }

   public void func_98054_a(boolean p_98054_1_) {
      this.func_98055_j(p_98054_1_?0.5F:1.0F);
   }

   protected final void func_70105_a(float p_70105_1_, float p_70105_2_) {
      boolean var3 = this.field_98056_d > 0.0F;
      this.field_98056_d = p_70105_1_;
      this.field_98057_e = p_70105_2_;
      if(!var3) {
         this.func_98055_j(1.0F);
      }

   }

   protected final void func_98055_j(float p_98055_1_) {
      super.func_70105_a(this.field_98056_d * p_98055_1_, this.field_98057_e * p_98055_1_);
   }
}
