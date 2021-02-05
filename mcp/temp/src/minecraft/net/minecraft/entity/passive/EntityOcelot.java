package net.minecraft.entity.passive;

import com.google.common.base.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOcelotAttack;
import net.minecraft.entity.ai.EntityAIOcelotSit;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityOcelot extends EntityTameable {

   private EntityAIAvoidEntity field_175545_bm;
   private EntityAITempt field_70914_e;
   private static final String __OBFID = "CL_00001646";


   public EntityOcelot(World p_i1688_1_) {
      super(p_i1688_1_);
      this.func_70105_a(0.6F, 0.7F);
      ((PathNavigateGround)this.func_70661_as()).func_179690_a(true);
      this.field_70714_bg.func_75776_a(1, new EntityAISwimming(this));
      this.field_70714_bg.func_75776_a(2, this.field_70911_d);
      this.field_70714_bg.func_75776_a(3, this.field_70914_e = new EntityAITempt(this, 0.6D, Items.field_151115_aP, true));
      this.field_70714_bg.func_75776_a(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 5.0F));
      this.field_70714_bg.func_75776_a(6, new EntityAIOcelotSit(this, 0.8D));
      this.field_70714_bg.func_75776_a(7, new EntityAILeapAtTarget(this, 0.3F));
      this.field_70714_bg.func_75776_a(8, new EntityAIOcelotAttack(this));
      this.field_70714_bg.func_75776_a(9, new EntityAIMate(this, 0.8D));
      this.field_70714_bg.func_75776_a(10, new EntityAIWander(this, 0.8D));
      this.field_70714_bg.func_75776_a(11, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
      this.field_70715_bh.func_75776_a(1, new EntityAITargetNonTamed(this, EntityChicken.class, false, (Predicate)null));
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(18, Byte.valueOf((byte)0));
   }

   public void func_70619_bc() {
      if(this.func_70605_aq().func_75640_a()) {
         double var1 = this.func_70605_aq().func_75638_b();
         if(var1 == 0.6D) {
            this.func_70095_a(true);
            this.func_70031_b(false);
         } else if(var1 == 1.33D) {
            this.func_70095_a(false);
            this.func_70031_b(true);
         } else {
            this.func_70095_a(false);
            this.func_70031_b(false);
         }
      } else {
         this.func_70095_a(false);
         this.func_70031_b(false);
      }

   }

   protected boolean func_70692_ba() {
      return !this.func_70909_n() && this.field_70173_aa > 2400;
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.30000001192092896D);
   }

   public void func_180430_e(float p_180430_1_, float p_180430_2_) {}

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74768_a("CatType", this.func_70913_u());
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      this.func_70912_b(p_70037_1_.func_74762_e("CatType"));
   }

   protected String func_70639_aQ() {
      return this.func_70909_n()?(this.func_70880_s()?"mob.cat.purr":(this.field_70146_Z.nextInt(4) == 0?"mob.cat.purreow":"mob.cat.meow")):"";
   }

   protected String func_70621_aR() {
      return "mob.cat.hitt";
   }

   protected String func_70673_aS() {
      return "mob.cat.hitt";
   }

   protected float func_70599_aP() {
      return 0.4F;
   }

   protected Item func_146068_u() {
      return Items.field_151116_aA;
   }

   public boolean func_70652_k(Entity p_70652_1_) {
      return p_70652_1_.func_70097_a(DamageSource.func_76358_a(this), 3.0F);
   }

   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
      if(this.func_180431_b(p_70097_1_)) {
         return false;
      } else {
         this.field_70911_d.func_75270_a(false);
         return super.func_70097_a(p_70097_1_, p_70097_2_);
      }
   }

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {}

   public boolean func_70085_c(EntityPlayer p_70085_1_) {
      ItemStack var2 = p_70085_1_.field_71071_by.func_70448_g();
      if(this.func_70909_n()) {
         if(this.func_152114_e(p_70085_1_) && !this.field_70170_p.field_72995_K && !this.func_70877_b(var2)) {
            this.field_70911_d.func_75270_a(!this.func_70906_o());
         }
      } else if(this.field_70914_e.func_75277_f() && var2 != null && var2.func_77973_b() == Items.field_151115_aP && p_70085_1_.func_70068_e(this) < 9.0D) {
         if(!p_70085_1_.field_71075_bZ.field_75098_d) {
            --var2.field_77994_a;
         }

         if(var2.field_77994_a <= 0) {
            p_70085_1_.field_71071_by.func_70299_a(p_70085_1_.field_71071_by.field_70461_c, (ItemStack)null);
         }

         if(!this.field_70170_p.field_72995_K) {
            if(this.field_70146_Z.nextInt(3) == 0) {
               this.func_70903_f(true);
               this.func_70912_b(1 + this.field_70170_p.field_73012_v.nextInt(3));
               this.func_152115_b(p_70085_1_.func_110124_au().toString());
               this.func_70908_e(true);
               this.field_70911_d.func_75270_a(true);
               this.field_70170_p.func_72960_a(this, (byte)7);
            } else {
               this.func_70908_e(false);
               this.field_70170_p.func_72960_a(this, (byte)6);
            }
         }

         return true;
      }

      return super.func_70085_c(p_70085_1_);
   }

   public EntityOcelot func_180493_b(EntityAgeable p_180493_1_) {
      EntityOcelot var2 = new EntityOcelot(this.field_70170_p);
      if(this.func_70909_n()) {
         var2.func_152115_b(this.func_152113_b());
         var2.func_70903_f(true);
         var2.func_70912_b(this.func_70913_u());
      }

      return var2;
   }

   public boolean func_70877_b(ItemStack p_70877_1_) {
      return p_70877_1_ != null && p_70877_1_.func_77973_b() == Items.field_151115_aP;
   }

   public boolean func_70878_b(EntityAnimal p_70878_1_) {
      if(p_70878_1_ == this) {
         return false;
      } else if(!this.func_70909_n()) {
         return false;
      } else if(!(p_70878_1_ instanceof EntityOcelot)) {
         return false;
      } else {
         EntityOcelot var2 = (EntityOcelot)p_70878_1_;
         return !var2.func_70909_n()?false:this.func_70880_s() && var2.func_70880_s();
      }
   }

   public int func_70913_u() {
      return this.field_70180_af.func_75683_a(18);
   }

   public void func_70912_b(int p_70912_1_) {
      this.field_70180_af.func_75692_b(18, Byte.valueOf((byte)p_70912_1_));
   }

   public boolean func_70601_bi() {
      return this.field_70170_p.field_73012_v.nextInt(3) != 0;
   }

   public boolean func_70058_J() {
      if(this.field_70170_p.func_72917_a(this.func_174813_aQ(), this) && this.field_70170_p.func_72945_a(this, this.func_174813_aQ()).isEmpty() && !this.field_70170_p.func_72953_d(this.func_174813_aQ())) {
         BlockPos var1 = new BlockPos(this.field_70165_t, this.func_174813_aQ().field_72338_b, this.field_70161_v);
         if(var1.func_177956_o() < 63) {
            return false;
         }

         Block var2 = this.field_70170_p.func_180495_p(var1.func_177977_b()).func_177230_c();
         if(var2 == Blocks.field_150349_c || var2.func_149688_o() == Material.field_151584_j) {
            return true;
         }
      }

      return false;
   }

   public String func_70005_c_() {
      return this.func_145818_k_()?this.func_95999_t():(this.func_70909_n()?StatCollector.func_74838_a("entity.Cat.name"):super.func_70005_c_());
   }

   public void func_70903_f(boolean p_70903_1_) {
      super.func_70903_f(p_70903_1_);
   }

   protected void func_175544_ck() {
      if(this.field_175545_bm == null) {
         this.field_175545_bm = new EntityAIAvoidEntity(this, new Predicate() {

            private static final String __OBFID = "CL_00002243";

            public boolean func_179874_a(Entity p_179874_1_) {
               return p_179874_1_ instanceof EntityPlayer;
            }
            // $FF: synthetic method
            public boolean apply(Object p_apply_1_) {
               return this.func_179874_a((Entity)p_apply_1_);
            }
         }, 16.0F, 0.8D, 1.33D);
      }

      this.field_70714_bg.func_85156_a(this.field_175545_bm);
      if(!this.func_70909_n()) {
         this.field_70714_bg.func_75776_a(4, this.field_175545_bm);
      }

   }

   public IEntityLivingData func_180482_a(DifficultyInstance p_180482_1_, IEntityLivingData p_180482_2_) {
      p_180482_2_ = super.func_180482_a(p_180482_1_, p_180482_2_);
      if(this.field_70170_p.field_73012_v.nextInt(7) == 0) {
         for(int var3 = 0; var3 < 2; ++var3) {
            EntityOcelot var4 = new EntityOcelot(this.field_70170_p);
            var4.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
            var4.func_70873_a(-24000);
            this.field_70170_p.func_72838_d(var4);
         }
      }

      return p_180482_2_;
   }

   // $FF: synthetic method
   public EntityAgeable func_90011_a(EntityAgeable p_90011_1_) {
      return this.func_180493_b(p_90011_1_);
   }
}
