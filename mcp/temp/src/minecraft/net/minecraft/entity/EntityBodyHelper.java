package net.minecraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class EntityBodyHelper {

   private EntityLivingBase field_75668_a;
   private int field_75666_b;
   private float field_75667_c;
   private static final String __OBFID = "CL_00001570";


   public EntityBodyHelper(EntityLivingBase p_i1611_1_) {
      this.field_75668_a = p_i1611_1_;
   }

   public void func_75664_a() {
      double var1 = this.field_75668_a.field_70165_t - this.field_75668_a.field_70169_q;
      double var3 = this.field_75668_a.field_70161_v - this.field_75668_a.field_70166_s;
      if(var1 * var1 + var3 * var3 > 2.500000277905201E-7D) {
         this.field_75668_a.field_70761_aq = this.field_75668_a.field_70177_z;
         this.field_75668_a.field_70759_as = this.func_75665_a(this.field_75668_a.field_70761_aq, this.field_75668_a.field_70759_as, 75.0F);
         this.field_75667_c = this.field_75668_a.field_70759_as;
         this.field_75666_b = 0;
      } else {
         float var5 = 75.0F;
         if(Math.abs(this.field_75668_a.field_70759_as - this.field_75667_c) > 15.0F) {
            this.field_75666_b = 0;
            this.field_75667_c = this.field_75668_a.field_70759_as;
         } else {
            ++this.field_75666_b;
            boolean var6 = true;
            if(this.field_75666_b > 10) {
               var5 = Math.max(1.0F - (float)(this.field_75666_b - 10) / 10.0F, 0.0F) * 75.0F;
            }
         }

         this.field_75668_a.field_70761_aq = this.func_75665_a(this.field_75668_a.field_70759_as, this.field_75668_a.field_70761_aq, var5);
      }
   }

   private float func_75665_a(float p_75665_1_, float p_75665_2_, float p_75665_3_) {
      float var4 = MathHelper.func_76142_g(p_75665_1_ - p_75665_2_);
      if(var4 < -p_75665_3_) {
         var4 = -p_75665_3_;
      }

      if(var4 >= p_75665_3_) {
         var4 = p_75665_3_;
      }

      return p_75665_1_ - var4;
   }
}
