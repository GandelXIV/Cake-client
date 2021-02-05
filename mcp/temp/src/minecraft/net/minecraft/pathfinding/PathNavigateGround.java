package net.minecraft.pathfinding;

import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.pathfinder.WalkNodeProcessor;

public class PathNavigateGround extends PathNavigate {

   protected WalkNodeProcessor field_179695_a;
   private boolean field_179694_f;
   private static final String __OBFID = "CL_00002246";


   public PathNavigateGround(EntityLiving p_i45875_1_, World p_i45875_2_) {
      super(p_i45875_1_, p_i45875_2_);
   }

   protected PathFinder func_179679_a() {
      this.field_179695_a = new WalkNodeProcessor();
      this.field_179695_a.func_176175_a(true);
      return new PathFinder(this.field_179695_a);
   }

   protected boolean func_75485_k() {
      return this.field_75515_a.field_70122_E || this.func_179684_h() && this.func_75506_l() || this.field_75515_a.func_70115_ae() && this.field_75515_a instanceof EntityZombie && this.field_75515_a.field_70154_o instanceof EntityChicken;
   }

   protected Vec3 func_75502_i() {
      return new Vec3(this.field_75515_a.field_70165_t, (double)this.func_179687_p(), this.field_75515_a.field_70161_v);
   }

   private int func_179687_p() {
      if(this.field_75515_a.func_70090_H() && this.func_179684_h()) {
         int var1 = (int)this.field_75515_a.func_174813_aQ().field_72338_b;
         Block var2 = this.field_75513_b.func_180495_p(new BlockPos(MathHelper.func_76128_c(this.field_75515_a.field_70165_t), var1, MathHelper.func_76128_c(this.field_75515_a.field_70161_v))).func_177230_c();
         int var3 = 0;

         do {
            if(var2 != Blocks.field_150358_i && var2 != Blocks.field_150355_j) {
               return var1;
            }

            ++var1;
            var2 = this.field_75513_b.func_180495_p(new BlockPos(MathHelper.func_76128_c(this.field_75515_a.field_70165_t), var1, MathHelper.func_76128_c(this.field_75515_a.field_70161_v))).func_177230_c();
            ++var3;
         } while(var3 <= 16);

         return (int)this.field_75515_a.func_174813_aQ().field_72338_b;
      } else {
         return (int)(this.field_75515_a.func_174813_aQ().field_72338_b + 0.5D);
      }
   }

   protected void func_75487_m() {
      super.func_75487_m();
      if(this.field_179694_f) {
         if(this.field_75513_b.func_175678_i(new BlockPos(MathHelper.func_76128_c(this.field_75515_a.field_70165_t), (int)(this.field_75515_a.func_174813_aQ().field_72338_b + 0.5D), MathHelper.func_76128_c(this.field_75515_a.field_70161_v)))) {
            return;
         }

         for(int var1 = 0; var1 < this.field_75514_c.func_75874_d(); ++var1) {
            PathPoint var2 = this.field_75514_c.func_75877_a(var1);
            if(this.field_75513_b.func_175678_i(new BlockPos(var2.field_75839_a, var2.field_75837_b, var2.field_75838_c))) {
               this.field_75514_c.func_75871_b(var1 - 1);
               return;
            }
         }
      }

   }

   protected boolean func_75493_a(Vec3 p_75493_1_, Vec3 p_75493_2_, int p_75493_3_, int p_75493_4_, int p_75493_5_) {
      int var6 = MathHelper.func_76128_c(p_75493_1_.field_72450_a);
      int var7 = MathHelper.func_76128_c(p_75493_1_.field_72449_c);
      double var8 = p_75493_2_.field_72450_a - p_75493_1_.field_72450_a;
      double var10 = p_75493_2_.field_72449_c - p_75493_1_.field_72449_c;
      double var12 = var8 * var8 + var10 * var10;
      if(var12 < 1.0E-8D) {
         return false;
      } else {
         double var14 = 1.0D / Math.sqrt(var12);
         var8 *= var14;
         var10 *= var14;
         p_75493_3_ += 2;
         p_75493_5_ += 2;
         if(!this.func_179683_a(var6, (int)p_75493_1_.field_72448_b, var7, p_75493_3_, p_75493_4_, p_75493_5_, p_75493_1_, var8, var10)) {
            return false;
         } else {
            p_75493_3_ -= 2;
            p_75493_5_ -= 2;
            double var16 = 1.0D / Math.abs(var8);
            double var18 = 1.0D / Math.abs(var10);
            double var20 = (double)(var6 * 1) - p_75493_1_.field_72450_a;
            double var22 = (double)(var7 * 1) - p_75493_1_.field_72449_c;
            if(var8 >= 0.0D) {
               ++var20;
            }

            if(var10 >= 0.0D) {
               ++var22;
            }

            var20 /= var8;
            var22 /= var10;
            int var24 = var8 < 0.0D?-1:1;
            int var25 = var10 < 0.0D?-1:1;
            int var26 = MathHelper.func_76128_c(p_75493_2_.field_72450_a);
            int var27 = MathHelper.func_76128_c(p_75493_2_.field_72449_c);
            int var28 = var26 - var6;
            int var29 = var27 - var7;

            do {
               if(var28 * var24 <= 0 && var29 * var25 <= 0) {
                  return true;
               }

               if(var20 < var22) {
                  var20 += var16;
                  var6 += var24;
                  var28 = var26 - var6;
               } else {
                  var22 += var18;
                  var7 += var25;
                  var29 = var27 - var7;
               }
            } while(this.func_179683_a(var6, (int)p_75493_1_.field_72448_b, var7, p_75493_3_, p_75493_4_, p_75493_5_, p_75493_1_, var8, var10));

            return false;
         }
      }
   }

   private boolean func_179683_a(int p_179683_1_, int p_179683_2_, int p_179683_3_, int p_179683_4_, int p_179683_5_, int p_179683_6_, Vec3 p_179683_7_, double p_179683_8_, double p_179683_10_) {
      int var12 = p_179683_1_ - p_179683_4_ / 2;
      int var13 = p_179683_3_ - p_179683_6_ / 2;
      if(!this.func_179692_b(var12, p_179683_2_, var13, p_179683_4_, p_179683_5_, p_179683_6_, p_179683_7_, p_179683_8_, p_179683_10_)) {
         return false;
      } else {
         for(int var14 = var12; var14 < var12 + p_179683_4_; ++var14) {
            for(int var15 = var13; var15 < var13 + p_179683_6_; ++var15) {
               double var16 = (double)var14 + 0.5D - p_179683_7_.field_72450_a;
               double var18 = (double)var15 + 0.5D - p_179683_7_.field_72449_c;
               if(var16 * p_179683_8_ + var18 * p_179683_10_ >= 0.0D) {
                  Block var20 = this.field_75513_b.func_180495_p(new BlockPos(var14, p_179683_2_ - 1, var15)).func_177230_c();
                  Material var21 = var20.func_149688_o();
                  if(var21 == Material.field_151579_a) {
                     return false;
                  }

                  if(var21 == Material.field_151586_h && !this.field_75515_a.func_70090_H()) {
                     return false;
                  }

                  if(var21 == Material.field_151587_i) {
                     return false;
                  }
               }
            }
         }

         return true;
      }
   }

   private boolean func_179692_b(int p_179692_1_, int p_179692_2_, int p_179692_3_, int p_179692_4_, int p_179692_5_, int p_179692_6_, Vec3 p_179692_7_, double p_179692_8_, double p_179692_10_) {
      Iterator var12 = BlockPos.func_177980_a(new BlockPos(p_179692_1_, p_179692_2_, p_179692_3_), new BlockPos(p_179692_1_ + p_179692_4_ - 1, p_179692_2_ + p_179692_5_ - 1, p_179692_3_ + p_179692_6_ - 1)).iterator();

      while(var12.hasNext()) {
         BlockPos var13 = (BlockPos)var12.next();
         double var14 = (double)var13.func_177958_n() + 0.5D - p_179692_7_.field_72450_a;
         double var16 = (double)var13.func_177952_p() + 0.5D - p_179692_7_.field_72449_c;
         if(var14 * p_179692_8_ + var16 * p_179692_10_ >= 0.0D) {
            Block var18 = this.field_75513_b.func_180495_p(var13).func_177230_c();
            if(!var18.func_176205_b(this.field_75513_b, var13)) {
               return false;
            }
         }
      }

      return true;
   }

   public void func_179690_a(boolean p_179690_1_) {
      this.field_179695_a.func_176176_c(p_179690_1_);
   }

   public boolean func_179689_e() {
      return this.field_179695_a.func_176173_e();
   }

   public void func_179688_b(boolean p_179688_1_) {
      this.field_179695_a.func_176172_b(p_179688_1_);
   }

   public void func_179691_c(boolean p_179691_1_) {
      this.field_179695_a.func_176175_a(p_179691_1_);
   }

   public boolean func_179686_g() {
      return this.field_179695_a.func_176179_b();
   }

   public void func_179693_d(boolean p_179693_1_) {
      this.field_179695_a.func_176178_d(p_179693_1_);
   }

   public boolean func_179684_h() {
      return this.field_179695_a.func_176174_d();
   }

   public void func_179685_e(boolean p_179685_1_) {
      this.field_179694_f = p_179685_1_;
   }
}
