package net.minecraft.client.renderer.tileentity;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiUtilRenderComponents;
import net.minecraft.client.model.ModelSign;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileEntitySignRenderer extends TileEntitySpecialRenderer {

   private static final ResourceLocation field_147513_b = new ResourceLocation("textures/entity/sign.png");
   private final ModelSign field_147514_c = new ModelSign();
   private static final String __OBFID = "CL_00000970";


   public void func_180541_a(TileEntitySign p_180541_1_, double p_180541_2_, double p_180541_4_, double p_180541_6_, float p_180541_8_, int p_180541_9_) {
      Block var10 = p_180541_1_.func_145838_q();
      GlStateManager.func_179094_E();
      float var11 = 0.6666667F;
      float var13;
      if(var10 == Blocks.field_150472_an) {
         GlStateManager.func_179109_b((float)p_180541_2_ + 0.5F, (float)p_180541_4_ + 0.75F * var11, (float)p_180541_6_ + 0.5F);
         float var12 = (float)(p_180541_1_.func_145832_p() * 360) / 16.0F;
         GlStateManager.func_179114_b(-var12, 0.0F, 1.0F, 0.0F);
         this.field_147514_c.field_78165_b.field_78806_j = true;
      } else {
         int var19 = p_180541_1_.func_145832_p();
         var13 = 0.0F;
         if(var19 == 2) {
            var13 = 180.0F;
         }

         if(var19 == 4) {
            var13 = 90.0F;
         }

         if(var19 == 5) {
            var13 = -90.0F;
         }

         GlStateManager.func_179109_b((float)p_180541_2_ + 0.5F, (float)p_180541_4_ + 0.75F * var11, (float)p_180541_6_ + 0.5F);
         GlStateManager.func_179114_b(-var13, 0.0F, 1.0F, 0.0F);
         GlStateManager.func_179109_b(0.0F, -0.3125F, -0.4375F);
         this.field_147514_c.field_78165_b.field_78806_j = false;
      }

      if(p_180541_9_ >= 0) {
         this.func_147499_a(field_178460_a[p_180541_9_]);
         GlStateManager.func_179128_n(5890);
         GlStateManager.func_179094_E();
         GlStateManager.func_179152_a(4.0F, 2.0F, 1.0F);
         GlStateManager.func_179109_b(0.0625F, 0.0625F, 0.0625F);
         GlStateManager.func_179128_n(5888);
      } else {
         this.func_147499_a(field_147513_b);
      }

      GlStateManager.func_179091_B();
      GlStateManager.func_179094_E();
      GlStateManager.func_179152_a(var11, -var11, -var11);
      this.field_147514_c.func_78164_a();
      GlStateManager.func_179121_F();
      FontRenderer var20 = this.func_147498_b();
      var13 = 0.015625F * var11;
      GlStateManager.func_179109_b(0.0F, 0.5F * var11, 0.07F * var11);
      GlStateManager.func_179152_a(var13, -var13, var13);
      GL11.glNormal3f(0.0F, 0.0F, -1.0F * var13);
      GlStateManager.func_179132_a(false);
      byte var14 = 0;
      if(p_180541_9_ < 0) {
         for(int var15 = 0; var15 < p_180541_1_.field_145915_a.length; ++var15) {
            if(p_180541_1_.field_145915_a[var15] != null) {
               IChatComponent var16 = p_180541_1_.field_145915_a[var15];
               List var17 = GuiUtilRenderComponents.func_178908_a(var16, 90, var20, false, true);
               String var18 = var17 != null && var17.size() > 0?((IChatComponent)var17.get(0)).func_150254_d():"";
               if(var15 == p_180541_1_.field_145918_i) {
                  var18 = "> " + var18 + " <";
                  var20.func_78276_b(var18, -var20.func_78256_a(var18) / 2, var15 * 10 - p_180541_1_.field_145915_a.length * 5, var14);
               } else {
                  var20.func_78276_b(var18, -var20.func_78256_a(var18) / 2, var15 * 10 - p_180541_1_.field_145915_a.length * 5, var14);
               }
            }
         }
      }

      GlStateManager.func_179132_a(true);
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.func_179121_F();
      if(p_180541_9_ >= 0) {
         GlStateManager.func_179128_n(5890);
         GlStateManager.func_179121_F();
         GlStateManager.func_179128_n(5888);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_180535_a(TileEntity p_180535_1_, double p_180535_2_, double p_180535_4_, double p_180535_6_, float p_180535_8_, int p_180535_9_) {
      this.func_180541_a((TileEntitySign)p_180535_1_, p_180535_2_, p_180535_4_, p_180535_6_, p_180535_8_, p_180535_9_);
   }

}
