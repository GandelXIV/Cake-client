package net.minecraft.item;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemGlassBottle extends Item {

   private static final String __OBFID = "CL_00001776";


   public ItemGlassBottle() {
      this.func_77637_a(CreativeTabs.field_78038_k);
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

            if(p_77659_2_.func_180495_p(var5).func_177230_c().func_149688_o() == Material.field_151586_h) {
               --p_77659_1_.field_77994_a;
               p_77659_3_.func_71029_a(StatList.field_75929_E[Item.func_150891_b(this)]);
               if(p_77659_1_.field_77994_a <= 0) {
                  return new ItemStack(Items.field_151068_bn);
               }

               if(!p_77659_3_.field_71071_by.func_70441_a(new ItemStack(Items.field_151068_bn))) {
                  p_77659_3_.func_71019_a(new ItemStack(Items.field_151068_bn, 1, 0), false);
               }
            }
         }

         return p_77659_1_;
      }
   }
}
