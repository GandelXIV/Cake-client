package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelSign extends ModelBase {

   public ModelRenderer field_78166_a = new ModelRenderer(this, 0, 0);
   public ModelRenderer field_78165_b;
   private static final String __OBFID = "CL_00000854";


   public ModelSign() {
      this.field_78166_a.func_78790_a(-12.0F, -14.0F, -1.0F, 24, 12, 2, 0.0F);
      this.field_78165_b = new ModelRenderer(this, 0, 14);
      this.field_78165_b.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 14, 2, 0.0F);
   }

   public void func_78164_a() {
      this.field_78166_a.func_78785_a(0.0625F);
      this.field_78165_b.func_78785_a(0.0625F);
   }
}
