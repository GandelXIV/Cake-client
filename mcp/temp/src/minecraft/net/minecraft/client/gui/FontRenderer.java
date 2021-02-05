package net.minecraft.client.gui;

import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.ArabicShapingException;
import com.ibm.icu.text.Bidi;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.GL11;

public class FontRenderer implements IResourceManagerReloadListener {

   private static final ResourceLocation[] field_111274_c = new ResourceLocation[256];
   private int[] field_78286_d = new int[256];
   public int field_78288_b = 9;
   public Random field_78289_c = new Random();
   private byte[] field_78287_e = new byte[65536];
   private int[] field_78285_g = new int[32];
   private final ResourceLocation field_111273_g;
   private final TextureManager field_78298_i;
   private float field_78295_j;
   private float field_78296_k;
   private boolean field_78293_l;
   private boolean field_78294_m;
   private float field_78291_n;
   private float field_78292_o;
   private float field_78306_p;
   private float field_78305_q;
   private int field_78304_r;
   private boolean field_78303_s;
   private boolean field_78302_t;
   private boolean field_78301_u;
   private boolean field_78300_v;
   private boolean field_78299_w;
   private static final String __OBFID = "CL_00000660";


   public FontRenderer(GameSettings p_i1035_1_, ResourceLocation p_i1035_2_, TextureManager p_i1035_3_, boolean p_i1035_4_) {
      this.field_111273_g = p_i1035_2_;
      this.field_78298_i = p_i1035_3_;
      this.field_78293_l = p_i1035_4_;
      p_i1035_3_.func_110577_a(this.field_111273_g);

      for(int var5 = 0; var5 < 32; ++var5) {
         int var6 = (var5 >> 3 & 1) * 85;
         int var7 = (var5 >> 2 & 1) * 170 + var6;
         int var8 = (var5 >> 1 & 1) * 170 + var6;
         int var9 = (var5 >> 0 & 1) * 170 + var6;
         if(var5 == 6) {
            var7 += 85;
         }

         if(p_i1035_1_.field_74337_g) {
            int var10 = (var7 * 30 + var8 * 59 + var9 * 11) / 100;
            int var11 = (var7 * 30 + var8 * 70) / 100;
            int var12 = (var7 * 30 + var9 * 70) / 100;
            var7 = var10;
            var8 = var11;
            var9 = var12;
         }

         if(var5 >= 16) {
            var7 /= 4;
            var8 /= 4;
            var9 /= 4;
         }

         this.field_78285_g[var5] = (var7 & 255) << 16 | (var8 & 255) << 8 | var9 & 255;
      }

      this.func_98306_d();
   }

   public void func_110549_a(IResourceManager p_110549_1_) {
      this.func_111272_d();
   }

   private void func_111272_d() {
      BufferedImage var1;
      try {
         var1 = TextureUtil.func_177053_a(Minecraft.func_71410_x().func_110442_L().func_110536_a(this.field_111273_g).func_110527_b());
      } catch (IOException var17) {
         throw new RuntimeException(var17);
      }

      int var2 = var1.getWidth();
      int var3 = var1.getHeight();
      int[] var4 = new int[var2 * var3];
      var1.getRGB(0, 0, var2, var3, var4, 0, var2);
      int var5 = var3 / 16;
      int var6 = var2 / 16;
      byte var7 = 1;
      float var8 = 8.0F / (float)var6;
      int var9 = 0;

      while(var9 < 256) {
         int var10 = var9 % 16;
         int var11 = var9 / 16;
         if(var9 == 32) {
            this.field_78286_d[var9] = 3 + var7;
         }

         int var12 = var6 - 1;

         while(true) {
            if(var12 >= 0) {
               int var13 = var10 * var6 + var12;
               boolean var14 = true;

               for(int var15 = 0; var15 < var5 && var14; ++var15) {
                  int var16 = (var11 * var6 + var15) * var2;
                  if((var4[var13 + var16] >> 24 & 255) != 0) {
                     var14 = false;
                  }
               }

               if(var14) {
                  --var12;
                  continue;
               }
            }

            ++var12;
            this.field_78286_d[var9] = (int)(0.5D + (double)((float)var12 * var8)) + var7;
            ++var9;
            break;
         }
      }

   }

   private void func_98306_d() {
      InputStream var1 = null;

      try {
         var1 = Minecraft.func_71410_x().func_110442_L().func_110536_a(new ResourceLocation("font/glyph_sizes.bin")).func_110527_b();
         var1.read(this.field_78287_e);
      } catch (IOException var6) {
         throw new RuntimeException(var6);
      } finally {
         IOUtils.closeQuietly(var1);
      }

   }

   private float func_78278_a(int p_78278_1_, char p_78278_2_, boolean p_78278_3_) {
      return p_78278_2_ == 32?4.0F:("\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u0000".indexOf(p_78278_2_) != -1 && !this.field_78293_l?this.func_78266_a(p_78278_1_, p_78278_3_):this.func_78277_a(p_78278_2_, p_78278_3_));
   }

   private float func_78266_a(int p_78266_1_, boolean p_78266_2_) {
      float var3 = (float)(p_78266_1_ % 16 * 8);
      float var4 = (float)(p_78266_1_ / 16 * 8);
      float var5 = p_78266_2_?1.0F:0.0F;
      this.field_78298_i.func_110577_a(this.field_111273_g);
      float var6 = (float)this.field_78286_d[p_78266_1_] - 0.01F;
      GL11.glBegin(5);
      GL11.glTexCoord2f(var3 / 128.0F, var4 / 128.0F);
      GL11.glVertex3f(this.field_78295_j + var5, this.field_78296_k, 0.0F);
      GL11.glTexCoord2f(var3 / 128.0F, (var4 + 7.99F) / 128.0F);
      GL11.glVertex3f(this.field_78295_j - var5, this.field_78296_k + 7.99F, 0.0F);
      GL11.glTexCoord2f((var3 + var6 - 1.0F) / 128.0F, var4 / 128.0F);
      GL11.glVertex3f(this.field_78295_j + var6 - 1.0F + var5, this.field_78296_k, 0.0F);
      GL11.glTexCoord2f((var3 + var6 - 1.0F) / 128.0F, (var4 + 7.99F) / 128.0F);
      GL11.glVertex3f(this.field_78295_j + var6 - 1.0F - var5, this.field_78296_k + 7.99F, 0.0F);
      GL11.glEnd();
      return (float)this.field_78286_d[p_78266_1_];
   }

   private ResourceLocation func_111271_a(int p_111271_1_) {
      if(field_111274_c[p_111271_1_] == null) {
         field_111274_c[p_111271_1_] = new ResourceLocation(String.format("textures/font/unicode_page_%02x.png", new Object[]{Integer.valueOf(p_111271_1_)}));
      }

      return field_111274_c[p_111271_1_];
   }

   private void func_78257_a(int p_78257_1_) {
      this.field_78298_i.func_110577_a(this.func_111271_a(p_78257_1_));
   }

   private float func_78277_a(char p_78277_1_, boolean p_78277_2_) {
      if(this.field_78287_e[p_78277_1_] == 0) {
         return 0.0F;
      } else {
         int var3 = p_78277_1_ / 256;
         this.func_78257_a(var3);
         int var4 = this.field_78287_e[p_78277_1_] >>> 4;
         int var5 = this.field_78287_e[p_78277_1_] & 15;
         float var6 = (float)var4;
         float var7 = (float)(var5 + 1);
         float var8 = (float)(p_78277_1_ % 16 * 16) + var6;
         float var9 = (float)((p_78277_1_ & 255) / 16 * 16);
         float var10 = var7 - var6 - 0.02F;
         float var11 = p_78277_2_?1.0F:0.0F;
         GL11.glBegin(5);
         GL11.glTexCoord2f(var8 / 256.0F, var9 / 256.0F);
         GL11.glVertex3f(this.field_78295_j + var11, this.field_78296_k, 0.0F);
         GL11.glTexCoord2f(var8 / 256.0F, (var9 + 15.98F) / 256.0F);
         GL11.glVertex3f(this.field_78295_j - var11, this.field_78296_k + 7.99F, 0.0F);
         GL11.glTexCoord2f((var8 + var10) / 256.0F, var9 / 256.0F);
         GL11.glVertex3f(this.field_78295_j + var10 / 2.0F + var11, this.field_78296_k, 0.0F);
         GL11.glTexCoord2f((var8 + var10) / 256.0F, (var9 + 15.98F) / 256.0F);
         GL11.glVertex3f(this.field_78295_j + var10 / 2.0F - var11, this.field_78296_k + 7.99F, 0.0F);
         GL11.glEnd();
         return (var7 - var6) / 2.0F + 1.0F;
      }
   }

   public int func_175063_a(String p_175063_1_, float p_175063_2_, float p_175063_3_, int p_175063_4_) {
      return this.func_175065_a(p_175063_1_, p_175063_2_, p_175063_3_, p_175063_4_, true);
   }

   public int func_78276_b(String p_78276_1_, int p_78276_2_, int p_78276_3_, int p_78276_4_) {
      return this.func_175065_a(p_78276_1_, (float)p_78276_2_, (float)p_78276_3_, p_78276_4_, false);
   }

   public int func_175065_a(String p_175065_1_, float p_175065_2_, float p_175065_3_, int p_175065_4_, boolean p_175065_5_) {
      GlStateManager.func_179141_d();
      this.func_78265_b();
      int var6;
      if(p_175065_5_) {
         var6 = this.func_180455_b(p_175065_1_, p_175065_2_ + 1.0F, p_175065_3_ + 1.0F, p_175065_4_, true);
         var6 = Math.max(var6, this.func_180455_b(p_175065_1_, p_175065_2_, p_175065_3_, p_175065_4_, false));
      } else {
         var6 = this.func_180455_b(p_175065_1_, p_175065_2_, p_175065_3_, p_175065_4_, false);
      }

      return var6;
   }

   private String func_147647_b(String p_147647_1_) {
      try {
         Bidi var2 = new Bidi((new ArabicShaping(8)).shape(p_147647_1_), 127);
         var2.setReorderingMode(0);
         return var2.writeReordered(2);
      } catch (ArabicShapingException var3) {
         return p_147647_1_;
      }
   }

   private void func_78265_b() {
      this.field_78303_s = false;
      this.field_78302_t = false;
      this.field_78301_u = false;
      this.field_78300_v = false;
      this.field_78299_w = false;
   }

   private void func_78255_a(String p_78255_1_, boolean p_78255_2_) {
      for(int var3 = 0; var3 < p_78255_1_.length(); ++var3) {
         char var4 = p_78255_1_.charAt(var3);
         int var5;
         int var6;
         if(var4 == 167 && var3 + 1 < p_78255_1_.length()) {
            var5 = "0123456789abcdefklmnor".indexOf(p_78255_1_.toLowerCase().charAt(var3 + 1));
            if(var5 < 16) {
               this.field_78303_s = false;
               this.field_78302_t = false;
               this.field_78299_w = false;
               this.field_78300_v = false;
               this.field_78301_u = false;
               if(var5 < 0 || var5 > 15) {
                  var5 = 15;
               }

               if(p_78255_2_) {
                  var5 += 16;
               }

               var6 = this.field_78285_g[var5];
               this.field_78304_r = var6;
               GlStateManager.func_179131_c((float)(var6 >> 16) / 255.0F, (float)(var6 >> 8 & 255) / 255.0F, (float)(var6 & 255) / 255.0F, this.field_78305_q);
            } else if(var5 == 16) {
               this.field_78303_s = true;
            } else if(var5 == 17) {
               this.field_78302_t = true;
            } else if(var5 == 18) {
               this.field_78299_w = true;
            } else if(var5 == 19) {
               this.field_78300_v = true;
            } else if(var5 == 20) {
               this.field_78301_u = true;
            } else if(var5 == 21) {
               this.field_78303_s = false;
               this.field_78302_t = false;
               this.field_78299_w = false;
               this.field_78300_v = false;
               this.field_78301_u = false;
               GlStateManager.func_179131_c(this.field_78291_n, this.field_78292_o, this.field_78306_p, this.field_78305_q);
            }

            ++var3;
         } else {
            var5 = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u0000".indexOf(var4);
            if(this.field_78303_s && var5 != -1) {
               do {
                  var6 = this.field_78289_c.nextInt(this.field_78286_d.length);
               } while(this.field_78286_d[var5] != this.field_78286_d[var6]);

               var5 = var6;
            }

            float var12 = this.field_78293_l?0.5F:1.0F;
            boolean var7 = (var4 == 0 || var5 == -1 || this.field_78293_l) && p_78255_2_;
            if(var7) {
               this.field_78295_j -= var12;
               this.field_78296_k -= var12;
            }

            float var8 = this.func_78278_a(var5, var4, this.field_78301_u);
            if(var7) {
               this.field_78295_j += var12;
               this.field_78296_k += var12;
            }

            if(this.field_78302_t) {
               this.field_78295_j += var12;
               if(var7) {
                  this.field_78295_j -= var12;
                  this.field_78296_k -= var12;
               }

               this.func_78278_a(var5, var4, this.field_78301_u);
               this.field_78295_j -= var12;
               if(var7) {
                  this.field_78295_j += var12;
                  this.field_78296_k += var12;
               }

               ++var8;
            }

            Tessellator var9;
            WorldRenderer var10;
            if(this.field_78299_w) {
               var9 = Tessellator.func_178181_a();
               var10 = var9.func_178180_c();
               GlStateManager.func_179090_x();
               var10.func_178970_b();
               var10.func_178984_b((double)this.field_78295_j, (double)(this.field_78296_k + (float)(this.field_78288_b / 2)), 0.0D);
               var10.func_178984_b((double)(this.field_78295_j + var8), (double)(this.field_78296_k + (float)(this.field_78288_b / 2)), 0.0D);
               var10.func_178984_b((double)(this.field_78295_j + var8), (double)(this.field_78296_k + (float)(this.field_78288_b / 2) - 1.0F), 0.0D);
               var10.func_178984_b((double)this.field_78295_j, (double)(this.field_78296_k + (float)(this.field_78288_b / 2) - 1.0F), 0.0D);
               var9.func_78381_a();
               GlStateManager.func_179098_w();
            }

            if(this.field_78300_v) {
               var9 = Tessellator.func_178181_a();
               var10 = var9.func_178180_c();
               GlStateManager.func_179090_x();
               var10.func_178970_b();
               int var11 = this.field_78300_v?-1:0;
               var10.func_178984_b((double)(this.field_78295_j + (float)var11), (double)(this.field_78296_k + (float)this.field_78288_b), 0.0D);
               var10.func_178984_b((double)(this.field_78295_j + var8), (double)(this.field_78296_k + (float)this.field_78288_b), 0.0D);
               var10.func_178984_b((double)(this.field_78295_j + var8), (double)(this.field_78296_k + (float)this.field_78288_b - 1.0F), 0.0D);
               var10.func_178984_b((double)(this.field_78295_j + (float)var11), (double)(this.field_78296_k + (float)this.field_78288_b - 1.0F), 0.0D);
               var9.func_78381_a();
               GlStateManager.func_179098_w();
            }

            this.field_78295_j += (float)((int)var8);
         }
      }

   }

   private int func_78274_b(String p_78274_1_, int p_78274_2_, int p_78274_3_, int p_78274_4_, int p_78274_5_, boolean p_78274_6_) {
      if(this.field_78294_m) {
         int var7 = this.func_78256_a(this.func_147647_b(p_78274_1_));
         p_78274_2_ = p_78274_2_ + p_78274_4_ - var7;
      }

      return this.func_180455_b(p_78274_1_, (float)p_78274_2_, (float)p_78274_3_, p_78274_5_, p_78274_6_);
   }

   private int func_180455_b(String p_180455_1_, float p_180455_2_, float p_180455_3_, int p_180455_4_, boolean p_180455_5_) {
      if(p_180455_1_ == null) {
         return 0;
      } else {
         if(this.field_78294_m) {
            p_180455_1_ = this.func_147647_b(p_180455_1_);
         }

         if((p_180455_4_ & -67108864) == 0) {
            p_180455_4_ |= -16777216;
         }

         if(p_180455_5_) {
            p_180455_4_ = (p_180455_4_ & 16579836) >> 2 | p_180455_4_ & -16777216;
         }

         this.field_78291_n = (float)(p_180455_4_ >> 16 & 255) / 255.0F;
         this.field_78292_o = (float)(p_180455_4_ >> 8 & 255) / 255.0F;
         this.field_78306_p = (float)(p_180455_4_ & 255) / 255.0F;
         this.field_78305_q = (float)(p_180455_4_ >> 24 & 255) / 255.0F;
         GlStateManager.func_179131_c(this.field_78291_n, this.field_78292_o, this.field_78306_p, this.field_78305_q);
         this.field_78295_j = p_180455_2_;
         this.field_78296_k = p_180455_3_;
         this.func_78255_a(p_180455_1_, p_180455_5_);
         return (int)this.field_78295_j;
      }
   }

   public int func_78256_a(String p_78256_1_) {
      if(p_78256_1_ == null) {
         return 0;
      } else {
         int var2 = 0;
         boolean var3 = false;

         for(int var4 = 0; var4 < p_78256_1_.length(); ++var4) {
            char var5 = p_78256_1_.charAt(var4);
            int var6 = this.func_78263_a(var5);
            if(var6 < 0 && var4 < p_78256_1_.length() - 1) {
               ++var4;
               var5 = p_78256_1_.charAt(var4);
               if(var5 != 108 && var5 != 76) {
                  if(var5 == 114 || var5 == 82) {
                     var3 = false;
                  }
               } else {
                  var3 = true;
               }

               var6 = 0;
            }

            var2 += var6;
            if(var3 && var6 > 0) {
               ++var2;
            }
         }

         return var2;
      }
   }

   public int func_78263_a(char p_78263_1_) {
      if(p_78263_1_ == 167) {
         return -1;
      } else if(p_78263_1_ == 32) {
         return 4;
      } else {
         int var2 = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u0000".indexOf(p_78263_1_);
         if(p_78263_1_ > 0 && var2 != -1 && !this.field_78293_l) {
            return this.field_78286_d[var2];
         } else if(this.field_78287_e[p_78263_1_] != 0) {
            int var3 = this.field_78287_e[p_78263_1_] >>> 4;
            int var4 = this.field_78287_e[p_78263_1_] & 15;
            if(var4 > 7) {
               var4 = 15;
               var3 = 0;
            }

            ++var4;
            return (var4 - var3) / 2 + 1;
         } else {
            return 0;
         }
      }
   }

   public String func_78269_a(String p_78269_1_, int p_78269_2_) {
      return this.func_78262_a(p_78269_1_, p_78269_2_, false);
   }

   public String func_78262_a(String p_78262_1_, int p_78262_2_, boolean p_78262_3_) {
      StringBuilder var4 = new StringBuilder();
      int var5 = 0;
      int var6 = p_78262_3_?p_78262_1_.length() - 1:0;
      int var7 = p_78262_3_?-1:1;
      boolean var8 = false;
      boolean var9 = false;

      for(int var10 = var6; var10 >= 0 && var10 < p_78262_1_.length() && var5 < p_78262_2_; var10 += var7) {
         char var11 = p_78262_1_.charAt(var10);
         int var12 = this.func_78263_a(var11);
         if(var8) {
            var8 = false;
            if(var11 != 108 && var11 != 76) {
               if(var11 == 114 || var11 == 82) {
                  var9 = false;
               }
            } else {
               var9 = true;
            }
         } else if(var12 < 0) {
            var8 = true;
         } else {
            var5 += var12;
            if(var9) {
               ++var5;
            }
         }

         if(var5 > p_78262_2_) {
            break;
         }

         if(p_78262_3_) {
            var4.insert(0, var11);
         } else {
            var4.append(var11);
         }
      }

      return var4.toString();
   }

   private String func_78273_d(String p_78273_1_) {
      while(p_78273_1_ != null && p_78273_1_.endsWith("\n")) {
         p_78273_1_ = p_78273_1_.substring(0, p_78273_1_.length() - 1);
      }

      return p_78273_1_;
   }

   public void func_78279_b(String p_78279_1_, int p_78279_2_, int p_78279_3_, int p_78279_4_, int p_78279_5_) {
      this.func_78265_b();
      this.field_78304_r = p_78279_5_;
      p_78279_1_ = this.func_78273_d(p_78279_1_);
      this.func_78268_b(p_78279_1_, p_78279_2_, p_78279_3_, p_78279_4_, false);
   }

   private void func_78268_b(String p_78268_1_, int p_78268_2_, int p_78268_3_, int p_78268_4_, boolean p_78268_5_) {
      List var6 = this.func_78271_c(p_78268_1_, p_78268_4_);

      for(Iterator var7 = var6.iterator(); var7.hasNext(); p_78268_3_ += this.field_78288_b) {
         String var8 = (String)var7.next();
         this.func_78274_b(var8, p_78268_2_, p_78268_3_, p_78268_4_, this.field_78304_r, p_78268_5_);
      }

   }

   public int func_78267_b(String p_78267_1_, int p_78267_2_) {
      return this.field_78288_b * this.func_78271_c(p_78267_1_, p_78267_2_).size();
   }

   public void func_78264_a(boolean p_78264_1_) {
      this.field_78293_l = p_78264_1_;
   }

   public boolean func_82883_a() {
      return this.field_78293_l;
   }

   public void func_78275_b(boolean p_78275_1_) {
      this.field_78294_m = p_78275_1_;
   }

   public List func_78271_c(String p_78271_1_, int p_78271_2_) {
      return Arrays.asList(this.func_78280_d(p_78271_1_, p_78271_2_).split("\n"));
   }

   String func_78280_d(String p_78280_1_, int p_78280_2_) {
      int var3 = this.func_78259_e(p_78280_1_, p_78280_2_);
      if(p_78280_1_.length() <= var3) {
         return p_78280_1_;
      } else {
         String var4 = p_78280_1_.substring(0, var3);
         char var5 = p_78280_1_.charAt(var3);
         boolean var6 = var5 == 32 || var5 == 10;
         String var7 = func_78282_e(var4) + p_78280_1_.substring(var3 + (var6?1:0));
         return var4 + "\n" + this.func_78280_d(var7, p_78280_2_);
      }
   }

   private int func_78259_e(String p_78259_1_, int p_78259_2_) {
      int var3 = p_78259_1_.length();
      int var4 = 0;
      int var5 = 0;
      int var6 = -1;

      for(boolean var7 = false; var5 < var3; ++var5) {
         char var8 = p_78259_1_.charAt(var5);
         switch(var8) {
         case 10:
            --var5;
            break;
         case 32:
            var6 = var5;
         case 167:
            if(var5 < var3 - 1) {
               ++var5;
               char var9 = p_78259_1_.charAt(var5);
               if(var9 != 108 && var9 != 76) {
                  if(var9 == 114 || var9 == 82 || func_78272_b(var9)) {
                     var7 = false;
                  }
               } else {
                  var7 = true;
               }
            }
            break;
         default:
            var4 += this.func_78263_a(var8);
            if(var7) {
               ++var4;
            }
         }

         if(var8 == 10) {
            ++var5;
            var6 = var5;
            break;
         }

         if(var4 > p_78259_2_) {
            break;
         }
      }

      return var5 != var3 && var6 != -1 && var6 < var5?var6:var5;
   }

   private static boolean func_78272_b(char p_78272_0_) {
      return p_78272_0_ >= 48 && p_78272_0_ <= 57 || p_78272_0_ >= 97 && p_78272_0_ <= 102 || p_78272_0_ >= 65 && p_78272_0_ <= 70;
   }

   private static boolean func_78270_c(char p_78270_0_) {
      return p_78270_0_ >= 107 && p_78270_0_ <= 111 || p_78270_0_ >= 75 && p_78270_0_ <= 79 || p_78270_0_ == 114 || p_78270_0_ == 82;
   }

   public static String func_78282_e(String p_78282_0_) {
      String var1 = "";
      int var2 = -1;
      int var3 = p_78282_0_.length();

      while((var2 = p_78282_0_.indexOf(167, var2 + 1)) != -1) {
         if(var2 < var3 - 1) {
            char var4 = p_78282_0_.charAt(var2 + 1);
            if(func_78272_b(var4)) {
               var1 = "\u00a7" + var4;
            } else if(func_78270_c(var4)) {
               var1 = var1 + "\u00a7" + var4;
            }
         }
      }

      return var1;
   }

   public boolean func_78260_a() {
      return this.field_78294_m;
   }

   public int func_175064_b(char p_175064_1_) {
      return this.field_78285_g["0123456789abcdef".indexOf(p_175064_1_)];
   }

}
