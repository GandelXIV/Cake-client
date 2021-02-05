package net.minecraft.client.renderer;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class ActiveRenderInfo {

   private static final IntBuffer field_178814_a = GLAllocation.func_74527_f(16);
   private static final FloatBuffer field_178812_b = GLAllocation.func_74529_h(16);
   private static final FloatBuffer field_178813_c = GLAllocation.func_74529_h(16);
   private static final FloatBuffer field_178810_d = GLAllocation.func_74529_h(3);
   private static Vec3 field_178811_e = new Vec3(0.0D, 0.0D, 0.0D);
   private static float field_74588_d;
   private static float field_74589_e;
   private static float field_74586_f;
   private static float field_74587_g;
   private static float field_74596_h;
   private static final String __OBFID = "CL_00000626";


   public static void func_74583_a(EntityPlayer p_74583_0_, boolean p_74583_1_) {
      GlStateManager.func_179111_a(2982, field_178812_b);
      GlStateManager.func_179111_a(2983, field_178813_c);
      GL11.glGetInteger(2978, field_178814_a);
      float var2 = (float)((field_178814_a.get(0) + field_178814_a.get(2)) / 2);
      float var3 = (float)((field_178814_a.get(1) + field_178814_a.get(3)) / 2);
      GLU.gluUnProject(var2, var3, 0.0F, field_178812_b, field_178813_c, field_178814_a, field_178810_d);
      field_178811_e = new Vec3((double)field_178810_d.get(0), (double)field_178810_d.get(1), (double)field_178810_d.get(2));
      int var4 = p_74583_1_?1:0;
      float var5 = p_74583_0_.field_70125_A;
      float var6 = p_74583_0_.field_70177_z;
      field_74588_d = MathHelper.func_76134_b(var6 * 3.1415927F / 180.0F) * (float)(1 - var4 * 2);
      field_74586_f = MathHelper.func_76126_a(var6 * 3.1415927F / 180.0F) * (float)(1 - var4 * 2);
      field_74587_g = -field_74586_f * MathHelper.func_76126_a(var5 * 3.1415927F / 180.0F) * (float)(1 - var4 * 2);
      field_74596_h = field_74588_d * MathHelper.func_76126_a(var5 * 3.1415927F / 180.0F) * (float)(1 - var4 * 2);
      field_74589_e = MathHelper.func_76134_b(var5 * 3.1415927F / 180.0F);
   }

   public static Vec3 func_178806_a(Entity p_178806_0_, double p_178806_1_) {
      double var3 = p_178806_0_.field_70169_q + (p_178806_0_.field_70165_t - p_178806_0_.field_70169_q) * p_178806_1_;
      double var5 = p_178806_0_.field_70167_r + (p_178806_0_.field_70163_u - p_178806_0_.field_70167_r) * p_178806_1_;
      double var7 = p_178806_0_.field_70166_s + (p_178806_0_.field_70161_v - p_178806_0_.field_70166_s) * p_178806_1_;
      double var9 = var3 + field_178811_e.field_72450_a;
      double var11 = var5 + field_178811_e.field_72448_b;
      double var13 = var7 + field_178811_e.field_72449_c;
      return new Vec3(var9, var11, var13);
   }

   public static Block func_180786_a(World p_180786_0_, Entity p_180786_1_, float p_180786_2_) {
      Vec3 var3 = func_178806_a(p_180786_1_, (double)p_180786_2_);
      BlockPos var4 = new BlockPos(var3);
      IBlockState var5 = p_180786_0_.func_180495_p(var4);
      Block var6 = var5.func_177230_c();
      if(var6.func_149688_o().func_76224_d()) {
         float var7 = 0.0F;
         if(var5.func_177230_c() instanceof BlockLiquid) {
            var7 = BlockLiquid.func_149801_b(((Integer)var5.func_177229_b(BlockLiquid.field_176367_b)).intValue()) - 0.11111111F;
         }

         float var8 = (float)(var4.func_177956_o() + 1) - var7;
         if(var3.field_72448_b >= (double)var8) {
            var6 = p_180786_0_.func_180495_p(var4.func_177984_a()).func_177230_c();
         }
      }

      return var6;
   }

   public static Vec3 func_178804_a() {
      return field_178811_e;
   }

   public static float func_178808_b() {
      return field_74588_d;
   }

   public static float func_178809_c() {
      return field_74589_e;
   }

   public static float func_178803_d() {
      return field_74586_f;
   }

   public static float func_178805_e() {
      return field_74587_g;
   }

   public static float func_178807_f() {
      return field_74596_h;
   }

}
