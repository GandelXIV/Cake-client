package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.MathHelper;
import org.lwjgl.input.Mouse;

public abstract class GuiSlot {

   protected final Minecraft field_148161_k;
   protected int field_148155_a;
   protected int field_148158_l;
   protected int field_148153_b;
   protected int field_148154_c;
   protected int field_148151_d;
   protected int field_148152_e;
   protected final int field_148149_f;
   private int field_148159_m;
   private int field_148156_n;
   protected int field_148150_g;
   protected int field_148162_h;
   protected boolean field_148163_i = true;
   protected float field_148157_o = -2.0F;
   protected float field_148170_p;
   protected float field_148169_q;
   protected int field_148168_r = -1;
   protected long field_148167_s;
   protected boolean field_178041_q = true;
   protected boolean field_148166_t = true;
   protected boolean field_148165_u;
   protected int field_148160_j;
   private boolean field_148164_v = true;
   private static final String __OBFID = "CL_00000679";


   public GuiSlot(Minecraft p_i1052_1_, int p_i1052_2_, int p_i1052_3_, int p_i1052_4_, int p_i1052_5_, int p_i1052_6_) {
      this.field_148161_k = p_i1052_1_;
      this.field_148155_a = p_i1052_2_;
      this.field_148158_l = p_i1052_3_;
      this.field_148153_b = p_i1052_4_;
      this.field_148154_c = p_i1052_5_;
      this.field_148149_f = p_i1052_6_;
      this.field_148152_e = 0;
      this.field_148151_d = p_i1052_2_;
   }

   public void func_148122_a(int p_148122_1_, int p_148122_2_, int p_148122_3_, int p_148122_4_) {
      this.field_148155_a = p_148122_1_;
      this.field_148158_l = p_148122_2_;
      this.field_148153_b = p_148122_3_;
      this.field_148154_c = p_148122_4_;
      this.field_148152_e = 0;
      this.field_148151_d = p_148122_1_;
   }

   public void func_148130_a(boolean p_148130_1_) {
      this.field_148166_t = p_148130_1_;
   }

   protected void func_148133_a(boolean p_148133_1_, int p_148133_2_) {
      this.field_148165_u = p_148133_1_;
      this.field_148160_j = p_148133_2_;
      if(!p_148133_1_) {
         this.field_148160_j = 0;
      }

   }

   protected abstract int func_148127_b();

   protected abstract void func_148144_a(int var1, boolean var2, int var3, int var4);

   protected abstract boolean func_148131_a(int var1);

   protected int func_148138_e() {
      return this.func_148127_b() * this.field_148149_f + this.field_148160_j;
   }

   protected abstract void func_148123_a();

   protected void func_178040_a(int p_178040_1_, int p_178040_2_, int p_178040_3_) {}

   protected abstract void func_180791_a(int var1, int var2, int var3, int var4, int var5, int var6);

   protected void func_148129_a(int p_148129_1_, int p_148129_2_, Tessellator p_148129_3_) {}

   protected void func_148132_a(int p_148132_1_, int p_148132_2_) {}

   protected void func_148142_b(int p_148142_1_, int p_148142_2_) {}

   public int func_148124_c(int p_148124_1_, int p_148124_2_) {
      int var3 = this.field_148152_e + this.field_148155_a / 2 - this.func_148139_c() / 2;
      int var4 = this.field_148152_e + this.field_148155_a / 2 + this.func_148139_c() / 2;
      int var5 = p_148124_2_ - this.field_148153_b - this.field_148160_j + (int)this.field_148169_q - 4;
      int var6 = var5 / this.field_148149_f;
      return p_148124_1_ < this.func_148137_d() && p_148124_1_ >= var3 && p_148124_1_ <= var4 && var6 >= 0 && var5 >= 0 && var6 < this.func_148127_b()?var6:-1;
   }

   public void func_148134_d(int p_148134_1_, int p_148134_2_) {
      this.field_148159_m = p_148134_1_;
      this.field_148156_n = p_148134_2_;
   }

   protected void func_148121_k() {
      int var1 = this.func_148135_f();
      if(var1 < 0) {
         var1 /= 2;
      }

      if(!this.field_148163_i && var1 < 0) {
         var1 = 0;
      }

      this.field_148169_q = MathHelper.func_76131_a(this.field_148169_q, 0.0F, (float)var1);
   }

   public int func_148135_f() {
      return Math.max(0, this.func_148138_e() - (this.field_148154_c - this.field_148153_b - 4));
   }

   public int func_148148_g() {
      return (int)this.field_148169_q;
   }

   public boolean func_148141_e(int p_148141_1_) {
      return p_148141_1_ >= this.field_148153_b && p_148141_1_ <= this.field_148154_c && this.field_148150_g >= this.field_148152_e && this.field_148150_g <= this.field_148151_d;
   }

   public void func_148145_f(int p_148145_1_) {
      this.field_148169_q += (float)p_148145_1_;
      this.func_148121_k();
      this.field_148157_o = -2.0F;
   }

   public void func_148147_a(GuiButton p_148147_1_) {
      if(p_148147_1_.field_146124_l) {
         if(p_148147_1_.field_146127_k == this.field_148159_m) {
            this.field_148169_q -= (float)(this.field_148149_f * 2 / 3);
            this.field_148157_o = -2.0F;
            this.func_148121_k();
         } else if(p_148147_1_.field_146127_k == this.field_148156_n) {
            this.field_148169_q += (float)(this.field_148149_f * 2 / 3);
            this.field_148157_o = -2.0F;
            this.func_148121_k();
         }

      }
   }

   public void func_148128_a(int p_148128_1_, int p_148128_2_, float p_148128_3_) {
      if(this.field_178041_q) {
         this.field_148150_g = p_148128_1_;
         this.field_148162_h = p_148128_2_;
         this.func_148123_a();
         int var4 = this.func_148137_d();
         int var5 = var4 + 6;
         this.func_148121_k();
         GlStateManager.func_179140_f();
         GlStateManager.func_179106_n();
         Tessellator var6 = Tessellator.func_178181_a();
         WorldRenderer var7 = var6.func_178180_c();
         this.field_148161_k.func_110434_K().func_110577_a(Gui.field_110325_k);
         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
         float var8 = 32.0F;
         var7.func_178970_b();
         var7.func_178991_c(2105376);
         var7.func_178985_a((double)this.field_148152_e, (double)this.field_148154_c, 0.0D, (double)((float)this.field_148152_e / var8), (double)((float)(this.field_148154_c + (int)this.field_148169_q) / var8));
         var7.func_178985_a((double)this.field_148151_d, (double)this.field_148154_c, 0.0D, (double)((float)this.field_148151_d / var8), (double)((float)(this.field_148154_c + (int)this.field_148169_q) / var8));
         var7.func_178985_a((double)this.field_148151_d, (double)this.field_148153_b, 0.0D, (double)((float)this.field_148151_d / var8), (double)((float)(this.field_148153_b + (int)this.field_148169_q) / var8));
         var7.func_178985_a((double)this.field_148152_e, (double)this.field_148153_b, 0.0D, (double)((float)this.field_148152_e / var8), (double)((float)(this.field_148153_b + (int)this.field_148169_q) / var8));
         var6.func_78381_a();
         int var9 = this.field_148152_e + this.field_148155_a / 2 - this.func_148139_c() / 2 + 2;
         int var10 = this.field_148153_b + 4 - (int)this.field_148169_q;
         if(this.field_148165_u) {
            this.func_148129_a(var9, var10, var6);
         }

         this.func_148120_b(var9, var10, p_148128_1_, p_148128_2_);
         GlStateManager.func_179097_i();
         byte var11 = 4;
         this.func_148136_c(0, this.field_148153_b, 255, 255);
         this.func_148136_c(this.field_148154_c, this.field_148158_l, 255, 255);
         GlStateManager.func_179147_l();
         GlStateManager.func_179120_a(770, 771, 0, 1);
         GlStateManager.func_179118_c();
         GlStateManager.func_179103_j(7425);
         GlStateManager.func_179090_x();
         var7.func_178970_b();
         var7.func_178974_a(0, 0);
         var7.func_178985_a((double)this.field_148152_e, (double)(this.field_148153_b + var11), 0.0D, 0.0D, 1.0D);
         var7.func_178985_a((double)this.field_148151_d, (double)(this.field_148153_b + var11), 0.0D, 1.0D, 1.0D);
         var7.func_178974_a(0, 255);
         var7.func_178985_a((double)this.field_148151_d, (double)this.field_148153_b, 0.0D, 1.0D, 0.0D);
         var7.func_178985_a((double)this.field_148152_e, (double)this.field_148153_b, 0.0D, 0.0D, 0.0D);
         var6.func_78381_a();
         var7.func_178970_b();
         var7.func_178974_a(0, 255);
         var7.func_178985_a((double)this.field_148152_e, (double)this.field_148154_c, 0.0D, 0.0D, 1.0D);
         var7.func_178985_a((double)this.field_148151_d, (double)this.field_148154_c, 0.0D, 1.0D, 1.0D);
         var7.func_178974_a(0, 0);
         var7.func_178985_a((double)this.field_148151_d, (double)(this.field_148154_c - var11), 0.0D, 1.0D, 0.0D);
         var7.func_178985_a((double)this.field_148152_e, (double)(this.field_148154_c - var11), 0.0D, 0.0D, 0.0D);
         var6.func_78381_a();
         int var12 = this.func_148135_f();
         if(var12 > 0) {
            int var13 = (this.field_148154_c - this.field_148153_b) * (this.field_148154_c - this.field_148153_b) / this.func_148138_e();
            var13 = MathHelper.func_76125_a(var13, 32, this.field_148154_c - this.field_148153_b - 8);
            int var14 = (int)this.field_148169_q * (this.field_148154_c - this.field_148153_b - var13) / var12 + this.field_148153_b;
            if(var14 < this.field_148153_b) {
               var14 = this.field_148153_b;
            }

            var7.func_178970_b();
            var7.func_178974_a(0, 255);
            var7.func_178985_a((double)var4, (double)this.field_148154_c, 0.0D, 0.0D, 1.0D);
            var7.func_178985_a((double)var5, (double)this.field_148154_c, 0.0D, 1.0D, 1.0D);
            var7.func_178985_a((double)var5, (double)this.field_148153_b, 0.0D, 1.0D, 0.0D);
            var7.func_178985_a((double)var4, (double)this.field_148153_b, 0.0D, 0.0D, 0.0D);
            var6.func_78381_a();
            var7.func_178970_b();
            var7.func_178974_a(8421504, 255);
            var7.func_178985_a((double)var4, (double)(var14 + var13), 0.0D, 0.0D, 1.0D);
            var7.func_178985_a((double)var5, (double)(var14 + var13), 0.0D, 1.0D, 1.0D);
            var7.func_178985_a((double)var5, (double)var14, 0.0D, 1.0D, 0.0D);
            var7.func_178985_a((double)var4, (double)var14, 0.0D, 0.0D, 0.0D);
            var6.func_78381_a();
            var7.func_178970_b();
            var7.func_178974_a(12632256, 255);
            var7.func_178985_a((double)var4, (double)(var14 + var13 - 1), 0.0D, 0.0D, 1.0D);
            var7.func_178985_a((double)(var5 - 1), (double)(var14 + var13 - 1), 0.0D, 1.0D, 1.0D);
            var7.func_178985_a((double)(var5 - 1), (double)var14, 0.0D, 1.0D, 0.0D);
            var7.func_178985_a((double)var4, (double)var14, 0.0D, 0.0D, 0.0D);
            var6.func_78381_a();
         }

         this.func_148142_b(p_148128_1_, p_148128_2_);
         GlStateManager.func_179098_w();
         GlStateManager.func_179103_j(7424);
         GlStateManager.func_179141_d();
         GlStateManager.func_179084_k();
      }
   }

   public void func_178039_p() {
      if(this.func_148141_e(this.field_148162_h)) {
         if(Mouse.isButtonDown(0) && this.func_148125_i()) {
            if(this.field_148157_o == -1.0F) {
               boolean var1 = true;
               if(this.field_148162_h >= this.field_148153_b && this.field_148162_h <= this.field_148154_c) {
                  int var2 = this.field_148155_a / 2 - this.func_148139_c() / 2;
                  int var3 = this.field_148155_a / 2 + this.func_148139_c() / 2;
                  int var4 = this.field_148162_h - this.field_148153_b - this.field_148160_j + (int)this.field_148169_q - 4;
                  int var5 = var4 / this.field_148149_f;
                  if(this.field_148150_g >= var2 && this.field_148150_g <= var3 && var5 >= 0 && var4 >= 0 && var5 < this.func_148127_b()) {
                     boolean var6 = var5 == this.field_148168_r && Minecraft.func_71386_F() - this.field_148167_s < 250L;
                     this.func_148144_a(var5, var6, this.field_148150_g, this.field_148162_h);
                     this.field_148168_r = var5;
                     this.field_148167_s = Minecraft.func_71386_F();
                  } else if(this.field_148150_g >= var2 && this.field_148150_g <= var3 && var4 < 0) {
                     this.func_148132_a(this.field_148150_g - var2, this.field_148162_h - this.field_148153_b + (int)this.field_148169_q - 4);
                     var1 = false;
                  }

                  int var11 = this.func_148137_d();
                  int var7 = var11 + 6;
                  if(this.field_148150_g >= var11 && this.field_148150_g <= var7) {
                     this.field_148170_p = -1.0F;
                     int var8 = this.func_148135_f();
                     if(var8 < 1) {
                        var8 = 1;
                     }

                     int var9 = (int)((float)((this.field_148154_c - this.field_148153_b) * (this.field_148154_c - this.field_148153_b)) / (float)this.func_148138_e());
                     var9 = MathHelper.func_76125_a(var9, 32, this.field_148154_c - this.field_148153_b - 8);
                     this.field_148170_p /= (float)(this.field_148154_c - this.field_148153_b - var9) / (float)var8;
                  } else {
                     this.field_148170_p = 1.0F;
                  }

                  if(var1) {
                     this.field_148157_o = (float)this.field_148162_h;
                  } else {
                     this.field_148157_o = -2.0F;
                  }
               } else {
                  this.field_148157_o = -2.0F;
               }
            } else if(this.field_148157_o >= 0.0F) {
               this.field_148169_q -= ((float)this.field_148162_h - this.field_148157_o) * this.field_148170_p;
               this.field_148157_o = (float)this.field_148162_h;
            }
         } else {
            this.field_148157_o = -1.0F;
         }

         int var10 = Mouse.getEventDWheel();
         if(var10 != 0) {
            if(var10 > 0) {
               var10 = -1;
            } else if(var10 < 0) {
               var10 = 1;
            }

            this.field_148169_q += (float)(var10 * this.field_148149_f / 2);
         }
      }

   }

   public void func_148143_b(boolean p_148143_1_) {
      this.field_148164_v = p_148143_1_;
   }

   public boolean func_148125_i() {
      return this.field_148164_v;
   }

   public int func_148139_c() {
      return 220;
   }

   protected void func_148120_b(int p_148120_1_, int p_148120_2_, int p_148120_3_, int p_148120_4_) {
      int var5 = this.func_148127_b();
      Tessellator var6 = Tessellator.func_178181_a();
      WorldRenderer var7 = var6.func_178180_c();

      for(int var8 = 0; var8 < var5; ++var8) {
         int var9 = p_148120_2_ + var8 * this.field_148149_f + this.field_148160_j;
         int var10 = this.field_148149_f - 4;
         if(var9 > this.field_148154_c || var9 + var10 < this.field_148153_b) {
            this.func_178040_a(var8, p_148120_1_, var9);
         }

         if(this.field_148166_t && this.func_148131_a(var8)) {
            int var11 = this.field_148152_e + (this.field_148155_a / 2 - this.func_148139_c() / 2);
            int var12 = this.field_148152_e + this.field_148155_a / 2 + this.func_148139_c() / 2;
            GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.func_179090_x();
            var7.func_178970_b();
            var7.func_178991_c(8421504);
            var7.func_178985_a((double)var11, (double)(var9 + var10 + 2), 0.0D, 0.0D, 1.0D);
            var7.func_178985_a((double)var12, (double)(var9 + var10 + 2), 0.0D, 1.0D, 1.0D);
            var7.func_178985_a((double)var12, (double)(var9 - 2), 0.0D, 1.0D, 0.0D);
            var7.func_178985_a((double)var11, (double)(var9 - 2), 0.0D, 0.0D, 0.0D);
            var7.func_178991_c(0);
            var7.func_178985_a((double)(var11 + 1), (double)(var9 + var10 + 1), 0.0D, 0.0D, 1.0D);
            var7.func_178985_a((double)(var12 - 1), (double)(var9 + var10 + 1), 0.0D, 1.0D, 1.0D);
            var7.func_178985_a((double)(var12 - 1), (double)(var9 - 1), 0.0D, 1.0D, 0.0D);
            var7.func_178985_a((double)(var11 + 1), (double)(var9 - 1), 0.0D, 0.0D, 0.0D);
            var6.func_78381_a();
            GlStateManager.func_179098_w();
         }

         this.func_180791_a(var8, p_148120_1_, var9, var10, p_148120_3_, p_148120_4_);
      }

   }

   protected int func_148137_d() {
      return this.field_148155_a / 2 + 124;
   }

   protected void func_148136_c(int p_148136_1_, int p_148136_2_, int p_148136_3_, int p_148136_4_) {
      Tessellator var5 = Tessellator.func_178181_a();
      WorldRenderer var6 = var5.func_178180_c();
      this.field_148161_k.func_110434_K().func_110577_a(Gui.field_110325_k);
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      float var7 = 32.0F;
      var6.func_178970_b();
      var6.func_178974_a(4210752, p_148136_4_);
      var6.func_178985_a((double)this.field_148152_e, (double)p_148136_2_, 0.0D, 0.0D, (double)((float)p_148136_2_ / var7));
      var6.func_178985_a((double)(this.field_148152_e + this.field_148155_a), (double)p_148136_2_, 0.0D, (double)((float)this.field_148155_a / var7), (double)((float)p_148136_2_ / var7));
      var6.func_178974_a(4210752, p_148136_3_);
      var6.func_178985_a((double)(this.field_148152_e + this.field_148155_a), (double)p_148136_1_, 0.0D, (double)((float)this.field_148155_a / var7), (double)((float)p_148136_1_ / var7));
      var6.func_178985_a((double)this.field_148152_e, (double)p_148136_1_, 0.0D, 0.0D, (double)((float)p_148136_1_ / var7));
      var5.func_78381_a();
   }

   public void func_148140_g(int p_148140_1_) {
      this.field_148152_e = p_148140_1_;
      this.field_148151_d = p_148140_1_ + this.field_148155_a;
   }

   public int func_148146_j() {
      return this.field_148149_f;
   }
}
