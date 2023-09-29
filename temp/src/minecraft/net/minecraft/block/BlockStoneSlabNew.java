package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;

public abstract class BlockStoneSlabNew extends BlockSlab {

   public static final PropertyBool field_176558_b = PropertyBool.func_177716_a("seamless");
   public static final PropertyEnum field_176559_M = PropertyEnum.func_177709_a("variant", BlockStoneSlabNew.EnumType.class);
   private static final String __OBFID = "CL_00002087";


   public BlockStoneSlabNew() {
      super(Material.field_151576_e);
      IBlockState var1 = this.field_176227_L.func_177621_b();
      if(this.func_176552_j()) {
         var1 = var1.func_177226_a(field_176558_b, Boolean.valueOf(false));
      } else {
         var1 = var1.func_177226_a(field_176554_a, BlockSlab.EnumBlockHalf.BOTTOM);
      }

      this.func_180632_j(var1.func_177226_a(field_176559_M, BlockStoneSlabNew.EnumType.RED_SANDSTONE));
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public Item func_180660_a(IBlockState p_180660_1_, Random p_180660_2_, int p_180660_3_) {
      return Item.func_150898_a(Blocks.field_180389_cP);
   }

   public Item func_180665_b(World p_180665_1_, BlockPos p_180665_2_) {
      return Item.func_150898_a(Blocks.field_180389_cP);
   }

   public String func_150002_b(int p_150002_1_) {
      return super.func_149739_a() + "." + BlockStoneSlabNew.EnumType.func_176916_a(p_150002_1_).func_176918_c();
   }

   public IProperty func_176551_l() {
      return field_176559_M;
   }

   public Object func_176553_a(ItemStack p_176553_1_) {
      return BlockStoneSlabNew.EnumType.func_176916_a(p_176553_1_.func_77960_j() & 7);
   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      if(p_149666_1_ != Item.func_150898_a(Blocks.field_180388_cO)) {
         BlockStoneSlabNew.EnumType[] var4 = BlockStoneSlabNew.EnumType.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            BlockStoneSlabNew.EnumType var7 = var4[var6];
            p_149666_3_.add(new ItemStack(p_149666_1_, 1, var7.func_176915_a()));
         }

      }
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      IBlockState var2 = this.func_176223_P().func_177226_a(field_176559_M, BlockStoneSlabNew.EnumType.func_176916_a(p_176203_1_ & 7));
      if(this.func_176552_j()) {
         var2 = var2.func_177226_a(field_176558_b, Boolean.valueOf((p_176203_1_ & 8) != 0));
      } else {
         var2 = var2.func_177226_a(field_176554_a, (p_176203_1_ & 8) == 0?BlockSlab.EnumBlockHalf.BOTTOM:BlockSlab.EnumBlockHalf.TOP);
      }

      return var2;
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      byte var2 = 0;
      int var3 = var2 | ((BlockStoneSlabNew.EnumType)p_176201_1_.func_177229_b(field_176559_M)).func_176915_a();
      if(this.func_176552_j()) {
         if(((Boolean)p_176201_1_.func_177229_b(field_176558_b)).booleanValue()) {
            var3 |= 8;
         }
      } else if(p_176201_1_.func_177229_b(field_176554_a) == BlockSlab.EnumBlockHalf.TOP) {
         var3 |= 8;
      }

      return var3;
   }

   protected BlockState func_180661_e() {
      return this.func_176552_j()?new BlockState(this, new IProperty[]{field_176558_b, field_176559_M}):new BlockState(this, new IProperty[]{field_176554_a, field_176559_M});
   }

   public int func_180651_a(IBlockState p_180651_1_) {
      return ((BlockStoneSlabNew.EnumType)p_180651_1_.func_177229_b(field_176559_M)).func_176915_a();
   }


   public static enum EnumType implements IStringSerializable {

      RED_SANDSTONE("RED_SANDSTONE", 0, 0, "red_sandstone");
      private static final BlockStoneSlabNew.EnumType[] field_176921_b = new BlockStoneSlabNew.EnumType[values().length];
      private final int field_176922_c;
      private final String field_176919_d;
      // $FF: synthetic field
      private static final BlockStoneSlabNew.EnumType[] $VALUES = new BlockStoneSlabNew.EnumType[]{RED_SANDSTONE};
      private static final String __OBFID = "CL_00002086";


      private EnumType(String p_i45697_1_, int p_i45697_2_, int p_i45697_3_, String p_i45697_4_) {
         this.field_176922_c = p_i45697_3_;
         this.field_176919_d = p_i45697_4_;
      }

      public int func_176915_a() {
         return this.field_176922_c;
      }

      public String toString() {
         return this.field_176919_d;
      }

      public static BlockStoneSlabNew.EnumType func_176916_a(int p_176916_0_) {
         if(p_176916_0_ < 0 || p_176916_0_ >= field_176921_b.length) {
            p_176916_0_ = 0;
         }

         return field_176921_b[p_176916_0_];
      }

      public String func_176610_l() {
         return this.field_176919_d;
      }

      public String func_176918_c() {
         return this.field_176919_d;
      }

      static {
         BlockStoneSlabNew.EnumType[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            BlockStoneSlabNew.EnumType var3 = var0[var2];
            field_176921_b[var3.func_176915_a()] = var3;
         }

      }
   }
}
