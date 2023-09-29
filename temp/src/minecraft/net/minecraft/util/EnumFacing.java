package net.minecraft.util;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3i;

public enum EnumFacing implements IStringSerializable {

   DOWN("DOWN", 0, 0, 1, -1, "down", EnumFacing.AxisDirection.NEGATIVE, EnumFacing.Axis.Y, new Vec3i(0, -1, 0)),
   UP("UP", 1, 1, 0, -1, "up", EnumFacing.AxisDirection.POSITIVE, EnumFacing.Axis.Y, new Vec3i(0, 1, 0)),
   NORTH("NORTH", 2, 2, 3, 2, "north", EnumFacing.AxisDirection.NEGATIVE, EnumFacing.Axis.Z, new Vec3i(0, 0, -1)),
   SOUTH("SOUTH", 3, 3, 2, 0, "south", EnumFacing.AxisDirection.POSITIVE, EnumFacing.Axis.Z, new Vec3i(0, 0, 1)),
   WEST("WEST", 4, 4, 5, 1, "west", EnumFacing.AxisDirection.NEGATIVE, EnumFacing.Axis.X, new Vec3i(-1, 0, 0)),
   EAST("EAST", 5, 5, 4, 3, "east", EnumFacing.AxisDirection.POSITIVE, EnumFacing.Axis.X, new Vec3i(1, 0, 0));
   private final int field_176748_g;
   private final int field_176759_h;
   private final int field_176760_i;
   private final String field_176757_j;
   private final EnumFacing.Axis field_176758_k;
   private final EnumFacing.AxisDirection field_176755_l;
   private final Vec3i field_176756_m;
   private static final EnumFacing[] field_82609_l = new EnumFacing[6];
   private static final EnumFacing[] field_176754_o = new EnumFacing[4];
   private static final Map field_176761_p = Maps.newHashMap();
   // $FF: synthetic field
   private static final EnumFacing[] $VALUES = new EnumFacing[]{DOWN, UP, NORTH, SOUTH, WEST, EAST};
   private static final String __OBFID = "CL_00001201";


   private EnumFacing(String p_i46016_1_, int p_i46016_2_, int p_i46016_3_, int p_i46016_4_, int p_i46016_5_, String p_i46016_6_, EnumFacing.AxisDirection p_i46016_7_, EnumFacing.Axis p_i46016_8_, Vec3i p_i46016_9_) {
      this.field_176748_g = p_i46016_3_;
      this.field_176760_i = p_i46016_5_;
      this.field_176759_h = p_i46016_4_;
      this.field_176757_j = p_i46016_6_;
      this.field_176758_k = p_i46016_8_;
      this.field_176755_l = p_i46016_7_;
      this.field_176756_m = p_i46016_9_;
   }

   public int func_176745_a() {
      return this.field_176748_g;
   }

   public int func_176736_b() {
      return this.field_176760_i;
   }

   public EnumFacing.AxisDirection func_176743_c() {
      return this.field_176755_l;
   }

   public EnumFacing func_176734_d() {
      return func_82600_a(this.field_176759_h);
   }

   public EnumFacing func_176732_a(EnumFacing.Axis p_176732_1_) {
      switch(EnumFacing.SwitchPlane.field_179515_a[p_176732_1_.ordinal()]) {
      case 1:
         if(this != WEST && this != EAST) {
            return this.func_176744_n();
         }

         return this;
      case 2:
         if(this != UP && this != DOWN) {
            return this.func_176746_e();
         }

         return this;
      case 3:
         if(this != NORTH && this != SOUTH) {
            return this.func_176738_p();
         }

         return this;
      default:
         throw new IllegalStateException("Unable to get CW facing for axis " + p_176732_1_);
      }
   }

   public EnumFacing func_176746_e() {
      switch(EnumFacing.SwitchPlane.field_179513_b[this.ordinal()]) {
      case 1:
         return EAST;
      case 2:
         return SOUTH;
      case 3:
         return WEST;
      case 4:
         return NORTH;
      default:
         throw new IllegalStateException("Unable to get Y-rotated facing of " + this);
      }
   }

   private EnumFacing func_176744_n() {
      switch(EnumFacing.SwitchPlane.field_179513_b[this.ordinal()]) {
      case 1:
         return DOWN;
      case 2:
      case 4:
      default:
         throw new IllegalStateException("Unable to get X-rotated facing of " + this);
      case 3:
         return UP;
      case 5:
         return NORTH;
      case 6:
         return SOUTH;
      }
   }

   private EnumFacing func_176738_p() {
      switch(EnumFacing.SwitchPlane.field_179513_b[this.ordinal()]) {
      case 2:
         return DOWN;
      case 3:
      default:
         throw new IllegalStateException("Unable to get Z-rotated facing of " + this);
      case 4:
         return UP;
      case 5:
         return EAST;
      case 6:
         return WEST;
      }
   }

   public EnumFacing func_176735_f() {
      switch(EnumFacing.SwitchPlane.field_179513_b[this.ordinal()]) {
      case 1:
         return WEST;
      case 2:
         return NORTH;
      case 3:
         return EAST;
      case 4:
         return SOUTH;
      default:
         throw new IllegalStateException("Unable to get CCW facing of " + this);
      }
   }

   public int func_82601_c() {
      return this.field_176758_k == EnumFacing.Axis.X?this.field_176755_l.func_179524_a():0;
   }

   public int func_96559_d() {
      return this.field_176758_k == EnumFacing.Axis.Y?this.field_176755_l.func_179524_a():0;
   }

   public int func_82599_e() {
      return this.field_176758_k == EnumFacing.Axis.Z?this.field_176755_l.func_179524_a():0;
   }

   public String func_176742_j() {
      return this.field_176757_j;
   }

   public EnumFacing.Axis func_176740_k() {
      return this.field_176758_k;
   }

   public static EnumFacing func_176739_a(String p_176739_0_) {
      return p_176739_0_ == null?null:(EnumFacing)field_176761_p.get(p_176739_0_.toLowerCase());
   }

   public static EnumFacing func_82600_a(int p_82600_0_) {
      return field_82609_l[MathHelper.func_76130_a(p_82600_0_ % field_82609_l.length)];
   }

   public static EnumFacing func_176731_b(int p_176731_0_) {
      return field_176754_o[MathHelper.func_76130_a(p_176731_0_ % field_176754_o.length)];
   }

   public static EnumFacing func_176733_a(double p_176733_0_) {
      return func_176731_b(MathHelper.func_76128_c(p_176733_0_ / 90.0D + 0.5D) & 3);
   }

   public static EnumFacing func_176741_a(Random p_176741_0_) {
      return values()[p_176741_0_.nextInt(values().length)];
   }

   public static EnumFacing func_176737_a(float p_176737_0_, float p_176737_1_, float p_176737_2_) {
      EnumFacing var3 = NORTH;
      float var4 = Float.MIN_VALUE;
      EnumFacing[] var5 = values();
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         EnumFacing var8 = var5[var7];
         float var9 = p_176737_0_ * (float)var8.field_176756_m.func_177958_n() + p_176737_1_ * (float)var8.field_176756_m.func_177956_o() + p_176737_2_ * (float)var8.field_176756_m.func_177952_p();
         if(var9 > var4) {
            var4 = var9;
            var3 = var8;
         }
      }

      return var3;
   }

   public String toString() {
      return this.field_176757_j;
   }

   public String func_176610_l() {
      return this.field_176757_j;
   }

   public Vec3i func_176730_m() {
      return this.field_176756_m;
   }

   static {
      EnumFacing[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         EnumFacing var3 = var0[var2];
         field_82609_l[var3.field_176748_g] = var3;
         if(var3.func_176740_k().func_176722_c()) {
            field_176754_o[var3.field_176760_i] = var3;
         }

         field_176761_p.put(var3.func_176742_j().toLowerCase(), var3);
      }

   }

   public static enum Axis implements Predicate, IStringSerializable {

      X("X", 0, "x", EnumFacing.Plane.HORIZONTAL),
      Y("Y", 1, "y", EnumFacing.Plane.VERTICAL),
      Z("Z", 2, "z", EnumFacing.Plane.HORIZONTAL);
      private static final Map field_176725_d = Maps.newHashMap();
      private final String field_176726_e;
      private final EnumFacing.Plane field_176723_f;
      // $FF: synthetic field
      private static final EnumFacing.Axis[] $VALUES = new EnumFacing.Axis[]{X, Y, Z};
      private static final String __OBFID = "CL_00002321";


      private Axis(String p_i46015_1_, int p_i46015_2_, String p_i46015_3_, EnumFacing.Plane p_i46015_4_) {
         this.field_176726_e = p_i46015_3_;
         this.field_176723_f = p_i46015_4_;
      }

      public static EnumFacing.Axis func_176717_a(String p_176717_0_) {
         return p_176717_0_ == null?null:(EnumFacing.Axis)field_176725_d.get(p_176717_0_.toLowerCase());
      }

      public String func_176719_a() {
         return this.field_176726_e;
      }

      public boolean func_176720_b() {
         return this.field_176723_f == EnumFacing.Plane.VERTICAL;
      }

      public boolean func_176722_c() {
         return this.field_176723_f == EnumFacing.Plane.HORIZONTAL;
      }

      public String toString() {
         return this.field_176726_e;
      }

      public boolean func_176718_a(EnumFacing p_176718_1_) {
         return p_176718_1_ != null && p_176718_1_.func_176740_k() == this;
      }

      public EnumFacing.Plane func_176716_d() {
         return this.field_176723_f;
      }

      public String func_176610_l() {
         return this.field_176726_e;
      }

      // $FF: synthetic method
      public boolean apply(Object p_apply_1_) {
         return this.func_176718_a((EnumFacing)p_apply_1_);
      }

      static {
         EnumFacing.Axis[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            EnumFacing.Axis var3 = var0[var2];
            field_176725_d.put(var3.func_176719_a().toLowerCase(), var3);
         }

      }
   }

   public static enum AxisDirection {

      POSITIVE("POSITIVE", 0, 1, "Towards positive"),
      NEGATIVE("NEGATIVE", 1, -1, "Towards negative");
      private final int field_179528_c;
      private final String field_179525_d;
      // $FF: synthetic field
      private static final EnumFacing.AxisDirection[] $VALUES = new EnumFacing.AxisDirection[]{POSITIVE, NEGATIVE};
      private static final String __OBFID = "CL_00002320";


      private AxisDirection(String p_i46014_1_, int p_i46014_2_, int p_i46014_3_, String p_i46014_4_) {
         this.field_179528_c = p_i46014_3_;
         this.field_179525_d = p_i46014_4_;
      }

      public int func_179524_a() {
         return this.field_179528_c;
      }

      public String toString() {
         return this.field_179525_d;
      }

   }

   public static enum Plane implements Predicate, Iterable {

      HORIZONTAL("HORIZONTAL", 0),
      VERTICAL("VERTICAL", 1);
      // $FF: synthetic field
      private static final EnumFacing.Plane[] $VALUES = new EnumFacing.Plane[]{HORIZONTAL, VERTICAL};
      private static final String __OBFID = "CL_00002319";


      private Plane(String p_i46013_1_, int p_i46013_2_) {}

      public EnumFacing[] func_179516_a() {
         switch(EnumFacing.SwitchPlane.field_179514_c[this.ordinal()]) {
         case 1:
            return new EnumFacing[]{EnumFacing.NORTH, EnumFacing.EAST, EnumFacing.SOUTH, EnumFacing.WEST};
         case 2:
            return new EnumFacing[]{EnumFacing.UP, EnumFacing.DOWN};
         default:
            throw new Error("Someone\'s been tampering with the universe!");
         }
      }

      public EnumFacing func_179518_a(Random p_179518_1_) {
         EnumFacing[] var2 = this.func_179516_a();
         return var2[p_179518_1_.nextInt(var2.length)];
      }

      public boolean func_179519_a(EnumFacing p_179519_1_) {
         return p_179519_1_ != null && p_179519_1_.func_176740_k().func_176716_d() == this;
      }

      public Iterator iterator() {
         return Iterators.forArray(this.func_179516_a());
      }

      // $FF: synthetic method
      public boolean apply(Object p_apply_1_) {
         return this.func_179519_a((EnumFacing)p_apply_1_);
      }

   }

   // $FF: synthetic class
   static final class SwitchPlane {

      // $FF: synthetic field
      static final int[] field_179515_a;
      // $FF: synthetic field
      static final int[] field_179513_b;
      // $FF: synthetic field
      static final int[] field_179514_c = new int[EnumFacing.Plane.values().length];
      private static final String __OBFID = "CL_00002322";


      static {
         try {
            field_179514_c[EnumFacing.Plane.HORIZONTAL.ordinal()] = 1;
         } catch (NoSuchFieldError var11) {
            ;
         }

         try {
            field_179514_c[EnumFacing.Plane.VERTICAL.ordinal()] = 2;
         } catch (NoSuchFieldError var10) {
            ;
         }

         field_179513_b = new int[EnumFacing.values().length];

         try {
            field_179513_b[EnumFacing.NORTH.ordinal()] = 1;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            field_179513_b[EnumFacing.EAST.ordinal()] = 2;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            field_179513_b[EnumFacing.SOUTH.ordinal()] = 3;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            field_179513_b[EnumFacing.WEST.ordinal()] = 4;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            field_179513_b[EnumFacing.UP.ordinal()] = 5;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            field_179513_b[EnumFacing.DOWN.ordinal()] = 6;
         } catch (NoSuchFieldError var4) {
            ;
         }

         field_179515_a = new int[EnumFacing.Axis.values().length];

         try {
            field_179515_a[EnumFacing.Axis.X.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_179515_a[EnumFacing.Axis.Y.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_179515_a[EnumFacing.Axis.Z.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
