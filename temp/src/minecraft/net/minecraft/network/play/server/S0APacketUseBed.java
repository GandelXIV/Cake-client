package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class S0APacketUseBed implements Packet {

   private int field_149097_a;
   private BlockPos field_179799_b;
   private static final String __OBFID = "CL_00001319";


   public S0APacketUseBed() {}

   public S0APacketUseBed(EntityPlayer p_i45964_1_, BlockPos p_i45964_2_) {
      this.field_149097_a = p_i45964_1_.func_145782_y();
      this.field_179799_b = p_i45964_2_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149097_a = p_148837_1_.func_150792_a();
      this.field_179799_b = p_148837_1_.func_179259_c();
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_150787_b(this.field_149097_a);
      p_148840_1_.func_179255_a(this.field_179799_b);
   }

   public void func_180744_a(INetHandlerPlayClient p_180744_1_) {
      p_180744_1_.func_147278_a(this);
   }

   public EntityPlayer func_149091_a(World p_149091_1_) {
      return (EntityPlayer)p_149091_1_.func_73045_a(this.field_149097_a);
   }

   public BlockPos func_179798_a() {
      return this.field_179799_b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180744_a((INetHandlerPlayClient)p_148833_1_);
   }
}
