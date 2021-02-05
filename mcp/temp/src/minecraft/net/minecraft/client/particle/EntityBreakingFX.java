package net.minecraft.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityBreakingFX extends EntityFX {

   private static final String __OBFID = "CL_00000897";


   protected EntityBreakingFX(World p_i1195_1_, double p_i1195_2_, double p_i1195_4_, double p_i1195_6_, Item p_i1195_8_) {
      this(p_i1195_1_, p_i1195_2_, p_i1195_4_, p_i1195_6_, p_i1195_8_, 0);
   }

   protected EntityBreakingFX(World p_i1197_1_, double p_i1197_2_, double p_i1197_4_, double p_i1197_6_, double p_i1197_8_, double p_i1197_10_, double p_i1197_12_, Item p_i1197_14_, int p_i1197_15_) {
      this(p_i1197_1_, p_i1197_2_, p_i1197_4_, p_i1197_6_, p_i1197_14_, p_i1197_15_);
      this.field_70159_w *= 0.10000000149011612D;
      this.field_70181_x *= 0.10000000149011612D;
      this.field_70179_y *= 0.10000000149011612D;
      this.field_70159_w += p_i1197_8_;
      this.field_70181_x += p_i1197_10_;
      this.field_70179_y += p_i1197_12_;
   }

   protected EntityBreakingFX(World p_i1196_1_, double p_i1196_2_, double p_i1196_4_, double p_i1196_6_, Item p_i1196_8_, int p_i1196_9_) {
      super(p_i1196_1_, p_i1196_2_, p_i1196_4_, p_i1196_6_, 0.0D, 0.0D, 0.0D);
      this.func_180435_a(Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178087_a(p_i1196_8_, p_i1196_9_));
      this.field_70552_h = this.field_70553_i = this.field_70551_j = 1.0F;
      this.field_70545_g = Blocks.field_150433_aE.field_149763_I;
      this.field_70544_f /= 2.0F;
   }

   public int func_70537_b() {
      return 1;
   }

   public void func_180434_a(WorldRenderer p_180434_1_, Entity p_180434_2_, float p_180434_3_, float p_180434_4_, float p_180434_5_, float p_180434_6_, float p_180434_7_, float p_180434_8_) {
      float var9 = ((float)this.field_94054_b + this.field_70548_b / 4.0F) / 16.0F;
      float var10 = var9 + 0.015609375F;
      float var11 = ((float)this.field_94055_c + this.field_70549_c / 4.0F) / 16.0F;
      float var12 = var11 + 0.015609375F;
      float var13 = 0.1F * this.field_70544_f;
      if(this.field_70550_a != null) {
         var9 = this.field_70550_a.func_94214_a((double)(this.field_70548_b / 4.0F * 16.0F));
         var10 = this.field_70550_a.func_94214_a((double)((this.field_70548_b + 1.0F) / 4.0F * 16.0F));
         var11 = this.field_70550_a.func_94207_b((double)(this.field_70549_c / 4.0F * 16.0F));
         var12 = this.field_70550_a.func_94207_b((double)((this.field_70549_c + 1.0F) / 4.0F * 16.0F));
      }

      float var14 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)p_180434_3_ - field_70556_an);
      float var15 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)p_180434_3_ - field_70554_ao);
      float var16 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)p_180434_3_ - field_70555_ap);
      p_180434_1_.func_178986_b(this.field_70552_h, this.field_70553_i, this.field_70551_j);
      p_180434_1_.func_178985_a((double)(var14 - p_180434_4_ * var13 - p_180434_7_ * var13), (double)(var15 - p_180434_5_ * var13), (double)(var16 - p_180434_6_ * var13 - p_180434_8_ * var13), (double)var9, (double)var12);
      p_180434_1_.func_178985_a((double)(var14 - p_180434_4_ * var13 + p_180434_7_ * var13), (double)(var15 + p_180434_5_ * var13), (double)(var16 - p_180434_6_ * var13 + p_180434_8_ * var13), (double)var9, (double)var11);
      p_180434_1_.func_178985_a((double)(var14 + p_180434_4_ * var13 + p_180434_7_ * var13), (double)(var15 + p_180434_5_ * var13), (double)(var16 + p_180434_6_ * var13 + p_180434_8_ * var13), (double)var10, (double)var11);
      p_180434_1_.func_178985_a((double)(var14 + p_180434_4_ * var13 - p_180434_7_ * var13), (double)(var15 - p_180434_5_ * var13), (double)(var16 + p_180434_6_ * var13 - p_180434_8_ * var13), (double)var10, (double)var12);
   }

   public static class Factory implements IParticleFactory {

      private static final String __OBFID = "CL_00002613";


      public EntityFX func_178902_a(int p_178902_1_, World p_178902_2_, double p_178902_3_, double p_178902_5_, double p_178902_7_, double p_178902_9_, double p_178902_11_, double p_178902_13_, int ... p_178902_15_) {
         int var16 = p_178902_15_.length > 1?p_178902_15_[1]:0;
         return new EntityBreakingFX(p_178902_2_, p_178902_3_, p_178902_5_, p_178902_7_, p_178902_9_, p_178902_11_, p_178902_13_, Item.func_150899_d(p_178902_15_[0]), var16);
      }
   }

   public static class SlimeFactory implements IParticleFactory {

      private static final String __OBFID = "CL_00002612";


      public EntityFX func_178902_a(int p_178902_1_, World p_178902_2_, double p_178902_3_, double p_178902_5_, double p_178902_7_, double p_178902_9_, double p_178902_11_, double p_178902_13_, int ... p_178902_15_) {
         return new EntityBreakingFX(p_178902_2_, p_178902_3_, p_178902_5_, p_178902_7_, Items.field_151123_aH);
      }
   }

   public static class SnowballFactory implements IParticleFactory {

      private static final String __OBFID = "CL_00002611";


      public EntityFX func_178902_a(int p_178902_1_, World p_178902_2_, double p_178902_3_, double p_178902_5_, double p_178902_7_, double p_178902_9_, double p_178902_11_, double p_178902_13_, int ... p_178902_15_) {
         return new EntityBreakingFX(p_178902_2_, p_178902_3_, p_178902_5_, p_178902_7_, Items.field_151126_ay);
      }
   }
}
