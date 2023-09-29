package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S39PacketPlayerAbilities implements Packet {

   private boolean field_149119_a;
   private boolean field_149117_b;
   private boolean field_149118_c;
   private boolean field_149115_d;
   private float field_149116_e;
   private float field_149114_f;
   private static final String __OBFID = "CL_00001317";


   public S39PacketPlayerAbilities() {}

   public S39PacketPlayerAbilities(PlayerCapabilities p_i45208_1_) {
      this.func_149108_a(p_i45208_1_.field_75102_a);
      this.func_149102_b(p_i45208_1_.field_75100_b);
      this.func_149109_c(p_i45208_1_.field_75101_c);
      this.func_149111_d(p_i45208_1_.field_75098_d);
      this.func_149104_a(p_i45208_1_.func_75093_a());
      this.func_149110_b(p_i45208_1_.func_75094_b());
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      byte var2 = p_148837_1_.readByte();
      this.func_149108_a((var2 & 1) > 0);
      this.func_149102_b((var2 & 2) > 0);
      this.func_149109_c((var2 & 4) > 0);
      this.func_149111_d((var2 & 8) > 0);
      this.func_149104_a(p_148837_1_.readFloat());
      this.func_149110_b(p_148837_1_.readFloat());
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      byte var2 = 0;
      if(this.func_149112_c()) {
         var2 = (byte)(var2 | 1);
      }

      if(this.func_149106_d()) {
         var2 = (byte)(var2 | 2);
      }

      if(this.func_149105_e()) {
         var2 = (byte)(var2 | 4);
      }

      if(this.func_149103_f()) {
         var2 = (byte)(var2 | 8);
      }

      p_148840_1_.writeByte(var2);
      p_148840_1_.writeFloat(this.field_149116_e);
      p_148840_1_.writeFloat(this.field_149114_f);
   }

   public void func_180742_a(INetHandlerPlayClient p_180742_1_) {
      p_180742_1_.func_147270_a(this);
   }

   public boolean func_149112_c() {
      return this.field_149119_a;
   }

   public void func_149108_a(boolean p_149108_1_) {
      this.field_149119_a = p_149108_1_;
   }

   public boolean func_149106_d() {
      return this.field_149117_b;
   }

   public void func_149102_b(boolean p_149102_1_) {
      this.field_149117_b = p_149102_1_;
   }

   public boolean func_149105_e() {
      return this.field_149118_c;
   }

   public void func_149109_c(boolean p_149109_1_) {
      this.field_149118_c = p_149109_1_;
   }

   public boolean func_149103_f() {
      return this.field_149115_d;
   }

   public void func_149111_d(boolean p_149111_1_) {
      this.field_149115_d = p_149111_1_;
   }

   public float func_149101_g() {
      return this.field_149116_e;
   }

   public void func_149104_a(float p_149104_1_) {
      this.field_149116_e = p_149104_1_;
   }

   public float func_149107_h() {
      return this.field_149114_f;
   }

   public void func_149110_b(float p_149110_1_) {
      this.field_149114_f = p_149110_1_;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180742_a((INetHandlerPlayClient)p_148833_1_);
   }
}
