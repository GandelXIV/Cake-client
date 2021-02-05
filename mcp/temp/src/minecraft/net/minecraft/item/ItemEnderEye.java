package net.minecraft.item;

import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemEnderEye extends Item {

   private static final String __OBFID = "CL_00000026";


   public ItemEnderEye() {
      this.func_77637_a(CreativeTabs.field_78026_f);
   }

   public boolean func_180614_a(ItemStack p_180614_1_, EntityPlayer p_180614_2_, World p_180614_3_, BlockPos p_180614_4_, EnumFacing p_180614_5_, float p_180614_6_, float p_180614_7_, float p_180614_8_) {
      IBlockState var9 = p_180614_3_.func_180495_p(p_180614_4_);
      if(p_180614_2_.func_175151_a(p_180614_4_.func_177972_a(p_180614_5_), p_180614_5_, p_180614_1_) && var9.func_177230_c() == Blocks.field_150378_br && !((Boolean)var9.func_177229_b(BlockEndPortalFrame.field_176507_b)).booleanValue()) {
         if(p_180614_3_.field_72995_K) {
            return true;
         } else {
            p_180614_3_.func_180501_a(p_180614_4_, var9.func_177226_a(BlockEndPortalFrame.field_176507_b, Boolean.valueOf(true)), 2);
            p_180614_3_.func_175666_e(p_180614_4_, Blocks.field_150378_br);
            --p_180614_1_.field_77994_a;

            for(int var10 = 0; var10 < 16; ++var10) {
               double var11 = (double)((float)p_180614_4_.func_177958_n() + (5.0F + field_77697_d.nextFloat() * 6.0F) / 16.0F);
               double var13 = (double)((float)p_180614_4_.func_177956_o() + 0.8125F);
               double var15 = (double)((float)p_180614_4_.func_177952_p() + (5.0F + field_77697_d.nextFloat() * 6.0F) / 16.0F);
               double var17 = 0.0D;
               double var19 = 0.0D;
               double var21 = 0.0D;
               p_180614_3_.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, var11, var13, var15, var17, var19, var21, new int[0]);
            }

            EnumFacing var23 = (EnumFacing)var9.func_177229_b(BlockEndPortalFrame.field_176508_a);
            int var24 = 0;
            int var12 = 0;
            boolean var25 = false;
            boolean var14 = true;
            EnumFacing var26 = var23.func_176746_e();

            for(int var16 = -2; var16 <= 2; ++var16) {
               BlockPos var28 = p_180614_4_.func_177967_a(var26, var16);
               IBlockState var18 = p_180614_3_.func_180495_p(var28);
               if(var18.func_177230_c() == Blocks.field_150378_br) {
                  if(!((Boolean)var18.func_177229_b(BlockEndPortalFrame.field_176507_b)).booleanValue()) {
                     var14 = false;
                     break;
                  }

                  var12 = var16;
                  if(!var25) {
                     var24 = var16;
                     var25 = true;
                  }
               }
            }

            if(var14 && var12 == var24 + 2) {
               BlockPos var27 = p_180614_4_.func_177967_a(var23, 4);

               int var29;
               for(var29 = var24; var29 <= var12; ++var29) {
                  BlockPos var30 = var27.func_177967_a(var26, var29);
                  IBlockState var32 = p_180614_3_.func_180495_p(var30);
                  if(var32.func_177230_c() != Blocks.field_150378_br || !((Boolean)var32.func_177229_b(BlockEndPortalFrame.field_176507_b)).booleanValue()) {
                     var14 = false;
                     break;
                  }
               }

               int var31;
               BlockPos var33;
               for(var29 = var24 - 1; var29 <= var12 + 1; var29 += 4) {
                  var27 = p_180614_4_.func_177967_a(var26, var29);

                  for(var31 = 1; var31 <= 3; ++var31) {
                     var33 = var27.func_177967_a(var23, var31);
                     IBlockState var20 = p_180614_3_.func_180495_p(var33);
                     if(var20.func_177230_c() != Blocks.field_150378_br || !((Boolean)var20.func_177229_b(BlockEndPortalFrame.field_176507_b)).booleanValue()) {
                        var14 = false;
                        break;
                     }
                  }
               }

               if(var14) {
                  for(var29 = var24; var29 <= var12; ++var29) {
                     var27 = p_180614_4_.func_177967_a(var26, var29);

                     for(var31 = 1; var31 <= 3; ++var31) {
                        var33 = var27.func_177967_a(var23, var31);
                        p_180614_3_.func_180501_a(var33, Blocks.field_150384_bq.func_176223_P(), 2);
                     }
                  }
               }
            }

            return true;
         }
      } else {
         return false;
      }
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      MovingObjectPosition var4 = this.func_77621_a(p_77659_2_, p_77659_3_, false);
      if(var4 != null && var4.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK && p_77659_2_.func_180495_p(var4.func_178782_a()).func_177230_c() == Blocks.field_150378_br) {
         return p_77659_1_;
      } else {
         if(!p_77659_2_.field_72995_K) {
            BlockPos var5 = p_77659_2_.func_180499_a("Stronghold", new BlockPos(p_77659_3_));
            if(var5 != null) {
               EntityEnderEye var6 = new EntityEnderEye(p_77659_2_, p_77659_3_.field_70165_t, p_77659_3_.field_70163_u, p_77659_3_.field_70161_v);
               var6.func_180465_a(var5);
               p_77659_2_.func_72838_d(var6);
               p_77659_2_.func_72956_a(p_77659_3_, "random.bow", 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
               p_77659_2_.func_180498_a((EntityPlayer)null, 1002, new BlockPos(p_77659_3_), 0);
               if(!p_77659_3_.field_71075_bZ.field_75098_d) {
                  --p_77659_1_.field_77994_a;
               }

               p_77659_3_.func_71029_a(StatList.field_75929_E[Item.func_150891_b(this)]);
            }
         }

         return p_77659_1_;
      }
   }
}
