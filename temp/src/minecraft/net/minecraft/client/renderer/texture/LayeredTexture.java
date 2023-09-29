package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LayeredTexture extends AbstractTexture {

   private static final Logger field_147638_c = LogManager.getLogger();
   public final List field_110567_b;
   private static final String __OBFID = "CL_00001051";


   public LayeredTexture(String ... p_i1274_1_) {
      this.field_110567_b = Lists.newArrayList(p_i1274_1_);
   }

   public void func_110551_a(IResourceManager p_110551_1_) throws IOException {
      this.func_147631_c();
      BufferedImage var2 = null;

      try {
         Iterator var3 = this.field_110567_b.iterator();

         while(var3.hasNext()) {
            String var4 = (String)var3.next();
            if(var4 != null) {
               InputStream var5 = p_110551_1_.func_110536_a(new ResourceLocation(var4)).func_110527_b();
               BufferedImage var6 = TextureUtil.func_177053_a(var5);
               if(var2 == null) {
                  var2 = new BufferedImage(var6.getWidth(), var6.getHeight(), 2);
               }

               var2.getGraphics().drawImage(var6, 0, 0, (ImageObserver)null);
            }
         }
      } catch (IOException var7) {
         field_147638_c.error("Couldn\'t load layered image", var7);
         return;
      }

      TextureUtil.func_110987_a(this.func_110552_b(), var2);
   }

}
