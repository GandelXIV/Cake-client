package net.minecraft.entity.ai.attributes;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.server.management.LowerStringMap;

public class ServersideAttributeMap extends BaseAttributeMap {

   private final Set field_111162_d = Sets.newHashSet();
   protected final Map field_111163_c = new LowerStringMap();
   private static final String __OBFID = "CL_00001569";


   public ModifiableAttributeInstance func_180795_e(IAttribute p_180795_1_) {
      return (ModifiableAttributeInstance)super.func_111151_a(p_180795_1_);
   }

   public ModifiableAttributeInstance func_180796_b(String p_180796_1_) {
      IAttributeInstance var2 = super.func_111152_a(p_180796_1_);
      if(var2 == null) {
         var2 = (IAttributeInstance)this.field_111163_c.get(p_180796_1_);
      }

      return (ModifiableAttributeInstance)var2;
   }

   public IAttributeInstance func_111150_b(IAttribute p_111150_1_) {
      IAttributeInstance var2 = super.func_111150_b(p_111150_1_);
      if(p_111150_1_ instanceof RangedAttribute && ((RangedAttribute)p_111150_1_).func_111116_f() != null) {
         this.field_111163_c.put(((RangedAttribute)p_111150_1_).func_111116_f(), var2);
      }

      return var2;
   }

   protected IAttributeInstance func_180376_c(IAttribute p_180376_1_) {
      return new ModifiableAttributeInstance(this, p_180376_1_);
   }

   public void func_180794_a(IAttributeInstance p_180794_1_) {
      if(p_180794_1_.func_111123_a().func_111111_c()) {
         this.field_111162_d.add(p_180794_1_);
      }

      Iterator var2 = this.field_180377_c.get(p_180794_1_.func_111123_a()).iterator();

      while(var2.hasNext()) {
         IAttribute var3 = (IAttribute)var2.next();
         ModifiableAttributeInstance var4 = this.func_180795_e(var3);
         if(var4 != null) {
            var4.func_111131_f();
         }
      }

   }

   public Set func_111161_b() {
      return this.field_111162_d;
   }

   public Collection func_111160_c() {
      HashSet var1 = Sets.newHashSet();
      Iterator var2 = this.func_111146_a().iterator();

      while(var2.hasNext()) {
         IAttributeInstance var3 = (IAttributeInstance)var2.next();
         if(var3.func_111123_a().func_111111_c()) {
            var1.add(var3);
         }
      }

      return var1;
   }

   // $FF: synthetic method
   public IAttributeInstance func_111152_a(String p_111152_1_) {
      return this.func_180796_b(p_111152_1_);
   }

   // $FF: synthetic method
   public IAttributeInstance func_111151_a(IAttribute p_111151_1_) {
      return this.func_180795_e(p_111151_1_);
   }
}
