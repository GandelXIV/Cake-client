package net.minecraft.client.renderer.entity.layers;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelWitch;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderWitch;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class LayerHeldItemWitch implements LayerRenderer {

   private final RenderWitch field_177144_a;
   private static final String __OBFID = "CL_00002407";


   public LayerHeldItemWitch(RenderWitch p_i46106_1_) {
      this.field_177144_a = p_i46106_1_;
   }

   public void func_177143_a(EntityWitch p_177143_1_, float p_177143_2_, float p_177143_3_, float p_177143_4_, float p_177143_5_, float p_177143_6_, float p_177143_7_, float p_177143_8_) {
      ItemStack var9 = p_177143_1_.func_70694_bm();
      if(var9 != null) {
         GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
         GlStateManager.func_179094_E();
         if(this.field_177144_a.func_177087_b().field_78091_s) {
            GlStateManager.func_179109_b(0.0F, 0.625F, 0.0F);
            GlStateManager.func_179114_b(-20.0F, -1.0F, 0.0F, 0.0F);
            float var10 = 0.5F;
            GlStateManager.func_179152_a(var10, var10, var10);
         }

         ((ModelWitch)this.field_177144_a.func_177087_b()).field_82898_f.func_78794_c(0.0625F);
         GlStateManager.func_179109_b(-0.0625F, 0.53125F, 0.21875F);
         Item var13 = var9.func_77973_b();
         Minecraft var11 = Minecraft.func_71410_x();
         float var12;
         if(var13 instanceof ItemBlock && var11.func_175602_ab().func_175021_a(Block.func_149634_a(var13), var9.func_77960_j())) {
            GlStateManager.func_179109_b(0.0F, 0.1875F, -0.3125F);
            GlStateManager.func_179114_b(20.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.func_179114_b(45.0F, 0.0F, 1.0F, 0.0F);
            var12 = 0.375F;
            GlStateManager.func_179152_a(var12, -var12, var12);
         } else if(var13 == Items.field_151031_f) {
            GlStateManager.func_179109_b(0.0F, 0.125F, 0.3125F);
            GlStateManager.func_179114_b(-20.0F, 0.0F, 1.0F, 0.0F);
            var12 = 0.625F;
            GlStateManager.func_179152_a(var12, -var12, var12);
            GlStateManager.func_179114_b(-100.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.func_179114_b(45.0F, 0.0F, 1.0F, 0.0F);
         } else if(var13.func_77662_d()) {
            if(var13.func_77629_n_()) {
               GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
               GlStateManager.func_179109_b(0.0F, -0.125F, 0.0F);
            }

            this.field_177144_a.func_82422_c();
            var12 = 0.625F;
            GlStateManager.func_179152_a(var12, -var12, var12);
            GlStateManager.func_179114_b(-100.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.func_179114_b(45.0F, 0.0F, 1.0F, 0.0F);
         } else {
            GlStateManager.func_179109_b(0.25F, 0.1875F, -0.1875F);
            var12 = 0.375F;
            GlStateManager.func_179152_a(var12, var12, var12);
            GlStateManager.func_179114_b(60.0F, 0.0F, 0.0F, 1.0F);
            GlStateManager.func_179114_b(-90.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.func_179114_b(20.0F, 0.0F, 0.0F, 1.0F);
         }

         GlStateManager.func_179114_b(-15.0F, 1.0F, 0.0F, 0.0F);
         GlStateManager.func_179114_b(40.0F, 0.0F, 0.0F, 1.0F);
         var11.func_175597_ag().func_178099_a(p_177143_1_, var9, ItemCameraTransforms.TransformType.THIRD_PERSON);
         GlStateManager.func_179121_F();
      }
   }

   public boolean func_177142_b() {
      return false;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_177141_a(EntityLivingBase p_177141_1_, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
      this.func_177143_a((EntityWitch)p_177141_1_, p_177141_2_, p_177141_3_, p_177141_4_, p_177141_5_, p_177141_6_, p_177141_7_, p_177141_8_);
   }
}
