package net.minecraft.client.audio;

import net.minecraft.client.audio.ISoundEventAccessor;
import net.minecraft.client.audio.SoundPoolEntry;

public class SoundEventAccessor implements ISoundEventAccessor {

   private final SoundPoolEntry field_148739_a;
   private final int field_148738_b;
   private static final String __OBFID = "CL_00001153";


   SoundEventAccessor(SoundPoolEntry p_i45123_1_, int p_i45123_2_) {
      this.field_148739_a = p_i45123_1_;
      this.field_148738_b = p_i45123_2_;
   }

   public int func_148721_a() {
      return this.field_148738_b;
   }

   public SoundPoolEntry func_148720_g() {
      return new SoundPoolEntry(this.field_148739_a);
   }

   // $FF: synthetic method
   public Object func_148720_g() {
      return this.func_148720_g();
   }
}
