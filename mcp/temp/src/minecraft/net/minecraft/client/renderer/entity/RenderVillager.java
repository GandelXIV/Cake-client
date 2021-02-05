package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;

public class RenderVillager extends RenderLiving {

   private static final ResourceLocation field_110903_f = new ResourceLocation("textures/entity/villager/villager.png");
   private static final ResourceLocation field_110904_g = new ResourceLocation("textures/entity/villager/farmer.png");
   private static final ResourceLocation field_110908_h = new ResourceLocation("textures/entity/villager/librarian.png");
   private static final ResourceLocation field_110907_k = new ResourceLocation("textures/entity/villager/priest.png");
   private static final ResourceLocation field_110905_l = new ResourceLocation("textures/entity/villager/smith.png");
   private static final ResourceLocation field_110906_m = new ResourceLocation("textures/entity/villager/butcher.png");
   private static final String __OBFID = "CL_00001032";


   public RenderVillager(RenderManager p_i46132_1_) {
      super(p_i46132_1_, new ModelVillager(0.0F), 0.5F);
      this.func_177094_a(new LayerCustomHead(this.func_177134_g().field_78191_a));
   }

   public ModelVillager func_177134_g() {
      return (ModelVillager)super.func_177087_b();
   }

   protected ResourceLocation func_110775_a(EntityVillager p_110775_1_) {
      switch(p_110775_1_.func_70946_n()) {
      case 0:
         return field_110904_g;
      case 1:
         return field_110908_h;
      case 2:
         return field_110907_k;
      case 3:
         return field_110905_l;
      case 4:
         return field_110906_m;
      default:
         return field_110903_f;
      }
   }

   protected void func_77041_b(EntityVillager p_77041_1_, float p_77041_2_) {
      float var3 = 0.9375F;
      if(p_77041_1_.func_70874_b() < 0) {
         var3 = (float)((double)var3 * 0.5D);
         this.field_76989_e = 0.25F;
      } else {
         this.field_76989_e = 0.5F;
      }

      GlStateManager.func_179152_a(var3, var3, var3);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
      this.func_77041_b((EntityVillager)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   public ModelBase func_177087_b() {
      return this.func_177134_g();
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntityVillager)p_110775_1_);
   }

}
