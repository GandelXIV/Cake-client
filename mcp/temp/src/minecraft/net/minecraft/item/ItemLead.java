package net.minecraft.item;

import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemLead extends Item {

   private static final String __OBFID = "CL_00000045";


   public ItemLead() {
      this.func_77637_a(CreativeTabs.field_78040_i);
   }

   public boolean func_180614_a(ItemStack p_180614_1_, EntityPlayer p_180614_2_, World p_180614_3_, BlockPos p_180614_4_, EnumFacing p_180614_5_, float p_180614_6_, float p_180614_7_, float p_180614_8_) {
      Block var9 = p_180614_3_.func_180495_p(p_180614_4_).func_177230_c();
      if(var9 instanceof BlockFence) {
         if(p_180614_3_.field_72995_K) {
            return true;
         } else {
            func_180618_a(p_180614_2_, p_180614_3_, p_180614_4_);
            return true;
         }
      } else {
         return false;
      }
   }

   public static boolean func_180618_a(EntityPlayer p_180618_0_, World p_180618_1_, BlockPos p_180618_2_) {
      EntityLeashKnot var3 = EntityLeashKnot.func_174863_b(p_180618_1_, p_180618_2_);
      boolean var4 = false;
      double var5 = 7.0D;
      int var7 = p_180618_2_.func_177958_n();
      int var8 = p_180618_2_.func_177956_o();
      int var9 = p_180618_2_.func_177952_p();
      List var10 = p_180618_1_.func_72872_a(EntityLiving.class, new AxisAlignedBB((double)var7 - var5, (double)var8 - var5, (double)var9 - var5, (double)var7 + var5, (double)var8 + var5, (double)var9 + var5));
      Iterator var11 = var10.iterator();

      while(var11.hasNext()) {
         EntityLiving var12 = (EntityLiving)var11.next();
         if(var12.func_110167_bD() && var12.func_110166_bE() == p_180618_0_) {
            if(var3 == null) {
               var3 = EntityLeashKnot.func_174862_a(p_180618_1_, p_180618_2_);
            }

            var12.func_110162_b(var3, true);
            var4 = true;
         }
      }

      return var4;
   }
}
