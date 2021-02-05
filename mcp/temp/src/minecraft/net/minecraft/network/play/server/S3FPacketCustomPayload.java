package net.minecraft.network.play.server;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S3FPacketCustomPayload implements Packet {

   private String field_149172_a;
   private PacketBuffer field_149171_b;
   private static final String __OBFID = "CL_00001297";


   public S3FPacketCustomPayload() {}

   public S3FPacketCustomPayload(String p_i45980_1_, PacketBuffer p_i45980_2_) {
      this.field_149172_a = p_i45980_1_;
      this.field_149171_b = p_i45980_2_;
      if(p_i45980_2_.writerIndex() > 1048576) {
         throw new IllegalArgumentException("Payload may not be larger than 1048576 bytes");
      }
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149172_a = p_148837_1_.func_150789_c(20);
      int var2 = p_148837_1_.readableBytes();
      if(var2 >= 0 && var2 <= 1048576) {
         this.field_149171_b = new PacketBuffer(p_148837_1_.readBytes(var2));
      } else {
         throw new IOException("Payload may not be larger than 1048576 bytes");
      }
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_180714_a(this.field_149172_a);
      p_148840_1_.writeBytes((ByteBuf)this.field_149171_b);
   }

   public void func_180734_a(INetHandlerPlayClient p_180734_1_) {
      p_180734_1_.func_147240_a(this);
   }

   public String func_149169_c() {
      return this.field_149172_a;
   }

   public PacketBuffer func_180735_b() {
      return this.field_149171_b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180734_a((INetHandlerPlayClient)p_148833_1_);
   }
}
