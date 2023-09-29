package net.minecraft.client.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class ModelGuardian extends ModelBase {

   private ModelRenderer field_178710_a;
   private ModelRenderer field_178708_b;
   private ModelRenderer[] field_178709_c;
   private ModelRenderer[] field_178707_d;
   private static final String __OBFID = "CL_00002628";


   public ModelGuardian() {
      this.field_78090_t = 64;
      this.field_78089_u = 64;
      this.field_178709_c = new ModelRenderer[12];
      this.field_178710_a = new ModelRenderer(this);
      this.field_178710_a.func_78784_a(0, 0).func_78789_a(-6.0F, 10.0F, -8.0F, 12, 12, 16);
      this.field_178710_a.func_78784_a(0, 28).func_78789_a(-8.0F, 10.0F, -6.0F, 2, 12, 12);
      this.field_178710_a.func_78784_a(0, 28).func_178769_a(6.0F, 10.0F, -6.0F, 2, 12, 12, true);
      this.field_178710_a.func_78784_a(16, 40).func_78789_a(-6.0F, 8.0F, -6.0F, 12, 2, 12);
      this.field_178710_a.func_78784_a(16, 40).func_78789_a(-6.0F, 22.0F, -6.0F, 12, 2, 12);

      for(int var1 = 0; var1 < this.field_178709_c.length; ++var1) {
         this.field_178709_c[var1] = new ModelRenderer(this, 0, 0);
         this.field_178709_c[var1].func_78789_a(-1.0F, -4.5F, -1.0F, 2, 9, 2);
         this.field_178710_a.func_78792_a(this.field_178709_c[var1]);
      }

      this.field_178708_b = new ModelRenderer(this, 8, 0);
      this.field_178708_b.func_78789_a(-1.0F, 15.0F, 0.0F, 2, 2, 1);
      this.field_178710_a.func_78792_a(this.field_178708_b);
      this.field_178707_d = new ModelRenderer[3];
      this.field_178707_d[0] = new ModelRenderer(this, 40, 0);
      this.field_178707_d[0].func_78789_a(-2.0F, 14.0F, 7.0F, 4, 4, 8);
      this.field_178707_d[1] = new ModelRenderer(this, 0, 54);
      this.field_178707_d[1].func_78789_a(0.0F, 14.0F, 0.0F, 3, 3, 7);
      this.field_178707_d[2] = new ModelRenderer(this);
      this.field_178707_d[2].func_78784_a(41, 32).func_78789_a(0.0F, 14.0F, 0.0F, 2, 2, 6);
      this.field_178707_d[2].func_78784_a(25, 19).func_78789_a(1.0F, 10.5F, 3.0F, 1, 9, 9);
      this.field_178710_a.func_78792_a(this.field_178707_d[0]);
      this.field_178707_d[0].func_78792_a(this.field_178707_d[1]);
      this.field_178707_d[1].func_78792_a(this.field_178707_d[2]);
   }

   public int func_178706_a() {
      return 54;
   }

   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
      this.func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
      this.field_178710_a.func_78785_a(p_78088_7_);
   }

   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
      EntityGuardian var8 = (EntityGuardian)p_78087_7_;
      float var9 = p_78087_3_ - (float)var8.field_70173_aa;
      this.field_178710_a.field_78796_g = p_78087_4_ / 57.295776F;
      this.field_178710_a.field_78795_f = p_78087_5_ / 57.295776F;
      float[] var10 = new float[]{1.75F, 0.25F, 0.0F, 0.0F, 0.5F, 0.5F, 0.5F, 0.5F, 1.25F, 0.75F, 0.0F, 0.0F};
      float[] var11 = new float[]{0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 1.75F, 1.25F, 0.75F, 0.0F, 0.0F, 0.0F, 0.0F};
      float[] var12 = new float[]{0.0F, 0.0F, 0.25F, 1.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.75F, 1.25F};
      float[] var13 = new float[]{0.0F, 0.0F, 8.0F, -8.0F, -8.0F, 8.0F, 8.0F, -8.0F, 0.0F, 0.0F, 8.0F, -8.0F};
      float[] var14 = new float[]{-8.0F, -8.0F, -8.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, 8.0F};
      float[] var15 = new float[]{8.0F, -8.0F, 0.0F, 0.0F, -8.0F, -8.0F, 8.0F, 8.0F, 8.0F, -8.0F, 0.0F, 0.0F};
      float var16 = (1.0F - var8.func_175469_o(var9)) * 0.55F;

      for(int var17 = 0; var17 < 12; ++var17) {
         this.field_178709_c[var17].field_78795_f = 3.1415927F * var10[var17];
         this.field_178709_c[var17].field_78796_g = 3.1415927F * var11[var17];
         this.field_178709_c[var17].field_78808_h = 3.1415927F * var12[var17];
         this.field_178709_c[var17].field_78800_c = var13[var17] * (1.0F + MathHelper.func_76134_b(p_78087_3_ * 1.5F + (float)var17) * 0.01F - var16);
         this.field_178709_c[var17].field_78797_d = 16.0F + var14[var17] * (1.0F + MathHelper.func_76134_b(p_78087_3_ * 1.5F + (float)var17) * 0.01F - var16);
         this.field_178709_c[var17].field_78798_e = var15[var17] * (1.0F + MathHelper.func_76134_b(p_78087_3_ * 1.5F + (float)var17) * 0.01F - var16);
      }

      this.field_178708_b.field_78798_e = -8.25F;
      Object var26 = Minecraft.func_71410_x().func_175606_aa();
      if(var8.func_175474_cn()) {
         var26 = var8.func_175466_co();
      }

      if(var26 != null) {
         Vec3 var18 = ((Entity)var26).func_174824_e(0.0F);
         Vec3 var19 = p_78087_7_.func_174824_e(0.0F);
         double var20 = var18.field_72448_b - var19.field_72448_b;
         if(var20 > 0.0D) {
            this.field_178708_b.field_78797_d = 0.0F;
         } else {
            this.field_178708_b.field_78797_d = 1.0F;
         }

         Vec3 var22 = p_78087_7_.func_70676_i(0.0F);
         var22 = new Vec3(var22.field_72450_a, 0.0D, var22.field_72449_c);
         Vec3 var23 = (new Vec3(var19.field_72450_a - var18.field_72450_a, 0.0D, var19.field_72449_c - var18.field_72449_c)).func_72432_b().func_178785_b(1.5707964F);
         double var24 = var22.func_72430_b(var23);
         this.field_178708_b.field_78800_c = MathHelper.func_76129_c((float)Math.abs(var24)) * 2.0F * (float)Math.signum(var24);
      }

      this.field_178708_b.field_78806_j = true;
      float var27 = var8.func_175471_a(var9);
      this.field_178707_d[0].field_78796_g = MathHelper.func_76126_a(var27) * 3.1415927F * 0.05F;
      this.field_178707_d[1].field_78796_g = MathHelper.func_76126_a(var27) * 3.1415927F * 0.1F;
      this.field_178707_d[1].field_78800_c = -1.5F;
      this.field_178707_d[1].field_78797_d = 0.5F;
      this.field_178707_d[1].field_78798_e = 14.0F;
      this.field_178707_d[2].field_78796_g = MathHelper.func_76126_a(var27) * 3.1415927F * 0.15F;
      this.field_178707_d[2].field_78800_c = 0.5F;
      this.field_178707_d[2].field_78797_d = 0.5F;
      this.field_178707_d[2].field_78798_e = 6.0F;
   }
}
