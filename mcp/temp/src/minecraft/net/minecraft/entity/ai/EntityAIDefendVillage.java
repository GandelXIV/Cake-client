package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.village.Village;

public class EntityAIDefendVillage extends EntityAITarget {

   EntityIronGolem field_75305_a;
   EntityLivingBase field_75304_b;
   private static final String __OBFID = "CL_00001618";


   public EntityAIDefendVillage(EntityIronGolem p_i1659_1_) {
      super(p_i1659_1_, false, true);
      this.field_75305_a = p_i1659_1_;
      this.func_75248_a(1);
   }

   public boolean func_75250_a() {
      Village var1 = this.field_75305_a.func_70852_n();
      if(var1 == null) {
         return false;
      } else {
         this.field_75304_b = var1.func_75571_b(this.field_75305_a);
         if(!this.func_75296_a(this.field_75304_b, false)) {
            if(this.field_75299_d.func_70681_au().nextInt(20) == 0) {
               this.field_75304_b = var1.func_82685_c(this.field_75305_a);
               return this.func_75296_a(this.field_75304_b, false);
            } else {
               return false;
            }
         } else {
            return true;
         }
      }
   }

   public void func_75249_e() {
      this.field_75305_a.func_70624_b(this.field_75304_b);
      super.func_75249_e();
   }
}
