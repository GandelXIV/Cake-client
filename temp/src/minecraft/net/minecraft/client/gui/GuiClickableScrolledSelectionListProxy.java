package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.realms.RealmsClickableScrolledSelectionList;
import net.minecraft.realms.Tezzelator;
import org.lwjgl.input.Mouse;

public class GuiClickableScrolledSelectionListProxy extends GuiSlot {

   private final RealmsClickableScrolledSelectionList field_178046_u;
   private static final String __OBFID = "CL_00001939";


   public GuiClickableScrolledSelectionListProxy(RealmsClickableScrolledSelectionList p_i45526_1_, int p_i45526_2_, int p_i45526_3_, int p_i45526_4_, int p_i45526_5_, int p_i45526_6_) {
      super(Minecraft.func_71410_x(), p_i45526_2_, p_i45526_3_, p_i45526_4_, p_i45526_5_, p_i45526_6_);
      this.field_178046_u = p_i45526_1_;
   }

   protected int func_148127_b() {
      return this.field_178046_u.getItemCount();
   }

   protected void func_148144_a(int p_148144_1_, boolean p_148144_2_, int p_148144_3_, int p_148144_4_) {
      this.field_178046_u.selectItem(p_148144_1_, p_148144_2_, p_148144_3_, p_148144_4_);
   }

   protected boolean func_148131_a(int p_148131_1_) {
      return this.field_178046_u.isSelectedItem(p_148131_1_);
   }

   protected void func_148123_a() {
      this.field_178046_u.renderBackground();
   }

   protected void func_180791_a(int p_180791_1_, int p_180791_2_, int p_180791_3_, int p_180791_4_, int p_180791_5_, int p_180791_6_) {
      this.field_178046_u.renderItem(p_180791_1_, p_180791_2_, p_180791_3_, p_180791_4_, p_180791_5_, p_180791_6_);
   }

   public int func_178044_e() {
      return super.field_148155_a;
   }

   public int func_178042_f() {
      return super.field_148162_h;
   }

   public int func_178045_g() {
      return super.field_148150_g;
   }

   protected int func_148138_e() {
      return this.field_178046_u.getMaxPosition();
   }

   protected int func_148137_d() {
      return this.field_178046_u.getScrollbarPosition();
   }

   public void func_178039_p() {
      super.func_178039_p();
      if(this.field_148170_p > 0.0F && Mouse.getEventButtonState()) {
         this.field_178046_u.customMouseEvent(this.field_148153_b, this.field_148154_c, this.field_148160_j, this.field_148169_q, this.field_148149_f);
      }

   }

   public void func_178043_a(int p_178043_1_, int p_178043_2_, int p_178043_3_, Tezzelator p_178043_4_) {
      this.field_178046_u.renderSelected(p_178043_1_, p_178043_2_, p_178043_3_, p_178043_4_);
   }

   protected void func_148120_b(int p_148120_1_, int p_148120_2_, int p_148120_3_, int p_148120_4_) {
      int var5 = this.func_148127_b();

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = p_148120_2_ + var6 * this.field_148149_f + this.field_148160_j;
         int var8 = this.field_148149_f - 4;
         if(var7 > this.field_148154_c || var7 + var8 < this.field_148153_b) {
            this.func_178040_a(var6, p_148120_1_, var7);
         }

         if(this.field_148166_t && this.func_148131_a(var6)) {
            this.func_178043_a(this.field_148155_a, var7, var8, Tezzelator.instance);
         }

         this.func_180791_a(var6, p_148120_1_, var7, var8, p_148120_3_, p_148120_4_);
      }

   }
}
