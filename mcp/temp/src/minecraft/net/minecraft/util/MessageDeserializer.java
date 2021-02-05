package net.minecraft.util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.io.IOException;
import java.util.List;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class MessageDeserializer extends ByteToMessageDecoder {

   private static final Logger field_150800_a = LogManager.getLogger();
   private static final Marker field_150799_b = MarkerManager.getMarker("PACKET_RECEIVED", NetworkManager.field_150738_b);
   private final EnumPacketDirection field_152499_c;
   private static final String __OBFID = "CL_00001252";


   public MessageDeserializer(EnumPacketDirection p_i45999_1_) {
      this.field_152499_c = p_i45999_1_;
   }

   protected void decode(ChannelHandlerContext p_decode_1_, ByteBuf p_decode_2_, List p_decode_3_) throws IOException, InstantiationException, IllegalAccessException {
      if(p_decode_2_.readableBytes() != 0) {
         PacketBuffer var4 = new PacketBuffer(p_decode_2_);
         int var5 = var4.func_150792_a();
         Packet var6 = ((EnumConnectionState)p_decode_1_.channel().attr(NetworkManager.field_150739_c).get()).func_179244_a(this.field_152499_c, var5);
         if(var6 == null) {
            throw new IOException("Bad packet id " + var5);
         } else {
            var6.func_148837_a(var4);
            if(var4.readableBytes() > 0) {
               throw new IOException("Packet " + ((EnumConnectionState)p_decode_1_.channel().attr(NetworkManager.field_150739_c).get()).func_150759_c() + "/" + var5 + " (" + var6.getClass().getSimpleName() + ") was larger than I expected, found " + var4.readableBytes() + " bytes extra whilst reading packet " + var5);
            } else {
               p_decode_3_.add(var6);
               if(field_150800_a.isDebugEnabled()) {
                  field_150800_a.debug(field_150799_b, " IN: [{}:{}] {}", new Object[]{p_decode_1_.channel().attr(NetworkManager.field_150739_c).get(), Integer.valueOf(var5), var6.getClass().getName()});
               }

            }
         }
      }
   }

}
