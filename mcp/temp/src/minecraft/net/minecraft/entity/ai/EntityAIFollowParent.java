package net.minecraft.entity.ai;

import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityAnimal;

public class EntityAIFollowParent extends EntityAIBase {

   EntityAnimal field_75348_a;
   EntityAnimal field_75346_b;
   double field_75347_c;
   private int field_75345_d;
   private static final String __OBFID = "CL_00001586";


   public EntityAIFollowParent(EntityAnimal p_i1626_1_, double p_i1626_2_) {
      this.field_75348_a = p_i1626_1_;
      this.field_75347_c = p_i1626_2_;
   }

   public boolean func_75250_a() {
      if(this.field_75348_a.func_70874_b() >= 0) {
         return false;
      } else {
         List var1 = this.field_75348_a.field_70170_p.func_72872_a(this.field_75348_a.getClass(), this.field_75348_a.func_174813_aQ().func_72314_b(8.0D, 4.0D, 8.0D));
         EntityAnimal var2 = null;
         double var3 = Double.MAX_VALUE;
         Iterator var5 = var1.iterator();

         while(var5.hasNext()) {
            EntityAnimal var6 = (EntityAnimal)var5.next();
            if(var6.func_70874_b() >= 0) {
               double var7 = this.field_75348_a.func_70068_e(var6);
               if(var7 <= var3) {
                  var3 = var7;
                  var2 = var6;
               }
            }
         }

         if(var2 == null) {
            return false;
         } else if(var3 < 9.0D) {
            return false;
         } else {
            this.field_75346_b = var2;
            return true;
         }
      }
   }

   public boolean func_75253_b() {
      if(this.field_75348_a.func_70874_b() >= 0) {
         return false;
      } else if(!this.field_75346_b.func_70089_S()) {
         return false;
      } else {
         double var1 = this.field_75348_a.func_70068_e(this.field_75346_b);
         return var1 >= 9.0D && var1 <= 256.0D;
      }
   }

   public void func_75249_e() {
      this.field_75345_d = 0;
   }

   public void func_75251_c() {
      this.field_75346_b = null;
   }

   public void func_75246_d() {
      if(--this.field_75345_d <= 0) {
         this.field_75345_d = 10;
         this.field_75348_a.func_70661_as().func_75497_a(this.field_75346_b, this.field_75347_c);
      }
   }
}
