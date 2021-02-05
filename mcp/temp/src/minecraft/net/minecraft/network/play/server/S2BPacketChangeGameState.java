package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S2BPacketChangeGameState implements Packet {

   public static final String[] field_149142_a = new String[]{"tile.bed.notValid"};
   private int field_149140_b;
   private float field_149141_c;
   private static final String __OBFID = "CL_00001301";


   public S2BPacketChangeGameState() {}

   public S2BPacketChangeGameState(int p_i45194_1_, float p_i45194_2_) {
      this.field_149140_b = p_i45194_1_;
      this.field_149141_c = p_i45194_2_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149140_b = p_148837_1_.readUnsignedByte();
      this.field_149141_c = p_148837_1_.readFloat();
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.writeByte(this.field_149140_b);
      p_148840_1_.writeFloat(this.field_149141_c);
   }

   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
      p_148833_1_.func_147252_a(this);
   }

   public int func_149138_c() {
      return this.field_149140_b;
   }

   public float func_149137_d() {
      return this.field_149141_c;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_148833_a((INetHandlerPlayClient)p_148833_1_);
   }

}
