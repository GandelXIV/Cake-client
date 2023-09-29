package net.minecraft.block;

import com.google.common.base.Predicate;
import java.util.List;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlockNewLog extends BlockLog {

   public static final PropertyEnum field_176300_b = PropertyEnum.func_177708_a("variant", BlockPlanks.EnumType.class, new Predicate() {

      private static final String __OBFID = "CL_00002089";

      public boolean func_180194_a(BlockPlanks.EnumType p_180194_1_) {
         return p_180194_1_.func_176839_a() >= 4;
      }
      // $FF: synthetic method
      public boolean apply(Object p_apply_1_) {
         return this.func_180194_a((BlockPlanks.EnumType)p_apply_1_);
      }
   });
   private static final String __OBFID = "CL_00000277";


   public BlockNewLog() {
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176300_b, BlockPlanks.EnumType.ACACIA).func_177226_a(field_176299_a, BlockLog.EnumAxis.Y));
   }

   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
      p_149666_3_.add(new ItemStack(p_149666_1_, 1, BlockPlanks.EnumType.ACACIA.func_176839_a() - 4));
      p_149666_3_.add(new ItemStack(p_149666_1_, 1, BlockPlanks.EnumType.DARK_OAK.func_176839_a() - 4));
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      IBlockState var2 = this.func_176223_P().func_177226_a(field_176300_b, BlockPlanks.EnumType.func_176837_a((p_176203_1_ & 3) + 4));
      switch(p_176203_1_ & 12) {
      case 0:
         var2 = var2.func_177226_a(field_176299_a, BlockLog.EnumAxis.Y);
         break;
      case 4:
         var2 = var2.func_177226_a(field_176299_a, BlockLog.EnumAxis.X);
         break;
      case 8:
         var2 = var2.func_177226_a(field_176299_a, BlockLog.EnumAxis.Z);
         break;
      default:
         var2 = var2.func_177226_a(field_176299_a, BlockLog.EnumAxis.NONE);
      }

      return var2;
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      byte var2 = 0;
      int var3 = var2 | ((BlockPlanks.EnumType)p_176201_1_.func_177229_b(field_176300_b)).func_176839_a() - 4;
      switch(BlockNewLog.SwitchEnumAxis.field_180191_a[((BlockLog.EnumAxis)p_176201_1_.func_177229_b(field_176299_a)).ordinal()]) {
      case 1:
         var3 |= 4;
         break;
      case 2:
         var3 |= 8;
         break;
      case 3:
         var3 |= 12;
      }

      return var3;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176300_b, field_176299_a});
   }

   protected ItemStack func_180643_i(IBlockState p_180643_1_) {
      return new ItemStack(Item.func_150898_a(this), 1, ((BlockPlanks.EnumType)p_180643_1_.func_177229_b(field_176300_b)).func_176839_a() - 4);
   }

   public int func_180651_a(IBlockState p_180651_1_) {
      return ((BlockPlanks.EnumType)p_180651_1_.func_177229_b(field_176300_b)).func_176839_a() - 4;
   }


   // $FF: synthetic class
   static final class SwitchEnumAxis {

      // $FF: synthetic field
      static final int[] field_180191_a = new int[BlockLog.EnumAxis.values().length];
      private static final String __OBFID = "CL_00002088";


      static {
         try {
            field_180191_a[BlockLog.EnumAxis.X.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_180191_a[BlockLog.EnumAxis.Z.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_180191_a[BlockLog.EnumAxis.NONE.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
