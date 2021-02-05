package net.minecraft.entity.monster;

import com.google.common.base.Predicate;
import java.util.Calendar;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderHell;

public class EntitySkeleton extends EntityMob implements IRangedAttackMob {

   private EntityAIArrowAttack field_85037_d = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F);
   private EntityAIAttackOnCollide field_85038_e = new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, false);
   private static final String __OBFID = "CL_00001697";


   public EntitySkeleton(World p_i1741_1_) {
      super(p_i1741_1_);
      this.field_70714_bg.func_75776_a(1, new EntityAISwimming(this));
      this.field_70714_bg.func_75776_a(2, new EntityAIRestrictSun(this));
      this.field_70714_bg.func_75776_a(2, this.field_175455_a);
      this.field_70714_bg.func_75776_a(3, new EntityAIFleeSun(this, 1.0D));
      this.field_70714_bg.func_75776_a(3, new EntityAIAvoidEntity(this, new Predicate() {

         private static final String __OBFID = "CL_00002203";

         public boolean func_179945_a(Entity p_179945_1_) {
            return p_179945_1_ instanceof EntityWolf;
         }
         // $FF: synthetic method
         public boolean apply(Object p_apply_1_) {
            return this.func_179945_a((Entity)p_apply_1_);
         }
      }, 6.0F, 1.0D, 1.2D));
      this.field_70714_bg.func_75776_a(4, new EntityAIWander(this, 1.0D));
      this.field_70714_bg.func_75776_a(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.field_70714_bg.func_75776_a(6, new EntityAILookIdle(this));
      this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, false, new Class[0]));
      this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
      this.field_70715_bh.func_75776_a(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
      if(p_i1741_1_ != null && !p_i1741_1_.field_72995_K) {
         this.func_85036_m();
      }

   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25D);
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(13, new Byte((byte)0));
   }

   protected String func_70639_aQ() {
      return "mob.skeleton.say";
   }

   protected String func_70621_aR() {
      return "mob.skeleton.hurt";
   }

   protected String func_70673_aS() {
      return "mob.skeleton.death";
   }

   protected void func_180429_a(BlockPos p_180429_1_, Block p_180429_2_) {
      this.func_85030_a("mob.skeleton.step", 0.15F, 1.0F);
   }

   public boolean func_70652_k(Entity p_70652_1_) {
      if(super.func_70652_k(p_70652_1_)) {
         if(this.func_82202_m() == 1 && p_70652_1_ instanceof EntityLivingBase) {
            ((EntityLivingBase)p_70652_1_).func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 200));
         }

         return true;
      } else {
         return false;
      }
   }

   public EnumCreatureAttribute func_70668_bt() {
      return EnumCreatureAttribute.UNDEAD;
   }

   public void func_70636_d() {
      if(this.field_70170_p.func_72935_r() && !this.field_70170_p.field_72995_K) {
         float var1 = this.func_70013_c(1.0F);
         BlockPos var2 = new BlockPos(this.field_70165_t, (double)Math.round(this.field_70163_u), this.field_70161_v);
         if(var1 > 0.5F && this.field_70146_Z.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F && this.field_70170_p.func_175678_i(var2)) {
            boolean var3 = true;
            ItemStack var4 = this.func_71124_b(4);
            if(var4 != null) {
               if(var4.func_77984_f()) {
                  var4.func_77964_b(var4.func_77952_i() + this.field_70146_Z.nextInt(2));
                  if(var4.func_77952_i() >= var4.func_77958_k()) {
                     this.func_70669_a(var4);
                     this.func_70062_b(4, (ItemStack)null);
                  }
               }

               var3 = false;
            }

            if(var3) {
               this.func_70015_d(8);
            }
         }
      }

      if(this.field_70170_p.field_72995_K && this.func_82202_m() == 1) {
         this.func_70105_a(0.72F, 2.535F);
      }

      super.func_70636_d();
   }

   public void func_70098_U() {
      super.func_70098_U();
      if(this.field_70154_o instanceof EntityCreature) {
         EntityCreature var1 = (EntityCreature)this.field_70154_o;
         this.field_70761_aq = var1.field_70761_aq;
      }

   }

   public void func_70645_a(DamageSource p_70645_1_) {
      super.func_70645_a(p_70645_1_);
      if(p_70645_1_.func_76364_f() instanceof EntityArrow && p_70645_1_.func_76346_g() instanceof EntityPlayer) {
         EntityPlayer var2 = (EntityPlayer)p_70645_1_.func_76346_g();
         double var3 = var2.field_70165_t - this.field_70165_t;
         double var5 = var2.field_70161_v - this.field_70161_v;
         if(var3 * var3 + var5 * var5 >= 2500.0D) {
            var2.func_71029_a(AchievementList.field_76020_v);
         }
      } else if(p_70645_1_.func_76346_g() instanceof EntityCreeper && ((EntityCreeper)p_70645_1_.func_76346_g()).func_70830_n() && ((EntityCreeper)p_70645_1_.func_76346_g()).func_70650_aV()) {
         ((EntityCreeper)p_70645_1_.func_76346_g()).func_175493_co();
         this.func_70099_a(new ItemStack(Items.field_151144_bL, 1, this.func_82202_m() == 1?1:0), 0.0F);
      }

   }

   protected Item func_146068_u() {
      return Items.field_151032_g;
   }

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
      int var3;
      int var4;
      if(this.func_82202_m() == 1) {
         var3 = this.field_70146_Z.nextInt(3 + p_70628_2_) - 1;

         for(var4 = 0; var4 < var3; ++var4) {
            this.func_145779_a(Items.field_151044_h, 1);
         }
      } else {
         var3 = this.field_70146_Z.nextInt(3 + p_70628_2_);

         for(var4 = 0; var4 < var3; ++var4) {
            this.func_145779_a(Items.field_151032_g, 1);
         }
      }

      var3 = this.field_70146_Z.nextInt(3 + p_70628_2_);

      for(var4 = 0; var4 < var3; ++var4) {
         this.func_145779_a(Items.field_151103_aS, 1);
      }

   }

   protected void func_82164_bB() {
      if(this.func_82202_m() == 1) {
         this.func_70099_a(new ItemStack(Items.field_151144_bL, 1, 1), 0.0F);
      }

   }

   protected void func_180481_a(DifficultyInstance p_180481_1_) {
      super.func_180481_a(p_180481_1_);
      this.func_70062_b(0, new ItemStack(Items.field_151031_f));
   }

   public IEntityLivingData func_180482_a(DifficultyInstance p_180482_1_, IEntityLivingData p_180482_2_) {
      p_180482_2_ = super.func_180482_a(p_180482_1_, p_180482_2_);
      if(this.field_70170_p.field_73011_w instanceof WorldProviderHell && this.func_70681_au().nextInt(5) > 0) {
         this.field_70714_bg.func_75776_a(4, this.field_85038_e);
         this.func_82201_a(1);
         this.func_70062_b(0, new ItemStack(Items.field_151052_q));
         this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(4.0D);
      } else {
         this.field_70714_bg.func_75776_a(4, this.field_85037_d);
         this.func_180481_a(p_180482_1_);
         this.func_180483_b(p_180482_1_);
      }

      this.func_98053_h(this.field_70146_Z.nextFloat() < 0.55F * p_180482_1_.func_180170_c());
      if(this.func_71124_b(4) == null) {
         Calendar var3 = this.field_70170_p.func_83015_S();
         if(var3.get(2) + 1 == 10 && var3.get(5) == 31 && this.field_70146_Z.nextFloat() < 0.25F) {
            this.func_70062_b(4, new ItemStack(this.field_70146_Z.nextFloat() < 0.1F?Blocks.field_150428_aP:Blocks.field_150423_aK));
            this.field_82174_bp[4] = 0.0F;
         }
      }

      return p_180482_2_;
   }

   public void func_85036_m() {
      this.field_70714_bg.func_85156_a(this.field_85038_e);
      this.field_70714_bg.func_85156_a(this.field_85037_d);
      ItemStack var1 = this.func_70694_bm();
      if(var1 != null && var1.func_77973_b() == Items.field_151031_f) {
         this.field_70714_bg.func_75776_a(4, this.field_85037_d);
      } else {
         this.field_70714_bg.func_75776_a(4, this.field_85038_e);
      }

   }

   public void func_82196_d(EntityLivingBase p_82196_1_, float p_82196_2_) {
      EntityArrow var3 = new EntityArrow(this.field_70170_p, this, p_82196_1_, 1.6F, (float)(14 - this.field_70170_p.func_175659_aa().func_151525_a() * 4));
      int var4 = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, this.func_70694_bm());
      int var5 = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, this.func_70694_bm());
      var3.func_70239_b((double)(p_82196_2_ * 2.0F) + this.field_70146_Z.nextGaussian() * 0.25D + (double)((float)this.field_70170_p.func_175659_aa().func_151525_a() * 0.11F));
      if(var4 > 0) {
         var3.func_70239_b(var3.func_70242_d() + (double)var4 * 0.5D + 0.5D);
      }

      if(var5 > 0) {
         var3.func_70240_a(var5);
      }

      if(EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, this.func_70694_bm()) > 0 || this.func_82202_m() == 1) {
         var3.func_70015_d(100);
      }

      this.func_85030_a("random.bow", 1.0F, 1.0F / (this.func_70681_au().nextFloat() * 0.4F + 0.8F));
      this.field_70170_p.func_72838_d(var3);
   }

   public int func_82202_m() {
      return this.field_70180_af.func_75683_a(13);
   }

   public void func_82201_a(int p_82201_1_) {
      this.field_70180_af.func_75692_b(13, Byte.valueOf((byte)p_82201_1_));
      this.field_70178_ae = p_82201_1_ == 1;
      if(p_82201_1_ == 1) {
         this.func_70105_a(0.72F, 2.535F);
      } else {
         this.func_70105_a(0.6F, 1.95F);
      }

   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      if(p_70037_1_.func_150297_b("SkeletonType", 99)) {
         byte var2 = p_70037_1_.func_74771_c("SkeletonType");
         this.func_82201_a(var2);
      }

      this.func_85036_m();
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74774_a("SkeletonType", (byte)this.func_82202_m());
   }

   public void func_70062_b(int p_70062_1_, ItemStack p_70062_2_) {
      super.func_70062_b(p_70062_1_, p_70062_2_);
      if(!this.field_70170_p.field_72995_K && p_70062_1_ == 0) {
         this.func_85036_m();
      }

   }

   public float func_70047_e() {
      return this.func_82202_m() == 1?super.func_70047_e():1.74F;
   }

   public double func_70033_W() {
      return super.func_70033_W() - 0.5D;
   }
}
