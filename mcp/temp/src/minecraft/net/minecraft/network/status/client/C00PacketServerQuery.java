package net.minecraft.network.status.client;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.status.INetHandlerStatusServer;

public class C00PacketServerQuery implements Packet {

   private static final String __OBFID = "CL_00001393";


   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {}

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {}

   public void func_180775_a(INetHandlerStatusServer p_180775_1_) {
      p_180775_1_.func_147312_a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180775_a((INetHandlerStatusServer)p_148833_1_);
   }
}
