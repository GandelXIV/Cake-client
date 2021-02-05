package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.MathHelper;

public class EntityMoveHelper {

   protected EntityLiving field_75648_a;
   protected double field_75646_b;
   protected double field_75647_c;
   protected double field_75644_d;
   protected double field_75645_e;
   protected boolean field_75643_f;
   private static final String __OBFID = "CL_00001573";


   public EntityMoveHelper(EntityLiving p_i1614_1_) {
      this.field_75648_a = p_i1614_1_;
      this.field_75646_b = p_i1614_1_.field_70165_t;
      this.field_75647_c = p_i1614_1_.field_70163_u;
      this.field_75644_d = p_i1614_1_.field_70161_v;
   }

   public boolean func_75640_a() {
      return this.field_75643_f;
   }

   public double func_75638_b() {
      return this.field_75645_e;
   }

   public void func_75642_a(double p_75642_1_, double p_75642_3_, double p_75642_5_, double p_75642_7_) {
      this.field_75646_b = p_75642_1_;
      this.field_75647_c = p_75642_3_;
      this.field_75644_d = p_75642_5_;
      this.field_75645_e = p_75642_7_;
      this.field_75643_f = true;
   }

   public void func_75641_c() {
      this.field_75648_a.func_70657_f(0.0F);
      if(this.field_75643_f) {
         this.field_75643_f = false;
         int var1 = MathHelper.func_76128_c(this.field_75648_a.func_174813_aQ().field_72338_b + 0.5D);
         double var2 = this.field_75646_b - this.field_75648_a.field_70165_t;
         double var4 = this.field_75644_d - this.field_75648_a.field_70161_v;
         double var6 = this.field_75647_c - (double)var1;
         double var8 = var2 * var2 + var6 * var6 + var4 * var4;
         if(var8 >= 2.500000277905201E-7D) {
            float var10 = (float)(Math.atan2(var4, var2) * 180.0D / 3.1415927410125732D) - 90.0F;
            this.field_75648_a.field_70177_z = this.func_75639_a(this.field_75648_a.field_70177_z, var10, 30.0F);
            this.field_75648_a.func_70659_e((float)(this.field_75645_e * this.field_75648_a.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111126_e()));
            if(var6 > 0.0D && var2 * var2 + var4 * var4 < 1.0D) {
               this.field_75648_a.func_70683_ar().func_75660_a();
            }

         }
      }
   }

   protected float func_75639_a(float p_75639_1_, float p_75639_2_, float p_75639_3_) {
      float var4 = MathHelper.func_76142_g(p_75639_2_ - p_75639_1_);
      if(var4 > p_75639_3_) {
         var4 = p_75639_3_;
      }

      if(var4 < -p_75639_3_) {
         var4 = -p_75639_3_;
      }

      float var5 = p_75639_1_ + var4;
      if(var5 < 0.0F) {
         var5 += 360.0F;
      } else if(var5 > 360.0F) {
         var5 -= 360.0F;
      }

      return var5;
   }

   public double func_179917_d() {
      return this.field_75646_b;
   }

   public double func_179919_e() {
      return this.field_75647_c;
   }

   public double func_179918_f() {
      return this.field_75644_d;
   }
}
