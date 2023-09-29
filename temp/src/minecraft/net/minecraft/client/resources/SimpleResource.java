package net.minecraft.client.resources;

import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;

public class SimpleResource implements IResource {

   private final Map field_110535_a = Maps.newHashMap();
   private final String field_177242_b;
   private final ResourceLocation field_110533_b;
   private final InputStream field_110534_c;
   private final InputStream field_110531_d;
   private final IMetadataSerializer field_110532_e;
   private boolean field_110529_f;
   private JsonObject field_110530_g;
   private static final String __OBFID = "CL_00001093";


   public SimpleResource(String p_i46090_1_, ResourceLocation p_i46090_2_, InputStream p_i46090_3_, InputStream p_i46090_4_, IMetadataSerializer p_i46090_5_) {
      this.field_177242_b = p_i46090_1_;
      this.field_110533_b = p_i46090_2_;
      this.field_110534_c = p_i46090_3_;
      this.field_110531_d = p_i46090_4_;
      this.field_110532_e = p_i46090_5_;
   }

   public ResourceLocation func_177241_a() {
      return this.field_110533_b;
   }

   public InputStream func_110527_b() {
      return this.field_110534_c;
   }

   public boolean func_110528_c() {
      return this.field_110531_d != null;
   }

   public IMetadataSection func_110526_a(String p_110526_1_) {
      if(!this.func_110528_c()) {
         return null;
      } else {
         if(this.field_110530_g == null && !this.field_110529_f) {
            this.field_110529_f = true;
            BufferedReader var2 = null;

            try {
               var2 = new BufferedReader(new InputStreamReader(this.field_110531_d));
               this.field_110530_g = (new JsonParser()).parse(var2).getAsJsonObject();
            } finally {
               IOUtils.closeQuietly(var2);
            }
         }

         IMetadataSection var6 = (IMetadataSection)this.field_110535_a.get(p_110526_1_);
         if(var6 == null) {
            var6 = this.field_110532_e.func_110503_a(p_110526_1_, this.field_110530_g);
         }

         return var6;
      }
   }

   public String func_177240_d() {
      return this.field_177242_b;
   }

   public boolean equals(Object p_equals_1_) {
      if(this == p_equals_1_) {
         return true;
      } else if(!(p_equals_1_ instanceof SimpleResource)) {
         return false;
      } else {
         SimpleResource var2 = (SimpleResource)p_equals_1_;
         if(this.field_110533_b != null) {
            if(!this.field_110533_b.equals(var2.field_110533_b)) {
               return false;
            }
         } else if(var2.field_110533_b != null) {
            return false;
         }

         if(this.field_177242_b != null) {
            if(!this.field_177242_b.equals(var2.field_177242_b)) {
               return false;
            }
         } else if(var2.field_177242_b != null) {
            return false;
         }

         return true;
      }
   }

   public int hashCode() {
      int var1 = this.field_177242_b != null?this.field_177242_b.hashCode():0;
      var1 = 31 * var1 + (this.field_110533_b != null?this.field_110533_b.hashCode():0);
      return var1;
   }
}
