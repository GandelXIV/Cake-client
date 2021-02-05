package net.minecraft.network.play.server;

import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;

public class S37PacketStatistics implements Packet {

   private Map field_148976_a;
   private static final String __OBFID = "CL_00001283";


   public S37PacketStatistics() {}

   public S37PacketStatistics(Map p_i45173_1_) {
      this.field_148976_a = p_i45173_1_;
   }

   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
      p_148833_1_.func_147293_a(this);
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      int var2 = p_148837_1_.func_150792_a();
      this.field_148976_a = Maps.newHashMap();

      for(int var3 = 0; var3 < var2; ++var3) {
         StatBase var4 = StatList.func_151177_a(p_148837_1_.func_150789_c(32767));
         int var5 = p_148837_1_.func_150792_a();
         if(var4 != null) {
            this.field_148976_a.put(var4, Integer.valueOf(var5));
         }
      }

   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_150787_b(this.field_148976_a.size());
      Iterator var2 = this.field_148976_a.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         p_148840_1_.func_180714_a(((StatBase)var3.getKey()).field_75975_e);
         p_148840_1_.func_150787_b(((Integer)var3.getValue()).intValue());
      }

   }

   public Map func_148974_c() {
      return this.field_148976_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_148833_a((INetHandlerPlayClient)p_148833_1_);
   }
}
