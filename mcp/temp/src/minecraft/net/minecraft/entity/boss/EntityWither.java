package net.minecraft.entity.boss;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityWither extends EntityMob implements IBossDisplayData, IRangedAttackMob {

   private float[] field_82220_d = new float[2];
   private float[] field_82221_e = new float[2];
   private float[] field_82217_f = new float[2];
   private float[] field_82218_g = new float[2];
   private int[] field_82223_h = new int[2];
   private int[] field_82224_i = new int[2];
   private int field_82222_j;
   private static final Predicate field_82219_bJ = new Predicate() {

      private static final String __OBFID = "CL_00001662";

      public boolean func_180027_a(Entity p_180027_1_) {
         return p_180027_1_ instanceof EntityLivingBase && ((EntityLivingBase)p_180027_1_).func_70668_bt() != EnumCreatureAttribute.UNDEAD;
      }
      // $FF: synthetic method
      public boolean apply(Object p_apply_1_) {
         return this.func_180027_a((Entity)p_apply_1_);
      }
   };
   private static final String __OBFID = "CL_00001661";


   public EntityWither(World p_i1701_1_) {
      super(p_i1701_1_);
      this.func_70606_j(this.func_110138_aP());
      this.func_70105_a(0.9F, 3.5F);
      this.field_70178_ae = true;
      ((PathNavigateGround)this.func_70661_as()).func_179693_d(true);
      this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
      this.field_70714_bg.func_75776_a(2, new EntityAIArrowAttack(this, 1.0D, 40, 20.0F));
      this.field_70714_bg.func_75776_a(5, new EntityAIWander(this, 1.0D));
      this.field_70714_bg.func_75776_a(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.field_70714_bg.func_75776_a(7, new EntityAILookIdle(this));
      this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, false, new Class[0]));
      this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, false, field_82219_bJ));
      this.field_70728_aV = 50;
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(17, new Integer(0));
      this.field_70180_af.func_75682_a(18, new Integer(0));
      this.field_70180_af.func_75682_a(19, new Integer(0));
      this.field_70180_af.func_75682_a(20, new Integer(0));
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74768_a("Invul", this.func_82212_n());
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      this.func_82215_s(p_70037_1_.func_74762_e("Invul"));
   }

   protected String func_70639_aQ() {
      return "mob.wither.idle";
   }

   protected String func_70621_aR() {
      return "mob.wither.hurt";
   }

   protected String func_70673_aS() {
      return "mob.wither.death";
   }

   public void func_70636_d() {
      this.field_70181_x *= 0.6000000238418579D;
      double var4;
      double var6;
      double var8;
      if(!this.field_70170_p.field_72995_K && this.func_82203_t(0) > 0) {
         Entity var1 = this.field_70170_p.func_73045_a(this.func_82203_t(0));
         if(var1 != null) {
            if(this.field_70163_u < var1.field_70163_u || !this.func_82205_o() && this.field_70163_u < var1.field_70163_u + 5.0D) {
               if(this.field_70181_x < 0.0D) {
                  this.field_70181_x = 0.0D;
               }

               this.field_70181_x += (0.5D - this.field_70181_x) * 0.6000000238418579D;
            }

            double var2 = var1.field_70165_t - this.field_70165_t;
            var4 = var1.field_70161_v - this.field_70161_v;
            var6 = var2 * var2 + var4 * var4;
            if(var6 > 9.0D) {
               var8 = (double)MathHelper.func_76133_a(var6);
               this.field_70159_w += (var2 / var8 * 0.5D - this.field_70159_w) * 0.6000000238418579D;
               this.field_70179_y += (var4 / var8 * 0.5D - this.field_70179_y) * 0.6000000238418579D;
            }
         }
      }

      if(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y > 0.05000000074505806D) {
         this.field_70177_z = (float)Math.atan2(this.field_70179_y, this.field_70159_w) * 57.295776F - 90.0F;
      }

      super.func_70636_d();

      int var20;
      for(var20 = 0; var20 < 2; ++var20) {
         this.field_82218_g[var20] = this.field_82221_e[var20];
         this.field_82217_f[var20] = this.field_82220_d[var20];
      }

      int var22;
      for(var20 = 0; var20 < 2; ++var20) {
         var22 = this.func_82203_t(var20 + 1);
         Entity var3 = null;
         if(var22 > 0) {
            var3 = this.field_70170_p.func_73045_a(var22);
         }

         if(var3 != null) {
            var4 = this.func_82214_u(var20 + 1);
            var6 = this.func_82208_v(var20 + 1);
            var8 = this.func_82213_w(var20 + 1);
            double var10 = var3.field_70165_t - var4;
            double var12 = var3.field_70163_u + (double)var3.func_70047_e() - var6;
            double var14 = var3.field_70161_v - var8;
            double var16 = (double)MathHelper.func_76133_a(var10 * var10 + var14 * var14);
            float var18 = (float)(Math.atan2(var14, var10) * 180.0D / 3.1415927410125732D) - 90.0F;
            float var19 = (float)(-(Math.atan2(var12, var16) * 180.0D / 3.1415927410125732D));
            this.field_82220_d[var20] = this.func_82204_b(this.field_82220_d[var20], var19, 40.0F);
            this.field_82221_e[var20] = this.func_82204_b(this.field_82221_e[var20], var18, 10.0F);
         } else {
            this.field_82221_e[var20] = this.func_82204_b(this.field_82221_e[var20], this.field_70761_aq, 10.0F);
         }
      }

      boolean var21 = this.func_82205_o();

      for(var22 = 0; var22 < 3; ++var22) {
         double var23 = this.func_82214_u(var22);
         double var5 = this.func_82208_v(var22);
         double var7 = this.func_82213_w(var22);
         this.field_70170_p.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, var23 + this.field_70146_Z.nextGaussian() * 0.30000001192092896D, var5 + this.field_70146_Z.nextGaussian() * 0.30000001192092896D, var7 + this.field_70146_Z.nextGaussian() * 0.30000001192092896D, 0.0D, 0.0D, 0.0D, new int[0]);
         if(var21 && this.field_70170_p.field_73012_v.nextInt(4) == 0) {
            this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_MOB, var23 + this.field_70146_Z.nextGaussian() * 0.30000001192092896D, var5 + this.field_70146_Z.nextGaussian() * 0.30000001192092896D, var7 + this.field_70146_Z.nextGaussian() * 0.30000001192092896D, 0.699999988079071D, 0.699999988079071D, 0.5D, new int[0]);
         }
      }

      if(this.func_82212_n() > 0) {
         for(var22 = 0; var22 < 3; ++var22) {
            this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_MOB, this.field_70165_t + this.field_70146_Z.nextGaussian() * 1.0D, this.field_70163_u + (double)(this.field_70146_Z.nextFloat() * 3.3F), this.field_70161_v + this.field_70146_Z.nextGaussian() * 1.0D, 0.699999988079071D, 0.699999988079071D, 0.8999999761581421D, new int[0]);
         }
      }

   }

   protected void func_70619_bc() {
      int var1;
      if(this.func_82212_n() > 0) {
         var1 = this.func_82212_n() - 1;
         if(var1 <= 0) {
            this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u + (double)this.func_70047_e(), this.field_70161_v, 7.0F, false, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
            this.field_70170_p.func_175669_a(1013, new BlockPos(this), 0);
         }

         this.func_82215_s(var1);
         if(this.field_70173_aa % 10 == 0) {
            this.func_70691_i(10.0F);
         }

      } else {
         super.func_70619_bc();

         int var12;
         for(var1 = 1; var1 < 3; ++var1) {
            if(this.field_70173_aa >= this.field_82223_h[var1 - 1]) {
               this.field_82223_h[var1 - 1] = this.field_70173_aa + 10 + this.field_70146_Z.nextInt(10);
               if(this.field_70170_p.func_175659_aa() == EnumDifficulty.NORMAL || this.field_70170_p.func_175659_aa() == EnumDifficulty.HARD) {
                  int var10001 = var1 - 1;
                  int var10003 = this.field_82224_i[var1 - 1];
                  this.field_82224_i[var10001] = this.field_82224_i[var1 - 1] + 1;
                  if(var10003 > 15) {
                     float var2 = 10.0F;
                     float var3 = 5.0F;
                     double var4 = MathHelper.func_82716_a(this.field_70146_Z, this.field_70165_t - (double)var2, this.field_70165_t + (double)var2);
                     double var6 = MathHelper.func_82716_a(this.field_70146_Z, this.field_70163_u - (double)var3, this.field_70163_u + (double)var3);
                     double var8 = MathHelper.func_82716_a(this.field_70146_Z, this.field_70161_v - (double)var2, this.field_70161_v + (double)var2);
                     this.func_82209_a(var1 + 1, var4, var6, var8, true);
                     this.field_82224_i[var1 - 1] = 0;
                  }
               }

               var12 = this.func_82203_t(var1);
               if(var12 > 0) {
                  Entity var14 = this.field_70170_p.func_73045_a(var12);
                  if(var14 != null && var14.func_70089_S() && this.func_70068_e(var14) <= 900.0D && this.func_70685_l(var14)) {
                     this.func_82216_a(var1 + 1, (EntityLivingBase)var14);
                     this.field_82223_h[var1 - 1] = this.field_70173_aa + 40 + this.field_70146_Z.nextInt(20);
                     this.field_82224_i[var1 - 1] = 0;
                  } else {
                     this.func_82211_c(var1, 0);
                  }
               } else {
                  List var13 = this.field_70170_p.func_175647_a(EntityLivingBase.class, this.func_174813_aQ().func_72314_b(20.0D, 8.0D, 20.0D), Predicates.and(field_82219_bJ, IEntitySelector.field_180132_d));

                  for(int var16 = 0; var16 < 10 && !var13.isEmpty(); ++var16) {
                     EntityLivingBase var5 = (EntityLivingBase)var13.get(this.field_70146_Z.nextInt(var13.size()));
                     if(var5 != this && var5.func_70089_S() && this.func_70685_l(var5)) {
                        if(var5 instanceof EntityPlayer) {
                           if(!((EntityPlayer)var5).field_71075_bZ.field_75102_a) {
                              this.func_82211_c(var1, var5.func_145782_y());
                           }
                        } else {
                           this.func_82211_c(var1, var5.func_145782_y());
                        }
                        break;
                     }

                     var13.remove(var5);
                  }
               }
            }
         }

         if(this.func_70638_az() != null) {
            this.func_82211_c(0, this.func_70638_az().func_145782_y());
         } else {
            this.func_82211_c(0, 0);
         }

         if(this.field_82222_j > 0) {
            --this.field_82222_j;
            if(this.field_82222_j == 0 && this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
               var1 = MathHelper.func_76128_c(this.field_70163_u);
               var12 = MathHelper.func_76128_c(this.field_70165_t);
               int var15 = MathHelper.func_76128_c(this.field_70161_v);
               boolean var17 = false;

               for(int var18 = -1; var18 <= 1; ++var18) {
                  for(int var19 = -1; var19 <= 1; ++var19) {
                     for(int var7 = 0; var7 <= 3; ++var7) {
                        int var20 = var12 + var18;
                        int var9 = var1 + var7;
                        int var10 = var15 + var19;
                        Block var11 = this.field_70170_p.func_180495_p(new BlockPos(var20, var9, var10)).func_177230_c();
                        if(var11.func_149688_o() != Material.field_151579_a && var11 != Blocks.field_150357_h && var11 != Blocks.field_150384_bq && var11 != Blocks.field_150378_br && var11 != Blocks.field_150483_bI && var11 != Blocks.field_180401_cv) {
                           var17 = this.field_70170_p.func_175655_b(new BlockPos(var20, var9, var10), true) || var17;
                        }
                     }
                  }
               }

               if(var17) {
                  this.field_70170_p.func_180498_a((EntityPlayer)null, 1012, new BlockPos(this), 0);
               }
            }
         }

         if(this.field_70173_aa % 20 == 0) {
            this.func_70691_i(1.0F);
         }

      }
   }

   public void func_82206_m() {
      this.func_82215_s(220);
      this.func_70606_j(this.func_110138_aP() / 3.0F);
   }

   public void func_70110_aj() {}

   public int func_70658_aO() {
      return 4;
   }

   private double func_82214_u(int p_82214_1_) {
      if(p_82214_1_ <= 0) {
         return this.field_70165_t;
      } else {
         float var2 = (this.field_70761_aq + (float)(180 * (p_82214_1_ - 1))) / 180.0F * 3.1415927F;
         float var3 = MathHelper.func_76134_b(var2);
         return this.field_70165_t + (double)var3 * 1.3D;
      }
   }

   private double func_82208_v(int p_82208_1_) {
      return p_82208_1_ <= 0?this.field_70163_u + 3.0D:this.field_70163_u + 2.2D;
   }

   private double func_82213_w(int p_82213_1_) {
      if(p_82213_1_ <= 0) {
         return this.field_70161_v;
      } else {
         float var2 = (this.field_70761_aq + (float)(180 * (p_82213_1_ - 1))) / 180.0F * 3.1415927F;
         float var3 = MathHelper.func_76126_a(var2);
         return this.field_70161_v + (double)var3 * 1.3D;
      }
   }

   private float func_82204_b(float p_82204_1_, float p_82204_2_, float p_82204_3_) {
      float var4 = MathHelper.func_76142_g(p_82204_2_ - p_82204_1_);
      if(var4 > p_82204_3_) {
         var4 = p_82204_3_;
      }

      if(var4 < -p_82204_3_) {
         var4 = -p_82204_3_;
      }

      return p_82204_1_ + var4;
   }

   private void func_82216_a(int p_82216_1_, EntityLivingBase p_82216_2_) {
      this.func_82209_a(p_82216_1_, p_82216_2_.field_70165_t, p_82216_2_.field_70163_u + (double)p_82216_2_.func_70047_e() * 0.5D, p_82216_2_.field_70161_v, p_82216_1_ == 0 && this.field_70146_Z.nextFloat() < 0.001F);
   }

   private void func_82209_a(int p_82209_1_, double p_82209_2_, double p_82209_4_, double p_82209_6_, boolean p_82209_8_) {
      this.field_70170_p.func_180498_a((EntityPlayer)null, 1014, new BlockPos(this), 0);
      double var9 = this.func_82214_u(p_82209_1_);
      double var11 = this.func_82208_v(p_82209_1_);
      double var13 = this.func_82213_w(p_82209_1_);
      double var15 = p_82209_2_ - var9;
      double var17 = p_82209_4_ - var11;
      double var19 = p_82209_6_ - var13;
      EntityWitherSkull var21 = new EntityWitherSkull(this.field_70170_p, this, var15, var17, var19);
      if(p_82209_8_) {
         var21.func_82343_e(true);
      }

      var21.field_70163_u = var11;
      var21.field_70165_t = var9;
      var21.field_70161_v = var13;
      this.field_70170_p.func_72838_d(var21);
   }

   public void func_82196_d(EntityLivingBase p_82196_1_, float p_82196_2_) {
      this.func_82216_a(0, p_82196_1_);
   }

   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
      if(this.func_180431_b(p_70097_1_)) {
         return false;
      } else if(p_70097_1_ != DamageSource.field_76369_e && !(p_70097_1_.func_76346_g() instanceof EntityWither)) {
         if(this.func_82212_n() > 0 && p_70097_1_ != DamageSource.field_76380_i) {
            return false;
         } else {
            Entity var3;
            if(this.func_82205_o()) {
               var3 = p_70097_1_.func_76364_f();
               if(var3 instanceof EntityArrow) {
                  return false;
               }
            }

            var3 = p_70097_1_.func_76346_g();
            if(var3 != null && !(var3 instanceof EntityPlayer) && var3 instanceof EntityLivingBase && ((EntityLivingBase)var3).func_70668_bt() == this.func_70668_bt()) {
               return false;
            } else {
               if(this.field_82222_j <= 0) {
                  this.field_82222_j = 20;
               }

               for(int var4 = 0; var4 < this.field_82224_i.length; ++var4) {
                  this.field_82224_i[var4] += 3;
               }

               return super.func_70097_a(p_70097_1_, p_70097_2_);
            }
         }
      } else {
         return false;
      }
   }

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
      EntityItem var3 = this.func_145779_a(Items.field_151156_bN, 1);
      if(var3 != null) {
         var3.func_174873_u();
      }

      if(!this.field_70170_p.field_72995_K) {
         Iterator var4 = this.field_70170_p.func_72872_a(EntityPlayer.class, this.func_174813_aQ().func_72314_b(50.0D, 100.0D, 50.0D)).iterator();

         while(var4.hasNext()) {
            EntityPlayer var5 = (EntityPlayer)var4.next();
            var5.func_71029_a(AchievementList.field_150964_J);
         }
      }

   }

   protected void func_70623_bb() {
      this.field_70708_bq = 0;
   }

   public int func_70070_b(float p_70070_1_) {
      return 15728880;
   }

   public void func_180430_e(float p_180430_1_, float p_180430_2_) {}

   public void func_70690_d(PotionEffect p_70690_1_) {}

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(300.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.6000000238418579D);
      this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(40.0D);
   }

   public float func_82207_a(int p_82207_1_) {
      return this.field_82221_e[p_82207_1_];
   }

   public float func_82210_r(int p_82210_1_) {
      return this.field_82220_d[p_82210_1_];
   }

   public int func_82212_n() {
      return this.field_70180_af.func_75679_c(20);
   }

   public void func_82215_s(int p_82215_1_) {
      this.field_70180_af.func_75692_b(20, Integer.valueOf(p_82215_1_));
   }

   public int func_82203_t(int p_82203_1_) {
      return this.field_70180_af.func_75679_c(17 + p_82203_1_);
   }

   public void func_82211_c(int p_82211_1_, int p_82211_2_) {
      this.field_70180_af.func_75692_b(17 + p_82211_1_, Integer.valueOf(p_82211_2_));
   }

   public boolean func_82205_o() {
      return this.func_110143_aJ() <= this.func_110138_aP() / 2.0F;
   }

   public EnumCreatureAttribute func_70668_bt() {
      return EnumCreatureAttribute.UNDEAD;
   }

   public void func_70078_a(Entity p_70078_1_) {
      this.field_70154_o = null;
   }

}
