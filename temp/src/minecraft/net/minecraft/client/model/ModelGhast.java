package net.minecraft.client.model;

import java.util.Random;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGhast extends ModelBase {

   ModelRenderer field_78128_a;
   ModelRenderer[] field_78127_b = new ModelRenderer[9];
   private static final String __OBFID = "CL_00000839";


   public ModelGhast() {
      byte var1 = -16;
      this.field_78128_a = new ModelRenderer(this, 0, 0);
      this.field_78128_a.func_78789_a(-8.0F, -8.0F, -8.0F, 16, 16, 16);
      this.field_78128_a.field_78797_d += (float)(24 + var1);
      Random var2 = new Random(1660L);

      for(int var3 = 0; var3 < this.field_78127_b.length; ++var3) {
         this.field_78127_b[var3] = new ModelRenderer(this, 0, 0);
         float var4 = (((float)(var3 % 3) - (float)(var3 / 3 % 2) * 0.5F + 0.25F) / 2.0F * 2.0F - 1.0F) * 5.0F;
         float var5 = ((float)(var3 / 3) / 2.0F * 2.0F - 1.0F) * 5.0F;
         int var6 = var2.nextInt(7) + 8;
         this.field_78127_b[var3].func_78789_a(-1.0F, 0.0F, -1.0F, 2, var6, 2);
         this.field_78127_b[var3].field_78800_c = var4;
         this.field_78127_b[var3].field_78798_e = var5;
         this.field_78127_b[var3].field_78797_d = (float)(31 + var1);
      }

   }

   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
      for(int var8 = 0; var8 < this.field_78127_b.length; ++var8) {
         this.field_78127_b[var8].field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.3F + (float)var8) + 0.4F;
      }

   }

   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
      this.func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
      GlStateManager.func_179094_E();
      GlStateManager.func_179109_b(0.0F, 0.6F, 0.0F);
      this.field_78128_a.func_78785_a(p_78088_7_);
      ModelRenderer[] var8 = this.field_78127_b;
      int var9 = var8.length;

      for(int var10 = 0; var10 < var9; ++var10) {
         ModelRenderer var11 = var8[var10];
         var11.func_78785_a(p_78088_7_);
      }

      GlStateManager.func_179121_F();
   }
}
