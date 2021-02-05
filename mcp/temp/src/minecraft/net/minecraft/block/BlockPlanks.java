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

public class BlockPlanks extends Block {

   public static final PropertyEnum field_176383_a = PropertyEnum.func_177709_a("variant", BlockPlanks.EnumType.class);
   private static final String __OBFID = "CL_00002082";


   public BlockPlanks() {
      super(Material.field_151575_d);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176383_a, BlockPlanks.EnumType.OAK));
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public int func_180651_a(IBlockState p_180651_1_) {
      return ((BlockPlanks.EnumType)p_180651_1_.func_177229_b(field_176383_a)).func_176839_a();
   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      BlockPlanks.EnumType[] var4 = BlockPlanks.EnumType.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         BlockPlanks.EnumType var7 = var4[var6];
         p_149666_3_.add(new ItemStack(p_149666_1_, 1, var7.func_176839_a()));
      }

   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176383_a, BlockPlanks.EnumType.func_176837_a(p_176203_1_));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((BlockPlanks.EnumType)p_176201_1_.func_177229_b(field_176383_a)).func_176839_a();
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176383_a});
   }


   public static enum EnumType implements IStringSerializable {

      OAK("OAK", 0, 0, "oak"),
      SPRUCE("SPRUCE", 1, 1, "spruce"),
      BIRCH("BIRCH", 2, 2, "birch"),
      JUNGLE("JUNGLE", 3, 3, "jungle"),
      ACACIA("ACACIA", 4, 4, "acacia"),
      DARK_OAK("DARK_OAK", 5, 5, "dark_oak", "big_oak");
      private static final BlockPlanks.EnumType[] field_176842_g = new BlockPlanks.EnumType[values().length];
      private final int field_176850_h;
      private final String field_176851_i;
      private final String field_176848_j;
      // $FF: synthetic field
      private static final BlockPlanks.EnumType[] $VALUES = new BlockPlanks.EnumType[]{OAK, SPRUCE, BIRCH, JUNGLE, ACACIA, DARK_OAK};
      private static final String __OBFID = "CL_00002081";


      private EnumType(String p_i45695_1_, int p_i45695_2_, int p_i45695_3_, String p_i45695_4_) {
         this(p_i45695_1_, p_i45695_2_, p_i45695_3_, p_i45695_4_, p_i45695_4_);
      }

      private EnumType(String p_i45696_1_, int p_i45696_2_, int p_i45696_3_, String p_i45696_4_, String p_i45696_5_) {
         this.field_176850_h = p_i45696_3_;
         this.field_176851_i = p_i45696_4_;
         this.field_176848_j = p_i45696_5_;
      }

      public int func_176839_a() {
         return this.field_176850_h;
      }

      public String toString() {
         return this.field_176851_i;
      }

      public static BlockPlanks.EnumType func_176837_a(int p_176837_0_) {
         if(p_176837_0_ < 0 || p_176837_0_ >= field_176842_g.length) {
            p_176837_0_ = 0;
         }

         return field_176842_g[p_176837_0_];
      }

      public String func_176610_l() {
         return this.field_176851_i;
      }

      public String func_176840_c() {
         return this.field_176848_j;
      }

      static {
         BlockPlanks.EnumType[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            BlockPlanks.EnumType var3 = var0[var2];
            field_176842_g[var3.func_176839_a()] = var3;
         }

      }
   }
}
