package net.minecraft.entity.projectile;

import java.util.Arrays;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.WeightedRandomFishable;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class EntityFishHook extends Entity {

   private static final List field_146039_d = Arrays.asList(new WeightedRandomFishable[]{(new WeightedRandomFishable(new ItemStack(Items.field_151021_T), 10)).func_150709_a(0.9F), new WeightedRandomFishable(new ItemStack(Items.field_151116_aA), 10), new WeightedRandomFishable(new ItemStack(Items.field_151103_aS), 10), new WeightedRandomFishable(new ItemStack(Items.field_151068_bn), 10), new WeightedRandomFishable(new ItemStack(Items.field_151007_F), 5), (new WeightedRandomFishable(new ItemStack(Items.field_151112_aM), 2)).func_150709_a(0.9F), new WeightedRandomFishable(new ItemStack(Items.field_151054_z), 10), new WeightedRandomFishable(new ItemStack(Items.field_151055_y), 5), new WeightedRandomFishable(new ItemStack(Items.field_151100_aR, 10, EnumDyeColor.BLACK.func_176767_b()), 1), new WeightedRandomFishable(new ItemStack(Blocks.field_150479_bC), 10), new WeightedRandomFishable(new ItemStack(Items.field_151078_bh), 10)});
   private static final List field_146041_e = Arrays.asList(new WeightedRandomFishable[]{new WeightedRandomFishable(new ItemStack(Blocks.field_150392_bi), 1), new WeightedRandomFishable(new ItemStack(Items.field_151057_cb), 1), new WeightedRandomFishable(new ItemStack(Items.field_151141_av), 1), (new WeightedRandomFishable(new ItemStack(Items.field_151031_f), 1)).func_150709_a(0.25F).func_150707_a(), (new WeightedRandomFishable(new ItemStack(Items.field_151112_aM), 1)).func_150709_a(0.25F).func_150707_a(), (new WeightedRandomFishable(new ItemStack(Items.field_151122_aG), 1)).func_150707_a()});
   private static final List field_146036_f = Arrays.asList(new WeightedRandomFishable[]{new WeightedRandomFishable(new ItemStack(Items.field_151115_aP, 1, ItemFishFood.FishType.COD.func_150976_a()), 60), new WeightedRandomFishable(new ItemStack(Items.field_151115_aP, 1, ItemFishFood.FishType.SALMON.func_150976_a()), 25), new WeightedRandomFishable(new ItemStack(Items.field_151115_aP, 1, ItemFishFood.FishType.CLOWNFISH.func_150976_a()), 2), new WeightedRandomFishable(new ItemStack(Items.field_151115_aP, 1, ItemFishFood.FishType.PUFFERFISH.func_150976_a()), 13)});
   private int field_146037_g;
   private int field_146048_h;
   private int field_146050_i;
   private Block field_146046_j;
   private boolean field_146051_au;
   public int field_146044_a;
   public EntityPlayer field_146042_b;
   private int field_146049_av;
   private int field_146047_aw;
   private int field_146045_ax;
   private int field_146040_ay;
   private int field_146038_az;
   private float field_146054_aA;
   public Entity field_146043_c;
   private int field_146055_aB;
   private double field_146056_aC;
   private double field_146057_aD;
   private double field_146058_aE;
   private double field_146059_aF;
   private double field_146060_aG;
   private double field_146061_aH;
   private double field_146052_aI;
   private double field_146053_aJ;
   private static final String __OBFID = "CL_00001663";


   public static List func_174855_j() {
      return field_146036_f;
   }

   public EntityFishHook(World p_i1764_1_) {
      super(p_i1764_1_);
      this.field_146037_g = -1;
      this.field_146048_h = -1;
      this.field_146050_i = -1;
      this.func_70105_a(0.25F, 0.25F);
      this.field_70158_ak = true;
   }

   public EntityFishHook(World p_i1765_1_, double p_i1765_2_, double p_i1765_4_, double p_i1765_6_, EntityPlayer p_i1765_8_) {
      this(p_i1765_1_);
      this.func_70107_b(p_i1765_2_, p_i1765_4_, p_i1765_6_);
      this.field_70158_ak = true;
      this.field_146042_b = p_i1765_8_;
      p_i1765_8_.field_71104_cf = this;
   }

   public EntityFishHook(World p_i1766_1_, EntityPlayer p_i1766_2_) {
      super(p_i1766_1_);
      this.field_146037_g = -1;
      this.field_146048_h = -1;
      this.field_146050_i = -1;
      this.field_70158_ak = true;
      this.field_146042_b = p_i1766_2_;
      this.field_146042_b.field_71104_cf = this;
      this.func_70105_a(0.25F, 0.25F);
      this.func_70012_b(p_i1766_2_.field_70165_t, p_i1766_2_.field_70163_u + (double)p_i1766_2_.func_70047_e(), p_i1766_2_.field_70161_v, p_i1766_2_.field_70177_z, p_i1766_2_.field_70125_A);
      this.field_70165_t -= (double)(MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
      this.field_70163_u -= 0.10000000149011612D;
      this.field_70161_v -= (double)(MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      float var3 = 0.4F;
      this.field_70159_w = (double)(-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * var3);
      this.field_70179_y = (double)(MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * var3);
      this.field_70181_x = (double)(-MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F) * var3);
      this.func_146035_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, 1.5F, 1.0F);
   }

   protected void func_70088_a() {}

   public boolean func_70112_a(double p_70112_1_) {
      double var3 = this.func_174813_aQ().func_72320_b() * 4.0D;
      var3 *= 64.0D;
      return p_70112_1_ < var3 * var3;
   }

   public void func_146035_c(double p_146035_1_, double p_146035_3_, double p_146035_5_, float p_146035_7_, float p_146035_8_) {
      float var9 = MathHelper.func_76133_a(p_146035_1_ * p_146035_1_ + p_146035_3_ * p_146035_3_ + p_146035_5_ * p_146035_5_);
      p_146035_1_ /= (double)var9;
      p_146035_3_ /= (double)var9;
      p_146035_5_ /= (double)var9;
      p_146035_1_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * (double)p_146035_8_;
      p_146035_3_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * (double)p_146035_8_;
      p_146035_5_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * (double)p_146035_8_;
      p_146035_1_ *= (double)p_146035_7_;
      p_146035_3_ *= (double)p_146035_7_;
      p_146035_5_ *= (double)p_146035_7_;
      this.field_70159_w = p_146035_1_;
      this.field_70181_x = p_146035_3_;
      this.field_70179_y = p_146035_5_;
      float var10 = MathHelper.func_76133_a(p_146035_1_ * p_146035_1_ + p_146035_5_ * p_146035_5_);
      this.field_70126_B = this.field_70177_z = (float)(Math.atan2(p_146035_1_, p_146035_5_) * 180.0D / 3.1415927410125732D);
      this.field_70127_C = this.field_70125_A = (float)(Math.atan2(p_146035_3_, (double)var10) * 180.0D / 3.1415927410125732D);
      this.field_146049_av = 0;
   }

   public void func_180426_a(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
      this.field_146056_aC = p_180426_1_;
      this.field_146057_aD = p_180426_3_;
      this.field_146058_aE = p_180426_5_;
      this.field_146059_aF = (double)p_180426_7_;
      this.field_146060_aG = (double)p_180426_8_;
      this.field_146055_aB = p_180426_9_;
      this.field_70159_w = this.field_146061_aH;
      this.field_70181_x = this.field_146052_aI;
      this.field_70179_y = this.field_146053_aJ;
   }

   public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
      this.field_146061_aH = this.field_70159_w = p_70016_1_;
      this.field_146052_aI = this.field_70181_x = p_70016_3_;
      this.field_146053_aJ = this.field_70179_y = p_70016_5_;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if(this.field_146055_aB > 0) {
         double var28 = this.field_70165_t + (this.field_146056_aC - this.field_70165_t) / (double)this.field_146055_aB;
         double var29 = this.field_70163_u + (this.field_146057_aD - this.field_70163_u) / (double)this.field_146055_aB;
         double var30 = this.field_70161_v + (this.field_146058_aE - this.field_70161_v) / (double)this.field_146055_aB;
         double var7 = MathHelper.func_76138_g(this.field_146059_aF - (double)this.field_70177_z);
         this.field_70177_z = (float)((double)this.field_70177_z + var7 / (double)this.field_146055_aB);
         this.field_70125_A = (float)((double)this.field_70125_A + (this.field_146060_aG - (double)this.field_70125_A) / (double)this.field_146055_aB);
         --this.field_146055_aB;
         this.func_70107_b(var28, var29, var30);
         this.func_70101_b(this.field_70177_z, this.field_70125_A);
      } else {
         if(!this.field_70170_p.field_72995_K) {
            ItemStack var1 = this.field_146042_b.func_71045_bC();
            if(this.field_146042_b.field_70128_L || !this.field_146042_b.func_70089_S() || var1 == null || var1.func_77973_b() != Items.field_151112_aM || this.func_70068_e(this.field_146042_b) > 1024.0D) {
               this.func_70106_y();
               this.field_146042_b.field_71104_cf = null;
               return;
            }

            if(this.field_146043_c != null) {
               if(!this.field_146043_c.field_70128_L) {
                  this.field_70165_t = this.field_146043_c.field_70165_t;
                  double var10002 = (double)this.field_146043_c.field_70131_O;
                  this.field_70163_u = this.field_146043_c.func_174813_aQ().field_72338_b + var10002 * 0.8D;
                  this.field_70161_v = this.field_146043_c.field_70161_v;
                  return;
               }

               this.field_146043_c = null;
            }
         }

         if(this.field_146044_a > 0) {
            --this.field_146044_a;
         }

         if(this.field_146051_au) {
            if(this.field_70170_p.func_180495_p(new BlockPos(this.field_146037_g, this.field_146048_h, this.field_146050_i)).func_177230_c() == this.field_146046_j) {
               ++this.field_146049_av;
               if(this.field_146049_av == 1200) {
                  this.func_70106_y();
               }

               return;
            }

            this.field_146051_au = false;
            this.field_70159_w *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
            this.field_70181_x *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
            this.field_70179_y *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
            this.field_146049_av = 0;
            this.field_146047_aw = 0;
         } else {
            ++this.field_146047_aw;
         }

         Vec3 var27 = new Vec3(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         Vec3 var2 = new Vec3(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
         MovingObjectPosition var3 = this.field_70170_p.func_72933_a(var27, var2);
         var27 = new Vec3(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         var2 = new Vec3(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
         if(var3 != null) {
            var2 = new Vec3(var3.field_72307_f.field_72450_a, var3.field_72307_f.field_72448_b, var3.field_72307_f.field_72449_c);
         }

         Entity var4 = null;
         List var5 = this.field_70170_p.func_72839_b(this, this.func_174813_aQ().func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
         double var6 = 0.0D;

         double var13;
         for(int var8 = 0; var8 < var5.size(); ++var8) {
            Entity var9 = (Entity)var5.get(var8);
            if(var9.func_70067_L() && (var9 != this.field_146042_b || this.field_146047_aw >= 5)) {
               float var10 = 0.3F;
               AxisAlignedBB var11 = var9.func_174813_aQ().func_72314_b((double)var10, (double)var10, (double)var10);
               MovingObjectPosition var12 = var11.func_72327_a(var27, var2);
               if(var12 != null) {
                  var13 = var27.func_72438_d(var12.field_72307_f);
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
            if(var3.field_72308_g != null) {
               if(var3.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, this.field_146042_b), 0.0F)) {
                  this.field_146043_c = var3.field_72308_g;
               }
            } else {
               this.field_146051_au = true;
            }
         }

         if(!this.field_146051_au) {
            this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            float var31 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.1415927410125732D);

            for(this.field_70125_A = (float)(Math.atan2(this.field_70181_x, (double)var31) * 180.0D / 3.1415927410125732D); this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F) {
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
            float var32 = 0.92F;
            if(this.field_70122_E || this.field_70123_F) {
               var32 = 0.5F;
            }

            byte var33 = 5;
            double var34 = 0.0D;

            double var19;
            for(int var35 = 0; var35 < var33; ++var35) {
               AxisAlignedBB var14 = this.func_174813_aQ();
               double var15 = var14.field_72337_e - var14.field_72338_b;
               double var17 = var14.field_72338_b + var15 * (double)var35 / (double)var33;
               var19 = var14.field_72338_b + var15 * (double)(var35 + 1) / (double)var33;
               AxisAlignedBB var21 = new AxisAlignedBB(var14.field_72340_a, var17, var14.field_72339_c, var14.field_72336_d, var19, var14.field_72334_f);
               if(this.field_70170_p.func_72830_b(var21, Material.field_151586_h)) {
                  var34 += 1.0D / (double)var33;
               }
            }

            if(!this.field_70170_p.field_72995_K && var34 > 0.0D) {
               WorldServer var36 = (WorldServer)this.field_70170_p;
               int var37 = 1;
               BlockPos var38 = (new BlockPos(this)).func_177984_a();
               if(this.field_70146_Z.nextFloat() < 0.25F && this.field_70170_p.func_175727_C(var38)) {
                  var37 = 2;
               }

               if(this.field_70146_Z.nextFloat() < 0.5F && !this.field_70170_p.func_175678_i(var38)) {
                  --var37;
               }

               if(this.field_146045_ax > 0) {
                  --this.field_146045_ax;
                  if(this.field_146045_ax <= 0) {
                     this.field_146040_ay = 0;
                     this.field_146038_az = 0;
                  }
               } else {
                  float var16;
                  float var18;
                  double var23;
                  float var39;
                  double var40;
                  if(this.field_146038_az > 0) {
                     this.field_146038_az -= var37;
                     if(this.field_146038_az <= 0) {
                        this.field_70181_x -= 0.20000000298023224D;
                        this.func_85030_a("random.splash", 0.25F, 1.0F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4F);
                        var16 = (float)MathHelper.func_76128_c(this.func_174813_aQ().field_72338_b);
                        var36.func_175739_a(EnumParticleTypes.WATER_BUBBLE, this.field_70165_t, (double)(var16 + 1.0F), this.field_70161_v, (int)(1.0F + this.field_70130_N * 20.0F), (double)this.field_70130_N, 0.0D, (double)this.field_70130_N, 0.20000000298023224D, new int[0]);
                        var36.func_175739_a(EnumParticleTypes.WATER_WAKE, this.field_70165_t, (double)(var16 + 1.0F), this.field_70161_v, (int)(1.0F + this.field_70130_N * 20.0F), (double)this.field_70130_N, 0.0D, (double)this.field_70130_N, 0.20000000298023224D, new int[0]);
                        this.field_146045_ax = MathHelper.func_76136_a(this.field_70146_Z, 10, 30);
                     } else {
                        this.field_146054_aA = (float)((double)this.field_146054_aA + this.field_70146_Z.nextGaussian() * 4.0D);
                        var16 = this.field_146054_aA * 0.017453292F;
                        var39 = MathHelper.func_76126_a(var16);
                        var18 = MathHelper.func_76134_b(var16);
                        var19 = this.field_70165_t + (double)(var39 * (float)this.field_146038_az * 0.1F);
                        var40 = (double)((float)MathHelper.func_76128_c(this.func_174813_aQ().field_72338_b) + 1.0F);
                        var23 = this.field_70161_v + (double)(var18 * (float)this.field_146038_az * 0.1F);
                        if(this.field_70146_Z.nextFloat() < 0.15F) {
                           var36.func_175739_a(EnumParticleTypes.WATER_BUBBLE, var19, var40 - 0.10000000149011612D, var23, 1, (double)var39, 0.1D, (double)var18, 0.0D, new int[0]);
                        }

                        float var25 = var39 * 0.04F;
                        float var26 = var18 * 0.04F;
                        var36.func_175739_a(EnumParticleTypes.WATER_WAKE, var19, var40, var23, 0, (double)var26, 0.01D, (double)(-var25), 1.0D, new int[0]);
                        var36.func_175739_a(EnumParticleTypes.WATER_WAKE, var19, var40, var23, 0, (double)(-var26), 0.01D, (double)var25, 1.0D, new int[0]);
                     }
                  } else if(this.field_146040_ay > 0) {
                     this.field_146040_ay -= var37;
                     var16 = 0.15F;
                     if(this.field_146040_ay < 20) {
                        var16 = (float)((double)var16 + (double)(20 - this.field_146040_ay) * 0.05D);
                     } else if(this.field_146040_ay < 40) {
                        var16 = (float)((double)var16 + (double)(40 - this.field_146040_ay) * 0.02D);
                     } else if(this.field_146040_ay < 60) {
                        var16 = (float)((double)var16 + (double)(60 - this.field_146040_ay) * 0.01D);
                     }

                     if(this.field_70146_Z.nextFloat() < var16) {
                        var39 = MathHelper.func_151240_a(this.field_70146_Z, 0.0F, 360.0F) * 0.017453292F;
                        var18 = MathHelper.func_151240_a(this.field_70146_Z, 25.0F, 60.0F);
                        var19 = this.field_70165_t + (double)(MathHelper.func_76126_a(var39) * var18 * 0.1F);
                        var40 = (double)((float)MathHelper.func_76128_c(this.func_174813_aQ().field_72338_b) + 1.0F);
                        var23 = this.field_70161_v + (double)(MathHelper.func_76134_b(var39) * var18 * 0.1F);
                        var36.func_175739_a(EnumParticleTypes.WATER_SPLASH, var19, var40, var23, 2 + this.field_70146_Z.nextInt(2), 0.10000000149011612D, 0.0D, 0.10000000149011612D, 0.0D, new int[0]);
                     }

                     if(this.field_146040_ay <= 0) {
                        this.field_146054_aA = MathHelper.func_151240_a(this.field_70146_Z, 0.0F, 360.0F);
                        this.field_146038_az = MathHelper.func_76136_a(this.field_70146_Z, 20, 80);
                     }
                  } else {
                     this.field_146040_ay = MathHelper.func_76136_a(this.field_70146_Z, 100, 900);
                     this.field_146040_ay -= EnchantmentHelper.func_151387_h(this.field_146042_b) * 20 * 5;
                  }
               }

               if(this.field_146045_ax > 0) {
                  this.field_70181_x -= (double)(this.field_70146_Z.nextFloat() * this.field_70146_Z.nextFloat() * this.field_70146_Z.nextFloat()) * 0.2D;
               }
            }

            var13 = var34 * 2.0D - 1.0D;
            this.field_70181_x += 0.03999999910593033D * var13;
            if(var34 > 0.0D) {
               var32 = (float)((double)var32 * 0.9D);
               this.field_70181_x *= 0.8D;
            }

            this.field_70159_w *= (double)var32;
            this.field_70181_x *= (double)var32;
            this.field_70179_y *= (double)var32;
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         }
      }
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      p_70014_1_.func_74777_a("xTile", (short)this.field_146037_g);
      p_70014_1_.func_74777_a("yTile", (short)this.field_146048_h);
      p_70014_1_.func_74777_a("zTile", (short)this.field_146050_i);
      ResourceLocation var2 = (ResourceLocation)Block.field_149771_c.func_177774_c(this.field_146046_j);
      p_70014_1_.func_74778_a("inTile", var2 == null?"":var2.toString());
      p_70014_1_.func_74774_a("shake", (byte)this.field_146044_a);
      p_70014_1_.func_74774_a("inGround", (byte)(this.field_146051_au?1:0));
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      this.field_146037_g = p_70037_1_.func_74765_d("xTile");
      this.field_146048_h = p_70037_1_.func_74765_d("yTile");
      this.field_146050_i = p_70037_1_.func_74765_d("zTile");
      if(p_70037_1_.func_150297_b("inTile", 8)) {
         this.field_146046_j = Block.func_149684_b(p_70037_1_.func_74779_i("inTile"));
      } else {
         this.field_146046_j = Block.func_149729_e(p_70037_1_.func_74771_c("inTile") & 255);
      }

      this.field_146044_a = p_70037_1_.func_74771_c("shake") & 255;
      this.field_146051_au = p_70037_1_.func_74771_c("inGround") == 1;
   }

   public int func_146034_e() {
      if(this.field_70170_p.field_72995_K) {
         return 0;
      } else {
         byte var1 = 0;
         if(this.field_146043_c != null) {
            double var2 = this.field_146042_b.field_70165_t - this.field_70165_t;
            double var4 = this.field_146042_b.field_70163_u - this.field_70163_u;
            double var6 = this.field_146042_b.field_70161_v - this.field_70161_v;
            double var8 = (double)MathHelper.func_76133_a(var2 * var2 + var4 * var4 + var6 * var6);
            double var10 = 0.1D;
            this.field_146043_c.field_70159_w += var2 * var10;
            this.field_146043_c.field_70181_x += var4 * var10 + (double)MathHelper.func_76133_a(var8) * 0.08D;
            this.field_146043_c.field_70179_y += var6 * var10;
            var1 = 3;
         } else if(this.field_146045_ax > 0) {
            EntityItem var13 = new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.func_146033_f());
            double var3 = this.field_146042_b.field_70165_t - this.field_70165_t;
            double var5 = this.field_146042_b.field_70163_u - this.field_70163_u;
            double var7 = this.field_146042_b.field_70161_v - this.field_70161_v;
            double var9 = (double)MathHelper.func_76133_a(var3 * var3 + var5 * var5 + var7 * var7);
            double var11 = 0.1D;
            var13.field_70159_w = var3 * var11;
            var13.field_70181_x = var5 * var11 + (double)MathHelper.func_76133_a(var9) * 0.08D;
            var13.field_70179_y = var7 * var11;
            this.field_70170_p.func_72838_d(var13);
            this.field_146042_b.field_70170_p.func_72838_d(new EntityXPOrb(this.field_146042_b.field_70170_p, this.field_146042_b.field_70165_t, this.field_146042_b.field_70163_u + 0.5D, this.field_146042_b.field_70161_v + 0.5D, this.field_70146_Z.nextInt(6) + 1));
            var1 = 1;
         }

         if(this.field_146051_au) {
            var1 = 2;
         }

         this.func_70106_y();
         this.field_146042_b.field_71104_cf = null;
         return var1;
      }
   }

   private ItemStack func_146033_f() {
      float var1 = this.field_70170_p.field_73012_v.nextFloat();
      int var2 = EnchantmentHelper.func_151386_g(this.field_146042_b);
      int var3 = EnchantmentHelper.func_151387_h(this.field_146042_b);
      float var4 = 0.1F - (float)var2 * 0.025F - (float)var3 * 0.01F;
      float var5 = 0.05F + (float)var2 * 0.01F - (float)var3 * 0.01F;
      var4 = MathHelper.func_76131_a(var4, 0.0F, 1.0F);
      var5 = MathHelper.func_76131_a(var5, 0.0F, 1.0F);
      if(var1 < var4) {
         this.field_146042_b.func_71029_a(StatList.field_151183_A);
         return ((WeightedRandomFishable)WeightedRandom.func_76271_a(this.field_70146_Z, field_146039_d)).func_150708_a(this.field_70146_Z);
      } else {
         var1 -= var4;
         if(var1 < var5) {
            this.field_146042_b.func_71029_a(StatList.field_151184_B);
            return ((WeightedRandomFishable)WeightedRandom.func_76271_a(this.field_70146_Z, field_146041_e)).func_150708_a(this.field_70146_Z);
         } else {
            float var10000 = var1 - var5;
            this.field_146042_b.func_71029_a(StatList.field_75933_B);
            return ((WeightedRandomFishable)WeightedRandom.func_76271_a(this.field_70146_Z, field_146036_f)).func_150708_a(this.field_70146_Z);
         }
      }
   }

   public void func_70106_y() {
      super.func_70106_y();
      if(this.field_146042_b != null) {
         this.field_146042_b.field_71104_cf = null;
      }

   }

}
