package net.minecraft.network.play.server;

import java.io.IOException;
import java.util.Collection;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.Vec4b;
import net.minecraft.world.storage.MapData;

public class S34PacketMaps implements Packet {

   private int field_149191_a;
   private byte field_179739_b;
   private Vec4b[] field_179740_c;
   private int field_179737_d;
   private int field_179738_e;
   private int field_179735_f;
   private int field_179736_g;
   private byte[] field_179741_h;
   private static final String __OBFID = "CL_00001311";


   public S34PacketMaps() {}

   public S34PacketMaps(int p_i45975_1_, byte p_i45975_2_, Collection p_i45975_3_, byte[] p_i45975_4_, int p_i45975_5_, int p_i45975_6_, int p_i45975_7_, int p_i45975_8_) {
      this.field_149191_a = p_i45975_1_;
      this.field_179739_b = p_i45975_2_;
      this.field_179740_c = (Vec4b[])p_i45975_3_.toArray(new Vec4b[p_i45975_3_.size()]);
      this.field_179737_d = p_i45975_5_;
      this.field_179738_e = p_i45975_6_;
      this.field_179735_f = p_i45975_7_;
      this.field_179736_g = p_i45975_8_;
      this.field_179741_h = new byte[p_i45975_7_ * p_i45975_8_];

      for(int var9 = 0; var9 < p_i45975_7_; ++var9) {
         for(int var10 = 0; var10 < p_i45975_8_; ++var10) {
            this.field_179741_h[var9 + var10 * p_i45975_7_] = p_i45975_4_[p_i45975_5_ + var9 + (p_i45975_6_ + var10) * 128];
         }
      }

   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149191_a = p_148837_1_.func_150792_a();
      this.field_179739_b = p_148837_1_.readByte();
      this.field_179740_c = new Vec4b[p_148837_1_.func_150792_a()];

      for(int var2 = 0; var2 < this.field_179740_c.length; ++var2) {
         short var3 = (short)p_148837_1_.readByte();
         this.field_179740_c[var2] = new Vec4b((byte)(var3 >> 4 & 15), p_148837_1_.readByte(), p_148837_1_.readByte(), (byte)(var3 & 15));
      }

      this.field_179735_f = p_148837_1_.readUnsignedByte();
      if(this.field_179735_f > 0) {
         this.field_179736_g = p_148837_1_.readUnsignedByte();
         this.field_179737_d = p_148837_1_.readUnsignedByte();
         this.field_179738_e = p_148837_1_.readUnsignedByte();
         this.field_179741_h = p_148837_1_.func_179251_a();
      }

   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_150787_b(this.field_149191_a);
      p_148840_1_.writeByte(this.field_179739_b);
      p_148840_1_.func_150787_b(this.field_179740_c.length);
      Vec4b[] var2 = this.field_179740_c;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Vec4b var5 = var2[var4];
         p_148840_1_.writeByte((var5.func_176110_a() & 15) << 4 | var5.func_176111_d() & 15);
         p_148840_1_.writeByte(var5.func_176112_b());
         p_148840_1_.writeByte(var5.func_176113_c());
      }

      p_148840_1_.writeByte(this.field_179735_f);
      if(this.field_179735_f > 0) {
         p_148840_1_.writeByte(this.field_179736_g);
         p_148840_1_.writeByte(this.field_179737_d);
         p_148840_1_.writeByte(this.field_179738_e);
         p_148840_1_.func_179250_a(this.field_179741_h);
      }

   }

   public void func_180741_a(INetHandlerPlayClient p_180741_1_) {
      p_180741_1_.func_147264_a(this);
   }

   public int func_149188_c() {
      return this.field_149191_a;
   }

   public void func_179734_a(MapData p_179734_1_) {
      p_179734_1_.field_76197_d = this.field_179739_b;
      p_179734_1_.field_76203_h.clear();

      int var2;
      for(var2 = 0; var2 < this.field_179740_c.length; ++var2) {
         Vec4b var3 = this.field_179740_c[var2];
         p_179734_1_.field_76203_h.put("icon-" + var2, var3);
      }

      for(var2 = 0; var2 < this.field_179735_f; ++var2) {
         for(int var4 = 0; var4 < this.field_179736_g; ++var4) {
            p_179734_1_.field_76198_e[this.field_179737_d + var2 + (this.field_179738_e + var4) * 128] = this.field_179741_h[var2 + var4 * this.field_179735_f];
         }
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180741_a((INetHandlerPlayClient)p_148833_1_);
   }
}
