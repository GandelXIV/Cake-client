package net.minecraft.network.login.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.login.INetHandlerLoginClient;
import net.minecraft.util.IChatComponent;

public class S00PacketDisconnect implements Packet {

   private IChatComponent field_149605_a;
   private static final String __OBFID = "CL_00001377";


   public S00PacketDisconnect() {}

   public S00PacketDisconnect(IChatComponent p_i45269_1_) {
      this.field_149605_a = p_i45269_1_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149605_a = p_148837_1_.func_179258_d();
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_179256_a(this.field_149605_a);
   }

   public void func_180772_a(INetHandlerLoginClient p_180772_1_) {
      p_180772_1_.func_147388_a(this);
   }

   public IChatComponent func_149603_c() {
      return this.field_149605_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180772_a((INetHandlerLoginClient)p_148833_1_);
   }
}
