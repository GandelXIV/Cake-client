package net.minecraft.client.renderer.entity.layers;

import java.util.Random;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.MathHelper;

public class LayerArrow implements LayerRenderer {

   private final RendererLivingEntity field_177168_a;
   private static final String __OBFID = "CL_00002426";


   public LayerArrow(RendererLivingEntity p_i46124_1_) {
      this.field_177168_a = p_i46124_1_;
   }

   public void func_177141_a(EntityLivingBase p_177141_1_, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
      int var9 = p_177141_1_.func_85035_bI();
      if(var9 > 0) {
         EntityArrow var10 = new EntityArrow(p_177141_1_.field_70170_p, p_177141_1_.field_70165_t, p_177141_1_.field_70163_u, p_177141_1_.field_70161_v);
         Random var11 = new Random((long)p_177141_1_.func_145782_y());
         RenderHelper.func_74518_a();

         for(int var12 = 0; var12 < var9; ++var12) {
            GlStateManager.func_179094_E();
            ModelRenderer var13 = this.field_177168_a.func_177087_b().func_85181_a(var11);
            ModelBox var14 = (ModelBox)var13.field_78804_l.get(var11.nextInt(var13.field_78804_l.size()));
            var13.func_78794_c(0.0625F);
            float var15 = var11.nextFloat();
            float var16 = var11.nextFloat();
            float var17 = var11.nextFloat();
            float var18 = (var14.field_78252_a + (var14.field_78248_d - var14.field_78252_a) * var15) / 16.0F;
            float var19 = (var14.field_78250_b + (var14.field_78249_e - var14.field_78250_b) * var16) / 16.0F;
            float var20 = (var14.field_78251_c + (var14.field_78246_f - var14.field_78251_c) * var17) / 16.0F;
            GlStateManager.func_179109_b(var18, var19, var20);
            var15 = var15 * 2.0F - 1.0F;
            var16 = var16 * 2.0F - 1.0F;
            var17 = var17 * 2.0F - 1.0F;
            var15 *= -1.0F;
            var16 *= -1.0F;
            var17 *= -1.0F;
            float var21 = MathHelper.func_76129_c(var15 * var15 + var17 * var17);
            var10.field_70126_B = var10.field_70177_z = (float)(Math.atan2((double)var15, (double)var17) * 180.0D / 3.1415927410125732D);
            var10.field_70127_C = var10.field_70125_A = (float)(Math.atan2((double)var16, (double)var21) * 180.0D / 3.1415927410125732D);
            double var22 = 0.0D;
            double var24 = 0.0D;
            double var26 = 0.0D;
            this.field_177168_a.func_177068_d().func_147940_a(var10, var22, var24, var26, 0.0F, p_177141_4_);
            GlStateManager.func_179121_F();
         }

         RenderHelper.func_74519_b();
      }
   }

   public boolean func_177142_b() {
      return false;
   }
}
