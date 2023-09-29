package net.minecraft.block;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;

public class BlockChest extends BlockContainer {

   public static final PropertyDirection field_176459_a = PropertyDirection.func_177712_a("facing", EnumFacing.Plane.HORIZONTAL);
   private final Random field_149955_b = new Random();
   public final int field_149956_a;
   private static final String __OBFID = "CL_00000214";


   protected BlockChest(int p_i45397_1_) {
      super(Material.field_151575_d);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176459_a, EnumFacing.NORTH));
      this.field_149956_a = p_i45397_1_;
      this.func_149647_a(CreativeTabs.field_78031_c);
      this.func_149676_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public int func_149645_b() {
      return 2;
   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      if(p_180654_1_.func_180495_p(p_180654_2_.func_177978_c()).func_177230_c() == this) {
         this.func_149676_a(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
      } else if(p_180654_1_.func_180495_p(p_180654_2_.func_177968_d()).func_177230_c() == this) {
         this.func_149676_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
      } else if(p_180654_1_.func_180495_p(p_180654_2_.func_177976_e()).func_177230_c() == this) {
         this.func_149676_a(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
      } else if(p_180654_1_.func_180495_p(p_180654_2_.func_177974_f()).func_177230_c() == this) {
         this.func_149676_a(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
      } else {
         this.func_149676_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
      }

   }

   public void func_176213_c(World p_176213_1_, BlockPos p_176213_2_, IBlockState p_176213_3_) {
      this.func_176455_e(p_176213_1_, p_176213_2_, p_176213_3_);
      Iterator var4 = EnumFacing.Plane.HORIZONTAL.iterator();

      while(var4.hasNext()) {
         EnumFacing var5 = (EnumFacing)var4.next();
         BlockPos var6 = p_176213_2_.func_177972_a(var5);
         IBlockState var7 = p_176213_1_.func_180495_p(var6);
         if(var7.func_177230_c() == this) {
            this.func_176455_e(p_176213_1_, var6, var7);
         }
      }

   }

   public IBlockState func_180642_a(World p_180642_1_, BlockPos p_180642_2_, EnumFacing p_180642_3_, float p_180642_4_, float p_180642_5_, float p_180642_6_, int p_180642_7_, EntityLivingBase p_180642_8_) {
      return this.func_176223_P().func_177226_a(field_176459_a, p_180642_8_.func_174811_aO());
   }

   public void func_180633_a(World p_180633_1_, BlockPos p_180633_2_, IBlockState p_180633_3_, EntityLivingBase p_180633_4_, ItemStack p_180633_5_) {
      EnumFacing var6 = EnumFacing.func_176731_b(MathHelper.func_76128_c((double)(p_180633_4_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3).func_176734_d();
      p_180633_3_ = p_180633_3_.func_177226_a(field_176459_a, var6);
      BlockPos var7 = p_180633_2_.func_177978_c();
      BlockPos var8 = p_180633_2_.func_177968_d();
      BlockPos var9 = p_180633_2_.func_177976_e();
      BlockPos var10 = p_180633_2_.func_177974_f();
      boolean var11 = this == p_180633_1_.func_180495_p(var7).func_177230_c();
      boolean var12 = this == p_180633_1_.func_180495_p(var8).func_177230_c();
      boolean var13 = this == p_180633_1_.func_180495_p(var9).func_177230_c();
      boolean var14 = this == p_180633_1_.func_180495_p(var10).func_177230_c();
      if(!var11 && !var12 && !var13 && !var14) {
         p_180633_1_.func_180501_a(p_180633_2_, p_180633_3_, 3);
      } else if(var6.func_176740_k() == EnumFacing.Axis.X && (var11 || var12)) {
         if(var11) {
            p_180633_1_.func_180501_a(var7, p_180633_3_, 3);
         } else {
            p_180633_1_.func_180501_a(var8, p_180633_3_, 3);
         }

         p_180633_1_.func_180501_a(p_180633_2_, p_180633_3_, 3);
      } else if(var6.func_176740_k() == EnumFacing.Axis.Z && (var13 || var14)) {
         if(var13) {
            p_180633_1_.func_180501_a(var9, p_180633_3_, 3);
         } else {
            p_180633_1_.func_180501_a(var10, p_180633_3_, 3);
         }

         p_180633_1_.func_180501_a(p_180633_2_, p_180633_3_, 3);
      }

      if(p_180633_5_.func_82837_s()) {
         TileEntity var15 = p_180633_1_.func_175625_s(p_180633_2_);
         if(var15 instanceof TileEntityChest) {
            ((TileEntityChest)var15).func_145976_a(p_180633_5_.func_82833_r());
         }
      }

   }

   public IBlockState func_176455_e(World p_176455_1_, BlockPos p_176455_2_, IBlockState p_176455_3_) {
      if(p_176455_1_.field_72995_K) {
         return p_176455_3_;
      } else {
         IBlockState var4 = p_176455_1_.func_180495_p(p_176455_2_.func_177978_c());
         IBlockState var5 = p_176455_1_.func_180495_p(p_176455_2_.func_177968_d());
         IBlockState var6 = p_176455_1_.func_180495_p(p_176455_2_.func_177976_e());
         IBlockState var7 = p_176455_1_.func_180495_p(p_176455_2_.func_177974_f());
         EnumFacing var8 = (EnumFacing)p_176455_3_.func_177229_b(field_176459_a);
         Block var9 = var4.func_177230_c();
         Block var10 = var5.func_177230_c();
         Block var11 = var6.func_177230_c();
         Block var12 = var7.func_177230_c();
         if(var9 != this && var10 != this) {
            boolean var21 = var9.func_149730_j();
            boolean var22 = var10.func_149730_j();
            if(var11 == this || var12 == this) {
               BlockPos var23 = var11 == this?p_176455_2_.func_177976_e():p_176455_2_.func_177974_f();
               IBlockState var24 = p_176455_1_.func_180495_p(var23.func_177978_c());
               IBlockState var25 = p_176455_1_.func_180495_p(var23.func_177968_d());
               var8 = EnumFacing.SOUTH;
               EnumFacing var26;
               if(var11 == this) {
                  var26 = (EnumFacing)var6.func_177229_b(field_176459_a);
               } else {
                  var26 = (EnumFacing)var7.func_177229_b(field_176459_a);
               }

               if(var26 == EnumFacing.NORTH) {
                  var8 = EnumFacing.NORTH;
               }

               Block var19 = var24.func_177230_c();
               Block var20 = var25.func_177230_c();
               if((var21 || var19.func_149730_j()) && !var22 && !var20.func_149730_j()) {
                  var8 = EnumFacing.SOUTH;
               }

               if((var22 || var20.func_149730_j()) && !var21 && !var19.func_149730_j()) {
                  var8 = EnumFacing.NORTH;
               }
            }
         } else {
            BlockPos var13 = var9 == this?p_176455_2_.func_177978_c():p_176455_2_.func_177968_d();
            IBlockState var14 = p_176455_1_.func_180495_p(var13.func_177976_e());
            IBlockState var15 = p_176455_1_.func_180495_p(var13.func_177974_f());
            var8 = EnumFacing.EAST;
            EnumFacing var16;
            if(var9 == this) {
               var16 = (EnumFacing)var4.func_177229_b(field_176459_a);
            } else {
               var16 = (EnumFacing)var5.func_177229_b(field_176459_a);
            }

            if(var16 == EnumFacing.WEST) {
               var8 = EnumFacing.WEST;
            }

            Block var17 = var14.func_177230_c();
            Block var18 = var15.func_177230_c();
            if((var11.func_149730_j() || var17.func_149730_j()) && !var12.func_149730_j() && !var18.func_149730_j()) {
               var8 = EnumFacing.EAST;
            }

            if((var12.func_149730_j() || var18.func_149730_j()) && !var11.func_149730_j() && !var17.func_149730_j()) {
               var8 = EnumFacing.WEST;
            }
         }

         p_176455_3_ = p_176455_3_.func_177226_a(field_176459_a, var8);
         p_176455_1_.func_180501_a(p_176455_2_, p_176455_3_, 3);
         return p_176455_3_;
      }
   }

   public IBlockState func_176458_f(World p_176458_1_, BlockPos p_176458_2_, IBlockState p_176458_3_) {
      EnumFacing var4 = null;
      Iterator var5 = EnumFacing.Plane.HORIZONTAL.iterator();

      while(var5.hasNext()) {
         EnumFacing var6 = (EnumFacing)var5.next();
         IBlockState var7 = p_176458_1_.func_180495_p(p_176458_2_.func_177972_a(var6));
         if(var7.func_177230_c() == this) {
            return p_176458_3_;
         }

         if(var7.func_177230_c().func_149730_j()) {
            if(var4 != null) {
               var4 = null;
               break;
            }

            var4 = var6;
         }
      }

      if(var4 != null) {
         return p_176458_3_.func_177226_a(field_176459_a, var4.func_176734_d());
      } else {
         EnumFacing var8 = (EnumFacing)p_176458_3_.func_177229_b(field_176459_a);
         if(p_176458_1_.func_180495_p(p_176458_2_.func_177972_a(var8)).func_177230_c().func_149730_j()) {
            var8 = var8.func_176734_d();
         }

         if(p_176458_1_.func_180495_p(p_176458_2_.func_177972_a(var8)).func_177230_c().func_149730_j()) {
            var8 = var8.func_176746_e();
         }

         if(p_176458_1_.func_180495_p(p_176458_2_.func_177972_a(var8)).func_177230_c().func_149730_j()) {
            var8 = var8.func_176734_d();
         }

         return p_176458_3_.func_177226_a(field_176459_a, var8);
      }
   }

   public boolean func_176196_c(World p_176196_1_, BlockPos p_176196_2_) {
      int var3 = 0;
      BlockPos var4 = p_176196_2_.func_177976_e();
      BlockPos var5 = p_176196_2_.func_177974_f();
      BlockPos var6 = p_176196_2_.func_177978_c();
      BlockPos var7 = p_176196_2_.func_177968_d();
      if(p_176196_1_.func_180495_p(var4).func_177230_c() == this) {
         if(this.func_176454_e(p_176196_1_, var4)) {
            return false;
         }

         ++var3;
      }

      if(p_176196_1_.func_180495_p(var5).func_177230_c() == this) {
         if(this.func_176454_e(p_176196_1_, var5)) {
            return false;
         }

         ++var3;
      }

      if(p_176196_1_.func_180495_p(var6).func_177230_c() == this) {
         if(this.func_176454_e(p_176196_1_, var6)) {
            return false;
         }

         ++var3;
      }

      if(p_176196_1_.func_180495_p(var7).func_177230_c() == this) {
         if(this.func_176454_e(p_176196_1_, var7)) {
            return false;
         }

         ++var3;
      }

      return var3 <= 1;
   }

   private boolean func_176454_e(World p_176454_1_, BlockPos p_176454_2_) {
      if(p_176454_1_.func_180495_p(p_176454_2_).func_177230_c() != this) {
         return false;
      } else {
         Iterator var3 = EnumFacing.Plane.HORIZONTAL.iterator();

         EnumFacing var4;
         do {
            if(!var3.hasNext()) {
               return false;
            }

            var4 = (EnumFacing)var3.next();
         } while(p_176454_1_.func_180495_p(p_176454_2_.func_177972_a(var4)).func_177230_c() != this);

         return true;
      }
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      super.func_176204_a(p_176204_1_, p_176204_2_, p_176204_3_, p_176204_4_);
      TileEntity var5 = p_176204_1_.func_175625_s(p_176204_2_);
      if(var5 instanceof TileEntityChest) {
         var5.func_145836_u();
      }

   }

   public void func_180663_b(World p_180663_1_, BlockPos p_180663_2_, IBlockState p_180663_3_) {
      TileEntity var4 = p_180663_1_.func_175625_s(p_180663_2_);
      if(var4 instanceof IInventory) {
         InventoryHelper.func_180175_a(p_180663_1_, p_180663_2_, (IInventory)var4);
         p_180663_1_.func_175666_e(p_180663_2_, this);
      }

      super.func_180663_b(p_180663_1_, p_180663_2_, p_180663_3_);
   }

   public boolean func_180639_a(World p_180639_1_, BlockPos p_180639_2_, IBlockState p_180639_3_, EntityPlayer p_180639_4_, EnumFacing p_180639_5_, float p_180639_6_, float p_180639_7_, float p_180639_8_) {
      if(p_180639_1_.field_72995_K) {
         return true;
      } else {
         ILockableContainer var9 = this.func_180676_d(p_180639_1_, p_180639_2_);
         if(var9 != null) {
            p_180639_4_.func_71007_a(var9);
         }

         return true;
      }
   }

   public ILockableContainer func_180676_d(World p_180676_1_, BlockPos p_180676_2_) {
      TileEntity var3 = p_180676_1_.func_175625_s(p_180676_2_);
      if(!(var3 instanceof TileEntityChest)) {
         return null;
      } else {
         Object var4 = (TileEntityChest)var3;
         if(this.func_176457_m(p_180676_1_, p_180676_2_)) {
            return null;
         } else {
            Iterator var5 = EnumFacing.Plane.HORIZONTAL.iterator();

            while(var5.hasNext()) {
               EnumFacing var6 = (EnumFacing)var5.next();
               BlockPos var7 = p_180676_2_.func_177972_a(var6);
               Block var8 = p_180676_1_.func_180495_p(var7).func_177230_c();
               if(var8 == this) {
                  if(this.func_176457_m(p_180676_1_, var7)) {
                     return null;
                  }

                  TileEntity var9 = p_180676_1_.func_175625_s(var7);
                  if(var9 instanceof TileEntityChest) {
                     if(var6 != EnumFacing.WEST && var6 != EnumFacing.NORTH) {
                        var4 = new InventoryLargeChest("container.chestDouble", (ILockableContainer)var4, (TileEntityChest)var9);
                     } else {
                        var4 = new InventoryLargeChest("container.chestDouble", (TileEntityChest)var9, (ILockableContainer)var4);
                     }
                  }
               }
            }

            return (ILockableContainer)var4;
         }
      }
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntityChest();
   }

   public boolean func_149744_f() {
      return this.field_149956_a == 1;
   }

   public int func_180656_a(IBlockAccess p_180656_1_, BlockPos p_180656_2_, IBlockState p_180656_3_, EnumFacing p_180656_4_) {
      if(!this.func_149744_f()) {
         return 0;
      } else {
         int var5 = 0;
         TileEntity var6 = p_180656_1_.func_175625_s(p_180656_2_);
         if(var6 instanceof TileEntityChest) {
            var5 = ((TileEntityChest)var6).field_145987_o;
         }

         return MathHelper.func_76125_a(var5, 0, 15);
      }
   }

   public int func_176211_b(IBlockAccess p_176211_1_, BlockPos p_176211_2_, IBlockState p_176211_3_, EnumFacing p_176211_4_) {
      return p_176211_4_ == EnumFacing.UP?this.func_180656_a(p_176211_1_, p_176211_2_, p_176211_3_, p_176211_4_):0;
   }

   private boolean func_176457_m(World p_176457_1_, BlockPos p_176457_2_) {
      return this.func_176456_n(p_176457_1_, p_176457_2_) || this.func_176453_o(p_176457_1_, p_176457_2_);
   }

   private boolean func_176456_n(World p_176456_1_, BlockPos p_176456_2_) {
      return p_176456_1_.func_180495_p(p_176456_2_.func_177984_a()).func_177230_c().func_149721_r();
   }

   private boolean func_176453_o(World p_176453_1_, BlockPos p_176453_2_) {
      Iterator var3 = p_176453_1_.func_72872_a(EntityOcelot.class, new AxisAlignedBB((double)p_176453_2_.func_177958_n(), (double)(p_176453_2_.func_177956_o() + 1), (double)p_176453_2_.func_177952_p(), (double)(p_176453_2_.func_177958_n() + 1), (double)(p_176453_2_.func_177956_o() + 2), (double)(p_176453_2_.func_177952_p() + 1))).iterator();

      EntityOcelot var5;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         Entity var4 = (Entity)var3.next();
         var5 = (EntityOcelot)var4;
      } while(!var5.func_70906_o());

      return true;
   }

   public boolean func_149740_M() {
      return true;
   }

   public int func_180641_l(World p_180641_1_, BlockPos p_180641_2_) {
      return Container.func_94526_b(this.func_180676_d(p_180641_1_, p_180641_2_));
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      EnumFacing var2 = EnumFacing.func_82600_a(p_176203_1_);
      if(var2.func_176740_k() == EnumFacing.Axis.Y) {
         var2 = EnumFacing.NORTH;
      }

      return this.func_176223_P().func_177226_a(field_176459_a, var2);
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((EnumFacing)p_176201_1_.func_177229_b(field_176459_a)).func_176745_a();
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176459_a});
   }

}
