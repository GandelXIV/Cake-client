package net.minecraft.client.settings;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.stream.TwitchStream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.network.play.client.C15PacketClientSettings;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class GameSettings {

   private static final Logger field_151454_ax = LogManager.getLogger();
   private static final Gson field_151450_ay = new Gson();
   private static final ParameterizedType field_151449_az = new ParameterizedType() {

      private static final String __OBFID = "CL_00000651";

      public Type[] getActualTypeArguments() {
         return new Type[]{String.class};
      }
      public Type getRawType() {
         return List.class;
      }
      public Type getOwnerType() {
         return null;
      }
   };
   private static final String[] field_74367_ae = new String[]{"options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large"};
   private static final String[] field_74364_ag = new String[]{"options.particles.all", "options.particles.decreased", "options.particles.minimal"};
   private static final String[] field_98303_au = new String[]{"options.ao.off", "options.ao.min", "options.ao.max"};
   private static final String[] field_152391_aS = new String[]{"options.stream.compression.low", "options.stream.compression.medium", "options.stream.compression.high"};
   private static final String[] field_152392_aT = new String[]{"options.stream.chat.enabled.streaming", "options.stream.chat.enabled.always", "options.stream.chat.enabled.never"};
   private static final String[] field_152393_aU = new String[]{"options.stream.chat.userFilter.all", "options.stream.chat.userFilter.subs", "options.stream.chat.userFilter.mods"};
   private static final String[] field_152394_aV = new String[]{"options.stream.mic_toggle.mute", "options.stream.mic_toggle.talk"};
   public float field_74341_c = 0.5F;
   public boolean field_74338_d;
   public int field_151451_c = -1;
   public boolean field_74336_f = true;
   public boolean field_74337_g;
   public boolean field_151448_g = true;
   public int field_74350_i = 120;
   public boolean field_74345_l = true;
   public boolean field_74347_j = true;
   public int field_74348_k = 2;
   public List field_151453_l = Lists.newArrayList();
   public EntityPlayer.EnumChatVisibility field_74343_n;
   public boolean field_74344_o;
   public boolean field_74359_p;
   public boolean field_74358_q;
   public float field_74357_r;
   public boolean field_74355_t;
   public boolean field_74353_u;
   public boolean field_74352_v;
   public boolean field_178881_t;
   public boolean field_178880_u;
   public boolean field_178879_v;
   public boolean field_80005_w;
   public boolean field_82882_x;
   public boolean field_82881_y;
   private final Set field_178882_aU;
   public boolean field_85185_A;
   public int field_92118_B;
   public int field_92119_C;
   public boolean field_92117_D;
   public float field_96691_E;
   public float field_96692_F;
   public float field_96693_G;
   public float field_96694_H;
   public boolean field_151441_H;
   public int field_151442_I;
   private Map field_151446_aD;
   public float field_152400_J;
   public float field_152401_K;
   public float field_152402_L;
   public float field_152403_M;
   public float field_152404_N;
   public int field_152405_O;
   public boolean field_152406_P;
   public String field_152407_Q;
   public int field_152408_R;
   public int field_152409_S;
   public int field_152410_T;
   public KeyBinding field_74351_w;
   public KeyBinding field_74370_x;
   public KeyBinding field_74368_y;
   public KeyBinding field_74366_z;
   public KeyBinding field_74314_A;
   public KeyBinding field_74311_E;
   public KeyBinding field_151445_Q;
   public KeyBinding field_74313_G;
   public KeyBinding field_74316_C;
   public KeyBinding field_74312_F;
   public KeyBinding field_74322_I;
   public KeyBinding field_151444_V;
   public KeyBinding field_74310_D;
   public KeyBinding field_74321_H;
   public KeyBinding field_74323_J;
   public KeyBinding field_151447_Z;
   public KeyBinding field_151457_aa;
   public KeyBinding field_151458_ab;
   public KeyBinding field_152395_am;
   public KeyBinding field_178883_an;
   public KeyBinding field_152396_an;
   public KeyBinding field_152397_ao;
   public KeyBinding field_152398_ap;
   public KeyBinding field_152399_aq;
   public KeyBinding[] field_151456_ac;
   public KeyBinding[] field_74324_K;
   protected Minecraft field_74317_L;
   private File field_74354_ai;
   public EnumDifficulty field_74318_M;
   public boolean field_74319_N;
   public int field_74320_O;
   public boolean field_74330_P;
   public boolean field_74329_Q;
   public String field_74332_R;
   public boolean field_74326_T;
   public boolean field_74325_U;
   public float field_74334_X;
   public float field_74333_Y;
   public float field_151452_as;
   public int field_74335_Z;
   public int field_74362_aa;
   public String field_74363_ab;
   public boolean field_151455_aw;
   private static final String __OBFID = "CL_00000650";


   public GameSettings(Minecraft p_i46326_1_, File p_i46326_2_) {
      this.field_74343_n = EntityPlayer.EnumChatVisibility.FULL;
      this.field_74344_o = true;
      this.field_74359_p = true;
      this.field_74358_q = true;
      this.field_74357_r = 1.0F;
      this.field_74355_t = true;
      this.field_74352_v = true;
      this.field_178881_t = false;
      this.field_178880_u = true;
      this.field_178879_v = false;
      this.field_82881_y = true;
      this.field_178882_aU = Sets.newHashSet(EnumPlayerModelParts.values());
      this.field_92117_D = true;
      this.field_96691_E = 1.0F;
      this.field_96692_F = 1.0F;
      this.field_96693_G = 0.44366196F;
      this.field_96694_H = 1.0F;
      this.field_151441_H = true;
      this.field_151442_I = 4;
      this.field_151446_aD = Maps.newEnumMap(SoundCategory.class);
      this.field_152400_J = 0.5F;
      this.field_152401_K = 1.0F;
      this.field_152402_L = 1.0F;
      this.field_152403_M = 0.5412844F;
      this.field_152404_N = 0.31690142F;
      this.field_152405_O = 1;
      this.field_152406_P = true;
      this.field_152407_Q = "";
      this.field_152408_R = 0;
      this.field_152409_S = 0;
      this.field_152410_T = 0;
      this.field_74351_w = new KeyBinding("key.forward", 17, "key.categories.movement");
      this.field_74370_x = new KeyBinding("key.left", 30, "key.categories.movement");
      this.field_74368_y = new KeyBinding("key.back", 31, "key.categories.movement");
      this.field_74366_z = new KeyBinding("key.right", 32, "key.categories.movement");
      this.field_74314_A = new KeyBinding("key.jump", 57, "key.categories.movement");
      this.field_74311_E = new KeyBinding("key.sneak", 42, "key.categories.movement");
      this.field_151445_Q = new KeyBinding("key.inventory", 18, "key.categories.inventory");
      this.field_74313_G = new KeyBinding("key.use", -99, "key.categories.gameplay");
      this.field_74316_C = new KeyBinding("key.drop", 16, "key.categories.gameplay");
      this.field_74312_F = new KeyBinding("key.attack", -100, "key.categories.gameplay");
      this.field_74322_I = new KeyBinding("key.pickItem", -98, "key.categories.gameplay");
      this.field_151444_V = new KeyBinding("key.sprint", 29, "key.categories.gameplay");
      this.field_74310_D = new KeyBinding("key.chat", 20, "key.categories.multiplayer");
      this.field_74321_H = new KeyBinding("key.playerlist", 15, "key.categories.multiplayer");
      this.field_74323_J = new KeyBinding("key.command", 53, "key.categories.multiplayer");
      this.field_151447_Z = new KeyBinding("key.screenshot", 60, "key.categories.misc");
      this.field_151457_aa = new KeyBinding("key.togglePerspective", 63, "key.categories.misc");
      this.field_151458_ab = new KeyBinding("key.smoothCamera", 0, "key.categories.misc");
      this.field_152395_am = new KeyBinding("key.fullscreen", 87, "key.categories.misc");
      this.field_178883_an = new KeyBinding("key.spectatorOutlines", 0, "key.categories.misc");
      this.field_152396_an = new KeyBinding("key.streamStartStop", 64, "key.categories.stream");
      this.field_152397_ao = new KeyBinding("key.streamPauseUnpause", 65, "key.categories.stream");
      this.field_152398_ap = new KeyBinding("key.streamCommercial", 0, "key.categories.stream");
      this.field_152399_aq = new KeyBinding("key.streamToggleMic", 0, "key.categories.stream");
      this.field_151456_ac = new KeyBinding[]{new KeyBinding("key.hotbar.1", 2, "key.categories.inventory"), new KeyBinding("key.hotbar.2", 3, "key.categories.inventory"), new KeyBinding("key.hotbar.3", 4, "key.categories.inventory"), new KeyBinding("key.hotbar.4", 5, "key.categories.inventory"), new KeyBinding("key.hotbar.5", 6, "key.categories.inventory"), new KeyBinding("key.hotbar.6", 7, "key.categories.inventory"), new KeyBinding("key.hotbar.7", 8, "key.categories.inventory"), new KeyBinding("key.hotbar.8", 9, "key.categories.inventory"), new KeyBinding("key.hotbar.9", 10, "key.categories.inventory")};
      this.field_74324_K = (KeyBinding[])ArrayUtils.addAll(new KeyBinding[]{this.field_74312_F, this.field_74313_G, this.field_74351_w, this.field_74370_x, this.field_74368_y, this.field_74366_z, this.field_74314_A, this.field_74311_E, this.field_74316_C, this.field_151445_Q, this.field_74310_D, this.field_74321_H, this.field_74322_I, this.field_74323_J, this.field_151447_Z, this.field_151457_aa, this.field_151458_ab, this.field_151444_V, this.field_152396_an, this.field_152397_ao, this.field_152398_ap, this.field_152399_aq, this.field_152395_am, this.field_178883_an}, this.field_151456_ac);
      this.field_74318_M = EnumDifficulty.NORMAL;
      this.field_74332_R = "";
      this.field_74334_X = 70.0F;
      this.field_74363_ab = "en_US";
      this.field_151455_aw = false;
      this.field_74317_L = p_i46326_1_;
      this.field_74354_ai = new File(p_i46326_2_, "options.txt");
      if(p_i46326_1_.func_147111_S() && Runtime.getRuntime().maxMemory() >= 1000000000L) {
         GameSettings.Options.RENDER_DISTANCE.func_148263_a(32.0F);
      } else {
         GameSettings.Options.RENDER_DISTANCE.func_148263_a(16.0F);
      }

      this.field_151451_c = p_i46326_1_.func_147111_S()?12:8;
      this.func_74300_a();
   }

   public GameSettings() {
      this.field_74343_n = EntityPlayer.EnumChatVisibility.FULL;
      this.field_74344_o = true;
      this.field_74359_p = true;
      this.field_74358_q = true;
      this.field_74357_r = 1.0F;
      this.field_74355_t = true;
      this.field_74352_v = true;
      this.field_178881_t = false;
      this.field_178880_u = true;
      this.field_178879_v = false;
      this.field_82881_y = true;
      this.field_178882_aU = Sets.newHashSet(EnumPlayerModelParts.values());
      this.field_92117_D = true;
      this.field_96691_E = 1.0F;
      this.field_96692_F = 1.0F;
      this.field_96693_G = 0.44366196F;
      this.field_96694_H = 1.0F;
      this.field_151441_H = true;
      this.field_151442_I = 4;
      this.field_151446_aD = Maps.newEnumMap(SoundCategory.class);
      this.field_152400_J = 0.5F;
      this.field_152401_K = 1.0F;
      this.field_152402_L = 1.0F;
      this.field_152403_M = 0.5412844F;
      this.field_152404_N = 0.31690142F;
      this.field_152405_O = 1;
      this.field_152406_P = true;
      this.field_152407_Q = "";
      this.field_152408_R = 0;
      this.field_152409_S = 0;
      this.field_152410_T = 0;
      this.field_74351_w = new KeyBinding("key.forward", 17, "key.categories.movement");
      this.field_74370_x = new KeyBinding("key.left", 30, "key.categories.movement");
      this.field_74368_y = new KeyBinding("key.back", 31, "key.categories.movement");
      this.field_74366_z = new KeyBinding("key.right", 32, "key.categories.movement");
      this.field_74314_A = new KeyBinding("key.jump", 57, "key.categories.movement");
      this.field_74311_E = new KeyBinding("key.sneak", 42, "key.categories.movement");
      this.field_151445_Q = new KeyBinding("key.inventory", 18, "key.categories.inventory");
      this.field_74313_G = new KeyBinding("key.use", -99, "key.categories.gameplay");
      this.field_74316_C = new KeyBinding("key.drop", 16, "key.categories.gameplay");
      this.field_74312_F = new KeyBinding("key.attack", -100, "key.categories.gameplay");
      this.field_74322_I = new KeyBinding("key.pickItem", -98, "key.categories.gameplay");
      this.field_151444_V = new KeyBinding("key.sprint", 29, "key.categories.gameplay");
      this.field_74310_D = new KeyBinding("key.chat", 20, "key.categories.multiplayer");
      this.field_74321_H = new KeyBinding("key.playerlist", 15, "key.categories.multiplayer");
      this.field_74323_J = new KeyBinding("key.command", 53, "key.categories.multiplayer");
      this.field_151447_Z = new KeyBinding("key.screenshot", 60, "key.categories.misc");
      this.field_151457_aa = new KeyBinding("key.togglePerspective", 63, "key.categories.misc");
      this.field_151458_ab = new KeyBinding("key.smoothCamera", 0, "key.categories.misc");
      this.field_152395_am = new KeyBinding("key.fullscreen", 87, "key.categories.misc");
      this.field_178883_an = new KeyBinding("key.spectatorOutlines", 0, "key.categories.misc");
      this.field_152396_an = new KeyBinding("key.streamStartStop", 64, "key.categories.stream");
      this.field_152397_ao = new KeyBinding("key.streamPauseUnpause", 65, "key.categories.stream");
      this.field_152398_ap = new KeyBinding("key.streamCommercial", 0, "key.categories.stream");
      this.field_152399_aq = new KeyBinding("key.streamToggleMic", 0, "key.categories.stream");
      this.field_151456_ac = new KeyBinding[]{new KeyBinding("key.hotbar.1", 2, "key.categories.inventory"), new KeyBinding("key.hotbar.2", 3, "key.categories.inventory"), new KeyBinding("key.hotbar.3", 4, "key.categories.inventory"), new KeyBinding("key.hotbar.4", 5, "key.categories.inventory"), new KeyBinding("key.hotbar.5", 6, "key.categories.inventory"), new KeyBinding("key.hotbar.6", 7, "key.categories.inventory"), new KeyBinding("key.hotbar.7", 8, "key.categories.inventory"), new KeyBinding("key.hotbar.8", 9, "key.categories.inventory"), new KeyBinding("key.hotbar.9", 10, "key.categories.inventory")};
      this.field_74324_K = (KeyBinding[])ArrayUtils.addAll(new KeyBinding[]{this.field_74312_F, this.field_74313_G, this.field_74351_w, this.field_74370_x, this.field_74368_y, this.field_74366_z, this.field_74314_A, this.field_74311_E, this.field_74316_C, this.field_151445_Q, this.field_74310_D, this.field_74321_H, this.field_74322_I, this.field_74323_J, this.field_151447_Z, this.field_151457_aa, this.field_151458_ab, this.field_151444_V, this.field_152396_an, this.field_152397_ao, this.field_152398_ap, this.field_152399_aq, this.field_152395_am, this.field_178883_an}, this.field_151456_ac);
      this.field_74318_M = EnumDifficulty.NORMAL;
      this.field_74332_R = "";
      this.field_74334_X = 70.0F;
      this.field_74363_ab = "en_US";
      this.field_151455_aw = false;
   }

   public static String func_74298_c(int p_74298_0_) {
      return p_74298_0_ < 0?I18n.func_135052_a("key.mouseButton", new Object[]{Integer.valueOf(p_74298_0_ + 101)}):(p_74298_0_ < 256?Keyboard.getKeyName(p_74298_0_):String.format("%c", new Object[]{Character.valueOf((char)(p_74298_0_ - 256))}).toUpperCase());
   }

   public static boolean func_100015_a(KeyBinding p_100015_0_) {
      return p_100015_0_.func_151463_i() == 0?false:(p_100015_0_.func_151463_i() < 0?Mouse.isButtonDown(p_100015_0_.func_151463_i() + 100):Keyboard.isKeyDown(p_100015_0_.func_151463_i()));
   }

   public void func_151440_a(KeyBinding p_151440_1_, int p_151440_2_) {
      p_151440_1_.func_151462_b(p_151440_2_);
      this.func_74303_b();
   }

   public void func_74304_a(GameSettings.Options p_74304_1_, float p_74304_2_) {
      if(p_74304_1_ == GameSettings.Options.SENSITIVITY) {
         this.field_74341_c = p_74304_2_;
      }

      if(p_74304_1_ == GameSettings.Options.FOV) {
         this.field_74334_X = p_74304_2_;
      }

      if(p_74304_1_ == GameSettings.Options.GAMMA) {
         this.field_74333_Y = p_74304_2_;
      }

      if(p_74304_1_ == GameSettings.Options.FRAMERATE_LIMIT) {
         this.field_74350_i = (int)p_74304_2_;
      }

      if(p_74304_1_ == GameSettings.Options.CHAT_OPACITY) {
         this.field_74357_r = p_74304_2_;
         this.field_74317_L.field_71456_v.func_146158_b().func_146245_b();
      }

      if(p_74304_1_ == GameSettings.Options.CHAT_HEIGHT_FOCUSED) {
         this.field_96694_H = p_74304_2_;
         this.field_74317_L.field_71456_v.func_146158_b().func_146245_b();
      }

      if(p_74304_1_ == GameSettings.Options.CHAT_HEIGHT_UNFOCUSED) {
         this.field_96693_G = p_74304_2_;
         this.field_74317_L.field_71456_v.func_146158_b().func_146245_b();
      }

      if(p_74304_1_ == GameSettings.Options.CHAT_WIDTH) {
         this.field_96692_F = p_74304_2_;
         this.field_74317_L.field_71456_v.func_146158_b().func_146245_b();
      }

      if(p_74304_1_ == GameSettings.Options.CHAT_SCALE) {
         this.field_96691_E = p_74304_2_;
         this.field_74317_L.field_71456_v.func_146158_b().func_146245_b();
      }

      if(p_74304_1_ == GameSettings.Options.MIPMAP_LEVELS) {
         int var3 = this.field_151442_I;
         this.field_151442_I = (int)p_74304_2_;
         if((float)var3 != p_74304_2_) {
            this.field_74317_L.func_147117_R().func_147633_a(this.field_151442_I);
            this.field_74317_L.func_110434_K().func_110577_a(TextureMap.field_110575_b);
            this.field_74317_L.func_147117_R().func_174937_a(false, this.field_151442_I > 0);
            this.field_74317_L.func_175603_A();
         }
      }

      if(p_74304_1_ == GameSettings.Options.BLOCK_ALTERNATIVES) {
         this.field_178880_u = !this.field_178880_u;
         this.field_74317_L.field_71438_f.func_72712_a();
      }

      if(p_74304_1_ == GameSettings.Options.RENDER_DISTANCE) {
         this.field_151451_c = (int)p_74304_2_;
         this.field_74317_L.field_71438_f.func_174979_m();
      }

      if(p_74304_1_ == GameSettings.Options.STREAM_BYTES_PER_PIXEL) {
         this.field_152400_J = p_74304_2_;
      }

      if(p_74304_1_ == GameSettings.Options.STREAM_VOLUME_MIC) {
         this.field_152401_K = p_74304_2_;
         this.field_74317_L.func_152346_Z().func_152915_s();
      }

      if(p_74304_1_ == GameSettings.Options.STREAM_VOLUME_SYSTEM) {
         this.field_152402_L = p_74304_2_;
         this.field_74317_L.func_152346_Z().func_152915_s();
      }

      if(p_74304_1_ == GameSettings.Options.STREAM_KBPS) {
         this.field_152403_M = p_74304_2_;
      }

      if(p_74304_1_ == GameSettings.Options.STREAM_FPS) {
         this.field_152404_N = p_74304_2_;
      }

   }

   public void func_74306_a(GameSettings.Options p_74306_1_, int p_74306_2_) {
      if(p_74306_1_ == GameSettings.Options.INVERT_MOUSE) {
         this.field_74338_d = !this.field_74338_d;
      }

      if(p_74306_1_ == GameSettings.Options.GUI_SCALE) {
         this.field_74335_Z = this.field_74335_Z + p_74306_2_ & 3;
      }

      if(p_74306_1_ == GameSettings.Options.PARTICLES) {
         this.field_74362_aa = (this.field_74362_aa + p_74306_2_) % 3;
      }

      if(p_74306_1_ == GameSettings.Options.VIEW_BOBBING) {
         this.field_74336_f = !this.field_74336_f;
      }

      if(p_74306_1_ == GameSettings.Options.RENDER_CLOUDS) {
         this.field_74345_l = !this.field_74345_l;
      }

      if(p_74306_1_ == GameSettings.Options.FORCE_UNICODE_FONT) {
         this.field_151455_aw = !this.field_151455_aw;
         this.field_74317_L.field_71466_p.func_78264_a(this.field_74317_L.func_135016_M().func_135042_a() || this.field_151455_aw);
      }

      if(p_74306_1_ == GameSettings.Options.FBO_ENABLE) {
         this.field_151448_g = !this.field_151448_g;
      }

      if(p_74306_1_ == GameSettings.Options.ANAGLYPH) {
         this.field_74337_g = !this.field_74337_g;
         this.field_74317_L.func_110436_a();
      }

      if(p_74306_1_ == GameSettings.Options.GRAPHICS) {
         this.field_74347_j = !this.field_74347_j;
         this.field_74317_L.field_71438_f.func_72712_a();
      }

      if(p_74306_1_ == GameSettings.Options.AMBIENT_OCCLUSION) {
         this.field_74348_k = (this.field_74348_k + p_74306_2_) % 3;
         this.field_74317_L.field_71438_f.func_72712_a();
      }

      if(p_74306_1_ == GameSettings.Options.CHAT_VISIBILITY) {
         this.field_74343_n = EntityPlayer.EnumChatVisibility.func_151426_a((this.field_74343_n.func_151428_a() + p_74306_2_) % 3);
      }

      if(p_74306_1_ == GameSettings.Options.STREAM_COMPRESSION) {
         this.field_152405_O = (this.field_152405_O + p_74306_2_) % 3;
      }

      if(p_74306_1_ == GameSettings.Options.STREAM_SEND_METADATA) {
         this.field_152406_P = !this.field_152406_P;
      }

      if(p_74306_1_ == GameSettings.Options.STREAM_CHAT_ENABLED) {
         this.field_152408_R = (this.field_152408_R + p_74306_2_) % 3;
      }

      if(p_74306_1_ == GameSettings.Options.STREAM_CHAT_USER_FILTER) {
         this.field_152409_S = (this.field_152409_S + p_74306_2_) % 3;
      }

      if(p_74306_1_ == GameSettings.Options.STREAM_MIC_TOGGLE_BEHAVIOR) {
         this.field_152410_T = (this.field_152410_T + p_74306_2_) % 2;
      }

      if(p_74306_1_ == GameSettings.Options.CHAT_COLOR) {
         this.field_74344_o = !this.field_74344_o;
      }

      if(p_74306_1_ == GameSettings.Options.CHAT_LINKS) {
         this.field_74359_p = !this.field_74359_p;
      }

      if(p_74306_1_ == GameSettings.Options.CHAT_LINKS_PROMPT) {
         this.field_74358_q = !this.field_74358_q;
      }

      if(p_74306_1_ == GameSettings.Options.SNOOPER_ENABLED) {
         this.field_74355_t = !this.field_74355_t;
      }

      if(p_74306_1_ == GameSettings.Options.TOUCHSCREEN) {
         this.field_85185_A = !this.field_85185_A;
      }

      if(p_74306_1_ == GameSettings.Options.USE_FULLSCREEN) {
         this.field_74353_u = !this.field_74353_u;
         if(this.field_74317_L.func_71372_G() != this.field_74353_u) {
            this.field_74317_L.func_71352_k();
         }
      }

      if(p_74306_1_ == GameSettings.Options.ENABLE_VSYNC) {
         this.field_74352_v = !this.field_74352_v;
         Display.setVSyncEnabled(this.field_74352_v);
      }

      if(p_74306_1_ == GameSettings.Options.USE_VBO) {
         this.field_178881_t = !this.field_178881_t;
         this.field_74317_L.field_71438_f.func_72712_a();
      }

      if(p_74306_1_ == GameSettings.Options.BLOCK_ALTERNATIVES) {
         this.field_178880_u = !this.field_178880_u;
         this.field_74317_L.field_71438_f.func_72712_a();
      }

      if(p_74306_1_ == GameSettings.Options.REDUCED_DEBUG_INFO) {
         this.field_178879_v = !this.field_178879_v;
      }

      this.func_74303_b();
   }

   public float func_74296_a(GameSettings.Options p_74296_1_) {
      return p_74296_1_ == GameSettings.Options.FOV?this.field_74334_X:(p_74296_1_ == GameSettings.Options.GAMMA?this.field_74333_Y:(p_74296_1_ == GameSettings.Options.SATURATION?this.field_151452_as:(p_74296_1_ == GameSettings.Options.SENSITIVITY?this.field_74341_c:(p_74296_1_ == GameSettings.Options.CHAT_OPACITY?this.field_74357_r:(p_74296_1_ == GameSettings.Options.CHAT_HEIGHT_FOCUSED?this.field_96694_H:(p_74296_1_ == GameSettings.Options.CHAT_HEIGHT_UNFOCUSED?this.field_96693_G:(p_74296_1_ == GameSettings.Options.CHAT_SCALE?this.field_96691_E:(p_74296_1_ == GameSettings.Options.CHAT_WIDTH?this.field_96692_F:(p_74296_1_ == GameSettings.Options.FRAMERATE_LIMIT?(float)this.field_74350_i:(p_74296_1_ == GameSettings.Options.MIPMAP_LEVELS?(float)this.field_151442_I:(p_74296_1_ == GameSettings.Options.RENDER_DISTANCE?(float)this.field_151451_c:(p_74296_1_ == GameSettings.Options.STREAM_BYTES_PER_PIXEL?this.field_152400_J:(p_74296_1_ == GameSettings.Options.STREAM_VOLUME_MIC?this.field_152401_K:(p_74296_1_ == GameSettings.Options.STREAM_VOLUME_SYSTEM?this.field_152402_L:(p_74296_1_ == GameSettings.Options.STREAM_KBPS?this.field_152403_M:(p_74296_1_ == GameSettings.Options.STREAM_FPS?this.field_152404_N:0.0F))))))))))))))));
   }

   public boolean func_74308_b(GameSettings.Options p_74308_1_) {
      switch(GameSettings.SwitchOptions.field_151477_a[p_74308_1_.ordinal()]) {
      case 1:
         return this.field_74338_d;
      case 2:
         return this.field_74336_f;
      case 3:
         return this.field_74337_g;
      case 4:
         return this.field_151448_g;
      case 5:
         return this.field_74345_l;
      case 6:
         return this.field_74344_o;
      case 7:
         return this.field_74359_p;
      case 8:
         return this.field_74358_q;
      case 9:
         return this.field_74355_t;
      case 10:
         return this.field_74353_u;
      case 11:
         return this.field_74352_v;
      case 12:
         return this.field_178881_t;
      case 13:
         return this.field_85185_A;
      case 14:
         return this.field_152406_P;
      case 15:
         return this.field_151455_aw;
      case 16:
         return this.field_178880_u;
      case 17:
         return this.field_178879_v;
      default:
         return false;
      }
   }

   private static String func_74299_a(String[] p_74299_0_, int p_74299_1_) {
      if(p_74299_1_ < 0 || p_74299_1_ >= p_74299_0_.length) {
         p_74299_1_ = 0;
      }

      return I18n.func_135052_a(p_74299_0_[p_74299_1_], new Object[0]);
   }

   public String func_74297_c(GameSettings.Options p_74297_1_) {
      String var2 = I18n.func_135052_a(p_74297_1_.func_74378_d(), new Object[0]) + ": ";
      if(p_74297_1_.func_74380_a()) {
         float var6 = this.func_74296_a(p_74297_1_);
         float var4 = p_74297_1_.func_148266_c(var6);
         return p_74297_1_ == GameSettings.Options.SENSITIVITY?(var4 == 0.0F?var2 + I18n.func_135052_a("options.sensitivity.min", new Object[0]):(var4 == 1.0F?var2 + I18n.func_135052_a("options.sensitivity.max", new Object[0]):var2 + (int)(var4 * 200.0F) + "%")):(p_74297_1_ == GameSettings.Options.FOV?(var6 == 70.0F?var2 + I18n.func_135052_a("options.fov.min", new Object[0]):(var6 == 110.0F?var2 + I18n.func_135052_a("options.fov.max", new Object[0]):var2 + (int)var6)):(p_74297_1_ == GameSettings.Options.FRAMERATE_LIMIT?(var6 == p_74297_1_.field_148272_O?var2 + I18n.func_135052_a("options.framerateLimit.max", new Object[0]):var2 + (int)var6 + " fps"):(p_74297_1_ == GameSettings.Options.RENDER_CLOUDS?(var6 == p_74297_1_.field_148271_N?var2 + I18n.func_135052_a("options.cloudHeight.min", new Object[0]):var2 + ((int)var6 + 128)):(p_74297_1_ == GameSettings.Options.GAMMA?(var4 == 0.0F?var2 + I18n.func_135052_a("options.gamma.min", new Object[0]):(var4 == 1.0F?var2 + I18n.func_135052_a("options.gamma.max", new Object[0]):var2 + "+" + (int)(var4 * 100.0F) + "%")):(p_74297_1_ == GameSettings.Options.SATURATION?var2 + (int)(var4 * 400.0F) + "%":(p_74297_1_ == GameSettings.Options.CHAT_OPACITY?var2 + (int)(var4 * 90.0F + 10.0F) + "%":(p_74297_1_ == GameSettings.Options.CHAT_HEIGHT_UNFOCUSED?var2 + GuiNewChat.func_146243_b(var4) + "px":(p_74297_1_ == GameSettings.Options.CHAT_HEIGHT_FOCUSED?var2 + GuiNewChat.func_146243_b(var4) + "px":(p_74297_1_ == GameSettings.Options.CHAT_WIDTH?var2 + GuiNewChat.func_146233_a(var4) + "px":(p_74297_1_ == GameSettings.Options.RENDER_DISTANCE?var2 + (int)var6 + " chunks":(p_74297_1_ == GameSettings.Options.MIPMAP_LEVELS?(var6 == 0.0F?var2 + I18n.func_135052_a("options.off", new Object[0]):var2 + (int)var6):(p_74297_1_ == GameSettings.Options.STREAM_FPS?var2 + TwitchStream.func_152948_a(var4) + " fps":(p_74297_1_ == GameSettings.Options.STREAM_KBPS?var2 + TwitchStream.func_152946_b(var4) + " Kbps":(p_74297_1_ == GameSettings.Options.STREAM_BYTES_PER_PIXEL?var2 + String.format("%.3f bpp", new Object[]{Float.valueOf(TwitchStream.func_152947_c(var4))}):(var4 == 0.0F?var2 + I18n.func_135052_a("options.off", new Object[0]):var2 + (int)(var4 * 100.0F) + "%")))))))))))))));
      } else if(p_74297_1_.func_74382_b()) {
         boolean var5 = this.func_74308_b(p_74297_1_);
         return var5?var2 + I18n.func_135052_a("options.on", new Object[0]):var2 + I18n.func_135052_a("options.off", new Object[0]);
      } else if(p_74297_1_ == GameSettings.Options.GUI_SCALE) {
         return var2 + func_74299_a(field_74367_ae, this.field_74335_Z);
      } else if(p_74297_1_ == GameSettings.Options.CHAT_VISIBILITY) {
         return var2 + I18n.func_135052_a(this.field_74343_n.func_151429_b(), new Object[0]);
      } else if(p_74297_1_ == GameSettings.Options.PARTICLES) {
         return var2 + func_74299_a(field_74364_ag, this.field_74362_aa);
      } else if(p_74297_1_ == GameSettings.Options.AMBIENT_OCCLUSION) {
         return var2 + func_74299_a(field_98303_au, this.field_74348_k);
      } else if(p_74297_1_ == GameSettings.Options.STREAM_COMPRESSION) {
         return var2 + func_74299_a(field_152391_aS, this.field_152405_O);
      } else if(p_74297_1_ == GameSettings.Options.STREAM_CHAT_ENABLED) {
         return var2 + func_74299_a(field_152392_aT, this.field_152408_R);
      } else if(p_74297_1_ == GameSettings.Options.STREAM_CHAT_USER_FILTER) {
         return var2 + func_74299_a(field_152393_aU, this.field_152409_S);
      } else if(p_74297_1_ == GameSettings.Options.STREAM_MIC_TOGGLE_BEHAVIOR) {
         return var2 + func_74299_a(field_152394_aV, this.field_152410_T);
      } else if(p_74297_1_ == GameSettings.Options.GRAPHICS) {
         if(this.field_74347_j) {
            return var2 + I18n.func_135052_a("options.graphics.fancy", new Object[0]);
         } else {
            String var3 = "options.graphics.fast";
            return var2 + I18n.func_135052_a("options.graphics.fast", new Object[0]);
         }
      } else {
         return var2;
      }
   }

   public void func_74300_a() {
      try {
         if(!this.field_74354_ai.exists()) {
            return;
         }

         BufferedReader var1 = new BufferedReader(new FileReader(this.field_74354_ai));
         String var2 = "";
         this.field_151446_aD.clear();

         while((var2 = var1.readLine()) != null) {
            try {
               String[] var3 = var2.split(":");
               if(var3[0].equals("mouseSensitivity")) {
                  this.field_74341_c = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("fov")) {
                  this.field_74334_X = this.func_74305_a(var3[1]) * 40.0F + 70.0F;
               }

               if(var3[0].equals("gamma")) {
                  this.field_74333_Y = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("saturation")) {
                  this.field_151452_as = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("invertYMouse")) {
                  this.field_74338_d = var3[1].equals("true");
               }

               if(var3[0].equals("renderDistance")) {
                  this.field_151451_c = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("guiScale")) {
                  this.field_74335_Z = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("particles")) {
                  this.field_74362_aa = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("bobView")) {
                  this.field_74336_f = var3[1].equals("true");
               }

               if(var3[0].equals("anaglyph3d")) {
                  this.field_74337_g = var3[1].equals("true");
               }

               if(var3[0].equals("maxFps")) {
                  this.field_74350_i = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("fboEnable")) {
                  this.field_151448_g = var3[1].equals("true");
               }

               if(var3[0].equals("difficulty")) {
                  this.field_74318_M = EnumDifficulty.func_151523_a(Integer.parseInt(var3[1]));
               }

               if(var3[0].equals("fancyGraphics")) {
                  this.field_74347_j = var3[1].equals("true");
               }

               if(var3[0].equals("ao")) {
                  if(var3[1].equals("true")) {
                     this.field_74348_k = 2;
                  } else if(var3[1].equals("false")) {
                     this.field_74348_k = 0;
                  } else {
                     this.field_74348_k = Integer.parseInt(var3[1]);
                  }
               }

               if(var3[0].equals("renderClouds")) {
                  this.field_74345_l = var3[1].equals("true");
               }

               if(var3[0].equals("resourcePacks")) {
                  this.field_151453_l = (List)field_151450_ay.fromJson(var2.substring(var2.indexOf(58) + 1), field_151449_az);
                  if(this.field_151453_l == null) {
                     this.field_151453_l = Lists.newArrayList();
                  }
               }

               if(var3[0].equals("lastServer") && var3.length >= 2) {
                  this.field_74332_R = var2.substring(var2.indexOf(58) + 1);
               }

               if(var3[0].equals("lang") && var3.length >= 2) {
                  this.field_74363_ab = var3[1];
               }

               if(var3[0].equals("chatVisibility")) {
                  this.field_74343_n = EntityPlayer.EnumChatVisibility.func_151426_a(Integer.parseInt(var3[1]));
               }

               if(var3[0].equals("chatColors")) {
                  this.field_74344_o = var3[1].equals("true");
               }

               if(var3[0].equals("chatLinks")) {
                  this.field_74359_p = var3[1].equals("true");
               }

               if(var3[0].equals("chatLinksPrompt")) {
                  this.field_74358_q = var3[1].equals("true");
               }

               if(var3[0].equals("chatOpacity")) {
                  this.field_74357_r = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("snooperEnabled")) {
                  this.field_74355_t = var3[1].equals("true");
               }

               if(var3[0].equals("fullscreen")) {
                  this.field_74353_u = var3[1].equals("true");
               }

               if(var3[0].equals("enableVsync")) {
                  this.field_74352_v = var3[1].equals("true");
               }

               if(var3[0].equals("useVbo")) {
                  this.field_178881_t = var3[1].equals("true");
               }

               if(var3[0].equals("hideServerAddress")) {
                  this.field_80005_w = var3[1].equals("true");
               }

               if(var3[0].equals("advancedItemTooltips")) {
                  this.field_82882_x = var3[1].equals("true");
               }

               if(var3[0].equals("pauseOnLostFocus")) {
                  this.field_82881_y = var3[1].equals("true");
               }

               if(var3[0].equals("touchscreen")) {
                  this.field_85185_A = var3[1].equals("true");
               }

               if(var3[0].equals("overrideHeight")) {
                  this.field_92119_C = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("overrideWidth")) {
                  this.field_92118_B = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("heldItemTooltips")) {
                  this.field_92117_D = var3[1].equals("true");
               }

               if(var3[0].equals("chatHeightFocused")) {
                  this.field_96694_H = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("chatHeightUnfocused")) {
                  this.field_96693_G = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("chatScale")) {
                  this.field_96691_E = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("chatWidth")) {
                  this.field_96692_F = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("showInventoryAchievementHint")) {
                  this.field_151441_H = var3[1].equals("true");
               }

               if(var3[0].equals("mipmapLevels")) {
                  this.field_151442_I = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("streamBytesPerPixel")) {
                  this.field_152400_J = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("streamMicVolume")) {
                  this.field_152401_K = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("streamSystemVolume")) {
                  this.field_152402_L = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("streamKbps")) {
                  this.field_152403_M = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("streamFps")) {
                  this.field_152404_N = this.func_74305_a(var3[1]);
               }

               if(var3[0].equals("streamCompression")) {
                  this.field_152405_O = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("streamSendMetadata")) {
                  this.field_152406_P = var3[1].equals("true");
               }

               if(var3[0].equals("streamPreferredServer") && var3.length >= 2) {
                  this.field_152407_Q = var2.substring(var2.indexOf(58) + 1);
               }

               if(var3[0].equals("streamChatEnabled")) {
                  this.field_152408_R = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("streamChatUserFilter")) {
                  this.field_152409_S = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("streamMicToggleBehavior")) {
                  this.field_152410_T = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("forceUnicodeFont")) {
                  this.field_151455_aw = var3[1].equals("true");
               }

               if(var3[0].equals("allowBlockAlternatives")) {
                  this.field_178880_u = var3[1].equals("true");
               }

               if(var3[0].equals("reducedDebugInfo")) {
                  this.field_178879_v = var3[1].equals("true");
               }

               KeyBinding[] var4 = this.field_74324_K;
               int var5 = var4.length;

               int var6;
               for(var6 = 0; var6 < var5; ++var6) {
                  KeyBinding var7 = var4[var6];
                  if(var3[0].equals("key_" + var7.func_151464_g())) {
                     var7.func_151462_b(Integer.parseInt(var3[1]));
                  }
               }

               SoundCategory[] var10 = SoundCategory.values();
               var5 = var10.length;

               for(var6 = 0; var6 < var5; ++var6) {
                  SoundCategory var12 = var10[var6];
                  if(var3[0].equals("soundCategory_" + var12.func_147155_a())) {
                     this.field_151446_aD.put(var12, Float.valueOf(this.func_74305_a(var3[1])));
                  }
               }

               EnumPlayerModelParts[] var11 = EnumPlayerModelParts.values();
               var5 = var11.length;

               for(var6 = 0; var6 < var5; ++var6) {
                  EnumPlayerModelParts var13 = var11[var6];
                  if(var3[0].equals("modelPart_" + var13.func_179329_c())) {
                     this.func_178878_a(var13, var3[1].equals("true"));
                  }
               }
            } catch (Exception var8) {
               field_151454_ax.warn("Skipping bad option: " + var2);
            }
         }

         KeyBinding.func_74508_b();
         var1.close();
      } catch (Exception var9) {
         field_151454_ax.error("Failed to load options", var9);
      }

   }

   private float func_74305_a(String p_74305_1_) {
      return p_74305_1_.equals("true")?1.0F:(p_74305_1_.equals("false")?0.0F:Float.parseFloat(p_74305_1_));
   }

   public void func_74303_b() {
      try {
         PrintWriter var1 = new PrintWriter(new FileWriter(this.field_74354_ai));
         var1.println("invertYMouse:" + this.field_74338_d);
         var1.println("mouseSensitivity:" + this.field_74341_c);
         var1.println("fov:" + (this.field_74334_X - 70.0F) / 40.0F);
         var1.println("gamma:" + this.field_74333_Y);
         var1.println("saturation:" + this.field_151452_as);
         var1.println("renderDistance:" + this.field_151451_c);
         var1.println("guiScale:" + this.field_74335_Z);
         var1.println("particles:" + this.field_74362_aa);
         var1.println("bobView:" + this.field_74336_f);
         var1.println("anaglyph3d:" + this.field_74337_g);
         var1.println("maxFps:" + this.field_74350_i);
         var1.println("fboEnable:" + this.field_151448_g);
         var1.println("difficulty:" + this.field_74318_M.func_151525_a());
         var1.println("fancyGraphics:" + this.field_74347_j);
         var1.println("ao:" + this.field_74348_k);
         var1.println("renderClouds:" + this.field_74345_l);
         var1.println("resourcePacks:" + field_151450_ay.toJson(this.field_151453_l));
         var1.println("lastServer:" + this.field_74332_R);
         var1.println("lang:" + this.field_74363_ab);
         var1.println("chatVisibility:" + this.field_74343_n.func_151428_a());
         var1.println("chatColors:" + this.field_74344_o);
         var1.println("chatLinks:" + this.field_74359_p);
         var1.println("chatLinksPrompt:" + this.field_74358_q);
         var1.println("chatOpacity:" + this.field_74357_r);
         var1.println("snooperEnabled:" + this.field_74355_t);
         var1.println("fullscreen:" + this.field_74353_u);
         var1.println("enableVsync:" + this.field_74352_v);
         var1.println("useVbo:" + this.field_178881_t);
         var1.println("hideServerAddress:" + this.field_80005_w);
         var1.println("advancedItemTooltips:" + this.field_82882_x);
         var1.println("pauseOnLostFocus:" + this.field_82881_y);
         var1.println("touchscreen:" + this.field_85185_A);
         var1.println("overrideWidth:" + this.field_92118_B);
         var1.println("overrideHeight:" + this.field_92119_C);
         var1.println("heldItemTooltips:" + this.field_92117_D);
         var1.println("chatHeightFocused:" + this.field_96694_H);
         var1.println("chatHeightUnfocused:" + this.field_96693_G);
         var1.println("chatScale:" + this.field_96691_E);
         var1.println("chatWidth:" + this.field_96692_F);
         var1.println("showInventoryAchievementHint:" + this.field_151441_H);
         var1.println("mipmapLevels:" + this.field_151442_I);
         var1.println("streamBytesPerPixel:" + this.field_152400_J);
         var1.println("streamMicVolume:" + this.field_152401_K);
         var1.println("streamSystemVolume:" + this.field_152402_L);
         var1.println("streamKbps:" + this.field_152403_M);
         var1.println("streamFps:" + this.field_152404_N);
         var1.println("streamCompression:" + this.field_152405_O);
         var1.println("streamSendMetadata:" + this.field_152406_P);
         var1.println("streamPreferredServer:" + this.field_152407_Q);
         var1.println("streamChatEnabled:" + this.field_152408_R);
         var1.println("streamChatUserFilter:" + this.field_152409_S);
         var1.println("streamMicToggleBehavior:" + this.field_152410_T);
         var1.println("forceUnicodeFont:" + this.field_151455_aw);
         var1.println("allowBlockAlternatives:" + this.field_178880_u);
         var1.println("reducedDebugInfo:" + this.field_178879_v);
         KeyBinding[] var2 = this.field_74324_K;
         int var3 = var2.length;

         int var4;
         for(var4 = 0; var4 < var3; ++var4) {
            KeyBinding var5 = var2[var4];
            var1.println("key_" + var5.func_151464_g() + ":" + var5.func_151463_i());
         }

         SoundCategory[] var7 = SoundCategory.values();
         var3 = var7.length;

         for(var4 = 0; var4 < var3; ++var4) {
            SoundCategory var9 = var7[var4];
            var1.println("soundCategory_" + var9.func_147155_a() + ":" + this.func_151438_a(var9));
         }

         EnumPlayerModelParts[] var8 = EnumPlayerModelParts.values();
         var3 = var8.length;

         for(var4 = 0; var4 < var3; ++var4) {
            EnumPlayerModelParts var10 = var8[var4];
            var1.println("modelPart_" + var10.func_179329_c() + ":" + this.field_178882_aU.contains(var10));
         }

         var1.close();
      } catch (Exception var6) {
         field_151454_ax.error("Failed to save options", var6);
      }

      this.func_82879_c();
   }

   public float func_151438_a(SoundCategory p_151438_1_) {
      return this.field_151446_aD.containsKey(p_151438_1_)?((Float)this.field_151446_aD.get(p_151438_1_)).floatValue():1.0F;
   }

   public void func_151439_a(SoundCategory p_151439_1_, float p_151439_2_) {
      this.field_74317_L.func_147118_V().func_147684_a(p_151439_1_, p_151439_2_);
      this.field_151446_aD.put(p_151439_1_, Float.valueOf(p_151439_2_));
   }

   public void func_82879_c() {
      if(this.field_74317_L.field_71439_g != null) {
         int var1 = 0;

         EnumPlayerModelParts var3;
         for(Iterator var2 = this.field_178882_aU.iterator(); var2.hasNext(); var1 |= var3.func_179327_a()) {
            var3 = (EnumPlayerModelParts)var2.next();
         }

         this.field_74317_L.field_71439_g.field_71174_a.func_147297_a(new C15PacketClientSettings(this.field_74363_ab, this.field_151451_c, this.field_74343_n, this.field_74344_o, var1));
      }

   }

   public Set func_178876_d() {
      return ImmutableSet.copyOf(this.field_178882_aU);
   }

   public void func_178878_a(EnumPlayerModelParts p_178878_1_, boolean p_178878_2_) {
      if(p_178878_2_) {
         this.field_178882_aU.add(p_178878_1_);
      } else {
         this.field_178882_aU.remove(p_178878_1_);
      }

      this.func_82879_c();
   }

   public void func_178877_a(EnumPlayerModelParts p_178877_1_) {
      if(!this.func_178876_d().contains(p_178877_1_)) {
         this.field_178882_aU.add(p_178877_1_);
      } else {
         this.field_178882_aU.remove(p_178877_1_);
      }

      this.func_82879_c();
   }

   public boolean func_74309_c() {
      return this.field_151451_c >= 4 && this.field_74345_l;
   }


   public static enum Options {

      INVERT_MOUSE("INVERT_MOUSE", 0, "options.invertMouse", false, true),
      SENSITIVITY("SENSITIVITY", 1, "options.sensitivity", true, false),
      FOV("FOV", 2, "options.fov", true, false, 30.0F, 110.0F, 1.0F),
      GAMMA("GAMMA", 3, "options.gamma", true, false),
      SATURATION("SATURATION", 4, "options.saturation", true, false),
      RENDER_DISTANCE("RENDER_DISTANCE", 5, "options.renderDistance", true, false, 2.0F, 16.0F, 1.0F),
      VIEW_BOBBING("VIEW_BOBBING", 6, "options.viewBobbing", false, true),
      ANAGLYPH("ANAGLYPH", 7, "options.anaglyph", false, true),
      FRAMERATE_LIMIT("FRAMERATE_LIMIT", 8, "options.framerateLimit", true, false, 10.0F, 260.0F, 10.0F),
      FBO_ENABLE("FBO_ENABLE", 9, "options.fboEnable", false, true),
      RENDER_CLOUDS("RENDER_CLOUDS", 10, "options.renderClouds", false, true),
      GRAPHICS("GRAPHICS", 11, "options.graphics", false, false),
      AMBIENT_OCCLUSION("AMBIENT_OCCLUSION", 12, "options.ao", false, false),
      GUI_SCALE("GUI_SCALE", 13, "options.guiScale", false, false),
      PARTICLES("PARTICLES", 14, "options.particles", false, false),
      CHAT_VISIBILITY("CHAT_VISIBILITY", 15, "options.chat.visibility", false, false),
      CHAT_COLOR("CHAT_COLOR", 16, "options.chat.color", false, true),
      CHAT_LINKS("CHAT_LINKS", 17, "options.chat.links", false, true),
      CHAT_OPACITY("CHAT_OPACITY", 18, "options.chat.opacity", true, false),
      CHAT_LINKS_PROMPT("CHAT_LINKS_PROMPT", 19, "options.chat.links.prompt", false, true),
      SNOOPER_ENABLED("SNOOPER_ENABLED", 20, "options.snooper", false, true),
      USE_FULLSCREEN("USE_FULLSCREEN", 21, "options.fullscreen", false, true),
      ENABLE_VSYNC("ENABLE_VSYNC", 22, "options.vsync", false, true),
      USE_VBO("USE_VBO", 23, "options.vbo", false, true),
      TOUCHSCREEN("TOUCHSCREEN", 24, "options.touchscreen", false, true),
      CHAT_SCALE("CHAT_SCALE", 25, "options.chat.scale", true, false),
      CHAT_WIDTH("CHAT_WIDTH", 26, "options.chat.width", true, false),
      CHAT_HEIGHT_FOCUSED("CHAT_HEIGHT_FOCUSED", 27, "options.chat.height.focused", true, false),
      CHAT_HEIGHT_UNFOCUSED("CHAT_HEIGHT_UNFOCUSED", 28, "options.chat.height.unfocused", true, false),
      MIPMAP_LEVELS("MIPMAP_LEVELS", 29, "options.mipmapLevels", true, false, 0.0F, 4.0F, 1.0F),
      FORCE_UNICODE_FONT("FORCE_UNICODE_FONT", 30, "options.forceUnicodeFont", false, true),
      STREAM_BYTES_PER_PIXEL("STREAM_BYTES_PER_PIXEL", 31, "options.stream.bytesPerPixel", true, false),
      STREAM_VOLUME_MIC("STREAM_VOLUME_MIC", 32, "options.stream.micVolumne", true, false),
      STREAM_VOLUME_SYSTEM("STREAM_VOLUME_SYSTEM", 33, "options.stream.systemVolume", true, false),
      STREAM_KBPS("STREAM_KBPS", 34, "options.stream.kbps", true, false),
      STREAM_FPS("STREAM_FPS", 35, "options.stream.fps", true, false),
      STREAM_COMPRESSION("STREAM_COMPRESSION", 36, "options.stream.compression", false, false),
      STREAM_SEND_METADATA("STREAM_SEND_METADATA", 37, "options.stream.sendMetadata", false, true),
      STREAM_CHAT_ENABLED("STREAM_CHAT_ENABLED", 38, "options.stream.chat.enabled", false, false),
      STREAM_CHAT_USER_FILTER("STREAM_CHAT_USER_FILTER", 39, "options.stream.chat.userFilter", false, false),
      STREAM_MIC_TOGGLE_BEHAVIOR("STREAM_MIC_TOGGLE_BEHAVIOR", 40, "options.stream.micToggleBehavior", false, false),
      BLOCK_ALTERNATIVES("BLOCK_ALTERNATIVES", 41, "options.blockAlternatives", false, true),
      REDUCED_DEBUG_INFO("REDUCED_DEBUG_INFO", 42, "options.reducedDebugInfo", false, true);
      private final boolean field_74385_A;
      private final boolean field_74386_B;
      private final String field_74387_C;
      private final float field_148270_M;
      private float field_148271_N;
      private float field_148272_O;
      // $FF: synthetic field
      private static final GameSettings.Options[] $VALUES = new GameSettings.Options[]{INVERT_MOUSE, SENSITIVITY, FOV, GAMMA, SATURATION, RENDER_DISTANCE, VIEW_BOBBING, ANAGLYPH, FRAMERATE_LIMIT, FBO_ENABLE, RENDER_CLOUDS, GRAPHICS, AMBIENT_OCCLUSION, GUI_SCALE, PARTICLES, CHAT_VISIBILITY, CHAT_COLOR, CHAT_LINKS, CHAT_OPACITY, CHAT_LINKS_PROMPT, SNOOPER_ENABLED, USE_FULLSCREEN, ENABLE_VSYNC, USE_VBO, TOUCHSCREEN, CHAT_SCALE, CHAT_WIDTH, CHAT_HEIGHT_FOCUSED, CHAT_HEIGHT_UNFOCUSED, MIPMAP_LEVELS, FORCE_UNICODE_FONT, STREAM_BYTES_PER_PIXEL, STREAM_VOLUME_MIC, STREAM_VOLUME_SYSTEM, STREAM_KBPS, STREAM_FPS, STREAM_COMPRESSION, STREAM_SEND_METADATA, STREAM_CHAT_ENABLED, STREAM_CHAT_USER_FILTER, STREAM_MIC_TOGGLE_BEHAVIOR, BLOCK_ALTERNATIVES, REDUCED_DEBUG_INFO};
      private static final String __OBFID = "CL_00000653";


      public static GameSettings.Options func_74379_a(int p_74379_0_) {
         GameSettings.Options[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            GameSettings.Options var4 = var1[var3];
            if(var4.func_74381_c() == p_74379_0_) {
               return var4;
            }
         }

         return null;
      }

      private Options(String p_i1015_1_, int p_i1015_2_, String p_i1015_3_, boolean p_i1015_4_, boolean p_i1015_5_) {
         this(p_i1015_1_, p_i1015_2_, p_i1015_3_, p_i1015_4_, p_i1015_5_, 0.0F, 1.0F, 0.0F);
      }

      private Options(String p_i45004_1_, int p_i45004_2_, String p_i45004_3_, boolean p_i45004_4_, boolean p_i45004_5_, float p_i45004_6_, float p_i45004_7_, float p_i45004_8_) {
         this.field_74387_C = p_i45004_3_;
         this.field_74385_A = p_i45004_4_;
         this.field_74386_B = p_i45004_5_;
         this.field_148271_N = p_i45004_6_;
         this.field_148272_O = p_i45004_7_;
         this.field_148270_M = p_i45004_8_;
      }

      public boolean func_74380_a() {
         return this.field_74385_A;
      }

      public boolean func_74382_b() {
         return this.field_74386_B;
      }

      public int func_74381_c() {
         return this.ordinal();
      }

      public String func_74378_d() {
         return this.field_74387_C;
      }

      public float func_148267_f() {
         return this.field_148272_O;
      }

      public void func_148263_a(float p_148263_1_) {
         this.field_148272_O = p_148263_1_;
      }

      public float func_148266_c(float p_148266_1_) {
         return MathHelper.func_76131_a((this.func_148268_e(p_148266_1_) - this.field_148271_N) / (this.field_148272_O - this.field_148271_N), 0.0F, 1.0F);
      }

      public float func_148262_d(float p_148262_1_) {
         return this.func_148268_e(this.field_148271_N + (this.field_148272_O - this.field_148271_N) * MathHelper.func_76131_a(p_148262_1_, 0.0F, 1.0F));
      }

      public float func_148268_e(float p_148268_1_) {
         p_148268_1_ = this.func_148264_f(p_148268_1_);
         return MathHelper.func_76131_a(p_148268_1_, this.field_148271_N, this.field_148272_O);
      }

      protected float func_148264_f(float p_148264_1_) {
         if(this.field_148270_M > 0.0F) {
            p_148264_1_ = this.field_148270_M * (float)Math.round(p_148264_1_ / this.field_148270_M);
         }

         return p_148264_1_;
      }

   }

   // $FF: synthetic class
   static final class SwitchOptions {

      // $FF: synthetic field
      static final int[] field_151477_a = new int[GameSettings.Options.values().length];
      private static final String __OBFID = "CL_00000652";


      static {
         try {
            field_151477_a[GameSettings.Options.INVERT_MOUSE.ordinal()] = 1;
         } catch (NoSuchFieldError var17) {
            ;
         }

         try {
            field_151477_a[GameSettings.Options.VIEW_BOBBING.ordinal()] = 2;
         } catch (NoSuchFieldError var16) {
            ;
         }

         try {
            field_151477_a[GameSettings.Options.ANAGLYPH.ordinal()] = 3;
         } catch (NoSuchFieldError var15) {
            ;
         }

         try {
            field_151477_a[GameSettings.Options.FBO_ENABLE.ordinal()] = 4;
         } catch (NoSuchFieldError var14) {
            ;
         }

         try {
            field_151477_a[GameSettings.Options.RENDER_CLOUDS.ordinal()] = 5;
         } catch (NoSuchFieldError var13) {
            ;
         }

         try {
            field_151477_a[GameSettings.Options.CHAT_COLOR.ordinal()] = 6;
         } catch (NoSuchFieldError var12) {
            ;
         }

         try {
            field_151477_a[GameSettings.Options.CHAT_LINKS.ordinal()] = 7;
         } catch (NoSuchFieldError var11) {
            ;
         }

         try {
            field_151477_a[GameSettings.Options.CHAT_LINKS_PROMPT.ordinal()] = 8;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            field_151477_a[GameSettings.Options.SNOOPER_ENABLED.ordinal()] = 9;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            field_151477_a[GameSettings.Options.USE_FULLSCREEN.ordinal()] = 10;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            field_151477_a[GameSettings.Options.ENABLE_VSYNC.ordinal()] = 11;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            field_151477_a[GameSettings.Options.USE_VBO.ordinal()] = 12;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            field_151477_a[GameSettings.Options.TOUCHSCREEN.ordinal()] = 13;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            field_151477_a[GameSettings.Options.STREAM_SEND_METADATA.ordinal()] = 14;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_151477_a[GameSettings.Options.FORCE_UNICODE_FONT.ordinal()] = 15;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_151477_a[GameSettings.Options.BLOCK_ALTERNATIVES.ordinal()] = 16;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_151477_a[GameSettings.Options.REDUCED_DEBUG_INFO.ordinal()] = 17;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
