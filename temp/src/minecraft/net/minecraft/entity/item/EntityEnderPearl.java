package net.minecraft.entity.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityEnderPearl extends EntityThrowable {

   private static final String __OBFID = "CL_00001725";


   public EntityEnderPearl(World p_i1783_1_, EntityLivingBase p_i1783_2_) {
      super(p_i1783_1_, p_i1783_2_);
   }

   public EntityEnderPearl(World p_i1784_1_, double p_i1784_2_, double p_i1784_4_, double p_i1784_6_) {
      super(p_i1784_1_, p_i1784_2_, p_i1784_4_, p_i1784_6_);
   }

   protected void func_70184_a(MovingObjectPosition p_70184_1_) {
      EntityLivingBase var2 = this.func_85052_h();
      if(p_70184_1_.field_72308_g != null) {
         p_70184_1_.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, var2), 0.0F);
      }

      for(int var3 = 0; var3 < 32; ++var3) {
         this.field_70170_p.func_175688_a(EnumParticleTypes.PORTAL, this.field_70165_t, this.field_70163_u + this.field_70146_Z.nextDouble() * 2.0D, this.field_70161_v, this.field_70146_Z.nextGaussian(), 0.0D, this.field_70146_Z.nextGaussian(), new int[0]);
      }

      if(!this.field_70170_p.field_72995_K) {
         if(var2 instanceof EntityPlayerMP) {
            EntityPlayerMP var5 = (EntityPlayerMP)var2;
            if(var5.field_71135_a.func_147362_b().func_150724_d() && var5.field_70170_p == this.field_70170_p && !var5.func_70608_bn()) {
               if(this.field_70146_Z.nextFloat() < 0.05F && this.field_70170_p.func_82736_K().func_82766_b("doMobSpawning")) {
                  EntityEndermite var4 = new EntityEndermite(this.field_70170_p);
                  var4.func_175496_a(true);
                  var4.func_70012_b(var2.field_70165_t, var2.field_70163_u, var2.field_70161_v, var2.field_70177_z, var2.field_70125_A);
                  this.field_70170_p.func_72838_d(var4);
               }

               if(var2.func_70115_ae()) {
                  var2.func_70078_a((Entity)null);
               }

               var2.func_70634_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
               var2.field_70143_R = 0.0F;
               var2.func_70097_a(DamageSource.field_76379_h, 5.0F);
            }
         }

         this.func_70106_y();
      }

   }

   public void func_70071_h_() {
      EntityLivingBase var1 = this.func_85052_h();
      if(var1 != null && var1 instanceof EntityPlayer && !var1.func_70089_S()) {
         this.func_70106_y();
      } else {
         super.func_70071_h_();
      }

   }
}
