package net.minecraft.network.play.server;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

public class S20PacketEntityProperties implements Packet {

   private int field_149445_a;
   private final List field_149444_b = Lists.newArrayList();
   private static final String __OBFID = "CL_00001341";


   public S20PacketEntityProperties() {}

   public S20PacketEntityProperties(int p_i45236_1_, Collection p_i45236_2_) {
      this.field_149445_a = p_i45236_1_;
      Iterator var3 = p_i45236_2_.iterator();

      while(var3.hasNext()) {
         IAttributeInstance var4 = (IAttributeInstance)var3.next();
         this.field_149444_b.add(new S20PacketEntityProperties.Snapshot(var4.func_111123_a().func_111108_a(), var4.func_111125_b(), var4.func_111122_c()));
      }

   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149445_a = p_148837_1_.func_150792_a();
      int var2 = p_148837_1_.readInt();

      for(int var3 = 0; var3 < var2; ++var3) {
         String var4 = p_148837_1_.func_150789_c(64);
         double var5 = p_148837_1_.readDouble();
         ArrayList var7 = Lists.newArrayList();
         int var8 = p_148837_1_.func_150792_a();

         for(int var9 = 0; var9 < var8; ++var9) {
            UUID var10 = p_148837_1_.func_179253_g();
            var7.add(new AttributeModifier(var10, "Unknown synced attribute modifier", p_148837_1_.readDouble(), p_148837_1_.readByte()));
         }

         this.field_149444_b.add(new S20PacketEntityProperties.Snapshot(var4, var5, var7));
      }

   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_150787_b(this.field_149445_a);
      p_148840_1_.writeInt(this.field_149444_b.size());
      Iterator var2 = this.field_149444_b.iterator();

      while(var2.hasNext()) {
         S20PacketEntityProperties.Snapshot var3 = (S20PacketEntityProperties.Snapshot)var2.next();
         p_148840_1_.func_180714_a(var3.func_151409_a());
         p_148840_1_.writeDouble(var3.func_151410_b());
         p_148840_1_.func_150787_b(var3.func_151408_c().size());
         Iterator var4 = var3.func_151408_c().iterator();

         while(var4.hasNext()) {
            AttributeModifier var5 = (AttributeModifier)var4.next();
            p_148840_1_.func_179252_a(var5.func_111167_a());
            p_148840_1_.writeDouble(var5.func_111164_d());
            p_148840_1_.writeByte(var5.func_111169_c());
         }
      }

   }

   public void func_180754_a(INetHandlerPlayClient p_180754_1_) {
      p_180754_1_.func_147290_a(this);
   }

   public int func_149442_c() {
      return this.field_149445_a;
   }

   public List func_149441_d() {
      return this.field_149444_b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180754_a((INetHandlerPlayClient)p_148833_1_);
   }

   public class Snapshot {

      private final String field_151412_b;
      private final double field_151413_c;
      private final Collection field_151411_d;
      private static final String __OBFID = "CL_00001342";


      public Snapshot(String p_i45235_2_, double p_i45235_3_, Collection p_i45235_5_) {
         this.field_151412_b = p_i45235_2_;
         this.field_151413_c = p_i45235_3_;
         this.field_151411_d = p_i45235_5_;
      }

      public String func_151409_a() {
         return this.field_151412_b;
      }

      public double func_151410_b() {
         return this.field_151413_c;
      }

      public Collection func_151408_c() {
         return this.field_151411_d;
      }
   }
}
