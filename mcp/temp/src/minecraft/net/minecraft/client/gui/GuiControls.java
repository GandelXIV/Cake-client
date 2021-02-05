package net.minecraft.client.gui;

import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiKeyBindingList;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiOptionSlider;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;

public class GuiControls extends GuiScreen {

   private static final GameSettings.Options[] field_146492_g = new GameSettings.Options[]{GameSettings.Options.INVERT_MOUSE, GameSettings.Options.SENSITIVITY, GameSettings.Options.TOUCHSCREEN};
   private GuiScreen field_146496_h;
   protected String field_146495_a = "Controls";
   private GameSettings field_146497_i;
   public KeyBinding field_146491_f = null;
   public long field_152177_g;
   private GuiKeyBindingList field_146494_r;
   private GuiButton field_146493_s;
   private static final String __OBFID = "CL_00000736";


   public GuiControls(GuiScreen p_i1027_1_, GameSettings p_i1027_2_) {
      this.field_146496_h = p_i1027_1_;
      this.field_146497_i = p_i1027_2_;
   }

   public void func_73866_w_() {
      this.field_146494_r = new GuiKeyBindingList(this, this.field_146297_k);
      this.field_146292_n.add(new GuiButton(200, this.field_146294_l / 2 - 155, this.field_146295_m - 29, 150, 20, I18n.func_135052_a("gui.done", new Object[0])));
      this.field_146292_n.add(this.field_146493_s = new GuiButton(201, this.field_146294_l / 2 - 155 + 160, this.field_146295_m - 29, 150, 20, I18n.func_135052_a("controls.resetAll", new Object[0])));
      this.field_146495_a = I18n.func_135052_a("controls.title", new Object[0]);
      int var1 = 0;
      GameSettings.Options[] var2 = field_146492_g;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         GameSettings.Options var5 = var2[var4];
         if(var5.func_74380_a()) {
            this.field_146292_n.add(new GuiOptionSlider(var5.func_74381_c(), this.field_146294_l / 2 - 155 + var1 % 2 * 160, 18 + 24 * (var1 >> 1), var5));
         } else {
            this.field_146292_n.add(new GuiOptionButton(var5.func_74381_c(), this.field_146294_l / 2 - 155 + var1 % 2 * 160, 18 + 24 * (var1 >> 1), var5, this.field_146497_i.func_74297_c(var5)));
         }

         ++var1;
      }

   }

   public void func_146274_d() throws IOException {
      super.func_146274_d();
      this.field_146494_r.func_178039_p();
   }

   protected void func_146284_a(GuiButton p_146284_1_) throws IOException {
      if(p_146284_1_.field_146127_k == 200) {
         this.field_146297_k.func_147108_a(this.field_146496_h);
      } else if(p_146284_1_.field_146127_k == 201) {
         KeyBinding[] var2 = this.field_146297_k.field_71474_y.field_74324_K;
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            KeyBinding var5 = var2[var4];
            var5.func_151462_b(var5.func_151469_h());
         }

         KeyBinding.func_74508_b();
      } else if(p_146284_1_.field_146127_k < 100 && p_146284_1_ instanceof GuiOptionButton) {
         this.field_146497_i.func_74306_a(((GuiOptionButton)p_146284_1_).func_146136_c(), 1);
         p_146284_1_.field_146126_j = this.field_146497_i.func_74297_c(GameSettings.Options.func_74379_a(p_146284_1_.field_146127_k));
      }

   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) throws IOException {
      if(this.field_146491_f != null) {
         this.field_146497_i.func_151440_a(this.field_146491_f, -100 + p_73864_3_);
         this.field_146491_f = null;
         KeyBinding.func_74508_b();
      } else if(p_73864_3_ != 0 || !this.field_146494_r.func_148179_a(p_73864_1_, p_73864_2_, p_73864_3_)) {
         super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
      }

   }

   protected void func_146286_b(int p_146286_1_, int p_146286_2_, int p_146286_3_) {
      if(p_146286_3_ != 0 || !this.field_146494_r.func_148181_b(p_146286_1_, p_146286_2_, p_146286_3_)) {
         super.func_146286_b(p_146286_1_, p_146286_2_, p_146286_3_);
      }

   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) throws IOException {
      if(this.field_146491_f != null) {
         if(p_73869_2_ == 1) {
            this.field_146497_i.func_151440_a(this.field_146491_f, 0);
         } else if(p_73869_2_ != 0) {
            this.field_146497_i.func_151440_a(this.field_146491_f, p_73869_2_);
         } else if(p_73869_1_ > 0) {
            this.field_146497_i.func_151440_a(this.field_146491_f, p_73869_1_ + 256);
         }

         this.field_146491_f = null;
         this.field_152177_g = Minecraft.func_71386_F();
         KeyBinding.func_74508_b();
      } else {
         super.func_73869_a(p_73869_1_, p_73869_2_);
      }

   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_146276_q_();
      this.field_146494_r.func_148128_a(p_73863_1_, p_73863_2_, p_73863_3_);
      this.func_73732_a(this.field_146289_q, this.field_146495_a, this.field_146294_l / 2, 8, 16777215);
      boolean var4 = true;
      KeyBinding[] var5 = this.field_146497_i.field_74324_K;
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         KeyBinding var8 = var5[var7];
         if(var8.func_151463_i() != var8.func_151469_h()) {
            var4 = false;
            break;
         }
      }

      this.field_146493_s.field_146124_l = !var4;
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

}
