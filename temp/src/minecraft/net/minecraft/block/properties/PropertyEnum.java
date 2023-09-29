package net.minecraft.block.properties;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.block.properties.PropertyHelper;
import net.minecraft.util.IStringSerializable;

public class PropertyEnum extends PropertyHelper {

   private final ImmutableSet field_177711_a;
   private final Map field_177710_b = Maps.newHashMap();
   private static final String __OBFID = "CL_00002015";


   protected PropertyEnum(String p_i45649_1_, Class p_i45649_2_, Collection p_i45649_3_) {
      super(p_i45649_1_, p_i45649_2_);
      this.field_177711_a = ImmutableSet.copyOf(p_i45649_3_);
      Iterator var4 = p_i45649_3_.iterator();

      while(var4.hasNext()) {
         Enum var5 = (Enum)var4.next();
         String var6 = ((IStringSerializable)var5).func_176610_l();
         if(this.field_177710_b.containsKey(var6)) {
            throw new IllegalArgumentException("Multiple values have the same name \'" + var6 + "\'");
         }

         this.field_177710_b.put(var6, var5);
      }

   }

   public Collection func_177700_c() {
      return this.field_177711_a;
   }

   public String func_177705_a(Enum p_177705_1_) {
      return ((IStringSerializable)p_177705_1_).func_176610_l();
   }

   public static PropertyEnum func_177709_a(String p_177709_0_, Class p_177709_1_) {
      return func_177708_a(p_177709_0_, p_177709_1_, Predicates.alwaysTrue());
   }

   public static PropertyEnum func_177708_a(String p_177708_0_, Class p_177708_1_, Predicate p_177708_2_) {
      return func_177707_a(p_177708_0_, p_177708_1_, Collections2.filter(Lists.newArrayList(p_177708_1_.getEnumConstants()), p_177708_2_));
   }

   public static PropertyEnum func_177706_a(String p_177706_0_, Class p_177706_1_, Enum ... p_177706_2_) {
      return func_177707_a(p_177706_0_, p_177706_1_, Lists.newArrayList(p_177706_2_));
   }

   public static PropertyEnum func_177707_a(String p_177707_0_, Class p_177707_1_, Collection p_177707_2_) {
      return new PropertyEnum(p_177707_0_, p_177707_1_, p_177707_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String func_177702_a(Comparable p_177702_1_) {
      return this.func_177705_a((Enum)p_177702_1_);
   }
}
