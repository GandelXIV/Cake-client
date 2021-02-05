package net.minecraft.server.management;

import com.google.gson.JsonObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.minecraft.server.management.UserListEntry;

public abstract class BanEntry extends UserListEntry {

   public static final SimpleDateFormat field_73698_a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
   protected final Date field_73694_d;
   protected final String field_73695_e;
   protected final Date field_73692_f;
   protected final String field_73693_g;
   private static final String __OBFID = "CL_00001395";


   public BanEntry(Object p_i46334_1_, Date p_i46334_2_, String p_i46334_3_, Date p_i46334_4_, String p_i46334_5_) {
      super(p_i46334_1_);
      this.field_73694_d = p_i46334_2_ == null?new Date():p_i46334_2_;
      this.field_73695_e = p_i46334_3_ == null?"(Unknown)":p_i46334_3_;
      this.field_73692_f = p_i46334_4_;
      this.field_73693_g = p_i46334_5_ == null?"Banned by an operator.":p_i46334_5_;
   }

   protected BanEntry(Object p_i1174_1_, JsonObject p_i1174_2_) {
      super(p_i1174_1_, p_i1174_2_);

      Date var3;
      try {
         var3 = p_i1174_2_.has("created")?field_73698_a.parse(p_i1174_2_.get("created").getAsString()):new Date();
      } catch (ParseException var7) {
         var3 = new Date();
      }

      this.field_73694_d = var3;
      this.field_73695_e = p_i1174_2_.has("source")?p_i1174_2_.get("source").getAsString():"(Unknown)";

      Date var4;
      try {
         var4 = p_i1174_2_.has("expires")?field_73698_a.parse(p_i1174_2_.get("expires").getAsString()):null;
      } catch (ParseException var6) {
         var4 = null;
      }

      this.field_73692_f = var4;
      this.field_73693_g = p_i1174_2_.has("reason")?p_i1174_2_.get("reason").getAsString():"Banned by an operator.";
   }

   public Date func_73680_d() {
      return this.field_73692_f;
   }

   public String func_73686_f() {
      return this.field_73693_g;
   }

   boolean func_73682_e() {
      return this.field_73692_f == null?false:this.field_73692_f.before(new Date());
   }

   protected void func_152641_a(JsonObject p_152641_1_) {
      p_152641_1_.addProperty("created", field_73698_a.format(this.field_73694_d));
      p_152641_1_.addProperty("source", this.field_73695_e);
      p_152641_1_.addProperty("expires", this.field_73692_f == null?"forever":field_73698_a.format(this.field_73692_f));
      p_152641_1_.addProperty("reason", this.field_73693_g);
   }

}
