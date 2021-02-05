package net.minecraft.client.renderer.entity;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.entity.layers.LayerArrow;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerCape;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.client.renderer.entity.layers.LayerDeadmau5Head;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.ResourceLocation;

public class RenderPlayer extends RendererLivingEntity {

   private boolean field_177140_a;
   private static final String __OBFID = "CL_00001020";


   public RenderPlayer(RenderManager p_i46102_1_) {
      this(p_i46102_1_, false);
   }

   public RenderPlayer(RenderManager p_i46103_1_, boolean p_i46103_2_) {
      super(p_i46103_1_, new ModelPlayer(0.0F, p_i46103_2_), 0.5F);
      this.field_177140_a = p_i46103_2_;
      this.func_177094_a(new LayerBipedArmor(this));
      this.func_177094_a(new LayerHeldItem(this));
      this.func_177094_a(new LayerArrow(this));
      this.func_177094_a(new LayerDeadmau5Head(this));
      this.func_177094_a(new LayerCape(this));
      this.func_177094_a(new LayerCustomHead(this.func_177136_g().field_78116_c));
   }

   public ModelPlayer func_177136_g() {
      return (ModelPlayer)super.func_177087_b();
   }

   public void func_180596_a(AbstractClientPlayer p_180596_1_, double p_180596_2_, double p_180596_4_, double p_180596_6_, float p_180596_8_, float p_180596_9_) {
      if(!p_180596_1_.func_175144_cb() || this.field_76990_c.field_78734_h == p_180596_1_) {
         double var10 = p_180596_4_;
         if(p_180596_1_.func_70093_af() && !(p_180596_1_ instanceof EntityPlayerSP)) {
            var10 = p_180596_4_ - 0.125D;
         }

         this.func_177137_d(p_180596_1_);
         super.func_76986_a((EntityLivingBase)p_180596_1_, p_180596_2_, var10, p_180596_6_, p_180596_8_, p_180596_9_);
      }
   }

   private void func_177137_d(AbstractClientPlayer p_177137_1_) {
      ModelPlayer var2 = this.func_177136_g();
      if(p_177137_1_.func_175149_v()) {
         var2.func_178719_a(false);
         var2.field_78116_c.field_78806_j = true;
         var2.field_178720_f.field_78806_j = true;
      } else {
         ItemStack var3 = p_177137_1_.field_71071_by.func_70448_g();
         var2.func_178719_a(true);
         var2.field_178720_f.field_78806_j = p_177137_1_.func_175148_a(EnumPlayerModelParts.HAT);
         var2.field_178730_v.field_78806_j = p_177137_1_.func_175148_a(EnumPlayerModelParts.JACKET);
         var2.field_178733_c.field_78806_j = p_177137_1_.func_175148_a(EnumPlayerModelParts.LEFT_PANTS_LEG);
         var2.field_178731_d.field_78806_j = p_177137_1_.func_175148_a(EnumPlayerModelParts.RIGHT_PANTS_LEG);
         var2.field_178734_a.field_78806_j = p_177137_1_.func_175148_a(EnumPlayerModelParts.LEFT_SLEEVE);
         var2.field_178732_b.field_78806_j = p_177137_1_.func_175148_a(EnumPlayerModelParts.RIGHT_SLEEVE);
         var2.field_78119_l = 0;
         var2.field_78118_o = false;
         var2.field_78117_n = p_177137_1_.func_70093_af();
         if(var3 == null) {
            var2.field_78120_m = 0;
         } else {
            var2.field_78120_m = 1;
            if(p_177137_1_.func_71052_bv() > 0) {
               EnumAction var4 = var3.func_77975_n();
               if(var4 == EnumAction.BLOCK) {
                  var2.field_78120_m = 3;
               } else if(var4 == EnumAction.BOW) {
                  var2.field_78118_o = true;
               }
            }
         }
      }

   }

   protected ResourceLocation func_180594_a(AbstractClientPlayer p_180594_1_) {
      return p_180594_1_.func_110306_p();
   }

   public void func_82422_c() {
      GlStateManager.func_179109_b(0.0F, 0.1875F, 0.0F);
   }

   protected void func_77041_b(AbstractClientPlayer p_77041_1_, float p_77041_2_) {
      float var3 = 0.9375F;
      GlStateManager.func_179152_a(var3, var3, var3);
   }

   protected void func_96449_a(AbstractClientPlayer p_96449_1_, double p_96449_2_, double p_96449_4_, double p_96449_6_, String p_96449_8_, float p_96449_9_, double p_96449_10_) {
      if(p_96449_10_ < 100.0D) {
         Scoreboard var12 = p_96449_1_.func_96123_co();
         ScoreObjective var13 = var12.func_96539_a(2);
         if(var13 != null) {
            Score var14 = var12.func_96529_a(p_96449_1_.func_70005_c_(), var13);
            this.func_147906_a(p_96449_1_, var14.func_96652_c() + " " + var13.func_96678_d(), p_96449_2_, p_96449_4_, p_96449_6_, 64);
            p_96449_4_ += (double)((float)this.func_76983_a().field_78288_b * 1.15F * p_96449_9_);
         }
      }

      super.func_177069_a(p_96449_1_, p_96449_2_, p_96449_4_, p_96449_6_, p_96449_8_, p_96449_9_, p_96449_10_);
   }

   public void func_177138_b(AbstractClientPlayer p_177138_1_) {
      float var2 = 1.0F;
      GlStateManager.func_179124_c(var2, var2, var2);
      ModelPlayer var3 = this.func_177136_g();
      this.func_177137_d(p_177138_1_);
      var3.field_78095_p = 0.0F;
      var3.field_78117_n = false;
      var3.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, p_177138_1_);
      var3.func_178725_a();
   }

   public void func_177139_c(AbstractClientPlayer p_177139_1_) {
      float var2 = 1.0F;
      GlStateManager.func_179124_c(var2, var2, var2);
      ModelPlayer var3 = this.func_177136_g();
      this.func_177137_d(p_177139_1_);
      var3.field_78117_n = false;
      var3.field_78095_p = 0.0F;
      var3.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, p_177139_1_);
      var3.func_178726_b();
   }

   protected void func_77039_a(AbstractClientPlayer p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
      if(p_77039_1_.func_70089_S() && p_77039_1_.func_70608_bn()) {
         super.func_77039_a(p_77039_1_, p_77039_2_ + (double)p_77039_1_.field_71079_bU, p_77039_4_ + (double)p_77039_1_.field_71082_cx, p_77039_6_ + (double)p_77039_1_.field_71089_bV);
      } else {
         super.func_77039_a(p_77039_1_, p_77039_2_, p_77039_4_, p_77039_6_);
      }

   }

   protected void func_180595_a(AbstractClientPlayer p_180595_1_, float p_180595_2_, float p_180595_3_, float p_180595_4_) {
      if(p_180595_1_.func_70089_S() && p_180595_1_.func_70608_bn()) {
         GlStateManager.func_179114_b(p_180595_1_.func_71051_bG(), 0.0F, 1.0F, 0.0F);
         GlStateManager.func_179114_b(this.func_77037_a(p_180595_1_), 0.0F, 0.0F, 1.0F);
         GlStateManager.func_179114_b(270.0F, 0.0F, 1.0F, 0.0F);
      } else {
         super.func_77043_a(p_180595_1_, p_180595_2_, p_180595_3_, p_180595_4_);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
      this.func_77041_b((AbstractClientPlayer)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77043_a(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
      this.func_180595_a((AbstractClientPlayer)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77039_a(EntityLivingBase p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
      this.func_77039_a((AbstractClientPlayer)p_77039_1_, p_77039_2_, p_77039_4_, p_77039_6_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_180596_a((AbstractClientPlayer)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   // $FF: synthetic method
   public ModelBase func_177087_b() {
      return this.func_177136_g();
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_180594_a((AbstractClientPlayer)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_177069_a(Entity p_177069_1_, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
      this.func_96449_a((AbstractClientPlayer)p_177069_1_, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_9_, p_177069_10_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_180596_a((AbstractClientPlayer)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
