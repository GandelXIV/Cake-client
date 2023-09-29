package net.minecraft.block;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockDynamicLiquid extends BlockLiquid {

   int field_149815_a;
   private static final String __OBFID = "CL_00000234";


   protected BlockDynamicLiquid(Material p_i45403_1_) {
      super(p_i45403_1_);
   }

   private void func_180690_f(World p_180690_1_, BlockPos p_180690_2_, IBlockState p_180690_3_) {
      p_180690_1_.func_180501_a(p_180690_2_, func_176363_b(this.field_149764_J).func_176223_P().func_177226_a(field_176367_b, p_180690_3_.func_177229_b(field_176367_b)), 2);
   }

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      int var5 = ((Integer)p_180650_3_.func_177229_b(field_176367_b)).intValue();
      byte var6 = 1;
      if(this.field_149764_J == Material.field_151587_i && !p_180650_1_.field_73011_w.func_177500_n()) {
         var6 = 2;
      }

      int var7 = this.func_149738_a(p_180650_1_);
      int var16;
      if(var5 > 0) {
         int var8 = -100;
         this.field_149815_a = 0;

         EnumFacing var10;
         for(Iterator var9 = EnumFacing.Plane.HORIZONTAL.iterator(); var9.hasNext(); var8 = this.func_176371_a(p_180650_1_, p_180650_2_.func_177972_a(var10), var8)) {
            var10 = (EnumFacing)var9.next();
         }

         int var14 = var8 + var6;
         if(var14 >= 8 || var8 < 0) {
            var14 = -1;
         }

         if(this.func_176362_e(p_180650_1_, p_180650_2_.func_177984_a()) >= 0) {
            var16 = this.func_176362_e(p_180650_1_, p_180650_2_.func_177984_a());
            if(var16 >= 8) {
               var14 = var16;
            } else {
               var14 = var16 + 8;
            }
         }

         if(this.field_149815_a >= 2 && this.field_149764_J == Material.field_151586_h) {
            IBlockState var17 = p_180650_1_.func_180495_p(p_180650_2_.func_177977_b());
            if(var17.func_177230_c().func_149688_o().func_76220_a()) {
               var14 = 0;
            } else if(var17.func_177230_c().func_149688_o() == this.field_149764_J && ((Integer)var17.func_177229_b(field_176367_b)).intValue() == 0) {
               var14 = 0;
            }
         }

         if(this.field_149764_J == Material.field_151587_i && var5 < 8 && var14 < 8 && var14 > var5 && p_180650_4_.nextInt(4) != 0) {
            var7 *= 4;
         }

         if(var14 == var5) {
            this.func_180690_f(p_180650_1_, p_180650_2_, p_180650_3_);
         } else {
            var5 = var14;
            if(var14 < 0) {
               p_180650_1_.func_175698_g(p_180650_2_);
            } else {
               p_180650_3_ = p_180650_3_.func_177226_a(field_176367_b, Integer.valueOf(var14));
               p_180650_1_.func_180501_a(p_180650_2_, p_180650_3_, 2);
               p_180650_1_.func_175684_a(p_180650_2_, this, var7);
               p_180650_1_.func_175685_c(p_180650_2_, this);
            }
         }
      } else {
         this.func_180690_f(p_180650_1_, p_180650_2_, p_180650_3_);
      }

      IBlockState var13 = p_180650_1_.func_180495_p(p_180650_2_.func_177977_b());
      if(this.func_176373_h(p_180650_1_, p_180650_2_.func_177977_b(), var13)) {
         if(this.field_149764_J == Material.field_151587_i && p_180650_1_.func_180495_p(p_180650_2_.func_177977_b()).func_177230_c().func_149688_o() == Material.field_151586_h) {
            p_180650_1_.func_175656_a(p_180650_2_.func_177977_b(), Blocks.field_150348_b.func_176223_P());
            this.func_180688_d(p_180650_1_, p_180650_2_.func_177977_b());
            return;
         }

         if(var5 >= 8) {
            this.func_176375_a(p_180650_1_, p_180650_2_.func_177977_b(), var13, var5);
         } else {
            this.func_176375_a(p_180650_1_, p_180650_2_.func_177977_b(), var13, var5 + 8);
         }
      } else if(var5 >= 0 && (var5 == 0 || this.func_176372_g(p_180650_1_, p_180650_2_.func_177977_b(), var13))) {
         Set var15 = this.func_176376_e(p_180650_1_, p_180650_2_);
         var16 = var5 + var6;
         if(var5 >= 8) {
            var16 = 1;
         }

         if(var16 >= 8) {
            return;
         }

         Iterator var11 = var15.iterator();

         while(var11.hasNext()) {
            EnumFacing var12 = (EnumFacing)var11.next();
            this.func_176375_a(p_180650_1_, p_180650_2_.func_177972_a(var12), p_180650_1_.func_180495_p(p_180650_2_.func_177972_a(var12)), var16);
         }
      }

   }

   private void func_176375_a(World p_176375_1_, BlockPos p_176375_2_, IBlockState p_176375_3_, int p_176375_4_) {
      if(this.func_176373_h(p_176375_1_, p_176375_2_, p_176375_3_)) {
         if(p_176375_3_.func_177230_c() != Blocks.field_150350_a) {
            if(this.field_149764_J == Material.field_151587_i) {
               this.func_180688_d(p_176375_1_, p_176375_2_);
            } else {
               p_176375_3_.func_177230_c().func_176226_b(p_176375_1_, p_176375_2_, p_176375_3_, 0);
            }
         }

         p_176375_1_.func_180501_a(p_176375_2_, this.func_176223_P().func_177226_a(field_176367_b, Integer.valueOf(p_176375_4_)), 3);
      }

   }

   private int func_176374_a(World p_176374_1_, BlockPos p_176374_2_, int p_176374_3_, EnumFacing p_176374_4_) {
      int var5 = 1000;
      Iterator var6 = EnumFacing.Plane.HORIZONTAL.iterator();

      while(var6.hasNext()) {
         EnumFacing var7 = (EnumFacing)var6.next();
         if(var7 != p_176374_4_) {
            BlockPos var8 = p_176374_2_.func_177972_a(var7);
            IBlockState var9 = p_176374_1_.func_180495_p(var8);
            if(!this.func_176372_g(p_176374_1_, var8, var9) && (var9.func_177230_c().func_149688_o() != this.field_149764_J || ((Integer)var9.func_177229_b(field_176367_b)).intValue() > 0)) {
               if(!this.func_176372_g(p_176374_1_, var8.func_177977_b(), var9)) {
                  return p_176374_3_;
               }

               if(p_176374_3_ < 4) {
                  int var10 = this.func_176374_a(p_176374_1_, var8, p_176374_3_ + 1, var7.func_176734_d());
                  if(var10 < var5) {
                     var5 = var10;
                  }
               }
            }
         }
      }

      return var5;
   }

   private Set func_176376_e(World p_176376_1_, BlockPos p_176376_2_) {
      int var3 = 1000;
      EnumSet var4 = EnumSet.noneOf(EnumFacing.class);
      Iterator var5 = EnumFacing.Plane.HORIZONTAL.iterator();

      while(var5.hasNext()) {
         EnumFacing var6 = (EnumFacing)var5.next();
         BlockPos var7 = p_176376_2_.func_177972_a(var6);
         IBlockState var8 = p_176376_1_.func_180495_p(var7);
         if(!this.func_176372_g(p_176376_1_, var7, var8) && (var8.func_177230_c().func_149688_o() != this.field_149764_J || ((Integer)var8.func_177229_b(field_176367_b)).intValue() > 0)) {
            int var9;
            if(this.func_176372_g(p_176376_1_, var7.func_177977_b(), p_176376_1_.func_180495_p(var7.func_177977_b()))) {
               var9 = this.func_176374_a(p_176376_1_, var7, 1, var6.func_176734_d());
            } else {
               var9 = 0;
            }

            if(var9 < var3) {
               var4.clear();
            }

            if(var9 <= var3) {
               var4.add(var6);
               var3 = var9;
            }
         }
      }

      return var4;
   }

   private boolean func_176372_g(World p_176372_1_, BlockPos p_176372_2_, IBlockState p_176372_3_) {
      Block var4 = p_176372_1_.func_180495_p(p_176372_2_).func_177230_c();
      return !(var4 instanceof BlockDoor) && var4 != Blocks.field_150472_an && var4 != Blocks.field_150468_ap && var4 != Blocks.field_150436_aH?(var4.field_149764_J == Material.field_151567_E?true:var4.field_149764_J.func_76230_c()):true;
   }

   protected int func_176371_a(World p_176371_1_, BlockPos p_176371_2_, int p_176371_3_) {
      int var4 = this.func_176362_e(p_176371_1_, p_176371_2_);
      if(var4 < 0) {
         return p_176371_3_;
      } else {
         if(var4 == 0) {
            ++this.field_149815_a;
         }

         if(var4 >= 8) {
            var4 = 0;
         }

         return p_176371_3_ >= 0 && var4 >= p_176371_3_?p_176371_3_:var4;
      }
   }

   private boolean func_176373_h(World p_176373_1_, BlockPos p_176373_2_, IBlockState p_176373_3_) {
      Material var4 = p_176373_3_.func_177230_c().func_149688_o();
      return var4 != this.field_149764_J && var4 != Material.field_151587_i && !this.func_176372_g(p_176373_1_, p_176373_2_, p_176373_3_);
   }

   public void func_176213_c(World p_176213_1_, BlockPos p_176213_2_, IBlockState p_176213_3_) {
      if(!this.func_176365_e(p_176213_1_, p_176213_2_, p_176213_3_)) {
         p_176213_1_.func_175684_a(p_176213_2_, this, this.func_149738_a(p_176213_1_));
      }

   }
}
