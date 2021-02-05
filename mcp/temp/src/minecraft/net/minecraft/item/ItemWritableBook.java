package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class ItemWritableBook extends Item {

   private static final String __OBFID = "CL_00000076";


   public ItemWritableBook() {
      this.func_77625_d(1);
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      p_77659_3_.func_71048_c(p_77659_1_);
      p_77659_3_.func_71029_a(StatList.field_75929_E[Item.func_150891_b(this)]);
      return p_77659_1_;
   }

   public static boolean func_150930_a(NBTTagCompound p_150930_0_) {
      if(p_150930_0_ == null) {
         return false;
      } else if(!p_150930_0_.func_150297_b("pages", 9)) {
         return false;
      } else {
         NBTTagList var1 = p_150930_0_.func_150295_c("pages", 8);

         for(int var2 = 0; var2 < var1.func_74745_c(); ++var2) {
            String var3 = var1.func_150307_f(var2);
            if(var3 == null) {
               return false;
            }

            if(var3.length() > 32767) {
               return false;
            }
         }

         return true;
      }
   }
}
