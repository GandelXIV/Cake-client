package net.minecraft.client.renderer.texture;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.IntBuffer;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class TextureUtil {

   private static final Logger field_147959_c = LogManager.getLogger();
   private static final IntBuffer field_111000_c = GLAllocation.func_74527_f(4194304);
   public static final DynamicTexture field_111001_a = new DynamicTexture(16, 16);
   public static final int[] field_110999_b = field_111001_a.func_110565_c();
   private static final int[] field_147957_g;
   private static final String __OBFID = "CL_00001067";


   public static int func_110996_a() {
      return GlStateManager.func_179146_y();
   }

   public static void func_147942_a(int p_147942_0_) {
      GlStateManager.func_179150_h(p_147942_0_);
   }

   public static int func_110987_a(int p_110987_0_, BufferedImage p_110987_1_) {
      return func_110989_a(p_110987_0_, p_110987_1_, false, false);
   }

   public static void func_110988_a(int p_110988_0_, int[] p_110988_1_, int p_110988_2_, int p_110988_3_) {
      func_94277_a(p_110988_0_);
      func_147947_a(0, p_110988_1_, p_110988_2_, p_110988_3_, 0, 0, false, false, false);
   }

   public static int[][] func_147949_a(int p_147949_0_, int p_147949_1_, int[][] p_147949_2_) {
      int[][] var3 = new int[p_147949_0_ + 1][];
      var3[0] = p_147949_2_[0];
      if(p_147949_0_ > 0) {
         boolean var4 = false;

         int var5;
         for(var5 = 0; var5 < p_147949_2_.length; ++var5) {
            if(p_147949_2_[0][var5] >> 24 == 0) {
               var4 = true;
               break;
            }
         }

         for(var5 = 1; var5 <= p_147949_0_; ++var5) {
            if(p_147949_2_[var5] != null) {
               var3[var5] = p_147949_2_[var5];
            } else {
               int[] var6 = var3[var5 - 1];
               int[] var7 = new int[var6.length >> 2];
               int var8 = p_147949_1_ >> var5;
               int var9 = var7.length / var8;
               int var10 = var8 << 1;

               for(int var11 = 0; var11 < var8; ++var11) {
                  for(int var12 = 0; var12 < var9; ++var12) {
                     int var13 = 2 * (var11 + var12 * var10);
                     var7[var11 + var12 * var8] = func_147943_a(var6[var13 + 0], var6[var13 + 1], var6[var13 + 0 + var10], var6[var13 + 1 + var10], var4);
                  }
               }

               var3[var5] = var7;
            }
         }
      }

      return var3;
   }

   private static int func_147943_a(int p_147943_0_, int p_147943_1_, int p_147943_2_, int p_147943_3_, boolean p_147943_4_) {
      if(!p_147943_4_) {
         int var13 = func_147944_a(p_147943_0_, p_147943_1_, p_147943_2_, p_147943_3_, 24);
         int var14 = func_147944_a(p_147943_0_, p_147943_1_, p_147943_2_, p_147943_3_, 16);
         int var15 = func_147944_a(p_147943_0_, p_147943_1_, p_147943_2_, p_147943_3_, 8);
         int var16 = func_147944_a(p_147943_0_, p_147943_1_, p_147943_2_, p_147943_3_, 0);
         return var13 << 24 | var14 << 16 | var15 << 8 | var16;
      } else {
         field_147957_g[0] = p_147943_0_;
         field_147957_g[1] = p_147943_1_;
         field_147957_g[2] = p_147943_2_;
         field_147957_g[3] = p_147943_3_;
         float var5 = 0.0F;
         float var6 = 0.0F;
         float var7 = 0.0F;
         float var8 = 0.0F;

         int var9;
         for(var9 = 0; var9 < 4; ++var9) {
            if(field_147957_g[var9] >> 24 != 0) {
               var5 += (float)Math.pow((double)((float)(field_147957_g[var9] >> 24 & 255) / 255.0F), 2.2D);
               var6 += (float)Math.pow((double)((float)(field_147957_g[var9] >> 16 & 255) / 255.0F), 2.2D);
               var7 += (float)Math.pow((double)((float)(field_147957_g[var9] >> 8 & 255) / 255.0F), 2.2D);
               var8 += (float)Math.pow((double)((float)(field_147957_g[var9] >> 0 & 255) / 255.0F), 2.2D);
            }
         }

         var5 /= 4.0F;
         var6 /= 4.0F;
         var7 /= 4.0F;
         var8 /= 4.0F;
         var9 = (int)(Math.pow((double)var5, 0.45454545454545453D) * 255.0D);
         int var10 = (int)(Math.pow((double)var6, 0.45454545454545453D) * 255.0D);
         int var11 = (int)(Math.pow((double)var7, 0.45454545454545453D) * 255.0D);
         int var12 = (int)(Math.pow((double)var8, 0.45454545454545453D) * 255.0D);
         if(var9 < 96) {
            var9 = 0;
         }

         return var9 << 24 | var10 << 16 | var11 << 8 | var12;
      }
   }

   private static int func_147944_a(int p_147944_0_, int p_147944_1_, int p_147944_2_, int p_147944_3_, int p_147944_4_) {
      float var5 = (float)Math.pow((double)((float)(p_147944_0_ >> p_147944_4_ & 255) / 255.0F), 2.2D);
      float var6 = (float)Math.pow((double)((float)(p_147944_1_ >> p_147944_4_ & 255) / 255.0F), 2.2D);
      float var7 = (float)Math.pow((double)((float)(p_147944_2_ >> p_147944_4_ & 255) / 255.0F), 2.2D);
      float var8 = (float)Math.pow((double)((float)(p_147944_3_ >> p_147944_4_ & 255) / 255.0F), 2.2D);
      float var9 = (float)Math.pow((double)(var5 + var6 + var7 + var8) * 0.25D, 0.45454545454545453D);
      return (int)((double)var9 * 255.0D);
   }

   public static void func_147955_a(int[][] p_147955_0_, int p_147955_1_, int p_147955_2_, int p_147955_3_, int p_147955_4_, boolean p_147955_5_, boolean p_147955_6_) {
      for(int var7 = 0; var7 < p_147955_0_.length; ++var7) {
         int[] var8 = p_147955_0_[var7];
         func_147947_a(var7, var8, p_147955_1_ >> var7, p_147955_2_ >> var7, p_147955_3_ >> var7, p_147955_4_ >> var7, p_147955_5_, p_147955_6_, p_147955_0_.length > 1);
      }

   }

   private static void func_147947_a(int p_147947_0_, int[] p_147947_1_, int p_147947_2_, int p_147947_3_, int p_147947_4_, int p_147947_5_, boolean p_147947_6_, boolean p_147947_7_, boolean p_147947_8_) {
      int var9 = 4194304 / p_147947_2_;
      func_147954_b(p_147947_6_, p_147947_8_);
      func_110997_a(p_147947_7_);

      int var12;
      for(int var10 = 0; var10 < p_147947_2_ * p_147947_3_; var10 += p_147947_2_ * var12) {
         int var11 = var10 / p_147947_2_;
         var12 = Math.min(var9, p_147947_3_ - var11);
         int var13 = p_147947_2_ * var12;
         func_110994_a(p_147947_1_, var10, var13);
         GL11.glTexSubImage2D(3553, p_147947_0_, p_147947_4_, p_147947_5_ + var11, p_147947_2_, var12, '\u80e1', '\u8367', field_111000_c);
      }

   }

   public static int func_110989_a(int p_110989_0_, BufferedImage p_110989_1_, boolean p_110989_2_, boolean p_110989_3_) {
      func_110991_a(p_110989_0_, p_110989_1_.getWidth(), p_110989_1_.getHeight());
      return func_110995_a(p_110989_0_, p_110989_1_, 0, 0, p_110989_2_, p_110989_3_);
   }

   public static void func_110991_a(int p_110991_0_, int p_110991_1_, int p_110991_2_) {
      func_180600_a(p_110991_0_, 0, p_110991_1_, p_110991_2_);
   }

   public static void func_180600_a(int p_180600_0_, int p_180600_1_, int p_180600_2_, int p_180600_3_) {
      func_147942_a(p_180600_0_);
      func_94277_a(p_180600_0_);
      if(p_180600_1_ >= 0) {
         GL11.glTexParameteri(3553, '\u813d', p_180600_1_);
         GL11.glTexParameterf(3553, '\u813a', 0.0F);
         GL11.glTexParameterf(3553, '\u813b', (float)p_180600_1_);
         GL11.glTexParameterf(3553, '\u8501', 0.0F);
      }

      for(int var4 = 0; var4 <= p_180600_1_; ++var4) {
         GL11.glTexImage2D(3553, var4, 6408, p_180600_2_ >> var4, p_180600_3_ >> var4, 0, '\u80e1', '\u8367', (IntBuffer)null);
      }

   }

   public static int func_110995_a(int p_110995_0_, BufferedImage p_110995_1_, int p_110995_2_, int p_110995_3_, boolean p_110995_4_, boolean p_110995_5_) {
      func_94277_a(p_110995_0_);
      func_110993_a(p_110995_1_, p_110995_2_, p_110995_3_, p_110995_4_, p_110995_5_);
      return p_110995_0_;
   }

   private static void func_110993_a(BufferedImage p_110993_0_, int p_110993_1_, int p_110993_2_, boolean p_110993_3_, boolean p_110993_4_) {
      int var5 = p_110993_0_.getWidth();
      int var6 = p_110993_0_.getHeight();
      int var7 = 4194304 / var5;
      int[] var8 = new int[var7 * var5];
      func_147951_b(p_110993_3_);
      func_110997_a(p_110993_4_);

      for(int var9 = 0; var9 < var5 * var6; var9 += var5 * var7) {
         int var10 = var9 / var5;
         int var11 = Math.min(var7, var6 - var10);
         int var12 = var5 * var11;
         p_110993_0_.getRGB(0, var10, var5, var11, var8, 0, var5);
         func_110990_a(var8, var12);
         GL11.glTexSubImage2D(3553, 0, p_110993_1_, p_110993_2_ + var10, var5, var11, '\u80e1', '\u8367', field_111000_c);
      }

   }

   private static void func_110997_a(boolean p_110997_0_) {
      if(p_110997_0_) {
         GL11.glTexParameteri(3553, 10242, 10496);
         GL11.glTexParameteri(3553, 10243, 10496);
      } else {
         GL11.glTexParameteri(3553, 10242, 10497);
         GL11.glTexParameteri(3553, 10243, 10497);
      }

   }

   private static void func_147951_b(boolean p_147951_0_) {
      func_147954_b(p_147951_0_, false);
   }

   private static void func_147954_b(boolean p_147954_0_, boolean p_147954_1_) {
      if(p_147954_0_) {
         GL11.glTexParameteri(3553, 10241, p_147954_1_?9987:9729);
         GL11.glTexParameteri(3553, 10240, 9729);
      } else {
         GL11.glTexParameteri(3553, 10241, p_147954_1_?9986:9728);
         GL11.glTexParameteri(3553, 10240, 9728);
      }

   }

   private static void func_110990_a(int[] p_110990_0_, int p_110990_1_) {
      func_110994_a(p_110990_0_, 0, p_110990_1_);
   }

   private static void func_110994_a(int[] p_110994_0_, int p_110994_1_, int p_110994_2_) {
      int[] var3 = p_110994_0_;
      if(Minecraft.func_71410_x().field_71474_y.field_74337_g) {
         var3 = func_110985_a(p_110994_0_);
      }

      field_111000_c.clear();
      field_111000_c.put(var3, p_110994_1_, p_110994_2_);
      field_111000_c.position(0).limit(p_110994_2_);
   }

   static void func_94277_a(int p_94277_0_) {
      GlStateManager.func_179144_i(p_94277_0_);
   }

   public static int[] func_110986_a(IResourceManager p_110986_0_, ResourceLocation p_110986_1_) throws IOException {
      BufferedImage var2 = func_177053_a(p_110986_0_.func_110536_a(p_110986_1_).func_110527_b());
      int var3 = var2.getWidth();
      int var4 = var2.getHeight();
      int[] var5 = new int[var3 * var4];
      var2.getRGB(0, 0, var3, var4, var5, 0, var3);
      return var5;
   }

   public static BufferedImage func_177053_a(InputStream p_177053_0_) throws IOException {
      BufferedImage var1;
      try {
         var1 = ImageIO.read(p_177053_0_);
      } finally {
         IOUtils.closeQuietly(p_177053_0_);
      }

      return var1;
   }

   public static int[] func_110985_a(int[] p_110985_0_) {
      int[] var1 = new int[p_110985_0_.length];

      for(int var2 = 0; var2 < p_110985_0_.length; ++var2) {
         var1[var2] = func_177054_c(p_110985_0_[var2]);
      }

      return var1;
   }

   public static int func_177054_c(int p_177054_0_) {
      int var1 = p_177054_0_ >> 24 & 255;
      int var2 = p_177054_0_ >> 16 & 255;
      int var3 = p_177054_0_ >> 8 & 255;
      int var4 = p_177054_0_ & 255;
      int var5 = (var2 * 30 + var3 * 59 + var4 * 11) / 100;
      int var6 = (var2 * 30 + var3 * 70) / 100;
      int var7 = (var2 * 30 + var4 * 70) / 100;
      return var1 << 24 | var5 << 16 | var6 << 8 | var7;
   }

   public static void func_177055_a(String p_177055_0_, int p_177055_1_, int p_177055_2_, int p_177055_3_, int p_177055_4_) {
      func_94277_a(p_177055_1_);
      GL11.glPixelStorei(3333, 1);
      GL11.glPixelStorei(3317, 1);

      for(int var5 = 0; var5 <= p_177055_2_; ++var5) {
         File var6 = new File(p_177055_0_ + "_" + var5 + ".png");
         int var7 = p_177055_3_ >> var5;
         int var8 = p_177055_4_ >> var5;
         int var9 = var7 * var8;
         IntBuffer var10 = BufferUtils.createIntBuffer(var9);
         int[] var11 = new int[var9];
         GL11.glGetTexImage(3553, var5, '\u80e1', '\u8367', var10);
         var10.get(var11);
         BufferedImage var12 = new BufferedImage(var7, var8, 2);
         var12.setRGB(0, 0, var7, var8, var11, 0, var7);

         try {
            ImageIO.write(var12, "png", var6);
            field_147959_c.debug("Exported png to: {}", new Object[]{var6.getAbsolutePath()});
         } catch (IOException var14) {
            field_147959_c.debug("Unable to write: ", var14);
         }
      }

   }

   public static void func_147953_a(int[] p_147953_0_, int p_147953_1_, int p_147953_2_) {
      int[] var3 = new int[p_147953_1_];
      int var4 = p_147953_2_ / 2;

      for(int var5 = 0; var5 < var4; ++var5) {
         System.arraycopy(p_147953_0_, var5 * p_147953_1_, var3, 0, p_147953_1_);
         System.arraycopy(p_147953_0_, (p_147953_2_ - 1 - var5) * p_147953_1_, p_147953_0_, var5 * p_147953_1_, p_147953_1_);
         System.arraycopy(var3, 0, p_147953_0_, (p_147953_2_ - 1 - var5) * p_147953_1_, p_147953_1_);
      }

   }

   static {
      int var0 = -16777216;
      int var1 = -524040;
      int[] var2 = new int[]{-524040, -524040, -524040, -524040, -524040, -524040, -524040, -524040};
      int[] var3 = new int[]{-16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216};
      int var4 = var2.length;

      for(int var5 = 0; var5 < 16; ++var5) {
         System.arraycopy(var5 < var4?var2:var3, 0, field_110999_b, 16 * var5, var4);
         System.arraycopy(var5 < var4?var3:var2, 0, field_110999_b, 16 * var5 + var4, var4);
      }

      field_111001_a.func_110564_a();
      field_147957_g = new int[4];
   }
}
