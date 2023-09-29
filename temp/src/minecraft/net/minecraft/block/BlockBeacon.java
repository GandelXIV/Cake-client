package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.HttpUtil;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;

public class BlockBeacon extends BlockContainer {

   private static final String __OBFID = "CL_00000197";


   public BlockBeacon() {
      super(Material.field_151592_s);
      this.func_149711_c(3.0F);
      this.func_149647_a(CreativeTabs.field_78026_f);
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntityBeacon();
   }

   public boolean func_180639_a(World p_180639_1_, BlockPos p_180639_2_, IBlockState p_180639_3_, EntityPlayer p_180639_4_, EnumFacing p_180639_5_, float p_180639_6_, float p_180639_7_, float p_180639_8_) {
      if(p_180639_1_.field_72995_K) {
         return true;
      } else {
         TileEntity var9 = p_180639_1_.func_175625_s(p_180639_2_);
         if(var9 instanceof TileEntityBeacon) {
            p_180639_4_.func_71007_a((TileEntityBeacon)var9);
         }

         return true;
      }
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public int func_149645_b() {
      return 3;
   }

   public void func_180633_a(World p_180633_1_, BlockPos p_180633_2_, IBlockState p_180633_3_, EntityLivingBase p_180633_4_, ItemStack p_180633_5_) {
      super.func_180633_a(p_180633_1_, p_180633_2_, p_180633_3_, p_180633_4_, p_180633_5_);
      if(p_180633_5_.func_82837_s()) {
         TileEntity var6 = p_180633_1_.func_175625_s(p_180633_2_);
         if(var6 instanceof TileEntityBeacon) {
            ((TileEntityBeacon)var6).func_145999_a(p_180633_5_.func_82833_r());
         }
      }

   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      TileEntity var5 = p_176204_1_.func_175625_s(p_176204_2_);
      if(var5 instanceof TileEntityBeacon) {
         ((TileEntityBeacon)var5).func_174908_m();
         p_176204_1_.func_175641_c(p_176204_2_, this, 1, 0);
      }

   }

   public EnumWorldBlockLayer func_180664_k() {
      return EnumWorldBlockLayer.CUTOUT;
   }

   public static void func_176450_d(final World p_176450_0_, final BlockPos p_176450_1_) {
      HttpUtil.field_180193_a.submit(new Runnable() {

         private static final String __OBFID = "CL_00002136";

         public void run() {
            Chunk var1 = p_176450_0_.func_175726_f(p_176450_1_);

            for(int var2 = p_176450_1_.func_177956_o() - 1; var2 >= 0; --var2) {
               final BlockPos var3 = new BlockPos(p_176450_1_.func_177958_n(), var2, p_176450_1_.func_177952_p());
               if(!var1.func_177444_d(var3)) {
                  break;
               }

               IBlockState var4 = p_176450_0_.func_180495_p(var3);
               if(var4.func_177230_c() == Blocks.field_150461_bJ) {
                  ((WorldServer)p_176450_0_).func_152344_a(new Runnable() {

                     private static final String __OBFID = "CL_00002135";

                     public void run() {
                        TileEntity var1 = p_176450_0_.func_175625_s(var3);
                        if(var1 instanceof TileEntityBeacon) {
                           ((TileEntityBeacon)var1).func_174908_m();
                           p_176450_0_.func_175641_c(var3, Blocks.field_150461_bJ, 1, 0);
                        }

                     }
                  });
               }
            }

         }
      });
   }
}
