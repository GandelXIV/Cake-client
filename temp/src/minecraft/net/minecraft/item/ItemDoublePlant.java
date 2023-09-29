package net.minecraft.item;

import com.google.common.base.Function;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.world.ColorizerGrass;

public class ItemDoublePlant extends ItemMultiTexture {

   private static final String __OBFID = "CL_00000021";


   public ItemDoublePlant(Block p_i45787_1_, Block p_i45787_2_, Function p_i45787_3_) {
      super(p_i45787_1_, p_i45787_2_, p_i45787_3_);
   }

   public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_) {
      BlockDoublePlant.EnumPlantType var3 = BlockDoublePlant.EnumPlantType.func_176938_a(p_82790_1_.func_77960_j());
      return var3 != BlockDoublePlant.EnumPlantType.GRASS && var3 != BlockDoublePlant.EnumPlantType.FERN?super.func_82790_a(p_82790_1_, p_82790_2_):ColorizerGrass.func_77480_a(0.5D, 1.0D);
   }
}
