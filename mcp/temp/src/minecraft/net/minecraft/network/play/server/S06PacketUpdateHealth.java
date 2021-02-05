package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S06PacketUpdateHealth implements Packet {

   private float field_149336_a;
   private int field_149334_b;
   private float field_149335_c;
   private static final String __OBFID = "CL_00001332";


   public S06PacketUpdateHealth() {}

   public S06PacketUpdateHealth(float p_i45223_1_, int p_i45223_2_, float p_i45223_3_) {
      this.field_149336_a = p_i45223_1_;
      this.field_149334_b = p_i45223_2_;
      this.field_149335_c = p_i45223_3_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149336_a = p_148837_1_.readFloat();
      this.field_149334_b = p_148837_1_.func_150792_a();
      this.field_149335_c = p_148837_1_.readFloat();
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.writeFloat(this.field_149336_a);
      p_148840_1_.func_150787_b(this.field_149334_b);
      p_148840_1_.writeFloat(this.field_149335_c);
   }

   public void func_180750_a(INetHandlerPlayClient p_180750_1_) {
      p_180750_1_.func_147249_a(this);
   }

   public float func_149332_c() {
      return this.field_149336_a;
   }

   public int func_149330_d() {
      return this.field_149334_b;
   }

   public float func_149331_e() {
      return this.field_149335_c;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180750_a((INetHandlerPlayClient)p_148833_1_);
   }
}
