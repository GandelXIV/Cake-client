package net.minecraft.world;

import net.minecraft.nbt.NBTTagCompound;

public abstract class WorldSavedData {

   public final String field_76190_i;
   private boolean field_76189_a;
   private static final String __OBFID = "CL_00000580";


   public WorldSavedData(String p_i2141_1_) {
      this.field_76190_i = p_i2141_1_;
   }

   public abstract void func_76184_a(NBTTagCompound var1);

   public abstract void func_76187_b(NBTTagCompound var1);

   public void func_76185_a() {
      this.func_76186_a(true);
   }

   public void func_76186_a(boolean p_76186_1_) {
      this.field_76189_a = p_76186_1_;
   }

   public boolean func_76188_b() {
      return this.field_76189_a;
   }
}
