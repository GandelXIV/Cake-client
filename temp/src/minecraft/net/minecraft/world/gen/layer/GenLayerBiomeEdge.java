package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomeEdge extends GenLayer {

   private static final String __OBFID = "CL_00000554";


   public GenLayerBiomeEdge(long p_i45475_1_, GenLayer p_i45475_3_) {
      super(p_i45475_1_);
      this.field_75909_a = p_i45475_3_;
   }

   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
      int[] var5 = this.field_75909_a.func_75904_a(p_75904_1_ - 1, p_75904_2_ - 1, p_75904_3_ + 2, p_75904_4_ + 2);
      int[] var6 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);

      for(int var7 = 0; var7 < p_75904_4_; ++var7) {
         for(int var8 = 0; var8 < p_75904_3_; ++var8) {
            this.func_75903_a((long)(var8 + p_75904_1_), (long)(var7 + p_75904_2_));
            int var9 = var5[var8 + 1 + (var7 + 1) * (p_75904_3_ + 2)];
            if(!this.func_151636_a(var5, var6, var8, var7, p_75904_3_, var9, BiomeGenBase.field_76770_e.field_76756_M, BiomeGenBase.field_76783_v.field_76756_M) && !this.func_151635_b(var5, var6, var8, var7, p_75904_3_, var9, BiomeGenBase.field_150607_aa.field_76756_M, BiomeGenBase.field_150589_Z.field_76756_M) && !this.func_151635_b(var5, var6, var8, var7, p_75904_3_, var9, BiomeGenBase.field_150608_ab.field_76756_M, BiomeGenBase.field_150589_Z.field_76756_M) && !this.func_151635_b(var5, var6, var8, var7, p_75904_3_, var9, BiomeGenBase.field_150578_U.field_76756_M, BiomeGenBase.field_76768_g.field_76756_M)) {
               int var10;
               int var11;
               int var12;
               int var13;
               if(var9 == BiomeGenBase.field_76769_d.field_76756_M) {
                  var10 = var5[var8 + 1 + (var7 + 1 - 1) * (p_75904_3_ + 2)];
                  var11 = var5[var8 + 1 + 1 + (var7 + 1) * (p_75904_3_ + 2)];
                  var12 = var5[var8 + 1 - 1 + (var7 + 1) * (p_75904_3_ + 2)];
                  var13 = var5[var8 + 1 + (var7 + 1 + 1) * (p_75904_3_ + 2)];
                  if(var10 != BiomeGenBase.field_76774_n.field_76756_M && var11 != BiomeGenBase.field_76774_n.field_76756_M && var12 != BiomeGenBase.field_76774_n.field_76756_M && var13 != BiomeGenBase.field_76774_n.field_76756_M) {
                     var6[var8 + var7 * p_75904_3_] = var9;
                  } else {
                     var6[var8 + var7 * p_75904_3_] = BiomeGenBase.field_150580_W.field_76756_M;
                  }
               } else if(var9 == BiomeGenBase.field_76780_h.field_76756_M) {
                  var10 = var5[var8 + 1 + (var7 + 1 - 1) * (p_75904_3_ + 2)];
                  var11 = var5[var8 + 1 + 1 + (var7 + 1) * (p_75904_3_ + 2)];
                  var12 = var5[var8 + 1 - 1 + (var7 + 1) * (p_75904_3_ + 2)];
                  var13 = var5[var8 + 1 + (var7 + 1 + 1) * (p_75904_3_ + 2)];
                  if(var10 != BiomeGenBase.field_76769_d.field_76756_M && var11 != BiomeGenBase.field_76769_d.field_76756_M && var12 != BiomeGenBase.field_76769_d.field_76756_M && var13 != BiomeGenBase.field_76769_d.field_76756_M && var10 != BiomeGenBase.field_150584_S.field_76756_M && var11 != BiomeGenBase.field_150584_S.field_76756_M && var12 != BiomeGenBase.field_150584_S.field_76756_M && var13 != BiomeGenBase.field_150584_S.field_76756_M && var10 != BiomeGenBase.field_76774_n.field_76756_M && var11 != BiomeGenBase.field_76774_n.field_76756_M && var12 != BiomeGenBase.field_76774_n.field_76756_M && var13 != BiomeGenBase.field_76774_n.field_76756_M) {
                     if(var10 != BiomeGenBase.field_76782_w.field_76756_M && var13 != BiomeGenBase.field_76782_w.field_76756_M && var11 != BiomeGenBase.field_76782_w.field_76756_M && var12 != BiomeGenBase.field_76782_w.field_76756_M) {
                        var6[var8 + var7 * p_75904_3_] = var9;
                     } else {
                        var6[var8 + var7 * p_75904_3_] = BiomeGenBase.field_150574_L.field_76756_M;
                     }
                  } else {
                     var6[var8 + var7 * p_75904_3_] = BiomeGenBase.field_76772_c.field_76756_M;
                  }
               } else {
                  var6[var8 + var7 * p_75904_3_] = var9;
               }
            }
         }
      }

      return var6;
   }

   private boolean func_151636_a(int[] p_151636_1_, int[] p_151636_2_, int p_151636_3_, int p_151636_4_, int p_151636_5_, int p_151636_6_, int p_151636_7_, int p_151636_8_) {
      if(!func_151616_a(p_151636_6_, p_151636_7_)) {
         return false;
      } else {
         int var9 = p_151636_1_[p_151636_3_ + 1 + (p_151636_4_ + 1 - 1) * (p_151636_5_ + 2)];
         int var10 = p_151636_1_[p_151636_3_ + 1 + 1 + (p_151636_4_ + 1) * (p_151636_5_ + 2)];
         int var11 = p_151636_1_[p_151636_3_ + 1 - 1 + (p_151636_4_ + 1) * (p_151636_5_ + 2)];
         int var12 = p_151636_1_[p_151636_3_ + 1 + (p_151636_4_ + 1 + 1) * (p_151636_5_ + 2)];
         if(this.func_151634_b(var9, p_151636_7_) && this.func_151634_b(var10, p_151636_7_) && this.func_151634_b(var11, p_151636_7_) && this.func_151634_b(var12, p_151636_7_)) {
            p_151636_2_[p_151636_3_ + p_151636_4_ * p_151636_5_] = p_151636_6_;
         } else {
            p_151636_2_[p_151636_3_ + p_151636_4_ * p_151636_5_] = p_151636_8_;
         }

         return true;
      }
   }

   private boolean func_151635_b(int[] p_151635_1_, int[] p_151635_2_, int p_151635_3_, int p_151635_4_, int p_151635_5_, int p_151635_6_, int p_151635_7_, int p_151635_8_) {
      if(p_151635_6_ != p_151635_7_) {
         return false;
      } else {
         int var9 = p_151635_1_[p_151635_3_ + 1 + (p_151635_4_ + 1 - 1) * (p_151635_5_ + 2)];
         int var10 = p_151635_1_[p_151635_3_ + 1 + 1 + (p_151635_4_ + 1) * (p_151635_5_ + 2)];
         int var11 = p_151635_1_[p_151635_3_ + 1 - 1 + (p_151635_4_ + 1) * (p_151635_5_ + 2)];
         int var12 = p_151635_1_[p_151635_3_ + 1 + (p_151635_4_ + 1 + 1) * (p_151635_5_ + 2)];
         if(func_151616_a(var9, p_151635_7_) && func_151616_a(var10, p_151635_7_) && func_151616_a(var11, p_151635_7_) && func_151616_a(var12, p_151635_7_)) {
            p_151635_2_[p_151635_3_ + p_151635_4_ * p_151635_5_] = p_151635_6_;
         } else {
            p_151635_2_[p_151635_3_ + p_151635_4_ * p_151635_5_] = p_151635_8_;
         }

         return true;
      }
   }

   private boolean func_151634_b(int p_151634_1_, int p_151634_2_) {
      if(func_151616_a(p_151634_1_, p_151634_2_)) {
         return true;
      } else {
         BiomeGenBase var3 = BiomeGenBase.func_150568_d(p_151634_1_);
         BiomeGenBase var4 = BiomeGenBase.func_150568_d(p_151634_2_);
         if(var3 != null && var4 != null) {
            BiomeGenBase.TempCategory var5 = var3.func_150561_m();
            BiomeGenBase.TempCategory var6 = var4.func_150561_m();
            return var5 == var6 || var5 == BiomeGenBase.TempCategory.MEDIUM || var6 == BiomeGenBase.TempCategory.MEDIUM;
         } else {
            return false;
         }
      }
   }
}
