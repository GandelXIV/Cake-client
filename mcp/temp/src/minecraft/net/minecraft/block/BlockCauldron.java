package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBanner;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockCauldron extends Block {

   public static final PropertyInteger field_176591_a = PropertyInteger.func_177719_a("level", 0, 3);
   private static final String __OBFID = "CL_00000213";


   public BlockCauldron() {
      super(Material.field_151573_f);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176591_a, Integer.valueOf(0)));
   }

   public void func_180638_a(World p_180638_1_, BlockPos p_180638_2_, IBlockState p_180638_3_, AxisAlignedBB p_180638_4_, List p_180638_5_, Entity p_180638_6_) {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
      super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
      float var7 = 0.125F;
      this.func_149676_a(0.0F, 0.0F, 0.0F, var7, 1.0F, 1.0F);
      super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var7);
      super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
      this.func_149676_a(1.0F - var7, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
      this.func_149676_a(0.0F, 0.0F, 1.0F - var7, 1.0F, 1.0F, 1.0F);
      super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
      this.func_149683_g();
   }

   public void func_149683_g() {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public void func_180634_a(World p_180634_1_, BlockPos p_180634_2_, IBlockState p_180634_3_, Entity p_180634_4_) {
      int var5 = ((Integer)p_180634_3_.func_177229_b(field_176591_a)).intValue();
      float var6 = (float)p_180634_2_.func_177956_o() + (6.0F + (float)(3 * var5)) / 16.0F;
      if(!p_180634_1_.field_72995_K && p_180634_4_.func_70027_ad() && var5 > 0 && p_180634_4_.func_174813_aQ().field_72338_b <= (double)var6) {
         p_180634_4_.func_70066_B();
         this.func_176590_a(p_180634_1_, p_180634_2_, p_180634_3_, var5 - 1);
      }

   }

   public boolean func_180639_a(World p_180639_1_, BlockPos p_180639_2_, IBlockState p_180639_3_, EntityPlayer p_180639_4_, EnumFacing p_180639_5_, float p_180639_6_, float p_180639_7_, float p_180639_8_) {
      if(p_180639_1_.field_72995_K) {
         return true;
      } else {
         ItemStack var9 = p_180639_4_.field_71071_by.func_70448_g();
         if(var9 == null) {
            return true;
         } else {
            int var10 = ((Integer)p_180639_3_.func_177229_b(field_176591_a)).intValue();
            Item var11 = var9.func_77973_b();
            if(var11 == Items.field_151131_as) {
               if(var10 < 3) {
                  if(!p_180639_4_.field_71075_bZ.field_75098_d) {
                     p_180639_4_.field_71071_by.func_70299_a(p_180639_4_.field_71071_by.field_70461_c, new ItemStack(Items.field_151133_ar));
                  }

                  this.func_176590_a(p_180639_1_, p_180639_2_, p_180639_3_, 3);
               }

               return true;
            } else {
               ItemStack var13;
               if(var11 == Items.field_151069_bo) {
                  if(var10 > 0) {
                     if(!p_180639_4_.field_71075_bZ.field_75098_d) {
                        var13 = new ItemStack(Items.field_151068_bn, 1, 0);
                        if(!p_180639_4_.field_71071_by.func_70441_a(var13)) {
                           p_180639_1_.func_72838_d(new EntityItem(p_180639_1_, (double)p_180639_2_.func_177958_n() + 0.5D, (double)p_180639_2_.func_177956_o() + 1.5D, (double)p_180639_2_.func_177952_p() + 0.5D, var13));
                        } else if(p_180639_4_ instanceof EntityPlayerMP) {
                           ((EntityPlayerMP)p_180639_4_).func_71120_a(p_180639_4_.field_71069_bz);
                        }

                        --var9.field_77994_a;
                        if(var9.field_77994_a <= 0) {
                           p_180639_4_.field_71071_by.func_70299_a(p_180639_4_.field_71071_by.field_70461_c, (ItemStack)null);
                        }
                     }

                     this.func_176590_a(p_180639_1_, p_180639_2_, p_180639_3_, var10 - 1);
                  }

                  return true;
               } else {
                  if(var10 > 0 && var11 instanceof ItemArmor) {
                     ItemArmor var12 = (ItemArmor)var11;
                     if(var12.func_82812_d() == ItemArmor.ArmorMaterial.LEATHER && var12.func_82816_b_(var9)) {
                        var12.func_82815_c(var9);
                        this.func_176590_a(p_180639_1_, p_180639_2_, p_180639_3_, var10 - 1);
                        return true;
                     }
                  }

                  if(var10 > 0 && var11 instanceof ItemBanner && TileEntityBanner.func_175113_c(var9) > 0) {
                     var13 = var9.func_77946_l();
                     var13.field_77994_a = 1;
                     TileEntityBanner.func_175117_e(var13);
                     if(var9.field_77994_a <= 1 && !p_180639_4_.field_71075_bZ.field_75098_d) {
                        p_180639_4_.field_71071_by.func_70299_a(p_180639_4_.field_71071_by.field_70461_c, var13);
                     } else {
                        if(!p_180639_4_.field_71071_by.func_70441_a(var13)) {
                           p_180639_1_.func_72838_d(new EntityItem(p_180639_1_, (double)p_180639_2_.func_177958_n() + 0.5D, (double)p_180639_2_.func_177956_o() + 1.5D, (double)p_180639_2_.func_177952_p() + 0.5D, var13));
                        } else if(p_180639_4_ instanceof EntityPlayerMP) {
                           ((EntityPlayerMP)p_180639_4_).func_71120_a(p_180639_4_.field_71069_bz);
                        }

                        if(!p_180639_4_.field_71075_bZ.field_75098_d) {
                           --var9.field_77994_a;
                        }
                     }

                     if(!p_180639_4_.field_71075_bZ.field_75098_d) {
                        this.func_176590_a(p_180639_1_, p_180639_2_, p_180639_3_, var10 - 1);
                     }

                     return true;
                  } else {
                     return false;
                  }
               }
            }
         }
      }
   }

   public void func_176590_a(World p_176590_1_, BlockPos p_176590_2_, IBlockState p_176590_3_, int p_176590_4_) {
      p_176590_1_.func_180501_a(p_176590_2_, p_176590_3_.func_177226_a(field_176591_a, Integer.valueOf(MathHelper.func_76125_a(p_176590_4_, 0, 3))), 2);
      p_176590_1_.func_175666_e(p_176590_2_, this);
   }

   public void func_176224_k(World p_176224_1_, BlockPos p_176224_2_) {
      if(p_176224_1_.field_73012_v.nextInt(20) == 1) {
         IBlockState var3 = p_176224_1_.func_180495_p(p_176224_2_);
         if(((Integer)var3.func_177229_b(field_176591_a)).intValue() < 3) {
            p_176224_1_.func_180501_a(p_176224_2_, var3.func_177231_a(field_176591_a), 2);
         }

      }
   }

   public Item func_180660_a(IBlockState p_180660_1_, Random p_180660_2_, int p_180660_3_) {
      return Items.field_151066_bu;
   }

   public Item func_180665_b(World p_180665_1_, BlockPos p_180665_2_) {
      return Items.field_151066_bu;
   }

   public boolean func_149740_M() {
      return true;
   }

   public int func_180641_l(World p_180641_1_, BlockPos p_180641_2_) {
      return ((Integer)p_180641_1_.func_180495_p(p_180641_2_).func_177229_b(field_176591_a)).intValue();
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176591_a, Integer.valueOf(p_176203_1_));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((Integer)p_176201_1_.func_177229_b(field_176591_a)).intValue();
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176591_a});
   }

}
