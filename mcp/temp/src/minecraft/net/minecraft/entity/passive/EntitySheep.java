package net.minecraft.entity.passive;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntitySheep extends EntityAnimal {

   private final InventoryCrafting field_90016_e = new InventoryCrafting(new Container() {

      private static final String __OBFID = "CL_00001649";

      public boolean func_75145_c(EntityPlayer p_75145_1_) {
         return false;
      }
   }, 2, 1);
   private static final Map field_175514_bm = Maps.newEnumMap(EnumDyeColor.class);
   private int field_70899_e;
   private EntityAIEatGrass field_146087_bs = new EntityAIEatGrass(this);
   private static final String __OBFID = "CL_00001648";


   public static float[] func_175513_a(EnumDyeColor p_175513_0_) {
      return (float[])field_175514_bm.get(p_175513_0_);
   }

   public EntitySheep(World p_i1691_1_) {
      super(p_i1691_1_);
      this.func_70105_a(0.9F, 1.3F);
      ((PathNavigateGround)this.func_70661_as()).func_179690_a(true);
      this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
      this.field_70714_bg.func_75776_a(1, new EntityAIPanic(this, 1.25D));
      this.field_70714_bg.func_75776_a(2, new EntityAIMate(this, 1.0D));
      this.field_70714_bg.func_75776_a(3, new EntityAITempt(this, 1.1D, Items.field_151015_O, false));
      this.field_70714_bg.func_75776_a(4, new EntityAIFollowParent(this, 1.1D));
      this.field_70714_bg.func_75776_a(5, this.field_146087_bs);
      this.field_70714_bg.func_75776_a(6, new EntityAIWander(this, 1.0D));
      this.field_70714_bg.func_75776_a(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_70714_bg.func_75776_a(8, new EntityAILookIdle(this));
      this.field_90016_e.func_70299_a(0, new ItemStack(Items.field_151100_aR, 1, 0));
      this.field_90016_e.func_70299_a(1, new ItemStack(Items.field_151100_aR, 1, 0));
   }

   protected void func_70619_bc() {
      this.field_70899_e = this.field_146087_bs.func_151499_f();
      super.func_70619_bc();
   }

   public void func_70636_d() {
      if(this.field_70170_p.field_72995_K) {
         this.field_70899_e = Math.max(0, this.field_70899_e - 1);
      }

      super.func_70636_d();
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(8.0D);
      this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513D);
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(16, new Byte((byte)0));
   }

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
      if(!this.func_70892_o()) {
         this.func_70099_a(new ItemStack(Item.func_150898_a(Blocks.field_150325_L), 1, this.func_175509_cj().func_176765_a()), 0.0F);
      }

      int var3 = this.field_70146_Z.nextInt(2) + 1 + this.field_70146_Z.nextInt(1 + p_70628_2_);

      for(int var4 = 0; var4 < var3; ++var4) {
         if(this.func_70027_ad()) {
            this.func_145779_a(Items.field_179557_bn, 1);
         } else {
            this.func_145779_a(Items.field_179561_bm, 1);
         }
      }

   }

   protected Item func_146068_u() {
      return Item.func_150898_a(Blocks.field_150325_L);
   }

   public void func_70103_a(byte p_70103_1_) {
      if(p_70103_1_ == 10) {
         this.field_70899_e = 40;
      } else {
         super.func_70103_a(p_70103_1_);
      }

   }

   public float func_70894_j(float p_70894_1_) {
      return this.field_70899_e <= 0?0.0F:(this.field_70899_e >= 4 && this.field_70899_e <= 36?1.0F:(this.field_70899_e < 4?((float)this.field_70899_e - p_70894_1_) / 4.0F:-((float)(this.field_70899_e - 40) - p_70894_1_) / 4.0F));
   }

   public float func_70890_k(float p_70890_1_) {
      if(this.field_70899_e > 4 && this.field_70899_e <= 36) {
         float var2 = ((float)(this.field_70899_e - 4) - p_70890_1_) / 32.0F;
         return 0.62831855F + 0.21991149F * MathHelper.func_76126_a(var2 * 28.7F);
      } else {
         return this.field_70899_e > 0?0.62831855F:this.field_70125_A / 57.295776F;
      }
   }

   public boolean func_70085_c(EntityPlayer p_70085_1_) {
      ItemStack var2 = p_70085_1_.field_71071_by.func_70448_g();
      if(var2 != null && var2.func_77973_b() == Items.field_151097_aZ && !this.func_70892_o() && !this.func_70631_g_()) {
         if(!this.field_70170_p.field_72995_K) {
            this.func_70893_e(true);
            int var3 = 1 + this.field_70146_Z.nextInt(3);

            for(int var4 = 0; var4 < var3; ++var4) {
               EntityItem var5 = this.func_70099_a(new ItemStack(Item.func_150898_a(Blocks.field_150325_L), 1, this.func_175509_cj().func_176765_a()), 1.0F);
               var5.field_70181_x += (double)(this.field_70146_Z.nextFloat() * 0.05F);
               var5.field_70159_w += (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.1F);
               var5.field_70179_y += (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.1F);
            }
         }

         var2.func_77972_a(1, p_70085_1_);
         this.func_85030_a("mob.sheep.shear", 1.0F, 1.0F);
      }

      return super.func_70085_c(p_70085_1_);
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74757_a("Sheared", this.func_70892_o());
      p_70014_1_.func_74774_a("Color", (byte)this.func_175509_cj().func_176765_a());
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      this.func_70893_e(p_70037_1_.func_74767_n("Sheared"));
      this.func_175512_b(EnumDyeColor.func_176764_b(p_70037_1_.func_74771_c("Color")));
   }

   protected String func_70639_aQ() {
      return "mob.sheep.say";
   }

   protected String func_70621_aR() {
      return "mob.sheep.say";
   }

   protected String func_70673_aS() {
      return "mob.sheep.say";
   }

   protected void func_180429_a(BlockPos p_180429_1_, Block p_180429_2_) {
      this.func_85030_a("mob.sheep.step", 0.15F, 1.0F);
   }

   public EnumDyeColor func_175509_cj() {
      return EnumDyeColor.func_176764_b(this.field_70180_af.func_75683_a(16) & 15);
   }

   public void func_175512_b(EnumDyeColor p_175512_1_) {
      byte var2 = this.field_70180_af.func_75683_a(16);
      this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(var2 & 240 | p_175512_1_.func_176765_a() & 15)));
   }

   public boolean func_70892_o() {
      return (this.field_70180_af.func_75683_a(16) & 16) != 0;
   }

   public void func_70893_e(boolean p_70893_1_) {
      byte var2 = this.field_70180_af.func_75683_a(16);
      if(p_70893_1_) {
         this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(var2 | 16)));
      } else {
         this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(var2 & -17)));
      }

   }

   public static EnumDyeColor func_175510_a(Random p_175510_0_) {
      int var1 = p_175510_0_.nextInt(100);
      return var1 < 5?EnumDyeColor.BLACK:(var1 < 10?EnumDyeColor.GRAY:(var1 < 15?EnumDyeColor.SILVER:(var1 < 18?EnumDyeColor.BROWN:(p_175510_0_.nextInt(500) == 0?EnumDyeColor.PINK:EnumDyeColor.WHITE))));
   }

   public EntitySheep func_180491_b(EntityAgeable p_180491_1_) {
      EntitySheep var2 = (EntitySheep)p_180491_1_;
      EntitySheep var3 = new EntitySheep(this.field_70170_p);
      var3.func_175512_b(this.func_175511_a(this, var2));
      return var3;
   }

   public void func_70615_aA() {
      this.func_70893_e(false);
      if(this.func_70631_g_()) {
         this.func_110195_a(60);
      }

   }

   public IEntityLivingData func_180482_a(DifficultyInstance p_180482_1_, IEntityLivingData p_180482_2_) {
      p_180482_2_ = super.func_180482_a(p_180482_1_, p_180482_2_);
      this.func_175512_b(func_175510_a(this.field_70170_p.field_73012_v));
      return p_180482_2_;
   }

   private EnumDyeColor func_175511_a(EntityAnimal p_175511_1_, EntityAnimal p_175511_2_) {
      int var3 = ((EntitySheep)p_175511_1_).func_175509_cj().func_176767_b();
      int var4 = ((EntitySheep)p_175511_2_).func_175509_cj().func_176767_b();
      this.field_90016_e.func_70301_a(0).func_77964_b(var3);
      this.field_90016_e.func_70301_a(1).func_77964_b(var4);
      ItemStack var5 = CraftingManager.func_77594_a().func_82787_a(this.field_90016_e, ((EntitySheep)p_175511_1_).field_70170_p);
      int var6;
      if(var5 != null && var5.func_77973_b() == Items.field_151100_aR) {
         var6 = var5.func_77960_j();
      } else {
         var6 = this.field_70170_p.field_73012_v.nextBoolean()?var3:var4;
      }

      return EnumDyeColor.func_176766_a(var6);
   }

   public float func_70047_e() {
      return 0.95F * this.field_70131_O;
   }

   // $FF: synthetic method
   public EntityAgeable func_90011_a(EntityAgeable p_90011_1_) {
      return this.func_180491_b(p_90011_1_);
   }

   static {
      field_175514_bm.put(EnumDyeColor.WHITE, new float[]{1.0F, 1.0F, 1.0F});
      field_175514_bm.put(EnumDyeColor.ORANGE, new float[]{0.85F, 0.5F, 0.2F});
      field_175514_bm.put(EnumDyeColor.MAGENTA, new float[]{0.7F, 0.3F, 0.85F});
      field_175514_bm.put(EnumDyeColor.LIGHT_BLUE, new float[]{0.4F, 0.6F, 0.85F});
      field_175514_bm.put(EnumDyeColor.YELLOW, new float[]{0.9F, 0.9F, 0.2F});
      field_175514_bm.put(EnumDyeColor.LIME, new float[]{0.5F, 0.8F, 0.1F});
      field_175514_bm.put(EnumDyeColor.PINK, new float[]{0.95F, 0.5F, 0.65F});
      field_175514_bm.put(EnumDyeColor.GRAY, new float[]{0.3F, 0.3F, 0.3F});
      field_175514_bm.put(EnumDyeColor.SILVER, new float[]{0.6F, 0.6F, 0.6F});
      field_175514_bm.put(EnumDyeColor.CYAN, new float[]{0.3F, 0.5F, 0.6F});
      field_175514_bm.put(EnumDyeColor.PURPLE, new float[]{0.5F, 0.25F, 0.7F});
      field_175514_bm.put(EnumDyeColor.BLUE, new float[]{0.2F, 0.3F, 0.7F});
      field_175514_bm.put(EnumDyeColor.BROWN, new float[]{0.4F, 0.3F, 0.2F});
      field_175514_bm.put(EnumDyeColor.GREEN, new float[]{0.4F, 0.5F, 0.2F});
      field_175514_bm.put(EnumDyeColor.RED, new float[]{0.6F, 0.2F, 0.2F});
      field_175514_bm.put(EnumDyeColor.BLACK, new float[]{0.1F, 0.1F, 0.1F});
   }
}
