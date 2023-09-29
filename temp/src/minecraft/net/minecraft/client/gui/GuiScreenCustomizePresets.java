package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiCustomizeWorldScreen;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.ChunkProviderSettings;
import org.lwjgl.input.Keyboard;

public class GuiScreenCustomizePresets extends GuiScreen {

   private static final List field_175310_f = Lists.newArrayList();
   private GuiScreenCustomizePresets.ListPreset field_175311_g;
   private GuiButton field_175316_h;
   private GuiTextField field_175317_i;
   private GuiCustomizeWorldScreen field_175314_r;
   protected String field_175315_a = "Customize World Presets";
   private String field_175313_s;
   private String field_175312_t;
   private static final String __OBFID = "CL_00001937";


   public GuiScreenCustomizePresets(GuiCustomizeWorldScreen p_i45524_1_) {
      this.field_175314_r = p_i45524_1_;
   }

   public void func_73866_w_() {
      this.field_146292_n.clear();
      Keyboard.enableRepeatEvents(true);
      this.field_175315_a = I18n.func_135052_a("createWorld.customize.custom.presets.title", new Object[0]);
      this.field_175313_s = I18n.func_135052_a("createWorld.customize.presets.share", new Object[0]);
      this.field_175312_t = I18n.func_135052_a("createWorld.customize.presets.list", new Object[0]);
      this.field_175317_i = new GuiTextField(2, this.field_146289_q, 50, 40, this.field_146294_l - 100, 20);
      this.field_175311_g = new GuiScreenCustomizePresets.ListPreset();
      this.field_175317_i.func_146203_f(2000);
      this.field_175317_i.func_146180_a(this.field_175314_r.func_175323_a());
      this.field_146292_n.add(this.field_175316_h = new GuiButton(0, this.field_146294_l / 2 - 102, this.field_146295_m - 27, 100, 20, I18n.func_135052_a("createWorld.customize.presets.select", new Object[0])));
      this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 + 3, this.field_146295_m - 27, 100, 20, I18n.func_135052_a("gui.cancel", new Object[0])));
      this.func_175304_a();
   }

   public void func_146274_d() throws IOException {
      super.func_146274_d();
      this.field_175311_g.func_178039_p();
   }

   public void func_146281_b() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) throws IOException {
      this.field_175317_i.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) throws IOException {
      if(!this.field_175317_i.func_146201_a(p_73869_1_, p_73869_2_)) {
         super.func_73869_a(p_73869_1_, p_73869_2_);
      }

   }

   protected void func_146284_a(GuiButton p_146284_1_) throws IOException {
      switch(p_146284_1_.field_146127_k) {
      case 0:
         this.field_175314_r.func_175324_a(this.field_175317_i.func_146179_b());
         this.field_146297_k.func_147108_a(this.field_175314_r);
         break;
      case 1:
         this.field_146297_k.func_147108_a(this.field_175314_r);
      }

   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      this.func_146276_q_();
      this.field_175311_g.func_148128_a(p_73863_1_, p_73863_2_, p_73863_3_);
      this.func_73732_a(this.field_146289_q, this.field_175315_a, this.field_146294_l / 2, 8, 16777215);
      this.func_73731_b(this.field_146289_q, this.field_175313_s, 50, 30, 10526880);
      this.func_73731_b(this.field_146289_q, this.field_175312_t, 50, 70, 10526880);
      this.field_175317_i.func_146194_f();
      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   public void func_73876_c() {
      this.field_175317_i.func_146178_a();
      super.func_73876_c();
   }

   public void func_175304_a() {
      this.field_175316_h.field_146124_l = this.func_175305_g();
   }

   private boolean func_175305_g() {
      return this.field_175311_g.field_178053_u > -1 && this.field_175311_g.field_178053_u < field_175310_f.size() || this.field_175317_i.func_146179_b().length() > 1;
   }

   static {
      ChunkProviderSettings.Factory var0 = ChunkProviderSettings.Factory.func_177865_a("{ \"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":5000.0, \"mainNoiseScaleY\":1000.0, \"mainNoiseScaleZ\":5000.0, \"baseSize\":8.5, \"stretchY\":8.0, \"biomeDepthWeight\":2.0, \"biomeDepthOffset\":0.5, \"biomeScaleWeight\":2.0, \"biomeScaleOffset\":0.375, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":255 }");
      ResourceLocation var1 = new ResourceLocation("textures/gui/presets/water.png");
      field_175310_f.add(new GuiScreenCustomizePresets.Info(I18n.func_135052_a("createWorld.customize.custom.preset.waterWorld", new Object[0]), var1, var0));
      var0 = ChunkProviderSettings.Factory.func_177865_a("{\"coordinateScale\":3000.0, \"heightScale\":6000.0, \"upperLimitScale\":250.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":80.0, \"mainNoiseScaleY\":160.0, \"mainNoiseScaleZ\":80.0, \"baseSize\":8.5, \"stretchY\":10.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":63 }");
      var1 = new ResourceLocation("textures/gui/presets/isles.png");
      field_175310_f.add(new GuiScreenCustomizePresets.Info(I18n.func_135052_a("createWorld.customize.custom.preset.isleLand", new Object[0]), var1, var0));
      var0 = ChunkProviderSettings.Factory.func_177865_a("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":5000.0, \"mainNoiseScaleY\":1000.0, \"mainNoiseScaleZ\":5000.0, \"baseSize\":8.5, \"stretchY\":5.0, \"biomeDepthWeight\":2.0, \"biomeDepthOffset\":1.0, \"biomeScaleWeight\":4.0, \"biomeScaleOffset\":1.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":63 }");
      var1 = new ResourceLocation("textures/gui/presets/delight.png");
      field_175310_f.add(new GuiScreenCustomizePresets.Info(I18n.func_135052_a("createWorld.customize.custom.preset.caveDelight", new Object[0]), var1, var0));
      var0 = ChunkProviderSettings.Factory.func_177865_a("{\"coordinateScale\":738.41864, \"heightScale\":157.69133, \"upperLimitScale\":801.4267, \"lowerLimitScale\":1254.1643, \"depthNoiseScaleX\":374.93652, \"depthNoiseScaleZ\":288.65228, \"depthNoiseScaleExponent\":1.2092624, \"mainNoiseScaleX\":1355.9908, \"mainNoiseScaleY\":745.5343, \"mainNoiseScaleZ\":1183.464, \"baseSize\":1.8758626, \"stretchY\":1.7137525, \"biomeDepthWeight\":1.7553768, \"biomeDepthOffset\":3.4701107, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":2.535211, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":63 }");
      var1 = new ResourceLocation("textures/gui/presets/madness.png");
      field_175310_f.add(new GuiScreenCustomizePresets.Info(I18n.func_135052_a("createWorld.customize.custom.preset.mountains", new Object[0]), var1, var0));
      var0 = ChunkProviderSettings.Factory.func_177865_a("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":1000.0, \"mainNoiseScaleY\":3000.0, \"mainNoiseScaleZ\":1000.0, \"baseSize\":8.5, \"stretchY\":10.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":20 }");
      var1 = new ResourceLocation("textures/gui/presets/drought.png");
      field_175310_f.add(new GuiScreenCustomizePresets.Info(I18n.func_135052_a("createWorld.customize.custom.preset.drought", new Object[0]), var1, var0));
      var0 = ChunkProviderSettings.Factory.func_177865_a("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":2.0, \"lowerLimitScale\":64.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":80.0, \"mainNoiseScaleY\":160.0, \"mainNoiseScaleZ\":80.0, \"baseSize\":8.5, \"stretchY\":12.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":6 }");
      var1 = new ResourceLocation("textures/gui/presets/chaos.png");
      field_175310_f.add(new GuiScreenCustomizePresets.Info(I18n.func_135052_a("createWorld.customize.custom.preset.caveChaos", new Object[0]), var1, var0));
      var0 = ChunkProviderSettings.Factory.func_177865_a("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":80.0, \"mainNoiseScaleY\":160.0, \"mainNoiseScaleZ\":80.0, \"baseSize\":8.5, \"stretchY\":12.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":true, \"seaLevel\":40 }");
      var1 = new ResourceLocation("textures/gui/presets/luck.png");
      field_175310_f.add(new GuiScreenCustomizePresets.Info(I18n.func_135052_a("createWorld.customize.custom.preset.goodLuck", new Object[0]), var1, var0));
   }

   static class Info {

      public String field_178955_a;
      public ResourceLocation field_178953_b;
      public ChunkProviderSettings.Factory field_178954_c;
      private static final String __OBFID = "CL_00001936";


      public Info(String p_i45523_1_, ResourceLocation p_i45523_2_, ChunkProviderSettings.Factory p_i45523_3_) {
         this.field_178955_a = p_i45523_1_;
         this.field_178953_b = p_i45523_2_;
         this.field_178954_c = p_i45523_3_;
      }
   }

   class ListPreset extends GuiSlot {

      public int field_178053_u = -1;
      private static final String __OBFID = "CL_00001935";


      public ListPreset() {
         super(GuiScreenCustomizePresets.this.field_146297_k, GuiScreenCustomizePresets.this.field_146294_l, GuiScreenCustomizePresets.this.field_146295_m, 80, GuiScreenCustomizePresets.this.field_146295_m - 32, 38);
      }

      protected int func_148127_b() {
         return GuiScreenCustomizePresets.field_175310_f.size();
      }

      protected void func_148144_a(int p_148144_1_, boolean p_148144_2_, int p_148144_3_, int p_148144_4_) {
         this.field_178053_u = p_148144_1_;
         GuiScreenCustomizePresets.this.func_175304_a();
         GuiScreenCustomizePresets.this.field_175317_i.func_146180_a(((GuiScreenCustomizePresets.Info)GuiScreenCustomizePresets.field_175310_f.get(GuiScreenCustomizePresets.this.field_175311_g.field_178053_u)).field_178954_c.toString());
      }

      protected boolean func_148131_a(int p_148131_1_) {
         return p_148131_1_ == this.field_178053_u;
      }

      protected void func_148123_a() {}

      private void func_178051_a(int p_178051_1_, int p_178051_2_, ResourceLocation p_178051_3_) {
         int var4 = p_178051_1_ + 5;
         GuiScreenCustomizePresets.this.func_73730_a(var4 - 1, var4 + 32, p_178051_2_ - 1, -2039584);
         GuiScreenCustomizePresets.this.func_73730_a(var4 - 1, var4 + 32, p_178051_2_ + 32, -6250336);
         GuiScreenCustomizePresets.this.func_73728_b(var4 - 1, p_178051_2_ - 1, p_178051_2_ + 32, -2039584);
         GuiScreenCustomizePresets.this.func_73728_b(var4 + 32, p_178051_2_ - 1, p_178051_2_ + 32, -6250336);
         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
         this.field_148161_k.func_110434_K().func_110577_a(p_178051_3_);
         boolean var6 = true;
         boolean var7 = true;
         Tessellator var8 = Tessellator.func_178181_a();
         WorldRenderer var9 = var8.func_178180_c();
         var9.func_178970_b();
         var9.func_178985_a((double)(var4 + 0), (double)(p_178051_2_ + 32), 0.0D, 0.0D, 1.0D);
         var9.func_178985_a((double)(var4 + 32), (double)(p_178051_2_ + 32), 0.0D, 1.0D, 1.0D);
         var9.func_178985_a((double)(var4 + 32), (double)(p_178051_2_ + 0), 0.0D, 1.0D, 0.0D);
         var9.func_178985_a((double)(var4 + 0), (double)(p_178051_2_ + 0), 0.0D, 0.0D, 0.0D);
         var8.func_78381_a();
      }

      protected void func_180791_a(int p_180791_1_, int p_180791_2_, int p_180791_3_, int p_180791_4_, int p_180791_5_, int p_180791_6_) {
         GuiScreenCustomizePresets.Info var7 = (GuiScreenCustomizePresets.Info)GuiScreenCustomizePresets.field_175310_f.get(p_180791_1_);
         this.func_178051_a(p_180791_2_, p_180791_3_, var7.field_178953_b);
         GuiScreenCustomizePresets.this.field_146289_q.func_78276_b(var7.field_178955_a, p_180791_2_ + 32 + 10, p_180791_3_ + 14, 16777215);
      }
   }
}
