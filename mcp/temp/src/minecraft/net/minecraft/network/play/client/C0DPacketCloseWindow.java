package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

public class C0DPacketCloseWindow implements Packet {

   private int field_149556_a;
   private static final String __OBFID = "CL_00001354";


   public C0DPacketCloseWindow() {}

   public C0DPacketCloseWindow(int p_i45247_1_) {
      this.field_149556_a = p_i45247_1_;
   }

   public void func_180759_a(INetHandlerPlayServer p_180759_1_) {
      p_180759_1_.func_147356_a(this);
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149556_a = p_148837_1_.readByte();
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.writeByte(this.field_149556_a);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180759_a((INetHandlerPlayServer)p_148833_1_);
   }
}
