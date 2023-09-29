package net.minecraft.realms;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;

public class Tezzelator {

   public static Tessellator t = Tessellator.func_178181_a();
   public static final Tezzelator instance = new Tezzelator();
   private static final String __OBFID = "CL_00001855";


   public int end() {
      return t.func_78381_a();
   }

   public void vertex(double p_vertex_1_, double p_vertex_3_, double p_vertex_5_) {
      t.func_178180_c().func_178984_b(p_vertex_1_, p_vertex_3_, p_vertex_5_);
   }

   public void color(float p_color_1_, float p_color_2_, float p_color_3_, float p_color_4_) {
      t.func_178180_c().func_178960_a(p_color_1_, p_color_2_, p_color_3_, p_color_4_);
   }

   public void color(int p_color_1_, int p_color_2_, int p_color_3_) {
      t.func_178180_c().func_78913_a(p_color_1_, p_color_2_, p_color_3_);
   }

   public void tex2(int p_tex2_1_) {
      t.func_178180_c().func_178963_b(p_tex2_1_);
   }

   public void normal(float p_normal_1_, float p_normal_2_, float p_normal_3_) {
      t.func_178180_c().func_178980_d(p_normal_1_, p_normal_2_, p_normal_3_);
   }

   public void noColor() {
      t.func_178180_c().func_78914_f();
   }

   public void color(int p_color_1_) {
      t.func_178180_c().func_178991_c(p_color_1_);
   }

   public void color(float p_color_1_, float p_color_2_, float p_color_3_) {
      t.func_178180_c().func_178986_b(p_color_1_, p_color_2_, p_color_3_);
   }

   public WorldRenderer.State sortQuads(float p_sortQuads_1_, float p_sortQuads_2_, float p_sortQuads_3_) {
      return t.func_178180_c().func_178971_a(p_sortQuads_1_, p_sortQuads_2_, p_sortQuads_3_);
   }

   public void restoreState(WorldRenderer.State p_restoreState_1_) {
      t.func_178180_c().func_178993_a(p_restoreState_1_);
   }

   public void begin(int p_begin_1_) {
      t.func_178180_c().func_178964_a(p_begin_1_);
   }

   public void begin() {
      t.func_178180_c().func_178970_b();
   }

   public void vertexUV(double p_vertexUV_1_, double p_vertexUV_3_, double p_vertexUV_5_, double p_vertexUV_7_, double p_vertexUV_9_) {
      t.func_178180_c().func_178985_a(p_vertexUV_1_, p_vertexUV_3_, p_vertexUV_5_, p_vertexUV_7_, p_vertexUV_9_);
   }

   public void color(int p_color_1_, int p_color_2_) {
      t.func_178180_c().func_178974_a(p_color_1_, p_color_2_);
   }

   public void offset(double p_offset_1_, double p_offset_3_, double p_offset_5_) {
      t.func_178180_c().func_178969_c(p_offset_1_, p_offset_3_, p_offset_5_);
   }

   public void color(int p_color_1_, int p_color_2_, int p_color_3_, int p_color_4_) {
      t.func_178180_c().func_178961_b(p_color_1_, p_color_2_, p_color_3_, p_color_4_);
   }

   public void tex(double p_tex_1_, double p_tex_3_) {
      t.func_178180_c().func_178992_a(p_tex_1_, p_tex_3_);
   }

   public void color(byte p_color_1_, byte p_color_2_, byte p_color_3_) {
      t.func_178180_c().func_178982_a(p_color_1_, p_color_2_, p_color_3_);
   }

}
