package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

public class C0APacketAnimation implements Packet {

   private static final String __OBFID = "CL_00001345";


   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {}

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {}

   public void func_179721_a(INetHandlerPlayServer p_179721_1_) {
      p_179721_1_.func_175087_a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_179721_a((INetHandlerPlayServer)p_148833_1_);
   }
}
