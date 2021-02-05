package net.minecraft.pathfinding;

import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.pathfinder.NodeProcessor;

public class PathFinder {

   private Path field_75866_b = new Path();
   private PathPoint[] field_75864_d = new PathPoint[32];
   private NodeProcessor field_176190_c;
   private static final String __OBFID = "CL_00000576";


   public PathFinder(NodeProcessor p_i45557_1_) {
      this.field_176190_c = p_i45557_1_;
   }

   public PathEntity func_176188_a(IBlockAccess p_176188_1_, Entity p_176188_2_, Entity p_176188_3_, float p_176188_4_) {
      return this.func_176189_a(p_176188_1_, p_176188_2_, p_176188_3_.field_70165_t, p_176188_3_.func_174813_aQ().field_72338_b, p_176188_3_.field_70161_v, p_176188_4_);
   }

   public PathEntity func_180782_a(IBlockAccess p_180782_1_, Entity p_180782_2_, BlockPos p_180782_3_, float p_180782_4_) {
      return this.func_176189_a(p_180782_1_, p_180782_2_, (double)((float)p_180782_3_.func_177958_n() + 0.5F), (double)((float)p_180782_3_.func_177956_o() + 0.5F), (double)((float)p_180782_3_.func_177952_p() + 0.5F), p_180782_4_);
   }

   private PathEntity func_176189_a(IBlockAccess p_176189_1_, Entity p_176189_2_, double p_176189_3_, double p_176189_5_, double p_176189_7_, float p_176189_9_) {
      this.field_75866_b.func_75848_a();
      this.field_176190_c.func_176162_a(p_176189_1_, p_176189_2_);
      PathPoint var10 = this.field_176190_c.func_176161_a(p_176189_2_);
      PathPoint var11 = this.field_176190_c.func_176160_a(p_176189_2_, p_176189_3_, p_176189_5_, p_176189_7_);
      PathEntity var12 = this.func_176187_a(p_176189_2_, var10, var11, p_176189_9_);
      this.field_176190_c.func_176163_a();
      return var12;
   }

   private PathEntity func_176187_a(Entity p_176187_1_, PathPoint p_176187_2_, PathPoint p_176187_3_, float p_176187_4_) {
      p_176187_2_.field_75836_e = 0.0F;
      p_176187_2_.field_75833_f = p_176187_2_.func_75832_b(p_176187_3_);
      p_176187_2_.field_75834_g = p_176187_2_.field_75833_f;
      this.field_75866_b.func_75848_a();
      this.field_75866_b.func_75849_a(p_176187_2_);
      PathPoint var5 = p_176187_2_;

      while(!this.field_75866_b.func_75845_e()) {
         PathPoint var6 = this.field_75866_b.func_75844_c();
         if(var6.equals(p_176187_3_)) {
            return this.func_75853_a(p_176187_2_, p_176187_3_);
         }

         if(var6.func_75832_b(p_176187_3_) < var5.func_75832_b(p_176187_3_)) {
            var5 = var6;
         }

         var6.field_75842_i = true;
         int var7 = this.field_176190_c.func_176164_a(this.field_75864_d, p_176187_1_, var6, p_176187_3_, p_176187_4_);

         for(int var8 = 0; var8 < var7; ++var8) {
            PathPoint var9 = this.field_75864_d[var8];
            float var10 = var6.field_75836_e + var6.func_75832_b(var9);
            if(var10 < p_176187_4_ * 2.0F && (!var9.func_75831_a() || var10 < var9.field_75836_e)) {
               var9.field_75841_h = var6;
               var9.field_75836_e = var10;
               var9.field_75833_f = var9.func_75832_b(p_176187_3_);
               if(var9.func_75831_a()) {
                  this.field_75866_b.func_75850_a(var9, var9.field_75836_e + var9.field_75833_f);
               } else {
                  var9.field_75834_g = var9.field_75836_e + var9.field_75833_f;
                  this.field_75866_b.func_75849_a(var9);
               }
            }
         }
      }

      if(var5 == p_176187_2_) {
         return null;
      } else {
         return this.func_75853_a(p_176187_2_, var5);
      }
   }

   private PathEntity func_75853_a(PathPoint p_75853_1_, PathPoint p_75853_2_) {
      int var3 = 1;

      PathPoint var4;
      for(var4 = p_75853_2_; var4.field_75841_h != null; var4 = var4.field_75841_h) {
         ++var3;
      }

      PathPoint[] var5 = new PathPoint[var3];
      var4 = p_75853_2_;
      --var3;

      for(var5[var3] = p_75853_2_; var4.field_75841_h != null; var5[var3] = var4) {
         var4 = var4.field_75841_h;
         --var3;
      }

      return new PathEntity(var5);
   }
}
