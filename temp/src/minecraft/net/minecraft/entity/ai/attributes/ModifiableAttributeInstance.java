package net.minecraft.entity.ai.attributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;

public class ModifiableAttributeInstance implements IAttributeInstance {

   private final BaseAttributeMap field_111138_a;
   private final IAttribute field_111136_b;
   private final Map field_111137_c = Maps.newHashMap();
   private final Map field_111134_d = Maps.newHashMap();
   private final Map field_111135_e = Maps.newHashMap();
   private double field_111132_f;
   private boolean field_111133_g = true;
   private double field_111139_h;
   private static final String __OBFID = "CL_00001567";


   public ModifiableAttributeInstance(BaseAttributeMap p_i1608_1_, IAttribute p_i1608_2_) {
      this.field_111138_a = p_i1608_1_;
      this.field_111136_b = p_i1608_2_;
      this.field_111132_f = p_i1608_2_.func_111110_b();

      for(int var3 = 0; var3 < 3; ++var3) {
         this.field_111137_c.put(Integer.valueOf(var3), Sets.newHashSet());
      }

   }

   public IAttribute func_111123_a() {
      return this.field_111136_b;
   }

   public double func_111125_b() {
      return this.field_111132_f;
   }

   public void func_111128_a(double p_111128_1_) {
      if(p_111128_1_ != this.func_111125_b()) {
         this.field_111132_f = p_111128_1_;
         this.func_111131_f();
      }
   }

   public Collection func_111130_a(int p_111130_1_) {
      return (Collection)this.field_111137_c.get(Integer.valueOf(p_111130_1_));
   }

   public Collection func_111122_c() {
      HashSet var1 = Sets.newHashSet();

      for(int var2 = 0; var2 < 3; ++var2) {
         var1.addAll(this.func_111130_a(var2));
      }

      return var1;
   }

   public AttributeModifier func_111127_a(UUID p_111127_1_) {
      return (AttributeModifier)this.field_111135_e.get(p_111127_1_);
   }

   public boolean func_180374_a(AttributeModifier p_180374_1_) {
      return this.field_111135_e.get(p_180374_1_.func_111167_a()) != null;
   }

   public void func_111121_a(AttributeModifier p_111121_1_) {
      if(this.func_111127_a(p_111121_1_.func_111167_a()) != null) {
         throw new IllegalArgumentException("Modifier is already applied on this attribute!");
      } else {
         Object var2 = (Set)this.field_111134_d.get(p_111121_1_.func_111166_b());
         if(var2 == null) {
            var2 = Sets.newHashSet();
            this.field_111134_d.put(p_111121_1_.func_111166_b(), var2);
         }

         ((Set)this.field_111137_c.get(Integer.valueOf(p_111121_1_.func_111169_c()))).add(p_111121_1_);
         ((Set)var2).add(p_111121_1_);
         this.field_111135_e.put(p_111121_1_.func_111167_a(), p_111121_1_);
         this.func_111131_f();
      }
   }

   protected void func_111131_f() {
      this.field_111133_g = true;
      this.field_111138_a.func_180794_a(this);
   }

   public void func_111124_b(AttributeModifier p_111124_1_) {
      for(int var2 = 0; var2 < 3; ++var2) {
         Set var3 = (Set)this.field_111137_c.get(Integer.valueOf(var2));
         var3.remove(p_111124_1_);
      }

      Set var4 = (Set)this.field_111134_d.get(p_111124_1_.func_111166_b());
      if(var4 != null) {
         var4.remove(p_111124_1_);
         if(var4.isEmpty()) {
            this.field_111134_d.remove(p_111124_1_.func_111166_b());
         }
      }

      this.field_111135_e.remove(p_111124_1_.func_111167_a());
      this.func_111131_f();
   }

   public void func_142049_d() {
      Collection var1 = this.func_111122_c();
      if(var1 != null) {
         ArrayList var4 = Lists.newArrayList(var1);
         Iterator var2 = var4.iterator();

         while(var2.hasNext()) {
            AttributeModifier var3 = (AttributeModifier)var2.next();
            this.func_111124_b(var3);
         }

      }
   }

   public double func_111126_e() {
      if(this.field_111133_g) {
         this.field_111139_h = this.func_111129_g();
         this.field_111133_g = false;
      }

      return this.field_111139_h;
   }

   private double func_111129_g() {
      double var1 = this.func_111125_b();

      AttributeModifier var4;
      for(Iterator var3 = this.func_180375_b(0).iterator(); var3.hasNext(); var1 += var4.func_111164_d()) {
         var4 = (AttributeModifier)var3.next();
      }

      double var7 = var1;

      Iterator var5;
      AttributeModifier var6;
      for(var5 = this.func_180375_b(1).iterator(); var5.hasNext(); var7 += var1 * var6.func_111164_d()) {
         var6 = (AttributeModifier)var5.next();
      }

      for(var5 = this.func_180375_b(2).iterator(); var5.hasNext(); var7 *= 1.0D + var6.func_111164_d()) {
         var6 = (AttributeModifier)var5.next();
      }

      return this.field_111136_b.func_111109_a(var7);
   }

   private Collection func_180375_b(int p_180375_1_) {
      HashSet var2 = Sets.newHashSet(this.func_111130_a(p_180375_1_));

      for(IAttribute var3 = this.field_111136_b.func_180372_d(); var3 != null; var3 = var3.func_180372_d()) {
         IAttributeInstance var4 = this.field_111138_a.func_111151_a(var3);
         if(var4 != null) {
            var2.addAll(var4.func_111130_a(p_180375_1_));
         }
      }

      return var2;
   }
}
