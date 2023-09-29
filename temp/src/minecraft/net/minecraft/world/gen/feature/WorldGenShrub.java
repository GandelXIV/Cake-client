package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;

public class WorldGenShrub extends WorldGenTrees {

   private int field_150528_a;
   private int field_150527_b;
   private static final String __OBFID = "CL_00000411";


   public WorldGenShrub(int p_i2015_1_, int p_i2015_2_) {
      super(false);
      this.field_150527_b = p_i2015_1_;
      this.field_150528_a = p_i2015_2_;
   }

   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      Block var4;
      while(((var4 = p_180709_1_.func_180495_p(p_180709_3_).func_177230_c()).func_149688_o() == Material.field_151579_a || var4.func_149688_o() == Material.field_151584_j) && p_180709_3_.func_177956_o() > 0) {
         p_180709_3_ = p_180709_3_.func_177977_b();
      }

      Block var5 = p_180709_1_.func_180495_p(p_180709_3_).func_177230_c();
      if(var5 == Blocks.field_150346_d || var5 == Blocks.field_150349_c) {
         p_180709_3_ = p_180709_3_.func_177984_a();
         this.func_175905_a(p_180709_1_, p_180709_3_, Blocks.field_150364_r, this.field_150527_b);

         for(int var6 = p_180709_3_.func_177956_o(); var6 <= p_180709_3_.func_177956_o() + 2; ++var6) {
            int var7 = var6 - p_180709_3_.func_177956_o();
            int var8 = 2 - var7;

            for(int var9 = p_180709_3_.func_177958_n() - var8; var9 <= p_180709_3_.func_177958_n() + var8; ++var9) {
               int var10 = var9 - p_180709_3_.func_177958_n();

               for(int var11 = p_180709_3_.func_177952_p() - var8; var11 <= p_180709_3_.func_177952_p() + var8; ++var11) {
                  int var12 = var11 - p_180709_3_.func_177952_p();
                  if(Math.abs(var10) != var8 || Math.abs(var12) != var8 || p_180709_2_.nextInt(2) != 0) {
                     BlockPos var13 = new BlockPos(var9, var6, var11);
                     if(!p_180709_1_.func_180495_p(var13).func_177230_c().func_149730_j()) {
                        this.func_175905_a(p_180709_1_, var13, Blocks.field_150362_t, this.field_150528_a);
                     }
                  }
               }
            }
         }
      }

      return true;
   }
}
