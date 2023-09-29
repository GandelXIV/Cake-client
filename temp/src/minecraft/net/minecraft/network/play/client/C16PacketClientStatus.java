package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

public class C16PacketClientStatus implements Packet {

   private C16PacketClientStatus.EnumState field_149437_a;
   private static final String __OBFID = "CL_00001348";


   public C16PacketClientStatus() {}

   public C16PacketClientStatus(C16PacketClientStatus.EnumState p_i45242_1_) {
      this.field_149437_a = p_i45242_1_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149437_a = (C16PacketClientStatus.EnumState)p_148837_1_.func_179257_a(C16PacketClientStatus.EnumState.class);
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_179249_a(this.field_149437_a);
   }

   public void func_180758_a(INetHandlerPlayServer p_180758_1_) {
      p_180758_1_.func_147342_a(this);
   }

   public C16PacketClientStatus.EnumState func_149435_c() {
      return this.field_149437_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180758_a((INetHandlerPlayServer)p_148833_1_);
   }

   public static enum EnumState {

      PERFORM_RESPAWN("PERFORM_RESPAWN", 0),
      REQUEST_STATS("REQUEST_STATS", 1),
      OPEN_INVENTORY_ACHIEVEMENT("OPEN_INVENTORY_ACHIEVEMENT", 2);
      // $FF: synthetic field
      private static final C16PacketClientStatus.EnumState[] $VALUES = new C16PacketClientStatus.EnumState[]{PERFORM_RESPAWN, REQUEST_STATS, OPEN_INVENTORY_ACHIEVEMENT};
      private static final String __OBFID = "CL_00001349";


      private EnumState(String p_i45947_1_, int p_i45947_2_) {}

   }
}
