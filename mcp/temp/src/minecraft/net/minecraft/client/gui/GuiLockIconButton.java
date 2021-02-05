package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;

public class GuiLockIconButton extends GuiButton {

   private boolean field_175231_o = false;
   private static final String __OBFID = "CL_00001952";


   public GuiLockIconButton(int p_i45538_1_, int p_i45538_2_, int p_i45538_3_) {
      super(p_i45538_1_, p_i45538_2_, p_i45538_3_, 20, 20, "");
   }

   public boolean func_175230_c() {
      return this.field_175231_o;
   }

   public void func_175229_b(boolean p_175229_1_) {
      this.field_175231_o = p_175229_1_;
   }

   public void func_146112_a(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_) {
      if(this.field_146125_m) {
         p_146112_1_.func_110434_K().func_110577_a(GuiButton.field_146122_a);
         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
         boolean var4 = p_146112_2_ >= this.field_146128_h && p_146112_3_ >= this.field_146129_i && p_146112_2_ < this.field_146128_h + this.field_146120_f && p_146112_3_ < this.field_146129_i + this.field_146121_g;
         GuiLockIconButton.Icon var5;
         if(this.field_175231_o) {
            if(!this.field_146124_l) {
               var5 = GuiLockIconButton.Icon.LOCKED_DISABLED;
            } else if(var4) {
               var5 = GuiLockIconButton.Icon.LOCKED_HOVER;
            } else {
               var5 = GuiLockIconButton.Icon.LOCKED;
            }
         } else if(!this.field_146124_l) {
            var5 = GuiLockIconButton.Icon.UNLOCKED_DISABLED;
         } else if(var4) {
            var5 = GuiLockIconButton.Icon.UNLOCKED_HOVER;
         } else {
            var5 = GuiLockIconButton.Icon.UNLOCKED;
         }

         this.func_73729_b(this.field_146128_h, this.field_146129_i, var5.func_178910_a(), var5.func_178912_b(), this.field_146120_f, this.field_146121_g);
      }
   }

   static enum Icon {

      LOCKED("LOCKED", 0, 0, 146),
      LOCKED_HOVER("LOCKED_HOVER", 1, 0, 166),
      LOCKED_DISABLED("LOCKED_DISABLED", 2, 0, 186),
      UNLOCKED("UNLOCKED", 3, 20, 146),
      UNLOCKED_HOVER("UNLOCKED_HOVER", 4, 20, 166),
      UNLOCKED_DISABLED("UNLOCKED_DISABLED", 5, 20, 186);
      private final int field_178914_g;
      private final int field_178920_h;
      // $FF: synthetic field
      private static final GuiLockIconButton.Icon[] $VALUES = new GuiLockIconButton.Icon[]{LOCKED, LOCKED_HOVER, LOCKED_DISABLED, UNLOCKED, UNLOCKED_HOVER, UNLOCKED_DISABLED};
      private static final String __OBFID = "CL_00001951";


      private Icon(String p_i45537_1_, int p_i45537_2_, int p_i45537_3_, int p_i45537_4_) {
         this.field_178914_g = p_i45537_3_;
         this.field_178920_h = p_i45537_4_;
      }

      public int func_178910_a() {
         return this.field_178914_g;
      }

      public int func_178912_b() {
         return this.field_178920_h;
      }

   }
}
