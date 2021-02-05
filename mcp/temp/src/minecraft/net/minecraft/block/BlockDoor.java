package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDoor extends Block {

   public static final PropertyDirection field_176520_a = PropertyDirection.func_177712_a("facing", EnumFacing.Plane.HORIZONTAL);
   public static final PropertyBool field_176519_b = PropertyBool.func_177716_a("open");
   public static final PropertyEnum field_176521_M = PropertyEnum.func_177709_a("hinge", BlockDoor.EnumHingePosition.class);
   public static final PropertyBool field_176522_N = PropertyBool.func_177716_a("powered");
   public static final PropertyEnum field_176523_O = PropertyEnum.func_177709_a("half", BlockDoor.EnumDoorHalf.class);
   private static final String __OBFID = "CL_00000230";


   protected BlockDoor(Material p_i45402_1_) {
      super(p_i45402_1_);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176520_a, EnumFacing.NORTH).func_177226_a(field_176519_b, Boolean.valueOf(false)).func_177226_a(field_176521_M, BlockDoor.EnumHingePosition.LEFT).func_177226_a(field_176522_N, Boolean.valueOf(false)).func_177226_a(field_176523_O, BlockDoor.EnumDoorHalf.LOWER));
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_176205_b(IBlockAccess p_176205_1_, BlockPos p_176205_2_) {
      return func_176516_g(func_176515_e(p_176205_1_, p_176205_2_));
   }

   public boolean func_149686_d() {
      return false;
   }

   public AxisAlignedBB func_180646_a(World p_180646_1_, BlockPos p_180646_2_) {
      this.func_180654_a(p_180646_1_, p_180646_2_);
      return super.func_180646_a(p_180646_1_, p_180646_2_);
   }

   public AxisAlignedBB func_180640_a(World p_180640_1_, BlockPos p_180640_2_, IBlockState p_180640_3_) {
      this.func_180654_a(p_180640_1_, p_180640_2_);
      return super.func_180640_a(p_180640_1_, p_180640_2_, p_180640_3_);
   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      this.func_150011_b(func_176515_e(p_180654_1_, p_180654_2_));
   }

   private void func_150011_b(int p_150011_1_) {
      float var2 = 0.1875F;
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
      EnumFacing var3 = func_176511_f(p_150011_1_);
      boolean var4 = func_176516_g(p_150011_1_);
      boolean var5 = func_176513_j(p_150011_1_);
      if(var4) {
         if(var3 == EnumFacing.EAST) {
            if(!var5) {
               this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
            } else {
               this.func_149676_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
            }
         } else if(var3 == EnumFacing.SOUTH) {
            if(!var5) {
               this.func_149676_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            } else {
               this.func_149676_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
            }
         } else if(var3 == EnumFacing.WEST) {
            if(!var5) {
               this.func_149676_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
            } else {
               this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
            }
         } else if(var3 == EnumFacing.NORTH) {
            if(!var5) {
               this.func_149676_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
            } else {
               this.func_149676_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }
         }
      } else if(var3 == EnumFacing.EAST) {
         this.func_149676_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
      } else if(var3 == EnumFacing.SOUTH) {
         this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
      } else if(var3 == EnumFacing.WEST) {
         this.func_149676_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else if(var3 == EnumFacing.NORTH) {
         this.func_149676_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
      }

   }

   public boolean func_180639_a(World p_180639_1_, BlockPos p_180639_2_, IBlockState p_180639_3_, EntityPlayer p_180639_4_, EnumFacing p_180639_5_, float p_180639_6_, float p_180639_7_, float p_180639_8_) {
      if(this.field_149764_J == Material.field_151573_f) {
         return true;
      } else {
         BlockPos var9 = p_180639_3_.func_177229_b(field_176523_O) == BlockDoor.EnumDoorHalf.LOWER?p_180639_2_:p_180639_2_.func_177977_b();
         IBlockState var10 = p_180639_2_.equals(var9)?p_180639_3_:p_180639_1_.func_180495_p(var9);
         if(var10.func_177230_c() != this) {
            return false;
         } else {
            p_180639_3_ = var10.func_177231_a(field_176519_b);
            p_180639_1_.func_180501_a(var9, p_180639_3_, 2);
            p_180639_1_.func_175704_b(var9, p_180639_2_);
            p_180639_1_.func_180498_a(p_180639_4_, ((Boolean)p_180639_3_.func_177229_b(field_176519_b)).booleanValue()?1003:1006, p_180639_2_, 0);
            return true;
         }
      }
   }

   public void func_176512_a(World p_176512_1_, BlockPos p_176512_2_, boolean p_176512_3_) {
      IBlockState var4 = p_176512_1_.func_180495_p(p_176512_2_);
      if(var4.func_177230_c() == this) {
         BlockPos var5 = var4.func_177229_b(field_176523_O) == BlockDoor.EnumDoorHalf.LOWER?p_176512_2_:p_176512_2_.func_177977_b();
         IBlockState var6 = p_176512_2_ == var5?var4:p_176512_1_.func_180495_p(var5);
         if(var6.func_177230_c() == this && ((Boolean)var6.func_177229_b(field_176519_b)).booleanValue() != p_176512_3_) {
            p_176512_1_.func_180501_a(var5, var6.func_177226_a(field_176519_b, Boolean.valueOf(p_176512_3_)), 2);
            p_176512_1_.func_175704_b(var5, p_176512_2_);
            p_176512_1_.func_180498_a((EntityPlayer)null, p_176512_3_?1003:1006, p_176512_2_, 0);
         }

      }
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      if(p_176204_3_.func_177229_b(field_176523_O) == BlockDoor.EnumDoorHalf.UPPER) {
         BlockPos var5 = p_176204_2_.func_177977_b();
         IBlockState var6 = p_176204_1_.func_180495_p(var5);
         if(var6.func_177230_c() != this) {
            p_176204_1_.func_175698_g(p_176204_2_);
         } else if(p_176204_4_ != this) {
            this.func_176204_a(p_176204_1_, var5, var6, p_176204_4_);
         }
      } else {
         boolean var9 = false;
         BlockPos var10 = p_176204_2_.func_177984_a();
         IBlockState var7 = p_176204_1_.func_180495_p(var10);
         if(var7.func_177230_c() != this) {
            p_176204_1_.func_175698_g(p_176204_2_);
            var9 = true;
         }

         if(!World.func_175683_a(p_176204_1_, p_176204_2_.func_177977_b())) {
            p_176204_1_.func_175698_g(p_176204_2_);
            var9 = true;
            if(var7.func_177230_c() == this) {
               p_176204_1_.func_175698_g(var10);
            }
         }

         if(var9) {
            if(!p_176204_1_.field_72995_K) {
               this.func_176226_b(p_176204_1_, p_176204_2_, p_176204_3_, 0);
            }
         } else {
            boolean var8 = p_176204_1_.func_175640_z(p_176204_2_) || p_176204_1_.func_175640_z(var10);
            if((var8 || p_176204_4_.func_149744_f()) && p_176204_4_ != this && var8 != ((Boolean)var7.func_177229_b(field_176522_N)).booleanValue()) {
               p_176204_1_.func_180501_a(var10, var7.func_177226_a(field_176522_N, Boolean.valueOf(var8)), 2);
               if(var8 != ((Boolean)p_176204_3_.func_177229_b(field_176519_b)).booleanValue()) {
                  p_176204_1_.func_180501_a(p_176204_2_, p_176204_3_.func_177226_a(field_176519_b, Boolean.valueOf(var8)), 2);
                  p_176204_1_.func_175704_b(p_176204_2_, p_176204_2_);
                  p_176204_1_.func_180498_a((EntityPlayer)null, var8?1003:1006, p_176204_2_, 0);
               }
            }
         }
      }

   }

   public Item func_180660_a(IBlockState p_180660_1_, Random p_180660_2_, int p_180660_3_) {
      return p_180660_1_.func_177229_b(field_176523_O) == BlockDoor.EnumDoorHalf.UPPER?null:this.func_176509_j();
   }

   public MovingObjectPosition func_180636_a(World p_180636_1_, BlockPos p_180636_2_, Vec3 p_180636_3_, Vec3 p_180636_4_) {
      this.func_180654_a(p_180636_1_, p_180636_2_);
      return super.func_180636_a(p_180636_1_, p_180636_2_, p_180636_3_, p_180636_4_);
   }

   public boolean func_176196_c(World p_176196_1_, BlockPos p_176196_2_) {
      return p_176196_2_.func_177956_o() >= 255?false:World.func_175683_a(p_176196_1_, p_176196_2_.func_177977_b()) && super.func_176196_c(p_176196_1_, p_176196_2_) && super.func_176196_c(p_176196_1_, p_176196_2_.func_177984_a());
   }

   public int func_149656_h() {
      return 1;
   }

   public static int func_176515_e(IBlockAccess p_176515_0_, BlockPos p_176515_1_) {
      IBlockState var2 = p_176515_0_.func_180495_p(p_176515_1_);
      int var3 = var2.func_177230_c().func_176201_c(var2);
      boolean var4 = func_176518_i(var3);
      IBlockState var5 = p_176515_0_.func_180495_p(p_176515_1_.func_177977_b());
      int var6 = var5.func_177230_c().func_176201_c(var5);
      int var7 = var4?var6:var3;
      IBlockState var8 = p_176515_0_.func_180495_p(p_176515_1_.func_177984_a());
      int var9 = var8.func_177230_c().func_176201_c(var8);
      int var10 = var4?var3:var9;
      boolean var11 = (var10 & 1) != 0;
      boolean var12 = (var10 & 2) != 0;
      return func_176510_b(var7) | (var4?8:0) | (var11?16:0) | (var12?32:0);
   }

   public Item func_180665_b(World p_180665_1_, BlockPos p_180665_2_) {
      return this.func_176509_j();
   }

   private Item func_176509_j() {
      return this == Blocks.field_150454_av?Items.field_151139_aw:(this == Blocks.field_180414_ap?Items.field_179569_ar:(this == Blocks.field_180412_aq?Items.field_179568_as:(this == Blocks.field_180411_ar?Items.field_179567_at:(this == Blocks.field_180410_as?Items.field_179572_au:(this == Blocks.field_180409_at?Items.field_179571_av:Items.field_179570_aq)))));
   }

   public void func_176208_a(World p_176208_1_, BlockPos p_176208_2_, IBlockState p_176208_3_, EntityPlayer p_176208_4_) {
      BlockPos var5 = p_176208_2_.func_177977_b();
      if(p_176208_4_.field_71075_bZ.field_75098_d && p_176208_3_.func_177229_b(field_176523_O) == BlockDoor.EnumDoorHalf.UPPER && p_176208_1_.func_180495_p(var5).func_177230_c() == this) {
         p_176208_1_.func_175698_g(var5);
      }

   }

   public EnumWorldBlockLayer func_180664_k() {
      return EnumWorldBlockLayer.CUTOUT;
   }

   public IBlockState func_176221_a(IBlockState p_176221_1_, IBlockAccess p_176221_2_, BlockPos p_176221_3_) {
      IBlockState var4;
      if(p_176221_1_.func_177229_b(field_176523_O) == BlockDoor.EnumDoorHalf.LOWER) {
         var4 = p_176221_2_.func_180495_p(p_176221_3_.func_177984_a());
         if(var4.func_177230_c() == this) {
            p_176221_1_ = p_176221_1_.func_177226_a(field_176521_M, var4.func_177229_b(field_176521_M)).func_177226_a(field_176522_N, var4.func_177229_b(field_176522_N));
         }
      } else {
         var4 = p_176221_2_.func_180495_p(p_176221_3_.func_177977_b());
         if(var4.func_177230_c() == this) {
            p_176221_1_ = p_176221_1_.func_177226_a(field_176520_a, var4.func_177229_b(field_176520_a)).func_177226_a(field_176519_b, var4.func_177229_b(field_176519_b));
         }
      }

      return p_176221_1_;
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return (p_176203_1_ & 8) > 0?this.func_176223_P().func_177226_a(field_176523_O, BlockDoor.EnumDoorHalf.UPPER).func_177226_a(field_176521_M, (p_176203_1_ & 1) > 0?BlockDoor.EnumHingePosition.RIGHT:BlockDoor.EnumHingePosition.LEFT).func_177226_a(field_176522_N, Boolean.valueOf((p_176203_1_ & 2) > 0)):this.func_176223_P().func_177226_a(field_176523_O, BlockDoor.EnumDoorHalf.LOWER).func_177226_a(field_176520_a, EnumFacing.func_176731_b(p_176203_1_ & 3).func_176735_f()).func_177226_a(field_176519_b, Boolean.valueOf((p_176203_1_ & 4) > 0));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      byte var2 = 0;
      int var3;
      if(p_176201_1_.func_177229_b(field_176523_O) == BlockDoor.EnumDoorHalf.UPPER) {
         var3 = var2 | 8;
         if(p_176201_1_.func_177229_b(field_176521_M) == BlockDoor.EnumHingePosition.RIGHT) {
            var3 |= 1;
         }

         if(((Boolean)p_176201_1_.func_177229_b(field_176522_N)).booleanValue()) {
            var3 |= 2;
         }
      } else {
         var3 = var2 | ((EnumFacing)p_176201_1_.func_177229_b(field_176520_a)).func_176746_e().func_176736_b();
         if(((Boolean)p_176201_1_.func_177229_b(field_176519_b)).booleanValue()) {
            var3 |= 4;
         }
      }

      return var3;
   }

   protected static int func_176510_b(int p_176510_0_) {
      return p_176510_0_ & 7;
   }

   public static boolean func_176514_f(IBlockAccess p_176514_0_, BlockPos p_176514_1_) {
      return func_176516_g(func_176515_e(p_176514_0_, p_176514_1_));
   }

   public static EnumFacing func_176517_h(IBlockAccess p_176517_0_, BlockPos p_176517_1_) {
      return func_176511_f(func_176515_e(p_176517_0_, p_176517_1_));
   }

   public static EnumFacing func_176511_f(int p_176511_0_) {
      return EnumFacing.func_176731_b(p_176511_0_ & 3).func_176735_f();
   }

   protected static boolean func_176516_g(int p_176516_0_) {
      return (p_176516_0_ & 4) != 0;
   }

   protected static boolean func_176518_i(int p_176518_0_) {
      return (p_176518_0_ & 8) != 0;
   }

   protected static boolean func_176513_j(int p_176513_0_) {
      return (p_176513_0_ & 16) != 0;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176523_O, field_176520_a, field_176519_b, field_176521_M, field_176522_N});
   }


   public static enum EnumDoorHalf implements IStringSerializable {

      UPPER("UPPER", 0),
      LOWER("LOWER", 1);
      // $FF: synthetic field
      private static final BlockDoor.EnumDoorHalf[] $VALUES = new BlockDoor.EnumDoorHalf[]{UPPER, LOWER};
      private static final String __OBFID = "CL_00002124";


      private EnumDoorHalf(String p_i45726_1_, int p_i45726_2_) {}

      public String toString() {
         return this.func_176610_l();
      }

      public String func_176610_l() {
         return this == UPPER?"upper":"lower";
      }

   }

   public static enum EnumHingePosition implements IStringSerializable {

      LEFT("LEFT", 0),
      RIGHT("RIGHT", 1);
      // $FF: synthetic field
      private static final BlockDoor.EnumHingePosition[] $VALUES = new BlockDoor.EnumHingePosition[]{LEFT, RIGHT};
      private static final String __OBFID = "CL_00002123";


      private EnumHingePosition(String p_i45725_1_, int p_i45725_2_) {}

      public String toString() {
         return this.func_176610_l();
      }

      public String func_176610_l() {
         return this == LEFT?"left":"right";
      }

   }
}
