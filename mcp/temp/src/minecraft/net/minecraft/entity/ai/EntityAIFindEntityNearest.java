package net.minecraft.entity.ai;

import com.google.common.base.Predicate;
import java.util.Collections;
import java.util.List;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayerMP;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityAIFindEntityNearest extends EntityAIBase {

   private static final Logger field_179444_a = LogManager.getLogger();
   private EntityLiving field_179442_b;
   private final Predicate field_179443_c;
   private final EntityAINearestAttackableTarget.Sorter field_179440_d;
   private EntityLivingBase field_179441_e;
   private Class field_179439_f;
   private static final String __OBFID = "CL_00002250";


   public EntityAIFindEntityNearest(EntityLiving p_i45884_1_, Class p_i45884_2_) {
      this.field_179442_b = p_i45884_1_;
      this.field_179439_f = p_i45884_2_;
      if(p_i45884_1_ instanceof EntityCreature) {
         field_179444_a.warn("Use NearestAttackableTargetGoal.class for PathfinerMob mobs!");
      }

      this.field_179443_c = new Predicate() {

         private static final String __OBFID = "CL_00002249";

         public boolean func_179876_a(EntityLivingBase p_179876_1_) {
            double var2 = EntityAIFindEntityNearest.this.func_179438_f();
            if(p_179876_1_.func_70093_af()) {
               var2 *= 0.800000011920929D;
            }

            return p_179876_1_.func_82150_aj()?false:((double)p_179876_1_.func_70032_d(EntityAIFindEntityNearest.this.field_179442_b) > var2?false:EntityAITarget.func_179445_a(EntityAIFindEntityNearest.this.field_179442_b, p_179876_1_, false, true));
         }
         // $FF: synthetic method
         public boolean apply(Object p_apply_1_) {
            return this.func_179876_a((EntityLivingBase)p_apply_1_);
         }
      };
      this.field_179440_d = new EntityAINearestAttackableTarget.Sorter(p_i45884_1_);
   }

   public boolean func_75250_a() {
      double var1 = this.func_179438_f();
      List var3 = this.field_179442_b.field_70170_p.func_175647_a(this.field_179439_f, this.field_179442_b.func_174813_aQ().func_72314_b(var1, 4.0D, var1), this.field_179443_c);
      Collections.sort(var3, this.field_179440_d);
      if(var3.isEmpty()) {
         return false;
      } else {
         this.field_179441_e = (EntityLivingBase)var3.get(0);
         return true;
      }
   }

   public boolean func_75253_b() {
      EntityLivingBase var1 = this.field_179442_b.func_70638_az();
      if(var1 == null) {
         return false;
      } else if(!var1.func_70089_S()) {
         return false;
      } else {
         double var2 = this.func_179438_f();
         return this.field_179442_b.func_70068_e(var1) > var2 * var2?false:!(var1 instanceof EntityPlayerMP) || !((EntityPlayerMP)var1).field_71134_c.func_73083_d();
      }
   }

   public void func_75249_e() {
      this.field_179442_b.func_70624_b(this.field_179441_e);
      super.func_75249_e();
   }

   public void func_75251_c() {
      this.field_179442_b.func_70624_b((EntityLivingBase)null);
      super.func_75249_e();
   }

   protected double func_179438_f() {
      IAttributeInstance var1 = this.field_179442_b.func_110148_a(SharedMonsterAttributes.field_111265_b);
      return var1 == null?16.0D:var1.func_111126_e();
   }

}
