package net.minecraft.client.audio;

import com.google.common.collect.Maps;
import java.util.Map;

public enum SoundCategory {

   MASTER("MASTER", 0, "master", 0),
   MUSIC("MUSIC", 1, "music", 1),
   RECORDS("RECORDS", 2, "record", 2),
   WEATHER("WEATHER", 3, "weather", 3),
   BLOCKS("BLOCKS", 4, "block", 4),
   MOBS("MOBS", 5, "hostile", 5),
   ANIMALS("ANIMALS", 6, "neutral", 6),
   PLAYERS("PLAYERS", 7, "player", 7),
   AMBIENT("AMBIENT", 8, "ambient", 8);
   private static final Map field_147168_j = Maps.newHashMap();
   private static final Map field_147169_k = Maps.newHashMap();
   private final String field_147166_l;
   private final int field_147167_m;
   // $FF: synthetic field
   private static final SoundCategory[] $VALUES = new SoundCategory[]{MASTER, MUSIC, RECORDS, WEATHER, BLOCKS, MOBS, ANIMALS, PLAYERS, AMBIENT};
   private static final String __OBFID = "CL_00001686";


   private SoundCategory(String p_i45126_1_, int p_i45126_2_, String p_i45126_3_, int p_i45126_4_) {
      this.field_147166_l = p_i45126_3_;
      this.field_147167_m = p_i45126_4_;
   }

   public String func_147155_a() {
      return this.field_147166_l;
   }

   public int func_147156_b() {
      return this.field_147167_m;
   }

   public static SoundCategory func_147154_a(String p_147154_0_) {
      return (SoundCategory)field_147168_j.get(p_147154_0_);
   }

   static {
      SoundCategory[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         SoundCategory var3 = var0[var2];
         if(field_147168_j.containsKey(var3.func_147155_a()) || field_147169_k.containsKey(Integer.valueOf(var3.func_147156_b()))) {
            throw new Error("Clash in Sound Category ID & Name pools! Cannot insert " + var3);
         }

         field_147168_j.put(var3.func_147155_a(), var3);
         field_147169_k.put(Integer.valueOf(var3.func_147156_b()), var3);
      }

   }
}
