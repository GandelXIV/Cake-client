package net.minecraft.client.gui;

import com.google.common.base.Charsets;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import java.awt.image.BufferedImage;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServerListEntryNormal implements GuiListExtended.IGuiListEntry {

   private static final Logger field_148304_a = LogManager.getLogger();
   private static final ThreadPoolExecutor field_148302_b = new ScheduledThreadPoolExecutor(5, (new ThreadFactoryBuilder()).setNameFormat("Server Pinger #%d").setDaemon(true).build());
   private static final ResourceLocation field_178015_c = new ResourceLocation("textures/misc/unknown_server.png");
   private static final ResourceLocation field_178014_d = new ResourceLocation("textures/gui/server_selection.png");
   private final GuiMultiplayer field_148303_c;
   private final Minecraft field_148300_d;
   private final ServerData field_148301_e;
   private final ResourceLocation field_148306_i;
   private String field_148299_g;
   private DynamicTexture field_148305_h;
   private long field_148298_f;
   private static final String __OBFID = "CL_00000817";


   protected ServerListEntryNormal(GuiMultiplayer p_i45048_1_, ServerData p_i45048_2_) {
      this.field_148303_c = p_i45048_1_;
      this.field_148301_e = p_i45048_2_;
      this.field_148300_d = Minecraft.func_71410_x();
      this.field_148306_i = new ResourceLocation("servers/" + p_i45048_2_.field_78845_b + "/icon");
      this.field_148305_h = (DynamicTexture)this.field_148300_d.func_110434_K().func_110581_b(this.field_148306_i);
   }

   public void func_180790_a(int p_180790_1_, int p_180790_2_, int p_180790_3_, int p_180790_4_, int p_180790_5_, int p_180790_6_, int p_180790_7_, boolean p_180790_8_) {
      if(!this.field_148301_e.field_78841_f) {
         this.field_148301_e.field_78841_f = true;
         this.field_148301_e.field_78844_e = -2L;
         this.field_148301_e.field_78843_d = "";
         this.field_148301_e.field_78846_c = "";
         field_148302_b.submit(new Runnable() {

            private static final String __OBFID = "CL_00000818";

            public void run() {
               try {
                  ServerListEntryNormal.this.field_148303_c.func_146789_i().func_147224_a(ServerListEntryNormal.this.field_148301_e);
               } catch (UnknownHostException var2) {
                  ServerListEntryNormal.this.field_148301_e.field_78844_e = -1L;
                  ServerListEntryNormal.this.field_148301_e.field_78843_d = EnumChatFormatting.DARK_RED + "Can\'t resolve hostname";
               } catch (Exception var3) {
                  ServerListEntryNormal.this.field_148301_e.field_78844_e = -1L;
                  ServerListEntryNormal.this.field_148301_e.field_78843_d = EnumChatFormatting.DARK_RED + "Can\'t connect to server.";
               }

            }
         });
      }

      boolean var9 = this.field_148301_e.field_82821_f > 47;
      boolean var10 = this.field_148301_e.field_82821_f < 47;
      boolean var11 = var9 || var10;
      this.field_148300_d.field_71466_p.func_78276_b(this.field_148301_e.field_78847_a, p_180790_2_ + 32 + 3, p_180790_3_ + 1, 16777215);
      List var12 = this.field_148300_d.field_71466_p.func_78271_c(this.field_148301_e.field_78843_d, p_180790_4_ - 32 - 2);

      for(int var13 = 0; var13 < Math.min(var12.size(), 2); ++var13) {
         this.field_148300_d.field_71466_p.func_78276_b((String)var12.get(var13), p_180790_2_ + 32 + 3, p_180790_3_ + 12 + this.field_148300_d.field_71466_p.field_78288_b * var13, 8421504);
      }

      String var23 = var11?EnumChatFormatting.DARK_RED + this.field_148301_e.field_82822_g:this.field_148301_e.field_78846_c;
      int var14 = this.field_148300_d.field_71466_p.func_78256_a(var23);
      this.field_148300_d.field_71466_p.func_78276_b(var23, p_180790_2_ + p_180790_4_ - var14 - 15 - 2, p_180790_3_ + 1, 8421504);
      byte var15 = 0;
      String var17 = null;
      int var16;
      String var18;
      if(var11) {
         var16 = 5;
         var18 = var9?"Client out of date!":"Server out of date!";
         var17 = this.field_148301_e.field_147412_i;
      } else if(this.field_148301_e.field_78841_f && this.field_148301_e.field_78844_e != -2L) {
         if(this.field_148301_e.field_78844_e < 0L) {
            var16 = 5;
         } else if(this.field_148301_e.field_78844_e < 150L) {
            var16 = 0;
         } else if(this.field_148301_e.field_78844_e < 300L) {
            var16 = 1;
         } else if(this.field_148301_e.field_78844_e < 600L) {
            var16 = 2;
         } else if(this.field_148301_e.field_78844_e < 1000L) {
            var16 = 3;
         } else {
            var16 = 4;
         }

         if(this.field_148301_e.field_78844_e < 0L) {
            var18 = "(no connection)";
         } else {
            var18 = this.field_148301_e.field_78844_e + "ms";
            var17 = this.field_148301_e.field_147412_i;
         }
      } else {
         var15 = 1;
         var16 = (int)(Minecraft.func_71386_F() / 100L + (long)(p_180790_1_ * 2) & 7L);
         if(var16 > 4) {
            var16 = 8 - var16;
         }

         var18 = "Pinging...";
      }

      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_148300_d.func_110434_K().func_110577_a(Gui.field_110324_m);
      Gui.func_146110_a(p_180790_2_ + p_180790_4_ - 15, p_180790_3_, (float)(var15 * 10), (float)(176 + var16 * 8), 10, 8, 256.0F, 256.0F);
      if(this.field_148301_e.func_147409_e() != null && !this.field_148301_e.func_147409_e().equals(this.field_148299_g)) {
         this.field_148299_g = this.field_148301_e.func_147409_e();
         this.func_148297_b();
         this.field_148303_c.func_146795_p().func_78855_b();
      }

      if(this.field_148305_h != null) {
         this.func_178012_a(p_180790_2_, p_180790_3_, this.field_148306_i);
      } else {
         this.func_178012_a(p_180790_2_, p_180790_3_, field_178015_c);
      }

      int var19 = p_180790_6_ - p_180790_2_;
      int var20 = p_180790_7_ - p_180790_3_;
      if(var19 >= p_180790_4_ - 15 && var19 <= p_180790_4_ - 5 && var20 >= 0 && var20 <= 8) {
         this.field_148303_c.func_146793_a(var18);
      } else if(var19 >= p_180790_4_ - var14 - 15 - 2 && var19 <= p_180790_4_ - 15 - 2 && var20 >= 0 && var20 <= 8) {
         this.field_148303_c.func_146793_a(var17);
      }

      if(this.field_148300_d.field_71474_y.field_85185_A || p_180790_8_) {
         this.field_148300_d.func_110434_K().func_110577_a(field_178014_d);
         Gui.func_73734_a(p_180790_2_, p_180790_3_, p_180790_2_ + 32, p_180790_3_ + 32, -1601138544);
         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
         int var21 = p_180790_6_ - p_180790_2_;
         int var22 = p_180790_7_ - p_180790_3_;
         if(this.func_178013_b()) {
            if(var21 < 32 && var21 > 16) {
               Gui.func_146110_a(p_180790_2_, p_180790_3_, 0.0F, 32.0F, 32, 32, 256.0F, 256.0F);
            } else {
               Gui.func_146110_a(p_180790_2_, p_180790_3_, 0.0F, 0.0F, 32, 32, 256.0F, 256.0F);
            }
         }

         if(this.field_148303_c.func_175392_a(this, p_180790_1_)) {
            if(var21 < 16 && var22 < 16) {
               Gui.func_146110_a(p_180790_2_, p_180790_3_, 96.0F, 32.0F, 32, 32, 256.0F, 256.0F);
            } else {
               Gui.func_146110_a(p_180790_2_, p_180790_3_, 96.0F, 0.0F, 32, 32, 256.0F, 256.0F);
            }
         }

         if(this.field_148303_c.func_175394_b(this, p_180790_1_)) {
            if(var21 < 16 && var22 > 16) {
               Gui.func_146110_a(p_180790_2_, p_180790_3_, 64.0F, 32.0F, 32, 32, 256.0F, 256.0F);
            } else {
               Gui.func_146110_a(p_180790_2_, p_180790_3_, 64.0F, 0.0F, 32, 32, 256.0F, 256.0F);
            }
         }
      }

   }

   protected void func_178012_a(int p_178012_1_, int p_178012_2_, ResourceLocation p_178012_3_) {
      this.field_148300_d.func_110434_K().func_110577_a(p_178012_3_);
      GlStateManager.func_179147_l();
      Gui.func_146110_a(p_178012_1_, p_178012_2_, 0.0F, 0.0F, 32, 32, 32.0F, 32.0F);
      GlStateManager.func_179084_k();
   }

   private boolean func_178013_b() {
      return true;
   }

   private void func_148297_b() {
      if(this.field_148301_e.func_147409_e() == null) {
         this.field_148300_d.func_110434_K().func_147645_c(this.field_148306_i);
         this.field_148305_h = null;
      } else {
         ByteBuf var2 = Unpooled.copiedBuffer(this.field_148301_e.func_147409_e(), Charsets.UTF_8);
         ByteBuf var3 = Base64.decode(var2);

         BufferedImage var1;
         label74: {
            try {
               var1 = TextureUtil.func_177053_a(new ByteBufInputStream(var3));
               Validate.validState(var1.getWidth() == 64, "Must be 64 pixels wide", new Object[0]);
               Validate.validState(var1.getHeight() == 64, "Must be 64 pixels high", new Object[0]);
               break label74;
            } catch (Exception var8) {
               field_148304_a.error("Invalid icon for server " + this.field_148301_e.field_78847_a + " (" + this.field_148301_e.field_78845_b + ")", var8);
               this.field_148301_e.func_147407_a((String)null);
            } finally {
               var2.release();
               var3.release();
            }

            return;
         }

         if(this.field_148305_h == null) {
            this.field_148305_h = new DynamicTexture(var1.getWidth(), var1.getHeight());
            this.field_148300_d.func_110434_K().func_110579_a(this.field_148306_i, this.field_148305_h);
         }

         var1.getRGB(0, 0, var1.getWidth(), var1.getHeight(), this.field_148305_h.func_110565_c(), 0, var1.getWidth());
         this.field_148305_h.func_110564_a();
      }

   }

   public boolean func_148278_a(int p_148278_1_, int p_148278_2_, int p_148278_3_, int p_148278_4_, int p_148278_5_, int p_148278_6_) {
      if(p_148278_5_ <= 32) {
         if(p_148278_5_ < 32 && p_148278_5_ > 16 && this.func_178013_b()) {
            this.field_148303_c.func_146790_a(p_148278_1_);
            this.field_148303_c.func_146796_h();
            return true;
         }

         if(p_148278_5_ < 16 && p_148278_6_ < 16 && this.field_148303_c.func_175392_a(this, p_148278_1_)) {
            this.field_148303_c.func_175391_a(this, p_148278_1_, GuiScreen.func_146272_n());
            return true;
         }

         if(p_148278_5_ < 16 && p_148278_6_ > 16 && this.field_148303_c.func_175394_b(this, p_148278_1_)) {
            this.field_148303_c.func_175393_b(this, p_148278_1_, GuiScreen.func_146272_n());
            return true;
         }
      }

      this.field_148303_c.func_146790_a(p_148278_1_);
      if(Minecraft.func_71386_F() - this.field_148298_f < 250L) {
         this.field_148303_c.func_146796_h();
      }

      this.field_148298_f = Minecraft.func_71386_F();
      return false;
   }

   public void func_178011_a(int p_178011_1_, int p_178011_2_, int p_178011_3_) {}

   public void func_148277_b(int p_148277_1_, int p_148277_2_, int p_148277_3_, int p_148277_4_, int p_148277_5_, int p_148277_6_) {}

   public ServerData func_148296_a() {
      return this.field_148301_e;
   }

}
