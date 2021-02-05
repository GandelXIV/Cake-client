package net.minecraft.entity.ai.attributes;

import net.minecraft.entity.ai.attributes.BaseAttribute;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.util.MathHelper;

public class RangedAttribute extends BaseAttribute {

   private final double field_111120_a;
   private final double field_111118_b;
   private String field_111119_c;
   private static final String __OBFID = "CL_00001568";


   public RangedAttribute(IAttribute p_i45891_1_, String p_i45891_2_, double p_i45891_3_, double p_i45891_5_, double p_i45891_7_) {
      super(p_i45891_1_, p_i45891_2_, p_i45891_3_);
      this.field_111120_a = p_i45891_5_;
      this.field_111118_b = p_i45891_7_;
      if(p_i45891_5_ > p_i45891_7_) {
         throw new IllegalArgumentException("Minimum value cannot be bigger than maximum value!");
      } else if(p_i45891_3_ < p_i45891_5_) {
         throw new IllegalArgumentException("Default value cannot be lower than minimum value!");
      } else if(p_i45891_3_ > p_i45891_7_) {
         throw new IllegalArgumentException("Default value cannot be bigger than maximum value!");
      }
   }

   public RangedAttribute func_111117_a(String p_111117_1_) {
      this.field_111119_c = p_111117_1_;
      return this;
   }

   public String func_111116_f() {
      return this.field_111119_c;
   }

   public double func_111109_a(double p_111109_1_) {
      p_111109_1_ = MathHelper.func_151237_a(p_111109_1_, this.field_111120_a, this.field_111118_b);
      return p_111109_1_;
   }
}
