package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

public class C19PacketResourcePackStatus implements Packet {

   private String field_179720_a;
   private C19PacketResourcePackStatus.Action field_179719_b;
   private static final String __OBFID = "CL_00002282";


   public C19PacketResourcePackStatus() {}

   public C19PacketResourcePackStatus(String p_i45935_1_, C19PacketResourcePackStatus.Action p_i45935_2_) {
      if(p_i45935_1_.length() > 40) {
         p_i45935_1_ = p_i45935_1_.substring(0, 40);
      }

      this.field_179720_a = p_i45935_1_;
      this.field_179719_b = p_i45935_2_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_179720_a = p_148837_1_.func_150789_c(40);
      this.field_179719_b = (C19PacketResourcePackStatus.Action)p_148837_1_.func_179257_a(C19PacketResourcePackStatus.Action.class);
   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_180714_a(this.field_179720_a);
      p_148840_1_.func_179249_a(this.field_179719_b);
   }

   public void func_179718_a(INetHandlerPlayServer p_179718_1_) {
      p_179718_1_.func_175086_a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_179718_a((INetHandlerPlayServer)p_148833_1_);
   }

   public static enum Action {

      SUCCESSFULLY_LOADED("SUCCESSFULLY_LOADED", 0),
      DECLINED("DECLINED", 1),
      FAILED_DOWNLOAD("FAILED_DOWNLOAD", 2),
      ACCEPTED("ACCEPTED", 3);
      // $FF: synthetic field
      private static final C19PacketResourcePackStatus.Action[] $VALUES = new C19PacketResourcePackStatus.Action[]{SUCCESSFULLY_LOADED, DECLINED, FAILED_DOWNLOAD, ACCEPTED};
      private static final String __OBFID = "CL_00002281";


      private Action(String p_i45934_1_, int p_i45934_2_) {}

   }
}
