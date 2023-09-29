package net.minecraft.client.gui.stream;

import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.stream.IngestServerTester;
import net.minecraft.util.EnumChatFormatting;
import tv.twitch.broadcast.IngestServer;

public class GuiIngestServers extends GuiScreen {

   private final GuiScreen field_152309_a;
   private String field_152310_f;
   private GuiIngestServers.ServerList field_152311_g;
   private static final String __OBFID = "CL_00001843";


   public GuiIngestServers(GuiScreen p_i46312_1_) {
      this.field_152309_a = p_i46312_1_;
   }

   public void func_73866_w_() {
      this.field_152310_f = I18n.func_135052_a("options.stream.ingest.title", new Object[0]);
      this.field_152311_g = new GuiIngestServers.ServerList(this.field_146297_k);
      if(!this.field_146297_k.func_152346_Z().func_152908_z()) {
         this.field_146297_k.func_152346_Z().func_152909_x();
      }

      this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 155, this.field_146295_m - 24 - 6, 150, 20, I18n.func_135052_a("gui.done", new Object[0])));
      this.field_146292_n.add(new GuiButton(2, this.field_146294_l / 2 + 5, this.field_146295_m - 24 - 6, 150, 20, I18n.func_135052_a("options.stream.ingest.reset", new Object[0])));
   }

   public void func_146274_d() throws IOException {
      super.func_146274_d();
      this.field_152311_g.func_178039_p();
   }

   public void func_146281_b() {
      if(this.field_146297_k.func_152346_Z().func_152908_z()) {
         this.field_146297_k.func_152346_Z().func_152932_y().func_153039_l();
      }

   }

   protected void func_146284_a(GuiButton p_146284_1_) throws IOException {
      if(p_146284_1_.field_146124_l) {
         if(p_146284_1_.field_146127_k == 1) {
            this.field_146297_k.func_147108_a(this.field_152309_a);
         } else {
            this.field_146297_k.field_71474_y.field_152407_Q = "";
            this.field_146297_k.field_71474_y.func_74303_b();
         }

      }
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_146276_q_();
      this.field_152311_g.func_148128_a(p_73863_1_, p_73863_2_, p_73863_3_);
      this.func_73732_a(this.field_146289_q, this.field_152310_f, this.field_146294_l / 2, 20, 16777215);
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   class ServerList extends GuiSlot {

      private static final String __OBFID = "CL_00001842";


      public ServerList(Minecraft p_i45499_2_) {
         super(p_i45499_2_, GuiIngestServers.this.field_146294_l, GuiIngestServers.this.field_146295_m, 32, GuiIngestServers.this.field_146295_m - 35, (int)((double)p_i45499_2_.field_71466_p.field_78288_b * 3.5D));
         this.func_148130_a(false);
      }

      protected int func_148127_b() {
         return this.field_148161_k.func_152346_Z().func_152925_v().length;
      }

      protected void func_148144_a(int p_148144_1_, boolean p_148144_2_, int p_148144_3_, int p_148144_4_) {
         this.field_148161_k.field_71474_y.field_152407_Q = this.field_148161_k.func_152346_Z().func_152925_v()[p_148144_1_].serverUrl;
         this.field_148161_k.field_71474_y.func_74303_b();
      }

      protected boolean func_148131_a(int p_148131_1_) {
         return this.field_148161_k.func_152346_Z().func_152925_v()[p_148131_1_].serverUrl.equals(this.field_148161_k.field_71474_y.field_152407_Q);
      }

      protected void func_148123_a() {}

      protected void func_180791_a(int p_180791_1_, int p_180791_2_, int p_180791_3_, int p_180791_4_, int p_180791_5_, int p_180791_6_) {
         IngestServer var7 = this.field_148161_k.func_152346_Z().func_152925_v()[p_180791_1_];
         String var8 = var7.serverUrl.replaceAll("\\{stream_key\\}", "");
         String var9 = (int)var7.bitrateKbps + " kbps";
         String var10 = null;
         IngestServerTester var11 = this.field_148161_k.func_152346_Z().func_152932_y();
         if(var11 != null) {
            if(var7 == var11.func_153040_c()) {
               var8 = EnumChatFormatting.GREEN + var8;
               var9 = (int)(var11.func_153030_h() * 100.0F) + "%";
            } else if(p_180791_1_ < var11.func_153028_p()) {
               if(var7.bitrateKbps == 0.0F) {
                  var9 = EnumChatFormatting.RED + "Down!";
               }
            } else {
               var9 = EnumChatFormatting.OBFUSCATED + "1234" + EnumChatFormatting.RESET + " kbps";
            }
         } else if(var7.bitrateKbps == 0.0F) {
            var9 = EnumChatFormatting.RED + "Down!";
         }

         p_180791_2_ -= 15;
         if(this.func_148131_a(p_180791_1_)) {
            var10 = EnumChatFormatting.BLUE + "(Preferred)";
         } else if(var7.defaultServer) {
            var10 = EnumChatFormatting.GREEN + "(Default)";
         }

         GuiIngestServers.this.func_73731_b(GuiIngestServers.this.field_146289_q, var7.serverName, p_180791_2_ + 2, p_180791_3_ + 5, 16777215);
         GuiIngestServers.this.func_73731_b(GuiIngestServers.this.field_146289_q, var8, p_180791_2_ + 2, p_180791_3_ + GuiIngestServers.this.field_146289_q.field_78288_b + 5 + 3, 3158064);
         GuiIngestServers.this.func_73731_b(GuiIngestServers.this.field_146289_q, var9, this.func_148137_d() - 5 - GuiIngestServers.this.field_146289_q.func_78256_a(var9), p_180791_3_ + 5, 8421504);
         if(var10 != null) {
            GuiIngestServers.this.func_73731_b(GuiIngestServers.this.field_146289_q, var10, this.func_148137_d() - 5 - GuiIngestServers.this.field_146289_q.func_78256_a(var10), p_180791_3_ + 5 + 3 + GuiIngestServers.this.field_146289_q.field_78288_b, 8421504);
         }

      }

      protected int func_148137_d() {
         return super.func_148137_d() + 15;
      }
   }
}
