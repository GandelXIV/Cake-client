package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTSizeTracker;

public class NBTTagByte extends NBTBase.NBTPrimitive {

   private byte field_74756_a;
   private static final String __OBFID = "CL_00001214";


   NBTTagByte() {}

   public NBTTagByte(byte p_i45129_1_) {
      this.field_74756_a = p_i45129_1_;
   }

   void func_74734_a(DataOutput p_74734_1_) throws IOException {
      p_74734_1_.writeByte(this.field_74756_a);
   }

   void func_152446_a(DataInput p_152446_1_, int p_152446_2_, NBTSizeTracker p_152446_3_) throws IOException {
      p_152446_3_.func_152450_a(8L);
      this.field_74756_a = p_152446_1_.readByte();
   }

   public byte func_74732_a() {
      return (byte)1;
   }

   public String toString() {
      return "" + this.field_74756_a + "b";
   }

   public NBTBase func_74737_b() {
      return new NBTTagByte(this.field_74756_a);
   }

   public boolean equals(Object p_equals_1_) {
      if(super.equals(p_equals_1_)) {
         NBTTagByte var2 = (NBTTagByte)p_equals_1_;
         return this.field_74756_a == var2.field_74756_a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.field_74756_a;
   }

   public long func_150291_c() {
      return (long)this.field_74756_a;
   }

   public int func_150287_d() {
      return this.field_74756_a;
   }

   public short func_150289_e() {
      return (short)this.field_74756_a;
   }

   public byte func_150290_f() {
      return this.field_74756_a;
   }

   public double func_150286_g() {
      return (double)this.field_74756_a;
   }

   public float func_150288_h() {
      return (float)this.field_74756_a;
   }
}
