package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

public class C0CPacketInput implements Packet {

   private float field_149624_a;
   private float field_149622_b;
   private boolean field_149623_c;
   private boolean field_149621_d;
   private static final String __OBFID = "CL_00001367";


   public C0CPacketInput() {}

   public C0CPacketInput(float p_i45261_1_, float p_i45261_2_, boolean p_i45261_3_, boolean p_i45261_4_) {
      this.field_149624_a = p_i45261_1_;
      this.field_149622_b = p_i45261_2_;
      this.field_149623_c = p_i45261_3_;
      this.field_149621_d = p_i45261_4_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149624_a = p_148837_1_.readFloat();
      this.field_149622_b = p_148837_1_.readFloat();
      byte var2 = p_148837_1_.readByte();
      this.field_149623_c = (var2 & 1) > 0;
      this.field_149621_d = (var2 & 2) > 0;
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.writeFloat(this.field_149624_a);
      p_148840_1_.writeFloat(this.field_149622_b);
      byte var2 = 0;
      if(this.field_149623_c) {
         var2 = (byte)(var2 | 1);
      }

      if(this.field_149621_d) {
         var2 = (byte)(var2 | 2);
      }

      p_148840_1_.writeByte(var2);
   }

   public void func_180766_a(INetHandlerPlayServer p_180766_1_) {
      p_180766_1_.func_147358_a(this);
   }

   public float func_149620_c() {
      return this.field_149624_a;
   }

   public float func_149616_d() {
      return this.field_149622_b;
   }

   public boolean func_149618_e() {
      return this.field_149623_c;
   }

   public boolean func_149617_f() {
      return this.field_149621_d;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180766_a((INetHandlerPlayServer)p_148833_1_);
   }
}
