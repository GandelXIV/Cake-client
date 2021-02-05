package net.minecraft.client.renderer.entity;

import java.util.Random;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderEntityItem extends Render {

   private final RenderItem field_177080_a;
   private Random field_177079_e = new Random();
   private static final String __OBFID = "CL_00002442";


   public RenderEntityItem(RenderManager p_i46167_1_, RenderItem p_i46167_2_) {
      super(p_i46167_1_);
      this.field_177080_a = p_i46167_2_;
      this.field_76989_e = 0.15F;
      this.field_76987_f = 0.75F;
   }

   private int func_177077_a(EntityItem p_177077_1_, double p_177077_2_, double p_177077_4_, double p_177077_6_, float p_177077_8_, IBakedModel p_177077_9_) {
      ItemStack var10 = p_177077_1_.func_92059_d();
      Item var11 = var10.func_77973_b();
      if(var11 == null) {
         return 0;
      } else {
         boolean var12 = p_177077_9_.func_177556_c();
         int var13 = this.func_177078_a(var10);
         float var14 = 0.25F;
         float var15 = MathHelper.func_76126_a(((float)p_177077_1_.func_174872_o() + p_177077_8_) / 10.0F + p_177077_1_.field_70290_d) * 0.1F + 0.1F;
         GlStateManager.func_179109_b((float)p_177077_2_, (float)p_177077_4_ + var15 + 0.25F, (float)p_177077_6_);
         float var16;
         if(var12 || this.field_76990_c.field_78733_k != null && this.field_76990_c.field_78733_k.field_74347_j) {
            var16 = (((float)p_177077_1_.func_174872_o() + p_177077_8_) / 20.0F + p_177077_1_.field_70290_d) * 57.295776F;
            GlStateManager.func_179114_b(var16, 0.0F, 1.0F, 0.0F);
         }

         if(!var12) {
            var16 = -0.0F * (float)(var13 - 1) * 0.5F;
            float var17 = -0.0F * (float)(var13 - 1) * 0.5F;
            float var18 = -0.046875F * (float)(var13 - 1) * 0.5F;
            GlStateManager.func_179109_b(var16, var17, var18);
         }

         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
         return var13;
      }
   }

   private int func_177078_a(ItemStack p_177078_1_) {
      byte var2 = 1;
      if(p_177078_1_.field_77994_a > 48) {
         var2 = 5;
      } else if(p_177078_1_.field_77994_a > 32) {
         var2 = 4;
      } else if(p_177078_1_.field_77994_a > 16) {
         var2 = 3;
      } else if(p_177078_1_.field_77994_a > 1) {
         var2 = 2;
      }

      return var2;
   }

   public void func_177075_a(EntityItem p_177075_1_, double p_177075_2_, double p_177075_4_, double p_177075_6_, float p_177075_8_, float p_177075_9_) {
      ItemStack var10 = p_177075_1_.func_92059_d();
      this.field_177079_e.setSeed(187L);
      boolean var11 = false;
      if(this.func_180548_c(p_177075_1_)) {
         this.field_76990_c.field_78724_e.func_110581_b(this.func_177076_a(p_177075_1_)).func_174936_b(false, false);
         var11 = true;
      }

      GlStateManager.func_179091_B();
      GlStateManager.func_179092_a(516, 0.1F);
      GlStateManager.func_179147_l();
      GlStateManager.func_179120_a(770, 771, 1, 0);
      GlStateManager.func_179094_E();
      IBakedModel var12 = this.field_177080_a.func_175037_a().func_178089_a(var10);
      int var13 = this.func_177077_a(p_177075_1_, p_177075_2_, p_177075_4_, p_177075_6_, p_177075_9_, var12);

      for(int var14 = 0; var14 < var13; ++var14) {
         if(var12.func_177556_c()) {
            GlStateManager.func_179094_E();
            if(var14 > 0) {
               float var15 = (this.field_177079_e.nextFloat() * 2.0F - 1.0F) * 0.15F;
               float var16 = (this.field_177079_e.nextFloat() * 2.0F - 1.0F) * 0.15F;
               float var17 = (this.field_177079_e.nextFloat() * 2.0F - 1.0F) * 0.15F;
               GlStateManager.func_179109_b(var15, var16, var17);
            }

            GlStateManager.func_179152_a(0.5F, 0.5F, 0.5F);
            this.field_177080_a.func_180454_a(var10, var12);
            GlStateManager.func_179121_F();
         } else {
            this.field_177080_a.func_180454_a(var10, var12);
            GlStateManager.func_179109_b(0.0F, 0.0F, 0.046875F);
         }
      }

      GlStateManager.func_179121_F();
      GlStateManager.func_179101_C();
      GlStateManager.func_179084_k();
      this.func_180548_c(p_177075_1_);
      if(var11) {
         this.field_76990_c.field_78724_e.func_110581_b(this.func_177076_a(p_177075_1_)).func_174935_a();
      }

      super.func_76986_a(p_177075_1_, p_177075_2_, p_177075_4_, p_177075_6_, p_177075_8_, p_177075_9_);
   }

   protected ResourceLocation func_177076_a(EntityItem p_177076_1_) {
      return TextureMap.field_110575_b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_177076_a((EntityItem)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_177075_a((EntityItem)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
