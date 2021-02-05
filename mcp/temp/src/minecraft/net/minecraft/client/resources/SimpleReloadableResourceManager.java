package net.minecraft.client.resources;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.resources.FallbackResourceManager;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleReloadableResourceManager implements IReloadableResourceManager {

   private static final Logger field_147967_a = LogManager.getLogger();
   private static final Joiner field_130074_a = Joiner.on(", ");
   private final Map field_110548_a = Maps.newHashMap();
   private final List field_110546_b = Lists.newArrayList();
   private final Set field_135057_d = Sets.newLinkedHashSet();
   private final IMetadataSerializer field_110547_c;
   private static final String __OBFID = "CL_00001091";


   public SimpleReloadableResourceManager(IMetadataSerializer p_i1299_1_) {
      this.field_110547_c = p_i1299_1_;
   }

   public void func_110545_a(IResourcePack p_110545_1_) {
      FallbackResourceManager var4;
      for(Iterator var2 = p_110545_1_.func_110587_b().iterator(); var2.hasNext(); var4.func_110538_a(p_110545_1_)) {
         String var3 = (String)var2.next();
         this.field_135057_d.add(var3);
         var4 = (FallbackResourceManager)this.field_110548_a.get(var3);
         if(var4 == null) {
            var4 = new FallbackResourceManager(this.field_110547_c);
            this.field_110548_a.put(var3, var4);
         }
      }

   }

   public Set func_135055_a() {
      return this.field_135057_d;
   }

   public IResource func_110536_a(ResourceLocation p_110536_1_) throws IOException {
      IResourceManager var2 = (IResourceManager)this.field_110548_a.get(p_110536_1_.func_110624_b());
      if(var2 != null) {
         return var2.func_110536_a(p_110536_1_);
      } else {
         throw new FileNotFoundException(p_110536_1_.toString());
      }
   }

   public List func_135056_b(ResourceLocation p_135056_1_) throws IOException {
      IResourceManager var2 = (IResourceManager)this.field_110548_a.get(p_135056_1_.func_110624_b());
      if(var2 != null) {
         return var2.func_135056_b(p_135056_1_);
      } else {
         throw new FileNotFoundException(p_135056_1_.toString());
      }
   }

   private void func_110543_a() {
      this.field_110548_a.clear();
      this.field_135057_d.clear();
   }

   public void func_110541_a(List p_110541_1_) {
      this.func_110543_a();
      field_147967_a.info("Reloading ResourceManager: " + field_130074_a.join(Iterables.transform(p_110541_1_, new Function() {

         private static final String __OBFID = "CL_00001092";

         public String apply(IResourcePack p_apply_1_) {
            return p_apply_1_.func_130077_b();
         }
         // $FF: synthetic method
         public Object apply(Object p_apply_1_) {
            return this.apply((IResourcePack)p_apply_1_);
         }
      })));
      Iterator var2 = p_110541_1_.iterator();

      while(var2.hasNext()) {
         IResourcePack var3 = (IResourcePack)var2.next();
         this.func_110545_a(var3);
      }

      this.func_110544_b();
   }

   public void func_110542_a(IResourceManagerReloadListener p_110542_1_) {
      this.field_110546_b.add(p_110542_1_);
      p_110542_1_.func_110549_a(this);
   }

   private void func_110544_b() {
      Iterator var1 = this.field_110546_b.iterator();

      while(var1.hasNext()) {
         IResourceManagerReloadListener var2 = (IResourceManagerReloadListener)var1.next();
         var2.func_110549_a(this);
      }

   }

}
