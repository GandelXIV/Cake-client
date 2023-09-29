package net.minecraft.client.renderer;

import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.MapItemRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.culling.ClippingHelperImpl;
import net.minecraft.client.renderer.culling.Frustrum;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.shader.ShaderLinkHelper;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MouseFilter;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.biome.BiomeGenBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.Project;

public class EntityRenderer implements IResourceManagerReloadListener {

   private static final Logger field_147710_q = LogManager.getLogger();
   private static final ResourceLocation field_110924_q = new ResourceLocation("textures/environment/rain.png");
   private static final ResourceLocation field_110923_r = new ResourceLocation("textures/environment/snow.png");
   public static boolean field_78517_a;
   public static int field_78515_b;
   private Minecraft field_78531_r;
   private final IResourceManager field_147711_ac;
   private Random field_78537_ab = new Random();
   private float field_78530_s;
   public final ItemRenderer field_78516_c;
   private final MapItemRenderer field_147709_v;
   private int field_78529_t;
   private Entity field_78528_u;
   private MouseFilter field_78527_v = new MouseFilter();
   private MouseFilter field_78526_w = new MouseFilter();
   private float field_78490_B = 4.0F;
   private float field_78491_C = 4.0F;
   private float field_78496_H;
   private float field_78497_I;
   private float field_78498_J;
   private float field_78499_K;
   private float field_78492_L;
   private float field_78507_R;
   private float field_78506_S;
   private float field_82831_U;
   private float field_82832_V;
   private boolean field_78500_U;
   private boolean field_175074_C = true;
   private boolean field_175073_D = true;
   private long field_78508_Y = Minecraft.func_71386_F();
   private long field_78510_Z;
   private final DynamicTexture field_78513_d;
   private final int[] field_78504_Q;
   private final ResourceLocation field_110922_T;
   private boolean field_78536_aa;
   private float field_78514_e;
   private float field_175075_L;
   private int field_78534_ac;
   private float[] field_175076_N = new float[1024];
   private float[] field_175077_O = new float[1024];
   private FloatBuffer field_78521_m = GLAllocation.func_74529_h(16);
   private float field_175080_Q;
   private float field_175082_R;
   private float field_175081_S;
   private float field_78535_ad;
   private float field_78539_ae;
   private int field_175079_V = 0;
   private boolean field_175078_W = false;
   private double field_78503_V = 1.0D;
   private double field_78502_W;
   private double field_78509_X;
   private ShaderGroup field_147707_d;
   private static final ResourceLocation[] field_147712_ad = new ResourceLocation[]{new ResourceLocation("shaders/post/notch.json"), new ResourceLocation("shaders/post/fxaa.json"), new ResourceLocation("shaders/post/art.json"), new ResourceLocation("shaders/post/bumpy.json"), new ResourceLocation("shaders/post/blobs2.json"), new ResourceLocation("shaders/post/pencil.json"), new ResourceLocation("shaders/post/color_convolve.json"), new ResourceLocation("shaders/post/deconverge.json"), new ResourceLocation("shaders/post/flip.json"), new ResourceLocation("shaders/post/invert.json"), new ResourceLocation("shaders/post/ntsc.json"), new ResourceLocation("shaders/post/outline.json"), new ResourceLocation("shaders/post/phosphor.json"), new ResourceLocation("shaders/post/scan_pincushion.json"), new ResourceLocation("shaders/post/sobel.json"), new ResourceLocation("shaders/post/bits.json"), new ResourceLocation("shaders/post/desaturate.json"), new ResourceLocation("shaders/post/green.json"), new ResourceLocation("shaders/post/blur.json"), new ResourceLocation("shaders/post/wobble.json"), new ResourceLocation("shaders/post/blobs.json"), new ResourceLocation("shaders/post/antialias.json"), new ResourceLocation("shaders/post/creeper.json"), new ResourceLocation("shaders/post/spider.json")};
   public static final int field_147708_e = field_147712_ad.length;
   private int field_147713_ae;
   private boolean field_175083_ad;
   private int field_175084_ae;
   private static final String __OBFID = "CL_00000947";


   public EntityRenderer(Minecraft p_i45076_1_, IResourceManager p_i45076_2_) {
      this.field_147713_ae = field_147708_e;
      this.field_175083_ad = false;
      this.field_175084_ae = 0;
      this.field_78531_r = p_i45076_1_;
      this.field_147711_ac = p_i45076_2_;
      this.field_78516_c = p_i45076_1_.func_175597_ag();
      this.field_147709_v = new MapItemRenderer(p_i45076_1_.func_110434_K());
      this.field_78513_d = new DynamicTexture(16, 16);
      this.field_110922_T = p_i45076_1_.func_110434_K().func_110578_a("lightMap", this.field_78513_d);
      this.field_78504_Q = this.field_78513_d.func_110565_c();
      this.field_147707_d = null;

      for(int var3 = 0; var3 < 32; ++var3) {
         for(int var4 = 0; var4 < 32; ++var4) {
            float var5 = (float)(var4 - 16);
            float var6 = (float)(var3 - 16);
            float var7 = MathHelper.func_76129_c(var5 * var5 + var6 * var6);
            this.field_175076_N[var3 << 5 | var4] = -var6 / var7;
            this.field_175077_O[var3 << 5 | var4] = var5 / var7;
         }
      }

   }

   public boolean func_147702_a() {
      return OpenGlHelper.field_148824_g && this.field_147707_d != null;
   }

   public void func_175071_c() {
      this.field_175083_ad = !this.field_175083_ad;
   }

   public void func_175066_a(Entity p_175066_1_) {
      if(OpenGlHelper.field_148824_g) {
         if(this.field_147707_d != null) {
            this.field_147707_d.func_148021_a();
         }

         this.field_147707_d = null;
         if(p_175066_1_ instanceof EntityCreeper) {
            this.func_175069_a(new ResourceLocation("shaders/post/creeper.json"));
         } else if(p_175066_1_ instanceof EntitySpider) {
            this.func_175069_a(new ResourceLocation("shaders/post/spider.json"));
         } else if(p_175066_1_ instanceof EntityEnderman) {
            this.func_175069_a(new ResourceLocation("shaders/post/invert.json"));
         }

      }
   }

   public void func_147705_c() {
      if(OpenGlHelper.field_148824_g) {
         if(this.field_78531_r.func_175606_aa() instanceof EntityPlayer) {
            if(this.field_147707_d != null) {
               this.field_147707_d.func_148021_a();
            }

            this.field_147713_ae = (this.field_147713_ae + 1) % (field_147712_ad.length + 1);
            if(this.field_147713_ae != field_147708_e) {
               this.func_175069_a(field_147712_ad[this.field_147713_ae]);
            } else {
               this.field_147707_d = null;
            }

         }
      }
   }

   private void func_175069_a(ResourceLocation p_175069_1_) {
      try {
         this.field_147707_d = new ShaderGroup(this.field_78531_r.func_110434_K(), this.field_147711_ac, this.field_78531_r.func_147110_a(), p_175069_1_);
         this.field_147707_d.func_148026_a(this.field_78531_r.field_71443_c, this.field_78531_r.field_71440_d);
         this.field_175083_ad = true;
      } catch (IOException var3) {
         field_147710_q.warn("Failed to load shader: " + p_175069_1_, var3);
         this.field_147713_ae = field_147708_e;
         this.field_175083_ad = false;
      } catch (JsonSyntaxException var4) {
         field_147710_q.warn("Failed to load shader: " + p_175069_1_, var4);
         this.field_147713_ae = field_147708_e;
         this.field_175083_ad = false;
      }

   }

   public void func_110549_a(IResourceManager p_110549_1_) {
      if(this.field_147707_d != null) {
         this.field_147707_d.func_148021_a();
      }

      this.field_147707_d = null;
      if(this.field_147713_ae != field_147708_e) {
         this.func_175069_a(field_147712_ad[this.field_147713_ae]);
      } else {
         this.func_175066_a(this.field_78531_r.func_175606_aa());
      }

   }

   public void func_78464_a() {
      if(OpenGlHelper.field_148824_g && ShaderLinkHelper.func_148074_b() == null) {
         ShaderLinkHelper.func_148076_a();
      }

      this.func_78477_e();
      this.func_78470_f();
      this.field_78535_ad = this.field_78539_ae;
      this.field_78491_C = this.field_78490_B;
      float var1;
      float var2;
      if(this.field_78531_r.field_71474_y.field_74326_T) {
         var1 = this.field_78531_r.field_71474_y.field_74341_c * 0.6F + 0.2F;
         var2 = var1 * var1 * var1 * 8.0F;
         this.field_78498_J = this.field_78527_v.func_76333_a(this.field_78496_H, 0.05F * var2);
         this.field_78499_K = this.field_78526_w.func_76333_a(this.field_78497_I, 0.05F * var2);
         this.field_78492_L = 0.0F;
         this.field_78496_H = 0.0F;
         this.field_78497_I = 0.0F;
      } else {
         this.field_78498_J = 0.0F;
         this.field_78499_K = 0.0F;
         this.field_78527_v.func_180179_a();
         this.field_78526_w.func_180179_a();
      }

      if(this.field_78531_r.func_175606_aa() == null) {
         this.field_78531_r.func_175607_a(this.field_78531_r.field_71439_g);
      }

      var1 = this.field_78531_r.field_71441_e.func_175724_o(new BlockPos(this.field_78531_r.func_175606_aa()));
      var2 = (float)this.field_78531_r.field_71474_y.field_151451_c / 32.0F;
      float var3 = var1 * (1.0F - var2) + var2;
      this.field_78539_ae += (var3 - this.field_78539_ae) * 0.1F;
      ++this.field_78529_t;
      this.field_78516_c.func_78441_a();
      this.func_78484_h();
      this.field_82832_V = this.field_82831_U;
      if(BossStatus.field_82825_d) {
         this.field_82831_U += 0.05F;
         if(this.field_82831_U > 1.0F) {
            this.field_82831_U = 1.0F;
         }

         BossStatus.field_82825_d = false;
      } else if(this.field_82831_U > 0.0F) {
         this.field_82831_U -= 0.0125F;
      }

   }

   public ShaderGroup func_147706_e() {
      return this.field_147707_d;
   }

   public void func_147704_a(int p_147704_1_, int p_147704_2_) {
      if(OpenGlHelper.field_148824_g) {
         if(this.field_147707_d != null) {
            this.field_147707_d.func_148026_a(p_147704_1_, p_147704_2_);
         }

         this.field_78531_r.field_71438_f.func_72720_a(p_147704_1_, p_147704_2_);
      }
   }

   public void func_78473_a(float p_78473_1_) {
      Entity var2 = this.field_78531_r.func_175606_aa();
      if(var2 != null) {
         if(this.field_78531_r.field_71441_e != null) {
            this.field_78531_r.field_71424_I.func_76320_a("pick");
            this.field_78531_r.field_147125_j = null;
            double var3 = (double)this.field_78531_r.field_71442_b.func_78757_d();
            this.field_78531_r.field_71476_x = var2.func_174822_a(var3, p_78473_1_);
            double var5 = var3;
            Vec3 var7 = var2.func_174824_e(p_78473_1_);
            if(this.field_78531_r.field_71442_b.func_78749_i()) {
               var3 = 6.0D;
               var5 = 6.0D;
            } else {
               if(var3 > 3.0D) {
                  var5 = 3.0D;
               }

               var3 = var5;
            }

            if(this.field_78531_r.field_71476_x != null) {
               var5 = this.field_78531_r.field_71476_x.field_72307_f.func_72438_d(var7);
            }

            Vec3 var8 = var2.func_70676_i(p_78473_1_);
            Vec3 var9 = var7.func_72441_c(var8.field_72450_a * var3, var8.field_72448_b * var3, var8.field_72449_c * var3);
            this.field_78528_u = null;
            Vec3 var10 = null;
            float var11 = 1.0F;
            List var12 = this.field_78531_r.field_71441_e.func_72839_b(var2, var2.func_174813_aQ().func_72321_a(var8.field_72450_a * var3, var8.field_72448_b * var3, var8.field_72449_c * var3).func_72314_b((double)var11, (double)var11, (double)var11));
            double var13 = var5;

            for(int var15 = 0; var15 < var12.size(); ++var15) {
               Entity var16 = (Entity)var12.get(var15);
               if(var16.func_70067_L()) {
                  float var17 = var16.func_70111_Y();
                  AxisAlignedBB var18 = var16.func_174813_aQ().func_72314_b((double)var17, (double)var17, (double)var17);
                  MovingObjectPosition var19 = var18.func_72327_a(var7, var9);
                  if(var18.func_72318_a(var7)) {
                     if(0.0D < var13 || var13 == 0.0D) {
                        this.field_78528_u = var16;
                        var10 = var19 == null?var7:var19.field_72307_f;
                        var13 = 0.0D;
                     }
                  } else if(var19 != null) {
                     double var20 = var7.func_72438_d(var19.field_72307_f);
                     if(var20 < var13 || var13 == 0.0D) {
                        if(var16 == var2.field_70154_o) {
                           if(var13 == 0.0D) {
                              this.field_78528_u = var16;
                              var10 = var19.field_72307_f;
                           }
                        } else {
                           this.field_78528_u = var16;
                           var10 = var19.field_72307_f;
                           var13 = var20;
                        }
                     }
                  }
               }
            }

            if(this.field_78528_u != null && (var13 < var5 || this.field_78531_r.field_71476_x == null)) {
               this.field_78531_r.field_71476_x = new MovingObjectPosition(this.field_78528_u, var10);
               if(this.field_78528_u instanceof EntityLivingBase || this.field_78528_u instanceof EntityItemFrame) {
                  this.field_78531_r.field_147125_j = this.field_78528_u;
               }
            }

            this.field_78531_r.field_71424_I.func_76319_b();
         }
      }
   }

   private void func_78477_e() {
      float var1 = 1.0F;
      if(this.field_78531_r.func_175606_aa() instanceof AbstractClientPlayer) {
         AbstractClientPlayer var2 = (AbstractClientPlayer)this.field_78531_r.func_175606_aa();
         var1 = var2.func_175156_o();
      }

      this.field_78506_S = this.field_78507_R;
      this.field_78507_R += (var1 - this.field_78507_R) * 0.5F;
      if(this.field_78507_R > 1.5F) {
         this.field_78507_R = 1.5F;
      }

      if(this.field_78507_R < 0.1F) {
         this.field_78507_R = 0.1F;
      }

   }

   private float func_78481_a(float p_78481_1_, boolean p_78481_2_) {
      if(this.field_175078_W) {
         return 90.0F;
      } else {
         Entity var3 = this.field_78531_r.func_175606_aa();
         float var4 = 70.0F;
         if(p_78481_2_) {
            var4 = this.field_78531_r.field_71474_y.field_74334_X;
            var4 *= this.field_78506_S + (this.field_78507_R - this.field_78506_S) * p_78481_1_;
         }

         if(var3 instanceof EntityLivingBase && ((EntityLivingBase)var3).func_110143_aJ() <= 0.0F) {
            float var5 = (float)((EntityLivingBase)var3).field_70725_aQ + p_78481_1_;
            var4 /= (1.0F - 500.0F / (var5 + 500.0F)) * 2.0F + 1.0F;
         }

         Block var6 = ActiveRenderInfo.func_180786_a(this.field_78531_r.field_71441_e, var3, p_78481_1_);
         if(var6.func_149688_o() == Material.field_151586_h) {
            var4 = var4 * 60.0F / 70.0F;
         }

         return var4;
      }
   }

   private void func_78482_e(float p_78482_1_) {
      if(this.field_78531_r.func_175606_aa() instanceof EntityLivingBase) {
         EntityLivingBase var2 = (EntityLivingBase)this.field_78531_r.func_175606_aa();
         float var3 = (float)var2.field_70737_aN - p_78482_1_;
         float var4;
         if(var2.func_110143_aJ() <= 0.0F) {
            var4 = (float)var2.field_70725_aQ + p_78482_1_;
            GlStateManager.func_179114_b(40.0F - 8000.0F / (var4 + 200.0F), 0.0F, 0.0F, 1.0F);
         }

         if(var3 < 0.0F) {
            return;
         }

         var3 /= (float)var2.field_70738_aO;
         var3 = MathHelper.func_76126_a(var3 * var3 * var3 * var3 * 3.1415927F);
         var4 = var2.field_70739_aP;
         GlStateManager.func_179114_b(-var4, 0.0F, 1.0F, 0.0F);
         GlStateManager.func_179114_b(-var3 * 14.0F, 0.0F, 0.0F, 1.0F);
         GlStateManager.func_179114_b(var4, 0.0F, 1.0F, 0.0F);
      }

   }

   private void func_78475_f(float p_78475_1_) {
      if(this.field_78531_r.func_175606_aa() instanceof EntityPlayer) {
         EntityPlayer var2 = (EntityPlayer)this.field_78531_r.func_175606_aa();
         float var3 = var2.field_70140_Q - var2.field_70141_P;
         float var4 = -(var2.field_70140_Q + var3 * p_78475_1_);
         float var5 = var2.field_71107_bF + (var2.field_71109_bG - var2.field_71107_bF) * p_78475_1_;
         float var6 = var2.field_70727_aS + (var2.field_70726_aT - var2.field_70727_aS) * p_78475_1_;
         GlStateManager.func_179109_b(MathHelper.func_76126_a(var4 * 3.1415927F) * var5 * 0.5F, -Math.abs(MathHelper.func_76134_b(var4 * 3.1415927F) * var5), 0.0F);
         GlStateManager.func_179114_b(MathHelper.func_76126_a(var4 * 3.1415927F) * var5 * 3.0F, 0.0F, 0.0F, 1.0F);
         GlStateManager.func_179114_b(Math.abs(MathHelper.func_76134_b(var4 * 3.1415927F - 0.2F) * var5) * 5.0F, 1.0F, 0.0F, 0.0F);
         GlStateManager.func_179114_b(var6, 1.0F, 0.0F, 0.0F);
      }
   }

   private void func_78467_g(float p_78467_1_) {
      Entity var2 = this.field_78531_r.func_175606_aa();
      float var3 = var2.func_70047_e();
      double var4 = var2.field_70169_q + (var2.field_70165_t - var2.field_70169_q) * (double)p_78467_1_;
      double var6 = var2.field_70167_r + (var2.field_70163_u - var2.field_70167_r) * (double)p_78467_1_ + (double)var3;
      double var8 = var2.field_70166_s + (var2.field_70161_v - var2.field_70166_s) * (double)p_78467_1_;
      if(var2 instanceof EntityLivingBase && ((EntityLivingBase)var2).func_70608_bn()) {
         var3 = (float)((double)var3 + 1.0D);
         GlStateManager.func_179109_b(0.0F, 0.3F, 0.0F);
         if(!this.field_78531_r.field_71474_y.field_74325_U) {
            BlockPos var27 = new BlockPos(var2);
            IBlockState var11 = this.field_78531_r.field_71441_e.func_180495_p(var27);
            Block var29 = var11.func_177230_c();
            if(var29 == Blocks.field_150324_C) {
               int var30 = ((EnumFacing)var11.func_177229_b(BlockBed.field_176387_N)).func_176736_b();
               GlStateManager.func_179114_b((float)(var30 * 90), 0.0F, 1.0F, 0.0F);
            }

            GlStateManager.func_179114_b(var2.field_70126_B + (var2.field_70177_z - var2.field_70126_B) * p_78467_1_ + 180.0F, 0.0F, -1.0F, 0.0F);
            GlStateManager.func_179114_b(var2.field_70127_C + (var2.field_70125_A - var2.field_70127_C) * p_78467_1_, -1.0F, 0.0F, 0.0F);
         }
      } else if(this.field_78531_r.field_71474_y.field_74320_O > 0) {
         double var10 = (double)(this.field_78491_C + (this.field_78490_B - this.field_78491_C) * p_78467_1_);
         if(this.field_78531_r.field_71474_y.field_74325_U) {
            GlStateManager.func_179109_b(0.0F, 0.0F, (float)(-var10));
         } else {
            float var12 = var2.field_70177_z;
            float var13 = var2.field_70125_A;
            if(this.field_78531_r.field_71474_y.field_74320_O == 2) {
               var13 += 180.0F;
            }

            double var14 = (double)(-MathHelper.func_76126_a(var12 / 180.0F * 3.1415927F) * MathHelper.func_76134_b(var13 / 180.0F * 3.1415927F)) * var10;
            double var16 = (double)(MathHelper.func_76134_b(var12 / 180.0F * 3.1415927F) * MathHelper.func_76134_b(var13 / 180.0F * 3.1415927F)) * var10;
            double var18 = (double)(-MathHelper.func_76126_a(var13 / 180.0F * 3.1415927F)) * var10;

            for(int var20 = 0; var20 < 8; ++var20) {
               float var21 = (float)((var20 & 1) * 2 - 1);
               float var22 = (float)((var20 >> 1 & 1) * 2 - 1);
               float var23 = (float)((var20 >> 2 & 1) * 2 - 1);
               var21 *= 0.1F;
               var22 *= 0.1F;
               var23 *= 0.1F;
               MovingObjectPosition var24 = this.field_78531_r.field_71441_e.func_72933_a(new Vec3(var4 + (double)var21, var6 + (double)var22, var8 + (double)var23), new Vec3(var4 - var14 + (double)var21 + (double)var23, var6 - var18 + (double)var22, var8 - var16 + (double)var23));
               if(var24 != null) {
                  double var25 = var24.field_72307_f.func_72438_d(new Vec3(var4, var6, var8));
                  if(var25 < var10) {
                     var10 = var25;
                  }
               }
            }

            if(this.field_78531_r.field_71474_y.field_74320_O == 2) {
               GlStateManager.func_179114_b(180.0F, 0.0F, 1.0F, 0.0F);
            }

            GlStateManager.func_179114_b(var2.field_70125_A - var13, 1.0F, 0.0F, 0.0F);
            GlStateManager.func_179114_b(var2.field_70177_z - var12, 0.0F, 1.0F, 0.0F);
            GlStateManager.func_179109_b(0.0F, 0.0F, (float)(-var10));
            GlStateManager.func_179114_b(var12 - var2.field_70177_z, 0.0F, 1.0F, 0.0F);
            GlStateManager.func_179114_b(var13 - var2.field_70125_A, 1.0F, 0.0F, 0.0F);
         }
      } else {
         GlStateManager.func_179109_b(0.0F, 0.0F, -0.1F);
      }

      if(!this.field_78531_r.field_71474_y.field_74325_U) {
         GlStateManager.func_179114_b(var2.field_70127_C + (var2.field_70125_A - var2.field_70127_C) * p_78467_1_, 1.0F, 0.0F, 0.0F);
         if(var2 instanceof EntityAnimal) {
            EntityAnimal var28 = (EntityAnimal)var2;
            GlStateManager.func_179114_b(var28.field_70758_at + (var28.field_70759_as - var28.field_70758_at) * p_78467_1_ + 180.0F, 0.0F, 1.0F, 0.0F);
         } else {
            GlStateManager.func_179114_b(var2.field_70126_B + (var2.field_70177_z - var2.field_70126_B) * p_78467_1_ + 180.0F, 0.0F, 1.0F, 0.0F);
         }
      }

      GlStateManager.func_179109_b(0.0F, -var3, 0.0F);
      var4 = var2.field_70169_q + (var2.field_70165_t - var2.field_70169_q) * (double)p_78467_1_;
      var6 = var2.field_70167_r + (var2.field_70163_u - var2.field_70167_r) * (double)p_78467_1_ + (double)var3;
      var8 = var2.field_70166_s + (var2.field_70161_v - var2.field_70166_s) * (double)p_78467_1_;
      this.field_78500_U = this.field_78531_r.field_71438_f.func_72721_a(var4, var6, var8, p_78467_1_);
   }

   private void func_78479_a(float p_78479_1_, int p_78479_2_) {
      this.field_78530_s = (float)(this.field_78531_r.field_71474_y.field_151451_c * 16);
      GlStateManager.func_179128_n(5889);
      GlStateManager.func_179096_D();
      float var3 = 0.07F;
      if(this.field_78531_r.field_71474_y.field_74337_g) {
         GlStateManager.func_179109_b((float)(-(p_78479_2_ * 2 - 1)) * var3, 0.0F, 0.0F);
      }

      if(this.field_78503_V != 1.0D) {
         GlStateManager.func_179109_b((float)this.field_78502_W, (float)(-this.field_78509_X), 0.0F);
         GlStateManager.func_179139_a(this.field_78503_V, this.field_78503_V, 1.0D);
      }

      Project.gluPerspective(this.func_78481_a(p_78479_1_, true), (float)this.field_78531_r.field_71443_c / (float)this.field_78531_r.field_71440_d, 0.05F, this.field_78530_s * MathHelper.field_180189_a);
      GlStateManager.func_179128_n(5888);
      GlStateManager.func_179096_D();
      if(this.field_78531_r.field_71474_y.field_74337_g) {
         GlStateManager.func_179109_b((float)(p_78479_2_ * 2 - 1) * 0.1F, 0.0F, 0.0F);
      }

      this.func_78482_e(p_78479_1_);
      if(this.field_78531_r.field_71474_y.field_74336_f) {
         this.func_78475_f(p_78479_1_);
      }

      float var4 = this.field_78531_r.field_71439_g.field_71080_cy + (this.field_78531_r.field_71439_g.field_71086_bY - this.field_78531_r.field_71439_g.field_71080_cy) * p_78479_1_;
      if(var4 > 0.0F) {
         byte var5 = 20;
         if(this.field_78531_r.field_71439_g.func_70644_a(Potion.field_76431_k)) {
            var5 = 7;
         }

         float var6 = 5.0F / (var4 * var4 + 5.0F) - var4 * 0.04F;
         var6 *= var6;
         GlStateManager.func_179114_b(((float)this.field_78529_t + p_78479_1_) * (float)var5, 0.0F, 1.0F, 1.0F);
         GlStateManager.func_179152_a(1.0F / var6, 1.0F, 1.0F);
         GlStateManager.func_179114_b(-((float)this.field_78529_t + p_78479_1_) * (float)var5, 0.0F, 1.0F, 1.0F);
      }

      this.func_78467_g(p_78479_1_);
      if(this.field_175078_W) {
         switch(this.field_175079_V) {
         case 0:
            GlStateManager.func_179114_b(90.0F, 0.0F, 1.0F, 0.0F);
            break;
         case 1:
            GlStateManager.func_179114_b(180.0F, 0.0F, 1.0F, 0.0F);
            break;
         case 2:
            GlStateManager.func_179114_b(-90.0F, 0.0F, 1.0F, 0.0F);
            break;
         case 3:
            GlStateManager.func_179114_b(90.0F, 1.0F, 0.0F, 0.0F);
            break;
         case 4:
            GlStateManager.func_179114_b(-90.0F, 1.0F, 0.0F, 0.0F);
         }
      }

   }

   private void func_78476_b(float p_78476_1_, int p_78476_2_) {
      if(!this.field_175078_W) {
         GlStateManager.func_179128_n(5889);
         GlStateManager.func_179096_D();
         float var3 = 0.07F;
         if(this.field_78531_r.field_71474_y.field_74337_g) {
            GlStateManager.func_179109_b((float)(-(p_78476_2_ * 2 - 1)) * var3, 0.0F, 0.0F);
         }

         Project.gluPerspective(this.func_78481_a(p_78476_1_, false), (float)this.field_78531_r.field_71443_c / (float)this.field_78531_r.field_71440_d, 0.05F, this.field_78530_s * 2.0F);
         GlStateManager.func_179128_n(5888);
         GlStateManager.func_179096_D();
         if(this.field_78531_r.field_71474_y.field_74337_g) {
            GlStateManager.func_179109_b((float)(p_78476_2_ * 2 - 1) * 0.1F, 0.0F, 0.0F);
         }

         GlStateManager.func_179094_E();
         this.func_78482_e(p_78476_1_);
         if(this.field_78531_r.field_71474_y.field_74336_f) {
            this.func_78475_f(p_78476_1_);
         }

         boolean var4 = this.field_78531_r.func_175606_aa() instanceof EntityLivingBase && ((EntityLivingBase)this.field_78531_r.func_175606_aa()).func_70608_bn();
         if(this.field_78531_r.field_71474_y.field_74320_O == 0 && !var4 && !this.field_78531_r.field_71474_y.field_74319_N && !this.field_78531_r.field_71442_b.func_78747_a()) {
            this.func_180436_i();
            this.field_78516_c.func_78440_a(p_78476_1_);
            this.func_175072_h();
         }

         GlStateManager.func_179121_F();
         if(this.field_78531_r.field_71474_y.field_74320_O == 0 && !var4) {
            this.field_78516_c.func_78447_b(p_78476_1_);
            this.func_78482_e(p_78476_1_);
         }

         if(this.field_78531_r.field_71474_y.field_74336_f) {
            this.func_78475_f(p_78476_1_);
         }

      }
   }

   public void func_175072_h() {
      GlStateManager.func_179138_g(OpenGlHelper.field_77476_b);
      GlStateManager.func_179090_x();
      GlStateManager.func_179138_g(OpenGlHelper.field_77478_a);
   }

   public void func_180436_i() {
      GlStateManager.func_179138_g(OpenGlHelper.field_77476_b);
      GlStateManager.func_179128_n(5890);
      GlStateManager.func_179096_D();
      float var1 = 0.00390625F;
      GlStateManager.func_179152_a(var1, var1, var1);
      GlStateManager.func_179109_b(8.0F, 8.0F, 8.0F);
      GlStateManager.func_179128_n(5888);
      this.field_78531_r.func_110434_K().func_110577_a(this.field_110922_T);
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      GL11.glTexParameteri(3553, 10242, 10496);
      GL11.glTexParameteri(3553, 10243, 10496);
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.func_179098_w();
      GlStateManager.func_179138_g(OpenGlHelper.field_77478_a);
   }

   private void func_78470_f() {
      this.field_175075_L = (float)((double)this.field_175075_L + (Math.random() - Math.random()) * Math.random() * Math.random());
      this.field_175075_L = (float)((double)this.field_175075_L * 0.9D);
      this.field_78514_e += (this.field_175075_L - this.field_78514_e) * 1.0F;
      this.field_78536_aa = true;
   }

   private void func_78472_g(float p_78472_1_) {
      if(this.field_78536_aa) {
         this.field_78531_r.field_71424_I.func_76320_a("lightTex");
         WorldClient var2 = this.field_78531_r.field_71441_e;
         if(var2 != null) {
            for(int var3 = 0; var3 < 256; ++var3) {
               float var4 = var2.func_72971_b(1.0F) * 0.95F + 0.05F;
               float var5 = var2.field_73011_w.func_177497_p()[var3 / 16] * var4;
               float var6 = var2.field_73011_w.func_177497_p()[var3 % 16] * (this.field_78514_e * 0.1F + 1.5F);
               if(var2.func_175658_ac() > 0) {
                  var5 = var2.field_73011_w.func_177497_p()[var3 / 16];
               }

               float var7 = var5 * (var2.func_72971_b(1.0F) * 0.65F + 0.35F);
               float var8 = var5 * (var2.func_72971_b(1.0F) * 0.65F + 0.35F);
               float var11 = var6 * ((var6 * 0.6F + 0.4F) * 0.6F + 0.4F);
               float var12 = var6 * (var6 * var6 * 0.6F + 0.4F);
               float var13 = var7 + var6;
               float var14 = var8 + var11;
               float var15 = var5 + var12;
               var13 = var13 * 0.96F + 0.03F;
               var14 = var14 * 0.96F + 0.03F;
               var15 = var15 * 0.96F + 0.03F;
               float var16;
               if(this.field_82831_U > 0.0F) {
                  var16 = this.field_82832_V + (this.field_82831_U - this.field_82832_V) * p_78472_1_;
                  var13 = var13 * (1.0F - var16) + var13 * 0.7F * var16;
                  var14 = var14 * (1.0F - var16) + var14 * 0.6F * var16;
                  var15 = var15 * (1.0F - var16) + var15 * 0.6F * var16;
               }

               if(var2.field_73011_w.func_177502_q() == 1) {
                  var13 = 0.22F + var6 * 0.75F;
                  var14 = 0.28F + var11 * 0.75F;
                  var15 = 0.25F + var12 * 0.75F;
               }

               float var17;
               if(this.field_78531_r.field_71439_g.func_70644_a(Potion.field_76439_r)) {
                  var16 = this.func_180438_a(this.field_78531_r.field_71439_g, p_78472_1_);
                  var17 = 1.0F / var13;
                  if(var17 > 1.0F / var14) {
                     var17 = 1.0F / var14;
                  }

                  if(var17 > 1.0F / var15) {
                     var17 = 1.0F / var15;
                  }

                  var13 = var13 * (1.0F - var16) + var13 * var17 * var16;
                  var14 = var14 * (1.0F - var16) + var14 * var17 * var16;
                  var15 = var15 * (1.0F - var16) + var15 * var17 * var16;
               }

               if(var13 > 1.0F) {
                  var13 = 1.0F;
               }

               if(var14 > 1.0F) {
                  var14 = 1.0F;
               }

               if(var15 > 1.0F) {
                  var15 = 1.0F;
               }

               var16 = this.field_78531_r.field_71474_y.field_74333_Y;
               var17 = 1.0F - var13;
               float var18 = 1.0F - var14;
               float var19 = 1.0F - var15;
               var17 = 1.0F - var17 * var17 * var17 * var17;
               var18 = 1.0F - var18 * var18 * var18 * var18;
               var19 = 1.0F - var19 * var19 * var19 * var19;
               var13 = var13 * (1.0F - var16) + var17 * var16;
               var14 = var14 * (1.0F - var16) + var18 * var16;
               var15 = var15 * (1.0F - var16) + var19 * var16;
               var13 = var13 * 0.96F + 0.03F;
               var14 = var14 * 0.96F + 0.03F;
               var15 = var15 * 0.96F + 0.03F;
               if(var13 > 1.0F) {
                  var13 = 1.0F;
               }

               if(var14 > 1.0F) {
                  var14 = 1.0F;
               }

               if(var15 > 1.0F) {
                  var15 = 1.0F;
               }

               if(var13 < 0.0F) {
                  var13 = 0.0F;
               }

               if(var14 < 0.0F) {
                  var14 = 0.0F;
               }

               if(var15 < 0.0F) {
                  var15 = 0.0F;
               }

               short var20 = 255;
               int var21 = (int)(var13 * 255.0F);
               int var22 = (int)(var14 * 255.0F);
               int var23 = (int)(var15 * 255.0F);
               this.field_78504_Q[var3] = var20 << 24 | var21 << 16 | var22 << 8 | var23;
            }

            this.field_78513_d.func_110564_a();
            this.field_78536_aa = false;
            this.field_78531_r.field_71424_I.func_76319_b();
         }
      }
   }

   private float func_180438_a(EntityLivingBase p_180438_1_, float p_180438_2_) {
      int var3 = p_180438_1_.func_70660_b(Potion.field_76439_r).func_76459_b();
      return var3 > 200?1.0F:0.7F + MathHelper.func_76126_a(((float)var3 - p_180438_2_) * 3.1415927F * 0.2F) * 0.3F;
   }

   public void func_78480_b(float p_78480_1_) {
      boolean var2 = Display.isActive();
      if(!var2 && this.field_78531_r.field_71474_y.field_82881_y && (!this.field_78531_r.field_71474_y.field_85185_A || !Mouse.isButtonDown(1))) {
         if(Minecraft.func_71386_F() - this.field_78508_Y > 500L) {
            this.field_78531_r.func_71385_j();
         }
      } else {
         this.field_78508_Y = Minecraft.func_71386_F();
      }

      this.field_78531_r.field_71424_I.func_76320_a("mouse");
      if(var2 && Minecraft.field_142025_a && this.field_78531_r.field_71415_G && !Mouse.isInsideWindow()) {
         Mouse.setGrabbed(false);
         Mouse.setCursorPosition(Display.getWidth() / 2, Display.getHeight() / 2);
         Mouse.setGrabbed(true);
      }

      if(this.field_78531_r.field_71415_G && var2) {
         this.field_78531_r.field_71417_B.func_74374_c();
         float var3 = this.field_78531_r.field_71474_y.field_74341_c * 0.6F + 0.2F;
         float var4 = var3 * var3 * var3 * 8.0F;
         float var5 = (float)this.field_78531_r.field_71417_B.field_74377_a * var4;
         float var6 = (float)this.field_78531_r.field_71417_B.field_74375_b * var4;
         byte var7 = 1;
         if(this.field_78531_r.field_71474_y.field_74338_d) {
            var7 = -1;
         }

         if(this.field_78531_r.field_71474_y.field_74326_T) {
            this.field_78496_H += var5;
            this.field_78497_I += var6;
            float var8 = p_78480_1_ - this.field_78492_L;
            this.field_78492_L = p_78480_1_;
            var5 = this.field_78498_J * var8;
            var6 = this.field_78499_K * var8;
            this.field_78531_r.field_71439_g.func_70082_c(var5, var6 * (float)var7);
         } else {
            this.field_78496_H = 0.0F;
            this.field_78497_I = 0.0F;
            this.field_78531_r.field_71439_g.func_70082_c(var5, var6 * (float)var7);
         }
      }

      this.field_78531_r.field_71424_I.func_76319_b();
      if(!this.field_78531_r.field_71454_w) {
         field_78517_a = this.field_78531_r.field_71474_y.field_74337_g;
         final ScaledResolution var13 = new ScaledResolution(this.field_78531_r, this.field_78531_r.field_71443_c, this.field_78531_r.field_71440_d);
         int var14 = var13.func_78326_a();
         int var15 = var13.func_78328_b();
         final int var16 = Mouse.getX() * var14 / this.field_78531_r.field_71443_c;
         final int var17 = var15 - Mouse.getY() * var15 / this.field_78531_r.field_71440_d - 1;
         int var18 = this.field_78531_r.field_71474_y.field_74350_i;
         if(this.field_78531_r.field_71441_e != null) {
            this.field_78531_r.field_71424_I.func_76320_a("level");
            int var9 = Math.max(Minecraft.func_175610_ah(), 30);
            this.func_78471_a(p_78480_1_, this.field_78510_Z + (long)(1000000000 / var9));
            if(OpenGlHelper.field_148824_g) {
               this.field_78531_r.field_71438_f.func_174975_c();
               if(this.field_147707_d != null && this.field_175083_ad) {
                  GlStateManager.func_179128_n(5890);
                  GlStateManager.func_179094_E();
                  GlStateManager.func_179096_D();
                  this.field_147707_d.func_148018_a(p_78480_1_);
                  GlStateManager.func_179121_F();
               }

               this.field_78531_r.func_147110_a().func_147610_a(true);
            }

            this.field_78510_Z = System.nanoTime();
            this.field_78531_r.field_71424_I.func_76318_c("gui");
            if(!this.field_78531_r.field_71474_y.field_74319_N || this.field_78531_r.field_71462_r != null) {
               GlStateManager.func_179092_a(516, 0.1F);
               this.field_78531_r.field_71456_v.func_175180_a(p_78480_1_);
            }

            this.field_78531_r.field_71424_I.func_76319_b();
         } else {
            GlStateManager.func_179083_b(0, 0, this.field_78531_r.field_71443_c, this.field_78531_r.field_71440_d);
            GlStateManager.func_179128_n(5889);
            GlStateManager.func_179096_D();
            GlStateManager.func_179128_n(5888);
            GlStateManager.func_179096_D();
            this.func_78478_c();
            this.field_78510_Z = System.nanoTime();
         }

         if(this.field_78531_r.field_71462_r != null) {
            GlStateManager.func_179086_m(256);

            try {
               this.field_78531_r.field_71462_r.func_73863_a(var16, var17, p_78480_1_);
            } catch (Throwable var12) {
               CrashReport var10 = CrashReport.func_85055_a(var12, "Rendering screen");
               CrashReportCategory var11 = var10.func_85058_a("Screen render details");
               var11.func_71500_a("Screen name", new Callable() {

                  private static final String __OBFID = "CL_00000948";

                  public String call() {
                     return EntityRenderer.this.field_78531_r.field_71462_r.getClass().getCanonicalName();
                  }
                  // $FF: synthetic method
                  public Object call() {
                     return this.call();
                  }
               });
               var11.func_71500_a("Mouse location", new Callable() {

                  private static final String __OBFID = "CL_00000950";

                  public String call() {
                     return String.format("Scaled: (%d, %d). Absolute: (%d, %d)", new Object[]{Integer.valueOf(var16), Integer.valueOf(var17), Integer.valueOf(Mouse.getX()), Integer.valueOf(Mouse.getY())});
                  }
                  // $FF: synthetic method
                  public Object call() {
                     return this.call();
                  }
               });
               var11.func_71500_a("Screen size", new Callable() {

                  private static final String __OBFID = "CL_00000951";

                  public String call() {
                     return String.format("Scaled: (%d, %d). Absolute: (%d, %d). Scale factor of %d", new Object[]{Integer.valueOf(var13.func_78326_a()), Integer.valueOf(var13.func_78328_b()), Integer.valueOf(EntityRenderer.this.field_78531_r.field_71443_c), Integer.valueOf(EntityRenderer.this.field_78531_r.field_71440_d), Integer.valueOf(var13.func_78325_e())});
                  }
                  // $FF: synthetic method
                  public Object call() {
                     return this.call();
                  }
               });
               throw new ReportedException(var10);
            }
         }

      }
   }

   public void func_152430_c(float p_152430_1_) {
      this.func_78478_c();
      this.field_78531_r.field_71456_v.func_180478_c(new ScaledResolution(this.field_78531_r, this.field_78531_r.field_71443_c, this.field_78531_r.field_71440_d));
   }

   private boolean func_175070_n() {
      if(!this.field_175073_D) {
         return false;
      } else {
         Entity var1 = this.field_78531_r.func_175606_aa();
         boolean var2 = var1 instanceof EntityPlayer && !this.field_78531_r.field_71474_y.field_74319_N;
         if(var2 && !((EntityPlayer)var1).field_71075_bZ.field_75099_e) {
            ItemStack var3 = ((EntityPlayer)var1).func_71045_bC();
            if(this.field_78531_r.field_71476_x != null && this.field_78531_r.field_71476_x.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
               BlockPos var4 = this.field_78531_r.field_71476_x.func_178782_a();
               Block var5 = this.field_78531_r.field_71441_e.func_180495_p(var4).func_177230_c();
               if(this.field_78531_r.field_71442_b.func_178889_l() == WorldSettings.GameType.SPECTATOR) {
                  var2 = var5.func_149716_u() && this.field_78531_r.field_71441_e.func_175625_s(var4) instanceof IInventory;
               } else {
                  var2 = var3 != null && (var3.func_179544_c(var5) || var3.func_179547_d(var5));
               }
            }
         }

         return var2;
      }
   }

   private void func_175067_i(float p_175067_1_) {
      if(this.field_78531_r.field_71474_y.field_74330_P && !this.field_78531_r.field_71474_y.field_74319_N && !this.field_78531_r.field_71439_g.func_175140_cp() && !this.field_78531_r.field_71474_y.field_178879_v) {
         Entity var2 = this.field_78531_r.func_175606_aa();
         GlStateManager.func_179147_l();
         GlStateManager.func_179120_a(770, 771, 1, 0);
         GL11.glLineWidth(1.0F);
         GlStateManager.func_179090_x();
         GlStateManager.func_179132_a(false);
         GlStateManager.func_179094_E();
         GlStateManager.func_179128_n(5888);
         GlStateManager.func_179096_D();
         this.func_78467_g(p_175067_1_);
         GlStateManager.func_179109_b(0.0F, var2.func_70047_e(), 0.0F);
         RenderGlobal.func_147590_a(new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.005D, 1.0E-4D, 1.0E-4D), -65536);
         RenderGlobal.func_147590_a(new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0E-4D, 1.0E-4D, 0.005D), -16776961);
         RenderGlobal.func_147590_a(new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0E-4D, 0.0033D, 1.0E-4D), -16711936);
         GlStateManager.func_179121_F();
         GlStateManager.func_179132_a(true);
         GlStateManager.func_179098_w();
         GlStateManager.func_179084_k();
      }

   }

   public void func_78471_a(float p_78471_1_, long p_78471_2_) {
      this.func_78472_g(p_78471_1_);
      if(this.field_78531_r.func_175606_aa() == null) {
         this.field_78531_r.func_175607_a(this.field_78531_r.field_71439_g);
      }

      this.func_78473_a(p_78471_1_);
      GlStateManager.func_179126_j();
      GlStateManager.func_179141_d();
      GlStateManager.func_179092_a(516, 0.5F);
      this.field_78531_r.field_71424_I.func_76320_a("center");
      if(this.field_78531_r.field_71474_y.field_74337_g) {
         field_78515_b = 0;
         GlStateManager.func_179135_a(false, true, true, false);
         this.func_175068_a(0, p_78471_1_, p_78471_2_);
         field_78515_b = 1;
         GlStateManager.func_179135_a(true, false, false, false);
         this.func_175068_a(1, p_78471_1_, p_78471_2_);
         GlStateManager.func_179135_a(true, true, true, false);
      } else {
         this.func_175068_a(2, p_78471_1_, p_78471_2_);
      }

      this.field_78531_r.field_71424_I.func_76319_b();
   }

   private void func_175068_a(int p_175068_1_, float p_175068_2_, long p_175068_3_) {
      RenderGlobal var5 = this.field_78531_r.field_71438_f;
      EffectRenderer var6 = this.field_78531_r.field_71452_i;
      boolean var7 = this.func_175070_n();
      GlStateManager.func_179089_o();
      this.field_78531_r.field_71424_I.func_76318_c("clear");
      GlStateManager.func_179083_b(0, 0, this.field_78531_r.field_71443_c, this.field_78531_r.field_71440_d);
      this.func_78466_h(p_175068_2_);
      GlStateManager.func_179086_m(16640);
      this.field_78531_r.field_71424_I.func_76318_c("camera");
      this.func_78479_a(p_175068_2_, p_175068_1_);
      ActiveRenderInfo.func_74583_a(this.field_78531_r.field_71439_g, this.field_78531_r.field_71474_y.field_74320_O == 2);
      this.field_78531_r.field_71424_I.func_76318_c("frustum");
      ClippingHelperImpl.func_78558_a();
      this.field_78531_r.field_71424_I.func_76318_c("culling");
      Frustrum var8 = new Frustrum();
      Entity var9 = this.field_78531_r.func_175606_aa();
      double var10 = var9.field_70142_S + (var9.field_70165_t - var9.field_70142_S) * (double)p_175068_2_;
      double var12 = var9.field_70137_T + (var9.field_70163_u - var9.field_70137_T) * (double)p_175068_2_;
      double var14 = var9.field_70136_U + (var9.field_70161_v - var9.field_70136_U) * (double)p_175068_2_;
      var8.func_78547_a(var10, var12, var14);
      if(this.field_78531_r.field_71474_y.field_151451_c >= 4) {
         this.func_78468_a(-1, p_175068_2_);
         this.field_78531_r.field_71424_I.func_76318_c("sky");
         GlStateManager.func_179128_n(5889);
         GlStateManager.func_179096_D();
         Project.gluPerspective(this.func_78481_a(p_175068_2_, true), (float)this.field_78531_r.field_71443_c / (float)this.field_78531_r.field_71440_d, 0.05F, this.field_78530_s * 2.0F);
         GlStateManager.func_179128_n(5888);
         var5.func_174976_a(p_175068_2_, p_175068_1_);
         GlStateManager.func_179128_n(5889);
         GlStateManager.func_179096_D();
         Project.gluPerspective(this.func_78481_a(p_175068_2_, true), (float)this.field_78531_r.field_71443_c / (float)this.field_78531_r.field_71440_d, 0.05F, this.field_78530_s * MathHelper.field_180189_a);
         GlStateManager.func_179128_n(5888);
      }

      this.func_78468_a(0, p_175068_2_);
      GlStateManager.func_179103_j(7425);
      if(var9.field_70163_u + (double)var9.func_70047_e() < 128.0D) {
         this.func_180437_a(var5, p_175068_2_, p_175068_1_);
      }

      this.field_78531_r.field_71424_I.func_76318_c("prepareterrain");
      this.func_78468_a(0, p_175068_2_);
      this.field_78531_r.func_110434_K().func_110577_a(TextureMap.field_110575_b);
      RenderHelper.func_74518_a();
      this.field_78531_r.field_71424_I.func_76318_c("terrain_setup");
      var5.func_174970_a(var9, (double)p_175068_2_, var8, this.field_175084_ae++, this.field_78531_r.field_71439_g.func_175149_v());
      if(p_175068_1_ == 0 || p_175068_1_ == 2) {
         this.field_78531_r.field_71424_I.func_76318_c("updatechunks");
         this.field_78531_r.field_71438_f.func_174967_a(p_175068_3_);
      }

      this.field_78531_r.field_71424_I.func_76318_c("terrain");
      GlStateManager.func_179128_n(5888);
      GlStateManager.func_179094_E();
      GlStateManager.func_179118_c();
      var5.func_174977_a(EnumWorldBlockLayer.SOLID, (double)p_175068_2_, p_175068_1_, var9);
      GlStateManager.func_179141_d();
      var5.func_174977_a(EnumWorldBlockLayer.CUTOUT_MIPPED, (double)p_175068_2_, p_175068_1_, var9);
      this.field_78531_r.func_110434_K().func_110581_b(TextureMap.field_110575_b).func_174936_b(false, false);
      var5.func_174977_a(EnumWorldBlockLayer.CUTOUT, (double)p_175068_2_, p_175068_1_, var9);
      this.field_78531_r.func_110434_K().func_110581_b(TextureMap.field_110575_b).func_174935_a();
      GlStateManager.func_179103_j(7424);
      GlStateManager.func_179092_a(516, 0.1F);
      EntityPlayer var16;
      if(!this.field_175078_W) {
         GlStateManager.func_179128_n(5888);
         GlStateManager.func_179121_F();
         GlStateManager.func_179094_E();
         RenderHelper.func_74519_b();
         this.field_78531_r.field_71424_I.func_76318_c("entities");
         var5.func_180446_a(var9, var8, p_175068_2_);
         RenderHelper.func_74518_a();
         this.func_175072_h();
         GlStateManager.func_179128_n(5888);
         GlStateManager.func_179121_F();
         GlStateManager.func_179094_E();
         if(this.field_78531_r.field_71476_x != null && var9.func_70055_a(Material.field_151586_h) && var7) {
            var16 = (EntityPlayer)var9;
            GlStateManager.func_179118_c();
            this.field_78531_r.field_71424_I.func_76318_c("outline");
            var5.func_72731_b(var16, this.field_78531_r.field_71476_x, 0, p_175068_2_);
            GlStateManager.func_179141_d();
         }
      }

      GlStateManager.func_179128_n(5888);
      GlStateManager.func_179121_F();
      if(var7 && this.field_78531_r.field_71476_x != null && !var9.func_70055_a(Material.field_151586_h)) {
         var16 = (EntityPlayer)var9;
         GlStateManager.func_179118_c();
         this.field_78531_r.field_71424_I.func_76318_c("outline");
         var5.func_72731_b(var16, this.field_78531_r.field_71476_x, 0, p_175068_2_);
         GlStateManager.func_179141_d();
      }

      this.field_78531_r.field_71424_I.func_76318_c("destroyProgress");
      GlStateManager.func_179147_l();
      GlStateManager.func_179120_a(770, 1, 1, 0);
      var5.func_174981_a(Tessellator.func_178181_a(), Tessellator.func_178181_a().func_178180_c(), var9, p_175068_2_);
      GlStateManager.func_179084_k();
      if(!this.field_175078_W) {
         this.func_180436_i();
         this.field_78531_r.field_71424_I.func_76318_c("litParticles");
         var6.func_78872_b(var9, p_175068_2_);
         RenderHelper.func_74518_a();
         this.func_78468_a(0, p_175068_2_);
         this.field_78531_r.field_71424_I.func_76318_c("particles");
         var6.func_78874_a(var9, p_175068_2_);
         this.func_175072_h();
      }

      GlStateManager.func_179132_a(false);
      GlStateManager.func_179089_o();
      this.field_78531_r.field_71424_I.func_76318_c("weather");
      this.func_78474_d(p_175068_2_);
      GlStateManager.func_179132_a(true);
      var5.func_180449_a(var9, p_175068_2_);
      GlStateManager.func_179084_k();
      GlStateManager.func_179089_o();
      GlStateManager.func_179120_a(770, 771, 1, 0);
      GlStateManager.func_179092_a(516, 0.1F);
      this.func_78468_a(0, p_175068_2_);
      GlStateManager.func_179147_l();
      GlStateManager.func_179132_a(false);
      this.field_78531_r.func_110434_K().func_110577_a(TextureMap.field_110575_b);
      GlStateManager.func_179103_j(7425);
      if(this.field_78531_r.field_71474_y.field_74347_j) {
         this.field_78531_r.field_71424_I.func_76318_c("translucent");
         GlStateManager.func_179147_l();
         GlStateManager.func_179120_a(770, 771, 1, 0);
         var5.func_174977_a(EnumWorldBlockLayer.TRANSLUCENT, (double)p_175068_2_, p_175068_1_, var9);
         GlStateManager.func_179084_k();
      } else {
         this.field_78531_r.field_71424_I.func_76318_c("translucent");
         var5.func_174977_a(EnumWorldBlockLayer.TRANSLUCENT, (double)p_175068_2_, p_175068_1_, var9);
      }

      GlStateManager.func_179103_j(7424);
      GlStateManager.func_179132_a(true);
      GlStateManager.func_179089_o();
      GlStateManager.func_179084_k();
      GlStateManager.func_179106_n();
      if(var9.field_70163_u + (double)var9.func_70047_e() >= 128.0D) {
         this.field_78531_r.field_71424_I.func_76318_c("aboveClouds");
         this.func_180437_a(var5, p_175068_2_, p_175068_1_);
      }

      this.field_78531_r.field_71424_I.func_76318_c("hand");
      if(this.field_175074_C) {
         GlStateManager.func_179086_m(256);
         this.func_78476_b(p_175068_2_, p_175068_1_);
         this.func_175067_i(p_175068_2_);
      }

   }

   private void func_180437_a(RenderGlobal p_180437_1_, float p_180437_2_, int p_180437_3_) {
      if(this.field_78531_r.field_71474_y.func_74309_c()) {
         this.field_78531_r.field_71424_I.func_76318_c("clouds");
         GlStateManager.func_179128_n(5889);
         GlStateManager.func_179096_D();
         Project.gluPerspective(this.func_78481_a(p_180437_2_, true), (float)this.field_78531_r.field_71443_c / (float)this.field_78531_r.field_71440_d, 0.05F, this.field_78530_s * 4.0F);
         GlStateManager.func_179128_n(5888);
         GlStateManager.func_179094_E();
         this.func_78468_a(0, p_180437_2_);
         p_180437_1_.func_180447_b(p_180437_2_, p_180437_3_);
         GlStateManager.func_179106_n();
         GlStateManager.func_179121_F();
         GlStateManager.func_179128_n(5889);
         GlStateManager.func_179096_D();
         Project.gluPerspective(this.func_78481_a(p_180437_2_, true), (float)this.field_78531_r.field_71443_c / (float)this.field_78531_r.field_71440_d, 0.05F, this.field_78530_s * MathHelper.field_180189_a);
         GlStateManager.func_179128_n(5888);
      }

   }

   private void func_78484_h() {
      float var1 = this.field_78531_r.field_71441_e.func_72867_j(1.0F);
      if(!this.field_78531_r.field_71474_y.field_74347_j) {
         var1 /= 2.0F;
      }

      if(var1 != 0.0F) {
         this.field_78537_ab.setSeed((long)this.field_78529_t * 312987231L);
         Entity var2 = this.field_78531_r.func_175606_aa();
         WorldClient var3 = this.field_78531_r.field_71441_e;
         BlockPos var4 = new BlockPos(var2);
         byte var5 = 10;
         double var6 = 0.0D;
         double var8 = 0.0D;
         double var10 = 0.0D;
         int var12 = 0;
         int var13 = (int)(100.0F * var1 * var1);
         if(this.field_78531_r.field_71474_y.field_74362_aa == 1) {
            var13 >>= 1;
         } else if(this.field_78531_r.field_71474_y.field_74362_aa == 2) {
            var13 = 0;
         }

         for(int var14 = 0; var14 < var13; ++var14) {
            BlockPos var15 = var3.func_175725_q(var4.func_177982_a(this.field_78537_ab.nextInt(var5) - this.field_78537_ab.nextInt(var5), 0, this.field_78537_ab.nextInt(var5) - this.field_78537_ab.nextInt(var5)));
            BiomeGenBase var16 = var3.func_180494_b(var15);
            BlockPos var17 = var15.func_177977_b();
            Block var18 = var3.func_180495_p(var17).func_177230_c();
            if(var15.func_177956_o() <= var4.func_177956_o() + var5 && var15.func_177956_o() >= var4.func_177956_o() - var5 && var16.func_76738_d() && var16.func_180626_a(var15) >= 0.15F) {
               float var19 = this.field_78537_ab.nextFloat();
               float var20 = this.field_78537_ab.nextFloat();
               if(var18.func_149688_o() == Material.field_151587_i) {
                  this.field_78531_r.field_71441_e.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, (double)((float)var15.func_177958_n() + var19), (double)((float)var15.func_177956_o() + 0.1F) - var18.func_149665_z(), (double)((float)var15.func_177952_p() + var20), 0.0D, 0.0D, 0.0D, new int[0]);
               } else if(var18.func_149688_o() != Material.field_151579_a) {
                  var18.func_180654_a(var3, var17);
                  ++var12;
                  if(this.field_78537_ab.nextInt(var12) == 0) {
                     var6 = (double)((float)var17.func_177958_n() + var19);
                     var8 = (double)((float)var17.func_177956_o() + 0.1F) + var18.func_149669_A() - 1.0D;
                     var10 = (double)((float)var17.func_177952_p() + var20);
                  }

                  this.field_78531_r.field_71441_e.func_175688_a(EnumParticleTypes.WATER_DROP, (double)((float)var17.func_177958_n() + var19), (double)((float)var17.func_177956_o() + 0.1F) + var18.func_149669_A(), (double)((float)var17.func_177952_p() + var20), 0.0D, 0.0D, 0.0D, new int[0]);
               }
            }
         }

         if(var12 > 0 && this.field_78537_ab.nextInt(3) < this.field_78534_ac++) {
            this.field_78534_ac = 0;
            if(var8 > (double)(var4.func_177956_o() + 1) && var3.func_175725_q(var4).func_177956_o() > MathHelper.func_76141_d((float)var4.func_177956_o())) {
               this.field_78531_r.field_71441_e.func_72980_b(var6, var8, var10, "ambient.weather.rain", 0.1F, 0.5F, false);
            } else {
               this.field_78531_r.field_71441_e.func_72980_b(var6, var8, var10, "ambient.weather.rain", 0.2F, 1.0F, false);
            }
         }

      }
   }

   protected void func_78474_d(float p_78474_1_) {
      float var2 = this.field_78531_r.field_71441_e.func_72867_j(p_78474_1_);
      if(var2 > 0.0F) {
         this.func_180436_i();
         Entity var3 = this.field_78531_r.func_175606_aa();
         WorldClient var4 = this.field_78531_r.field_71441_e;
         int var5 = MathHelper.func_76128_c(var3.field_70165_t);
         int var6 = MathHelper.func_76128_c(var3.field_70163_u);
         int var7 = MathHelper.func_76128_c(var3.field_70161_v);
         Tessellator var8 = Tessellator.func_178181_a();
         WorldRenderer var9 = var8.func_178180_c();
         GlStateManager.func_179129_p();
         GL11.glNormal3f(0.0F, 1.0F, 0.0F);
         GlStateManager.func_179147_l();
         GlStateManager.func_179120_a(770, 771, 1, 0);
         GlStateManager.func_179092_a(516, 0.1F);
         double var10 = var3.field_70142_S + (var3.field_70165_t - var3.field_70142_S) * (double)p_78474_1_;
         double var12 = var3.field_70137_T + (var3.field_70163_u - var3.field_70137_T) * (double)p_78474_1_;
         double var14 = var3.field_70136_U + (var3.field_70161_v - var3.field_70136_U) * (double)p_78474_1_;
         int var16 = MathHelper.func_76128_c(var12);
         byte var17 = 5;
         if(this.field_78531_r.field_71474_y.field_74347_j) {
            var17 = 10;
         }

         byte var18 = -1;
         float var19 = (float)this.field_78529_t + p_78474_1_;
         if(this.field_78531_r.field_71474_y.field_74347_j) {
            var17 = 10;
         }

         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);

         for(int var20 = var7 - var17; var20 <= var7 + var17; ++var20) {
            for(int var21 = var5 - var17; var21 <= var5 + var17; ++var21) {
               int var22 = (var20 - var7 + 16) * 32 + var21 - var5 + 16;
               float var23 = this.field_175076_N[var22] * 0.5F;
               float var24 = this.field_175077_O[var22] * 0.5F;
               BlockPos var25 = new BlockPos(var21, 0, var20);
               BiomeGenBase var26 = var4.func_180494_b(var25);
               if(var26.func_76738_d() || var26.func_76746_c()) {
                  int var27 = var4.func_175725_q(var25).func_177956_o();
                  int var28 = var6 - var17;
                  int var29 = var6 + var17;
                  if(var28 < var27) {
                     var28 = var27;
                  }

                  if(var29 < var27) {
                     var29 = var27;
                  }

                  float var30 = 1.0F;
                  int var31 = var27;
                  if(var27 < var16) {
                     var31 = var16;
                  }

                  if(var28 != var29) {
                     this.field_78537_ab.setSeed((long)(var21 * var21 * 3121 + var21 * 45238971 ^ var20 * var20 * 418711 + var20 * 13761));
                     float var32 = var26.func_180626_a(new BlockPos(var21, var28, var20));
                     float var33;
                     double var36;
                     if(var4.func_72959_q().func_76939_a(var32, var27) >= 0.15F) {
                        if(var18 != 0) {
                           if(var18 >= 0) {
                              var8.func_78381_a();
                           }

                           var18 = 0;
                           this.field_78531_r.func_110434_K().func_110577_a(field_110924_q);
                           var9.func_178970_b();
                        }

                        var33 = ((float)(this.field_78529_t + var21 * var21 * 3121 + var21 * 45238971 + var20 * var20 * 418711 + var20 * 13761 & 31) + p_78474_1_) / 32.0F * (3.0F + this.field_78537_ab.nextFloat());
                        double var34 = (double)((float)var21 + 0.5F) - var3.field_70165_t;
                        var36 = (double)((float)var20 + 0.5F) - var3.field_70161_v;
                        float var38 = MathHelper.func_76133_a(var34 * var34 + var36 * var36) / (float)var17;
                        float var39 = 1.0F;
                        var9.func_178963_b(var4.func_175626_b(new BlockPos(var21, var31, var20), 0));
                        var9.func_178960_a(var39, var39, var39, ((1.0F - var38 * var38) * 0.5F + 0.5F) * var2);
                        var9.func_178969_c(-var10 * 1.0D, -var12 * 1.0D, -var14 * 1.0D);
                        var9.func_178985_a((double)((float)var21 - var23) + 0.5D, (double)var28, (double)((float)var20 - var24) + 0.5D, (double)(0.0F * var30), (double)((float)var28 * var30 / 4.0F + var33 * var30));
                        var9.func_178985_a((double)((float)var21 + var23) + 0.5D, (double)var28, (double)((float)var20 + var24) + 0.5D, (double)(1.0F * var30), (double)((float)var28 * var30 / 4.0F + var33 * var30));
                        var9.func_178985_a((double)((float)var21 + var23) + 0.5D, (double)var29, (double)((float)var20 + var24) + 0.5D, (double)(1.0F * var30), (double)((float)var29 * var30 / 4.0F + var33 * var30));
                        var9.func_178985_a((double)((float)var21 - var23) + 0.5D, (double)var29, (double)((float)var20 - var24) + 0.5D, (double)(0.0F * var30), (double)((float)var29 * var30 / 4.0F + var33 * var30));
                        var9.func_178969_c(0.0D, 0.0D, 0.0D);
                     } else {
                        if(var18 != 1) {
                           if(var18 >= 0) {
                              var8.func_78381_a();
                           }

                           var18 = 1;
                           this.field_78531_r.func_110434_K().func_110577_a(field_110923_r);
                           var9.func_178970_b();
                        }

                        var33 = ((float)(this.field_78529_t & 511) + p_78474_1_) / 512.0F;
                        float var42 = this.field_78537_ab.nextFloat() + var19 * 0.01F * (float)this.field_78537_ab.nextGaussian();
                        float var35 = this.field_78537_ab.nextFloat() + var19 * (float)this.field_78537_ab.nextGaussian() * 0.001F;
                        var36 = (double)((float)var21 + 0.5F) - var3.field_70165_t;
                        double var43 = (double)((float)var20 + 0.5F) - var3.field_70161_v;
                        float var40 = MathHelper.func_76133_a(var36 * var36 + var43 * var43) / (float)var17;
                        float var41 = 1.0F;
                        var9.func_178963_b((var4.func_175626_b(new BlockPos(var21, var31, var20), 0) * 3 + 15728880) / 4);
                        var9.func_178960_a(var41, var41, var41, ((1.0F - var40 * var40) * 0.3F + 0.5F) * var2);
                        var9.func_178969_c(-var10 * 1.0D, -var12 * 1.0D, -var14 * 1.0D);
                        var9.func_178985_a((double)((float)var21 - var23) + 0.5D, (double)var28, (double)((float)var20 - var24) + 0.5D, (double)(0.0F * var30 + var42), (double)((float)var28 * var30 / 4.0F + var33 * var30 + var35));
                        var9.func_178985_a((double)((float)var21 + var23) + 0.5D, (double)var28, (double)((float)var20 + var24) + 0.5D, (double)(1.0F * var30 + var42), (double)((float)var28 * var30 / 4.0F + var33 * var30 + var35));
                        var9.func_178985_a((double)((float)var21 + var23) + 0.5D, (double)var29, (double)((float)var20 + var24) + 0.5D, (double)(1.0F * var30 + var42), (double)((float)var29 * var30 / 4.0F + var33 * var30 + var35));
                        var9.func_178985_a((double)((float)var21 - var23) + 0.5D, (double)var29, (double)((float)var20 - var24) + 0.5D, (double)(0.0F * var30 + var42), (double)((float)var29 * var30 / 4.0F + var33 * var30 + var35));
                        var9.func_178969_c(0.0D, 0.0D, 0.0D);
                     }
                  }
               }
            }
         }

         if(var18 >= 0) {
            var8.func_78381_a();
         }

         GlStateManager.func_179089_o();
         GlStateManager.func_179084_k();
         GlStateManager.func_179092_a(516, 0.1F);
         this.func_175072_h();
      }
   }

   public void func_78478_c() {
      ScaledResolution var1 = new ScaledResolution(this.field_78531_r, this.field_78531_r.field_71443_c, this.field_78531_r.field_71440_d);
      GlStateManager.func_179086_m(256);
      GlStateManager.func_179128_n(5889);
      GlStateManager.func_179096_D();
      GlStateManager.func_179130_a(0.0D, var1.func_78327_c(), var1.func_78324_d(), 0.0D, 1000.0D, 3000.0D);
      GlStateManager.func_179128_n(5888);
      GlStateManager.func_179096_D();
      GlStateManager.func_179109_b(0.0F, 0.0F, -2000.0F);
   }

   private void func_78466_h(float p_78466_1_) {
      WorldClient var2 = this.field_78531_r.field_71441_e;
      Entity var3 = this.field_78531_r.func_175606_aa();
      float var4 = 0.25F + 0.75F * (float)this.field_78531_r.field_71474_y.field_151451_c / 32.0F;
      var4 = 1.0F - (float)Math.pow((double)var4, 0.25D);
      Vec3 var5 = var2.func_72833_a(this.field_78531_r.func_175606_aa(), p_78466_1_);
      float var6 = (float)var5.field_72450_a;
      float var7 = (float)var5.field_72448_b;
      float var8 = (float)var5.field_72449_c;
      Vec3 var9 = var2.func_72948_g(p_78466_1_);
      this.field_175080_Q = (float)var9.field_72450_a;
      this.field_175082_R = (float)var9.field_72448_b;
      this.field_175081_S = (float)var9.field_72449_c;
      float var13;
      if(this.field_78531_r.field_71474_y.field_151451_c >= 4) {
         double var10 = -1.0D;
         Vec3 var12 = MathHelper.func_76126_a(var2.func_72929_e(p_78466_1_)) > 0.0F?new Vec3(var10, 0.0D, 0.0D):new Vec3(1.0D, 0.0D, 0.0D);
         var13 = (float)var3.func_70676_i(p_78466_1_).func_72430_b(var12);
         if(var13 < 0.0F) {
            var13 = 0.0F;
         }

         if(var13 > 0.0F) {
            float[] var14 = var2.field_73011_w.func_76560_a(var2.func_72826_c(p_78466_1_), p_78466_1_);
            if(var14 != null) {
               var13 *= var14[3];
               this.field_175080_Q = this.field_175080_Q * (1.0F - var13) + var14[0] * var13;
               this.field_175082_R = this.field_175082_R * (1.0F - var13) + var14[1] * var13;
               this.field_175081_S = this.field_175081_S * (1.0F - var13) + var14[2] * var13;
            }
         }
      }

      this.field_175080_Q += (var6 - this.field_175080_Q) * var4;
      this.field_175082_R += (var7 - this.field_175082_R) * var4;
      this.field_175081_S += (var8 - this.field_175081_S) * var4;
      float var19 = var2.func_72867_j(p_78466_1_);
      float var11;
      float var20;
      if(var19 > 0.0F) {
         var11 = 1.0F - var19 * 0.5F;
         var20 = 1.0F - var19 * 0.4F;
         this.field_175080_Q *= var11;
         this.field_175082_R *= var11;
         this.field_175081_S *= var20;
      }

      var11 = var2.func_72819_i(p_78466_1_);
      if(var11 > 0.0F) {
         var20 = 1.0F - var11 * 0.5F;
         this.field_175080_Q *= var20;
         this.field_175082_R *= var20;
         this.field_175081_S *= var20;
      }

      Block var21 = ActiveRenderInfo.func_180786_a(this.field_78531_r.field_71441_e, var3, p_78466_1_);
      if(this.field_78500_U) {
         Vec3 var22 = var2.func_72824_f(p_78466_1_);
         this.field_175080_Q = (float)var22.field_72450_a;
         this.field_175082_R = (float)var22.field_72448_b;
         this.field_175081_S = (float)var22.field_72449_c;
      } else if(var21.func_149688_o() == Material.field_151586_h) {
         var13 = (float)EnchantmentHelper.func_180319_a(var3) * 0.2F;
         if(var3 instanceof EntityLivingBase && ((EntityLivingBase)var3).func_70644_a(Potion.field_76427_o)) {
            var13 = var13 * 0.3F + 0.6F;
         }

         this.field_175080_Q = 0.02F + var13;
         this.field_175082_R = 0.02F + var13;
         this.field_175081_S = 0.2F + var13;
      } else if(var21.func_149688_o() == Material.field_151587_i) {
         this.field_175080_Q = 0.6F;
         this.field_175082_R = 0.1F;
         this.field_175081_S = 0.0F;
      }

      var13 = this.field_78535_ad + (this.field_78539_ae - this.field_78535_ad) * p_78466_1_;
      this.field_175080_Q *= var13;
      this.field_175082_R *= var13;
      this.field_175081_S *= var13;
      double var23 = (var3.field_70137_T + (var3.field_70163_u - var3.field_70137_T) * (double)p_78466_1_) * var2.field_73011_w.func_76565_k();
      if(var3 instanceof EntityLivingBase && ((EntityLivingBase)var3).func_70644_a(Potion.field_76440_q)) {
         int var16 = ((EntityLivingBase)var3).func_70660_b(Potion.field_76440_q).func_76459_b();
         if(var16 < 20) {
            var23 *= (double)(1.0F - (float)var16 / 20.0F);
         } else {
            var23 = 0.0D;
         }
      }

      if(var23 < 1.0D) {
         if(var23 < 0.0D) {
            var23 = 0.0D;
         }

         var23 *= var23;
         this.field_175080_Q = (float)((double)this.field_175080_Q * var23);
         this.field_175082_R = (float)((double)this.field_175082_R * var23);
         this.field_175081_S = (float)((double)this.field_175081_S * var23);
      }

      float var24;
      if(this.field_82831_U > 0.0F) {
         var24 = this.field_82832_V + (this.field_82831_U - this.field_82832_V) * p_78466_1_;
         this.field_175080_Q = this.field_175080_Q * (1.0F - var24) + this.field_175080_Q * 0.7F * var24;
         this.field_175082_R = this.field_175082_R * (1.0F - var24) + this.field_175082_R * 0.6F * var24;
         this.field_175081_S = this.field_175081_S * (1.0F - var24) + this.field_175081_S * 0.6F * var24;
      }

      float var17;
      if(var3 instanceof EntityLivingBase && ((EntityLivingBase)var3).func_70644_a(Potion.field_76439_r)) {
         var24 = this.func_180438_a((EntityLivingBase)var3, p_78466_1_);
         var17 = 1.0F / this.field_175080_Q;
         if(var17 > 1.0F / this.field_175082_R) {
            var17 = 1.0F / this.field_175082_R;
         }

         if(var17 > 1.0F / this.field_175081_S) {
            var17 = 1.0F / this.field_175081_S;
         }

         this.field_175080_Q = this.field_175080_Q * (1.0F - var24) + this.field_175080_Q * var17 * var24;
         this.field_175082_R = this.field_175082_R * (1.0F - var24) + this.field_175082_R * var17 * var24;
         this.field_175081_S = this.field_175081_S * (1.0F - var24) + this.field_175081_S * var17 * var24;
      }

      if(this.field_78531_r.field_71474_y.field_74337_g) {
         var24 = (this.field_175080_Q * 30.0F + this.field_175082_R * 59.0F + this.field_175081_S * 11.0F) / 100.0F;
         var17 = (this.field_175080_Q * 30.0F + this.field_175082_R * 70.0F) / 100.0F;
         float var18 = (this.field_175080_Q * 30.0F + this.field_175081_S * 70.0F) / 100.0F;
         this.field_175080_Q = var24;
         this.field_175082_R = var17;
         this.field_175081_S = var18;
      }

      GlStateManager.func_179082_a(this.field_175080_Q, this.field_175082_R, this.field_175081_S, 0.0F);
   }

   private void func_78468_a(int p_78468_1_, float p_78468_2_) {
      Entity var3 = this.field_78531_r.func_175606_aa();
      boolean var4 = false;
      if(var3 instanceof EntityPlayer) {
         var4 = ((EntityPlayer)var3).field_71075_bZ.field_75098_d;
      }

      GL11.glFog(2918, this.func_78469_a(this.field_175080_Q, this.field_175082_R, this.field_175081_S, 1.0F));
      GL11.glNormal3f(0.0F, -1.0F, 0.0F);
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      Block var5 = ActiveRenderInfo.func_180786_a(this.field_78531_r.field_71441_e, var3, p_78468_2_);
      float var6;
      if(var3 instanceof EntityLivingBase && ((EntityLivingBase)var3).func_70644_a(Potion.field_76440_q)) {
         var6 = 5.0F;
         int var7 = ((EntityLivingBase)var3).func_70660_b(Potion.field_76440_q).func_76459_b();
         if(var7 < 20) {
            var6 = 5.0F + (this.field_78530_s - 5.0F) * (1.0F - (float)var7 / 20.0F);
         }

         GlStateManager.func_179093_d(9729);
         if(p_78468_1_ == -1) {
            GlStateManager.func_179102_b(0.0F);
            GlStateManager.func_179153_c(var6 * 0.8F);
         } else {
            GlStateManager.func_179102_b(var6 * 0.25F);
            GlStateManager.func_179153_c(var6);
         }

         if(GLContext.getCapabilities().GL_NV_fog_distance) {
            GL11.glFogi('\u855a', '\u855b');
         }
      } else if(this.field_78500_U) {
         GlStateManager.func_179093_d(2048);
         GlStateManager.func_179095_a(0.1F);
      } else if(var5.func_149688_o() == Material.field_151586_h) {
         GlStateManager.func_179093_d(2048);
         if(var3 instanceof EntityLivingBase && ((EntityLivingBase)var3).func_70644_a(Potion.field_76427_o)) {
            GlStateManager.func_179095_a(0.01F);
         } else {
            GlStateManager.func_179095_a(0.1F - (float)EnchantmentHelper.func_180319_a(var3) * 0.03F);
         }
      } else if(var5.func_149688_o() == Material.field_151587_i) {
         GlStateManager.func_179093_d(2048);
         GlStateManager.func_179095_a(2.0F);
      } else {
         var6 = this.field_78530_s;
         GlStateManager.func_179093_d(9729);
         if(p_78468_1_ == -1) {
            GlStateManager.func_179102_b(0.0F);
            GlStateManager.func_179153_c(var6);
         } else {
            GlStateManager.func_179102_b(var6 * 0.75F);
            GlStateManager.func_179153_c(var6);
         }

         if(GLContext.getCapabilities().GL_NV_fog_distance) {
            GL11.glFogi('\u855a', '\u855b');
         }

         if(this.field_78531_r.field_71441_e.field_73011_w.func_76568_b((int)var3.field_70165_t, (int)var3.field_70161_v)) {
            GlStateManager.func_179102_b(var6 * 0.05F);
            GlStateManager.func_179153_c(Math.min(var6, 192.0F) * 0.5F);
         }
      }

      GlStateManager.func_179142_g();
      GlStateManager.func_179127_m();
      GlStateManager.func_179104_a(1028, 4608);
   }

   private FloatBuffer func_78469_a(float p_78469_1_, float p_78469_2_, float p_78469_3_, float p_78469_4_) {
      this.field_78521_m.clear();
      this.field_78521_m.put(p_78469_1_).put(p_78469_2_).put(p_78469_3_).put(p_78469_4_);
      this.field_78521_m.flip();
      return this.field_78521_m;
   }

   public MapItemRenderer func_147701_i() {
      return this.field_147709_v;
   }

}
