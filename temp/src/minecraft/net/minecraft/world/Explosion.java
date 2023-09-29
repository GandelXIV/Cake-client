package net.minecraft.world;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class Explosion {

   private final boolean field_77286_a;
   private final boolean field_82755_b;
   private final Random field_77290_i;
   private final World field_77287_j;
   private final double field_77284_b;
   private final double field_77285_c;
   private final double field_77282_d;
   private final Entity field_77283_e;
   private final float field_77280_f;
   private final List field_77281_g;
   private final Map field_77288_k;
   private static final String __OBFID = "CL_00000134";


   public Explosion(World p_i45752_1_, Entity p_i45752_2_, double p_i45752_3_, double p_i45752_5_, double p_i45752_7_, float p_i45752_9_, List p_i45752_10_) {
      this(p_i45752_1_, p_i45752_2_, p_i45752_3_, p_i45752_5_, p_i45752_7_, p_i45752_9_, false, true, p_i45752_10_);
   }

   public Explosion(World p_i45753_1_, Entity p_i45753_2_, double p_i45753_3_, double p_i45753_5_, double p_i45753_7_, float p_i45753_9_, boolean p_i45753_10_, boolean p_i45753_11_, List p_i45753_12_) {
      this(p_i45753_1_, p_i45753_2_, p_i45753_3_, p_i45753_5_, p_i45753_7_, p_i45753_9_, p_i45753_10_, p_i45753_11_);
      this.field_77281_g.addAll(p_i45753_12_);
   }

   public Explosion(World p_i45754_1_, Entity p_i45754_2_, double p_i45754_3_, double p_i45754_5_, double p_i45754_7_, float p_i45754_9_, boolean p_i45754_10_, boolean p_i45754_11_) {
      this.field_77290_i = new Random();
      this.field_77281_g = Lists.newArrayList();
      this.field_77288_k = Maps.newHashMap();
      this.field_77287_j = p_i45754_1_;
      this.field_77283_e = p_i45754_2_;
      this.field_77280_f = p_i45754_9_;
      this.field_77284_b = p_i45754_3_;
      this.field_77285_c = p_i45754_5_;
      this.field_77282_d = p_i45754_7_;
      this.field_77286_a = p_i45754_10_;
      this.field_82755_b = p_i45754_11_;
   }

   public void func_77278_a() {
      HashSet var1 = Sets.newHashSet();
      boolean var2 = true;

      int var4;
      int var5;
      for(int var3 = 0; var3 < 16; ++var3) {
         for(var4 = 0; var4 < 16; ++var4) {
            for(var5 = 0; var5 < 16; ++var5) {
               if(var3 == 0 || var3 == 15 || var4 == 0 || var4 == 15 || var5 == 0 || var5 == 15) {
                  double var6 = (double)((float)var3 / 15.0F * 2.0F - 1.0F);
                  double var8 = (double)((float)var4 / 15.0F * 2.0F - 1.0F);
                  double var10 = (double)((float)var5 / 15.0F * 2.0F - 1.0F);
                  double var12 = Math.sqrt(var6 * var6 + var8 * var8 + var10 * var10);
                  var6 /= var12;
                  var8 /= var12;
                  var10 /= var12;
                  float var14 = this.field_77280_f * (0.7F + this.field_77287_j.field_73012_v.nextFloat() * 0.6F);
                  double var15 = this.field_77284_b;
                  double var17 = this.field_77285_c;
                  double var19 = this.field_77282_d;

                  for(float var21 = 0.3F; var14 > 0.0F; var14 -= 0.22500001F) {
                     BlockPos var22 = new BlockPos(var15, var17, var19);
                     IBlockState var23 = this.field_77287_j.func_180495_p(var22);
                     if(var23.func_177230_c().func_149688_o() != Material.field_151579_a) {
                        float var24 = this.field_77283_e != null?this.field_77283_e.func_180428_a(this, this.field_77287_j, var22, var23):var23.func_177230_c().func_149638_a((Entity)null);
                        var14 -= (var24 + 0.3F) * 0.3F;
                     }

                     if(var14 > 0.0F && (this.field_77283_e == null || this.field_77283_e.func_174816_a(this, this.field_77287_j, var22, var23, var14))) {
                        var1.add(var22);
                     }

                     var15 += var6 * 0.30000001192092896D;
                     var17 += var8 * 0.30000001192092896D;
                     var19 += var10 * 0.30000001192092896D;
                  }
               }
            }
         }
      }

      this.field_77281_g.addAll(var1);
      float var30 = this.field_77280_f * 2.0F;
      var4 = MathHelper.func_76128_c(this.field_77284_b - (double)var30 - 1.0D);
      var5 = MathHelper.func_76128_c(this.field_77284_b + (double)var30 + 1.0D);
      int var31 = MathHelper.func_76128_c(this.field_77285_c - (double)var30 - 1.0D);
      int var7 = MathHelper.func_76128_c(this.field_77285_c + (double)var30 + 1.0D);
      int var32 = MathHelper.func_76128_c(this.field_77282_d - (double)var30 - 1.0D);
      int var9 = MathHelper.func_76128_c(this.field_77282_d + (double)var30 + 1.0D);
      List var33 = this.field_77287_j.func_72839_b(this.field_77283_e, new AxisAlignedBB((double)var4, (double)var31, (double)var32, (double)var5, (double)var7, (double)var9));
      Vec3 var11 = new Vec3(this.field_77284_b, this.field_77285_c, this.field_77282_d);

      for(int var34 = 0; var34 < var33.size(); ++var34) {
         Entity var13 = (Entity)var33.get(var34);
         if(!var13.func_180427_aV()) {
            double var35 = var13.func_70011_f(this.field_77284_b, this.field_77285_c, this.field_77282_d) / (double)var30;
            if(var35 <= 1.0D) {
               double var16 = var13.field_70165_t - this.field_77284_b;
               double var18 = var13.field_70163_u + (double)var13.func_70047_e() - this.field_77285_c;
               double var20 = var13.field_70161_v - this.field_77282_d;
               double var36 = (double)MathHelper.func_76133_a(var16 * var16 + var18 * var18 + var20 * var20);
               if(var36 != 0.0D) {
                  var16 /= var36;
                  var18 /= var36;
                  var20 /= var36;
                  double var37 = (double)this.field_77287_j.func_72842_a(var11, var13.func_174813_aQ());
                  double var26 = (1.0D - var35) * var37;
                  var13.func_70097_a(DamageSource.func_94539_a(this), (float)((int)((var26 * var26 + var26) / 2.0D * 8.0D * (double)var30 + 1.0D)));
                  double var28 = EnchantmentProtection.func_92092_a(var13, var26);
                  var13.field_70159_w += var16 * var28;
                  var13.field_70181_x += var18 * var28;
                  var13.field_70179_y += var20 * var28;
                  if(var13 instanceof EntityPlayer) {
                     this.field_77288_k.put((EntityPlayer)var13, new Vec3(var16 * var26, var18 * var26, var20 * var26));
                  }
               }
            }
         }
      }

   }

   public void func_77279_a(boolean p_77279_1_) {
      this.field_77287_j.func_72908_a(this.field_77284_b, this.field_77285_c, this.field_77282_d, "random.explode", 4.0F, (1.0F + (this.field_77287_j.field_73012_v.nextFloat() - this.field_77287_j.field_73012_v.nextFloat()) * 0.2F) * 0.7F);
      if(this.field_77280_f >= 2.0F && this.field_82755_b) {
         this.field_77287_j.func_175688_a(EnumParticleTypes.EXPLOSION_HUGE, this.field_77284_b, this.field_77285_c, this.field_77282_d, 1.0D, 0.0D, 0.0D, new int[0]);
      } else {
         this.field_77287_j.func_175688_a(EnumParticleTypes.EXPLOSION_LARGE, this.field_77284_b, this.field_77285_c, this.field_77282_d, 1.0D, 0.0D, 0.0D, new int[0]);
      }

      Iterator var2;
      BlockPos var3;
      if(this.field_82755_b) {
         var2 = this.field_77281_g.iterator();

         while(var2.hasNext()) {
            var3 = (BlockPos)var2.next();
            Block var4 = this.field_77287_j.func_180495_p(var3).func_177230_c();
            if(p_77279_1_) {
               double var5 = (double)((float)var3.func_177958_n() + this.field_77287_j.field_73012_v.nextFloat());
               double var7 = (double)((float)var3.func_177956_o() + this.field_77287_j.field_73012_v.nextFloat());
               double var9 = (double)((float)var3.func_177952_p() + this.field_77287_j.field_73012_v.nextFloat());
               double var11 = var5 - this.field_77284_b;
               double var13 = var7 - this.field_77285_c;
               double var15 = var9 - this.field_77282_d;
               double var17 = (double)MathHelper.func_76133_a(var11 * var11 + var13 * var13 + var15 * var15);
               var11 /= var17;
               var13 /= var17;
               var15 /= var17;
               double var19 = 0.5D / (var17 / (double)this.field_77280_f + 0.1D);
               var19 *= (double)(this.field_77287_j.field_73012_v.nextFloat() * this.field_77287_j.field_73012_v.nextFloat() + 0.3F);
               var11 *= var19;
               var13 *= var19;
               var15 *= var19;
               this.field_77287_j.func_175688_a(EnumParticleTypes.EXPLOSION_NORMAL, (var5 + this.field_77284_b * 1.0D) / 2.0D, (var7 + this.field_77285_c * 1.0D) / 2.0D, (var9 + this.field_77282_d * 1.0D) / 2.0D, var11, var13, var15, new int[0]);
               this.field_77287_j.func_175688_a(EnumParticleTypes.SMOKE_NORMAL, var5, var7, var9, var11, var13, var15, new int[0]);
            }

            if(var4.func_149688_o() != Material.field_151579_a) {
               if(var4.func_149659_a(this)) {
                  var4.func_180653_a(this.field_77287_j, var3, this.field_77287_j.func_180495_p(var3), 1.0F / this.field_77280_f, 0);
               }

               this.field_77287_j.func_180501_a(var3, Blocks.field_150350_a.func_176223_P(), 3);
               var4.func_180652_a(this.field_77287_j, var3, this);
            }
         }
      }

      if(this.field_77286_a) {
         var2 = this.field_77281_g.iterator();

         while(var2.hasNext()) {
            var3 = (BlockPos)var2.next();
            if(this.field_77287_j.func_180495_p(var3).func_177230_c().func_149688_o() == Material.field_151579_a && this.field_77287_j.func_180495_p(var3.func_177977_b()).func_177230_c().func_149730_j() && this.field_77290_i.nextInt(3) == 0) {
               this.field_77287_j.func_175656_a(var3, Blocks.field_150480_ab.func_176223_P());
            }
         }
      }

   }

   public Map func_77277_b() {
      return this.field_77288_k;
   }

   public EntityLivingBase func_94613_c() {
      return this.field_77283_e == null?null:(this.field_77283_e instanceof EntityTNTPrimed?((EntityTNTPrimed)this.field_77283_e).func_94083_c():(this.field_77283_e instanceof EntityLivingBase?(EntityLivingBase)this.field_77283_e:null));
   }

   public void func_180342_d() {
      this.field_77281_g.clear();
   }

   public List func_180343_e() {
      return this.field_77281_g;
   }
}
