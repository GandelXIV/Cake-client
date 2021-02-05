package net.minecraft.block;

import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockSourceImpl;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityDropper;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockDropper extends BlockDispenser {

   private final IBehaviorDispenseItem field_149947_P = new BehaviorDefaultDispenseItem();
   private static final String __OBFID = "CL_00000233";


   protected IBehaviorDispenseItem func_149940_a(ItemStack p_149940_1_) {
      return this.field_149947_P;
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntityDropper();
   }

   protected void func_176439_d(World p_176439_1_, BlockPos p_176439_2_) {
      BlockSourceImpl var3 = new BlockSourceImpl(p_176439_1_, p_176439_2_);
      TileEntityDispenser var4 = (TileEntityDispenser)var3.func_150835_j();
      if(var4 != null) {
         int var5 = var4.func_146017_i();
         if(var5 < 0) {
            p_176439_1_.func_175718_b(1001, p_176439_2_, 0);
         } else {
            ItemStack var6 = var4.func_70301_a(var5);
            if(var6 != null) {
               EnumFacing var7 = (EnumFacing)p_176439_1_.func_180495_p(p_176439_2_).func_177229_b(field_176441_a);
               BlockPos var8 = p_176439_2_.func_177972_a(var7);
               IInventory var9 = TileEntityHopper.func_145893_b(p_176439_1_, (double)var8.func_177958_n(), (double)var8.func_177956_o(), (double)var8.func_177952_p());
               ItemStack var10;
               if(var9 == null) {
                  var10 = this.field_149947_P.func_82482_a(var3, var6);
                  if(var10 != null && var10.field_77994_a == 0) {
                     var10 = null;
                  }
               } else {
                  var10 = TileEntityHopper.func_174918_a(var9, var6.func_77946_l().func_77979_a(1), var7.func_176734_d());
                  if(var10 == null) {
                     var10 = var6.func_77946_l();
                     if(--var10.field_77994_a == 0) {
                        var10 = null;
                     }
                  } else {
                     var10 = var6.func_77946_l();
                  }
               }

               var4.func_70299_a(var5, var10);
            }
         }
      }
   }
}
