package net.minecraft.client.resources;

import java.io.IOException;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.ColorizerGrass;

public class GrassColorReloadListener implements IResourceManagerReloadListener {

   private static final ResourceLocation field_130078_a = new ResourceLocation("textures/colormap/grass.png");
   private static final String __OBFID = "CL_00001078";


   public void func_110549_a(IResourceManager p_110549_1_) {
      try {
         ColorizerGrass.func_77479_a(TextureUtil.func_110986_a(p_110549_1_, field_130078_a));
      } catch (IOException var3) {
         ;
      }

   }

}
