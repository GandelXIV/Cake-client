package net.minecraft.block;

import net.minecraft.block.BlockBasePressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockPressurePlateWeighted extends BlockBasePressurePlate {

   public static final PropertyInteger field_176579_a = PropertyInteger.func_177719_a("power", 0, 15);
   private final int field_150068_a;
   private static final String __OBFID = "CL_00000334";


   protected BlockPressurePlateWeighted(String p_i45436_1_, Material p_i45436_2_, int p_i45436_3_) {
      super(p_i45436_2_);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176579_a, Integer.valueOf(0)));
      this.field_150068_a = p_i45436_3_;
   }

   protected int func_180669_e(World p_180669_1_, BlockPos p_180669_2_) {
      int var3 = Math.min(p_180669_1_.func_72872_a(Entity.class, this.func_180667_a(p_180669_2_)).size(), this.field_150068_a);
      if(var3 > 0) {
         float var4 = (float)Math.min(this.field_150068_a, var3) / (float)this.field_150068_a;
         return MathHelper.func_76123_f(var4 * 15.0F);
      } else {
         return 0;
      }
   }

   protected int func_176576_e(IBlockState p_176576_1_) {
      return ((Integer)p_176576_1_.func_177229_b(field_176579_a)).intValue();
   }

   protected IBlockState func_176575_a(IBlockState p_176575_1_, int p_176575_2_) {
      return p_176575_1_.func_177226_a(field_176579_a, Integer.valueOf(p_176575_2_));
   }

   public int func_149738_a(World p_149738_1_) {
      return 10;
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176579_a, Integer.valueOf(p_176203_1_));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      return ((Integer)p_176201_1_.func_177229_b(field_176579_a)).intValue();
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176579_a});
   }

}
