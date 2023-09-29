package net.minecraft.util;

import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import net.minecraft.util.IJsonSerializable;

public class JsonSerializableSet extends ForwardingSet implements IJsonSerializable {

   private final Set field_151004_a = Sets.newHashSet();
   private static final String __OBFID = "CL_00001482";


   public void func_152753_a(JsonElement p_152753_1_) {
      if(p_152753_1_.isJsonArray()) {
         Iterator var2 = p_152753_1_.getAsJsonArray().iterator();

         while(var2.hasNext()) {
            JsonElement var3 = (JsonElement)var2.next();
            this.add(var3.getAsString());
         }
      }

   }

   public JsonElement func_151003_a() {
      JsonArray var1 = new JsonArray();
      Iterator var2 = this.iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.add(new JsonPrimitive(var3));
      }

      return var1;
   }

   protected Set delegate() {
      return this.field_151004_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected Collection delegate() {
      return this.delegate();
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected Object delegate() {
      return this.delegate();
   }
}
