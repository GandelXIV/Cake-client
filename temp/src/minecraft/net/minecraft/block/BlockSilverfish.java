package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;

public class BlockSilverfish extends Block {

   public static final PropertyEnum field_176378_a = PropertyEnum.func_177709_a("variant", BlockSilverfish.EnumType.class);
   private static final String __OBFID = "CL_00000271";


   public BlockSilverfish() {
      super(Material.field_151571_B);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176378_a, BlockSilverfish.EnumType.STONE));
      this.func_149711_c(0.0F);
      this.func_149647_a(CreativeTabs.field_78031_c);
   }

   public int func_149745_a(Random p_149745_1_) {
      return 0;
   }

   public static boolean func_176377_d(IBlockState p_176377_0_) {
      Block var1 = p_176377_0_.func_177230_c();
      return p_176377_0_ == Blocks.field_150348_b.func_176223_P().func_177226_a(BlockStone.field_176247_a, BlockStone.EnumType.STONE) || var1 == Blocks.field_150347_e || var1 == Blocks.field_150417_aV;
   }

   protected ItemStack func_180643_i(IBlockState p_180643_1_) {
      switch(BlockSilverfish.SwitchEnumType.field_180178_a[((BlockSilverfish.EnumType)p_180643_1_.func_177229_b(field_176378_a)).ordinal()]) {
      case 1:
         return new ItemStack(Blocks.field_150347_e);
      case 2:
         return new ItemStack(Blocks.field_150417_aV);
      case 3:
         return new ItemStack(Blocks.field_150417_aV, 1, BlockStoneBrick.EnumType.MOSSY.func_176612_a());
      case 4:
         return new ItemStack(Blocks.field_150417_aV, 1, BlockStoneBrick.EnumType.CRACKED.func_176612_a());
      case 5:
         return new ItemStack(Blocks.field_150417_aV, 1, BlockStoneBrick.EnumType.CHISELED.func_176612_a());
      default:
         return new ItemStack(Blocks.field_150348_b);
      }
   }

   public void func_180653_a(World p_180653_1_, BlockPos p_180653_2_, IBlockState p_180653_3_, float p_180653_4_, int p_180653_5_) {
      if(!p_180653_1_.field_72995_K && p_180653_1_.func_82736_K().func_82766_b("doTileDrops")) {
         EntitySilverfish var6 = new EntitySilverfish(p_180653_1_);
         var6.func_70012_b((double)p_180653_2_.func_177958_n() + 0.5D, (double)p_180653_2_.func_177956_o(), (double)p_180653_2_.func_177952_p() + 0.5D, 0.0F, 0.0F);
         p_180653_1_.func_72838_d(var6);
         var6.func_70656_aK();
      }

   }

   public int func_176222_j(World p_176222_1_, BlockPos p_176222_2_) {
      IBlockState var3 = p_176222_1_.func_180495_p(p_176222_2_);
      return var3.func_177230_c().func_176201_c(var3);
   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      BlockSilverfish.EnumType[] var4 = BlockSilverfish.EnumType.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         BlockSilverfish.EnumType var7 = var4[var6];
         p_149666_3_.add(new ItemStack(p_149666_1_, 1, var7.func_176881_a()));
      }

   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176378_a, BlockSilverfish.EnumType.func_176879_a(p_176203_1_));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((BlockSilverfish.EnumType)p_176201_1_.func_177229_b(field_176378_a)).func_176881_a();
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176378_a});
   }


   public static enum EnumType implements IStringSerializable {

      STONE("STONE", 0, 0, "stone", (BlockSilverfish.SwitchEnumType)null) {

         private static final String __OBFID = "CL_00002097";

         public IBlockState func_176883_d() {
            return Blocks.field_150348_b.func_176223_P().func_177226_a(BlockStone.field_176247_a, BlockStone.EnumType.STONE);
         }
      },
      COBBLESTONE("COBBLESTONE", 1, 1, "cobblestone", "cobble", (BlockSilverfish.SwitchEnumType)null) {

         private static final String __OBFID = "CL_00002096";

         public IBlockState func_176883_d() {
            return Blocks.field_150347_e.func_176223_P();
         }
      },
      STONEBRICK("STONEBRICK", 2, 2, "stone_brick", "brick", (BlockSilverfish.SwitchEnumType)null) {

         private static final String __OBFID = "CL_00002095";

         public IBlockState func_176883_d() {
            return Blocks.field_150417_aV.func_176223_P().func_177226_a(BlockStoneBrick.field_176249_a, BlockStoneBrick.EnumType.DEFAULT);
         }
      },
      MOSSY_STONEBRICK("MOSSY_STONEBRICK", 3, 3, "mossy_brick", "mossybrick", (BlockSilverfish.SwitchEnumType)null) {

         private static final String __OBFID = "CL_00002094";

         public IBlockState func_176883_d() {
            return Blocks.field_150417_aV.func_176223_P().func_177226_a(BlockStoneBrick.field_176249_a, BlockStoneBrick.EnumType.MOSSY);
         }
      },
      CRACKED_STONEBRICK("CRACKED_STONEBRICK", 4, 4, "cracked_brick", "crackedbrick", (BlockSilverfish.SwitchEnumType)null) {

         private static final String __OBFID = "CL_00002093";

         public IBlockState func_176883_d() {
            return Blocks.field_150417_aV.func_176223_P().func_177226_a(BlockStoneBrick.field_176249_a, BlockStoneBrick.EnumType.CRACKED);
         }
      },
      CHISELED_STONEBRICK("CHISELED_STONEBRICK", 5, 5, "chiseled_brick", "chiseledbrick", (BlockSilverfish.SwitchEnumType)null) {

         private static final String __OBFID = "CL_00002092";

         public IBlockState func_176883_d() {
            return Blocks.field_150417_aV.func_176223_P().func_177226_a(BlockStoneBrick.field_176249_a, BlockStoneBrick.EnumType.CHISELED);
         }
      };
      private static final BlockSilverfish.EnumType[] field_176885_g = new BlockSilverfish.EnumType[values().length];
      private final int field_176893_h;
      private final String field_176894_i;
      private final String field_176891_j;
      // $FF: synthetic field
      private static final BlockSilverfish.EnumType[] $VALUES = new BlockSilverfish.EnumType[]{STONE, COBBLESTONE, STONEBRICK, MOSSY_STONEBRICK, CRACKED_STONEBRICK, CHISELED_STONEBRICK};
      private static final String __OBFID = "CL_00002098";


      private EnumType(String p_i45704_1_, int p_i45704_2_, int p_i45704_3_, String p_i45704_4_) {
         this(p_i45704_1_, p_i45704_2_, p_i45704_3_, p_i45704_4_, p_i45704_4_);
      }

      private EnumType(String p_i45705_1_, int p_i45705_2_, int p_i45705_3_, String p_i45705_4_, String p_i45705_5_) {
         this.field_176893_h = p_i45705_3_;
         this.field_176894_i = p_i45705_4_;
         this.field_176891_j = p_i45705_5_;
      }

      public int func_176881_a() {
         return this.field_176893_h;
      }

      public String toString() {
         return this.field_176894_i;
      }

      public static BlockSilverfish.EnumType func_176879_a(int p_176879_0_) {
         if(p_176879_0_ < 0 || p_176879_0_ >= field_176885_g.length) {
            p_176879_0_ = 0;
         }

         return field_176885_g[p_176879_0_];
      }

      public String func_176610_l() {
         return this.field_176894_i;
      }

      public String func_176882_c() {
         return this.field_176891_j;
      }

      public abstract IBlockState func_176883_d();

      public static BlockSilverfish.EnumType func_176878_a(IBlockState p_176878_0_) {
         BlockSilverfish.EnumType[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            BlockSilverfish.EnumType var4 = var1[var3];
            if(p_176878_0_ == var4.func_176883_d()) {
               return var4;
            }
         }

         return STONE;
      }

      // $FF: synthetic method
      EnumType(String p_i45706_1_, int p_i45706_2_, int p_i45706_3_, String p_i45706_4_, BlockSilverfish.SwitchEnumType p_i45706_5_) {
         this(p_i45706_1_, p_i45706_2_, p_i45706_3_, p_i45706_4_);
      }

      // $FF: synthetic method
      EnumType(String p_i45707_1_, int p_i45707_2_, int p_i45707_3_, String p_i45707_4_, String p_i45707_5_, BlockSilverfish.SwitchEnumType p_i45707_6_) {
         this(p_i45707_1_, p_i45707_2_, p_i45707_3_, p_i45707_4_, p_i45707_5_);
      }

      static {
         BlockSilverfish.EnumType[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            BlockSilverfish.EnumType var3 = var0[var2];
            field_176885_g[var3.func_176881_a()] = var3;
         }

      }
   }

   // $FF: synthetic class
   static final class SwitchEnumType {

      // $FF: synthetic field
      static final int[] field_180178_a = new int[BlockSilverfish.EnumType.values().length];
      private static final String __OBFID = "CL_00002099";


      static {
         try {
            field_180178_a[BlockSilverfish.EnumType.COBBLESTONE.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            field_180178_a[BlockSilverfish.EnumType.STONEBRICK.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_180178_a[BlockSilverfish.EnumType.MOSSY_STONEBRICK.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_180178_a[BlockSilverfish.EnumType.CRACKED_STONEBRICK.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_180178_a[BlockSilverfish.EnumType.CHISELED_STONEBRICK.ordinal()] = 5;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
