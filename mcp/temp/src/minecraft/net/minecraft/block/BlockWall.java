package net.minecraft.block;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
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
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWall extends Block {

   public static final PropertyBool field_176256_a = PropertyBool.func_177716_a("up");
   public static final PropertyBool field_176254_b = PropertyBool.func_177716_a("north");
   public static final PropertyBool field_176257_M = PropertyBool.func_177716_a("east");
   public static final PropertyBool field_176258_N = PropertyBool.func_177716_a("south");
   public static final PropertyBool field_176259_O = PropertyBool.func_177716_a("west");
   public static final PropertyEnum field_176255_P = PropertyEnum.func_177709_a("variant", BlockWall.EnumType.class);
   private static final String __OBFID = "CL_00000331";


   public BlockWall(Block p_i45435_1_) {
      super(p_i45435_1_.field_149764_J);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176256_a, Boolean.valueOf(false)).func_177226_a(field_176254_b, Boolean.valueOf(false)).func_177226_a(field_176257_M, Boolean.valueOf(false)).func_177226_a(field_176258_N, Boolean.valueOf(false)).func_177226_a(field_176259_O, Boolean.valueOf(false)).func_177226_a(field_176255_P, BlockWall.EnumType.NORMAL));
      this.func_149711_c(p_i45435_1_.field_149782_v);
      this.func_149752_b(p_i45435_1_.field_149781_w / 3.0F);
      this.func_149672_a(p_i45435_1_.field_149762_H);
      this.func_149647_a(CreativeTabs.field_78030_b);
   }

   public boolean func_149686_d() {
      return false;
   }

   public boolean func_176205_b(IBlockAccess p_176205_1_, BlockPos p_176205_2_) {
      return false;
   }

   public boolean func_149662_c() {
      return false;
   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      boolean var3 = this.func_176253_e(p_180654_1_, p_180654_2_.func_177978_c());
      boolean var4 = this.func_176253_e(p_180654_1_, p_180654_2_.func_177968_d());
      boolean var5 = this.func_176253_e(p_180654_1_, p_180654_2_.func_177976_e());
      boolean var6 = this.func_176253_e(p_180654_1_, p_180654_2_.func_177974_f());
      float var7 = 0.25F;
      float var8 = 0.75F;
      float var9 = 0.25F;
      float var10 = 0.75F;
      float var11 = 1.0F;
      if(var3) {
         var9 = 0.0F;
      }

      if(var4) {
         var10 = 1.0F;
      }

      if(var5) {
         var7 = 0.0F;
      }

      if(var6) {
         var8 = 1.0F;
      }

      if(var3 && var4 && !var5 && !var6) {
         var11 = 0.8125F;
         var7 = 0.3125F;
         var8 = 0.6875F;
      } else if(!var3 && !var4 && var5 && var6) {
         var11 = 0.8125F;
         var9 = 0.3125F;
         var10 = 0.6875F;
      }

      this.func_149676_a(var7, 0.0F, var9, var8, var11, var10);
   }

   public AxisAlignedBB func_180640_a(World p_180640_1_, BlockPos p_180640_2_, IBlockState p_180640_3_) {
      this.func_180654_a(p_180640_1_, p_180640_2_);
      this.field_149756_F = 1.5D;
      return super.func_180640_a(p_180640_1_, p_180640_2_, p_180640_3_);
   }

   public boolean func_176253_e(IBlockAccess p_176253_1_, BlockPos p_176253_2_) {
      Block var3 = p_176253_1_.func_180495_p(p_176253_2_).func_177230_c();
      return var3 == Blocks.field_180401_cv?false:(var3 != this && !(var3 instanceof BlockFenceGate)?(var3.field_149764_J.func_76218_k() && var3.func_149686_d()?var3.field_149764_J != Material.field_151572_C:false):true);
   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      BlockWall.EnumType[] var4 = BlockWall.EnumType.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         BlockWall.EnumType var7 = var4[var6];
         p_149666_3_.add(new ItemStack(p_149666_1_, 1, var7.func_176657_a()));
      }

   }

   public int func_180651_a(IBlockState p_180651_1_) {
      return ((BlockWall.EnumType)p_180651_1_.func_177229_b(field_176255_P)).func_176657_a();
   }

   public boolean func_176225_a(IBlockAccess p_176225_1_, BlockPos p_176225_2_, EnumFacing p_176225_3_) {
      return p_176225_3_ == EnumFacing.DOWN?super.func_176225_a(p_176225_1_, p_176225_2_, p_176225_3_):true;
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176255_P, BlockWall.EnumType.func_176660_a(p_176203_1_));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((BlockWall.EnumType)p_176201_1_.func_177229_b(field_176255_P)).func_176657_a();
   }

   public IBlockState func_176221_a(IBlockState p_176221_1_, IBlockAccess p_176221_2_, BlockPos p_176221_3_) {
      return p_176221_1_.func_177226_a(field_176256_a, Boolean.valueOf(!p_176221_2_.func_175623_d(p_176221_3_.func_177984_a()))).func_177226_a(field_176254_b, Boolean.valueOf(this.func_176253_e(p_176221_2_, p_176221_3_.func_177978_c()))).func_177226_a(field_176257_M, Boolean.valueOf(this.func_176253_e(p_176221_2_, p_176221_3_.func_177974_f()))).func_177226_a(field_176258_N, Boolean.valueOf(this.func_176253_e(p_176221_2_, p_176221_3_.func_177968_d()))).func_177226_a(field_176259_O, Boolean.valueOf(this.func_176253_e(p_176221_2_, p_176221_3_.func_177976_e())));
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176256_a, field_176254_b, field_176257_M, field_176259_O, field_176258_N, field_176255_P});
   }


   public static enum EnumType implements IStringSerializable {

      NORMAL("NORMAL", 0, 0, "cobblestone", "normal"),
      MOSSY("MOSSY", 1, 1, "mossy_cobblestone", "mossy");
      private static final BlockWall.EnumType[] field_176666_c = new BlockWall.EnumType[values().length];
      private final int field_176663_d;
      private final String field_176664_e;
      private String field_176661_f;
      // $FF: synthetic field
      private static final BlockWall.EnumType[] $VALUES = new BlockWall.EnumType[]{NORMAL, MOSSY};
      private static final String __OBFID = "CL_00002048";


      private EnumType(String p_i45673_1_, int p_i45673_2_, int p_i45673_3_, String p_i45673_4_, String p_i45673_5_) {
         this.field_176663_d = p_i45673_3_;
         this.field_176664_e = p_i45673_4_;
         this.field_176661_f = p_i45673_5_;
      }

      public int func_176657_a() {
         return this.field_176663_d;
      }

      public String toString() {
         return this.field_176664_e;
      }

      public static BlockWall.EnumType func_176660_a(int p_176660_0_) {
         if(p_176660_0_ < 0 || p_176660_0_ >= field_176666_c.length) {
            p_176660_0_ = 0;
         }

         return field_176666_c[p_176660_0_];
      }

      public String func_176610_l() {
         return this.field_176664_e;
      }

      public String func_176659_c() {
         return this.field_176661_f;
      }

      static {
         BlockWall.EnumType[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            BlockWall.EnumType var3 = var0[var2];
            field_176666_c[var3.func_176657_a()] = var3;
         }

      }
   }
}
