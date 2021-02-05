package net.minecraft.client.resources;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.io.InputStream;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

public class Locale {

   private static final Splitter field_135030_b = Splitter.on('=').limit(2);
   private static final Pattern field_135031_c = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");
   Map field_135032_a = Maps.newHashMap();
   private boolean field_135029_d;
   private static final String __OBFID = "CL_00001097";


   public synchronized void func_135022_a(IResourceManager p_135022_1_, List p_135022_2_) {
      this.field_135032_a.clear();
      Iterator var3 = p_135022_2_.iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         String var5 = String.format("lang/%s.lang", new Object[]{var4});
         Iterator var6 = p_135022_1_.func_135055_a().iterator();

         while(var6.hasNext()) {
            String var7 = (String)var6.next();

            try {
               this.func_135028_a(p_135022_1_.func_135056_b(new ResourceLocation(var7, var5)));
            } catch (IOException var9) {
               ;
            }
         }
      }

      this.func_135024_b();
   }

   public boolean func_135025_a() {
      return this.field_135029_d;
   }

   private void func_135024_b() {
      this.field_135029_d = false;
      int var1 = 0;
      int var2 = 0;
      Iterator var3 = this.field_135032_a.values().iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         int var5 = var4.length();
         var2 += var5;

         for(int var6 = 0; var6 < var5; ++var6) {
            if(var4.charAt(var6) >= 256) {
               ++var1;
            }
         }
      }

      float var7 = (float)var1 / (float)var2;
      this.field_135029_d = (double)var7 > 0.1D;
   }

   private void func_135028_a(List p_135028_1_) throws IOException {
      Iterator var2 = p_135028_1_.iterator();

      while(var2.hasNext()) {
         IResource var3 = (IResource)var2.next();
         InputStream var4 = var3.func_110527_b();

         try {
            this.func_135021_a(var4);
         } finally {
            IOUtils.closeQuietly(var4);
         }
      }

   }

   private void func_135021_a(InputStream p_135021_1_) throws IOException {
      Iterator var2 = IOUtils.readLines(p_135021_1_, Charsets.UTF_8).iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         if(!var3.isEmpty() && var3.charAt(0) != 35) {
            String[] var4 = (String[])Iterables.toArray(field_135030_b.split(var3), String.class);
            if(var4 != null && var4.length == 2) {
               String var5 = var4[0];
               String var6 = field_135031_c.matcher(var4[1]).replaceAll("%$1s");
               this.field_135032_a.put(var5, var6);
            }
         }
      }

   }

   private String func_135026_c(String p_135026_1_) {
      String var2 = (String)this.field_135032_a.get(p_135026_1_);
      return var2 == null?p_135026_1_:var2;
   }

   public String func_135023_a(String p_135023_1_, Object[] p_135023_2_) {
      String var3 = this.func_135026_c(p_135023_1_);

      try {
         return String.format(var3, p_135023_2_);
      } catch (IllegalFormatException var5) {
         return "Format error: " + var3;
      }
   }

}
