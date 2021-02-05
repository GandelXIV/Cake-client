package net.minecraft.entity.ai;

import java.util.Random;
import net.minecraft.entity.EntityCreature;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class RandomPositionGenerator {

   private static Vec3 field_75465_a = new Vec3(0.0D, 0.0D, 0.0D);
   private static final String __OBFID = "CL_00001629";


   public static Vec3 func_75463_a(EntityCreature p_75463_0_, int p_75463_1_, int p_75463_2_) {
      return func_75462_c(p_75463_0_, p_75463_1_, p_75463_2_, (Vec3)null);
   }

   public static Vec3 func_75464_a(EntityCreature p_75464_0_, int p_75464_1_, int p_75464_2_, Vec3 p_75464_3_) {
      field_75465_a = p_75464_3_.func_178786_a(p_75464_0_.field_70165_t, p_75464_0_.field_70163_u, p_75464_0_.field_70161_v);
      return func_75462_c(p_75464_0_, p_75464_1_, p_75464_2_, field_75465_a);
   }

   public static Vec3 func_75461_b(EntityCreature p_75461_0_, int p_75461_1_, int p_75461_2_, Vec3 p_75461_3_) {
      field_75465_a = (new Vec3(p_75461_0_.field_70165_t, p_75461_0_.field_70163_u, p_75461_0_.field_70161_v)).func_178788_d(p_75461_3_);
      return func_75462_c(p_75461_0_, p_75461_1_, p_75461_2_, field_75465_a);
   }

   private static Vec3 func_75462_c(EntityCreature p_75462_0_, int p_75462_1_, int p_75462_2_, Vec3 p_75462_3_) {
      Random var4 = p_75462_0_.func_70681_au();
      boolean var5 = false;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      float var9 = -99999.0F;
      boolean var10;
      if(p_75462_0_.func_110175_bO()) {
         double var11 = p_75462_0_.func_180486_cf().func_177954_c((double)MathHelper.func_76128_c(p_75462_0_.field_70165_t), (double)MathHelper.func_76128_c(p_75462_0_.field_70163_u), (double)MathHelper.func_76128_c(p_75462_0_.field_70161_v)) + 4.0D;
         double var13 = (double)(p_75462_0_.func_110174_bM() + (float)p_75462_1_);
         var10 = var11 < var13 * var13;
      } else {
         var10 = false;
      }

      for(int var17 = 0; var17 < 10; ++var17) {
         int var12 = var4.nextInt(2 * p_75462_1_ + 1) - p_75462_1_;
         int var18 = var4.nextInt(2 * p_75462_2_ + 1) - p_75462_2_;
         int var14 = var4.nextInt(2 * p_75462_1_ + 1) - p_75462_1_;
         if(p_75462_3_ == null || (double)var12 * p_75462_3_.field_72450_a + (double)var14 * p_75462_3_.field_72449_c >= 0.0D) {
            BlockPos var15;
            if(p_75462_0_.func_110175_bO() && p_75462_1_ > 1) {
               var15 = p_75462_0_.func_180486_cf();
               if(p_75462_0_.field_70165_t > (double)var15.func_177958_n()) {
                  var12 -= var4.nextInt(p_75462_1_ / 2);
               } else {
                  var12 += var4.nextInt(p_75462_1_ / 2);
               }

               if(p_75462_0_.field_70161_v > (double)var15.func_177952_p()) {
                  var14 -= var4.nextInt(p_75462_1_ / 2);
               } else {
                  var14 += var4.nextInt(p_75462_1_ / 2);
               }
            }

            var12 += MathHelper.func_76128_c(p_75462_0_.field_70165_t);
            var18 += MathHelper.func_76128_c(p_75462_0_.field_70163_u);
            var14 += MathHelper.func_76128_c(p_75462_0_.field_70161_v);
            var15 = new BlockPos(var12, var18, var14);
            if(!var10 || p_75462_0_.func_180485_d(var15)) {
               float var16 = p_75462_0_.func_180484_a(var15);
               if(var16 > var9) {
                  var9 = var16;
                  var6 = var12;
                  var7 = var18;
                  var8 = var14;
                  var5 = true;
               }
            }
         }
      }

      if(var5) {
         return new Vec3((double)var6, (double)var7, (double)var8);
      } else {
         return null;
      }
   }

}
