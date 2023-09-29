package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.Charsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GuiWinGame extends GuiScreen {

   private static final Logger field_146580_a = LogManager.getLogger();
   private static final ResourceLocation field_146576_f = new ResourceLocation("textures/gui/title/minecraft.png");
   private static final ResourceLocation field_146577_g = new ResourceLocation("textures/misc/vignette.png");
   private int field_146581_h;
   private List field_146582_i;
   private int field_146579_r;
   private float field_146578_s = 0.5F;
   private static final String __OBFID = "CL_00000719";


   public void func_73876_c() {
      ++this.field_146581_h;
      float var1 = (float)(this.field_146579_r + this.field_146295_m + this.field_146295_m + 24) / this.field_146578_s;
      if((float)this.field_146581_h > var1) {
         this.func_146574_g();
      }

   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) throws IOException {
      if(p_73869_2_ == 1) {
         this.func_146574_g();
      }

   }

   private void func_146574_g() {
      this.field_146297_k.field_71439_g.field_71174_a.func_147297_a(new C16PacketClientStatus(C16PacketClientStatus.EnumState.PERFORM_RESPAWN));
      this.field_146297_k.func_147108_a((GuiScreen)null);
   }

   public boolean func_73868_f() {
      return true;
   }

   public void func_73866_w_() {
      if(this.field_146582_i == null) {
         this.field_146582_i = Lists.newArrayList();

         try {
            String var1 = "";
            String var2 = "" + EnumChatFormatting.WHITE + EnumChatFormatting.OBFUSCATED + EnumChatFormatting.GREEN + EnumChatFormatting.AQUA;
            short var3 = 274;
            BufferedReader var4 = new BufferedReader(new InputStreamReader(this.field_146297_k.func_110442_L().func_110536_a(new ResourceLocation("texts/end.txt")).func_110527_b(), Charsets.UTF_8));
            Random var5 = new Random(8124371L);

            int var6;
            while((var1 = var4.readLine()) != null) {
               String var7;
               String var8;
               for(var1 = var1.replaceAll("PLAYERNAME", this.field_146297_k.func_110432_I().func_111285_a()); var1.contains(var2); var1 = var7 + EnumChatFormatting.WHITE + EnumChatFormatting.OBFUSCATED + "XXXXXXXX".substring(0, var5.nextInt(4) + 3) + var8) {
                  var6 = var1.indexOf(var2);
                  var7 = var1.substring(0, var6);
                  var8 = var1.substring(var6 + var2.length());
               }

               this.field_146582_i.addAll(this.field_146297_k.field_71466_p.func_78271_c(var1, var3));
               this.field_146582_i.add("");
            }

            for(var6 = 0; var6 < 8; ++var6) {
               this.field_146582_i.add("");
            }

            var4 = new BufferedReader(new InputStreamReader(this.field_146297_k.func_110442_L().func_110536_a(new ResourceLocation("texts/credits.txt")).func_110527_b(), Charsets.UTF_8));

            while((var1 = var4.readLine()) != null) {
               var1 = var1.replaceAll("PLAYERNAME", this.field_146297_k.func_110432_I().func_111285_a());
               var1 = var1.replaceAll("\t", "    ");
               this.field_146582_i.addAll(this.field_146297_k.field_71466_p.func_78271_c(var1, var3));
               this.field_146582_i.add("");
            }

            this.field_146579_r = this.field_146582_i.size() * 12;
         } catch (Exception var9) {
            field_146580_a.error("Couldn\'t load credits", var9);
         }

      }
   }

   private void func_146575_b(int p_146575_1_, int p_146575_2_, float p_146575_3_) {
      Tessellator var4 = Tessellator.func_178181_a();
      WorldRenderer var5 = var4.func_178180_c();
      this.field_146297_k.func_110434_K().func_110577_a(Gui.field_110325_k);
      var5.func_178970_b();
      var5.func_178960_a(1.0F, 1.0F, 1.0F, 1.0F);
      int var6 = this.field_146294_l;
      float var7 = 0.0F - ((float)this.field_146581_h + p_146575_3_) * 0.5F * this.field_146578_s;
      float var8 = (float)this.field_146295_m - ((float)this.field_146581_h + p_146575_3_) * 0.5F * this.field_146578_s;
      float var9 = 0.015625F;
      float var10 = ((float)this.field_146581_h + p_146575_3_ - 0.0F) * 0.02F;
      float var11 = (float)(this.field_146579_r + this.field_146295_m + this.field_146295_m + 24) / this.field_146578_s;
      float var12 = (var11 - 20.0F - ((float)this.field_146581_h + p_146575_3_)) * 0.005F;
      if(var12 < var10) {
         var10 = var12;
      }

      if(var10 > 1.0F) {
         var10 = 1.0F;
      }

      var10 *= var10;
      var10 = var10 * 96.0F / 255.0F;
      var5.func_178986_b(var10, var10, var10);
      var5.func_178985_a(0.0D, (double)this.field_146295_m, (double)this.field_73735_i, 0.0D, (double)(var7 * var9));
      var5.func_178985_a((double)var6, (double)this.field_146295_m, (double)this.field_73735_i, (double)((float)var6 * var9), (double)(var7 * var9));
      var5.func_178985_a((double)var6, 0.0D, (double)this.field_73735_i, (double)((float)var6 * var9), (double)(var8 * var9));
      var5.func_178985_a(0.0D, 0.0D, (double)this.field_73735_i, 0.0D, (double)(var8 * var9));
      var4.func_78381_a();
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_146575_b(p_73863_1_, p_73863_2_, p_73863_3_);
      Tessellator var4 = Tessellator.func_178181_a();
      WorldRenderer var5 = var4.func_178180_c();
      short var6 = 274;
      int var7 = this.field_146294_l / 2 - var6 / 2;
      int var8 = this.field_146295_m + 50;
      float var9 = -((float)this.field_146581_h + p_73863_3_) * this.field_146578_s;
      GlStateManager.func_179094_E();
      GlStateManager.func_179109_b(0.0F, var9, 0.0F);
      this.field_146297_k.func_110434_K().func_110577_a(field_146576_f);
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      this.func_73729_b(var7, var8, 0, 0, 155, 44);
      this.func_73729_b(var7 + 155, var8, 0, 45, 155, 44);
      var5.func_178991_c(16777215);
      int var10 = var8 + 200;

      int var11;
      for(var11 = 0; var11 < this.field_146582_i.size(); ++var11) {
         if(var11 == this.field_146582_i.size() - 1) {
            float var12 = (float)var10 + var9 - (float)(this.field_146295_m / 2 - 6);
            if(var12 < 0.0F) {
               GlStateManager.func_179109_b(0.0F, -var12, 0.0F);
            }
         }

         if((float)var10 + var9 + 12.0F + 8.0F > 0.0F && (float)var10 + var9 < (float)this.field_146295_m) {
            String var13 = (String)this.field_146582_i.get(var11);
            if(var13.startsWith("[C]")) {
               this.field_146289_q.func_175063_a(var13.substring(3), (float)(var7 + (var6 - this.field_146289_q.func_78256_a(var13.substring(3))) / 2), (float)var10, 16777215);
            } else {
               this.field_146289_q.field_78289_c.setSeed((long)var11 * 4238972211L + (long)(this.field_146581_h / 4));
               this.field_146289_q.func_175063_a(var13, (float)var7, (float)var10, 16777215);
            }
         }

         var10 += 12;
      }

      GlStateManager.func_179121_F();
      this.field_146297_k.func_110434_K().func_110577_a(field_146577_g);
      GlStateManager.func_179147_l();
      GlStateManager.func_179112_b(0, 769);
      var5.func_178970_b();
      var5.func_178960_a(1.0F, 1.0F, 1.0F, 1.0F);
      var11 = this.field_146294_l;
      int var14 = this.field_146295_m;
      var5.func_178985_a(0.0D, (double)var14, (double)this.field_73735_i, 0.0D, 1.0D);
      var5.func_178985_a((double)var11, (double)var14, (double)this.field_73735_i, 1.0D, 1.0D);
      var5.func_178985_a((double)var11, 0.0D, (double)this.field_73735_i, 1.0D, 0.0D);
      var5.func_178985_a(0.0D, 0.0D, (double)this.field_73735_i, 0.0D, 0.0D);
      var4.func_78381_a();
      GlStateManager.func_179084_k();
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

}
