package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S48PacketResourcePackSend implements Packet {

   private String field_179786_a;
   private String field_179785_b;
   private static final String __OBFID = "CL_00002293";


   public S48PacketResourcePackSend() {}

   public S48PacketResourcePackSend(String p_i45963_1_, String p_i45963_2_) {
      this.field_179786_a = p_i45963_1_;
      this.field_179785_b = p_i45963_2_;
      if(p_i45963_2_.length() > 40) {
         throw new IllegalArgumentException("Hash is too long (max 40, was " + p_i45963_2_.length() + ")");
      }
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_179786_a = p_148837_1_.func_150789_c(32767);
      this.field_179785_b = p_148837_1_.func_150789_c(40);
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_180714_a(this.field_179786_a);
      p_148840_1_.func_180714_a(this.field_179785_b);
   }

   public void func_179782_a(INetHandlerPlayClient p_179782_1_) {
      p_179782_1_.func_175095_a(this);
   }

   public String func_179783_a() {
      return this.field_179786_a;
   }

   public String func_179784_b() {
      return this.field_179785_b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_179782_a((INetHandlerPlayClient)p_148833_1_);
   }
}
