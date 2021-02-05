package net.minecraft.world;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEventData;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.INpc;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.network.play.server.S19PacketEntityStatus;
import net.minecraft.network.play.server.S24PacketBlockAction;
import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.network.play.server.S2APacketParticles;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.network.play.server.S2CPacketSpawnGlobalEntity;
import net.minecraft.profiler.Profiler;
import net.minecraft.scoreboard.ScoreboardSaveData;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.ReportedException;
import net.minecraft.util.Vec3;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.village.VillageCollection;
import net.minecraft.village.VillageSiege;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.Explosion;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.NextTickListEntry;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraft.world.gen.feature.WorldGeneratorBonusChest;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorldServer extends World implements IThreadListener {

   private static final Logger field_147491_a = LogManager.getLogger();
   private final MinecraftServer field_73061_a;
   private final EntityTracker field_73062_L;
   private final PlayerManager field_73063_M;
   private final Set field_73064_N = Sets.newHashSet();
   private final TreeSet field_73065_O = new TreeSet();
   private final Map field_175741_N = Maps.newHashMap();
   public ChunkProviderServer field_73059_b;
   public boolean field_73058_d;
   private boolean field_73068_P;
   private int field_80004_Q;
   private final Teleporter field_85177_Q;
   private final SpawnerAnimals field_175742_R = new SpawnerAnimals();
   protected final VillageSiege field_175740_d = new VillageSiege(this);
   private WorldServer.ServerBlockEventList[] field_147490_S = new WorldServer.ServerBlockEventList[]{new WorldServer.ServerBlockEventList(null), new WorldServer.ServerBlockEventList(null)};
   private int field_147489_T;
   private static final List field_73069_S = Lists.newArrayList(new WeightedRandomChestContent[]{new WeightedRandomChestContent(Items.field_151055_y, 0, 1, 3, 10), new WeightedRandomChestContent(Item.func_150898_a(Blocks.field_150344_f), 0, 1, 3, 10), new WeightedRandomChestContent(Item.func_150898_a(Blocks.field_150364_r), 0, 1, 3, 10), new WeightedRandomChestContent(Items.field_151049_t, 0, 1, 1, 3), new WeightedRandomChestContent(Items.field_151053_p, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151050_s, 0, 1, 1, 3), new WeightedRandomChestContent(Items.field_151039_o, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151034_e, 0, 2, 3, 5), new WeightedRandomChestContent(Items.field_151025_P, 0, 2, 3, 3), new WeightedRandomChestContent(Item.func_150898_a(Blocks.field_150363_s), 0, 1, 3, 10)});
   private List field_94579_S = Lists.newArrayList();
   private static final String __OBFID = "CL_00001437";


   public WorldServer(MinecraftServer p_i45921_1_, ISaveHandler p_i45921_2_, WorldInfo p_i45921_3_, int p_i45921_4_, Profiler p_i45921_5_) {
      super(p_i45921_2_, p_i45921_3_, WorldProvider.func_76570_a(p_i45921_4_), p_i45921_5_, false);
      this.field_73061_a = p_i45921_1_;
      this.field_73062_L = new EntityTracker(this);
      this.field_73063_M = new PlayerManager(this);
      this.field_73011_w.func_76558_a(this);
      this.field_73020_y = this.func_72970_h();
      this.field_85177_Q = new Teleporter(this);
      this.func_72966_v();
      this.func_72947_a();
      this.func_175723_af().func_177725_a(p_i45921_1_.func_175580_aG());
   }

   public World func_175643_b() {
      this.field_72988_C = new MapStorage(this.field_73019_z);
      String var1 = VillageCollection.func_176062_a(this.field_73011_w);
      VillageCollection var2 = (VillageCollection)this.field_72988_C.func_75742_a(VillageCollection.class, var1);
      if(var2 == null) {
         this.field_72982_D = new VillageCollection(this);
         this.field_72988_C.func_75745_a(var1, this.field_72982_D);
      } else {
         this.field_72982_D = var2;
         this.field_72982_D.func_82566_a(this);
      }

      this.field_96442_D = new ServerScoreboard(this.field_73061_a);
      ScoreboardSaveData var3 = (ScoreboardSaveData)this.field_72988_C.func_75742_a(ScoreboardSaveData.class, "scoreboard");
      if(var3 == null) {
         var3 = new ScoreboardSaveData();
         this.field_72988_C.func_75745_a("scoreboard", var3);
      }

      var3.func_96499_a(this.field_96442_D);
      ((ServerScoreboard)this.field_96442_D).func_96547_a(var3);
      this.func_175723_af().func_177739_c(this.field_72986_A.func_176120_C(), this.field_72986_A.func_176126_D());
      this.func_175723_af().func_177744_c(this.field_72986_A.func_176140_I());
      this.func_175723_af().func_177724_b(this.field_72986_A.func_176138_H());
      this.func_175723_af().func_177747_c(this.field_72986_A.func_176131_J());
      this.func_175723_af().func_177723_b(this.field_72986_A.func_176139_K());
      if(this.field_72986_A.func_176134_F() > 0L) {
         this.func_175723_af().func_177738_a(this.field_72986_A.func_176137_E(), this.field_72986_A.func_176132_G(), this.field_72986_A.func_176134_F());
      } else {
         this.func_175723_af().func_177750_a(this.field_72986_A.func_176137_E());
      }

      return this;
   }

   public void func_72835_b() {
      super.func_72835_b();
      if(this.func_72912_H().func_76093_s() && this.func_175659_aa() != EnumDifficulty.HARD) {
         this.func_72912_H().func_176144_a(EnumDifficulty.HARD);
      }

      this.field_73011_w.func_177499_m().func_76938_b();
      if(this.func_73056_e()) {
         if(this.func_82736_K().func_82766_b("doDaylightCycle")) {
            long var1 = this.field_72986_A.func_76073_f() + 24000L;
            this.field_72986_A.func_76068_b(var1 - var1 % 24000L);
         }

         this.func_73053_d();
      }

      this.field_72984_F.func_76320_a("mobSpawner");
      if(this.func_82736_K().func_82766_b("doMobSpawning") && this.field_72986_A.func_76067_t() != WorldType.field_180272_g) {
         this.field_175742_R.func_77192_a(this, this.field_72985_G, this.field_72992_H, this.field_72986_A.func_82573_f() % 400L == 0L);
      }

      this.field_72984_F.func_76318_c("chunkSource");
      this.field_73020_y.func_73156_b();
      int var3 = this.func_72967_a(1.0F);
      if(var3 != this.func_175657_ab()) {
         this.func_175692_b(var3);
      }

      this.field_72986_A.func_82572_b(this.field_72986_A.func_82573_f() + 1L);
      if(this.func_82736_K().func_82766_b("doDaylightCycle")) {
         this.field_72986_A.func_76068_b(this.field_72986_A.func_76073_f() + 1L);
      }

      this.field_72984_F.func_76318_c("tickPending");
      this.func_72955_a(false);
      this.field_72984_F.func_76318_c("tickBlocks");
      this.func_147456_g();
      this.field_72984_F.func_76318_c("chunkMap");
      this.field_73063_M.func_72693_b();
      this.field_72984_F.func_76318_c("village");
      this.field_72982_D.func_75544_a();
      this.field_175740_d.func_75528_a();
      this.field_72984_F.func_76318_c("portalForcer");
      this.field_85177_Q.func_85189_a(this.func_82737_E());
      this.field_72984_F.func_76319_b();
      this.func_147488_Z();
   }

   public BiomeGenBase.SpawnListEntry func_175734_a(EnumCreatureType p_175734_1_, BlockPos p_175734_2_) {
      List var3 = this.func_72863_F().func_177458_a(p_175734_1_, p_175734_2_);
      return var3 != null && !var3.isEmpty()?(BiomeGenBase.SpawnListEntry)WeightedRandom.func_76271_a(this.field_73012_v, var3):null;
   }

   public boolean func_175732_a(EnumCreatureType p_175732_1_, BiomeGenBase.SpawnListEntry p_175732_2_, BlockPos p_175732_3_) {
      List var4 = this.func_72863_F().func_177458_a(p_175732_1_, p_175732_3_);
      return var4 != null && !var4.isEmpty()?var4.contains(p_175732_2_):false;
   }

   public void func_72854_c() {
      this.field_73068_P = false;
      if(!this.field_73010_i.isEmpty()) {
         int var1 = 0;
         int var2 = 0;
         Iterator var3 = this.field_73010_i.iterator();

         while(var3.hasNext()) {
            EntityPlayer var4 = (EntityPlayer)var3.next();
            if(var4.func_175149_v()) {
               ++var1;
            } else if(var4.func_70608_bn()) {
               ++var2;
            }
         }

         this.field_73068_P = var2 > 0 && var2 >= this.field_73010_i.size() - var1;
      }

   }

   protected void func_73053_d() {
      this.field_73068_P = false;
      Iterator var1 = this.field_73010_i.iterator();

      while(var1.hasNext()) {
         EntityPlayer var2 = (EntityPlayer)var1.next();
         if(var2.func_70608_bn()) {
            var2.func_70999_a(false, false, true);
         }
      }

      this.func_73051_P();
   }

   private void func_73051_P() {
      this.field_72986_A.func_76080_g(0);
      this.field_72986_A.func_76084_b(false);
      this.field_72986_A.func_76090_f(0);
      this.field_72986_A.func_76069_a(false);
   }

   public boolean func_73056_e() {
      if(this.field_73068_P && !this.field_72995_K) {
         Iterator var1 = this.field_73010_i.iterator();

         EntityPlayer var2;
         do {
            if(!var1.hasNext()) {
               return true;
            }

            var2 = (EntityPlayer)var1.next();
         } while(!var2.func_175149_v() && var2.func_71026_bH());

         return false;
      } else {
         return false;
      }
   }

   public void func_72974_f() {
      if(this.field_72986_A.func_76075_d() <= 0) {
         this.field_72986_A.func_76056_b(64);
      }

      int var1 = this.field_72986_A.func_76079_c();
      int var2 = this.field_72986_A.func_76074_e();
      int var3 = 0;

      while(this.func_175703_c(new BlockPos(var1, 0, var2)).func_149688_o() == Material.field_151579_a) {
         var1 += this.field_73012_v.nextInt(8) - this.field_73012_v.nextInt(8);
         var2 += this.field_73012_v.nextInt(8) - this.field_73012_v.nextInt(8);
         ++var3;
         if(var3 == 10000) {
            break;
         }
      }

      this.field_72986_A.func_76058_a(var1);
      this.field_72986_A.func_76087_c(var2);
   }

   protected void func_147456_g() {
      super.func_147456_g();
      if(this.field_72986_A.func_76067_t() == WorldType.field_180272_g) {
         Iterator var21 = this.field_72993_I.iterator();

         while(var21.hasNext()) {
            ChunkCoordIntPair var22 = (ChunkCoordIntPair)var21.next();
            this.func_72964_e(var22.field_77276_a, var22.field_77275_b).func_150804_b(false);
         }

      } else {
         int var1 = 0;
         int var2 = 0;

         for(Iterator var3 = this.field_72993_I.iterator(); var3.hasNext(); this.field_72984_F.func_76319_b()) {
            ChunkCoordIntPair var4 = (ChunkCoordIntPair)var3.next();
            int var5 = var4.field_77276_a * 16;
            int var6 = var4.field_77275_b * 16;
            this.field_72984_F.func_76320_a("getChunk");
            Chunk var7 = this.func_72964_e(var4.field_77276_a, var4.field_77275_b);
            this.func_147467_a(var5, var6, var7);
            this.field_72984_F.func_76318_c("tickChunk");
            var7.func_150804_b(false);
            this.field_72984_F.func_76318_c("thunder");
            int var8;
            BlockPos var9;
            if(this.field_73012_v.nextInt(100000) == 0 && this.func_72896_J() && this.func_72911_I()) {
               this.field_73005_l = this.field_73005_l * 3 + 1013904223;
               var8 = this.field_73005_l >> 2;
               var9 = this.func_175736_a(new BlockPos(var5 + (var8 & 15), 0, var6 + (var8 >> 8 & 15)));
               if(this.func_175727_C(var9)) {
                  this.func_72942_c(new EntityLightningBolt(this, (double)var9.func_177958_n(), (double)var9.func_177956_o(), (double)var9.func_177952_p()));
               }
            }

            this.field_72984_F.func_76318_c("iceandsnow");
            if(this.field_73012_v.nextInt(16) == 0) {
               this.field_73005_l = this.field_73005_l * 3 + 1013904223;
               var8 = this.field_73005_l >> 2;
               var9 = this.func_175725_q(new BlockPos(var5 + (var8 & 15), 0, var6 + (var8 >> 8 & 15)));
               BlockPos var10 = var9.func_177977_b();
               if(this.func_175662_w(var10)) {
                  this.func_175656_a(var10, Blocks.field_150432_aD.func_176223_P());
               }

               if(this.func_72896_J() && this.func_175708_f(var9, true)) {
                  this.func_175656_a(var9, Blocks.field_150431_aC.func_176223_P());
               }

               if(this.func_72896_J() && this.func_180494_b(var10).func_76738_d()) {
                  this.func_180495_p(var10).func_177230_c().func_176224_k(this, var10);
               }
            }

            this.field_72984_F.func_76318_c("tickBlocks");
            var8 = this.func_82736_K().func_180263_c("randomTickSpeed");
            if(var8 > 0) {
               ExtendedBlockStorage[] var23 = var7.func_76587_i();
               int var24 = var23.length;

               for(int var11 = 0; var11 < var24; ++var11) {
                  ExtendedBlockStorage var12 = var23[var11];
                  if(var12 != null && var12.func_76675_b()) {
                     for(int var13 = 0; var13 < var8; ++var13) {
                        this.field_73005_l = this.field_73005_l * 3 + 1013904223;
                        int var14 = this.field_73005_l >> 2;
                        int var15 = var14 & 15;
                        int var16 = var14 >> 8 & 15;
                        int var17 = var14 >> 16 & 15;
                        ++var2;
                        BlockPos var18 = new BlockPos(var15 + var5, var17 + var12.func_76662_d(), var16 + var6);
                        IBlockState var19 = var12.func_177485_a(var15, var17, var16);
                        Block var20 = var19.func_177230_c();
                        if(var20.func_149653_t()) {
                           ++var1;
                           var20.func_180645_a(this, var18, var19, this.field_73012_v);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   protected BlockPos func_175736_a(BlockPos p_175736_1_) {
      BlockPos var2 = this.func_175725_q(p_175736_1_);
      AxisAlignedBB var3 = (new AxisAlignedBB(var2, new BlockPos(var2.func_177958_n(), this.func_72800_K(), var2.func_177952_p()))).func_72314_b(3.0D, 3.0D, 3.0D);
      List var4 = this.func_175647_a(EntityLivingBase.class, var3, new Predicate() {

         private static final String __OBFID = "CL_00001889";

         public boolean func_180242_a(EntityLivingBase p_180242_1_) {
            return p_180242_1_ != null && p_180242_1_.func_70089_S() && WorldServer.this.func_175678_i(p_180242_1_.func_180425_c());
         }
         // $FF: synthetic method
         public boolean apply(Object p_apply_1_) {
            return this.func_180242_a((EntityLivingBase)p_apply_1_);
         }
      });
      return !var4.isEmpty()?((EntityLivingBase)var4.get(this.field_73012_v.nextInt(var4.size()))).func_180425_c():var2;
   }

   public boolean func_175691_a(BlockPos p_175691_1_, Block p_175691_2_) {
      NextTickListEntry var3 = new NextTickListEntry(p_175691_1_, p_175691_2_);
      return this.field_94579_S.contains(var3);
   }

   public void func_175684_a(BlockPos p_175684_1_, Block p_175684_2_, int p_175684_3_) {
      this.func_175654_a(p_175684_1_, p_175684_2_, p_175684_3_, 0);
   }

   public void func_175654_a(BlockPos p_175654_1_, Block p_175654_2_, int p_175654_3_, int p_175654_4_) {
      NextTickListEntry var5 = new NextTickListEntry(p_175654_1_, p_175654_2_);
      byte var6 = 0;
      if(this.field_72999_e && p_175654_2_.func_149688_o() != Material.field_151579_a) {
         if(p_175654_2_.func_149698_L()) {
            var6 = 8;
            if(this.func_175707_a(var5.field_180282_a.func_177982_a(-var6, -var6, -var6), var5.field_180282_a.func_177982_a(var6, var6, var6))) {
               IBlockState var7 = this.func_180495_p(var5.field_180282_a);
               if(var7.func_177230_c().func_149688_o() != Material.field_151579_a && var7.func_177230_c() == var5.func_151351_a()) {
                  var7.func_177230_c().func_180650_b(this, var5.field_180282_a, var7, this.field_73012_v);
               }
            }

            return;
         }

         p_175654_3_ = 1;
      }

      if(this.func_175707_a(p_175654_1_.func_177982_a(-var6, -var6, -var6), p_175654_1_.func_177982_a(var6, var6, var6))) {
         if(p_175654_2_.func_149688_o() != Material.field_151579_a) {
            var5.func_77176_a((long)p_175654_3_ + this.field_72986_A.func_82573_f());
            var5.func_82753_a(p_175654_4_);
         }

         if(!this.field_73064_N.contains(var5)) {
            this.field_73064_N.add(var5);
            this.field_73065_O.add(var5);
         }
      }

   }

   public void func_180497_b(BlockPos p_180497_1_, Block p_180497_2_, int p_180497_3_, int p_180497_4_) {
      NextTickListEntry var5 = new NextTickListEntry(p_180497_1_, p_180497_2_);
      var5.func_82753_a(p_180497_4_);
      if(p_180497_2_.func_149688_o() != Material.field_151579_a) {
         var5.func_77176_a((long)p_180497_3_ + this.field_72986_A.func_82573_f());
      }

      if(!this.field_73064_N.contains(var5)) {
         this.field_73064_N.add(var5);
         this.field_73065_O.add(var5);
      }

   }

   public void func_72939_s() {
      if(this.field_73010_i.isEmpty()) {
         if(this.field_80004_Q++ >= 1200) {
            return;
         }
      } else {
         this.func_82742_i();
      }

      super.func_72939_s();
   }

   public void func_82742_i() {
      this.field_80004_Q = 0;
   }

   public boolean func_72955_a(boolean p_72955_1_) {
      if(this.field_72986_A.func_76067_t() == WorldType.field_180272_g) {
         return false;
      } else {
         int var2 = this.field_73065_O.size();
         if(var2 != this.field_73064_N.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
         } else {
            if(var2 > 1000) {
               var2 = 1000;
            }

            this.field_72984_F.func_76320_a("cleaning");

            NextTickListEntry var4;
            for(int var3 = 0; var3 < var2; ++var3) {
               var4 = (NextTickListEntry)this.field_73065_O.first();
               if(!p_72955_1_ && var4.field_77180_e > this.field_72986_A.func_82573_f()) {
                  break;
               }

               this.field_73065_O.remove(var4);
               this.field_73064_N.remove(var4);
               this.field_94579_S.add(var4);
            }

            this.field_72984_F.func_76319_b();
            this.field_72984_F.func_76320_a("ticking");
            Iterator var11 = this.field_94579_S.iterator();

            while(var11.hasNext()) {
               var4 = (NextTickListEntry)var11.next();
               var11.remove();
               byte var5 = 0;
               if(this.func_175707_a(var4.field_180282_a.func_177982_a(-var5, -var5, -var5), var4.field_180282_a.func_177982_a(var5, var5, var5))) {
                  IBlockState var6 = this.func_180495_p(var4.field_180282_a);
                  if(var6.func_177230_c().func_149688_o() != Material.field_151579_a && Block.func_149680_a(var6.func_177230_c(), var4.func_151351_a())) {
                     try {
                        var6.func_177230_c().func_180650_b(this, var4.field_180282_a, var6, this.field_73012_v);
                     } catch (Throwable var10) {
                        CrashReport var8 = CrashReport.func_85055_a(var10, "Exception while ticking a block");
                        CrashReportCategory var9 = var8.func_85058_a("Block being ticked");
                        CrashReportCategory.func_175750_a(var9, var4.field_180282_a, var6);
                        throw new ReportedException(var8);
                     }
                  }
               } else {
                  this.func_175684_a(var4.field_180282_a, var4.func_151351_a(), 0);
               }
            }

            this.field_72984_F.func_76319_b();
            this.field_94579_S.clear();
            return !this.field_73065_O.isEmpty();
         }
      }
   }

   public List func_72920_a(Chunk p_72920_1_, boolean p_72920_2_) {
      ChunkCoordIntPair var3 = p_72920_1_.func_76632_l();
      int var4 = (var3.field_77276_a << 4) - 2;
      int var5 = var4 + 16 + 2;
      int var6 = (var3.field_77275_b << 4) - 2;
      int var7 = var6 + 16 + 2;
      return this.func_175712_a(new StructureBoundingBox(var4, 0, var6, var5, 256, var7), p_72920_2_);
   }

   public List func_175712_a(StructureBoundingBox p_175712_1_, boolean p_175712_2_) {
      ArrayList var3 = null;

      for(int var4 = 0; var4 < 2; ++var4) {
         Iterator var5;
         if(var4 == 0) {
            var5 = this.field_73065_O.iterator();
         } else {
            var5 = this.field_94579_S.iterator();
            if(!this.field_94579_S.isEmpty()) {
               field_147491_a.debug("toBeTicked = " + this.field_94579_S.size());
            }
         }

         while(var5.hasNext()) {
            NextTickListEntry var6 = (NextTickListEntry)var5.next();
            BlockPos var7 = var6.field_180282_a;
            if(var7.func_177958_n() >= p_175712_1_.field_78897_a && var7.func_177958_n() < p_175712_1_.field_78893_d && var7.func_177952_p() >= p_175712_1_.field_78896_c && var7.func_177952_p() < p_175712_1_.field_78892_f) {
               if(p_175712_2_) {
                  this.field_73064_N.remove(var6);
                  var5.remove();
               }

               if(var3 == null) {
                  var3 = Lists.newArrayList();
               }

               var3.add(var6);
            }
         }
      }

      return var3;
   }

   public void func_72866_a(Entity p_72866_1_, boolean p_72866_2_) {
      if(!this.func_175735_ai() && (p_72866_1_ instanceof EntityAnimal || p_72866_1_ instanceof EntityWaterMob)) {
         p_72866_1_.func_70106_y();
      }

      if(!this.func_175738_ah() && p_72866_1_ instanceof INpc) {
         p_72866_1_.func_70106_y();
      }

      super.func_72866_a(p_72866_1_, p_72866_2_);
   }

   private boolean func_175738_ah() {
      return this.field_73061_a.func_71220_V();
   }

   private boolean func_175735_ai() {
      return this.field_73061_a.func_71268_U();
   }

   protected IChunkProvider func_72970_h() {
      IChunkLoader var1 = this.field_73019_z.func_75763_a(this.field_73011_w);
      this.field_73059_b = new ChunkProviderServer(this, var1, this.field_73011_w.func_76555_c());
      return this.field_73059_b;
   }

   public List func_147486_a(int p_147486_1_, int p_147486_2_, int p_147486_3_, int p_147486_4_, int p_147486_5_, int p_147486_6_) {
      ArrayList var7 = Lists.newArrayList();

      for(int var8 = 0; var8 < this.field_147482_g.size(); ++var8) {
         TileEntity var9 = (TileEntity)this.field_147482_g.get(var8);
         BlockPos var10 = var9.func_174877_v();
         if(var10.func_177958_n() >= p_147486_1_ && var10.func_177956_o() >= p_147486_2_ && var10.func_177952_p() >= p_147486_3_ && var10.func_177958_n() < p_147486_4_ && var10.func_177956_o() < p_147486_5_ && var10.func_177952_p() < p_147486_6_) {
            var7.add(var9);
         }
      }

      return var7;
   }

   public boolean func_175660_a(EntityPlayer p_175660_1_, BlockPos p_175660_2_) {
      return !this.field_73061_a.func_175579_a(this, p_175660_2_, p_175660_1_) && this.func_175723_af().func_177746_a(p_175660_2_);
   }

   public void func_72963_a(WorldSettings p_72963_1_) {
      if(!this.field_72986_A.func_76070_v()) {
         try {
            this.func_73052_b(p_72963_1_);
            if(this.field_72986_A.func_76067_t() == WorldType.field_180272_g) {
               this.func_175737_aj();
            }

            super.func_72963_a(p_72963_1_);
         } catch (Throwable var6) {
            CrashReport var3 = CrashReport.func_85055_a(var6, "Exception initializing level");

            try {
               this.func_72914_a(var3);
            } catch (Throwable var5) {
               ;
            }

            throw new ReportedException(var3);
         }

         this.field_72986_A.func_76091_d(true);
      }

   }

   private void func_175737_aj() {
      this.field_72986_A.func_176128_f(false);
      this.field_72986_A.func_176121_c(true);
      this.field_72986_A.func_76084_b(false);
      this.field_72986_A.func_76069_a(false);
      this.field_72986_A.func_176142_i(1000000000);
      this.field_72986_A.func_76068_b(6000L);
      this.field_72986_A.func_76060_a(WorldSettings.GameType.SPECTATOR);
      this.field_72986_A.func_176119_g(false);
      this.field_72986_A.func_176144_a(EnumDifficulty.PEACEFUL);
      this.field_72986_A.func_180783_e(true);
      this.func_82736_K().func_82764_b("doDaylightCycle", "false");
   }

   private void func_73052_b(WorldSettings p_73052_1_) {
      if(!this.field_73011_w.func_76567_e()) {
         this.field_72986_A.func_176143_a(BlockPos.field_177992_a.func_177981_b(this.field_73011_w.func_76557_i()));
      } else if(this.field_72986_A.func_76067_t() == WorldType.field_180272_g) {
         this.field_72986_A.func_176143_a(BlockPos.field_177992_a.func_177984_a());
      } else {
         this.field_72987_B = true;
         WorldChunkManager var2 = this.field_73011_w.func_177499_m();
         List var3 = var2.func_76932_a();
         Random var4 = new Random(this.func_72905_C());
         BlockPos var5 = var2.func_180630_a(0, 0, 256, var3, var4);
         int var6 = 0;
         int var7 = this.field_73011_w.func_76557_i();
         int var8 = 0;
         if(var5 != null) {
            var6 = var5.func_177958_n();
            var8 = var5.func_177952_p();
         } else {
            field_147491_a.warn("Unable to find spawn biome");
         }

         int var9 = 0;

         while(!this.field_73011_w.func_76566_a(var6, var8)) {
            var6 += var4.nextInt(64) - var4.nextInt(64);
            var8 += var4.nextInt(64) - var4.nextInt(64);
            ++var9;
            if(var9 == 1000) {
               break;
            }
         }

         this.field_72986_A.func_176143_a(new BlockPos(var6, var7, var8));
         this.field_72987_B = false;
         if(p_73052_1_.func_77167_c()) {
            this.func_73047_i();
         }

      }
   }

   protected void func_73047_i() {
      WorldGeneratorBonusChest var1 = new WorldGeneratorBonusChest(field_73069_S, 10);

      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = this.field_72986_A.func_76079_c() + this.field_73012_v.nextInt(6) - this.field_73012_v.nextInt(6);
         int var4 = this.field_72986_A.func_76074_e() + this.field_73012_v.nextInt(6) - this.field_73012_v.nextInt(6);
         BlockPos var5 = this.func_175672_r(new BlockPos(var3, 0, var4)).func_177984_a();
         if(var1.func_180709_b(this, this.field_73012_v, var5)) {
            break;
         }
      }

   }

   public BlockPos func_180504_m() {
      return this.field_73011_w.func_177496_h();
   }

   public void func_73044_a(boolean p_73044_1_, IProgressUpdate p_73044_2_) throws MinecraftException {
      if(this.field_73020_y.func_73157_c()) {
         if(p_73044_2_ != null) {
            p_73044_2_.func_73720_a("Saving level");
         }

         this.func_73042_a();
         if(p_73044_2_ != null) {
            p_73044_2_.func_73719_c("Saving chunks");
         }

         this.field_73020_y.func_73151_a(p_73044_1_, p_73044_2_);
         List var3 = this.field_73059_b.func_152380_a();
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            Chunk var5 = (Chunk)var4.next();
            if(!this.field_73063_M.func_152621_a(var5.field_76635_g, var5.field_76647_h)) {
               this.field_73059_b.func_73241_b(var5.field_76635_g, var5.field_76647_h);
            }
         }

      }
   }

   public void func_104140_m() {
      if(this.field_73020_y.func_73157_c()) {
         this.field_73020_y.func_104112_b();
      }
   }

   protected void func_73042_a() throws MinecraftException {
      this.func_72906_B();
      this.field_72986_A.func_176145_a(this.func_175723_af().func_177741_h());
      this.field_72986_A.func_176124_d(this.func_175723_af().func_177731_f());
      this.field_72986_A.func_176141_c(this.func_175723_af().func_177721_g());
      this.field_72986_A.func_176129_e(this.func_175723_af().func_177742_m());
      this.field_72986_A.func_176125_f(this.func_175723_af().func_177727_n());
      this.field_72986_A.func_176122_j(this.func_175723_af().func_177748_q());
      this.field_72986_A.func_176136_k(this.func_175723_af().func_177740_p());
      this.field_72986_A.func_176118_b(this.func_175723_af().func_177751_j());
      this.field_72986_A.func_176135_e(this.func_175723_af().func_177732_i());
      this.field_73019_z.func_75755_a(this.field_72986_A, this.field_73061_a.func_71203_ab().func_72378_q());
      this.field_72988_C.func_75744_a();
   }

   protected void func_72923_a(Entity p_72923_1_) {
      super.func_72923_a(p_72923_1_);
      this.field_175729_l.func_76038_a(p_72923_1_.func_145782_y(), p_72923_1_);
      this.field_175741_N.put(p_72923_1_.func_110124_au(), p_72923_1_);
      Entity[] var2 = p_72923_1_.func_70021_al();
      if(var2 != null) {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            this.field_175729_l.func_76038_a(var2[var3].func_145782_y(), var2[var3]);
         }
      }

   }

   protected void func_72847_b(Entity p_72847_1_) {
      super.func_72847_b(p_72847_1_);
      this.field_175729_l.func_76049_d(p_72847_1_.func_145782_y());
      this.field_175741_N.remove(p_72847_1_.func_110124_au());
      Entity[] var2 = p_72847_1_.func_70021_al();
      if(var2 != null) {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            this.field_175729_l.func_76049_d(var2[var3].func_145782_y());
         }
      }

   }

   public boolean func_72942_c(Entity p_72942_1_) {
      if(super.func_72942_c(p_72942_1_)) {
         this.field_73061_a.func_71203_ab().func_148541_a(p_72942_1_.field_70165_t, p_72942_1_.field_70163_u, p_72942_1_.field_70161_v, 512.0D, this.field_73011_w.func_177502_q(), new S2CPacketSpawnGlobalEntity(p_72942_1_));
         return true;
      } else {
         return false;
      }
   }

   public void func_72960_a(Entity p_72960_1_, byte p_72960_2_) {
      this.func_73039_n().func_151248_b(p_72960_1_, new S19PacketEntityStatus(p_72960_1_, p_72960_2_));
   }

   public Explosion func_72885_a(Entity p_72885_1_, double p_72885_2_, double p_72885_4_, double p_72885_6_, float p_72885_8_, boolean p_72885_9_, boolean p_72885_10_) {
      Explosion var11 = new Explosion(this, p_72885_1_, p_72885_2_, p_72885_4_, p_72885_6_, p_72885_8_, p_72885_9_, p_72885_10_);
      var11.func_77278_a();
      var11.func_77279_a(false);
      if(!p_72885_10_) {
         var11.func_180342_d();
      }

      Iterator var12 = this.field_73010_i.iterator();

      while(var12.hasNext()) {
         EntityPlayer var13 = (EntityPlayer)var12.next();
         if(var13.func_70092_e(p_72885_2_, p_72885_4_, p_72885_6_) < 4096.0D) {
            ((EntityPlayerMP)var13).field_71135_a.func_147359_a(new S27PacketExplosion(p_72885_2_, p_72885_4_, p_72885_6_, p_72885_8_, var11.func_180343_e(), (Vec3)var11.func_77277_b().get(var13)));
         }
      }

      return var11;
   }

   public void func_175641_c(BlockPos p_175641_1_, Block p_175641_2_, int p_175641_3_, int p_175641_4_) {
      BlockEventData var5 = new BlockEventData(p_175641_1_, p_175641_2_, p_175641_3_, p_175641_4_);
      Iterator var6 = this.field_147490_S[this.field_147489_T].iterator();

      BlockEventData var7;
      do {
         if(!var6.hasNext()) {
            this.field_147490_S[this.field_147489_T].add(var5);
            return;
         }

         var7 = (BlockEventData)var6.next();
      } while(!var7.equals(var5));

   }

   private void func_147488_Z() {
      while(!this.field_147490_S[this.field_147489_T].isEmpty()) {
         int var1 = this.field_147489_T;
         this.field_147489_T ^= 1;
         Iterator var2 = this.field_147490_S[var1].iterator();

         while(var2.hasNext()) {
            BlockEventData var3 = (BlockEventData)var2.next();
            if(this.func_147485_a(var3)) {
               this.field_73061_a.func_71203_ab().func_148541_a((double)var3.func_180328_a().func_177958_n(), (double)var3.func_180328_a().func_177956_o(), (double)var3.func_180328_a().func_177952_p(), 64.0D, this.field_73011_w.func_177502_q(), new S24PacketBlockAction(var3.func_180328_a(), var3.func_151337_f(), var3.func_151339_d(), var3.func_151338_e()));
            }
         }

         this.field_147490_S[var1].clear();
      }

   }

   private boolean func_147485_a(BlockEventData p_147485_1_) {
      IBlockState var2 = this.func_180495_p(p_147485_1_.func_180328_a());
      return var2.func_177230_c() == p_147485_1_.func_151337_f()?var2.func_177230_c().func_180648_a(this, p_147485_1_.func_180328_a(), var2, p_147485_1_.func_151339_d(), p_147485_1_.func_151338_e()):false;
   }

   public void func_73041_k() {
      this.field_73019_z.func_75759_a();
   }

   protected void func_72979_l() {
      boolean var1 = this.func_72896_J();
      super.func_72979_l();
      if(this.field_73003_n != this.field_73004_o) {
         this.field_73061_a.func_71203_ab().func_148537_a(new S2BPacketChangeGameState(7, this.field_73004_o), this.field_73011_w.func_177502_q());
      }

      if(this.field_73018_p != this.field_73017_q) {
         this.field_73061_a.func_71203_ab().func_148537_a(new S2BPacketChangeGameState(8, this.field_73017_q), this.field_73011_w.func_177502_q());
      }

      if(var1 != this.func_72896_J()) {
         if(var1) {
            this.field_73061_a.func_71203_ab().func_148540_a(new S2BPacketChangeGameState(2, 0.0F));
         } else {
            this.field_73061_a.func_71203_ab().func_148540_a(new S2BPacketChangeGameState(1, 0.0F));
         }

         this.field_73061_a.func_71203_ab().func_148540_a(new S2BPacketChangeGameState(7, this.field_73004_o));
         this.field_73061_a.func_71203_ab().func_148540_a(new S2BPacketChangeGameState(8, this.field_73017_q));
      }

   }

   protected int func_152379_p() {
      return this.field_73061_a.func_71203_ab().func_72395_o();
   }

   public MinecraftServer func_73046_m() {
      return this.field_73061_a;
   }

   public EntityTracker func_73039_n() {
      return this.field_73062_L;
   }

   public PlayerManager func_73040_p() {
      return this.field_73063_M;
   }

   public Teleporter func_85176_s() {
      return this.field_85177_Q;
   }

   public void func_175739_a(EnumParticleTypes p_175739_1_, double p_175739_2_, double p_175739_4_, double p_175739_6_, int p_175739_8_, double p_175739_9_, double p_175739_11_, double p_175739_13_, double p_175739_15_, int ... p_175739_17_) {
      this.func_180505_a(p_175739_1_, false, p_175739_2_, p_175739_4_, p_175739_6_, p_175739_8_, p_175739_9_, p_175739_11_, p_175739_13_, p_175739_15_, p_175739_17_);
   }

   public void func_180505_a(EnumParticleTypes p_180505_1_, boolean p_180505_2_, double p_180505_3_, double p_180505_5_, double p_180505_7_, int p_180505_9_, double p_180505_10_, double p_180505_12_, double p_180505_14_, double p_180505_16_, int ... p_180505_18_) {
      S2APacketParticles var19 = new S2APacketParticles(p_180505_1_, p_180505_2_, (float)p_180505_3_, (float)p_180505_5_, (float)p_180505_7_, (float)p_180505_10_, (float)p_180505_12_, (float)p_180505_14_, (float)p_180505_16_, p_180505_9_, p_180505_18_);

      for(int var20 = 0; var20 < this.field_73010_i.size(); ++var20) {
         EntityPlayerMP var21 = (EntityPlayerMP)this.field_73010_i.get(var20);
         BlockPos var22 = var21.func_180425_c();
         double var23 = var22.func_177954_c(p_180505_3_, p_180505_5_, p_180505_7_);
         if(var23 <= 256.0D || p_180505_2_ && var23 <= 65536.0D) {
            var21.field_71135_a.func_147359_a(var19);
         }
      }

   }

   public Entity func_175733_a(UUID p_175733_1_) {
      return (Entity)this.field_175741_N.get(p_175733_1_);
   }

   public ListenableFuture func_152344_a(Runnable p_152344_1_) {
      return this.field_73061_a.func_152344_a(p_152344_1_);
   }

   public boolean func_152345_ab() {
      return this.field_73061_a.func_152345_ab();
   }


   static class ServerBlockEventList extends ArrayList {

      private static final String __OBFID = "CL_00001439";


      private ServerBlockEventList() {}

      // $FF: synthetic method
      ServerBlockEventList(Object p_i1521_1_) {
         this();
      }
   }
}
