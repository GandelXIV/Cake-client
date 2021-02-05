package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S3APacketTabComplete implements Packet {

   private String[] field_149632_a;
   private static final String __OBFID = "CL_00001288";


   public S3APacketTabComplete() {}

   public S3APacketTabComplete(String[] p_i45178_1_) {
      this.field_149632_a = p_i45178_1_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149632_a = new String[p_148837_1_.func_150792_a()];

      for(int var2 = 0; var2 < this.field_149632_a.length; ++var2) {
         this.field_149632_a[var2] = p_148837_1_.func_150789_c(32767);
      }

   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_150787_b(this.field_149632_a.length);
      String[] var2 = this.field_149632_a;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         p_148840_1_.func_180714_a(var5);
      }

   }

   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
      p_148833_1_.func_147274_a(this);
   }

   public String[] func_149630_c() {
      return this.field_149632_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_148833_a((INetHandlerPlayClient)p_148833_1_);
   }
}
