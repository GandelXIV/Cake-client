package net.minecraft.item;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFireworkCharge;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemFirework extends Item {

   private static final String __OBFID = "CL_00000031";


   public boolean func_180614_a(ItemStack p_180614_1_, EntityPlayer p_180614_2_, World p_180614_3_, BlockPos p_180614_4_, EnumFacing p_180614_5_, float p_180614_6_, float p_180614_7_, float p_180614_8_) {
      if(!p_180614_3_.field_72995_K) {
         EntityFireworkRocket var9 = new EntityFireworkRocket(p_180614_3_, (double)((float)p_180614_4_.func_177958_n() + p_180614_6_), (double)((float)p_180614_4_.func_177956_o() + p_180614_7_), (double)((float)p_180614_4_.func_177952_p() + p_180614_8_), p_180614_1_);
         p_180614_3_.func_72838_d(var9);
         if(!p_180614_2_.field_71075_bZ.field_75098_d) {
            --p_180614_1_.field_77994_a;
         }

         return true;
      } else {
         return false;
      }
   }

   public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
      if(p_77624_1_.func_77942_o()) {
         NBTTagCompound var5 = p_77624_1_.func_77978_p().func_74775_l("Fireworks");
         if(var5 != null) {
            if(var5.func_150297_b("Flight", 99)) {
               p_77624_3_.add(StatCollector.func_74838_a("item.fireworks.flight") + " " + var5.func_74771_c("Flight"));
            }

            NBTTagList var6 = var5.func_150295_c("Explosions", 10);
            if(var6 != null && var6.func_74745_c() > 0) {
               for(int var7 = 0; var7 < var6.func_74745_c(); ++var7) {
                  NBTTagCompound var8 = var6.func_150305_b(var7);
                  ArrayList var9 = Lists.newArrayList();
                  ItemFireworkCharge.func_150902_a(var8, var9);
                  if(var9.size() > 0) {
                     for(int var10 = 1; var10 < var9.size(); ++var10) {
                        var9.set(var10, "  " + (String)var9.get(var10));
                     }

                     p_77624_3_.addAll(var9);
                  }
               }
            }

         }
      }
   }
}
