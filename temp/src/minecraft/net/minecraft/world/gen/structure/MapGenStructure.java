package net.minecraft.world.gen.structure;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ReportedException;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.structure.MapGenStructureData;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;

public abstract class MapGenStructure extends MapGenBase {

   private MapGenStructureData field_143029_e;
   protected Map field_75053_d = Maps.newHashMap();
   private static final String __OBFID = "CL_00000505";


   public abstract String func_143025_a();

   protected final void func_180701_a(World p_180701_1_, final int p_180701_2_, final int p_180701_3_, int p_180701_4_, int p_180701_5_, ChunkPrimer p_180701_6_) {
      this.func_143027_a(p_180701_1_);
      if(!this.field_75053_d.containsKey(Long.valueOf(ChunkCoordIntPair.func_77272_a(p_180701_2_, p_180701_3_)))) {
         this.field_75038_b.nextInt();

         try {
            if(this.func_75047_a(p_180701_2_, p_180701_3_)) {
               StructureStart var7 = this.func_75049_b(p_180701_2_, p_180701_3_);
               this.field_75053_d.put(Long.valueOf(ChunkCoordIntPair.func_77272_a(p_180701_2_, p_180701_3_)), var7);
               this.func_143026_a(p_180701_2_, p_180701_3_, var7);
            }

         } catch (Throwable var10) {
            CrashReport var8 = CrashReport.func_85055_a(var10, "Exception preparing structure feature");
            CrashReportCategory var9 = var8.func_85058_a("Feature being prepared");
            var9.func_71500_a("Is feature chunk", new Callable() {

               private static final String __OBFID = "CL_00000506";

               public String call() {
                  return MapGenStructure.this.func_75047_a(p_180701_2_, p_180701_3_)?"True":"False";
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            var9.func_71507_a("Chunk location", String.format("%d,%d", new Object[]{Integer.valueOf(p_180701_2_), Integer.valueOf(p_180701_3_)}));
            var9.func_71500_a("Chunk pos hash", new Callable() {

               private static final String __OBFID = "CL_00000507";

               public String call() {
                  return String.valueOf(ChunkCoordIntPair.func_77272_a(p_180701_2_, p_180701_3_));
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            var9.func_71500_a("Structure type", new Callable() {

               private static final String __OBFID = "CL_00000508";

               public String call() {
                  return MapGenStructure.this.getClass().getCanonicalName();
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            throw new ReportedException(var8);
         }
      }
   }

   public boolean func_175794_a(World p_175794_1_, Random p_175794_2_, ChunkCoordIntPair p_175794_3_) {
      this.func_143027_a(p_175794_1_);
      int var4 = (p_175794_3_.field_77276_a << 4) + 8;
      int var5 = (p_175794_3_.field_77275_b << 4) + 8;
      boolean var6 = false;
      Iterator var7 = this.field_75053_d.values().iterator();

      while(var7.hasNext()) {
         StructureStart var8 = (StructureStart)var7.next();
         if(var8.func_75069_d() && var8.func_175788_a(p_175794_3_) && var8.func_75071_a().func_78885_a(var4, var5, var4 + 15, var5 + 15)) {
            var8.func_75068_a(p_175794_1_, p_175794_2_, new StructureBoundingBox(var4, var5, var4 + 15, var5 + 15));
            var8.func_175787_b(p_175794_3_);
            var6 = true;
            this.func_143026_a(var8.func_143019_e(), var8.func_143018_f(), var8);
         }
      }

      return var6;
   }

   public boolean func_175795_b(BlockPos p_175795_1_) {
      this.func_143027_a(this.field_75039_c);
      return this.func_175797_c(p_175795_1_) != null;
   }

   protected StructureStart func_175797_c(BlockPos p_175797_1_) {
      Iterator var2 = this.field_75053_d.values().iterator();

      while(var2.hasNext()) {
         StructureStart var3 = (StructureStart)var2.next();
         if(var3.func_75069_d() && var3.func_75071_a().func_175898_b(p_175797_1_)) {
            Iterator var4 = var3.func_75073_b().iterator();

            while(var4.hasNext()) {
               StructureComponent var5 = (StructureComponent)var4.next();
               if(var5.func_74874_b().func_175898_b(p_175797_1_)) {
                  return var3;
               }
            }
         }
      }

      return null;
   }

   public boolean func_175796_a(World p_175796_1_, BlockPos p_175796_2_) {
      this.func_143027_a(p_175796_1_);
      Iterator var3 = this.field_75053_d.values().iterator();

      StructureStart var4;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         var4 = (StructureStart)var3.next();
      } while(!var4.func_75069_d() || !var4.func_75071_a().func_175898_b(p_175796_2_));

      return true;
   }

   public BlockPos func_180706_b(World p_180706_1_, BlockPos p_180706_2_) {
      this.field_75039_c = p_180706_1_;
      this.func_143027_a(p_180706_1_);
      this.field_75038_b.setSeed(p_180706_1_.func_72905_C());
      long var3 = this.field_75038_b.nextLong();
      long var5 = this.field_75038_b.nextLong();
      long var7 = (long)(p_180706_2_.func_177958_n() >> 4) * var3;
      long var9 = (long)(p_180706_2_.func_177952_p() >> 4) * var5;
      this.field_75038_b.setSeed(var7 ^ var9 ^ p_180706_1_.func_72905_C());
      this.func_180701_a(p_180706_1_, p_180706_2_.func_177958_n() >> 4, p_180706_2_.func_177952_p() >> 4, 0, 0, (ChunkPrimer)null);
      double var11 = Double.MAX_VALUE;
      BlockPos var13 = null;
      Iterator var14 = this.field_75053_d.values().iterator();

      BlockPos var17;
      double var18;
      while(var14.hasNext()) {
         StructureStart var15 = (StructureStart)var14.next();
         if(var15.func_75069_d()) {
            StructureComponent var16 = (StructureComponent)var15.func_75073_b().get(0);
            var17 = var16.func_180776_a();
            var18 = var17.func_177951_i(p_180706_2_);
            if(var18 < var11) {
               var11 = var18;
               var13 = var17;
            }
         }
      }

      if(var13 != null) {
         return var13;
      } else {
         List var20 = this.func_75052_o_();
         if(var20 != null) {
            BlockPos var21 = null;
            Iterator var22 = var20.iterator();

            while(var22.hasNext()) {
               var17 = (BlockPos)var22.next();
               var18 = var17.func_177951_i(p_180706_2_);
               if(var18 < var11) {
                  var11 = var18;
                  var21 = var17;
               }
            }

            return var21;
         } else {
            return null;
         }
      }
   }

   protected List func_75052_o_() {
      return null;
   }

   private void func_143027_a(World p_143027_1_) {
      if(this.field_143029_e == null) {
         this.field_143029_e = (MapGenStructureData)p_143027_1_.func_72943_a(MapGenStructureData.class, this.func_143025_a());
         if(this.field_143029_e == null) {
            this.field_143029_e = new MapGenStructureData(this.func_143025_a());
            p_143027_1_.func_72823_a(this.func_143025_a(), this.field_143029_e);
         } else {
            NBTTagCompound var2 = this.field_143029_e.func_143041_a();
            Iterator var3 = var2.func_150296_c().iterator();

            while(var3.hasNext()) {
               String var4 = (String)var3.next();
               NBTBase var5 = var2.func_74781_a(var4);
               if(var5.func_74732_a() == 10) {
                  NBTTagCompound var6 = (NBTTagCompound)var5;
                  if(var6.func_74764_b("ChunkX") && var6.func_74764_b("ChunkZ")) {
                     int var7 = var6.func_74762_e("ChunkX");
                     int var8 = var6.func_74762_e("ChunkZ");
                     StructureStart var9 = MapGenStructureIO.func_143035_a(var6, p_143027_1_);
                     if(var9 != null) {
                        this.field_75053_d.put(Long.valueOf(ChunkCoordIntPair.func_77272_a(var7, var8)), var9);
                     }
                  }
               }
            }
         }
      }

   }

   private void func_143026_a(int p_143026_1_, int p_143026_2_, StructureStart p_143026_3_) {
      this.field_143029_e.func_143043_a(p_143026_3_.func_143021_a(p_143026_1_, p_143026_2_), p_143026_1_, p_143026_2_);
      this.field_143029_e.func_76185_a();
   }

   protected abstract boolean func_75047_a(int var1, int var2);

   protected abstract StructureStart func_75049_b(int var1, int var2);
}
