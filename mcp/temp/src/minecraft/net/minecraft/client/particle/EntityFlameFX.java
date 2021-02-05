package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFlameFX extends EntityFX {

   private float field_70562_a;
   private static final String __OBFID = "CL_00000907";


   protected EntityFlameFX(World p_i1209_1_, double p_i1209_2_, double p_i1209_4_, double p_i1209_6_, double p_i1209_8_, double p_i1209_10_, double p_i1209_12_) {
      super(p_i1209_1_, p_i1209_2_, p_i1209_4_, p_i1209_6_, p_i1209_8_, p_i1209_10_, p_i1209_12_);
      this.field_70159_w = this.field_70159_w * 0.009999999776482582D + p_i1209_8_;
      this.field_70181_x = this.field_70181_x * 0.009999999776482582D + p_i1209_10_;
      this.field_70179_y = this.field_70179_y * 0.009999999776482582D + p_i1209_12_;
      double var10000 = p_i1209_2_ + (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.05F);
      var10000 = p_i1209_4_ + (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.05F);
      var10000 = p_i1209_6_ + (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.05F);
      this.field_70562_a = this.field_70544_f;
      this.field_70552_h = this.field_70553_i = this.field_70551_j = 1.0F;
      this.field_70547_e = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) + 4;
      this.field_70145_X = true;
      this.func_70536_a(48);
   }

   public void func_180434_a(WorldRenderer p_180434_1_, Entity p_180434_2_, float p_180434_3_, float p_180434_4_, float p_180434_5_, float p_180434_6_, float p_180434_7_, float p_180434_8_) {
      float var9 = ((float)this.field_70546_d + p_180434_3_) / (float)this.field_70547_e;
      this.field_70544_f = this.field_70562_a * (1.0F - var9 * var9 * 0.5F);
      super.func_180434_a(p_180434_1_, p_180434_2_, p_180434_3_, p_180434_4_, p_180434_5_, p_180434_6_, p_180434_7_, p_180434_8_);
   }

   public int func_70070_b(float p_70070_1_) {
      float var2 = ((float)this.field_70546_d + p_70070_1_) / (float)this.field_70547_e;
      var2 = MathHelper.func_76131_a(var2, 0.0F, 1.0F);
      int var3 = super.func_70070_b(p_70070_1_);
      int var4 = var3 & 255;
      int var5 = var3 >> 16 & 255;
      var4 += (int)(var2 * 15.0F * 16.0F);
      if(var4 > 240) {
         var4 = 240;
      }

      return var4 | var5 << 16;
   }

   public float func_70013_c(float p_70013_1_) {
      float var2 = ((float)this.field_70546_d + p_70013_1_) / (float)this.field_70547_e;
      var2 = MathHelper.func_76131_a(var2, 0.0F, 1.0F);
      float var3 = super.func_70013_c(p_70013_1_);
      return var3 * var2 + (1.0F - var2);
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      if(this.field_70546_d++ >= this.field_70547_e) {
         this.func_70106_y();
      }

      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      this.field_70159_w *= 0.9599999785423279D;
      this.field_70181_x *= 0.9599999785423279D;
      this.field_70179_y *= 0.9599999785423279D;
      if(this.field_70122_E) {
         this.field_70159_w *= 0.699999988079071D;
         this.field_70179_y *= 0.699999988079071D;
      }

   }

   public static class Factory implements IParticleFactory {

      private static final String __OBFID = "CL_00002602";


      public EntityFX func_178902_a(int p_178902_1_, World p_178902_2_, double p_178902_3_, double p_178902_5_, double p_178902_7_, double p_178902_9_, double p_178902_11_, double p_178902_13_, int ... p_178902_15_) {
         return new EntityFlameFX(p_178902_2_, p_178902_3_, p_178902_5_, p_178902_7_, p_178902_9_, p_178902_11_, p_178902_13_);
      }
   }
}
