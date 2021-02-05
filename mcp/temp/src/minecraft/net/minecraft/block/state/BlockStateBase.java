package net.minecraft.block.state;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;

public abstract class BlockStateBase implements IBlockState {

   private static final Joiner field_177234_a = Joiner.on(',');
   private static final Function field_177233_b = new Function() {

      private static final String __OBFID = "CL_00002031";

      public String func_177225_a(Entry p_177225_1_) {
         if(p_177225_1_ == null) {
            return "<NULL>";
         } else {
            IProperty var2 = (IProperty)p_177225_1_.getKey();
            return var2.func_177701_a() + "=" + var2.func_177702_a((Comparable)p_177225_1_.getValue());
         }
      }
      // $FF: synthetic method
      public Object apply(Object p_apply_1_) {
         return this.func_177225_a((Entry)p_apply_1_);
      }
   };
   private static final String __OBFID = "CL_00002032";


   public IBlockState func_177231_a(IProperty p_177231_1_) {
      return this.func_177226_a(p_177231_1_, (Comparable)func_177232_a(p_177231_1_.func_177700_c(), this.func_177229_b(p_177231_1_)));
   }

   protected static Object func_177232_a(Collection p_177232_0_, Object p_177232_1_) {
      Iterator var2 = p_177232_0_.iterator();

      do {
         if(!var2.hasNext()) {
            return var2.next();
         }
      } while(!var2.next().equals(p_177232_1_));

      if(var2.hasNext()) {
         return var2.next();
      } else {
         return p_177232_0_.iterator().next();
      }
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(Block.field_149771_c.func_177774_c(this.func_177230_c()));
      if(!this.func_177228_b().isEmpty()) {
         var1.append("[");
         field_177234_a.appendTo(var1, Iterables.transform(this.func_177228_b().entrySet(), field_177233_b));
         var1.append("]");
      }

      return var1.toString();
   }

}
