package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;

public class GuiLabel extends Gui {

   protected int field_146167_a = 200;
   protected int field_146161_f = 20;
   public int field_146162_g;
   public int field_146174_h;
   private List field_146173_k;
   public int field_175204_i;
   private boolean field_146170_l;
   public boolean field_146172_j = true;
   private boolean field_146171_m;
   private int field_146168_n;
   private int field_146169_o;
   private int field_146166_p;
   private int field_146165_q;
   private FontRenderer field_146164_r;
   private int field_146163_s;
   private static final String __OBFID = "CL_00000671";


   public GuiLabel(FontRenderer p_i45540_1_, int p_i45540_2_, int p_i45540_3_, int p_i45540_4_, int p_i45540_5_, int p_i45540_6_, int p_i45540_7_) {
      this.field_146164_r = p_i45540_1_;
      this.field_175204_i = p_i45540_2_;
      this.field_146162_g = p_i45540_3_;
      this.field_146174_h = p_i45540_4_;
      this.field_146167_a = p_i45540_5_;
      this.field_146161_f = p_i45540_6_;
      this.field_146173_k = Lists.newArrayList();
      this.field_146170_l = false;
      this.field_146171_m = false;
      this.field_146168_n = p_i45540_7_;
      this.field_146169_o = -1;
      this.field_146166_p = -1;
      this.field_146165_q = -1;
      this.field_146163_s = 0;
   }

   public void func_175202_a(String p_175202_1_) {
      this.field_146173_k.add(I18n.func_135052_a(p_175202_1_, new Object[0]));
   }

   public GuiLabel func_175203_a() {
      this.field_146170_l = true;
      return this;
   }

   public void func_146159_a(Minecraft p_146159_1_, int p_146159_2_, int p_146159_3_) {
      if(this.field_146172_j) {
         GlStateManager.func_179147_l();
         GlStateManager.func_179120_a(770, 771, 1, 0);
         this.func_146160_b(p_146159_1_, p_146159_2_, p_146159_3_);
         int var4 = this.field_146174_h + this.field_146161_f / 2 + this.field_146163_s / 2;
         int var5 = var4 - this.field_146173_k.size() * 10 / 2;

         for(int var6 = 0; var6 < this.field_146173_k.size(); ++var6) {
            if(this.field_146170_l) {
               this.func_73732_a(this.field_146164_r, (String)this.field_146173_k.get(var6), this.field_146162_g + this.field_146167_a / 2, var5 + var6 * 10, this.field_146168_n);
            } else {
               this.func_73731_b(this.field_146164_r, (String)this.field_146173_k.get(var6), this.field_146162_g, var5 + var6 * 10, this.field_146168_n);
            }
         }

      }
   }

   protected void func_146160_b(Minecraft p_146160_1_, int p_146160_2_, int p_146160_3_) {
      if(this.field_146171_m) {
         int var4 = this.field_146167_a + this.field_146163_s * 2;
         int var5 = this.field_146161_f + this.field_146163_s * 2;
         int var6 = this.field_146162_g - this.field_146163_s;
         int var7 = this.field_146174_h - this.field_146163_s;
         func_73734_a(var6, var7, var6 + var4, var7 + var5, this.field_146169_o);
         this.func_73730_a(var6, var6 + var4, var7, this.field_146166_p);
         this.func_73730_a(var6, var6 + var4, var7 + var5, this.field_146165_q);
         this.func_73728_b(var6, var7, var7 + var5, this.field_146166_p);
         this.func_73728_b(var6 + var4, var7, var7 + var5, this.field_146165_q);
      }

   }
}
