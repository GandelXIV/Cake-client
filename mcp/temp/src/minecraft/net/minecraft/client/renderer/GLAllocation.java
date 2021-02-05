package net.minecraft.client.renderer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class GLAllocation {

   private static final String __OBFID = "CL_00000630";


   public static synchronized int func_74526_a(int p_74526_0_) {
      int var1 = GL11.glGenLists(p_74526_0_);
      if(var1 == 0) {
         int var2 = GL11.glGetError();
         String var3 = "No error code reported";
         if(var2 != 0) {
            var3 = GLU.gluErrorString(var2);
         }

         throw new IllegalStateException("glGenLists returned an ID of 0 for a count of " + p_74526_0_ + ", GL error (" + var2 + "): " + var3);
      } else {
         return var1;
      }
   }

   public static synchronized void func_178874_a(int p_178874_0_, int p_178874_1_) {
      GL11.glDeleteLists(p_178874_0_, p_178874_1_);
   }

   public static synchronized void func_74523_b(int p_74523_0_) {
      GL11.glDeleteLists(p_74523_0_, 1);
   }

   public static synchronized ByteBuffer func_74524_c(int p_74524_0_) {
      return ByteBuffer.allocateDirect(p_74524_0_).order(ByteOrder.nativeOrder());
   }

   public static IntBuffer func_74527_f(int p_74527_0_) {
      return func_74524_c(p_74527_0_ << 2).asIntBuffer();
   }

   public static FloatBuffer func_74529_h(int p_74529_0_) {
      return func_74524_c(p_74529_0_ << 2).asFloatBuffer();
   }
}
