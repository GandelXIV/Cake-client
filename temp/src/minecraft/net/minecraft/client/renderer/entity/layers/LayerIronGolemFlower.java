package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelIronGolem;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderIronGolem;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.init.Blocks;

public class LayerIronGolemFlower implements LayerRenderer {

   private final RenderIronGolem field_177154_a;
   private static final String __OBFID = "CL_00002408";


   public LayerIronGolemFlower(RenderIronGolem p_i46107_1_) {
      this.field_177154_a = p_i46107_1_;
   }

   public void func_177153_a(EntityIronGolem p_177153_1_, float p_177153_2_, float p_177153_3_, float p_177153_4_, float p_177153_5_, float p_177153_6_, float p_177153_7_, float p_177153_8_) {
      if(p_177153_1_.func_70853_p() != 0) {
         BlockRendererDispatcher var9 = Minecraft.func_71410_x().func_175602_ab();
         GlStateManager.func_179091_B();
         GlStateManager.func_179094_E();
         GlStateManager.func_179114_b(5.0F + 180.0F * ((ModelIronGolem)this.field_177154_a.func_177087_b()).field_78177_c.field_78795_f / 3.1415927F, 1.0F, 0.0F, 0.0F);
         GlStateManager.func_179114_b(90.0F, 1.0F, 0.0F, 0.0F);
         GlStateManager.func_179109_b(-0.9375F, -0.625F, -0.9375F);
         float var10 = 0.5F;
         GlStateManager.func_179152_a(var10, -var10, var10);
         int var11 = p_177153_1_.func_70070_b(p_177153_4_);
         int var12 = var11 % 65536;
         int var13 = var11 / 65536;
         OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)var12 / 1.0F, (float)var13 / 1.0F);
         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
         this.field_177154_a.func_110776_a(TextureMap.field_110575_b);
         var9.func_175016_a(Blocks.field_150328_O.func_176223_P(), 1.0F);
         GlStateManager.func_179121_F();
         GlStateManager.func_179101_C();
      }
   }

   public boolean func_177142_b() {
      return false;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_177141_a(EntityLivingBase p_177141_1_, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
      this.func_177153_a((EntityIronGolem)p_177141_1_, p_177141_2_, p_177141_3_, p_177141_4_, p_177141_5_, p_177141_6_, p_177141_7_, p_177141_8_);
   }
}
