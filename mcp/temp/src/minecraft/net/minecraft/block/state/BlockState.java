package net.minecraft.block.state;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.Cartesian;
import net.minecraft.util.MapPopulator;

public class BlockState {

   private static final Joiner field_177628_a = Joiner.on(", ");
   private static final Function field_177626_b = new Function() {

      private static final String __OBFID = "CL_00002029";

      public String func_177568_a(IProperty p_177568_1_) {
         return p_177568_1_ == null?"<NULL>":p_177568_1_.func_177701_a();
      }
      // $FF: synthetic method
      public Object apply(Object p_apply_1_) {
         return this.func_177568_a((IProperty)p_apply_1_);
      }
   };
   private final Block field_177627_c;
   private final ImmutableList field_177624_d;
   private final ImmutableList field_177625_e;
   private static final String __OBFID = "CL_00002030";


   public BlockState(Block p_i45663_1_, IProperty ... p_i45663_2_) {
      this.field_177627_c = p_i45663_1_;
      Arrays.sort(p_i45663_2_, new Comparator() {

         private static final String __OBFID = "CL_00002028";

         public int func_177548_a(IProperty p_177548_1_, IProperty p_177548_2_) {
            return p_177548_1_.func_177701_a().compareTo(p_177548_2_.func_177701_a());
         }
         // $FF: synthetic method
         public int compare(Object p_compare_1_, Object p_compare_2_) {
            return this.func_177548_a((IProperty)p_compare_1_, (IProperty)p_compare_2_);
         }
      });
      this.field_177624_d = ImmutableList.copyOf(p_i45663_2_);
      LinkedHashMap var3 = Maps.newLinkedHashMap();
      ArrayList var4 = Lists.newArrayList();
      Iterable var5 = Cartesian.func_179321_a(this.func_177620_e());
      Iterator var6 = var5.iterator();

      while(var6.hasNext()) {
         List var7 = (List)var6.next();
         Map var8 = MapPopulator.func_179400_b(this.field_177624_d, var7);
         BlockState.StateImplemenation var9 = new BlockState.StateImplemenation(p_i45663_1_, ImmutableMap.copyOf(var8), null);
         var3.put(var8, var9);
         var4.add(var9);
      }

      var6 = var4.iterator();

      while(var6.hasNext()) {
         BlockState.StateImplemenation var10 = (BlockState.StateImplemenation)var6.next();
         var10.func_177235_a(var3);
      }

      this.field_177625_e = ImmutableList.copyOf(var4);
   }

   public ImmutableList func_177619_a() {
      return this.field_177625_e;
   }

   private List func_177620_e() {
      ArrayList var1 = Lists.newArrayList();

      for(int var2 = 0; var2 < this.field_177624_d.size(); ++var2) {
         var1.add(((IProperty)this.field_177624_d.get(var2)).func_177700_c());
      }

      return var1;
   }

   public IBlockState func_177621_b() {
      return (IBlockState)this.field_177625_e.get(0);
   }

   public Block func_177622_c() {
      return this.field_177627_c;
   }

   public Collection func_177623_d() {
      return this.field_177624_d;
   }

   public String toString() {
      return Objects.toStringHelper(this).add("block", Block.field_149771_c.func_177774_c(this.field_177627_c)).add("properties", Iterables.transform(this.field_177624_d, field_177626_b)).toString();
   }


   static class StateImplemenation extends BlockStateBase {

      private final Block field_177239_a;
      private final ImmutableMap field_177237_b;
      private ImmutableTable field_177238_c;
      private static final String __OBFID = "CL_00002027";


      private StateImplemenation(Block p_i45660_1_, ImmutableMap p_i45660_2_) {
         this.field_177239_a = p_i45660_1_;
         this.field_177237_b = p_i45660_2_;
      }

      public Collection func_177227_a() {
         return Collections.unmodifiableCollection(this.field_177237_b.keySet());
      }

      public Comparable func_177229_b(IProperty p_177229_1_) {
         if(!this.field_177237_b.containsKey(p_177229_1_)) {
            throw new IllegalArgumentException("Cannot get property " + p_177229_1_ + " as it does not exist in " + this.field_177239_a.func_176194_O());
         } else {
            return (Comparable)p_177229_1_.func_177699_b().cast(this.field_177237_b.get(p_177229_1_));
         }
      }

      public IBlockState func_177226_a(IProperty p_177226_1_, Comparable p_177226_2_) {
         if(!this.field_177237_b.containsKey(p_177226_1_)) {
            throw new IllegalArgumentException("Cannot set property " + p_177226_1_ + " as it does not exist in " + this.field_177239_a.func_176194_O());
         } else if(!p_177226_1_.func_177700_c().contains(p_177226_2_)) {
            throw new IllegalArgumentException("Cannot set property " + p_177226_1_ + " to " + p_177226_2_ + " on block " + Block.field_149771_c.func_177774_c(this.field_177239_a) + ", it is not an allowed value");
         } else {
            return (IBlockState)(this.field_177237_b.get(p_177226_1_) == p_177226_2_?this:(IBlockState)this.field_177238_c.get(p_177226_1_, p_177226_2_));
         }
      }

      public ImmutableMap func_177228_b() {
         return this.field_177237_b;
      }

      public Block func_177230_c() {
         return this.field_177239_a;
      }

      public boolean equals(Object p_equals_1_) {
         return this == p_equals_1_;
      }

      public int hashCode() {
         return this.field_177237_b.hashCode();
      }

      public void func_177235_a(Map p_177235_1_) {
         if(this.field_177238_c != null) {
            throw new IllegalStateException();
         } else {
            HashBasedTable var2 = HashBasedTable.create();
            Iterator var3 = this.field_177237_b.keySet().iterator();

            while(var3.hasNext()) {
               IProperty var4 = (IProperty)var3.next();
               Iterator var5 = var4.func_177700_c().iterator();

               while(var5.hasNext()) {
                  Comparable var6 = (Comparable)var5.next();
                  if(var6 != this.field_177237_b.get(var4)) {
                     var2.put(var4, var6, p_177235_1_.get(this.func_177236_b(var4, var6)));
                  }
               }
            }

            this.field_177238_c = ImmutableTable.copyOf(var2);
         }
      }

      private Map func_177236_b(IProperty p_177236_1_, Comparable p_177236_2_) {
         HashMap var3 = Maps.newHashMap(this.field_177237_b);
         var3.put(p_177236_1_, p_177236_2_);
         return var3;
      }

      // $FF: synthetic method
      StateImplemenation(Block p_i45661_1_, ImmutableMap p_i45661_2_, Object p_i45661_3_) {
         this(p_i45661_1_, p_i45661_2_);
      }
   }
}
