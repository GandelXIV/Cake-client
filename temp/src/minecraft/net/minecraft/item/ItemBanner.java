package net.minecraft.item;

import java.util.List;
import net.minecraft.block.BlockStandingSign;
import net.minecraft.block.BlockWallSign;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemBanner extends ItemBlock {

   private static final String __OBFID = "CL_00002181";


   public ItemBanner() {
      super(Blocks.field_180393_cK);
      this.field_77777_bU = 16;
      this.func_77637_a(CreativeTabs.field_78031_c);
      this.func_77627_a(true);
      this.func_77656_e(0);
   }

   public boolean func_180614_a(ItemStack p_180614_1_, EntityPlayer p_180614_2_, World p_180614_3_, BlockPos p_180614_4_, EnumFacing p_180614_5_, float p_180614_6_, float p_180614_7_, float p_180614_8_) {
      if(p_180614_5_ == EnumFacing.DOWN) {
         return false;
      } else if(!p_180614_3_.func_180495_p(p_180614_4_).func_177230_c().func_149688_o().func_76220_a()) {
         return false;
      } else {
         p_180614_4_ = p_180614_4_.func_177972_a(p_180614_5_);
         if(!p_180614_2_.func_175151_a(p_180614_4_, p_180614_5_, p_180614_1_)) {
            return false;
         } else if(!Blocks.field_180393_cK.func_176196_c(p_180614_3_, p_180614_4_)) {
            return false;
         } else if(p_180614_3_.field_72995_K) {
            return true;
         } else {
            if(p_180614_5_ == EnumFacing.UP) {
               int var9 = MathHelper.func_76128_c((double)((p_180614_2_.field_70177_z + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
               p_180614_3_.func_180501_a(p_180614_4_, Blocks.field_180393_cK.func_176223_P().func_177226_a(BlockStandingSign.field_176413_a, Integer.valueOf(var9)), 3);
            } else {
               p_180614_3_.func_180501_a(p_180614_4_, Blocks.field_180394_cL.func_176223_P().func_177226_a(BlockWallSign.field_176412_a, p_180614_5_), 3);
            }

            --p_180614_1_.field_77994_a;
            TileEntity var10 = p_180614_3_.func_175625_s(p_180614_4_);
            if(var10 instanceof TileEntityBanner) {
               ((TileEntityBanner)var10).func_175112_a(p_180614_1_);
            }

            return true;
         }
      }
   }

   public String func_77653_i(ItemStack p_77653_1_) {
      String var2 = "item.banner.";
      EnumDyeColor var3 = this.func_179225_h(p_77653_1_);
      var2 = var2 + var3.func_176762_d() + ".name";
      return StatCollector.func_74838_a(var2);
   }

   public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
      NBTTagCompound var5 = p_77624_1_.func_179543_a("BlockEntityTag", false);
      if(var5 != null && var5.func_74764_b("Patterns")) {
         NBTTagList var6 = var5.func_150295_c("Patterns", 10);

         for(int var7 = 0; var7 < var6.func_74745_c() && var7 < 6; ++var7) {
            NBTTagCompound var8 = var6.func_150305_b(var7);
            EnumDyeColor var9 = EnumDyeColor.func_176766_a(var8.func_74762_e("Color"));
            TileEntityBanner.EnumBannerPattern var10 = TileEntityBanner.EnumBannerPattern.func_177268_a(var8.func_74779_i("Pattern"));
            if(var10 != null) {
               p_77624_3_.add(StatCollector.func_74838_a("item.banner." + var10.func_177271_a() + "." + var9.func_176762_d()));
            }
         }

      }
   }

   public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_) {
      if(p_82790_2_ == 0) {
         return 16777215;
      } else {
         EnumDyeColor var3 = this.func_179225_h(p_82790_1_);
         return var3.func_176768_e().field_76291_p;
      }
   }

   public void func_150895_a(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_) {
      EnumDyeColor[] var4 = EnumDyeColor.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         EnumDyeColor var7 = var4[var6];
         p_150895_3_.add(new ItemStack(p_150895_1_, 1, var7.func_176767_b()));
      }

   }

   public CreativeTabs func_77640_w() {
      return CreativeTabs.field_78031_c;
   }

   private EnumDyeColor func_179225_h(ItemStack p_179225_1_) {
      NBTTagCompound var2 = p_179225_1_.func_179543_a("BlockEntityTag", false);
      EnumDyeColor var3 = null;
      if(var2 != null && var2.func_74764_b("Base")) {
         var3 = EnumDyeColor.func_176766_a(var2.func_74762_e("Base"));
      } else {
         var3 = EnumDyeColor.func_176766_a(p_179225_1_.func_77960_j());
      }

      return var3;
   }
}
