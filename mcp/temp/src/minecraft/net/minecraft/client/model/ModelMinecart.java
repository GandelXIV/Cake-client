package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMinecart extends ModelBase {

   public ModelRenderer[] field_78154_a = new ModelRenderer[7];
   private static final String __OBFID = "CL_00000844";


   public ModelMinecart() {
      this.field_78154_a[0] = new ModelRenderer(this, 0, 10);
      this.field_78154_a[1] = new ModelRenderer(this, 0, 0);
      this.field_78154_a[2] = new ModelRenderer(this, 0, 0);
      this.field_78154_a[3] = new ModelRenderer(this, 0, 0);
      this.field_78154_a[4] = new ModelRenderer(this, 0, 0);
      this.field_78154_a[5] = new ModelRenderer(this, 44, 10);
      byte var1 = 20;
      byte var2 = 8;
      byte var3 = 16;
      byte var4 = 4;
      this.field_78154_a[0].func_78790_a((float)(-var1 / 2), (float)(-var3 / 2), -1.0F, var1, var3, 2, 0.0F);
      this.field_78154_a[0].func_78793_a(0.0F, (float)var4, 0.0F);
      this.field_78154_a[5].func_78790_a((float)(-var1 / 2 + 1), (float)(-var3 / 2 + 1), -1.0F, var1 - 2, var3 - 2, 1, 0.0F);
      this.field_78154_a[5].func_78793_a(0.0F, (float)var4, 0.0F);
      this.field_78154_a[1].func_78790_a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
      this.field_78154_a[1].func_78793_a((float)(-var1 / 2 + 1), (float)var4, 0.0F);
      this.field_78154_a[2].func_78790_a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
      this.field_78154_a[2].func_78793_a((float)(var1 / 2 - 1), (float)var4, 0.0F);
      this.field_78154_a[3].func_78790_a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
      this.field_78154_a[3].func_78793_a(0.0F, (float)var4, (float)(-var3 / 2 + 1));
      this.field_78154_a[4].func_78790_a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
      this.field_78154_a[4].func_78793_a(0.0F, (float)var4, (float)(var3 / 2 - 1));
      this.field_78154_a[0].field_78795_f = 1.5707964F;
      this.field_78154_a[1].field_78796_g = 4.712389F;
      this.field_78154_a[2].field_78796_g = 1.5707964F;
      this.field_78154_a[3].field_78796_g = 3.1415927F;
      this.field_78154_a[5].field_78795_f = -1.5707964F;
   }

   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
      this.field_78154_a[5].field_78797_d = 4.0F - p_78088_4_;

      for(int var8 = 0; var8 < 6; ++var8) {
         this.field_78154_a[var8].func_78785_a(p_78088_7_);
      }

   }
}
