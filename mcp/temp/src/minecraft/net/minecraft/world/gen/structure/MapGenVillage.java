package net.minecraft.world.gen.structure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.gen.structure.StructureVillagePieces;

public class MapGenVillage extends MapGenStructure {

   public static final List field_75055_e = Arrays.asList(new BiomeGenBase[]{BiomeGenBase.field_76772_c, BiomeGenBase.field_76769_d, BiomeGenBase.field_150588_X});
   private int field_75054_f;
   private int field_82665_g;
   private int field_82666_h;
   private static final String __OBFID = "CL_00000514";


   public MapGenVillage() {
      this.field_82665_g = 32;
      this.field_82666_h = 8;
   }

   public MapGenVillage(Map p_i2093_1_) {
      this();
      Iterator var2 = p_i2093_1_.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(((String)var3.getKey()).equals("size")) {
            this.field_75054_f = MathHelper.func_82714_a((String)var3.getValue(), this.field_75054_f, 0);
         } else if(((String)var3.getKey()).equals("distance")) {
            this.field_82665_g = MathHelper.func_82714_a((String)var3.getValue(), this.field_82665_g, this.field_82666_h + 1);
         }
      }

   }

   public String func_143025_a() {
      return "Village";
   }

   protected boolean func_75047_a(int p_75047_1_, int p_75047_2_) {
      int var3 = p_75047_1_;
      int var4 = p_75047_2_;
      if(p_75047_1_ < 0) {
         p_75047_1_ -= this.field_82665_g - 1;
      }

      if(p_75047_2_ < 0) {
         p_75047_2_ -= this.field_82665_g - 1;
      }

      int var5 = p_75047_1_ / this.field_82665_g;
      int var6 = p_75047_2_ / this.field_82665_g;
      Random var7 = this.field_75039_c.func_72843_D(var5, var6, 10387312);
      var5 *= this.field_82665_g;
      var6 *= this.field_82665_g;
      var5 += var7.nextInt(this.field_82665_g - this.field_82666_h);
      var6 += var7.nextInt(this.field_82665_g - this.field_82666_h);
      if(var3 == var5 && var4 == var6) {
         boolean var8 = this.field_75039_c.func_72959_q().func_76940_a(var3 * 16 + 8, var4 * 16 + 8, 0, field_75055_e);
         if(var8) {
            return true;
         }
      }

      return false;
   }

   protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_) {
      return new MapGenVillage.Start(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_, this.field_75054_f);
   }


   public static class Start extends StructureStart {

      private boolean field_75076_c;
      private static final String __OBFID = "CL_00000515";


      public Start() {}

      public Start(World p_i2092_1_, Random p_i2092_2_, int p_i2092_3_, int p_i2092_4_, int p_i2092_5_) {
         super(p_i2092_3_, p_i2092_4_);
         List var6 = StructureVillagePieces.func_75084_a(p_i2092_2_, p_i2092_5_);
         StructureVillagePieces.Start var7 = new StructureVillagePieces.Start(p_i2092_1_.func_72959_q(), 0, p_i2092_2_, (p_i2092_3_ << 4) + 2, (p_i2092_4_ << 4) + 2, var6, p_i2092_5_);
         this.field_75075_a.add(var7);
         var7.func_74861_a(var7, this.field_75075_a, p_i2092_2_);
         List var8 = var7.field_74930_j;
         List var9 = var7.field_74932_i;

         int var10;
         while(!var8.isEmpty() || !var9.isEmpty()) {
            StructureComponent var11;
            if(var8.isEmpty()) {
               var10 = p_i2092_2_.nextInt(var9.size());
               var11 = (StructureComponent)var9.remove(var10);
               var11.func_74861_a(var7, this.field_75075_a, p_i2092_2_);
            } else {
               var10 = p_i2092_2_.nextInt(var8.size());
               var11 = (StructureComponent)var8.remove(var10);
               var11.func_74861_a(var7, this.field_75075_a, p_i2092_2_);
            }
         }

         this.func_75072_c();
         var10 = 0;
         Iterator var13 = this.field_75075_a.iterator();

         while(var13.hasNext()) {
            StructureComponent var12 = (StructureComponent)var13.next();
            if(!(var12 instanceof StructureVillagePieces.Road)) {
               ++var10;
            }
         }

         this.field_75076_c = var10 > 2;
      }

      public boolean func_75069_d() {
         return this.field_75076_c;
      }

      public void func_143022_a(NBTTagCompound p_143022_1_) {
         super.func_143022_a(p_143022_1_);
         p_143022_1_.func_74757_a("Valid", this.field_75076_c);
      }

      public void func_143017_b(NBTTagCompound p_143017_1_) {
         super.func_143017_b(p_143017_1_);
         this.field_75076_c = p_143017_1_.func_74767_n("Valid");
      }
   }
}
