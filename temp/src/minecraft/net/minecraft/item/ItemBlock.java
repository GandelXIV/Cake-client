package net.minecraft.item;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemBlock extends Item {

   protected final Block field_150939_a;
   private static final String __OBFID = "CL_00001772";


   public ItemBlock(Block p_i45328_1_) {
      this.field_150939_a = p_i45328_1_;
   }

   public ItemBlock func_77655_b(String p_77655_1_) {
      super.func_77655_b(p_77655_1_);
      return this;
   }

   public boolean func_180614_a(ItemStack p_180614_1_, EntityPlayer p_180614_2_, World p_180614_3_, BlockPos p_180614_4_, EnumFacing p_180614_5_, float p_180614_6_, float p_180614_7_, float p_180614_8_) {
      IBlockState var9 = p_180614_3_.func_180495_p(p_180614_4_);
      Block var10 = var9.func_177230_c();
      if(var10 == Blocks.field_150431_aC && ((Integer)var9.func_177229_b(BlockSnow.field_176315_a)).intValue() < 1) {
         p_180614_5_ = EnumFacing.UP;
      } else if(!var10.func_176200_f(p_180614_3_, p_180614_4_)) {
         p_180614_4_ = p_180614_4_.func_177972_a(p_180614_5_);
      }

      if(p_180614_1_.field_77994_a == 0) {
         return false;
      } else if(!p_180614_2_.func_175151_a(p_180614_4_, p_180614_5_, p_180614_1_)) {
         return false;
      } else if(p_180614_4_.func_177956_o() == 255 && this.field_150939_a.func_149688_o().func_76220_a()) {
         return false;
      } else if(p_180614_3_.func_175716_a(this.field_150939_a, p_180614_4_, false, p_180614_5_, (Entity)null, p_180614_1_)) {
         int var11 = this.func_77647_b(p_180614_1_.func_77960_j());
         IBlockState var12 = this.field_150939_a.func_180642_a(p_180614_3_, p_180614_4_, p_180614_5_, p_180614_6_, p_180614_7_, p_180614_8_, var11, p_180614_2_);
         if(p_180614_3_.func_180501_a(p_180614_4_, var12, 3)) {
            var12 = p_180614_3_.func_180495_p(p_180614_4_);
            if(var12.func_177230_c() == this.field_150939_a) {
               func_179224_a(p_180614_3_, p_180614_4_, p_180614_1_);
               this.field_150939_a.func_180633_a(p_180614_3_, p_180614_4_, var12, p_180614_2_, p_180614_1_);
            }

            p_180614_3_.func_72908_a((double)((float)p_180614_4_.func_177958_n() + 0.5F), (double)((float)p_180614_4_.func_177956_o() + 0.5F), (double)((float)p_180614_4_.func_177952_p() + 0.5F), this.field_150939_a.field_149762_H.func_150496_b(), (this.field_150939_a.field_149762_H.func_150497_c() + 1.0F) / 2.0F, this.field_150939_a.field_149762_H.func_150494_d() * 0.8F);
            --p_180614_1_.field_77994_a;
         }

         return true;
      } else {
         return false;
      }
   }

   public static boolean func_179224_a(World p_179224_0_, BlockPos p_179224_1_, ItemStack p_179224_2_) {
      if(p_179224_2_.func_77942_o() && p_179224_2_.func_77978_p().func_150297_b("BlockEntityTag", 10)) {
         TileEntity var3 = p_179224_0_.func_175625_s(p_179224_1_);
         if(var3 != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            NBTTagCompound var5 = (NBTTagCompound)var4.func_74737_b();
            var3.func_145841_b(var4);
            NBTTagCompound var6 = (NBTTagCompound)p_179224_2_.func_77978_p().func_74781_a("BlockEntityTag");
            var4.func_179237_a(var6);
            var4.func_74768_a("x", p_179224_1_.func_177958_n());
            var4.func_74768_a("y", p_179224_1_.func_177956_o());
            var4.func_74768_a("z", p_179224_1_.func_177952_p());
            if(!var4.equals(var5)) {
               var3.func_145839_a(var4);
               var3.func_70296_d();
               return true;
            }
         }
      }

      return false;
   }

   public boolean func_179222_a(World p_179222_1_, BlockPos p_179222_2_, EnumFacing p_179222_3_, EntityPlayer p_179222_4_, ItemStack p_179222_5_) {
      Block var6 = p_179222_1_.func_180495_p(p_179222_2_).func_177230_c();
      if(var6 == Blocks.field_150431_aC) {
         p_179222_3_ = EnumFacing.UP;
      } else if(!var6.func_176200_f(p_179222_1_, p_179222_2_)) {
         p_179222_2_ = p_179222_2_.func_177972_a(p_179222_3_);
      }

      return p_179222_1_.func_175716_a(this.field_150939_a, p_179222_2_, false, p_179222_3_, (Entity)null, p_179222_5_);
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      return this.field_150939_a.func_149739_a();
   }

   public String func_77658_a() {
      return this.field_150939_a.func_149739_a();
   }

   public CreativeTabs func_77640_w() {
      return this.field_150939_a.func_149708_J();
   }

   public void func_150895_a(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_) {
      this.field_150939_a.func_149666_a(p_150895_1_, p_150895_2_, p_150895_3_);
   }

   public Block func_179223_d() {
      return this.field_150939_a;
   }

   // $FF: synthetic method
   public Item func_77655_b(String p_77655_1_) {
      return this.func_77655_b(p_77655_1_);
   }
}
