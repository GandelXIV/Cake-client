package net.minecraft.world.gen;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;

public class MapGenBase {

   protected int field_75040_a = 8;
   protected Random field_75038_b = new Random();
   protected World field_75039_c;
   private static final String __OBFID = "CL_00000394";


   public void func_175792_a(IChunkProvider p_175792_1_, World p_175792_2_, int p_175792_3_, int p_175792_4_, ChunkPrimer p_175792_5_) {
      int var6 = this.field_75040_a;
      this.field_75039_c = p_175792_2_;
      this.field_75038_b.setSeed(p_175792_2_.func_72905_C());
      long var7 = this.field_75038_b.nextLong();
      long var9 = this.field_75038_b.nextLong();

      for(int var11 = p_175792_3_ - var6; var11 <= p_175792_3_ + var6; ++var11) {
         for(int var12 = p_175792_4_ - var6; var12 <= p_175792_4_ + var6; ++var12) {
            long var13 = (long)var11 * var7;
            long var15 = (long)var12 * var9;
            this.field_75038_b.setSeed(var13 ^ var15 ^ p_175792_2_.func_72905_C());
            this.func_180701_a(p_175792_2_, var11, var12, p_175792_3_, p_175792_4_, p_175792_5_);
         }
      }

   }

   protected void func_180701_a(World p_180701_1_, int p_180701_2_, int p_180701_3_, int p_180701_4_, int p_180701_5_, ChunkPrimer p_180701_6_) {}
}
