package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public class BlockStone extends Block {

   public static final PropertyEnum field_176247_a = PropertyEnum.func_177709_a("variant", BlockStone.EnumType.class);
   private static final String __OBFID = "CL_00000317";


   public BlockStone() {
      super(Material.field_151576_e);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176247_a, BlockStone.EnumType.STONE));
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public Item func_180660_a(IBlockState p_180660_1_, Random p_180660_2_, int p_180660_3_) {
      return p_180660_1_.func_177229_b(field_176247_a) == BlockStone.EnumType.STONE?Item.func_150898_a(Blocks.field_150347_e):Item.func_150898_a(Blocks.field_150348_b);
   }

   public int func_180651_a(IBlockState p_180651_1_) {
      return ((BlockStone.EnumType)p_180651_1_.func_177229_b(field_176247_a)).func_176642_a();
   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      BlockStone.EnumType[] var4 = BlockStone.EnumType.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         BlockStone.EnumType var7 = var4[var6];
         p_149666_3_.add(new ItemStack(p_149666_1_, 1, var7.func_176642_a()));
      }

   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176247_a, BlockStone.EnumType.func_176643_a(p_176203_1_));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((BlockStone.EnumType)p_176201_1_.func_177229_b(field_176247_a)).func_176642_a();
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176247_a});
   }


   public static enum EnumType implements IStringSerializable {

      STONE("STONE", 0, 0, "stone"),
      GRANITE("GRANITE", 1, 1, "granite"),
      GRANITE_SMOOTH("GRANITE_SMOOTH", 2, 2, "smooth_granite", "graniteSmooth"),
      DIORITE("DIORITE", 3, 3, "diorite"),
      DIORITE_SMOOTH("DIORITE_SMOOTH", 4, 4, "smooth_diorite", "dioriteSmooth"),
      ANDESITE("ANDESITE", 5, 5, "andesite"),
      ANDESITE_SMOOTH("ANDESITE_SMOOTH", 6, 6, "smooth_andesite", "andesiteSmooth");
      private static final BlockStone.EnumType[] field_176655_h = new BlockStone.EnumType[values().length];
      private final int field_176656_i;
      private final String field_176653_j;
      private final String field_176654_k;
      // $FF: synthetic field
      private static final BlockStone.EnumType[] $VALUES = new BlockStone.EnumType[]{STONE, GRANITE, GRANITE_SMOOTH, DIORITE, DIORITE_SMOOTH, ANDESITE, ANDESITE_SMOOTH};
      private static final String __OBFID = "CL_00002058";


      private EnumType(String p_i45680_1_, int p_i45680_2_, int p_i45680_3_, String p_i45680_4_) {
         this(p_i45680_1_, p_i45680_2_, p_i45680_3_, p_i45680_4_, p_i45680_4_);
      }

      private EnumType(String p_i45681_1_, int p_i45681_2_, int p_i45681_3_, String p_i45681_4_, String p_i45681_5_) {
         this.field_176656_i = p_i45681_3_;
         this.field_176653_j = p_i45681_4_;
         this.field_176654_k = p_i45681_5_;
      }

      public int func_176642_a() {
         return this.field_176656_i;
      }

      public String toString() {
         return this.field_176653_j;
      }

      public static BlockStone.EnumType func_176643_a(int p_176643_0_) {
         if(p_176643_0_ < 0 || p_176643_0_ >= field_176655_h.length) {
            p_176643_0_ = 0;
         }

         return field_176655_h[p_176643_0_];
      }

      public String func_176610_l() {
         return this.field_176653_j;
      }

      public String func_176644_c() {
         return this.field_176654_k;
      }

      static {
         BlockStone.EnumType[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            BlockStone.EnumType var3 = var0[var2];
            field_176655_h[var3.func_176642_a()] = var3;
         }

      }
   }
}
