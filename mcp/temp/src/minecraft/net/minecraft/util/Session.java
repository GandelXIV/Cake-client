package net.minecraft.util;

import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import com.mojang.util.UUIDTypeAdapter;
import java.util.Map;
import java.util.UUID;

public class Session {

   private final String field_74286_b;
   private final String field_148257_b;
   private final String field_148258_c;
   private final Session.Type field_152429_d;
   private static final String __OBFID = "CL_00000659";


   public Session(String p_i1098_1_, String p_i1098_2_, String p_i1098_3_, String p_i1098_4_) {
      this.field_74286_b = p_i1098_1_;
      this.field_148257_b = p_i1098_2_;
      this.field_148258_c = p_i1098_3_;
      this.field_152429_d = Session.Type.func_152421_a(p_i1098_4_);
   }

   public String func_111286_b() {
      return "token:" + this.field_148258_c + ":" + this.field_148257_b;
   }

   public String func_148255_b() {
      return this.field_148257_b;
   }

   public String func_111285_a() {
      return this.field_74286_b;
   }

   public String func_148254_d() {
      return this.field_148258_c;
   }

   public GameProfile func_148256_e() {
      try {
         UUID var1 = UUIDTypeAdapter.fromString(this.func_148255_b());
         return new GameProfile(var1, this.func_111285_a());
      } catch (IllegalArgumentException var2) {
         return new GameProfile((UUID)null, this.func_111285_a());
      }
   }

   public Session.Type func_152428_f() {
      return this.field_152429_d;
   }

   public static enum Type {

      LEGACY("LEGACY", 0, "legacy"),
      MOJANG("MOJANG", 1, "mojang");
      private static final Map field_152425_c = Maps.newHashMap();
      private final String field_152426_d;
      // $FF: synthetic field
      private static final Session.Type[] $VALUES = new Session.Type[]{LEGACY, MOJANG};
      private static final String __OBFID = "CL_00001851";


      private Type(String p_i1096_1_, int p_i1096_2_, String p_i1096_3_) {
         this.field_152426_d = p_i1096_3_;
      }

      public static Session.Type func_152421_a(String p_152421_0_) {
         return (Session.Type)field_152425_c.get(p_152421_0_.toLowerCase());
      }

      static {
         Session.Type[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            Session.Type var3 = var0[var2];
            field_152425_c.put(var3.field_152426_d, var3);
         }

      }
   }
}
