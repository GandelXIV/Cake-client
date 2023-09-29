package net.minecraft.world.gen.structure;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.util.MathHelper;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureMineshaftStart;
import net.minecraft.world.gen.structure.StructureStart;

public class MapGenMineshaft extends MapGenStructure {

   private double field_82673_e = 0.004D;
   private static final String __OBFID = "CL_00000443";


   public MapGenMineshaft() {}

   public String func_143025_a() {
      return "Mineshaft";
   }

   public MapGenMineshaft(Map p_i2034_1_) {
      Iterator var2 = p_i2034_1_.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(((String)var3.getKey()).equals("chance")) {
            this.field_82673_e = MathHelper.func_82712_a((String)var3.getValue(), this.field_82673_e);
         }
      }

   }

   protected boolean func_75047_a(int p_75047_1_, int p_75047_2_) {
      return this.field_75038_b.nextDouble() < this.field_82673_e && this.field_75038_b.nextInt(80) < Math.max(Math.abs(p_75047_1_), Math.abs(p_75047_2_));
   }

   protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_) {
      return new StructureMineshaftStart(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_);
   }
}
