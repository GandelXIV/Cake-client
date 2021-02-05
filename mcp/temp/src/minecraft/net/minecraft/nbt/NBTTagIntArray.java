package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTSizeTracker;

public class NBTTagIntArray extends NBTBase {

   private int[] field_74749_a;
   private static final String __OBFID = "CL_00001221";


   NBTTagIntArray() {}

   public NBTTagIntArray(int[] p_i45132_1_) {
      this.field_74749_a = p_i45132_1_;
   }

   void func_74734_a(DataOutput p_74734_1_) throws IOException {
      p_74734_1_.writeInt(this.field_74749_a.length);

      for(int var2 = 0; var2 < this.field_74749_a.length; ++var2) {
         p_74734_1_.writeInt(this.field_74749_a[var2]);
      }

   }

   void func_152446_a(DataInput p_152446_1_, int p_152446_2_, NBTSizeTracker p_152446_3_) throws IOException {
      int var4 = p_152446_1_.readInt();
      p_152446_3_.func_152450_a((long)(32 * var4));
      this.field_74749_a = new int[var4];

      for(int var5 = 0; var5 < var4; ++var5) {
         this.field_74749_a[var5] = p_152446_1_.readInt();
      }

   }

   public byte func_74732_a() {
      return (byte)11;
   }

   public String toString() {
      String var1 = "[";
      int[] var2 = this.field_74749_a;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var2[var4];
         var1 = var1 + var5 + ",";
      }

      return var1 + "]";
   }

   public NBTBase func_74737_b() {
      int[] var1 = new int[this.field_74749_a.length];
      System.arraycopy(this.field_74749_a, 0, var1, 0, this.field_74749_a.length);
      return new NBTTagIntArray(var1);
   }

   public boolean equals(Object p_equals_1_) {
      return super.equals(p_equals_1_)?Arrays.equals(this.field_74749_a, ((NBTTagIntArray)p_equals_1_).field_74749_a):false;
   }

   public int hashCode() {
      return super.hashCode() ^ Arrays.hashCode(this.field_74749_a);
   }

   public int[] func_150302_c() {
      return this.field_74749_a;
   }
}
