package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockGravel extends BlockFalling {

   private static final String __OBFID = "CL_00000252";


   public Item func_180660_a(IBlockState p_180660_1_, Random p_180660_2_, int p_180660_3_) {
      if(p_180660_3_ > 3) {
         p_180660_3_ = 3;
      }

      return p_180660_2_.nextInt(10 - p_180660_3_ * 3) == 0?Items.field_151145_ak:Item.func_150898_a(this);
   }
}
