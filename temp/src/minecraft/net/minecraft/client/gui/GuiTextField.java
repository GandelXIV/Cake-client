package net.minecraft.client.gui;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiPageButtonList;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.MathHelper;

public class GuiTextField extends Gui {

   private final int field_175208_g;
   private final FontRenderer field_146211_a;
   public int field_146209_f;
   public int field_146210_g;
   private final int field_146218_h;
   private final int field_146219_i;
   private String field_146216_j = "";
   private int field_146217_k = 32;
   private int field_146214_l;
   private boolean field_146215_m = true;
   private boolean field_146212_n = true;
   private boolean field_146213_o;
   private boolean field_146226_p = true;
   private int field_146225_q;
   private int field_146224_r;
   private int field_146223_s;
   private int field_146222_t = 14737632;
   private int field_146221_u = 7368816;
   private boolean field_146220_v = true;
   private GuiPageButtonList.GuiResponder field_175210_x;
   private Predicate field_175209_y = Predicates.alwaysTrue();
   private static final String __OBFID = "CL_00000670";


   public GuiTextField(int p_i45542_1_, FontRenderer p_i45542_2_, int p_i45542_3_, int p_i45542_4_, int p_i45542_5_, int p_i45542_6_) {
      this.field_175208_g = p_i45542_1_;
      this.field_146211_a = p_i45542_2_;
      this.field_146209_f = p_i45542_3_;
      this.field_146210_g = p_i45542_4_;
      this.field_146218_h = p_i45542_5_;
      this.field_146219_i = p_i45542_6_;
   }

   public void func_175207_a(GuiPageButtonList.GuiResponder p_175207_1_) {
      this.field_175210_x = p_175207_1_;
   }

   public void func_146178_a() {
      ++this.field_146214_l;
   }

   public void func_146180_a(String p_146180_1_) {
      if(this.field_175209_y.apply(p_146180_1_)) {
         if(p_146180_1_.length() > this.field_146217_k) {
            this.field_146216_j = p_146180_1_.substring(0, this.field_146217_k);
         } else {
            this.field_146216_j = p_146180_1_;
         }

         this.func_146202_e();
      }
   }

   public String func_146179_b() {
      return this.field_146216_j;
   }

   public String func_146207_c() {
      int var1 = this.field_146224_r < this.field_146223_s?this.field_146224_r:this.field_146223_s;
      int var2 = this.field_146224_r < this.field_146223_s?this.field_146223_s:this.field_146224_r;
      return this.field_146216_j.substring(var1, var2);
   }

   public void func_175205_a(Predicate p_175205_1_) {
      this.field_175209_y = p_175205_1_;
   }

   public void func_146191_b(String p_146191_1_) {
      String var2 = "";
      String var3 = ChatAllowedCharacters.func_71565_a(p_146191_1_);
      int var4 = this.field_146224_r < this.field_146223_s?this.field_146224_r:this.field_146223_s;
      int var5 = this.field_146224_r < this.field_146223_s?this.field_146223_s:this.field_146224_r;
      int var6 = this.field_146217_k - this.field_146216_j.length() - (var4 - var5);
      boolean var7 = false;
      if(this.field_146216_j.length() > 0) {
         var2 = var2 + this.field_146216_j.substring(0, var4);
      }

      int var8;
      if(var6 < var3.length()) {
         var2 = var2 + var3.substring(0, var6);
         var8 = var6;
      } else {
         var2 = var2 + var3;
         var8 = var3.length();
      }

      if(this.field_146216_j.length() > 0 && var5 < this.field_146216_j.length()) {
         var2 = var2 + this.field_146216_j.substring(var5);
      }

      if(this.field_175209_y.apply(var2)) {
         this.field_146216_j = var2;
         this.func_146182_d(var4 - this.field_146223_s + var8);
         if(this.field_175210_x != null) {
            this.field_175210_x.func_175319_a(this.field_175208_g, this.field_146216_j);
         }

      }
   }

   public void func_146177_a(int p_146177_1_) {
      if(this.field_146216_j.length() != 0) {
         if(this.field_146223_s != this.field_146224_r) {
            this.func_146191_b("");
         } else {
            this.func_146175_b(this.func_146187_c(p_146177_1_) - this.field_146224_r);
         }
      }
   }

   public void func_146175_b(int p_146175_1_) {
      if(this.field_146216_j.length() != 0) {
         if(this.field_146223_s != this.field_146224_r) {
            this.func_146191_b("");
         } else {
            boolean var2 = p_146175_1_ < 0;
            int var3 = var2?this.field_146224_r + p_146175_1_:this.field_146224_r;
            int var4 = var2?this.field_146224_r:this.field_146224_r + p_146175_1_;
            String var5 = "";
            if(var3 >= 0) {
               var5 = this.field_146216_j.substring(0, var3);
            }

            if(var4 < this.field_146216_j.length()) {
               var5 = var5 + this.field_146216_j.substring(var4);
            }

            this.field_146216_j = var5;
            if(var2) {
               this.func_146182_d(p_146175_1_);
            }

            if(this.field_175210_x != null) {
               this.field_175210_x.func_175319_a(this.field_175208_g, this.field_146216_j);
            }

         }
      }
   }

   public int func_175206_d() {
      return this.field_175208_g;
   }

   public int func_146187_c(int p_146187_1_) {
      return this.func_146183_a(p_146187_1_, this.func_146198_h());
   }

   public int func_146183_a(int p_146183_1_, int p_146183_2_) {
      return this.func_146197_a(p_146183_1_, p_146183_2_, true);
   }

   public int func_146197_a(int p_146197_1_, int p_146197_2_, boolean p_146197_3_) {
      int var4 = p_146197_2_;
      boolean var5 = p_146197_1_ < 0;
      int var6 = Math.abs(p_146197_1_);

      for(int var7 = 0; var7 < var6; ++var7) {
         if(var5) {
            while(p_146197_3_ && var4 > 0 && this.field_146216_j.charAt(var4 - 1) == 32) {
               --var4;
            }

            while(var4 > 0 && this.field_146216_j.charAt(var4 - 1) != 32) {
               --var4;
            }
         } else {
            int var8 = this.field_146216_j.length();
            var4 = this.field_146216_j.indexOf(32, var4);
            if(var4 == -1) {
               var4 = var8;
            } else {
               while(p_146197_3_ && var4 < var8 && this.field_146216_j.charAt(var4) == 32) {
                  ++var4;
               }
            }
         }
      }

      return var4;
   }

   public void func_146182_d(int p_146182_1_) {
      this.func_146190_e(this.field_146223_s + p_146182_1_);
   }

   public void func_146190_e(int p_146190_1_) {
      this.field_146224_r = p_146190_1_;
      int var2 = this.field_146216_j.length();
      this.field_146224_r = MathHelper.func_76125_a(this.field_146224_r, 0, var2);
      this.func_146199_i(this.field_146224_r);
   }

   public void func_146196_d() {
      this.func_146190_e(0);
   }

   public void func_146202_e() {
      this.func_146190_e(this.field_146216_j.length());
   }

   public boolean func_146201_a(char p_146201_1_, int p_146201_2_) {
      if(!this.field_146213_o) {
         return false;
      } else if(GuiScreen.func_175278_g(p_146201_2_)) {
         this.func_146202_e();
         this.func_146199_i(0);
         return true;
      } else if(GuiScreen.func_175280_f(p_146201_2_)) {
         GuiScreen.func_146275_d(this.func_146207_c());
         return true;
      } else if(GuiScreen.func_175279_e(p_146201_2_)) {
         if(this.field_146226_p) {
            this.func_146191_b(GuiScreen.func_146277_j());
         }

         return true;
      } else if(GuiScreen.func_175277_d(p_146201_2_)) {
         GuiScreen.func_146275_d(this.func_146207_c());
         if(this.field_146226_p) {
            this.func_146191_b("");
         }

         return true;
      } else {
         switch(p_146201_2_) {
         case 14:
            if(GuiScreen.func_146271_m()) {
               if(this.field_146226_p) {
                  this.func_146177_a(-1);
               }
            } else if(this.field_146226_p) {
               this.func_146175_b(-1);
            }

            return true;
         case 199:
            if(GuiScreen.func_146272_n()) {
               this.func_146199_i(0);
            } else {
               this.func_146196_d();
            }

            return true;
         case 203:
            if(GuiScreen.func_146272_n()) {
               if(GuiScreen.func_146271_m()) {
                  this.func_146199_i(this.func_146183_a(-1, this.func_146186_n()));
               } else {
                  this.func_146199_i(this.func_146186_n() - 1);
               }
            } else if(GuiScreen.func_146271_m()) {
               this.func_146190_e(this.func_146187_c(-1));
            } else {
               this.func_146182_d(-1);
            }

            return true;
         case 205:
            if(GuiScreen.func_146272_n()) {
               if(GuiScreen.func_146271_m()) {
                  this.func_146199_i(this.func_146183_a(1, this.func_146186_n()));
               } else {
                  this.func_146199_i(this.func_146186_n() + 1);
               }
            } else if(GuiScreen.func_146271_m()) {
               this.func_146190_e(this.func_146187_c(1));
            } else {
               this.func_146182_d(1);
            }

            return true;
         case 207:
            if(GuiScreen.func_146272_n()) {
               this.func_146199_i(this.field_146216_j.length());
            } else {
               this.func_146202_e();
            }

            return true;
         case 211:
            if(GuiScreen.func_146271_m()) {
               if(this.field_146226_p) {
                  this.func_146177_a(1);
               }
            } else if(this.field_146226_p) {
               this.func_146175_b(1);
            }

            return true;
         default:
            if(ChatAllowedCharacters.func_71566_a(p_146201_1_)) {
               if(this.field_146226_p) {
                  this.func_146191_b(Character.toString(p_146201_1_));
               }

               return true;
            } else {
               return false;
            }
         }
      }
   }

   public void func_146192_a(int p_146192_1_, int p_146192_2_, int p_146192_3_) {
      boolean var4 = p_146192_1_ >= this.field_146209_f && p_146192_1_ < this.field_146209_f + this.field_146218_h && p_146192_2_ >= this.field_146210_g && p_146192_2_ < this.field_146210_g + this.field_146219_i;
      if(this.field_146212_n) {
         this.func_146195_b(var4);
      }

      if(this.field_146213_o && var4 && p_146192_3_ == 0) {
         int var5 = p_146192_1_ - this.field_146209_f;
         if(this.field_146215_m) {
            var5 -= 4;
         }

         String var6 = this.field_146211_a.func_78269_a(this.field_146216_j.substring(this.field_146225_q), this.func_146200_o());
         this.func_146190_e(this.field_146211_a.func_78269_a(var6, var5).length() + this.field_146225_q);
      }

   }

   public void func_146194_f() {
      if(this.func_146176_q()) {
         if(this.func_146181_i()) {
            func_73734_a(this.field_146209_f - 1, this.field_146210_g - 1, this.field_146209_f + this.field_146218_h + 1, this.field_146210_g + this.field_146219_i + 1, -6250336);
            func_73734_a(this.field_146209_f, this.field_146210_g, this.field_146209_f + this.field_146218_h, this.field_146210_g + this.field_146219_i, -16777216);
         }

         int var1 = this.field_146226_p?this.field_146222_t:this.field_146221_u;
         int var2 = this.field_146224_r - this.field_146225_q;
         int var3 = this.field_146223_s - this.field_146225_q;
         String var4 = this.field_146211_a.func_78269_a(this.field_146216_j.substring(this.field_146225_q), this.func_146200_o());
         boolean var5 = var2 >= 0 && var2 <= var4.length();
         boolean var6 = this.field_146213_o && this.field_146214_l / 6 % 2 == 0 && var5;
         int var7 = this.field_146215_m?this.field_146209_f + 4:this.field_146209_f;
         int var8 = this.field_146215_m?this.field_146210_g + (this.field_146219_i - 8) / 2:this.field_146210_g;
         int var9 = var7;
         if(var3 > var4.length()) {
            var3 = var4.length();
         }

         if(var4.length() > 0) {
            String var10 = var5?var4.substring(0, var2):var4;
            var9 = this.field_146211_a.func_175063_a(var10, (float)var7, (float)var8, var1);
         }

         boolean var13 = this.field_146224_r < this.field_146216_j.length() || this.field_146216_j.length() >= this.func_146208_g();
         int var11 = var9;
         if(!var5) {
            var11 = var2 > 0?var7 + this.field_146218_h:var7;
         } else if(var13) {
            var11 = var9 - 1;
            --var9;
         }

         if(var4.length() > 0 && var5 && var2 < var4.length()) {
            var9 = this.field_146211_a.func_175063_a(var4.substring(var2), (float)var9, (float)var8, var1);
         }

         if(var6) {
            if(var13) {
               Gui.func_73734_a(var11, var8 - 1, var11 + 1, var8 + 1 + this.field_146211_a.field_78288_b, -3092272);
            } else {
               this.field_146211_a.func_175063_a("_", (float)var11, (float)var8, var1);
            }
         }

         if(var3 != var2) {
            int var12 = var7 + this.field_146211_a.func_78256_a(var4.substring(0, var3));
            this.func_146188_c(var11, var8 - 1, var12 - 1, var8 + 1 + this.field_146211_a.field_78288_b);
         }

      }
   }

   private void func_146188_c(int p_146188_1_, int p_146188_2_, int p_146188_3_, int p_146188_4_) {
      int var5;
      if(p_146188_1_ < p_146188_3_) {
         var5 = p_146188_1_;
         p_146188_1_ = p_146188_3_;
         p_146188_3_ = var5;
      }

      if(p_146188_2_ < p_146188_4_) {
         var5 = p_146188_2_;
         p_146188_2_ = p_146188_4_;
         p_146188_4_ = var5;
      }

      if(p_146188_3_ > this.field_146209_f + this.field_146218_h) {
         p_146188_3_ = this.field_146209_f + this.field_146218_h;
      }

      if(p_146188_1_ > this.field_146209_f + this.field_146218_h) {
         p_146188_1_ = this.field_146209_f + this.field_146218_h;
      }

      Tessellator var7 = Tessellator.func_178181_a();
      WorldRenderer var6 = var7.func_178180_c();
      GlStateManager.func_179131_c(0.0F, 0.0F, 255.0F, 255.0F);
      GlStateManager.func_179090_x();
      GlStateManager.func_179115_u();
      GlStateManager.func_179116_f(5387);
      var6.func_178970_b();
      var6.func_178984_b((double)p_146188_1_, (double)p_146188_4_, 0.0D);
      var6.func_178984_b((double)p_146188_3_, (double)p_146188_4_, 0.0D);
      var6.func_178984_b((double)p_146188_3_, (double)p_146188_2_, 0.0D);
      var6.func_178984_b((double)p_146188_1_, (double)p_146188_2_, 0.0D);
      var7.func_78381_a();
      GlStateManager.func_179134_v();
      GlStateManager.func_179098_w();
   }

   public void func_146203_f(int p_146203_1_) {
      this.field_146217_k = p_146203_1_;
      if(this.field_146216_j.length() > p_146203_1_) {
         this.field_146216_j = this.field_146216_j.substring(0, p_146203_1_);
      }

   }

   public int func_146208_g() {
      return this.field_146217_k;
   }

   public int func_146198_h() {
      return this.field_146224_r;
   }

   public boolean func_146181_i() {
      return this.field_146215_m;
   }

   public void func_146185_a(boolean p_146185_1_) {
      this.field_146215_m = p_146185_1_;
   }

   public void func_146193_g(int p_146193_1_) {
      this.field_146222_t = p_146193_1_;
   }

   public void func_146204_h(int p_146204_1_) {
      this.field_146221_u = p_146204_1_;
   }

   public void func_146195_b(boolean p_146195_1_) {
      if(p_146195_1_ && !this.field_146213_o) {
         this.field_146214_l = 0;
      }

      this.field_146213_o = p_146195_1_;
   }

   public boolean func_146206_l() {
      return this.field_146213_o;
   }

   public void func_146184_c(boolean p_146184_1_) {
      this.field_146226_p = p_146184_1_;
   }

   public int func_146186_n() {
      return this.field_146223_s;
   }

   public int func_146200_o() {
      return this.func_146181_i()?this.field_146218_h - 8:this.field_146218_h;
   }

   public void func_146199_i(int p_146199_1_) {
      int var2 = this.field_146216_j.length();
      if(p_146199_1_ > var2) {
         p_146199_1_ = var2;
      }

      if(p_146199_1_ < 0) {
         p_146199_1_ = 0;
      }

      this.field_146223_s = p_146199_1_;
      if(this.field_146211_a != null) {
         if(this.field_146225_q > var2) {
            this.field_146225_q = var2;
         }

         int var3 = this.func_146200_o();
         String var4 = this.field_146211_a.func_78269_a(this.field_146216_j.substring(this.field_146225_q), var3);
         int var5 = var4.length() + this.field_146225_q;
         if(p_146199_1_ == this.field_146225_q) {
            this.field_146225_q -= this.field_146211_a.func_78262_a(this.field_146216_j, var3, true).length();
         }

         if(p_146199_1_ > var5) {
            this.field_146225_q += p_146199_1_ - var5;
         } else if(p_146199_1_ <= this.field_146225_q) {
            this.field_146225_q -= this.field_146225_q - p_146199_1_;
         }

         this.field_146225_q = MathHelper.func_76125_a(this.field_146225_q, 0, var2);
      }

   }

   public void func_146205_d(boolean p_146205_1_) {
      this.field_146212_n = p_146205_1_;
   }

   public boolean func_146176_q() {
      return this.field_146220_v;
   }

   public void func_146189_e(boolean p_146189_1_) {
      this.field_146220_v = p_146189_1_;
   }
}
