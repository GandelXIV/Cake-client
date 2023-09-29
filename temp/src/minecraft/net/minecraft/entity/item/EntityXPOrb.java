package net.minecraft.entity.item;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityXPOrb extends Entity {

   public int field_70533_a;
   public int field_70531_b;
   public int field_70532_c;
   private int field_70529_d = 5;
   private int field_70530_e;
   private EntityPlayer field_80001_f;
   private int field_80002_g;
   private static final String __OBFID = "CL_00001544";


   public EntityXPOrb(World p_i1585_1_, double p_i1585_2_, double p_i1585_4_, double p_i1585_6_, int p_i1585_8_) {
      super(p_i1585_1_);
      this.func_70105_a(0.5F, 0.5F);
      this.func_70107_b(p_i1585_2_, p_i1585_4_, p_i1585_6_);
      this.field_70177_z = (float)(Math.random() * 360.0D);
      this.field_70159_w = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
      this.field_70181_x = (double)((float)(Math.random() * 0.2D) * 2.0F);
      this.field_70179_y = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
      this.field_70530_e = p_i1585_8_;
   }

   protected boolean func_70041_e_() {
      return false;
   }

   public EntityXPOrb(World p_i1586_1_) {
      super(p_i1586_1_);
      this.func_70105_a(0.25F, 0.25F);
   }

   protected void func_70088_a() {}

   public int func_70070_b(float p_70070_1_) {
      float var2 = 0.5F;
      var2 = MathHelper.func_76131_a(var2, 0.0F, 1.0F);
      int var3 = super.func_70070_b(p_70070_1_);
      int var4 = var3 & 255;
      int var5 = var3 >> 16 & 255;
      var4 += (int)(var2 * 15.0F * 16.0F);
      if(var4 > 240) {
         var4 = 240;
      }

      return var4 | var5 << 16;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if(this.field_70532_c > 0) {
         --this.field_70532_c;
      }

      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      this.field_70181_x -= 0.029999999329447746D;
      if(this.field_70170_p.func_180495_p(new BlockPos(this)).func_177230_c().func_149688_o() == Material.field_151587_i) {
         this.field_70181_x = 0.20000000298023224D;
         this.field_70159_w = (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F);
         this.field_70179_y = (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F);
         this.func_85030_a("random.fizz", 0.4F, 2.0F + this.field_70146_Z.nextFloat() * 0.4F);
      }

      this.func_145771_j(this.field_70165_t, (this.func_174813_aQ().field_72338_b + this.func_174813_aQ().field_72337_e) / 2.0D, this.field_70161_v);
      double var1 = 8.0D;
      if(this.field_80002_g < this.field_70533_a - 20 + this.func_145782_y() % 100) {
         if(this.field_80001_f == null || this.field_80001_f.func_70068_e(this) > var1 * var1) {
            this.field_80001_f = this.field_70170_p.func_72890_a(this, var1);
         }

         this.field_80002_g = this.field_70533_a;
      }

      if(this.field_80001_f != null && this.field_80001_f.func_175149_v()) {
         this.field_80001_f = null;
      }

      if(this.field_80001_f != null) {
         double var3 = (this.field_80001_f.field_70165_t - this.field_70165_t) / var1;
         double var5 = (this.field_80001_f.field_70163_u + (double)this.field_80001_f.func_70047_e() - this.field_70163_u) / var1;
         double var7 = (this.field_80001_f.field_70161_v - this.field_70161_v) / var1;
         double var9 = Math.sqrt(var3 * var3 + var5 * var5 + var7 * var7);
         double var11 = 1.0D - var9;
         if(var11 > 0.0D) {
            var11 *= var11;
            this.field_70159_w += var3 / var9 * var11 * 0.1D;
            this.field_70181_x += var5 / var9 * var11 * 0.1D;
            this.field_70179_y += var7 / var9 * var11 * 0.1D;
         }
      }

      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      float var13 = 0.98F;
      if(this.field_70122_E) {
         var13 = this.field_70170_p.func_180495_p(new BlockPos(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.func_174813_aQ().field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v))).func_177230_c().field_149765_K * 0.98F;
      }

      this.field_70159_w *= (double)var13;
      this.field_70181_x *= 0.9800000190734863D;
      this.field_70179_y *= (double)var13;
      if(this.field_70122_E) {
         this.field_70181_x *= -0.8999999761581421D;
      }

      ++this.field_70533_a;
      ++this.field_70531_b;
      if(this.field_70531_b >= 6000) {
         this.func_70106_y();
      }

   }

   public boolean func_70072_I() {
      return this.field_70170_p.func_72918_a(this.func_174813_aQ(), Material.field_151586_h, this);
   }

   protected void func_70081_e(int p_70081_1_) {
      this.func_70097_a(DamageSource.field_76372_a, (float)p_70081_1_);
   }

   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
      if(this.func_180431_b(p_70097_1_)) {
         return false;
      } else {
         this.func_70018_K();
         this.field_70529_d = (int)((float)this.field_70529_d - p_70097_2_);
         if(this.field_70529_d <= 0) {
            this.func_70106_y();
         }

         return false;
      }
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      p_70014_1_.func_74777_a("Health", (short)((byte)this.field_70529_d));
      p_70014_1_.func_74777_a("Age", (short)this.field_70531_b);
      p_70014_1_.func_74777_a("Value", (short)this.field_70530_e);
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      this.field_70529_d = p_70037_1_.func_74765_d("Health") & 255;
      this.field_70531_b = p_70037_1_.func_74765_d("Age");
      this.field_70530_e = p_70037_1_.func_74765_d("Value");
   }

   public void func_70100_b_(EntityPlayer p_70100_1_) {
      if(!this.field_70170_p.field_72995_K) {
         if(this.field_70532_c == 0 && p_70100_1_.field_71090_bL == 0) {
            p_70100_1_.field_71090_bL = 2;
            this.field_70170_p.func_72956_a(p_70100_1_, "random.orb", 0.1F, 0.5F * ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7F + 1.8F));
            p_70100_1_.func_71001_a(this, 1);
            p_70100_1_.func_71023_q(this.field_70530_e);
            this.func_70106_y();
         }

      }
   }

   public int func_70526_d() {
      return this.field_70530_e;
   }

   public int func_70528_g() {
      return this.field_70530_e >= 2477?10:(this.field_70530_e >= 1237?9:(this.field_70530_e >= 617?8:(this.field_70530_e >= 307?7:(this.field_70530_e >= 149?6:(this.field_70530_e >= 73?5:(this.field_70530_e >= 37?4:(this.field_70530_e >= 17?3:(this.field_70530_e >= 7?2:(this.field_70530_e >= 3?1:0)))))))));
   }

   public static int func_70527_a(int p_70527_0_) {
      return p_70527_0_ >= 2477?2477:(p_70527_0_ >= 1237?1237:(p_70527_0_ >= 617?617:(p_70527_0_ >= 307?307:(p_70527_0_ >= 149?149:(p_70527_0_ >= 73?73:(p_70527_0_ >= 37?37:(p_70527_0_ >= 17?17:(p_70527_0_ >= 7?7:(p_70527_0_ >= 3?3:1)))))))));
   }

   public boolean func_70075_an() {
      return false;
   }
}
