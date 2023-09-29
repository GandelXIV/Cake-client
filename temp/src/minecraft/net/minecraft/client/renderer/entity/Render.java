package net.minecraft.client.renderer.entity;

import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public abstract class Render {

   private static final ResourceLocation field_110778_a = new ResourceLocation("textures/misc/shadow.png");
   protected final RenderManager field_76990_c;
   protected float field_76989_e;
   protected float field_76987_f = 1.0F;
   private static final String __OBFID = "CL_00000992";


   protected Render(RenderManager p_i46179_1_) {
      this.field_76990_c = p_i46179_1_;
   }

   public boolean func_177071_a(Entity p_177071_1_, ICamera p_177071_2_, double p_177071_3_, double p_177071_5_, double p_177071_7_) {
      return p_177071_1_.func_145770_h(p_177071_3_, p_177071_5_, p_177071_7_) && (p_177071_1_.field_70158_ak || p_177071_2_.func_78546_a(p_177071_1_.func_174813_aQ()));
   }

   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_177067_a(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_);
   }

   protected void func_177067_a(Entity p_177067_1_, double p_177067_2_, double p_177067_4_, double p_177067_6_) {
      if(this.func_177070_b(p_177067_1_)) {
         this.func_147906_a(p_177067_1_, p_177067_1_.func_145748_c_().func_150254_d(), p_177067_2_, p_177067_4_, p_177067_6_, 64);
      }
   }

   protected boolean func_177070_b(Entity p_177070_1_) {
      return p_177070_1_.func_94059_bO() && p_177070_1_.func_145818_k_();
   }

   protected void func_177069_a(Entity p_177069_1_, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
      this.func_147906_a(p_177069_1_, p_177069_8_, p_177069_2_, p_177069_4_, p_177069_6_, 64);
   }

   protected abstract ResourceLocation func_110775_a(Entity var1);

   protected boolean func_180548_c(Entity p_180548_1_) {
      ResourceLocation var2 = this.func_110775_a(p_180548_1_);
      if(var2 == null) {
         return false;
      } else {
         this.func_110776_a(var2);
         return true;
      }
   }

   public void func_110776_a(ResourceLocation p_110776_1_) {
      this.field_76990_c.field_78724_e.func_110577_a(p_110776_1_);
   }

   private void func_76977_a(Entity p_76977_1_, double p_76977_2_, double p_76977_4_, double p_76977_6_, float p_76977_8_) {
      GlStateManager.func_179140_f();
      TextureMap var9 = Minecraft.func_71410_x().func_147117_R();
      TextureAtlasSprite var10 = var9.func_110572_b("minecraft:blocks/fire_layer_0");
      TextureAtlasSprite var11 = var9.func_110572_b("minecraft:blocks/fire_layer_1");
      GlStateManager.func_179094_E();
      GlStateManager.func_179109_b((float)p_76977_2_, (float)p_76977_4_, (float)p_76977_6_);
      float var12 = p_76977_1_.field_70130_N * 1.4F;
      GlStateManager.func_179152_a(var12, var12, var12);
      Tessellator var13 = Tessellator.func_178181_a();
      WorldRenderer var14 = var13.func_178180_c();
      float var15 = 0.5F;
      float var16 = 0.0F;
      float var17 = p_76977_1_.field_70131_O / var12;
      float var18 = (float)(p_76977_1_.field_70163_u - p_76977_1_.func_174813_aQ().field_72338_b);
      GlStateManager.func_179114_b(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179109_b(0.0F, 0.0F, -0.3F + (float)((int)var17) * 0.02F);
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      float var19 = 0.0F;
      int var20 = 0;
      var14.func_178970_b();

      while(var17 > 0.0F) {
         TextureAtlasSprite var21 = var20 % 2 == 0?var10:var11;
         this.func_110776_a(TextureMap.field_110575_b);
         float var22 = var21.func_94209_e();
         float var23 = var21.func_94206_g();
         float var24 = var21.func_94212_f();
         float var25 = var21.func_94210_h();
         if(var20 / 2 % 2 == 0) {
            float var26 = var24;
            var24 = var22;
            var22 = var26;
         }

         var14.func_178985_a((double)(var15 - var16), (double)(0.0F - var18), (double)var19, (double)var24, (double)var25);
         var14.func_178985_a((double)(-var15 - var16), (double)(0.0F - var18), (double)var19, (double)var22, (double)var25);
         var14.func_178985_a((double)(-var15 - var16), (double)(1.4F - var18), (double)var19, (double)var22, (double)var23);
         var14.func_178985_a((double)(var15 - var16), (double)(1.4F - var18), (double)var19, (double)var24, (double)var23);
         var17 -= 0.45F;
         var18 -= 0.45F;
         var15 *= 0.9F;
         var19 += 0.03F;
         ++var20;
      }

      var13.func_78381_a();
      GlStateManager.func_179121_F();
      GlStateManager.func_179145_e();
   }

   private void func_76975_c(Entity p_76975_1_, double p_76975_2_, double p_76975_4_, double p_76975_6_, float p_76975_8_, float p_76975_9_) {
      GlStateManager.func_179147_l();
      GlStateManager.func_179112_b(770, 771);
      this.field_76990_c.field_78724_e.func_110577_a(field_110778_a);
      World var10 = this.func_76982_b();
      GlStateManager.func_179132_a(false);
      float var11 = this.field_76989_e;
      if(p_76975_1_ instanceof EntityLiving) {
         EntityLiving var12 = (EntityLiving)p_76975_1_;
         var11 *= var12.func_70603_bj();
         if(var12.func_70631_g_()) {
            var11 *= 0.5F;
         }
      }

      double var35 = p_76975_1_.field_70142_S + (p_76975_1_.field_70165_t - p_76975_1_.field_70142_S) * (double)p_76975_9_;
      double var14 = p_76975_1_.field_70137_T + (p_76975_1_.field_70163_u - p_76975_1_.field_70137_T) * (double)p_76975_9_;
      double var16 = p_76975_1_.field_70136_U + (p_76975_1_.field_70161_v - p_76975_1_.field_70136_U) * (double)p_76975_9_;
      int var18 = MathHelper.func_76128_c(var35 - (double)var11);
      int var19 = MathHelper.func_76128_c(var35 + (double)var11);
      int var20 = MathHelper.func_76128_c(var14 - (double)var11);
      int var21 = MathHelper.func_76128_c(var14);
      int var22 = MathHelper.func_76128_c(var16 - (double)var11);
      int var23 = MathHelper.func_76128_c(var16 + (double)var11);
      double var24 = p_76975_2_ - var35;
      double var26 = p_76975_4_ - var14;
      double var28 = p_76975_6_ - var16;
      Tessellator var30 = Tessellator.func_178181_a();
      WorldRenderer var31 = var30.func_178180_c();
      var31.func_178970_b();
      Iterator var32 = BlockPos.func_177980_a(new BlockPos(var18, var20, var22), new BlockPos(var19, var21, var23)).iterator();

      while(var32.hasNext()) {
         BlockPos var33 = (BlockPos)var32.next();
         Block var34 = var10.func_180495_p(var33.func_177977_b()).func_177230_c();
         if(var34.func_149645_b() != -1 && var10.func_175671_l(var33) > 3) {
            this.func_180549_a(var34, p_76975_2_, p_76975_4_, p_76975_6_, var33, p_76975_8_, var11, var24, var26, var28);
         }
      }

      var30.func_78381_a();
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.func_179084_k();
      GlStateManager.func_179132_a(true);
   }

   private World func_76982_b() {
      return this.field_76990_c.field_78722_g;
   }

   private void func_180549_a(Block p_180549_1_, double p_180549_2_, double p_180549_4_, double p_180549_6_, BlockPos p_180549_8_, float p_180549_9_, float p_180549_10_, double p_180549_11_, double p_180549_13_, double p_180549_15_) {
      if(p_180549_1_.func_149686_d()) {
         Tessellator var17 = Tessellator.func_178181_a();
         WorldRenderer var18 = var17.func_178180_c();
         double var19 = ((double)p_180549_9_ - (p_180549_4_ - ((double)p_180549_8_.func_177956_o() + p_180549_13_)) / 2.0D) * 0.5D * (double)this.func_76982_b().func_175724_o(p_180549_8_);
         if(var19 >= 0.0D) {
            if(var19 > 1.0D) {
               var19 = 1.0D;
            }

            var18.func_178960_a(1.0F, 1.0F, 1.0F, (float)var19);
            double var21 = (double)p_180549_8_.func_177958_n() + p_180549_1_.func_149704_x() + p_180549_11_;
            double var23 = (double)p_180549_8_.func_177958_n() + p_180549_1_.func_149753_y() + p_180549_11_;
            double var25 = (double)p_180549_8_.func_177956_o() + p_180549_1_.func_149665_z() + p_180549_13_ + 0.015625D;
            double var27 = (double)p_180549_8_.func_177952_p() + p_180549_1_.func_149706_B() + p_180549_15_;
            double var29 = (double)p_180549_8_.func_177952_p() + p_180549_1_.func_149693_C() + p_180549_15_;
            float var31 = (float)((p_180549_2_ - var21) / 2.0D / (double)p_180549_10_ + 0.5D);
            float var32 = (float)((p_180549_2_ - var23) / 2.0D / (double)p_180549_10_ + 0.5D);
            float var33 = (float)((p_180549_6_ - var27) / 2.0D / (double)p_180549_10_ + 0.5D);
            float var34 = (float)((p_180549_6_ - var29) / 2.0D / (double)p_180549_10_ + 0.5D);
            var18.func_178985_a(var21, var25, var27, (double)var31, (double)var33);
            var18.func_178985_a(var21, var25, var29, (double)var31, (double)var34);
            var18.func_178985_a(var23, var25, var29, (double)var32, (double)var34);
            var18.func_178985_a(var23, var25, var27, (double)var32, (double)var33);
         }
      }
   }

   public static void func_76978_a(AxisAlignedBB p_76978_0_, double p_76978_1_, double p_76978_3_, double p_76978_5_) {
      GlStateManager.func_179090_x();
      Tessellator var7 = Tessellator.func_178181_a();
      WorldRenderer var8 = var7.func_178180_c();
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      var8.func_178970_b();
      var8.func_178969_c(p_76978_1_, p_76978_3_, p_76978_5_);
      var8.func_178980_d(0.0F, 0.0F, -1.0F);
      var8.func_178984_b(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
      var8.func_178984_b(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
      var8.func_178984_b(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
      var8.func_178984_b(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
      var8.func_178980_d(0.0F, 0.0F, 1.0F);
      var8.func_178984_b(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
      var8.func_178984_b(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
      var8.func_178984_b(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
      var8.func_178984_b(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
      var8.func_178980_d(0.0F, -1.0F, 0.0F);
      var8.func_178984_b(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
      var8.func_178984_b(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
      var8.func_178984_b(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
      var8.func_178984_b(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
      var8.func_178980_d(0.0F, 1.0F, 0.0F);
      var8.func_178984_b(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
      var8.func_178984_b(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
      var8.func_178984_b(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
      var8.func_178984_b(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
      var8.func_178980_d(-1.0F, 0.0F, 0.0F);
      var8.func_178984_b(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
      var8.func_178984_b(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
      var8.func_178984_b(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
      var8.func_178984_b(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
      var8.func_178980_d(1.0F, 0.0F, 0.0F);
      var8.func_178984_b(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
      var8.func_178984_b(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
      var8.func_178984_b(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
      var8.func_178984_b(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
      var8.func_178969_c(0.0D, 0.0D, 0.0D);
      var7.func_78381_a();
      GlStateManager.func_179098_w();
   }

   public void func_76979_b(Entity p_76979_1_, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_) {
      if(this.field_76990_c.field_78733_k != null) {
         if(this.field_76990_c.field_78733_k.field_74347_j && this.field_76989_e > 0.0F && !p_76979_1_.func_82150_aj() && this.field_76990_c.func_178627_a()) {
            double var10 = this.field_76990_c.func_78714_a(p_76979_1_.field_70165_t, p_76979_1_.field_70163_u, p_76979_1_.field_70161_v);
            float var12 = (float)((1.0D - var10 / 256.0D) * (double)this.field_76987_f);
            if(var12 > 0.0F) {
               this.func_76975_c(p_76979_1_, p_76979_2_, p_76979_4_, p_76979_6_, var12, p_76979_9_);
            }
         }

         if(p_76979_1_.func_90999_ad() && (!(p_76979_1_ instanceof EntityPlayer) || !((EntityPlayer)p_76979_1_).func_175149_v())) {
            this.func_76977_a(p_76979_1_, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_9_);
         }

      }
   }

   public FontRenderer func_76983_a() {
      return this.field_76990_c.func_78716_a();
   }

   protected void func_147906_a(Entity p_147906_1_, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
      double var10 = p_147906_1_.func_70068_e(this.field_76990_c.field_78734_h);
      if(var10 <= (double)(p_147906_9_ * p_147906_9_)) {
         FontRenderer var12 = this.func_76983_a();
         float var13 = 1.6F;
         float var14 = 0.016666668F * var13;
         GlStateManager.func_179094_E();
         GlStateManager.func_179109_b((float)p_147906_3_ + 0.0F, (float)p_147906_5_ + p_147906_1_.field_70131_O + 0.5F, (float)p_147906_7_);
         GL11.glNormal3f(0.0F, 1.0F, 0.0F);
         GlStateManager.func_179114_b(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
         GlStateManager.func_179114_b(this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
         GlStateManager.func_179152_a(-var14, -var14, var14);
         GlStateManager.func_179140_f();
         GlStateManager.func_179132_a(false);
         GlStateManager.func_179097_i();
         GlStateManager.func_179147_l();
         GlStateManager.func_179120_a(770, 771, 1, 0);
         Tessellator var15 = Tessellator.func_178181_a();
         WorldRenderer var16 = var15.func_178180_c();
         byte var17 = 0;
         if(p_147906_2_.equals("deadmau5")) {
            var17 = -10;
         }

         GlStateManager.func_179090_x();
         var16.func_178970_b();
         int var18 = var12.func_78256_a(p_147906_2_) / 2;
         var16.func_178960_a(0.0F, 0.0F, 0.0F, 0.25F);
         var16.func_178984_b((double)(-var18 - 1), (double)(-1 + var17), 0.0D);
         var16.func_178984_b((double)(-var18 - 1), (double)(8 + var17), 0.0D);
         var16.func_178984_b((double)(var18 + 1), (double)(8 + var17), 0.0D);
         var16.func_178984_b((double)(var18 + 1), (double)(-1 + var17), 0.0D);
         var15.func_78381_a();
         GlStateManager.func_179098_w();
         var12.func_78276_b(p_147906_2_, -var12.func_78256_a(p_147906_2_) / 2, var17, 553648127);
         GlStateManager.func_179126_j();
         GlStateManager.func_179132_a(true);
         var12.func_78276_b(p_147906_2_, -var12.func_78256_a(p_147906_2_) / 2, var17, -1);
         GlStateManager.func_179145_e();
         GlStateManager.func_179084_k();
         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.func_179121_F();
      }
   }

   public RenderManager func_177068_d() {
      return this.field_76990_c;
   }

}
