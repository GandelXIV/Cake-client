package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.util.ResourceLocation;

public class TileEntityEnderChestRenderer extends TileEntitySpecialRenderer {

   private static final ResourceLocation field_147520_b = new ResourceLocation("textures/entity/chest/ender.png");
   private ModelChest field_147521_c = new ModelChest();
   private static final String __OBFID = "CL_00000967";


   public void func_180540_a(TileEntityEnderChest p_180540_1_, double p_180540_2_, double p_180540_4_, double p_180540_6_, float p_180540_8_, int p_180540_9_) {
      int var10 = 0;
      if(p_180540_1_.func_145830_o()) {
         var10 = p_180540_1_.func_145832_p();
      }

      if(p_180540_9_ >= 0) {
         this.func_147499_a(field_178460_a[p_180540_9_]);
         GlStateManager.func_179128_n(5890);
         GlStateManager.func_179094_E();
         GlStateManager.func_179152_a(4.0F, 4.0F, 1.0F);
         GlStateManager.func_179109_b(0.0625F, 0.0625F, 0.0625F);
         GlStateManager.func_179128_n(5888);
      } else {
         this.func_147499_a(field_147520_b);
      }

      GlStateManager.func_179094_E();
      GlStateManager.func_179091_B();
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.func_179109_b((float)p_180540_2_, (float)p_180540_4_ + 1.0F, (float)p_180540_6_ + 1.0F);
      GlStateManager.func_179152_a(1.0F, -1.0F, -1.0F);
      GlStateManager.func_179109_b(0.5F, 0.5F, 0.5F);
      short var11 = 0;
      if(var10 == 2) {
         var11 = 180;
      }

      if(var10 == 3) {
         var11 = 0;
      }

      if(var10 == 4) {
         var11 = 90;
      }

      if(var10 == 5) {
         var11 = -90;
      }

      GlStateManager.func_179114_b((float)var11, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179109_b(-0.5F, -0.5F, -0.5F);
      float var12 = p_180540_1_.field_145975_i + (p_180540_1_.field_145972_a - p_180540_1_.field_145975_i) * p_180540_8_;
      var12 = 1.0F - var12;
      var12 = 1.0F - var12 * var12 * var12;
      this.field_147521_c.field_78234_a.field_78795_f = -(var12 * 3.1415927F / 2.0F);
      this.field_147521_c.func_78231_a();
      GlStateManager.func_179101_C();
      GlStateManager.func_179121_F();
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      if(p_180540_9_ >= 0) {
         GlStateManager.func_179128_n(5890);
         GlStateManager.func_179121_F();
         GlStateManager.func_179128_n(5888);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_180535_a(TileEntity p_180535_1_, double p_180535_2_, double p_180535_4_, double p_180535_6_, float p_180535_8_, int p_180535_9_) {
      this.func_180540_a((TileEntityEnderChest)p_180535_1_, p_180535_2_, p_180535_4_, p_180535_6_, p_180535_8_, p_180535_9_);
   }

}
