package net.minecraft.world.gen.structure;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

public class MapGenStronghold extends MapGenStructure {

   private List field_151546_e;
   private boolean field_75056_f;
   private ChunkCoordIntPair[] field_75057_g;
   private double field_82671_h;
   private int field_82672_i;
   private static final String __OBFID = "CL_00000481";


   public MapGenStronghold() {
      this.field_75057_g = new ChunkCoordIntPair[3];
      this.field_82671_h = 32.0D;
      this.field_82672_i = 3;
      this.field_151546_e = Lists.newArrayList();
      BiomeGenBase[] var1 = BiomeGenBase.func_150565_n();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         BiomeGenBase var4 = var1[var3];
         if(var4 != null && var4.field_76748_D > 0.0F) {
            this.field_151546_e.add(var4);
         }
      }

   }

   public MapGenStronghold(Map p_i2068_1_) {
      this();
      Iterator var2 = p_i2068_1_.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(((String)var3.getKey()).equals("distance")) {
            this.field_82671_h = MathHelper.func_82713_a((String)var3.getValue(), this.field_82671_h, 1.0D);
         } else if(((String)var3.getKey()).equals("count")) {
            this.field_75057_g = new ChunkCoordIntPair[MathHelper.func_82714_a((String)var3.getValue(), this.field_75057_g.length, 1)];
         } else if(((String)var3.getKey()).equals("spread")) {
            this.field_82672_i = MathHelper.func_82714_a((String)var3.getValue(), this.field_82672_i, 1);
         }
      }

   }

   public String func_143025_a() {
      return "Stronghold";
   }

   protected boolean func_75047_a(int p_75047_1_, int p_75047_2_) {
      if(!this.field_75056_f) {
         Random var3 = new Random();
         var3.setSeed(this.field_75039_c.func_72905_C());
         double var4 = var3.nextDouble() * 3.141592653589793D * 2.0D;
         int var6 = 1;

         for(int var7 = 0; var7 < this.field_75057_g.length; ++var7) {
            double var8 = (1.25D * (double)var6 + var3.nextDouble()) * this.field_82671_h * (double)var6;
            int var10 = (int)Math.round(Math.cos(var4) * var8);
            int var11 = (int)Math.round(Math.sin(var4) * var8);
            BlockPos var12 = this.field_75039_c.func_72959_q().func_180630_a((var10 << 4) + 8, (var11 << 4) + 8, 112, this.field_151546_e, var3);
            if(var12 != null) {
               var10 = var12.func_177958_n() >> 4;
               var11 = var12.func_177952_p() >> 4;
            }

            this.field_75057_g[var7] = new ChunkCoordIntPair(var10, var11);
            var4 += 6.283185307179586D * (double)var6 / (double)this.field_82672_i;
            if(var7 == this.field_82672_i) {
               var6 += 2 + var3.nextInt(5);
               this.field_82672_i += 1 + var3.nextInt(2);
            }
         }

         this.field_75056_f = true;
      }

      ChunkCoordIntPair[] var13 = this.field_75057_g;
      int var14 = var13.length;

      for(int var5 = 0; var5 < var14; ++var5) {
         ChunkCoordIntPair var15 = var13[var5];
         if(p_75047_1_ == var15.field_77276_a && p_75047_2_ == var15.field_77275_b) {
            return true;
         }
      }

      return false;
   }

   protected List func_75052_o_() {
      ArrayList var1 = Lists.newArrayList();
      ChunkCoordIntPair[] var2 = this.field_75057_g;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ChunkCoordIntPair var5 = var2[var4];
         if(var5 != null) {
            var1.add(var5.func_180619_a(64));
         }
      }

      return var1;
   }

   protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_) {
      MapGenStronghold.Start var3;
      for(var3 = new MapGenStronghold.Start(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_); var3.func_75073_b().isEmpty() || ((StructureStrongholdPieces.Stairs2)var3.func_75073_b().get(0)).field_75025_b == null; var3 = new MapGenStronghold.Start(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_)) {
         ;
      }

      return var3;
   }

   public static class Start extends StructureStart {

      private static final String __OBFID = "CL_00000482";


      public Start() {}

      public Start(World p_i2067_1_, Random p_i2067_2_, int p_i2067_3_, int p_i2067_4_) {
         super(p_i2067_3_, p_i2067_4_);
         StructureStrongholdPieces.func_75198_a();
         StructureStrongholdPieces.Stairs2 var5 = new StructureStrongholdPieces.Stairs2(0, p_i2067_2_, (p_i2067_3_ << 4) + 2, (p_i2067_4_ << 4) + 2);
         this.field_75075_a.add(var5);
         var5.func_74861_a(var5, this.field_75075_a, p_i2067_2_);
         List var6 = var5.field_75026_c;

         while(!var6.isEmpty()) {
            int var7 = p_i2067_2_.nextInt(var6.size());
            StructureComponent var8 = (StructureComponent)var6.remove(var7);
            var8.func_74861_a(var5, this.field_75075_a, p_i2067_2_);
         }

         this.func_75072_c();
         this.func_75067_a(p_i2067_1_, p_i2067_2_, 10);
      }
   }
}
