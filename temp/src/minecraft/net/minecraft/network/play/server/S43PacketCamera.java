package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.entity.Entity;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.world.World;

public class S43PacketCamera implements Packet {

   public int field_179781_a;
   private static final String __OBFID = "CL_00002289";


   public S43PacketCamera() {}

   public S43PacketCamera(Entity p_i45960_1_) {
      this.field_179781_a = p_i45960_1_.func_145782_y();
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_179781_a = p_148837_1_.func_150792_a();
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_150787_b(this.field_179781_a);
   }

   public void func_179779_a(INetHandlerPlayClient p_179779_1_) {
      p_179779_1_.func_175094_a(this);
   }

   public Entity func_179780_a(World p_179780_1_) {
      return p_179780_1_.func_73045_a(this.field_179781_a);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_179779_a((INetHandlerPlayClient)p_148833_1_);
   }
}
