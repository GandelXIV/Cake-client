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

public class BlockRedSandstone extends Block {

   public static final PropertyEnum field_176336_a = PropertyEnum.func_177709_a("type", BlockRedSandstone.EnumType.class);
   private static final String __OBFID = "CL_00002072";


   public BlockRedSandstone() {
      super(Material.field_151576_e);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176336_a, BlockRedSandstone.EnumType.DEFAULT));
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public int func_180651_a(IBlockState p_180651_1_) {
      return ((BlockRedSandstone.EnumType)p_180651_1_.func_177229_b(field_176336_a)).func_176827_a();
   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      BlockRedSandstone.EnumType[] var4 = BlockRedSandstone.EnumType.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         BlockRedSandstone.EnumType var7 = var4[var6];
         p_149666_3_.add(new ItemStack(p_149666_1_, 1, var7.func_176827_a()));
      }

   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176336_a, BlockRedSandstone.EnumType.func_176825_a(p_176203_1_));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((BlockRedSandstone.EnumType)p_176201_1_.func_177229_b(field_176336_a)).func_176827_a();
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176336_a});
   }


   public static enum EnumType implements IStringSerializable {

      DEFAULT("DEFAULT", 0, 0, "red_sandstone", "default"),
      CHISELED("CHISELED", 1, 1, "chiseled_red_sandstone", "chiseled"),
      SMOOTH("SMOOTH", 2, 2, "smooth_red_sandstone", "smooth");
      private static final BlockRedSandstone.EnumType[] field_176831_d = new BlockRedSandstone.EnumType[values().length];
      private final int field_176832_e;
      private final String field_176829_f;
      private final String field_176830_g;
      // $FF: synthetic field
      private static final BlockRedSandstone.EnumType[] $VALUES = new BlockRedSandstone.EnumType[]{DEFAULT, CHISELED, SMOOTH};
      private static final String __OBFID = "CL_00002071";


      private EnumType(String p_i45690_1_, int p_i45690_2_, int p_i45690_3_, String p_i45690_4_, String p_i45690_5_) {
         this.field_176832_e = p_i45690_3_;
         this.field_176829_f = p_i45690_4_;
         this.field_176830_g = p_i45690_5_;
      }

      public int func_176827_a() {
         return this.field_176832_e;
      }

      public String toString() {
         return this.field_176829_f;
      }

      public static BlockRedSandstone.EnumType func_176825_a(int p_176825_0_) {
         if(p_176825_0_ < 0 || p_176825_0_ >= field_176831_d.length) {
            p_176825_0_ = 0;
         }

         return field_176831_d[p_176825_0_];
      }

      public String func_176610_l() {
         return this.field_176829_f;
      }

      public String func_176828_c() {
         return this.field_176830_g;
      }

      static {
         BlockRedSandstone.EnumType[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            BlockRedSandstone.EnumType var3 = var0[var2];
            field_176831_d[var3.func_176827_a()] = var3;
         }

      }
   }
}
