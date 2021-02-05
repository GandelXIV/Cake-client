package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S46PacketSetCompressionLevel implements Packet {

   private int field_179761_a;
   private static final String __OBFID = "CL_00002300";


   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_179761_a = p_148837_1_.func_150792_a();
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_150787_b(this.field_179761_a);
   }

   public void func_179759_a(INetHandlerPlayClient p_179759_1_) {
      p_179759_1_.func_175100_a(this);
   }

   public int func_179760_a() {
      return this.field_179761_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_179759_a((INetHandlerPlayClient)p_148833_1_);
   }
}
