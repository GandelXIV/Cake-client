package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelGuardian;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public class RenderGuardian extends RenderLiving {

   private static final ResourceLocation field_177114_e = new ResourceLocation("textures/entity/guardian.png");
   private static final ResourceLocation field_177116_j = new ResourceLocation("textures/entity/guardian_elder.png");
   private static final ResourceLocation field_177117_k = new ResourceLocation("textures/entity/guardian_beam.png");
   int field_177115_a;
   private static final String __OBFID = "CL_00002443";


   public RenderGuardian(RenderManager p_i46171_1_) {
      super(p_i46171_1_, new ModelGuardian(), 0.5F);
      this.field_177115_a = ((ModelGuardian)this.field_77045_g).func_178706_a();
   }

   public boolean func_177113_a(EntityGuardian p_177113_1_, ICamera p_177113_2_, double p_177113_3_, double p_177113_5_, double p_177113_7_) {
      if(super.func_177104_a(p_177113_1_, p_177113_2_, p_177113_3_, p_177113_5_, p_177113_7_)) {
         return true;
      } else {
         if(p_177113_1_.func_175474_cn()) {
            EntityLivingBase var9 = p_177113_1_.func_175466_co();
            if(var9 != null) {
               Vec3 var10 = this.func_177110_a(var9, (double)var9.field_70131_O * 0.5D, 1.0F);
               Vec3 var11 = this.func_177110_a(p_177113_1_, (double)p_177113_1_.func_70047_e(), 1.0F);
               if(p_177113_2_.func_78546_a(AxisAlignedBB.func_178781_a(var11.field_72450_a, var11.field_72448_b, var11.field_72449_c, var10.field_72450_a, var10.field_72448_b, var10.field_72449_c))) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   private Vec3 func_177110_a(EntityLivingBase p_177110_1_, double p_177110_2_, float p_177110_4_) {
      double var5 = p_177110_1_.field_70142_S + (p_177110_1_.field_70165_t - p_177110_1_.field_70142_S) * (double)p_177110_4_;
      double var7 = p_177110_2_ + p_177110_1_.field_70137_T + (p_177110_1_.field_70163_u - p_177110_1_.field_70137_T) * (double)p_177110_4_;
      double var9 = p_177110_1_.field_70136_U + (p_177110_1_.field_70161_v - p_177110_1_.field_70136_U) * (double)p_177110_4_;
      return new Vec3(var5, var7, var9);
   }

   public void func_177109_a(EntityGuardian p_177109_1_, double p_177109_2_, double p_177109_4_, double p_177109_6_, float p_177109_8_, float p_177109_9_) {
      if(this.field_177115_a != ((ModelGuardian)this.field_77045_g).func_178706_a()) {
         this.field_77045_g = new ModelGuardian();
         this.field_177115_a = ((ModelGuardian)this.field_77045_g).func_178706_a();
      }

      super.func_76986_a((EntityLiving)p_177109_1_, p_177109_2_, p_177109_4_, p_177109_6_, p_177109_8_, p_177109_9_);
      EntityLivingBase var10 = p_177109_1_.func_175466_co();
      if(var10 != null) {
         float var11 = p_177109_1_.func_175477_p(p_177109_9_);
         Tessellator var12 = Tessellator.func_178181_a();
         WorldRenderer var13 = var12.func_178180_c();
         this.func_110776_a(field_177117_k);
         GL11.glTexParameterf(3553, 10242, 10497.0F);
         GL11.glTexParameterf(3553, 10243, 10497.0F);
         GlStateManager.func_179140_f();
         GlStateManager.func_179129_p();
         GlStateManager.func_179084_k();
         GlStateManager.func_179132_a(true);
         float var14 = 240.0F;
         OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, var14, var14);
         GlStateManager.func_179120_a(770, 1, 1, 0);
         float var15 = (float)p_177109_1_.field_70170_p.func_82737_E() + p_177109_9_;
         float var16 = var15 * 0.5F % 1.0F;
         float var17 = p_177109_1_.func_70047_e();
         GlStateManager.func_179094_E();
         GlStateManager.func_179109_b((float)p_177109_2_, (float)p_177109_4_ + var17, (float)p_177109_6_);
         Vec3 var18 = this.func_177110_a(var10, (double)var10.field_70131_O * 0.5D, p_177109_9_);
         Vec3 var19 = this.func_177110_a(p_177109_1_, (double)var17, p_177109_9_);
         Vec3 var20 = var18.func_178788_d(var19);
         double var21 = var20.func_72433_c() + 1.0D;
         var20 = var20.func_72432_b();
         float var23 = (float)Math.acos(var20.field_72448_b);
         float var24 = (float)Math.atan2(var20.field_72449_c, var20.field_72450_a);
         GlStateManager.func_179114_b((1.5707964F + -var24) * 57.295776F, 0.0F, 1.0F, 0.0F);
         GlStateManager.func_179114_b(var23 * 57.295776F, 1.0F, 0.0F, 0.0F);
         byte var25 = 1;
         double var26 = (double)var15 * 0.05D * (1.0D - (double)(var25 & 1) * 2.5D);
         var13.func_178970_b();
         float var28 = var11 * var11;
         var13.func_178961_b(64 + (int)(var28 * 240.0F), 32 + (int)(var28 * 192.0F), 128 - (int)(var28 * 64.0F), 255);
         double var29 = (double)var25 * 0.2D;
         double var31 = var29 * 1.41D;
         double var33 = 0.0D + Math.cos(var26 + 2.356194490192345D) * var31;
         double var35 = 0.0D + Math.sin(var26 + 2.356194490192345D) * var31;
         double var37 = 0.0D + Math.cos(var26 + 0.7853981633974483D) * var31;
         double var39 = 0.0D + Math.sin(var26 + 0.7853981633974483D) * var31;
         double var41 = 0.0D + Math.cos(var26 + 3.9269908169872414D) * var31;
         double var43 = 0.0D + Math.sin(var26 + 3.9269908169872414D) * var31;
         double var45 = 0.0D + Math.cos(var26 + 5.497787143782138D) * var31;
         double var47 = 0.0D + Math.sin(var26 + 5.497787143782138D) * var31;
         double var49 = 0.0D + Math.cos(var26 + 3.141592653589793D) * var29;
         double var51 = 0.0D + Math.sin(var26 + 3.141592653589793D) * var29;
         double var53 = 0.0D + Math.cos(var26 + 0.0D) * var29;
         double var55 = 0.0D + Math.sin(var26 + 0.0D) * var29;
         double var57 = 0.0D + Math.cos(var26 + 1.5707963267948966D) * var29;
         double var59 = 0.0D + Math.sin(var26 + 1.5707963267948966D) * var29;
         double var61 = 0.0D + Math.cos(var26 + 4.71238898038469D) * var29;
         double var63 = 0.0D + Math.sin(var26 + 4.71238898038469D) * var29;
         double var67 = 0.0D;
         double var69 = 0.4999D;
         double var71 = (double)(-1.0F + var16);
         double var73 = var21 * (0.5D / var29) + var71;
         var13.func_178985_a(var49, var21, var51, var69, var73);
         var13.func_178985_a(var49, 0.0D, var51, var69, var71);
         var13.func_178985_a(var53, 0.0D, var55, var67, var71);
         var13.func_178985_a(var53, var21, var55, var67, var73);
         var13.func_178985_a(var57, var21, var59, var69, var73);
         var13.func_178985_a(var57, 0.0D, var59, var69, var71);
         var13.func_178985_a(var61, 0.0D, var63, var67, var71);
         var13.func_178985_a(var61, var21, var63, var67, var73);
         double var75 = 0.0D;
         if(p_177109_1_.field_70173_aa % 2 == 0) {
            var75 = 0.5D;
         }

         var13.func_178985_a(var33, var21, var35, 0.5D, var75 + 0.5D);
         var13.func_178985_a(var37, var21, var39, 1.0D, var75 + 0.5D);
         var13.func_178985_a(var45, var21, var47, 1.0D, var75);
         var13.func_178985_a(var41, var21, var43, 0.5D, var75);
         var12.func_78381_a();
         GlStateManager.func_179121_F();
      }

   }

   protected void func_177112_a(EntityGuardian p_177112_1_, float p_177112_2_) {
      if(p_177112_1_.func_175461_cl()) {
         GlStateManager.func_179152_a(2.35F, 2.35F, 2.35F);
      }

   }

   protected ResourceLocation func_177111_a(EntityGuardian p_177111_1_) {
      return p_177111_1_.func_175461_cl()?field_177116_j:field_177114_e;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_177109_a((EntityGuardian)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean func_177104_a(EntityLiving p_177104_1_, ICamera p_177104_2_, double p_177104_3_, double p_177104_5_, double p_177104_7_) {
      return this.func_177113_a((EntityGuardian)p_177104_1_, p_177104_2_, p_177104_3_, p_177104_5_, p_177104_7_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
      this.func_177112_a((EntityGuardian)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_177109_a((EntityGuardian)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_177111_a((EntityGuardian)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_177109_a((EntityGuardian)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean func_177071_a(Entity p_177071_1_, ICamera p_177071_2_, double p_177071_3_, double p_177071_5_, double p_177071_7_) {
      return this.func_177113_a((EntityGuardian)p_177071_1_, p_177071_2_, p_177071_3_, p_177071_5_, p_177071_7_);
   }

}
