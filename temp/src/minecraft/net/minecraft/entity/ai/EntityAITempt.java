package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;

public class EntityAITempt extends EntityAIBase {

   private EntityCreature field_75284_a;
   private double field_75282_b;
   private double field_75283_c;
   private double field_75280_d;
   private double field_75281_e;
   private double field_75278_f;
   private double field_75279_g;
   private EntityPlayer field_75289_h;
   private int field_75290_i;
   private boolean field_75287_j;
   private Item field_151484_k;
   private boolean field_75285_l;
   private boolean field_75286_m;
   private static final String __OBFID = "CL_00001616";


   public EntityAITempt(EntityCreature p_i45316_1_, double p_i45316_2_, Item p_i45316_4_, boolean p_i45316_5_) {
      this.field_75284_a = p_i45316_1_;
      this.field_75282_b = p_i45316_2_;
      this.field_151484_k = p_i45316_4_;
      this.field_75285_l = p_i45316_5_;
      this.func_75248_a(3);
      if(!(p_i45316_1_.func_70661_as() instanceof PathNavigateGround)) {
         throw new IllegalArgumentException("Unsupported mob type for TemptGoal");
      }
   }

   public boolean func_75250_a() {
      if(this.field_75290_i > 0) {
         --this.field_75290_i;
         return false;
      } else {
         this.field_75289_h = this.field_75284_a.field_70170_p.func_72890_a(this.field_75284_a, 10.0D);
         if(this.field_75289_h == null) {
            return false;
         } else {
            ItemStack var1 = this.field_75289_h.func_71045_bC();
            return var1 == null?false:var1.func_77973_b() == this.field_151484_k;
         }
      }
   }

   public boolean func_75253_b() {
      if(this.field_75285_l) {
         if(this.field_75284_a.func_70068_e(this.field_75289_h) < 36.0D) {
            if(this.field_75289_h.func_70092_e(this.field_75283_c, this.field_75280_d, this.field_75281_e) > 0.010000000000000002D) {
               return false;
            }

            if(Math.abs((double)this.field_75289_h.field_70125_A - this.field_75278_f) > 5.0D || Math.abs((double)this.field_75289_h.field_70177_z - this.field_75279_g) > 5.0D) {
               return false;
            }
         } else {
            this.field_75283_c = this.field_75289_h.field_70165_t;
            this.field_75280_d = this.field_75289_h.field_70163_u;
            this.field_75281_e = this.field_75289_h.field_70161_v;
         }

         this.field_75278_f = (double)this.field_75289_h.field_70125_A;
         this.field_75279_g = (double)this.field_75289_h.field_70177_z;
      }

      return this.func_75250_a();
   }

   public void func_75249_e() {
      this.field_75283_c = this.field_75289_h.field_70165_t;
      this.field_75280_d = this.field_75289_h.field_70163_u;
      this.field_75281_e = this.field_75289_h.field_70161_v;
      this.field_75287_j = true;
      this.field_75286_m = ((PathNavigateGround)this.field_75284_a.func_70661_as()).func_179689_e();
      ((PathNavigateGround)this.field_75284_a.func_70661_as()).func_179690_a(false);
   }

   public void func_75251_c() {
      this.field_75289_h = null;
      this.field_75284_a.func_70661_as().func_75499_g();
      this.field_75290_i = 100;
      this.field_75287_j = false;
      ((PathNavigateGround)this.field_75284_a.func_70661_as()).func_179690_a(this.field_75286_m);
   }

   public void func_75246_d() {
      this.field_75284_a.func_70671_ap().func_75651_a(this.field_75289_h, 30.0F, (float)this.field_75284_a.func_70646_bf());
      if(this.field_75284_a.func_70068_e(this.field_75289_h) < 6.25D) {
         this.field_75284_a.func_70661_as().func_75499_g();
      } else {
         this.field_75284_a.func_70661_as().func_75497_a(this.field_75289_h, this.field_75282_b);
      }

   }

   public boolean func_75277_f() {
      return this.field_75287_j;
   }
}
