package net.minecraft.client.renderer.entity.layers;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class LayerHeldItem implements LayerRenderer {

   private final RendererLivingEntity field_177206_a;
   private static final String __OBFID = "CL_00002416";


   public LayerHeldItem(RendererLivingEntity p_i46115_1_) {
      this.field_177206_a = p_i46115_1_;
   }

   public void func_177141_a(EntityLivingBase p_177141_1_, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
      ItemStack var9 = p_177141_1_.func_70694_bm();
      if(var9 != null) {
         GlStateManager.func_179094_E();
         if(this.field_177206_a.func_177087_b().field_78091_s) {
            float var10 = 0.5F;
            GlStateManager.func_179109_b(0.0F, 0.625F, 0.0F);
            GlStateManager.func_179114_b(-20.0F, -1.0F, 0.0F, 0.0F);
            GlStateManager.func_179152_a(var10, var10, var10);
         }

         ((ModelBiped)this.field_177206_a.func_177087_b()).func_178718_a(0.0625F);
         GlStateManager.func_179109_b(-0.0625F, 0.4375F, 0.0625F);
         if(p_177141_1_ instanceof EntityPlayer && ((EntityPlayer)p_177141_1_).field_71104_cf != null) {
            var9 = new ItemStack(Items.field_151112_aM, 0);
         }

         Item var13 = var9.func_77973_b();
         Minecraft var11 = Minecraft.func_71410_x();
         if(var13 instanceof ItemBlock && Block.func_149634_a(var13).func_149645_b() == 2) {
            GlStateManager.func_179109_b(0.0F, 0.1875F, -0.3125F);
            GlStateManager.func_179114_b(20.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.func_179114_b(45.0F, 0.0F, 1.0F, 0.0F);
            float var12 = 0.375F;
            GlStateManager.func_179152_a(-var12, -var12, var12);
         }

         var11.func_175597_ag().func_178099_a(p_177141_1_, var9, ItemCameraTransforms.TransformType.THIRD_PERSON);
         GlStateManager.func_179121_F();
      }
   }

   public boolean func_177142_b() {
      return false;
   }
}
