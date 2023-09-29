package net.minecraft.pathfinding;

import net.minecraft.pathfinding.PathPoint;

public class Path {

   private PathPoint[] field_75852_a = new PathPoint[1024];
   private int field_75851_b;
   private static final String __OBFID = "CL_00000573";


   public PathPoint func_75849_a(PathPoint p_75849_1_) {
      if(p_75849_1_.field_75835_d >= 0) {
         throw new IllegalStateException("OW KNOWS!");
      } else {
         if(this.field_75851_b == this.field_75852_a.length) {
            PathPoint[] var2 = new PathPoint[this.field_75851_b << 1];
            System.arraycopy(this.field_75852_a, 0, var2, 0, this.field_75851_b);
            this.field_75852_a = var2;
         }

         this.field_75852_a[this.field_75851_b] = p_75849_1_;
         p_75849_1_.field_75835_d = this.field_75851_b;
         this.func_75847_a(this.field_75851_b++);
         return p_75849_1_;
      }
   }

   public void func_75848_a() {
      this.field_75851_b = 0;
   }

   public PathPoint func_75844_c() {
      PathPoint var1 = this.field_75852_a[0];
      this.field_75852_a[0] = this.field_75852_a[--this.field_75851_b];
      this.field_75852_a[this.field_75851_b] = null;
      if(this.field_75851_b > 0) {
         this.func_75846_b(0);
      }

      var1.field_75835_d = -1;
      return var1;
   }

   public void func_75850_a(PathPoint p_75850_1_, float p_75850_2_) {
      float var3 = p_75850_1_.field_75834_g;
      p_75850_1_.field_75834_g = p_75850_2_;
      if(p_75850_2_ < var3) {
         this.func_75847_a(p_75850_1_.field_75835_d);
      } else {
         this.func_75846_b(p_75850_1_.field_75835_d);
      }

   }

   private void func_75847_a(int p_75847_1_) {
      PathPoint var2 = this.field_75852_a[p_75847_1_];

      int var4;
      for(float var3 = var2.field_75834_g; p_75847_1_ > 0; p_75847_1_ = var4) {
         var4 = p_75847_1_ - 1 >> 1;
         PathPoint var5 = this.field_75852_a[var4];
         if(var3 >= var5.field_75834_g) {
            break;
         }

         this.field_75852_a[p_75847_1_] = var5;
         var5.field_75835_d = p_75847_1_;
      }

      this.field_75852_a[p_75847_1_] = var2;
      var2.field_75835_d = p_75847_1_;
   }

   private void func_75846_b(int p_75846_1_) {
      PathPoint var2 = this.field_75852_a[p_75846_1_];
      float var3 = var2.field_75834_g;

      while(true) {
         int var4 = 1 + (p_75846_1_ << 1);
         int var5 = var4 + 1;
         if(var4 >= this.field_75851_b) {
            break;
         }

         PathPoint var6 = this.field_75852_a[var4];
         float var7 = var6.field_75834_g;
         PathPoint var8;
         float var9;
         if(var5 >= this.field_75851_b) {
            var8 = null;
            var9 = Float.POSITIVE_INFINITY;
         } else {
            var8 = this.field_75852_a[var5];
            var9 = var8.field_75834_g;
         }

         if(var7 < var9) {
            if(var7 >= var3) {
               break;
            }

            this.field_75852_a[p_75846_1_] = var6;
            var6.field_75835_d = p_75846_1_;
            p_75846_1_ = var4;
         } else {
            if(var9 >= var3) {
               break;
            }

            this.field_75852_a[p_75846_1_] = var8;
            var8.field_75835_d = p_75846_1_;
            p_75846_1_ = var5;
         }
      }

      this.field_75852_a[p_75846_1_] = var2;
      var2.field_75835_d = p_75846_1_;
   }

   public boolean func_75845_e() {
      return this.field_75851_b == 0;
   }
}
