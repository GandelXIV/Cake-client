package net.minecraft.entity.ai;

import com.google.common.base.Predicate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.passive.EntityTameable;

public class EntityAITargetNonTamed extends EntityAINearestAttackableTarget {

   private EntityTameable field_75310_g;
   private static final String __OBFID = "CL_00001623";


   public EntityAITargetNonTamed(EntityTameable p_i45876_1_, Class p_i45876_2_, boolean p_i45876_3_, Predicate p_i45876_4_) {
      super(p_i45876_1_, p_i45876_2_, 10, p_i45876_3_, false, p_i45876_4_);
      this.field_75310_g = p_i45876_1_;
   }

   public boolean func_75250_a() {
      return !this.field_75310_g.func_70909_n() && super.func_75250_a();
   }
}
