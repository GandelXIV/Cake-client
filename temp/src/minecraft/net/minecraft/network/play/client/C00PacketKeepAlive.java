package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

public class C00PacketKeepAlive implements Packet {

   private int field_149461_a;
   private static final String __OBFID = "CL_00001359";


   public C00PacketKeepAlive() {}

   public C00PacketKeepAlive(int p_i45252_1_) {
      this.field_149461_a = p_i45252_1_;
   }

   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
      p_148833_1_.func_147353_a(this);
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149461_a = p_148837_1_.func_150792_a();
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_150787_b(this.field_149461_a);
   }

   public int func_149460_c() {
      return this.field_149461_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_148833_a((INetHandlerPlayServer)p_148833_1_);
   }
}
