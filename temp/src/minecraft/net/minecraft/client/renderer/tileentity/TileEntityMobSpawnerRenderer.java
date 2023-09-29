package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;

public class TileEntityMobSpawnerRenderer extends TileEntitySpecialRenderer {

   private static final String __OBFID = "CL_00000968";


   public void func_180539_a(TileEntityMobSpawner p_180539_1_, double p_180539_2_, double p_180539_4_, double p_180539_6_, float p_180539_8_, int p_180539_9_) {
      GlStateManager.func_179094_E();
      GlStateManager.func_179109_b((float)p_180539_2_ + 0.5F, (float)p_180539_4_, (float)p_180539_6_ + 0.5F);
      func_147517_a(p_180539_1_.func_145881_a(), p_180539_2_, p_180539_4_, p_180539_6_, p_180539_8_);
      GlStateManager.func_179121_F();
   }

   public static void func_147517_a(MobSpawnerBaseLogic p_147517_0_, double p_147517_1_, double p_147517_3_, double p_147517_5_, float p_147517_7_) {
      Entity var8 = p_147517_0_.func_180612_a(p_147517_0_.func_98271_a());
      if(var8 != null) {
         float var9 = 0.4375F;
         GlStateManager.func_179109_b(0.0F, 0.4F, 0.0F);
         GlStateManager.func_179114_b((float)(p_147517_0_.func_177223_e() + (p_147517_0_.func_177222_d() - p_147517_0_.func_177223_e()) * (double)p_147517_7_) * 10.0F, 0.0F, 1.0F, 0.0F);
         GlStateManager.func_179114_b(-30.0F, 1.0F, 0.0F, 0.0F);
         GlStateManager.func_179109_b(0.0F, -0.4F, 0.0F);
         GlStateManager.func_179152_a(var9, var9, var9);
         var8.func_70012_b(p_147517_1_, p_147517_3_, p_147517_5_, 0.0F, 0.0F);
         Minecraft.func_71410_x().func_175598_ae().func_147940_a(var8, 0.0D, 0.0D, 0.0D, 0.0F, p_147517_7_);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_180535_a(TileEntity p_180535_1_, double p_180535_2_, double p_180535_4_, double p_180535_6_, float p_180535_8_, int p_180535_9_) {
      this.func_180539_a((TileEntityMobSpawner)p_180535_1_, p_180535_2_, p_180535_4_, p_180535_6_, p_180535_8_, p_180535_9_);
   }
}
