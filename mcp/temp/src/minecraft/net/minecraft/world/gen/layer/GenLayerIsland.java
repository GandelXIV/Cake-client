package net.minecraft.world.gen.layer;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerIsland extends GenLayer {

   private static final String __OBFID = "CL_00000558";


   public GenLayerIsland(long p_i2124_1_) {
      super(p_i2124_1_);
   }

   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
      int[] var5 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);

      for(int var6 = 0; var6 < p_75904_4_; ++var6) {
         for(int var7 = 0; var7 < p_75904_3_; ++var7) {
            this.func_75903_a((long)(p_75904_1_ + var7), (long)(p_75904_2_ + var6));
            var5[var7 + var6 * p_75904_3_] = this.func_75902_a(10) == 0?1:0;
         }
      }

      if(p_75904_1_ > -p_75904_3_ && p_75904_1_ <= 0 && p_75904_2_ > -p_75904_4_ && p_75904_2_ <= 0) {
         var5[-p_75904_1_ + -p_75904_2_ * p_75904_3_] = 1;
      }

      return var5;
   }
}
