package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBlaze extends ModelBase {

   private ModelRenderer[] field_78106_a = new ModelRenderer[12];
   private ModelRenderer field_78105_b;
   private static final String __OBFID = "CL_00000831";


   public ModelBlaze() {
      for(int var1 = 0; var1 < this.field_78106_a.length; ++var1) {
         this.field_78106_a[var1] = new ModelRenderer(this, 0, 16);
         this.field_78106_a[var1].func_78789_a(0.0F, 0.0F, 0.0F, 2, 8, 2);
      }

      this.field_78105_b = new ModelRenderer(this, 0, 0);
      this.field_78105_b.func_78789_a(-4.0F, -4.0F, -4.0F, 8, 8, 8);
   }

   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
      this.func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
      this.field_78105_b.func_78785_a(p_78088_7_);

      for(int var8 = 0; var8 < this.field_78106_a.length; ++var8) {
         this.field_78106_a[var8].func_78785_a(p_78088_7_);
      }

   }

   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
      float var8 = p_78087_3_ * 3.1415927F * -0.1F;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         this.field_78106_a[var9].field_78797_d = -2.0F + MathHelper.func_76134_b(((float)(var9 * 2) + p_78087_3_) * 0.25F);
         this.field_78106_a[var9].field_78800_c = MathHelper.func_76134_b(var8) * 9.0F;
         this.field_78106_a[var9].field_78798_e = MathHelper.func_76126_a(var8) * 9.0F;
         ++var8;
      }

      var8 = 0.7853982F + p_78087_3_ * 3.1415927F * 0.03F;

      for(var9 = 4; var9 < 8; ++var9) {
         this.field_78106_a[var9].field_78797_d = 2.0F + MathHelper.func_76134_b(((float)(var9 * 2) + p_78087_3_) * 0.25F);
         this.field_78106_a[var9].field_78800_c = MathHelper.func_76134_b(var8) * 7.0F;
         this.field_78106_a[var9].field_78798_e = MathHelper.func_76126_a(var8) * 7.0F;
         ++var8;
      }

      var8 = 0.47123894F + p_78087_3_ * 3.1415927F * -0.05F;

      for(var9 = 8; var9 < 12; ++var9) {
         this.field_78106_a[var9].field_78797_d = 11.0F + MathHelper.func_76134_b(((float)var9 * 1.5F + p_78087_3_) * 0.5F);
         this.field_78106_a[var9].field_78800_c = MathHelper.func_76134_b(var8) * 5.0F;
         this.field_78106_a[var9].field_78798_e = MathHelper.func_76126_a(var8) * 5.0F;
         ++var8;
      }

      this.field_78105_b.field_78796_g = p_78087_4_ / 57.295776F;
      this.field_78105_b.field_78795_f = p_78087_5_ / 57.295776F;
   }
}
