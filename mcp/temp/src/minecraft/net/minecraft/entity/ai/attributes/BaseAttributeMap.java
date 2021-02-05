package net.minecraft.entity.ai.attributes;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.server.management.LowerStringMap;

public abstract class BaseAttributeMap {

   protected final Map field_111154_a = Maps.newHashMap();
   protected final Map field_111153_b = new LowerStringMap();
   protected final Multimap field_180377_c = HashMultimap.create();
   private static final String __OBFID = "CL_00001566";


   public IAttributeInstance func_111151_a(IAttribute p_111151_1_) {
      return (IAttributeInstance)this.field_111154_a.get(p_111151_1_);
   }

   public IAttributeInstance func_111152_a(String p_111152_1_) {
      return (IAttributeInstance)this.field_111153_b.get(p_111152_1_);
   }

   public IAttributeInstance func_111150_b(IAttribute p_111150_1_) {
      if(this.field_111153_b.containsKey(p_111150_1_.func_111108_a())) {
         throw new IllegalArgumentException("Attribute is already registered!");
      } else {
         IAttributeInstance var2 = this.func_180376_c(p_111150_1_);
         this.field_111153_b.put(p_111150_1_.func_111108_a(), var2);
         this.field_111154_a.put(p_111150_1_, var2);

         for(IAttribute var3 = p_111150_1_.func_180372_d(); var3 != null; var3 = var3.func_180372_d()) {
            this.field_180377_c.put(var3, p_111150_1_);
         }

         return var2;
      }
   }

   protected abstract IAttributeInstance func_180376_c(IAttribute var1);

   public Collection func_111146_a() {
      return this.field_111153_b.values();
   }

   public void func_180794_a(IAttributeInstance p_180794_1_) {}

   public void func_111148_a(Multimap p_111148_1_) {
      Iterator var2 = p_111148_1_.entries().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         IAttributeInstance var4 = this.func_111152_a((String)var3.getKey());
         if(var4 != null) {
            var4.func_111124_b((AttributeModifier)var3.getValue());
         }
      }

   }

   public void func_111147_b(Multimap p_111147_1_) {
      Iterator var2 = p_111147_1_.entries().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         IAttributeInstance var4 = this.func_111152_a((String)var3.getKey());
         if(var4 != null) {
            var4.func_111124_b((AttributeModifier)var3.getValue());
            var4.func_111121_a((AttributeModifier)var3.getValue());
         }
      }

   }
}
