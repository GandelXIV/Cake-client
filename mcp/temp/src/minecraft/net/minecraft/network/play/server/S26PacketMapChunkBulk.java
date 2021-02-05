package net.minecraft.network.play.server;

import java.io.IOException;
import java.util.List;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.play.server.S21PacketChunkData;
import net.minecraft.world.chunk.Chunk;

public class S26PacketMapChunkBulk implements Packet {

   private int[] field_149266_a;
   private int[] field_149264_b;
   private S21PacketChunkData.Extracted[] field_179755_c;
   private boolean field_149267_h;
   private static final String __OBFID = "CL_00001306";


   public S26PacketMapChunkBulk() {}

   public S26PacketMapChunkBulk(List p_i45197_1_) {
      int var2 = p_i45197_1_.size();
      this.field_149266_a = new int[var2];
      this.field_149264_b = new int[var2];
      this.field_179755_c = new S21PacketChunkData.Extracted[var2];
      this.field_149267_h = !((Chunk)p_i45197_1_.get(0)).func_177412_p().field_73011_w.func_177495_o();

      for(int var3 = 0; var3 < var2; ++var3) {
         Chunk var4 = (Chunk)p_i45197_1_.get(var3);
         S21PacketChunkData.Extracted var5 = S21PacketChunkData.func_179756_a(var4, true, this.field_149267_h, '\uffff');
         this.field_149266_a[var3] = var4.field_76635_g;
         this.field_149264_b[var3] = var4.field_76647_h;
         this.field_179755_c[var3] = var5;
      }

   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149267_h = p_148837_1_.readBoolean();
      int var2 = p_148837_1_.func_150792_a();
      this.field_149266_a = new int[var2];
      this.field_149264_b = new int[var2];
      this.field_179755_c = new S21PacketChunkData.Extracted[var2];

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         this.field_149266_a[var3] = p_148837_1_.readInt();
         this.field_149264_b[var3] = p_148837_1_.readInt();
         this.field_179755_c[var3] = new S21PacketChunkData.Extracted();
         this.field_179755_c[var3].field_150280_b = p_148837_1_.readShort() & '\uffff';
         this.field_179755_c[var3].field_150282_a = new byte[S21PacketChunkData.func_180737_a(Integer.bitCount(this.field_179755_c[var3].field_150280_b), this.field_149267_h, true)];
      }

      for(var3 = 0; var3 < var2; ++var3) {
         p_148837_1_.readBytes(this.field_179755_c[var3].field_150282_a);
      }

   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.writeBoolean(this.field_149267_h);
      p_148840_1_.func_150787_b(this.field_179755_c.length);

      int var2;
      for(var2 = 0; var2 < this.field_149266_a.length; ++var2) {
         p_148840_1_.writeInt(this.field_149266_a[var2]);
         p_148840_1_.writeInt(this.field_149264_b[var2]);
         p_148840_1_.writeShort((short)(this.field_179755_c[var2].field_150280_b & '\uffff'));
      }

      for(var2 = 0; var2 < this.field_149266_a.length; ++var2) {
         p_148840_1_.writeBytes(this.field_179755_c[var2].field_150282_a);
      }

   }

   public void func_180738_a(INetHandlerPlayClient p_180738_1_) {
      p_180738_1_.func_147269_a(this);
   }

   public int func_149255_a(int p_149255_1_) {
      return this.field_149266_a[p_149255_1_];
   }

   public int func_149253_b(int p_149253_1_) {
      return this.field_149264_b[p_149253_1_];
   }

   public int func_149254_d() {
      return this.field_149266_a.length;
   }

   public byte[] func_149256_c(int p_149256_1_) {
      return this.field_179755_c[p_149256_1_].field_150282_a;
   }

   public int func_179754_d(int p_179754_1_) {
      return this.field_179755_c[p_179754_1_].field_150280_b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180738_a((INetHandlerPlayClient)p_148833_1_);
   }
}
