package net.minecraft.client.renderer;

import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.WorldVertexBufferUploader;

public class Tessellator {

   private WorldRenderer field_178183_a;
   private WorldVertexBufferUploader field_178182_b = new WorldVertexBufferUploader();
   private static final Tessellator field_78398_a = new Tessellator(2097152);
   private static final String __OBFID = "CL_00000960";


   public static Tessellator func_178181_a() {
      return field_78398_a;
   }

   public Tessellator(int p_i1250_1_) {
      this.field_178183_a = new WorldRenderer(p_i1250_1_);
   }

   public int func_78381_a() {
      return this.field_178182_b.func_178177_a(this.field_178183_a, this.field_178183_a.func_178977_d());
   }

   public WorldRenderer func_178180_c() {
      return this.field_178183_a;
   }

}
