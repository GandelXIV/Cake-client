package net.minecraft.world;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.IEntitySelector;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.profiler.Profiler;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IntHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ReportedException;
import net.minecraft.util.Vec3;
import net.minecraft.village.VillageCollection;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.Explosion;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.IWorldAccess;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldInfo;

public abstract class World implements IBlockAccess {

   protected boolean field_72999_e;
   public final List field_72996_f = Lists.newArrayList();
   protected final List field_72997_g = Lists.newArrayList();
   public final List field_147482_g = Lists.newArrayList();
   public final List field_175730_i = Lists.newArrayList();
   private final List field_147484_a = Lists.newArrayList();
   private final List field_147483_b = Lists.newArrayList();
   public final List field_73010_i = Lists.newArrayList();
   public final List field_73007_j = Lists.newArrayList();
   protected final IntHashMap field_175729_l = new IntHashMap();
   private long field_73001_c = 16777215L;
   private int field_73008_k;
   protected int field_73005_l = (new Random()).nextInt();
   protected final int field_73006_m = 1013904223;
   protected float field_73003_n;
   protected float field_73004_o;
   protected float field_73018_p;
   protected float field_73017_q;
   private int field_73016_r;
   public final Random field_73012_v = new Random();
   public final WorldProvider field_73011_w;
   protected List field_73021_x = Lists.newArrayList();
   protected IChunkProvider field_73020_y;
   protected final ISaveHandler field_73019_z;
   protected WorldInfo field_72986_A;
   protected boolean field_72987_B;
   protected MapStorage field_72988_C;
   protected VillageCollection field_72982_D;
   public final Profiler field_72984_F;
   private final Calendar field_83016_L = Calendar.getInstance();
   protected Scoreboard field_96442_D = new Scoreboard();
   public final boolean field_72995_K;
   protected Set field_72993_I = Sets.newHashSet();
   private int field_72990_M;
   protected boolean field_72985_G;
   protected boolean field_72992_H;
   private boolean field_147481_N;
   private final WorldBorder field_175728_M;
   int[] field_72994_J;
   private static final String __OBFID = "CL_00000140";


   protected World(ISaveHandler p_i45749_1_, WorldInfo p_i45749_2_, WorldProvider p_i45749_3_, Profiler p_i45749_4_, boolean p_i45749_5_) {
      this.field_72990_M = this.field_73012_v.nextInt(12000);
      this.field_72985_G = true;
      this.field_72992_H = true;
      this.field_72994_J = new int['\u8000'];
      this.field_73019_z = p_i45749_1_;
      this.field_72984_F = p_i45749_4_;
      this.field_72986_A = p_i45749_2_;
      this.field_73011_w = p_i45749_3_;
      this.field_72995_K = p_i45749_5_;
      this.field_175728_M = p_i45749_3_.func_177501_r();
   }

   public World func_175643_b() {
      return this;
   }

   public BiomeGenBase func_180494_b(final BlockPos p_180494_1_) {
      if(this.func_175667_e(p_180494_1_)) {
         Chunk var2 = this.func_175726_f(p_180494_1_);

         try {
            return var2.func_177411_a(p_180494_1_, this.field_73011_w.func_177499_m());
         } catch (Throwable var6) {
            CrashReport var4 = CrashReport.func_85055_a(var6, "Getting biome");
            CrashReportCategory var5 = var4.func_85058_a("Coordinates of biome request");
            var5.func_71500_a("Location", new Callable() {

               private static final String __OBFID = "CL_00000141";

               public String call() {
                  return CrashReportCategory.func_180522_a(p_180494_1_);
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            throw new ReportedException(var4);
         }
      } else {
         return this.field_73011_w.func_177499_m().func_180300_a(p_180494_1_, BiomeGenBase.field_76772_c);
      }
   }

   public WorldChunkManager func_72959_q() {
      return this.field_73011_w.func_177499_m();
   }

   protected abstract IChunkProvider func_72970_h();

   public void func_72963_a(WorldSettings p_72963_1_) {
      this.field_72986_A.func_76091_d(true);
   }

   public void func_72974_f() {
      this.func_175652_B(new BlockPos(8, 64, 8));
   }

   public Block func_175703_c(BlockPos p_175703_1_) {
      BlockPos var2;
      for(var2 = new BlockPos(p_175703_1_.func_177958_n(), 63, p_175703_1_.func_177952_p()); !this.func_175623_d(var2.func_177984_a()); var2 = var2.func_177984_a()) {
         ;
      }

      return this.func_180495_p(var2).func_177230_c();
   }

   private boolean func_175701_a(BlockPos p_175701_1_) {
      return p_175701_1_.func_177958_n() >= -30000000 && p_175701_1_.func_177952_p() >= -30000000 && p_175701_1_.func_177958_n() < 30000000 && p_175701_1_.func_177952_p() < 30000000 && p_175701_1_.func_177956_o() >= 0 && p_175701_1_.func_177956_o() < 256;
   }

   public boolean func_175623_d(BlockPos p_175623_1_) {
      return this.func_180495_p(p_175623_1_).func_177230_c().func_149688_o() == Material.field_151579_a;
   }

   public boolean func_175667_e(BlockPos p_175667_1_) {
      return this.func_175668_a(p_175667_1_, true);
   }

   public boolean func_175668_a(BlockPos p_175668_1_, boolean p_175668_2_) {
      return !this.func_175701_a(p_175668_1_)?false:this.func_175680_a(p_175668_1_.func_177958_n() >> 4, p_175668_1_.func_177952_p() >> 4, p_175668_2_);
   }

   public boolean func_175697_a(BlockPos p_175697_1_, int p_175697_2_) {
      return this.func_175648_a(p_175697_1_, p_175697_2_, true);
   }

   public boolean func_175648_a(BlockPos p_175648_1_, int p_175648_2_, boolean p_175648_3_) {
      return this.func_175663_a(p_175648_1_.func_177958_n() - p_175648_2_, p_175648_1_.func_177956_o() - p_175648_2_, p_175648_1_.func_177952_p() - p_175648_2_, p_175648_1_.func_177958_n() + p_175648_2_, p_175648_1_.func_177956_o() + p_175648_2_, p_175648_1_.func_177952_p() + p_175648_2_, p_175648_3_);
   }

   public boolean func_175707_a(BlockPos p_175707_1_, BlockPos p_175707_2_) {
      return this.func_175706_a(p_175707_1_, p_175707_2_, true);
   }

   public boolean func_175706_a(BlockPos p_175706_1_, BlockPos p_175706_2_, boolean p_175706_3_) {
      return this.func_175663_a(p_175706_1_.func_177958_n(), p_175706_1_.func_177956_o(), p_175706_1_.func_177952_p(), p_175706_2_.func_177958_n(), p_175706_2_.func_177956_o(), p_175706_2_.func_177952_p(), p_175706_3_);
   }

   public boolean func_175711_a(StructureBoundingBox p_175711_1_) {
      return this.func_175639_b(p_175711_1_, true);
   }

   public boolean func_175639_b(StructureBoundingBox p_175639_1_, boolean p_175639_2_) {
      return this.func_175663_a(p_175639_1_.field_78897_a, p_175639_1_.field_78895_b, p_175639_1_.field_78896_c, p_175639_1_.field_78893_d, p_175639_1_.field_78894_e, p_175639_1_.field_78892_f, p_175639_2_);
   }

   private boolean func_175663_a(int p_175663_1_, int p_175663_2_, int p_175663_3_, int p_175663_4_, int p_175663_5_, int p_175663_6_, boolean p_175663_7_) {
      if(p_175663_5_ >= 0 && p_175663_2_ < 256) {
         p_175663_1_ >>= 4;
         p_175663_3_ >>= 4;
         p_175663_4_ >>= 4;
         p_175663_6_ >>= 4;

         for(int var8 = p_175663_1_; var8 <= p_175663_4_; ++var8) {
            for(int var9 = p_175663_3_; var9 <= p_175663_6_; ++var9) {
               if(!this.func_175680_a(var8, var9, p_175663_7_)) {
                  return false;
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   protected boolean func_175680_a(int p_175680_1_, int p_175680_2_, boolean p_175680_3_) {
      return this.field_73020_y.func_73149_a(p_175680_1_, p_175680_2_) && (p_175680_3_ || !this.field_73020_y.func_73154_d(p_175680_1_, p_175680_2_).func_76621_g());
   }

   public Chunk func_175726_f(BlockPos p_175726_1_) {
      return this.func_72964_e(p_175726_1_.func_177958_n() >> 4, p_175726_1_.func_177952_p() >> 4);
   }

   public Chunk func_72964_e(int p_72964_1_, int p_72964_2_) {
      return this.field_73020_y.func_73154_d(p_72964_1_, p_72964_2_);
   }

   public boolean func_180501_a(BlockPos p_180501_1_, IBlockState p_180501_2_, int p_180501_3_) {
      if(!this.func_175701_a(p_180501_1_)) {
         return false;
      } else if(!this.field_72995_K && this.field_72986_A.func_76067_t() == WorldType.field_180272_g) {
         return false;
      } else {
         Chunk var4 = this.func_175726_f(p_180501_1_);
         Block var5 = p_180501_2_.func_177230_c();
         IBlockState var6 = var4.func_177436_a(p_180501_1_, p_180501_2_);
         if(var6 == null) {
            return false;
         } else {
            Block var7 = var6.func_177230_c();
            if(var5.func_149717_k() != var7.func_149717_k() || var5.func_149750_m() != var7.func_149750_m()) {
               this.field_72984_F.func_76320_a("checkLight");
               this.func_175664_x(p_180501_1_);
               this.field_72984_F.func_76319_b();
            }

            if((p_180501_3_ & 2) != 0 && (!this.field_72995_K || (p_180501_3_ & 4) == 0) && var4.func_150802_k()) {
               this.func_175689_h(p_180501_1_);
            }

            if(!this.field_72995_K && (p_180501_3_ & 1) != 0) {
               this.func_175722_b(p_180501_1_, var6.func_177230_c());
               if(var5.func_149740_M()) {
                  this.func_175666_e(p_180501_1_, var5);
               }
            }

            return true;
         }
      }
   }

   public boolean func_175698_g(BlockPos p_175698_1_) {
      return this.func_180501_a(p_175698_1_, Blocks.field_150350_a.func_176223_P(), 3);
   }

   public boolean func_175655_b(BlockPos p_175655_1_, boolean p_175655_2_) {
      IBlockState var3 = this.func_180495_p(p_175655_1_);
      Block var4 = var3.func_177230_c();
      if(var4.func_149688_o() == Material.field_151579_a) {
         return false;
      } else {
         this.func_175718_b(2001, p_175655_1_, Block.func_176210_f(var3));
         if(p_175655_2_) {
            var4.func_176226_b(this, p_175655_1_, var3, 0);
         }

         return this.func_180501_a(p_175655_1_, Blocks.field_150350_a.func_176223_P(), 3);
      }
   }

   public boolean func_175656_a(BlockPos p_175656_1_, IBlockState p_175656_2_) {
      return this.func_180501_a(p_175656_1_, p_175656_2_, 3);
   }

   public void func_175689_h(BlockPos p_175689_1_) {
      for(int var2 = 0; var2 < this.field_73021_x.size(); ++var2) {
         ((IWorldAccess)this.field_73021_x.get(var2)).func_174960_a(p_175689_1_);
      }

   }

   public void func_175722_b(BlockPos p_175722_1_, Block p_175722_2_) {
      if(this.field_72986_A.func_76067_t() != WorldType.field_180272_g) {
         this.func_175685_c(p_175722_1_, p_175722_2_);
      }

   }

   public void func_72975_g(int p_72975_1_, int p_72975_2_, int p_72975_3_, int p_72975_4_) {
      int var5;
      if(p_72975_3_ > p_72975_4_) {
         var5 = p_72975_4_;
         p_72975_4_ = p_72975_3_;
         p_72975_3_ = var5;
      }

      if(!this.field_73011_w.func_177495_o()) {
         for(var5 = p_72975_3_; var5 <= p_72975_4_; ++var5) {
            this.func_180500_c(EnumSkyBlock.SKY, new BlockPos(p_72975_1_, var5, p_72975_2_));
         }
      }

      this.func_147458_c(p_72975_1_, p_72975_3_, p_72975_2_, p_72975_1_, p_72975_4_, p_72975_2_);
   }

   public void func_175704_b(BlockPos p_175704_1_, BlockPos p_175704_2_) {
      this.func_147458_c(p_175704_1_.func_177958_n(), p_175704_1_.func_177956_o(), p_175704_1_.func_177952_p(), p_175704_2_.func_177958_n(), p_175704_2_.func_177956_o(), p_175704_2_.func_177952_p());
   }

   public void func_147458_c(int p_147458_1_, int p_147458_2_, int p_147458_3_, int p_147458_4_, int p_147458_5_, int p_147458_6_) {
      for(int var7 = 0; var7 < this.field_73021_x.size(); ++var7) {
         ((IWorldAccess)this.field_73021_x.get(var7)).func_147585_a(p_147458_1_, p_147458_2_, p_147458_3_, p_147458_4_, p_147458_5_, p_147458_6_);
      }

   }

   public void func_175685_c(BlockPos p_175685_1_, Block p_175685_2_) {
      this.func_180496_d(p_175685_1_.func_177976_e(), p_175685_2_);
      this.func_180496_d(p_175685_1_.func_177974_f(), p_175685_2_);
      this.func_180496_d(p_175685_1_.func_177977_b(), p_175685_2_);
      this.func_180496_d(p_175685_1_.func_177984_a(), p_175685_2_);
      this.func_180496_d(p_175685_1_.func_177978_c(), p_175685_2_);
      this.func_180496_d(p_175685_1_.func_177968_d(), p_175685_2_);
   }

   public void func_175695_a(BlockPos p_175695_1_, Block p_175695_2_, EnumFacing p_175695_3_) {
      if(p_175695_3_ != EnumFacing.WEST) {
         this.func_180496_d(p_175695_1_.func_177976_e(), p_175695_2_);
      }

      if(p_175695_3_ != EnumFacing.EAST) {
         this.func_180496_d(p_175695_1_.func_177974_f(), p_175695_2_);
      }

      if(p_175695_3_ != EnumFacing.DOWN) {
         this.func_180496_d(p_175695_1_.func_177977_b(), p_175695_2_);
      }

      if(p_175695_3_ != EnumFacing.UP) {
         this.func_180496_d(p_175695_1_.func_177984_a(), p_175695_2_);
      }

      if(p_175695_3_ != EnumFacing.NORTH) {
         this.func_180496_d(p_175695_1_.func_177978_c(), p_175695_2_);
      }

      if(p_175695_3_ != EnumFacing.SOUTH) {
         this.func_180496_d(p_175695_1_.func_177968_d(), p_175695_2_);
      }

   }

   public void func_180496_d(BlockPos p_180496_1_, final Block p_180496_2_) {
      if(!this.field_72995_K) {
         IBlockState var3 = this.func_180495_p(p_180496_1_);

         try {
            var3.func_177230_c().func_176204_a(this, p_180496_1_, var3, p_180496_2_);
         } catch (Throwable var7) {
            CrashReport var5 = CrashReport.func_85055_a(var7, "Exception while updating neighbours");
            CrashReportCategory var6 = var5.func_85058_a("Block being updated");
            var6.func_71500_a("Source block type", new Callable() {

               private static final String __OBFID = "CL_00000142";

               public String call() {
                  try {
                     return String.format("ID #%d (%s // %s)", new Object[]{Integer.valueOf(Block.func_149682_b(p_180496_2_)), p_180496_2_.func_149739_a(), p_180496_2_.getClass().getCanonicalName()});
                  } catch (Throwable var2) {
                     return "ID #" + Block.func_149682_b(p_180496_2_);
                  }
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            CrashReportCategory.func_175750_a(var6, p_180496_1_, var3);
            throw new ReportedException(var5);
         }
      }
   }

   public boolean func_175691_a(BlockPos p_175691_1_, Block p_175691_2_) {
      return false;
   }

   public boolean func_175678_i(BlockPos p_175678_1_) {
      return this.func_175726_f(p_175678_1_).func_177444_d(p_175678_1_);
   }

   public boolean func_175710_j(BlockPos p_175710_1_) {
      if(p_175710_1_.func_177956_o() >= 63) {
         return this.func_175678_i(p_175710_1_);
      } else {
         BlockPos var2 = new BlockPos(p_175710_1_.func_177958_n(), 63, p_175710_1_.func_177952_p());
         if(!this.func_175678_i(var2)) {
            return false;
         } else {
            for(var2 = var2.func_177977_b(); var2.func_177956_o() > p_175710_1_.func_177956_o(); var2 = var2.func_177977_b()) {
               Block var3 = this.func_180495_p(var2).func_177230_c();
               if(var3.func_149717_k() > 0 && !var3.func_149688_o().func_76224_d()) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   public int func_175699_k(BlockPos p_175699_1_) {
      if(p_175699_1_.func_177956_o() < 0) {
         return 0;
      } else {
         if(p_175699_1_.func_177956_o() >= 256) {
            p_175699_1_ = new BlockPos(p_175699_1_.func_177958_n(), 255, p_175699_1_.func_177952_p());
         }

         return this.func_175726_f(p_175699_1_).func_177443_a(p_175699_1_, 0);
      }
   }

   public int func_175671_l(BlockPos p_175671_1_) {
      return this.func_175721_c(p_175671_1_, true);
   }

   public int func_175721_c(BlockPos p_175721_1_, boolean p_175721_2_) {
      if(p_175721_1_.func_177958_n() >= -30000000 && p_175721_1_.func_177952_p() >= -30000000 && p_175721_1_.func_177958_n() < 30000000 && p_175721_1_.func_177952_p() < 30000000) {
         if(p_175721_2_ && this.func_180495_p(p_175721_1_).func_177230_c().func_149710_n()) {
            int var8 = this.func_175721_c(p_175721_1_.func_177984_a(), false);
            int var4 = this.func_175721_c(p_175721_1_.func_177974_f(), false);
            int var5 = this.func_175721_c(p_175721_1_.func_177976_e(), false);
            int var6 = this.func_175721_c(p_175721_1_.func_177968_d(), false);
            int var7 = this.func_175721_c(p_175721_1_.func_177978_c(), false);
            if(var4 > var8) {
               var8 = var4;
            }

            if(var5 > var8) {
               var8 = var5;
            }

            if(var6 > var8) {
               var8 = var6;
            }

            if(var7 > var8) {
               var8 = var7;
            }

            return var8;
         } else if(p_175721_1_.func_177956_o() < 0) {
            return 0;
         } else {
            if(p_175721_1_.func_177956_o() >= 256) {
               p_175721_1_ = new BlockPos(p_175721_1_.func_177958_n(), 255, p_175721_1_.func_177952_p());
            }

            Chunk var3 = this.func_175726_f(p_175721_1_);
            return var3.func_177443_a(p_175721_1_, this.field_73008_k);
         }
      } else {
         return 15;
      }
   }

   public BlockPos func_175645_m(BlockPos p_175645_1_) {
      int var2;
      if(p_175645_1_.func_177958_n() >= -30000000 && p_175645_1_.func_177952_p() >= -30000000 && p_175645_1_.func_177958_n() < 30000000 && p_175645_1_.func_177952_p() < 30000000) {
         if(this.func_175680_a(p_175645_1_.func_177958_n() >> 4, p_175645_1_.func_177952_p() >> 4, true)) {
            var2 = this.func_72964_e(p_175645_1_.func_177958_n() >> 4, p_175645_1_.func_177952_p() >> 4).func_76611_b(p_175645_1_.func_177958_n() & 15, p_175645_1_.func_177952_p() & 15);
         } else {
            var2 = 0;
         }
      } else {
         var2 = 64;
      }

      return new BlockPos(p_175645_1_.func_177958_n(), var2, p_175645_1_.func_177952_p());
   }

   public int func_82734_g(int p_82734_1_, int p_82734_2_) {
      if(p_82734_1_ >= -30000000 && p_82734_2_ >= -30000000 && p_82734_1_ < 30000000 && p_82734_2_ < 30000000) {
         if(!this.func_175680_a(p_82734_1_ >> 4, p_82734_2_ >> 4, true)) {
            return 0;
         } else {
            Chunk var3 = this.func_72964_e(p_82734_1_ >> 4, p_82734_2_ >> 4);
            return var3.func_177442_v();
         }
      } else {
         return 64;
      }
   }

   public int func_175705_a(EnumSkyBlock p_175705_1_, BlockPos p_175705_2_) {
      if(this.field_73011_w.func_177495_o() && p_175705_1_ == EnumSkyBlock.SKY) {
         return 0;
      } else {
         if(p_175705_2_.func_177956_o() < 0) {
            p_175705_2_ = new BlockPos(p_175705_2_.func_177958_n(), 0, p_175705_2_.func_177952_p());
         }

         if(!this.func_175701_a(p_175705_2_)) {
            return p_175705_1_.field_77198_c;
         } else if(!this.func_175667_e(p_175705_2_)) {
            return p_175705_1_.field_77198_c;
         } else if(this.func_180495_p(p_175705_2_).func_177230_c().func_149710_n()) {
            int var8 = this.func_175642_b(p_175705_1_, p_175705_2_.func_177984_a());
            int var4 = this.func_175642_b(p_175705_1_, p_175705_2_.func_177974_f());
            int var5 = this.func_175642_b(p_175705_1_, p_175705_2_.func_177976_e());
            int var6 = this.func_175642_b(p_175705_1_, p_175705_2_.func_177968_d());
            int var7 = this.func_175642_b(p_175705_1_, p_175705_2_.func_177978_c());
            if(var4 > var8) {
               var8 = var4;
            }

            if(var5 > var8) {
               var8 = var5;
            }

            if(var6 > var8) {
               var8 = var6;
            }

            if(var7 > var8) {
               var8 = var7;
            }

            return var8;
         } else {
            Chunk var3 = this.func_175726_f(p_175705_2_);
            return var3.func_177413_a(p_175705_1_, p_175705_2_);
         }
      }
   }

   public int func_175642_b(EnumSkyBlock p_175642_1_, BlockPos p_175642_2_) {
      if(p_175642_2_.func_177956_o() < 0) {
         p_175642_2_ = new BlockPos(p_175642_2_.func_177958_n(), 0, p_175642_2_.func_177952_p());
      }

      if(!this.func_175701_a(p_175642_2_)) {
         return p_175642_1_.field_77198_c;
      } else if(!this.func_175667_e(p_175642_2_)) {
         return p_175642_1_.field_77198_c;
      } else {
         Chunk var3 = this.func_175726_f(p_175642_2_);
         return var3.func_177413_a(p_175642_1_, p_175642_2_);
      }
   }

   public void func_175653_a(EnumSkyBlock p_175653_1_, BlockPos p_175653_2_, int p_175653_3_) {
      if(this.func_175701_a(p_175653_2_)) {
         if(this.func_175667_e(p_175653_2_)) {
            Chunk var4 = this.func_175726_f(p_175653_2_);
            var4.func_177431_a(p_175653_1_, p_175653_2_, p_175653_3_);
            this.func_175679_n(p_175653_2_);
         }
      }
   }

   public void func_175679_n(BlockPos p_175679_1_) {
      for(int var2 = 0; var2 < this.field_73021_x.size(); ++var2) {
         ((IWorldAccess)this.field_73021_x.get(var2)).func_174959_b(p_175679_1_);
      }

   }

   public int func_175626_b(BlockPos p_175626_1_, int p_175626_2_) {
      int var3 = this.func_175705_a(EnumSkyBlock.SKY, p_175626_1_);
      int var4 = this.func_175705_a(EnumSkyBlock.BLOCK, p_175626_1_);
      if(var4 < p_175626_2_) {
         var4 = p_175626_2_;
      }

      return var3 << 20 | var4 << 4;
   }

   public float func_175724_o(BlockPos p_175724_1_) {
      return this.field_73011_w.func_177497_p()[this.func_175671_l(p_175724_1_)];
   }

   public IBlockState func_180495_p(BlockPos p_180495_1_) {
      if(!this.func_175701_a(p_180495_1_)) {
         return Blocks.field_150350_a.func_176223_P();
      } else {
         Chunk var2 = this.func_175726_f(p_180495_1_);
         return var2.func_177435_g(p_180495_1_);
      }
   }

   public boolean func_72935_r() {
      return this.field_73008_k < 4;
   }

   public MovingObjectPosition func_72933_a(Vec3 p_72933_1_, Vec3 p_72933_2_) {
      return this.func_147447_a(p_72933_1_, p_72933_2_, false, false, false);
   }

   public MovingObjectPosition func_72901_a(Vec3 p_72901_1_, Vec3 p_72901_2_, boolean p_72901_3_) {
      return this.func_147447_a(p_72901_1_, p_72901_2_, p_72901_3_, false, false);
   }

   public MovingObjectPosition func_147447_a(Vec3 p_147447_1_, Vec3 p_147447_2_, boolean p_147447_3_, boolean p_147447_4_, boolean p_147447_5_) {
      if(!Double.isNaN(p_147447_1_.field_72450_a) && !Double.isNaN(p_147447_1_.field_72448_b) && !Double.isNaN(p_147447_1_.field_72449_c)) {
         if(!Double.isNaN(p_147447_2_.field_72450_a) && !Double.isNaN(p_147447_2_.field_72448_b) && !Double.isNaN(p_147447_2_.field_72449_c)) {
            int var6 = MathHelper.func_76128_c(p_147447_2_.field_72450_a);
            int var7 = MathHelper.func_76128_c(p_147447_2_.field_72448_b);
            int var8 = MathHelper.func_76128_c(p_147447_2_.field_72449_c);
            int var9 = MathHelper.func_76128_c(p_147447_1_.field_72450_a);
            int var10 = MathHelper.func_76128_c(p_147447_1_.field_72448_b);
            int var11 = MathHelper.func_76128_c(p_147447_1_.field_72449_c);
            BlockPos var12 = new BlockPos(var9, var10, var11);
            new BlockPos(var6, var7, var8);
            IBlockState var14 = this.func_180495_p(var12);
            Block var15 = var14.func_177230_c();
            if((!p_147447_4_ || var15.func_180640_a(this, var12, var14) != null) && var15.func_176209_a(var14, p_147447_3_)) {
               MovingObjectPosition var16 = var15.func_180636_a(this, var12, p_147447_1_, p_147447_2_);
               if(var16 != null) {
                  return var16;
               }
            }

            MovingObjectPosition var41 = null;
            int var42 = 200;

            while(var42-- >= 0) {
               if(Double.isNaN(p_147447_1_.field_72450_a) || Double.isNaN(p_147447_1_.field_72448_b) || Double.isNaN(p_147447_1_.field_72449_c)) {
                  return null;
               }

               if(var9 == var6 && var10 == var7 && var11 == var8) {
                  return p_147447_5_?var41:null;
               }

               boolean var43 = true;
               boolean var17 = true;
               boolean var18 = true;
               double var19 = 999.0D;
               double var21 = 999.0D;
               double var23 = 999.0D;
               if(var6 > var9) {
                  var19 = (double)var9 + 1.0D;
               } else if(var6 < var9) {
                  var19 = (double)var9 + 0.0D;
               } else {
                  var43 = false;
               }

               if(var7 > var10) {
                  var21 = (double)var10 + 1.0D;
               } else if(var7 < var10) {
                  var21 = (double)var10 + 0.0D;
               } else {
                  var17 = false;
               }

               if(var8 > var11) {
                  var23 = (double)var11 + 1.0D;
               } else if(var8 < var11) {
                  var23 = (double)var11 + 0.0D;
               } else {
                  var18 = false;
               }

               double var25 = 999.0D;
               double var27 = 999.0D;
               double var29 = 999.0D;
               double var31 = p_147447_2_.field_72450_a - p_147447_1_.field_72450_a;
               double var33 = p_147447_2_.field_72448_b - p_147447_1_.field_72448_b;
               double var35 = p_147447_2_.field_72449_c - p_147447_1_.field_72449_c;
               if(var43) {
                  var25 = (var19 - p_147447_1_.field_72450_a) / var31;
               }

               if(var17) {
                  var27 = (var21 - p_147447_1_.field_72448_b) / var33;
               }

               if(var18) {
                  var29 = (var23 - p_147447_1_.field_72449_c) / var35;
               }

               if(var25 == -0.0D) {
                  var25 = -1.0E-4D;
               }

               if(var27 == -0.0D) {
                  var27 = -1.0E-4D;
               }

               if(var29 == -0.0D) {
                  var29 = -1.0E-4D;
               }

               EnumFacing var37;
               if(var25 < var27 && var25 < var29) {
                  var37 = var6 > var9?EnumFacing.WEST:EnumFacing.EAST;
                  p_147447_1_ = new Vec3(var19, p_147447_1_.field_72448_b + var33 * var25, p_147447_1_.field_72449_c + var35 * var25);
               } else if(var27 < var29) {
                  var37 = var7 > var10?EnumFacing.DOWN:EnumFacing.UP;
                  p_147447_1_ = new Vec3(p_147447_1_.field_72450_a + var31 * var27, var21, p_147447_1_.field_72449_c + var35 * var27);
               } else {
                  var37 = var8 > var11?EnumFacing.NORTH:EnumFacing.SOUTH;
                  p_147447_1_ = new Vec3(p_147447_1_.field_72450_a + var31 * var29, p_147447_1_.field_72448_b + var33 * var29, var23);
               }

               var9 = MathHelper.func_76128_c(p_147447_1_.field_72450_a) - (var37 == EnumFacing.EAST?1:0);
               var10 = MathHelper.func_76128_c(p_147447_1_.field_72448_b) - (var37 == EnumFacing.UP?1:0);
               var11 = MathHelper.func_76128_c(p_147447_1_.field_72449_c) - (var37 == EnumFacing.SOUTH?1:0);
               var12 = new BlockPos(var9, var10, var11);
               IBlockState var38 = this.func_180495_p(var12);
               Block var39 = var38.func_177230_c();
               if(!p_147447_4_ || var39.func_180640_a(this, var12, var38) != null) {
                  if(var39.func_176209_a(var38, p_147447_3_)) {
                     MovingObjectPosition var40 = var39.func_180636_a(this, var12, p_147447_1_, p_147447_2_);
                     if(var40 != null) {
                        return var40;
                     }
                  } else {
                     var41 = new MovingObjectPosition(MovingObjectPosition.MovingObjectType.MISS, p_147447_1_, var37, var12);
                  }
               }
            }

            return p_147447_5_?var41:null;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   public void func_72956_a(Entity p_72956_1_, String p_72956_2_, float p_72956_3_, float p_72956_4_) {
      for(int var5 = 0; var5 < this.field_73021_x.size(); ++var5) {
         ((IWorldAccess)this.field_73021_x.get(var5)).func_72704_a(p_72956_2_, p_72956_1_.field_70165_t, p_72956_1_.field_70163_u, p_72956_1_.field_70161_v, p_72956_3_, p_72956_4_);
      }

   }

   public void func_85173_a(EntityPlayer p_85173_1_, String p_85173_2_, float p_85173_3_, float p_85173_4_) {
      for(int var5 = 0; var5 < this.field_73021_x.size(); ++var5) {
         ((IWorldAccess)this.field_73021_x.get(var5)).func_85102_a(p_85173_1_, p_85173_2_, p_85173_1_.field_70165_t, p_85173_1_.field_70163_u, p_85173_1_.field_70161_v, p_85173_3_, p_85173_4_);
      }

   }

   public void func_72908_a(double p_72908_1_, double p_72908_3_, double p_72908_5_, String p_72908_7_, float p_72908_8_, float p_72908_9_) {
      for(int var10 = 0; var10 < this.field_73021_x.size(); ++var10) {
         ((IWorldAccess)this.field_73021_x.get(var10)).func_72704_a(p_72908_7_, p_72908_1_, p_72908_3_, p_72908_5_, p_72908_8_, p_72908_9_);
      }

   }

   public void func_72980_b(double p_72980_1_, double p_72980_3_, double p_72980_5_, String p_72980_7_, float p_72980_8_, float p_72980_9_, boolean p_72980_10_) {}

   public void func_175717_a(BlockPos p_175717_1_, String p_175717_2_) {
      for(int var3 = 0; var3 < this.field_73021_x.size(); ++var3) {
         ((IWorldAccess)this.field_73021_x.get(var3)).func_174961_a(p_175717_2_, p_175717_1_);
      }

   }

   public void func_175688_a(EnumParticleTypes p_175688_1_, double p_175688_2_, double p_175688_4_, double p_175688_6_, double p_175688_8_, double p_175688_10_, double p_175688_12_, int ... p_175688_14_) {
      this.func_175720_a(p_175688_1_.func_179348_c(), p_175688_1_.func_179344_e(), p_175688_2_, p_175688_4_, p_175688_6_, p_175688_8_, p_175688_10_, p_175688_12_, p_175688_14_);
   }

   public void func_175682_a(EnumParticleTypes p_175682_1_, boolean p_175682_2_, double p_175682_3_, double p_175682_5_, double p_175682_7_, double p_175682_9_, double p_175682_11_, double p_175682_13_, int ... p_175682_15_) {
      this.func_175720_a(p_175682_1_.func_179348_c(), p_175682_1_.func_179344_e() | p_175682_2_, p_175682_3_, p_175682_5_, p_175682_7_, p_175682_9_, p_175682_11_, p_175682_13_, p_175682_15_);
   }

   private void func_175720_a(int p_175720_1_, boolean p_175720_2_, double p_175720_3_, double p_175720_5_, double p_175720_7_, double p_175720_9_, double p_175720_11_, double p_175720_13_, int ... p_175720_15_) {
      for(int var16 = 0; var16 < this.field_73021_x.size(); ++var16) {
         ((IWorldAccess)this.field_73021_x.get(var16)).func_180442_a(p_175720_1_, p_175720_2_, p_175720_3_, p_175720_5_, p_175720_7_, p_175720_9_, p_175720_11_, p_175720_13_, p_175720_15_);
      }

   }

   public boolean func_72942_c(Entity p_72942_1_) {
      this.field_73007_j.add(p_72942_1_);
      return true;
   }

   public boolean func_72838_d(Entity p_72838_1_) {
      int var2 = MathHelper.func_76128_c(p_72838_1_.field_70165_t / 16.0D);
      int var3 = MathHelper.func_76128_c(p_72838_1_.field_70161_v / 16.0D);
      boolean var4 = p_72838_1_.field_98038_p;
      if(p_72838_1_ instanceof EntityPlayer) {
         var4 = true;
      }

      if(!var4 && !this.func_175680_a(var2, var3, true)) {
         return false;
      } else {
         if(p_72838_1_ instanceof EntityPlayer) {
            EntityPlayer var5 = (EntityPlayer)p_72838_1_;
            this.field_73010_i.add(var5);
            this.func_72854_c();
         }

         this.func_72964_e(var2, var3).func_76612_a(p_72838_1_);
         this.field_72996_f.add(p_72838_1_);
         this.func_72923_a(p_72838_1_);
         return true;
      }
   }

   protected void func_72923_a(Entity p_72923_1_) {
      for(int var2 = 0; var2 < this.field_73021_x.size(); ++var2) {
         ((IWorldAccess)this.field_73021_x.get(var2)).func_72703_a(p_72923_1_);
      }

   }

   protected void func_72847_b(Entity p_72847_1_) {
      for(int var2 = 0; var2 < this.field_73021_x.size(); ++var2) {
         ((IWorldAccess)this.field_73021_x.get(var2)).func_72709_b(p_72847_1_);
      }

   }

   public void func_72900_e(Entity p_72900_1_) {
      if(p_72900_1_.field_70153_n != null) {
         p_72900_1_.field_70153_n.func_70078_a((Entity)null);
      }

      if(p_72900_1_.field_70154_o != null) {
         p_72900_1_.func_70078_a((Entity)null);
      }

      p_72900_1_.func_70106_y();
      if(p_72900_1_ instanceof EntityPlayer) {
         this.field_73010_i.remove(p_72900_1_);
         this.func_72854_c();
         this.func_72847_b(p_72900_1_);
      }

   }

   public void func_72973_f(Entity p_72973_1_) {
      p_72973_1_.func_70106_y();
      if(p_72973_1_ instanceof EntityPlayer) {
         this.field_73010_i.remove(p_72973_1_);
         this.func_72854_c();
      }

      int var2 = p_72973_1_.field_70176_ah;
      int var3 = p_72973_1_.field_70164_aj;
      if(p_72973_1_.field_70175_ag && this.func_175680_a(var2, var3, true)) {
         this.func_72964_e(var2, var3).func_76622_b(p_72973_1_);
      }

      this.field_72996_f.remove(p_72973_1_);
      this.func_72847_b(p_72973_1_);
   }

   public void func_72954_a(IWorldAccess p_72954_1_) {
      this.field_73021_x.add(p_72954_1_);
   }

   public void func_72848_b(IWorldAccess p_72848_1_) {
      this.field_73021_x.remove(p_72848_1_);
   }

   public List func_72945_a(Entity p_72945_1_, AxisAlignedBB p_72945_2_) {
      ArrayList var3 = Lists.newArrayList();
      int var4 = MathHelper.func_76128_c(p_72945_2_.field_72340_a);
      int var5 = MathHelper.func_76128_c(p_72945_2_.field_72336_d + 1.0D);
      int var6 = MathHelper.func_76128_c(p_72945_2_.field_72338_b);
      int var7 = MathHelper.func_76128_c(p_72945_2_.field_72337_e + 1.0D);
      int var8 = MathHelper.func_76128_c(p_72945_2_.field_72339_c);
      int var9 = MathHelper.func_76128_c(p_72945_2_.field_72334_f + 1.0D);

      for(int var10 = var4; var10 < var5; ++var10) {
         for(int var11 = var8; var11 < var9; ++var11) {
            if(this.func_175667_e(new BlockPos(var10, 64, var11))) {
               for(int var12 = var6 - 1; var12 < var7; ++var12) {
                  BlockPos var13 = new BlockPos(var10, var12, var11);
                  boolean var14 = p_72945_1_.func_174832_aS();
                  boolean var15 = this.func_175673_a(this.func_175723_af(), p_72945_1_);
                  if(var14 && var15) {
                     p_72945_1_.func_174821_h(false);
                  } else if(!var14 && !var15) {
                     p_72945_1_.func_174821_h(true);
                  }

                  IBlockState var16;
                  if(!this.func_175723_af().func_177746_a(var13) && var15) {
                     var16 = Blocks.field_150348_b.func_176223_P();
                  } else {
                     var16 = this.func_180495_p(var13);
                  }

                  var16.func_177230_c().func_180638_a(this, var13, var16, p_72945_2_, var3, p_72945_1_);
               }
            }
         }
      }

      double var17 = 0.25D;
      List var18 = this.func_72839_b(p_72945_1_, p_72945_2_.func_72314_b(var17, var17, var17));

      for(int var19 = 0; var19 < var18.size(); ++var19) {
         if(p_72945_1_.field_70153_n != var18 && p_72945_1_.field_70154_o != var18) {
            AxisAlignedBB var20 = ((Entity)var18.get(var19)).func_70046_E();
            if(var20 != null && var20.func_72326_a(p_72945_2_)) {
               var3.add(var20);
            }

            var20 = p_72945_1_.func_70114_g((Entity)var18.get(var19));
            if(var20 != null && var20.func_72326_a(p_72945_2_)) {
               var3.add(var20);
            }
         }
      }

      return var3;
   }

   public boolean func_175673_a(WorldBorder p_175673_1_, Entity p_175673_2_) {
      double var3 = p_175673_1_.func_177726_b();
      double var5 = p_175673_1_.func_177736_c();
      double var7 = p_175673_1_.func_177728_d();
      double var9 = p_175673_1_.func_177733_e();
      if(p_175673_2_.func_174832_aS()) {
         ++var3;
         ++var5;
         --var7;
         --var9;
      } else {
         --var3;
         --var5;
         ++var7;
         ++var9;
      }

      return p_175673_2_.field_70165_t > var3 && p_175673_2_.field_70165_t < var7 && p_175673_2_.field_70161_v > var5 && p_175673_2_.field_70161_v < var9;
   }

   public List func_147461_a(AxisAlignedBB p_147461_1_) {
      ArrayList var2 = Lists.newArrayList();
      int var3 = MathHelper.func_76128_c(p_147461_1_.field_72340_a);
      int var4 = MathHelper.func_76128_c(p_147461_1_.field_72336_d + 1.0D);
      int var5 = MathHelper.func_76128_c(p_147461_1_.field_72338_b);
      int var6 = MathHelper.func_76128_c(p_147461_1_.field_72337_e + 1.0D);
      int var7 = MathHelper.func_76128_c(p_147461_1_.field_72339_c);
      int var8 = MathHelper.func_76128_c(p_147461_1_.field_72334_f + 1.0D);

      for(int var9 = var3; var9 < var4; ++var9) {
         for(int var10 = var7; var10 < var8; ++var10) {
            if(this.func_175667_e(new BlockPos(var9, 64, var10))) {
               for(int var11 = var5 - 1; var11 < var6; ++var11) {
                  BlockPos var13 = new BlockPos(var9, var11, var10);
                  IBlockState var12;
                  if(var9 >= -30000000 && var9 < 30000000 && var10 >= -30000000 && var10 < 30000000) {
                     var12 = this.func_180495_p(var13);
                  } else {
                     var12 = Blocks.field_150357_h.func_176223_P();
                  }

                  var12.func_177230_c().func_180638_a(this, var13, var12, p_147461_1_, var2, (Entity)null);
               }
            }
         }
      }

      return var2;
   }

   public int func_72967_a(float p_72967_1_) {
      float var2 = this.func_72826_c(p_72967_1_);
      float var3 = 1.0F - (MathHelper.func_76134_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.5F);
      var3 = MathHelper.func_76131_a(var3, 0.0F, 1.0F);
      var3 = 1.0F - var3;
      var3 = (float)((double)var3 * (1.0D - (double)(this.func_72867_j(p_72967_1_) * 5.0F) / 16.0D));
      var3 = (float)((double)var3 * (1.0D - (double)(this.func_72819_i(p_72967_1_) * 5.0F) / 16.0D));
      var3 = 1.0F - var3;
      return (int)(var3 * 11.0F);
   }

   public float func_72971_b(float p_72971_1_) {
      float var2 = this.func_72826_c(p_72971_1_);
      float var3 = 1.0F - (MathHelper.func_76134_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.2F);
      var3 = MathHelper.func_76131_a(var3, 0.0F, 1.0F);
      var3 = 1.0F - var3;
      var3 = (float)((double)var3 * (1.0D - (double)(this.func_72867_j(p_72971_1_) * 5.0F) / 16.0D));
      var3 = (float)((double)var3 * (1.0D - (double)(this.func_72819_i(p_72971_1_) * 5.0F) / 16.0D));
      return var3 * 0.8F + 0.2F;
   }

   public Vec3 func_72833_a(Entity p_72833_1_, float p_72833_2_) {
      float var3 = this.func_72826_c(p_72833_2_);
      float var4 = MathHelper.func_76134_b(var3 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
      var4 = MathHelper.func_76131_a(var4, 0.0F, 1.0F);
      int var5 = MathHelper.func_76128_c(p_72833_1_.field_70165_t);
      int var6 = MathHelper.func_76128_c(p_72833_1_.field_70163_u);
      int var7 = MathHelper.func_76128_c(p_72833_1_.field_70161_v);
      BlockPos var8 = new BlockPos(var5, var6, var7);
      BiomeGenBase var9 = this.func_180494_b(var8);
      float var10 = var9.func_180626_a(var8);
      int var11 = var9.func_76731_a(var10);
      float var12 = (float)(var11 >> 16 & 255) / 255.0F;
      float var13 = (float)(var11 >> 8 & 255) / 255.0F;
      float var14 = (float)(var11 & 255) / 255.0F;
      var12 *= var4;
      var13 *= var4;
      var14 *= var4;
      float var15 = this.func_72867_j(p_72833_2_);
      float var16;
      float var17;
      if(var15 > 0.0F) {
         var16 = (var12 * 0.3F + var13 * 0.59F + var14 * 0.11F) * 0.6F;
         var17 = 1.0F - var15 * 0.75F;
         var12 = var12 * var17 + var16 * (1.0F - var17);
         var13 = var13 * var17 + var16 * (1.0F - var17);
         var14 = var14 * var17 + var16 * (1.0F - var17);
      }

      var16 = this.func_72819_i(p_72833_2_);
      if(var16 > 0.0F) {
         var17 = (var12 * 0.3F + var13 * 0.59F + var14 * 0.11F) * 0.2F;
         float var18 = 1.0F - var16 * 0.75F;
         var12 = var12 * var18 + var17 * (1.0F - var18);
         var13 = var13 * var18 + var17 * (1.0F - var18);
         var14 = var14 * var18 + var17 * (1.0F - var18);
      }

      if(this.field_73016_r > 0) {
         var17 = (float)this.field_73016_r - p_72833_2_;
         if(var17 > 1.0F) {
            var17 = 1.0F;
         }

         var17 *= 0.45F;
         var12 = var12 * (1.0F - var17) + 0.8F * var17;
         var13 = var13 * (1.0F - var17) + 0.8F * var17;
         var14 = var14 * (1.0F - var17) + 1.0F * var17;
      }

      return new Vec3((double)var12, (double)var13, (double)var14);
   }

   public float func_72826_c(float p_72826_1_) {
      return this.field_73011_w.func_76563_a(this.field_72986_A.func_76073_f(), p_72826_1_);
   }

   public int func_72853_d() {
      return this.field_73011_w.func_76559_b(this.field_72986_A.func_76073_f());
   }

   public float func_130001_d() {
      return WorldProvider.field_111203_a[this.field_73011_w.func_76559_b(this.field_72986_A.func_76073_f())];
   }

   public float func_72929_e(float p_72929_1_) {
      float var2 = this.func_72826_c(p_72929_1_);
      return var2 * 3.1415927F * 2.0F;
   }

   public Vec3 func_72824_f(float p_72824_1_) {
      float var2 = this.func_72826_c(p_72824_1_);
      float var3 = MathHelper.func_76134_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
      var3 = MathHelper.func_76131_a(var3, 0.0F, 1.0F);
      float var4 = (float)(this.field_73001_c >> 16 & 255L) / 255.0F;
      float var5 = (float)(this.field_73001_c >> 8 & 255L) / 255.0F;
      float var6 = (float)(this.field_73001_c & 255L) / 255.0F;
      float var7 = this.func_72867_j(p_72824_1_);
      float var8;
      float var9;
      if(var7 > 0.0F) {
         var8 = (var4 * 0.3F + var5 * 0.59F + var6 * 0.11F) * 0.6F;
         var9 = 1.0F - var7 * 0.95F;
         var4 = var4 * var9 + var8 * (1.0F - var9);
         var5 = var5 * var9 + var8 * (1.0F - var9);
         var6 = var6 * var9 + var8 * (1.0F - var9);
      }

      var4 *= var3 * 0.9F + 0.1F;
      var5 *= var3 * 0.9F + 0.1F;
      var6 *= var3 * 0.85F + 0.15F;
      var8 = this.func_72819_i(p_72824_1_);
      if(var8 > 0.0F) {
         var9 = (var4 * 0.3F + var5 * 0.59F + var6 * 0.11F) * 0.2F;
         float var10 = 1.0F - var8 * 0.95F;
         var4 = var4 * var10 + var9 * (1.0F - var10);
         var5 = var5 * var10 + var9 * (1.0F - var10);
         var6 = var6 * var10 + var9 * (1.0F - var10);
      }

      return new Vec3((double)var4, (double)var5, (double)var6);
   }

   public Vec3 func_72948_g(float p_72948_1_) {
      float var2 = this.func_72826_c(p_72948_1_);
      return this.field_73011_w.func_76562_b(var2, p_72948_1_);
   }

   public BlockPos func_175725_q(BlockPos p_175725_1_) {
      return this.func_175726_f(p_175725_1_).func_177440_h(p_175725_1_);
   }

   public BlockPos func_175672_r(BlockPos p_175672_1_) {
      Chunk var2 = this.func_175726_f(p_175672_1_);

      BlockPos var3;
      BlockPos var4;
      for(var3 = new BlockPos(p_175672_1_.func_177958_n(), var2.func_76625_h() + 16, p_175672_1_.func_177952_p()); var3.func_177956_o() >= 0; var3 = var4) {
         var4 = var3.func_177977_b();
         Material var5 = var2.func_177428_a(var4).func_149688_o();
         if(var5.func_76230_c() && var5 != Material.field_151584_j) {
            break;
         }
      }

      return var3;
   }

   public float func_72880_h(float p_72880_1_) {
      float var2 = this.func_72826_c(p_72880_1_);
      float var3 = 1.0F - (MathHelper.func_76134_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.25F);
      var3 = MathHelper.func_76131_a(var3, 0.0F, 1.0F);
      return var3 * var3 * 0.5F;
   }

   public void func_175684_a(BlockPos p_175684_1_, Block p_175684_2_, int p_175684_3_) {}

   public void func_175654_a(BlockPos p_175654_1_, Block p_175654_2_, int p_175654_3_, int p_175654_4_) {}

   public void func_180497_b(BlockPos p_180497_1_, Block p_180497_2_, int p_180497_3_, int p_180497_4_) {}

   public void func_72939_s() {
      this.field_72984_F.func_76320_a("entities");
      this.field_72984_F.func_76320_a("global");

      int var1;
      Entity var2;
      CrashReport var4;
      CrashReportCategory var5;
      for(var1 = 0; var1 < this.field_73007_j.size(); ++var1) {
         var2 = (Entity)this.field_73007_j.get(var1);

         try {
            ++var2.field_70173_aa;
            var2.func_70071_h_();
         } catch (Throwable var9) {
            var4 = CrashReport.func_85055_a(var9, "Ticking entity");
            var5 = var4.func_85058_a("Entity being ticked");
            if(var2 == null) {
               var5.func_71507_a("Entity", "~~NULL~~");
            } else {
               var2.func_85029_a(var5);
            }

            throw new ReportedException(var4);
         }

         if(var2.field_70128_L) {
            this.field_73007_j.remove(var1--);
         }
      }

      this.field_72984_F.func_76318_c("remove");
      this.field_72996_f.removeAll(this.field_72997_g);

      int var3;
      int var15;
      for(var1 = 0; var1 < this.field_72997_g.size(); ++var1) {
         var2 = (Entity)this.field_72997_g.get(var1);
         var3 = var2.field_70176_ah;
         var15 = var2.field_70164_aj;
         if(var2.field_70175_ag && this.func_175680_a(var3, var15, true)) {
            this.func_72964_e(var3, var15).func_76622_b(var2);
         }
      }

      for(var1 = 0; var1 < this.field_72997_g.size(); ++var1) {
         this.func_72847_b((Entity)this.field_72997_g.get(var1));
      }

      this.field_72997_g.clear();
      this.field_72984_F.func_76318_c("regular");

      for(var1 = 0; var1 < this.field_72996_f.size(); ++var1) {
         var2 = (Entity)this.field_72996_f.get(var1);
         if(var2.field_70154_o != null) {
            if(!var2.field_70154_o.field_70128_L && var2.field_70154_o.field_70153_n == var2) {
               continue;
            }

            var2.field_70154_o.field_70153_n = null;
            var2.field_70154_o = null;
         }

         this.field_72984_F.func_76320_a("tick");
         if(!var2.field_70128_L) {
            try {
               this.func_72870_g(var2);
            } catch (Throwable var8) {
               var4 = CrashReport.func_85055_a(var8, "Ticking entity");
               var5 = var4.func_85058_a("Entity being ticked");
               var2.func_85029_a(var5);
               throw new ReportedException(var4);
            }
         }

         this.field_72984_F.func_76319_b();
         this.field_72984_F.func_76320_a("remove");
         if(var2.field_70128_L) {
            var3 = var2.field_70176_ah;
            var15 = var2.field_70164_aj;
            if(var2.field_70175_ag && this.func_175680_a(var3, var15, true)) {
               this.func_72964_e(var3, var15).func_76622_b(var2);
            }

            this.field_72996_f.remove(var1--);
            this.func_72847_b(var2);
         }

         this.field_72984_F.func_76319_b();
      }

      this.field_72984_F.func_76318_c("blockEntities");
      this.field_147481_N = true;
      Iterator var10 = this.field_175730_i.iterator();

      while(var10.hasNext()) {
         TileEntity var11 = (TileEntity)var10.next();
         if(!var11.func_145837_r() && var11.func_145830_o()) {
            BlockPos var13 = var11.func_174877_v();
            if(this.func_175667_e(var13) && this.field_175728_M.func_177746_a(var13)) {
               try {
                  ((IUpdatePlayerListBox)var11).func_73660_a();
               } catch (Throwable var7) {
                  CrashReport var16 = CrashReport.func_85055_a(var7, "Ticking block entity");
                  CrashReportCategory var6 = var16.func_85058_a("Block entity being ticked");
                  var11.func_145828_a(var6);
                  throw new ReportedException(var16);
               }
            }
         }

         if(var11.func_145837_r()) {
            var10.remove();
            this.field_147482_g.remove(var11);
            if(this.func_175667_e(var11.func_174877_v())) {
               this.func_175726_f(var11.func_174877_v()).func_177425_e(var11.func_174877_v());
            }
         }
      }

      this.field_147481_N = false;
      if(!this.field_147483_b.isEmpty()) {
         this.field_175730_i.removeAll(this.field_147483_b);
         this.field_147482_g.removeAll(this.field_147483_b);
         this.field_147483_b.clear();
      }

      this.field_72984_F.func_76318_c("pendingBlockEntities");
      if(!this.field_147484_a.isEmpty()) {
         for(int var12 = 0; var12 < this.field_147484_a.size(); ++var12) {
            TileEntity var14 = (TileEntity)this.field_147484_a.get(var12);
            if(!var14.func_145837_r()) {
               if(!this.field_147482_g.contains(var14)) {
                  this.func_175700_a(var14);
               }

               if(this.func_175667_e(var14.func_174877_v())) {
                  this.func_175726_f(var14.func_174877_v()).func_177426_a(var14.func_174877_v(), var14);
               }

               this.func_175689_h(var14.func_174877_v());
            }
         }

         this.field_147484_a.clear();
      }

      this.field_72984_F.func_76319_b();
      this.field_72984_F.func_76319_b();
   }

   public boolean func_175700_a(TileEntity p_175700_1_) {
      boolean var2 = this.field_147482_g.add(p_175700_1_);
      if(var2 && p_175700_1_ instanceof IUpdatePlayerListBox) {
         this.field_175730_i.add(p_175700_1_);
      }

      return var2;
   }

   public void func_147448_a(Collection p_147448_1_) {
      if(this.field_147481_N) {
         this.field_147484_a.addAll(p_147448_1_);
      } else {
         Iterator var2 = p_147448_1_.iterator();

         while(var2.hasNext()) {
            TileEntity var3 = (TileEntity)var2.next();
            this.field_147482_g.add(var3);
            if(var3 instanceof IUpdatePlayerListBox) {
               this.field_175730_i.add(var3);
            }
         }
      }

   }

   public void func_72870_g(Entity p_72870_1_) {
      this.func_72866_a(p_72870_1_, true);
   }

   public void func_72866_a(Entity p_72866_1_, boolean p_72866_2_) {
      int var3 = MathHelper.func_76128_c(p_72866_1_.field_70165_t);
      int var4 = MathHelper.func_76128_c(p_72866_1_.field_70161_v);
      byte var5 = 32;
      if(!p_72866_2_ || this.func_175663_a(var3 - var5, 0, var4 - var5, var3 + var5, 0, var4 + var5, true)) {
         p_72866_1_.field_70142_S = p_72866_1_.field_70165_t;
         p_72866_1_.field_70137_T = p_72866_1_.field_70163_u;
         p_72866_1_.field_70136_U = p_72866_1_.field_70161_v;
         p_72866_1_.field_70126_B = p_72866_1_.field_70177_z;
         p_72866_1_.field_70127_C = p_72866_1_.field_70125_A;
         if(p_72866_2_ && p_72866_1_.field_70175_ag) {
            ++p_72866_1_.field_70173_aa;
            if(p_72866_1_.field_70154_o != null) {
               p_72866_1_.func_70098_U();
            } else {
               p_72866_1_.func_70071_h_();
            }
         }

         this.field_72984_F.func_76320_a("chunkCheck");
         if(Double.isNaN(p_72866_1_.field_70165_t) || Double.isInfinite(p_72866_1_.field_70165_t)) {
            p_72866_1_.field_70165_t = p_72866_1_.field_70142_S;
         }

         if(Double.isNaN(p_72866_1_.field_70163_u) || Double.isInfinite(p_72866_1_.field_70163_u)) {
            p_72866_1_.field_70163_u = p_72866_1_.field_70137_T;
         }

         if(Double.isNaN(p_72866_1_.field_70161_v) || Double.isInfinite(p_72866_1_.field_70161_v)) {
            p_72866_1_.field_70161_v = p_72866_1_.field_70136_U;
         }

         if(Double.isNaN((double)p_72866_1_.field_70125_A) || Double.isInfinite((double)p_72866_1_.field_70125_A)) {
            p_72866_1_.field_70125_A = p_72866_1_.field_70127_C;
         }

         if(Double.isNaN((double)p_72866_1_.field_70177_z) || Double.isInfinite((double)p_72866_1_.field_70177_z)) {
            p_72866_1_.field_70177_z = p_72866_1_.field_70126_B;
         }

         int var6 = MathHelper.func_76128_c(p_72866_1_.field_70165_t / 16.0D);
         int var7 = MathHelper.func_76128_c(p_72866_1_.field_70163_u / 16.0D);
         int var8 = MathHelper.func_76128_c(p_72866_1_.field_70161_v / 16.0D);
         if(!p_72866_1_.field_70175_ag || p_72866_1_.field_70176_ah != var6 || p_72866_1_.field_70162_ai != var7 || p_72866_1_.field_70164_aj != var8) {
            if(p_72866_1_.field_70175_ag && this.func_175680_a(p_72866_1_.field_70176_ah, p_72866_1_.field_70164_aj, true)) {
               this.func_72964_e(p_72866_1_.field_70176_ah, p_72866_1_.field_70164_aj).func_76608_a(p_72866_1_, p_72866_1_.field_70162_ai);
            }

            if(this.func_175680_a(var6, var8, true)) {
               p_72866_1_.field_70175_ag = true;
               this.func_72964_e(var6, var8).func_76612_a(p_72866_1_);
            } else {
               p_72866_1_.field_70175_ag = false;
            }
         }

         this.field_72984_F.func_76319_b();
         if(p_72866_2_ && p_72866_1_.field_70175_ag && p_72866_1_.field_70153_n != null) {
            if(!p_72866_1_.field_70153_n.field_70128_L && p_72866_1_.field_70153_n.field_70154_o == p_72866_1_) {
               this.func_72870_g(p_72866_1_.field_70153_n);
            } else {
               p_72866_1_.field_70153_n.field_70154_o = null;
               p_72866_1_.field_70153_n = null;
            }
         }

      }
   }

   public boolean func_72855_b(AxisAlignedBB p_72855_1_) {
      return this.func_72917_a(p_72855_1_, (Entity)null);
   }

   public boolean func_72917_a(AxisAlignedBB p_72917_1_, Entity p_72917_2_) {
      List var3 = this.func_72839_b((Entity)null, p_72917_1_);

      for(int var4 = 0; var4 < var3.size(); ++var4) {
         Entity var5 = (Entity)var3.get(var4);
         if(!var5.field_70128_L && var5.field_70156_m && var5 != p_72917_2_ && (p_72917_2_ == null || p_72917_2_.field_70154_o != var5 && p_72917_2_.field_70153_n != var5)) {
            return false;
         }
      }

      return true;
   }

   public boolean func_72829_c(AxisAlignedBB p_72829_1_) {
      int var2 = MathHelper.func_76128_c(p_72829_1_.field_72340_a);
      int var3 = MathHelper.func_76128_c(p_72829_1_.field_72336_d);
      int var4 = MathHelper.func_76128_c(p_72829_1_.field_72338_b);
      int var5 = MathHelper.func_76128_c(p_72829_1_.field_72337_e);
      int var6 = MathHelper.func_76128_c(p_72829_1_.field_72339_c);
      int var7 = MathHelper.func_76128_c(p_72829_1_.field_72334_f);

      for(int var8 = var2; var8 <= var3; ++var8) {
         for(int var9 = var4; var9 <= var5; ++var9) {
            for(int var10 = var6; var10 <= var7; ++var10) {
               Block var11 = this.func_180495_p(new BlockPos(var8, var9, var10)).func_177230_c();
               if(var11.func_149688_o() != Material.field_151579_a) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean func_72953_d(AxisAlignedBB p_72953_1_) {
      int var2 = MathHelper.func_76128_c(p_72953_1_.field_72340_a);
      int var3 = MathHelper.func_76128_c(p_72953_1_.field_72336_d);
      int var4 = MathHelper.func_76128_c(p_72953_1_.field_72338_b);
      int var5 = MathHelper.func_76128_c(p_72953_1_.field_72337_e);
      int var6 = MathHelper.func_76128_c(p_72953_1_.field_72339_c);
      int var7 = MathHelper.func_76128_c(p_72953_1_.field_72334_f);

      for(int var8 = var2; var8 <= var3; ++var8) {
         for(int var9 = var4; var9 <= var5; ++var9) {
            for(int var10 = var6; var10 <= var7; ++var10) {
               Block var11 = this.func_180495_p(new BlockPos(var8, var9, var10)).func_177230_c();
               if(var11.func_149688_o().func_76224_d()) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean func_147470_e(AxisAlignedBB p_147470_1_) {
      int var2 = MathHelper.func_76128_c(p_147470_1_.field_72340_a);
      int var3 = MathHelper.func_76128_c(p_147470_1_.field_72336_d + 1.0D);
      int var4 = MathHelper.func_76128_c(p_147470_1_.field_72338_b);
      int var5 = MathHelper.func_76128_c(p_147470_1_.field_72337_e + 1.0D);
      int var6 = MathHelper.func_76128_c(p_147470_1_.field_72339_c);
      int var7 = MathHelper.func_76128_c(p_147470_1_.field_72334_f + 1.0D);
      if(this.func_175663_a(var2, var4, var6, var3, var5, var7, true)) {
         for(int var8 = var2; var8 < var3; ++var8) {
            for(int var9 = var4; var9 < var5; ++var9) {
               for(int var10 = var6; var10 < var7; ++var10) {
                  Block var11 = this.func_180495_p(new BlockPos(var8, var9, var10)).func_177230_c();
                  if(var11 == Blocks.field_150480_ab || var11 == Blocks.field_150356_k || var11 == Blocks.field_150353_l) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public boolean func_72918_a(AxisAlignedBB p_72918_1_, Material p_72918_2_, Entity p_72918_3_) {
      int var4 = MathHelper.func_76128_c(p_72918_1_.field_72340_a);
      int var5 = MathHelper.func_76128_c(p_72918_1_.field_72336_d + 1.0D);
      int var6 = MathHelper.func_76128_c(p_72918_1_.field_72338_b);
      int var7 = MathHelper.func_76128_c(p_72918_1_.field_72337_e + 1.0D);
      int var8 = MathHelper.func_76128_c(p_72918_1_.field_72339_c);
      int var9 = MathHelper.func_76128_c(p_72918_1_.field_72334_f + 1.0D);
      if(!this.func_175663_a(var4, var6, var8, var5, var7, var9, true)) {
         return false;
      } else {
         boolean var10 = false;
         Vec3 var11 = new Vec3(0.0D, 0.0D, 0.0D);

         for(int var12 = var4; var12 < var5; ++var12) {
            for(int var13 = var6; var13 < var7; ++var13) {
               for(int var14 = var8; var14 < var9; ++var14) {
                  BlockPos var15 = new BlockPos(var12, var13, var14);
                  IBlockState var16 = this.func_180495_p(var15);
                  Block var17 = var16.func_177230_c();
                  if(var17.func_149688_o() == p_72918_2_) {
                     double var18 = (double)((float)(var13 + 1) - BlockLiquid.func_149801_b(((Integer)var16.func_177229_b(BlockLiquid.field_176367_b)).intValue()));
                     if((double)var7 >= var18) {
                        var10 = true;
                        var11 = var17.func_176197_a(this, var15, p_72918_3_, var11);
                     }
                  }
               }
            }
         }

         if(var11.func_72433_c() > 0.0D && p_72918_3_.func_96092_aw()) {
            var11 = var11.func_72432_b();
            double var20 = 0.014D;
            p_72918_3_.field_70159_w += var11.field_72450_a * var20;
            p_72918_3_.field_70181_x += var11.field_72448_b * var20;
            p_72918_3_.field_70179_y += var11.field_72449_c * var20;
         }

         return var10;
      }
   }

   public boolean func_72875_a(AxisAlignedBB p_72875_1_, Material p_72875_2_) {
      int var3 = MathHelper.func_76128_c(p_72875_1_.field_72340_a);
      int var4 = MathHelper.func_76128_c(p_72875_1_.field_72336_d + 1.0D);
      int var5 = MathHelper.func_76128_c(p_72875_1_.field_72338_b);
      int var6 = MathHelper.func_76128_c(p_72875_1_.field_72337_e + 1.0D);
      int var7 = MathHelper.func_76128_c(p_72875_1_.field_72339_c);
      int var8 = MathHelper.func_76128_c(p_72875_1_.field_72334_f + 1.0D);

      for(int var9 = var3; var9 < var4; ++var9) {
         for(int var10 = var5; var10 < var6; ++var10) {
            for(int var11 = var7; var11 < var8; ++var11) {
               if(this.func_180495_p(new BlockPos(var9, var10, var11)).func_177230_c().func_149688_o() == p_72875_2_) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean func_72830_b(AxisAlignedBB p_72830_1_, Material p_72830_2_) {
      int var3 = MathHelper.func_76128_c(p_72830_1_.field_72340_a);
      int var4 = MathHelper.func_76128_c(p_72830_1_.field_72336_d + 1.0D);
      int var5 = MathHelper.func_76128_c(p_72830_1_.field_72338_b);
      int var6 = MathHelper.func_76128_c(p_72830_1_.field_72337_e + 1.0D);
      int var7 = MathHelper.func_76128_c(p_72830_1_.field_72339_c);
      int var8 = MathHelper.func_76128_c(p_72830_1_.field_72334_f + 1.0D);

      for(int var9 = var3; var9 < var4; ++var9) {
         for(int var10 = var5; var10 < var6; ++var10) {
            for(int var11 = var7; var11 < var8; ++var11) {
               BlockPos var12 = new BlockPos(var9, var10, var11);
               IBlockState var13 = this.func_180495_p(var12);
               Block var14 = var13.func_177230_c();
               if(var14.func_149688_o() == p_72830_2_) {
                  int var15 = ((Integer)var13.func_177229_b(BlockLiquid.field_176367_b)).intValue();
                  double var16 = (double)(var10 + 1);
                  if(var15 < 8) {
                     var16 = (double)(var10 + 1) - (double)var15 / 8.0D;
                  }

                  if(var16 >= p_72830_1_.field_72338_b) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public Explosion func_72876_a(Entity p_72876_1_, double p_72876_2_, double p_72876_4_, double p_72876_6_, float p_72876_8_, boolean p_72876_9_) {
      return this.func_72885_a(p_72876_1_, p_72876_2_, p_72876_4_, p_72876_6_, p_72876_8_, false, p_72876_9_);
   }

   public Explosion func_72885_a(Entity p_72885_1_, double p_72885_2_, double p_72885_4_, double p_72885_6_, float p_72885_8_, boolean p_72885_9_, boolean p_72885_10_) {
      Explosion var11 = new Explosion(this, p_72885_1_, p_72885_2_, p_72885_4_, p_72885_6_, p_72885_8_, p_72885_9_, p_72885_10_);
      var11.func_77278_a();
      var11.func_77279_a(true);
      return var11;
   }

   public float func_72842_a(Vec3 p_72842_1_, AxisAlignedBB p_72842_2_) {
      double var3 = 1.0D / ((p_72842_2_.field_72336_d - p_72842_2_.field_72340_a) * 2.0D + 1.0D);
      double var5 = 1.0D / ((p_72842_2_.field_72337_e - p_72842_2_.field_72338_b) * 2.0D + 1.0D);
      double var7 = 1.0D / ((p_72842_2_.field_72334_f - p_72842_2_.field_72339_c) * 2.0D + 1.0D);
      if(var3 >= 0.0D && var5 >= 0.0D && var7 >= 0.0D) {
         int var9 = 0;
         int var10 = 0;

         for(float var11 = 0.0F; var11 <= 1.0F; var11 = (float)((double)var11 + var3)) {
            for(float var12 = 0.0F; var12 <= 1.0F; var12 = (float)((double)var12 + var5)) {
               for(float var13 = 0.0F; var13 <= 1.0F; var13 = (float)((double)var13 + var7)) {
                  double var14 = p_72842_2_.field_72340_a + (p_72842_2_.field_72336_d - p_72842_2_.field_72340_a) * (double)var11;
                  double var16 = p_72842_2_.field_72338_b + (p_72842_2_.field_72337_e - p_72842_2_.field_72338_b) * (double)var12;
                  double var18 = p_72842_2_.field_72339_c + (p_72842_2_.field_72334_f - p_72842_2_.field_72339_c) * (double)var13;
                  if(this.func_72933_a(new Vec3(var14, var16, var18), p_72842_1_) == null) {
                     ++var9;
                  }

                  ++var10;
               }
            }
         }

         return (float)var9 / (float)var10;
      } else {
         return 0.0F;
      }
   }

   public boolean func_175719_a(EntityPlayer p_175719_1_, BlockPos p_175719_2_, EnumFacing p_175719_3_) {
      p_175719_2_ = p_175719_2_.func_177972_a(p_175719_3_);
      if(this.func_180495_p(p_175719_2_).func_177230_c() == Blocks.field_150480_ab) {
         this.func_180498_a(p_175719_1_, 1004, p_175719_2_, 0);
         this.func_175698_g(p_175719_2_);
         return true;
      } else {
         return false;
      }
   }

   public String func_72981_t() {
      return "All: " + this.field_72996_f.size();
   }

   public String func_72827_u() {
      return this.field_73020_y.func_73148_d();
   }

   public TileEntity func_175625_s(BlockPos p_175625_1_) {
      if(!this.func_175701_a(p_175625_1_)) {
         return null;
      } else {
         TileEntity var2 = null;
         int var3;
         TileEntity var4;
         if(this.field_147481_N) {
            for(var3 = 0; var3 < this.field_147484_a.size(); ++var3) {
               var4 = (TileEntity)this.field_147484_a.get(var3);
               if(!var4.func_145837_r() && var4.func_174877_v().equals(p_175625_1_)) {
                  var2 = var4;
                  break;
               }
            }
         }

         if(var2 == null) {
            var2 = this.func_175726_f(p_175625_1_).func_177424_a(p_175625_1_, Chunk.EnumCreateEntityType.IMMEDIATE);
         }

         if(var2 == null) {
            for(var3 = 0; var3 < this.field_147484_a.size(); ++var3) {
               var4 = (TileEntity)this.field_147484_a.get(var3);
               if(!var4.func_145837_r() && var4.func_174877_v().equals(p_175625_1_)) {
                  var2 = var4;
                  break;
               }
            }
         }

         return var2;
      }
   }

   public void func_175690_a(BlockPos p_175690_1_, TileEntity p_175690_2_) {
      if(p_175690_2_ != null && !p_175690_2_.func_145837_r()) {
         if(this.field_147481_N) {
            p_175690_2_.func_174878_a(p_175690_1_);
            Iterator var3 = this.field_147484_a.iterator();

            while(var3.hasNext()) {
               TileEntity var4 = (TileEntity)var3.next();
               if(var4.func_174877_v().equals(p_175690_1_)) {
                  var4.func_145843_s();
                  var3.remove();
               }
            }

            this.field_147484_a.add(p_175690_2_);
         } else {
            this.func_175700_a(p_175690_2_);
            this.func_175726_f(p_175690_1_).func_177426_a(p_175690_1_, p_175690_2_);
         }
      }

   }

   public void func_175713_t(BlockPos p_175713_1_) {
      TileEntity var2 = this.func_175625_s(p_175713_1_);
      if(var2 != null && this.field_147481_N) {
         var2.func_145843_s();
         this.field_147484_a.remove(var2);
      } else {
         if(var2 != null) {
            this.field_147484_a.remove(var2);
            this.field_147482_g.remove(var2);
            this.field_175730_i.remove(var2);
         }

         this.func_175726_f(p_175713_1_).func_177425_e(p_175713_1_);
      }

   }

   public void func_147457_a(TileEntity p_147457_1_) {
      this.field_147483_b.add(p_147457_1_);
   }

   public boolean func_175665_u(BlockPos p_175665_1_) {
      IBlockState var2 = this.func_180495_p(p_175665_1_);
      AxisAlignedBB var3 = var2.func_177230_c().func_180640_a(this, p_175665_1_, var2);
      return var3 != null && var3.func_72320_b() >= 1.0D;
   }

   public static boolean func_175683_a(IBlockAccess p_175683_0_, BlockPos p_175683_1_) {
      IBlockState var2 = p_175683_0_.func_180495_p(p_175683_1_);
      Block var3 = var2.func_177230_c();
      return var3.func_149688_o().func_76218_k() && var3.func_149686_d()?true:(var3 instanceof BlockStairs?var2.func_177229_b(BlockStairs.field_176308_b) == BlockStairs.EnumHalf.TOP:(var3 instanceof BlockSlab?var2.func_177229_b(BlockSlab.field_176554_a) == BlockSlab.EnumBlockHalf.TOP:(var3 instanceof BlockHopper?true:(var3 instanceof BlockSnow?((Integer)var2.func_177229_b(BlockSnow.field_176315_a)).intValue() == 7:false))));
   }

   public boolean func_175677_d(BlockPos p_175677_1_, boolean p_175677_2_) {
      if(!this.func_175701_a(p_175677_1_)) {
         return p_175677_2_;
      } else {
         Chunk var3 = this.field_73020_y.func_177459_a(p_175677_1_);
         if(var3.func_76621_g()) {
            return p_175677_2_;
         } else {
            Block var4 = this.func_180495_p(p_175677_1_).func_177230_c();
            return var4.func_149688_o().func_76218_k() && var4.func_149686_d();
         }
      }
   }

   public void func_72966_v() {
      int var1 = this.func_72967_a(1.0F);
      if(var1 != this.field_73008_k) {
         this.field_73008_k = var1;
      }

   }

   public void func_72891_a(boolean p_72891_1_, boolean p_72891_2_) {
      this.field_72985_G = p_72891_1_;
      this.field_72992_H = p_72891_2_;
   }

   public void func_72835_b() {
      this.func_72979_l();
   }

   protected void func_72947_a() {
      if(this.field_72986_A.func_76059_o()) {
         this.field_73004_o = 1.0F;
         if(this.field_72986_A.func_76061_m()) {
            this.field_73017_q = 1.0F;
         }
      }

   }

   protected void func_72979_l() {
      if(!this.field_73011_w.func_177495_o()) {
         if(!this.field_72995_K) {
            int var1 = this.field_72986_A.func_176133_A();
            if(var1 > 0) {
               --var1;
               this.field_72986_A.func_176142_i(var1);
               this.field_72986_A.func_76090_f(this.field_72986_A.func_76061_m()?1:2);
               this.field_72986_A.func_76080_g(this.field_72986_A.func_76059_o()?1:2);
            }

            int var2 = this.field_72986_A.func_76071_n();
            if(var2 <= 0) {
               if(this.field_72986_A.func_76061_m()) {
                  this.field_72986_A.func_76090_f(this.field_73012_v.nextInt(12000) + 3600);
               } else {
                  this.field_72986_A.func_76090_f(this.field_73012_v.nextInt(168000) + 12000);
               }
            } else {
               --var2;
               this.field_72986_A.func_76090_f(var2);
               if(var2 <= 0) {
                  this.field_72986_A.func_76069_a(!this.field_72986_A.func_76061_m());
               }
            }

            this.field_73018_p = this.field_73017_q;
            if(this.field_72986_A.func_76061_m()) {
               this.field_73017_q = (float)((double)this.field_73017_q + 0.01D);
            } else {
               this.field_73017_q = (float)((double)this.field_73017_q - 0.01D);
            }

            this.field_73017_q = MathHelper.func_76131_a(this.field_73017_q, 0.0F, 1.0F);
            int var3 = this.field_72986_A.func_76083_p();
            if(var3 <= 0) {
               if(this.field_72986_A.func_76059_o()) {
                  this.field_72986_A.func_76080_g(this.field_73012_v.nextInt(12000) + 12000);
               } else {
                  this.field_72986_A.func_76080_g(this.field_73012_v.nextInt(168000) + 12000);
               }
            } else {
               --var3;
               this.field_72986_A.func_76080_g(var3);
               if(var3 <= 0) {
                  this.field_72986_A.func_76084_b(!this.field_72986_A.func_76059_o());
               }
            }

            this.field_73003_n = this.field_73004_o;
            if(this.field_72986_A.func_76059_o()) {
               this.field_73004_o = (float)((double)this.field_73004_o + 0.01D);
            } else {
               this.field_73004_o = (float)((double)this.field_73004_o - 0.01D);
            }

            this.field_73004_o = MathHelper.func_76131_a(this.field_73004_o, 0.0F, 1.0F);
         }
      }
   }

   protected void func_72903_x() {
      this.field_72993_I.clear();
      this.field_72984_F.func_76320_a("buildList");

      int var1;
      EntityPlayer var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < this.field_73010_i.size(); ++var1) {
         var2 = (EntityPlayer)this.field_73010_i.get(var1);
         var3 = MathHelper.func_76128_c(var2.field_70165_t / 16.0D);
         var4 = MathHelper.func_76128_c(var2.field_70161_v / 16.0D);
         var5 = this.func_152379_p();

         for(int var6 = -var5; var6 <= var5; ++var6) {
            for(int var7 = -var5; var7 <= var5; ++var7) {
               this.field_72993_I.add(new ChunkCoordIntPair(var6 + var3, var7 + var4));
            }
         }
      }

      this.field_72984_F.func_76319_b();
      if(this.field_72990_M > 0) {
         --this.field_72990_M;
      }

      this.field_72984_F.func_76320_a("playerCheckLight");
      if(!this.field_73010_i.isEmpty()) {
         var1 = this.field_73012_v.nextInt(this.field_73010_i.size());
         var2 = (EntityPlayer)this.field_73010_i.get(var1);
         var3 = MathHelper.func_76128_c(var2.field_70165_t) + this.field_73012_v.nextInt(11) - 5;
         var4 = MathHelper.func_76128_c(var2.field_70163_u) + this.field_73012_v.nextInt(11) - 5;
         var5 = MathHelper.func_76128_c(var2.field_70161_v) + this.field_73012_v.nextInt(11) - 5;
         this.func_175664_x(new BlockPos(var3, var4, var5));
      }

      this.field_72984_F.func_76319_b();
   }

   protected abstract int func_152379_p();

   protected void func_147467_a(int p_147467_1_, int p_147467_2_, Chunk p_147467_3_) {
      this.field_72984_F.func_76318_c("moodSound");
      if(this.field_72990_M == 0 && !this.field_72995_K) {
         this.field_73005_l = this.field_73005_l * 3 + 1013904223;
         int var4 = this.field_73005_l >> 2;
         int var5 = var4 & 15;
         int var6 = var4 >> 8 & 15;
         int var7 = var4 >> 16 & 255;
         BlockPos var8 = new BlockPos(var5, var7, var6);
         Block var9 = p_147467_3_.func_177428_a(var8);
         var5 += p_147467_1_;
         var6 += p_147467_2_;
         if(var9.func_149688_o() == Material.field_151579_a && this.func_175699_k(var8) <= this.field_73012_v.nextInt(8) && this.func_175642_b(EnumSkyBlock.SKY, var8) <= 0) {
            EntityPlayer var10 = this.func_72977_a((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D, 8.0D);
            if(var10 != null && var10.func_70092_e((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D) > 4.0D) {
               this.func_72908_a((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + this.field_73012_v.nextFloat() * 0.2F);
               this.field_72990_M = this.field_73012_v.nextInt(12000) + 6000;
            }
         }
      }

      this.field_72984_F.func_76318_c("checkLight");
      p_147467_3_.func_76594_o();
   }

   protected void func_147456_g() {
      this.func_72903_x();
   }

   public void func_175637_a(Block p_175637_1_, BlockPos p_175637_2_, Random p_175637_3_) {
      this.field_72999_e = true;
      p_175637_1_.func_180650_b(this, p_175637_2_, this.func_180495_p(p_175637_2_), p_175637_3_);
      this.field_72999_e = false;
   }

   public boolean func_175675_v(BlockPos p_175675_1_) {
      return this.func_175670_e(p_175675_1_, false);
   }

   public boolean func_175662_w(BlockPos p_175662_1_) {
      return this.func_175670_e(p_175662_1_, true);
   }

   public boolean func_175670_e(BlockPos p_175670_1_, boolean p_175670_2_) {
      BiomeGenBase var3 = this.func_180494_b(p_175670_1_);
      float var4 = var3.func_180626_a(p_175670_1_);
      if(var4 > 0.15F) {
         return false;
      } else {
         if(p_175670_1_.func_177956_o() >= 0 && p_175670_1_.func_177956_o() < 256 && this.func_175642_b(EnumSkyBlock.BLOCK, p_175670_1_) < 10) {
            IBlockState var5 = this.func_180495_p(p_175670_1_);
            Block var6 = var5.func_177230_c();
            if((var6 == Blocks.field_150355_j || var6 == Blocks.field_150358_i) && ((Integer)var5.func_177229_b(BlockLiquid.field_176367_b)).intValue() == 0) {
               if(!p_175670_2_) {
                  return true;
               }

               boolean var7 = this.func_175696_F(p_175670_1_.func_177976_e()) && this.func_175696_F(p_175670_1_.func_177974_f()) && this.func_175696_F(p_175670_1_.func_177978_c()) && this.func_175696_F(p_175670_1_.func_177968_d());
               if(!var7) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   private boolean func_175696_F(BlockPos p_175696_1_) {
      return this.func_180495_p(p_175696_1_).func_177230_c().func_149688_o() == Material.field_151586_h;
   }

   public boolean func_175708_f(BlockPos p_175708_1_, boolean p_175708_2_) {
      BiomeGenBase var3 = this.func_180494_b(p_175708_1_);
      float var4 = var3.func_180626_a(p_175708_1_);
      if(var4 > 0.15F) {
         return false;
      } else if(!p_175708_2_) {
         return true;
      } else {
         if(p_175708_1_.func_177956_o() >= 0 && p_175708_1_.func_177956_o() < 256 && this.func_175642_b(EnumSkyBlock.BLOCK, p_175708_1_) < 10) {
            Block var5 = this.func_180495_p(p_175708_1_).func_177230_c();
            if(var5.func_149688_o() == Material.field_151579_a && Blocks.field_150431_aC.func_176196_c(this, p_175708_1_)) {
               return true;
            }
         }

         return false;
      }
   }

   public boolean func_175664_x(BlockPos p_175664_1_) {
      boolean var2 = false;
      if(!this.field_73011_w.func_177495_o()) {
         var2 |= this.func_180500_c(EnumSkyBlock.SKY, p_175664_1_);
      }

      var2 |= this.func_180500_c(EnumSkyBlock.BLOCK, p_175664_1_);
      return var2;
   }

   private int func_175638_a(BlockPos p_175638_1_, EnumSkyBlock p_175638_2_) {
      if(p_175638_2_ == EnumSkyBlock.SKY && this.func_175678_i(p_175638_1_)) {
         return 15;
      } else {
         Block var3 = this.func_180495_p(p_175638_1_).func_177230_c();
         int var4 = p_175638_2_ == EnumSkyBlock.SKY?0:var3.func_149750_m();
         int var5 = var3.func_149717_k();
         if(var5 >= 15 && var3.func_149750_m() > 0) {
            var5 = 1;
         }

         if(var5 < 1) {
            var5 = 1;
         }

         if(var5 >= 15) {
            return 0;
         } else if(var4 >= 14) {
            return var4;
         } else {
            EnumFacing[] var6 = EnumFacing.values();
            int var7 = var6.length;

            for(int var8 = 0; var8 < var7; ++var8) {
               EnumFacing var9 = var6[var8];
               BlockPos var10 = p_175638_1_.func_177972_a(var9);
               int var11 = this.func_175642_b(p_175638_2_, var10) - var5;
               if(var11 > var4) {
                  var4 = var11;
               }

               if(var4 >= 14) {
                  return var4;
               }
            }

            return var4;
         }
      }
   }

   public boolean func_180500_c(EnumSkyBlock p_180500_1_, BlockPos p_180500_2_) {
      if(!this.func_175648_a(p_180500_2_, 17, false)) {
         return false;
      } else {
         int var3 = 0;
         int var4 = 0;
         this.field_72984_F.func_76320_a("getBrightness");
         int var5 = this.func_175642_b(p_180500_1_, p_180500_2_);
         int var6 = this.func_175638_a(p_180500_2_, p_180500_1_);
         int var7 = p_180500_2_.func_177958_n();
         int var8 = p_180500_2_.func_177956_o();
         int var9 = p_180500_2_.func_177952_p();
         int var10;
         int var11;
         int var12;
         int var13;
         int var16;
         int var17;
         int var18;
         int var19;
         if(var6 > var5) {
            this.field_72994_J[var4++] = 133152;
         } else if(var6 < var5) {
            this.field_72994_J[var4++] = 133152 | var5 << 18;

            while(var3 < var4) {
               var10 = this.field_72994_J[var3++];
               var11 = (var10 & 63) - 32 + var7;
               var12 = (var10 >> 6 & 63) - 32 + var8;
               var13 = (var10 >> 12 & 63) - 32 + var9;
               int var14 = var10 >> 18 & 15;
               BlockPos var15 = new BlockPos(var11, var12, var13);
               var16 = this.func_175642_b(p_180500_1_, var15);
               if(var16 == var14) {
                  this.func_175653_a(p_180500_1_, var15, 0);
                  if(var14 > 0) {
                     var17 = MathHelper.func_76130_a(var11 - var7);
                     var18 = MathHelper.func_76130_a(var12 - var8);
                     var19 = MathHelper.func_76130_a(var13 - var9);
                     if(var17 + var18 + var19 < 17) {
                        EnumFacing[] var20 = EnumFacing.values();
                        int var21 = var20.length;

                        for(int var22 = 0; var22 < var21; ++var22) {
                           EnumFacing var23 = var20[var22];
                           int var24 = var11 + var23.func_82601_c();
                           int var25 = var12 + var23.func_96559_d();
                           int var26 = var13 + var23.func_82599_e();
                           BlockPos var27 = new BlockPos(var24, var25, var26);
                           int var28 = Math.max(1, this.func_180495_p(var27).func_177230_c().func_149717_k());
                           var16 = this.func_175642_b(p_180500_1_, var27);
                           if(var16 == var14 - var28 && var4 < this.field_72994_J.length) {
                              this.field_72994_J[var4++] = var24 - var7 + 32 | var25 - var8 + 32 << 6 | var26 - var9 + 32 << 12 | var14 - var28 << 18;
                           }
                        }
                     }
                  }
               }
            }

            var3 = 0;
         }

         this.field_72984_F.func_76319_b();
         this.field_72984_F.func_76320_a("checkedPosition < toCheckCount");

         while(var3 < var4) {
            var10 = this.field_72994_J[var3++];
            var11 = (var10 & 63) - 32 + var7;
            var12 = (var10 >> 6 & 63) - 32 + var8;
            var13 = (var10 >> 12 & 63) - 32 + var9;
            BlockPos var29 = new BlockPos(var11, var12, var13);
            int var30 = this.func_175642_b(p_180500_1_, var29);
            var16 = this.func_175638_a(var29, p_180500_1_);
            if(var16 != var30) {
               this.func_175653_a(p_180500_1_, var29, var16);
               if(var16 > var30) {
                  var17 = Math.abs(var11 - var7);
                  var18 = Math.abs(var12 - var8);
                  var19 = Math.abs(var13 - var9);
                  boolean var31 = var4 < this.field_72994_J.length - 6;
                  if(var17 + var18 + var19 < 17 && var31) {
                     if(this.func_175642_b(p_180500_1_, var29.func_177976_e()) < var16) {
                        this.field_72994_J[var4++] = var11 - 1 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                     }

                     if(this.func_175642_b(p_180500_1_, var29.func_177974_f()) < var16) {
                        this.field_72994_J[var4++] = var11 + 1 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                     }

                     if(this.func_175642_b(p_180500_1_, var29.func_177977_b()) < var16) {
                        this.field_72994_J[var4++] = var11 - var7 + 32 + (var12 - 1 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                     }

                     if(this.func_175642_b(p_180500_1_, var29.func_177984_a()) < var16) {
                        this.field_72994_J[var4++] = var11 - var7 + 32 + (var12 + 1 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                     }

                     if(this.func_175642_b(p_180500_1_, var29.func_177978_c()) < var16) {
                        this.field_72994_J[var4++] = var11 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 - 1 - var9 + 32 << 12);
                     }

                     if(this.func_175642_b(p_180500_1_, var29.func_177968_d()) < var16) {
                        this.field_72994_J[var4++] = var11 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 + 1 - var9 + 32 << 12);
                     }
                  }
               }
            }
         }

         this.field_72984_F.func_76319_b();
         return true;
      }
   }

   public boolean func_72955_a(boolean p_72955_1_) {
      return false;
   }

   public List func_72920_a(Chunk p_72920_1_, boolean p_72920_2_) {
      return null;
   }

   public List func_175712_a(StructureBoundingBox p_175712_1_, boolean p_175712_2_) {
      return null;
   }

   public List func_72839_b(Entity p_72839_1_, AxisAlignedBB p_72839_2_) {
      return this.func_175674_a(p_72839_1_, p_72839_2_, IEntitySelector.field_180132_d);
   }

   public List func_175674_a(Entity p_175674_1_, AxisAlignedBB p_175674_2_, Predicate p_175674_3_) {
      ArrayList var4 = Lists.newArrayList();
      int var5 = MathHelper.func_76128_c((p_175674_2_.field_72340_a - 2.0D) / 16.0D);
      int var6 = MathHelper.func_76128_c((p_175674_2_.field_72336_d + 2.0D) / 16.0D);
      int var7 = MathHelper.func_76128_c((p_175674_2_.field_72339_c - 2.0D) / 16.0D);
      int var8 = MathHelper.func_76128_c((p_175674_2_.field_72334_f + 2.0D) / 16.0D);

      for(int var9 = var5; var9 <= var6; ++var9) {
         for(int var10 = var7; var10 <= var8; ++var10) {
            if(this.func_175680_a(var9, var10, true)) {
               this.func_72964_e(var9, var10).func_177414_a(p_175674_1_, p_175674_2_, var4, p_175674_3_);
            }
         }
      }

      return var4;
   }

   public List func_175644_a(Class p_175644_1_, Predicate p_175644_2_) {
      ArrayList var3 = Lists.newArrayList();
      Iterator var4 = this.field_72996_f.iterator();

      while(var4.hasNext()) {
         Entity var5 = (Entity)var4.next();
         if(p_175644_1_.isAssignableFrom(var5.getClass()) && p_175644_2_.apply(var5)) {
            var3.add(var5);
         }
      }

      return var3;
   }

   public List func_175661_b(Class p_175661_1_, Predicate p_175661_2_) {
      ArrayList var3 = Lists.newArrayList();
      Iterator var4 = this.field_73010_i.iterator();

      while(var4.hasNext()) {
         Entity var5 = (Entity)var4.next();
         if(p_175661_1_.isAssignableFrom(var5.getClass()) && p_175661_2_.apply(var5)) {
            var3.add(var5);
         }
      }

      return var3;
   }

   public List func_72872_a(Class p_72872_1_, AxisAlignedBB p_72872_2_) {
      return this.func_175647_a(p_72872_1_, p_72872_2_, IEntitySelector.field_180132_d);
   }

   public List func_175647_a(Class p_175647_1_, AxisAlignedBB p_175647_2_, Predicate p_175647_3_) {
      int var4 = MathHelper.func_76128_c((p_175647_2_.field_72340_a - 2.0D) / 16.0D);
      int var5 = MathHelper.func_76128_c((p_175647_2_.field_72336_d + 2.0D) / 16.0D);
      int var6 = MathHelper.func_76128_c((p_175647_2_.field_72339_c - 2.0D) / 16.0D);
      int var7 = MathHelper.func_76128_c((p_175647_2_.field_72334_f + 2.0D) / 16.0D);
      ArrayList var8 = Lists.newArrayList();

      for(int var9 = var4; var9 <= var5; ++var9) {
         for(int var10 = var6; var10 <= var7; ++var10) {
            if(this.func_175680_a(var9, var10, true)) {
               this.func_72964_e(var9, var10).func_177430_a(p_175647_1_, p_175647_2_, var8, p_175647_3_);
            }
         }
      }

      return var8;
   }

   public Entity func_72857_a(Class p_72857_1_, AxisAlignedBB p_72857_2_, Entity p_72857_3_) {
      List var4 = this.func_72872_a(p_72857_1_, p_72857_2_);
      Entity var5 = null;
      double var6 = Double.MAX_VALUE;

      for(int var8 = 0; var8 < var4.size(); ++var8) {
         Entity var9 = (Entity)var4.get(var8);
         if(var9 != p_72857_3_ && IEntitySelector.field_180132_d.apply(var9)) {
            double var10 = p_72857_3_.func_70068_e(var9);
            if(var10 <= var6) {
               var5 = var9;
               var6 = var10;
            }
         }
      }

      return var5;
   }

   public Entity func_73045_a(int p_73045_1_) {
      return (Entity)this.field_175729_l.func_76041_a(p_73045_1_);
   }

   public List func_72910_y() {
      return this.field_72996_f;
   }

   public void func_175646_b(BlockPos p_175646_1_, TileEntity p_175646_2_) {
      if(this.func_175667_e(p_175646_1_)) {
         this.func_175726_f(p_175646_1_).func_76630_e();
      }

   }

   public int func_72907_a(Class p_72907_1_) {
      int var2 = 0;
      Iterator var3 = this.field_72996_f.iterator();

      while(var3.hasNext()) {
         Entity var4 = (Entity)var3.next();
         if((!(var4 instanceof EntityLiving) || !((EntityLiving)var4).func_104002_bU()) && p_72907_1_.isAssignableFrom(var4.getClass())) {
            ++var2;
         }
      }

      return var2;
   }

   public void func_175650_b(Collection p_175650_1_) {
      this.field_72996_f.addAll(p_175650_1_);
      Iterator var2 = p_175650_1_.iterator();

      while(var2.hasNext()) {
         Entity var3 = (Entity)var2.next();
         this.func_72923_a(var3);
      }

   }

   public void func_175681_c(Collection p_175681_1_) {
      this.field_72997_g.addAll(p_175681_1_);
   }

   public boolean func_175716_a(Block p_175716_1_, BlockPos p_175716_2_, boolean p_175716_3_, EnumFacing p_175716_4_, Entity p_175716_5_, ItemStack p_175716_6_) {
      Block var7 = this.func_180495_p(p_175716_2_).func_177230_c();
      AxisAlignedBB var8 = p_175716_3_?null:p_175716_1_.func_180640_a(this, p_175716_2_, p_175716_1_.func_176223_P());
      return var8 != null && !this.func_72917_a(var8, p_175716_5_)?false:(var7.func_149688_o() == Material.field_151594_q && p_175716_1_ == Blocks.field_150467_bQ?true:var7.func_149688_o().func_76222_j() && p_175716_1_.func_176193_a(this, p_175716_2_, p_175716_4_, p_175716_6_));
   }

   public int func_175627_a(BlockPos p_175627_1_, EnumFacing p_175627_2_) {
      IBlockState var3 = this.func_180495_p(p_175627_1_);
      return var3.func_177230_c().func_176211_b(this, p_175627_1_, var3, p_175627_2_);
   }

   public WorldType func_175624_G() {
      return this.field_72986_A.func_76067_t();
   }

   public int func_175676_y(BlockPos p_175676_1_) {
      byte var2 = 0;
      int var3 = Math.max(var2, this.func_175627_a(p_175676_1_.func_177977_b(), EnumFacing.DOWN));
      if(var3 >= 15) {
         return var3;
      } else {
         var3 = Math.max(var3, this.func_175627_a(p_175676_1_.func_177984_a(), EnumFacing.UP));
         if(var3 >= 15) {
            return var3;
         } else {
            var3 = Math.max(var3, this.func_175627_a(p_175676_1_.func_177978_c(), EnumFacing.NORTH));
            if(var3 >= 15) {
               return var3;
            } else {
               var3 = Math.max(var3, this.func_175627_a(p_175676_1_.func_177968_d(), EnumFacing.SOUTH));
               if(var3 >= 15) {
                  return var3;
               } else {
                  var3 = Math.max(var3, this.func_175627_a(p_175676_1_.func_177976_e(), EnumFacing.WEST));
                  if(var3 >= 15) {
                     return var3;
                  } else {
                     var3 = Math.max(var3, this.func_175627_a(p_175676_1_.func_177974_f(), EnumFacing.EAST));
                     return var3 >= 15?var3:var3;
                  }
               }
            }
         }
      }
   }

   public boolean func_175709_b(BlockPos p_175709_1_, EnumFacing p_175709_2_) {
      return this.func_175651_c(p_175709_1_, p_175709_2_) > 0;
   }

   public int func_175651_c(BlockPos p_175651_1_, EnumFacing p_175651_2_) {
      IBlockState var3 = this.func_180495_p(p_175651_1_);
      Block var4 = var3.func_177230_c();
      return var4.func_149721_r()?this.func_175676_y(p_175651_1_):var4.func_180656_a(this, p_175651_1_, var3, p_175651_2_);
   }

   public boolean func_175640_z(BlockPos p_175640_1_) {
      return this.func_175651_c(p_175640_1_.func_177977_b(), EnumFacing.DOWN) > 0?true:(this.func_175651_c(p_175640_1_.func_177984_a(), EnumFacing.UP) > 0?true:(this.func_175651_c(p_175640_1_.func_177978_c(), EnumFacing.NORTH) > 0?true:(this.func_175651_c(p_175640_1_.func_177968_d(), EnumFacing.SOUTH) > 0?true:(this.func_175651_c(p_175640_1_.func_177976_e(), EnumFacing.WEST) > 0?true:this.func_175651_c(p_175640_1_.func_177974_f(), EnumFacing.EAST) > 0))));
   }

   public int func_175687_A(BlockPos p_175687_1_) {
      int var2 = 0;
      EnumFacing[] var3 = EnumFacing.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EnumFacing var6 = var3[var5];
         int var7 = this.func_175651_c(p_175687_1_.func_177972_a(var6), var6);
         if(var7 >= 15) {
            return 15;
         }

         if(var7 > var2) {
            var2 = var7;
         }
      }

      return var2;
   }

   public EntityPlayer func_72890_a(Entity p_72890_1_, double p_72890_2_) {
      return this.func_72977_a(p_72890_1_.field_70165_t, p_72890_1_.field_70163_u, p_72890_1_.field_70161_v, p_72890_2_);
   }

   public EntityPlayer func_72977_a(double p_72977_1_, double p_72977_3_, double p_72977_5_, double p_72977_7_) {
      double var9 = -1.0D;
      EntityPlayer var11 = null;

      for(int var12 = 0; var12 < this.field_73010_i.size(); ++var12) {
         EntityPlayer var13 = (EntityPlayer)this.field_73010_i.get(var12);
         if(IEntitySelector.field_180132_d.apply(var13)) {
            double var14 = var13.func_70092_e(p_72977_1_, p_72977_3_, p_72977_5_);
            if((p_72977_7_ < 0.0D || var14 < p_72977_7_ * p_72977_7_) && (var9 == -1.0D || var14 < var9)) {
               var9 = var14;
               var11 = var13;
            }
         }
      }

      return var11;
   }

   public boolean func_175636_b(double p_175636_1_, double p_175636_3_, double p_175636_5_, double p_175636_7_) {
      for(int var9 = 0; var9 < this.field_73010_i.size(); ++var9) {
         EntityPlayer var10 = (EntityPlayer)this.field_73010_i.get(var9);
         if(IEntitySelector.field_180132_d.apply(var10)) {
            double var11 = var10.func_70092_e(p_175636_1_, p_175636_3_, p_175636_5_);
            if(p_175636_7_ < 0.0D || var11 < p_175636_7_ * p_175636_7_) {
               return true;
            }
         }
      }

      return false;
   }

   public EntityPlayer func_72924_a(String p_72924_1_) {
      for(int var2 = 0; var2 < this.field_73010_i.size(); ++var2) {
         EntityPlayer var3 = (EntityPlayer)this.field_73010_i.get(var2);
         if(p_72924_1_.equals(var3.func_70005_c_())) {
            return var3;
         }
      }

      return null;
   }

   public EntityPlayer func_152378_a(UUID p_152378_1_) {
      for(int var2 = 0; var2 < this.field_73010_i.size(); ++var2) {
         EntityPlayer var3 = (EntityPlayer)this.field_73010_i.get(var2);
         if(p_152378_1_.equals(var3.func_110124_au())) {
            return var3;
         }
      }

      return null;
   }

   public void func_72882_A() {}

   public void func_72906_B() throws MinecraftException {
      this.field_73019_z.func_75762_c();
   }

   public void func_82738_a(long p_82738_1_) {
      this.field_72986_A.func_82572_b(p_82738_1_);
   }

   public long func_72905_C() {
      return this.field_72986_A.func_76063_b();
   }

   public long func_82737_E() {
      return this.field_72986_A.func_82573_f();
   }

   public long func_72820_D() {
      return this.field_72986_A.func_76073_f();
   }

   public void func_72877_b(long p_72877_1_) {
      this.field_72986_A.func_76068_b(p_72877_1_);
   }

   public BlockPos func_175694_M() {
      BlockPos var1 = new BlockPos(this.field_72986_A.func_76079_c(), this.field_72986_A.func_76075_d(), this.field_72986_A.func_76074_e());
      if(!this.func_175723_af().func_177746_a(var1)) {
         var1 = this.func_175645_m(new BlockPos(this.func_175723_af().func_177731_f(), 0.0D, this.func_175723_af().func_177721_g()));
      }

      return var1;
   }

   public void func_175652_B(BlockPos p_175652_1_) {
      this.field_72986_A.func_176143_a(p_175652_1_);
   }

   public void func_72897_h(Entity p_72897_1_) {
      int var2 = MathHelper.func_76128_c(p_72897_1_.field_70165_t / 16.0D);
      int var3 = MathHelper.func_76128_c(p_72897_1_.field_70161_v / 16.0D);
      byte var4 = 2;

      for(int var5 = var2 - var4; var5 <= var2 + var4; ++var5) {
         for(int var6 = var3 - var4; var6 <= var3 + var4; ++var6) {
            this.func_72964_e(var5, var6);
         }
      }

      if(!this.field_72996_f.contains(p_72897_1_)) {
         this.field_72996_f.add(p_72897_1_);
      }

   }

   public boolean func_175660_a(EntityPlayer p_175660_1_, BlockPos p_175660_2_) {
      return true;
   }

   public void func_72960_a(Entity p_72960_1_, byte p_72960_2_) {}

   public IChunkProvider func_72863_F() {
      return this.field_73020_y;
   }

   public void func_175641_c(BlockPos p_175641_1_, Block p_175641_2_, int p_175641_3_, int p_175641_4_) {
      p_175641_2_.func_180648_a(this, p_175641_1_, this.func_180495_p(p_175641_1_), p_175641_3_, p_175641_4_);
   }

   public ISaveHandler func_72860_G() {
      return this.field_73019_z;
   }

   public WorldInfo func_72912_H() {
      return this.field_72986_A;
   }

   public GameRules func_82736_K() {
      return this.field_72986_A.func_82574_x();
   }

   public void func_72854_c() {}

   public float func_72819_i(float p_72819_1_) {
      return (this.field_73018_p + (this.field_73017_q - this.field_73018_p) * p_72819_1_) * this.func_72867_j(p_72819_1_);
   }

   public void func_147442_i(float p_147442_1_) {
      this.field_73018_p = p_147442_1_;
      this.field_73017_q = p_147442_1_;
   }

   public float func_72867_j(float p_72867_1_) {
      return this.field_73003_n + (this.field_73004_o - this.field_73003_n) * p_72867_1_;
   }

   public void func_72894_k(float p_72894_1_) {
      this.field_73003_n = p_72894_1_;
      this.field_73004_o = p_72894_1_;
   }

   public boolean func_72911_I() {
      return (double)this.func_72819_i(1.0F) > 0.9D;
   }

   public boolean func_72896_J() {
      return (double)this.func_72867_j(1.0F) > 0.2D;
   }

   public boolean func_175727_C(BlockPos p_175727_1_) {
      if(!this.func_72896_J()) {
         return false;
      } else if(!this.func_175678_i(p_175727_1_)) {
         return false;
      } else if(this.func_175725_q(p_175727_1_).func_177956_o() > p_175727_1_.func_177956_o()) {
         return false;
      } else {
         BiomeGenBase var2 = this.func_180494_b(p_175727_1_);
         return var2.func_76746_c()?false:(this.func_175708_f(p_175727_1_, false)?false:var2.func_76738_d());
      }
   }

   public boolean func_180502_D(BlockPos p_180502_1_) {
      BiomeGenBase var2 = this.func_180494_b(p_180502_1_);
      return var2.func_76736_e();
   }

   public MapStorage func_175693_T() {
      return this.field_72988_C;
   }

   public void func_72823_a(String p_72823_1_, WorldSavedData p_72823_2_) {
      this.field_72988_C.func_75745_a(p_72823_1_, p_72823_2_);
   }

   public WorldSavedData func_72943_a(Class p_72943_1_, String p_72943_2_) {
      return this.field_72988_C.func_75742_a(p_72943_1_, p_72943_2_);
   }

   public int func_72841_b(String p_72841_1_) {
      return this.field_72988_C.func_75743_a(p_72841_1_);
   }

   public void func_175669_a(int p_175669_1_, BlockPos p_175669_2_, int p_175669_3_) {
      for(int var4 = 0; var4 < this.field_73021_x.size(); ++var4) {
         ((IWorldAccess)this.field_73021_x.get(var4)).func_180440_a(p_175669_1_, p_175669_2_, p_175669_3_);
      }

   }

   public void func_175718_b(int p_175718_1_, BlockPos p_175718_2_, int p_175718_3_) {
      this.func_180498_a((EntityPlayer)null, p_175718_1_, p_175718_2_, p_175718_3_);
   }

   public void func_180498_a(EntityPlayer p_180498_1_, int p_180498_2_, BlockPos p_180498_3_, int p_180498_4_) {
      try {
         for(int var5 = 0; var5 < this.field_73021_x.size(); ++var5) {
            ((IWorldAccess)this.field_73021_x.get(var5)).func_180439_a(p_180498_1_, p_180498_2_, p_180498_3_, p_180498_4_);
         }

      } catch (Throwable var8) {
         CrashReport var6 = CrashReport.func_85055_a(var8, "Playing level event");
         CrashReportCategory var7 = var6.func_85058_a("Level event being played");
         var7.func_71507_a("Block coordinates", CrashReportCategory.func_180522_a(p_180498_3_));
         var7.func_71507_a("Event source", p_180498_1_);
         var7.func_71507_a("Event type", Integer.valueOf(p_180498_2_));
         var7.func_71507_a("Event data", Integer.valueOf(p_180498_4_));
         throw new ReportedException(var6);
      }
   }

   public int func_72800_K() {
      return 256;
   }

   public int func_72940_L() {
      return this.field_73011_w.func_177495_o()?128:256;
   }

   public Random func_72843_D(int p_72843_1_, int p_72843_2_, int p_72843_3_) {
      long var4 = (long)p_72843_1_ * 341873128712L + (long)p_72843_2_ * 132897987541L + this.func_72912_H().func_76063_b() + (long)p_72843_3_;
      this.field_73012_v.setSeed(var4);
      return this.field_73012_v;
   }

   public BlockPos func_180499_a(String p_180499_1_, BlockPos p_180499_2_) {
      return this.func_72863_F().func_180513_a(this, p_180499_1_, p_180499_2_);
   }

   public boolean func_72806_N() {
      return false;
   }

   public double func_72919_O() {
      return this.field_72986_A.func_76067_t() == WorldType.field_77138_c?0.0D:63.0D;
   }

   public CrashReportCategory func_72914_a(CrashReport p_72914_1_) {
      CrashReportCategory var2 = p_72914_1_.func_85057_a("Affected level", 1);
      var2.func_71507_a("Level name", this.field_72986_A == null?"????":this.field_72986_A.func_76065_j());
      var2.func_71500_a("All players", new Callable() {

         private static final String __OBFID = "CL_00000143";

         public String call() {
            return World.this.field_73010_i.size() + " total; " + World.this.field_73010_i.toString();
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      var2.func_71500_a("Chunk stats", new Callable() {

         private static final String __OBFID = "CL_00000144";

         public String call() {
            return World.this.field_73020_y.func_73148_d();
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });

      try {
         this.field_72986_A.func_85118_a(var2);
      } catch (Throwable var4) {
         var2.func_71499_a("Level Data Unobtainable", var4);
      }

      return var2;
   }

   public void func_175715_c(int p_175715_1_, BlockPos p_175715_2_, int p_175715_3_) {
      for(int var4 = 0; var4 < this.field_73021_x.size(); ++var4) {
         IWorldAccess var5 = (IWorldAccess)this.field_73021_x.get(var4);
         var5.func_180441_b(p_175715_1_, p_175715_2_, p_175715_3_);
      }

   }

   public Calendar func_83015_S() {
      if(this.func_82737_E() % 600L == 0L) {
         this.field_83016_L.setTimeInMillis(MinecraftServer.func_130071_aq());
      }

      return this.field_83016_L;
   }

   public void func_92088_a(double p_92088_1_, double p_92088_3_, double p_92088_5_, double p_92088_7_, double p_92088_9_, double p_92088_11_, NBTTagCompound p_92088_13_) {}

   public Scoreboard func_96441_U() {
      return this.field_96442_D;
   }

   public void func_175666_e(BlockPos p_175666_1_, Block p_175666_2_) {
      Iterator var3 = EnumFacing.Plane.HORIZONTAL.iterator();

      while(var3.hasNext()) {
         EnumFacing var4 = (EnumFacing)var3.next();
         BlockPos var5 = p_175666_1_.func_177972_a(var4);
         if(this.func_175667_e(var5)) {
            IBlockState var6 = this.func_180495_p(var5);
            if(Blocks.field_150441_bU.func_149907_e(var6.func_177230_c())) {
               var6.func_177230_c().func_176204_a(this, var5, var6, p_175666_2_);
            } else if(var6.func_177230_c().func_149721_r()) {
               var5 = var5.func_177972_a(var4);
               var6 = this.func_180495_p(var5);
               if(Blocks.field_150441_bU.func_149907_e(var6.func_177230_c())) {
                  var6.func_177230_c().func_176204_a(this, var5, var6, p_175666_2_);
               }
            }
         }
      }

   }

   public DifficultyInstance func_175649_E(BlockPos p_175649_1_) {
      long var2 = 0L;
      float var4 = 0.0F;
      if(this.func_175667_e(p_175649_1_)) {
         var4 = this.func_130001_d();
         var2 = this.func_175726_f(p_175649_1_).func_177416_w();
      }

      return new DifficultyInstance(this.func_175659_aa(), this.func_72820_D(), var2, var4);
   }

   public EnumDifficulty func_175659_aa() {
      return this.func_72912_H().func_176130_y();
   }

   public int func_175657_ab() {
      return this.field_73008_k;
   }

   public void func_175692_b(int p_175692_1_) {
      this.field_73008_k = p_175692_1_;
   }

   public int func_175658_ac() {
      return this.field_73016_r;
   }

   public void func_175702_c(int p_175702_1_) {
      this.field_73016_r = p_175702_1_;
   }

   public boolean func_175686_ad() {
      return this.field_72987_B;
   }

   public VillageCollection func_175714_ae() {
      return this.field_72982_D;
   }

   public WorldBorder func_175723_af() {
      return this.field_175728_M;
   }

   public boolean func_72916_c(int p_72916_1_, int p_72916_2_) {
      BlockPos var3 = this.func_175694_M();
      int var4 = p_72916_1_ * 16 + 8 - var3.func_177958_n();
      int var5 = p_72916_2_ * 16 + 8 - var3.func_177952_p();
      short var6 = 128;
      return var4 >= -var6 && var4 <= var6 && var5 >= -var6 && var5 <= var6;
   }
}
