package net.minecraft.world.gen.layer;

import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.ChunkProviderSettings;
import net.minecraft.world.gen.layer.GenLayerAddIsland;
import net.minecraft.world.gen.layer.GenLayerAddMushroomIsland;
import net.minecraft.world.gen.layer.GenLayerAddSnow;
import net.minecraft.world.gen.layer.GenLayerBiome;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerDeepOcean;
import net.minecraft.world.gen.layer.GenLayerEdge;
import net.minecraft.world.gen.layer.GenLayerFuzzyZoom;
import net.minecraft.world.gen.layer.GenLayerHills;
import net.minecraft.world.gen.layer.GenLayerIsland;
import net.minecraft.world.gen.layer.GenLayerRareBiome;
import net.minecraft.world.gen.layer.GenLayerRemoveTooMuchOcean;
import net.minecraft.world.gen.layer.GenLayerRiver;
import net.minecraft.world.gen.layer.GenLayerRiverInit;
import net.minecraft.world.gen.layer.GenLayerRiverMix;
import net.minecraft.world.gen.layer.GenLayerShore;
import net.minecraft.world.gen.layer.GenLayerSmooth;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public abstract class GenLayer {

   private long field_75907_b;
   protected GenLayer field_75909_a;
   private long field_75908_c;
   protected long field_75906_d;
   private static final String __OBFID = "CL_00000559";


   public static GenLayer[] func_180781_a(long p_180781_0_, WorldType p_180781_2_, String p_180781_3_) {
      GenLayerIsland var4 = new GenLayerIsland(1L);
      GenLayerFuzzyZoom var13 = new GenLayerFuzzyZoom(2000L, var4);
      GenLayerAddIsland var14 = new GenLayerAddIsland(1L, var13);
      GenLayerZoom var15 = new GenLayerZoom(2001L, var14);
      var14 = new GenLayerAddIsland(2L, var15);
      var14 = new GenLayerAddIsland(50L, var14);
      var14 = new GenLayerAddIsland(70L, var14);
      GenLayerRemoveTooMuchOcean var16 = new GenLayerRemoveTooMuchOcean(2L, var14);
      GenLayerAddSnow var17 = new GenLayerAddSnow(2L, var16);
      var14 = new GenLayerAddIsland(3L, var17);
      GenLayerEdge var18 = new GenLayerEdge(2L, var14, GenLayerEdge.Mode.COOL_WARM);
      var18 = new GenLayerEdge(2L, var18, GenLayerEdge.Mode.HEAT_ICE);
      var18 = new GenLayerEdge(3L, var18, GenLayerEdge.Mode.SPECIAL);
      var15 = new GenLayerZoom(2002L, var18);
      var15 = new GenLayerZoom(2003L, var15);
      var14 = new GenLayerAddIsland(4L, var15);
      GenLayerAddMushroomIsland var19 = new GenLayerAddMushroomIsland(5L, var14);
      GenLayerDeepOcean var20 = new GenLayerDeepOcean(4L, var19);
      GenLayer var21 = GenLayerZoom.func_75915_a(1000L, var20, 0);
      ChunkProviderSettings var5 = null;
      int var6 = 4;
      int var7 = var6;
      if(p_180781_2_ == WorldType.field_180271_f && p_180781_3_.length() > 0) {
         var5 = ChunkProviderSettings.Factory.func_177865_a(p_180781_3_).func_177864_b();
         var6 = var5.field_177780_G;
         var7 = var5.field_177788_H;
      }

      if(p_180781_2_ == WorldType.field_77135_d) {
         var6 = 6;
      }

      GenLayer var8 = GenLayerZoom.func_75915_a(1000L, var21, 0);
      GenLayerRiverInit var22 = new GenLayerRiverInit(100L, var8);
      GenLayerBiome var9 = new GenLayerBiome(200L, var21, p_180781_2_, p_180781_3_);
      GenLayer var25 = GenLayerZoom.func_75915_a(1000L, var9, 2);
      GenLayerBiomeEdge var26 = new GenLayerBiomeEdge(1000L, var25);
      GenLayer var10 = GenLayerZoom.func_75915_a(1000L, var22, 2);
      GenLayerHills var27 = new GenLayerHills(1000L, var26, var10);
      var8 = GenLayerZoom.func_75915_a(1000L, var22, 2);
      var8 = GenLayerZoom.func_75915_a(1000L, var8, var7);
      GenLayerRiver var23 = new GenLayerRiver(1L, var8);
      GenLayerSmooth var24 = new GenLayerSmooth(1000L, var23);
      Object var28 = new GenLayerRareBiome(1001L, var27);

      for(int var11 = 0; var11 < var6; ++var11) {
         var28 = new GenLayerZoom((long)(1000 + var11), (GenLayer)var28);
         if(var11 == 0) {
            var28 = new GenLayerAddIsland(3L, (GenLayer)var28);
         }

         if(var11 == 1 || var6 == 1) {
            var28 = new GenLayerShore(1000L, (GenLayer)var28);
         }
      }

      GenLayerSmooth var29 = new GenLayerSmooth(1000L, (GenLayer)var28);
      GenLayerRiverMix var30 = new GenLayerRiverMix(100L, var29, var24);
      GenLayerVoronoiZoom var12 = new GenLayerVoronoiZoom(10L, var30);
      var30.func_75905_a(p_180781_0_);
      var12.func_75905_a(p_180781_0_);
      return new GenLayer[]{var30, var12, var30};
   }

   public GenLayer(long p_i2125_1_) {
      this.field_75906_d = p_i2125_1_;
      this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
      this.field_75906_d += p_i2125_1_;
      this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
      this.field_75906_d += p_i2125_1_;
      this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
      this.field_75906_d += p_i2125_1_;
   }

   public void func_75905_a(long p_75905_1_) {
      this.field_75907_b = p_75905_1_;
      if(this.field_75909_a != null) {
         this.field_75909_a.func_75905_a(p_75905_1_);
      }

      this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
      this.field_75907_b += this.field_75906_d;
      this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
      this.field_75907_b += this.field_75906_d;
      this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
      this.field_75907_b += this.field_75906_d;
   }

   public void func_75903_a(long p_75903_1_, long p_75903_3_) {
      this.field_75908_c = this.field_75907_b;
      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += p_75903_1_;
      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += p_75903_3_;
      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += p_75903_1_;
      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += p_75903_3_;
   }

   protected int func_75902_a(int p_75902_1_) {
      int var2 = (int)((this.field_75908_c >> 24) % (long)p_75902_1_);
      if(var2 < 0) {
         var2 += p_75902_1_;
      }

      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += this.field_75907_b;
      return var2;
   }

   public abstract int[] func_75904_a(int var1, int var2, int var3, int var4);

   protected static boolean func_151616_a(int p_151616_0_, int p_151616_1_) {
      if(p_151616_0_ == p_151616_1_) {
         return true;
      } else if(p_151616_0_ != BiomeGenBase.field_150607_aa.field_76756_M && p_151616_0_ != BiomeGenBase.field_150608_ab.field_76756_M) {
         final BiomeGenBase var2 = BiomeGenBase.func_150568_d(p_151616_0_);
         final BiomeGenBase var3 = BiomeGenBase.func_150568_d(p_151616_1_);

         try {
            return var2 != null && var3 != null?var2.func_150569_a(var3):false;
         } catch (Throwable var7) {
            CrashReport var5 = CrashReport.func_85055_a(var7, "Comparing biomes");
            CrashReportCategory var6 = var5.func_85058_a("Biomes being compared");
            var6.func_71507_a("Biome A ID", Integer.valueOf(p_151616_0_));
            var6.func_71507_a("Biome B ID", Integer.valueOf(p_151616_1_));
            var6.func_71500_a("Biome A", new Callable() {

               private static final String __OBFID = "CL_00000560";

               public String call() {
                  return String.valueOf(var2);
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            var6.func_71500_a("Biome B", new Callable() {

               private static final String __OBFID = "CL_00000561";

               public String call() {
                  return String.valueOf(var3);
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            throw new ReportedException(var5);
         }
      } else {
         return p_151616_1_ == BiomeGenBase.field_150607_aa.field_76756_M || p_151616_1_ == BiomeGenBase.field_150608_ab.field_76756_M;
      }
   }

   protected static boolean func_151618_b(int p_151618_0_) {
      return p_151618_0_ == BiomeGenBase.field_76771_b.field_76756_M || p_151618_0_ == BiomeGenBase.field_150575_M.field_76756_M || p_151618_0_ == BiomeGenBase.field_76776_l.field_76756_M;
   }

   protected int func_151619_a(int ... p_151619_1_) {
      return p_151619_1_[this.func_75902_a(p_151619_1_.length)];
   }

   protected int func_151617_b(int p_151617_1_, int p_151617_2_, int p_151617_3_, int p_151617_4_) {
      return p_151617_2_ == p_151617_3_ && p_151617_3_ == p_151617_4_?p_151617_2_:(p_151617_1_ == p_151617_2_ && p_151617_1_ == p_151617_3_?p_151617_1_:(p_151617_1_ == p_151617_2_ && p_151617_1_ == p_151617_4_?p_151617_1_:(p_151617_1_ == p_151617_3_ && p_151617_1_ == p_151617_4_?p_151617_1_:(p_151617_1_ == p_151617_2_ && p_151617_3_ != p_151617_4_?p_151617_1_:(p_151617_1_ == p_151617_3_ && p_151617_2_ != p_151617_4_?p_151617_1_:(p_151617_1_ == p_151617_4_ && p_151617_2_ != p_151617_3_?p_151617_1_:(p_151617_2_ == p_151617_3_ && p_151617_1_ != p_151617_4_?p_151617_2_:(p_151617_2_ == p_151617_4_ && p_151617_1_ != p_151617_3_?p_151617_2_:(p_151617_3_ == p_151617_4_ && p_151617_1_ != p_151617_2_?p_151617_3_:this.func_151619_a(new int[]{p_151617_1_, p_151617_2_, p_151617_3_, p_151617_4_}))))))))));
   }
}
