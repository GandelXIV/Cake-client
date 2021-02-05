package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.model.ModelSheep1;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;

public class LayerSheepWool implements LayerRenderer {

   private static final ResourceLocation field_177165_a = new ResourceLocation("textures/entity/sheep/sheep_fur.png");
   private final RenderSheep field_177163_b;
   private final ModelSheep1 field_177164_c = new ModelSheep1();
   private static final String __OBFID = "CL_00002413";


   public LayerSheepWool(RenderSheep p_i46112_1_) {
      this.field_177163_b = p_i46112_1_;
   }

   public void func_177162_a(EntitySheep p_177162_1_, float p_177162_2_, float p_177162_3_, float p_177162_4_, float p_177162_5_, float p_177162_6_, float p_177162_7_, float p_177162_8_) {
      if(!p_177162_1_.func_70892_o() && !p_177162_1_.func_82150_aj()) {
         this.field_177163_b.func_110776_a(field_177165_a);
         if(p_177162_1_.func_145818_k_() && "jeb_".equals(p_177162_1_.func_95999_t())) {
            boolean var17 = true;
            int var10 = p_177162_1_.field_70173_aa / 25 + p_177162_1_.func_145782_y();
            int var11 = EnumDyeColor.values().length;
            int var12 = var10 % var11;
            int var13 = (var10 + 1) % var11;
            float var14 = ((float)(p_177162_1_.field_70173_aa % 25) + p_177162_4_) / 25.0F;
            float[] var15 = EntitySheep.func_175513_a(EnumDyeColor.func_176764_b(var12));
            float[] var16 = EntitySheep.func_175513_a(EnumDyeColor.func_176764_b(var13));
            GlStateManager.func_179124_c(var15[0] * (1.0F - var14) + var16[0] * var14, var15[1] * (1.0F - var14) + var16[1] * var14, var15[2] * (1.0F - var14) + var16[2] * var14);
         } else {
            float[] var9 = EntitySheep.func_175513_a(p_177162_1_.func_175509_cj());
            GlStateManager.func_179124_c(var9[0], var9[1], var9[2]);
         }

         this.field_177164_c.func_178686_a(this.field_177163_b.func_177087_b());
         this.field_177164_c.func_78086_a(p_177162_1_, p_177162_2_, p_177162_3_, p_177162_4_);
         this.field_177164_c.func_78088_a(p_177162_1_, p_177162_2_, p_177162_3_, p_177162_5_, p_177162_6_, p_177162_7_, p_177162_8_);
      }
   }

   public boolean func_177142_b() {
      return true;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_177141_a(EntityLivingBase p_177141_1_, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
      this.func_177162_a((EntitySheep)p_177141_1_, p_177141_2_, p_177141_3_, p_177141_4_, p_177141_5_, p_177141_6_, p_177141_7_, p_177141_8_);
   }

}
