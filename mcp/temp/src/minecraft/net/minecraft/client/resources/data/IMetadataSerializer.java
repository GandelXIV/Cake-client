package net.minecraft.client.resources.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.IMetadataSectionSerializer;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumTypeAdapterFactory;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IRegistry;
import net.minecraft.util.RegistrySimple;

public class IMetadataSerializer {

   private final IRegistry field_110508_a = new RegistrySimple();
   private final GsonBuilder field_110506_b = new GsonBuilder();
   private Gson field_110507_c;
   private static final String __OBFID = "CL_00001101";


   public IMetadataSerializer() {
      this.field_110506_b.registerTypeHierarchyAdapter(IChatComponent.class, new IChatComponent.Serializer());
      this.field_110506_b.registerTypeHierarchyAdapter(ChatStyle.class, new ChatStyle.Serializer());
      this.field_110506_b.registerTypeAdapterFactory(new EnumTypeAdapterFactory());
   }

   public void func_110504_a(IMetadataSectionSerializer p_110504_1_, Class p_110504_2_) {
      this.field_110508_a.func_82595_a(p_110504_1_.func_110483_a(), new IMetadataSerializer.Registration(p_110504_1_, p_110504_2_, null));
      this.field_110506_b.registerTypeAdapter(p_110504_2_, p_110504_1_);
      this.field_110507_c = null;
   }

   public IMetadataSection func_110503_a(String p_110503_1_, JsonObject p_110503_2_) {
      if(p_110503_1_ == null) {
         throw new IllegalArgumentException("Metadata section name cannot be null");
      } else if(!p_110503_2_.has(p_110503_1_)) {
         return null;
      } else if(!p_110503_2_.get(p_110503_1_).isJsonObject()) {
         throw new IllegalArgumentException("Invalid metadata for \'" + p_110503_1_ + "\' - expected object, found " + p_110503_2_.get(p_110503_1_));
      } else {
         IMetadataSerializer.Registration var3 = (IMetadataSerializer.Registration)this.field_110508_a.func_82594_a(p_110503_1_);
         if(var3 == null) {
            throw new IllegalArgumentException("Don\'t know how to handle metadata section \'" + p_110503_1_ + "\'");
         } else {
            return (IMetadataSection)this.func_110505_a().fromJson(p_110503_2_.getAsJsonObject(p_110503_1_), var3.field_110500_b);
         }
      }
   }

   private Gson func_110505_a() {
      if(this.field_110507_c == null) {
         this.field_110507_c = this.field_110506_b.create();
      }

      return this.field_110507_c;
   }

   class Registration {

      final IMetadataSectionSerializer field_110502_a;
      final Class field_110500_b;
      private static final String __OBFID = "CL_00001103";


      private Registration(IMetadataSectionSerializer p_i1305_2_, Class p_i1305_3_) {
         this.field_110502_a = p_i1305_2_;
         this.field_110500_b = p_i1305_3_;
      }

      // $FF: synthetic method
      Registration(IMetadataSectionSerializer p_i1306_2_, Class p_i1306_3_, Object p_i1306_4_) {
         this(p_i1306_2_, p_i1306_3_);
      }
   }
}
