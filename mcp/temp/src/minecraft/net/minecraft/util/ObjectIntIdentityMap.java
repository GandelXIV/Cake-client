package net.minecraft.util;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.IObjectIntIterable;

public class ObjectIntIdentityMap implements IObjectIntIterable {

   private final IdentityHashMap field_148749_a = new IdentityHashMap(512);
   private final List field_148748_b = Lists.newArrayList();
   private static final String __OBFID = "CL_00001203";


   public void func_148746_a(Object p_148746_1_, int p_148746_2_) {
      this.field_148749_a.put(p_148746_1_, Integer.valueOf(p_148746_2_));

      while(this.field_148748_b.size() <= p_148746_2_) {
         this.field_148748_b.add((Object)null);
      }

      this.field_148748_b.set(p_148746_2_, p_148746_1_);
   }

   public int func_148747_b(Object p_148747_1_) {
      Integer var2 = (Integer)this.field_148749_a.get(p_148747_1_);
      return var2 == null?-1:var2.intValue();
   }

   public final Object func_148745_a(int p_148745_1_) {
      return p_148745_1_ >= 0 && p_148745_1_ < this.field_148748_b.size()?this.field_148748_b.get(p_148745_1_):null;
   }

   public Iterator iterator() {
      return Iterators.filter(this.field_148748_b.iterator(), Predicates.notNull());
   }
}
