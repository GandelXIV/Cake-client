package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderDragon;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.util.ResourceLocation;

public class LayerEnderDragonEyes implements LayerRenderer {

   private static final ResourceLocation field_177212_a = new ResourceLocation("textures/entity/enderdragon/dragon_eyes.png");
   private final RenderDragon field_177211_b;
   private static final String __OBFID = "CL_00002419";


   public LayerEnderDragonEyes(RenderDragon p_i46118_1_) {
      this.field_177211_b = p_i46118_1_;
   }

   public void func_177210_a(EntityDragon p_177210_1_, float p_177210_2_, float p_177210_3_, float p_177210_4_, float p_177210_5_, float p_177210_6_, float p_177210_7_, float p_177210_8_) {
      this.field_177211_b.func_110776_a(field_177212_a);
      GlStateManager.func_179147_l();
      GlStateManager.func_179118_c();
      GlStateManager.func_179112_b(1, 1);
      GlStateManager.func_179140_f();
      GlStateManager.func_179143_c(514);
      char var9 = '\uf0f0';
      int var10 = var9 % 65536;
      int var11 = var9 / 65536;
      OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)var10 / 1.0F, (float)var11 / 1.0F);
      GlStateManager.func_179145_e();
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_177211_b.func_177087_b().func_78088_a(p_177210_1_, p_177210_2_, p_177210_3_, p_177210_5_, p_177210_6_, p_177210_7_, p_177210_8_);
      this.field_177211_b.func_177105_a(p_177210_1_, p_177210_4_);
      GlStateManager.func_179084_k();
      GlStateManager.func_179141_d();
      GlStateManager.func_179143_c(515);
   }

   public boolean func_177142_b() {
      return false;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_177141_a(EntityLivingBase p_177141_1_, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
      this.func_177210_a((EntityDragon)p_177141_1_, p_177141_2_, p_177141_3_, p_177141_4_, p_177141_5_, p_177141_6_, p_177141_7_, p_177141_8_);
   }

}
