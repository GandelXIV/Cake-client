package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMycelium extends Block {

   public static final PropertyBool field_176384_a = PropertyBool.func_177716_a("snowy");
   private static final String __OBFID = "CL_00000273";


   protected BlockMycelium() {
      super(Material.field_151577_b);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176384_a, Boolean.valueOf(false)));
      this.func_149675_a(true);
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public IBlockState func_176221_a(IBlockState p_176221_1_, IBlockAccess p_176221_2_, BlockPos p_176221_3_) {
      Block var4 = p_176221_2_.func_180495_p(p_176221_3_.func_177984_a()).func_177230_c();
      return p_176221_1_.func_177226_a(field_176384_a, Boolean.valueOf(var4 == Blocks.field_150433_aE || var4 == Blocks.field_150431_aC));
   }

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      if(!p_180650_1_.field_72995_K) {
         if(p_180650_1_.func_175671_l(p_180650_2_.func_177984_a()) < 4 && p_180650_1_.func_180495_p(p_180650_2_.func_177984_a()).func_177230_c().func_149717_k() > 2) {
            p_180650_1_.func_175656_a(p_180650_2_, Blocks.field_150346_d.func_176223_P().func_177226_a(BlockDirt.field_176386_a, BlockDirt.DirtType.DIRT));
         } else {
            if(p_180650_1_.func_175671_l(p_180650_2_.func_177984_a()) >= 9) {
               for(int var5 = 0; var5 < 4; ++var5) {
                  BlockPos var6 = p_180650_2_.func_177982_a(p_180650_4_.nextInt(3) - 1, p_180650_4_.nextInt(5) - 3, p_180650_4_.nextInt(3) - 1);
                  IBlockState var7 = p_180650_1_.func_180495_p(var6);
                  Block var8 = p_180650_1_.func_180495_p(var6.func_177984_a()).func_177230_c();
                  if(var7.func_177230_c() == Blocks.field_150346_d && var7.func_177229_b(BlockDirt.field_176386_a) == BlockDirt.DirtType.DIRT && p_180650_1_.func_175671_l(var6.func_177984_a()) >= 4 && var8.func_149717_k() <= 2) {
                     p_180650_1_.func_175656_a(var6, this.func_176223_P());
                  }
               }
            }

         }
      }
   }

   public void func_180655_c(World p_180655_1_, BlockPos p_180655_2_, IBlockState p_180655_3_, Random p_180655_4_) {
      super.func_180655_c(p_180655_1_, p_180655_2_, p_180655_3_, p_180655_4_);
      if(p_180655_4_.nextInt(10) == 0) {
         p_180655_1_.func_175688_a(EnumParticleTypes.TOWN_AURA, (double)((float)p_180655_2_.func_177958_n() + p_180655_4_.nextFloat()), (double)((float)p_180655_2_.func_177956_o() + 1.1F), (double)((float)p_180655_2_.func_177952_p() + p_180655_4_.nextFloat()), 0.0D, 0.0D, 0.0D, new int[0]);
      }

   }

   public Item func_180660_a(IBlockState p_180660_1_, Random p_180660_2_, int p_180660_3_) {
      return Blocks.field_150346_d.func_180660_a(Blocks.field_150346_d.func_176223_P().func_177226_a(BlockDirt.field_176386_a, BlockDirt.DirtType.DIRT), p_180660_2_, p_180660_3_);
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return 0;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176384_a});
   }

}
