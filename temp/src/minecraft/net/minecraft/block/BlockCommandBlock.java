package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.server.CommandBlockLogic;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockCommandBlock extends BlockContainer {

   public static final PropertyBool field_176452_a = PropertyBool.func_177716_a("triggered");
   private static final String __OBFID = "CL_00000219";


   public BlockCommandBlock() {
      super(Material.field_151573_f);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176452_a, Boolean.valueOf(false)));
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntityCommandBlock();
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      if(!p_176204_1_.field_72995_K) {
         boolean var5 = p_176204_1_.func_175640_z(p_176204_2_);
         boolean var6 = ((Boolean)p_176204_3_.func_177229_b(field_176452_a)).booleanValue();
         if(var5 && !var6) {
            p_176204_1_.func_180501_a(p_176204_2_, p_176204_3_.func_177226_a(field_176452_a, Boolean.valueOf(true)), 4);
            p_176204_1_.func_175684_a(p_176204_2_, this, this.func_149738_a(p_176204_1_));
         } else if(!var5 && var6) {
            p_176204_1_.func_180501_a(p_176204_2_, p_176204_3_.func_177226_a(field_176452_a, Boolean.valueOf(false)), 4);
         }
      }

   }

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      TileEntity var5 = p_180650_1_.func_175625_s(p_180650_2_);
      if(var5 instanceof TileEntityCommandBlock) {
         ((TileEntityCommandBlock)var5).func_145993_a().func_145755_a(p_180650_1_);
         p_180650_1_.func_175666_e(p_180650_2_, this);
      }

   }

   public int func_149738_a(World p_149738_1_) {
      return 1;
   }

   public boolean func_180639_a(World p_180639_1_, BlockPos p_180639_2_, IBlockState p_180639_3_, EntityPlayer p_180639_4_, EnumFacing p_180639_5_, float p_180639_6_, float p_180639_7_, float p_180639_8_) {
      TileEntity var9 = p_180639_1_.func_175625_s(p_180639_2_);
      return var9 instanceof TileEntityCommandBlock?((TileEntityCommandBlock)var9).func_145993_a().func_175574_a(p_180639_4_):false;
   }

   public boolean func_149740_M() {
      return true;
   }

   public int func_180641_l(World p_180641_1_, BlockPos p_180641_2_) {
      TileEntity var3 = p_180641_1_.func_175625_s(p_180641_2_);
      return var3 instanceof TileEntityCommandBlock?((TileEntityCommandBlock)var3).func_145993_a().func_145760_g():0;
   }

   public void func_180633_a(World p_180633_1_, BlockPos p_180633_2_, IBlockState p_180633_3_, EntityLivingBase p_180633_4_, ItemStack p_180633_5_) {
      TileEntity var6 = p_180633_1_.func_175625_s(p_180633_2_);
      if(var6 instanceof TileEntityCommandBlock) {
         CommandBlockLogic var7 = ((TileEntityCommandBlock)var6).func_145993_a();
         if(p_180633_5_.func_82837_s()) {
            var7.func_145754_b(p_180633_5_.func_82833_r());
         }

         if(!p_180633_1_.field_72995_K) {
            var7.func_175573_a(p_180633_1_.func_82736_K().func_82766_b("sendCommandFeedback"));
         }

      }
   }

   public int func_149745_a(Random p_149745_1_) {
      return 0;
   }

   public int func_149645_b() {
      return 3;
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176452_a, Boolean.valueOf((p_176203_1_ & 1) > 0));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      int var2 = 0;
      if(((Boolean)p_176201_1_.func_177229_b(field_176452_a)).booleanValue()) {
         var2 |= 1;
      }

      return var2;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176452_a});
   }

   public IBlockState func_180642_a(World p_180642_1_, BlockPos p_180642_2_, EnumFacing p_180642_3_, float p_180642_4_, float p_180642_5_, float p_180642_6_, int p_180642_7_, EntityLivingBase p_180642_8_) {
      return this.func_176223_P().func_177226_a(field_176452_a, Boolean.valueOf(false));
   }

}
