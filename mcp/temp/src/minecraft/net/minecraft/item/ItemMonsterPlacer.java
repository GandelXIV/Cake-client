package net.minecraft.item;

import java.util.Iterator;
import java.util.List;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemMonsterPlacer extends Item {

   private static final String __OBFID = "CL_00000070";


   public ItemMonsterPlacer() {
      this.func_77627_a(true);
      this.func_77637_a(CreativeTabs.field_78026_f);
   }

   public String func_77653_i(ItemStack p_77653_1_) {
      String var2 = ("" + StatCollector.func_74838_a(this.func_77658_a() + ".name")).trim();
      String var3 = EntityList.func_75617_a(p_77653_1_.func_77960_j());
      if(var3 != null) {
         var2 = var2 + " " + StatCollector.func_74838_a("entity." + var3 + ".name");
      }

      return var2;
   }

   public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_) {
      EntityList.EntityEggInfo var3 = (EntityList.EntityEggInfo)EntityList.field_75627_a.get(Integer.valueOf(p_82790_1_.func_77960_j()));
      return var3 != null?(p_82790_2_ == 0?var3.field_75611_b:var3.field_75612_c):16777215;
   }

   public boolean func_180614_a(ItemStack p_180614_1_, EntityPlayer p_180614_2_, World p_180614_3_, BlockPos p_180614_4_, EnumFacing p_180614_5_, float p_180614_6_, float p_180614_7_, float p_180614_8_) {
      if(p_180614_3_.field_72995_K) {
         return true;
      } else if(!p_180614_2_.func_175151_a(p_180614_4_.func_177972_a(p_180614_5_), p_180614_5_, p_180614_1_)) {
         return false;
      } else {
         IBlockState var9 = p_180614_3_.func_180495_p(p_180614_4_);
         if(var9.func_177230_c() == Blocks.field_150474_ac) {
            TileEntity var10 = p_180614_3_.func_175625_s(p_180614_4_);
            if(var10 instanceof TileEntityMobSpawner) {
               MobSpawnerBaseLogic var11 = ((TileEntityMobSpawner)var10).func_145881_a();
               var11.func_98272_a(EntityList.func_75617_a(p_180614_1_.func_77960_j()));
               var10.func_70296_d();
               p_180614_3_.func_175689_h(p_180614_4_);
               if(!p_180614_2_.field_71075_bZ.field_75098_d) {
                  --p_180614_1_.field_77994_a;
               }

               return true;
            }
         }

         p_180614_4_ = p_180614_4_.func_177972_a(p_180614_5_);
         double var13 = 0.0D;
         if(p_180614_5_ == EnumFacing.UP && var9 instanceof BlockFence) {
            var13 = 0.5D;
         }

         Entity var12 = func_77840_a(p_180614_3_, p_180614_1_.func_77960_j(), (double)p_180614_4_.func_177958_n() + 0.5D, (double)p_180614_4_.func_177956_o() + var13, (double)p_180614_4_.func_177952_p() + 0.5D);
         if(var12 != null) {
            if(var12 instanceof EntityLivingBase && p_180614_1_.func_82837_s()) {
               var12.func_96094_a(p_180614_1_.func_82833_r());
            }

            if(!p_180614_2_.field_71075_bZ.field_75098_d) {
               --p_180614_1_.field_77994_a;
            }
         }

         return true;
      }
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      if(p_77659_2_.field_72995_K) {
         return p_77659_1_;
      } else {
         MovingObjectPosition var4 = this.func_77621_a(p_77659_2_, p_77659_3_, true);
         if(var4 == null) {
            return p_77659_1_;
         } else {
            if(var4.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
               BlockPos var5 = var4.func_178782_a();
               if(!p_77659_2_.func_175660_a(p_77659_3_, var5)) {
                  return p_77659_1_;
               }

               if(!p_77659_3_.func_175151_a(var5, var4.field_178784_b, p_77659_1_)) {
                  return p_77659_1_;
               }

               if(p_77659_2_.func_180495_p(var5).func_177230_c() instanceof BlockLiquid) {
                  Entity var6 = func_77840_a(p_77659_2_, p_77659_1_.func_77960_j(), (double)var5.func_177958_n() + 0.5D, (double)var5.func_177956_o() + 0.5D, (double)var5.func_177952_p() + 0.5D);
                  if(var6 != null) {
                     if(var6 instanceof EntityLivingBase && p_77659_1_.func_82837_s()) {
                        ((EntityLiving)var6).func_96094_a(p_77659_1_.func_82833_r());
                     }

                     if(!p_77659_3_.field_71075_bZ.field_75098_d) {
                        --p_77659_1_.field_77994_a;
                     }

                     p_77659_3_.func_71029_a(StatList.field_75929_E[Item.func_150891_b(this)]);
                  }
               }
            }

            return p_77659_1_;
         }
      }
   }

   public static Entity func_77840_a(World p_77840_0_, int p_77840_1_, double p_77840_2_, double p_77840_4_, double p_77840_6_) {
      if(!EntityList.field_75627_a.containsKey(Integer.valueOf(p_77840_1_))) {
         return null;
      } else {
         Entity var8 = null;

         for(int var9 = 0; var9 < 1; ++var9) {
            var8 = EntityList.func_75616_a(p_77840_1_, p_77840_0_);
            if(var8 instanceof EntityLivingBase) {
               EntityLiving var10 = (EntityLiving)var8;
               var8.func_70012_b(p_77840_2_, p_77840_4_, p_77840_6_, MathHelper.func_76142_g(p_77840_0_.field_73012_v.nextFloat() * 360.0F), 0.0F);
               var10.field_70759_as = var10.field_70177_z;
               var10.field_70761_aq = var10.field_70177_z;
               var10.func_180482_a(p_77840_0_.func_175649_E(new BlockPos(var10)), (IEntityLivingData)null);
               p_77840_0_.func_72838_d(var8);
               var10.func_70642_aH();
            }
         }

         return var8;
      }
   }

   public void func_150895_a(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_) {
      Iterator var4 = EntityList.field_75627_a.values().iterator();

      while(var4.hasNext()) {
         EntityList.EntityEggInfo var5 = (EntityList.EntityEggInfo)var4.next();
         p_150895_3_.add(new ItemStack(p_150895_1_, 1, var5.field_75613_a));
      }

   }
}
