package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityAIFollowOwner extends EntityAIBase {

   private EntityTameable field_75338_d;
   private EntityLivingBase field_75339_e;
   World field_75342_a;
   private double field_75336_f;
   private PathNavigate field_75337_g;
   private int field_75343_h;
   float field_75340_b;
   float field_75341_c;
   private boolean field_75344_i;
   private static final String __OBFID = "CL_00001585";


   public EntityAIFollowOwner(EntityTameable p_i1625_1_, double p_i1625_2_, float p_i1625_4_, float p_i1625_5_) {
      this.field_75338_d = p_i1625_1_;
      this.field_75342_a = p_i1625_1_.field_70170_p;
      this.field_75336_f = p_i1625_2_;
      this.field_75337_g = p_i1625_1_.func_70661_as();
      this.field_75341_c = p_i1625_4_;
      this.field_75340_b = p_i1625_5_;
      this.func_75248_a(3);
      if(!(p_i1625_1_.func_70661_as() instanceof PathNavigateGround)) {
         throw new IllegalArgumentException("Unsupported mob type for FollowOwnerGoal");
      }
   }

   public boolean func_75250_a() {
      EntityLivingBase var1 = this.field_75338_d.func_180492_cm();
      if(var1 == null) {
         return false;
      } else if(this.field_75338_d.func_70906_o()) {
         return false;
      } else if(this.field_75338_d.func_70068_e(var1) < (double)(this.field_75341_c * this.field_75341_c)) {
         return false;
      } else {
         this.field_75339_e = var1;
         return true;
      }
   }

   public boolean func_75253_b() {
      return !this.field_75337_g.func_75500_f() && this.field_75338_d.func_70068_e(this.field_75339_e) > (double)(this.field_75340_b * this.field_75340_b) && !this.field_75338_d.func_70906_o();
   }

   public void func_75249_e() {
      this.field_75343_h = 0;
      this.field_75344_i = ((PathNavigateGround)this.field_75338_d.func_70661_as()).func_179689_e();
      ((PathNavigateGround)this.field_75338_d.func_70661_as()).func_179690_a(false);
   }

   public void func_75251_c() {
      this.field_75339_e = null;
      this.field_75337_g.func_75499_g();
      ((PathNavigateGround)this.field_75338_d.func_70661_as()).func_179690_a(true);
   }

   public void func_75246_d() {
      this.field_75338_d.func_70671_ap().func_75651_a(this.field_75339_e, 10.0F, (float)this.field_75338_d.func_70646_bf());
      if(!this.field_75338_d.func_70906_o()) {
         if(--this.field_75343_h <= 0) {
            this.field_75343_h = 10;
            if(!this.field_75337_g.func_75497_a(this.field_75339_e, this.field_75336_f)) {
               if(!this.field_75338_d.func_110167_bD()) {
                  if(this.field_75338_d.func_70068_e(this.field_75339_e) >= 144.0D) {
                     int var1 = MathHelper.func_76128_c(this.field_75339_e.field_70165_t) - 2;
                     int var2 = MathHelper.func_76128_c(this.field_75339_e.field_70161_v) - 2;
                     int var3 = MathHelper.func_76128_c(this.field_75339_e.func_174813_aQ().field_72338_b);

                     for(int var4 = 0; var4 <= 4; ++var4) {
                        for(int var5 = 0; var5 <= 4; ++var5) {
                           if((var4 < 1 || var5 < 1 || var4 > 3 || var5 > 3) && World.func_175683_a(this.field_75342_a, new BlockPos(var1 + var4, var3 - 1, var2 + var5)) && !this.field_75342_a.func_180495_p(new BlockPos(var1 + var4, var3, var2 + var5)).func_177230_c().func_149686_d() && !this.field_75342_a.func_180495_p(new BlockPos(var1 + var4, var3 + 1, var2 + var5)).func_177230_c().func_149686_d()) {
                              this.field_75338_d.func_70012_b((double)((float)(var1 + var4) + 0.5F), (double)var3, (double)((float)(var2 + var5) + 0.5F), this.field_75338_d.field_70177_z, this.field_75338_d.field_70125_A);
                              this.field_75337_g.func_75499_g();
                              return;
                           }
                        }
                     }

                  }
               }
            }
         }
      }
   }
}
