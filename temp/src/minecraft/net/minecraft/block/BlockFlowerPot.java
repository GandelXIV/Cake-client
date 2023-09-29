package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFlowerPot extends BlockContainer {

   public static final PropertyInteger field_176444_a = PropertyInteger.func_177719_a("legacy_data", 0, 15);
   public static final PropertyEnum field_176443_b = PropertyEnum.func_177709_a("contents", BlockFlowerPot.EnumFlowerType.class);
   private static final String __OBFID = "CL_00000247";


   public BlockFlowerPot() {
      super(Material.field_151594_q);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176443_b, BlockFlowerPot.EnumFlowerType.EMPTY).func_177226_a(field_176444_a, Integer.valueOf(0)));
      this.func_149683_g();
   }

   public void func_149683_g() {
      float var1 = 0.375F;
      float var2 = var1 / 2.0F;
      this.func_149676_a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, var1, 0.5F + var2);
   }

   public boolean func_149662_c() {
      return false;
   }

   public int func_149645_b() {
      return 3;
   }

   public boolean func_149686_d() {
      return false;
   }

   public int func_180662_a(IBlockAccess p_180662_1_, BlockPos p_180662_2_, int p_180662_3_) {
      TileEntity var4 = p_180662_1_.func_175625_s(p_180662_2_);
      if(var4 instanceof TileEntityFlowerPot) {
         Item var5 = ((TileEntityFlowerPot)var4).func_145965_a();
         if(var5 instanceof ItemBlock) {
            return Block.func_149634_a(var5).func_180662_a(p_180662_1_, p_180662_2_, p_180662_3_);
         }
      }

      return 16777215;
   }

   public boolean func_180639_a(World p_180639_1_, BlockPos p_180639_2_, IBlockState p_180639_3_, EntityPlayer p_180639_4_, EnumFacing p_180639_5_, float p_180639_6_, float p_180639_7_, float p_180639_8_) {
      ItemStack var9 = p_180639_4_.field_71071_by.func_70448_g();
      if(var9 != null && var9.func_77973_b() instanceof ItemBlock) {
         TileEntityFlowerPot var10 = this.func_176442_d(p_180639_1_, p_180639_2_);
         if(var10 == null) {
            return false;
         } else if(var10.func_145965_a() != null) {
            return false;
         } else {
            Block var11 = Block.func_149634_a(var9.func_77973_b());
            if(!this.func_149928_a(var11, var9.func_77960_j())) {
               return false;
            } else {
               var10.func_145964_a(var9.func_77973_b(), var9.func_77960_j());
               var10.func_70296_d();
               p_180639_1_.func_175689_h(p_180639_2_);
               if(!p_180639_4_.field_71075_bZ.field_75098_d && --var9.field_77994_a <= 0) {
                  p_180639_4_.field_71071_by.func_70299_a(p_180639_4_.field_71071_by.field_70461_c, (ItemStack)null);
               }

               return true;
            }
         }
      } else {
         return false;
      }
   }

   private boolean func_149928_a(Block p_149928_1_, int p_149928_2_) {
      return p_149928_1_ != Blocks.field_150327_N && p_149928_1_ != Blocks.field_150328_O && p_149928_1_ != Blocks.field_150434_aF && p_149928_1_ != Blocks.field_150338_P && p_149928_1_ != Blocks.field_150337_Q && p_149928_1_ != Blocks.field_150345_g && p_149928_1_ != Blocks.field_150330_I?p_149928_1_ == Blocks.field_150329_H && p_149928_2_ == BlockTallGrass.EnumType.FERN.func_177044_a():true;
   }

   public Item func_180665_b(World p_180665_1_, BlockPos p_180665_2_) {
      TileEntityFlowerPot var3 = this.func_176442_d(p_180665_1_, p_180665_2_);
      return var3 != null && var3.func_145965_a() != null?var3.func_145965_a():Items.field_151162_bE;
   }

   public int func_176222_j(World p_176222_1_, BlockPos p_176222_2_) {
      TileEntityFlowerPot var3 = this.func_176442_d(p_176222_1_, p_176222_2_);
      return var3 != null && var3.func_145965_a() != null?var3.func_145966_b():0;
   }

   public boolean func_149648_K() {
      return true;
   }

   public boolean func_176196_c(World p_176196_1_, BlockPos p_176196_2_) {
      return super.func_176196_c(p_176196_1_, p_176196_2_) && World.func_175683_a(p_176196_1_, p_176196_2_.func_177977_b());
   }

   public void func_176204_a(World p_176204_1_, BlockPos p_176204_2_, IBlockState p_176204_3_, Block p_176204_4_) {
      if(!World.func_175683_a(p_176204_1_, p_176204_2_.func_177977_b())) {
         this.func_176226_b(p_176204_1_, p_176204_2_, p_176204_3_, 0);
         p_176204_1_.func_175698_g(p_176204_2_);
      }

   }

   public void func_180663_b(World p_180663_1_, BlockPos p_180663_2_, IBlockState p_180663_3_) {
      TileEntityFlowerPot var4 = this.func_176442_d(p_180663_1_, p_180663_2_);
      if(var4 != null && var4.func_145965_a() != null) {
         func_180635_a(p_180663_1_, p_180663_2_, new ItemStack(var4.func_145965_a(), 1, var4.func_145966_b()));
      }

      super.func_180663_b(p_180663_1_, p_180663_2_, p_180663_3_);
   }

   public void func_176208_a(World p_176208_1_, BlockPos p_176208_2_, IBlockState p_176208_3_, EntityPlayer p_176208_4_) {
      super.func_176208_a(p_176208_1_, p_176208_2_, p_176208_3_, p_176208_4_);
      if(p_176208_4_.field_71075_bZ.field_75098_d) {
         TileEntityFlowerPot var5 = this.func_176442_d(p_176208_1_, p_176208_2_);
         if(var5 != null) {
            var5.func_145964_a((Item)null, 0);
         }
      }

   }

   public Item func_180660_a(IBlockState p_180660_1_, Random p_180660_2_, int p_180660_3_) {
      return Items.field_151162_bE;
   }

   private TileEntityFlowerPot func_176442_d(World p_176442_1_, BlockPos p_176442_2_) {
      TileEntity var3 = p_176442_1_.func_175625_s(p_176442_2_);
      return var3 instanceof TileEntityFlowerPot?(TileEntityFlowerPot)var3:null;
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      Object var3 = null;
      int var4 = 0;
      switch(p_149915_2_) {
      case 1:
         var3 = Blocks.field_150328_O;
         var4 = BlockFlower.EnumFlowerType.POPPY.func_176968_b();
         break;
      case 2:
         var3 = Blocks.field_150327_N;
         break;
      case 3:
         var3 = Blocks.field_150345_g;
         var4 = BlockPlanks.EnumType.OAK.func_176839_a();
         break;
      case 4:
         var3 = Blocks.field_150345_g;
         var4 = BlockPlanks.EnumType.SPRUCE.func_176839_a();
         break;
      case 5:
         var3 = Blocks.field_150345_g;
         var4 = BlockPlanks.EnumType.BIRCH.func_176839_a();
         break;
      case 6:
         var3 = Blocks.field_150345_g;
         var4 = BlockPlanks.EnumType.JUNGLE.func_176839_a();
         break;
      case 7:
         var3 = Blocks.field_150337_Q;
         break;
      case 8:
         var3 = Blocks.field_150338_P;
         break;
      case 9:
         var3 = Blocks.field_150434_aF;
         break;
      case 10:
         var3 = Blocks.field_150330_I;
         break;
      case 11:
         var3 = Blocks.field_150329_H;
         var4 = BlockTallGrass.EnumType.FERN.func_177044_a();
         break;
      case 12:
         var3 = Blocks.field_150345_g;
         var4 = BlockPlanks.EnumType.ACACIA.func_176839_a();
         break;
      case 13:
         var3 = Blocks.field_150345_g;
         var4 = BlockPlanks.EnumType.DARK_OAK.func_176839_a();
      }

      return new TileEntityFlowerPot(Item.func_150898_a((Block)var3), var4);
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176443_b, field_176444_a});
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((Integer)p_176201_1_.func_177229_b(field_176444_a)).intValue();
   }

   public IBlockState func_176221_a(IBlockState p_176221_1_, IBlockAccess p_176221_2_, BlockPos p_176221_3_) {
      BlockFlowerPot.EnumFlowerType var4 = BlockFlowerPot.EnumFlowerType.EMPTY;
      TileEntity var5 = p_176221_2_.func_175625_s(p_176221_3_);
      if(var5 instanceof TileEntityFlowerPot) {
         TileEntityFlowerPot var6 = (TileEntityFlowerPot)var5;
         Item var7 = var6.func_145965_a();
         if(var7 instanceof ItemBlock) {
            int var8 = var6.func_145966_b();
            Block var9 = Block.func_149634_a(var7);
            if(var9 == Blocks.field_150345_g) {
               switch(BlockFlowerPot.SwitchEnumType.field_180353_a[BlockPlanks.EnumType.func_176837_a(var8).ordinal()]) {
               case 1:
                  var4 = BlockFlowerPot.EnumFlowerType.OAK_SAPLING;
                  break;
               case 2:
                  var4 = BlockFlowerPot.EnumFlowerType.SPRUCE_SAPLING;
                  break;
               case 3:
                  var4 = BlockFlowerPot.EnumFlowerType.BIRCH_SAPLING;
                  break;
               case 4:
                  var4 = BlockFlowerPot.EnumFlowerType.JUNGLE_SAPLING;
                  break;
               case 5:
                  var4 = BlockFlowerPot.EnumFlowerType.ACACIA_SAPLING;
                  break;
               case 6:
                  var4 = BlockFlowerPot.EnumFlowerType.DARK_OAK_SAPLING;
                  break;
               default:
                  var4 = BlockFlowerPot.EnumFlowerType.EMPTY;
               }
            } else if(var9 == Blocks.field_150329_H) {
               switch(var8) {
               case 0:
                  var4 = BlockFlowerPot.EnumFlowerType.DEAD_BUSH;
                  break;
               case 2:
                  var4 = BlockFlowerPot.EnumFlowerType.FERN;
                  break;
               default:
                  var4 = BlockFlowerPot.EnumFlowerType.EMPTY;
               }
            } else if(var9 == Blocks.field_150327_N) {
               var4 = BlockFlowerPot.EnumFlowerType.DANDELION;
            } else if(var9 == Blocks.field_150328_O) {
               switch(BlockFlowerPot.SwitchEnumType.field_180352_b[BlockFlower.EnumFlowerType.func_176967_a(BlockFlower.EnumFlowerColor.RED, var8).ordinal()]) {
               case 1:
                  var4 = BlockFlowerPot.EnumFlowerType.POPPY;
                  break;
               case 2:
                  var4 = BlockFlowerPot.EnumFlowerType.BLUE_ORCHID;
                  break;
               case 3:
                  var4 = BlockFlowerPot.EnumFlowerType.ALLIUM;
                  break;
               case 4:
                  var4 = BlockFlowerPot.EnumFlowerType.HOUSTONIA;
                  break;
               case 5:
                  var4 = BlockFlowerPot.EnumFlowerType.RED_TULIP;
                  break;
               case 6:
                  var4 = BlockFlowerPot.EnumFlowerType.ORANGE_TULIP;
                  break;
               case 7:
                  var4 = BlockFlowerPot.EnumFlowerType.WHITE_TULIP;
                  break;
               case 8:
                  var4 = BlockFlowerPot.EnumFlowerType.PINK_TULIP;
                  break;
               case 9:
                  var4 = BlockFlowerPot.EnumFlowerType.OXEYE_DAISY;
                  break;
               default:
                  var4 = BlockFlowerPot.EnumFlowerType.EMPTY;
               }
            } else if(var9 == Blocks.field_150337_Q) {
               var4 = BlockFlowerPot.EnumFlowerType.MUSHROOM_RED;
            } else if(var9 == Blocks.field_150338_P) {
               var4 = BlockFlowerPot.EnumFlowerType.MUSHROOM_BROWN;
            } else if(var9 == Blocks.field_150330_I) {
               var4 = BlockFlowerPot.EnumFlowerType.DEAD_BUSH;
            } else if(var9 == Blocks.field_150434_aF) {
               var4 = BlockFlowerPot.EnumFlowerType.CACTUS;
            }
         }
      }

      return p_176221_1_.func_177226_a(field_176443_b, var4);
   }

   public EnumWorldBlockLayer func_180664_k() {
      return EnumWorldBlockLayer.CUTOUT;
   }


   public static enum EnumFlowerType implements IStringSerializable {

      EMPTY("EMPTY", 0, "empty"),
      POPPY("POPPY", 1, "rose"),
      BLUE_ORCHID("BLUE_ORCHID", 2, "blue_orchid"),
      ALLIUM("ALLIUM", 3, "allium"),
      HOUSTONIA("HOUSTONIA", 4, "houstonia"),
      RED_TULIP("RED_TULIP", 5, "red_tulip"),
      ORANGE_TULIP("ORANGE_TULIP", 6, "orange_tulip"),
      WHITE_TULIP("WHITE_TULIP", 7, "white_tulip"),
      PINK_TULIP("PINK_TULIP", 8, "pink_tulip"),
      OXEYE_DAISY("OXEYE_DAISY", 9, "oxeye_daisy"),
      DANDELION("DANDELION", 10, "dandelion"),
      OAK_SAPLING("OAK_SAPLING", 11, "oak_sapling"),
      SPRUCE_SAPLING("SPRUCE_SAPLING", 12, "spruce_sapling"),
      BIRCH_SAPLING("BIRCH_SAPLING", 13, "birch_sapling"),
      JUNGLE_SAPLING("JUNGLE_SAPLING", 14, "jungle_sapling"),
      ACACIA_SAPLING("ACACIA_SAPLING", 15, "acacia_sapling"),
      DARK_OAK_SAPLING("DARK_OAK_SAPLING", 16, "dark_oak_sapling"),
      MUSHROOM_RED("MUSHROOM_RED", 17, "mushroom_red"),
      MUSHROOM_BROWN("MUSHROOM_BROWN", 18, "mushroom_brown"),
      DEAD_BUSH("DEAD_BUSH", 19, "dead_bush"),
      FERN("FERN", 20, "fern"),
      CACTUS("CACTUS", 21, "cactus");
      private final String field_177006_w;
      // $FF: synthetic field
      private static final BlockFlowerPot.EnumFlowerType[] $VALUES = new BlockFlowerPot.EnumFlowerType[]{EMPTY, POPPY, BLUE_ORCHID, ALLIUM, HOUSTONIA, RED_TULIP, ORANGE_TULIP, WHITE_TULIP, PINK_TULIP, OXEYE_DAISY, DANDELION, OAK_SAPLING, SPRUCE_SAPLING, BIRCH_SAPLING, JUNGLE_SAPLING, ACACIA_SAPLING, DARK_OAK_SAPLING, MUSHROOM_RED, MUSHROOM_BROWN, DEAD_BUSH, FERN, CACTUS};
      private static final String __OBFID = "CL_00002115";


      private EnumFlowerType(String p_i45715_1_, int p_i45715_2_, String p_i45715_3_) {
         this.field_177006_w = p_i45715_3_;
      }

      public String toString() {
         return this.field_177006_w;
      }

      public String func_176610_l() {
         return this.field_177006_w;
      }

   }

   // $FF: synthetic class
   static final class SwitchEnumType {

      // $FF: synthetic field
      static final int[] field_180353_a;
      // $FF: synthetic field
      static final int[] field_180352_b = new int[BlockFlower.EnumFlowerType.values().length];
      private static final String __OBFID = "CL_00002116";


      static {
         try {
            field_180352_b[BlockFlower.EnumFlowerType.POPPY.ordinal()] = 1;
         } catch (NoSuchFieldError var15) {
            ;
         }

         try {
            field_180352_b[BlockFlower.EnumFlowerType.BLUE_ORCHID.ordinal()] = 2;
         } catch (NoSuchFieldError var14) {
            ;
         }

         try {
            field_180352_b[BlockFlower.EnumFlowerType.ALLIUM.ordinal()] = 3;
         } catch (NoSuchFieldError var13) {
            ;
         }

         try {
            field_180352_b[BlockFlower.EnumFlowerType.HOUSTONIA.ordinal()] = 4;
         } catch (NoSuchFieldError var12) {
            ;
         }

         try {
            field_180352_b[BlockFlower.EnumFlowerType.RED_TULIP.ordinal()] = 5;
         } catch (NoSuchFieldError var11) {
            ;
         }

         try {
            field_180352_b[BlockFlower.EnumFlowerType.ORANGE_TULIP.ordinal()] = 6;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            field_180352_b[BlockFlower.EnumFlowerType.WHITE_TULIP.ordinal()] = 7;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            field_180352_b[BlockFlower.EnumFlowerType.PINK_TULIP.ordinal()] = 8;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            field_180352_b[BlockFlower.EnumFlowerType.OXEYE_DAISY.ordinal()] = 9;
         } catch (NoSuchFieldError var7) {
            ;
         }

         field_180353_a = new int[BlockPlanks.EnumType.values().length];

         try {
            field_180353_a[BlockPlanks.EnumType.OAK.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            field_180353_a[BlockPlanks.EnumType.SPRUCE.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            field_180353_a[BlockPlanks.EnumType.BIRCH.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_180353_a[BlockPlanks.EnumType.JUNGLE.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_180353_a[BlockPlanks.EnumType.ACACIA.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_180353_a[BlockPlanks.EnumType.DARK_OAK.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
