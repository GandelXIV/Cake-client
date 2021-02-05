package net.minecraft.world.gen.structure;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentScatteredFeaturePieces;
import net.minecraft.world.gen.structure.MapGenNetherBridge;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureMineshaftPieces;
import net.minecraft.world.gen.structure.StructureMineshaftStart;
import net.minecraft.world.gen.structure.StructureNetherBridgePieces;
import net.minecraft.world.gen.structure.StructureOceanMonument;
import net.minecraft.world.gen.structure.StructureOceanMonumentPieces;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MapGenStructureIO {

   private static final Logger field_151687_a = LogManager.getLogger();
   private static Map field_143040_a = Maps.newHashMap();
   private static Map field_143038_b = Maps.newHashMap();
   private static Map field_143039_c = Maps.newHashMap();
   private static Map field_143037_d = Maps.newHashMap();
   private static final String __OBFID = "CL_00000509";


   private static void func_143034_b(Class p_143034_0_, String p_143034_1_) {
      field_143040_a.put(p_143034_1_, p_143034_0_);
      field_143038_b.put(p_143034_0_, p_143034_1_);
   }

   static void func_143031_a(Class p_143031_0_, String p_143031_1_) {
      field_143039_c.put(p_143031_1_, p_143031_0_);
      field_143037_d.put(p_143031_0_, p_143031_1_);
   }

   public static String func_143033_a(StructureStart p_143033_0_) {
      return (String)field_143038_b.get(p_143033_0_.getClass());
   }

   public static String func_143036_a(StructureComponent p_143036_0_) {
      return (String)field_143037_d.get(p_143036_0_.getClass());
   }

   public static StructureStart func_143035_a(NBTTagCompound p_143035_0_, World p_143035_1_) {
      StructureStart var2 = null;

      try {
         Class var3 = (Class)field_143040_a.get(p_143035_0_.func_74779_i("id"));
         if(var3 != null) {
            var2 = (StructureStart)var3.newInstance();
         }
      } catch (Exception var4) {
         field_151687_a.warn("Failed Start with id " + p_143035_0_.func_74779_i("id"));
         var4.printStackTrace();
      }

      if(var2 != null) {
         var2.func_143020_a(p_143035_1_, p_143035_0_);
      } else {
         field_151687_a.warn("Skipping Structure with id " + p_143035_0_.func_74779_i("id"));
      }

      return var2;
   }

   public static StructureComponent func_143032_b(NBTTagCompound p_143032_0_, World p_143032_1_) {
      StructureComponent var2 = null;

      try {
         Class var3 = (Class)field_143039_c.get(p_143032_0_.func_74779_i("id"));
         if(var3 != null) {
            var2 = (StructureComponent)var3.newInstance();
         }
      } catch (Exception var4) {
         field_151687_a.warn("Failed Piece with id " + p_143032_0_.func_74779_i("id"));
         var4.printStackTrace();
      }

      if(var2 != null) {
         var2.func_143009_a(p_143032_1_, p_143032_0_);
      } else {
         field_151687_a.warn("Skipping Piece with id " + p_143032_0_.func_74779_i("id"));
      }

      return var2;
   }

   static {
      func_143034_b(StructureMineshaftStart.class, "Mineshaft");
      func_143034_b(MapGenVillage.Start.class, "Village");
      func_143034_b(MapGenNetherBridge.Start.class, "Fortress");
      func_143034_b(MapGenStronghold.Start.class, "Stronghold");
      func_143034_b(MapGenScatteredFeature.Start.class, "Temple");
      func_143034_b(StructureOceanMonument.StartMonument.class, "Monument");
      StructureMineshaftPieces.func_143048_a();
      StructureVillagePieces.func_143016_a();
      StructureNetherBridgePieces.func_143049_a();
      StructureStrongholdPieces.func_143046_a();
      ComponentScatteredFeaturePieces.func_143045_a();
      StructureOceanMonumentPieces.func_175970_a();
   }
}
