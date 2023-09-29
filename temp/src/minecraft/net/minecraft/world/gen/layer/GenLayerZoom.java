package net.minecraft.world.gen.layer;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerZoom extends GenLayer {

   private static final String __OBFID = "CL_00000572";


   public GenLayerZoom(long p_i2134_1_, GenLayer p_i2134_3_) {
      super(p_i2134_1_);
      super.field_75909_a = p_i2134_3_;
   }

   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
      int var5 = p_75904_1_ >> 1;
      int var6 = p_75904_2_ >> 1;
      int var7 = (p_75904_3_ >> 1) + 2;
      int var8 = (p_75904_4_ >> 1) + 2;
      int[] var9 = this.field_75909_a.func_75904_a(var5, var6, var7, var8);
      int var10 = var7 - 1 << 1;
      int var11 = var8 - 1 << 1;
      int[] var12 = IntCache.func_76445_a(var10 * var11);

      int var14;
      for(int var13 = 0; var13 < var8 - 1; ++var13) {
         var14 = (var13 << 1) * var10;
         int var15 = 0;
         int var16 = var9[var15 + 0 + (var13 + 0) * var7];

         for(int var17 = var9[var15 + 0 + (var13 + 1) * var7]; var15 < var7 - 1; ++var15) {
            this.func_75903_a((long)(var15 + var5 << 1), (long)(var13 + var6 << 1));
            int var18 = var9[var15 + 1 + (var13 + 0) * var7];
            int var19 = var9[var15 + 1 + (var13 + 1) * var7];
            var12[var14] = var16;
            var12[var14++ + var10] = this.func_151619_a(new int[]{var16, var17});
            var12[var14] = this.func_151619_a(new int[]{var16, var18});
            var12[var14++ + var10] = this.func_151617_b(var16, var18, var17, var19);
            var16 = var18;
            var17 = var19;
         }
      }

      int[] var20 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);

      for(var14 = 0; var14 < p_75904_4_; ++var14) {
         System.arraycopy(var12, (var14 + (p_75904_2_ & 1)) * var10 + (p_75904_1_ & 1), var20, var14 * p_75904_3_, p_75904_3_);
      }

      return var20;
   }

   public static GenLayer func_75915_a(long p_75915_0_, GenLayer p_75915_2_, int p_75915_3_) {
      Object var4 = p_75915_2_;

      for(int var5 = 0; var5 < p_75915_3_; ++var5) {
         var4 = new GenLayerZoom(p_75915_0_ + (long)var5, (GenLayer)var4);
      }

      return (GenLayer)var4;
   }
}
