package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class BlockEnchantmentTable extends BlockContainer {

   private static final String __OBFID = "CL_00000235";


   protected BlockEnchantmentTable() {
      super(Material.field_151576_e);
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
      this.func_149713_g(0);
      this.func_149647_a(CreativeTabs.field_78031_c);
   }

   public boolean func_149686_d() {
      return false;
   }

   public void func_180655_c(World p_180655_1_, BlockPos p_180655_2_, IBlockState p_180655_3_, Random p_180655_4_) {
      super.func_180655_c(p_180655_1_, p_180655_2_, p_180655_3_, p_180655_4_);

      for(int var5 = -2; var5 <= 2; ++var5) {
         for(int var6 = -2; var6 <= 2; ++var6) {
            if(var5 > -2 && var5 < 2 && var6 == -1) {
               var6 = 2;
            }

            if(p_180655_4_.nextInt(16) == 0) {
               for(int var7 = 0; var7 <= 1; ++var7) {
                  BlockPos var8 = p_180655_2_.func_177982_a(var5, var7, var6);
                  if(p_180655_1_.func_180495_p(var8).func_177230_c() == Blocks.field_150342_X) {
                     if(!p_180655_1_.func_175623_d(p_180655_2_.func_177982_a(var5 / 2, 0, var6 / 2))) {
                        break;
                     }

                     p_180655_1_.func_175688_a(EnumParticleTypes.ENCHANTMENT_TABLE, (double)p_180655_2_.func_177958_n() + 0.5D, (double)p_180655_2_.func_177956_o() + 2.0D, (double)p_180655_2_.func_177952_p() + 0.5D, (double)((float)var5 + p_180655_4_.nextFloat()) - 0.5D, (double)((float)var7 - p_180655_4_.nextFloat() - 1.0F), (double)((float)var6 + p_180655_4_.nextFloat()) - 0.5D, new int[0]);
                  }
               }
            }
         }
      }

   }

   public boolean func_149662_c() {
      return false;
   }

   public int func_149645_b() {
      return 3;
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntityEnchantmentTable();
   }

   public boolean func_180639_a(World p_180639_1_, BlockPos p_180639_2_, IBlockState p_180639_3_, EntityPlayer p_180639_4_, EnumFacing p_180639_5_, float p_180639_6_, float p_180639_7_, float p_180639_8_) {
      if(p_180639_1_.field_72995_K) {
         return true;
      } else {
         TileEntity var9 = p_180639_1_.func_175625_s(p_180639_2_);
         if(var9 instanceof TileEntityEnchantmentTable) {
            p_180639_4_.func_180468_a((TileEntityEnchantmentTable)var9);
         }

         return true;
      }
   }

   public void func_180633_a(World p_180633_1_, BlockPos p_180633_2_, IBlockState p_180633_3_, EntityLivingBase p_180633_4_, ItemStack p_180633_5_) {
      super.func_180633_a(p_180633_1_, p_180633_2_, p_180633_3_, p_180633_4_, p_180633_5_);
      if(p_180633_5_.func_82837_s()) {
         TileEntity var6 = p_180633_1_.func_175625_s(p_180633_2_);
         if(var6 instanceof TileEntityEnchantmentTable) {
            ((TileEntityEnchantmentTable)var6).func_145920_a(p_180633_5_.func_82833_r());
         }
      }

   }
}
