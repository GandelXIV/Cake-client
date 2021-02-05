package net.minecraft.util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.io.IOException;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.S0CPacketSpawnPlayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class MessageSerializer extends MessageToByteEncoder {

   private static final Logger field_150798_a = LogManager.getLogger();
   private static final Marker field_150797_b = MarkerManager.getMarker("PACKET_SENT", NetworkManager.field_150738_b);
   private final EnumPacketDirection field_152500_c;
   private static final String __OBFID = "CL_00001253";


   public MessageSerializer(EnumPacketDirection p_i45998_1_) {
      this.field_152500_c = p_i45998_1_;
   }

   protected void encode(ChannelHandlerContext p_encode_1_, Packet p_encode_2_, ByteBuf p_encode_3_) throws IOException {
      Integer var4 = ((EnumConnectionState)p_encode_1_.channel().attr(NetworkManager.field_150739_c).get()).func_179246_a(this.field_152500_c, p_encode_2_);
      if(field_150798_a.isDebugEnabled()) {
         field_150798_a.debug(field_150797_b, "OUT: [{}:{}] {}", new Object[]{p_encode_1_.channel().attr(NetworkManager.field_150739_c).get(), var4, p_encode_2_.getClass().getName()});
      }

      if(var4 == null) {
         throw new IOException("Can\'t serialize unregistered packet");
      } else {
         PacketBuffer var5 = new PacketBuffer(p_encode_3_);
         var5.func_150787_b(var4.intValue());

         try {
            if(p_encode_2_ instanceof S0CPacketSpawnPlayer) {
               p_encode_2_ = p_encode_2_;
            }

            p_encode_2_.func_148840_b(var5);
         } catch (Throwable var7) {
            field_150798_a.error(var7);
         }

      }
   }

   // $FF: synthetic method
   protected void encode(ChannelHandlerContext p_encode_1_, Object p_encode_2_, ByteBuf p_encode_3_) throws IOException {
      this.encode(p_encode_1_, (Packet)p_encode_2_, p_encode_3_);
   }

}
