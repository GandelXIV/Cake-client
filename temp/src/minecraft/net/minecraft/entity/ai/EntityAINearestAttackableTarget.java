package net.minecraft.entity.ai;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.player.EntityPlayer;

public class EntityAINearestAttackableTarget extends EntityAITarget {

   protected final Class field_75307_b;
   private final int field_75308_c;
   protected final EntityAINearestAttackableTarget.Sorter field_75306_g;
   protected Predicate field_82643_g;
   protected EntityLivingBase field_75309_a;
   private static final String __OBFID = "CL_00001620";


   public EntityAINearestAttackableTarget(EntityCreature p_i45878_1_, Class p_i45878_2_, boolean p_i45878_3_) {
      this(p_i45878_1_, p_i45878_2_, p_i45878_3_, false);
   }

   public EntityAINearestAttackableTarget(EntityCreature p_i45879_1_, Class p_i45879_2_, boolean p_i45879_3_, boolean p_i45879_4_) {
      this(p_i45879_1_, p_i45879_2_, 10, p_i45879_3_, p_i45879_4_, (Predicate)null);
   }

   public EntityAINearestAttackableTarget(EntityCreature p_i45880_1_, Class p_i45880_2_, int p_i45880_3_, boolean p_i45880_4_, boolean p_i45880_5_, final Predicate p_i45880_6_) {
      super(p_i45880_1_, p_i45880_4_, p_i45880_5_);
      this.field_75307_b = p_i45880_2_;
      this.field_75308_c = p_i45880_3_;
      this.field_75306_g = new EntityAINearestAttackableTarget.Sorter(p_i45880_1_);
      this.func_75248_a(1);
      this.field_82643_g = new Predicate() {

         private static final String __OBFID = "CL_00001621";

         public boolean func_179878_a(EntityLivingBase p_179878_1_) {
            if(p_i45880_6_ != null && !p_i45880_6_.apply(p_179878_1_)) {
               return false;
            } else {
               if(p_179878_1_ instanceof EntityPlayer) {
                  double var2 = EntityAINearestAttackableTarget.this.func_111175_f();
                  if(p_179878_1_.func_70093_af()) {
                     var2 *= 0.800000011920929D;
                  }

                  if(p_179878_1_.func_82150_aj()) {
                     float var4 = ((EntityPlayer)p_179878_1_).func_82243_bO();
                     if(var4 < 0.1F) {
                        var4 = 0.1F;
                     }

                     var2 *= (double)(0.7F * var4);
                  }

                  if((double)p_179878_1_.func_70032_d(EntityAINearestAttackableTarget.this.field_75299_d) > var2) {
                     return false;
                  }
               }

               return EntityAINearestAttackableTarget.this.func_75296_a(p_179878_1_, false);
            }
         }
         // $FF: synthetic method
         public boolean apply(Object p_apply_1_) {
            return this.func_179878_a((EntityLivingBase)p_apply_1_);
         }
      };
   }

   public boolean func_75250_a() {
      if(this.field_75308_c > 0 && this.field_75299_d.func_70681_au().nextInt(this.field_75308_c) != 0) {
         return false;
      } else {
         double var1 = this.func_111175_f();
         List var3 = this.field_75299_d.field_70170_p.func_175647_a(this.field_75307_b, this.field_75299_d.func_174813_aQ().func_72314_b(var1, 4.0D, var1), Predicates.and(this.field_82643_g, IEntitySelector.field_180132_d));
         Collections.sort(var3, this.field_75306_g);
         if(var3.isEmpty()) {
            return false;
         } else {
            this.field_75309_a = (EntityLivingBase)var3.get(0);
            return true;
         }
      }
   }

   public void func_75249_e() {
      this.field_75299_d.func_70624_b(this.field_75309_a);
      super.func_75249_e();
   }

   public static class Sorter implements Comparator {

      private final Entity field_75459_b;
      private static final String __OBFID = "CL_00001622";


      public Sorter(Entity p_i1662_1_) {
         this.field_75459_b = p_i1662_1_;
      }

      public int compare(Entity p_compare_1_, Entity p_compare_2_) {
         double var3 = this.field_75459_b.func_70068_e(p_compare_1_);
         double var5 = this.field_75459_b.func_70068_e(p_compare_2_);
         return var3 < var5?-1:(var3 > var5?1:0);
      }

      // $FF: synthetic method
      public int compare(Object p_compare_1_, Object p_compare_2_) {
         return this.compare((Entity)p_compare_1_, (Entity)p_compare_2_);
      }
   }
}
