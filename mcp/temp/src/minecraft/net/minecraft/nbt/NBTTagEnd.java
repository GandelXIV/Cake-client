package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTSizeTracker;

public class NBTTagEnd extends NBTBase {

   private static final String __OBFID = "CL_00001219";


   void func_152446_a(DataInput p_152446_1_, int p_152446_2_, NBTSizeTracker p_152446_3_) throws IOException {}

   void func_74734_a(DataOutput p_74734_1_) throws IOException {}

   public byte func_74732_a() {
      return (byte)0;
   }

   public String toString() {
      return "END";
   }

   public NBTBase func_74737_b() {
      return new NBTTagEnd();
   }
}
