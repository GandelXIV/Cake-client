package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerRiverMix extends GenLayer {

   private GenLayer field_75910_b;
   private GenLayer field_75911_c;
   private static final String __OBFID = "CL_00000567";


   public GenLayerRiverMix(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_) {
      super(p_i2129_1_);
      this.field_75910_b = p_i2129_3_;
      this.field_75911_c = p_i2129_4_;
   }

   public void func_75905_a(long p_75905_1_) {
      this.field_75910_b.func_75905_a(p_75905_1_);
      this.field_75911_c.func_75905_a(p_75905_1_);
      super.func_75905_a(p_75905_1_);
   }

   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
      int[] var5 = this.field_75910_b.func_75904_a(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
      int[] var6 = this.field_75911_c.func_75904_a(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
      int[] var7 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);

      for(int var8 = 0; var8 < p_75904_3_ * p_75904_4_; ++var8) {
         if(var5[var8] != BiomeGenBase.field_76771_b.field_76756_M && var5[var8] != BiomeGenBase.field_150575_M.field_76756_M) {
            if(var6[var8] == BiomeGenBase.field_76781_i.field_76756_M) {
               if(var5[var8] == BiomeGenBase.field_76774_n.field_76756_M) {
                  var7[var8] = BiomeGenBase.field_76777_m.field_76756_M;
               } else if(var5[var8] != BiomeGenBase.field_76789_p.field_76756_M && var5[var8] != BiomeGenBase.field_76788_q.field_76756_M) {
                  var7[var8] = var6[var8] & 255;
               } else {
                  var7[var8] = BiomeGenBase.field_76788_q.field_76756_M;
               }
            } else {
               var7[var8] = var5[var8];
            }
         } else {
            var7[var8] = var5[var8];
         }
      }

      return var7;
   }
}
