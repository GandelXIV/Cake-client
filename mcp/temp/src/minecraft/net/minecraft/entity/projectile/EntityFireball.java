package net.minecraft.entity.projectile;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class EntityFireball extends Entity {

   private int field_145795_e = -1;
   private int field_145793_f = -1;
   private int field_145794_g = -1;
   private Block field_145796_h;
   private boolean field_70238_i;
   public EntityLivingBase field_70235_a;
   private int field_70236_j;
   private int field_70234_an;
   public double field_70232_b;
   public double field_70233_c;
   public double field_70230_d;
   private static final String __OBFID = "CL_00001717";


   public EntityFireball(World p_i1759_1_) {
      super(p_i1759_1_);
      this.func_70105_a(1.0F, 1.0F);
   }

   protected void func_70088_a() {}

   public boolean func_70112_a(double p_70112_1_) {
      double var3 = this.func_174813_aQ().func_72320_b() * 4.0D;
      var3 *= 64.0D;
      return p_70112_1_ < var3 * var3;
   }

   public EntityFireball(World p_i1760_1_, double p_i1760_2_, double p_i1760_4_, double p_i1760_6_, double p_i1760_8_, double p_i1760_10_, double p_i1760_12_) {
      super(p_i1760_1_);
      this.func_70105_a(1.0F, 1.0F);
      this.func_70012_b(p_i1760_2_, p_i1760_4_, p_i1760_6_, this.field_70177_z, this.field_70125_A);
      this.func_70107_b(p_i1760_2_, p_i1760_4_, p_i1760_6_);
      double var14 = (double)MathHelper.func_76133_a(p_i1760_8_ * p_i1760_8_ + p_i1760_10_ * p_i1760_10_ + p_i1760_12_ * p_i1760_12_);
      this.field_70232_b = p_i1760_8_ / var14 * 0.1D;
      this.field_70233_c = p_i1760_10_ / var14 * 0.1D;
      this.field_70230_d = p_i1760_12_ / var14 * 0.1D;
   }

   public EntityFireball(World p_i1761_1_, EntityLivingBase p_i1761_2_, double p_i1761_3_, double p_i1761_5_, double p_i1761_7_) {
      super(p_i1761_1_);
      this.field_70235_a = p_i1761_2_;
      this.func_70105_a(1.0F, 1.0F);
      this.func_70012_b(p_i1761_2_.field_70165_t, p_i1761_2_.field_70163_u, p_i1761_2_.field_70161_v, p_i1761_2_.field_70177_z, p_i1761_2_.field_70125_A);
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70159_w = this.field_70181_x = this.field_70179_y = 0.0D;
      p_i1761_3_ += this.field_70146_Z.nextGaussian() * 0.4D;
      p_i1761_5_ += this.field_70146_Z.nextGaussian() * 0.4D;
      p_i1761_7_ += this.field_70146_Z.nextGaussian() * 0.4D;
      double var9 = (double)MathHelper.func_76133_a(p_i1761_3_ * p_i1761_3_ + p_i1761_5_ * p_i1761_5_ + p_i1761_7_ * p_i1761_7_);
      this.field_70232_b = p_i1761_3_ / var9 * 0.1D;
      this.field_70233_c = p_i1761_5_ / var9 * 0.1D;
      this.field_70230_d = p_i1761_7_ / var9 * 0.1D;
   }

   public void func_70071_h_() {
      if(!this.field_70170_p.field_72995_K && (this.field_70235_a != null && this.field_70235_a.field_70128_L || !this.field_70170_p.func_175667_e(new BlockPos(this)))) {
         this.func_70106_y();
      } else {
         super.func_70071_h_();
         this.func_70015_d(1);
         if(this.field_70238_i) {
            if(this.field_70170_p.func_180495_p(new BlockPos(this.field_145795_e, this.field_145793_f, this.field_145794_g)).func_177230_c() == this.field_145796_h) {
               ++this.field_70236_j;
               if(this.field_70236_j == 600) {
                  this.func_70106_y();
               }

               return;
            }

            this.field_70238_i = false;
            this.field_70159_w *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
            this.field_70181_x *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
            this.field_70179_y *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
            this.field_70236_j = 0;
            this.field_70234_an = 0;
         } else {
            ++this.field_70234_an;
         }

         Vec3 var1 = new Vec3(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         Vec3 var2 = new Vec3(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
         MovingObjectPosition var3 = this.field_70170_p.func_72933_a(var1, var2);
         var1 = new Vec3(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         var2 = new Vec3(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
         if(var3 != null) {
            var2 = new Vec3(var3.field_72307_f.field_72450_a, var3.field_72307_f.field_72448_b, var3.field_72307_f.field_72449_c);
         }

         Entity var4 = null;
         List var5 = this.field_70170_p.func_72839_b(this, this.func_174813_aQ().func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
         double var6 = 0.0D;

         for(int var8 = 0; var8 < var5.size(); ++var8) {
            Entity var9 = (Entity)var5.get(var8);
            if(var9.func_70067_L() && (!var9.func_70028_i(this.field_70235_a) || this.field_70234_an >= 25)) {
               float var10 = 0.3F;
               AxisAlignedBB var11 = var9.func_174813_aQ().func_72314_b((double)var10, (double)var10, (double)var10);
               MovingObjectPosition var12 = var11.func_72327_a(var1, var2);
               if(var12 != null) {
                  double var13 = var1.func_72438_d(var12.field_72307_f);
                  if(var13 < var6 || var6 == 0.0D) {
                     var4 = var9;
                     var6 = var13;
                  }
               }
            }
         }

         if(var4 != null) {
            var3 = new MovingObjectPosition(var4);
         }

         if(var3 != null) {
            this.func_70227_a(var3);
         }

         this.field_70165_t += this.field_70159_w;
         this.field_70163_u += this.field_70181_x;
         this.field_70161_v += this.field_70179_y;
         float var15 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
         this.field_70177_z = (float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0D / 3.1415927410125732D) + 90.0F;

         for(this.field_70125_A = (float)(Math.atan2((double)var15, this.field_70181_x) * 180.0D / 3.1415927410125732D) - 90.0F; this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F) {
            ;
         }

         while(this.field_70125_A - this.field_70127_C >= 180.0F) {
            this.field_70127_C += 360.0F;
         }

         while(this.field_70177_z - this.field_70126_B < -180.0F) {
            this.field_70126_B -= 360.0F;
         }

         while(this.field_70177_z - this.field_70126_B >= 180.0F) {
            this.field_70126_B += 360.0F;
         }

         this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F;
         this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F;
         float var16 = this.func_82341_c();
         if(this.func_70090_H()) {
            for(int var17 = 0; var17 < 4; ++var17) {
               float var18 = 0.25F;
               this.field_70170_p.func_175688_a(EnumParticleTypes.WATER_BUBBLE, this.field_70165_t - this.field_70159_w * (double)var18, this.field_70163_u - this.field_70181_x * (double)var18, this.field_70161_v - this.field_70179_y * (double)var18, this.field_70159_w, this.field_70181_x, this.field_70179_y, new int[0]);
            }

            var16 = 0.8F;
         }

         this.field_70159_w += this.field_70232_b;
         this.field_70181_x += this.field_70233_c;
         this.field_70179_y += this.field_70230_d;
         this.field_70159_w *= (double)var16;
         this.field_70181_x *= (double)var16;
         this.field_70179_y *= (double)var16;
         this.field_70170_p.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, this.field_70165_t, this.field_70163_u + 0.5D, this.field_70161_v, 0.0D, 0.0D, 0.0D, new int[0]);
         this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      }
   }

   protected float func_82341_c() {
      return 0.95F;
   }

   protected abstract void func_70227_a(MovingObjectPosition var1);

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      p_70014_1_.func_74777_a("xTile", (short)this.field_145795_e);
      p_70014_1_.func_74777_a("yTile", (short)this.field_145793_f);
      p_70014_1_.func_74777_a("zTile", (short)this.field_145794_g);
      ResourceLocation var2 = (ResourceLocation)Block.field_149771_c.func_177774_c(this.field_145796_h);
      p_70014_1_.func_74778_a("inTile", var2 == null?"":var2.toString());
      p_70014_1_.func_74774_a("inGround", (byte)(this.field_70238_i?1:0));
      p_70014_1_.func_74782_a("direction", this.func_70087_a(new double[]{this.field_70159_w, this.field_70181_x, this.field_70179_y}));
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      this.field_145795_e = p_70037_1_.func_74765_d("xTile");
      this.field_145793_f = p_70037_1_.func_74765_d("yTile");
      this.field_145794_g = p_70037_1_.func_74765_d("zTile");
      if(p_70037_1_.func_150297_b("inTile", 8)) {
         this.field_145796_h = Block.func_149684_b(p_70037_1_.func_74779_i("inTile"));
      } else {
         this.field_145796_h = Block.func_149729_e(p_70037_1_.func_74771_c("inTile") & 255);
      }

      this.field_70238_i = p_70037_1_.func_74771_c("inGround") == 1;
      if(p_70037_1_.func_150297_b("direction", 9)) {
         NBTTagList var2 = p_70037_1_.func_150295_c("direction", 6);
         this.field_70159_w = var2.func_150309_d(0);
         this.field_70181_x = var2.func_150309_d(1);
         this.field_70179_y = var2.func_150309_d(2);
      } else {
         this.func_70106_y();
      }

   }

   public boolean func_70067_L() {
      return true;
   }

   public float func_70111_Y() {
      return 1.0F;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
      if(this.func_180431_b(p_70097_1_)) {
         return false;
      } else {
         this.func_70018_K();
         if(p_70097_1_.func_76346_g() != null) {
            Vec3 var3 = p_70097_1_.func_76346_g().func_70040_Z();
            if(var3 != null) {
               this.field_70159_w = var3.field_72450_a;
               this.field_70181_x = var3.field_72448_b;
               this.field_70179_y = var3.field_72449_c;
               this.field_70232_b = this.field_70159_w * 0.1D;
               this.field_70233_c = this.field_70181_x * 0.1D;
               this.field_70230_d = this.field_70179_y * 0.1D;
            }

            if(p_70097_1_.func_76346_g() instanceof EntityLivingBase) {
               this.field_70235_a = (EntityLivingBase)p_70097_1_.func_76346_g();
            }

            return true;
         } else {
            return false;
         }
      }
   }

   public float func_70013_c(float p_70013_1_) {
      return 1.0F;
   }

   public int func_70070_b(float p_70070_1_) {
      return 15728880;
   }
}
