package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.ResourceLocation;

public class LayerSaddle implements LayerRenderer {

   private static final ResourceLocation field_177158_a = new ResourceLocation("textures/entity/pig/pig_saddle.png");
   private final RenderPig field_177156_b;
   private final ModelPig field_177157_c = new ModelPig(0.5F);
   private static final String __OBFID = "CL_00002414";


   public LayerSaddle(RenderPig p_i46113_1_) {
      this.field_177156_b = p_i46113_1_;
   }

   public void func_177155_a(EntityPig p_177155_1_, float p_177155_2_, float p_177155_3_, float p_177155_4_, float p_177155_5_, float p_177155_6_, float p_177155_7_, float p_177155_8_) {
      if(p_177155_1_.func_70901_n()) {
         this.field_177156_b.func_110776_a(field_177158_a);
         this.field_177157_c.func_178686_a(this.field_177156_b.func_177087_b());
         this.field_177157_c.func_78088_a(p_177155_1_, p_177155_2_, p_177155_3_, p_177155_5_, p_177155_6_, p_177155_7_, p_177155_8_);
      }
   }

   public boolean func_177142_b() {
      return false;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_177141_a(EntityLivingBase p_177141_1_, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
      this.func_177155_a((EntityPig)p_177141_1_, p_177141_2_, p_177141_3_, p_177141_4_, p_177141_5_, p_177141_6_, p_177141_7_, p_177141_8_);
   }

}
