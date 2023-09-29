package net.minecraft.block;

import java.util.List;
import net.minecraft.block.Block;
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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDirt extends Block {

   public static final PropertyEnum field_176386_a = PropertyEnum.func_177709_a("variant", BlockDirt.DirtType.class);
   public static final PropertyBool field_176385_b = PropertyBool.func_177716_a("snowy");
   private static final String __OBFID = "CL_00000228";


   protected BlockDirt() {
      super(Material.field_151578_c);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176386_a, BlockDirt.DirtType.DIRT).func_177226_a(field_176385_b, Boolean.valueOf(false)));
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public IBlockState func_176221_a(IBlockState p_176221_1_, IBlockAccess p_176221_2_, BlockPos p_176221_3_) {
      if(p_176221_1_.func_177229_b(field_176386_a) == BlockDirt.DirtType.PODZOL) {
         Block var4 = p_176221_2_.func_180495_p(p_176221_3_.func_177984_a()).func_177230_c();
         p_176221_1_ = p_176221_1_.func_177226_a(field_176385_b, Boolean.valueOf(var4 == Blocks.field_150433_aE || var4 == Blocks.field_150431_aC));
      }

      return p_176221_1_;
   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      p_149666_3_.add(new ItemStack(this, 1, BlockDirt.DirtType.DIRT.func_176925_a()));
      p_149666_3_.add(new ItemStack(this, 1, BlockDirt.DirtType.COARSE_DIRT.func_176925_a()));
      p_149666_3_.add(new ItemStack(this, 1, BlockDirt.DirtType.PODZOL.func_176925_a()));
   }

   public int func_176222_j(World p_176222_1_, BlockPos p_176222_2_) {
      IBlockState var3 = p_176222_1_.func_180495_p(p_176222_2_);
      return var3.func_177230_c() != this?0:((BlockDirt.DirtType)var3.func_177229_b(field_176386_a)).func_176925_a();
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176386_a, BlockDirt.DirtType.func_176924_a(p_176203_1_));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((BlockDirt.DirtType)p_176201_1_.func_177229_b(field_176386_a)).func_176925_a();
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176386_a, field_176385_b});
   }

   public int func_180651_a(IBlockState p_180651_1_) {
      BlockDirt.DirtType var2 = (BlockDirt.DirtType)p_180651_1_.func_177229_b(field_176386_a);
      if(var2 == BlockDirt.DirtType.PODZOL) {
         var2 = BlockDirt.DirtType.DIRT;
      }

      return var2.func_176925_a();
   }


   public static enum DirtType implements IStringSerializable {

      DIRT("DIRT", 0, 0, "dirt", "default"),
      COARSE_DIRT("COARSE_DIRT", 1, 1, "coarse_dirt", "coarse"),
      PODZOL("PODZOL", 2, 2, "podzol");
      private static final BlockDirt.DirtType[] field_176930_d = new BlockDirt.DirtType[values().length];
      private final int field_176931_e;
      private final String field_176928_f;
      private final String field_176929_g;
      // $FF: synthetic field
      private static final BlockDirt.DirtType[] $VALUES = new BlockDirt.DirtType[]{DIRT, COARSE_DIRT, PODZOL};
      private static final String __OBFID = "CL_00002125";


      private DirtType(String p_i45727_1_, int p_i45727_2_, int p_i45727_3_, String p_i45727_4_) {
         this(p_i45727_1_, p_i45727_2_, p_i45727_3_, p_i45727_4_, p_i45727_4_);
      }

      private DirtType(String p_i45728_1_, int p_i45728_2_, int p_i45728_3_, String p_i45728_4_, String p_i45728_5_) {
         this.field_176931_e = p_i45728_3_;
         this.field_176928_f = p_i45728_4_;
         this.field_176929_g = p_i45728_5_;
      }

      public int func_176925_a() {
         return this.field_176931_e;
      }

      public String func_176927_c() {
         return this.field_176929_g;
      }

      public String toString() {
         return this.field_176928_f;
      }

      public static BlockDirt.DirtType func_176924_a(int p_176924_0_) {
         if(p_176924_0_ < 0 || p_176924_0_ >= field_176930_d.length) {
            p_176924_0_ = 0;
         }

         return field_176930_d[p_176924_0_];
      }

      public String func_176610_l() {
         return this.field_176928_f;
      }

      static {
         BlockDirt.DirtType[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            BlockDirt.DirtType var3 = var0[var2];
            field_176930_d[var3.func_176925_a()] = var3;
         }

      }
   }
}
