package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;

public class S05PacketSpawnPosition implements Packet {

   private BlockPos field_179801_a;
   private static final String __OBFID = "CL_00001336";


   public S05PacketSpawnPosition() {}

   public S05PacketSpawnPosition(BlockPos p_i45956_1_) {
      this.field_179801_a = p_i45956_1_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_179801_a = p_148837_1_.func_179259_c();
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_179255_a(this.field_179801_a);
   }

   public void func_180752_a(INetHandlerPlayClient p_180752_1_) {
      p_180752_1_.func_147271_a(this);
   }

   public BlockPos func_179800_a() {
      return this.field_179801_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180752_a((INetHandlerPlayClient)p_148833_1_);
   }
}
