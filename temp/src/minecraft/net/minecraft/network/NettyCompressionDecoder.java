package net.minecraft.network;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import net.minecraft.network.PacketBuffer;

public class NettyCompressionDecoder extends ByteToMessageDecoder {

   private final Inflater field_179305_a;
   private int field_179304_b;
   private static final String __OBFID = "CL_00002314";


   public NettyCompressionDecoder(int p_i46006_1_) {
      this.field_179304_b = p_i46006_1_;
      this.field_179305_a = new Inflater();
   }

   protected void decode(ChannelHandlerContext p_decode_1_, ByteBuf p_decode_2_, List p_decode_3_) throws DataFormatException {
      if(p_decode_2_.readableBytes() != 0) {
         PacketBuffer var4 = new PacketBuffer(p_decode_2_);
         int var5 = var4.func_150792_a();
         if(var5 == 0) {
            p_decode_3_.add(var4.readBytes(var4.readableBytes()));
         } else {
            if(var5 < this.field_179304_b) {
               throw new DecoderException("Badly compressed packet - size of " + var5 + " is below server threshold of " + this.field_179304_b);
            }

            if(var5 > 2097152) {
               throw new DecoderException("Badly compressed packet - size of " + var5 + " is larger than protocol maximum of " + 2097152);
            }

            byte[] var6 = new byte[var4.readableBytes()];
            var4.readBytes(var6);
            this.field_179305_a.setInput(var6);
            byte[] var7 = new byte[var5];
            this.field_179305_a.inflate(var7);
            p_decode_3_.add(Unpooled.wrappedBuffer(var7));
            this.field_179305_a.reset();
         }

      }
   }

   public void func_179303_a(int p_179303_1_) {
      this.field_179304_b = p_179303_1_;
   }
}
