package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenJungle;
import net.minecraft.world.biome.BiomeGenMesa;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerShore extends GenLayer {

   private static final String __OBFID = "CL_00000568";


   public GenLayerShore(long p_i2130_1_, GenLayer p_i2130_3_) {
      super(p_i2130_1_);
      this.field_75909_a = p_i2130_3_;
   }

   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
      int[] var5 = this.field_75909_a.func_75904_a(p_75904_1_ - 1, p_75904_2_ - 1, p_75904_3_ + 2, p_75904_4_ + 2);
      int[] var6 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);

      for(int var7 = 0; var7 < p_75904_4_; ++var7) {
         for(int var8 = 0; var8 < p_75904_3_; ++var8) {
            this.func_75903_a((long)(var8 + p_75904_1_), (long)(var7 + p_75904_2_));
            int var9 = var5[var8 + 1 + (var7 + 1) * (p_75904_3_ + 2)];
            BiomeGenBase var10 = BiomeGenBase.func_150568_d(var9);
            int var11;
            int var12;
            int var13;
            int var14;
            if(var9 == BiomeGenBase.field_76789_p.field_76756_M) {
               var11 = var5[var8 + 1 + (var7 + 1 - 1) * (p_75904_3_ + 2)];
               var12 = var5[var8 + 1 + 1 + (var7 + 1) * (p_75904_3_ + 2)];
               var13 = var5[var8 + 1 - 1 + (var7 + 1) * (p_75904_3_ + 2)];
               var14 = var5[var8 + 1 + (var7 + 1 + 1) * (p_75904_3_ + 2)];
               if(var11 != BiomeGenBase.field_76771_b.field_76756_M && var12 != BiomeGenBase.field_76771_b.field_76756_M && var13 != BiomeGenBase.field_76771_b.field_76756_M && var14 != BiomeGenBase.field_76771_b.field_76756_M) {
                  var6[var8 + var7 * p_75904_3_] = var9;
               } else {
                  var6[var8 + var7 * p_75904_3_] = BiomeGenBase.field_76788_q.field_76756_M;
               }
            } else if(var10 != null && var10.func_150562_l() == BiomeGenJungle.class) {
               var11 = var5[var8 + 1 + (var7 + 1 - 1) * (p_75904_3_ + 2)];
               var12 = var5[var8 + 1 + 1 + (var7 + 1) * (p_75904_3_ + 2)];
               var13 = var5[var8 + 1 - 1 + (var7 + 1) * (p_75904_3_ + 2)];
               var14 = var5[var8 + 1 + (var7 + 1 + 1) * (p_75904_3_ + 2)];
               if(this.func_151631_c(var11) && this.func_151631_c(var12) && this.func_151631_c(var13) && this.func_151631_c(var14)) {
                  if(!func_151618_b(var11) && !func_151618_b(var12) && !func_151618_b(var13) && !func_151618_b(var14)) {
                     var6[var8 + var7 * p_75904_3_] = var9;
                  } else {
                     var6[var8 + var7 * p_75904_3_] = BiomeGenBase.field_76787_r.field_76756_M;
                  }
               } else {
                  var6[var8 + var7 * p_75904_3_] = BiomeGenBase.field_150574_L.field_76756_M;
               }
            } else if(var9 != BiomeGenBase.field_76770_e.field_76756_M && var9 != BiomeGenBase.field_150580_W.field_76756_M && var9 != BiomeGenBase.field_76783_v.field_76756_M) {
               if(var10 != null && var10.func_150559_j()) {
                  this.func_151632_a(var5, var6, var8, var7, p_75904_3_, var9, BiomeGenBase.field_150577_O.field_76756_M);
               } else if(var9 != BiomeGenBase.field_150589_Z.field_76756_M && var9 != BiomeGenBase.field_150607_aa.field_76756_M) {
                  if(var9 != BiomeGenBase.field_76771_b.field_76756_M && var9 != BiomeGenBase.field_150575_M.field_76756_M && var9 != BiomeGenBase.field_76781_i.field_76756_M && var9 != BiomeGenBase.field_76780_h.field_76756_M) {
                     var11 = var5[var8 + 1 + (var7 + 1 - 1) * (p_75904_3_ + 2)];
                     var12 = var5[var8 + 1 + 1 + (var7 + 1) * (p_75904_3_ + 2)];
                     var13 = var5[var8 + 1 - 1 + (var7 + 1) * (p_75904_3_ + 2)];
                     var14 = var5[var8 + 1 + (var7 + 1 + 1) * (p_75904_3_ + 2)];
                     if(!func_151618_b(var11) && !func_151618_b(var12) && !func_151618_b(var13) && !func_151618_b(var14)) {
                        var6[var8 + var7 * p_75904_3_] = var9;
                     } else {
                        var6[var8 + var7 * p_75904_3_] = BiomeGenBase.field_76787_r.field_76756_M;
                     }
                  } else {
                     var6[var8 + var7 * p_75904_3_] = var9;
                  }
               } else {
                  var11 = var5[var8 + 1 + (var7 + 1 - 1) * (p_75904_3_ + 2)];
                  var12 = var5[var8 + 1 + 1 + (var7 + 1) * (p_75904_3_ + 2)];
                  var13 = var5[var8 + 1 - 1 + (var7 + 1) * (p_75904_3_ + 2)];
                  var14 = var5[var8 + 1 + (var7 + 1 + 1) * (p_75904_3_ + 2)];
                  if(!func_151618_b(var11) && !func_151618_b(var12) && !func_151618_b(var13) && !func_151618_b(var14)) {
                     if(this.func_151633_d(var11) && this.func_151633_d(var12) && this.func_151633_d(var13) && this.func_151633_d(var14)) {
                        var6[var8 + var7 * p_75904_3_] = var9;
                     } else {
                        var6[var8 + var7 * p_75904_3_] = BiomeGenBase.field_76769_d.field_76756_M;
                     }
                  } else {
                     var6[var8 + var7 * p_75904_3_] = var9;
                  }
               }
            } else {
               this.func_151632_a(var5, var6, var8, var7, p_75904_3_, var9, BiomeGenBase.field_150576_N.field_76756_M);
            }
         }
      }

      return var6;
   }

   private void func_151632_a(int[] p_151632_1_, int[] p_151632_2_, int p_151632_3_, int p_151632_4_, int p_151632_5_, int p_151632_6_, int p_151632_7_) {
      if(func_151618_b(p_151632_6_)) {
         p_151632_2_[p_151632_3_ + p_151632_4_ * p_151632_5_] = p_151632_6_;
      } else {
         int var8 = p_151632_1_[p_151632_3_ + 1 + (p_151632_4_ + 1 - 1) * (p_151632_5_ + 2)];
         int var9 = p_151632_1_[p_151632_3_ + 1 + 1 + (p_151632_4_ + 1) * (p_151632_5_ + 2)];
         int var10 = p_151632_1_[p_151632_3_ + 1 - 1 + (p_151632_4_ + 1) * (p_151632_5_ + 2)];
         int var11 = p_151632_1_[p_151632_3_ + 1 + (p_151632_4_ + 1 + 1) * (p_151632_5_ + 2)];
         if(!func_151618_b(var8) && !func_151618_b(var9) && !func_151618_b(var10) && !func_151618_b(var11)) {
            p_151632_2_[p_151632_3_ + p_151632_4_ * p_151632_5_] = p_151632_6_;
         } else {
            p_151632_2_[p_151632_3_ + p_151632_4_ * p_151632_5_] = p_151632_7_;
         }

      }
   }

   private boolean func_151631_c(int p_151631_1_) {
      return BiomeGenBase.func_150568_d(p_151631_1_) != null && BiomeGenBase.func_150568_d(p_151631_1_).func_150562_l() == BiomeGenJungle.class?true:p_151631_1_ == BiomeGenBase.field_150574_L.field_76756_M || p_151631_1_ == BiomeGenBase.field_76782_w.field_76756_M || p_151631_1_ == BiomeGenBase.field_76792_x.field_76756_M || p_151631_1_ == BiomeGenBase.field_76767_f.field_76756_M || p_151631_1_ == BiomeGenBase.field_76768_g.field_76756_M || func_151618_b(p_151631_1_);
   }

   private boolean func_151633_d(int p_151633_1_) {
      return BiomeGenBase.func_150568_d(p_151633_1_) instanceof BiomeGenMesa;
   }
}
