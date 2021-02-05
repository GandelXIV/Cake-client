package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.chunk.Chunk;

public class S22PacketMultiBlockChange implements Packet {

   private ChunkCoordIntPair field_148925_b;
   private S22PacketMultiBlockChange.BlockUpdateData[] field_179845_b;
   private static final String __OBFID = "CL_00001290";


   public S22PacketMultiBlockChange() {}

   public S22PacketMultiBlockChange(int p_i45181_1_, short[] p_i45181_2_, Chunk p_i45181_3_) {
      this.field_148925_b = new ChunkCoordIntPair(p_i45181_3_.field_76635_g, p_i45181_3_.field_76647_h);
      this.field_179845_b = new S22PacketMultiBlockChange.BlockUpdateData[p_i45181_1_];

      for(int var4 = 0; var4 < this.field_179845_b.length; ++var4) {
         this.field_179845_b[var4] = new S22PacketMultiBlockChange.BlockUpdateData(p_i45181_2_[var4], p_i45181_3_);
      }

   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_148925_b = new ChunkCoordIntPair(p_148837_1_.readInt(), p_148837_1_.readInt());
      this.field_179845_b = new S22PacketMultiBlockChange.BlockUpdateData[p_148837_1_.func_150792_a()];

      for(int var2 = 0; var2 < this.field_179845_b.length; ++var2) {
         this.field_179845_b[var2] = new S22PacketMultiBlockChange.BlockUpdateData(p_148837_1_.readShort(), (IBlockState)Block.field_176229_d.func_148745_a(p_148837_1_.func_150792_a()));
      }

   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.writeInt(this.field_148925_b.field_77276_a);
      p_148840_1_.writeInt(this.field_148925_b.field_77275_b);
      p_148840_1_.func_150787_b(this.field_179845_b.length);
      S22PacketMultiBlockChange.BlockUpdateData[] var2 = this.field_179845_b;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         S22PacketMultiBlockChange.BlockUpdateData var5 = var2[var4];
         p_148840_1_.writeShort(var5.func_180089_b());
         p_148840_1_.func_150787_b(Block.field_176229_d.func_148747_b(var5.func_180088_c()));
      }

   }

   public void func_180729_a(INetHandlerPlayClient p_180729_1_) {
      p_180729_1_.func_147287_a(this);
   }

   public S22PacketMultiBlockChange.BlockUpdateData[] func_179844_a() {
      return this.field_179845_b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180729_a((INetHandlerPlayClient)p_148833_1_);
   }

   public class BlockUpdateData {

      private final short field_180091_b;
      private final IBlockState field_180092_c;
      private static final String __OBFID = "CL_00002302";


      public BlockUpdateData(short p_i45984_2_, IBlockState p_i45984_3_) {
         this.field_180091_b = p_i45984_2_;
         this.field_180092_c = p_i45984_3_;
      }

      public BlockUpdateData(short p_i45985_2_, Chunk p_i45985_3_) {
         this.field_180091_b = p_i45985_2_;
         this.field_180092_c = p_i45985_3_.func_177435_g(this.func_180090_a());
      }

      public BlockPos func_180090_a() {
         return new BlockPos(S22PacketMultiBlockChange.this.field_148925_b.func_180331_a(this.field_180091_b >> 12 & 15, this.field_180091_b & 255, this.field_180091_b >> 8 & 15));
      }

      public short func_180089_b() {
         return this.field_180091_b;
      }

      public IBlockState func_180088_c() {
         return this.field_180092_c;
      }
   }
}
