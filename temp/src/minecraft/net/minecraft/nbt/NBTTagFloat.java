package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTSizeTracker;
import net.minecraft.util.MathHelper;

public class NBTTagFloat extends NBTBase.NBTPrimitive {

   private float field_74750_a;
   private static final String __OBFID = "CL_00001220";


   NBTTagFloat() {}

   public NBTTagFloat(float p_i45131_1_) {
      this.field_74750_a = p_i45131_1_;
   }

   void func_74734_a(DataOutput p_74734_1_) throws IOException {
      p_74734_1_.writeFloat(this.field_74750_a);
   }

   void func_152446_a(DataInput p_152446_1_, int p_152446_2_, NBTSizeTracker p_152446_3_) throws IOException {
      p_152446_3_.func_152450_a(32L);
      this.field_74750_a = p_152446_1_.readFloat();
   }

   public byte func_74732_a() {
      return (byte)5;
   }

   public String toString() {
      return "" + this.field_74750_a + "f";
   }

   public NBTBase func_74737_b() {
      return new NBTTagFloat(this.field_74750_a);
   }

   public boolean equals(Object p_equals_1_) {
      if(super.equals(p_equals_1_)) {
         NBTTagFloat var2 = (NBTTagFloat)p_equals_1_;
         return this.field_74750_a == var2.field_74750_a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ Float.floatToIntBits(this.field_74750_a);
   }

   public long func_150291_c() {
      return (long)this.field_74750_a;
   }

   public int func_150287_d() {
      return MathHelper.func_76141_d(this.field_74750_a);
   }

   public short func_150289_e() {
      return (short)(MathHelper.func_76141_d(this.field_74750_a) & '\uffff');
   }

   public byte func_150290_f() {
      return (byte)(MathHelper.func_76141_d(this.field_74750_a) & 255);
   }

   public double func_150286_g() {
      return (double)this.field_74750_a;
   }

   public float func_150288_h() {
      return this.field_74750_a;
   }
}
