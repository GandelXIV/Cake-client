package net.minecraft.client.gui;

import java.io.IOException;
import java.net.URI;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GuiScreenDemo extends GuiScreen {

   private static final Logger field_146349_a = LogManager.getLogger();
   private static final ResourceLocation field_146348_f = new ResourceLocation("textures/gui/demo_background.png");
   private static final String __OBFID = "CL_00000691";


   public void func_73866_w_() {
      this.field_146292_n.clear();
      byte var1 = -16;
      this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 116, this.field_146295_m / 2 + 62 + var1, 114, 20, I18n.func_135052_a("demo.help.buy", new Object[0])));
      this.field_146292_n.add(new GuiButton(2, this.field_146294_l / 2 + 2, this.field_146295_m / 2 + 62 + var1, 114, 20, I18n.func_135052_a("demo.help.later", new Object[0])));
   }

   protected void func_146284_a(GuiButton p_146284_1_) throws IOException {
      switch(p_146284_1_.field_146127_k) {
      case 1:
         p_146284_1_.field_146124_l = false;

         try {
            Class var2 = Class.forName("java.awt.Desktop");
            Object var3 = var2.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
            var2.getMethod("browse", new Class[]{URI.class}).invoke(var3, new Object[]{new URI("http://www.minecraft.net/store?source=demo")});
         } catch (Throwable var4) {
            field_146349_a.error("Couldn\'t open link", var4);
         }
         break;
      case 2:
         this.field_146297_k.func_147108_a((GuiScreen)null);
         this.field_146297_k.func_71381_h();
      }

   }

   public void func_73876_c() {
      super.func_73876_c();
   }

   public void func_146276_q_() {
      super.func_146276_q_();
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_146297_k.func_110434_K().func_110577_a(field_146348_f);
      int var1 = (this.field_146294_l - 248) / 2;
      int var2 = (this.field_146295_m - 166) / 2;
      this.func_73729_b(var1, var2, 0, 0, 248, 166);
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_146276_q_();
      int var4 = (this.field_146294_l - 248) / 2 + 10;
      int var5 = (this.field_146295_m - 166) / 2 + 8;
      this.field_146289_q.func_78276_b(I18n.func_135052_a("demo.help.title", new Object[0]), var4, var5, 2039583);
      var5 += 12;
      GameSettings var6 = this.field_146297_k.field_71474_y;
      this.field_146289_q.func_78276_b(I18n.func_135052_a("demo.help.movementShort", new Object[]{GameSettings.func_74298_c(var6.field_74351_w.func_151463_i()), GameSettings.func_74298_c(var6.field_74370_x.func_151463_i()), GameSettings.func_74298_c(var6.field_74368_y.func_151463_i()), GameSettings.func_74298_c(var6.field_74366_z.func_151463_i())}), var4, var5, 5197647);
      this.field_146289_q.func_78276_b(I18n.func_135052_a("demo.help.movementMouse", new Object[0]), var4, var5 + 12, 5197647);
      this.field_146289_q.func_78276_b(I18n.func_135052_a("demo.help.jump", new Object[]{GameSettings.func_74298_c(var6.field_74314_A.func_151463_i())}), var4, var5 + 24, 5197647);
      this.field_146289_q.func_78276_b(I18n.func_135052_a("demo.help.inventory", new Object[]{GameSettings.func_74298_c(var6.field_151445_Q.func_151463_i())}), var4, var5 + 36, 5197647);
      this.field_146289_q.func_78279_b(I18n.func_135052_a("demo.help.fullWrapped", new Object[0]), var4, var5 + 68, 218, 2039583);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

}
