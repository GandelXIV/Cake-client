package net.minecraft.client.particle;

import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityFireworkSparkFX extends EntityFX {

   private int field_92049_a = 160;
   private boolean field_92054_ax;
   private boolean field_92048_ay;
   private final EffectRenderer field_92047_az;
   private float field_92050_aA;
   private float field_92051_aB;
   private float field_92052_aC;
   private boolean field_92053_aD;
   private static final String __OBFID = "CL_00000905";


   public EntityFireworkSparkFX(World p_i46356_1_, double p_i46356_2_, double p_i46356_4_, double p_i46356_6_, double p_i46356_8_, double p_i46356_10_, double p_i46356_12_, EffectRenderer p_i46356_14_) {
      super(p_i46356_1_, p_i46356_2_, p_i46356_4_, p_i46356_6_);
      this.field_70159_w = p_i46356_8_;
      this.field_70181_x = p_i46356_10_;
      this.field_70179_y = p_i46356_12_;
      this.field_92047_az = p_i46356_14_;
      this.field_70544_f *= 0.75F;
      this.field_70547_e = 48 + this.field_70146_Z.nextInt(12);
      this.field_70145_X = false;
   }

   public void func_92045_e(boolean p_92045_1_) {
      this.field_92054_ax = p_92045_1_;
   }

   public void func_92043_f(boolean p_92043_1_) {
      this.field_92048_ay = p_92043_1_;
   }

   public void func_92044_a(int p_92044_1_) {
      float var2 = (float)((p_92044_1_ & 16711680) >> 16) / 255.0F;
      float var3 = (float)((p_92044_1_ & '\uff00') >> 8) / 255.0F;
      float var4 = (float)((p_92044_1_ & 255) >> 0) / 255.0F;
      float var5 = 1.0F;
      this.func_70538_b(var2 * var5, var3 * var5, var4 * var5);
   }

   public void func_92046_g(int p_92046_1_) {
      this.field_92050_aA = (float)((p_92046_1_ & 16711680) >> 16) / 255.0F;
      this.field_92051_aB = (float)((p_92046_1_ & '\uff00') >> 8) / 255.0F;
      this.field_92052_aC = (float)((p_92046_1_ & 255) >> 0) / 255.0F;
      this.field_92053_aD = true;
   }

   public AxisAlignedBB func_70046_E() {
      return null;
   }

   public boolean func_70104_M() {
      return false;
   }

   public void func_180434_a(WorldRenderer p_180434_1_, Entity p_180434_2_, float p_180434_3_, float p_180434_4_, float p_180434_5_, float p_180434_6_, float p_180434_7_, float p_180434_8_) {
      if(!this.field_92048_ay || this.field_70546_d < this.field_70547_e / 3 || (this.field_70546_d + this.field_70547_e) / 3 % 2 == 0) {
         super.func_180434_a(p_180434_1_, p_180434_2_, p_180434_3_, p_180434_4_, p_180434_5_, p_180434_6_, p_180434_7_, p_180434_8_);
      }

   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      if(this.field_70546_d++ >= this.field_70547_e) {
         this.func_70106_y();
      }

      if(this.field_70546_d > this.field_70547_e / 2) {
         this.func_82338_g(1.0F - ((float)this.field_70546_d - (float)(this.field_70547_e / 2)) / (float)this.field_70547_e);
         if(this.field_92053_aD) {
            this.field_70552_h += (this.field_92050_aA - this.field_70552_h) * 0.2F;
            this.field_70553_i += (this.field_92051_aB - this.field_70553_i) * 0.2F;
            this.field_70551_j += (this.field_92052_aC - this.field_70551_j) * 0.2F;
         }
      }

      this.func_70536_a(this.field_92049_a + (7 - this.field_70546_d * 8 / this.field_70547_e));
      this.field_70181_x -= 0.004D;
      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      this.field_70159_w *= 0.9100000262260437D;
      this.field_70181_x *= 0.9100000262260437D;
      this.field_70179_y *= 0.9100000262260437D;
      if(this.field_70122_E) {
         this.field_70159_w *= 0.699999988079071D;
         this.field_70179_y *= 0.699999988079071D;
      }

      if(this.field_92054_ax && this.field_70546_d < this.field_70547_e / 2 && (this.field_70546_d + this.field_70547_e) % 2 == 0) {
         EntityFireworkSparkFX var1 = new EntityFireworkSparkFX(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D, this.field_92047_az);
         var1.func_82338_g(0.99F);
         var1.func_70538_b(this.field_70552_h, this.field_70553_i, this.field_70551_j);
         var1.field_70546_d = var1.field_70547_e / 2;
         if(this.field_92053_aD) {
            var1.field_92053_aD = true;
            var1.field_92050_aA = this.field_92050_aA;
            var1.field_92051_aB = this.field_92051_aB;
            var1.field_92052_aC = this.field_92052_aC;
         }

         var1.field_92048_ay = this.field_92048_ay;
         this.field_92047_az.func_78873_a(var1);
      }

   }

   public int func_70070_b(float p_70070_1_) {
      return 15728880;
   }

   public float func_70013_c(float p_70013_1_) {
      return 1.0F;
   }
}
