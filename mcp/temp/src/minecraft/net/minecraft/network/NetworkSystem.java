package net.minecraft.network;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.local.LocalAddress;
import io.netty.channel.local.LocalEventLoopGroup;
import io.netty.channel.local.LocalServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import net.minecraft.client.network.NetHandlerHandshakeMemory;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.PingResponseHandler;
import net.minecraft.network.play.server.S40PacketDisconnect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.NetHandlerHandshakeTCP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.MessageDeserializer;
import net.minecraft.util.MessageDeserializer2;
import net.minecraft.util.MessageSerializer;
import net.minecraft.util.MessageSerializer2;
import net.minecraft.util.ReportedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NetworkSystem {

   private static final Logger field_151275_b = LogManager.getLogger();
   public static final LazyLoadBase field_151276_c = new LazyLoadBase() {

      private static final String __OBFID = "CL_00001448";

      protected NioEventLoopGroup func_179286_a() {
         return new NioEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Server IO #%d").setDaemon(true).build());
      }
      // $FF: synthetic method
      protected Object func_179280_b() {
         return this.func_179286_a();
      }
   };
   public static final LazyLoadBase field_180232_b = new LazyLoadBase() {

      private static final String __OBFID = "CL_00001449";

      protected LocalEventLoopGroup func_179285_a() {
         return new LocalEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Local Server IO #%d").setDaemon(true).build());
      }
      // $FF: synthetic method
      protected Object func_179280_b() {
         return this.func_179285_a();
      }
   };
   private final MinecraftServer field_151273_d;
   public volatile boolean field_151277_a;
   private final List field_151274_e = Collections.synchronizedList(Lists.newArrayList());
   private final List field_151272_f = Collections.synchronizedList(Lists.newArrayList());
   private static final String __OBFID = "CL_00001447";


   public NetworkSystem(MinecraftServer p_i45292_1_) {
      this.field_151273_d = p_i45292_1_;
      this.field_151277_a = true;
   }

   public void func_151265_a(InetAddress p_151265_1_, int p_151265_2_) throws IOException {
      List var3 = this.field_151274_e;
      synchronized(this.field_151274_e) {
         this.field_151274_e.add(((ServerBootstrap)((ServerBootstrap)(new ServerBootstrap()).channel(NioServerSocketChannel.class)).childHandler(new ChannelInitializer() {

            private static final String __OBFID = "CL_00001450";

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

               p_initChannel_1_.pipeline().addLast("timeout", new ReadTimeoutHandler(30)).addLast("legacy_query", new PingResponseHandler(NetworkSystem.this)).addLast("splitter", new MessageDeserializer2()).addLast("decoder", new MessageDeserializer(EnumPacketDirection.SERVERBOUND)).addLast("prepender", new MessageSerializer2()).addLast("encoder", new MessageSerializer(EnumPacketDirection.CLIENTBOUND));
               NetworkManager var2 = new NetworkManager(EnumPacketDirection.SERVERBOUND);
               NetworkSystem.this.field_151272_f.add(var2);
               p_initChannel_1_.pipeline().addLast("packet_handler", var2);
               var2.func_150719_a(new NetHandlerHandshakeTCP(NetworkSystem.this.field_151273_d, var2));
            }
         }).group((EventLoopGroup)field_151276_c.func_179281_c()).localAddress(p_151265_1_, p_151265_2_)).bind().syncUninterruptibly());
      }
   }

   public SocketAddress func_151270_a() {
      List var2 = this.field_151274_e;
      ChannelFuture var1;
      synchronized(this.field_151274_e) {
         var1 = ((ServerBootstrap)((ServerBootstrap)(new ServerBootstrap()).channel(LocalServerChannel.class)).childHandler(new ChannelInitializer() {

            private static final String __OBFID = "CL_00001451";

            protected void initChannel(Channel p_initChannel_1_) {
               NetworkManager var2 = new NetworkManager(EnumPacketDirection.SERVERBOUND);
               var2.func_150719_a(new NetHandlerHandshakeMemory(NetworkSystem.this.field_151273_d, var2));
               NetworkSystem.this.field_151272_f.add(var2);
               p_initChannel_1_.pipeline().addLast("packet_handler", var2);
            }
         }).group((EventLoopGroup)field_151276_c.func_179281_c()).localAddress(LocalAddress.ANY)).bind().syncUninterruptibly();
         this.field_151274_e.add(var1);
      }

      return var1.channel().localAddress();
   }

   public void func_151268_b() {
      this.field_151277_a = false;
      Iterator var1 = this.field_151274_e.iterator();

      while(var1.hasNext()) {
         ChannelFuture var2 = (ChannelFuture)var1.next();

         try {
            var2.channel().close().sync();
         } catch (InterruptedException var4) {
            field_151275_b.error("Interrupted whilst closing channel");
         }
      }

   }

   public void func_151269_c() {
      List var1 = this.field_151272_f;
      synchronized(this.field_151272_f) {
         Iterator var2 = this.field_151272_f.iterator();

         while(var2.hasNext()) {
            final NetworkManager var3 = (NetworkManager)var2.next();
            if(!var3.func_179291_h()) {
               if(!var3.func_150724_d()) {
                  var2.remove();
                  var3.func_179293_l();
               } else {
                  try {
                     var3.func_74428_b();
                  } catch (Exception var8) {
                     if(var3.func_150731_c()) {
                        CrashReport var10 = CrashReport.func_85055_a(var8, "Ticking memory connection");
                        CrashReportCategory var6 = var10.func_85058_a("Ticking connection");
                        var6.func_71500_a("Connection", new Callable() {

                           private static final String __OBFID = "CL_00002272";

                           public String func_180229_a() {
                              return var3.toString();
                           }
                           // $FF: synthetic method
                           public Object call() {
                              return this.func_180229_a();
                           }
                        });
                        throw new ReportedException(var10);
                     }

                     field_151275_b.warn("Failed to handle packet for " + var3.func_74430_c(), var8);
                     final ChatComponentText var5 = new ChatComponentText("Internal server error");
                     var3.func_179288_a(new S40PacketDisconnect(var5), new GenericFutureListener() {

                        private static final String __OBFID = "CL_00002271";

                        public void operationComplete(Future p_operationComplete_1_) {
                           var3.func_150718_a(var5);
                        }
                     }, new GenericFutureListener[0]);
                     var3.func_150721_g();
                  }
               }
            }
         }

      }
   }

   public MinecraftServer func_151267_d() {
      return this.field_151273_d;
   }

}
