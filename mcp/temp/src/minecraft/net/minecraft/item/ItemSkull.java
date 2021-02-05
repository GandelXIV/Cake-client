package net.minecraft.item;

import com.mojang.authlib.GameProfile;
import java.util.List;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemSkull extends Item {

   private static final String[] field_82807_a = new String[]{"skeleton", "wither", "zombie", "char", "creeper"};
   private static final String __OBFID = "CL_00000067";


   public ItemSkull() {
      this.func_77637_a(CreativeTabs.field_78031_c);
      this.func_77656_e(0);
      this.func_77627_a(true);
   }

   public boolean func_180614_a(ItemStack p_180614_1_, EntityPlayer p_180614_2_, World p_180614_3_, BlockPos p_180614_4_, EnumFacing p_180614_5_, float p_180614_6_, float p_180614_7_, float p_180614_8_) {
      if(p_180614_5_ == EnumFacing.DOWN) {
         return false;
      } else {
         IBlockState var9 = p_180614_3_.func_180495_p(p_180614_4_);
         Block var10 = var9.func_177230_c();
         boolean var11 = var10.func_176200_f(p_180614_3_, p_180614_4_);
         if(!var11) {
            if(!p_180614_3_.func_180495_p(p_180614_4_).func_177230_c().func_149688_o().func_76220_a()) {
               return false;
            }

            p_180614_4_ = p_180614_4_.func_177972_a(p_180614_5_);
         }

         if(!p_180614_2_.func_175151_a(p_180614_4_, p_180614_5_, p_180614_1_)) {
            return false;
         } else if(!Blocks.field_150465_bP.func_176196_c(p_180614_3_, p_180614_4_)) {
            return false;
         } else {
            if(!p_180614_3_.field_72995_K) {
               p_180614_3_.func_180501_a(p_180614_4_, Blocks.field_150465_bP.func_176223_P().func_177226_a(BlockSkull.field_176418_a, p_180614_5_), 3);
               int var12 = 0;
               if(p_180614_5_ == EnumFacing.UP) {
                  var12 = MathHelper.func_76128_c((double)(p_180614_2_.field_70177_z * 16.0F / 360.0F) + 0.5D) & 15;
               }

               TileEntity var13 = p_180614_3_.func_175625_s(p_180614_4_);
               if(var13 instanceof TileEntitySkull) {
                  TileEntitySkull var14 = (TileEntitySkull)var13;
                  if(p_180614_1_.func_77960_j() == 3) {
                     GameProfile var15 = null;
                     if(p_180614_1_.func_77942_o()) {
                        NBTTagCompound var16 = p_180614_1_.func_77978_p();
                        if(var16.func_150297_b("SkullOwner", 10)) {
                           var15 = NBTUtil.func_152459_a(var16.func_74775_l("SkullOwner"));
                        } else if(var16.func_150297_b("SkullOwner", 8) && var16.func_74779_i("SkullOwner").length() > 0) {
                           var15 = new GameProfile((UUID)null, var16.func_74779_i("SkullOwner"));
                        }
                     }

                     var14.func_152106_a(var15);
                  } else {
                     var14.func_152107_a(p_180614_1_.func_77960_j());
                  }

                  var14.func_145903_a(var12);
                  Blocks.field_150465_bP.func_180679_a(p_180614_3_, p_180614_4_, var14);
               }

               --p_180614_1_.field_77994_a;
            }

            return true;
         }
      }
   }

   public void func_150895_a(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_) {
      for(int var4 = 0; var4 < field_82807_a.length; ++var4) {
         p_150895_3_.add(new ItemStack(p_150895_1_, 1, var4));
      }

   }

   public int func_77647_b(int p_77647_1_) {
      return p_77647_1_;
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      int var2 = p_77667_1_.func_77960_j();
      if(var2 < 0 || var2 >= field_82807_a.length) {
         var2 = 0;
      }

      return super.func_77658_a() + "." + field_82807_a[var2];
   }

   public String func_77653_i(ItemStack p_77653_1_) {
      if(p_77653_1_.func_77960_j() == 3 && p_77653_1_.func_77942_o()) {
         if(p_77653_1_.func_77978_p().func_150297_b("SkullOwner", 8)) {
            return StatCollector.func_74837_a("item.skull.player.name", new Object[]{p_77653_1_.func_77978_p().func_74779_i("SkullOwner")});
         }

         if(p_77653_1_.func_77978_p().func_150297_b("SkullOwner", 10)) {
            NBTTagCompound var2 = p_77653_1_.func_77978_p().func_74775_l("SkullOwner");
            if(var2.func_150297_b("Name", 8)) {
               return StatCollector.func_74837_a("item.skull.player.name", new Object[]{var2.func_74779_i("Name")});
            }
         }
      }

      return super.func_77653_i(p_77653_1_);
   }

   public boolean func_179215_a(NBTTagCompound p_179215_1_) {
      super.func_179215_a(p_179215_1_);
      if(p_179215_1_.func_150297_b("SkullOwner", 8) && p_179215_1_.func_74779_i("SkullOwner").length() > 0) {
         GameProfile var2 = new GameProfile((UUID)null, p_179215_1_.func_74779_i("SkullOwner"));
         var2 = TileEntitySkull.func_174884_b(var2);
         p_179215_1_.func_74782_a("SkullOwner", NBTUtil.func_180708_a(new NBTTagCompound(), var2));
         return true;
      } else {
         return false;
      }
   }

}
