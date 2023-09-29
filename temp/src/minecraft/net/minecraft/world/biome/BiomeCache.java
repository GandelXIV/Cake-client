package net.minecraft.world.biome;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.LongHashMap;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;

public class BiomeCache {

   private final WorldChunkManager field_76844_a;
   private long field_76842_b;
   private LongHashMap field_76843_c = new LongHashMap();
   private List field_76841_d = Lists.newArrayList();
   private static final String __OBFID = "CL_00000162";


   public BiomeCache(WorldChunkManager p_i1973_1_) {
      this.field_76844_a = p_i1973_1_;
   }

   public BiomeCache.Block func_76840_a(int p_76840_1_, int p_76840_2_) {
      p_76840_1_ >>= 4;
      p_76840_2_ >>= 4;
      long var3 = (long)p_76840_1_ & 4294967295L | ((long)p_76840_2_ & 4294967295L) << 32;
      BiomeCache.Block var5 = (BiomeCache.Block)this.field_76843_c.func_76164_a(var3);
      if(var5 == null) {
         var5 = new BiomeCache.Block(p_76840_1_, p_76840_2_);
         this.field_76843_c.func_76163_a(var3, var5);
         this.field_76841_d.add(var5);
      }

      var5.field_76886_f = MinecraftServer.func_130071_aq();
      return var5;
   }

   public BiomeGenBase func_180284_a(int p_180284_1_, int p_180284_2_, BiomeGenBase p_180284_3_) {
      BiomeGenBase var4 = this.func_76840_a(p_180284_1_, p_180284_2_).func_76885_a(p_180284_1_, p_180284_2_);
      return var4 == null?p_180284_3_:var4;
   }

   public void func_76838_a() {
      long var1 = MinecraftServer.func_130071_aq();
      long var3 = var1 - this.field_76842_b;
      if(var3 > 7500L || var3 < 0L) {
         this.field_76842_b = var1;

         for(int var5 = 0; var5 < this.field_76841_d.size(); ++var5) {
            BiomeCache.Block var6 = (BiomeCache.Block)this.field_76841_d.get(var5);
            long var7 = var1 - var6.field_76886_f;
            if(var7 > 30000L || var7 < 0L) {
               this.field_76841_d.remove(var5--);
               long var9 = (long)var6.field_76888_d & 4294967295L | ((long)var6.field_76889_e & 4294967295L) << 32;
               this.field_76843_c.func_76159_d(var9);
            }
         }
      }

   }

   public BiomeGenBase[] func_76839_e(int p_76839_1_, int p_76839_2_) {
      return this.func_76840_a(p_76839_1_, p_76839_2_).field_76891_c;
   }

   public class Block {

      public float[] field_76890_b = new float[256];
      public BiomeGenBase[] field_76891_c = new BiomeGenBase[256];
      public int field_76888_d;
      public int field_76889_e;
      public long field_76886_f;
      private static final String __OBFID = "CL_00000163";


      public Block(int p_i1972_2_, int p_i1972_3_) {
         this.field_76888_d = p_i1972_2_;
         this.field_76889_e = p_i1972_3_;
         BiomeCache.this.field_76844_a.func_76936_a(this.field_76890_b, p_i1972_2_ << 4, p_i1972_3_ << 4, 16, 16);
         BiomeCache.this.field_76844_a.func_76931_a(this.field_76891_c, p_i1972_2_ << 4, p_i1972_3_ << 4, 16, 16, false);
      }

      public BiomeGenBase func_76885_a(int p_76885_1_, int p_76885_2_) {
         return this.field_76891_c[p_76885_1_ & 15 | (p_76885_2_ & 15) << 4];
      }
   }
}
