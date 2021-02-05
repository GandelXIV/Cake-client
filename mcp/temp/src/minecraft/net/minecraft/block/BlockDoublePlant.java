package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColorHelper;

public class BlockDoublePlant extends BlockBush implements IGrowable {

   public static final PropertyEnum field_176493_a = PropertyEnum.func_177709_a("variant", BlockDoublePlant.EnumPlantType.class);
   public static final PropertyEnum field_176492_b = PropertyEnum.func_177709_a("half", BlockDoublePlant.EnumBlockHalf.class);
   private static final String __OBFID = "CL_00000231";


   public BlockDoublePlant() {
      super(Material.field_151582_l);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176493_a, BlockDoublePlant.EnumPlantType.SUNFLOWER).func_177226_a(field_176492_b, BlockDoublePlant.EnumBlockHalf.LOWER));
      this.func_149711_c(0.0F);
      this.func_149672_a(field_149779_h);
      this.func_149663_c("doublePlant");
   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      this.func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public BlockDoublePlant.EnumPlantType func_176490_e(IBlockAccess p_176490_1_, BlockPos p_176490_2_) {
      IBlockState var3 = p_176490_1_.func_180495_p(p_176490_2_);
      if(var3.func_177230_c() == this) {
         var3 = this.func_176221_a(var3, p_176490_1_, p_176490_2_);
         return (BlockDoublePlant.EnumPlantType)var3.func_177229_b(field_176493_a);
      } else {
         return BlockDoublePlant.EnumPlantType.FERN;
      }
   }

   public boolean func_176196_c(World p_176196_1_, BlockPos p_176196_2_) {
      return super.func_176196_c(p_176196_1_, p_176196_2_) && p_176196_1_.func_175623_d(p_176196_2_.func_177984_a());
   }

   public boolean func_176200_f(World p_176200_1_, BlockPos p_176200_2_) {
      IBlockState var3 = p_176200_1_.func_180495_p(p_176200_2_);
      if(var3.func_177230_c() != this) {
         return true;
      } else {
         BlockDoublePlant.EnumPlantType var4 = (BlockDoublePlant.EnumPlantType)this.func_176221_a(var3, p_176200_1_, p_176200_2_).func_177229_b(field_176493_a);
         return var4 == BlockDoublePlant.EnumPlantType.FERN || var4 == BlockDoublePlant.EnumPlantType.GRASS;
      }
   }

   protected void func_176475_e(World p_176475_1_, BlockPos p_176475_2_, IBlockState p_176475_3_) {
      if(!this.func_180671_f(p_176475_1_, p_176475_2_, p_176475_3_)) {
         boolean var4 = p_176475_3_.func_177229_b(field_176492_b) == BlockDoublePlant.EnumBlockHalf.UPPER;
         BlockPos var5 = var4?p_176475_2_:p_176475_2_.func_177984_a();
         BlockPos var6 = var4?p_176475_2_.func_177977_b():p_176475_2_;
         Object var7 = var4?this:p_176475_1_.func_180495_p(var5).func_177230_c();
         Object var8 = var4?p_176475_1_.func_180495_p(var6).func_177230_c():this;
         if(var7 == this) {
            p_176475_1_.func_180501_a(var5, Blocks.field_150350_a.func_176223_P(), 3);
         }

         if(var8 == this) {
            p_176475_1_.func_180501_a(var6, Blocks.field_150350_a.func_176223_P(), 3);
            if(!var4) {
               this.func_176226_b(p_176475_1_, var6, p_176475_3_, 0);
            }
         }

      }
   }

   public boolean func_180671_f(World p_180671_1_, BlockPos p_180671_2_, IBlockState p_180671_3_) {
      if(p_180671_3_.func_177229_b(field_176492_b) == BlockDoublePlant.EnumBlockHalf.UPPER) {
         return p_180671_1_.func_180495_p(p_180671_2_.func_177977_b()).func_177230_c() == this;
      } else {
         IBlockState var4 = p_180671_1_.func_180495_p(p_180671_2_.func_177984_a());
         return var4.func_177230_c() == this && super.func_180671_f(p_180671_1_, p_180671_2_, var4);
      }
   }

   public Item func_180660_a(IBlockState p_180660_1_, Random p_180660_2_, int p_180660_3_) {
      if(p_180660_1_.func_177229_b(field_176492_b) == BlockDoublePlant.EnumBlockHalf.UPPER) {
         return null;
      } else {
         BlockDoublePlant.EnumPlantType var4 = (BlockDoublePlant.EnumPlantType)p_180660_1_.func_177229_b(field_176493_a);
         return var4 == BlockDoublePlant.EnumPlantType.FERN?null:(var4 == BlockDoublePlant.EnumPlantType.GRASS?(p_180660_2_.nextInt(8) == 0?Items.field_151014_N:null):Item.func_150898_a(this));
      }
   }

   public int func_180651_a(IBlockState p_180651_1_) {
      return p_180651_1_.func_177229_b(field_176492_b) != BlockDoublePlant.EnumBlockHalf.UPPER && p_180651_1_.func_177229_b(field_176493_a) != BlockDoublePlant.EnumPlantType.GRASS?((BlockDoublePlant.EnumPlantType)p_180651_1_.func_177229_b(field_176493_a)).func_176936_a():0;
   }

   public int func_180662_a(IBlockAccess p_180662_1_, BlockPos p_180662_2_, int p_180662_3_) {
      BlockDoublePlant.EnumPlantType var4 = this.func_176490_e(p_180662_1_, p_180662_2_);
      return var4 != BlockDoublePlant.EnumPlantType.GRASS && var4 != BlockDoublePlant.EnumPlantType.FERN?16777215:BiomeColorHelper.func_180286_a(p_180662_1_, p_180662_2_);
   }

   public void func_176491_a(World p_176491_1_, BlockPos p_176491_2_, BlockDoublePlant.EnumPlantType p_176491_3_, int p_176491_4_) {
      p_176491_1_.func_180501_a(p_176491_2_, this.func_176223_P().func_177226_a(field_176492_b, BlockDoublePlant.EnumBlockHalf.LOWER).func_177226_a(field_176493_a, p_176491_3_), p_176491_4_);
      p_176491_1_.func_180501_a(p_176491_2_.func_177984_a(), this.func_176223_P().func_177226_a(field_176492_b, BlockDoublePlant.EnumBlockHalf.UPPER), p_176491_4_);
   }

   public void func_180633_a(World p_180633_1_, BlockPos p_180633_2_, IBlockState p_180633_3_, EntityLivingBase p_180633_4_, ItemStack p_180633_5_) {
      p_180633_1_.func_180501_a(p_180633_2_.func_177984_a(), this.func_176223_P().func_177226_a(field_176492_b, BlockDoublePlant.EnumBlockHalf.UPPER), 2);
   }

   public void func_180657_a(World p_180657_1_, EntityPlayer p_180657_2_, BlockPos p_180657_3_, IBlockState p_180657_4_, TileEntity p_180657_5_) {
      if(p_180657_1_.field_72995_K || p_180657_2_.func_71045_bC() == null || p_180657_2_.func_71045_bC().func_77973_b() != Items.field_151097_aZ || p_180657_4_.func_177229_b(field_176492_b) != BlockDoublePlant.EnumBlockHalf.LOWER || !this.func_176489_b(p_180657_1_, p_180657_3_, p_180657_4_, p_180657_2_)) {
         super.func_180657_a(p_180657_1_, p_180657_2_, p_180657_3_, p_180657_4_, p_180657_5_);
      }
   }

   public void func_176208_a(World p_176208_1_, BlockPos p_176208_2_, IBlockState p_176208_3_, EntityPlayer p_176208_4_) {
      if(p_176208_3_.func_177229_b(field_176492_b) == BlockDoublePlant.EnumBlockHalf.UPPER) {
         if(p_176208_1_.func_180495_p(p_176208_2_.func_177977_b()).func_177230_c() == this) {
            if(!p_176208_4_.field_71075_bZ.field_75098_d) {
               IBlockState var5 = p_176208_1_.func_180495_p(p_176208_2_.func_177977_b());
               BlockDoublePlant.EnumPlantType var6 = (BlockDoublePlant.EnumPlantType)var5.func_177229_b(field_176493_a);
               if(var6 != BlockDoublePlant.EnumPlantType.FERN && var6 != BlockDoublePlant.EnumPlantType.GRASS) {
                  p_176208_1_.func_175655_b(p_176208_2_.func_177977_b(), true);
               } else if(!p_176208_1_.field_72995_K) {
                  if(p_176208_4_.func_71045_bC() != null && p_176208_4_.func_71045_bC().func_77973_b() == Items.field_151097_aZ) {
                     this.func_176489_b(p_176208_1_, p_176208_2_, var5, p_176208_4_);
                     p_176208_1_.func_175698_g(p_176208_2_.func_177977_b());
                  } else {
                     p_176208_1_.func_175655_b(p_176208_2_.func_177977_b(), true);
                  }
               } else {
                  p_176208_1_.func_175698_g(p_176208_2_.func_177977_b());
               }
            } else {
               p_176208_1_.func_175698_g(p_176208_2_.func_177977_b());
            }
         }
      } else if(p_176208_4_.field_71075_bZ.field_75098_d && p_176208_1_.func_180495_p(p_176208_2_.func_177984_a()).func_177230_c() == this) {
         p_176208_1_.func_180501_a(p_176208_2_.func_177984_a(), Blocks.field_150350_a.func_176223_P(), 2);
      }

      super.func_176208_a(p_176208_1_, p_176208_2_, p_176208_3_, p_176208_4_);
   }

   private boolean func_176489_b(World p_176489_1_, BlockPos p_176489_2_, IBlockState p_176489_3_, EntityPlayer p_176489_4_) {
      BlockDoublePlant.EnumPlantType var5 = (BlockDoublePlant.EnumPlantType)p_176489_3_.func_177229_b(field_176493_a);
      if(var5 != BlockDoublePlant.EnumPlantType.FERN && var5 != BlockDoublePlant.EnumPlantType.GRASS) {
         return false;
      } else {
         p_176489_4_.func_71029_a(StatList.field_75934_C[Block.func_149682_b(this)]);
         int var6 = (var5 == BlockDoublePlant.EnumPlantType.GRASS?BlockTallGrass.EnumType.GRASS:BlockTallGrass.EnumType.FERN).func_177044_a();
         func_180635_a(p_176489_1_, p_176489_2_, new ItemStack(Blocks.field_150329_H, 2, var6));
         return true;
      }
   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      BlockDoublePlant.EnumPlantType[] var4 = BlockDoublePlant.EnumPlantType.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         BlockDoublePlant.EnumPlantType var7 = var4[var6];
         p_149666_3_.add(new ItemStack(p_149666_1_, 1, var7.func_176936_a()));
      }

   }

   public int func_176222_j(World p_176222_1_, BlockPos p_176222_2_) {
      return this.func_176490_e(p_176222_1_, p_176222_2_).func_176936_a();
   }

   public boolean func_176473_a(World p_176473_1_, BlockPos p_176473_2_, IBlockState p_176473_3_, boolean p_176473_4_) {
      BlockDoublePlant.EnumPlantType var5 = this.func_176490_e(p_176473_1_, p_176473_2_);
      return var5 != BlockDoublePlant.EnumPlantType.GRASS && var5 != BlockDoublePlant.EnumPlantType.FERN;
   }

   public boolean func_180670_a(World p_180670_1_, Random p_180670_2_, BlockPos p_180670_3_, IBlockState p_180670_4_) {
      return true;
   }

   public void func_176474_b(World p_176474_1_, Random p_176474_2_, BlockPos p_176474_3_, IBlockState p_176474_4_) {
      func_180635_a(p_176474_1_, p_176474_3_, new ItemStack(this, 1, this.func_176490_e(p_176474_1_, p_176474_3_).func_176936_a()));
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return (p_176203_1_ & 8) > 0?this.func_176223_P().func_177226_a(field_176492_b, BlockDoublePlant.EnumBlockHalf.UPPER):this.func_176223_P().func_177226_a(field_176492_b, BlockDoublePlant.EnumBlockHalf.LOWER).func_177226_a(field_176493_a, BlockDoublePlant.EnumPlantType.func_176938_a(p_176203_1_ & 7));
   }

   public IBlockState func_176221_a(IBlockState p_176221_1_, IBlockAccess p_176221_2_, BlockPos p_176221_3_) {
      if(p_176221_1_.func_177229_b(field_176492_b) == BlockDoublePlant.EnumBlockHalf.UPPER) {
         IBlockState var4 = p_176221_2_.func_180495_p(p_176221_3_.func_177977_b());
         if(var4.func_177230_c() == this) {
            p_176221_1_ = p_176221_1_.func_177226_a(field_176493_a, var4.func_177229_b(field_176493_a));
         }
      }

      return p_176221_1_;
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return p_176201_1_.func_177229_b(field_176492_b) == BlockDoublePlant.EnumBlockHalf.UPPER?8:((BlockDoublePlant.EnumPlantType)p_176201_1_.func_177229_b(field_176493_a)).func_176936_a();
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176492_b, field_176493_a});
   }

   public Block.EnumOffsetType func_176218_Q() {
      return Block.EnumOffsetType.XZ;
   }


   static enum EnumBlockHalf implements IStringSerializable {

      UPPER("UPPER", 0),
      LOWER("LOWER", 1);
      // $FF: synthetic field
      private static final BlockDoublePlant.EnumBlockHalf[] $VALUES = new BlockDoublePlant.EnumBlockHalf[]{UPPER, LOWER};
      private static final String __OBFID = "CL_00002122";


      private EnumBlockHalf(String p_i45724_1_, int p_i45724_2_) {}

      public String toString() {
         return this.func_176610_l();
      }

      public String func_176610_l() {
         return this == UPPER?"upper":"lower";
      }

   }

   public static enum EnumPlantType implements IStringSerializable {

      SUNFLOWER("SUNFLOWER", 0, 0, "sunflower"),
      SYRINGA("SYRINGA", 1, 1, "syringa"),
      GRASS("GRASS", 2, 2, "double_grass", "grass"),
      FERN("FERN", 3, 3, "double_fern", "fern"),
      ROSE("ROSE", 4, 4, "double_rose", "rose"),
      PAEONIA("PAEONIA", 5, 5, "paeonia");
      private static final BlockDoublePlant.EnumPlantType[] field_176941_g = new BlockDoublePlant.EnumPlantType[values().length];
      private final int field_176949_h;
      private final String field_176950_i;
      private final String field_176947_j;
      // $FF: synthetic field
      private static final BlockDoublePlant.EnumPlantType[] $VALUES = new BlockDoublePlant.EnumPlantType[]{SUNFLOWER, SYRINGA, GRASS, FERN, ROSE, PAEONIA};
      private static final String __OBFID = "CL_00002121";


      private EnumPlantType(String p_i45722_1_, int p_i45722_2_, int p_i45722_3_, String p_i45722_4_) {
         this(p_i45722_1_, p_i45722_2_, p_i45722_3_, p_i45722_4_, p_i45722_4_);
      }

      private EnumPlantType(String p_i45723_1_, int p_i45723_2_, int p_i45723_3_, String p_i45723_4_, String p_i45723_5_) {
         this.field_176949_h = p_i45723_3_;
         this.field_176950_i = p_i45723_4_;
         this.field_176947_j = p_i45723_5_;
      }

      public int func_176936_a() {
         return this.field_176949_h;
      }

      public String toString() {
         return this.field_176950_i;
      }

      public static BlockDoublePlant.EnumPlantType func_176938_a(int p_176938_0_) {
         if(p_176938_0_ < 0 || p_176938_0_ >= field_176941_g.length) {
            p_176938_0_ = 0;
         }

         return field_176941_g[p_176938_0_];
      }

      public String func_176610_l() {
         return this.field_176950_i;
      }

      public String func_176939_c() {
         return this.field_176947_j;
      }

      static {
         BlockDoublePlant.EnumPlantType[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            BlockDoublePlant.EnumPlantType var3 = var0[var2];
            field_176941_g[var3.func_176936_a()] = var3;
         }

      }
   }
}
