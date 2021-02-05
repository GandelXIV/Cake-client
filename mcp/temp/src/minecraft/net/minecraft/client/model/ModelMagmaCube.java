package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMagmaCube;

public class ModelMagmaCube extends ModelBase {

   ModelRenderer[] field_78109_a = new ModelRenderer[8];
   ModelRenderer field_78108_b;
   private static final String __OBFID = "CL_00000842";


   public ModelMagmaCube() {
      for(int var1 = 0; var1 < this.field_78109_a.length; ++var1) {
         byte var2 = 0;
         int var3 = var1;
         if(var1 == 2) {
            var2 = 24;
            var3 = 10;
         } else if(var1 == 3) {
            var2 = 24;
            var3 = 19;
         }

         this.field_78109_a[var1] = new ModelRenderer(this, var2, var3);
         this.field_78109_a[var1].func_78789_a(-4.0F, (float)(16 + var1), -4.0F, 8, 1, 8);
      }

      this.field_78108_b = new ModelRenderer(this, 0, 16);
      this.field_78108_b.func_78789_a(-2.0F, 18.0F, -2.0F, 4, 4, 4);
   }

   public void func_78086_a(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
      EntityMagmaCube var5 = (EntityMagmaCube)p_78086_1_;
      float var6 = var5.field_70812_c + (var5.field_70811_b - var5.field_70812_c) * p_78086_4_;
      if(var6 < 0.0F) {
         var6 = 0.0F;
      }

      for(int var7 = 0; var7 < this.field_78109_a.length; ++var7) {
         this.field_78109_a[var7].field_78797_d = (float)(-(4 - var7)) * var6 * 1.7F;
      }

   }

   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
      this.func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
      this.field_78108_b.func_78785_a(p_78088_7_);

      for(int var8 = 0; var8 < this.field_78109_a.length; ++var8) {
         this.field_78109_a[var8].func_78785_a(p_78088_7_);
      }

   }
}
