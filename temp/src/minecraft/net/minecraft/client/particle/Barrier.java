package net.minecraft.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class Barrier extends EntityFX {

   private static final String __OBFID = "CL_00002615";


   protected Barrier(World p_i46286_1_, double p_i46286_2_, double p_i46286_4_, double p_i46286_6_, Item p_i46286_8_) {
      super(p_i46286_1_, p_i46286_2_, p_i46286_4_, p_i46286_6_, 0.0D, 0.0D, 0.0D);
      this.func_180435_a(Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178082_a(p_i46286_8_));
      this.field_70552_h = this.field_70553_i = this.field_70551_j = 1.0F;
      this.field_70159_w = this.field_70181_x = this.field_70179_y = 0.0D;
      this.field_70545_g = 0.0F;
      this.field_70547_e = 80;
   }

   public int func_70537_b() {
      return 1;
   }

   public void func_180434_a(WorldRenderer p_180434_1_, Entity p_180434_2_, float p_180434_3_, float p_180434_4_, float p_180434_5_, float p_180434_6_, float p_180434_7_, float p_180434_8_) {
      float var9 = this.field_70550_a.func_94209_e();
      float var10 = this.field_70550_a.func_94212_f();
      float var11 = this.field_70550_a.func_94206_g();
      float var12 = this.field_70550_a.func_94210_h();
      float var13 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)p_180434_3_ - field_70556_an);
      float var14 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)p_180434_3_ - field_70554_ao);
      float var15 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)p_180434_3_ - field_70555_ap);
      p_180434_1_.func_178986_b(this.field_70552_h, this.field_70553_i, this.field_70551_j);
      float var16 = 0.5F;
      p_180434_1_.func_178985_a((double)(var13 - p_180434_4_ * var16 - p_180434_7_ * var16), (double)(var14 - p_180434_5_ * var16), (double)(var15 - p_180434_6_ * var16 - p_180434_8_ * var16), (double)var10, (double)var12);
      p_180434_1_.func_178985_a((double)(var13 - p_180434_4_ * var16 + p_180434_7_ * var16), (double)(var14 + p_180434_5_ * var16), (double)(var15 - p_180434_6_ * var16 + p_180434_8_ * var16), (double)var10, (double)var11);
      p_180434_1_.func_178985_a((double)(var13 + p_180434_4_ * var16 + p_180434_7_ * var16), (double)(var14 + p_180434_5_ * var16), (double)(var15 + p_180434_6_ * var16 + p_180434_8_ * var16), (double)var9, (double)var11);
      p_180434_1_.func_178985_a((double)(var13 + p_180434_4_ * var16 - p_180434_7_ * var16), (double)(var14 - p_180434_5_ * var16), (double)(var15 + p_180434_6_ * var16 - p_180434_8_ * var16), (double)var9, (double)var12);
   }

   public static class Factory implements IParticleFactory {

      private static final String __OBFID = "CL_00002614";


      public EntityFX func_178902_a(int p_178902_1_, World p_178902_2_, double p_178902_3_, double p_178902_5_, double p_178902_7_, double p_178902_9_, double p_178902_11_, double p_178902_13_, int ... p_178902_15_) {
         return new Barrier(p_178902_2_, p_178902_3_, p_178902_5_, p_178902_7_, Item.func_150898_a(Blocks.field_180401_cv));
      }
   }
}
