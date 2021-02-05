package net.minecraft.client.gui.inventory;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.achievement.GuiAchievements;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.gui.inventory.CreativeCrafting;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class GuiContainerCreative extends InventoryEffectRenderer {

   private static final ResourceLocation field_147061_u = new ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
   private static InventoryBasic field_147060_v = new InventoryBasic("tmp", true, 45);
   private static int field_147058_w = CreativeTabs.field_78030_b.func_78021_a();
   private float field_147067_x;
   private boolean field_147066_y;
   private boolean field_147065_z;
   private GuiTextField field_147062_A;
   private List field_147063_B;
   private Slot field_147064_C;
   private boolean field_147057_D;
   private CreativeCrafting field_147059_E;
   private static final String __OBFID = "CL_00000752";


   public GuiContainerCreative(EntityPlayer p_i1088_1_) {
      super(new GuiContainerCreative.ContainerCreative(p_i1088_1_));
      p_i1088_1_.field_71070_bA = this.field_147002_h;
      this.field_146291_p = true;
      this.field_147000_g = 136;
      this.field_146999_f = 195;
   }

   public void func_73876_c() {
      if(!this.field_146297_k.field_71442_b.func_78758_h()) {
         this.field_146297_k.func_147108_a(new GuiInventory(this.field_146297_k.field_71439_g));
      }

      this.func_175378_g();
   }

   protected void func_146984_a(Slot p_146984_1_, int p_146984_2_, int p_146984_3_, int p_146984_4_) {
      this.field_147057_D = true;
      boolean var5 = p_146984_4_ == 1;
      p_146984_4_ = p_146984_2_ == -999 && p_146984_4_ == 0?4:p_146984_4_;
      ItemStack var7;
      InventoryPlayer var11;
      if(p_146984_1_ == null && field_147058_w != CreativeTabs.field_78036_m.func_78021_a() && p_146984_4_ != 5) {
         var11 = this.field_146297_k.field_71439_g.field_71071_by;
         if(var11.func_70445_o() != null) {
            if(p_146984_3_ == 0) {
               this.field_146297_k.field_71439_g.func_71019_a(var11.func_70445_o(), true);
               this.field_146297_k.field_71442_b.func_78752_a(var11.func_70445_o());
               var11.func_70437_b((ItemStack)null);
            }

            if(p_146984_3_ == 1) {
               var7 = var11.func_70445_o().func_77979_a(1);
               this.field_146297_k.field_71439_g.func_71019_a(var7, true);
               this.field_146297_k.field_71442_b.func_78752_a(var7);
               if(var11.func_70445_o().field_77994_a == 0) {
                  var11.func_70437_b((ItemStack)null);
               }
            }
         }
      } else {
         int var10;
         if(p_146984_1_ == this.field_147064_C && var5) {
            for(var10 = 0; var10 < this.field_146297_k.field_71439_g.field_71069_bz.func_75138_a().size(); ++var10) {
               this.field_146297_k.field_71442_b.func_78761_a((ItemStack)null, var10);
            }
         } else {
            ItemStack var6;
            if(field_147058_w == CreativeTabs.field_78036_m.func_78021_a()) {
               if(p_146984_1_ == this.field_147064_C) {
                  this.field_146297_k.field_71439_g.field_71071_by.func_70437_b((ItemStack)null);
               } else if(p_146984_4_ == 4 && p_146984_1_ != null && p_146984_1_.func_75216_d()) {
                  var6 = p_146984_1_.func_75209_a(p_146984_3_ == 0?1:p_146984_1_.func_75211_c().func_77976_d());
                  this.field_146297_k.field_71439_g.func_71019_a(var6, true);
                  this.field_146297_k.field_71442_b.func_78752_a(var6);
               } else if(p_146984_4_ == 4 && this.field_146297_k.field_71439_g.field_71071_by.func_70445_o() != null) {
                  this.field_146297_k.field_71439_g.func_71019_a(this.field_146297_k.field_71439_g.field_71071_by.func_70445_o(), true);
                  this.field_146297_k.field_71442_b.func_78752_a(this.field_146297_k.field_71439_g.field_71071_by.func_70445_o());
                  this.field_146297_k.field_71439_g.field_71071_by.func_70437_b((ItemStack)null);
               } else {
                  this.field_146297_k.field_71439_g.field_71069_bz.func_75144_a(p_146984_1_ == null?p_146984_2_:((GuiContainerCreative.CreativeSlot)p_146984_1_).field_148332_b.field_75222_d, p_146984_3_, p_146984_4_, this.field_146297_k.field_71439_g);
                  this.field_146297_k.field_71439_g.field_71069_bz.func_75142_b();
               }
            } else if(p_146984_4_ != 5 && p_146984_1_.field_75224_c == field_147060_v) {
               var11 = this.field_146297_k.field_71439_g.field_71071_by;
               var7 = var11.func_70445_o();
               ItemStack var8 = p_146984_1_.func_75211_c();
               ItemStack var9;
               if(p_146984_4_ == 2) {
                  if(var8 != null && p_146984_3_ >= 0 && p_146984_3_ < 9) {
                     var9 = var8.func_77946_l();
                     var9.field_77994_a = var9.func_77976_d();
                     this.field_146297_k.field_71439_g.field_71071_by.func_70299_a(p_146984_3_, var9);
                     this.field_146297_k.field_71439_g.field_71069_bz.func_75142_b();
                  }

                  return;
               }

               if(p_146984_4_ == 3) {
                  if(var11.func_70445_o() == null && p_146984_1_.func_75216_d()) {
                     var9 = p_146984_1_.func_75211_c().func_77946_l();
                     var9.field_77994_a = var9.func_77976_d();
                     var11.func_70437_b(var9);
                  }

                  return;
               }

               if(p_146984_4_ == 4) {
                  if(var8 != null) {
                     var9 = var8.func_77946_l();
                     var9.field_77994_a = p_146984_3_ == 0?1:var9.func_77976_d();
                     this.field_146297_k.field_71439_g.func_71019_a(var9, true);
                     this.field_146297_k.field_71442_b.func_78752_a(var9);
                  }

                  return;
               }

               if(var7 != null && var8 != null && var7.func_77969_a(var8)) {
                  if(p_146984_3_ == 0) {
                     if(var5) {
                        var7.field_77994_a = var7.func_77976_d();
                     } else if(var7.field_77994_a < var7.func_77976_d()) {
                        ++var7.field_77994_a;
                     }
                  } else if(var7.field_77994_a <= 1) {
                     var11.func_70437_b((ItemStack)null);
                  } else {
                     --var7.field_77994_a;
                  }
               } else if(var8 != null && var7 == null) {
                  var11.func_70437_b(ItemStack.func_77944_b(var8));
                  var7 = var11.func_70445_o();
                  if(var5) {
                     var7.field_77994_a = var7.func_77976_d();
                  }
               } else {
                  var11.func_70437_b((ItemStack)null);
               }
            } else {
               this.field_147002_h.func_75144_a(p_146984_1_ == null?p_146984_2_:p_146984_1_.field_75222_d, p_146984_3_, p_146984_4_, this.field_146297_k.field_71439_g);
               if(Container.func_94532_c(p_146984_3_) == 2) {
                  for(var10 = 0; var10 < 9; ++var10) {
                     this.field_146297_k.field_71442_b.func_78761_a(this.field_147002_h.func_75139_a(45 + var10).func_75211_c(), 36 + var10);
                  }
               } else if(p_146984_1_ != null) {
                  var6 = this.field_147002_h.func_75139_a(p_146984_1_.field_75222_d).func_75211_c();
                  this.field_146297_k.field_71442_b.func_78761_a(var6, p_146984_1_.field_75222_d - this.field_147002_h.field_75151_b.size() + 9 + 36);
               }
            }
         }
      }

   }

   public void func_73866_w_() {
      if(this.field_146297_k.field_71442_b.func_78758_h()) {
         super.func_73866_w_();
         this.field_146292_n.clear();
         Keyboard.enableRepeatEvents(true);
         this.field_147062_A = new GuiTextField(0, this.field_146289_q, this.field_147003_i + 82, this.field_147009_r + 6, 89, this.field_146289_q.field_78288_b);
         this.field_147062_A.func_146203_f(15);
         this.field_147062_A.func_146185_a(false);
         this.field_147062_A.func_146189_e(false);
         this.field_147062_A.func_146193_g(16777215);
         int var1 = field_147058_w;
         field_147058_w = -1;
         this.func_147050_b(CreativeTabs.field_78032_a[var1]);
         this.field_147059_E = new CreativeCrafting(this.field_146297_k);
         this.field_146297_k.field_71439_g.field_71069_bz.func_75132_a(this.field_147059_E);
      } else {
         this.field_146297_k.func_147108_a(new GuiInventory(this.field_146297_k.field_71439_g));
      }

   }

   public void func_146281_b() {
      super.func_146281_b();
      if(this.field_146297_k.field_71439_g != null && this.field_146297_k.field_71439_g.field_71071_by != null) {
         this.field_146297_k.field_71439_g.field_71069_bz.func_82847_b(this.field_147059_E);
      }

      Keyboard.enableRepeatEvents(false);
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) throws IOException {
      if(field_147058_w != CreativeTabs.field_78027_g.func_78021_a()) {
         if(GameSettings.func_100015_a(this.field_146297_k.field_71474_y.field_74310_D)) {
            this.func_147050_b(CreativeTabs.field_78027_g);
         } else {
            super.func_73869_a(p_73869_1_, p_73869_2_);
         }

      } else {
         if(this.field_147057_D) {
            this.field_147057_D = false;
            this.field_147062_A.func_146180_a("");
         }

         if(!this.func_146983_a(p_73869_2_)) {
            if(this.field_147062_A.func_146201_a(p_73869_1_, p_73869_2_)) {
               this.func_147053_i();
            } else {
               super.func_73869_a(p_73869_1_, p_73869_2_);
            }

         }
      }
   }

   private void func_147053_i() {
      GuiContainerCreative.ContainerCreative var1 = (GuiContainerCreative.ContainerCreative)this.field_147002_h;
      var1.field_148330_a.clear();
      Iterator var2 = Item.field_150901_e.iterator();

      while(var2.hasNext()) {
         Item var3 = (Item)var2.next();
         if(var3 != null && var3.func_77640_w() != null) {
            var3.func_150895_a(var3, (CreativeTabs)null, var1.field_148330_a);
         }
      }

      Enchantment[] var8 = Enchantment.field_77331_b;
      int var9 = var8.length;

      for(int var4 = 0; var4 < var9; ++var4) {
         Enchantment var5 = var8[var4];
         if(var5 != null && var5.field_77351_y != null) {
            Items.field_151134_bR.func_92113_a(var5, var1.field_148330_a);
         }
      }

      var2 = var1.field_148330_a.iterator();
      String var10 = this.field_147062_A.func_146179_b().toLowerCase();

      while(var2.hasNext()) {
         ItemStack var11 = (ItemStack)var2.next();
         boolean var12 = false;
         Iterator var6 = var11.func_82840_a(this.field_146297_k.field_71439_g, this.field_146297_k.field_71474_y.field_82882_x).iterator();

         while(true) {
            if(var6.hasNext()) {
               String var7 = (String)var6.next();
               if(!EnumChatFormatting.func_110646_a(var7).toLowerCase().contains(var10)) {
                  continue;
               }

               var12 = true;
            }

            if(!var12) {
               var2.remove();
            }
            break;
         }
      }

      this.field_147067_x = 0.0F;
      var1.func_148329_a(0.0F);
   }

   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
      CreativeTabs var3 = CreativeTabs.field_78032_a[field_147058_w];
      if(var3.func_78019_g()) {
         GlStateManager.func_179084_k();
         this.field_146289_q.func_78276_b(I18n.func_135052_a(var3.func_78024_c(), new Object[0]), 8, 6, 4210752);
      }

   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) throws IOException {
      if(p_73864_3_ == 0) {
         int var4 = p_73864_1_ - this.field_147003_i;
         int var5 = p_73864_2_ - this.field_147009_r;
         CreativeTabs[] var6 = CreativeTabs.field_78032_a;
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            CreativeTabs var9 = var6[var8];
            if(this.func_147049_a(var9, var4, var5)) {
               return;
            }
         }
      }

      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   protected void func_146286_b(int p_146286_1_, int p_146286_2_, int p_146286_3_) {
      if(p_146286_3_ == 0) {
         int var4 = p_146286_1_ - this.field_147003_i;
         int var5 = p_146286_2_ - this.field_147009_r;
         CreativeTabs[] var6 = CreativeTabs.field_78032_a;
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            CreativeTabs var9 = var6[var8];
            if(this.func_147049_a(var9, var4, var5)) {
               this.func_147050_b(var9);
               return;
            }
         }
      }

      super.func_146286_b(p_146286_1_, p_146286_2_, p_146286_3_);
   }

   private boolean func_147055_p() {
      return field_147058_w != CreativeTabs.field_78036_m.func_78021_a() && CreativeTabs.field_78032_a[field_147058_w].func_78017_i() && ((GuiContainerCreative.ContainerCreative)this.field_147002_h).func_148328_e();
   }

   private void func_147050_b(CreativeTabs p_147050_1_) {
      int var2 = field_147058_w;
      field_147058_w = p_147050_1_.func_78021_a();
      GuiContainerCreative.ContainerCreative var3 = (GuiContainerCreative.ContainerCreative)this.field_147002_h;
      this.field_147008_s.clear();
      var3.field_148330_a.clear();
      p_147050_1_.func_78018_a(var3.field_148330_a);
      if(p_147050_1_ == CreativeTabs.field_78036_m) {
         Container var4 = this.field_146297_k.field_71439_g.field_71069_bz;
         if(this.field_147063_B == null) {
            this.field_147063_B = var3.field_75151_b;
         }

         var3.field_75151_b = Lists.newArrayList();

         for(int var5 = 0; var5 < var4.field_75151_b.size(); ++var5) {
            GuiContainerCreative.CreativeSlot var6 = new GuiContainerCreative.CreativeSlot((Slot)var4.field_75151_b.get(var5), var5);
            var3.field_75151_b.add(var6);
            int var7;
            int var8;
            int var9;
            if(var5 >= 5 && var5 < 9) {
               var7 = var5 - 5;
               var8 = var7 / 2;
               var9 = var7 % 2;
               var6.field_75223_e = 9 + var8 * 54;
               var6.field_75221_f = 6 + var9 * 27;
            } else if(var5 >= 0 && var5 < 5) {
               var6.field_75221_f = -2000;
               var6.field_75223_e = -2000;
            } else if(var5 < var4.field_75151_b.size()) {
               var7 = var5 - 9;
               var8 = var7 % 9;
               var9 = var7 / 9;
               var6.field_75223_e = 9 + var8 * 18;
               if(var5 >= 36) {
                  var6.field_75221_f = 112;
               } else {
                  var6.field_75221_f = 54 + var9 * 18;
               }
            }
         }

         this.field_147064_C = new Slot(field_147060_v, 0, 173, 112);
         var3.field_75151_b.add(this.field_147064_C);
      } else if(var2 == CreativeTabs.field_78036_m.func_78021_a()) {
         var3.field_75151_b = this.field_147063_B;
         this.field_147063_B = null;
      }

      if(this.field_147062_A != null) {
         if(p_147050_1_ == CreativeTabs.field_78027_g) {
            this.field_147062_A.func_146189_e(true);
            this.field_147062_A.func_146205_d(false);
            this.field_147062_A.func_146195_b(true);
            this.field_147062_A.func_146180_a("");
            this.func_147053_i();
         } else {
            this.field_147062_A.func_146189_e(false);
            this.field_147062_A.func_146205_d(true);
            this.field_147062_A.func_146195_b(false);
         }
      }

      this.field_147067_x = 0.0F;
      var3.func_148329_a(0.0F);
   }

   public void func_146274_d() throws IOException {
      super.func_146274_d();
      int var1 = Mouse.getEventDWheel();
      if(var1 != 0 && this.func_147055_p()) {
         int var2 = ((GuiContainerCreative.ContainerCreative)this.field_147002_h).field_148330_a.size() / 9 - 5 + 1;
         if(var1 > 0) {
            var1 = 1;
         }

         if(var1 < 0) {
            var1 = -1;
         }

         this.field_147067_x = (float)((double)this.field_147067_x - (double)var1 / (double)var2);
         this.field_147067_x = MathHelper.func_76131_a(this.field_147067_x, 0.0F, 1.0F);
         ((GuiContainerCreative.ContainerCreative)this.field_147002_h).func_148329_a(this.field_147067_x);
      }

   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      boolean var4 = Mouse.isButtonDown(0);
      int var5 = this.field_147003_i;
      int var6 = this.field_147009_r;
      int var7 = var5 + 175;
      int var8 = var6 + 18;
      int var9 = var7 + 14;
      int var10 = var8 + 112;
      if(!this.field_147065_z && var4 && p_73863_1_ >= var7 && p_73863_2_ >= var8 && p_73863_1_ < var9 && p_73863_2_ < var10) {
         this.field_147066_y = this.func_147055_p();
      }

      if(!var4) {
         this.field_147066_y = false;
      }

      this.field_147065_z = var4;
      if(this.field_147066_y) {
         this.field_147067_x = ((float)(p_73863_2_ - var8) - 7.5F) / ((float)(var10 - var8) - 15.0F);
         this.field_147067_x = MathHelper.func_76131_a(this.field_147067_x, 0.0F, 1.0F);
         ((GuiContainerCreative.ContainerCreative)this.field_147002_h).func_148329_a(this.field_147067_x);
      }

      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
      CreativeTabs[] var11 = CreativeTabs.field_78032_a;
      int var12 = var11.length;

      for(int var13 = 0; var13 < var12; ++var13) {
         CreativeTabs var14 = var11[var13];
         if(this.func_147052_b(var14, p_73863_1_, p_73863_2_)) {
            break;
         }
      }

      if(this.field_147064_C != null && field_147058_w == CreativeTabs.field_78036_m.func_78021_a() && this.func_146978_c(this.field_147064_C.field_75223_e, this.field_147064_C.field_75221_f, 16, 16, p_73863_1_, p_73863_2_)) {
         this.func_146279_a(I18n.func_135052_a("inventory.binSlot", new Object[0]), p_73863_1_, p_73863_2_);
      }

      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.func_179140_f();
   }

   protected void func_146285_a(ItemStack p_146285_1_, int p_146285_2_, int p_146285_3_) {
      if(field_147058_w == CreativeTabs.field_78027_g.func_78021_a()) {
         List var4 = p_146285_1_.func_82840_a(this.field_146297_k.field_71439_g, this.field_146297_k.field_71474_y.field_82882_x);
         CreativeTabs var5 = p_146285_1_.func_77973_b().func_77640_w();
         if(var5 == null && p_146285_1_.func_77973_b() == Items.field_151134_bR) {
            Map var6 = EnchantmentHelper.func_82781_a(p_146285_1_);
            if(var6.size() == 1) {
               Enchantment var7 = Enchantment.func_180306_c(((Integer)var6.keySet().iterator().next()).intValue());
               CreativeTabs[] var8 = CreativeTabs.field_78032_a;
               int var9 = var8.length;

               for(int var10 = 0; var10 < var9; ++var10) {
                  CreativeTabs var11 = var8[var10];
                  if(var11.func_111226_a(var7.field_77351_y)) {
                     var5 = var11;
                     break;
                  }
               }
            }
         }

         if(var5 != null) {
            var4.add(1, "" + EnumChatFormatting.BOLD + EnumChatFormatting.BLUE + I18n.func_135052_a(var5.func_78024_c(), new Object[0]));
         }

         for(int var12 = 0; var12 < var4.size(); ++var12) {
            if(var12 == 0) {
               var4.set(var12, p_146285_1_.func_77953_t().field_77937_e + (String)var4.get(var12));
            } else {
               var4.set(var12, EnumChatFormatting.GRAY + (String)var4.get(var12));
            }
         }

         this.func_146283_a(var4, p_146285_2_, p_146285_3_);
      } else {
         super.func_146285_a(p_146285_1_, p_146285_2_, p_146285_3_);
      }

   }

   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      RenderHelper.func_74520_c();
      CreativeTabs var4 = CreativeTabs.field_78032_a[field_147058_w];
      CreativeTabs[] var5 = CreativeTabs.field_78032_a;
      int var6 = var5.length;

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         CreativeTabs var8 = var5[var7];
         this.field_146297_k.func_110434_K().func_110577_a(field_147061_u);
         if(var8.func_78021_a() != field_147058_w) {
            this.func_147051_a(var8);
         }
      }

      this.field_146297_k.func_110434_K().func_110577_a(new ResourceLocation("textures/gui/container/creative_inventory/tab_" + var4.func_78015_f()));
      this.func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, this.field_147000_g);
      this.field_147062_A.func_146194_f();
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      int var9 = this.field_147003_i + 175;
      var6 = this.field_147009_r + 18;
      var7 = var6 + 112;
      this.field_146297_k.func_110434_K().func_110577_a(field_147061_u);
      if(var4.func_78017_i()) {
         this.func_73729_b(var9, var6 + (int)((float)(var7 - var6 - 17) * this.field_147067_x), 232 + (this.func_147055_p()?0:12), 0, 12, 15);
      }

      this.func_147051_a(var4);
      if(var4 == CreativeTabs.field_78036_m) {
         GuiInventory.func_147046_a(this.field_147003_i + 43, this.field_147009_r + 45, 20, (float)(this.field_147003_i + 43 - p_146976_2_), (float)(this.field_147009_r + 45 - 30 - p_146976_3_), this.field_146297_k.field_71439_g);
      }

   }

   protected boolean func_147049_a(CreativeTabs p_147049_1_, int p_147049_2_, int p_147049_3_) {
      int var4 = p_147049_1_.func_78020_k();
      int var5 = 28 * var4;
      byte var6 = 0;
      if(var4 == 5) {
         var5 = this.field_146999_f - 28 + 2;
      } else if(var4 > 0) {
         var5 += var4;
      }

      int var7;
      if(p_147049_1_.func_78023_l()) {
         var7 = var6 - 32;
      } else {
         var7 = var6 + this.field_147000_g;
      }

      return p_147049_2_ >= var5 && p_147049_2_ <= var5 + 28 && p_147049_3_ >= var7 && p_147049_3_ <= var7 + 32;
   }

   protected boolean func_147052_b(CreativeTabs p_147052_1_, int p_147052_2_, int p_147052_3_) {
      int var4 = p_147052_1_.func_78020_k();
      int var5 = 28 * var4;
      byte var6 = 0;
      if(var4 == 5) {
         var5 = this.field_146999_f - 28 + 2;
      } else if(var4 > 0) {
         var5 += var4;
      }

      int var7;
      if(p_147052_1_.func_78023_l()) {
         var7 = var6 - 32;
      } else {
         var7 = var6 + this.field_147000_g;
      }

      if(this.func_146978_c(var5 + 3, var7 + 3, 23, 27, p_147052_2_, p_147052_3_)) {
         this.func_146279_a(I18n.func_135052_a(p_147052_1_.func_78024_c(), new Object[0]), p_147052_2_, p_147052_3_);
         return true;
      } else {
         return false;
      }
   }

   protected void func_147051_a(CreativeTabs p_147051_1_) {
      boolean var2 = p_147051_1_.func_78021_a() == field_147058_w;
      boolean var3 = p_147051_1_.func_78023_l();
      int var4 = p_147051_1_.func_78020_k();
      int var5 = var4 * 28;
      int var6 = 0;
      int var7 = this.field_147003_i + 28 * var4;
      int var8 = this.field_147009_r;
      byte var9 = 32;
      if(var2) {
         var6 += 32;
      }

      if(var4 == 5) {
         var7 = this.field_147003_i + this.field_146999_f - 28;
      } else if(var4 > 0) {
         var7 += var4;
      }

      if(var3) {
         var8 -= 28;
      } else {
         var6 += 64;
         var8 += this.field_147000_g - 4;
      }

      GlStateManager.func_179140_f();
      this.func_73729_b(var7, var8, var5, var6, 28, var9);
      this.field_73735_i = 100.0F;
      this.field_146296_j.field_77023_b = 100.0F;
      var7 += 6;
      var8 += 8 + (var3?1:-1);
      GlStateManager.func_179145_e();
      GlStateManager.func_179091_B();
      ItemStack var10 = p_147051_1_.func_151244_d();
      this.field_146296_j.func_180450_b(var10, var7, var8);
      this.field_146296_j.func_175030_a(this.field_146289_q, var10, var7, var8);
      GlStateManager.func_179140_f();
      this.field_146296_j.field_77023_b = 0.0F;
      this.field_73735_i = 0.0F;
   }

   protected void func_146284_a(GuiButton p_146284_1_) throws IOException {
      if(p_146284_1_.field_146127_k == 0) {
         this.field_146297_k.func_147108_a(new GuiAchievements(this, this.field_146297_k.field_71439_g.func_146107_m()));
      }

      if(p_146284_1_.field_146127_k == 1) {
         this.field_146297_k.func_147108_a(new GuiStats(this, this.field_146297_k.field_71439_g.func_146107_m()));
      }

   }

   public int func_147056_g() {
      return field_147058_w;
   }


   static class ContainerCreative extends Container {

      public List field_148330_a = Lists.newArrayList();
      private static final String __OBFID = "CL_00000753";


      public ContainerCreative(EntityPlayer p_i1086_1_) {
         InventoryPlayer var2 = p_i1086_1_.field_71071_by;

         int var3;
         for(var3 = 0; var3 < 5; ++var3) {
            for(int var4 = 0; var4 < 9; ++var4) {
               this.func_75146_a(new Slot(GuiContainerCreative.field_147060_v, var3 * 9 + var4, 9 + var4 * 18, 18 + var3 * 18));
            }
         }

         for(var3 = 0; var3 < 9; ++var3) {
            this.func_75146_a(new Slot(var2, var3, 9 + var3 * 18, 112));
         }

         this.func_148329_a(0.0F);
      }

      public boolean func_75145_c(EntityPlayer p_75145_1_) {
         return true;
      }

      public void func_148329_a(float p_148329_1_) {
         int var2 = (this.field_148330_a.size() + 8) / 9 - 5;
         int var3 = (int)((double)(p_148329_1_ * (float)var2) + 0.5D);
         if(var3 < 0) {
            var3 = 0;
         }

         for(int var4 = 0; var4 < 5; ++var4) {
            for(int var5 = 0; var5 < 9; ++var5) {
               int var6 = var5 + (var4 + var3) * 9;
               if(var6 >= 0 && var6 < this.field_148330_a.size()) {
                  GuiContainerCreative.field_147060_v.func_70299_a(var5 + var4 * 9, (ItemStack)this.field_148330_a.get(var6));
               } else {
                  GuiContainerCreative.field_147060_v.func_70299_a(var5 + var4 * 9, (ItemStack)null);
               }
            }
         }

      }

      public boolean func_148328_e() {
         return this.field_148330_a.size() > 45;
      }

      protected void func_75133_b(int p_75133_1_, int p_75133_2_, boolean p_75133_3_, EntityPlayer p_75133_4_) {}

      public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
         if(p_82846_2_ >= this.field_75151_b.size() - 9 && p_82846_2_ < this.field_75151_b.size()) {
            Slot var3 = (Slot)this.field_75151_b.get(p_82846_2_);
            if(var3 != null && var3.func_75216_d()) {
               var3.func_75215_d((ItemStack)null);
            }
         }

         return null;
      }

      public boolean func_94530_a(ItemStack p_94530_1_, Slot p_94530_2_) {
         return p_94530_2_.field_75221_f > 90;
      }

      public boolean func_94531_b(Slot p_94531_1_) {
         return p_94531_1_.field_75224_c instanceof InventoryPlayer || p_94531_1_.field_75221_f > 90 && p_94531_1_.field_75223_e <= 162;
      }
   }

   class CreativeSlot extends Slot {

      private final Slot field_148332_b;
      private static final String __OBFID = "CL_00000754";


      public CreativeSlot(Slot p_i46313_2_, int p_i46313_3_) {
         super(p_i46313_2_.field_75224_c, p_i46313_3_, 0, 0);
         this.field_148332_b = p_i46313_2_;
      }

      public void func_82870_a(EntityPlayer p_82870_1_, ItemStack p_82870_2_) {
         this.field_148332_b.func_82870_a(p_82870_1_, p_82870_2_);
      }

      public boolean func_75214_a(ItemStack p_75214_1_) {
         return this.field_148332_b.func_75214_a(p_75214_1_);
      }

      public ItemStack func_75211_c() {
         return this.field_148332_b.func_75211_c();
      }

      public boolean func_75216_d() {
         return this.field_148332_b.func_75216_d();
      }

      public void func_75215_d(ItemStack p_75215_1_) {
         this.field_148332_b.func_75215_d(p_75215_1_);
      }

      public void func_75218_e() {
         this.field_148332_b.func_75218_e();
      }

      public int func_75219_a() {
         return this.field_148332_b.func_75219_a();
      }

      public int func_178170_b(ItemStack p_178170_1_) {
         return this.field_148332_b.func_178170_b(p_178170_1_);
      }

      public String func_178171_c() {
         return this.field_148332_b.func_178171_c();
      }

      public ItemStack func_75209_a(int p_75209_1_) {
         return this.field_148332_b.func_75209_a(p_75209_1_);
      }

      public boolean func_75217_a(IInventory p_75217_1_, int p_75217_2_) {
         return this.field_148332_b.func_75217_a(p_75217_1_, p_75217_2_);
      }
   }
}
