package net.minecraft.realms;

import com.google.common.collect.Lists;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.ServerStatusResponse;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.status.INetHandlerStatusClient;
import net.minecraft.network.status.client.C00PacketServerQuery;
import net.minecraft.network.status.client.C01PacketPing;
import net.minecraft.network.status.server.S00PacketServerInfo;
import net.minecraft.network.status.server.S01PacketPong;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsServerAddress;
import net.minecraft.realms.RealmsServerPing;
import net.minecraft.realms.RealmsSharedConstants;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RealmsServerStatusPinger {

   private static final Logger LOGGER = LogManager.getLogger();
   private final List connections = Collections.synchronizedList(Lists.newArrayList());
   private static final String __OBFID = "CL_00001854";


   public void pingServer(final String p_pingServer_1_, final RealmsServerPing p_pingServer_2_) throws UnknownHostException {
      if(p_pingServer_1_ != null && !p_pingServer_1_.startsWith("0.0.0.0") && !p_pingServer_1_.isEmpty()) {
         RealmsServerAddress var3 = RealmsServerAddress.parseString(p_pingServer_1_);
         final NetworkManager var4 = NetworkManager.func_150726_a(InetAddress.getByName(var3.getHost()), var3.getPort());
         this.connections.add(var4);
         var4.func_150719_a(new INetHandlerStatusClient() {

            private boolean field_154345_e = false;
            private static final String __OBFID = "CL_00001807";

            public void func_147397_a(S00PacketServerInfo p_147397_1_) {
               ServerStatusResponse var2 = p_147397_1_.func_149294_c();
               if(var2.func_151318_b() != null) {
                  p_pingServer_2_.nrOfPlayers = String.valueOf(var2.func_151318_b().func_151333_b());
               }

               var4.func_179290_a(new C01PacketPing(Realms.currentTimeMillis()));
               this.field_154345_e = true;
            }
            public void func_147398_a(S01PacketPong p_147398_1_) {
               var4.func_150718_a(new ChatComponentText("Finished"));
            }
            public void func_147231_a(IChatComponent p_147231_1_) {
               if(!this.field_154345_e) {
                  RealmsServerStatusPinger.LOGGER.error("Can\'t ping " + p_pingServer_1_ + ": " + p_147231_1_.func_150260_c());
               }

            }
         });

         try {
            var4.func_179290_a(new C00Handshake(RealmsSharedConstants.NETWORK_PROTOCOL_VERSION, var3.getHost(), var3.getPort(), EnumConnectionState.STATUS));
            var4.func_179290_a(new C00PacketServerQuery());
         } catch (Throwable var6) {
            LOGGER.error(var6);
         }

      }
   }

   public void tick() {
      List var1 = this.connections;
      synchronized(this.connections) {
         Iterator var2 = this.connections.iterator();

         while(var2.hasNext()) {
            NetworkManager var3 = (NetworkManager)var2.next();
            if(var3.func_150724_d()) {
               var3.func_74428_b();
            } else {
               var2.remove();
               var3.func_179293_l();
            }
         }

      }
   }

   public void removeAll() {
      List var1 = this.connections;
      synchronized(this.connections) {
         Iterator var2 = this.connections.iterator();

         while(var2.hasNext()) {
            NetworkManager var3 = (NetworkManager)var2.next();
            if(var3.func_150724_d()) {
               var2.remove();
               var3.func_150718_a(new ChatComponentText("Cancelled"));
            }
         }

      }
   }

}
