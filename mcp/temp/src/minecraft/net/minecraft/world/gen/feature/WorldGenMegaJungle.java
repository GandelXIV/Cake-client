package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;

public class WorldGenMegaJungle extends WorldGenHugeTrees {

   private static final String __OBFID = "CL_00000420";


   public WorldGenMegaJungle(boolean p_i45456_1_, int p_i45456_2_, int p_i45456_3_, int p_i45456_4_, int p_i45456_5_) {
      super(p_i45456_1_, p_i45456_2_, p_i45456_3_, p_i45456_4_, p_i45456_5_);
   }

   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      int var4 = this.func_150533_a(p_180709_2_);
      if(!this.func_175929_a(p_180709_1_, p_180709_2_, p_180709_3_, var4)) {
         return false;
      } else {
         this.func_175930_c(p_180709_1_, p_180709_3_.func_177981_b(var4), 2);

         for(int var5 = p_180709_3_.func_177956_o() + var4 - 2 - p_180709_2_.nextInt(4); var5 > p_180709_3_.func_177956_o() + var4 / 2; var5 -= 2 + p_180709_2_.nextInt(4)) {
            float var6 = p_180709_2_.nextFloat() * 3.1415927F * 2.0F;
            int var7 = p_180709_3_.func_177958_n() + (int)(0.5F + MathHelper.func_76134_b(var6) * 4.0F);
            int var8 = p_180709_3_.func_177952_p() + (int)(0.5F + MathHelper.func_76126_a(var6) * 4.0F);

            int var9;
            for(var9 = 0; var9 < 5; ++var9) {
               var7 = p_180709_3_.func_177958_n() + (int)(1.5F + MathHelper.func_76134_b(var6) * (float)var9);
               var8 = p_180709_3_.func_177952_p() + (int)(1.5F + MathHelper.func_76126_a(var6) * (float)var9);
               this.func_175905_a(p_180709_1_, new BlockPos(var7, var5 - 3 + var9 / 2, var8), Blocks.field_150364_r, this.field_76520_b);
            }

            var9 = 1 + p_180709_2_.nextInt(2);
            int var10 = var5;

            for(int var11 = var5 - var9; var11 <= var10; ++var11) {
               int var12 = var11 - var10;
               this.func_175928_b(p_180709_1_, new BlockPos(var7, var11, var8), 1 - var12);
            }
         }

         for(int var13 = 0; var13 < var4; ++var13) {
            BlockPos var14 = p_180709_3_.func_177981_b(var13);
            if(this.func_175931_a(p_180709_1_.func_180495_p(var14).func_177230_c().func_149688_o())) {
               this.func_175905_a(p_180709_1_, var14, Blocks.field_150364_r, this.field_76520_b);
               if(var13 > 0) {
                  this.func_175932_b(p_180709_1_, p_180709_2_, var14.func_177976_e(), BlockVine.field_176275_S);
                  this.func_175932_b(p_180709_1_, p_180709_2_, var14.func_177978_c(), BlockVine.field_176272_Q);
               }
            }

            if(var13 < var4 - 1) {
               BlockPos var15 = var14.func_177974_f();
               if(this.func_175931_a(p_180709_1_.func_180495_p(var15).func_177230_c().func_149688_o())) {
                  this.func_175905_a(p_180709_1_, var15, Blocks.field_150364_r, this.field_76520_b);
                  if(var13 > 0) {
                     this.func_175932_b(p_180709_1_, p_180709_2_, var15.func_177974_f(), BlockVine.field_176271_T);
                     this.func_175932_b(p_180709_1_, p_180709_2_, var15.func_177978_c(), BlockVine.field_176272_Q);
                  }
               }

               BlockPos var16 = var14.func_177968_d().func_177974_f();
               if(this.func_175931_a(p_180709_1_.func_180495_p(var16).func_177230_c().func_149688_o())) {
                  this.func_175905_a(p_180709_1_, var16, Blocks.field_150364_r, this.field_76520_b);
                  if(var13 > 0) {
                     this.func_175932_b(p_180709_1_, p_180709_2_, var16.func_177974_f(), BlockVine.field_176271_T);
                     this.func_175932_b(p_180709_1_, p_180709_2_, var16.func_177968_d(), BlockVine.field_176276_R);
                  }
               }

               BlockPos var17 = var14.func_177968_d();
               if(this.func_175931_a(p_180709_1_.func_180495_p(var17).func_177230_c().func_149688_o())) {
                  this.func_175905_a(p_180709_1_, var17, Blocks.field_150364_r, this.field_76520_b);
                  if(var13 > 0) {
                     this.func_175932_b(p_180709_1_, p_180709_2_, var17.func_177976_e(), BlockVine.field_176275_S);
                     this.func_175932_b(p_180709_1_, p_180709_2_, var17.func_177968_d(), BlockVine.field_176276_R);
                  }
               }
            }
         }

         return true;
      }
   }

   private boolean func_175931_a(Material p_175931_1_) {
      return p_175931_1_ == Material.field_151579_a || p_175931_1_ == Material.field_151584_j;
   }

   private void func_175932_b(World p_175932_1_, Random p_175932_2_, BlockPos p_175932_3_, int p_175932_4_) {
      if(p_175932_2_.nextInt(3) > 0 && p_175932_1_.func_175623_d(p_175932_3_)) {
         this.func_175905_a(p_175932_1_, p_175932_3_, Blocks.field_150395_bd, p_175932_4_);
      }

   }

   private void func_175930_c(World p_175930_1_, BlockPos p_175930_2_, int p_175930_3_) {
      byte var4 = 2;

      for(int var5 = -var4; var5 <= 0; ++var5) {
         this.func_175925_a(p_175930_1_, p_175930_2_.func_177981_b(var5), p_175930_3_ + 1 - var5);
      }

   }
}
