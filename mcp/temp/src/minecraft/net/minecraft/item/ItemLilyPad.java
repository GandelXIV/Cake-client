package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemColored;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemLilyPad extends ItemColored {

   private static final String __OBFID = "CL_00000074";


   public ItemLilyPad(Block p_i45357_1_) {
      super(p_i45357_1_, false);
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      MovingObjectPosition var4 = this.func_77621_a(p_77659_2_, p_77659_3_, true);
      if(var4 == null) {
         return p_77659_1_;
      } else {
         if(var4.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
            BlockPos var5 = var4.func_178782_a();
            if(!p_77659_2_.func_175660_a(p_77659_3_, var5)) {
               return p_77659_1_;
            }

            if(!p_77659_3_.func_175151_a(var5.func_177972_a(var4.field_178784_b), var4.field_178784_b, p_77659_1_)) {
               return p_77659_1_;
            }

            BlockPos var6 = var5.func_177984_a();
            IBlockState var7 = p_77659_2_.func_180495_p(var5);
            if(var7.func_177230_c().func_149688_o() == Material.field_151586_h && ((Integer)var7.func_177229_b(BlockLiquid.field_176367_b)).intValue() == 0 && p_77659_2_.func_175623_d(var6)) {
               p_77659_2_.func_175656_a(var6, Blocks.field_150392_bi.func_176223_P());
               if(!p_77659_3_.field_71075_bZ.field_75098_d) {
                  --p_77659_1_.field_77994_a;
               }

               p_77659_3_.func_71029_a(StatList.field_75929_E[Item.func_150891_b(this)]);
            }
         }

         return p_77659_1_;
      }
   }

   public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_) {
      return Blocks.field_150392_bi.func_180644_h(Blocks.field_150392_bi.func_176203_a(p_82790_1_.func_77960_j()));
   }
}
