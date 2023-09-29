package net.minecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMapBase;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;

public class ItemEmptyMap extends ItemMapBase {

   private static final String __OBFID = "CL_00000024";


   protected ItemEmptyMap() {
      this.func_77637_a(CreativeTabs.field_78026_f);
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      ItemStack var4 = new ItemStack(Items.field_151098_aY, 1, p_77659_2_.func_72841_b("map"));
      String var5 = "map_" + var4.func_77960_j();
      MapData var6 = new MapData(var5);
      p_77659_2_.func_72823_a(var5, var6);
      var6.field_76197_d = 0;
      var6.func_176054_a(p_77659_3_.field_70165_t, p_77659_3_.field_70161_v, var6.field_76197_d);
      var6.field_76200_c = (byte)p_77659_2_.field_73011_w.func_177502_q();
      var6.func_76185_a();
      --p_77659_1_.field_77994_a;
      if(p_77659_1_.field_77994_a <= 0) {
         return var4;
      } else {
         if(!p_77659_3_.field_71071_by.func_70441_a(var4.func_77946_l())) {
            p_77659_3_.func_71019_a(var4, false);
         }

         p_77659_3_.func_71029_a(StatList.field_75929_E[Item.func_150891_b(this)]);
         return p_77659_1_;
      }
   }
}
