package net.minecraft.world.chunk.storage;

import com.google.common.collect.Maps;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.world.chunk.storage.RegionFile;

public class RegionFileCache {

   private static final Map field_76553_a = Maps.newHashMap();
   private static final String __OBFID = "CL_00000383";


   public static synchronized RegionFile func_76550_a(File p_76550_0_, int p_76550_1_, int p_76550_2_) {
      File var3 = new File(p_76550_0_, "region");
      File var4 = new File(var3, "r." + (p_76550_1_ >> 5) + "." + (p_76550_2_ >> 5) + ".mca");
      RegionFile var5 = (RegionFile)field_76553_a.get(var4);
      if(var5 != null) {
         return var5;
      } else {
         if(!var3.exists()) {
            var3.mkdirs();
         }

         if(field_76553_a.size() >= 256) {
            func_76551_a();
         }

         RegionFile var6 = new RegionFile(var4);
         field_76553_a.put(var4, var6);
         return var6;
      }
   }

   public static synchronized void func_76551_a() {
      Iterator var0 = field_76553_a.values().iterator();

      while(var0.hasNext()) {
         RegionFile var1 = (RegionFile)var0.next();

         try {
            if(var1 != null) {
               var1.func_76708_c();
            }
         } catch (IOException var3) {
            var3.printStackTrace();
         }
      }

      field_76553_a.clear();
   }

   public static DataInputStream func_76549_c(File p_76549_0_, int p_76549_1_, int p_76549_2_) {
      RegionFile var3 = func_76550_a(p_76549_0_, p_76549_1_, p_76549_2_);
      return var3.func_76704_a(p_76549_1_ & 31, p_76549_2_ & 31);
   }

   public static DataOutputStream func_76552_d(File p_76552_0_, int p_76552_1_, int p_76552_2_) {
      RegionFile var3 = func_76550_a(p_76552_0_, p_76552_1_, p_76552_2_);
      return var3.func_76710_b(p_76552_1_ & 31, p_76552_2_ & 31);
   }

}
