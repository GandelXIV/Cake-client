package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockStaticLiquid extends BlockLiquid {

   private static final String __OBFID = "CL_00000315";


   protected BlockStaticLiquid(Material p_i45429_1_) {
      super(p_i45429_1_);
      this.func_149675_a(false);
      if(p_i45429_1_ == Material.field_151587_i) {
         this.func_149675_a(true);
      }

   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      if(!this.func_176365_e(p_176204_1_, p_176204_2_, p_176204_3_)) {
         this.func_176370_f(p_176204_1_, p_176204_2_, p_176204_3_);
      }

   }

   private void func_176370_f(World p_176370_1_, BlockPos p_176370_2_, IBlockState p_176370_3_) {
      BlockDynamicLiquid var4 = func_176361_a(this.field_149764_J);
      p_176370_1_.func_180501_a(p_176370_2_, var4.func_176223_P().func_177226_a(field_176367_b, p_176370_3_.func_177229_b(field_176367_b)), 2);
      p_176370_1_.func_175684_a(p_176370_2_, var4, this.func_149738_a(p_176370_1_));
   }

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      if(this.field_149764_J == Material.field_151587_i) {
         if(p_180650_1_.func_82736_K().func_82766_b("doFireTick")) {
            int var5 = p_180650_4_.nextInt(3);
            if(var5 > 0) {
               BlockPos var6 = p_180650_2_;

               for(int var7 = 0; var7 < var5; ++var7) {
                  var6 = var6.func_177982_a(p_180650_4_.nextInt(3) - 1, 1, p_180650_4_.nextInt(3) - 1);
                  Block var8 = p_180650_1_.func_180495_p(var6).func_177230_c();
                  if(var8.field_149764_J == Material.field_151579_a) {
                     if(this.func_176369_e(p_180650_1_, var6)) {
                        p_180650_1_.func_175656_a(var6, Blocks.field_150480_ab.func_176223_P());
                        return;
                     }
                  } else if(var8.field_149764_J.func_76230_c()) {
                     return;
                  }
               }
            } else {
               for(int var9 = 0; var9 < 3; ++var9) {
                  BlockPos var10 = p_180650_2_.func_177982_a(p_180650_4_.nextInt(3) - 1, 0, p_180650_4_.nextInt(3) - 1);
                  if(p_180650_1_.func_175623_d(var10.func_177984_a()) && this.func_176368_m(p_180650_1_, var10)) {
                     p_180650_1_.func_175656_a(var10.func_177984_a(), Blocks.field_150480_ab.func_176223_P());
                  }
               }
            }

         }
      }
   }

   protected boolean func_176369_e(World p_176369_1_, BlockPos p_176369_2_) {
      EnumFacing[] var3 = EnumFacing.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EnumFacing var6 = var3[var5];
         if(this.func_176368_m(p_176369_1_, p_176369_2_.func_177972_a(var6))) {
            return true;
         }
      }

      return false;
   }

   private boolean func_176368_m(World p_176368_1_, BlockPos p_176368_2_) {
      return p_176368_1_.func_180495_p(p_176368_2_).func_177230_c().func_149688_o().func_76217_h();
   }
}
