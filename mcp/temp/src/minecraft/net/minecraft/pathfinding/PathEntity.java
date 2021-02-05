package net.minecraft.pathfinding;

import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.Vec3;

public class PathEntity {

   private final PathPoint[] field_75884_a;
   private int field_75882_b;
   private int field_75883_c;
   private static final String __OBFID = "CL_00000575";


   public PathEntity(PathPoint[] p_i2136_1_) {
      this.field_75884_a = p_i2136_1_;
      this.field_75883_c = p_i2136_1_.length;
   }

   public void func_75875_a() {
      ++this.field_75882_b;
   }

   public boolean func_75879_b() {
      return this.field_75882_b >= this.field_75883_c;
   }

   public PathPoint func_75870_c() {
      return this.field_75883_c > 0?this.field_75884_a[this.field_75883_c - 1]:null;
   }

   public PathPoint func_75877_a(int p_75877_1_) {
      return this.field_75884_a[p_75877_1_];
   }

   public int func_75874_d() {
      return this.field_75883_c;
   }

   public void func_75871_b(int p_75871_1_) {
      this.field_75883_c = p_75871_1_;
   }

   public int func_75873_e() {
      return this.field_75882_b;
   }

   public void func_75872_c(int p_75872_1_) {
      this.field_75882_b = p_75872_1_;
   }

   public Vec3 func_75881_a(Entity p_75881_1_, int p_75881_2_) {
      double var3 = (double)this.field_75884_a[p_75881_2_].field_75839_a + (double)((int)(p_75881_1_.field_70130_N + 1.0F)) * 0.5D;
      double var5 = (double)this.field_75884_a[p_75881_2_].field_75837_b;
      double var7 = (double)this.field_75884_a[p_75881_2_].field_75838_c + (double)((int)(p_75881_1_.field_70130_N + 1.0F)) * 0.5D;
      return new Vec3(var3, var5, var7);
   }

   public Vec3 func_75878_a(Entity p_75878_1_) {
      return this.func_75881_a(p_75878_1_, this.field_75882_b);
   }

   public boolean func_75876_a(PathEntity p_75876_1_) {
      if(p_75876_1_ == null) {
         return false;
      } else if(p_75876_1_.field_75884_a.length != this.field_75884_a.length) {
         return false;
      } else {
         for(int var2 = 0; var2 < this.field_75884_a.length; ++var2) {
            if(this.field_75884_a[var2].field_75839_a != p_75876_1_.field_75884_a[var2].field_75839_a || this.field_75884_a[var2].field_75837_b != p_75876_1_.field_75884_a[var2].field_75837_b || this.field_75884_a[var2].field_75838_c != p_75876_1_.field_75884_a[var2].field_75838_c) {
               return false;
            }
         }

         return true;
      }
   }

   public boolean func_75880_b(Vec3 p_75880_1_) {
      PathPoint var2 = this.func_75870_c();
      return var2 == null?false:var2.field_75839_a == (int)p_75880_1_.field_72450_a && var2.field_75838_c == (int)p_75880_1_.field_72449_c;
   }
}
