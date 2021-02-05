package net.minecraft.nbt;

import com.google.common.collect.Lists;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTSizeTracker;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagEnd;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagIntArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NBTTagList extends NBTBase {

   private static final Logger field_179239_b = LogManager.getLogger();
   private List field_74747_a = Lists.newArrayList();
   private byte field_74746_b = 0;
   private static final String __OBFID = "CL_00001224";


   void func_74734_a(DataOutput p_74734_1_) throws IOException {
      if(!this.field_74747_a.isEmpty()) {
         this.field_74746_b = ((NBTBase)this.field_74747_a.get(0)).func_74732_a();
      } else {
         this.field_74746_b = 0;
      }

      p_74734_1_.writeByte(this.field_74746_b);
      p_74734_1_.writeInt(this.field_74747_a.size());

      for(int var2 = 0; var2 < this.field_74747_a.size(); ++var2) {
         ((NBTBase)this.field_74747_a.get(var2)).func_74734_a(p_74734_1_);
      }

   }

   void func_152446_a(DataInput p_152446_1_, int p_152446_2_, NBTSizeTracker p_152446_3_) throws IOException {
      if(p_152446_2_ > 512) {
         throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
      } else {
         p_152446_3_.func_152450_a(8L);
         this.field_74746_b = p_152446_1_.readByte();
         int var4 = p_152446_1_.readInt();
         this.field_74747_a = Lists.newArrayList();

         for(int var5 = 0; var5 < var4; ++var5) {
            NBTBase var6 = NBTBase.func_150284_a(this.field_74746_b);
            var6.func_152446_a(p_152446_1_, p_152446_2_ + 1, p_152446_3_);
            this.field_74747_a.add(var6);
         }

      }
   }

   public byte func_74732_a() {
      return (byte)9;
   }

   public String toString() {
      String var1 = "[";
      int var2 = 0;

      for(Iterator var3 = this.field_74747_a.iterator(); var3.hasNext(); ++var2) {
         NBTBase var4 = (NBTBase)var3.next();
         var1 = var1 + "" + var2 + ':' + var4 + ',';
      }

      return var1 + "]";
   }

   public void func_74742_a(NBTBase p_74742_1_) {
      if(this.field_74746_b == 0) {
         this.field_74746_b = p_74742_1_.func_74732_a();
      } else if(this.field_74746_b != p_74742_1_.func_74732_a()) {
         field_179239_b.warn("Adding mismatching tag types to tag list");
         return;
      }

      this.field_74747_a.add(p_74742_1_);
   }

   public void func_150304_a(int p_150304_1_, NBTBase p_150304_2_) {
      if(p_150304_1_ >= 0 && p_150304_1_ < this.field_74747_a.size()) {
         if(this.field_74746_b == 0) {
            this.field_74746_b = p_150304_2_.func_74732_a();
         } else if(this.field_74746_b != p_150304_2_.func_74732_a()) {
            field_179239_b.warn("Adding mismatching tag types to tag list");
            return;
         }

         this.field_74747_a.set(p_150304_1_, p_150304_2_);
      } else {
         field_179239_b.warn("index out of bounds to set tag in tag list");
      }
   }

   public NBTBase func_74744_a(int p_74744_1_) {
      return (NBTBase)this.field_74747_a.remove(p_74744_1_);
   }

   public boolean func_82582_d() {
      return this.field_74747_a.isEmpty();
   }

   public NBTTagCompound func_150305_b(int p_150305_1_) {
      if(p_150305_1_ >= 0 && p_150305_1_ < this.field_74747_a.size()) {
         NBTBase var2 = (NBTBase)this.field_74747_a.get(p_150305_1_);
         return var2.func_74732_a() == 10?(NBTTagCompound)var2:new NBTTagCompound();
      } else {
         return new NBTTagCompound();
      }
   }

   public int[] func_150306_c(int p_150306_1_) {
      if(p_150306_1_ >= 0 && p_150306_1_ < this.field_74747_a.size()) {
         NBTBase var2 = (NBTBase)this.field_74747_a.get(p_150306_1_);
         return var2.func_74732_a() == 11?((NBTTagIntArray)var2).func_150302_c():new int[0];
      } else {
         return new int[0];
      }
   }

   public double func_150309_d(int p_150309_1_) {
      if(p_150309_1_ >= 0 && p_150309_1_ < this.field_74747_a.size()) {
         NBTBase var2 = (NBTBase)this.field_74747_a.get(p_150309_1_);
         return var2.func_74732_a() == 6?((NBTTagDouble)var2).func_150286_g():0.0D;
      } else {
         return 0.0D;
      }
   }

   public float func_150308_e(int p_150308_1_) {
      if(p_150308_1_ >= 0 && p_150308_1_ < this.field_74747_a.size()) {
         NBTBase var2 = (NBTBase)this.field_74747_a.get(p_150308_1_);
         return var2.func_74732_a() == 5?((NBTTagFloat)var2).func_150288_h():0.0F;
      } else {
         return 0.0F;
      }
   }

   public String func_150307_f(int p_150307_1_) {
      if(p_150307_1_ >= 0 && p_150307_1_ < this.field_74747_a.size()) {
         NBTBase var2 = (NBTBase)this.field_74747_a.get(p_150307_1_);
         return var2.func_74732_a() == 8?var2.func_150285_a_():var2.toString();
      } else {
         return "";
      }
   }

   public NBTBase func_179238_g(int p_179238_1_) {
      return (NBTBase)(p_179238_1_ >= 0 && p_179238_1_ < this.field_74747_a.size()?(NBTBase)this.field_74747_a.get(p_179238_1_):new NBTTagEnd());
   }

   public int func_74745_c() {
      return this.field_74747_a.size();
   }

   public NBTBase func_74737_b() {
      NBTTagList var1 = new NBTTagList();
      var1.field_74746_b = this.field_74746_b;
      Iterator var2 = this.field_74747_a.iterator();

      while(var2.hasNext()) {
         NBTBase var3 = (NBTBase)var2.next();
         NBTBase var4 = var3.func_74737_b();
         var1.field_74747_a.add(var4);
      }

      return var1;
   }

   public boolean equals(Object p_equals_1_) {
      if(super.equals(p_equals_1_)) {
         NBTTagList var2 = (NBTTagList)p_equals_1_;
         if(this.field_74746_b == var2.field_74746_b) {
            return this.field_74747_a.equals(var2.field_74747_a);
         }
      }

      return false;
   }

   public int hashCode() {
      return super.hashCode() ^ this.field_74747_a.hashCode();
   }

   public int func_150303_d() {
      return this.field_74746_b;
   }

}
