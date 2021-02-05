package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.entity.Entity;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S0BPacketAnimation implements Packet {

   private int field_148981_a;
   private int field_148980_b;
   private static final String __OBFID = "CL_00001282";


   public S0BPacketAnimation() {}

   public S0BPacketAnimation(Entity p_i45172_1_, int p_i45172_2_) {
      this.field_148981_a = p_i45172_1_.func_145782_y();
      this.field_148980_b = p_i45172_2_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_148981_a = p_148837_1_.func_150792_a();
      this.field_148980_b = p_148837_1_.readUnsignedByte();
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_150787_b(this.field_148981_a);
      p_148840_1_.writeByte(this.field_148980_b);
   }

   public void func_180723_a(INetHandlerPlayClient p_180723_1_) {
      p_180723_1_.func_147279_a(this);
   }

   public int func_148978_c() {
      return this.field_148981_a;
   }

   public int func_148977_d() {
      return this.field_148980_b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180723_a((INetHandlerPlayClient)p_148833_1_);
   }
}
