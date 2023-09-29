package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.IChatComponent;

public class S47PacketPlayerListHeaderFooter implements Packet {

   private IChatComponent field_179703_a;
   private IChatComponent field_179702_b;
   private static final String __OBFID = "CL_00002285";


   public S47PacketPlayerListHeaderFooter() {}

   public S47PacketPlayerListHeaderFooter(IChatComponent p_i45950_1_) {
      this.field_179703_a = p_i45950_1_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_179703_a = p_148837_1_.func_179258_d();
      this.field_179702_b = p_148837_1_.func_179258_d();
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_179256_a(this.field_179703_a);
      p_148840_1_.func_179256_a(this.field_179702_b);
   }

   public void func_179699_a(INetHandlerPlayClient p_179699_1_) {
      p_179699_1_.func_175096_a(this);
   }

   public IChatComponent func_179700_a() {
      return this.field_179703_a;
   }

   public IChatComponent func_179701_b() {
      return this.field_179702_b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_179699_a((INetHandlerPlayClient)p_148833_1_);
   }
}
