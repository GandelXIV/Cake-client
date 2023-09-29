package net.minecraft.client.renderer.entity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelMinecart;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;

public class RenderMinecart extends Render {

   private static final ResourceLocation field_110804_g = new ResourceLocation("textures/entity/minecart.png");
   protected ModelBase field_77013_a = new ModelMinecart();
   private static final String __OBFID = "CL_00001013";


   public RenderMinecart(RenderManager p_i46155_1_) {
      super(p_i46155_1_);
      this.field_76989_e = 0.5F;
   }

   public void func_76986_a(EntityMinecart p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      GlStateManager.func_179094_E();
      this.func_180548_c(p_76986_1_);
      long var10 = (long)p_76986_1_.func_145782_y() * 493286711L;
      var10 = var10 * var10 * 4392167121L + var10 * 98761L;
      float var12 = (((float)(var10 >> 16 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
      float var13 = (((float)(var10 >> 20 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
      float var14 = (((float)(var10 >> 24 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
      GlStateManager.func_179109_b(var12, var13, var14);
      double var15 = p_76986_1_.field_70142_S + (p_76986_1_.field_70165_t - p_76986_1_.field_70142_S) * (double)p_76986_9_;
      double var17 = p_76986_1_.field_70137_T + (p_76986_1_.field_70163_u - p_76986_1_.field_70137_T) * (double)p_76986_9_;
      double var19 = p_76986_1_.field_70136_U + (p_76986_1_.field_70161_v - p_76986_1_.field_70136_U) * (double)p_76986_9_;
      double var21 = 0.30000001192092896D;
      Vec3 var23 = p_76986_1_.func_70489_a(var15, var17, var19);
      float var24 = p_76986_1_.field_70127_C + (p_76986_1_.field_70125_A - p_76986_1_.field_70127_C) * p_76986_9_;
      if(var23 != null) {
         Vec3 var25 = p_76986_1_.func_70495_a(var15, var17, var19, var21);
         Vec3 var26 = p_76986_1_.func_70495_a(var15, var17, var19, -var21);
         if(var25 == null) {
            var25 = var23;
         }

         if(var26 == null) {
            var26 = var23;
         }

         p_76986_2_ += var23.field_72450_a - var15;
         p_76986_4_ += (var25.field_72448_b + var26.field_72448_b) / 2.0D - var17;
         p_76986_6_ += var23.field_72449_c - var19;
         Vec3 var27 = var26.func_72441_c(-var25.field_72450_a, -var25.field_72448_b, -var25.field_72449_c);
         if(var27.func_72433_c() != 0.0D) {
            var27 = var27.func_72432_b();
            p_76986_8_ = (float)(Math.atan2(var27.field_72449_c, var27.field_72450_a) * 180.0D / 3.141592653589793D);
            var24 = (float)(Math.atan(var27.field_72448_b) * 73.0D);
         }
      }

      GlStateManager.func_179109_b((float)p_76986_2_, (float)p_76986_4_ + 0.375F, (float)p_76986_6_);
      GlStateManager.func_179114_b(180.0F - p_76986_8_, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b(-var24, 0.0F, 0.0F, 1.0F);
      float var30 = (float)p_76986_1_.func_70496_j() - p_76986_9_;
      float var31 = p_76986_1_.func_70491_i() - p_76986_9_;
      if(var31 < 0.0F) {
         var31 = 0.0F;
      }

      if(var30 > 0.0F) {
         GlStateManager.func_179114_b(MathHelper.func_76126_a(var30) * var30 * var31 / 10.0F * (float)p_76986_1_.func_70493_k(), 1.0F, 0.0F, 0.0F);
      }

      int var32 = p_76986_1_.func_94099_q();
      IBlockState var28 = p_76986_1_.func_174897_t();
      if(var28.func_177230_c().func_149645_b() != -1) {
         GlStateManager.func_179094_E();
         this.func_110776_a(TextureMap.field_110575_b);
         float var29 = 0.75F;
         GlStateManager.func_179152_a(var29, var29, var29);
         GlStateManager.func_179109_b(-0.5F, (float)(var32 - 8) / 16.0F, 0.5F);
         this.func_180560_a(p_76986_1_, p_76986_9_, var28);
         GlStateManager.func_179121_F();
         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
         this.func_180548_c(p_76986_1_);
      }

      GlStateManager.func_179152_a(-1.0F, -1.0F, 1.0F);
      this.field_77013_a.func_78088_a(p_76986_1_, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
      GlStateManager.func_179121_F();
      super.func_76986_a(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   protected ResourceLocation func_110775_a(EntityMinecart p_110775_1_) {
      return field_110804_g;
   }

   protected void func_180560_a(EntityMinecart p_180560_1_, float p_180560_2_, IBlockState p_180560_3_) {
      GlStateManager.func_179094_E();
      Minecraft.func_71410_x().func_175602_ab().func_175016_a(p_180560_3_, p_180560_1_.func_70013_c(p_180560_2_));
      GlStateManager.func_179121_F();
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityMinecart)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityMinecart)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
