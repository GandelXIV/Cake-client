package net.minecraft.world.gen;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.FlatGeneratorInfo;
import net.minecraft.world.gen.FlatLayerInfo;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraft.world.gen.structure.StructureOceanMonument;

public class ChunkProviderFlat implements IChunkProvider {

   private World field_73163_a;
   private Random field_73161_b;
   private final IBlockState[] field_82700_c = new IBlockState[256];
   private final FlatGeneratorInfo field_82699_e;
   private final List field_82696_f = Lists.newArrayList();
   private final boolean field_82697_g;
   private final boolean field_82702_h;
   private WorldGenLakes field_82703_i;
   private WorldGenLakes field_82701_j;
   private static final String __OBFID = "CL_00000391";


   public ChunkProviderFlat(World p_i2004_1_, long p_i2004_2_, boolean p_i2004_4_, String p_i2004_5_) {
      this.field_73163_a = p_i2004_1_;
      this.field_73161_b = new Random(p_i2004_2_);
      this.field_82699_e = FlatGeneratorInfo.func_82651_a(p_i2004_5_);
      if(p_i2004_4_) {
         Map var6 = this.field_82699_e.func_82644_b();
         if(var6.containsKey("village")) {
            Map var7 = (Map)var6.get("village");
            if(!var7.containsKey("size")) {
               var7.put("size", "1");
            }

            this.field_82696_f.add(new MapGenVillage(var7));
         }

         if(var6.containsKey("biome_1")) {
            this.field_82696_f.add(new MapGenScatteredFeature((Map)var6.get("biome_1")));
         }

         if(var6.containsKey("mineshaft")) {
            this.field_82696_f.add(new MapGenMineshaft((Map)var6.get("mineshaft")));
         }

         if(var6.containsKey("stronghold")) {
            this.field_82696_f.add(new MapGenStronghold((Map)var6.get("stronghold")));
         }

         if(var6.containsKey("oceanmonument")) {
            this.field_82696_f.add(new StructureOceanMonument((Map)var6.get("oceanmonument")));
         }
      }

      if(this.field_82699_e.func_82644_b().containsKey("lake")) {
         this.field_82703_i = new WorldGenLakes(Blocks.field_150355_j);
      }

      if(this.field_82699_e.func_82644_b().containsKey("lava_lake")) {
         this.field_82701_j = new WorldGenLakes(Blocks.field_150353_l);
      }

      this.field_82702_h = this.field_82699_e.func_82644_b().containsKey("dungeon");
      boolean var11 = true;
      Iterator var12 = this.field_82699_e.func_82650_c().iterator();

      while(var12.hasNext()) {
         FlatLayerInfo var8 = (FlatLayerInfo)var12.next();

         for(int var9 = var8.func_82656_d(); var9 < var8.func_82656_d() + var8.func_82657_a(); ++var9) {
            IBlockState var10 = var8.func_175900_c();
            if(var10.func_177230_c() != Blocks.field_150350_a) {
               var11 = false;
               this.field_82700_c[var9] = var10;
            }
         }
      }

      this.field_82697_g = var11?false:this.field_82699_e.func_82644_b().containsKey("decoration");
   }

   public Chunk func_73154_d(int p_73154_1_, int p_73154_2_) {
      ChunkPrimer var3 = new ChunkPrimer();

      int var7;
      for(int var4 = 0; var4 < this.field_82700_c.length; ++var4) {
         IBlockState var5 = this.field_82700_c[var4];
         if(var5 != null) {
            for(int var6 = 0; var6 < 16; ++var6) {
               for(var7 = 0; var7 < 16; ++var7) {
                  var3.func_177855_a(var6, var4, var7, var5);
               }
            }
         }
      }

      Iterator var8 = this.field_82696_f.iterator();

      while(var8.hasNext()) {
         MapGenBase var10 = (MapGenBase)var8.next();
         var10.func_175792_a(this, this.field_73163_a, p_73154_1_, p_73154_2_, var3);
      }

      Chunk var9 = new Chunk(this.field_73163_a, var3, p_73154_1_, p_73154_2_);
      BiomeGenBase[] var11 = this.field_73163_a.func_72959_q().func_76933_b((BiomeGenBase[])null, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16);
      byte[] var12 = var9.func_76605_m();

      for(var7 = 0; var7 < var12.length; ++var7) {
         var12[var7] = (byte)var11[var7].field_76756_M;
      }

      var9.func_76603_b();
      return var9;
   }

   public boolean func_73149_a(int p_73149_1_, int p_73149_2_) {
      return true;
   }

   public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
      int var4 = p_73153_2_ * 16;
      int var5 = p_73153_3_ * 16;
      BlockPos var6 = new BlockPos(var4, 0, var5);
      BiomeGenBase var7 = this.field_73163_a.func_180494_b(new BlockPos(var4 + 16, 0, var5 + 16));
      boolean var8 = false;
      this.field_73161_b.setSeed(this.field_73163_a.func_72905_C());
      long var9 = this.field_73161_b.nextLong() / 2L * 2L + 1L;
      long var11 = this.field_73161_b.nextLong() / 2L * 2L + 1L;
      this.field_73161_b.setSeed((long)p_73153_2_ * var9 + (long)p_73153_3_ * var11 ^ this.field_73163_a.func_72905_C());
      ChunkCoordIntPair var13 = new ChunkCoordIntPair(p_73153_2_, p_73153_3_);
      Iterator var14 = this.field_82696_f.iterator();

      while(var14.hasNext()) {
         MapGenStructure var15 = (MapGenStructure)var14.next();
         boolean var16 = var15.func_175794_a(this.field_73163_a, this.field_73161_b, var13);
         if(var15 instanceof MapGenVillage) {
            var8 |= var16;
         }
      }

      if(this.field_82703_i != null && !var8 && this.field_73161_b.nextInt(4) == 0) {
         this.field_82703_i.func_180709_b(this.field_73163_a, this.field_73161_b, var6.func_177982_a(this.field_73161_b.nextInt(16) + 8, this.field_73161_b.nextInt(256), this.field_73161_b.nextInt(16) + 8));
      }

      if(this.field_82701_j != null && !var8 && this.field_73161_b.nextInt(8) == 0) {
         BlockPos var17 = var6.func_177982_a(this.field_73161_b.nextInt(16) + 8, this.field_73161_b.nextInt(this.field_73161_b.nextInt(248) + 8), this.field_73161_b.nextInt(16) + 8);
         if(var17.func_177956_o() < 63 || this.field_73161_b.nextInt(10) == 0) {
            this.field_82701_j.func_180709_b(this.field_73163_a, this.field_73161_b, var17);
         }
      }

      if(this.field_82702_h) {
         for(int var18 = 0; var18 < 8; ++var18) {
            (new WorldGenDungeons()).func_180709_b(this.field_73163_a, this.field_73161_b, var6.func_177982_a(this.field_73161_b.nextInt(16) + 8, this.field_73161_b.nextInt(256), this.field_73161_b.nextInt(16) + 8));
         }
      }

      if(this.field_82697_g) {
         var7.func_180624_a(this.field_73163_a, this.field_73161_b, new BlockPos(var4, 0, var5));
      }

   }

   public boolean func_177460_a(IChunkProvider p_177460_1_, Chunk p_177460_2_, int p_177460_3_, int p_177460_4_) {
      return false;
   }

   public boolean func_73151_a(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
      return true;
   }

   public void func_104112_b() {}

   public boolean func_73156_b() {
      return false;
   }

   public boolean func_73157_c() {
      return true;
   }

   public String func_73148_d() {
      return "FlatLevelSource";
   }

   public List func_177458_a(EnumCreatureType p_177458_1_, BlockPos p_177458_2_) {
      BiomeGenBase var3 = this.field_73163_a.func_180494_b(p_177458_2_);
      return var3.func_76747_a(p_177458_1_);
   }

   public BlockPos func_180513_a(World p_180513_1_, String p_180513_2_, BlockPos p_180513_3_) {
      if("Stronghold".equals(p_180513_2_)) {
         Iterator var4 = this.field_82696_f.iterator();

         while(var4.hasNext()) {
            MapGenStructure var5 = (MapGenStructure)var4.next();
            if(var5 instanceof MapGenStronghold) {
               return var5.func_180706_b(p_180513_1_, p_180513_3_);
            }
         }
      }

      return null;
   }

   public int func_73152_e() {
      return 0;
   }

   public void func_180514_a(Chunk p_180514_1_, int p_180514_2_, int p_180514_3_) {
      Iterator var4 = this.field_82696_f.iterator();

      while(var4.hasNext()) {
         MapGenStructure var5 = (MapGenStructure)var4.next();
         var5.func_175792_a(this, this.field_73163_a, p_180514_2_, p_180514_3_, (ChunkPrimer)null);
      }

   }

   public Chunk func_177459_a(BlockPos p_177459_1_) {
      return this.func_73154_d(p_177459_1_.func_177958_n() >> 4, p_177459_1_.func_177952_p() >> 4);
   }
}
