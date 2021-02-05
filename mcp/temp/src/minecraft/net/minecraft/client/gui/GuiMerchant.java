package net.minecraft.client.gui;

import io.netty.buffer.Unpooled;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GuiMerchant extends GuiContainer {

   private static final Logger field_147039_u = LogManager.getLogger();
   private static final ResourceLocation field_147038_v = new ResourceLocation("textures/gui/container/villager.png");
   private IMerchant field_147037_w;
   private GuiMerchant.MerchantButton field_147043_x;
   private GuiMerchant.MerchantButton field_147042_y;
   private int field_147041_z;
   private IChatComponent field_147040_A;
   private static final String __OBFID = "CL_00000762";


   public GuiMerchant(InventoryPlayer p_i45500_1_, IMerchant p_i45500_2_, World p_i45500_3_) {
      super(new ContainerMerchant(p_i45500_1_, p_i45500_2_, p_i45500_3_));
      this.field_147037_w = p_i45500_2_;
      this.field_147040_A = p_i45500_2_.func_145748_c_();
   }

   public void func_73866_w_() {
      super.func_73866_w_();
      int var1 = (this.field_146294_l - this.field_146999_f) / 2;
      int var2 = (this.field_146295_m - this.field_147000_g) / 2;
      this.field_146292_n.add(this.field_147043_x = new GuiMerchant.MerchantButton(1, var1 + 120 + 27, var2 + 24 - 1, true));
      this.field_146292_n.add(this.field_147042_y = new GuiMerchant.MerchantButton(2, var1 + 36 - 19, var2 + 24 - 1, false));
      this.field_147043_x.field_146124_l = false;
      this.field_147042_y.field_146124_l = false;
   }

   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
      String var3 = this.field_147040_A.func_150260_c();
      this.field_146289_q.func_78276_b(var3, this.field_146999_f / 2 - this.field_146289_q.func_78256_a(var3) / 2, 6, 4210752);
      this.field_146289_q.func_78276_b(I18n.func_135052_a("container.inventory", new Object[0]), 8, this.field_147000_g - 96 + 2, 4210752);
   }

   public void func_73876_c() {
      super.func_73876_c();
      MerchantRecipeList var1 = this.field_147037_w.func_70934_b(this.field_146297_k.field_71439_g);
      if(var1 != null) {
         this.field_147043_x.field_146124_l = this.field_147041_z < var1.size() - 1;
         this.field_147042_y.field_146124_l = this.field_147041_z > 0;
      }

   }

   protected void func_146284_a(GuiButton p_146284_1_) throws IOException {
      boolean var2 = false;
      if(p_146284_1_ == this.field_147043_x) {
         ++this.field_147041_z;
         MerchantRecipeList var3 = this.field_147037_w.func_70934_b(this.field_146297_k.field_71439_g);
         if(var3 != null && this.field_147041_z >= var3.size()) {
            this.field_147041_z = var3.size() - 1;
         }

         var2 = true;
      } else if(p_146284_1_ == this.field_147042_y) {
         --this.field_147041_z;
         if(this.field_147041_z < 0) {
            this.field_147041_z = 0;
         }

         var2 = true;
      }

      if(var2) {
         ((ContainerMerchant)this.field_147002_h).func_75175_c(this.field_147041_z);
         PacketBuffer var4 = new PacketBuffer(Unpooled.buffer());
         var4.writeInt(this.field_147041_z);
         this.field_146297_k.func_147114_u().func_147297_a(new C17PacketCustomPayload("MC|TrSel", var4));
      }

   }

   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_146297_k.func_110434_K().func_110577_a(field_147038_v);
      int var4 = (this.field_146294_l - this.field_146999_f) / 2;
      int var5 = (this.field_146295_m - this.field_147000_g) / 2;
      this.func_73729_b(var4, var5, 0, 0, this.field_146999_f, this.field_147000_g);
      MerchantRecipeList var6 = this.field_147037_w.func_70934_b(this.field_146297_k.field_71439_g);
      if(var6 != null && !var6.isEmpty()) {
         int var7 = this.field_147041_z;
         if(var7 < 0 || var7 >= var6.size()) {
            return;
         }

         MerchantRecipe var8 = (MerchantRecipe)var6.get(var7);
         if(var8.func_82784_g()) {
            this.field_146297_k.func_110434_K().func_110577_a(field_147038_v);
            GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.func_179140_f();
            this.func_73729_b(this.field_147003_i + 83, this.field_147009_r + 21, 212, 0, 28, 21);
            this.func_73729_b(this.field_147003_i + 83, this.field_147009_r + 51, 212, 0, 28, 21);
         }
      }

   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
      MerchantRecipeList var4 = this.field_147037_w.func_70934_b(this.field_146297_k.field_71439_g);
      if(var4 != null && !var4.isEmpty()) {
         int var5 = (this.field_146294_l - this.field_146999_f) / 2;
         int var6 = (this.field_146295_m - this.field_147000_g) / 2;
         int var7 = this.field_147041_z;
         MerchantRecipe var8 = (MerchantRecipe)var4.get(var7);
         ItemStack var9 = var8.func_77394_a();
         ItemStack var10 = var8.func_77396_b();
         ItemStack var11 = var8.func_77397_d();
         GlStateManager.func_179094_E();
         RenderHelper.func_74520_c();
         GlStateManager.func_179140_f();
         GlStateManager.func_179091_B();
         GlStateManager.func_179142_g();
         GlStateManager.func_179145_e();
         this.field_146296_j.field_77023_b = 100.0F;
         this.field_146296_j.func_180450_b(var9, var5 + 36, var6 + 24);
         this.field_146296_j.func_175030_a(this.field_146289_q, var9, var5 + 36, var6 + 24);
         if(var10 != null) {
            this.field_146296_j.func_180450_b(var10, var5 + 62, var6 + 24);
            this.field_146296_j.func_175030_a(this.field_146289_q, var10, var5 + 62, var6 + 24);
         }

         this.field_146296_j.func_180450_b(var11, var5 + 120, var6 + 24);
         this.field_146296_j.func_175030_a(this.field_146289_q, var11, var5 + 120, var6 + 24);
         this.field_146296_j.field_77023_b = 0.0F;
         GlStateManager.func_179140_f();
         if(this.func_146978_c(36, 24, 16, 16, p_73863_1_, p_73863_2_) && var9 != null) {
            this.func_146285_a(var9, p_73863_1_, p_73863_2_);
         } else if(var10 != null && this.func_146978_c(62, 24, 16, 16, p_73863_1_, p_73863_2_) && var10 != null) {
            this.func_146285_a(var10, p_73863_1_, p_73863_2_);
         } else if(var11 != null && this.func_146978_c(120, 24, 16, 16, p_73863_1_, p_73863_2_) && var11 != null) {
            this.func_146285_a(var11, p_73863_1_, p_73863_2_);
         } else if(var8.func_82784_g() && (this.func_146978_c(83, 21, 28, 21, p_73863_1_, p_73863_2_) || this.func_146978_c(83, 51, 28, 21, p_73863_1_, p_73863_2_))) {
            this.func_146279_a(I18n.func_135052_a("merchant.deprecated", new Object[0]), p_73863_1_, p_73863_2_);
         }

         GlStateManager.func_179121_F();
         GlStateManager.func_179145_e();
         GlStateManager.func_179126_j();
         RenderHelper.func_74519_b();
      }

   }

   public IMerchant func_147035_g() {
      return this.field_147037_w;
   }


   static class MerchantButton extends GuiButton {

      private final boolean field_146157_o;
      private static final String __OBFID = "CL_00000763";


      public MerchantButton(int p_i1095_1_, int p_i1095_2_, int p_i1095_3_, boolean p_i1095_4_) {
         super(p_i1095_1_, p_i1095_2_, p_i1095_3_, 12, 19, "");
         this.field_146157_o = p_i1095_4_;
      }

      public void func_146112_a(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_) {
         if(this.field_146125_m) {
            p_146112_1_.func_110434_K().func_110577_a(GuiMerchant.field_147038_v);
            GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
            boolean var4 = p_146112_2_ >= this.field_146128_h && p_146112_3_ >= this.field_146129_i && p_146112_2_ < this.field_146128_h + this.field_146120_f && p_146112_3_ < this.field_146129_i + this.field_146121_g;
            int var5 = 0;
            int var6 = 176;
            if(!this.field_146124_l) {
               var6 += this.field_146120_f * 2;
            } else if(var4) {
               var6 += this.field_146120_f;
            }

            if(!this.field_146157_o) {
               var5 += this.field_146121_g;
            }

            this.func_73729_b(this.field_146128_h, this.field_146129_i, var6, var5, this.field_146120_f, this.field_146121_g);
         }
      }
   }
}
