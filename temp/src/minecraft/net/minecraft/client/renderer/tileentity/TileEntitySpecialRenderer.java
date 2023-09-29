package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public abstract class TileEntitySpecialRenderer {

   protected static final ResourceLocation[] field_178460_a = new ResourceLocation[]{new ResourceLocation("textures/blocks/destroy_stage_0.png"), new ResourceLocation("textures/blocks/destroy_stage_1.png"), new ResourceLocation("textures/blocks/destroy_stage_2.png"), new ResourceLocation("textures/blocks/destroy_stage_3.png"), new ResourceLocation("textures/blocks/destroy_stage_4.png"), new ResourceLocation("textures/blocks/destroy_stage_5.png"), new ResourceLocation("textures/blocks/destroy_stage_6.png"), new ResourceLocation("textures/blocks/destroy_stage_7.png"), new ResourceLocation("textures/blocks/destroy_stage_8.png"), new ResourceLocation("textures/blocks/destroy_stage_9.png")};
   protected TileEntityRendererDispatcher field_147501_a;
   private static final String __OBFID = "CL_00000964";


   public abstract void func_180535_a(TileEntity var1, double var2, double var4, double var6, float var8, int var9);

   protected void func_147499_a(ResourceLocation p_147499_1_) {
      TextureManager var2 = this.field_147501_a.field_147553_e;
      if(var2 != null) {
         var2.func_110577_a(p_147499_1_);
      }

   }

   protected World func_178459_a() {
      return this.field_147501_a.field_147550_f;
   }

   public void func_147497_a(TileEntityRendererDispatcher p_147497_1_) {
      this.field_147501_a = p_147497_1_;
   }

   public FontRenderer func_147498_b() {
      return this.field_147501_a.func_147548_a();
   }

}
