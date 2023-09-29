package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;

public class LayerDeadmau5Head implements LayerRenderer {

   private final RenderPlayer field_177208_a;
   private static final String __OBFID = "CL_00002421";


   public LayerDeadmau5Head(RenderPlayer p_i46119_1_) {
      this.field_177208_a = p_i46119_1_;
   }

   public void func_177207_a(AbstractClientPlayer p_177207_1_, float p_177207_2_, float p_177207_3_, float p_177207_4_, float p_177207_5_, float p_177207_6_, float p_177207_7_, float p_177207_8_) {
      if(p_177207_1_.func_70005_c_().equals("deadmau5") && p_177207_1_.func_152123_o() && !p_177207_1_.func_82150_aj()) {
         this.field_177208_a.func_110776_a(p_177207_1_.func_110306_p());

         for(int var9 = 0; var9 < 2; ++var9) {
            float var10 = p_177207_1_.field_70126_B + (p_177207_1_.field_70177_z - p_177207_1_.field_70126_B) * p_177207_4_ - (p_177207_1_.field_70760_ar + (p_177207_1_.field_70761_aq - p_177207_1_.field_70760_ar) * p_177207_4_);
            float var11 = p_177207_1_.field_70127_C + (p_177207_1_.field_70125_A - p_177207_1_.field_70127_C) * p_177207_4_;
            GlStateManager.func_179094_E();
            GlStateManager.func_179114_b(var10, 0.0F, 1.0F, 0.0F);
            GlStateManager.func_179114_b(var11, 1.0F, 0.0F, 0.0F);
            GlStateManager.func_179109_b(0.375F * (float)(var9 * 2 - 1), 0.0F, 0.0F);
            GlStateManager.func_179109_b(0.0F, -0.375F, 0.0F);
            GlStateManager.func_179114_b(-var11, 1.0F, 0.0F, 0.0F);
            GlStateManager.func_179114_b(-var10, 0.0F, 1.0F, 0.0F);
            float var12 = 1.3333334F;
            GlStateManager.func_179152_a(var12, var12, var12);
            this.field_177208_a.func_177136_g().func_178727_b(0.0625F);
            GlStateManager.func_179121_F();
         }

      }
   }

   public boolean func_177142_b() {
      return true;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_177141_a(EntityLivingBase p_177141_1_, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
      this.func_177207_a((AbstractClientPlayer)p_177141_1_, p_177141_2_, p_177141_3_, p_177141_4_, p_177141_5_, p_177141_6_, p_177141_7_, p_177141_8_);
   }
}
