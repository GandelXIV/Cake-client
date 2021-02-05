package net.minecraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFireworkOverlayFX extends EntityFX {

   private static final String __OBFID = "CL_00000904";


   protected EntityFireworkOverlayFX(World p_i46357_1_, double p_i46357_2_, double p_i46357_4_, double p_i46357_6_) {
      super(p_i46357_1_, p_i46357_2_, p_i46357_4_, p_i46357_6_);
      this.field_70547_e = 4;
   }

   public void func_180434_a(WorldRenderer p_180434_1_, Entity p_180434_2_, float p_180434_3_, float p_180434_4_, float p_180434_5_, float p_180434_6_, float p_180434_7_, float p_180434_8_) {
      float var9 = 0.25F;
      float var10 = var9 + 0.25F;
      float var11 = 0.125F;
      float var12 = var11 + 0.25F;
      float var13 = 7.1F * MathHelper.func_76126_a(((float)this.field_70546_d + p_180434_3_ - 1.0F) * 0.25F * 3.1415927F);
      this.field_82339_as = 0.6F - ((float)this.field_70546_d + p_180434_3_ - 1.0F) * 0.25F * 0.5F;
      float var14 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)p_180434_3_ - field_70556_an);
      float var15 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)p_180434_3_ - field_70554_ao);
      float var16 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)p_180434_3_ - field_70555_ap);
      p_180434_1_.func_178960_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, this.field_82339_as);
      p_180434_1_.func_178985_a((double)(var14 - p_180434_4_ * var13 - p_180434_7_ * var13), (double)(var15 - p_180434_5_ * var13), (double)(var16 - p_180434_6_ * var13 - p_180434_8_ * var13), (double)var10, (double)var12);
      p_180434_1_.func_178985_a((double)(var14 - p_180434_4_ * var13 + p_180434_7_ * var13), (double)(var15 + p_180434_5_ * var13), (double)(var16 - p_180434_6_ * var13 + p_180434_8_ * var13), (double)var10, (double)var11);
      p_180434_1_.func_178985_a((double)(var14 + p_180434_4_ * var13 + p_180434_7_ * var13), (double)(var15 + p_180434_5_ * var13), (double)(var16 + p_180434_6_ * var13 + p_180434_8_ * var13), (double)var9, (double)var11);
      p_180434_1_.func_178985_a((double)(var14 + p_180434_4_ * var13 - p_180434_7_ * var13), (double)(var15 - p_180434_5_ * var13), (double)(var16 + p_180434_6_ * var13 - p_180434_8_ * var13), (double)var9, (double)var12);
   }
}
