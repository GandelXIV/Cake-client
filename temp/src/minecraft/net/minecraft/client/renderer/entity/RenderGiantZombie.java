package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.util.ResourceLocation;

public class RenderGiantZombie extends RenderLiving {

   private static final ResourceLocation field_110871_a = new ResourceLocation("textures/entity/zombie/zombie.png");
   private float field_77073_a;
   private static final String __OBFID = "CL_00000998";


   public RenderGiantZombie(RenderManager p_i46173_1_, ModelBase p_i46173_2_, float p_i46173_3_, float p_i46173_4_) {
      super(p_i46173_1_, p_i46173_2_, p_i46173_3_ * p_i46173_4_);
      this.field_77073_a = p_i46173_4_;
      this.func_177094_a(new LayerHeldItem(this));
      this.func_177094_a(new LayerBipedArmor(this) {

         private static final String __OBFID = "CL_00002444";

         protected void func_177177_a() {
            this.field_177189_c = new ModelZombie(0.5F, true);
            this.field_177186_d = new ModelZombie(1.0F, true);
         }
      });
   }

   public void func_82422_c() {
      GlStateManager.func_179109_b(0.0F, 0.1875F, 0.0F);
   }

   protected void func_77041_b(EntityGiantZombie p_77041_1_, float p_77041_2_) {
      GlStateManager.func_179152_a(this.field_77073_a, this.field_77073_a, this.field_77073_a);
   }

   protected ResourceLocation func_110775_a(EntityGiantZombie p_110775_1_) {
      return field_110871_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
      this.func_77041_b((EntityGiantZombie)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityGiantZombie)p_110775_1_);
   }

}
