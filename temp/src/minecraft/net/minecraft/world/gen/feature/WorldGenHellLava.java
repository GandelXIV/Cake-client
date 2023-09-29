package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenHellLava extends WorldGenerator {

   private final Block field_150553_a;
   private final boolean field_94524_b;
   private static final String __OBFID = "CL_00000414";


   public WorldGenHellLava(Block p_i45453_1_, boolean p_i45453_2_) {
      this.field_150553_a = p_i45453_1_;
      this.field_94524_b = p_i45453_2_;
   }

   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      if(p_180709_1_.func_180495_p(p_180709_3_.func_177984_a()).func_177230_c() != Blocks.field_150424_aL) {
         return false;
      } else if(p_180709_1_.func_180495_p(p_180709_3_).func_177230_c().func_149688_o() != Material.field_151579_a && p_180709_1_.func_180495_p(p_180709_3_).func_177230_c() != Blocks.field_150424_aL) {
         return false;
      } else {
         int var4 = 0;
         if(p_180709_1_.func_180495_p(p_180709_3_.func_177976_e()).func_177230_c() == Blocks.field_150424_aL) {
            ++var4;
         }

         if(p_180709_1_.func_180495_p(p_180709_3_.func_177974_f()).func_177230_c() == Blocks.field_150424_aL) {
            ++var4;
         }

         if(p_180709_1_.func_180495_p(p_180709_3_.func_177978_c()).func_177230_c() == Blocks.field_150424_aL) {
            ++var4;
         }

         if(p_180709_1_.func_180495_p(p_180709_3_.func_177968_d()).func_177230_c() == Blocks.field_150424_aL) {
            ++var4;
         }

         if(p_180709_1_.func_180495_p(p_180709_3_.func_177977_b()).func_177230_c() == Blocks.field_150424_aL) {
            ++var4;
         }

         int var5 = 0;
         if(p_180709_1_.func_175623_d(p_180709_3_.func_177976_e())) {
            ++var5;
         }

         if(p_180709_1_.func_175623_d(p_180709_3_.func_177974_f())) {
            ++var5;
         }

         if(p_180709_1_.func_175623_d(p_180709_3_.func_177978_c())) {
            ++var5;
         }

         if(p_180709_1_.func_175623_d(p_180709_3_.func_177968_d())) {
            ++var5;
         }

         if(p_180709_1_.func_175623_d(p_180709_3_.func_177977_b())) {
            ++var5;
         }

         if(!this.field_94524_b && var4 == 4 && var5 == 1 || var4 == 5) {
            p_180709_1_.func_180501_a(p_180709_3_, this.field_150553_a.func_176223_P(), 2);
            p_180709_1_.func_175637_a(this.field_150553_a, p_180709_3_, p_180709_2_);
         }

         return true;
      }
   }
}
