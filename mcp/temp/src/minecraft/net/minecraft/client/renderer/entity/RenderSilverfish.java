package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelSilverfish;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.util.ResourceLocation;

public class RenderSilverfish extends RenderLiving {

   private static final ResourceLocation field_110882_a = new ResourceLocation("textures/entity/silverfish.png");
   private static final String __OBFID = "CL_00001022";


   public RenderSilverfish(RenderManager p_i46144_1_) {
      super(p_i46144_1_, new ModelSilverfish(), 0.3F);
   }

   protected float func_180584_a(EntitySilverfish p_180584_1_) {
      return 180.0F;
   }

   protected ResourceLocation func_110775_a(EntitySilverfish p_110775_1_) {
      return field_110882_a;
   }

   // $FF: synthetic method
   protected float func_77037_a(EntityLivingBase p_77037_1_) {
      return this.func_180584_a((EntitySilverfish)p_77037_1_);
   }

   // $FF: synthetic method
   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
      return this.func_110775_a((EntitySilverfish)p_110775_1_);
   }

}
