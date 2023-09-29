package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.entity.Entity;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

public class C0BPacketEntityAction implements Packet {

   private int field_149517_a;
   private C0BPacketEntityAction.Action field_149515_b;
   private int field_149516_c;
   private static final String __OBFID = "CL_00001366";


   public C0BPacketEntityAction() {}

   public C0BPacketEntityAction(Entity p_i45937_1_, C0BPacketEntityAction.Action p_i45937_2_) {
      this(p_i45937_1_, p_i45937_2_, 0);
   }

   public C0BPacketEntityAction(Entity p_i45938_1_, C0BPacketEntityAction.Action p_i45938_2_, int p_i45938_3_) {
      this.field_149517_a = p_i45938_1_.func_145782_y();
      this.field_149515_b = p_i45938_2_;
      this.field_149516_c = p_i45938_3_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149517_a = p_148837_1_.func_150792_a();
      this.field_149515_b = (C0BPacketEntityAction.Action)p_148837_1_.func_179257_a(C0BPacketEntityAction.Action.class);
      this.field_149516_c = p_148837_1_.func_150792_a();
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_150787_b(this.field_149517_a);
      p_148840_1_.func_179249_a(this.field_149515_b);
      p_148840_1_.func_150787_b(this.field_149516_c);
   }

   public void func_180765_a(INetHandlerPlayServer p_180765_1_) {
      p_180765_1_.func_147357_a(this);
   }

   public C0BPacketEntityAction.Action func_180764_b() {
      return this.field_149515_b;
   }

   public int func_149512_e() {
      return this.field_149516_c;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180765_a((INetHandlerPlayServer)p_148833_1_);
   }

   public static enum Action {

      START_SNEAKING("START_SNEAKING", 0),
      STOP_SNEAKING("STOP_SNEAKING", 1),
      STOP_SLEEPING("STOP_SLEEPING", 2),
      START_SPRINTING("START_SPRINTING", 3),
      STOP_SPRINTING("STOP_SPRINTING", 4),
      RIDING_JUMP("RIDING_JUMP", 5),
      OPEN_INVENTORY("OPEN_INVENTORY", 6);
      // $FF: synthetic field
      private static final C0BPacketEntityAction.Action[] $VALUES = new C0BPacketEntityAction.Action[]{START_SNEAKING, STOP_SNEAKING, STOP_SLEEPING, START_SPRINTING, STOP_SPRINTING, RIDING_JUMP, OPEN_INVENTORY};
      private static final String __OBFID = "CL_00002283";


      private Action(String p_i45936_1_, int p_i45936_2_) {}

   }
}
