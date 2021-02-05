package net.minecraft.world.gen.feature;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGeneratorBonusChest extends WorldGenerator {

   private final List field_175909_a;
   private final int field_76545_b;
   private static final String __OBFID = "CL_00000403";


   public WorldGeneratorBonusChest(List p_i45634_1_, int p_i45634_2_) {
      this.field_175909_a = p_i45634_1_;
      this.field_76545_b = p_i45634_2_;
   }

   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      Block var4;
      while(((var4 = p_180709_1_.func_180495_p(p_180709_3_).func_177230_c()).func_149688_o() == Material.field_151579_a || var4.func_149688_o() == Material.field_151584_j) && p_180709_3_.func_177956_o() > 1) {
         p_180709_3_ = p_180709_3_.func_177977_b();
      }

      if(p_180709_3_.func_177956_o() < 1) {
         return false;
      } else {
         p_180709_3_ = p_180709_3_.func_177984_a();

         for(int var5 = 0; var5 < 4; ++var5) {
            BlockPos var6 = p_180709_3_.func_177982_a(p_180709_2_.nextInt(4) - p_180709_2_.nextInt(4), p_180709_2_.nextInt(3) - p_180709_2_.nextInt(3), p_180709_2_.nextInt(4) - p_180709_2_.nextInt(4));
            if(p_180709_1_.func_175623_d(var6) && World.func_175683_a(p_180709_1_, var6.func_177977_b())) {
               p_180709_1_.func_180501_a(var6, Blocks.field_150486_ae.func_176223_P(), 2);
               TileEntity var7 = p_180709_1_.func_175625_s(var6);
               if(var7 instanceof TileEntityChest) {
                  WeightedRandomChestContent.func_177630_a(p_180709_2_, this.field_175909_a, (TileEntityChest)var7, this.field_76545_b);
               }

               BlockPos var8 = var6.func_177974_f();
               BlockPos var9 = var6.func_177976_e();
               BlockPos var10 = var6.func_177978_c();
               BlockPos var11 = var6.func_177968_d();
               if(p_180709_1_.func_175623_d(var9) && World.func_175683_a(p_180709_1_, var9.func_177977_b())) {
                  p_180709_1_.func_180501_a(var9, Blocks.field_150478_aa.func_176223_P(), 2);
               }

               if(p_180709_1_.func_175623_d(var8) && World.func_175683_a(p_180709_1_, var8.func_177977_b())) {
                  p_180709_1_.func_180501_a(var8, Blocks.field_150478_aa.func_176223_P(), 2);
               }

               if(p_180709_1_.func_175623_d(var10) && World.func_175683_a(p_180709_1_, var10.func_177977_b())) {
                  p_180709_1_.func_180501_a(var10, Blocks.field_150478_aa.func_176223_P(), 2);
               }

               if(p_180709_1_.func_175623_d(var11) && World.func_175683_a(p_180709_1_, var11.func_177977_b())) {
                  p_180709_1_.func_180501_a(var11, Blocks.field_150478_aa.func_176223_P(), 2);
               }

               return true;
            }
         }

         return false;
      }
   }
}
