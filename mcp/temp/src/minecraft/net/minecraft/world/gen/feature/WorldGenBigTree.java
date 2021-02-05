package net.minecraft.world.gen.feature;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenBigTree extends WorldGenAbstractTree {

   private Random field_175949_k;
   private World field_175946_l;
   private BlockPos field_175947_m;
   int field_76504_e;
   int field_76501_f;
   double field_76502_g;
   double field_175944_d;
   double field_175945_e;
   double field_76513_k;
   int field_175943_g;
   int field_175950_h;
   int field_76508_n;
   List field_175948_j;
   private static final String __OBFID = "CL_00000400";


   public WorldGenBigTree(boolean p_i2008_1_) {
      super(p_i2008_1_);
      this.field_175947_m = BlockPos.field_177992_a;
      this.field_76502_g = 0.618D;
      this.field_175944_d = 0.381D;
      this.field_175945_e = 1.0D;
      this.field_76513_k = 1.0D;
      this.field_175943_g = 1;
      this.field_175950_h = 12;
      this.field_76508_n = 4;
   }

   void func_76489_a() {
      this.field_76501_f = (int)((double)this.field_76504_e * this.field_76502_g);
      if(this.field_76501_f >= this.field_76504_e) {
         this.field_76501_f = this.field_76504_e - 1;
      }

      int var1 = (int)(1.382D + Math.pow(this.field_76513_k * (double)this.field_76504_e / 13.0D, 2.0D));
      if(var1 < 1) {
         var1 = 1;
      }

      int var2 = this.field_175947_m.func_177956_o() + this.field_76501_f;
      int var3 = this.field_76504_e - this.field_76508_n;
      this.field_175948_j = Lists.newArrayList();
      this.field_175948_j.add(new WorldGenBigTree.FoliageCoordinates(this.field_175947_m.func_177981_b(var3), var2));

      for(; var3 >= 0; --var3) {
         float var4 = this.func_76490_a(var3);
         if(var4 >= 0.0F) {
            for(int var5 = 0; var5 < var1; ++var5) {
               double var6 = this.field_175945_e * (double)var4 * ((double)this.field_175949_k.nextFloat() + 0.328D);
               double var8 = (double)(this.field_175949_k.nextFloat() * 2.0F) * 3.141592653589793D;
               double var10 = var6 * Math.sin(var8) + 0.5D;
               double var12 = var6 * Math.cos(var8) + 0.5D;
               BlockPos var14 = this.field_175947_m.func_177963_a(var10, (double)(var3 - 1), var12);
               BlockPos var15 = var14.func_177981_b(this.field_76508_n);
               if(this.func_175936_a(var14, var15) == -1) {
                  int var16 = this.field_175947_m.func_177958_n() - var14.func_177958_n();
                  int var17 = this.field_175947_m.func_177952_p() - var14.func_177952_p();
                  double var18 = (double)var14.func_177956_o() - Math.sqrt((double)(var16 * var16 + var17 * var17)) * this.field_175944_d;
                  int var20 = var18 > (double)var2?var2:(int)var18;
                  BlockPos var21 = new BlockPos(this.field_175947_m.func_177958_n(), var20, this.field_175947_m.func_177952_p());
                  if(this.func_175936_a(var21, var14) == -1) {
                     this.field_175948_j.add(new WorldGenBigTree.FoliageCoordinates(var14, var21.func_177956_o()));
                  }
               }
            }
         }
      }

   }

   void func_180712_a(BlockPos p_180712_1_, float p_180712_2_, Block p_180712_3_) {
      int var4 = (int)((double)p_180712_2_ + 0.618D);

      for(int var5 = -var4; var5 <= var4; ++var5) {
         for(int var6 = -var4; var6 <= var4; ++var6) {
            if(Math.pow((double)Math.abs(var5) + 0.5D, 2.0D) + Math.pow((double)Math.abs(var6) + 0.5D, 2.0D) <= (double)(p_180712_2_ * p_180712_2_)) {
               BlockPos var7 = p_180712_1_.func_177982_a(var5, 0, var6);
               Material var8 = this.field_175946_l.func_180495_p(var7).func_177230_c().func_149688_o();
               if(var8 == Material.field_151579_a || var8 == Material.field_151584_j) {
                  this.func_175905_a(this.field_175946_l, var7, p_180712_3_, 0);
               }
            }
         }
      }

   }

   float func_76490_a(int p_76490_1_) {
      if((float)p_76490_1_ < (float)this.field_76504_e * 0.3F) {
         return -1.0F;
      } else {
         float var2 = (float)this.field_76504_e / 2.0F;
         float var3 = var2 - (float)p_76490_1_;
         float var4 = MathHelper.func_76129_c(var2 * var2 - var3 * var3);
         if(var3 == 0.0F) {
            var4 = var2;
         } else if(Math.abs(var3) >= var2) {
            return 0.0F;
         }

         return var4 * 0.5F;
      }
   }

   float func_76495_b(int p_76495_1_) {
      return p_76495_1_ >= 0 && p_76495_1_ < this.field_76508_n?(p_76495_1_ != 0 && p_76495_1_ != this.field_76508_n - 1?3.0F:2.0F):-1.0F;
   }

   void func_175940_a(BlockPos p_175940_1_) {
      for(int var2 = 0; var2 < this.field_76508_n; ++var2) {
         this.func_180712_a(p_175940_1_.func_177981_b(var2), this.func_76495_b(var2), Blocks.field_150362_t);
      }

   }

   void func_175937_a(BlockPos p_175937_1_, BlockPos p_175937_2_, Block p_175937_3_) {
      BlockPos var4 = p_175937_2_.func_177982_a(-p_175937_1_.func_177958_n(), -p_175937_1_.func_177956_o(), -p_175937_1_.func_177952_p());
      int var5 = this.func_175935_b(var4);
      float var6 = (float)var4.func_177958_n() / (float)var5;
      float var7 = (float)var4.func_177956_o() / (float)var5;
      float var8 = (float)var4.func_177952_p() / (float)var5;

      for(int var9 = 0; var9 <= var5; ++var9) {
         BlockPos var10 = p_175937_1_.func_177963_a((double)(0.5F + (float)var9 * var6), (double)(0.5F + (float)var9 * var7), (double)(0.5F + (float)var9 * var8));
         BlockLog.EnumAxis var11 = this.func_175938_b(p_175937_1_, var10);
         this.func_175903_a(this.field_175946_l, var10, p_175937_3_.func_176223_P().func_177226_a(BlockLog.field_176299_a, var11));
      }

   }

   private int func_175935_b(BlockPos p_175935_1_) {
      int var2 = MathHelper.func_76130_a(p_175935_1_.func_177958_n());
      int var3 = MathHelper.func_76130_a(p_175935_1_.func_177956_o());
      int var4 = MathHelper.func_76130_a(p_175935_1_.func_177952_p());
      return var4 > var2 && var4 > var3?var4:(var3 > var2?var3:var2);
   }

   private BlockLog.EnumAxis func_175938_b(BlockPos p_175938_1_, BlockPos p_175938_2_) {
      BlockLog.EnumAxis var3 = BlockLog.EnumAxis.Y;
      int var4 = Math.abs(p_175938_2_.func_177958_n() - p_175938_1_.func_177958_n());
      int var5 = Math.abs(p_175938_2_.func_177952_p() - p_175938_1_.func_177952_p());
      int var6 = Math.max(var4, var5);
      if(var6 > 0) {
         if(var4 == var6) {
            var3 = BlockLog.EnumAxis.X;
         } else if(var5 == var6) {
            var3 = BlockLog.EnumAxis.Z;
         }
      }

      return var3;
   }

   void func_175941_b() {
      Iterator var1 = this.field_175948_j.iterator();

      while(var1.hasNext()) {
         WorldGenBigTree.FoliageCoordinates var2 = (WorldGenBigTree.FoliageCoordinates)var1.next();
         this.func_175940_a(var2);
      }

   }

   boolean func_76493_c(int p_76493_1_) {
      return (double)p_76493_1_ >= (double)this.field_76504_e * 0.2D;
   }

   void func_175942_c() {
      BlockPos var1 = this.field_175947_m;
      BlockPos var2 = this.field_175947_m.func_177981_b(this.field_76501_f);
      Block var3 = Blocks.field_150364_r;
      this.func_175937_a(var1, var2, var3);
      if(this.field_175943_g == 2) {
         this.func_175937_a(var1.func_177974_f(), var2.func_177974_f(), var3);
         this.func_175937_a(var1.func_177974_f().func_177968_d(), var2.func_177974_f().func_177968_d(), var3);
         this.func_175937_a(var1.func_177968_d(), var2.func_177968_d(), var3);
      }

   }

   void func_175939_d() {
      Iterator var1 = this.field_175948_j.iterator();

      while(var1.hasNext()) {
         WorldGenBigTree.FoliageCoordinates var2 = (WorldGenBigTree.FoliageCoordinates)var1.next();
         int var3 = var2.func_177999_q();
         BlockPos var4 = new BlockPos(this.field_175947_m.func_177958_n(), var3, this.field_175947_m.func_177952_p());
         if(this.func_76493_c(var3 - this.field_175947_m.func_177956_o())) {
            this.func_175937_a(var4, var2, Blocks.field_150364_r);
         }
      }

   }

   int func_175936_a(BlockPos p_175936_1_, BlockPos p_175936_2_) {
      BlockPos var3 = p_175936_2_.func_177982_a(-p_175936_1_.func_177958_n(), -p_175936_1_.func_177956_o(), -p_175936_1_.func_177952_p());
      int var4 = this.func_175935_b(var3);
      float var5 = (float)var3.func_177958_n() / (float)var4;
      float var6 = (float)var3.func_177956_o() / (float)var4;
      float var7 = (float)var3.func_177952_p() / (float)var4;
      if(var4 == 0) {
         return -1;
      } else {
         for(int var8 = 0; var8 <= var4; ++var8) {
            BlockPos var9 = p_175936_1_.func_177963_a((double)(0.5F + (float)var8 * var5), (double)(0.5F + (float)var8 * var6), (double)(0.5F + (float)var8 * var7));
            if(!this.func_150523_a(this.field_175946_l.func_180495_p(var9).func_177230_c())) {
               return var8;
            }
         }

         return -1;
      }
   }

   public void func_175904_e() {
      this.field_76508_n = 5;
   }

   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      this.field_175946_l = p_180709_1_;
      this.field_175947_m = p_180709_3_;
      this.field_175949_k = new Random(p_180709_2_.nextLong());
      if(this.field_76504_e == 0) {
         this.field_76504_e = 5 + this.field_175949_k.nextInt(this.field_175950_h);
      }

      if(!this.func_76497_e()) {
         return false;
      } else {
         this.func_76489_a();
         this.func_175941_b();
         this.func_175942_c();
         this.func_175939_d();
         return true;
      }
   }

   private boolean func_76497_e() {
      Block var1 = this.field_175946_l.func_180495_p(this.field_175947_m.func_177977_b()).func_177230_c();
      if(var1 != Blocks.field_150346_d && var1 != Blocks.field_150349_c && var1 != Blocks.field_150458_ak) {
         return false;
      } else {
         int var2 = this.func_175936_a(this.field_175947_m, this.field_175947_m.func_177981_b(this.field_76504_e - 1));
         if(var2 == -1) {
            return true;
         } else if(var2 < 6) {
            return false;
         } else {
            this.field_76504_e = var2;
            return true;
         }
      }
   }

   static class FoliageCoordinates extends BlockPos {

      private final int field_178000_b;
      private static final String __OBFID = "CL_00002001";


      public FoliageCoordinates(BlockPos p_i45635_1_, int p_i45635_2_) {
         super(p_i45635_1_.func_177958_n(), p_i45635_1_.func_177956_o(), p_i45635_1_.func_177952_p());
         this.field_178000_b = p_i45635_2_;
      }

      public int func_177999_q() {
         return this.field_178000_b;
      }
   }
}
