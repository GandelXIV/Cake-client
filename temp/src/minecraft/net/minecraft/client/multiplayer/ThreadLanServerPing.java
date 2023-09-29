package net.minecraft.client.multiplayer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadLanServerPing extends Thread {

   private static final AtomicInteger field_148658_a = new AtomicInteger(0);
   private static final Logger field_148657_b = LogManager.getLogger();
   private final String field_77528_b;
   private final DatagramSocket field_77529_c;
   private boolean field_77526_d = true;
   private final String field_77527_e;
   private static final String __OBFID = "CL_00001137";


   public ThreadLanServerPing(String p_i1321_1_, String p_i1321_2_) throws IOException {
      super("LanServerPinger #" + field_148658_a.incrementAndGet());
      this.field_77528_b = p_i1321_1_;
      this.field_77527_e = p_i1321_2_;
      this.setDaemon(true);
      this.field_77529_c = new DatagramSocket();
   }

   public void run() {
      String var1 = func_77525_a(this.field_77528_b, this.field_77527_e);
      byte[] var2 = var1.getBytes();

      while(!this.isInterrupted() && this.field_77526_d) {
         try {
            InetAddress var3 = InetAddress.getByName("224.0.2.60");
            DatagramPacket var4 = new DatagramPacket(var2, var2.length, var3, 4445);
            this.field_77529_c.send(var4);
         } catch (IOException var6) {
            field_148657_b.warn("LanServerPinger: " + var6.getMessage());
            break;
         }

         try {
            sleep(1500L);
         } catch (InterruptedException var5) {
            ;
         }
      }

   }

   public void interrupt() {
      super.interrupt();
      this.field_77526_d = false;
   }

   public static String func_77525_a(String p_77525_0_, String p_77525_1_) {
      return "[MOTD]" + p_77525_0_ + "[/MOTD][AD]" + p_77525_1_ + "[/AD]";
   }

   public static String func_77524_a(String p_77524_0_) {
      int var1 = p_77524_0_.indexOf("[MOTD]");
      if(var1 < 0) {
         return "missing no";
      } else {
         int var2 = p_77524_0_.indexOf("[/MOTD]", var1 + "[MOTD]".length());
         return var2 < var1?"missing no":p_77524_0_.substring(var1 + "[MOTD]".length(), var2);
      }
   }

   public static String func_77523_b(String p_77523_0_) {
      int var1 = p_77523_0_.indexOf("[/MOTD]");
      if(var1 < 0) {
         return null;
      } else {
         int var2 = p_77523_0_.indexOf("[/MOTD]", var1 + "[/MOTD]".length());
         if(var2 >= 0) {
            return null;
         } else {
            int var3 = p_77523_0_.indexOf("[AD]", var1 + "[/MOTD]".length());
            if(var3 < 0) {
               return null;
            } else {
               int var4 = p_77523_0_.indexOf("[/AD]", var3 + "[AD]".length());
               return var4 < var3?null:p_77523_0_.substring(var3 + "[AD]".length(), var4);
            }
         }
      }
   }

}
