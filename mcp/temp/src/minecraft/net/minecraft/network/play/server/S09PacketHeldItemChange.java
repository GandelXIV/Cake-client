package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S09PacketHeldItemChange implements Packet {

   private int field_149387_a;
   private static final String __OBFID = "CL_00001324";


   public S09PacketHeldItemChange() {}

   public S09PacketHeldItemChange(int p_i45215_1_) {
      this.field_149387_a = p_i45215_1_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149387_a = p_148837_1_.readByte();
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.writeByte(this.field_149387_a);
   }

   public void func_180746_a(INetHandlerPlayClient p_180746_1_) {
      p_180746_1_.func_147257_a(this);
   }

   public int func_149385_c() {
      return this.field_149387_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180746_a((INetHandlerPlayClient)p_148833_1_);
   }
}
