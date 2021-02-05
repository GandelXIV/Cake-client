package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemRedstone extends Item {

   private static final String __OBFID = "CL_00000058";


   public ItemRedstone() {
      this.func_77637_a(CreativeTabs.field_78028_d);
   }

   public boolean func_180614_a(ItemStack p_180614_1_, EntityPlayer p_180614_2_, World p_180614_3_, BlockPos p_180614_4_, EnumFacing p_180614_5_, float p_180614_6_, float p_180614_7_, float p_180614_8_) {
      boolean var9 = p_180614_3_.func_180495_p(p_180614_4_).func_177230_c().func_176200_f(p_180614_3_, p_180614_4_);
      BlockPos var10 = var9?p_180614_4_:p_180614_4_.func_177972_a(p_180614_5_);
      if(!p_180614_2_.func_175151_a(var10, p_180614_5_, p_180614_1_)) {
         return false;
      } else {
         Block var11 = p_180614_3_.func_180495_p(var10).func_177230_c();
         if(!p_180614_3_.func_175716_a(var11, var10, false, p_180614_5_, (Entity)null, p_180614_1_)) {
            return false;
         } else if(Blocks.field_150488_af.func_176196_c(p_180614_3_, var10)) {
            --p_180614_1_.field_77994_a;
            p_180614_3_.func_175656_a(var10, Blocks.field_150488_af.func_176223_P());
            return true;
         } else {
            return false;
         }
      }
   }
}
