package net.minecraft.network.login.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.login.INetHandlerLoginClient;

public class S03PacketEnableCompression implements Packet {

   private int field_179733_a;
   private static final String __OBFID = "CL_00002279";


   public S03PacketEnableCompression() {}

   public S03PacketEnableCompression(int p_i45929_1_) {
      this.field_179733_a = p_i45929_1_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_179733_a = p_148837_1_.func_150792_a();
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_150787_b(this.field_179733_a);
   }

   public void func_179732_a(INetHandlerLoginClient p_179732_1_) {
      p_179732_1_.func_180464_a(this);
   }

   public int func_179731_a() {
      return this.field_179733_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_179732_a((INetHandlerLoginClient)p_148833_1_);
   }
}
