package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class S10PacketSpawnPainting implements Packet {

   private int field_148973_a;
   private BlockPos field_179838_b;
   private EnumFacing field_179839_c;
   private String field_148968_f;
   private static final String __OBFID = "CL_00001280";


   public S10PacketSpawnPainting() {}

   public S10PacketSpawnPainting(EntityPainting p_i45170_1_) {
      this.field_148973_a = p_i45170_1_.func_145782_y();
      this.field_179838_b = p_i45170_1_.func_174857_n();
      this.field_179839_c = p_i45170_1_.field_174860_b;
      this.field_148968_f = p_i45170_1_.field_70522_e.field_75702_A;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_148973_a = p_148837_1_.func_150792_a();
      this.field_148968_f = p_148837_1_.func_150789_c(EntityPainting.EnumArt.field_180001_A);
      this.field_179838_b = p_148837_1_.func_179259_c();
      this.field_179839_c = EnumFacing.func_176731_b(p_148837_1_.readUnsignedByte());
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_150787_b(this.field_148973_a);
      p_148840_1_.func_180714_a(this.field_148968_f);
      p_148840_1_.func_179255_a(this.field_179838_b);
      p_148840_1_.writeByte(this.field_179839_c.func_176736_b());
   }

   public void func_180722_a(INetHandlerPlayClient p_180722_1_) {
      p_180722_1_.func_147288_a(this);
   }

   public int func_148965_c() {
      return this.field_148973_a;
   }

   public BlockPos func_179837_b() {
      return this.field_179838_b;
   }

   public EnumFacing func_179836_c() {
      return this.field_179839_c;
   }

   public String func_148961_h() {
      return this.field_148968_f;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180722_a((INetHandlerPlayClient)p_148833_1_);
   }
}
