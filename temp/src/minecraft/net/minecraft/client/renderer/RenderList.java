package net.minecraft.client.renderer;

import java.util.Iterator;
import net.minecraft.client.renderer.ChunkRenderContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.chunk.ListedRenderChunk;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.util.EnumWorldBlockLayer;
import org.lwjgl.opengl.GL11;

public class RenderList extends ChunkRenderContainer {

   private static final String __OBFID = "CL_00000957";


   public void func_178001_a(EnumWorldBlockLayer p_178001_1_) {
      if(this.field_178007_b) {
         Iterator var2 = this.field_178009_a.iterator();

         while(var2.hasNext()) {
            RenderChunk var3 = (RenderChunk)var2.next();
            ListedRenderChunk var4 = (ListedRenderChunk)var3;
            GlStateManager.func_179094_E();
            this.func_178003_a(var3);
            GL11.glCallList(var4.func_178600_a(p_178001_1_, var4.func_178571_g()));
            GlStateManager.func_179121_F();
         }

         GlStateManager.func_179117_G();
         this.field_178009_a.clear();
      }
   }
}
