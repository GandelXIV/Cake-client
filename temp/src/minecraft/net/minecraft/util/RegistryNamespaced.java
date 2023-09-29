package net.minecraft.util;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.util.IObjectIntIterable;
import net.minecraft.util.ObjectIntIdentityMap;
import net.minecraft.util.RegistrySimple;

public class RegistryNamespaced extends RegistrySimple implements IObjectIntIterable {

   protected final ObjectIntIdentityMap field_148759_a = new ObjectIntIdentityMap();
   protected final Map field_148758_b;
   private static final String __OBFID = "CL_00001206";


   public RegistryNamespaced() {
      this.field_148758_b = ((BiMap)this.field_82596_a).inverse();
   }

   public void func_177775_a(int p_177775_1_, Object p_177775_2_, Object p_177775_3_) {
      this.field_148759_a.func_148746_a(p_177775_3_, p_177775_1_);
      this.func_82595_a(p_177775_2_, p_177775_3_);
   }

   protected Map func_148740_a() {
      return HashBiMap.create();
   }

   public Object func_82594_a(Object p_82594_1_) {
      return super.func_82594_a(p_82594_1_);
   }

   public Object func_177774_c(Object p_177774_1_) {
      return this.field_148758_b.get(p_177774_1_);
   }

   public boolean func_148741_d(Object p_148741_1_) {
      return super.func_148741_d(p_148741_1_);
   }

   public int func_148757_b(Object p_148757_1_) {
      return this.field_148759_a.func_148747_b(p_148757_1_);
   }

   public Object func_148754_a(int p_148754_1_) {
      return this.field_148759_a.func_148745_a(p_148754_1_);
   }

   public Iterator iterator() {
      return this.field_148759_a.iterator();
   }
}
