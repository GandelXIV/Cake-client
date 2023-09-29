package net.minecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSaddle extends Item {

   private static final String __OBFID = "CL_00000059";


   public ItemSaddle() {
      this.field_77777_bU = 1;
      this.func_77637_a(CreativeTabs.field_78029_e);
   }

   public boolean func_111207_a(ItemStack p_111207_1_, EntityPlayer p_111207_2_, EntityLivingBase p_111207_3_) {
      if(p_111207_3_ instanceof EntityPig) {
         EntityPig var4 = (EntityPig)p_111207_3_;
         if(!var4.func_70901_n() && !var4.func_70631_g_()) {
            var4.func_70900_e(true);
            var4.field_70170_p.func_72956_a(var4, "mob.horse.leather", 0.5F, 1.0F);
            --p_111207_1_.field_77994_a;
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean func_77644_a(ItemStack p_77644_1_, EntityLivingBase p_77644_2_, EntityLivingBase p_77644_3_) {
      this.func_111207_a(p_77644_1_, (EntityPlayer)null, p_77644_2_);
      return true;
   }
}
