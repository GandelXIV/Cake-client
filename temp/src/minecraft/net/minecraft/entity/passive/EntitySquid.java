package net.minecraft.entity.passive;

import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySquid extends EntityWaterMob {

   public float field_70861_d;
   public float field_70862_e;
   public float field_70859_f;
   public float field_70860_g;
   public float field_70867_h;
   public float field_70868_i;
   public float field_70866_j;
   public float field_70865_by;
   private float field_70863_bz;
   private float field_70864_bA;
   private float field_70871_bB;
   private float field_70872_bC;
   private float field_70869_bD;
   private float field_70870_bE;
   private static final String __OBFID = "CL_00001651";


   public EntitySquid(World p_i1693_1_) {
      super(p_i1693_1_);
      this.func_70105_a(0.95F, 0.95F);
      this.field_70146_Z.setSeed((long)(1 + this.func_145782_y()));
      this.field_70864_bA = 1.0F / (this.field_70146_Z.nextFloat() + 1.0F) * 0.2F;
      this.field_70714_bg.func_75776_a(0, new EntitySquid.AIMoveRandom());
   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0D);
   }

   public float func_70047_e() {
      return this.field_70131_O * 0.5F;
   }

   protected String func_70639_aQ() {
      return null;
   }

   protected String func_70621_aR() {
      return null;
   }

   protected String func_70673_aS() {
      return null;
   }

   protected float func_70599_aP() {
      return 0.4F;
   }

   protected Item func_146068_u() {
      return null;
   }

   protected boolean func_70041_e_() {
      return false;
   }

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
      int var3 = this.field_70146_Z.nextInt(3 + p_70628_2_) + 1;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.func_70099_a(new ItemStack(Items.field_151100_aR, 1, EnumDyeColor.BLACK.func_176767_b()), 0.0F);
      }

   }

   public boolean func_70090_H() {
      return this.field_70170_p.func_72918_a(this.func_174813_aQ().func_72314_b(0.0D, -0.6000000238418579D, 0.0D), Material.field_151586_h, this);
   }

   public void func_70636_d() {
      super.func_70636_d();
      this.field_70862_e = this.field_70861_d;
      this.field_70860_g = this.field_70859_f;
      this.field_70868_i = this.field_70867_h;
      this.field_70865_by = this.field_70866_j;
      this.field_70867_h += this.field_70864_bA;
      if((double)this.field_70867_h > 6.283185307179586D) {
         if(this.field_70170_p.field_72995_K) {
            this.field_70867_h = 6.2831855F;
         } else {
            this.field_70867_h = (float)((double)this.field_70867_h - 6.283185307179586D);
            if(this.field_70146_Z.nextInt(10) == 0) {
               this.field_70864_bA = 1.0F / (this.field_70146_Z.nextFloat() + 1.0F) * 0.2F;
            }

            this.field_70170_p.func_72960_a(this, (byte)19);
         }
      }

      if(this.field_70171_ac) {
         float var1;
         if(this.field_70867_h < 3.1415927F) {
            var1 = this.field_70867_h / 3.1415927F;
            this.field_70866_j = MathHelper.func_76126_a(var1 * var1 * 3.1415927F) * 3.1415927F * 0.25F;
            if((double)var1 > 0.75D) {
               this.field_70863_bz = 1.0F;
               this.field_70871_bB = 1.0F;
            } else {
               this.field_70871_bB *= 0.8F;
            }
         } else {
            this.field_70866_j = 0.0F;
            this.field_70863_bz *= 0.9F;
            this.field_70871_bB *= 0.99F;
         }

         if(!this.field_70170_p.field_72995_K) {
            this.field_70159_w = (double)(this.field_70872_bC * this.field_70863_bz);
            this.field_70181_x = (double)(this.field_70869_bD * this.field_70863_bz);
            this.field_70179_y = (double)(this.field_70870_bE * this.field_70863_bz);
         }

         var1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
         this.field_70761_aq += (-((float)Math.atan2(this.field_70159_w, this.field_70179_y)) * 180.0F / 3.1415927F - this.field_70761_aq) * 0.1F;
         this.field_70177_z = this.field_70761_aq;
         this.field_70859_f = (float)((double)this.field_70859_f + 3.141592653589793D * (double)this.field_70871_bB * 1.5D);
         this.field_70861_d += (-((float)Math.atan2((double)var1, this.field_70181_x)) * 180.0F / 3.1415927F - this.field_70861_d) * 0.1F;
      } else {
         this.field_70866_j = MathHelper.func_76135_e(MathHelper.func_76126_a(this.field_70867_h)) * 3.1415927F * 0.25F;
         if(!this.field_70170_p.field_72995_K) {
            this.field_70159_w = 0.0D;
            this.field_70181_x -= 0.08D;
            this.field_70181_x *= 0.9800000190734863D;
            this.field_70179_y = 0.0D;
         }

         this.field_70861_d = (float)((double)this.field_70861_d + (double)(-90.0F - this.field_70861_d) * 0.02D);
      }

   }

   public void func_70612_e(float p_70612_1_, float p_70612_2_) {
      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
   }

   public boolean func_70601_bi() {
      return this.field_70163_u > 45.0D && this.field_70163_u < 63.0D && super.func_70601_bi();
   }

   public void func_70103_a(byte p_70103_1_) {
      if(p_70103_1_ == 19) {
         this.field_70867_h = 0.0F;
      } else {
         super.func_70103_a(p_70103_1_);
      }

   }

   public void func_175568_b(float p_175568_1_, float p_175568_2_, float p_175568_3_) {
      this.field_70872_bC = p_175568_1_;
      this.field_70869_bD = p_175568_2_;
      this.field_70870_bE = p_175568_3_;
   }

   public boolean func_175567_n() {
      return this.field_70872_bC != 0.0F || this.field_70869_bD != 0.0F || this.field_70870_bE != 0.0F;
   }

   class AIMoveRandom extends EntityAIBase {

      private EntitySquid field_179476_a = EntitySquid.this;
      private static final String __OBFID = "CL_00002232";


      public boolean func_75250_a() {
         return true;
      }

      public void func_75246_d() {
         int var1 = this.field_179476_a.func_70654_ax();
         if(var1 > 100) {
            this.field_179476_a.func_175568_b(0.0F, 0.0F, 0.0F);
         } else if(this.field_179476_a.func_70681_au().nextInt(50) == 0 || !this.field_179476_a.field_70171_ac || !this.field_179476_a.func_175567_n()) {
            float var2 = this.field_179476_a.func_70681_au().nextFloat() * 3.1415927F * 2.0F;
            float var3 = MathHelper.func_76134_b(var2) * 0.2F;
            float var4 = -0.1F + this.field_179476_a.func_70681_au().nextFloat() * 0.2F;
            float var5 = MathHelper.func_76126_a(var2) * 0.2F;
            this.field_179476_a.func_175568_b(var3, var4, var5);
         }

      }
   }
}
