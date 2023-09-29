package net.minecraft.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityFootStepFX extends EntityFX {

   private static final ResourceLocation field_110126_a = new ResourceLocation("textures/particle/footprint.png");
   private int field_70576_a;
   private int field_70578_aq;
   private TextureManager field_70577_ar;
   private static final String __OBFID = "CL_00000908";


   protected EntityFootStepFX(TextureManager p_i1210_1_, World p_i1210_2_, double p_i1210_3_, double p_i1210_5_, double p_i1210_7_) {
      super(p_i1210_2_, p_i1210_3_, p_i1210_5_, p_i1210_7_, 0.0D, 0.0D, 0.0D);
      this.field_70577_ar = p_i1210_1_;
      this.field_70159_w = this.field_70181_x = this.field_70179_y = 0.0D;
      this.field_70578_aq = 200;
   }

   public void func_180434_a(WorldRenderer p_180434_1_, Entity p_180434_2_, float p_180434_3_, float p_180434_4_, float p_180434_5_, float p_180434_6_, float p_180434_7_, float p_180434_8_) {
      float var9 = ((float)this.field_70576_a + p_180434_3_) / (float)this.field_70578_aq;
      var9 *= var9;
      float var10 = 2.0F - var9 * 2.0F;
      if(var10 > 1.0F) {
         var10 = 1.0F;
      }

      var10 *= 0.2F;
      GlStateManager.func_179140_f();
      float var11 = 0.125F;
      float var12 = (float)(this.field_70165_t - field_70556_an);
      float var13 = (float)(this.field_70163_u - field_70554_ao);
      float var14 = (float)(this.field_70161_v - field_70555_ap);
      float var15 = this.field_70170_p.func_175724_o(new BlockPos(this));
      this.field_70577_ar.func_110577_a(field_110126_a);
      GlStateManager.func_179147_l();
      GlStateManager.func_179112_b(770, 771);
      p_180434_1_.func_178970_b();
      p_180434_1_.func_178960_a(var15, var15, var15, var10);
      p_180434_1_.func_178985_a((double)(var12 - var11), (double)var13, (double)(var14 + var11), 0.0D, 1.0D);
      p_180434_1_.func_178985_a((double)(var12 + var11), (double)var13, (double)(var14 + var11), 1.0D, 1.0D);
      p_180434_1_.func_178985_a((double)(var12 + var11), (double)var13, (double)(var14 - var11), 1.0D, 0.0D);
      p_180434_1_.func_178985_a((double)(var12 - var11), (double)var13, (double)(var14 - var11), 0.0D, 0.0D);
      Tessellator.func_178181_a().func_78381_a();
      GlStateManager.func_179084_k();
      GlStateManager.func_179145_e();
   }

   public void func_70071_h_() {
      ++this.field_70576_a;
      if(this.field_70576_a == this.field_70578_aq) {
         this.func_70106_y();
      }

   }

   public int func_70537_b() {
      return 3;
   }


   public static class Factory implements IParticleFactory {

      private static final String __OBFID = "CL_00002601";


      public EntityFX func_178902_a(int p_178902_1_, World p_178902_2_, double p_178902_3_, double p_178902_5_, double p_178902_7_, double p_178902_9_, double p_178902_11_, double p_178902_13_, int ... p_178902_15_) {
         return new EntityFootStepFX(Minecraft.func_71410_x().func_110434_K(), p_178902_2_, p_178902_3_, p_178902_5_, p_178902_7_);
      }
   }
}
