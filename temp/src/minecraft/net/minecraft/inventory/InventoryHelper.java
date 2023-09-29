package net.minecraft.inventory;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class InventoryHelper {

   private static final Random field_180177_a = new Random();
   private static final String __OBFID = "CL_00002262";


   public static void func_180175_a(World p_180175_0_, BlockPos p_180175_1_, IInventory p_180175_2_) {
      func_180174_a(p_180175_0_, (double)p_180175_1_.func_177958_n(), (double)p_180175_1_.func_177956_o(), (double)p_180175_1_.func_177952_p(), p_180175_2_);
   }

   public static void func_180176_a(World p_180176_0_, Entity p_180176_1_, IInventory p_180176_2_) {
      func_180174_a(p_180176_0_, p_180176_1_.field_70165_t, p_180176_1_.field_70163_u, p_180176_1_.field_70161_v, p_180176_2_);
   }

   private static void func_180174_a(World p_180174_0_, double p_180174_1_, double p_180174_3_, double p_180174_5_, IInventory p_180174_7_) {
      for(int var8 = 0; var8 < p_180174_7_.func_70302_i_(); ++var8) {
         ItemStack var9 = p_180174_7_.func_70301_a(var8);
         if(var9 != null) {
            func_180173_a(p_180174_0_, p_180174_1_, p_180174_3_, p_180174_5_, var9);
         }
      }

   }

   private static void func_180173_a(World p_180173_0_, double p_180173_1_, double p_180173_3_, double p_180173_5_, ItemStack p_180173_7_) {
      float var8 = field_180177_a.nextFloat() * 0.8F + 0.1F;
      float var9 = field_180177_a.nextFloat() * 0.8F + 0.1F;
      float var10 = field_180177_a.nextFloat() * 0.8F + 0.1F;

      while(p_180173_7_.field_77994_a > 0) {
         int var11 = field_180177_a.nextInt(21) + 10;
         if(var11 > p_180173_7_.field_77994_a) {
            var11 = p_180173_7_.field_77994_a;
         }

         p_180173_7_.field_77994_a -= var11;
         EntityItem var12 = new EntityItem(p_180173_0_, p_180173_1_ + (double)var8, p_180173_3_ + (double)var9, p_180173_5_ + (double)var10, new ItemStack(p_180173_7_.func_77973_b(), var11, p_180173_7_.func_77960_j()));
         if(p_180173_7_.func_77942_o()) {
            var12.func_92059_d().func_77982_d((NBTTagCompound)p_180173_7_.func_77978_p().func_74737_b());
         }

         float var13 = 0.05F;
         var12.field_70159_w = field_180177_a.nextGaussian() * (double)var13;
         var12.field_70181_x = field_180177_a.nextGaussian() * (double)var13 + 0.20000000298023224D;
         var12.field_70179_y = field_180177_a.nextGaussian() * (double)var13;
         p_180173_0_.func_72838_d(var12);
      }

   }

}
