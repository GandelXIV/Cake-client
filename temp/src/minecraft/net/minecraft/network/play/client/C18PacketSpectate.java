package net.minecraft.network.play.client;

import java.io.IOException;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.world.WorldServer;

public class C18PacketSpectate implements Packet {

   private UUID field_179729_a;
   private static final String __OBFID = "CL_00002280";


   public C18PacketSpectate() {}

   public C18PacketSpectate(UUID p_i45932_1_) {
      this.field_179729_a = p_i45932_1_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_179729_a = p_148837_1_.func_179253_g();
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_179252_a(this.field_179729_a);
   }

   public void func_179728_a(INetHandlerPlayServer p_179728_1_) {
      p_179728_1_.func_175088_a(this);
   }

   public Entity func_179727_a(WorldServer p_179727_1_) {
      return p_179727_1_.func_175733_a(this.field_179729_a);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_179728_a((INetHandlerPlayServer)p_148833_1_);
   }
}
