package net.minecraft.block;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Tuple;
import net.minecraft.world.World;

public class BlockSponge extends Block {

   public static final PropertyBool field_176313_a = PropertyBool.func_177716_a("wet");
   private static final String __OBFID = "CL_00000311";


   protected BlockSponge() {
      super(Material.field_151583_m);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176313_a, Boolean.valueOf(false)));
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public int func_180651_a(IBlockState p_180651_1_) {
      return ((Boolean)p_180651_1_.func_177229_b(field_176313_a)).booleanValue()?1:0;
   }

   public void func_176213_c(World p_176213_1_, BlockPos p_176213_2_, IBlockState p_176213_3_) {
      this.func_176311_e(p_176213_1_, p_176213_2_, p_176213_3_);
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      this.func_176311_e(p_176204_1_, p_176204_2_, p_176204_3_);
      super.func_176204_a(p_176204_1_, p_176204_2_, p_176204_3_, p_176204_4_);
   }

   protected void func_176311_e(World p_176311_1_, BlockPos p_176311_2_, IBlockState p_176311_3_) {
      if(!((Boolean)p_176311_3_.func_177229_b(field_176313_a)).booleanValue() && this.func_176312_d(p_176311_1_, p_176311_2_)) {
         p_176311_1_.func_180501_a(p_176311_2_, p_176311_3_.func_177226_a(field_176313_a, Boolean.valueOf(true)), 2);
         p_176311_1_.func_175718_b(2001, p_176311_2_, Block.func_149682_b(Blocks.field_150355_j));
      }

   }

   private boolean func_176312_d(World p_176312_1_, BlockPos p_176312_2_) {
      LinkedList var3 = Lists.newLinkedList();
      ArrayList var4 = Lists.newArrayList();
      var3.add(new Tuple(p_176312_2_, Integer.valueOf(0)));
      int var5 = 0;

      BlockPos var7;
      while(!var3.isEmpty()) {
         Tuple var6 = (Tuple)var3.poll();
         var7 = (BlockPos)var6.func_76341_a();
         int var8 = ((Integer)var6.func_76340_b()).intValue();
         EnumFacing[] var9 = EnumFacing.values();
         int var10 = var9.length;

         for(int var11 = 0; var11 < var10; ++var11) {
            EnumFacing var12 = var9[var11];
            BlockPos var13 = var7.func_177972_a(var12);
            if(p_176312_1_.func_180495_p(var13).func_177230_c().func_149688_o() == Material.field_151586_h) {
               p_176312_1_.func_180501_a(var13, Blocks.field_150350_a.func_176223_P(), 2);
               var4.add(var13);
               ++var5;
               if(var8 < 6) {
                  var3.add(new Tuple(var13, Integer.valueOf(var8 + 1)));
               }
            }
         }

         if(var5 > 64) {
            break;
         }
      }

      Iterator var14 = var4.iterator();

      while(var14.hasNext()) {
         var7 = (BlockPos)var14.next();
         p_176312_1_.func_175685_c(var7, Blocks.field_150350_a);
      }

      return var5 > 0;
   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
      p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176313_a, Boolean.valueOf((p_176203_1_ & 1) == 1));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((Boolean)p_176201_1_.func_177229_b(field_176313_a)).booleanValue()?1:0;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176313_a});
   }

   public void func_180655_c(World p_180655_1_, BlockPos p_180655_2_, IBlockState p_180655_3_, Random p_180655_4_) {
      if(((Boolean)p_180655_3_.func_177229_b(field_176313_a)).booleanValue()) {
         EnumFacing var5 = EnumFacing.func_176741_a(p_180655_4_);
         if(var5 != EnumFacing.UP && !World.func_175683_a(p_180655_1_, p_180655_2_.func_177972_a(var5))) {
            double var6 = (double)p_180655_2_.func_177958_n();
            double var8 = (double)p_180655_2_.func_177956_o();
            double var10 = (double)p_180655_2_.func_177952_p();
            if(var5 == EnumFacing.DOWN) {
               var8 -= 0.05D;
               var6 += p_180655_4_.nextDouble();
               var10 += p_180655_4_.nextDouble();
            } else {
               var8 += p_180655_4_.nextDouble() * 0.8D;
               if(var5.func_176740_k() == EnumFacing.Axis.X) {
                  var10 += p_180655_4_.nextDouble();
                  if(var5 == EnumFacing.EAST) {
                     ++var6;
                  } else {
                     var6 += 0.05D;
                  }
               } else {
                  var6 += p_180655_4_.nextDouble();
                  if(var5 == EnumFacing.SOUTH) {
                     ++var10;
                  } else {
                     var10 += 0.05D;
                  }
               }
            }

            p_180655_1_.func_175688_a(EnumParticleTypes.DRIP_WATER, var6, var8, var10, 0.0D, 0.0D, 0.0D, new int[0]);
         }
      }
   }

}
