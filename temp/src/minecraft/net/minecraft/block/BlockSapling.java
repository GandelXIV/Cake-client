package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockSapling extends BlockBush implements IGrowable {

   public static final PropertyEnum field_176480_a = PropertyEnum.func_177709_a("type", BlockPlanks.EnumType.class);
   public static final PropertyInteger field_176479_b = PropertyInteger.func_177719_a("stage", 0, 1);
   private static final String __OBFID = "CL_00000305";


   protected BlockSapling() {
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176480_a, BlockPlanks.EnumType.OAK).func_177226_a(field_176479_b, Integer.valueOf(0)));
      float var1 = 0.4F;
      this.func_149676_a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var1 * 2.0F, 0.5F + var1);
      this.func_149647_a(CreativeTabs.field_78031_c);
   }

   public void func_180650_b(World p_180650_1_, BlockPos p_180650_2_, IBlockState p_180650_3_, Random p_180650_4_) {
      if(!p_180650_1_.field_72995_K) {
         super.func_180650_b(p_180650_1_, p_180650_2_, p_180650_3_, p_180650_4_);
         if(p_180650_1_.func_175671_l(p_180650_2_.func_177984_a()) >= 9 && p_180650_4_.nextInt(7) == 0) {
            this.func_176478_d(p_180650_1_, p_180650_2_, p_180650_3_, p_180650_4_);
         }

      }
   }

   public void func_176478_d(World p_176478_1_, BlockPos p_176478_2_, IBlockState p_176478_3_, Random p_176478_4_) {
      if(((Integer)p_176478_3_.func_177229_b(field_176479_b)).intValue() == 0) {
         p_176478_1_.func_180501_a(p_176478_2_, p_176478_3_.func_177231_a(field_176479_b), 4);
      } else {
         this.func_176476_e(p_176478_1_, p_176478_2_, p_176478_3_, p_176478_4_);
      }

   }

   public void func_176476_e(World p_176476_1_, BlockPos p_176476_2_, IBlockState p_176476_3_, Random p_176476_4_) {
      Object var5 = p_176476_4_.nextInt(10) == 0?new WorldGenBigTree(true):new WorldGenTrees(true);
      int var6 = 0;
      int var7 = 0;
      boolean var8 = false;
      switch(BlockSapling.SwitchEnumType.field_177065_a[((BlockPlanks.EnumType)p_176476_3_.func_177229_b(field_176480_a)).ordinal()]) {
      case 1:
         label78:
         for(var6 = 0; var6 >= -1; --var6) {
            for(var7 = 0; var7 >= -1; --var7) {
               if(this.func_176477_a(p_176476_1_, p_176476_2_.func_177982_a(var6, 0, var7), BlockPlanks.EnumType.SPRUCE) && this.func_176477_a(p_176476_1_, p_176476_2_.func_177982_a(var6 + 1, 0, var7), BlockPlanks.EnumType.SPRUCE) && this.func_176477_a(p_176476_1_, p_176476_2_.func_177982_a(var6, 0, var7 + 1), BlockPlanks.EnumType.SPRUCE) && this.func_176477_a(p_176476_1_, p_176476_2_.func_177982_a(var6 + 1, 0, var7 + 1), BlockPlanks.EnumType.SPRUCE)) {
                  var5 = new WorldGenMegaPineTree(false, p_176476_4_.nextBoolean());
                  var8 = true;
                  break label78;
               }
            }
         }

         if(!var8) {
            var7 = 0;
            var6 = 0;
            var5 = new WorldGenTaiga2(true);
         }
         break;
      case 2:
         var5 = new WorldGenForest(true, false);
         break;
      case 3:
         label93:
         for(var6 = 0; var6 >= -1; --var6) {
            for(var7 = 0; var7 >= -1; --var7) {
               if(this.func_176477_a(p_176476_1_, p_176476_2_.func_177982_a(var6, 0, var7), BlockPlanks.EnumType.JUNGLE) && this.func_176477_a(p_176476_1_, p_176476_2_.func_177982_a(var6 + 1, 0, var7), BlockPlanks.EnumType.JUNGLE) && this.func_176477_a(p_176476_1_, p_176476_2_.func_177982_a(var6, 0, var7 + 1), BlockPlanks.EnumType.JUNGLE) && this.func_176477_a(p_176476_1_, p_176476_2_.func_177982_a(var6 + 1, 0, var7 + 1), BlockPlanks.EnumType.JUNGLE)) {
                  var5 = new WorldGenMegaJungle(true, 10, 20, BlockPlanks.EnumType.JUNGLE.func_176839_a(), BlockPlanks.EnumType.JUNGLE.func_176839_a());
                  var8 = true;
                  break label93;
               }
            }
         }

         if(!var8) {
            var7 = 0;
            var6 = 0;
            var5 = new WorldGenTrees(true, 4 + p_176476_4_.nextInt(7), BlockPlanks.EnumType.JUNGLE.func_176839_a(), BlockPlanks.EnumType.JUNGLE.func_176839_a(), false);
         }
         break;
      case 4:
         var5 = new WorldGenSavannaTree(true);
         break;
      case 5:
         label108:
         for(var6 = 0; var6 >= -1; --var6) {
            for(var7 = 0; var7 >= -1; --var7) {
               if(this.func_176477_a(p_176476_1_, p_176476_2_.func_177982_a(var6, 0, var7), BlockPlanks.EnumType.DARK_OAK) && this.func_176477_a(p_176476_1_, p_176476_2_.func_177982_a(var6 + 1, 0, var7), BlockPlanks.EnumType.DARK_OAK) && this.func_176477_a(p_176476_1_, p_176476_2_.func_177982_a(var6, 0, var7 + 1), BlockPlanks.EnumType.DARK_OAK) && this.func_176477_a(p_176476_1_, p_176476_2_.func_177982_a(var6 + 1, 0, var7 + 1), BlockPlanks.EnumType.DARK_OAK)) {
                  var5 = new WorldGenCanopyTree(true);
                  var8 = true;
                  break label108;
               }
            }
         }

         if(!var8) {
            return;
         }
      case 6:
      }

      IBlockState var9 = Blocks.field_150350_a.func_176223_P();
      if(var8) {
         p_176476_1_.func_180501_a(p_176476_2_.func_177982_a(var6, 0, var7), var9, 4);
         p_176476_1_.func_180501_a(p_176476_2_.func_177982_a(var6 + 1, 0, var7), var9, 4);
         p_176476_1_.func_180501_a(p_176476_2_.func_177982_a(var6, 0, var7 + 1), var9, 4);
         p_176476_1_.func_180501_a(p_176476_2_.func_177982_a(var6 + 1, 0, var7 + 1), var9, 4);
      } else {
         p_176476_1_.func_180501_a(p_176476_2_, var9, 4);
      }

      if(!((WorldGenerator)var5).func_180709_b(p_176476_1_, p_176476_4_, p_176476_2_.func_177982_a(var6, 0, var7))) {
         if(var8) {
            p_176476_1_.func_180501_a(p_176476_2_.func_177982_a(var6, 0, var7), p_176476_3_, 4);
            p_176476_1_.func_180501_a(p_176476_2_.func_177982_a(var6 + 1, 0, var7), p_176476_3_, 4);
            p_176476_1_.func_180501_a(p_176476_2_.func_177982_a(var6, 0, var7 + 1), p_176476_3_, 4);
            p_176476_1_.func_180501_a(p_176476_2_.func_177982_a(var6 + 1, 0, var7 + 1), p_176476_3_, 4);
         } else {
            p_176476_1_.func_180501_a(p_176476_2_, p_176476_3_, 4);
         }
      }

   }

   public boolean func_176477_a(World p_176477_1_, BlockPos p_176477_2_, BlockPlanks.EnumType p_176477_3_) {
      IBlockState var4 = p_176477_1_.func_180495_p(p_176477_2_);
      return var4.func_177230_c() == this && var4.func_177229_b(field_176480_a) == p_176477_3_;
   }

   public int func_180651_a(IBlockState p_180651_1_) {
      return ((BlockPlanks.EnumType)p_180651_1_.func_177229_b(field_176480_a)).func_176839_a();
   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      BlockPlanks.EnumType[] var4 = BlockPlanks.EnumType.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         BlockPlanks.EnumType var7 = var4[var6];
         p_149666_3_.add(new ItemStack(p_149666_1_, 1, var7.func_176839_a()));
      }

   }

   public boolean func_176473_a(World p_176473_1_, BlockPos p_176473_2_, IBlockState p_176473_3_, boolean p_176473_4_) {
      return true;
   }

   public boolean func_180670_a(World p_180670_1_, Random p_180670_2_, BlockPos p_180670_3_, IBlockState p_180670_4_) {
      return (double)p_180670_1_.field_73012_v.nextFloat() < 0.45D;
   }

   public void func_176474_b(World p_176474_1_, Random p_176474_2_, BlockPos p_176474_3_, IBlockState p_176474_4_) {
      this.func_176478_d(p_176474_1_, p_176474_3_, p_176474_4_, p_176474_2_);
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176480_a, BlockPlanks.EnumType.func_176837_a(p_176203_1_ & 7)).func_177226_a(field_176479_b, Integer.valueOf((p_176203_1_ & 8) >> 3));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      byte var2 = 0;
      int var3 = var2 | ((BlockPlanks.EnumType)p_176201_1_.func_177229_b(field_176480_a)).func_176839_a();
      var3 |= ((Integer)p_176201_1_.func_177229_b(field_176479_b)).intValue() << 3;
      return var3;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176480_a, field_176479_b});
   }


   // $FF: synthetic class
   static final class SwitchEnumType {

      // $FF: synthetic field
      static final int[] field_177065_a = new int[BlockPlanks.EnumType.values().length];
      private static final String __OBFID = "CL_00002067";


      static {
         try {
            field_177065_a[BlockPlanks.EnumType.SPRUCE.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            field_177065_a[BlockPlanks.EnumType.BIRCH.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            field_177065_a[BlockPlanks.EnumType.JUNGLE.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_177065_a[BlockPlanks.EnumType.ACACIA.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_177065_a[BlockPlanks.EnumType.DARK_OAK.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_177065_a[BlockPlanks.EnumType.OAK.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
