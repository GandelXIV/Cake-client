package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public abstract class WorldGenHugeTrees extends WorldGenAbstractTree {

   protected final int field_76522_a;
   protected final int field_76520_b;
   protected final int field_76521_c;
   protected int field_150538_d;
   private static final String __OBFID = "CL_00000423";


   public WorldGenHugeTrees(boolean p_i45458_1_, int p_i45458_2_, int p_i45458_3_, int p_i45458_4_, int p_i45458_5_) {
      super(p_i45458_1_);
      this.field_76522_a = p_i45458_2_;
      this.field_150538_d = p_i45458_3_;
      this.field_76520_b = p_i45458_4_;
      this.field_76521_c = p_i45458_5_;
   }

   protected int func_150533_a(Random p_150533_1_) {
      int var2 = p_150533_1_.nextInt(3) + this.field_76522_a;
      if(this.field_150538_d > 1) {
         var2 += p_150533_1_.nextInt(this.field_150538_d);
      }

      return var2;
   }

   private boolean func_175926_c(World p_175926_1_, BlockPos p_175926_2_, int p_175926_3_) {
      boolean var4 = true;
      if(p_175926_2_.func_177956_o() >= 1 && p_175926_2_.func_177956_o() + p_175926_3_ + 1 <= 256) {
         for(int var5 = 0; var5 <= 1 + p_175926_3_; ++var5) {
            byte var6 = 2;
            if(var5 == 0) {
               var6 = 1;
            } else if(var5 >= 1 + p_175926_3_ - 2) {
               var6 = 2;
            }

            for(int var7 = -var6; var7 <= var6 && var4; ++var7) {
               for(int var8 = -var6; var8 <= var6 && var4; ++var8) {
                  if(p_175926_2_.func_177956_o() + var5 < 0 || p_175926_2_.func_177956_o() + var5 >= 256 || !this.func_150523_a(p_175926_1_.func_180495_p(p_175926_2_.func_177982_a(var7, var5, var8)).func_177230_c())) {
                     var4 = false;
                  }
               }
            }
         }

         return var4;
      } else {
         return false;
      }
   }

   private boolean func_175927_a(BlockPos p_175927_1_, World p_175927_2_) {
      BlockPos var3 = p_175927_1_.func_177977_b();
      Block var4 = p_175927_2_.func_180495_p(var3).func_177230_c();
      if((var4 == Blocks.field_150349_c || var4 == Blocks.field_150346_d) && p_175927_1_.func_177956_o() >= 2) {
         this.func_175921_a(p_175927_2_, var3);
         this.func_175921_a(p_175927_2_, var3.func_177974_f());
         this.func_175921_a(p_175927_2_, var3.func_177968_d());
         this.func_175921_a(p_175927_2_, var3.func_177968_d().func_177974_f());
         return true;
      } else {
         return false;
      }
   }

   protected boolean func_175929_a(World p_175929_1_, Random p_175929_2_, BlockPos p_175929_3_, int p_175929_4_) {
      return this.func_175926_c(p_175929_1_, p_175929_3_, p_175929_4_) && this.func_175927_a(p_175929_3_, p_175929_1_);
   }

   protected void func_175925_a(World p_175925_1_, BlockPos p_175925_2_, int p_175925_3_) {
      int var4 = p_175925_3_ * p_175925_3_;

      for(int var5 = -p_175925_3_; var5 <= p_175925_3_ + 1; ++var5) {
         for(int var6 = -p_175925_3_; var6 <= p_175925_3_ + 1; ++var6) {
            int var7 = var5 - 1;
            int var8 = var6 - 1;
            if(var5 * var5 + var6 * var6 <= var4 || var7 * var7 + var8 * var8 <= var4 || var5 * var5 + var8 * var8 <= var4 || var7 * var7 + var6 * var6 <= var4) {
               BlockPos var9 = p_175925_2_.func_177982_a(var5, 0, var6);
               Material var10 = p_175925_1_.func_180495_p(var9).func_177230_c().func_149688_o();
               if(var10 == Material.field_151579_a || var10 == Material.field_151584_j) {
                  this.func_175905_a(p_175925_1_, var9, Blocks.field_150362_t, this.field_76521_c);
               }
            }
         }
      }

   }

   protected void func_175928_b(World p_175928_1_, BlockPos p_175928_2_, int p_175928_3_) {
      int var4 = p_175928_3_ * p_175928_3_;

      for(int var5 = -p_175928_3_; var5 <= p_175928_3_; ++var5) {
         for(int var6 = -p_175928_3_; var6 <= p_175928_3_; ++var6) {
            if(var5 * var5 + var6 * var6 <= var4) {
               BlockPos var7 = p_175928_2_.func_177982_a(var5, 0, var6);
               Material var8 = p_175928_1_.func_180495_p(var7).func_177230_c().func_149688_o();
               if(var8 == Material.field_151579_a || var8 == Material.field_151584_j) {
                  this.func_175905_a(p_175928_1_, var7, Blocks.field_150362_t, this.field_76521_c);
               }
            }
         }
      }

   }
}
