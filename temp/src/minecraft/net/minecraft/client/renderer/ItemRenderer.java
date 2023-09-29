package net.minecraft.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.MapData;
import org.lwjgl.opengl.GL11;

public class ItemRenderer {

   private static final ResourceLocation field_110931_c = new ResourceLocation("textures/map/map_background.png");
   private static final ResourceLocation field_110929_d = new ResourceLocation("textures/misc/underwater.png");
   private final Minecraft field_78455_a;
   private ItemStack field_78453_b;
   private float field_78454_c;
   private float field_78451_d;
   private final RenderManager field_178111_g;
   private final RenderItem field_178112_h;
   private int field_78450_g = -1;
   private static final String __OBFID = "CL_00000953";


   public ItemRenderer(Minecraft p_i1247_1_) {
      this.field_78455_a = p_i1247_1_;
      this.field_178111_g = p_i1247_1_.func_175598_ae();
      this.field_178112_h = p_i1247_1_.func_175599_af();
   }

   public void func_178099_a(EntityLivingBase p_178099_1_, ItemStack p_178099_2_, ItemCameraTransforms.TransformType p_178099_3_) {
      if(p_178099_2_ != null) {
         Item var4 = p_178099_2_.func_77973_b();
         Block var5 = Block.func_149634_a(var4);
         GlStateManager.func_179094_E();
         if(this.field_178112_h.func_175050_a(p_178099_2_)) {
            GlStateManager.func_179152_a(2.0F, 2.0F, 2.0F);
            if(this.func_178107_a(var5)) {
               GlStateManager.func_179132_a(false);
            }
         }

         this.field_178112_h.func_175049_a(p_178099_2_, p_178099_1_, p_178099_3_);
         if(this.func_178107_a(var5)) {
            GlStateManager.func_179132_a(true);
         }

         GlStateManager.func_179121_F();
      }
   }

   private boolean func_178107_a(Block p_178107_1_) {
      return p_178107_1_ != null && p_178107_1_.func_180664_k() == EnumWorldBlockLayer.TRANSLUCENT;
   }

   private void func_178101_a(float p_178101_1_, float p_178101_2_) {
      GlStateManager.func_179094_E();
      GlStateManager.func_179114_b(p_178101_1_, 1.0F, 0.0F, 0.0F);
      GlStateManager.func_179114_b(p_178101_2_, 0.0F, 1.0F, 0.0F);
      RenderHelper.func_74519_b();
      GlStateManager.func_179121_F();
   }

   private void func_178109_a(AbstractClientPlayer p_178109_1_) {
      int var2 = this.field_78455_a.field_71441_e.func_175626_b(new BlockPos(p_178109_1_.field_70165_t, p_178109_1_.field_70163_u + (double)p_178109_1_.func_70047_e(), p_178109_1_.field_70161_v), 0);
      float var3 = (float)(var2 & '\uffff');
      float var4 = (float)(var2 >> 16);
      OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, var3, var4);
   }

   private void func_178110_a(EntityPlayerSP p_178110_1_, float p_178110_2_) {
      float var3 = p_178110_1_.field_71164_i + (p_178110_1_.field_71155_g - p_178110_1_.field_71164_i) * p_178110_2_;
      float var4 = p_178110_1_.field_71163_h + (p_178110_1_.field_71154_f - p_178110_1_.field_71163_h) * p_178110_2_;
      GlStateManager.func_179114_b((p_178110_1_.field_70125_A - var3) * 0.1F, 1.0F, 0.0F, 0.0F);
      GlStateManager.func_179114_b((p_178110_1_.field_70177_z - var4) * 0.1F, 0.0F, 1.0F, 0.0F);
   }

   private float func_178100_c(float p_178100_1_) {
      float var2 = 1.0F - p_178100_1_ / 45.0F + 0.1F;
      var2 = MathHelper.func_76131_a(var2, 0.0F, 1.0F);
      var2 = -MathHelper.func_76134_b(var2 * 3.1415927F) * 0.5F + 0.5F;
      return var2;
   }

   private void func_180534_a(RenderPlayer p_180534_1_) {
      GlStateManager.func_179094_E();
      GlStateManager.func_179114_b(54.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b(64.0F, 1.0F, 0.0F, 0.0F);
      GlStateManager.func_179114_b(-62.0F, 0.0F, 0.0F, 1.0F);
      GlStateManager.func_179109_b(0.25F, -0.85F, 0.75F);
      p_180534_1_.func_177138_b(this.field_78455_a.field_71439_g);
      GlStateManager.func_179121_F();
   }

   private void func_178106_b(RenderPlayer p_178106_1_) {
      GlStateManager.func_179094_E();
      GlStateManager.func_179114_b(92.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b(45.0F, 1.0F, 0.0F, 0.0F);
      GlStateManager.func_179114_b(41.0F, 0.0F, 0.0F, 1.0F);
      GlStateManager.func_179109_b(-0.3F, -1.1F, 0.45F);
      p_178106_1_.func_177139_c(this.field_78455_a.field_71439_g);
      GlStateManager.func_179121_F();
   }

   private void func_178102_b(AbstractClientPlayer p_178102_1_) {
      this.field_78455_a.func_110434_K().func_110577_a(p_178102_1_.func_110306_p());
      Render var2 = this.field_178111_g.func_78713_a(this.field_78455_a.field_71439_g);
      RenderPlayer var3 = (RenderPlayer)var2;
      if(!p_178102_1_.func_82150_aj()) {
         this.func_180534_a(var3);
         this.func_178106_b(var3);
      }

   }

   private void func_178097_a(AbstractClientPlayer p_178097_1_, float p_178097_2_, float p_178097_3_, float p_178097_4_) {
      float var5 = -0.4F * MathHelper.func_76126_a(MathHelper.func_76129_c(p_178097_4_) * 3.1415927F);
      float var6 = 0.2F * MathHelper.func_76126_a(MathHelper.func_76129_c(p_178097_4_) * 3.1415927F * 2.0F);
      float var7 = -0.2F * MathHelper.func_76126_a(p_178097_4_ * 3.1415927F);
      GlStateManager.func_179109_b(var5, var6, var7);
      float var8 = this.func_178100_c(p_178097_2_);
      GlStateManager.func_179109_b(0.0F, 0.04F, -0.72F);
      GlStateManager.func_179109_b(0.0F, p_178097_3_ * -1.2F, 0.0F);
      GlStateManager.func_179109_b(0.0F, var8 * -0.5F, 0.0F);
      GlStateManager.func_179114_b(90.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b(var8 * -85.0F, 0.0F, 0.0F, 1.0F);
      GlStateManager.func_179114_b(0.0F, 1.0F, 0.0F, 0.0F);
      this.func_178102_b(p_178097_1_);
      float var9 = MathHelper.func_76126_a(p_178097_4_ * p_178097_4_ * 3.1415927F);
      float var10 = MathHelper.func_76126_a(MathHelper.func_76129_c(p_178097_4_) * 3.1415927F);
      GlStateManager.func_179114_b(var9 * -20.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b(var10 * -20.0F, 0.0F, 0.0F, 1.0F);
      GlStateManager.func_179114_b(var10 * -80.0F, 1.0F, 0.0F, 0.0F);
      GlStateManager.func_179152_a(0.38F, 0.38F, 0.38F);
      GlStateManager.func_179114_b(90.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
      GlStateManager.func_179114_b(0.0F, 1.0F, 0.0F, 0.0F);
      GlStateManager.func_179109_b(-1.0F, -1.0F, 0.0F);
      GlStateManager.func_179152_a(0.015625F, 0.015625F, 0.015625F);
      this.field_78455_a.func_110434_K().func_110577_a(field_110931_c);
      Tessellator var11 = Tessellator.func_178181_a();
      WorldRenderer var12 = var11.func_178180_c();
      GL11.glNormal3f(0.0F, 0.0F, -1.0F);
      var12.func_178970_b();
      var12.func_178985_a(-7.0D, 135.0D, 0.0D, 0.0D, 1.0D);
      var12.func_178985_a(135.0D, 135.0D, 0.0D, 1.0D, 1.0D);
      var12.func_178985_a(135.0D, -7.0D, 0.0D, 1.0D, 0.0D);
      var12.func_178985_a(-7.0D, -7.0D, 0.0D, 0.0D, 0.0D);
      var11.func_78381_a();
      MapData var13 = Items.field_151098_aY.func_77873_a(this.field_78453_b, this.field_78455_a.field_71441_e);
      if(var13 != null) {
         this.field_78455_a.field_71460_t.func_147701_i().func_148250_a(var13, false);
      }

   }

   private void func_178095_a(AbstractClientPlayer p_178095_1_, float p_178095_2_, float p_178095_3_) {
      float var4 = -0.3F * MathHelper.func_76126_a(MathHelper.func_76129_c(p_178095_3_) * 3.1415927F);
      float var5 = 0.4F * MathHelper.func_76126_a(MathHelper.func_76129_c(p_178095_3_) * 3.1415927F * 2.0F);
      float var6 = -0.4F * MathHelper.func_76126_a(p_178095_3_ * 3.1415927F);
      GlStateManager.func_179109_b(var4, var5, var6);
      GlStateManager.func_179109_b(0.64000005F, -0.6F, -0.71999997F);
      GlStateManager.func_179109_b(0.0F, p_178095_2_ * -0.6F, 0.0F);
      GlStateManager.func_179114_b(45.0F, 0.0F, 1.0F, 0.0F);
      float var7 = MathHelper.func_76126_a(p_178095_3_ * p_178095_3_ * 3.1415927F);
      float var8 = MathHelper.func_76126_a(MathHelper.func_76129_c(p_178095_3_) * 3.1415927F);
      GlStateManager.func_179114_b(var8 * 70.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b(var7 * -20.0F, 0.0F, 0.0F, 1.0F);
      this.field_78455_a.func_110434_K().func_110577_a(p_178095_1_.func_110306_p());
      GlStateManager.func_179109_b(-1.0F, 3.6F, 3.5F);
      GlStateManager.func_179114_b(120.0F, 0.0F, 0.0F, 1.0F);
      GlStateManager.func_179114_b(200.0F, 1.0F, 0.0F, 0.0F);
      GlStateManager.func_179114_b(-135.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179152_a(1.0F, 1.0F, 1.0F);
      GlStateManager.func_179109_b(5.6F, 0.0F, 0.0F);
      Render var9 = this.field_178111_g.func_78713_a(this.field_78455_a.field_71439_g);
      RenderPlayer var10 = (RenderPlayer)var9;
      var10.func_177138_b(this.field_78455_a.field_71439_g);
   }

   private void func_178105_d(float p_178105_1_) {
      float var2 = -0.4F * MathHelper.func_76126_a(MathHelper.func_76129_c(p_178105_1_) * 3.1415927F);
      float var3 = 0.2F * MathHelper.func_76126_a(MathHelper.func_76129_c(p_178105_1_) * 3.1415927F * 2.0F);
      float var4 = -0.2F * MathHelper.func_76126_a(p_178105_1_ * 3.1415927F);
      GlStateManager.func_179109_b(var2, var3, var4);
   }

   private void func_178104_a(AbstractClientPlayer p_178104_1_, float p_178104_2_) {
      float var3 = (float)p_178104_1_.func_71052_bv() - p_178104_2_ + 1.0F;
      float var4 = var3 / (float)this.field_78453_b.func_77988_m();
      float var5 = MathHelper.func_76135_e(MathHelper.func_76134_b(var3 / 4.0F * 3.1415927F) * 0.1F);
      if(var4 >= 0.8F) {
         var5 = 0.0F;
      }

      GlStateManager.func_179109_b(0.0F, var5, 0.0F);
      float var6 = 1.0F - (float)Math.pow((double)var4, 27.0D);
      GlStateManager.func_179109_b(var6 * 0.6F, var6 * -0.5F, var6 * 0.0F);
      GlStateManager.func_179114_b(var6 * 90.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b(var6 * 10.0F, 1.0F, 0.0F, 0.0F);
      GlStateManager.func_179114_b(var6 * 30.0F, 0.0F, 0.0F, 1.0F);
   }

   private void func_178096_b(float p_178096_1_, float p_178096_2_) {
      GlStateManager.func_179109_b(0.56F, -0.52F, -0.71999997F);
      GlStateManager.func_179109_b(0.0F, p_178096_1_ * -0.6F, 0.0F);
      GlStateManager.func_179114_b(45.0F, 0.0F, 1.0F, 0.0F);
      float var3 = MathHelper.func_76126_a(p_178096_2_ * p_178096_2_ * 3.1415927F);
      float var4 = MathHelper.func_76126_a(MathHelper.func_76129_c(p_178096_2_) * 3.1415927F);
      GlStateManager.func_179114_b(var3 * -20.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b(var4 * -20.0F, 0.0F, 0.0F, 1.0F);
      GlStateManager.func_179114_b(var4 * -80.0F, 1.0F, 0.0F, 0.0F);
      GlStateManager.func_179152_a(0.4F, 0.4F, 0.4F);
   }

   private void func_178098_a(float p_178098_1_, AbstractClientPlayer p_178098_2_) {
      GlStateManager.func_179114_b(-18.0F, 0.0F, 0.0F, 1.0F);
      GlStateManager.func_179114_b(-12.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b(-8.0F, 1.0F, 0.0F, 0.0F);
      GlStateManager.func_179109_b(-0.9F, 0.2F, 0.0F);
      float var3 = (float)this.field_78453_b.func_77988_m() - ((float)p_178098_2_.func_71052_bv() - p_178098_1_ + 1.0F);
      float var4 = var3 / 20.0F;
      var4 = (var4 * var4 + var4 * 2.0F) / 3.0F;
      if(var4 > 1.0F) {
         var4 = 1.0F;
      }

      if(var4 > 0.1F) {
         float var5 = MathHelper.func_76126_a((var3 - 0.1F) * 1.3F);
         float var6 = var4 - 0.1F;
         float var7 = var5 * var6;
         GlStateManager.func_179109_b(var7 * 0.0F, var7 * 0.01F, var7 * 0.0F);
      }

      GlStateManager.func_179109_b(var4 * 0.0F, var4 * 0.0F, var4 * 0.1F);
      GlStateManager.func_179152_a(1.0F, 1.0F, 1.0F + var4 * 0.2F);
   }

   private void func_178103_d() {
      GlStateManager.func_179109_b(-0.5F, 0.2F, 0.0F);
      GlStateManager.func_179114_b(30.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b(-80.0F, 1.0F, 0.0F, 0.0F);
      GlStateManager.func_179114_b(60.0F, 0.0F, 1.0F, 0.0F);
   }

   public void func_78440_a(float p_78440_1_) {
      float var2 = 1.0F - (this.field_78451_d + (this.field_78454_c - this.field_78451_d) * p_78440_1_);
      EntityPlayerSP var3 = this.field_78455_a.field_71439_g;
      float var4 = var3.func_70678_g(p_78440_1_);
      float var5 = var3.field_70127_C + (var3.field_70125_A - var3.field_70127_C) * p_78440_1_;
      float var6 = var3.field_70126_B + (var3.field_70177_z - var3.field_70126_B) * p_78440_1_;
      this.func_178101_a(var5, var6);
      this.func_178109_a(var3);
      this.func_178110_a((EntityPlayerSP)var3, p_78440_1_);
      GlStateManager.func_179091_B();
      GlStateManager.func_179094_E();
      if(this.field_78453_b != null) {
         if(this.field_78453_b.func_77973_b() == Items.field_151098_aY) {
            this.func_178097_a(var3, var5, var2, var4);
         } else if(var3.func_71052_bv() > 0) {
            EnumAction var7 = this.field_78453_b.func_77975_n();
            switch(ItemRenderer.SwitchEnumAction.field_178094_a[var7.ordinal()]) {
            case 1:
               this.func_178096_b(var2, 0.0F);
               break;
            case 2:
            case 3:
               this.func_178104_a(var3, p_78440_1_);
               this.func_178096_b(var2, 0.0F);
               break;
            case 4:
               this.func_178096_b(var2, 0.0F);
               this.func_178103_d();
               break;
            case 5:
               this.func_178096_b(var2, 0.0F);
               this.func_178098_a(p_78440_1_, var3);
            }
         } else {
            this.func_178105_d(var4);
            this.func_178096_b(var2, var4);
         }

         this.func_178099_a(var3, this.field_78453_b, ItemCameraTransforms.TransformType.FIRST_PERSON);
      } else if(!var3.func_82150_aj()) {
         this.func_178095_a(var3, var2, var4);
      }

      GlStateManager.func_179121_F();
      GlStateManager.func_179101_C();
      RenderHelper.func_74518_a();
   }

   public void func_78447_b(float p_78447_1_) {
      GlStateManager.func_179118_c();
      if(this.field_78455_a.field_71439_g.func_70094_T()) {
         IBlockState var2 = this.field_78455_a.field_71441_e.func_180495_p(new BlockPos(this.field_78455_a.field_71439_g));
         EntityPlayerSP var3 = this.field_78455_a.field_71439_g;

         for(int var4 = 0; var4 < 8; ++var4) {
            double var5 = var3.field_70165_t + (double)(((float)((var4 >> 0) % 2) - 0.5F) * var3.field_70130_N * 0.8F);
            double var7 = var3.field_70163_u + (double)(((float)((var4 >> 1) % 2) - 0.5F) * 0.1F);
            double var9 = var3.field_70161_v + (double)(((float)((var4 >> 2) % 2) - 0.5F) * var3.field_70130_N * 0.8F);
            BlockPos var11 = new BlockPos(var5, var7 + (double)var3.func_70047_e(), var9);
            IBlockState var12 = this.field_78455_a.field_71441_e.func_180495_p(var11);
            if(var12.func_177230_c().func_176214_u()) {
               var2 = var12;
            }
         }

         if(var2.func_177230_c().func_149645_b() != -1) {
            this.func_178108_a(p_78447_1_, this.field_78455_a.func_175602_ab().func_175023_a().func_178122_a(var2));
         }
      }

      if(!this.field_78455_a.field_71439_g.func_175149_v()) {
         if(this.field_78455_a.field_71439_g.func_70055_a(Material.field_151586_h)) {
            this.func_78448_c(p_78447_1_);
         }

         if(this.field_78455_a.field_71439_g.func_70027_ad()) {
            this.func_78442_d(p_78447_1_);
         }
      }

      GlStateManager.func_179141_d();
   }

   private void func_178108_a(float p_178108_1_, TextureAtlasSprite p_178108_2_) {
      this.field_78455_a.func_110434_K().func_110577_a(TextureMap.field_110575_b);
      Tessellator var3 = Tessellator.func_178181_a();
      WorldRenderer var4 = var3.func_178180_c();
      float var5 = 0.1F;
      GlStateManager.func_179131_c(var5, var5, var5, 0.5F);
      GlStateManager.func_179094_E();
      float var6 = -1.0F;
      float var7 = 1.0F;
      float var8 = -1.0F;
      float var9 = 1.0F;
      float var10 = -0.5F;
      float var11 = p_178108_2_.func_94209_e();
      float var12 = p_178108_2_.func_94212_f();
      float var13 = p_178108_2_.func_94206_g();
      float var14 = p_178108_2_.func_94210_h();
      var4.func_178970_b();
      var4.func_178985_a((double)var6, (double)var8, (double)var10, (double)var12, (double)var14);
      var4.func_178985_a((double)var7, (double)var8, (double)var10, (double)var11, (double)var14);
      var4.func_178985_a((double)var7, (double)var9, (double)var10, (double)var11, (double)var13);
      var4.func_178985_a((double)var6, (double)var9, (double)var10, (double)var12, (double)var13);
      var3.func_78381_a();
      GlStateManager.func_179121_F();
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private void func_78448_c(float p_78448_1_) {
      this.field_78455_a.func_110434_K().func_110577_a(field_110929_d);
      Tessellator var2 = Tessellator.func_178181_a();
      WorldRenderer var3 = var2.func_178180_c();
      float var4 = this.field_78455_a.field_71439_g.func_70013_c(p_78448_1_);
      GlStateManager.func_179131_c(var4, var4, var4, 0.5F);
      GlStateManager.func_179147_l();
      GlStateManager.func_179120_a(770, 771, 1, 0);
      GlStateManager.func_179094_E();
      float var5 = 4.0F;
      float var6 = -1.0F;
      float var7 = 1.0F;
      float var8 = -1.0F;
      float var9 = 1.0F;
      float var10 = -0.5F;
      float var11 = -this.field_78455_a.field_71439_g.field_70177_z / 64.0F;
      float var12 = this.field_78455_a.field_71439_g.field_70125_A / 64.0F;
      var3.func_178970_b();
      var3.func_178985_a((double)var6, (double)var8, (double)var10, (double)(var5 + var11), (double)(var5 + var12));
      var3.func_178985_a((double)var7, (double)var8, (double)var10, (double)(0.0F + var11), (double)(var5 + var12));
      var3.func_178985_a((double)var7, (double)var9, (double)var10, (double)(0.0F + var11), (double)(0.0F + var12));
      var3.func_178985_a((double)var6, (double)var9, (double)var10, (double)(var5 + var11), (double)(0.0F + var12));
      var2.func_78381_a();
      GlStateManager.func_179121_F();
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.func_179084_k();
   }

   private void func_78442_d(float p_78442_1_) {
      Tessellator var2 = Tessellator.func_178181_a();
      WorldRenderer var3 = var2.func_178180_c();
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 0.9F);
      GlStateManager.func_179143_c(519);
      GlStateManager.func_179132_a(false);
      GlStateManager.func_179147_l();
      GlStateManager.func_179120_a(770, 771, 1, 0);
      float var4 = 1.0F;

      for(int var5 = 0; var5 < 2; ++var5) {
         GlStateManager.func_179094_E();
         TextureAtlasSprite var6 = this.field_78455_a.func_147117_R().func_110572_b("minecraft:blocks/fire_layer_1");
         this.field_78455_a.func_110434_K().func_110577_a(TextureMap.field_110575_b);
         float var7 = var6.func_94209_e();
         float var8 = var6.func_94212_f();
         float var9 = var6.func_94206_g();
         float var10 = var6.func_94210_h();
         float var11 = (0.0F - var4) / 2.0F;
         float var12 = var11 + var4;
         float var13 = 0.0F - var4 / 2.0F;
         float var14 = var13 + var4;
         float var15 = -0.5F;
         GlStateManager.func_179109_b((float)(-(var5 * 2 - 1)) * 0.24F, -0.3F, 0.0F);
         GlStateManager.func_179114_b((float)(var5 * 2 - 1) * 10.0F, 0.0F, 1.0F, 0.0F);
         var3.func_178970_b();
         var3.func_178985_a((double)var11, (double)var13, (double)var15, (double)var8, (double)var10);
         var3.func_178985_a((double)var12, (double)var13, (double)var15, (double)var7, (double)var10);
         var3.func_178985_a((double)var12, (double)var14, (double)var15, (double)var7, (double)var9);
         var3.func_178985_a((double)var11, (double)var14, (double)var15, (double)var8, (double)var9);
         var2.func_78381_a();
         GlStateManager.func_179121_F();
      }

      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.func_179084_k();
      GlStateManager.func_179132_a(true);
      GlStateManager.func_179143_c(515);
   }

   public void func_78441_a() {
      this.field_78451_d = this.field_78454_c;
      EntityPlayerSP var1 = this.field_78455_a.field_71439_g;
      ItemStack var2 = var1.field_71071_by.func_70448_g();
      boolean var3 = false;
      if(this.field_78453_b != null && var2 != null) {
         if(!this.field_78453_b.func_179549_c(var2)) {
            var3 = true;
         }
      } else if(this.field_78453_b == null && var2 == null) {
         var3 = false;
      } else {
         var3 = true;
      }

      float var4 = 0.4F;
      float var5 = var3?0.0F:1.0F;
      float var6 = MathHelper.func_76131_a(var5 - this.field_78454_c, -var4, var4);
      this.field_78454_c += var6;
      if(this.field_78454_c < 0.1F) {
         this.field_78453_b = var2;
         this.field_78450_g = var1.field_71071_by.field_70461_c;
      }

   }

   public void func_78444_b() {
      this.field_78454_c = 0.0F;
   }

   public void func_78445_c() {
      this.field_78454_c = 0.0F;
   }


   // $FF: synthetic class
   static final class SwitchEnumAction {

      // $FF: synthetic field
      static final int[] field_178094_a = new int[EnumAction.values().length];
      private static final String __OBFID = "CL_00002537";


      static {
         try {
            field_178094_a[EnumAction.NONE.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            field_178094_a[EnumAction.EAT.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_178094_a[EnumAction.DRINK.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_178094_a[EnumAction.BLOCK.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_178094_a[EnumAction.BOW.ordinal()] = 5;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
