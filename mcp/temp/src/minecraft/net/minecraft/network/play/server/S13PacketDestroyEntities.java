package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S13PacketDestroyEntities implements Packet {

   private int[] field_149100_a;
   private static final String __OBFID = "CL_00001320";


   public S13PacketDestroyEntities() {}

   public S13PacketDestroyEntities(int ... p_i45211_1_) {
      this.field_149100_a = p_i45211_1_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149100_a = new int[p_148837_1_.func_150792_a()];

      for(int var2 = 0; var2 < this.field_149100_a.length; ++var2) {
         this.field_149100_a[var2] = p_148837_1_.func_150792_a();
      }

   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_150787_b(this.field_149100_a.length);

      for(int var2 = 0; var2 < this.field_149100_a.length; ++var2) {
         p_148840_1_.func_150787_b(this.field_149100_a[var2]);
      }

   }

   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
      p_148833_1_.func_147238_a(this);
   }

   public int[] func_149098_c() {
      return this.field_149100_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_148833_a((INetHandlerPlayClient)p_148833_1_);
   }
}
