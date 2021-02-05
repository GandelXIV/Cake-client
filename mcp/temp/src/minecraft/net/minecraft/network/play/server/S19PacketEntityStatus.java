package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.entity.Entity;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.world.World;

public class S19PacketEntityStatus implements Packet {

   private int field_149164_a;
   private byte field_149163_b;
   private static final String __OBFID = "CL_00001299";


   public S19PacketEntityStatus() {}

   public S19PacketEntityStatus(Entity p_i46335_1_, byte p_i46335_2_) {
      this.field_149164_a = p_i46335_1_.func_145782_y();
      this.field_149163_b = p_i46335_2_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149164_a = p_148837_1_.readInt();
      this.field_149163_b = p_148837_1_.readByte();
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.writeInt(this.field_149164_a);
      p_148840_1_.writeByte(this.field_149163_b);
   }

   public void func_180736_a(INetHandlerPlayClient p_180736_1_) {
      p_180736_1_.func_147236_a(this);
   }

   public Entity func_149161_a(World p_149161_1_) {
      return p_149161_1_.func_73045_a(this.field_149164_a);
   }

   public byte func_149160_c() {
      return this.field_149163_b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180736_a((INetHandlerPlayClient)p_148833_1_);
   }
}
