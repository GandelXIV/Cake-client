package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;

public class S28PacketEffect implements Packet {

   private int field_149251_a;
   private BlockPos field_179747_b;
   private int field_149249_b;
   private boolean field_149246_f;
   private static final String __OBFID = "CL_00001307";


   public S28PacketEffect() {}

   public S28PacketEffect(int p_i45978_1_, BlockPos p_i45978_2_, int p_i45978_3_, boolean p_i45978_4_) {
      this.field_149251_a = p_i45978_1_;
      this.field_179747_b = p_i45978_2_;
      this.field_149249_b = p_i45978_3_;
      this.field_149246_f = p_i45978_4_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149251_a = p_148837_1_.readInt();
      this.field_179747_b = p_148837_1_.func_179259_c();
      this.field_149249_b = p_148837_1_.readInt();
      this.field_149246_f = p_148837_1_.readBoolean();
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.writeInt(this.field_149251_a);
      p_148840_1_.func_179255_a(this.field_179747_b);
      p_148840_1_.writeInt(this.field_149249_b);
      p_148840_1_.writeBoolean(this.field_149246_f);
   }

   public void func_180739_a(INetHandlerPlayClient p_180739_1_) {
      p_180739_1_.func_147277_a(this);
   }

   public boolean func_149244_c() {
      return this.field_149246_f;
   }

   public int func_149242_d() {
      return this.field_149251_a;
   }

   public int func_149241_e() {
      return this.field_149249_b;
   }

   public BlockPos func_179746_d() {
      return this.field_179747_b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180739_a((INetHandlerPlayClient)p_148833_1_);
   }
}
