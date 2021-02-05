package net.minecraft.client.renderer.entity;

import com.google.common.collect.Lists;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;

public abstract class RendererLivingEntity extends Render {

   private static final Logger field_147923_a = LogManager.getLogger();
   private static final DynamicTexture field_177096_e = new DynamicTexture(16, 16);
   protected ModelBase field_77045_g;
   protected FloatBuffer field_177095_g = GLAllocation.func_74529_h(4);
   protected List field_177097_h = Lists.newArrayList();
   protected boolean field_177098_i = false;
   private static final String __OBFID = "CL_00001012";


   public RendererLivingEntity(RenderManager p_i46156_1_, ModelBase p_i46156_2_, float p_i46156_3_) {
      super(p_i46156_1_);
      this.field_77045_g = p_i46156_2_;
      this.field_76989_e = p_i46156_3_;
   }

   protected boolean func_177094_a(LayerRenderer p_177094_1_) {
      return this.field_177097_h.add(p_177094_1_);
   }

   protected boolean func_177089_b(LayerRenderer p_177089_1_) {
      return this.field_177097_h.remove(p_177089_1_);
   }

   public ModelBase func_177087_b() {
      return this.field_77045_g;
   }

   protected float func_77034_a(float p_77034_1_, float p_77034_2_, float p_77034_3_) {
      float var4;
      for(var4 = p_77034_2_ - p_77034_1_; var4 < -180.0F; var4 += 360.0F) {
         ;
      }

      while(var4 >= 180.0F) {
         var4 -= 360.0F;
      }

      return p_77034_1_ + p_77034_3_ * var4;
   }

   public void func_82422_c() {}

   public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      GlStateManager.func_179094_E();
      GlStateManager.func_179129_p();
      this.field_77045_g.field_78095_p = this.func_77040_d(p_76986_1_, p_76986_9_);
      this.field_77045_g.field_78093_q = p_76986_1_.func_70115_ae();
      this.field_77045_g.field_78091_s = p_76986_1_.func_70631_g_();

      try {
         float var10 = this.func_77034_a(p_76986_1_.field_70760_ar, p_76986_1_.field_70761_aq, p_76986_9_);
         float var11 = this.func_77034_a(p_76986_1_.field_70758_at, p_76986_1_.field_70759_as, p_76986_9_);
         float var12 = var11 - var10;
         float var14;
         if(p_76986_1_.func_70115_ae() && p_76986_1_.field_70154_o instanceof EntityLivingBase) {
            EntityLivingBase var13 = (EntityLivingBase)p_76986_1_.field_70154_o;
            var10 = this.func_77034_a(var13.field_70760_ar, var13.field_70761_aq, p_76986_9_);
            var12 = var11 - var10;
            var14 = MathHelper.func_76142_g(var12);
            if(var14 < -85.0F) {
               var14 = -85.0F;
            }

            if(var14 >= 85.0F) {
               var14 = 85.0F;
            }

            var10 = var11 - var14;
            if(var14 * var14 > 2500.0F) {
               var10 += var14 * 0.2F;
            }
         }

         float var20 = p_76986_1_.field_70127_C + (p_76986_1_.field_70125_A - p_76986_1_.field_70127_C) * p_76986_9_;
         this.func_77039_a(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_);
         var14 = this.func_77044_a(p_76986_1_, p_76986_9_);
         this.func_77043_a(p_76986_1_, var14, var10, p_76986_9_);
         GlStateManager.func_179091_B();
         GlStateManager.func_179152_a(-1.0F, -1.0F, 1.0F);
         this.func_77041_b(p_76986_1_, p_76986_9_);
         float var15 = 0.0625F;
         GlStateManager.func_179109_b(0.0F, -1.5078125F, 0.0F);
         float var16 = p_76986_1_.field_70722_aY + (p_76986_1_.field_70721_aZ - p_76986_1_.field_70722_aY) * p_76986_9_;
         float var17 = p_76986_1_.field_70754_ba - p_76986_1_.field_70721_aZ * (1.0F - p_76986_9_);
         if(p_76986_1_.func_70631_g_()) {
            var17 *= 3.0F;
         }

         if(var16 > 1.0F) {
            var16 = 1.0F;
         }

         GlStateManager.func_179141_d();
         this.field_77045_g.func_78086_a(p_76986_1_, var17, var16, p_76986_9_);
         this.field_77045_g.func_78087_a(var17, var16, var14, var12, var20, 0.0625F, p_76986_1_);
         boolean var18;
         if(this.field_177098_i) {
            var18 = this.func_177088_c(p_76986_1_);
            this.func_77036_a(p_76986_1_, var17, var16, var14, var12, var20, 0.0625F);
            if(var18) {
               this.func_180565_e();
            }
         } else {
            var18 = this.func_177090_c(p_76986_1_, p_76986_9_);
            this.func_77036_a(p_76986_1_, var17, var16, var14, var12, var20, 0.0625F);
            if(var18) {
               this.func_177091_f();
            }

            GlStateManager.func_179132_a(true);
            if(!(p_76986_1_ instanceof EntityPlayer) || !((EntityPlayer)p_76986_1_).func_175149_v()) {
               this.func_177093_a(p_76986_1_, var17, var16, p_76986_9_, var14, var12, var20, 0.0625F);
            }
         }

         GlStateManager.func_179101_C();
      } catch (Exception var19) {
         field_147923_a.error("Couldn\'t render entity", var19);
      }

      GlStateManager.func_179138_g(OpenGlHelper.field_77476_b);
      GlStateManager.func_179098_w();
      GlStateManager.func_179138_g(OpenGlHelper.field_77478_a);
      GlStateManager.func_179089_o();
      GlStateManager.func_179121_F();
      if(!this.field_177098_i) {
         super.func_76986_a(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
      }

   }

   protected boolean func_177088_c(EntityLivingBase p_177088_1_) {
      int var2 = 16777215;
      if(p_177088_1_ instanceof EntityPlayer) {
         ScorePlayerTeam var3 = (ScorePlayerTeam)p_177088_1_.func_96124_cp();
         if(var3 != null) {
            String var4 = FontRenderer.func_78282_e(var3.func_96668_e());
            if(var4.length() >= 2) {
               var2 = this.func_76983_a().func_175064_b(var4.charAt(1));
            }
         }
      }

      float var6 = (float)(var2 >> 16 & 255) / 255.0F;
      float var7 = (float)(var2 >> 8 & 255) / 255.0F;
      float var5 = (float)(var2 & 255) / 255.0F;
      GlStateManager.func_179140_f();
      GlStateManager.func_179138_g(OpenGlHelper.field_77478_a);
      GlStateManager.func_179131_c(var6, var7, var5, 1.0F);
      GlStateManager.func_179090_x();
      GlStateManager.func_179138_g(OpenGlHelper.field_77476_b);
      GlStateManager.func_179090_x();
      GlStateManager.func_179138_g(OpenGlHelper.field_77478_a);
      return true;
   }

   protected void func_180565_e() {
      GlStateManager.func_179145_e();
      GlStateManager.func_179138_g(OpenGlHelper.field_77478_a);
      GlStateManager.func_179098_w();
      GlStateManager.func_179138_g(OpenGlHelper.field_77476_b);
      GlStateManager.func_179098_w();
      GlStateManager.func_179138_g(OpenGlHelper.field_77478_a);
   }

   protected void func_77036_a(EntityLivingBase p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
      boolean var8 = !p_77036_1_.func_82150_aj();
      boolean var9 = !var8 && !p_77036_1_.func_98034_c(Minecraft.func_71410_x().field_71439_g);
      if(var8 || var9) {
         if(!this.func_180548_c(p_77036_1_)) {
            return;
         }

         if(var9) {
            GlStateManager.func_179094_E();
            GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 0.15F);
            GlStateManager.func_179132_a(false);
            GlStateManager.func_179147_l();
            GlStateManager.func_179112_b(770, 771);
            GlStateManager.func_179092_a(516, 0.003921569F);
         }

         this.field_77045_g.func_78088_a(p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
         if(var9) {
            GlStateManager.func_179084_k();
            GlStateManager.func_179092_a(516, 0.1F);
            GlStateManager.func_179121_F();
            GlStateManager.func_179132_a(true);
         }
      }

   }

   protected boolean func_177090_c(EntityLivingBase p_177090_1_, float p_177090_2_) {
      return this.func_177092_a(p_177090_1_, p_177090_2_, true);
   }

   protected boolean func_177092_a(EntityLivingBase p_177092_1_, float p_177092_2_, boolean p_177092_3_) {
      float var4 = p_177092_1_.func_70013_c(p_177092_2_);
      int var5 = this.func_77030_a(p_177092_1_, var4, p_177092_2_);
      boolean var6 = (var5 >> 24 & 255) > 0;
      boolean var7 = p_177092_1_.field_70737_aN > 0 || p_177092_1_.field_70725_aQ > 0;
      if(!var6 && !var7) {
         return false;
      } else if(!var6 && !p_177092_3_) {
         return false;
      } else {
         GlStateManager.func_179138_g(OpenGlHelper.field_77478_a);
         GlStateManager.func_179098_w();
         GL11.glTexEnvi(8960, 8704, OpenGlHelper.field_176095_s);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176099_x, 8448);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176098_y, OpenGlHelper.field_77478_a);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176097_z, OpenGlHelper.field_176093_u);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176081_B, 768);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176082_C, 768);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176077_E, 7681);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176078_F, OpenGlHelper.field_77478_a);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176085_I, 770);
         GlStateManager.func_179138_g(OpenGlHelper.field_77476_b);
         GlStateManager.func_179098_w();
         GL11.glTexEnvi(8960, 8704, OpenGlHelper.field_176095_s);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176099_x, OpenGlHelper.field_176094_t);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176098_y, OpenGlHelper.field_176092_v);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176097_z, OpenGlHelper.field_176091_w);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176080_A, OpenGlHelper.field_176092_v);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176081_B, 768);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176082_C, 768);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176076_D, 770);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176077_E, 7681);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176078_F, OpenGlHelper.field_176091_w);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176085_I, 770);
         this.field_177095_g.position(0);
         if(var7) {
            this.field_177095_g.put(1.0F);
            this.field_177095_g.put(0.0F);
            this.field_177095_g.put(0.0F);
            this.field_177095_g.put(0.3F);
         } else {
            float var8 = (float)(var5 >> 24 & 255) / 255.0F;
            float var9 = (float)(var5 >> 16 & 255) / 255.0F;
            float var10 = (float)(var5 >> 8 & 255) / 255.0F;
            float var11 = (float)(var5 & 255) / 255.0F;
            this.field_177095_g.put(var9);
            this.field_177095_g.put(var10);
            this.field_177095_g.put(var11);
            this.field_177095_g.put(1.0F - var8);
         }

         this.field_177095_g.flip();
         GL11.glTexEnv(8960, 8705, this.field_177095_g);
         GlStateManager.func_179138_g(OpenGlHelper.field_176096_r);
         GlStateManager.func_179098_w();
         GlStateManager.func_179144_i(field_177096_e.func_110552_b());
         GL11.glTexEnvi(8960, 8704, OpenGlHelper.field_176095_s);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176099_x, 8448);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176098_y, OpenGlHelper.field_176091_w);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176097_z, OpenGlHelper.field_77476_b);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176081_B, 768);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176082_C, 768);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176077_E, 7681);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176078_F, OpenGlHelper.field_176091_w);
         GL11.glTexEnvi(8960, OpenGlHelper.field_176085_I, 770);
         GlStateManager.func_179138_g(OpenGlHelper.field_77478_a);
         return true;
      }
   }

   protected void func_177091_f() {
      GlStateManager.func_179138_g(OpenGlHelper.field_77478_a);
      GlStateManager.func_179098_w();
      GL11.glTexEnvi(8960, 8704, OpenGlHelper.field_176095_s);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176099_x, 8448);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176098_y, OpenGlHelper.field_77478_a);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176097_z, OpenGlHelper.field_176093_u);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176081_B, 768);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176082_C, 768);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176077_E, 8448);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176078_F, OpenGlHelper.field_77478_a);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176079_G, OpenGlHelper.field_176093_u);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176085_I, 770);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176086_J, 770);
      GlStateManager.func_179138_g(OpenGlHelper.field_77476_b);
      GL11.glTexEnvi(8960, 8704, OpenGlHelper.field_176095_s);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176099_x, 8448);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176081_B, 768);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176082_C, 768);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176098_y, 5890);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176097_z, OpenGlHelper.field_176091_w);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176077_E, 8448);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176085_I, 770);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176078_F, 5890);
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.func_179138_g(OpenGlHelper.field_176096_r);
      GlStateManager.func_179090_x();
      GlStateManager.func_179144_i(0);
      GL11.glTexEnvi(8960, 8704, OpenGlHelper.field_176095_s);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176099_x, 8448);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176081_B, 768);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176082_C, 768);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176098_y, 5890);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176097_z, OpenGlHelper.field_176091_w);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176077_E, 8448);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176085_I, 770);
      GL11.glTexEnvi(8960, OpenGlHelper.field_176078_F, 5890);
      GlStateManager.func_179138_g(OpenGlHelper.field_77478_a);
   }

   protected void func_77039_a(EntityLivingBase p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
      GlStateManager.func_179109_b((float)p_77039_2_, (float)p_77039_4_, (float)p_77039_6_);
   }

   protected void func_77043_a(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
      GlStateManager.func_179114_b(180.0F - p_77043_3_, 0.0F, 1.0F, 0.0F);
      if(p_77043_1_.field_70725_aQ > 0) {
         float var5 = ((float)p_77043_1_.field_70725_aQ + p_77043_4_ - 1.0F) / 20.0F * 1.6F;
         var5 = MathHelper.func_76129_c(var5);
         if(var5 > 1.0F) {
            var5 = 1.0F;
         }

         GlStateManager.func_179114_b(var5 * this.func_77037_a(p_77043_1_), 0.0F, 0.0F, 1.0F);
      } else {
         String var6 = EnumChatFormatting.func_110646_a(p_77043_1_.func_70005_c_());
         if(var6 != null && (var6.equals("Dinnerbone") || var6.equals("Grumm")) && (!(p_77043_1_ instanceof EntityPlayer) || ((EntityPlayer)p_77043_1_).func_175148_a(EnumPlayerModelParts.CAPE))) {
            GlStateManager.func_179109_b(0.0F, p_77043_1_.field_70131_O + 0.1F, 0.0F);
            GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
         }
      }

   }

   protected float func_77040_d(EntityLivingBase p_77040_1_, float p_77040_2_) {
      return p_77040_1_.func_70678_g(p_77040_2_);
   }

   protected float func_77044_a(EntityLivingBase p_77044_1_, float p_77044_2_) {
      return (float)p_77044_1_.field_70173_aa + p_77044_2_;
   }

   protected void func_177093_a(EntityLivingBase p_177093_1_, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {
      Iterator var9 = this.field_177097_h.iterator();

      while(var9.hasNext()) {
         LayerRenderer var10 = (LayerRenderer)var9.next();
         boolean var11 = this.func_177092_a(p_177093_1_, p_177093_4_, var10.func_177142_b());
         var10.func_177141_a(p_177093_1_, p_177093_2_, p_177093_3_, p_177093_4_, p_177093_5_, p_177093_6_, p_177093_7_, p_177093_8_);
         if(var11) {
            this.func_177091_f();
         }
      }

   }

   protected float func_77037_a(EntityLivingBase p_77037_1_) {
      return 90.0F;
   }

   protected int func_77030_a(EntityLivingBase p_77030_1_, float p_77030_2_, float p_77030_3_) {
      return 0;
   }

   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {}

   public void func_77033_b(EntityLivingBase p_77033_1_, double p_77033_2_, double p_77033_4_, double p_77033_6_) {
      if(this.func_110813_b(p_77033_1_)) {
         double var8 = p_77033_1_.func_70068_e(this.field_76990_c.field_78734_h);
         float var10 = p_77033_1_.func_70093_af()?32.0F:64.0F;
         if(var8 < (double)(var10 * var10)) {
            String var11 = p_77033_1_.func_145748_c_().func_150254_d();
            float var12 = 0.02666667F;
            GlStateManager.func_179092_a(516, 0.1F);
            if(p_77033_1_.func_70093_af()) {
               FontRenderer var13 = this.func_76983_a();
               GlStateManager.func_179094_E();
               GlStateManager.func_179109_b((float)p_77033_2_, (float)p_77033_4_ + p_77033_1_.field_70131_O + 0.5F - (p_77033_1_.func_70631_g_()?p_77033_1_.field_70131_O / 2.0F:0.0F), (float)p_77033_6_);
               GL11.glNormal3f(0.0F, 1.0F, 0.0F);
               GlStateManager.func_179114_b(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
               GlStateManager.func_179114_b(this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
               GlStateManager.func_179152_a(-0.02666667F, -0.02666667F, 0.02666667F);
               GlStateManager.func_179109_b(0.0F, 9.374999F, 0.0F);
               GlStateManager.func_179140_f();
               GlStateManager.func_179132_a(false);
               GlStateManager.func_179147_l();
               GlStateManager.func_179090_x();
               GlStateManager.func_179120_a(770, 771, 1, 0);
               Tessellator var14 = Tessellator.func_178181_a();
               WorldRenderer var15 = var14.func_178180_c();
               var15.func_178970_b();
               int var16 = var13.func_78256_a(var11) / 2;
               var15.func_178960_a(0.0F, 0.0F, 0.0F, 0.25F);
               var15.func_178984_b((double)(-var16 - 1), -1.0D, 0.0D);
               var15.func_178984_b((double)(-var16 - 1), 8.0D, 0.0D);
               var15.func_178984_b((double)(var16 + 1), 8.0D, 0.0D);
               var15.func_178984_b((double)(var16 + 1), -1.0D, 0.0D);
               var14.func_78381_a();
               GlStateManager.func_179098_w();
               GlStateManager.func_179132_a(true);
               var13.func_78276_b(var11, -var13.func_78256_a(var11) / 2, 0, 553648127);
               GlStateManager.func_179145_e();
               GlStateManager.func_179084_k();
               GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
               GlStateManager.func_179121_F();
            } else {
               this.func_177069_a(p_77033_1_, p_77033_2_, p_77033_4_ - (p_77033_1_.func_70631_g_()?(double)(p_77033_1_.field_70131_O / 2.0F):0.0D), p_77033_6_, var11, 0.02666667F, var8);
            }

         }
      }
   }

   protected boolean func_110813_b(EntityLivingBase p_110813_1_) {
      EntityPlayerSP var2 = Minecraft.func_71410_x().field_71439_g;
      if(p_110813_1_ instanceof EntityPlayer && p_110813_1_ != var2) {
         Team var3 = p_110813_1_.func_96124_cp();
         Team var4 = var2.func_96124_cp();
         if(var3 != null) {
            Team.EnumVisible var5 = var3.func_178770_i();
            switch(RendererLivingEntity.SwitchEnumVisible.field_178679_a[var5.ordinal()]) {
            case 1:
               return true;
            case 2:
               return false;
            case 3:
               return var4 == null || var3.func_142054_a(var4);
            case 4:
               return var4 == null || !var3.func_142054_a(var4);
            default:
               return true;
            }
         }
      }

      return Minecraft.func_71382_s() && p_110813_1_ != this.field_76990_c.field_78734_h && !p_110813_1_.func_98034_c(var2) && p_110813_1_.field_70153_n == null;
   }

   public void func_177086_a(boolean p_177086_1_) {
      this.field_177098_i = p_177086_1_;
   }

   // $FF: synthetic method
   protected boolean func_177070_b(Entity p_177070_1_) {
      return this.func_110813_b((EntityLivingBase)p_177070_1_);
   }

   // $FF: synthetic method
   public void func_177067_a(Entity p_177067_1_, double p_177067_2_, double p_177067_4_, double p_177067_6_) {
      this.func_77033_b((EntityLivingBase)p_177067_1_, p_177067_2_, p_177067_4_, p_177067_6_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76986_a((EntityLivingBase)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   static {
      int[] var0 = field_177096_e.func_110565_c();

      for(int var1 = 0; var1 < 256; ++var1) {
         var0[var1] = -1;
      }

      field_177096_e.func_110564_a();
   }

   // $FF: synthetic class
   static final class SwitchEnumVisible {

      // $FF: synthetic field
      static final int[] field_178679_a = new int[Team.EnumVisible.values().length];
      private static final String __OBFID = "CL_00002435";


      static {
         try {
            field_178679_a[Team.EnumVisible.ALWAYS.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_178679_a[Team.EnumVisible.NEVER.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_178679_a[Team.EnumVisible.HIDE_FOR_OTHER_TEAMS.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_178679_a[Team.EnumVisible.HIDE_FOR_OWN_TEAM.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
