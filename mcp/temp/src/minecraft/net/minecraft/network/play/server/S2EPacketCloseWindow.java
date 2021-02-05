package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S2EPacketCloseWindow implements Packet {

   private int field_148896_a;
   private static final String __OBFID = "CL_00001292";


   public S2EPacketCloseWindow() {}

   public S2EPacketCloseWindow(int p_i45183_1_) {
      this.field_148896_a = p_i45183_1_;
   }

   public void func_180731_a(INetHandlerPlayClient p_180731_1_) {
      p_180731_1_.func_147276_a(this);
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_148896_a = p_148837_1_.readUnsignedByte();
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.writeByte(this.field_148896_a);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180731_a((INetHandlerPlayClient)p_148833_1_);
   }
}
