package net.minecraft.client.multiplayer;

import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MovingSoundMinecart;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.particle.EntityFireworkStarterFX;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.profiler.Profiler;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.SaveDataMemoryStorage;
import net.minecraft.world.storage.SaveHandlerMP;
import net.minecraft.world.storage.WorldInfo;

public class WorldClient extends World {

   private NetHandlerPlayClient field_73035_a;
   private ChunkProviderClient field_73033_b;
   private final Set field_73032_d = Sets.newHashSet();
   private final Set field_73036_L = Sets.newHashSet();
   private final Minecraft field_73037_M = Minecraft.func_71410_x();
   private final Set field_73038_N = Sets.newHashSet();
   private static final String __OBFID = "CL_00000882";


   public WorldClient(NetHandlerPlayClient p_i45063_1_, WorldSettings p_i45063_2_, int p_i45063_3_, EnumDifficulty p_i45063_4_, Profiler p_i45063_5_) {
      super(new SaveHandlerMP(), new WorldInfo(p_i45063_2_, "MpServer"), WorldProvider.func_76570_a(p_i45063_3_), p_i45063_5_, true);
      this.field_73035_a = p_i45063_1_;
      this.func_72912_H().func_176144_a(p_i45063_4_);
      this.func_175652_B(new BlockPos(8, 64, 8));
      this.field_73011_w.func_76558_a(this);
      this.field_73020_y = this.func_72970_h();
      this.field_72988_C = new SaveDataMemoryStorage();
      this.func_72966_v();
      this.func_72947_a();
   }

   public void func_72835_b() {
      super.func_72835_b();
      this.func_82738_a(this.func_82737_E() + 1L);
      if(this.func_82736_K().func_82766_b("doDaylightCycle")) {
         this.func_72877_b(this.func_72820_D() + 1L);
      }

      this.field_72984_F.func_76320_a("reEntryProcessing");

      for(int var1 = 0; var1 < 10 && !this.field_73036_L.isEmpty(); ++var1) {
         Entity var2 = (Entity)this.field_73036_L.iterator().next();
         this.field_73036_L.remove(var2);
         if(!this.field_72996_f.contains(var2)) {
            this.func_72838_d(var2);
         }
      }

      this.field_72984_F.func_76318_c("chunkCache");
      this.field_73033_b.func_73156_b();
      this.field_72984_F.func_76318_c("blocks");
      this.func_147456_g();
      this.field_72984_F.func_76319_b();
   }

   public void func_73031_a(int p_73031_1_, int p_73031_2_, int p_73031_3_, int p_73031_4_, int p_73031_5_, int p_73031_6_) {}

   protected IChunkProvider func_72970_h() {
      this.field_73033_b = new ChunkProviderClient(this);
      return this.field_73033_b;
   }

   protected void func_147456_g() {
      super.func_147456_g();
      this.field_73038_N.retainAll(this.field_72993_I);
      if(this.field_73038_N.size() == this.field_72993_I.size()) {
         this.field_73038_N.clear();
      }

      int var1 = 0;
      Iterator var2 = this.field_72993_I.iterator();

      while(var2.hasNext()) {
         ChunkCoordIntPair var3 = (ChunkCoordIntPair)var2.next();
         if(!this.field_73038_N.contains(var3)) {
            int var4 = var3.field_77276_a * 16;
            int var5 = var3.field_77275_b * 16;
            this.field_72984_F.func_76320_a("getChunk");
            Chunk var6 = this.func_72964_e(var3.field_77276_a, var3.field_77275_b);
            this.func_147467_a(var4, var5, var6);
            this.field_72984_F.func_76319_b();
            this.field_73038_N.add(var3);
            ++var1;
            if(var1 >= 10) {
               return;
            }
         }
      }

   }

   public void func_73025_a(int p_73025_1_, int p_73025_2_, boolean p_73025_3_) {
      if(p_73025_3_) {
         this.field_73033_b.func_73158_c(p_73025_1_, p_73025_2_);
      } else {
         this.field_73033_b.func_73234_b(p_73025_1_, p_73025_2_);
      }

      if(!p_73025_3_) {
         this.func_147458_c(p_73025_1_ * 16, 0, p_73025_2_ * 16, p_73025_1_ * 16 + 15, 256, p_73025_2_ * 16 + 15);
      }

   }

   public boolean func_72838_d(Entity p_72838_1_) {
      boolean var2 = super.func_72838_d(p_72838_1_);
      this.field_73032_d.add(p_72838_1_);
      if(!var2) {
         this.field_73036_L.add(p_72838_1_);
      } else if(p_72838_1_ instanceof EntityMinecart) {
         this.field_73037_M.func_147118_V().func_147682_a(new MovingSoundMinecart((EntityMinecart)p_72838_1_));
      }

      return var2;
   }

   public void func_72900_e(Entity p_72900_1_) {
      super.func_72900_e(p_72900_1_);
      this.field_73032_d.remove(p_72900_1_);
   }

   protected void func_72923_a(Entity p_72923_1_) {
      super.func_72923_a(p_72923_1_);
      if(this.field_73036_L.contains(p_72923_1_)) {
         this.field_73036_L.remove(p_72923_1_);
      }

   }

   protected void func_72847_b(Entity p_72847_1_) {
      super.func_72847_b(p_72847_1_);
      boolean var2 = false;
      if(this.field_73032_d.contains(p_72847_1_)) {
         if(p_72847_1_.func_70089_S()) {
            this.field_73036_L.add(p_72847_1_);
            var2 = true;
         } else {
            this.field_73032_d.remove(p_72847_1_);
         }
      }

   }

   public void func_73027_a(int p_73027_1_, Entity p_73027_2_) {
      Entity var3 = this.func_73045_a(p_73027_1_);
      if(var3 != null) {
         this.func_72900_e(var3);
      }

      this.field_73032_d.add(p_73027_2_);
      p_73027_2_.func_145769_d(p_73027_1_);
      if(!this.func_72838_d(p_73027_2_)) {
         this.field_73036_L.add(p_73027_2_);
      }

      this.field_175729_l.func_76038_a(p_73027_1_, p_73027_2_);
   }

   public Entity func_73045_a(int p_73045_1_) {
      return (Entity)(p_73045_1_ == this.field_73037_M.field_71439_g.func_145782_y()?this.field_73037_M.field_71439_g:super.func_73045_a(p_73045_1_));
   }

   public Entity func_73028_b(int p_73028_1_) {
      Entity var2 = (Entity)this.field_175729_l.func_76049_d(p_73028_1_);
      if(var2 != null) {
         this.field_73032_d.remove(var2);
         this.func_72900_e(var2);
      }

      return var2;
   }

   public boolean func_180503_b(BlockPos p_180503_1_, IBlockState p_180503_2_) {
      int var3 = p_180503_1_.func_177958_n();
      int var4 = p_180503_1_.func_177956_o();
      int var5 = p_180503_1_.func_177952_p();
      this.func_73031_a(var3, var4, var5, var3, var4, var5);
      return super.func_180501_a(p_180503_1_, p_180503_2_, 3);
   }

   public void func_72882_A() {
      this.field_73035_a.func_147298_b().func_150718_a(new ChatComponentText("Quitting"));
   }

   protected void func_72979_l() {}

   protected int func_152379_p() {
      return this.field_73037_M.field_71474_y.field_151451_c;
   }

   public void func_73029_E(int p_73029_1_, int p_73029_2_, int p_73029_3_) {
      byte var4 = 16;
      Random var5 = new Random();
      ItemStack var6 = this.field_73037_M.field_71439_g.func_70694_bm();
      boolean var7 = this.field_73037_M.field_71442_b.func_178889_l() == WorldSettings.GameType.CREATIVE && var6 != null && Block.func_149634_a(var6.func_77973_b()) == Blocks.field_180401_cv;

      for(int var8 = 0; var8 < 1000; ++var8) {
         int var9 = p_73029_1_ + this.field_73012_v.nextInt(var4) - this.field_73012_v.nextInt(var4);
         int var10 = p_73029_2_ + this.field_73012_v.nextInt(var4) - this.field_73012_v.nextInt(var4);
         int var11 = p_73029_3_ + this.field_73012_v.nextInt(var4) - this.field_73012_v.nextInt(var4);
         BlockPos var12 = new BlockPos(var9, var10, var11);
         IBlockState var13 = this.func_180495_p(var12);
         var13.func_177230_c().func_180655_c(this, var12, var13, var5);
         if(var7 && var13.func_177230_c() == Blocks.field_180401_cv) {
            this.func_175688_a(EnumParticleTypes.BARRIER, (double)((float)var9 + 0.5F), (double)((float)var10 + 0.5F), (double)((float)var11 + 0.5F), 0.0D, 0.0D, 0.0D, new int[0]);
         }
      }

   }

   public void func_73022_a() {
      this.field_72996_f.removeAll(this.field_72997_g);

      int var1;
      Entity var2;
      int var3;
      int var4;
      for(var1 = 0; var1 < this.field_72997_g.size(); ++var1) {
         var2 = (Entity)this.field_72997_g.get(var1);
         var3 = var2.field_70176_ah;
         var4 = var2.field_70164_aj;
         if(var2.field_70175_ag && this.func_175680_a(var3, var4, true)) {
            this.func_72964_e(var3, var4).func_76622_b(var2);
         }
      }

      for(var1 = 0; var1 < this.field_72997_g.size(); ++var1) {
         this.func_72847_b((Entity)this.field_72997_g.get(var1));
      }

      this.field_72997_g.clear();

      for(var1 = 0; var1 < this.field_72996_f.size(); ++var1) {
         var2 = (Entity)this.field_72996_f.get(var1);
         if(var2.field_70154_o != null) {
            if(!var2.field_70154_o.field_70128_L && var2.field_70154_o.field_70153_n == var2) {
               continue;
            }

            var2.field_70154_o.field_70153_n = null;
            var2.field_70154_o = null;
         }

         if(var2.field_70128_L) {
            var3 = var2.field_70176_ah;
            var4 = var2.field_70164_aj;
            if(var2.field_70175_ag && this.func_175680_a(var3, var4, true)) {
               this.func_72964_e(var3, var4).func_76622_b(var2);
            }

            this.field_72996_f.remove(var1--);
            this.func_72847_b(var2);
         }
      }

   }

   public CrashReportCategory func_72914_a(CrashReport p_72914_1_) {
      CrashReportCategory var2 = super.func_72914_a(p_72914_1_);
      var2.func_71500_a("Forced entities", new Callable() {

         private static final String __OBFID = "CL_00000883";

         public String call() {
            return WorldClient.this.field_73032_d.size() + " total; " + WorldClient.this.field_73032_d.toString();
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      var2.func_71500_a("Retry entities", new Callable() {

         private static final String __OBFID = "CL_00000884";

         public String call() {
            return WorldClient.this.field_73036_L.size() + " total; " + WorldClient.this.field_73036_L.toString();
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      var2.func_71500_a("Server brand", new Callable() {

         private static final String __OBFID = "CL_00000885";

         public String call() {
            return WorldClient.this.field_73037_M.field_71439_g.func_142021_k();
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      var2.func_71500_a("Server type", new Callable() {

         private static final String __OBFID = "CL_00000886";

         public String call() {
            return WorldClient.this.field_73037_M.func_71401_C() == null?"Non-integrated multiplayer server":"Integrated singleplayer server";
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      return var2;
   }

   public void func_175731_a(BlockPos p_175731_1_, String p_175731_2_, float p_175731_3_, float p_175731_4_, boolean p_175731_5_) {
      this.func_72980_b((double)p_175731_1_.func_177958_n() + 0.5D, (double)p_175731_1_.func_177956_o() + 0.5D, (double)p_175731_1_.func_177952_p() + 0.5D, p_175731_2_, p_175731_3_, p_175731_4_, p_175731_5_);
   }

   public void func_72980_b(double p_72980_1_, double p_72980_3_, double p_72980_5_, String p_72980_7_, float p_72980_8_, float p_72980_9_, boolean p_72980_10_) {
      double var11 = this.field_73037_M.func_175606_aa().func_70092_e(p_72980_1_, p_72980_3_, p_72980_5_);
      PositionedSoundRecord var13 = new PositionedSoundRecord(new ResourceLocation(p_72980_7_), p_72980_8_, p_72980_9_, (float)p_72980_1_, (float)p_72980_3_, (float)p_72980_5_);
      if(p_72980_10_ && var11 > 100.0D) {
         double var14 = Math.sqrt(var11) / 40.0D;
         this.field_73037_M.func_147118_V().func_147681_a(var13, (int)(var14 * 20.0D));
      } else {
         this.field_73037_M.func_147118_V().func_147682_a(var13);
      }

   }

   public void func_92088_a(double p_92088_1_, double p_92088_3_, double p_92088_5_, double p_92088_7_, double p_92088_9_, double p_92088_11_, NBTTagCompound p_92088_13_) {
      this.field_73037_M.field_71452_i.func_78873_a(new EntityFireworkStarterFX(this, p_92088_1_, p_92088_3_, p_92088_5_, p_92088_7_, p_92088_9_, p_92088_11_, this.field_73037_M.field_71452_i, p_92088_13_));
   }

   public void func_96443_a(Scoreboard p_96443_1_) {
      this.field_96442_D = p_96443_1_;
   }

   public void func_72877_b(long p_72877_1_) {
      if(p_72877_1_ < 0L) {
         p_72877_1_ = -p_72877_1_;
         this.func_82736_K().func_82764_b("doDaylightCycle", "false");
      } else {
         this.func_82736_K().func_82764_b("doDaylightCycle", "true");
      }

      super.func_72877_b(p_72877_1_);
   }
}
