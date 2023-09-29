package net.minecraft.network;

import com.google.common.collect.Queues;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.local.LocalChannel;
import io.netty.channel.local.LocalEventLoopGroup;
import io.netty.channel.local.LocalServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.GenericFutureListener;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.Queue;
import javax.crypto.SecretKey;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NettyCompressionDecoder;
import net.minecraft.network.NettyCompressionEncoder;
import net.minecraft.network.NettyEncryptingDecoder;
import net.minecraft.network.NettyEncryptingEncoder;
import net.minecraft.network.Packet;
import net.minecraft.network.ThreadQuickExitException;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.CryptManager;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.MessageDeserializer;
import net.minecraft.util.MessageDeserializer2;
import net.minecraft.util.MessageSerializer;
import net.minecraft.util.MessageSerializer2;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class NetworkManager extends SimpleChannelInboundHandler {

   private static final Logger field_150735_g = LogManager.getLogger();
   public static final Marker field_150740_a = MarkerManager.getMarker("NETWORK");
   public static final Marker field_150738_b = MarkerManager.getMarker("NETWORK_PACKETS", field_150740_a);
   public static final AttributeKey field_150739_c = AttributeKey.valueOf("protocol");
   public static final LazyLoadBase field_179295_d = new LazyLoadBase() {

      private static final String __OBFID = "CL_00001241";

      protected NioEventLoopGroup func_179284_a() {
         return new NioEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Client IO #%d").setDaemon(true).build());
      }
      // $FF: synthetic method
      protected Object func_179280_b() {
         return this.func_179284_a();
      }
   };
   public static final LazyLoadBase field_179296_e = new LazyLoadBase() {

      private static final String __OBFID = "CL_00001242";

      protected LocalEventLoopGroup func_179287_a() {
         return new LocalEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Local Client IO #%d").setDaemon(true).build());
      }
      // $FF: synthetic method
      protected Object func_179280_b() {
         return this.func_179287_a();
      }
   };
   private final EnumPacketDirection field_179294_g;
   private final Queue field_150745_j = Queues.newConcurrentLinkedQueue();
   private Channel field_150746_k;
   private SocketAddress field_150743_l;
   private INetHandler field_150744_m;
   private IChatComponent field_150742_o;
   private boolean field_152463_r;
   private boolean field_179297_n;
   private static final String __OBFID = "CL_00001240";


   public NetworkManager(EnumPacketDirection p_i46004_1_) {
      this.field_179294_g = p_i46004_1_;
   }

   public void channelActive(ChannelHandlerContext p_channelActive_1_) throws Exception {
      super.channelActive(p_channelActive_1_);
      this.field_150746_k = p_channelActive_1_.channel();
      this.field_150743_l = this.field_150746_k.remoteAddress();

      try {
         this.func_150723_a(EnumConnectionState.HANDSHAKING);
      } catch (Throwable var3) {
         field_150735_g.fatal(var3);
      }

   }

   public void func_150723_a(EnumConnectionState p_150723_1_) {
      this.field_150746_k.attr(field_150739_c).set(p_150723_1_);
      this.field_150746_k.config().setAutoRead(true);
      field_150735_g.debug("Enabled auto read");
   }

   public void channelInactive(ChannelHandlerContext p_channelInactive_1_) {
      this.func_150718_a(new ChatComponentTranslation("disconnect.endOfStream", new Object[0]));
   }

   public void exceptionCaught(ChannelHandlerContext p_exceptionCaught_1_, Throwable p_exceptionCaught_2_) {
      field_150735_g.debug("Disconnecting " + this.func_74430_c(), p_exceptionCaught_2_);
      this.func_150718_a(new ChatComponentTranslation("disconnect.genericReason", new Object[]{"Internal Exception: " + p_exceptionCaught_2_}));
   }

   protected void channelRead0(ChannelHandlerContext p_channelRead0_1_, Packet p_channelRead0_2_) {
      if(this.field_150746_k.isOpen()) {
         try {
            p_channelRead0_2_.func_148833_a(this.field_150744_m);
         } catch (ThreadQuickExitException var4) {
            ;
         }
      }

   }

   public void func_150719_a(INetHandler p_150719_1_) {
      Validate.notNull(p_150719_1_, "packetListener", new Object[0]);
      field_150735_g.debug("Set listener of {} to {}", new Object[]{this, p_150719_1_});
      this.field_150744_m = p_150719_1_;
   }

   public void func_179290_a(Packet p_179290_1_) {
      if(this.field_150746_k != null && this.field_150746_k.isOpen()) {
         this.func_150733_h();
         this.func_150732_b(p_179290_1_, (GenericFutureListener[])null);
      } else {
         this.field_150745_j.add(new NetworkManager.InboundHandlerTuplePacketListener(p_179290_1_, (GenericFutureListener[])null));
      }

   }

   public void func_179288_a(Packet p_179288_1_, GenericFutureListener p_179288_2_, GenericFutureListener ... p_179288_3_) {
      if(this.field_150746_k != null && this.field_150746_k.isOpen()) {
         this.func_150733_h();
         this.func_150732_b(p_179288_1_, (GenericFutureListener[])ArrayUtils.add(p_179288_3_, 0, p_179288_2_));
      } else {
         this.field_150745_j.add(new NetworkManager.InboundHandlerTuplePacketListener(p_179288_1_, (GenericFutureListener[])ArrayUtils.add(p_179288_3_, 0, p_179288_2_)));
      }

   }

   private void func_150732_b(final Packet p_150732_1_, final GenericFutureListener[] p_150732_2_) {
      final EnumConnectionState var3 = EnumConnectionState.func_150752_a(p_150732_1_);
      final EnumConnectionState var4 = (EnumConnectionState)this.field_150746_k.attr(field_150739_c).get();
      if(var4 != var3) {
         field_150735_g.debug("Disabled auto read");
         this.field_150746_k.config().setAutoRead(false);
      }

      if(this.field_150746_k.eventLoop().inEventLoop()) {
         if(var3 != var4) {
            this.func_150723_a(var3);
         }

         ChannelFuture var5 = this.field_150746_k.writeAndFlush(p_150732_1_);
         if(p_150732_2_ != null) {
            var5.addListeners(p_150732_2_);
         }

         var5.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
      } else {
         this.field_150746_k.eventLoop().execute(new Runnable() {

            private static final String __OBFID = "CL_00001243";

            public void run() {
               if(var3 != var4) {
                  NetworkManager.this.func_150723_a(var3);
               }

               ChannelFuture var1 = NetworkManager.this.field_150746_k.writeAndFlush(p_150732_1_);
               if(p_150732_2_ != null) {
                  var1.addListeners(p_150732_2_);
               }

               var1.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
            }
         });
      }

   }

   private void func_150733_h() {
      if(this.field_150746_k != null && this.field_150746_k.isOpen()) {
         while(!this.field_150745_j.isEmpty()) {
            NetworkManager.InboundHandlerTuplePacketListener var1 = (NetworkManager.InboundHandlerTuplePacketListener)this.field_150745_j.poll();
            this.func_150732_b(var1.field_150774_a, var1.field_150773_b);
         }

      }
   }

   public void func_74428_b() {
      this.func_150733_h();
      if(this.field_150744_m instanceof IUpdatePlayerListBox) {
         ((IUpdatePlayerListBox)this.field_150744_m).func_73660_a();
      }

      this.field_150746_k.flush();
   }

   public SocketAddress func_74430_c() {
      return this.field_150743_l;
   }

   public void func_150718_a(IChatComponent p_150718_1_) {
      if(this.field_150746_k.isOpen()) {
         this.field_150746_k.close().awaitUninterruptibly();
         this.field_150742_o = p_150718_1_;
      }

   }

   public boolean func_150731_c() {
      return this.field_150746_k instanceof LocalChannel || this.field_150746_k instanceof LocalServerChannel;
   }

   public static NetworkManager func_150726_a(InetAddress p_150726_0_, int p_150726_1_) {
      final NetworkManager var2 = new NetworkManager(EnumPacketDirection.CLIENTBOUND);
      ((Bootstrap)((Bootstrap)((Bootstrap)(new Bootstrap()).group((EventLoopGroup)field_179295_d.func_179281_c())).handler(new ChannelInitializer() {

         private static final String __OBFID = "CL_00002312";

         protected void initChannel(Channel p_initChannel_1_) {
            try {
               p_initChannel_1_.config().setOption(ChannelOption.IP_TOS, Integer.valueOf(24));
            } catch (ChannelException var4) {
               ;
            }

            try {
               p_initChannel_1_.config().setOption(ChannelOption.TCP_NODELAY, Boolean.valueOf(false));
            } catch (ChannelException var3) {
               ;
            }

            p_initChannel_1_.pipeline().addLast("timeout", new ReadTimeoutHandler(20)).addLast("splitter", new MessageDeserializer2()).addLast("decoder", new MessageDeserializer(EnumPacketDirection.CLIENTBOUND)).addLast("prepender", new MessageSerializer2()).addLast("encoder", new MessageSerializer(EnumPacketDirection.SERVERBOUND)).addLast("packet_handler", var2);
         }
      })).channel(NioSocketChannel.class)).connect(p_150726_0_, p_150726_1_).syncUninterruptibly();
      return var2;
   }

   public static NetworkManager func_150722_a(SocketAddress p_150722_0_) {
      final NetworkManager var1 = new NetworkManager(EnumPacketDirection.CLIENTBOUND);
      ((Bootstrap)((Bootstrap)((Bootstrap)(new Bootstrap()).group((EventLoopGroup)field_179296_e.func_179281_c())).handler(new ChannelInitializer() {

         private static final String __OBFID = "CL_00002311";

         protected void initChannel(Channel p_initChannel_1_) {
            p_initChannel_1_.pipeline().addLast("packet_handler", var1);
         }
      })).channel(LocalChannel.class)).connect(p_150722_0_).syncUninterruptibly();
      return var1;
   }

   public void func_150727_a(SecretKey p_150727_1_) {
      this.field_152463_r = true;
      this.field_150746_k.pipeline().addBefore("splitter", "decrypt", new NettyEncryptingDecoder(CryptManager.func_151229_a(2, p_150727_1_)));
      this.field_150746_k.pipeline().addBefore("prepender", "encrypt", new NettyEncryptingEncoder(CryptManager.func_151229_a(1, p_150727_1_)));
   }

   public boolean func_179292_f() {
      return this.field_152463_r;
   }

   public boolean func_150724_d() {
      return this.field_150746_k != null && this.field_150746_k.isOpen();
   }

   public boolean func_179291_h() {
      return this.field_150746_k == null;
   }

   public INetHandler func_150729_e() {
      return this.field_150744_m;
   }

   public IChatComponent func_150730_f() {
      return this.field_150742_o;
   }

   public void func_150721_g() {
      this.field_150746_k.config().setAutoRead(false);
   }

   public void func_179289_a(int p_179289_1_) {
      if(p_179289_1_ >= 0) {
         if(this.field_150746_k.pipeline().get("decompress") instanceof NettyCompressionDecoder) {
            ((NettyCompressionDecoder)this.field_150746_k.pipeline().get("decompress")).func_179303_a(p_179289_1_);
         } else {
            this.field_150746_k.pipeline().addBefore("decoder", "decompress", new NettyCompressionDecoder(p_179289_1_));
         }

         if(this.field_150746_k.pipeline().get("compress") instanceof NettyCompressionEncoder) {
            ((NettyCompressionEncoder)this.field_150746_k.pipeline().get("decompress")).func_179299_a(p_179289_1_);
         } else {
            this.field_150746_k.pipeline().addBefore("encoder", "compress", new NettyCompressionEncoder(p_179289_1_));
         }
      } else {
         if(this.field_150746_k.pipeline().get("decompress") instanceof NettyCompressionDecoder) {
            this.field_150746_k.pipeline().remove("decompress");
         }

         if(this.field_150746_k.pipeline().get("compress") instanceof NettyCompressionEncoder) {
            this.field_150746_k.pipeline().remove("compress");
         }
      }

   }

   public void func_179293_l() {
      if(!this.func_179291_h() && !this.func_150724_d() && !this.field_179297_n) {
         this.field_179297_n = true;
         if(this.func_150730_f() != null) {
            this.func_150729_e().func_147231_a(this.func_150730_f());
         } else if(this.func_150729_e() != null) {
            this.func_150729_e().func_147231_a(new ChatComponentText("Disconnected"));
         }
      }

   }

   // $FF: synthetic method
   protected void channelRead0(ChannelHandlerContext p_channelRead0_1_, Object p_channelRead0_2_) {
      this.channelRead0(p_channelRead0_1_, (Packet)p_channelRead0_2_);
   }


   static class InboundHandlerTuplePacketListener {

      private final Packet field_150774_a;
      private final GenericFutureListener[] field_150773_b;
      private static final String __OBFID = "CL_00001244";


      public InboundHandlerTuplePacketListener(Packet p_i45146_1_, GenericFutureListener ... p_i45146_2_) {
         this.field_150774_a = p_i45146_1_;
         this.field_150773_b = p_i45146_2_;
      }
   }
}
