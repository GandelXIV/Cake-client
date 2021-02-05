package net.minecraft.client.renderer;

import java.util.Iterator;
import net.minecraft.client.renderer.ChunkRenderContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.util.EnumWorldBlockLayer;
import org.lwjgl.opengl.GL11;

public class VboRenderList extends ChunkRenderContainer {

   private static final String __OBFID = "CL_00002533";


   public void func_178001_a(EnumWorldBlockLayer p_178001_1_) {
      if(this.field_178007_b) {
         Iterator var2 = this.field_178009_a.iterator();

         while(var2.hasNext()) {
            RenderChunk var3 = (RenderChunk)var2.next();
            VertexBuffer var4 = var3.func_178565_b(p_178001_1_.ordinal());
            GlStateManager.func_179094_E();
            this.func_178003_a(var3);
            var3.func_178572_f();
            var4.func_177359_a();
            this.func_178010_a();
            var4.func_177358_a(7);
            GlStateManager.func_179121_F();
         }

         OpenGlHelper.func_176072_g(OpenGlHelper.field_176089_P, 0);
         GlStateManager.func_179117_G();
         this.field_178009_a.clear();
      }
   }

   private void func_178010_a() {
      GL11.glVertexPointer(3, 5126, 28, 0L);
      GL11.glColorPointer(4, 5121, 28, 12L);
      GL11.glTexCoordPointer(2, 5126, 28, 16L);
      OpenGlHelper.func_77472_b(OpenGlHelper.field_77476_b);
      GL11.glTexCoordPointer(2, 5122, 28, 24L);
      OpenGlHelper.func_77472_b(OpenGlHelper.field_77478_a);
   }
}
