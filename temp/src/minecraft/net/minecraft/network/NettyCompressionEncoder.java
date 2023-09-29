package net.minecraft.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.util.zip.Deflater;
import net.minecraft.network.PacketBuffer;

public class NettyCompressionEncoder extends MessageToByteEncoder {

   private final byte[] field_179302_a = new byte[8192];
   private final Deflater field_179300_b;
   private int field_179301_c;
   private static final String __OBFID = "CL_00002313";


   public NettyCompressionEncoder(int p_i46005_1_) {
      this.field_179301_c = p_i46005_1_;
      this.field_179300_b = new Deflater();
   }

   protected void func_179298_a(ChannelHandlerContext p_179298_1_, ByteBuf p_179298_2_, ByteBuf p_179298_3_) {
      int var4 = p_179298_2_.readableBytes();
      PacketBuffer var5 = new PacketBuffer(p_179298_3_);
      if(var4 < this.field_179301_c) {
         var5.func_150787_b(0);
         var5.writeBytes(p_179298_2_);
      } else {
         byte[] var6 = new byte[var4];
         p_179298_2_.readBytes(var6);
         var5.func_150787_b(var6.length);
         this.field_179300_b.setInput(var6, 0, var4);
         this.field_179300_b.finish();

         while(!this.field_179300_b.finished()) {
            int var7 = this.field_179300_b.deflate(this.field_179302_a);
            var5.writeBytes(this.field_179302_a, 0, var7);
         }

         this.field_179300_b.reset();
      }

   }

   public void func_179299_a(int p_179299_1_) {
      this.field_179301_c = p_179299_1_;
   }

   // $FF: synthetic method
   protected void encode(ChannelHandlerContext p_encode_1_, Object p_encode_2_, ByteBuf p_encode_3_) {
      this.func_179298_a(p_encode_1_, (ByteBuf)p_encode_2_, p_encode_3_);
   }
}
