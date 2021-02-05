package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerCreeperCharge;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderCreeper extends RenderLiving {

   private static final ResourceLocation field_110830_f = new ResourceLocation("textures/entity/creeper/creeper.png");
   private static final String __OBFID = "CL_00000985";


   public RenderCreeper(RenderManager p_i46186_1_) {
      super(p_i46186_1_, new ModelCreeper(), 0.5F);
      this.func_177094_a(new LayerCreeperCharge(this));
   }

   protected void func_180570_a(EntityCreeper p_180570_1_, float p_180570_2_) {
      float var3 = p_180570_1_.func_70831_j(p_180570_2_);
      float var4 = 1.0F + MathHelper.func_76126_a(var3 * 100.0F) * var3 * 0.01F;
      var3 = MathHelper.func_76131_a(var3, 0.0F, 1.0F);
      var3 *= var3;
      var3 *= var3;
      float var5 = (1.0F + var3 * 0.4F) * var4;
      float var6 = (1.0F + var3 * 0.1F) / var4;
      GlStateManager.func_179152_a(var5, var6, var5);
   }

   protected int func_180571_a(EntityCreeper p_180571_1_, float p_180571_2_, float p_180571_3_) {
      float var4 = p_180571_1_.func_70831_j(p_180571_3_);
      if((int)(var4 * 10.0F) % 2 == 0) {
         return 0;
      } else {
         int var5 = (int)(var4 * 0.2F * 255.0F);
         var5 = MathHelper.func_76125_a(var5, 0, 255);
         return var5 << 24 | 16777215;
      }
   }

   protected ResourceLocation func_110775_a(EntityCreeper p_110775_1_) {
      return field_110830_f;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
      this.func_180570_a((EntityCreeper)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_77030_a(EntityLivingBase p_77030_1_, float p_77030_2_, float p_77030_3_) {
      return this.func_180571_a((EntityCreeper)p_77030_1_, p_77030_2_, p_77030_3_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityCreeper)p_110775_1_);
   }

}
