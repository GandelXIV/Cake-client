package net.minecraft.client.resources.data;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import net.minecraft.client.resources.data.BaseMetadataSectionSerializer;
import net.minecraft.client.resources.data.PackMetadataSection;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.JsonUtils;

public class PackMetadataSectionSerializer extends BaseMetadataSectionSerializer implements JsonSerializer {

   private static final String __OBFID = "CL_00001113";


   public PackMetadataSection deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) {
      JsonObject var4 = p_deserialize_1_.getAsJsonObject();
      IChatComponent var5 = (IChatComponent)p_deserialize_3_.deserialize(var4.get("description"), IChatComponent.class);
      if(var5 == null) {
         throw new JsonParseException("Invalid/missing description!");
      } else {
         int var6 = JsonUtils.func_151203_m(var4, "pack_format");
         return new PackMetadataSection(var5, var6);
      }
   }

   public JsonElement serialize(PackMetadataSection p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_) {
      JsonObject var4 = new JsonObject();
      var4.addProperty("pack_format", Integer.valueOf(p_serialize_1_.func_110462_b()));
      var4.add("description", p_serialize_3_.serialize(p_serialize_1_.func_152805_a()));
      return var4;
   }

   public String func_110483_a() {
      return "pack";
   }

   // $FF: synthetic method
   public Object deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) {
      return this.deserialize(p_deserialize_1_, p_deserialize_2_, p_deserialize_3_);
   }

   // $FF: synthetic method
   public JsonElement serialize(Object p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_) {
      return this.serialize((PackMetadataSection)p_serialize_1_, p_serialize_2_, p_serialize_3_);
   }
}
