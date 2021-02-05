package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.util.BlockPos;
import org.apache.commons.lang3.StringUtils;

public class C14PacketTabComplete implements Packet {

   private String field_149420_a;
   private BlockPos field_179710_b;
   private static final String __OBFID = "CL_00001346";


   public C14PacketTabComplete() {}

   public C14PacketTabComplete(String p_i45239_1_) {
      this(p_i45239_1_, (BlockPos)null);
   }

   public C14PacketTabComplete(String p_i45948_1_, BlockPos p_i45948_2_) {
      this.field_149420_a = p_i45948_1_;
      this.field_179710_b = p_i45948_2_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149420_a = p_148837_1_.func_150789_c(32767);
      boolean var2 = p_148837_1_.readBoolean();
      if(var2) {
         this.field_179710_b = p_148837_1_.func_179259_c();
      }

   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_180714_a(StringUtils.substring(this.field_149420_a, 0, 32767));
      boolean var2 = this.field_179710_b != null;
      p_148840_1_.writeBoolean(var2);
      if(var2) {
         p_148840_1_.func_179255_a(this.field_179710_b);
      }

   }

   public void func_180756_a(INetHandlerPlayServer p_180756_1_) {
      p_180756_1_.func_147341_a(this);
   }

   public String func_149419_c() {
      return this.field_149420_a;
   }

   public BlockPos func_179709_b() {
      return this.field_179710_b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180756_a((INetHandlerPlayServer)p_148833_1_);
   }
}
