package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.block.Block;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;

public class S24PacketBlockAction implements Packet {

   private BlockPos field_179826_a;
   private int field_148872_d;
   private int field_148873_e;
   private Block field_148871_f;
   private static final String __OBFID = "CL_00001286";


   public S24PacketBlockAction() {}

   public S24PacketBlockAction(BlockPos p_i45989_1_, Block p_i45989_2_, int p_i45989_3_, int p_i45989_4_) {
      this.field_179826_a = p_i45989_1_;
      this.field_148872_d = p_i45989_3_;
      this.field_148873_e = p_i45989_4_;
      this.field_148871_f = p_i45989_2_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_179826_a = p_148837_1_.func_179259_c();
      this.field_148872_d = p_148837_1_.readUnsignedByte();
      this.field_148873_e = p_148837_1_.readUnsignedByte();
      this.field_148871_f = Block.func_149729_e(p_148837_1_.func_150792_a() & 4095);
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_179255_a(this.field_179826_a);
      p_148840_1_.writeByte(this.field_148872_d);
      p_148840_1_.writeByte(this.field_148873_e);
      p_148840_1_.func_150787_b(Block.func_149682_b(this.field_148871_f) & 4095);
   }

   public void func_180726_a(INetHandlerPlayClient p_180726_1_) {
      p_180726_1_.func_147261_a(this);
   }

   public BlockPos func_179825_a() {
      return this.field_179826_a;
   }

   public int func_148869_g() {
      return this.field_148872_d;
   }

   public int func_148864_h() {
      return this.field_148873_e;
   }

   public Block func_148868_c() {
      return this.field_148871_f;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180726_a((INetHandlerPlayClient)p_148833_1_);
   }
}
