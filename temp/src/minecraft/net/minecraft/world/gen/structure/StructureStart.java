package net.minecraft.world.gen.structure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public abstract class StructureStart {

   protected LinkedList field_75075_a = new LinkedList();
   protected StructureBoundingBox field_75074_b;
   private int field_143024_c;
   private int field_143023_d;
   private static final String __OBFID = "CL_00000513";


   public StructureStart() {}

   public StructureStart(int p_i43002_1_, int p_i43002_2_) {
      this.field_143024_c = p_i43002_1_;
      this.field_143023_d = p_i43002_2_;
   }

   public StructureBoundingBox func_75071_a() {
      return this.field_75074_b;
   }

   public LinkedList func_75073_b() {
      return this.field_75075_a;
   }

   public void func_75068_a(World p_75068_1_, Random p_75068_2_, StructureBoundingBox p_75068_3_) {
      Iterator var4 = this.field_75075_a.iterator();

      while(var4.hasNext()) {
         StructureComponent var5 = (StructureComponent)var4.next();
         if(var5.func_74874_b().func_78884_a(p_75068_3_) && !var5.func_74875_a(p_75068_1_, p_75068_2_, p_75068_3_)) {
            var4.remove();
         }
      }

   }

   protected void func_75072_c() {
      this.field_75074_b = StructureBoundingBox.func_78887_a();
      Iterator var1 = this.field_75075_a.iterator();

      while(var1.hasNext()) {
         StructureComponent var2 = (StructureComponent)var1.next();
         this.field_75074_b.func_78888_b(var2.func_74874_b());
      }

   }

   public NBTTagCompound func_143021_a(int p_143021_1_, int p_143021_2_) {
      NBTTagCompound var3 = new NBTTagCompound();
      var3.func_74778_a("id", MapGenStructureIO.func_143033_a(this));
      var3.func_74768_a("ChunkX", p_143021_1_);
      var3.func_74768_a("ChunkZ", p_143021_2_);
      var3.func_74782_a("BB", this.field_75074_b.func_151535_h());
      NBTTagList var4 = new NBTTagList();
      Iterator var5 = this.field_75075_a.iterator();

      while(var5.hasNext()) {
         StructureComponent var6 = (StructureComponent)var5.next();
         var4.func_74742_a(var6.func_143010_b());
      }

      var3.func_74782_a("Children", var4);
      this.func_143022_a(var3);
      return var3;
   }

   public void func_143022_a(NBTTagCompound p_143022_1_) {}

   public void func_143020_a(World p_143020_1_, NBTTagCompound p_143020_2_) {
      this.field_143024_c = p_143020_2_.func_74762_e("ChunkX");
      this.field_143023_d = p_143020_2_.func_74762_e("ChunkZ");
      if(p_143020_2_.func_74764_b("BB")) {
         this.field_75074_b = new StructureBoundingBox(p_143020_2_.func_74759_k("BB"));
      }

      NBTTagList var3 = p_143020_2_.func_150295_c("Children", 10);

      for(int var4 = 0; var4 < var3.func_74745_c(); ++var4) {
         this.field_75075_a.add(MapGenStructureIO.func_143032_b(var3.func_150305_b(var4), p_143020_1_));
      }

      this.func_143017_b(p_143020_2_);
   }

   public void func_143017_b(NBTTagCompound p_143017_1_) {}

   protected void func_75067_a(World p_75067_1_, Random p_75067_2_, int p_75067_3_) {
      int var4 = 63 - p_75067_3_;
      int var5 = this.field_75074_b.func_78882_c() + 1;
      if(var5 < var4) {
         var5 += p_75067_2_.nextInt(var4 - var5);
      }

      int var6 = var5 - this.field_75074_b.field_78894_e;
      this.field_75074_b.func_78886_a(0, var6, 0);
      Iterator var7 = this.field_75075_a.iterator();

      while(var7.hasNext()) {
         StructureComponent var8 = (StructureComponent)var7.next();
         var8.func_74874_b().func_78886_a(0, var6, 0);
      }

   }

   protected void func_75070_a(World p_75070_1_, Random p_75070_2_, int p_75070_3_, int p_75070_4_) {
      int var5 = p_75070_4_ - p_75070_3_ + 1 - this.field_75074_b.func_78882_c();
      boolean var6 = true;
      int var10;
      if(var5 > 1) {
         var10 = p_75070_3_ + p_75070_2_.nextInt(var5);
      } else {
         var10 = p_75070_3_;
      }

      int var7 = var10 - this.field_75074_b.field_78895_b;
      this.field_75074_b.func_78886_a(0, var7, 0);
      Iterator var8 = this.field_75075_a.iterator();

      while(var8.hasNext()) {
         StructureComponent var9 = (StructureComponent)var8.next();
         var9.func_74874_b().func_78886_a(0, var7, 0);
      }

   }

   public boolean func_75069_d() {
      return true;
   }

   public boolean func_175788_a(ChunkCoordIntPair p_175788_1_) {
      return true;
   }

   public void func_175787_b(ChunkCoordIntPair p_175787_1_) {}

   public int func_143019_e() {
      return this.field_143024_c;
   }

   public int func_143018_f() {
      return this.field_143023_d;
   }
}
