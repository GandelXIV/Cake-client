package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelArmorStand;
import net.minecraft.client.model.ModelArmorStandArmor;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.util.ResourceLocation;

public class ArmorStandRenderer extends RendererLivingEntity {

   public static final ResourceLocation field_177103_a = new ResourceLocation("textures/entity/armorstand/wood.png");
   private static final String __OBFID = "CL_00002447";


   public ArmorStandRenderer(RenderManager p_i46195_1_) {
      super(p_i46195_1_, new ModelArmorStand(), 0.0F);
      LayerBipedArmor var2 = new LayerBipedArmor(this) {

         private static final String __OBFID = "CL_00002446";

         protected void func_177177_a() {
            this.field_177189_c = new ModelArmorStandArmor(0.5F);
            this.field_177186_d = new ModelArmorStandArmor(1.0F);
         }
      };
      this.func_177094_a(var2);
      this.func_177094_a(new LayerHeldItem(this));
      this.func_177094_a(new LayerCustomHead(this.func_177100_a().field_78116_c));
   }

   protected ResourceLocation func_177102_a(EntityArmorStand p_177102_1_) {
      return field_177103_a;
   }

   public ModelArmorStand func_177100_a() {
      return (ModelArmorStand)super.func_177087_b();
   }

   protected void func_177101_a(EntityArmorStand p_177101_1_, float p_177101_2_, float p_177101_3_, float p_177101_4_) {
      GlStateManager.func_179114_b(180.0F - p_177101_3_, 0.0F, 1.0F, 0.0F);
   }

   protected boolean func_177099_b(EntityArmorStand p_177099_1_) {
      return p_177099_1_.func_174833_aM();
   }

   // $FF: synthetic method
   protected boolean func_110813_b(EntityLivingBase p_110813_1_) {
      return this.func_177099_b((EntityArmorStand)p_110813_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77043_a(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
      this.func_177101_a((EntityArmorStand)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
   }

   // $FF: synthetic method
   public ModelBase func_177087_b() {
      return this.func_177100_a();
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_177102_a((EntityArmorStand)p_110775_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected boolean func_177070_b(Entity p_177070_1_) {
      return this.func_177099_b((EntityArmorStand)p_177070_1_);
   }

}
