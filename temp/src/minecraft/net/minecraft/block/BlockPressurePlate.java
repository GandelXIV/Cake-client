package net.minecraft.block;

import java.util.Iterator;
import java.util.List;
import net.minecraft.block.BlockBasePressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockPressurePlate extends BlockBasePressurePlate {

   public static final PropertyBool field_176580_a = PropertyBool.func_177716_a("powered");
   private final BlockPressurePlate.Sensitivity field_150069_a;
   private static final String __OBFID = "CL_00000289";


   protected BlockPressurePlate(Material p_i45693_1_, BlockPressurePlate.Sensitivity p_i45693_2_) {
      super(p_i45693_1_);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176580_a, Boolean.valueOf(false)));
      this.field_150069_a = p_i45693_2_;
   }

   protected int func_176576_e(IBlockState p_176576_1_) {
      return ((Boolean)p_176576_1_.func_177229_b(field_176580_a)).booleanValue()?15:0;
   }

   protected IBlockState func_176575_a(IBlockState p_176575_1_, int p_176575_2_) {
      return p_176575_1_.func_177226_a(field_176580_a, Boolean.valueOf(p_176575_2_ > 0));
   }

   protected int func_180669_e(World p_180669_1_, BlockPos p_180669_2_) {
      AxisAlignedBB var3 = this.func_180667_a(p_180669_2_);
      List var4;
      switch(BlockPressurePlate.SwitchSensitivity.field_180127_a[this.field_150069_a.ordinal()]) {
      case 1:
         var4 = p_180669_1_.func_72839_b((Entity)null, var3);
         break;
      case 2:
         var4 = p_180669_1_.func_72872_a(EntityLivingBase.class, var3);
         break;
      default:
         return 0;
      }

      if(!var4.isEmpty()) {
         Iterator var5 = var4.iterator();

         while(var5.hasNext()) {
            Entity var6 = (Entity)var5.next();
            if(!var6.func_145773_az()) {
               return 15;
            }
         }
      }

      return 0;
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176580_a, Boolean.valueOf(p_176203_1_ == 1));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((Boolean)p_176201_1_.func_177229_b(field_176580_a)).booleanValue()?1:0;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176580_a});
   }


   public static enum Sensitivity {

      EVERYTHING("EVERYTHING", 0),
      MOBS("MOBS", 1);
      // $FF: synthetic field
      private static final BlockPressurePlate.Sensitivity[] $VALUES = new BlockPressurePlate.Sensitivity[]{EVERYTHING, MOBS};
      private static final String __OBFID = "CL_00000290";


      private Sensitivity(String p_i45417_1_, int p_i45417_2_) {}

   }

   // $FF: synthetic class
   static final class SwitchSensitivity {

      // $FF: synthetic field
      static final int[] field_180127_a = new int[BlockPressurePlate.Sensitivity.values().length];
      private static final String __OBFID = "CL_00002078";


      static {
         try {
            field_180127_a[BlockPressurePlate.Sensitivity.EVERYTHING.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_180127_a[BlockPressurePlate.Sensitivity.MOBS.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
