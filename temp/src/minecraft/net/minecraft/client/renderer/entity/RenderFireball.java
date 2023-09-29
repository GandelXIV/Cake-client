package net.minecraft.client.renderer.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;

public class RenderFireball extends Render {

   private float field_77002_a;
   private static final String __OBFID = "CL_00000995";


   public RenderFireball(RenderManager p_i46176_1_, float p_i46176_2_) {
      super(p_i46176_1_);
      this.field_77002_a = p_i46176_2_;
   }

   public void func_76986_a(EntityFireball p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      GlStateManager.func_179094_E();
      this.func_180548_c(p_76986_1_);
      GlStateManager.func_179109_b((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
      GlStateManager.func_179091_B();
      float var10 = this.field_77002_a;
      GlStateManager.func_179152_a(var10 / 1.0F, var10 / 1.0F, var10 / 1.0F);
      TextureAtlasSprite var11 = Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178082_a(Items.field_151059_bz);
      Tessellator var12 = Tessellator.func_178181_a();
      WorldRenderer var13 = var12.func_178180_c();
      float var14 = var11.func_94209_e();
      float var15 = var11.func_94212_f();
      float var16 = var11.func_94206_g();
      float var17 = var11.func_94210_h();
      float var18 = 1.0F;
      float var19 = 0.5F;
      float var20 = 0.25F;
      GlStateManager.func_179114_b(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b(-this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
      var13.func_178970_b();
      var13.func_178980_d(0.0F, 1.0F, 0.0F);
      var13.func_178985_a((double)(0.0F - var19), (double)(0.0F - var20), 0.0D, (double)var14, (double)var17);
      var13.func_178985_a((double)(var18 - var19), (double)(0.0F - var20), 0.0D, (double)var15, (double)var17);
      var13.func_178985_a((double)(var18 - var19), (double)(1.0F - var20), 0.0D, (double)var15, (double)var16);
      var13.func_178985_a((double)(0.0F - var19), (double)(1.0F - var20), 0.0D, (double)var14, (double)var16);
      var12.func_78381_a();
      GlStateManager.func_179101_C();
      GlStateManager.func_179121_F();
      super.func_76986_a(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   protected ResourceLocation func_180556_a(EntityFireball p_180556_1_) {
      return TextureMap.field_110575_b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_180556_a((EntityFireball)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityFireball)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
