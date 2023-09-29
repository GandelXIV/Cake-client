package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPistonExtension extends Block {

   public static final PropertyDirection field_176326_a = PropertyDirection.func_177714_a("facing");
   public static final PropertyEnum field_176325_b = PropertyEnum.func_177709_a("type", BlockPistonExtension.EnumPistonType.class);
   public static final PropertyBool field_176327_M = PropertyBool.func_177716_a("short");
   private static final String __OBFID = "CL_00000367";


   public BlockPistonExtension() {
      super(Material.field_76233_E);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176326_a, EnumFacing.NORTH).func_177226_a(field_176325_b, BlockPistonExtension.EnumPistonType.DEFAULT).func_177226_a(field_176327_M, Boolean.valueOf(false)));
      this.func_149672_a(field_149780_i);
      this.func_149711_c(0.5F);
   }

   public void func_176208_a(World p_176208_1_, BlockPos p_176208_2_, IBlockState p_176208_3_, EntityPlayer p_176208_4_) {
      if(p_176208_4_.field_71075_bZ.field_75098_d) {
         EnumFacing var5 = (EnumFacing)p_176208_3_.func_177229_b(field_176326_a);
         if(var5 != null) {
            BlockPos var6 = p_176208_2_.func_177972_a(var5.func_176734_d());
            Block var7 = p_176208_1_.func_180495_p(var6).func_177230_c();
            if(var7 == Blocks.field_150331_J || var7 == Blocks.field_150320_F) {
               p_176208_1_.func_175698_g(var6);
            }
         }
      }

      super.func_176208_a(p_176208_1_, p_176208_2_, p_176208_3_, p_176208_4_);
   }

   public void func_180663_b(World p_180663_1_, BlockPos p_180663_2_, IBlockState p_180663_3_) {
      super.func_180663_b(p_180663_1_, p_180663_2_, p_180663_3_);
      EnumFacing var4 = ((EnumFacing)p_180663_3_.func_177229_b(field_176326_a)).func_176734_d();
      p_180663_2_ = p_180663_2_.func_177972_a(var4);
      IBlockState var5 = p_180663_1_.func_180495_p(p_180663_2_);
      if((var5.func_177230_c() == Blocks.field_150331_J || var5.func_177230_c() == Blocks.field_150320_F) && ((Boolean)var5.func_177229_b(BlockPistonBase.field_176320_b)).booleanValue()) {
         var5.func_177230_c().func_176226_b(p_180663_1_, p_180663_2_, var5, 0);
         p_180663_1_.func_175698_g(p_180663_2_);
      }

   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_176196_c(World p_176196_1_, BlockPos p_176196_2_) {
      return false;
   }

   public boolean func_176198_a(World p_176198_1_, BlockPos p_176198_2_, EnumFacing p_176198_3_) {
      return false;
   }

   public int func_149745_a(Random p_149745_1_) {
      return 0;
   }

   public void func_180638_a(World p_180638_1_, BlockPos p_180638_2_, IBlockState p_180638_3_, AxisAlignedBB p_180638_4_, List p_180638_5_, Entity p_180638_6_) {
      this.func_176324_d(p_180638_3_);
      super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
      this.func_176323_e(p_180638_3_);
      super.func_180638_a(p_180638_1_, p_180638_2_, p_180638_3_, p_180638_4_, p_180638_5_, p_180638_6_);
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   private void func_176323_e(IBlockState p_176323_1_) {
      float var2 = 0.25F;
      float var3 = 0.375F;
      float var4 = 0.625F;
      float var5 = 0.25F;
      float var6 = 0.75F;
      switch(BlockPistonExtension.SwitchEnumFacing.field_177247_a[((EnumFacing)p_176323_1_.func_177229_b(field_176326_a)).ordinal()]) {
      case 1:
         this.func_149676_a(0.375F, 0.25F, 0.375F, 0.625F, 1.0F, 0.625F);
         break;
      case 2:
         this.func_149676_a(0.375F, 0.0F, 0.375F, 0.625F, 0.75F, 0.625F);
         break;
      case 3:
         this.func_149676_a(0.25F, 0.375F, 0.25F, 0.75F, 0.625F, 1.0F);
         break;
      case 4:
         this.func_149676_a(0.25F, 0.375F, 0.0F, 0.75F, 0.625F, 0.75F);
         break;
      case 5:
         this.func_149676_a(0.375F, 0.25F, 0.25F, 0.625F, 0.75F, 1.0F);
         break;
      case 6:
         this.func_149676_a(0.0F, 0.375F, 0.25F, 0.75F, 0.625F, 0.75F);
      }

   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      this.func_176324_d(p_180654_1_.func_180495_p(p_180654_2_));
   }

   public void func_176324_d(IBlockState p_176324_1_) {
      float var2 = 0.25F;
      EnumFacing var3 = (EnumFacing)p_176324_1_.func_177229_b(field_176326_a);
      if(var3 != null) {
         switch(BlockPistonExtension.SwitchEnumFacing.field_177247_a[var3.ordinal()]) {
         case 1:
            this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            break;
         case 2:
            this.func_149676_a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
         case 3:
            this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            break;
         case 4:
            this.func_149676_a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            break;
         case 5:
            this.func_149676_a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            break;
         case 6:
            this.func_149676_a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         }

      }
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      EnumFacing var5 = (EnumFacing)p_176204_3_.func_177229_b(field_176326_a);
      BlockPos var6 = p_176204_2_.func_177972_a(var5.func_176734_d());
      IBlockState var7 = p_176204_1_.func_180495_p(var6);
      if(var7.func_177230_c() != Blocks.field_150331_J && var7.func_177230_c() != Blocks.field_150320_F) {
         p_176204_1_.func_175698_g(p_176204_2_);
      } else {
         var7.func_177230_c().func_176204_a(p_176204_1_, var6, var7, p_176204_4_);
      }

   }

   public boolean func_176225_a(IBlockAccess p_176225_1_, BlockPos p_176225_2_, EnumFacing p_176225_3_) {
      return true;
   }

   public static EnumFacing func_176322_b(int p_176322_0_) {
      int var1 = p_176322_0_ & 7;
      return var1 > 5?null:EnumFacing.func_82600_a(var1);
   }

   public Item func_180665_b(World p_180665_1_, BlockPos p_180665_2_) {
      return p_180665_1_.func_180495_p(p_180665_2_).func_177229_b(field_176325_b) == BlockPistonExtension.EnumPistonType.STICKY?Item.func_150898_a(Blocks.field_150320_F):Item.func_150898_a(Blocks.field_150331_J);
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176326_a, func_176322_b(p_176203_1_)).func_177226_a(field_176325_b, (p_176203_1_ & 8) > 0?BlockPistonExtension.EnumPistonType.STICKY:BlockPistonExtension.EnumPistonType.DEFAULT);
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      byte var2 = 0;
      int var3 = var2 | ((EnumFacing)p_176201_1_.func_177229_b(field_176326_a)).func_176745_a();
      if(p_176201_1_.func_177229_b(field_176325_b) == BlockPistonExtension.EnumPistonType.STICKY) {
         var3 |= 8;
      }

      return var3;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176326_a, field_176325_b, field_176327_M});
   }


   public static enum EnumPistonType implements IStringSerializable {

      DEFAULT("DEFAULT", 0, "normal"),
      STICKY("STICKY", 1, "sticky");
      private final String field_176714_c;
      // $FF: synthetic field
      private static final BlockPistonExtension.EnumPistonType[] $VALUES = new BlockPistonExtension.EnumPistonType[]{DEFAULT, STICKY};
      private static final String __OBFID = "CL_00002035";


      private EnumPistonType(String p_i45666_1_, int p_i45666_2_, String p_i45666_3_) {
         this.field_176714_c = p_i45666_3_;
      }

      public String toString() {
         return this.field_176714_c;
      }

      public String func_176610_l() {
         return this.field_176714_c;
      }

   }

   // $FF: synthetic class
   static final class SwitchEnumFacing {

      // $FF: synthetic field
      static final int[] field_177247_a = new int[EnumFacing.values().length];
      private static final String __OBFID = "CL_00002036";


      static {
         try {
            field_177247_a[EnumFacing.DOWN.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            field_177247_a[EnumFacing.UP.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            field_177247_a[EnumFacing.NORTH.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_177247_a[EnumFacing.SOUTH.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_177247_a[EnumFacing.WEST.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_177247_a[EnumFacing.EAST.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
