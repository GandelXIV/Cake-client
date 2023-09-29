package net.minecraft.pathfinding;

import net.minecraft.entity.EntityLiving;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.pathfinder.SwimNodeProcessor;

public class PathNavigateSwimmer extends PathNavigate {

   private static final String __OBFID = "CL_00002244";


   public PathNavigateSwimmer(EntityLiving p_i45873_1_, World p_i45873_2_) {
      super(p_i45873_1_, p_i45873_2_);
   }

   protected PathFinder func_179679_a() {
      return new PathFinder(new SwimNodeProcessor());
   }

   protected boolean func_75485_k() {
      return this.func_75506_l();
   }

   protected Vec3 func_75502_i() {
      return new Vec3(this.field_75515_a.field_70165_t, this.field_75515_a.field_70163_u + (double)this.field_75515_a.field_70131_O * 0.5D, this.field_75515_a.field_70161_v);
   }

   protected void func_75508_h() {
      Vec3 var1 = this.func_75502_i();
      float var2 = this.field_75515_a.field_70130_N * this.field_75515_a.field_70130_N;
      byte var3 = 6;
      if(var1.func_72436_e(this.field_75514_c.func_75881_a(this.field_75515_a, this.field_75514_c.func_75873_e())) < (double)var2) {
         this.field_75514_c.func_75875_a();
      }

      for(int var4 = Math.min(this.field_75514_c.func_75873_e() + var3, this.field_75514_c.func_75874_d() - 1); var4 > this.field_75514_c.func_75873_e(); --var4) {
         Vec3 var5 = this.field_75514_c.func_75881_a(this.field_75515_a, var4);
         if(var5.func_72436_e(var1) <= 36.0D && this.func_75493_a(var1, var5, 0, 0, 0)) {
            this.field_75514_c.func_75872_c(var4);
            break;
         }
      }

      this.func_179677_a(var1);
   }

   protected void func_75487_m() {
      super.func_75487_m();
   }

   protected boolean func_75493_a(Vec3 p_75493_1_, Vec3 p_75493_2_, int p_75493_3_, int p_75493_4_, int p_75493_5_) {
      MovingObjectPosition var6 = this.field_75513_b.func_147447_a(p_75493_1_, new Vec3(p_75493_2_.field_72450_a, p_75493_2_.field_72448_b + (double)this.field_75515_a.field_70131_O * 0.5D, p_75493_2_.field_72449_c), false, true, false);
      return var6 == null || var6.field_72313_a == MovingObjectPosition.MovingObjectType.MISS;
   }
}
