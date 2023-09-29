package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemBucket extends Item {

   private Block field_77876_a;
   private static final String __OBFID = "CL_00000000";


   public ItemBucket(Block p_i45331_1_) {
      this.field_77777_bU = 1;
      this.field_77876_a = p_i45331_1_;
      this.func_77637_a(CreativeTabs.field_78026_f);
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      boolean var4 = this.field_77876_a == Blocks.field_150350_a;
      MovingObjectPosition var5 = this.func_77621_a(p_77659_2_, p_77659_3_, var4);
      if(var5 == null) {
         return p_77659_1_;
      } else {
         if(var5.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
            BlockPos var6 = var5.func_178782_a();
            if(!p_77659_2_.func_175660_a(p_77659_3_, var6)) {
               return p_77659_1_;
            }

            if(var4) {
               if(!p_77659_3_.func_175151_a(var6.func_177972_a(var5.field_178784_b), var5.field_178784_b, p_77659_1_)) {
                  return p_77659_1_;
               }

               IBlockState var7 = p_77659_2_.func_180495_p(var6);
               Material var8 = var7.func_177230_c().func_149688_o();
               if(var8 == Material.field_151586_h && ((Integer)var7.func_177229_b(BlockLiquid.field_176367_b)).intValue() == 0) {
                  p_77659_2_.func_175698_g(var6);
                  p_77659_3_.func_71029_a(StatList.field_75929_E[Item.func_150891_b(this)]);
                  return this.func_150910_a(p_77659_1_, p_77659_3_, Items.field_151131_as);
               }

               if(var8 == Material.field_151587_i && ((Integer)var7.func_177229_b(BlockLiquid.field_176367_b)).intValue() == 0) {
                  p_77659_2_.func_175698_g(var6);
                  p_77659_3_.func_71029_a(StatList.field_75929_E[Item.func_150891_b(this)]);
                  return this.func_150910_a(p_77659_1_, p_77659_3_, Items.field_151129_at);
               }
            } else {
               if(this.field_77876_a == Blocks.field_150350_a) {
                  return new ItemStack(Items.field_151133_ar);
               }

               BlockPos var9 = var6.func_177972_a(var5.field_178784_b);
               if(!p_77659_3_.func_175151_a(var9, var5.field_178784_b, p_77659_1_)) {
                  return p_77659_1_;
               }

               if(this.func_180616_a(p_77659_2_, var9) && !p_77659_3_.field_71075_bZ.field_75098_d) {
                  p_77659_3_.func_71029_a(StatList.field_75929_E[Item.func_150891_b(this)]);
                  return new ItemStack(Items.field_151133_ar);
               }
            }
         }

         return p_77659_1_;
      }
   }

   private ItemStack func_150910_a(ItemStack p_150910_1_, EntityPlayer p_150910_2_, Item p_150910_3_) {
      if(p_150910_2_.field_71075_bZ.field_75098_d) {
         return p_150910_1_;
      } else if(--p_150910_1_.field_77994_a <= 0) {
         return new ItemStack(p_150910_3_);
      } else {
         if(!p_150910_2_.field_71071_by.func_70441_a(new ItemStack(p_150910_3_))) {
            p_150910_2_.func_71019_a(new ItemStack(p_150910_3_, 1, 0), false);
         }

         return p_150910_1_;
      }
   }

   public boolean func_180616_a(World p_180616_1_, BlockPos p_180616_2_) {
      if(this.field_77876_a == Blocks.field_150350_a) {
         return false;
      } else {
         Material var3 = p_180616_1_.func_180495_p(p_180616_2_).func_177230_c().func_149688_o();
         boolean var4 = !var3.func_76220_a();
         if(!p_180616_1_.func_175623_d(p_180616_2_) && !var4) {
            return false;
         } else {
            if(p_180616_1_.field_73011_w.func_177500_n() && this.field_77876_a == Blocks.field_150358_i) {
               int var5 = p_180616_2_.func_177958_n();
               int var6 = p_180616_2_.func_177956_o();
               int var7 = p_180616_2_.func_177952_p();
               p_180616_1_.func_72908_a((double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), (double)((float)var7 + 0.5F), "random.fizz", 0.5F, 2.6F + (p_180616_1_.field_73012_v.nextFloat() - p_180616_1_.field_73012_v.nextFloat()) * 0.8F);

               for(int var8 = 0; var8 < 8; ++var8) {
                  p_180616_1_.func_175688_a(EnumParticleTypes.SMOKE_LARGE, (double)var5 + Math.random(), (double)var6 + Math.random(), (double)var7 + Math.random(), 0.0D, 0.0D, 0.0D, new int[0]);
               }
            } else {
               if(!p_180616_1_.field_72995_K && var4 && !var3.func_76224_d()) {
                  p_180616_1_.func_175655_b(p_180616_2_, true);
               }

               p_180616_1_.func_180501_a(p_180616_2_, this.field_77876_a.func_176223_P(), 3);
            }

            return true;
         }
      }
   }
}
