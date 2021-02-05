package net.minecraft.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityLargeExplodeFX extends EntityFX {

   private static final ResourceLocation field_110127_a = new ResourceLocation("textures/entity/explosion.png");
   private int field_70581_a;
   private int field_70584_aq;
   private TextureManager field_70583_ar;
   private float field_70582_as;
   private static final String __OBFID = "CL_00000910";


   protected EntityLargeExplodeFX(TextureManager p_i1213_1_, World p_i1213_2_, double p_i1213_3_, double p_i1213_5_, double p_i1213_7_, double p_i1213_9_, double p_i1213_11_, double p_i1213_13_) {
      super(p_i1213_2_, p_i1213_3_, p_i1213_5_, p_i1213_7_, 0.0D, 0.0D, 0.0D);
      this.field_70583_ar = p_i1213_1_;
      this.field_70584_aq = 6 + this.field_70146_Z.nextInt(4);
      this.field_70552_h = this.field_70553_i = this.field_70551_j = this.field_70146_Z.nextFloat() * 0.6F + 0.4F;
      this.field_70582_as = 1.0F - (float)p_i1213_9_ * 0.5F;
   }

   public void func_180434_a(WorldRenderer p_180434_1_, Entity p_180434_2_, float p_180434_3_, float p_180434_4_, float p_180434_5_, float p_180434_6_, float p_180434_7_, float p_180434_8_) {
      int var9 = (int)(((float)this.field_70581_a + p_180434_3_) * 15.0F / (float)this.field_70584_aq);
      if(var9 <= 15) {
         this.field_70583_ar.func_110577_a(field_110127_a);
         float var10 = (float)(var9 % 4) / 4.0F;
         float var11 = var10 + 0.24975F;
         float var12 = (float)(var9 / 4) / 4.0F;
         float var13 = var12 + 0.24975F;
         float var14 = 2.0F * this.field_70582_as;
         float var15 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)p_180434_3_ - field_70556_an);
         float var16 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)p_180434_3_ - field_70554_ao);
         float var17 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)p_180434_3_ - field_70555_ap);
         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.func_179140_f();
         RenderHelper.func_74518_a();
         p_180434_1_.func_178970_b();
         p_180434_1_.func_178960_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, 1.0F);
         p_180434_1_.func_178980_d(0.0F, 1.0F, 0.0F);
         p_180434_1_.func_178963_b(240);
         p_180434_1_.func_178985_a((double)(var15 - p_180434_4_ * var14 - p_180434_7_ * var14), (double)(var16 - p_180434_5_ * var14), (double)(var17 - p_180434_6_ * var14 - p_180434_8_ * var14), (double)var11, (double)var13);
         p_180434_1_.func_178985_a((double)(var15 - p_180434_4_ * var14 + p_180434_7_ * var14), (double)(var16 + p_180434_5_ * var14), (double)(var17 - p_180434_6_ * var14 + p_180434_8_ * var14), (double)var11, (double)var12);
         p_180434_1_.func_178985_a((double)(var15 + p_180434_4_ * var14 + p_180434_7_ * var14), (double)(var16 + p_180434_5_ * var14), (double)(var17 + p_180434_6_ * var14 + p_180434_8_ * var14), (double)var10, (double)var12);
         p_180434_1_.func_178985_a((double)(var15 + p_180434_4_ * var14 - p_180434_7_ * var14), (double)(var16 - p_180434_5_ * var14), (double)(var17 + p_180434_6_ * var14 - p_180434_8_ * var14), (double)var10, (double)var13);
         Tessellator.func_178181_a().func_78381_a();
         GlStateManager.func_179136_a(0.0F, 0.0F);
         GlStateManager.func_179145_e();
      }
   }

   public int func_70070_b(float p_70070_1_) {
      return '\uf0f0';
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      ++this.field_70581_a;
      if(this.field_70581_a == this.field_70584_aq) {
         this.func_70106_y();
      }

   }

   public int func_70537_b() {
      return 3;
   }


   public static class Factory implements IParticleFactory {

      private static final String __OBFID = "CL_00002598";


      public EntityFX func_178902_a(int p_178902_1_, World p_178902_2_, double p_178902_3_, double p_178902_5_, double p_178902_7_, double p_178902_9_, double p_178902_11_, double p_178902_13_, int ... p_178902_15_) {
         return new EntityLargeExplodeFX(Minecraft.func_71410_x().func_110434_K(), p_178902_2_, p_178902_3_, p_178902_5_, p_178902_7_, p_178902_9_, p_178902_11_, p_178902_13_);
      }
   }
}
