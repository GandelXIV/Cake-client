package net.minecraft.entity.projectile;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class EntityThrowable extends Entity implements IProjectile {

   private int field_145788_c = -1;
   private int field_145786_d = -1;
   private int field_145787_e = -1;
   private Block field_174853_f;
   protected boolean field_174854_a;
   public int field_70191_b;
   private EntityLivingBase field_70192_c;
   private String field_85053_h;
   private int field_70194_h;
   private int field_70195_i;
   private static final String __OBFID = "CL_00001723";


   public EntityThrowable(World p_i1776_1_) {
      super(p_i1776_1_);
      this.func_70105_a(0.25F, 0.25F);
   }

   protected void func_70088_a() {}

   public boolean func_70112_a(double p_70112_1_) {
      double var3 = this.func_174813_aQ().func_72320_b() * 4.0D;
      var3 *= 64.0D;
      return p_70112_1_ < var3 * var3;
   }

   public EntityThrowable(World p_i1777_1_, EntityLivingBase p_i1777_2_) {
      super(p_i1777_1_);
      this.field_70192_c = p_i1777_2_;
      this.func_70105_a(0.25F, 0.25F);
      this.func_70012_b(p_i1777_2_.field_70165_t, p_i1777_2_.field_70163_u + (double)p_i1777_2_.func_70047_e(), p_i1777_2_.field_70161_v, p_i1777_2_.field_70177_z, p_i1777_2_.field_70125_A);
      this.field_70165_t -= (double)(MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
      this.field_70163_u -= 0.10000000149011612D;
      this.field_70161_v -= (double)(MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      float var3 = 0.4F;
      this.field_70159_w = (double)(-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * var3);
      this.field_70179_y = (double)(MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * var3);
      this.field_70181_x = (double)(-MathHelper.func_76126_a((this.field_70125_A + this.func_70183_g()) / 180.0F * 3.1415927F) * var3);
      this.func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, this.func_70182_d(), 1.0F);
   }

   public EntityThrowable(World p_i1778_1_, double p_i1778_2_, double p_i1778_4_, double p_i1778_6_) {
      super(p_i1778_1_);
      this.field_70194_h = 0;
      this.func_70105_a(0.25F, 0.25F);
      this.func_70107_b(p_i1778_2_, p_i1778_4_, p_i1778_6_);
   }

   protected float func_70182_d() {
      return 1.5F;
   }

   protected float func_70183_g() {
      return 0.0F;
   }

   public void func_70186_c(double p_70186_1_, double p_70186_3_, double p_70186_5_, float p_70186_7_, float p_70186_8_) {
      float var9 = MathHelper.func_76133_a(p_70186_1_ * p_70186_1_ + p_70186_3_ * p_70186_3_ + p_70186_5_ * p_70186_5_);
      p_70186_1_ /= (double)var9;
      p_70186_3_ /= (double)var9;
      p_70186_5_ /= (double)var9;
      p_70186_1_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * (double)p_70186_8_;
      p_70186_3_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * (double)p_70186_8_;
      p_70186_5_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * (double)p_70186_8_;
      p_70186_1_ *= (double)p_70186_7_;
      p_70186_3_ *= (double)p_70186_7_;
      p_70186_5_ *= (double)p_70186_7_;
      this.field_70159_w = p_70186_1_;
      this.field_70181_x = p_70186_3_;
      this.field_70179_y = p_70186_5_;
      float var10 = MathHelper.func_76133_a(p_70186_1_ * p_70186_1_ + p_70186_5_ * p_70186_5_);
      this.field_70126_B = this.field_70177_z = (float)(Math.atan2(p_70186_1_, p_70186_5_) * 180.0D / 3.1415927410125732D);
      this.field_70127_C = this.field_70125_A = (float)(Math.atan2(p_70186_3_, (double)var10) * 180.0D / 3.1415927410125732D);
      this.field_70194_h = 0;
   }

   public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
      this.field_70159_w = p_70016_1_;
      this.field_70181_x = p_70016_3_;
      this.field_70179_y = p_70016_5_;
      if(this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
         float var7 = MathHelper.func_76133_a(p_70016_1_ * p_70016_1_ + p_70016_5_ * p_70016_5_);
         this.field_70126_B = this.field_70177_z = (float)(Math.atan2(p_70016_1_, p_70016_5_) * 180.0D / 3.1415927410125732D);
         this.field_70127_C = this.field_70125_A = (float)(Math.atan2(p_70016_3_, (double)var7) * 180.0D / 3.1415927410125732D);
      }

   }

   public void func_70071_h_() {
      this.field_70142_S = this.field_70165_t;
      this.field_70137_T = this.field_70163_u;
      this.field_70136_U = this.field_70161_v;
      super.func_70071_h_();
      if(this.field_70191_b > 0) {
         --this.field_70191_b;
      }

      if(this.field_174854_a) {
         if(this.field_70170_p.func_180495_p(new BlockPos(this.field_145788_c, this.field_145786_d, this.field_145787_e)).func_177230_c() == this.field_174853_f) {
            ++this.field_70194_h;
            if(this.field_70194_h == 1200) {
               this.func_70106_y();
            }

            return;
         }

         this.field_174854_a = false;
         this.field_70159_w *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
         this.field_70181_x *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
         this.field_70179_y *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
         this.field_70194_h = 0;
         this.field_70195_i = 0;
      } else {
         ++this.field_70195_i;
      }

      Vec3 var1 = new Vec3(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      Vec3 var2 = new Vec3(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
      MovingObjectPosition var3 = this.field_70170_p.func_72933_a(var1, var2);
      var1 = new Vec3(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      var2 = new Vec3(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
      if(var3 != null) {
         var2 = new Vec3(var3.field_72307_f.field_72450_a, var3.field_72307_f.field_72448_b, var3.field_72307_f.field_72449_c);
      }

      if(!this.field_70170_p.field_72995_K) {
         Entity var4 = null;
         List var5 = this.field_70170_p.func_72839_b(this, this.func_174813_aQ().func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
         double var6 = 0.0D;
         EntityLivingBase var8 = this.func_85052_h();

         for(int var9 = 0; var9 < var5.size(); ++var9) {
            Entity var10 = (Entity)var5.get(var9);
            if(var10.func_70067_L() && (var10 != var8 || this.field_70195_i >= 5)) {
               float var11 = 0.3F;
               AxisAlignedBB var12 = var10.func_174813_aQ().func_72314_b((double)var11, (double)var11, (double)var11);
               MovingObjectPosition var13 = var12.func_72327_a(var1, var2);
               if(var13 != null) {
                  double var14 = var1.func_72438_d(var13.field_72307_f);
                  if(var14 < var6 || var6 == 0.0D) {
                     var4 = var10;
                     var6 = var14;
                  }
               }
            }
         }

         if(var4 != null) {
            var3 = new MovingObjectPosition(var4);
         }
      }

      if(var3 != null) {
         if(var3.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK && this.field_70170_p.func_180495_p(var3.func_178782_a()).func_177230_c() == Blocks.field_150427_aO) {
            this.func_70063_aa();
         } else {
            this.func_70184_a(var3);
         }
      }

      this.field_70165_t += this.field_70159_w;
      this.field_70163_u += this.field_70181_x;
      this.field_70161_v += this.field_70179_y;
      float var16 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
      this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.1415927410125732D);

      for(this.field_70125_A = (float)(Math.atan2(this.field_70181_x, (double)var16) * 180.0D / 3.1415927410125732D); this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F) {
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
      float var17 = 0.99F;
      float var18 = this.func_70185_h();
      if(this.func_70090_H()) {
         for(int var7 = 0; var7 < 4; ++var7) {
            float var19 = 0.25F;
            this.field_70170_p.func_175688_a(EnumParticleTypes.WATER_BUBBLE, this.field_70165_t - this.field_70159_w * (double)var19, this.field_70163_u - this.field_70181_x * (double)var19, this.field_70161_v - this.field_70179_y * (double)var19, this.field_70159_w, this.field_70181_x, this.field_70179_y, new int[0]);
         }

         var17 = 0.8F;
      }

      this.field_70159_w *= (double)var17;
      this.field_70181_x *= (double)var17;
      this.field_70179_y *= (double)var17;
      this.field_70181_x -= (double)var18;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
   }

   protected float func_70185_h() {
      return 0.03F;
   }

   protected abstract void func_70184_a(MovingObjectPosition var1);

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      p_70014_1_.func_74777_a("xTile", (short)this.field_145788_c);
      p_70014_1_.func_74777_a("yTile", (short)this.field_145786_d);
      p_70014_1_.func_74777_a("zTile", (short)this.field_145787_e);
      ResourceLocation var2 = (ResourceLocation)Block.field_149771_c.func_177774_c(this.field_174853_f);
      p_70014_1_.func_74778_a("inTile", var2 == null?"":var2.toString());
      p_70014_1_.func_74774_a("shake", (byte)this.field_70191_b);
      p_70014_1_.func_74774_a("inGround", (byte)(this.field_174854_a?1:0));
      if((this.field_85053_h == null || this.field_85053_h.length() == 0) && this.field_70192_c instanceof EntityPlayer) {
         this.field_85053_h = this.field_70192_c.func_70005_c_();
      }

      p_70014_1_.func_74778_a("ownerName", this.field_85053_h == null?"":this.field_85053_h);
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      this.field_145788_c = p_70037_1_.func_74765_d("xTile");
      this.field_145786_d = p_70037_1_.func_74765_d("yTile");
      this.field_145787_e = p_70037_1_.func_74765_d("zTile");
      if(p_70037_1_.func_150297_b("inTile", 8)) {
         this.field_174853_f = Block.func_149684_b(p_70037_1_.func_74779_i("inTile"));
      } else {
         this.field_174853_f = Block.func_149729_e(p_70037_1_.func_74771_c("inTile") & 255);
      }

      this.field_70191_b = p_70037_1_.func_74771_c("shake") & 255;
      this.field_174854_a = p_70037_1_.func_74771_c("inGround") == 1;
      this.field_85053_h = p_70037_1_.func_74779_i("ownerName");
      if(this.field_85053_h != null && this.field_85053_h.length() == 0) {
         this.field_85053_h = null;
      }

   }

   public EntityLivingBase func_85052_h() {
      if(this.field_70192_c == null && this.field_85053_h != null && this.field_85053_h.length() > 0) {
         this.field_70192_c = this.field_70170_p.func_72924_a(this.field_85053_h);
      }

      return this.field_70192_c;
   }
}
