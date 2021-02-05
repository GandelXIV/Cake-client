package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class C07PacketPlayerDigging implements Packet {

   private BlockPos field_179717_a;
   private EnumFacing field_179716_b;
   private C07PacketPlayerDigging.Action field_149508_e;
   private static final String __OBFID = "CL_00001365";


   public C07PacketPlayerDigging() {}

   public C07PacketPlayerDigging(C07PacketPlayerDigging.Action p_i45940_1_, BlockPos p_i45940_2_, EnumFacing p_i45940_3_) {
      this.field_149508_e = p_i45940_1_;
      this.field_179717_a = p_i45940_2_;
      this.field_179716_b = p_i45940_3_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149508_e = (C07PacketPlayerDigging.Action)p_148837_1_.func_179257_a(C07PacketPlayerDigging.Action.class);
      this.field_179717_a = p_148837_1_.func_179259_c();
      this.field_179716_b = EnumFacing.func_82600_a(p_148837_1_.readUnsignedByte());
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_179249_a(this.field_149508_e);
      p_148840_1_.func_179255_a(this.field_179717_a);
      p_148840_1_.writeByte(this.field_179716_b.func_176745_a());
   }

   public void func_180763_a(INetHandlerPlayServer p_180763_1_) {
      p_180763_1_.func_147345_a(this);
   }

   public BlockPos func_179715_a() {
      return this.field_179717_a;
   }

   public EnumFacing func_179714_b() {
      return this.field_179716_b;
   }

   public C07PacketPlayerDigging.Action func_180762_c() {
      return this.field_149508_e;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180763_a((INetHandlerPlayServer)p_148833_1_);
   }

   public static enum Action {

      START_DESTROY_BLOCK("START_DESTROY_BLOCK", 0),
      ABORT_DESTROY_BLOCK("ABORT_DESTROY_BLOCK", 1),
      STOP_DESTROY_BLOCK("STOP_DESTROY_BLOCK", 2),
      DROP_ALL_ITEMS("DROP_ALL_ITEMS", 3),
      DROP_ITEM("DROP_ITEM", 4),
      RELEASE_USE_ITEM("RELEASE_USE_ITEM", 5);
      // $FF: synthetic field
      private static final C07PacketPlayerDigging.Action[] $VALUES = new C07PacketPlayerDigging.Action[]{START_DESTROY_BLOCK, ABORT_DESTROY_BLOCK, STOP_DESTROY_BLOCK, DROP_ALL_ITEMS, DROP_ITEM, RELEASE_USE_ITEM};
      private static final String __OBFID = "CL_00002284";


      private Action(String p_i45939_1_, int p_i45939_2_) {}

   }
}
