package net.minecraft.entity.passive;

import com.google.common.base.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCarrot;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIMoveToBlock;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityJumpHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityRabbit extends EntityAnimal {

   private EntityRabbit.AIAvoidEntity field_175539_bk;
   private int field_175540_bm = 0;
   private int field_175535_bn = 0;
   private boolean field_175536_bo = false;
   private boolean field_175537_bp = false;
   private int field_175538_bq = 0;
   private EntityRabbit.EnumMoveType field_175542_br;
   private int field_175541_bs;
   private EntityPlayer field_175543_bt;
   private static final String __OBFID = "CL_00002242";


   public EntityRabbit(World p_i45869_1_) {
      super(p_i45869_1_);
      this.field_175542_br = EntityRabbit.EnumMoveType.HOP;
      this.field_175541_bs = 0;
      this.field_175543_bt = null;
      this.func_70105_a(0.6F, 0.7F);
      this.field_70767_i = new EntityRabbit.RabbitJumpHelper(this);
      this.field_70765_h = new EntityRabbit.RabbitMoveHelper();
      ((PathNavigateGround)this.func_70661_as()).func_179690_a(true);
      this.field_70699_by.func_179678_a(2.5F);
      this.field_70714_bg.func_75776_a(1, new EntityAISwimming(this));
      this.field_70714_bg.func_75776_a(1, new EntityRabbit.AIPanic(1.33D));
      this.field_70714_bg.func_75776_a(2, new EntityAITempt(this, 1.0D, Items.field_151172_bF, false));
      this.field_70714_bg.func_75776_a(3, new EntityAIMate(this, 0.8D));
      this.field_70714_bg.func_75776_a(5, new EntityRabbit.AIRaidFarm());
      this.field_70714_bg.func_75776_a(5, new EntityAIWander(this, 0.6D));
      this.field_70714_bg.func_75776_a(11, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
      this.field_175539_bk = new EntityRabbit.AIAvoidEntity(new Predicate() {

         private static final String __OBFID = "CL_00002241";

         public boolean func_180086_a(Entity p_180086_1_) {
            return p_180086_1_ instanceof EntityWolf;
         }
         // $FF: synthetic method
         public boolean apply(Object p_apply_1_) {
            return this.func_180086_a((Entity)p_apply_1_);
         }
      }, 16.0F, 1.33D, 1.33D);
      this.field_70714_bg.func_75776_a(4, this.field_175539_bk);
      this.func_175515_b(0.0D);
   }

   protected float func_175134_bD() {
      return this.field_70765_h.func_75640_a() && this.field_70765_h.func_179919_e() > this.field_70163_u + 0.5D?0.5F:this.field_175542_br.func_180074_b();
   }

   public void func_175522_a(EntityRabbit.EnumMoveType p_175522_1_) {
      this.field_175542_br = p_175522_1_;
   }

   public float func_175521_o(float p_175521_1_) {
      return this.field_175535_bn == 0?0.0F:((float)this.field_175540_bm + p_175521_1_) / (float)this.field_175535_bn;
   }

   public void func_175515_b(double p_175515_1_) {
      this.func_70661_as().func_75489_a(p_175515_1_);
      this.field_70765_h.func_75642_a(this.field_70765_h.func_179917_d(), this.field_70765_h.func_179919_e(), this.field_70765_h.func_179918_f(), p_175515_1_);
   }

   public void func_175519_a(boolean p_175519_1_, EntityRabbit.EnumMoveType p_175519_2_) {
      super.func_70637_d(p_175519_1_);
      if(!p_175519_1_) {
         if(this.field_175542_br == EntityRabbit.EnumMoveType.ATTACK) {
            this.field_175542_br = EntityRabbit.EnumMoveType.HOP;
         }
      } else {
         this.func_175515_b(1.5D * (double)p_175519_2_.func_180072_a());
         this.func_85030_a(this.func_175516_ck(), this.func_70599_aP(), ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F) * 0.8F);
      }

      this.field_175536_bo = p_175519_1_;
   }

   public void func_175524_b(EntityRabbit.EnumMoveType p_175524_1_) {
      this.func_175519_a(true, p_175524_1_);
      this.field_175535_bn = p_175524_1_.func_180073_d();
      this.field_175540_bm = 0;
   }

   public boolean func_175523_cj() {
      return this.field_175536_bo;
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(18, Byte.valueOf((byte)0));
   }

   public void func_70619_bc() {
      if(this.field_70765_h.func_75638_b() > 0.8D) {
         this.func_175522_a(EntityRabbit.EnumMoveType.SPRINT);
      } else if(this.field_175542_br != EntityRabbit.EnumMoveType.ATTACK) {
         this.func_175522_a(EntityRabbit.EnumMoveType.HOP);
      }

      if(this.field_175538_bq > 0) {
         --this.field_175538_bq;
      }

      if(this.field_175541_bs > 0) {
         this.field_175541_bs -= this.field_70146_Z.nextInt(3);
         if(this.field_175541_bs < 0) {
            this.field_175541_bs = 0;
         }
      }

      if(this.field_70122_E) {
         if(!this.field_175537_bp) {
            this.func_175519_a(false, EntityRabbit.EnumMoveType.NONE);
            this.func_175517_cu();
         }

         if(this.func_175531_cl() == 99 && this.field_175538_bq == 0) {
            EntityLivingBase var1 = this.func_70638_az();
            if(var1 != null && this.func_70068_e(var1) < 16.0D) {
               this.func_175533_a(var1.field_70165_t, var1.field_70161_v);
               this.field_70765_h.func_75642_a(var1.field_70165_t, var1.field_70163_u, var1.field_70161_v, this.field_70765_h.func_75638_b());
               this.func_175524_b(EntityRabbit.EnumMoveType.ATTACK);
               this.field_175537_bp = true;
            }
         }

         EntityRabbit.RabbitJumpHelper var4 = (EntityRabbit.RabbitJumpHelper)this.field_70767_i;
         if(!var4.func_180067_c()) {
            if(this.field_70765_h.func_75640_a() && this.field_175538_bq == 0) {
               PathEntity var2 = this.field_70699_by.func_75505_d();
               Vec3 var3 = new Vec3(this.field_70765_h.func_179917_d(), this.field_70765_h.func_179919_e(), this.field_70765_h.func_179918_f());
               if(var2 != null && var2.func_75873_e() < var2.func_75874_d()) {
                  var3 = var2.func_75878_a(this);
               }

               this.func_175533_a(var3.field_72450_a, var3.field_72449_c);
               this.func_175524_b(this.field_175542_br);
            }
         } else if(!var4.func_180065_d()) {
            this.func_175518_cr();
         }
      }

      this.field_175537_bp = this.field_70122_E;
   }

   public void func_174830_Y() {}

   private void func_175533_a(double p_175533_1_, double p_175533_3_) {
      this.field_70177_z = (float)(Math.atan2(p_175533_3_ - this.field_70161_v, p_175533_1_ - this.field_70165_t) * 180.0D / 3.1415927410125732D) - 90.0F;
   }

   private void func_175518_cr() {
      ((EntityRabbit.RabbitJumpHelper)this.field_70767_i).func_180066_a(true);
   }

   private void func_175520_cs() {
      ((EntityRabbit.RabbitJumpHelper)this.field_70767_i).func_180066_a(false);
   }

   private void func_175530_ct() {
      this.field_175538_bq = this.func_175532_cm();
   }

   private void func_175517_cu() {
      this.func_175530_ct();
      this.func_175520_cs();
   }

   public void func_70636_d() {
      super.func_70636_d();
      if(this.field_175540_bm != this.field_175535_bn) {
         if(this.field_175540_bm == 0 && !this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_72960_a(this, (byte)1);
         }

         ++this.field_175540_bm;
      } else if(this.field_175535_bn != 0) {
         this.field_175540_bm = 0;
         this.field_175535_bn = 0;
      }

   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.30000001192092896D);
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74768_a("RabbitType", this.func_175531_cl());
      p_70014_1_.func_74768_a("MoreCarrotTicks", this.field_175541_bs);
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      this.func_175529_r(p_70037_1_.func_74762_e("RabbitType"));
      this.field_175541_bs = p_70037_1_.func_74762_e("MoreCarrotTicks");
   }

   protected String func_175516_ck() {
      return "mob.rabbit.hop";
   }

   protected String func_70639_aQ() {
      return "mob.rabbit.idle";
   }

   protected String func_70621_aR() {
      return "mob.rabbit.hurt";
   }

   protected String func_70673_aS() {
      return "mob.rabbit.death";
   }

   public boolean func_70652_k(Entity p_70652_1_) {
      if(this.func_175531_cl() == 99) {
         this.func_85030_a("mob.attack", 1.0F, (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F + 1.0F);
         return p_70652_1_.func_70097_a(DamageSource.func_76358_a(this), 8.0F);
      } else {
         return p_70652_1_.func_70097_a(DamageSource.func_76358_a(this), 3.0F);
      }
   }

   public int func_70658_aO() {
      return this.func_175531_cl() == 99?8:super.func_70658_aO();
   }

   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
      return this.func_180431_b(p_70097_1_)?false:super.func_70097_a(p_70097_1_, p_70097_2_);
   }

   protected void func_82164_bB() {
      this.func_70099_a(new ItemStack(Items.field_179556_br, 1), 0.0F);
   }

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
      int var3 = this.field_70146_Z.nextInt(2) + this.field_70146_Z.nextInt(1 + p_70628_2_);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.func_145779_a(Items.field_179555_bs, 1);
      }

      var3 = this.field_70146_Z.nextInt(2);

      for(var4 = 0; var4 < var3; ++var4) {
         if(this.func_70027_ad()) {
            this.func_145779_a(Items.field_179559_bp, 1);
         } else {
            this.func_145779_a(Items.field_179558_bo, 1);
         }
      }

   }

   private boolean func_175525_a(Item p_175525_1_) {
      return p_175525_1_ == Items.field_151172_bF || p_175525_1_ == Items.field_151150_bK || p_175525_1_ == Item.func_150898_a(Blocks.field_150327_N);
   }

   public EntityRabbit func_175526_b(EntityAgeable p_175526_1_) {
      EntityRabbit var2 = new EntityRabbit(this.field_70170_p);
      if(p_175526_1_ instanceof EntityRabbit) {
         var2.func_175529_r(this.field_70146_Z.nextBoolean()?this.func_175531_cl():((EntityRabbit)p_175526_1_).func_175531_cl());
      }

      return var2;
   }

   public boolean func_70877_b(ItemStack p_70877_1_) {
      return p_70877_1_ != null && this.func_175525_a(p_70877_1_.func_77973_b());
   }

   public int func_175531_cl() {
      return this.field_70180_af.func_75683_a(18);
   }

   public void func_175529_r(int p_175529_1_) {
      if(p_175529_1_ == 99) {
         this.field_70714_bg.func_85156_a(this.field_175539_bk);
         this.field_70714_bg.func_75776_a(4, new EntityRabbit.AIEvilAttack());
         this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, false, new Class[0]));
         this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
         this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityWolf.class, true));
         if(!this.func_145818_k_()) {
            this.func_96094_a(StatCollector.func_74838_a("entity.KillerBunny.name"));
         }
      }

      this.field_70180_af.func_75692_b(18, Byte.valueOf((byte)p_175529_1_));
   }

   public IEntityLivingData func_180482_a(DifficultyInstance p_180482_1_, IEntityLivingData p_180482_2_) {
      Object p_180482_2_1 = super.func_180482_a(p_180482_1_, p_180482_2_);
      int var3 = this.field_70146_Z.nextInt(6);
      boolean var4 = false;
      if(p_180482_2_1 instanceof EntityRabbit.RabbitTypeData) {
         var3 = ((EntityRabbit.RabbitTypeData)p_180482_2_1).field_179427_a;
         var4 = true;
      } else {
         p_180482_2_1 = new EntityRabbit.RabbitTypeData(var3);
      }

      this.func_175529_r(var3);
      if(var4) {
         this.func_70873_a(-24000);
      }

      return (IEntityLivingData)p_180482_2_1;
   }

   private boolean func_175534_cv() {
      return this.field_175541_bs == 0;
   }

   protected int func_175532_cm() {
      return this.field_175542_br.func_180075_c();
   }

   protected void func_175528_cn() {
      this.field_70170_p.func_175688_a(EnumParticleTypes.BLOCK_DUST, this.field_70165_t + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, this.field_70163_u + 0.5D + (double)(this.field_70146_Z.nextFloat() * this.field_70131_O), this.field_70161_v + (double)(this.field_70146_Z.nextFloat() * this.field_70130_N * 2.0F) - (double)this.field_70130_N, 0.0D, 0.0D, 0.0D, new int[]{Block.func_176210_f(Blocks.field_150459_bM.func_176203_a(7))});
      this.field_175541_bs = 100;
   }

   public void func_70103_a(byte p_70103_1_) {
      if(p_70103_1_ == 1) {
         this.func_174808_Z();
         this.field_175535_bn = 10;
         this.field_175540_bm = 0;
      } else {
         super.func_70103_a(p_70103_1_);
      }

   }

   // $FF: synthetic method
   public EntityAgeable func_90011_a(EntityAgeable p_90011_1_) {
      return this.func_175526_b(p_90011_1_);
   }

   class AIAvoidEntity extends EntityAIAvoidEntity {

      private EntityRabbit field_179511_d = EntityRabbit.this;
      private static final String __OBFID = "CL_00002238";


      public AIAvoidEntity(Predicate p_i45865_2_, float p_i45865_3_, double p_i45865_4_, double p_i45865_6_) {
         super(EntityRabbit.this, p_i45865_2_, p_i45865_3_, p_i45865_4_, p_i45865_6_);
      }

      public void func_75246_d() {
         super.func_75246_d();
      }
   }

   class AIEvilAttack extends EntityAIAttackOnCollide {

      private static final String __OBFID = "CL_00002240";


      public AIEvilAttack() {
         super(EntityRabbit.this, EntityLivingBase.class, 1.4D, true);
      }

      protected double func_179512_a(EntityLivingBase p_179512_1_) {
         return (double)(4.0F + p_179512_1_.field_70130_N);
      }
   }

   class AIPanic extends EntityAIPanic {

      private EntityRabbit field_179486_b = EntityRabbit.this;
      private static final String __OBFID = "CL_00002234";


      public AIPanic(double p_i45861_2_) {
         super(EntityRabbit.this, p_i45861_2_);
      }

      public void func_75246_d() {
         super.func_75246_d();
         this.field_179486_b.func_175515_b(this.field_75265_b);
      }
   }

   class AIRaidFarm extends EntityAIMoveToBlock {

      private boolean field_179498_d;
      private boolean field_179499_e = false;
      private static final String __OBFID = "CL_00002233";


      public AIRaidFarm() {
         super(EntityRabbit.this, 0.699999988079071D, 16);
      }

      public boolean func_75250_a() {
         if(this.field_179496_a <= 0) {
            if(!EntityRabbit.this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
               return false;
            }

            this.field_179499_e = false;
            this.field_179498_d = EntityRabbit.this.func_175534_cv();
         }

         return super.func_75250_a();
      }

      public boolean func_75253_b() {
         return this.field_179499_e && super.func_75253_b();
      }

      public void func_75249_e() {
         super.func_75249_e();
      }

      public void func_75251_c() {
         super.func_75251_c();
      }

      public void func_75246_d() {
         super.func_75246_d();
         EntityRabbit.this.func_70671_ap().func_75650_a((double)this.field_179494_b.func_177958_n() + 0.5D, (double)(this.field_179494_b.func_177956_o() + 1), (double)this.field_179494_b.func_177952_p() + 0.5D, 10.0F, (float)EntityRabbit.this.func_70646_bf());
         if(this.func_179487_f()) {
            World var1 = EntityRabbit.this.field_70170_p;
            BlockPos var2 = this.field_179494_b.func_177984_a();
            IBlockState var3 = var1.func_180495_p(var2);
            Block var4 = var3.func_177230_c();
            if(this.field_179499_e && var4 instanceof BlockCarrot && ((Integer)var3.func_177229_b(BlockCarrot.field_176488_a)).intValue() == 7) {
               var1.func_180501_a(var2, Blocks.field_150350_a.func_176223_P(), 2);
               var1.func_175655_b(var2, true);
               EntityRabbit.this.func_175528_cn();
            }

            this.field_179499_e = false;
            this.field_179496_a = 10;
         }

      }

      protected boolean func_179488_a(World p_179488_1_, BlockPos p_179488_2_) {
         Block var3 = p_179488_1_.func_180495_p(p_179488_2_).func_177230_c();
         if(var3 == Blocks.field_150458_ak) {
            p_179488_2_ = p_179488_2_.func_177984_a();
            IBlockState var4 = p_179488_1_.func_180495_p(p_179488_2_);
            var3 = var4.func_177230_c();
            if(var3 instanceof BlockCarrot && ((Integer)var4.func_177229_b(BlockCarrot.field_176488_a)).intValue() == 7 && this.field_179498_d && !this.field_179499_e) {
               this.field_179499_e = true;
               return true;
            }
         }

         return false;
      }
   }

   static enum EnumMoveType {

      NONE("NONE", 0, 0.0F, 0.0F, 30, 1),
      HOP("HOP", 1, 0.8F, 0.2F, 20, 10),
      STEP("STEP", 2, 1.0F, 0.45F, 14, 14),
      SPRINT("SPRINT", 3, 1.75F, 0.4F, 1, 8),
      ATTACK("ATTACK", 4, 2.0F, 0.7F, 7, 8);
      private final float field_180076_f;
      private final float field_180077_g;
      private final int field_180084_h;
      private final int field_180085_i;
      // $FF: synthetic field
      private static final EntityRabbit.EnumMoveType[] $VALUES = new EntityRabbit.EnumMoveType[]{NONE, HOP, STEP, SPRINT, ATTACK};
      private static final String __OBFID = "CL_00002239";


      private EnumMoveType(String p_i45866_1_, int p_i45866_2_, float p_i45866_3_, float p_i45866_4_, int p_i45866_5_, int p_i45866_6_) {
         this.field_180076_f = p_i45866_3_;
         this.field_180077_g = p_i45866_4_;
         this.field_180084_h = p_i45866_5_;
         this.field_180085_i = p_i45866_6_;
      }

      public float func_180072_a() {
         return this.field_180076_f;
      }

      public float func_180074_b() {
         return this.field_180077_g;
      }

      public int func_180075_c() {
         return this.field_180084_h;
      }

      public int func_180073_d() {
         return this.field_180085_i;
      }

   }

   public class RabbitJumpHelper extends EntityJumpHelper {

      private EntityRabbit field_180070_c;
      private boolean field_180068_d = false;
      private static final String __OBFID = "CL_00002236";


      public RabbitJumpHelper(EntityRabbit p_i45863_2_) {
         super(p_i45863_2_);
         this.field_180070_c = p_i45863_2_;
      }

      public boolean func_180067_c() {
         return this.field_75662_b;
      }

      public boolean func_180065_d() {
         return this.field_180068_d;
      }

      public void func_180066_a(boolean p_180066_1_) {
         this.field_180068_d = p_180066_1_;
      }

      public void func_75661_b() {
         if(this.field_75662_b) {
            this.field_180070_c.func_175524_b(EntityRabbit.EnumMoveType.STEP);
            this.field_75662_b = false;
         }

      }
   }

   class RabbitMoveHelper extends EntityMoveHelper {

      private EntityRabbit field_179929_g = EntityRabbit.this;
      private static final String __OBFID = "CL_00002235";


      public RabbitMoveHelper() {
         super(EntityRabbit.this);
      }

      public void func_75641_c() {
         if(this.field_179929_g.field_70122_E && !this.field_179929_g.func_175523_cj()) {
            this.field_179929_g.func_175515_b(0.0D);
         }

         super.func_75641_c();
      }
   }

   public static class RabbitTypeData implements IEntityLivingData {

      public int field_179427_a;
      private static final String __OBFID = "CL_00002237";


      public RabbitTypeData(int p_i45864_1_) {
         this.field_179427_a = p_i45864_1_;
      }
   }
}
