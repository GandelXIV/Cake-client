package net.minecraft.client.network;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ThreadLanServerPing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LanServerDetector {

   private static final AtomicInteger field_148551_a = new AtomicInteger(0);
   private static final Logger field_148550_b = LogManager.getLogger();
   private static final String __OBFID = "CL_00001133";



   public static class LanServer {

      private String field_77492_a;
      private String field_77490_b;
      private long field_77491_c;
      private static final String __OBFID = "CL_00001134";


      public LanServer(String p_i1319_1_, String p_i1319_2_) {
         this.field_77492_a = p_i1319_1_;
         this.field_77490_b = p_i1319_2_;
         this.field_77491_c = Minecraft.func_71386_F();
      }

      public String func_77487_a() {
         return this.field_77492_a;
      }

      public String func_77488_b() {
         return this.field_77490_b;
      }

      public void func_77489_c() {
         this.field_77491_c = Minecraft.func_71386_F();
      }
   }

   public static class LanServerList {

      private List field_77555_b = Lists.newArrayList();
      boolean field_77556_a;
      private static final String __OBFID = "CL_00001136";


      public synchronized boolean func_77553_a() {
         return this.field_77556_a;
      }

      public synchronized void func_77552_b() {
         this.field_77556_a = false;
      }

      public synchronized List func_77554_c() {
         return Collections.unmodifiableList(this.field_77555_b);
      }

      public synchronized void func_77551_a(String p_77551_1_, InetAddress p_77551_2_) {
         String var3 = ThreadLanServerPing.func_77524_a(p_77551_1_);
         String var4 = ThreadLanServerPing.func_77523_b(p_77551_1_);
         if(var4 != null) {
            var4 = p_77551_2_.getHostAddress() + ":" + var4;
            boolean var5 = false;
            Iterator var6 = this.field_77555_b.iterator();

            while(var6.hasNext()) {
               LanServerDetector.LanServer var7 = (LanServerDetector.LanServer)var6.next();
               if(var7.func_77488_b().equals(var4)) {
                  var7.func_77489_c();
                  var5 = true;
                  break;
               }
            }

            if(!var5) {
               this.field_77555_b.add(new LanServerDetector.LanServer(var3, var4));
               this.field_77556_a = true;
            }

         }
      }
   }

   public static class ThreadLanServerFind extends Thread {

      private final LanServerDetector.LanServerList field_77500_a;
      private final InetAddress field_77498_b;
      private final MulticastSocket field_77499_c;
      private static final String __OBFID = "CL_00001135";


      public ThreadLanServerFind(LanServerDetector.LanServerList p_i1320_1_) throws IOException {
         super("LanServerDetector #" + LanServerDetector.field_148551_a.incrementAndGet());
         this.field_77500_a = p_i1320_1_;
         this.setDaemon(true);
         this.field_77499_c = new MulticastSocket(4445);
         this.field_77498_b = InetAddress.getByName("224.0.2.60");
         this.field_77499_c.setSoTimeout(5000);
         this.field_77499_c.joinGroup(this.field_77498_b);
      }

      public void run() {
         byte[] var2 = new byte[1024];

         while(!this.isInterrupted()) {
            DatagramPacket var1 = new DatagramPacket(var2, var2.length);

            try {
               this.field_77499_c.receive(var1);
            } catch (SocketTimeoutException var5) {
               continue;
            } catch (IOException var6) {
               LanServerDetector.field_148550_b.error("Couldn\'t ping server", var6);
               break;
            }

            String var3 = new String(var1.getData(), var1.getOffset(), var1.getLength());
            LanServerDetector.field_148550_b.debug(var1.getAddress() + ": " + var3);
            this.field_77500_a.func_77551_a(var3, var1.getAddress());
         }

         try {
            this.field_77499_c.leaveGroup(this.field_77498_b);
         } catch (IOException var4) {
            ;
         }

         this.field_77499_c.close();
      }
   }
}
