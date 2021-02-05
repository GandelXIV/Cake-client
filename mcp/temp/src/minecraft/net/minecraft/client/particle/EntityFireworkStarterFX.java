package net.minecraft.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFireworkOverlayFX;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemDye;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFireworkStarterFX extends EntityFX {

   private int field_92042_ax;
   private final EffectRenderer field_92040_ay;
   private NBTTagList field_92039_az;
   boolean field_92041_a;
   private static final String __OBFID = "CL_00000906";


   public EntityFireworkStarterFX(World p_i46355_1_, double p_i46355_2_, double p_i46355_4_, double p_i46355_6_, double p_i46355_8_, double p_i46355_10_, double p_i46355_12_, EffectRenderer p_i46355_14_, NBTTagCompound p_i46355_15_) {
      super(p_i46355_1_, p_i46355_2_, p_i46355_4_, p_i46355_6_, 0.0D, 0.0D, 0.0D);
      this.field_70159_w = p_i46355_8_;
      this.field_70181_x = p_i46355_10_;
      this.field_70179_y = p_i46355_12_;
      this.field_92040_ay = p_i46355_14_;
      this.field_70547_e = 8;
      if(p_i46355_15_ != null) {
         this.field_92039_az = p_i46355_15_.func_150295_c("Explosions", 10);
         if(this.field_92039_az.func_74745_c() == 0) {
            this.field_92039_az = null;
         } else {
            this.field_70547_e = this.field_92039_az.func_74745_c() * 2 - 1;

            for(int var16 = 0; var16 < this.field_92039_az.func_74745_c(); ++var16) {
               NBTTagCompound var17 = this.field_92039_az.func_150305_b(var16);
               if(var17.func_74767_n("Flicker")) {
                  this.field_92041_a = true;
                  this.field_70547_e += 15;
                  break;
               }
            }
         }
      }

   }

   public void func_180434_a(WorldRenderer p_180434_1_, Entity p_180434_2_, float p_180434_3_, float p_180434_4_, float p_180434_5_, float p_180434_6_, float p_180434_7_, float p_180434_8_) {}

   public void func_70071_h_() {
      boolean var1;
      if(this.field_92042_ax == 0 && this.field_92039_az != null) {
         var1 = this.func_92037_i();
         boolean var2 = false;
         if(this.field_92039_az.func_74745_c() >= 3) {
            var2 = true;
         } else {
            for(int var3 = 0; var3 < this.field_92039_az.func_74745_c(); ++var3) {
               NBTTagCompound var4 = this.field_92039_az.func_150305_b(var3);
               if(var4.func_74771_c("Type") == 1) {
                  var2 = true;
                  break;
               }
            }
         }

         String var16 = "fireworks." + (var2?"largeBlast":"blast") + (var1?"_far":"");
         this.field_70170_p.func_72980_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, var16, 20.0F, 0.95F + this.field_70146_Z.nextFloat() * 0.1F, true);
      }

      if(this.field_92042_ax % 2 == 0 && this.field_92039_az != null && this.field_92042_ax / 2 < this.field_92039_az.func_74745_c()) {
         int var13 = this.field_92042_ax / 2;
         NBTTagCompound var14 = this.field_92039_az.func_150305_b(var13);
         byte var17 = var14.func_74771_c("Type");
         boolean var18 = var14.func_74767_n("Trail");
         boolean var5 = var14.func_74767_n("Flicker");
         int[] var6 = var14.func_74759_k("Colors");
         int[] var7 = var14.func_74759_k("FadeColors");
         if(var6.length == 0) {
            var6 = new int[]{ItemDye.field_150922_c[0]};
         }

         if(var17 == 1) {
            this.func_92035_a(0.5D, 4, var6, var7, var18, var5);
         } else if(var17 == 2) {
            this.func_92038_a(0.5D, new double[][]{{0.0D, 1.0D}, {0.3455D, 0.309D}, {0.9511D, 0.309D}, {0.3795918367346939D, -0.12653061224489795D}, {0.6122448979591837D, -0.8040816326530612D}, {0.0D, -0.35918367346938773D}}, var6, var7, var18, var5, false);
         } else if(var17 == 3) {
            this.func_92038_a(0.5D, new double[][]{{0.0D, 0.2D}, {0.2D, 0.2D}, {0.2D, 0.6D}, {0.6D, 0.6D}, {0.6D, 0.2D}, {0.2D, 0.2D}, {0.2D, 0.0D}, {0.4D, 0.0D}, {0.4D, -0.6D}, {0.2D, -0.6D}, {0.2D, -0.4D}, {0.0D, -0.4D}}, var6, var7, var18, var5, true);
         } else if(var17 == 4) {
            this.func_92036_a(var6, var7, var18, var5);
         } else {
            this.func_92035_a(0.25D, 2, var6, var7, var18, var5);
         }

         int var8 = var6[0];
         float var9 = (float)((var8 & 16711680) >> 16) / 255.0F;
         float var10 = (float)((var8 & '\uff00') >> 8) / 255.0F;
         float var11 = (float)((var8 & 255) >> 0) / 255.0F;
         EntityFireworkOverlayFX var12 = new EntityFireworkOverlayFX(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v);
         var12.func_70538_b(var9, var10, var11);
         this.field_92040_ay.func_78873_a(var12);
      }

      ++this.field_92042_ax;
      if(this.field_92042_ax > this.field_70547_e) {
         if(this.field_92041_a) {
            var1 = this.func_92037_i();
            String var15 = "fireworks." + (var1?"twinkle_far":"twinkle");
            this.field_70170_p.func_72980_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, var15, 20.0F, 0.9F + this.field_70146_Z.nextFloat() * 0.15F, true);
         }

         this.func_70106_y();
      }

   }

   private boolean func_92037_i() {
      Minecraft var1 = Minecraft.func_71410_x();
      return var1 == null || var1.func_175606_aa() == null || var1.func_175606_aa().func_70092_e(this.field_70165_t, this.field_70163_u, this.field_70161_v) >= 256.0D;
   }

   private void func_92034_a(double p_92034_1_, double p_92034_3_, double p_92034_5_, double p_92034_7_, double p_92034_9_, double p_92034_11_, int[] p_92034_13_, int[] p_92034_14_, boolean p_92034_15_, boolean p_92034_16_) {
      EntityFireworkSparkFX var17 = new EntityFireworkSparkFX(this.field_70170_p, p_92034_1_, p_92034_3_, p_92034_5_, p_92034_7_, p_92034_9_, p_92034_11_, this.field_92040_ay);
      var17.func_82338_g(0.99F);
      var17.func_92045_e(p_92034_15_);
      var17.func_92043_f(p_92034_16_);
      int var18 = this.field_70146_Z.nextInt(p_92034_13_.length);
      var17.func_92044_a(p_92034_13_[var18]);
      if(p_92034_14_ != null && p_92034_14_.length > 0) {
         var17.func_92046_g(p_92034_14_[this.field_70146_Z.nextInt(p_92034_14_.length)]);
      }

      this.field_92040_ay.func_78873_a(var17);
   }

   private void func_92035_a(double p_92035_1_, int p_92035_3_, int[] p_92035_4_, int[] p_92035_5_, boolean p_92035_6_, boolean p_92035_7_) {
      double var8 = this.field_70165_t;
      double var10 = this.field_70163_u;
      double var12 = this.field_70161_v;

      for(int var14 = -p_92035_3_; var14 <= p_92035_3_; ++var14) {
         for(int var15 = -p_92035_3_; var15 <= p_92035_3_; ++var15) {
            for(int var16 = -p_92035_3_; var16 <= p_92035_3_; ++var16) {
               double var17 = (double)var15 + (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) * 0.5D;
               double var19 = (double)var14 + (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) * 0.5D;
               double var21 = (double)var16 + (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) * 0.5D;
               double var23 = (double)MathHelper.func_76133_a(var17 * var17 + var19 * var19 + var21 * var21) / p_92035_1_ + this.field_70146_Z.nextGaussian() * 0.05D;
               this.func_92034_a(var8, var10, var12, var17 / var23, var19 / var23, var21 / var23, p_92035_4_, p_92035_5_, p_92035_6_, p_92035_7_);
               if(var14 != -p_92035_3_ && var14 != p_92035_3_ && var15 != -p_92035_3_ && var15 != p_92035_3_) {
                  var16 += p_92035_3_ * 2 - 1;
               }
            }
         }
      }

   }

   private void func_92038_a(double p_92038_1_, double[][] p_92038_3_, int[] p_92038_4_, int[] p_92038_5_, boolean p_92038_6_, boolean p_92038_7_, boolean p_92038_8_) {
      double var9 = p_92038_3_[0][0];
      double var11 = p_92038_3_[0][1];
      this.func_92034_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, var9 * p_92038_1_, var11 * p_92038_1_, 0.0D, p_92038_4_, p_92038_5_, p_92038_6_, p_92038_7_);
      float var13 = this.field_70146_Z.nextFloat() * 3.1415927F;
      double var14 = p_92038_8_?0.034D:0.34D;

      for(int var16 = 0; var16 < 3; ++var16) {
         double var17 = (double)var13 + (double)((float)var16 * 3.1415927F) * var14;
         double var19 = var9;
         double var21 = var11;

         for(int var23 = 1; var23 < p_92038_3_.length; ++var23) {
            double var24 = p_92038_3_[var23][0];
            double var26 = p_92038_3_[var23][1];

            for(double var28 = 0.25D; var28 <= 1.0D; var28 += 0.25D) {
               double var30 = (var19 + (var24 - var19) * var28) * p_92038_1_;
               double var32 = (var21 + (var26 - var21) * var28) * p_92038_1_;
               double var34 = var30 * Math.sin(var17);
               var30 *= Math.cos(var17);

               for(double var36 = -1.0D; var36 <= 1.0D; var36 += 2.0D) {
                  this.func_92034_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, var30 * var36, var32, var34 * var36, p_92038_4_, p_92038_5_, p_92038_6_, p_92038_7_);
               }
            }

            var19 = var24;
            var21 = var26;
         }
      }

   }

   private void func_92036_a(int[] p_92036_1_, int[] p_92036_2_, boolean p_92036_3_, boolean p_92036_4_) {
      double var5 = this.field_70146_Z.nextGaussian() * 0.05D;
      double var7 = this.field_70146_Z.nextGaussian() * 0.05D;

      for(int var9 = 0; var9 < 70; ++var9) {
         double var10 = this.field_70159_w * 0.5D + this.field_70146_Z.nextGaussian() * 0.15D + var5;
         double var12 = this.field_70179_y * 0.5D + this.field_70146_Z.nextGaussian() * 0.15D + var7;
         double var14 = this.field_70181_x * 0.5D + this.field_70146_Z.nextDouble() * 0.5D;
         this.func_92034_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, var10, var14, var12, p_92036_1_, p_92036_2_, p_92036_3_, p_92036_4_);
      }

   }

   public int func_70537_b() {
      return 0;
   }
}
