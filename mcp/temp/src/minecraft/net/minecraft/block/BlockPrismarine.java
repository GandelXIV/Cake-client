package net.minecraft.block;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public class BlockPrismarine extends Block {

   public static final PropertyEnum field_176332_a = PropertyEnum.func_177709_a("variant", BlockPrismarine.EnumType.class);
   public static final int field_176331_b = BlockPrismarine.EnumType.ROUGH.func_176807_a();
   public static final int field_176333_M = BlockPrismarine.EnumType.BRICKS.func_176807_a();
   public static final int field_176334_N = BlockPrismarine.EnumType.DARK.func_176807_a();
   private static final String __OBFID = "CL_00002077";


   public BlockPrismarine() {
      super(Material.field_151576_e);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176332_a, BlockPrismarine.EnumType.ROUGH));
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public int func_180651_a(IBlockState p_180651_1_) {
      return ((BlockPrismarine.EnumType)p_180651_1_.func_177229_b(field_176332_a)).func_176807_a();
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((BlockPrismarine.EnumType)p_176201_1_.func_177229_b(field_176332_a)).func_176807_a();
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176332_a});
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176332_a, BlockPrismarine.EnumType.func_176810_a(p_176203_1_));
   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      p_149666_3_.add(new ItemStack(p_149666_1_, 1, field_176331_b));
      p_149666_3_.add(new ItemStack(p_149666_1_, 1, field_176333_M));
      p_149666_3_.add(new ItemStack(p_149666_1_, 1, field_176334_N));
   }


   public static enum EnumType implements IStringSerializable {

      ROUGH("ROUGH", 0, 0, "prismarine", "rough"),
      BRICKS("BRICKS", 1, 1, "prismarine_bricks", "bricks"),
      DARK("DARK", 2, 2, "dark_prismarine", "dark");
      private static final BlockPrismarine.EnumType[] field_176813_d = new BlockPrismarine.EnumType[values().length];
      private final int field_176814_e;
      private final String field_176811_f;
      private final String field_176812_g;
      // $FF: synthetic field
      private static final BlockPrismarine.EnumType[] $VALUES = new BlockPrismarine.EnumType[]{ROUGH, BRICKS, DARK};
      private static final String __OBFID = "CL_00002076";


      private EnumType(String p_i45692_1_, int p_i45692_2_, int p_i45692_3_, String p_i45692_4_, String p_i45692_5_) {
         this.field_176814_e = p_i45692_3_;
         this.field_176811_f = p_i45692_4_;
         this.field_176812_g = p_i45692_5_;
      }

      public int func_176807_a() {
         return this.field_176814_e;
      }

      public String toString() {
         return this.field_176811_f;
      }

      public static BlockPrismarine.EnumType func_176810_a(int p_176810_0_) {
         if(p_176810_0_ < 0 || p_176810_0_ >= field_176813_d.length) {
            p_176810_0_ = 0;
         }

         return field_176813_d[p_176810_0_];
      }

      public String func_176610_l() {
         return this.field_176811_f;
      }

      public String func_176809_c() {
         return this.field_176812_g;
      }

      static {
         BlockPrismarine.EnumType[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            BlockPrismarine.EnumType var3 = var0[var2];
            field_176813_d[var3.func_176807_a()] = var3;
         }

      }
   }
}
