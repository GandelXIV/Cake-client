package net.minecraft.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class EntityLookHelper {

   private EntityLiving field_75659_a;
   private float field_75657_b;
   private float field_75658_c;
   private boolean field_75655_d;
   private double field_75656_e;
   private double field_75653_f;
   private double field_75654_g;
   private static final String __OBFID = "CL_00001572";


   public EntityLookHelper(EntityLiving p_i1613_1_) {
      this.field_75659_a = p_i1613_1_;
   }

   public void func_75651_a(Entity p_75651_1_, float p_75651_2_, float p_75651_3_) {
      this.field_75656_e = p_75651_1_.field_70165_t;
      if(p_75651_1_ instanceof EntityLivingBase) {
         this.field_75653_f = p_75651_1_.field_70163_u + (double)p_75651_1_.func_70047_e();
      } else {
         this.field_75653_f = (p_75651_1_.func_174813_aQ().field_72338_b + p_75651_1_.func_174813_aQ().field_72337_e) / 2.0D;
      }

      this.field_75654_g = p_75651_1_.field_70161_v;
      this.field_75657_b = p_75651_2_;
      this.field_75658_c = p_75651_3_;
      this.field_75655_d = true;
   }

   public void func_75650_a(double p_75650_1_, double p_75650_3_, double p_75650_5_, float p_75650_7_, float p_75650_8_) {
      this.field_75656_e = p_75650_1_;
      this.field_75653_f = p_75650_3_;
      this.field_75654_g = p_75650_5_;
      this.field_75657_b = p_75650_7_;
      this.field_75658_c = p_75650_8_;
      this.field_75655_d = true;
   }

   public void func_75649_a() {
      this.field_75659_a.field_70125_A = 0.0F;
      if(this.field_75655_d) {
         this.field_75655_d = false;
         double var1 = this.field_75656_e - this.field_75659_a.field_70165_t;
         double var3 = this.field_75653_f - (this.field_75659_a.field_70163_u + (double)this.field_75659_a.func_70047_e());
         double var5 = this.field_75654_g - this.field_75659_a.field_70161_v;
         double var7 = (double)MathHelper.func_76133_a(var1 * var1 + var5 * var5);
         float var9 = (float)(Math.atan2(var5, var1) * 180.0D / 3.1415927410125732D) - 90.0F;
         float var10 = (float)(-(Math.atan2(var3, var7) * 180.0D / 3.1415927410125732D));
         this.field_75659_a.field_70125_A = this.func_75652_a(this.field_75659_a.field_70125_A, var10, this.field_75658_c);
         this.field_75659_a.field_70759_as = this.func_75652_a(this.field_75659_a.field_70759_as, var9, this.field_75657_b);
      } else {
         this.field_75659_a.field_70759_as = this.func_75652_a(this.field_75659_a.field_70759_as, this.field_75659_a.field_70761_aq, 10.0F);
      }

      float var11 = MathHelper.func_76142_g(this.field_75659_a.field_70759_as - this.field_75659_a.field_70761_aq);
      if(!this.field_75659_a.func_70661_as().func_75500_f()) {
         if(var11 < -75.0F) {
            this.field_75659_a.field_70759_as = this.field_75659_a.field_70761_aq - 75.0F;
         }

         if(var11 > 75.0F) {
            this.field_75659_a.field_70759_as = this.field_75659_a.field_70761_aq + 75.0F;
         }
      }

   }

   private float func_75652_a(float p_75652_1_, float p_75652_2_, float p_75652_3_) {
      float var4 = MathHelper.func_76142_g(p_75652_2_ - p_75652_1_);
      if(var4 > p_75652_3_) {
         var4 = p_75652_3_;
      }

      if(var4 < -p_75652_3_) {
         var4 = -p_75652_3_;
      }

      return p_75652_1_ + var4;
   }

   public boolean func_180424_b() {
      return this.field_75655_d;
   }

   public double func_180423_e() {
      return this.field_75656_e;
   }

   public double func_180422_f() {
      return this.field_75653_f;
   }

   public double func_180421_g() {
      return this.field_75654_g;
   }
}
