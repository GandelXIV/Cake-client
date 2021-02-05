package net.minecraft.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class EntityPickupFX extends EntityFX {

   private Entity field_174840_a;
   private Entity field_174843_ax;
   private int field_70594_ar;
   private int field_70593_as;
   private float field_174841_aA;
   private RenderManager field_174842_aB = Minecraft.func_71410_x().func_175598_ae();
   private static final String __OBFID = "CL_00000930";


   public EntityPickupFX(World p_i1233_1_, Entity p_i1233_2_, Entity p_i1233_3_, float p_i1233_4_) {
      super(p_i1233_1_, p_i1233_2_.field_70165_t, p_i1233_2_.field_70163_u, p_i1233_2_.field_70161_v, p_i1233_2_.field_70159_w, p_i1233_2_.field_70181_x, p_i1233_2_.field_70179_y);
      this.field_174840_a = p_i1233_2_;
      this.field_174843_ax = p_i1233_3_;
      this.field_70593_as = 3;
      this.field_174841_aA = p_i1233_4_;
   }

   public void func_180434_a(WorldRenderer p_180434_1_, Entity p_180434_2_, float p_180434_3_, float p_180434_4_, float p_180434_5_, float p_180434_6_, float p_180434_7_, float p_180434_8_) {
      float var9 = ((float)this.field_70594_ar + p_180434_3_) / (float)this.field_70593_as;
      var9 *= var9;
      double var10 = this.field_174840_a.field_70165_t;
      double var12 = this.field_174840_a.field_70163_u;
      double var14 = this.field_174840_a.field_70161_v;
      double var16 = this.field_174843_ax.field_70142_S + (this.field_174843_ax.field_70165_t - this.field_174843_ax.field_70142_S) * (double)p_180434_3_;
      double var18 = this.field_174843_ax.field_70137_T + (this.field_174843_ax.field_70163_u - this.field_174843_ax.field_70137_T) * (double)p_180434_3_ + (double)this.field_174841_aA;
      double var20 = this.field_174843_ax.field_70136_U + (this.field_174843_ax.field_70161_v - this.field_174843_ax.field_70136_U) * (double)p_180434_3_;
      double var22 = var10 + (var16 - var10) * (double)var9;
      double var24 = var12 + (var18 - var12) * (double)var9;
      double var26 = var14 + (var20 - var14) * (double)var9;
      int var28 = this.func_70070_b(p_180434_3_);
      int var29 = var28 % 65536;
      int var30 = var28 / 65536;
      OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)var29 / 1.0F, (float)var30 / 1.0F);
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      var22 -= field_70556_an;
      var24 -= field_70554_ao;
      var26 -= field_70555_ap;
      this.field_174842_aB.func_147940_a(this.field_174840_a, (double)((float)var22), (double)((float)var24), (double)((float)var26), this.field_174840_a.field_70177_z, p_180434_3_);
   }

   public void func_70071_h_() {
      ++this.field_70594_ar;
      if(this.field_70594_ar == this.field_70593_as) {
         this.func_70106_y();
      }

   }

   public int func_70537_b() {
      return 3;
   }
}
