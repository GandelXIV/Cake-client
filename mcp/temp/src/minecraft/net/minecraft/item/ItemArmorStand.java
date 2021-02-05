package net.minecraft.item;

import java.util.List;
import java.util.Random;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Rotations;
import net.minecraft.world.World;

public class ItemArmorStand extends Item {

   private static final String __OBFID = "CL_00002182";


   public ItemArmorStand() {
      this.func_77637_a(CreativeTabs.field_78031_c);
   }

   public boolean func_180614_a(ItemStack p_180614_1_, EntityPlayer p_180614_2_, World p_180614_3_, BlockPos p_180614_4_, EnumFacing p_180614_5_, float p_180614_6_, float p_180614_7_, float p_180614_8_) {
      if(p_180614_5_ == EnumFacing.DOWN) {
         return false;
      } else {
         boolean var9 = p_180614_3_.func_180495_p(p_180614_4_).func_177230_c().func_176200_f(p_180614_3_, p_180614_4_);
         BlockPos var10 = var9?p_180614_4_:p_180614_4_.func_177972_a(p_180614_5_);
         if(!p_180614_2_.func_175151_a(var10, p_180614_5_, p_180614_1_)) {
            return false;
         } else {
            BlockPos var11 = var10.func_177984_a();
            boolean var12 = !p_180614_3_.func_175623_d(var10) && !p_180614_3_.func_180495_p(var10).func_177230_c().func_176200_f(p_180614_3_, var10);
            var12 |= !p_180614_3_.func_175623_d(var11) && !p_180614_3_.func_180495_p(var11).func_177230_c().func_176200_f(p_180614_3_, var11);
            if(var12) {
               return false;
            } else {
               double var13 = (double)var10.func_177958_n();
               double var15 = (double)var10.func_177956_o();
               double var17 = (double)var10.func_177952_p();
               List var19 = p_180614_3_.func_72839_b((Entity)null, AxisAlignedBB.func_178781_a(var13, var15, var17, var13 + 1.0D, var15 + 2.0D, var17 + 1.0D));
               if(var19.size() > 0) {
                  return false;
               } else {
                  if(!p_180614_3_.field_72995_K) {
                     p_180614_3_.func_175698_g(var10);
                     p_180614_3_.func_175698_g(var11);
                     EntityArmorStand var20 = new EntityArmorStand(p_180614_3_, var13 + 0.5D, var15, var17 + 0.5D);
                     float var21 = (float)MathHelper.func_76141_d((MathHelper.func_76142_g(p_180614_2_.field_70177_z - 180.0F) + 22.5F) / 45.0F) * 45.0F;
                     var20.func_70012_b(var13 + 0.5D, var15, var17 + 0.5D, var21, 0.0F);
                     this.func_179221_a(var20, p_180614_3_.field_73012_v);
                     NBTTagCompound var22 = p_180614_1_.func_77978_p();
                     if(var22 != null && var22.func_150297_b("EntityTag", 10)) {
                        NBTTagCompound var23 = new NBTTagCompound();
                        var20.func_70039_c(var23);
                        var23.func_179237_a(var22.func_74775_l("EntityTag"));
                        var20.func_70020_e(var23);
                     }

                     p_180614_3_.func_72838_d(var20);
                  }

                  --p_180614_1_.field_77994_a;
                  return true;
               }
            }
         }
      }
   }

   private void func_179221_a(EntityArmorStand p_179221_1_, Random p_179221_2_) {
      Rotations var3 = p_179221_1_.func_175418_s();
      float var5 = p_179221_2_.nextFloat() * 5.0F;
      float var6 = p_179221_2_.nextFloat() * 20.0F - 10.0F;
      Rotations var4 = new Rotations(var3.func_179415_b() + var5, var3.func_179416_c() + var6, var3.func_179413_d());
      p_179221_1_.func_175415_a(var4);
      var3 = p_179221_1_.func_175408_t();
      var5 = p_179221_2_.nextFloat() * 10.0F - 5.0F;
      var4 = new Rotations(var3.func_179415_b(), var3.func_179416_c() + var5, var3.func_179413_d());
      p_179221_1_.func_175424_b(var4);
   }
}
