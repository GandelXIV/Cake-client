package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;

public class BlockEventData {

   private BlockPos field_180329_a;
   private Block field_151344_d;
   private int field_151345_e;
   private int field_151343_f;
   private static final String __OBFID = "CL_00000131";


   public BlockEventData(BlockPos p_i45756_1_, Block p_i45756_2_, int p_i45756_3_, int p_i45756_4_) {
      this.field_180329_a = p_i45756_1_;
      this.field_151345_e = p_i45756_3_;
      this.field_151343_f = p_i45756_4_;
      this.field_151344_d = p_i45756_2_;
   }

   public BlockPos func_180328_a() {
      return this.field_180329_a;
   }

   public int func_151339_d() {
      return this.field_151345_e;
   }

   public int func_151338_e() {
      return this.field_151343_f;
   }

   public Block func_151337_f() {
      return this.field_151344_d;
   }

   public boolean equals(Object p_equals_1_) {
      if(!(p_equals_1_ instanceof BlockEventData)) {
         return false;
      } else {
         BlockEventData var2 = (BlockEventData)p_equals_1_;
         return this.field_180329_a.equals(var2.field_180329_a) && this.field_151345_e == var2.field_151345_e && this.field_151343_f == var2.field_151343_f && this.field_151344_d == var2.field_151344_d;
      }
   }

   public String toString() {
      return "TE(" + this.field_180329_a + ")," + this.field_151345_e + "," + this.field_151343_f + "," + this.field_151344_d;
   }
}
