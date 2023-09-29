package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTSizeTracker;

public class NBTTagShort extends NBTBase.NBTPrimitive {

   private short field_74752_a;
   private static final String __OBFID = "CL_00001227";


   public NBTTagShort() {}

   public NBTTagShort(short p_i45135_1_) {
      this.field_74752_a = p_i45135_1_;
   }

   void func_74734_a(DataOutput p_74734_1_) throws IOException {
      p_74734_1_.writeShort(this.field_74752_a);
   }

   void func_152446_a(DataInput p_152446_1_, int p_152446_2_, NBTSizeTracker p_152446_3_) throws IOException {
      p_152446_3_.func_152450_a(16L);
      this.field_74752_a = p_152446_1_.readShort();
   }

   public byte func_74732_a() {
      return (byte)2;
   }

   public String toString() {
      return "" + this.field_74752_a + "s";
   }

   public NBTBase func_74737_b() {
      return new NBTTagShort(this.field_74752_a);
   }

   public boolean equals(Object p_equals_1_) {
      if(super.equals(p_equals_1_)) {
         NBTTagShort var2 = (NBTTagShort)p_equals_1_;
         return this.field_74752_a == var2.field_74752_a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.field_74752_a;
   }

   public long func_150291_c() {
      return (long)this.field_74752_a;
   }

   public int func_150287_d() {
      return this.field_74752_a;
   }

   public short func_150289_e() {
      return this.field_74752_a;
   }

   public byte func_150290_f() {
      return (byte)(this.field_74752_a & 255);
   }

   public double func_150286_g() {
      return (double)this.field_74752_a;
   }

   public float func_150288_h() {
      return (float)this.field_74752_a;
   }
}
