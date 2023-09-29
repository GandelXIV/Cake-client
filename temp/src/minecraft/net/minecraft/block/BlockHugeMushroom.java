package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;

public class BlockHugeMushroom extends Block {

   public static final PropertyEnum field_176380_a = PropertyEnum.func_177709_a("variant", BlockHugeMushroom.EnumType.class);
   private final Block field_176379_b;
   private static final String __OBFID = "CL_00000258";


   public BlockHugeMushroom(Material p_i45711_1_, Block p_i45711_2_) {
      super(p_i45711_1_);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176380_a, BlockHugeMushroom.EnumType.ALL_OUTSIDE));
      this.field_176379_b = p_i45711_2_;
   }

   public int func_149745_a(Random p_149745_1_) {
      return Math.max(0, p_149745_1_.nextInt(10) - 7);
   }

   public Item func_180660_a(IBlockState p_180660_1_, Random p_180660_2_, int p_180660_3_) {
      return Item.func_150898_a(this.field_176379_b);
   }

   public Item func_180665_b(World p_180665_1_, BlockPos p_180665_2_) {
      return Item.func_150898_a(this.field_176379_b);
   }

   public IBlockState func_180642_a(World p_180642_1_, BlockPos p_180642_2_, EnumFacing p_180642_3_, float p_180642_4_, float p_180642_5_, float p_180642_6_, int p_180642_7_, EntityLivingBase p_180642_8_) {
      return this.func_176223_P();
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176380_a, BlockHugeMushroom.EnumType.func_176895_a(p_176203_1_));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((BlockHugeMushroom.EnumType)p_176201_1_.func_177229_b(field_176380_a)).func_176896_a();
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176380_a});
   }


   public static enum EnumType implements IStringSerializable {

      NORTH_WEST("NORTH_WEST", 0, 1, "north_west"),
      NORTH("NORTH", 1, 2, "north"),
      NORTH_EAST("NORTH_EAST", 2, 3, "north_east"),
      WEST("WEST", 3, 4, "west"),
      CENTER("CENTER", 4, 5, "center"),
      EAST("EAST", 5, 6, "east"),
      SOUTH_WEST("SOUTH_WEST", 6, 7, "south_west"),
      SOUTH("SOUTH", 7, 8, "south"),
      SOUTH_EAST("SOUTH_EAST", 8, 9, "south_east"),
      STEM("STEM", 9, 10, "stem"),
      ALL_INSIDE("ALL_INSIDE", 10, 0, "all_inside"),
      ALL_OUTSIDE("ALL_OUTSIDE", 11, 14, "all_outside"),
      ALL_STEM("ALL_STEM", 12, 15, "all_stem");
      private static final BlockHugeMushroom.EnumType[] field_176905_n = new BlockHugeMushroom.EnumType[16];
      private final int field_176906_o;
      private final String field_176914_p;
      // $FF: synthetic field
      private static final BlockHugeMushroom.EnumType[] $VALUES = new BlockHugeMushroom.EnumType[]{NORTH_WEST, NORTH, NORTH_EAST, WEST, CENTER, EAST, SOUTH_WEST, SOUTH, SOUTH_EAST, STEM, ALL_INSIDE, ALL_OUTSIDE, ALL_STEM};
      private static final String __OBFID = "CL_00002105";


      private EnumType(String p_i45710_1_, int p_i45710_2_, int p_i45710_3_, String p_i45710_4_) {
         this.field_176906_o = p_i45710_3_;
         this.field_176914_p = p_i45710_4_;
      }

      public int func_176896_a() {
         return this.field_176906_o;
      }

      public String toString() {
         return this.field_176914_p;
      }

      public static BlockHugeMushroom.EnumType func_176895_a(int p_176895_0_) {
         if(p_176895_0_ < 0 || p_176895_0_ >= field_176905_n.length) {
            p_176895_0_ = 0;
         }

         BlockHugeMushroom.EnumType var1 = field_176905_n[p_176895_0_];
         return var1 == null?field_176905_n[0]:var1;
      }

      public String func_176610_l() {
         return this.field_176914_p;
      }

      static {
         BlockHugeMushroom.EnumType[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            BlockHugeMushroom.EnumType var3 = var0[var2];
            field_176905_n[var3.func_176896_a()] = var3;
         }

      }
   }
}
