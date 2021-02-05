package net.minecraft.client.renderer.entity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderMinecart;
import net.minecraft.client.renderer.tileentity.TileEntityMobSpawnerRenderer;
import net.minecraft.entity.ai.EntityMinecartMobSpawner;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.init.Blocks;

public class RenderMinecartMobSpawner extends RenderMinecart {

   private static final String __OBFID = "CL_00001014";


   public RenderMinecartMobSpawner(RenderManager p_i46154_1_) {
      super(p_i46154_1_);
   }

   protected void func_177081_a(EntityMinecartMobSpawner p_177081_1_, float p_177081_2_, IBlockState p_177081_3_) {
      super.func_180560_a(p_177081_1_, p_177081_2_, p_177081_3_);
      if(p_177081_3_.func_177230_c() == Blocks.field_150474_ac) {
         TileEntityMobSpawnerRenderer.func_147517_a(p_177081_1_.func_98039_d(), p_177081_1_.field_70165_t, p_177081_1_.field_70163_u, p_177081_1_.field_70161_v, p_177081_2_);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_180560_a(EntityMinecart p_180560_1_, float p_180560_2_, IBlockState p_180560_3_) {
      this.func_177081_a((EntityMinecartMobSpawner)p_180560_1_, p_180560_2_, p_180560_3_);
   }
}
