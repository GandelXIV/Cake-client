package net.minecraft.entity.ai;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.List;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.Vec3;

public class EntityAIAvoidEntity extends EntityAIBase {

   public final Predicate field_179509_a = new Predicate() {

      private static final String __OBFID = "CL_00001575";

      public boolean func_180419_a(Entity p_180419_1_) {
         return p_180419_1_.func_70089_S() && EntityAIAvoidEntity.this.field_75380_a.func_70635_at().func_75522_a(p_180419_1_);
      }
      // $FF: synthetic method
      public boolean apply(Object p_apply_1_) {
         return this.func_180419_a((Entity)p_apply_1_);
      }
   };
   protected EntityCreature field_75380_a;
   private double field_75378_b;
   private double field_75379_c;
   protected Entity field_75376_d;
   private float field_179508_f;
   private PathEntity field_75374_f;
   private PathNavigate field_75375_g;
   private Predicate field_179510_i;
   private static final String __OBFID = "CL_00001574";


   public EntityAIAvoidEntity(EntityCreature p_i45890_1_, Predicate p_i45890_2_, float p_i45890_3_, double p_i45890_4_, double p_i45890_6_) {
      this.field_75380_a = p_i45890_1_;
      this.field_179510_i = p_i45890_2_;
      this.field_179508_f = p_i45890_3_;
      this.field_75378_b = p_i45890_4_;
      this.field_75379_c = p_i45890_6_;
      this.field_75375_g = p_i45890_1_.func_70661_as();
      this.func_75248_a(1);
   }

   public boolean func_75250_a() {
      List var1 = this.field_75380_a.field_70170_p.func_175674_a(this.field_75380_a, this.field_75380_a.func_174813_aQ().func_72314_b((double)this.field_179508_f, 3.0D, (double)this.field_179508_f), Predicates.and(new Predicate[]{IEntitySelector.field_180132_d, this.field_179509_a, this.field_179510_i}));
      if(var1.isEmpty()) {
         return false;
      } else {
         this.field_75376_d = (Entity)var1.get(0);
         Vec3 var2 = RandomPositionGenerator.func_75461_b(this.field_75380_a, 16, 7, new Vec3(this.field_75376_d.field_70165_t, this.field_75376_d.field_70163_u, this.field_75376_d.field_70161_v));
         if(var2 == null) {
            return false;
         } else if(this.field_75376_d.func_70092_e(var2.field_72450_a, var2.field_72448_b, var2.field_72449_c) < this.field_75376_d.func_70068_e(this.field_75380_a)) {
            return false;
         } else {
            this.field_75374_f = this.field_75375_g.func_75488_a(var2.field_72450_a, var2.field_72448_b, var2.field_72449_c);
            return this.field_75374_f == null?false:this.field_75374_f.func_75880_b(var2);
         }
      }
   }

   public boolean func_75253_b() {
      return !this.field_75375_g.func_75500_f();
   }

   public void func_75249_e() {
      this.field_75375_g.func_75484_a(this.field_75374_f, this.field_75378_b);
   }

   public void func_75251_c() {
      this.field_75376_d = null;
   }

   public void func_75246_d() {
      if(this.field_75380_a.func_70068_e(this.field_75376_d) < 49.0D) {
         this.field_75380_a.func_70661_as().func_75489_a(this.field_75379_c);
      } else {
         this.field_75380_a.func_70661_as().func_75489_a(this.field_75378_b);
      }

   }
}
