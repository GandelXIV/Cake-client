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

public abstract class BlockStoneSlab extends BlockSlab {

   public static final PropertyBool field_176555_b = PropertyBool.func_177716_a("seamless");
   public static final PropertyEnum field_176556_M = PropertyEnum.func_177709_a("variant", BlockStoneSlab.EnumType.class);
   private static final String __OBFID = "CL_00000320";


   public BlockStoneSlab() {
      super(Material.field_151576_e);
      IBlockState var1 = this.field_176227_L.func_177621_b();
      if(this.func_176552_j()) {
         var1 = var1.func_177226_a(field_176555_b, Boolean.valueOf(false));
      } else {
         var1 = var1.func_177226_a(field_176554_a, BlockSlab.EnumBlockHalf.BOTTOM);
      }

      this.func_180632_j(var1.func_177226_a(field_176556_M, BlockStoneSlab.EnumType.STONE));
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public Item func_180660_a(IBlockState p_180660_1_, Random p_180660_2_, int p_180660_3_) {
      return Item.func_150898_a(Blocks.field_150333_U);
   }

   public Item func_180665_b(World p_180665_1_, BlockPos p_180665_2_) {
      return Item.func_150898_a(Blocks.field_150333_U);
   }

   public String func_150002_b(int p_150002_1_) {
      return super.func_149739_a() + "." + BlockStoneSlab.EnumType.func_176625_a(p_150002_1_).func_176627_c();
   }

   public IProperty func_176551_l() {
      return field_176556_M;
   }

   public Object func_176553_a(ItemStack p_176553_1_) {
      return BlockStoneSlab.EnumType.func_176625_a(p_176553_1_.func_77960_j() & 7);
   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      if(p_149666_1_ != Item.func_150898_a(Blocks.field_150334_T)) {
         BlockStoneSlab.EnumType[] var4 = BlockStoneSlab.EnumType.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            BlockStoneSlab.EnumType var7 = var4[var6];
            if(var7 != BlockStoneSlab.EnumType.WOOD) {
               p_149666_3_.add(new ItemStack(p_149666_1_, 1, var7.func_176624_a()));
            }
         }

      }
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      IBlockState var2 = this.func_176223_P().func_177226_a(field_176556_M, BlockStoneSlab.EnumType.func_176625_a(p_176203_1_ & 7));
      if(this.func_176552_j()) {
         var2 = var2.func_177226_a(field_176555_b, Boolean.valueOf((p_176203_1_ & 8) != 0));
      } else {
         var2 = var2.func_177226_a(field_176554_a, (p_176203_1_ & 8) == 0?BlockSlab.EnumBlockHalf.BOTTOM:BlockSlab.EnumBlockHalf.TOP);
      }

      return var2;
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      byte var2 = 0;
      int var3 = var2 | ((BlockStoneSlab.EnumType)p_176201_1_.func_177229_b(field_176556_M)).func_176624_a();
      if(this.func_176552_j()) {
         if(((Boolean)p_176201_1_.func_177229_b(field_176555_b)).booleanValue()) {
            var3 |= 8;
         }
      } else if(p_176201_1_.func_177229_b(field_176554_a) == BlockSlab.EnumBlockHalf.TOP) {
         var3 |= 8;
      }

      return var3;
   }

   protected BlockState func_180661_e() {
      return this.func_176552_j()?new BlockState(this, new IProperty[]{field_176555_b, field_176556_M}):new BlockState(this, new IProperty[]{field_176554_a, field_176556_M});
   }

   public int func_180651_a(IBlockState p_180651_1_) {
      return ((BlockStoneSlab.EnumType)p_180651_1_.func_177229_b(field_176556_M)).func_176624_a();
   }


   public static enum EnumType implements IStringSerializable {

      STONE("STONE", 0, 0, "stone"),
      SAND("SAND", 1, 1, "sandstone", "sand"),
      WOOD("WOOD", 2, 2, "wood_old", "wood"),
      COBBLESTONE("COBBLESTONE", 3, 3, "cobblestone", "cobble"),
      BRICK("BRICK", 4, 4, "brick"),
      SMOOTHBRICK("SMOOTHBRICK", 5, 5, "stone_brick", "smoothStoneBrick"),
      NETHERBRICK("NETHERBRICK", 6, 6, "nether_brick", "netherBrick"),
      QUARTZ("QUARTZ", 7, 7, "quartz");
      private static final BlockStoneSlab.EnumType[] field_176640_i = new BlockStoneSlab.EnumType[values().length];
      private final int field_176637_j;
      private final String field_176638_k;
      private final String field_176635_l;
      // $FF: synthetic field
      private static final BlockStoneSlab.EnumType[] $VALUES = new BlockStoneSlab.EnumType[]{STONE, SAND, WOOD, COBBLESTONE, BRICK, SMOOTHBRICK, NETHERBRICK, QUARTZ};
      private static final String __OBFID = "CL_00002056";


      private EnumType(String p_i45677_1_, int p_i45677_2_, int p_i45677_3_, String p_i45677_4_) {
         this(p_i45677_1_, p_i45677_2_, p_i45677_3_, p_i45677_4_, p_i45677_4_);
      }

      private EnumType(String p_i45678_1_, int p_i45678_2_, int p_i45678_3_, String p_i45678_4_, String p_i45678_5_) {
         this.field_176637_j = p_i45678_3_;
         this.field_176638_k = p_i45678_4_;
         this.field_176635_l = p_i45678_5_;
      }

      public int func_176624_a() {
         return this.field_176637_j;
      }

      public String toString() {
         return this.field_176638_k;
      }

      public static BlockStoneSlab.EnumType func_176625_a(int p_176625_0_) {
         if(p_176625_0_ < 0 || p_176625_0_ >= field_176640_i.length) {
            p_176625_0_ = 0;
         }

         return field_176640_i[p_176625_0_];
      }

      public String func_176610_l() {
         return this.field_176638_k;
      }

      public String func_176627_c() {
         return this.field_176635_l;
      }

      static {
         BlockStoneSlab.EnumType[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            BlockStoneSlab.EnumType var3 = var0[var2];
            field_176640_i[var3.func_176624_a()] = var3;
         }

      }
   }
}
