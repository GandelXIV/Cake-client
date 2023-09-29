package net.minecraft.entity;

import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import org.apache.commons.lang3.Validate;

public abstract class EntityHanging extends Entity {

   private int field_70520_f;
   protected BlockPos field_174861_a;
   public EnumFacing field_174860_b;
   private static final String __OBFID = "CL_00001546";


   public EntityHanging(World p_i1588_1_) {
      super(p_i1588_1_);
      this.func_70105_a(0.5F, 0.5F);
   }

   public EntityHanging(World p_i45853_1_, BlockPos p_i45853_2_) {
      this(p_i45853_1_);
      this.field_174861_a = p_i45853_2_;
   }

   protected void func_70088_a() {}

   protected void func_174859_a(EnumFacing p_174859_1_) {
      Validate.notNull(p_174859_1_);
      Validate.isTrue(p_174859_1_.func_176740_k().func_176722_c());
      this.field_174860_b = p_174859_1_;
      this.field_70126_B = this.field_70177_z = (float)(this.field_174860_b.func_176736_b() * 90);
      this.func_174856_o();
   }

   private void func_174856_o() {
      if(this.field_174860_b != null) {
         double var1 = (double)this.field_174861_a.func_177958_n() + 0.5D;
         double var3 = (double)this.field_174861_a.func_177956_o() + 0.5D;
         double var5 = (double)this.field_174861_a.func_177952_p() + 0.5D;
         double var7 = 0.46875D;
         double var9 = this.func_174858_a(this.func_82329_d());
         double var11 = this.func_174858_a(this.func_82330_g());
         var1 -= (double)this.field_174860_b.func_82601_c() * 0.46875D;
         var5 -= (double)this.field_174860_b.func_82599_e() * 0.46875D;
         var3 += var11;
         EnumFacing var13 = this.field_174860_b.func_176735_f();
         var1 += var9 * (double)var13.func_82601_c();
         var5 += var9 * (double)var13.func_82599_e();
         this.field_70165_t = var1;
         this.field_70163_u = var3;
         this.field_70161_v = var5;
         double var14 = (double)this.func_82329_d();
         double var16 = (double)this.func_82330_g();
         double var18 = (double)this.func_82329_d();
         if(this.field_174860_b.func_176740_k() == EnumFacing.Axis.Z) {
            var18 = 1.0D;
         } else {
            var14 = 1.0D;
         }

         var14 /= 32.0D;
         var16 /= 32.0D;
         var18 /= 32.0D;
         this.func_174826_a(new AxisAlignedBB(var1 - var14, var3 - var16, var5 - var18, var1 + var14, var3 + var16, var5 + var18));
      }
   }

   private double func_174858_a(int p_174858_1_) {
      return p_174858_1_ % 32 == 0?0.5D:0.0D;
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      if(this.field_70520_f++ == 100 && !this.field_70170_p.field_72995_K) {
         this.field_70520_f = 0;
         if(!this.field_70128_L && !this.func_70518_d()) {
            this.func_70106_y();
            this.func_110128_b((Entity)null);
         }
      }

   }

   public boolean func_70518_d() {
      if(!this.field_70170_p.func_72945_a(this, this.func_174813_aQ()).isEmpty()) {
         return false;
      } else {
         int var1 = Math.max(1, this.func_82329_d() / 16);
         int var2 = Math.max(1, this.func_82330_g() / 16);
         BlockPos var3 = this.field_174861_a.func_177972_a(this.field_174860_b.func_176734_d());
         EnumFacing var4 = this.field_174860_b.func_176735_f();

         for(int var5 = 0; var5 < var1; ++var5) {
            for(int var6 = 0; var6 < var2; ++var6) {
               BlockPos var7 = var3.func_177967_a(var4, var5).func_177981_b(var6);
               Block var8 = this.field_70170_p.func_180495_p(var7).func_177230_c();
               if(!var8.func_149688_o().func_76220_a() && !BlockRedstoneDiode.func_149909_d(var8)) {
                  return false;
               }
            }
         }

         List var9 = this.field_70170_p.func_72839_b(this, this.func_174813_aQ());
         Iterator var10 = var9.iterator();

         Entity var11;
         do {
            if(!var10.hasNext()) {
               return true;
            }

            var11 = (Entity)var10.next();
         } while(!(var11 instanceof EntityHanging));

         return false;
      }
   }

   public boolean func_70067_L() {
      return true;
   }

   public boolean func_85031_j(Entity p_85031_1_) {
      return p_85031_1_ instanceof EntityPlayer?this.func_70097_a(DamageSource.func_76365_a((EntityPlayer)p_85031_1_), 0.0F):false;
   }

   public EnumFacing func_174811_aO() {
      return this.field_174860_b;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
      if(this.func_180431_b(p_70097_1_)) {
         return false;
      } else {
         if(!this.field_70128_L && !this.field_70170_p.field_72995_K) {
            this.func_70106_y();
            this.func_70018_K();
            this.func_110128_b(p_70097_1_.func_76346_g());
         }

         return true;
      }
   }

   public void func_70091_d(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
      if(!this.field_70170_p.field_72995_K && !this.field_70128_L && p_70091_1_ * p_70091_1_ + p_70091_3_ * p_70091_3_ + p_70091_5_ * p_70091_5_ > 0.0D) {
         this.func_70106_y();
         this.func_110128_b((Entity)null);
      }

   }

   public void func_70024_g(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
      if(!this.field_70170_p.field_72995_K && !this.field_70128_L && p_70024_1_ * p_70024_1_ + p_70024_3_ * p_70024_3_ + p_70024_5_ * p_70024_5_ > 0.0D) {
         this.func_70106_y();
         this.func_110128_b((Entity)null);
      }

   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      p_70014_1_.func_74774_a("Facing", (byte)this.field_174860_b.func_176736_b());
      p_70014_1_.func_74768_a("TileX", this.func_174857_n().func_177958_n());
      p_70014_1_.func_74768_a("TileY", this.func_174857_n().func_177956_o());
      p_70014_1_.func_74768_a("TileZ", this.func_174857_n().func_177952_p());
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      this.field_174861_a = new BlockPos(p_70037_1_.func_74762_e("TileX"), p_70037_1_.func_74762_e("TileY"), p_70037_1_.func_74762_e("TileZ"));
      EnumFacing var2;
      if(p_70037_1_.func_150297_b("Direction", 99)) {
         var2 = EnumFacing.func_176731_b(p_70037_1_.func_74771_c("Direction"));
         this.field_174861_a = this.field_174861_a.func_177972_a(var2);
      } else if(p_70037_1_.func_150297_b("Facing", 99)) {
         var2 = EnumFacing.func_176731_b(p_70037_1_.func_74771_c("Facing"));
      } else {
         var2 = EnumFacing.func_176731_b(p_70037_1_.func_74771_c("Dir"));
      }

      this.func_174859_a(var2);
   }

   public abstract int func_82329_d();

   public abstract int func_82330_g();

   public abstract void func_110128_b(Entity var1);

   protected boolean func_142008_O() {
      return false;
   }

   public void func_70107_b(double p_70107_1_, double p_70107_3_, double p_70107_5_) {
      this.field_70165_t = p_70107_1_;
      this.field_70163_u = p_70107_3_;
      this.field_70161_v = p_70107_5_;
      BlockPos var7 = this.field_174861_a;
      this.field_174861_a = new BlockPos(p_70107_1_, p_70107_3_, p_70107_5_);
      if(!this.field_174861_a.equals(var7)) {
         this.func_174856_o();
         this.field_70160_al = true;
      }

   }

   public BlockPos func_174857_n() {
      return this.field_174861_a;
   }
}
