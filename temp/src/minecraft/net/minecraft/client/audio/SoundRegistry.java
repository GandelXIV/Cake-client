package net.minecraft.client.audio;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.client.audio.SoundEventAccessorComposite;
import net.minecraft.util.RegistrySimple;

public class SoundRegistry extends RegistrySimple {

   private Map field_148764_a;
   private static final String __OBFID = "CL_00001151";


   protected Map func_148740_a() {
      this.field_148764_a = Maps.newHashMap();
      return this.field_148764_a;
   }

   public void func_148762_a(SoundEventAccessorComposite p_148762_1_) {
      this.func_82595_a(p_148762_1_.func_148729_c(), p_148762_1_);
   }

   public void func_148763_c() {
      this.field_148764_a.clear();
   }
}
