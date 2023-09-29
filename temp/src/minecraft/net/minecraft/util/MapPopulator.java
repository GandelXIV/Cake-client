package net.minecraft.util;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class MapPopulator {

   private static final String __OBFID = "CL_00002318";


   public static Map func_179400_b(Iterable p_179400_0_, Iterable p_179400_1_) {
      return func_179399_a(p_179400_0_, p_179400_1_, Maps.newLinkedHashMap());
   }

   public static Map func_179399_a(Iterable p_179399_0_, Iterable p_179399_1_, Map p_179399_2_) {
      Iterator var3 = p_179399_1_.iterator();
      Iterator var4 = p_179399_0_.iterator();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         p_179399_2_.put(var5, var3.next());
      }

      if(var3.hasNext()) {
         throw new NoSuchElementException();
      } else {
         return p_179399_2_;
      }
   }
}
