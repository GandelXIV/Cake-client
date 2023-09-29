package net.minecraft.client.renderer;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.vecmath.Matrix4f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockSign;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.ChunkRenderContainer;
import net.minecraft.client.renderer.DestroyBlockProgress;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderList;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VboRenderList;
import net.minecraft.client.renderer.ViewFrustum;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.client.renderer.chunk.CompiledChunk;
import net.minecraft.client.renderer.chunk.IRenderChunkFactory;
import net.minecraft.client.renderer.chunk.ListChunkFactory;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.client.renderer.chunk.VboChunkFactory;
import net.minecraft.client.renderer.chunk.VisGraph;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.culling.ClippingHelperImpl;
import net.minecraft.client.renderer.culling.Frustrum;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.shader.ShaderLinkHelper;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemRecord;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.IWorldAccess;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.chunk.Chunk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;

public class RenderGlobal implements IWorldAccess, IResourceManagerReloadListener {

   private static final Logger field_147599_m = LogManager.getLogger();
   private static final ResourceLocation field_110927_h = new ResourceLocation("textures/environment/moon_phases.png");
   private static final ResourceLocation field_110928_i = new ResourceLocation("textures/environment/sun.png");
   private static final ResourceLocation field_110925_j = new ResourceLocation("textures/environment/clouds.png");
   private static final ResourceLocation field_110926_k = new ResourceLocation("textures/environment/end_sky.png");
   private static final ResourceLocation field_175006_g = new ResourceLocation("textures/misc/forcefield.png");
   private final Minecraft field_72777_q;
   private final TextureManager field_72770_i;
   private final RenderManager field_175010_j;
   private WorldClient field_72769_h;
   private Set field_175009_l = Sets.newLinkedHashSet();
   private List field_72755_R = Lists.newArrayListWithCapacity(69696);
   private ViewFrustum field_175008_n;
   private int field_72772_v = -1;
   private int field_72771_w = -1;
   private int field_72781_x = -1;
   private VertexFormat field_175014_r;
   private VertexBuffer field_175013_s;
   private VertexBuffer field_175012_t;
   private VertexBuffer field_175011_u;
   private int field_72773_u;
   private final Map field_72738_E = Maps.newHashMap();
   private final Map field_147593_P = Maps.newHashMap();
   private final TextureAtlasSprite[] field_94141_F = new TextureAtlasSprite[10];
   private Framebuffer field_175015_z;
   private ShaderGroup field_174991_A;
   private double field_174992_B = Double.MIN_VALUE;
   private double field_174993_C = Double.MIN_VALUE;
   private double field_174987_D = Double.MIN_VALUE;
   private int field_174988_E = Integer.MIN_VALUE;
   private int field_174989_F = Integer.MIN_VALUE;
   private int field_174990_G = Integer.MIN_VALUE;
   private double field_174997_H = Double.MIN_VALUE;
   private double field_174998_I = Double.MIN_VALUE;
   private double field_174999_J = Double.MIN_VALUE;
   private double field_175000_K = Double.MIN_VALUE;
   private double field_174994_L = Double.MIN_VALUE;
   private final ChunkRenderDispatcher field_174995_M = new ChunkRenderDispatcher();
   private ChunkRenderContainer field_174996_N;
   private int field_72739_F = -1;
   private int field_72740_G = 2;
   private int field_72748_H;
   private int field_72749_I;
   private int field_72750_J;
   private boolean field_175002_T = false;
   private ClippingHelper field_175001_U;
   private final Vector4f[] field_175004_V = new Vector4f[8];
   private final Vector3d field_175003_W = new Vector3d();
   private boolean field_175005_X = false;
   IRenderChunkFactory field_175007_a;
   private double field_147596_f;
   private double field_147597_g;
   private double field_147602_h;
   private boolean field_147595_R = true;
   private static final String __OBFID = "CL_00000954";


   public RenderGlobal(Minecraft p_i1249_1_) {
      this.field_72777_q = p_i1249_1_;
      this.field_175010_j = p_i1249_1_.func_175598_ae();
      this.field_72770_i = p_i1249_1_.func_110434_K();
      this.field_72770_i.func_110577_a(field_175006_g);
      GL11.glTexParameteri(3553, 10242, 10497);
      GL11.glTexParameteri(3553, 10243, 10497);
      GlStateManager.func_179144_i(0);
      this.func_174971_n();
      this.field_175005_X = OpenGlHelper.func_176075_f();
      if(this.field_175005_X) {
         this.field_174996_N = new VboRenderList();
         this.field_175007_a = new VboChunkFactory();
      } else {
         this.field_174996_N = new RenderList();
         this.field_175007_a = new ListChunkFactory();
      }

      this.field_175014_r = new VertexFormat();
      this.field_175014_r.func_177349_a(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUseage.POSITION, 3));
      this.func_174963_q();
      this.func_174980_p();
      this.func_174964_o();
   }

   public void func_110549_a(IResourceManager p_110549_1_) {
      this.func_174971_n();
   }

   private void func_174971_n() {
      TextureMap var1 = this.field_72777_q.func_147117_R();

      for(int var2 = 0; var2 < this.field_94141_F.length; ++var2) {
         this.field_94141_F[var2] = var1.func_110572_b("minecraft:blocks/destroy_stage_" + var2);
      }

   }

   public void func_174966_b() {
      if(OpenGlHelper.field_148824_g) {
         if(ShaderLinkHelper.func_148074_b() == null) {
            ShaderLinkHelper.func_148076_a();
         }

         ResourceLocation var1 = new ResourceLocation("shaders/post/entity_outline.json");

         try {
            this.field_174991_A = new ShaderGroup(this.field_72777_q.func_110434_K(), this.field_72777_q.func_110442_L(), this.field_72777_q.func_147110_a(), var1);
            this.field_174991_A.func_148026_a(this.field_72777_q.field_71443_c, this.field_72777_q.field_71440_d);
            this.field_175015_z = this.field_174991_A.func_177066_a("final");
         } catch (IOException var3) {
            field_147599_m.warn("Failed to load shader: " + var1, var3);
            this.field_174991_A = null;
            this.field_175015_z = null;
         } catch (JsonSyntaxException var4) {
            field_147599_m.warn("Failed to load shader: " + var1, var4);
            this.field_174991_A = null;
            this.field_175015_z = null;
         }
      } else {
         this.field_174991_A = null;
         this.field_175015_z = null;
      }

   }

   public void func_174975_c() {
      if(this.func_174985_d()) {
         GlStateManager.func_179147_l();
         GlStateManager.func_179120_a(770, 771, 0, 1);
         this.field_175015_z.func_178038_a(this.field_72777_q.field_71443_c, this.field_72777_q.field_71440_d, false);
         GlStateManager.func_179084_k();
      }

   }

   protected boolean func_174985_d() {
      return this.field_175015_z != null && this.field_174991_A != null && this.field_72777_q.field_71439_g != null && this.field_72777_q.field_71439_g.func_175149_v() && this.field_72777_q.field_71474_y.field_178883_an.func_151470_d();
   }

   private void func_174964_o() {
      Tessellator var1 = Tessellator.func_178181_a();
      WorldRenderer var2 = var1.func_178180_c();
      if(this.field_175011_u != null) {
         this.field_175011_u.func_177362_c();
      }

      if(this.field_72781_x >= 0) {
         GLAllocation.func_74523_b(this.field_72781_x);
         this.field_72781_x = -1;
      }

      if(this.field_175005_X) {
         this.field_175011_u = new VertexBuffer(this.field_175014_r);
         this.func_174968_a(var2, -16.0F, true);
         var2.func_178977_d();
         var2.func_178965_a();
         this.field_175011_u.func_177360_a(var2.func_178966_f(), var2.func_178976_e());
      } else {
         this.field_72781_x = GLAllocation.func_74526_a(1);
         GL11.glNewList(this.field_72781_x, 4864);
         this.func_174968_a(var2, -16.0F, true);
         var1.func_78381_a();
         GL11.glEndList();
      }

   }

   private void func_174980_p() {
      Tessellator var1 = Tessellator.func_178181_a();
      WorldRenderer var2 = var1.func_178180_c();
      if(this.field_175012_t != null) {
         this.field_175012_t.func_177362_c();
      }

      if(this.field_72771_w >= 0) {
         GLAllocation.func_74523_b(this.field_72771_w);
         this.field_72771_w = -1;
      }

      if(this.field_175005_X) {
         this.field_175012_t = new VertexBuffer(this.field_175014_r);
         this.func_174968_a(var2, 16.0F, false);
         var2.func_178977_d();
         var2.func_178965_a();
         this.field_175012_t.func_177360_a(var2.func_178966_f(), var2.func_178976_e());
      } else {
         this.field_72771_w = GLAllocation.func_74526_a(1);
         GL11.glNewList(this.field_72771_w, 4864);
         this.func_174968_a(var2, 16.0F, false);
         var1.func_78381_a();
         GL11.glEndList();
      }

   }

   private void func_174968_a(WorldRenderer p_174968_1_, float p_174968_2_, boolean p_174968_3_) {
      boolean var4 = true;
      boolean var5 = true;
      p_174968_1_.func_178970_b();

      for(int var6 = -384; var6 <= 384; var6 += 64) {
         for(int var7 = -384; var7 <= 384; var7 += 64) {
            float var8 = (float)var6;
            float var9 = (float)(var6 + 64);
            if(p_174968_3_) {
               var9 = (float)var6;
               var8 = (float)(var6 + 64);
            }

            p_174968_1_.func_178984_b((double)var8, (double)p_174968_2_, (double)var7);
            p_174968_1_.func_178984_b((double)var9, (double)p_174968_2_, (double)var7);
            p_174968_1_.func_178984_b((double)var9, (double)p_174968_2_, (double)(var7 + 64));
            p_174968_1_.func_178984_b((double)var8, (double)p_174968_2_, (double)(var7 + 64));
         }
      }

   }

   private void func_174963_q() {
      Tessellator var1 = Tessellator.func_178181_a();
      WorldRenderer var2 = var1.func_178180_c();
      if(this.field_175013_s != null) {
         this.field_175013_s.func_177362_c();
      }

      if(this.field_72772_v >= 0) {
         GLAllocation.func_74523_b(this.field_72772_v);
         this.field_72772_v = -1;
      }

      if(this.field_175005_X) {
         this.field_175013_s = new VertexBuffer(this.field_175014_r);
         this.func_180444_a(var2);
         var2.func_178977_d();
         var2.func_178965_a();
         this.field_175013_s.func_177360_a(var2.func_178966_f(), var2.func_178976_e());
      } else {
         this.field_72772_v = GLAllocation.func_74526_a(1);
         GlStateManager.func_179094_E();
         GL11.glNewList(this.field_72772_v, 4864);
         this.func_180444_a(var2);
         var1.func_78381_a();
         GL11.glEndList();
         GlStateManager.func_179121_F();
      }

   }

   private void func_180444_a(WorldRenderer p_180444_1_) {
      Random var2 = new Random(10842L);
      p_180444_1_.func_178970_b();

      for(int var3 = 0; var3 < 1500; ++var3) {
         double var4 = (double)(var2.nextFloat() * 2.0F - 1.0F);
         double var6 = (double)(var2.nextFloat() * 2.0F - 1.0F);
         double var8 = (double)(var2.nextFloat() * 2.0F - 1.0F);
         double var10 = (double)(0.15F + var2.nextFloat() * 0.1F);
         double var12 = var4 * var4 + var6 * var6 + var8 * var8;
         if(var12 < 1.0D && var12 > 0.01D) {
            var12 = 1.0D / Math.sqrt(var12);
            var4 *= var12;
            var6 *= var12;
            var8 *= var12;
            double var14 = var4 * 100.0D;
            double var16 = var6 * 100.0D;
            double var18 = var8 * 100.0D;
            double var20 = Math.atan2(var4, var8);
            double var22 = Math.sin(var20);
            double var24 = Math.cos(var20);
            double var26 = Math.atan2(Math.sqrt(var4 * var4 + var8 * var8), var6);
            double var28 = Math.sin(var26);
            double var30 = Math.cos(var26);
            double var32 = var2.nextDouble() * 3.141592653589793D * 2.0D;
            double var34 = Math.sin(var32);
            double var36 = Math.cos(var32);

            for(int var38 = 0; var38 < 4; ++var38) {
               double var39 = 0.0D;
               double var41 = (double)((var38 & 2) - 1) * var10;
               double var43 = (double)((var38 + 1 & 2) - 1) * var10;
               double var45 = 0.0D;
               double var47 = var41 * var36 - var43 * var34;
               double var49 = var43 * var36 + var41 * var34;
               double var53 = var47 * var28 + 0.0D * var30;
               double var55 = 0.0D * var28 - var47 * var30;
               double var57 = var55 * var22 - var49 * var24;
               double var61 = var49 * var22 + var55 * var24;
               p_180444_1_.func_178984_b(var14 + var57, var16 + var53, var18 + var61);
            }
         }
      }

   }

   public void func_72732_a(WorldClient p_72732_1_) {
      if(this.field_72769_h != null) {
         this.field_72769_h.func_72848_b(this);
      }

      this.field_174992_B = Double.MIN_VALUE;
      this.field_174993_C = Double.MIN_VALUE;
      this.field_174987_D = Double.MIN_VALUE;
      this.field_174988_E = Integer.MIN_VALUE;
      this.field_174989_F = Integer.MIN_VALUE;
      this.field_174990_G = Integer.MIN_VALUE;
      this.field_175010_j.func_78717_a(p_72732_1_);
      this.field_72769_h = p_72732_1_;
      if(p_72732_1_ != null) {
         p_72732_1_.func_72954_a(this);
         this.func_72712_a();
      }

   }

   public void func_72712_a() {
      if(this.field_72769_h != null) {
         this.field_147595_R = true;
         Blocks.field_150362_t.func_150122_b(this.field_72777_q.field_71474_y.field_74347_j);
         Blocks.field_150361_u.func_150122_b(this.field_72777_q.field_71474_y.field_74347_j);
         this.field_72739_F = this.field_72777_q.field_71474_y.field_151451_c;
         boolean var1 = this.field_175005_X;
         this.field_175005_X = OpenGlHelper.func_176075_f();
         if(var1 && !this.field_175005_X) {
            this.field_174996_N = new RenderList();
            this.field_175007_a = new ListChunkFactory();
         } else if(!var1 && this.field_175005_X) {
            this.field_174996_N = new VboRenderList();
            this.field_175007_a = new VboChunkFactory();
         }

         if(var1 != this.field_175005_X) {
            this.func_174963_q();
            this.func_174980_p();
            this.func_174964_o();
         }

         if(this.field_175008_n != null) {
            this.field_175008_n.func_178160_a();
         }

         this.func_174986_e();
         this.field_175008_n = new ViewFrustum(this.field_72769_h, this.field_72777_q.field_71474_y.field_151451_c, this, this.field_175007_a);
         if(this.field_72769_h != null) {
            Entity var2 = this.field_72777_q.func_175606_aa();
            if(var2 != null) {
               this.field_175008_n.func_178163_a(var2.field_70165_t, var2.field_70161_v);
            }
         }

         this.field_72740_G = 2;
      }
   }

   protected void func_174986_e() {
      this.field_175009_l.clear();
      this.field_174995_M.func_178514_b();
   }

   public void func_72720_a(int p_72720_1_, int p_72720_2_) {
      if(OpenGlHelper.field_148824_g) {
         if(this.field_174991_A != null) {
            this.field_174991_A.func_148026_a(p_72720_1_, p_72720_2_);
         }

      }
   }

   public void func_180446_a(Entity p_180446_1_, ICamera p_180446_2_, float p_180446_3_) {
      if(this.field_72740_G > 0) {
         --this.field_72740_G;
      } else {
         double var4 = p_180446_1_.field_70169_q + (p_180446_1_.field_70165_t - p_180446_1_.field_70169_q) * (double)p_180446_3_;
         double var6 = p_180446_1_.field_70167_r + (p_180446_1_.field_70163_u - p_180446_1_.field_70167_r) * (double)p_180446_3_;
         double var8 = p_180446_1_.field_70166_s + (p_180446_1_.field_70161_v - p_180446_1_.field_70166_s) * (double)p_180446_3_;
         this.field_72769_h.field_72984_F.func_76320_a("prepare");
         TileEntityRendererDispatcher.field_147556_a.func_178470_a(this.field_72769_h, this.field_72777_q.func_110434_K(), this.field_72777_q.field_71466_p, this.field_72777_q.func_175606_aa(), p_180446_3_);
         this.field_175010_j.func_180597_a(this.field_72769_h, this.field_72777_q.field_71466_p, this.field_72777_q.func_175606_aa(), this.field_72777_q.field_147125_j, this.field_72777_q.field_71474_y, p_180446_3_);
         this.field_72748_H = 0;
         this.field_72749_I = 0;
         this.field_72750_J = 0;
         Entity var10 = this.field_72777_q.func_175606_aa();
         double var11 = var10.field_70142_S + (var10.field_70165_t - var10.field_70142_S) * (double)p_180446_3_;
         double var13 = var10.field_70137_T + (var10.field_70163_u - var10.field_70137_T) * (double)p_180446_3_;
         double var15 = var10.field_70136_U + (var10.field_70161_v - var10.field_70136_U) * (double)p_180446_3_;
         TileEntityRendererDispatcher.field_147554_b = var11;
         TileEntityRendererDispatcher.field_147555_c = var13;
         TileEntityRendererDispatcher.field_147552_d = var15;
         this.field_175010_j.func_178628_a(var11, var13, var15);
         this.field_72777_q.field_71460_t.func_180436_i();
         this.field_72769_h.field_72984_F.func_76318_c("global");
         List var17 = this.field_72769_h.func_72910_y();
         this.field_72748_H = var17.size();

         int var18;
         Entity var19;
         for(var18 = 0; var18 < this.field_72769_h.field_73007_j.size(); ++var18) {
            var19 = (Entity)this.field_72769_h.field_73007_j.get(var18);
            ++this.field_72749_I;
            if(var19.func_145770_h(var4, var6, var8)) {
               this.field_175010_j.func_147937_a(var19, p_180446_3_);
            }
         }

         if(this.func_174985_d()) {
            GlStateManager.func_179143_c(519);
            GlStateManager.func_179106_n();
            this.field_175015_z.func_147614_f();
            this.field_175015_z.func_147610_a(false);
            this.field_72769_h.field_72984_F.func_76318_c("entityOutlines");
            RenderHelper.func_74518_a();
            this.field_175010_j.func_178632_c(true);

            for(var18 = 0; var18 < var17.size(); ++var18) {
               var19 = (Entity)var17.get(var18);
               boolean var20 = this.field_72777_q.func_175606_aa() instanceof EntityLivingBase && ((EntityLivingBase)this.field_72777_q.func_175606_aa()).func_70608_bn();
               boolean var21 = var19.func_145770_h(var4, var6, var8) && (var19.field_70158_ak || p_180446_2_.func_78546_a(var19.func_174813_aQ()) || var19.field_70153_n == this.field_72777_q.field_71439_g) && var19 instanceof EntityPlayer;
               if((var19 != this.field_72777_q.func_175606_aa() || this.field_72777_q.field_71474_y.field_74320_O != 0 || var20) && var21) {
                  this.field_175010_j.func_147937_a(var19, p_180446_3_);
               }
            }

            this.field_175010_j.func_178632_c(false);
            RenderHelper.func_74519_b();
            GlStateManager.func_179132_a(false);
            this.field_174991_A.func_148018_a(p_180446_3_);
            GlStateManager.func_179132_a(true);
            this.field_72777_q.func_147110_a().func_147610_a(false);
            GlStateManager.func_179127_m();
            GlStateManager.func_179143_c(515);
            GlStateManager.func_179126_j();
            GlStateManager.func_179141_d();
         }

         this.field_72769_h.field_72984_F.func_76318_c("entities");
         Iterator var25 = this.field_72755_R.iterator();

         RenderGlobal.ContainerLocalRenderInformation var26;
         while(var25.hasNext()) {
            var26 = (RenderGlobal.ContainerLocalRenderInformation)var25.next();
            Chunk var28 = this.field_72769_h.func_175726_f(var26.field_178036_a.func_178568_j());
            Iterator var31 = var28.func_177429_s()[var26.field_178036_a.func_178568_j().func_177956_o() / 16].iterator();

            while(var31.hasNext()) {
               Entity var22 = (Entity)var31.next();
               boolean var23 = this.field_175010_j.func_178635_a(var22, p_180446_2_, var4, var6, var8) || var22.field_70153_n == this.field_72777_q.field_71439_g;
               if(var23) {
                  boolean var24 = this.field_72777_q.func_175606_aa() instanceof EntityLivingBase?((EntityLivingBase)this.field_72777_q.func_175606_aa()).func_70608_bn():false;
                  if(var22 == this.field_72777_q.func_175606_aa() && this.field_72777_q.field_71474_y.field_74320_O == 0 && !var24 || var22.field_70163_u >= 0.0D && var22.field_70163_u < 256.0D && !this.field_72769_h.func_175667_e(new BlockPos(var22))) {
                     continue;
                  }

                  ++this.field_72749_I;
                  this.field_175010_j.func_147937_a(var22, p_180446_3_);
               }

               if(!var23 && var22 instanceof EntityWitherSkull) {
                  this.field_72777_q.func_175598_ae().func_178630_b(var22, p_180446_3_);
               }
            }
         }

         this.field_72769_h.field_72984_F.func_76318_c("blockentities");
         RenderHelper.func_74519_b();
         var25 = this.field_72755_R.iterator();

         TileEntity var32;
         while(var25.hasNext()) {
            var26 = (RenderGlobal.ContainerLocalRenderInformation)var25.next();
            Iterator var29 = var26.field_178036_a.func_178571_g().func_178485_b().iterator();

            while(var29.hasNext()) {
               var32 = (TileEntity)var29.next();
               TileEntityRendererDispatcher.field_147556_a.func_180546_a(var32, p_180446_3_, -1);
            }
         }

         this.func_180443_s();
         var25 = this.field_72738_E.values().iterator();

         while(var25.hasNext()) {
            DestroyBlockProgress var27 = (DestroyBlockProgress)var25.next();
            BlockPos var30 = var27.func_180246_b();
            var32 = this.field_72769_h.func_175625_s(var30);
            if(var32 instanceof TileEntityChest) {
               TileEntityChest var33 = (TileEntityChest)var32;
               if(var33.field_145991_k != null) {
                  var30 = var30.func_177972_a(EnumFacing.WEST);
                  var32 = this.field_72769_h.func_175625_s(var30);
               } else if(var33.field_145992_i != null) {
                  var30 = var30.func_177972_a(EnumFacing.NORTH);
                  var32 = this.field_72769_h.func_175625_s(var30);
               }
            }

            Block var34 = this.field_72769_h.func_180495_p(var30).func_177230_c();
            if(var32 != null && (var34 instanceof BlockChest || var34 instanceof BlockEnderChest || var34 instanceof BlockSign || var34 instanceof BlockSkull)) {
               TileEntityRendererDispatcher.field_147556_a.func_180546_a(var32, p_180446_3_, var27.func_73106_e());
            }
         }

         this.func_174969_t();
         this.field_72777_q.field_71460_t.func_175072_h();
         this.field_72777_q.field_71424_I.func_76319_b();
      }
   }

   public String func_72735_c() {
      int var1 = this.field_175008_n.field_178164_f.length;
      int var2 = 0;
      Iterator var3 = this.field_72755_R.iterator();

      while(var3.hasNext()) {
         RenderGlobal.ContainerLocalRenderInformation var4 = (RenderGlobal.ContainerLocalRenderInformation)var3.next();
         CompiledChunk var5 = var4.field_178036_a.field_178590_b;
         if(var5 != CompiledChunk.field_178502_a && !var5.func_178489_a()) {
            ++var2;
         }
      }

      return String.format("C: %d/%d %sD: %d, %s", new Object[]{Integer.valueOf(var2), Integer.valueOf(var1), this.field_72777_q.field_175612_E?"(s) ":"", Integer.valueOf(this.field_72739_F), this.field_174995_M.func_178504_a()});
   }

   public String func_72723_d() {
      return "E: " + this.field_72749_I + "/" + this.field_72748_H + ", B: " + this.field_72750_J + ", I: " + (this.field_72748_H - this.field_72750_J - this.field_72749_I);
   }

   public void func_174970_a(Entity p_174970_1_, double p_174970_2_, ICamera p_174970_4_, int p_174970_5_, boolean p_174970_6_) {
      if(this.field_72777_q.field_71474_y.field_151451_c != this.field_72739_F) {
         this.func_72712_a();
      }

      this.field_72769_h.field_72984_F.func_76320_a("camera");
      double var7 = p_174970_1_.field_70165_t - this.field_174992_B;
      double var9 = p_174970_1_.field_70163_u - this.field_174993_C;
      double var11 = p_174970_1_.field_70161_v - this.field_174987_D;
      if(this.field_174988_E != p_174970_1_.field_70176_ah || this.field_174989_F != p_174970_1_.field_70162_ai || this.field_174990_G != p_174970_1_.field_70164_aj || var7 * var7 + var9 * var9 + var11 * var11 > 16.0D) {
         this.field_174992_B = p_174970_1_.field_70165_t;
         this.field_174993_C = p_174970_1_.field_70163_u;
         this.field_174987_D = p_174970_1_.field_70161_v;
         this.field_174988_E = p_174970_1_.field_70176_ah;
         this.field_174989_F = p_174970_1_.field_70162_ai;
         this.field_174990_G = p_174970_1_.field_70164_aj;
         this.field_175008_n.func_178163_a(p_174970_1_.field_70165_t, p_174970_1_.field_70161_v);
      }

      this.field_72769_h.field_72984_F.func_76318_c("renderlistcamera");
      double var13 = p_174970_1_.field_70142_S + (p_174970_1_.field_70165_t - p_174970_1_.field_70142_S) * p_174970_2_;
      double var15 = p_174970_1_.field_70137_T + (p_174970_1_.field_70163_u - p_174970_1_.field_70137_T) * p_174970_2_;
      double var17 = p_174970_1_.field_70136_U + (p_174970_1_.field_70161_v - p_174970_1_.field_70136_U) * p_174970_2_;
      this.field_174996_N.func_178004_a(var13, var15, var17);
      this.field_72769_h.field_72984_F.func_76318_c("cull");
      if(this.field_175001_U != null) {
         Frustrum var19 = new Frustrum(this.field_175001_U);
         var19.func_78547_a(this.field_175003_W.x, this.field_175003_W.y, this.field_175003_W.z);
         p_174970_4_ = var19;
      }

      this.field_72777_q.field_71424_I.func_76318_c("culling");
      BlockPos var35 = new BlockPos(var13, var15 + (double)p_174970_1_.func_70047_e(), var17);
      RenderChunk var20 = this.field_175008_n.func_178161_a(var35);
      BlockPos var21 = new BlockPos(MathHelper.func_76128_c(var13) / 16 * 16, MathHelper.func_76128_c(var15) / 16 * 16, MathHelper.func_76128_c(var17) / 16 * 16);
      this.field_147595_R = this.field_147595_R || !this.field_175009_l.isEmpty() || p_174970_1_.field_70165_t != this.field_174997_H || p_174970_1_.field_70163_u != this.field_174998_I || p_174970_1_.field_70161_v != this.field_174999_J || (double)p_174970_1_.field_70125_A != this.field_175000_K || (double)p_174970_1_.field_70177_z != this.field_174994_L;
      this.field_174997_H = p_174970_1_.field_70165_t;
      this.field_174998_I = p_174970_1_.field_70163_u;
      this.field_174999_J = p_174970_1_.field_70161_v;
      this.field_175000_K = (double)p_174970_1_.field_70125_A;
      this.field_174994_L = (double)p_174970_1_.field_70177_z;
      boolean var22 = this.field_175001_U != null;
      RenderGlobal.ContainerLocalRenderInformation var39;
      RenderChunk var41;
      if(!var22 && this.field_147595_R) {
         this.field_147595_R = false;
         this.field_72755_R = Lists.newArrayList();
         LinkedList var23 = Lists.newLinkedList();
         boolean var24 = this.field_72777_q.field_175612_E;
         if(var20 == null) {
            int var25 = var35.func_177956_o() > 0?248:8;

            for(int var26 = -this.field_72739_F; var26 <= this.field_72739_F; ++var26) {
               for(int var27 = -this.field_72739_F; var27 <= this.field_72739_F; ++var27) {
                  RenderChunk var28 = this.field_175008_n.func_178161_a(new BlockPos((var26 << 4) + 8, var25, (var27 << 4) + 8));
                  if(var28 != null && ((ICamera)p_174970_4_).func_78546_a(var28.field_178591_c)) {
                     var28.func_178577_a(p_174970_5_);
                     var23.add(new RenderGlobal.ContainerLocalRenderInformation(var28, (EnumFacing)null, 0, null));
                  }
               }
            }
         } else {
            boolean var38 = false;
            RenderGlobal.ContainerLocalRenderInformation var40 = new RenderGlobal.ContainerLocalRenderInformation(var20, (EnumFacing)null, 0, null);
            Set var42 = this.func_174978_c(var35);
            if(!var42.isEmpty() && var42.size() == 1) {
               Vector3f var44 = this.func_174962_a(p_174970_1_, p_174970_2_);
               EnumFacing var29 = EnumFacing.func_176737_a(var44.x, var44.y, var44.z).func_176734_d();
               var42.remove(var29);
            }

            if(var42.isEmpty()) {
               var38 = true;
            }

            if(var38 && !p_174970_6_) {
               this.field_72755_R.add(var40);
            } else {
               if(p_174970_6_ && this.field_72769_h.func_180495_p(var35).func_177230_c().func_149662_c()) {
                  var24 = false;
               }

               var20.func_178577_a(p_174970_5_);
               var23.add(var40);
            }
         }

         while(!var23.isEmpty()) {
            var39 = (RenderGlobal.ContainerLocalRenderInformation)var23.poll();
            var41 = var39.field_178036_a;
            EnumFacing var43 = var39.field_178034_b;
            BlockPos var45 = var41.func_178568_j();
            this.field_72755_R.add(var39);
            EnumFacing[] var46 = EnumFacing.values();
            int var30 = var46.length;

            for(int var31 = 0; var31 < var30; ++var31) {
               EnumFacing var32 = var46[var31];
               RenderChunk var33 = this.func_174973_a(var35, var45, var32);
               if((!var24 || !var39.field_178035_c.contains(var32.func_176734_d())) && (!var24 || var43 == null || var41.func_178571_g().func_178495_a(var43.func_176734_d(), var32)) && var33 != null && var33.func_178577_a(p_174970_5_) && ((ICamera)p_174970_4_).func_78546_a(var33.field_178591_c)) {
                  RenderGlobal.ContainerLocalRenderInformation var34 = new RenderGlobal.ContainerLocalRenderInformation(var33, var32, var39.field_178032_d + 1, null);
                  var34.field_178035_c.addAll(var39.field_178035_c);
                  var34.field_178035_c.add(var32);
                  var23.add(var34);
               }
            }
         }
      }

      if(this.field_175002_T) {
         this.func_174984_a(var13, var15, var17);
         this.field_175002_T = false;
      }

      this.field_174995_M.func_178513_e();
      Set var36 = this.field_175009_l;
      this.field_175009_l = Sets.newLinkedHashSet();
      Iterator var37 = this.field_72755_R.iterator();

      while(var37.hasNext()) {
         var39 = (RenderGlobal.ContainerLocalRenderInformation)var37.next();
         var41 = var39.field_178036_a;
         if(var41.func_178569_m() || var41.func_178583_l() || var36.contains(var41)) {
            this.field_147595_R = true;
            if(this.func_174983_a(var21, var39.field_178036_a)) {
               this.field_72777_q.field_71424_I.func_76320_a("build near");
               this.field_174995_M.func_178505_b(var41);
               var41.func_178575_a(false);
               this.field_72777_q.field_71424_I.func_76319_b();
            } else {
               this.field_175009_l.add(var41);
            }
         }
      }

      this.field_175009_l.addAll(var36);
      this.field_72777_q.field_71424_I.func_76319_b();
   }

   private boolean func_174983_a(BlockPos p_174983_1_, RenderChunk p_174983_2_) {
      BlockPos var3 = p_174983_2_.func_178568_j();
      return MathHelper.func_76130_a(p_174983_1_.func_177958_n() - var3.func_177958_n()) > 16?false:(MathHelper.func_76130_a(p_174983_1_.func_177956_o() - var3.func_177956_o()) > 16?false:MathHelper.func_76130_a(p_174983_1_.func_177952_p() - var3.func_177952_p()) <= 16);
   }

   private Set func_174978_c(BlockPos p_174978_1_) {
      VisGraph var2 = new VisGraph();
      BlockPos var3 = new BlockPos(p_174978_1_.func_177958_n() >> 4 << 4, p_174978_1_.func_177956_o() >> 4 << 4, p_174978_1_.func_177952_p() >> 4 << 4);
      Chunk var4 = this.field_72769_h.func_175726_f(var3);
      Iterator var5 = BlockPos.func_177975_b(var3, var3.func_177982_a(15, 15, 15)).iterator();

      while(var5.hasNext()) {
         BlockPos.MutableBlockPos var6 = (BlockPos.MutableBlockPos)var5.next();
         if(var4.func_177428_a(var6).func_149662_c()) {
            var2.func_178606_a(var6);
         }
      }

      return var2.func_178609_b(p_174978_1_);
   }

   private RenderChunk func_174973_a(BlockPos p_174973_1_, BlockPos p_174973_2_, EnumFacing p_174973_3_) {
      BlockPos var4 = p_174973_2_.func_177967_a(p_174973_3_, 16);
      return MathHelper.func_76130_a(p_174973_1_.func_177958_n() - var4.func_177958_n()) > this.field_72739_F * 16?null:(var4.func_177956_o() >= 0 && var4.func_177956_o() < 256?(MathHelper.func_76130_a(p_174973_1_.func_177952_p() - var4.func_177952_p()) > this.field_72739_F * 16?null:this.field_175008_n.func_178161_a(var4)):null);
   }

   private void func_174984_a(double p_174984_1_, double p_174984_3_, double p_174984_5_) {
      this.field_175001_U = new ClippingHelperImpl();
      ((ClippingHelperImpl)this.field_175001_U).func_78560_b();
      Matrix4f var7 = new Matrix4f(this.field_175001_U.field_178626_c);
      var7.transpose();
      Matrix4f var8 = new Matrix4f(this.field_175001_U.field_178625_b);
      var8.transpose();
      Matrix4f var9 = new Matrix4f();
      var9.mul(var8, var7);
      var9.invert();
      this.field_175003_W.x = p_174984_1_;
      this.field_175003_W.y = p_174984_3_;
      this.field_175003_W.z = p_174984_5_;
      this.field_175004_V[0] = new Vector4f(-1.0F, -1.0F, -1.0F, 1.0F);
      this.field_175004_V[1] = new Vector4f(1.0F, -1.0F, -1.0F, 1.0F);
      this.field_175004_V[2] = new Vector4f(1.0F, 1.0F, -1.0F, 1.0F);
      this.field_175004_V[3] = new Vector4f(-1.0F, 1.0F, -1.0F, 1.0F);
      this.field_175004_V[4] = new Vector4f(-1.0F, -1.0F, 1.0F, 1.0F);
      this.field_175004_V[5] = new Vector4f(1.0F, -1.0F, 1.0F, 1.0F);
      this.field_175004_V[6] = new Vector4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_175004_V[7] = new Vector4f(-1.0F, 1.0F, 1.0F, 1.0F);

      for(int var10 = 0; var10 < 8; ++var10) {
         var9.transform(this.field_175004_V[var10]);
         this.field_175004_V[var10].x /= this.field_175004_V[var10].w;
         this.field_175004_V[var10].y /= this.field_175004_V[var10].w;
         this.field_175004_V[var10].z /= this.field_175004_V[var10].w;
         this.field_175004_V[var10].w = 1.0F;
      }

   }

   protected Vector3f func_174962_a(Entity p_174962_1_, double p_174962_2_) {
      float var4 = (float)((double)p_174962_1_.field_70127_C + (double)(p_174962_1_.field_70125_A - p_174962_1_.field_70127_C) * p_174962_2_);
      float var5 = (float)((double)p_174962_1_.field_70126_B + (double)(p_174962_1_.field_70177_z - p_174962_1_.field_70126_B) * p_174962_2_);
      if(Minecraft.func_71410_x().field_71474_y.field_74320_O == 2) {
         var4 += 180.0F;
      }

      float var6 = MathHelper.func_76134_b(-var5 * 0.017453292F - 3.1415927F);
      float var7 = MathHelper.func_76126_a(-var5 * 0.017453292F - 3.1415927F);
      float var8 = -MathHelper.func_76134_b(-var4 * 0.017453292F);
      float var9 = MathHelper.func_76126_a(-var4 * 0.017453292F);
      return new Vector3f(var7 * var8, var9, var6 * var8);
   }

   public int func_174977_a(EnumWorldBlockLayer p_174977_1_, double p_174977_2_, int p_174977_4_, Entity p_174977_5_) {
      RenderHelper.func_74518_a();
      if(p_174977_1_ == EnumWorldBlockLayer.TRANSLUCENT) {
         this.field_72777_q.field_71424_I.func_76320_a("translucent_sort");
         double var6 = p_174977_5_.field_70165_t - this.field_147596_f;
         double var8 = p_174977_5_.field_70163_u - this.field_147597_g;
         double var10 = p_174977_5_.field_70161_v - this.field_147602_h;
         if(var6 * var6 + var8 * var8 + var10 * var10 > 1.0D) {
            this.field_147596_f = p_174977_5_.field_70165_t;
            this.field_147597_g = p_174977_5_.field_70163_u;
            this.field_147602_h = p_174977_5_.field_70161_v;
            int var12 = 0;
            Iterator var13 = this.field_72755_R.iterator();

            while(var13.hasNext()) {
               RenderGlobal.ContainerLocalRenderInformation var14 = (RenderGlobal.ContainerLocalRenderInformation)var13.next();
               if(var14.field_178036_a.field_178590_b.func_178492_d(p_174977_1_) && var12++ < 15) {
                  this.field_174995_M.func_178509_c(var14.field_178036_a);
               }
            }
         }

         this.field_72777_q.field_71424_I.func_76319_b();
      }

      this.field_72777_q.field_71424_I.func_76320_a("filterempty");
      int var15 = 0;
      boolean var7 = p_174977_1_ == EnumWorldBlockLayer.TRANSLUCENT;
      int var16 = var7?this.field_72755_R.size() - 1:0;
      int var9 = var7?-1:this.field_72755_R.size();
      int var17 = var7?-1:1;

      for(int var11 = var16; var11 != var9; var11 += var17) {
         RenderChunk var18 = ((RenderGlobal.ContainerLocalRenderInformation)this.field_72755_R.get(var11)).field_178036_a;
         if(!var18.func_178571_g().func_178491_b(p_174977_1_)) {
            ++var15;
            this.field_174996_N.func_178002_a(var18, p_174977_1_);
         }
      }

      this.field_72777_q.field_71424_I.func_76318_c("render_" + p_174977_1_);
      this.func_174982_a(p_174977_1_);
      this.field_72777_q.field_71424_I.func_76319_b();
      return var15;
   }

   private void func_174982_a(EnumWorldBlockLayer p_174982_1_) {
      this.field_72777_q.field_71460_t.func_180436_i();
      if(OpenGlHelper.func_176075_f()) {
         GL11.glEnableClientState('\u8074');
         OpenGlHelper.func_77472_b(OpenGlHelper.field_77478_a);
         GL11.glEnableClientState('\u8078');
         OpenGlHelper.func_77472_b(OpenGlHelper.field_77476_b);
         GL11.glEnableClientState('\u8078');
         OpenGlHelper.func_77472_b(OpenGlHelper.field_77478_a);
         GL11.glEnableClientState('\u8076');
      }

      this.field_174996_N.func_178001_a(p_174982_1_);
      if(OpenGlHelper.func_176075_f()) {
         List var2 = DefaultVertexFormats.field_176600_a.func_177343_g();
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            VertexFormatElement var4 = (VertexFormatElement)var3.next();
            VertexFormatElement.EnumUseage var5 = var4.func_177375_c();
            int var6 = var4.func_177369_e();
            switch(RenderGlobal.SwitchEnumUseage.field_178037_a[var5.ordinal()]) {
            case 1:
               GL11.glDisableClientState('\u8074');
               break;
            case 2:
               OpenGlHelper.func_77472_b(OpenGlHelper.field_77478_a + var6);
               GL11.glDisableClientState('\u8078');
               OpenGlHelper.func_77472_b(OpenGlHelper.field_77478_a);
               break;
            case 3:
               GL11.glDisableClientState('\u8076');
               GlStateManager.func_179117_G();
            }
         }
      }

      this.field_72777_q.field_71460_t.func_175072_h();
   }

   private void func_174965_a(Iterator p_174965_1_) {
      while(p_174965_1_.hasNext()) {
         DestroyBlockProgress var2 = (DestroyBlockProgress)p_174965_1_.next();
         int var3 = var2.func_82743_f();
         if(this.field_72773_u - var3 > 400) {
            p_174965_1_.remove();
         }
      }

   }

   public void func_72734_e() {
      ++this.field_72773_u;
      if(this.field_72773_u % 20 == 0) {
         this.func_174965_a(this.field_72738_E.values().iterator());
      }

   }

   private void func_180448_r() {
      GlStateManager.func_179106_n();
      GlStateManager.func_179118_c();
      GlStateManager.func_179147_l();
      GlStateManager.func_179120_a(770, 771, 1, 0);
      RenderHelper.func_74518_a();
      GlStateManager.func_179132_a(false);
      this.field_72770_i.func_110577_a(field_110926_k);
      Tessellator var1 = Tessellator.func_178181_a();
      WorldRenderer var2 = var1.func_178180_c();

      for(int var3 = 0; var3 < 6; ++var3) {
         GlStateManager.func_179094_E();
         if(var3 == 1) {
            GlStateManager.func_179114_b(90.0F, 1.0F, 0.0F, 0.0F);
         }

         if(var3 == 2) {
            GlStateManager.func_179114_b(-90.0F, 1.0F, 0.0F, 0.0F);
         }

         if(var3 == 3) {
            GlStateManager.func_179114_b(180.0F, 1.0F, 0.0F, 0.0F);
         }

         if(var3 == 4) {
            GlStateManager.func_179114_b(90.0F, 0.0F, 0.0F, 1.0F);
         }

         if(var3 == 5) {
            GlStateManager.func_179114_b(-90.0F, 0.0F, 0.0F, 1.0F);
         }

         var2.func_178970_b();
         var2.func_178991_c(2631720);
         var2.func_178985_a(-100.0D, -100.0D, -100.0D, 0.0D, 0.0D);
         var2.func_178985_a(-100.0D, -100.0D, 100.0D, 0.0D, 16.0D);
         var2.func_178985_a(100.0D, -100.0D, 100.0D, 16.0D, 16.0D);
         var2.func_178985_a(100.0D, -100.0D, -100.0D, 16.0D, 0.0D);
         var1.func_78381_a();
         GlStateManager.func_179121_F();
      }

      GlStateManager.func_179132_a(true);
      GlStateManager.func_179098_w();
      GlStateManager.func_179141_d();
   }

   public void func_174976_a(float p_174976_1_, int p_174976_2_) {
      if(this.field_72777_q.field_71441_e.field_73011_w.func_177502_q() == 1) {
         this.func_180448_r();
      } else if(this.field_72777_q.field_71441_e.field_73011_w.func_76569_d()) {
         GlStateManager.func_179090_x();
         Vec3 var3 = this.field_72769_h.func_72833_a(this.field_72777_q.func_175606_aa(), p_174976_1_);
         float var4 = (float)var3.field_72450_a;
         float var5 = (float)var3.field_72448_b;
         float var6 = (float)var3.field_72449_c;
         if(p_174976_2_ != 2) {
            float var7 = (var4 * 30.0F + var5 * 59.0F + var6 * 11.0F) / 100.0F;
            float var8 = (var4 * 30.0F + var5 * 70.0F) / 100.0F;
            float var9 = (var4 * 30.0F + var6 * 70.0F) / 100.0F;
            var4 = var7;
            var5 = var8;
            var6 = var9;
         }

         GlStateManager.func_179124_c(var4, var5, var6);
         Tessellator var23 = Tessellator.func_178181_a();
         WorldRenderer var24 = var23.func_178180_c();
         GlStateManager.func_179132_a(false);
         GlStateManager.func_179127_m();
         GlStateManager.func_179124_c(var4, var5, var6);
         if(this.field_175005_X) {
            this.field_175012_t.func_177359_a();
            GL11.glEnableClientState('\u8074');
            GL11.glVertexPointer(3, 5126, 12, 0L);
            this.field_175012_t.func_177358_a(7);
            this.field_175012_t.func_177361_b();
            GL11.glDisableClientState('\u8074');
         } else {
            GlStateManager.func_179148_o(this.field_72771_w);
         }

         GlStateManager.func_179106_n();
         GlStateManager.func_179118_c();
         GlStateManager.func_179147_l();
         GlStateManager.func_179120_a(770, 771, 1, 0);
         RenderHelper.func_74518_a();
         float[] var25 = this.field_72769_h.field_73011_w.func_76560_a(this.field_72769_h.func_72826_c(p_174976_1_), p_174976_1_);
         float var10;
         float var11;
         float var12;
         float var13;
         float var14;
         if(var25 != null) {
            GlStateManager.func_179090_x();
            GlStateManager.func_179103_j(7425);
            GlStateManager.func_179094_E();
            GlStateManager.func_179114_b(90.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.func_179114_b(MathHelper.func_76126_a(this.field_72769_h.func_72929_e(p_174976_1_)) < 0.0F?180.0F:0.0F, 0.0F, 0.0F, 1.0F);
            GlStateManager.func_179114_b(90.0F, 0.0F, 0.0F, 1.0F);
            var10 = var25[0];
            var11 = var25[1];
            var12 = var25[2];
            float var15;
            if(p_174976_2_ != 2) {
               var13 = (var10 * 30.0F + var11 * 59.0F + var12 * 11.0F) / 100.0F;
               var14 = (var10 * 30.0F + var11 * 70.0F) / 100.0F;
               var15 = (var10 * 30.0F + var12 * 70.0F) / 100.0F;
               var10 = var13;
               var11 = var14;
               var12 = var15;
            }

            var24.func_178964_a(6);
            var24.func_178960_a(var10, var11, var12, var25[3]);
            var24.func_178984_b(0.0D, 100.0D, 0.0D);
            boolean var27 = true;
            var24.func_178960_a(var25[0], var25[1], var25[2], 0.0F);

            for(int var28 = 0; var28 <= 16; ++var28) {
               var15 = (float)var28 * 3.1415927F * 2.0F / 16.0F;
               float var16 = MathHelper.func_76126_a(var15);
               float var17 = MathHelper.func_76134_b(var15);
               var24.func_178984_b((double)(var16 * 120.0F), (double)(var17 * 120.0F), (double)(-var17 * 40.0F * var25[3]));
            }

            var23.func_78381_a();
            GlStateManager.func_179121_F();
            GlStateManager.func_179103_j(7424);
         }

         GlStateManager.func_179098_w();
         GlStateManager.func_179120_a(770, 1, 1, 0);
         GlStateManager.func_179094_E();
         var10 = 1.0F - this.field_72769_h.func_72867_j(p_174976_1_);
         var11 = 0.0F;
         var12 = 0.0F;
         var13 = 0.0F;
         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, var10);
         GlStateManager.func_179109_b(0.0F, 0.0F, 0.0F);
         GlStateManager.func_179114_b(-90.0F, 0.0F, 1.0F, 0.0F);
         GlStateManager.func_179114_b(this.field_72769_h.func_72826_c(p_174976_1_) * 360.0F, 1.0F, 0.0F, 0.0F);
         var14 = 30.0F;
         this.field_72770_i.func_110577_a(field_110928_i);
         var24.func_178970_b();
         var24.func_178985_a((double)(-var14), 100.0D, (double)(-var14), 0.0D, 0.0D);
         var24.func_178985_a((double)var14, 100.0D, (double)(-var14), 1.0D, 0.0D);
         var24.func_178985_a((double)var14, 100.0D, (double)var14, 1.0D, 1.0D);
         var24.func_178985_a((double)(-var14), 100.0D, (double)var14, 0.0D, 1.0D);
         var23.func_78381_a();
         var14 = 20.0F;
         this.field_72770_i.func_110577_a(field_110927_h);
         int var29 = this.field_72769_h.func_72853_d();
         int var30 = var29 % 4;
         int var31 = var29 / 4 % 2;
         float var18 = (float)(var30 + 0) / 4.0F;
         float var19 = (float)(var31 + 0) / 2.0F;
         float var20 = (float)(var30 + 1) / 4.0F;
         float var21 = (float)(var31 + 1) / 2.0F;
         var24.func_178970_b();
         var24.func_178985_a((double)(-var14), -100.0D, (double)var14, (double)var20, (double)var21);
         var24.func_178985_a((double)var14, -100.0D, (double)var14, (double)var18, (double)var21);
         var24.func_178985_a((double)var14, -100.0D, (double)(-var14), (double)var18, (double)var19);
         var24.func_178985_a((double)(-var14), -100.0D, (double)(-var14), (double)var20, (double)var19);
         var23.func_78381_a();
         GlStateManager.func_179090_x();
         float var22 = this.field_72769_h.func_72880_h(p_174976_1_) * var10;
         if(var22 > 0.0F) {
            GlStateManager.func_179131_c(var22, var22, var22, var22);
            if(this.field_175005_X) {
               this.field_175013_s.func_177359_a();
               GL11.glEnableClientState('\u8074');
               GL11.glVertexPointer(3, 5126, 12, 0L);
               this.field_175013_s.func_177358_a(7);
               this.field_175013_s.func_177361_b();
               GL11.glDisableClientState('\u8074');
            } else {
               GlStateManager.func_179148_o(this.field_72772_v);
            }
         }

         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.func_179084_k();
         GlStateManager.func_179141_d();
         GlStateManager.func_179127_m();
         GlStateManager.func_179121_F();
         GlStateManager.func_179090_x();
         GlStateManager.func_179124_c(0.0F, 0.0F, 0.0F);
         double var26 = this.field_72777_q.field_71439_g.func_174824_e(p_174976_1_).field_72448_b - this.field_72769_h.func_72919_O();
         if(var26 < 0.0D) {
            GlStateManager.func_179094_E();
            GlStateManager.func_179109_b(0.0F, 12.0F, 0.0F);
            if(this.field_175005_X) {
               this.field_175011_u.func_177359_a();
               GL11.glEnableClientState('\u8074');
               GL11.glVertexPointer(3, 5126, 12, 0L);
               this.field_175011_u.func_177358_a(7);
               this.field_175011_u.func_177361_b();
               GL11.glDisableClientState('\u8074');
            } else {
               GlStateManager.func_179148_o(this.field_72781_x);
            }

            GlStateManager.func_179121_F();
            var12 = 1.0F;
            var13 = -((float)(var26 + 65.0D));
            var14 = -1.0F;
            var24.func_178970_b();
            var24.func_178974_a(0, 255);
            var24.func_178984_b(-1.0D, (double)var13, 1.0D);
            var24.func_178984_b(1.0D, (double)var13, 1.0D);
            var24.func_178984_b(1.0D, -1.0D, 1.0D);
            var24.func_178984_b(-1.0D, -1.0D, 1.0D);
            var24.func_178984_b(-1.0D, -1.0D, -1.0D);
            var24.func_178984_b(1.0D, -1.0D, -1.0D);
            var24.func_178984_b(1.0D, (double)var13, -1.0D);
            var24.func_178984_b(-1.0D, (double)var13, -1.0D);
            var24.func_178984_b(1.0D, -1.0D, -1.0D);
            var24.func_178984_b(1.0D, -1.0D, 1.0D);
            var24.func_178984_b(1.0D, (double)var13, 1.0D);
            var24.func_178984_b(1.0D, (double)var13, -1.0D);
            var24.func_178984_b(-1.0D, (double)var13, -1.0D);
            var24.func_178984_b(-1.0D, (double)var13, 1.0D);
            var24.func_178984_b(-1.0D, -1.0D, 1.0D);
            var24.func_178984_b(-1.0D, -1.0D, -1.0D);
            var24.func_178984_b(-1.0D, -1.0D, -1.0D);
            var24.func_178984_b(-1.0D, -1.0D, 1.0D);
            var24.func_178984_b(1.0D, -1.0D, 1.0D);
            var24.func_178984_b(1.0D, -1.0D, -1.0D);
            var23.func_78381_a();
         }

         if(this.field_72769_h.field_73011_w.func_76561_g()) {
            GlStateManager.func_179124_c(var4 * 0.2F + 0.04F, var5 * 0.2F + 0.04F, var6 * 0.6F + 0.1F);
         } else {
            GlStateManager.func_179124_c(var4, var5, var6);
         }

         GlStateManager.func_179094_E();
         GlStateManager.func_179109_b(0.0F, -((float)(var26 - 16.0D)), 0.0F);
         GlStateManager.func_179148_o(this.field_72781_x);
         GlStateManager.func_179121_F();
         GlStateManager.func_179098_w();
         GlStateManager.func_179132_a(true);
      }
   }

   public void func_180447_b(float p_180447_1_, int p_180447_2_) {
      if(this.field_72777_q.field_71441_e.field_73011_w.func_76569_d()) {
         if(this.field_72777_q.field_71474_y.field_74347_j) {
            this.func_180445_c(p_180447_1_, p_180447_2_);
         } else {
            GlStateManager.func_179129_p();
            float var3 = (float)(this.field_72777_q.func_175606_aa().field_70137_T + (this.field_72777_q.func_175606_aa().field_70163_u - this.field_72777_q.func_175606_aa().field_70137_T) * (double)p_180447_1_);
            boolean var4 = true;
            boolean var5 = true;
            Tessellator var6 = Tessellator.func_178181_a();
            WorldRenderer var7 = var6.func_178180_c();
            this.field_72770_i.func_110577_a(field_110925_j);
            GlStateManager.func_179147_l();
            GlStateManager.func_179120_a(770, 771, 1, 0);
            Vec3 var8 = this.field_72769_h.func_72824_f(p_180447_1_);
            float var9 = (float)var8.field_72450_a;
            float var10 = (float)var8.field_72448_b;
            float var11 = (float)var8.field_72449_c;
            float var12;
            if(p_180447_2_ != 2) {
               var12 = (var9 * 30.0F + var10 * 59.0F + var11 * 11.0F) / 100.0F;
               float var13 = (var9 * 30.0F + var10 * 70.0F) / 100.0F;
               float var14 = (var9 * 30.0F + var11 * 70.0F) / 100.0F;
               var9 = var12;
               var10 = var13;
               var11 = var14;
            }

            var12 = 4.8828125E-4F;
            double var26 = (double)((float)this.field_72773_u + p_180447_1_);
            double var15 = this.field_72777_q.func_175606_aa().field_70169_q + (this.field_72777_q.func_175606_aa().field_70165_t - this.field_72777_q.func_175606_aa().field_70169_q) * (double)p_180447_1_ + var26 * 0.029999999329447746D;
            double var17 = this.field_72777_q.func_175606_aa().field_70166_s + (this.field_72777_q.func_175606_aa().field_70161_v - this.field_72777_q.func_175606_aa().field_70166_s) * (double)p_180447_1_;
            int var19 = MathHelper.func_76128_c(var15 / 2048.0D);
            int var20 = MathHelper.func_76128_c(var17 / 2048.0D);
            var15 -= (double)(var19 * 2048);
            var17 -= (double)(var20 * 2048);
            float var21 = this.field_72769_h.field_73011_w.func_76571_f() - var3 + 0.33F;
            float var22 = (float)(var15 * 4.8828125E-4D);
            float var23 = (float)(var17 * 4.8828125E-4D);
            var7.func_178970_b();
            var7.func_178960_a(var9, var10, var11, 0.8F);

            for(int var24 = -256; var24 < 256; var24 += 32) {
               for(int var25 = -256; var25 < 256; var25 += 32) {
                  var7.func_178985_a((double)(var24 + 0), (double)var21, (double)(var25 + 32), (double)((float)(var24 + 0) * 4.8828125E-4F + var22), (double)((float)(var25 + 32) * 4.8828125E-4F + var23));
                  var7.func_178985_a((double)(var24 + 32), (double)var21, (double)(var25 + 32), (double)((float)(var24 + 32) * 4.8828125E-4F + var22), (double)((float)(var25 + 32) * 4.8828125E-4F + var23));
                  var7.func_178985_a((double)(var24 + 32), (double)var21, (double)(var25 + 0), (double)((float)(var24 + 32) * 4.8828125E-4F + var22), (double)((float)(var25 + 0) * 4.8828125E-4F + var23));
                  var7.func_178985_a((double)(var24 + 0), (double)var21, (double)(var25 + 0), (double)((float)(var24 + 0) * 4.8828125E-4F + var22), (double)((float)(var25 + 0) * 4.8828125E-4F + var23));
               }
            }

            var6.func_78381_a();
            GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.func_179084_k();
            GlStateManager.func_179089_o();
         }
      }
   }

   public boolean func_72721_a(double p_72721_1_, double p_72721_3_, double p_72721_5_, float p_72721_7_) {
      return false;
   }

   private void func_180445_c(float p_180445_1_, int p_180445_2_) {
      GlStateManager.func_179129_p();
      float var3 = (float)(this.field_72777_q.func_175606_aa().field_70137_T + (this.field_72777_q.func_175606_aa().field_70163_u - this.field_72777_q.func_175606_aa().field_70137_T) * (double)p_180445_1_);
      Tessellator var4 = Tessellator.func_178181_a();
      WorldRenderer var5 = var4.func_178180_c();
      float var6 = 12.0F;
      float var7 = 4.0F;
      double var8 = (double)((float)this.field_72773_u + p_180445_1_);
      double var10 = (this.field_72777_q.func_175606_aa().field_70169_q + (this.field_72777_q.func_175606_aa().field_70165_t - this.field_72777_q.func_175606_aa().field_70169_q) * (double)p_180445_1_ + var8 * 0.029999999329447746D) / 12.0D;
      double var12 = (this.field_72777_q.func_175606_aa().field_70166_s + (this.field_72777_q.func_175606_aa().field_70161_v - this.field_72777_q.func_175606_aa().field_70166_s) * (double)p_180445_1_) / 12.0D + 0.33000001311302185D;
      float var14 = this.field_72769_h.field_73011_w.func_76571_f() - var3 + 0.33F;
      int var15 = MathHelper.func_76128_c(var10 / 2048.0D);
      int var16 = MathHelper.func_76128_c(var12 / 2048.0D);
      var10 -= (double)(var15 * 2048);
      var12 -= (double)(var16 * 2048);
      this.field_72770_i.func_110577_a(field_110925_j);
      GlStateManager.func_179147_l();
      GlStateManager.func_179120_a(770, 771, 1, 0);
      Vec3 var17 = this.field_72769_h.func_72824_f(p_180445_1_);
      float var18 = (float)var17.field_72450_a;
      float var19 = (float)var17.field_72448_b;
      float var20 = (float)var17.field_72449_c;
      float var21;
      float var22;
      float var23;
      if(p_180445_2_ != 2) {
         var21 = (var18 * 30.0F + var19 * 59.0F + var20 * 11.0F) / 100.0F;
         var22 = (var18 * 30.0F + var19 * 70.0F) / 100.0F;
         var23 = (var18 * 30.0F + var20 * 70.0F) / 100.0F;
         var18 = var21;
         var19 = var22;
         var20 = var23;
      }

      var21 = 0.00390625F;
      var22 = (float)MathHelper.func_76128_c(var10) * 0.00390625F;
      var23 = (float)MathHelper.func_76128_c(var12) * 0.00390625F;
      float var24 = (float)(var10 - (double)MathHelper.func_76128_c(var10));
      float var25 = (float)(var12 - (double)MathHelper.func_76128_c(var12));
      boolean var26 = true;
      boolean var27 = true;
      float var28 = 9.765625E-4F;
      GlStateManager.func_179152_a(12.0F, 1.0F, 12.0F);

      for(int var29 = 0; var29 < 2; ++var29) {
         if(var29 == 0) {
            GlStateManager.func_179135_a(false, false, false, false);
         } else {
            switch(p_180445_2_) {
            case 0:
               GlStateManager.func_179135_a(false, true, true, true);
               break;
            case 1:
               GlStateManager.func_179135_a(true, false, false, true);
               break;
            case 2:
               GlStateManager.func_179135_a(true, true, true, true);
            }
         }

         for(int var30 = -3; var30 <= 4; ++var30) {
            for(int var31 = -3; var31 <= 4; ++var31) {
               var5.func_178970_b();
               float var32 = (float)(var30 * 8);
               float var33 = (float)(var31 * 8);
               float var34 = var32 - var24;
               float var35 = var33 - var25;
               if(var14 > -5.0F) {
                  var5.func_178960_a(var18 * 0.7F, var19 * 0.7F, var20 * 0.7F, 0.8F);
                  var5.func_178980_d(0.0F, -1.0F, 0.0F);
                  var5.func_178985_a((double)(var34 + 0.0F), (double)(var14 + 0.0F), (double)(var35 + 8.0F), (double)((var32 + 0.0F) * 0.00390625F + var22), (double)((var33 + 8.0F) * 0.00390625F + var23));
                  var5.func_178985_a((double)(var34 + 8.0F), (double)(var14 + 0.0F), (double)(var35 + 8.0F), (double)((var32 + 8.0F) * 0.00390625F + var22), (double)((var33 + 8.0F) * 0.00390625F + var23));
                  var5.func_178985_a((double)(var34 + 8.0F), (double)(var14 + 0.0F), (double)(var35 + 0.0F), (double)((var32 + 8.0F) * 0.00390625F + var22), (double)((var33 + 0.0F) * 0.00390625F + var23));
                  var5.func_178985_a((double)(var34 + 0.0F), (double)(var14 + 0.0F), (double)(var35 + 0.0F), (double)((var32 + 0.0F) * 0.00390625F + var22), (double)((var33 + 0.0F) * 0.00390625F + var23));
               }

               if(var14 <= 5.0F) {
                  var5.func_178960_a(var18, var19, var20, 0.8F);
                  var5.func_178980_d(0.0F, 1.0F, 0.0F);
                  var5.func_178985_a((double)(var34 + 0.0F), (double)(var14 + 4.0F - 9.765625E-4F), (double)(var35 + 8.0F), (double)((var32 + 0.0F) * 0.00390625F + var22), (double)((var33 + 8.0F) * 0.00390625F + var23));
                  var5.func_178985_a((double)(var34 + 8.0F), (double)(var14 + 4.0F - 9.765625E-4F), (double)(var35 + 8.0F), (double)((var32 + 8.0F) * 0.00390625F + var22), (double)((var33 + 8.0F) * 0.00390625F + var23));
                  var5.func_178985_a((double)(var34 + 8.0F), (double)(var14 + 4.0F - 9.765625E-4F), (double)(var35 + 0.0F), (double)((var32 + 8.0F) * 0.00390625F + var22), (double)((var33 + 0.0F) * 0.00390625F + var23));
                  var5.func_178985_a((double)(var34 + 0.0F), (double)(var14 + 4.0F - 9.765625E-4F), (double)(var35 + 0.0F), (double)((var32 + 0.0F) * 0.00390625F + var22), (double)((var33 + 0.0F) * 0.00390625F + var23));
               }

               var5.func_178960_a(var18 * 0.9F, var19 * 0.9F, var20 * 0.9F, 0.8F);
               int var36;
               if(var30 > -1) {
                  var5.func_178980_d(-1.0F, 0.0F, 0.0F);

                  for(var36 = 0; var36 < 8; ++var36) {
                     var5.func_178985_a((double)(var34 + (float)var36 + 0.0F), (double)(var14 + 0.0F), (double)(var35 + 8.0F), (double)((var32 + (float)var36 + 0.5F) * 0.00390625F + var22), (double)((var33 + 8.0F) * 0.00390625F + var23));
                     var5.func_178985_a((double)(var34 + (float)var36 + 0.0F), (double)(var14 + 4.0F), (double)(var35 + 8.0F), (double)((var32 + (float)var36 + 0.5F) * 0.00390625F + var22), (double)((var33 + 8.0F) * 0.00390625F + var23));
                     var5.func_178985_a((double)(var34 + (float)var36 + 0.0F), (double)(var14 + 4.0F), (double)(var35 + 0.0F), (double)((var32 + (float)var36 + 0.5F) * 0.00390625F + var22), (double)((var33 + 0.0F) * 0.00390625F + var23));
                     var5.func_178985_a((double)(var34 + (float)var36 + 0.0F), (double)(var14 + 0.0F), (double)(var35 + 0.0F), (double)((var32 + (float)var36 + 0.5F) * 0.00390625F + var22), (double)((var33 + 0.0F) * 0.00390625F + var23));
                  }
               }

               if(var30 <= 1) {
                  var5.func_178980_d(1.0F, 0.0F, 0.0F);

                  for(var36 = 0; var36 < 8; ++var36) {
                     var5.func_178985_a((double)(var34 + (float)var36 + 1.0F - 9.765625E-4F), (double)(var14 + 0.0F), (double)(var35 + 8.0F), (double)((var32 + (float)var36 + 0.5F) * 0.00390625F + var22), (double)((var33 + 8.0F) * 0.00390625F + var23));
                     var5.func_178985_a((double)(var34 + (float)var36 + 1.0F - 9.765625E-4F), (double)(var14 + 4.0F), (double)(var35 + 8.0F), (double)((var32 + (float)var36 + 0.5F) * 0.00390625F + var22), (double)((var33 + 8.0F) * 0.00390625F + var23));
                     var5.func_178985_a((double)(var34 + (float)var36 + 1.0F - 9.765625E-4F), (double)(var14 + 4.0F), (double)(var35 + 0.0F), (double)((var32 + (float)var36 + 0.5F) * 0.00390625F + var22), (double)((var33 + 0.0F) * 0.00390625F + var23));
                     var5.func_178985_a((double)(var34 + (float)var36 + 1.0F - 9.765625E-4F), (double)(var14 + 0.0F), (double)(var35 + 0.0F), (double)((var32 + (float)var36 + 0.5F) * 0.00390625F + var22), (double)((var33 + 0.0F) * 0.00390625F + var23));
                  }
               }

               var5.func_178960_a(var18 * 0.8F, var19 * 0.8F, var20 * 0.8F, 0.8F);
               if(var31 > -1) {
                  var5.func_178980_d(0.0F, 0.0F, -1.0F);

                  for(var36 = 0; var36 < 8; ++var36) {
                     var5.func_178985_a((double)(var34 + 0.0F), (double)(var14 + 4.0F), (double)(var35 + (float)var36 + 0.0F), (double)((var32 + 0.0F) * 0.00390625F + var22), (double)((var33 + (float)var36 + 0.5F) * 0.00390625F + var23));
                     var5.func_178985_a((double)(var34 + 8.0F), (double)(var14 + 4.0F), (double)(var35 + (float)var36 + 0.0F), (double)((var32 + 8.0F) * 0.00390625F + var22), (double)((var33 + (float)var36 + 0.5F) * 0.00390625F + var23));
                     var5.func_178985_a((double)(var34 + 8.0F), (double)(var14 + 0.0F), (double)(var35 + (float)var36 + 0.0F), (double)((var32 + 8.0F) * 0.00390625F + var22), (double)((var33 + (float)var36 + 0.5F) * 0.00390625F + var23));
                     var5.func_178985_a((double)(var34 + 0.0F), (double)(var14 + 0.0F), (double)(var35 + (float)var36 + 0.0F), (double)((var32 + 0.0F) * 0.00390625F + var22), (double)((var33 + (float)var36 + 0.5F) * 0.00390625F + var23));
                  }
               }

               if(var31 <= 1) {
                  var5.func_178980_d(0.0F, 0.0F, 1.0F);

                  for(var36 = 0; var36 < 8; ++var36) {
                     var5.func_178985_a((double)(var34 + 0.0F), (double)(var14 + 4.0F), (double)(var35 + (float)var36 + 1.0F - 9.765625E-4F), (double)((var32 + 0.0F) * 0.00390625F + var22), (double)((var33 + (float)var36 + 0.5F) * 0.00390625F + var23));
                     var5.func_178985_a((double)(var34 + 8.0F), (double)(var14 + 4.0F), (double)(var35 + (float)var36 + 1.0F - 9.765625E-4F), (double)((var32 + 8.0F) * 0.00390625F + var22), (double)((var33 + (float)var36 + 0.5F) * 0.00390625F + var23));
                     var5.func_178985_a((double)(var34 + 8.0F), (double)(var14 + 0.0F), (double)(var35 + (float)var36 + 1.0F - 9.765625E-4F), (double)((var32 + 8.0F) * 0.00390625F + var22), (double)((var33 + (float)var36 + 0.5F) * 0.00390625F + var23));
                     var5.func_178985_a((double)(var34 + 0.0F), (double)(var14 + 0.0F), (double)(var35 + (float)var36 + 1.0F - 9.765625E-4F), (double)((var32 + 0.0F) * 0.00390625F + var22), (double)((var33 + (float)var36 + 0.5F) * 0.00390625F + var23));
                  }
               }

               var4.func_78381_a();
            }
         }
      }

      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.func_179084_k();
      GlStateManager.func_179089_o();
   }

   public void func_174967_a(long p_174967_1_) {
      this.field_147595_R |= this.field_174995_M.func_178516_a(p_174967_1_);
      Iterator var3 = this.field_175009_l.iterator();

      while(var3.hasNext()) {
         RenderChunk var4 = (RenderChunk)var3.next();
         if(!this.field_174995_M.func_178507_a(var4)) {
            break;
         }

         var4.func_178575_a(false);
         var3.remove();
      }

   }

   public void func_180449_a(Entity p_180449_1_, float p_180449_2_) {
      Tessellator var3 = Tessellator.func_178181_a();
      WorldRenderer var4 = var3.func_178180_c();
      WorldBorder var5 = this.field_72769_h.func_175723_af();
      double var6 = (double)(this.field_72777_q.field_71474_y.field_151451_c * 16);
      if(p_180449_1_.field_70165_t >= var5.func_177728_d() - var6 || p_180449_1_.field_70165_t <= var5.func_177726_b() + var6 || p_180449_1_.field_70161_v >= var5.func_177733_e() - var6 || p_180449_1_.field_70161_v <= var5.func_177736_c() + var6) {
         double var8 = 1.0D - var5.func_177745_a(p_180449_1_) / var6;
         var8 = Math.pow(var8, 4.0D);
         double var10 = p_180449_1_.field_70142_S + (p_180449_1_.field_70165_t - p_180449_1_.field_70142_S) * (double)p_180449_2_;
         double var12 = p_180449_1_.field_70137_T + (p_180449_1_.field_70163_u - p_180449_1_.field_70137_T) * (double)p_180449_2_;
         double var14 = p_180449_1_.field_70136_U + (p_180449_1_.field_70161_v - p_180449_1_.field_70136_U) * (double)p_180449_2_;
         GlStateManager.func_179147_l();
         GlStateManager.func_179120_a(770, 1, 1, 0);
         this.field_72770_i.func_110577_a(field_175006_g);
         GlStateManager.func_179132_a(false);
         GlStateManager.func_179094_E();
         int var16 = var5.func_177734_a().func_177766_a();
         float var17 = (float)(var16 >> 16 & 255) / 255.0F;
         float var18 = (float)(var16 >> 8 & 255) / 255.0F;
         float var19 = (float)(var16 & 255) / 255.0F;
         GlStateManager.func_179131_c(var17, var18, var19, (float)var8);
         GlStateManager.func_179136_a(-3.0F, -3.0F);
         GlStateManager.func_179088_q();
         GlStateManager.func_179092_a(516, 0.1F);
         GlStateManager.func_179141_d();
         GlStateManager.func_179129_p();
         float var20 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F;
         float var21 = 0.0F;
         float var22 = 0.0F;
         float var23 = 128.0F;
         var4.func_178970_b();
         var4.func_178969_c(-var10, -var12, -var14);
         var4.func_78914_f();
         double var24 = Math.max((double)MathHelper.func_76128_c(var14 - var6), var5.func_177736_c());
         double var26 = Math.min((double)MathHelper.func_76143_f(var14 + var6), var5.func_177733_e());
         float var28;
         double var29;
         double var31;
         float var33;
         if(var10 > var5.func_177728_d() - var6) {
            var28 = 0.0F;

            for(var29 = var24; var29 < var26; var28 += 0.5F) {
               var31 = Math.min(1.0D, var26 - var29);
               var33 = (float)var31 * 0.5F;
               var4.func_178985_a(var5.func_177728_d(), 256.0D, var29, (double)(var20 + var28), (double)(var20 + 0.0F));
               var4.func_178985_a(var5.func_177728_d(), 256.0D, var29 + var31, (double)(var20 + var33 + var28), (double)(var20 + 0.0F));
               var4.func_178985_a(var5.func_177728_d(), 0.0D, var29 + var31, (double)(var20 + var33 + var28), (double)(var20 + 128.0F));
               var4.func_178985_a(var5.func_177728_d(), 0.0D, var29, (double)(var20 + var28), (double)(var20 + 128.0F));
               ++var29;
            }
         }

         if(var10 < var5.func_177726_b() + var6) {
            var28 = 0.0F;

            for(var29 = var24; var29 < var26; var28 += 0.5F) {
               var31 = Math.min(1.0D, var26 - var29);
               var33 = (float)var31 * 0.5F;
               var4.func_178985_a(var5.func_177726_b(), 256.0D, var29, (double)(var20 + var28), (double)(var20 + 0.0F));
               var4.func_178985_a(var5.func_177726_b(), 256.0D, var29 + var31, (double)(var20 + var33 + var28), (double)(var20 + 0.0F));
               var4.func_178985_a(var5.func_177726_b(), 0.0D, var29 + var31, (double)(var20 + var33 + var28), (double)(var20 + 128.0F));
               var4.func_178985_a(var5.func_177726_b(), 0.0D, var29, (double)(var20 + var28), (double)(var20 + 128.0F));
               ++var29;
            }
         }

         var24 = Math.max((double)MathHelper.func_76128_c(var10 - var6), var5.func_177726_b());
         var26 = Math.min((double)MathHelper.func_76143_f(var10 + var6), var5.func_177728_d());
         if(var14 > var5.func_177733_e() - var6) {
            var28 = 0.0F;

            for(var29 = var24; var29 < var26; var28 += 0.5F) {
               var31 = Math.min(1.0D, var26 - var29);
               var33 = (float)var31 * 0.5F;
               var4.func_178985_a(var29, 256.0D, var5.func_177733_e(), (double)(var20 + var28), (double)(var20 + 0.0F));
               var4.func_178985_a(var29 + var31, 256.0D, var5.func_177733_e(), (double)(var20 + var33 + var28), (double)(var20 + 0.0F));
               var4.func_178985_a(var29 + var31, 0.0D, var5.func_177733_e(), (double)(var20 + var33 + var28), (double)(var20 + 128.0F));
               var4.func_178985_a(var29, 0.0D, var5.func_177733_e(), (double)(var20 + var28), (double)(var20 + 128.0F));
               ++var29;
            }
         }

         if(var14 < var5.func_177736_c() + var6) {
            var28 = 0.0F;

            for(var29 = var24; var29 < var26; var28 += 0.5F) {
               var31 = Math.min(1.0D, var26 - var29);
               var33 = (float)var31 * 0.5F;
               var4.func_178985_a(var29, 256.0D, var5.func_177736_c(), (double)(var20 + var28), (double)(var20 + 0.0F));
               var4.func_178985_a(var29 + var31, 256.0D, var5.func_177736_c(), (double)(var20 + var33 + var28), (double)(var20 + 0.0F));
               var4.func_178985_a(var29 + var31, 0.0D, var5.func_177736_c(), (double)(var20 + var33 + var28), (double)(var20 + 128.0F));
               var4.func_178985_a(var29, 0.0D, var5.func_177736_c(), (double)(var20 + var28), (double)(var20 + 128.0F));
               ++var29;
            }
         }

         var3.func_78381_a();
         var4.func_178969_c(0.0D, 0.0D, 0.0D);
         GlStateManager.func_179089_o();
         GlStateManager.func_179118_c();
         GlStateManager.func_179136_a(0.0F, 0.0F);
         GlStateManager.func_179113_r();
         GlStateManager.func_179141_d();
         GlStateManager.func_179084_k();
         GlStateManager.func_179121_F();
         GlStateManager.func_179132_a(true);
      }
   }

   private void func_180443_s() {
      GlStateManager.func_179120_a(774, 768, 1, 0);
      GlStateManager.func_179147_l();
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 0.5F);
      GlStateManager.func_179136_a(-3.0F, -3.0F);
      GlStateManager.func_179088_q();
      GlStateManager.func_179092_a(516, 0.1F);
      GlStateManager.func_179141_d();
      GlStateManager.func_179094_E();
   }

   private void func_174969_t() {
      GlStateManager.func_179118_c();
      GlStateManager.func_179136_a(0.0F, 0.0F);
      GlStateManager.func_179113_r();
      GlStateManager.func_179141_d();
      GlStateManager.func_179132_a(true);
      GlStateManager.func_179121_F();
   }

   public void func_174981_a(Tessellator p_174981_1_, WorldRenderer p_174981_2_, Entity p_174981_3_, float p_174981_4_) {
      double var5 = p_174981_3_.field_70142_S + (p_174981_3_.field_70165_t - p_174981_3_.field_70142_S) * (double)p_174981_4_;
      double var7 = p_174981_3_.field_70137_T + (p_174981_3_.field_70163_u - p_174981_3_.field_70137_T) * (double)p_174981_4_;
      double var9 = p_174981_3_.field_70136_U + (p_174981_3_.field_70161_v - p_174981_3_.field_70136_U) * (double)p_174981_4_;
      if(!this.field_72738_E.isEmpty()) {
         this.field_72770_i.func_110577_a(TextureMap.field_110575_b);
         this.func_180443_s();
         p_174981_2_.func_178970_b();
         p_174981_2_.func_178967_a(DefaultVertexFormats.field_176600_a);
         p_174981_2_.func_178969_c(-var5, -var7, -var9);
         p_174981_2_.func_78914_f();
         Iterator var11 = this.field_72738_E.values().iterator();

         while(var11.hasNext()) {
            DestroyBlockProgress var12 = (DestroyBlockProgress)var11.next();
            BlockPos var13 = var12.func_180246_b();
            double var14 = (double)var13.func_177958_n() - var5;
            double var16 = (double)var13.func_177956_o() - var7;
            double var18 = (double)var13.func_177952_p() - var9;
            Block var20 = this.field_72769_h.func_180495_p(var13).func_177230_c();
            if(!(var20 instanceof BlockChest) && !(var20 instanceof BlockEnderChest) && !(var20 instanceof BlockSign) && !(var20 instanceof BlockSkull)) {
               if(var14 * var14 + var16 * var16 + var18 * var18 > 1024.0D) {
                  var11.remove();
               } else {
                  IBlockState var21 = this.field_72769_h.func_180495_p(var13);
                  if(var21.func_177230_c().func_149688_o() != Material.field_151579_a) {
                     int var22 = var12.func_73106_e();
                     TextureAtlasSprite var23 = this.field_94141_F[var22];
                     BlockRendererDispatcher var24 = this.field_72777_q.func_175602_ab();
                     var24.func_175020_a(var21, var13, var23, this.field_72769_h);
                  }
               }
            }
         }

         p_174981_1_.func_78381_a();
         p_174981_2_.func_178969_c(0.0D, 0.0D, 0.0D);
         this.func_174969_t();
      }

   }

   public void func_72731_b(EntityPlayer p_72731_1_, MovingObjectPosition p_72731_2_, int p_72731_3_, float p_72731_4_) {
      if(p_72731_3_ == 0 && p_72731_2_.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
         GlStateManager.func_179147_l();
         GlStateManager.func_179120_a(770, 771, 1, 0);
         GlStateManager.func_179131_c(0.0F, 0.0F, 0.0F, 0.4F);
         GL11.glLineWidth(2.0F);
         GlStateManager.func_179090_x();
         GlStateManager.func_179132_a(false);
         float var5 = 0.002F;
         BlockPos var6 = p_72731_2_.func_178782_a();
         Block var7 = this.field_72769_h.func_180495_p(var6).func_177230_c();
         if(var7.func_149688_o() != Material.field_151579_a && this.field_72769_h.func_175723_af().func_177746_a(var6)) {
            var7.func_180654_a(this.field_72769_h, var6);
            double var8 = p_72731_1_.field_70142_S + (p_72731_1_.field_70165_t - p_72731_1_.field_70142_S) * (double)p_72731_4_;
            double var10 = p_72731_1_.field_70137_T + (p_72731_1_.field_70163_u - p_72731_1_.field_70137_T) * (double)p_72731_4_;
            double var12 = p_72731_1_.field_70136_U + (p_72731_1_.field_70161_v - p_72731_1_.field_70136_U) * (double)p_72731_4_;
            func_147590_a(var7.func_180646_a(this.field_72769_h, var6).func_72314_b(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).func_72317_d(-var8, -var10, -var12), -1);
         }

         GlStateManager.func_179132_a(true);
         GlStateManager.func_179098_w();
         GlStateManager.func_179084_k();
      }

   }

   public static void func_147590_a(AxisAlignedBB p_147590_0_, int p_147590_1_) {
      Tessellator var2 = Tessellator.func_178181_a();
      WorldRenderer var3 = var2.func_178180_c();
      var3.func_178964_a(3);
      if(p_147590_1_ != -1) {
         var3.func_178991_c(p_147590_1_);
      }

      var3.func_178984_b(p_147590_0_.field_72340_a, p_147590_0_.field_72338_b, p_147590_0_.field_72339_c);
      var3.func_178984_b(p_147590_0_.field_72336_d, p_147590_0_.field_72338_b, p_147590_0_.field_72339_c);
      var3.func_178984_b(p_147590_0_.field_72336_d, p_147590_0_.field_72338_b, p_147590_0_.field_72334_f);
      var3.func_178984_b(p_147590_0_.field_72340_a, p_147590_0_.field_72338_b, p_147590_0_.field_72334_f);
      var3.func_178984_b(p_147590_0_.field_72340_a, p_147590_0_.field_72338_b, p_147590_0_.field_72339_c);
      var2.func_78381_a();
      var3.func_178964_a(3);
      if(p_147590_1_ != -1) {
         var3.func_178991_c(p_147590_1_);
      }

      var3.func_178984_b(p_147590_0_.field_72340_a, p_147590_0_.field_72337_e, p_147590_0_.field_72339_c);
      var3.func_178984_b(p_147590_0_.field_72336_d, p_147590_0_.field_72337_e, p_147590_0_.field_72339_c);
      var3.func_178984_b(p_147590_0_.field_72336_d, p_147590_0_.field_72337_e, p_147590_0_.field_72334_f);
      var3.func_178984_b(p_147590_0_.field_72340_a, p_147590_0_.field_72337_e, p_147590_0_.field_72334_f);
      var3.func_178984_b(p_147590_0_.field_72340_a, p_147590_0_.field_72337_e, p_147590_0_.field_72339_c);
      var2.func_78381_a();
      var3.func_178964_a(1);
      if(p_147590_1_ != -1) {
         var3.func_178991_c(p_147590_1_);
      }

      var3.func_178984_b(p_147590_0_.field_72340_a, p_147590_0_.field_72338_b, p_147590_0_.field_72339_c);
      var3.func_178984_b(p_147590_0_.field_72340_a, p_147590_0_.field_72337_e, p_147590_0_.field_72339_c);
      var3.func_178984_b(p_147590_0_.field_72336_d, p_147590_0_.field_72338_b, p_147590_0_.field_72339_c);
      var3.func_178984_b(p_147590_0_.field_72336_d, p_147590_0_.field_72337_e, p_147590_0_.field_72339_c);
      var3.func_178984_b(p_147590_0_.field_72336_d, p_147590_0_.field_72338_b, p_147590_0_.field_72334_f);
      var3.func_178984_b(p_147590_0_.field_72336_d, p_147590_0_.field_72337_e, p_147590_0_.field_72334_f);
      var3.func_178984_b(p_147590_0_.field_72340_a, p_147590_0_.field_72338_b, p_147590_0_.field_72334_f);
      var3.func_178984_b(p_147590_0_.field_72340_a, p_147590_0_.field_72337_e, p_147590_0_.field_72334_f);
      var2.func_78381_a();
   }

   private void func_72725_b(int p_72725_1_, int p_72725_2_, int p_72725_3_, int p_72725_4_, int p_72725_5_, int p_72725_6_) {
      this.field_175008_n.func_178162_a(p_72725_1_, p_72725_2_, p_72725_3_, p_72725_4_, p_72725_5_, p_72725_6_);
   }

   public void func_174960_a(BlockPos p_174960_1_) {
      int var2 = p_174960_1_.func_177958_n();
      int var3 = p_174960_1_.func_177956_o();
      int var4 = p_174960_1_.func_177952_p();
      this.func_72725_b(var2 - 1, var3 - 1, var4 - 1, var2 + 1, var3 + 1, var4 + 1);
   }

   public void func_174959_b(BlockPos p_174959_1_) {
      int var2 = p_174959_1_.func_177958_n();
      int var3 = p_174959_1_.func_177956_o();
      int var4 = p_174959_1_.func_177952_p();
      this.func_72725_b(var2 - 1, var3 - 1, var4 - 1, var2 + 1, var3 + 1, var4 + 1);
   }

   public void func_147585_a(int p_147585_1_, int p_147585_2_, int p_147585_3_, int p_147585_4_, int p_147585_5_, int p_147585_6_) {
      this.func_72725_b(p_147585_1_ - 1, p_147585_2_ - 1, p_147585_3_ - 1, p_147585_4_ + 1, p_147585_5_ + 1, p_147585_6_ + 1);
   }

   public void func_174961_a(String p_174961_1_, BlockPos p_174961_2_) {
      ISound var3 = (ISound)this.field_147593_P.get(p_174961_2_);
      if(var3 != null) {
         this.field_72777_q.func_147118_V().func_147683_b(var3);
         this.field_147593_P.remove(p_174961_2_);
      }

      if(p_174961_1_ != null) {
         ItemRecord var4 = ItemRecord.func_150926_b(p_174961_1_);
         if(var4 != null) {
            this.field_72777_q.field_71456_v.func_73833_a(var4.func_150927_i());
         }

         PositionedSoundRecord var5 = PositionedSoundRecord.func_147675_a(new ResourceLocation(p_174961_1_), (float)p_174961_2_.func_177958_n(), (float)p_174961_2_.func_177956_o(), (float)p_174961_2_.func_177952_p());
         this.field_147593_P.put(p_174961_2_, var5);
         this.field_72777_q.func_147118_V().func_147682_a(var5);
      }

   }

   public void func_72704_a(String p_72704_1_, double p_72704_2_, double p_72704_4_, double p_72704_6_, float p_72704_8_, float p_72704_9_) {}

   public void func_85102_a(EntityPlayer p_85102_1_, String p_85102_2_, double p_85102_3_, double p_85102_5_, double p_85102_7_, float p_85102_9_, float p_85102_10_) {}

   public void func_180442_a(int p_180442_1_, boolean p_180442_2_, final double p_180442_3_, final double p_180442_5_, final double p_180442_7_, double p_180442_9_, double p_180442_11_, double p_180442_13_, int ... p_180442_15_) {
      try {
         this.func_174974_b(p_180442_1_, p_180442_2_, p_180442_3_, p_180442_5_, p_180442_7_, p_180442_9_, p_180442_11_, p_180442_13_, p_180442_15_);
      } catch (Throwable var19) {
         CrashReport var17 = CrashReport.func_85055_a(var19, "Exception while adding particle");
         CrashReportCategory var18 = var17.func_85058_a("Particle being added");
         var18.func_71507_a("ID", Integer.valueOf(p_180442_1_));
         if(p_180442_15_ != null) {
            var18.func_71507_a("Parameters", p_180442_15_);
         }

         var18.func_71500_a("Position", new Callable() {

            private static final String __OBFID = "CL_00000955";

            public String call() {
               return CrashReportCategory.func_85074_a(p_180442_3_, p_180442_5_, p_180442_7_);
            }
            // $FF: synthetic method
            public Object call() {
               return this.call();
            }
         });
         throw new ReportedException(var17);
      }
   }

   private void func_174972_a(EnumParticleTypes p_174972_1_, double p_174972_2_, double p_174972_4_, double p_174972_6_, double p_174972_8_, double p_174972_10_, double p_174972_12_, int ... p_174972_14_) {
      this.func_180442_a(p_174972_1_.func_179348_c(), p_174972_1_.func_179344_e(), p_174972_2_, p_174972_4_, p_174972_6_, p_174972_8_, p_174972_10_, p_174972_12_, p_174972_14_);
   }

   private EntityFX func_174974_b(int p_174974_1_, boolean p_174974_2_, double p_174974_3_, double p_174974_5_, double p_174974_7_, double p_174974_9_, double p_174974_11_, double p_174974_13_, int ... p_174974_15_) {
      if(this.field_72777_q != null && this.field_72777_q.func_175606_aa() != null && this.field_72777_q.field_71452_i != null) {
         int var16 = this.field_72777_q.field_71474_y.field_74362_aa;
         if(var16 == 1 && this.field_72769_h.field_73012_v.nextInt(3) == 0) {
            var16 = 2;
         }

         double var17 = this.field_72777_q.func_175606_aa().field_70165_t - p_174974_3_;
         double var19 = this.field_72777_q.func_175606_aa().field_70163_u - p_174974_5_;
         double var21 = this.field_72777_q.func_175606_aa().field_70161_v - p_174974_7_;
         if(p_174974_2_) {
            return this.field_72777_q.field_71452_i.func_178927_a(p_174974_1_, p_174974_3_, p_174974_5_, p_174974_7_, p_174974_9_, p_174974_11_, p_174974_13_, p_174974_15_);
         } else {
            double var23 = 16.0D;
            return var17 * var17 + var19 * var19 + var21 * var21 > 256.0D?null:(var16 > 1?null:this.field_72777_q.field_71452_i.func_178927_a(p_174974_1_, p_174974_3_, p_174974_5_, p_174974_7_, p_174974_9_, p_174974_11_, p_174974_13_, p_174974_15_));
         }
      } else {
         return null;
      }
   }

   public void func_72703_a(Entity p_72703_1_) {}

   public void func_72709_b(Entity p_72709_1_) {}

   public void func_72728_f() {}

   public void func_180440_a(int p_180440_1_, BlockPos p_180440_2_, int p_180440_3_) {
      switch(p_180440_1_) {
      case 1013:
      case 1018:
         if(this.field_72777_q.func_175606_aa() != null) {
            double var4 = (double)p_180440_2_.func_177958_n() - this.field_72777_q.func_175606_aa().field_70165_t;
            double var6 = (double)p_180440_2_.func_177956_o() - this.field_72777_q.func_175606_aa().field_70163_u;
            double var8 = (double)p_180440_2_.func_177952_p() - this.field_72777_q.func_175606_aa().field_70161_v;
            double var10 = Math.sqrt(var4 * var4 + var6 * var6 + var8 * var8);
            double var12 = this.field_72777_q.func_175606_aa().field_70165_t;
            double var14 = this.field_72777_q.func_175606_aa().field_70163_u;
            double var16 = this.field_72777_q.func_175606_aa().field_70161_v;
            if(var10 > 0.0D) {
               var12 += var4 / var10 * 2.0D;
               var14 += var6 / var10 * 2.0D;
               var16 += var8 / var10 * 2.0D;
            }

            if(p_180440_1_ == 1013) {
               this.field_72769_h.func_72980_b(var12, var14, var16, "mob.wither.spawn", 1.0F, 1.0F, false);
            } else {
               this.field_72769_h.func_72980_b(var12, var14, var16, "mob.enderdragon.end", 5.0F, 1.0F, false);
            }
         }
      default:
      }
   }

   public void func_180439_a(EntityPlayer p_180439_1_, int p_180439_2_, BlockPos p_180439_3_, int p_180439_4_) {
      Random var5 = this.field_72769_h.field_73012_v;
      double var7;
      double var9;
      double var11;
      int var13;
      int var18;
      double var19;
      double var21;
      double var23;
      double var32;
      switch(p_180439_2_) {
      case 1000:
         this.field_72769_h.func_175731_a(p_180439_3_, "random.click", 1.0F, 1.0F, false);
         break;
      case 1001:
         this.field_72769_h.func_175731_a(p_180439_3_, "random.click", 1.0F, 1.2F, false);
         break;
      case 1002:
         this.field_72769_h.func_175731_a(p_180439_3_, "random.bow", 1.0F, 1.2F, false);
         break;
      case 1003:
         this.field_72769_h.func_175731_a(p_180439_3_, "random.door_open", 1.0F, this.field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F, false);
         break;
      case 1004:
         this.field_72769_h.func_175731_a(p_180439_3_, "random.fizz", 0.5F, 2.6F + (var5.nextFloat() - var5.nextFloat()) * 0.8F, false);
         break;
      case 1005:
         if(Item.func_150899_d(p_180439_4_) instanceof ItemRecord) {
            this.field_72769_h.func_175717_a(p_180439_3_, "records." + ((ItemRecord)Item.func_150899_d(p_180439_4_)).field_150929_a);
         } else {
            this.field_72769_h.func_175717_a(p_180439_3_, (String)null);
         }
         break;
      case 1006:
         this.field_72769_h.func_175731_a(p_180439_3_, "random.door_close", 1.0F, this.field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F, false);
         break;
      case 1007:
         this.field_72769_h.func_175731_a(p_180439_3_, "mob.ghast.charge", 10.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1008:
         this.field_72769_h.func_175731_a(p_180439_3_, "mob.ghast.fireball", 10.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1009:
         this.field_72769_h.func_175731_a(p_180439_3_, "mob.ghast.fireball", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1010:
         this.field_72769_h.func_175731_a(p_180439_3_, "mob.zombie.wood", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1011:
         this.field_72769_h.func_175731_a(p_180439_3_, "mob.zombie.metal", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1012:
         this.field_72769_h.func_175731_a(p_180439_3_, "mob.zombie.woodbreak", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1014:
         this.field_72769_h.func_175731_a(p_180439_3_, "mob.wither.shoot", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1015:
         this.field_72769_h.func_175731_a(p_180439_3_, "mob.bat.takeoff", 0.05F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1016:
         this.field_72769_h.func_175731_a(p_180439_3_, "mob.zombie.infect", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1017:
         this.field_72769_h.func_175731_a(p_180439_3_, "mob.zombie.unfect", 2.0F, (var5.nextFloat() - var5.nextFloat()) * 0.2F + 1.0F, false);
         break;
      case 1020:
         this.field_72769_h.func_175731_a(p_180439_3_, "random.anvil_break", 1.0F, this.field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F, false);
         break;
      case 1021:
         this.field_72769_h.func_175731_a(p_180439_3_, "random.anvil_use", 1.0F, this.field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F, false);
         break;
      case 1022:
         this.field_72769_h.func_175731_a(p_180439_3_, "random.anvil_land", 0.3F, this.field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F, false);
         break;
      case 2000:
         int var31 = p_180439_4_ % 3 - 1;
         int var8 = p_180439_4_ / 3 % 3 - 1;
         var9 = (double)p_180439_3_.func_177958_n() + (double)var31 * 0.6D + 0.5D;
         var11 = (double)p_180439_3_.func_177956_o() + 0.5D;
         var32 = (double)p_180439_3_.func_177952_p() + (double)var8 * 0.6D + 0.5D;

         for(int var33 = 0; var33 < 10; ++var33) {
            double var34 = var5.nextDouble() * 0.2D + 0.01D;
            double var35 = var9 + (double)var31 * 0.01D + (var5.nextDouble() - 0.5D) * (double)var8 * 0.5D;
            double var20 = var11 + (var5.nextDouble() - 0.5D) * 0.5D;
            double var22 = var32 + (double)var8 * 0.01D + (var5.nextDouble() - 0.5D) * (double)var31 * 0.5D;
            double var24 = (double)var31 * var34 + var5.nextGaussian() * 0.01D;
            double var26 = -0.03D + var5.nextGaussian() * 0.01D;
            double var28 = (double)var8 * var34 + var5.nextGaussian() * 0.01D;
            this.func_174972_a(EnumParticleTypes.SMOKE_NORMAL, var35, var20, var22, var24, var26, var28, new int[0]);
         }

         return;
      case 2001:
         Block var6 = Block.func_149729_e(p_180439_4_ & 4095);
         if(var6.func_149688_o() != Material.field_151579_a) {
            this.field_72777_q.func_147118_V().func_147682_a(new PositionedSoundRecord(new ResourceLocation(var6.field_149762_H.func_150495_a()), (var6.field_149762_H.func_150497_c() + 1.0F) / 2.0F, var6.field_149762_H.func_150494_d() * 0.8F, (float)p_180439_3_.func_177958_n() + 0.5F, (float)p_180439_3_.func_177956_o() + 0.5F, (float)p_180439_3_.func_177952_p() + 0.5F));
         }

         this.field_72777_q.field_71452_i.func_180533_a(p_180439_3_, var6.func_176203_a(p_180439_4_ >> 12 & 255));
         break;
      case 2002:
         var7 = (double)p_180439_3_.func_177958_n();
         var9 = (double)p_180439_3_.func_177956_o();
         var11 = (double)p_180439_3_.func_177952_p();

         for(var13 = 0; var13 < 8; ++var13) {
            this.func_174972_a(EnumParticleTypes.ITEM_CRACK, var7, var9, var11, var5.nextGaussian() * 0.15D, var5.nextDouble() * 0.2D, var5.nextGaussian() * 0.15D, new int[]{Item.func_150891_b(Items.field_151068_bn), p_180439_4_});
         }

         var13 = Items.field_151068_bn.func_77620_a(p_180439_4_);
         float var14 = (float)(var13 >> 16 & 255) / 255.0F;
         float var15 = (float)(var13 >> 8 & 255) / 255.0F;
         float var16 = (float)(var13 >> 0 & 255) / 255.0F;
         EnumParticleTypes var17 = EnumParticleTypes.SPELL;
         if(Items.field_151068_bn.func_77833_h(p_180439_4_)) {
            var17 = EnumParticleTypes.SPELL_INSTANT;
         }

         for(var18 = 0; var18 < 100; ++var18) {
            var19 = var5.nextDouble() * 4.0D;
            var21 = var5.nextDouble() * 3.141592653589793D * 2.0D;
            var23 = Math.cos(var21) * var19;
            double var25 = 0.01D + var5.nextDouble() * 0.5D;
            double var27 = Math.sin(var21) * var19;
            EntityFX var29 = this.func_174974_b(var17.func_179348_c(), var17.func_179344_e(), var7 + var23 * 0.1D, var9 + 0.3D, var11 + var27 * 0.1D, var23, var25, var27, new int[0]);
            if(var29 != null) {
               float var30 = 0.75F + var5.nextFloat() * 0.25F;
               var29.func_70538_b(var14 * var30, var15 * var30, var16 * var30);
               var29.func_70543_e((float)var19);
            }
         }

         this.field_72769_h.func_175731_a(p_180439_3_, "game.potion.smash", 1.0F, this.field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F, false);
         break;
      case 2003:
         var7 = (double)p_180439_3_.func_177958_n() + 0.5D;
         var9 = (double)p_180439_3_.func_177956_o();
         var11 = (double)p_180439_3_.func_177952_p() + 0.5D;

         for(var13 = 0; var13 < 8; ++var13) {
            this.func_174972_a(EnumParticleTypes.ITEM_CRACK, var7, var9, var11, var5.nextGaussian() * 0.15D, var5.nextDouble() * 0.2D, var5.nextGaussian() * 0.15D, new int[]{Item.func_150891_b(Items.field_151061_bv)});
         }

         for(var32 = 0.0D; var32 < 6.283185307179586D; var32 += 0.15707963267948966D) {
            this.func_174972_a(EnumParticleTypes.PORTAL, var7 + Math.cos(var32) * 5.0D, var9 - 0.4D, var11 + Math.sin(var32) * 5.0D, Math.cos(var32) * -5.0D, 0.0D, Math.sin(var32) * -5.0D, new int[0]);
            this.func_174972_a(EnumParticleTypes.PORTAL, var7 + Math.cos(var32) * 5.0D, var9 - 0.4D, var11 + Math.sin(var32) * 5.0D, Math.cos(var32) * -7.0D, 0.0D, Math.sin(var32) * -7.0D, new int[0]);
         }

         return;
      case 2004:
         for(var18 = 0; var18 < 20; ++var18) {
            var19 = (double)p_180439_3_.func_177958_n() + 0.5D + ((double)this.field_72769_h.field_73012_v.nextFloat() - 0.5D) * 2.0D;
            var21 = (double)p_180439_3_.func_177956_o() + 0.5D + ((double)this.field_72769_h.field_73012_v.nextFloat() - 0.5D) * 2.0D;
            var23 = (double)p_180439_3_.func_177952_p() + 0.5D + ((double)this.field_72769_h.field_73012_v.nextFloat() - 0.5D) * 2.0D;
            this.field_72769_h.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, var19, var21, var23, 0.0D, 0.0D, 0.0D, new int[0]);
            this.field_72769_h.func_175688_a(EnumParticleTypes.FLAME, var19, var21, var23, 0.0D, 0.0D, 0.0D, new int[0]);
         }

         return;
      case 2005:
         ItemDye.func_180617_a(this.field_72769_h, p_180439_3_, p_180439_4_);
      }

   }

   public void func_180441_b(int p_180441_1_, BlockPos p_180441_2_, int p_180441_3_) {
      if(p_180441_3_ >= 0 && p_180441_3_ < 10) {
         DestroyBlockProgress var4 = (DestroyBlockProgress)this.field_72738_E.get(Integer.valueOf(p_180441_1_));
         if(var4 == null || var4.func_180246_b().func_177958_n() != p_180441_2_.func_177958_n() || var4.func_180246_b().func_177956_o() != p_180441_2_.func_177956_o() || var4.func_180246_b().func_177952_p() != p_180441_2_.func_177952_p()) {
            var4 = new DestroyBlockProgress(p_180441_1_, p_180441_2_);
            this.field_72738_E.put(Integer.valueOf(p_180441_1_), var4);
         }

         var4.func_73107_a(p_180441_3_);
         var4.func_82744_b(this.field_72773_u);
      } else {
         this.field_72738_E.remove(Integer.valueOf(p_180441_1_));
      }

   }

   public void func_174979_m() {
      this.field_147595_R = true;
   }


   class ContainerLocalRenderInformation {

      final RenderChunk field_178036_a;
      final EnumFacing field_178034_b;
      final Set field_178035_c;
      final int field_178032_d;
      private static final String __OBFID = "CL_00002534";


      private ContainerLocalRenderInformation(RenderChunk p_i46248_2_, EnumFacing p_i46248_3_, int p_i46248_4_) {
         this.field_178035_c = EnumSet.noneOf(EnumFacing.class);
         this.field_178036_a = p_i46248_2_;
         this.field_178034_b = p_i46248_3_;
         this.field_178032_d = p_i46248_4_;
      }

      // $FF: synthetic method
      ContainerLocalRenderInformation(RenderChunk p_i46249_2_, EnumFacing p_i46249_3_, int p_i46249_4_, Object p_i46249_5_) {
         this(p_i46249_2_, p_i46249_3_, p_i46249_4_);
      }
   }

   // $FF: synthetic class
   static final class SwitchEnumUseage {

      // $FF: synthetic field
      static final int[] field_178037_a = new int[VertexFormatElement.EnumUseage.values().length];
      private static final String __OBFID = "CL_00002535";


      static {
         try {
            field_178037_a[VertexFormatElement.EnumUseage.POSITION.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_178037_a[VertexFormatElement.EnumUseage.UV.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_178037_a[VertexFormatElement.EnumUseage.COLOR.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
