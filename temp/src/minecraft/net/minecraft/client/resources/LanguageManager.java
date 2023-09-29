package net.minecraft.client.resources;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.Language;
import net.minecraft.client.resources.Locale;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.client.resources.data.LanguageMetadataSection;
import net.minecraft.util.StringTranslate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LanguageManager implements IResourceManagerReloadListener {

   private static final Logger field_147648_b = LogManager.getLogger();
   private final IMetadataSerializer field_135047_b;
   private String field_135048_c;
   protected static final Locale field_135049_a = new Locale();
   private Map field_135046_d = Maps.newHashMap();
   private static final String __OBFID = "CL_00001096";


   public LanguageManager(IMetadataSerializer p_i1304_1_, String p_i1304_2_) {
      this.field_135047_b = p_i1304_1_;
      this.field_135048_c = p_i1304_2_;
      I18n.func_135051_a(field_135049_a);
   }

   public void func_135043_a(List p_135043_1_) {
      this.field_135046_d.clear();
      Iterator var2 = p_135043_1_.iterator();

      while(var2.hasNext()) {
         IResourcePack var3 = (IResourcePack)var2.next();

         try {
            LanguageMetadataSection var4 = (LanguageMetadataSection)var3.func_135058_a(this.field_135047_b, "language");
            if(var4 != null) {
               Iterator var5 = var4.func_135018_a().iterator();

               while(var5.hasNext()) {
                  Language var6 = (Language)var5.next();
                  if(!this.field_135046_d.containsKey(var6.func_135034_a())) {
                     this.field_135046_d.put(var6.func_135034_a(), var6);
                  }
               }
            }
         } catch (RuntimeException var7) {
            field_147648_b.warn("Unable to parse metadata section of resourcepack: " + var3.func_130077_b(), var7);
         } catch (IOException var8) {
            field_147648_b.warn("Unable to parse metadata section of resourcepack: " + var3.func_130077_b(), var8);
         }
      }

   }

   public void func_110549_a(IResourceManager p_110549_1_) {
      ArrayList var2 = Lists.newArrayList(new String[]{"en_US"});
      if(!"en_US".equals(this.field_135048_c)) {
         var2.add(this.field_135048_c);
      }

      field_135049_a.func_135022_a(p_110549_1_, var2);
      StringTranslate.func_135063_a(field_135049_a.field_135032_a);
   }

   public boolean func_135042_a() {
      return field_135049_a.func_135025_a();
   }

   public boolean func_135044_b() {
      return this.func_135041_c() != null && this.func_135041_c().func_135035_b();
   }

   public void func_135045_a(Language p_135045_1_) {
      this.field_135048_c = p_135045_1_.func_135034_a();
   }

   public Language func_135041_c() {
      return this.field_135046_d.containsKey(this.field_135048_c)?(Language)this.field_135046_d.get(this.field_135048_c):(Language)this.field_135046_d.get("en_US");
   }

   public SortedSet func_135040_d() {
      return Sets.newTreeSet(this.field_135046_d.values());
   }

}
