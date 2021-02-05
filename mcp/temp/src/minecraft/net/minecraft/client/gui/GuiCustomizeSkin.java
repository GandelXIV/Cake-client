package net.minecraft.client.gui;

import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EnumPlayerModelParts;

public class GuiCustomizeSkin extends GuiScreen {

   private final GuiScreen field_175361_a;
   private String field_175360_f;
   private static final String __OBFID = "CL_00001932";


   public GuiCustomizeSkin(GuiScreen p_i45516_1_) {
      this.field_175361_a = p_i45516_1_;
   }

   public void func_73866_w_() {
      int var1 = 0;
      this.field_175360_f = I18n.func_135052_a("options.skinCustomisation.title", new Object[0]);
      EnumPlayerModelParts[] var2 = EnumPlayerModelParts.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         EnumPlayerModelParts var5 = var2[var4];
         this.field_146292_n.add(new GuiCustomizeSkin.ButtonPart(var5.func_179328_b(), this.field_146294_l / 2 - 155 + var1 % 2 * 160, this.field_146295_m / 6 + 24 * (var1 >> 1), 150, 20, var5, null));
         ++var1;
      }

      if(var1 % 2 == 1) {
         ++var1;
      }

      this.field_146292_n.add(new GuiButton(200, this.field_146294_l / 2 - 100, this.field_146295_m / 6 + 24 * (var1 >> 1), I18n.func_135052_a("gui.done", new Object[0])));
   }

   protected void func_146284_a(GuiButton p_146284_1_) throws IOException {
      if(p_146284_1_.field_146124_l) {
         if(p_146284_1_.field_146127_k == 200) {
            this.field_146297_k.field_71474_y.func_74303_b();
            this.field_146297_k.func_147108_a(this.field_175361_a);
         } else if(p_146284_1_ instanceof GuiCustomizeSkin.ButtonPart) {
            EnumPlayerModelParts var2 = ((GuiCustomizeSkin.ButtonPart)p_146284_1_).field_175234_p;
            this.field_146297_k.field_71474_y.func_178877_a(var2);
            p_146284_1_.field_146126_j = this.func_175358_a(var2);
         }

      }
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_146276_q_();
      this.func_73732_a(this.field_146289_q, this.field_175360_f, this.field_146294_l / 2, 20, 16777215);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   private String func_175358_a(EnumPlayerModelParts p_175358_1_) {
      String var2;
      if(this.field_146297_k.field_71474_y.func_178876_d().contains(p_175358_1_)) {
         var2 = I18n.func_135052_a("options.on", new Object[0]);
      } else {
         var2 = I18n.func_135052_a("options.off", new Object[0]);
      }

      return p_175358_1_.func_179326_d().func_150254_d() + ": " + var2;
   }

   class ButtonPart extends GuiButton {

      private final EnumPlayerModelParts field_175234_p;
      private static final String __OBFID = "CL_00001930";


      private ButtonPart(int p_i45514_2_, int p_i45514_3_, int p_i45514_4_, int p_i45514_5_, int p_i45514_6_, EnumPlayerModelParts p_i45514_7_) {
         super(p_i45514_2_, p_i45514_3_, p_i45514_4_, p_i45514_5_, p_i45514_6_, GuiCustomizeSkin.this.func_175358_a(p_i45514_7_));
         this.field_175234_p = p_i45514_7_;
      }

      // $FF: synthetic method
      ButtonPart(int p_i45515_2_, int p_i45515_3_, int p_i45515_4_, int p_i45515_5_, int p_i45515_6_, EnumPlayerModelParts p_i45515_7_, Object p_i45515_8_) {
         this(p_i45515_2_, p_i45515_3_, p_i45515_4_, p_i45515_5_, p_i45515_6_, p_i45515_7_);
      }
   }
}
