package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.ResourceLocation;

public class GuiStreamIndicator {

   private static final ResourceLocation field_152441_a = new ResourceLocation("textures/gui/stream_indicator.png");
   private final Minecraft field_152442_b;
   private float field_152443_c = 1.0F;
   private int field_152444_d = 1;
   private static final String __OBFID = "CL_00001849";


   public GuiStreamIndicator(Minecraft p_i46322_1_) {
      this.field_152442_b = p_i46322_1_;
   }

   public void func_152437_a(int p_152437_1_, int p_152437_2_) {
      if(this.field_152442_b.func_152346_Z().func_152934_n()) {
         GlStateManager.func_179147_l();
         int var3 = this.field_152442_b.func_152346_Z().func_152920_A();
         if(var3 > 0) {
            String var4 = "" + var3;
            int var5 = this.field_152442_b.field_71466_p.func_78256_a(var4);
            boolean var6 = true;
            int var7 = p_152437_1_ - var5 - 1;
            int var8 = p_152437_2_ + 20 - 1;
            int var10 = p_152437_2_ + 20 + this.field_152442_b.field_71466_p.field_78288_b - 1;
            GlStateManager.func_179090_x();
            Tessellator var11 = Tessellator.func_178181_a();
            WorldRenderer var12 = var11.func_178180_c();
            GlStateManager.func_179131_c(0.0F, 0.0F, 0.0F, (0.65F + 0.35000002F * this.field_152443_c) / 2.0F);
            var12.func_178970_b();
            var12.func_178984_b((double)var7, (double)var10, 0.0D);
            var12.func_178984_b((double)p_152437_1_, (double)var10, 0.0D);
            var12.func_178984_b((double)p_152437_1_, (double)var8, 0.0D);
            var12.func_178984_b((double)var7, (double)var8, 0.0D);
            var11.func_78381_a();
            GlStateManager.func_179098_w();
            this.field_152442_b.field_71466_p.func_78276_b(var4, p_152437_1_ - var5, p_152437_2_ + 20, 16777215);
         }

         this.func_152436_a(p_152437_1_, p_152437_2_, this.func_152440_b(), 0);
         this.func_152436_a(p_152437_1_, p_152437_2_, this.func_152438_c(), 17);
      }

   }

   private void func_152436_a(int p_152436_1_, int p_152436_2_, int p_152436_3_, int p_152436_4_) {
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 0.65F + 0.35000002F * this.field_152443_c);
      this.field_152442_b.func_110434_K().func_110577_a(field_152441_a);
      float var5 = 150.0F;
      float var6 = 0.0F;
      float var7 = (float)p_152436_3_ * 0.015625F;
      float var8 = 1.0F;
      float var9 = (float)(p_152436_3_ + 16) * 0.015625F;
      Tessellator var10 = Tessellator.func_178181_a();
      WorldRenderer var11 = var10.func_178180_c();
      var11.func_178970_b();
      var11.func_178985_a((double)(p_152436_1_ - 16 - p_152436_4_), (double)(p_152436_2_ + 16), (double)var5, (double)var6, (double)var9);
      var11.func_178985_a((double)(p_152436_1_ - p_152436_4_), (double)(p_152436_2_ + 16), (double)var5, (double)var8, (double)var9);
      var11.func_178985_a((double)(p_152436_1_ - p_152436_4_), (double)(p_152436_2_ + 0), (double)var5, (double)var8, (double)var7);
      var11.func_178985_a((double)(p_152436_1_ - 16 - p_152436_4_), (double)(p_152436_2_ + 0), (double)var5, (double)var6, (double)var7);
      var10.func_78381_a();
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private int func_152440_b() {
      return this.field_152442_b.func_152346_Z().func_152919_o()?16:0;
   }

   private int func_152438_c() {
      return this.field_152442_b.func_152346_Z().func_152929_G()?48:32;
   }

   public void func_152439_a() {
      if(this.field_152442_b.func_152346_Z().func_152934_n()) {
         this.field_152443_c += 0.025F * (float)this.field_152444_d;
         if(this.field_152443_c < 0.0F) {
            this.field_152444_d *= -1;
            this.field_152443_c = 0.0F;
         } else if(this.field_152443_c > 1.0F) {
            this.field_152444_d *= -1;
            this.field_152443_c = 1.0F;
         }
      } else {
         this.field_152443_c = 1.0F;
         this.field_152444_d = 1;
      }

   }

}
