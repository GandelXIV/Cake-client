package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySnowShovelFX extends EntityFX {

   float field_70588_a;
   private static final String __OBFID = "CL_00000925";


   protected EntitySnowShovelFX(World p_i1227_1_, double p_i1227_2_, double p_i1227_4_, double p_i1227_6_, double p_i1227_8_, double p_i1227_10_, double p_i1227_12_) {
      this(p_i1227_1_, p_i1227_2_, p_i1227_4_, p_i1227_6_, p_i1227_8_, p_i1227_10_, p_i1227_12_, 1.0F);
   }

   protected EntitySnowShovelFX(World p_i1228_1_, double p_i1228_2_, double p_i1228_4_, double p_i1228_6_, double p_i1228_8_, double p_i1228_10_, double p_i1228_12_, float p_i1228_14_) {
      super(p_i1228_1_, p_i1228_2_, p_i1228_4_, p_i1228_6_, p_i1228_8_, p_i1228_10_, p_i1228_12_);
      this.field_70159_w *= 0.10000000149011612D;
      this.field_70181_x *= 0.10000000149011612D;
      this.field_70179_y *= 0.10000000149011612D;
      this.field_70159_w += p_i1228_8_;
      this.field_70181_x += p_i1228_10_;
      this.field_70179_y += p_i1228_12_;
      this.field_70552_h = this.field_70553_i = this.field_70551_j = 1.0F - (float)(Math.random() * 0.30000001192092896D);
      this.field_70544_f *= 0.75F;
      this.field_70544_f *= p_i1228_14_;
      this.field_70588_a = this.field_70544_f;
      this.field_70547_e = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
      this.field_70547_e = (int)((float)this.field_70547_e * p_i1228_14_);
      this.field_70145_X = false;
   }

   public void func_180434_a(WorldRenderer p_180434_1_, Entity p_180434_2_, float p_180434_3_, float p_180434_4_, float p_180434_5_, float p_180434_6_, float p_180434_7_, float p_180434_8_) {
      float var9 = ((float)this.field_70546_d + p_180434_3_) / (float)this.field_70547_e * 32.0F;
      var9 = MathHelper.func_76131_a(var9, 0.0F, 1.0F);
      this.field_70544_f = this.field_70588_a * var9;
      super.func_180434_a(p_180434_1_, p_180434_2_, p_180434_3_, p_180434_4_, p_180434_5_, p_180434_6_, p_180434_7_, p_180434_8_);
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      if(this.field_70546_d++ >= this.field_70547_e) {
         this.func_70106_y();
      }

      this.func_70536_a(7 - this.field_70546_d * 8 / this.field_70547_e);
      this.field_70181_x -= 0.03D;
      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      this.field_70159_w *= 0.9900000095367432D;
      this.field_70181_x *= 0.9900000095367432D;
      this.field_70179_y *= 0.9900000095367432D;
      if(this.field_70122_E) {
         this.field_70159_w *= 0.699999988079071D;
         this.field_70179_y *= 0.699999988079071D;
      }

   }

   public static class Factory implements IParticleFactory {

      private static final String __OBFID = "CL_00002586";


      public EntityFX func_178902_a(int p_178902_1_, World p_178902_2_, double p_178902_3_, double p_178902_5_, double p_178902_7_, double p_178902_9_, double p_178902_11_, double p_178902_13_, int ... p_178902_15_) {
         return new EntitySnowShovelFX(p_178902_2_, p_178902_3_, p_178902_5_, p_178902_7_, p_178902_9_, p_178902_11_, p_178902_13_);
      }
   }
}
