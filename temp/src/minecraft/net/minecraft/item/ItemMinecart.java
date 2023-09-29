package net.minecraft.item;

import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemMinecart extends Item {

   private static final IBehaviorDispenseItem field_96602_b = new BehaviorDefaultDispenseItem() {

      private final BehaviorDefaultDispenseItem field_96465_b = new BehaviorDefaultDispenseItem();
      private static final String __OBFID = "CL_00000050";

      public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
         EnumFacing var3 = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
         World var4 = p_82487_1_.func_82618_k();
         double var5 = p_82487_1_.func_82615_a() + (double)var3.func_82601_c() * 1.125D;
         double var7 = Math.floor(p_82487_1_.func_82617_b()) + (double)var3.func_96559_d();
         double var9 = p_82487_1_.func_82616_c() + (double)var3.func_82599_e() * 1.125D;
         BlockPos var11 = p_82487_1_.func_180699_d().func_177972_a(var3);
         IBlockState var12 = var4.func_180495_p(var11);
         BlockRailBase.EnumRailDirection var13 = var12.func_177230_c() instanceof BlockRailBase?(BlockRailBase.EnumRailDirection)var12.func_177229_b(((BlockRailBase)var12.func_177230_c()).func_176560_l()):BlockRailBase.EnumRailDirection.NORTH_SOUTH;
         double var14;
         if(BlockRailBase.func_176563_d(var12)) {
            if(var13.func_177018_c()) {
               var14 = 0.6D;
            } else {
               var14 = 0.1D;
            }
         } else {
            if(var12.func_177230_c().func_149688_o() != Material.field_151579_a || !BlockRailBase.func_176563_d(var4.func_180495_p(var11.func_177977_b()))) {
               return this.field_96465_b.func_82482_a(p_82487_1_, p_82487_2_);
            }

            IBlockState var16 = var4.func_180495_p(var11.func_177977_b());
            BlockRailBase.EnumRailDirection var17 = var16.func_177230_c() instanceof BlockRailBase?(BlockRailBase.EnumRailDirection)var16.func_177229_b(((BlockRailBase)var16.func_177230_c()).func_176560_l()):BlockRailBase.EnumRailDirection.NORTH_SOUTH;
            if(var3 != EnumFacing.DOWN && var17.func_177018_c()) {
               var14 = -0.4D;
            } else {
               var14 = -0.9D;
            }
         }

         EntityMinecart var18 = EntityMinecart.func_180458_a(var4, var5, var7 + var14, var9, ((ItemMinecart)p_82487_2_.func_77973_b()).field_77841_a);
         if(p_82487_2_.func_82837_s()) {
            var18.func_96094_a(p_82487_2_.func_82833_r());
         }

         var4.func_72838_d(var18);
         p_82487_2_.func_77979_a(1);
         return p_82487_2_;
      }
      protected void func_82485_a(IBlockSource p_82485_1_) {
         p_82485_1_.func_82618_k().func_175718_b(1000, p_82485_1_.func_180699_d(), 0);
      }
   };
   private final EntityMinecart.EnumMinecartType field_77841_a;
   private static final String __OBFID = "CL_00000049";


   public ItemMinecart(EntityMinecart.EnumMinecartType p_i45785_1_) {
      this.field_77777_bU = 1;
      this.field_77841_a = p_i45785_1_;
      this.func_77637_a(CreativeTabs.field_78029_e);
      BlockDispenser.field_149943_a.func_82595_a(this, field_96602_b);
   }

   public boolean func_180614_a(ItemStack p_180614_1_, EntityPlayer p_180614_2_, World p_180614_3_, BlockPos p_180614_4_, EnumFacing p_180614_5_, float p_180614_6_, float p_180614_7_, float p_180614_8_) {
      IBlockState var9 = p_180614_3_.func_180495_p(p_180614_4_);
      if(BlockRailBase.func_176563_d(var9)) {
         if(!p_180614_3_.field_72995_K) {
            BlockRailBase.EnumRailDirection var10 = var9.func_177230_c() instanceof BlockRailBase?(BlockRailBase.EnumRailDirection)var9.func_177229_b(((BlockRailBase)var9.func_177230_c()).func_176560_l()):BlockRailBase.EnumRailDirection.NORTH_SOUTH;
            double var11 = 0.0D;
            if(var10.func_177018_c()) {
               var11 = 0.5D;
            }

            EntityMinecart var13 = EntityMinecart.func_180458_a(p_180614_3_, (double)p_180614_4_.func_177958_n() + 0.5D, (double)p_180614_4_.func_177956_o() + 0.0625D + var11, (double)p_180614_4_.func_177952_p() + 0.5D, this.field_77841_a);
            if(p_180614_1_.func_82837_s()) {
               var13.func_96094_a(p_180614_1_.func_82833_r());
            }

            p_180614_3_.func_72838_d(var13);
         }

         --p_180614_1_.field_77994_a;
         return true;
      } else {
         return false;
      }
   }

}
