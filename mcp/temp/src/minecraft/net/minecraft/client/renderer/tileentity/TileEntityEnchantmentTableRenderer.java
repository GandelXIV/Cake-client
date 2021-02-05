package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class TileEntityEnchantmentTableRenderer extends TileEntitySpecialRenderer {

   private static final ResourceLocation field_147540_b = new ResourceLocation("textures/entity/enchanting_table_book.png");
   private ModelBook field_147541_c = new ModelBook();
   private static final String __OBFID = "CL_00002470";


   public void func_180537_a(TileEntityEnchantmentTable p_180537_1_, double p_180537_2_, double p_180537_4_, double p_180537_6_, float p_180537_8_, int p_180537_9_) {
      GlStateManager.func_179094_E();
      GlStateManager.func_179109_b((float)p_180537_2_ + 0.5F, (float)p_180537_4_ + 0.75F, (float)p_180537_6_ + 0.5F);
      float var10 = (float)p_180537_1_.field_145926_a + p_180537_8_;
      GlStateManager.func_179109_b(0.0F, 0.1F + MathHelper.func_76126_a(var10 * 0.1F) * 0.01F, 0.0F);

      float var11;
      for(var11 = p_180537_1_.field_145928_o - p_180537_1_.field_145925_p; var11 >= 3.1415927F; var11 -= 6.2831855F) {
         ;
      }

      while(var11 < -3.1415927F) {
         var11 += 6.2831855F;
      }

      float var12 = p_180537_1_.field_145925_p + var11 * p_180537_8_;
      GlStateManager.func_179114_b(-var12 * 180.0F / 3.1415927F, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b(80.0F, 0.0F, 0.0F, 1.0F);
      this.func_147499_a(field_147540_b);
      float var13 = p_180537_1_.field_145931_j + (p_180537_1_.field_145933_i - p_180537_1_.field_145931_j) * p_180537_8_ + 0.25F;
      float var14 = p_180537_1_.field_145931_j + (p_180537_1_.field_145933_i - p_180537_1_.field_145931_j) * p_180537_8_ + 0.75F;
      var13 = (var13 - (float)MathHelper.func_76140_b((double)var13)) * 1.6F - 0.3F;
      var14 = (var14 - (float)MathHelper.func_76140_b((double)var14)) * 1.6F - 0.3F;
      if(var13 < 0.0F) {
         var13 = 0.0F;
      }

      if(var14 < 0.0F) {
         var14 = 0.0F;
      }

      if(var13 > 1.0F) {
         var13 = 1.0F;
      }

      if(var14 > 1.0F) {
         var14 = 1.0F;
      }

      float var15 = p_180537_1_.field_145927_n + (p_180537_1_.field_145930_m - p_180537_1_.field_145927_n) * p_180537_8_;
      GlStateManager.func_179089_o();
      this.field_147541_c.func_78088_a((Entity)null, var10, var13, var14, var15, 0.0F, 0.0625F);
      GlStateManager.func_179121_F();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_180535_a(TileEntity p_180535_1_, double p_180535_2_, double p_180535_4_, double p_180535_6_, float p_180535_8_, int p_180535_9_) {
      this.func_180537_a((TileEntityEnchantmentTable)p_180535_1_, p_180535_2_, p_180535_4_, p_180535_6_, p_180535_8_, p_180535_9_);
   }

}
