package net.minecraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.util.MathHelper;

public class ModelWither extends ModelBase {

   private ModelRenderer[] field_82905_a;
   private ModelRenderer[] field_82904_b;
   private static final String __OBFID = "CL_00000867";


   public ModelWither(float p_i46302_1_) {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.field_82905_a = new ModelRenderer[3];
      this.field_82905_a[0] = new ModelRenderer(this, 0, 16);
      this.field_82905_a[0].func_78790_a(-10.0F, 3.9F, -0.5F, 20, 3, 3, p_i46302_1_);
      this.field_82905_a[1] = (new ModelRenderer(this)).func_78787_b(this.field_78090_t, this.field_78089_u);
      this.field_82905_a[1].func_78793_a(-2.0F, 6.9F, -0.5F);
      this.field_82905_a[1].func_78784_a(0, 22).func_78790_a(0.0F, 0.0F, 0.0F, 3, 10, 3, p_i46302_1_);
      this.field_82905_a[1].func_78784_a(24, 22).func_78790_a(-4.0F, 1.5F, 0.5F, 11, 2, 2, p_i46302_1_);
      this.field_82905_a[1].func_78784_a(24, 22).func_78790_a(-4.0F, 4.0F, 0.5F, 11, 2, 2, p_i46302_1_);
      this.field_82905_a[1].func_78784_a(24, 22).func_78790_a(-4.0F, 6.5F, 0.5F, 11, 2, 2, p_i46302_1_);
      this.field_82905_a[2] = new ModelRenderer(this, 12, 22);
      this.field_82905_a[2].func_78790_a(0.0F, 0.0F, 0.0F, 3, 6, 3, p_i46302_1_);
      this.field_82904_b = new ModelRenderer[3];
      this.field_82904_b[0] = new ModelRenderer(this, 0, 0);
      this.field_82904_b[0].func_78790_a(-4.0F, -4.0F, -4.0F, 8, 8, 8, p_i46302_1_);
      this.field_82904_b[1] = new ModelRenderer(this, 32, 0);
      this.field_82904_b[1].func_78790_a(-4.0F, -4.0F, -4.0F, 6, 6, 6, p_i46302_1_);
      this.field_82904_b[1].field_78800_c = -8.0F;
      this.field_82904_b[1].field_78797_d = 4.0F;
      this.field_82904_b[2] = new ModelRenderer(this, 32, 0);
      this.field_82904_b[2].func_78790_a(-4.0F, -4.0F, -4.0F, 6, 6, 6, p_i46302_1_);
      this.field_82904_b[2].field_78800_c = 10.0F;
      this.field_82904_b[2].field_78797_d = 4.0F;
   }

   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
      this.func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
      ModelRenderer[] var8 = this.field_82904_b;
      int var9 = var8.length;

      int var10;
      ModelRenderer var11;
      for(var10 = 0; var10 < var9; ++var10) {
         var11 = var8[var10];
         var11.func_78785_a(p_78088_7_);
      }

      var8 = this.field_82905_a;
      var9 = var8.length;

      for(var10 = 0; var10 < var9; ++var10) {
         var11 = var8[var10];
         var11.func_78785_a(p_78088_7_);
      }

   }

   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
      float var8 = MathHelper.func_76134_b(p_78087_3_ * 0.1F);
      this.field_82905_a[1].field_78795_f = (0.065F + 0.05F * var8) * 3.1415927F;
      this.field_82905_a[2].func_78793_a(-2.0F, 6.9F + MathHelper.func_76134_b(this.field_82905_a[1].field_78795_f) * 10.0F, -0.5F + MathHelper.func_76126_a(this.field_82905_a[1].field_78795_f) * 10.0F);
      this.field_82905_a[2].field_78795_f = (0.265F + 0.1F * var8) * 3.1415927F;
      this.field_82904_b[0].field_78796_g = p_78087_4_ / 57.295776F;
      this.field_82904_b[0].field_78795_f = p_78087_5_ / 57.295776F;
   }

   public void func_78086_a(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
      EntityWither var5 = (EntityWither)p_78086_1_;

      for(int var6 = 1; var6 < 3; ++var6) {
         this.field_82904_b[var6].field_78796_g = (var5.func_82207_a(var6 - 1) - p_78086_1_.field_70761_aq) / 57.295776F;
         this.field_82904_b[var6].field_78795_f = var5.func_82210_r(var6 - 1) / 57.295776F;
      }

   }
}
