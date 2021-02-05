package net.minecraft.network.play.server;

import java.io.IOException;
import java.util.List;
import net.minecraft.entity.DataWatcher;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S1CPacketEntityMetadata implements Packet {

   private int field_149379_a;
   private List field_149378_b;
   private static final String __OBFID = "CL_00001326";


   public S1CPacketEntityMetadata() {}

   public S1CPacketEntityMetadata(int p_i45217_1_, DataWatcher p_i45217_2_, boolean p_i45217_3_) {
      this.field_149379_a = p_i45217_1_;
      if(p_i45217_3_) {
         this.field_149378_b = p_i45217_2_.func_75685_c();
      } else {
         this.field_149378_b = p_i45217_2_.func_75688_b();
      }

   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149379_a = p_148837_1_.func_150792_a();
      this.field_149378_b = DataWatcher.func_151508_b(p_148837_1_);
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_150787_b(this.field_149379_a);
      DataWatcher.func_151507_a(this.field_149378_b, p_148840_1_);
   }

   public void func_180748_a(INetHandlerPlayClient p_180748_1_) {
      p_180748_1_.func_147284_a(this);
   }

   public List func_149376_c() {
      return this.field_149378_b;
   }

   public int func_149375_d() {
      return this.field_149379_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180748_a((INetHandlerPlayClient)p_148833_1_);
   }
}
