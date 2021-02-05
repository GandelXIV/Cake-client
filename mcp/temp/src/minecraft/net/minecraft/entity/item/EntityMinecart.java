package net.minecraft.entity.item;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.BlockRailPowered;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityMinecartCommandBlock;
import net.minecraft.entity.ai.EntityMinecartMobSpawner;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.entity.item.EntityMinecartEmpty;
import net.minecraft.entity.item.EntityMinecartFurnace;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public abstract class EntityMinecart extends Entity implements IWorldNameable {

   private boolean field_70499_f;
   private String field_94102_c;
   private static final int[][][] field_70500_g = new int[][][]{{{0, 0, -1}, {0, 0, 1}}, {{-1, 0, 0}, {1, 0, 0}}, {{-1, -1, 0}, {1, 0, 0}}, {{-1, 0, 0}, {1, -1, 0}}, {{0, 0, -1}, {0, -1, 1}}, {{0, -1, -1}, {0, 0, 1}}, {{0, 0, 1}, {1, 0, 0}}, {{0, 0, 1}, {-1, 0, 0}}, {{0, 0, -1}, {-1, 0, 0}}, {{0, 0, -1}, {1, 0, 0}}};
   private int field_70510_h;
   private double field_70511_i;
   private double field_70509_j;
   private double field_70514_an;
   private double field_70512_ao;
   private double field_70513_ap;
   private double field_70508_aq;
   private double field_70507_ar;
   private double field_70506_as;
   private static final String __OBFID = "CL_00001670";


   public EntityMinecart(World p_i1712_1_) {
      super(p_i1712_1_);
      this.field_70156_m = true;
      this.func_70105_a(0.98F, 0.7F);
   }

   public static EntityMinecart func_180458_a(World p_180458_0_, double p_180458_1_, double p_180458_3_, double p_180458_5_, EntityMinecart.EnumMinecartType p_180458_7_) {
      switch(EntityMinecart.SwitchEnumMinecartType.field_180037_a[p_180458_7_.ordinal()]) {
      case 1:
         return new EntityMinecartChest(p_180458_0_, p_180458_1_, p_180458_3_, p_180458_5_);
      case 2:
         return new EntityMinecartFurnace(p_180458_0_, p_180458_1_, p_180458_3_, p_180458_5_);
      case 3:
         return new EntityMinecartTNT(p_180458_0_, p_180458_1_, p_180458_3_, p_180458_5_);
      case 4:
         return new EntityMinecartMobSpawner(p_180458_0_, p_180458_1_, p_180458_3_, p_180458_5_);
      case 5:
         return new EntityMinecartHopper(p_180458_0_, p_180458_1_, p_180458_3_, p_180458_5_);
      case 6:
         return new EntityMinecartCommandBlock(p_180458_0_, p_180458_1_, p_180458_3_, p_180458_5_);
      default:
         return new EntityMinecartEmpty(p_180458_0_, p_180458_1_, p_180458_3_, p_180458_5_);
      }
   }

   protected boolean func_70041_e_() {
      return false;
   }

   protected void func_70088_a() {
      this.field_70180_af.func_75682_a(17, new Integer(0));
      this.field_70180_af.func_75682_a(18, new Integer(1));
      this.field_70180_af.func_75682_a(19, new Float(0.0F));
      this.field_70180_af.func_75682_a(20, new Integer(0));
      this.field_70180_af.func_75682_a(21, new Integer(6));
      this.field_70180_af.func_75682_a(22, Byte.valueOf((byte)0));
   }

   public AxisAlignedBB func_70114_g(Entity p_70114_1_) {
      return p_70114_1_.func_70104_M()?p_70114_1_.func_174813_aQ():null;
   }

   public AxisAlignedBB func_70046_E() {
      return null;
   }

   public boolean func_70104_M() {
      return true;
   }

   public EntityMinecart(World p_i1713_1_, double p_i1713_2_, double p_i1713_4_, double p_i1713_6_) {
      this(p_i1713_1_);
      this.func_70107_b(p_i1713_2_, p_i1713_4_, p_i1713_6_);
      this.field_70159_w = 0.0D;
      this.field_70181_x = 0.0D;
      this.field_70179_y = 0.0D;
      this.field_70169_q = p_i1713_2_;
      this.field_70167_r = p_i1713_4_;
      this.field_70166_s = p_i1713_6_;
   }

   public double func_70042_X() {
      return (double)this.field_70131_O * 0.5D - 0.20000000298023224D;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
      if(!this.field_70170_p.field_72995_K && !this.field_70128_L) {
         if(this.func_180431_b(p_70097_1_)) {
            return false;
         } else {
            this.func_70494_i(-this.func_70493_k());
            this.func_70497_h(10);
            this.func_70018_K();
            this.func_70492_c(this.func_70491_i() + p_70097_2_ * 10.0F);
            boolean var3 = p_70097_1_.func_76346_g() instanceof EntityPlayer && ((EntityPlayer)p_70097_1_.func_76346_g()).field_71075_bZ.field_75098_d;
            if(var3 || this.func_70491_i() > 40.0F) {
               if(this.field_70153_n != null) {
                  this.field_70153_n.func_70078_a((Entity)null);
               }

               if(var3 && !this.func_145818_k_()) {
                  this.func_70106_y();
               } else {
                  this.func_94095_a(p_70097_1_);
               }
            }

            return true;
         }
      } else {
         return true;
      }
   }

   public void func_94095_a(DamageSource p_94095_1_) {
      this.func_70106_y();
      ItemStack var2 = new ItemStack(Items.field_151143_au, 1);
      if(this.field_94102_c != null) {
         var2.func_151001_c(this.field_94102_c);
      }

      this.func_70099_a(var2, 0.0F);
   }

   public void func_70057_ab() {
      this.func_70494_i(-this.func_70493_k());
      this.func_70497_h(10);
      this.func_70492_c(this.func_70491_i() + this.func_70491_i() * 10.0F);
   }

   public boolean func_70067_L() {
      return !this.field_70128_L;
   }

   public void func_70106_y() {
      super.func_70106_y();
   }

   public void func_70071_h_() {
      if(this.func_70496_j() > 0) {
         this.func_70497_h(this.func_70496_j() - 1);
      }

      if(this.func_70491_i() > 0.0F) {
         this.func_70492_c(this.func_70491_i() - 1.0F);
      }

      if(this.field_70163_u < -64.0D) {
         this.func_70076_C();
      }

      int var2;
      if(!this.field_70170_p.field_72995_K && this.field_70170_p instanceof WorldServer) {
         this.field_70170_p.field_72984_F.func_76320_a("portal");
         MinecraftServer var1 = ((WorldServer)this.field_70170_p).func_73046_m();
         var2 = this.func_82145_z();
         if(this.field_71087_bX) {
            if(var1.func_71255_r()) {
               if(this.field_70154_o == null && this.field_82153_h++ >= var2) {
                  this.field_82153_h = var2;
                  this.field_71088_bW = this.func_82147_ab();
                  byte var3;
                  if(this.field_70170_p.field_73011_w.func_177502_q() == -1) {
                     var3 = 0;
                  } else {
                     var3 = -1;
                  }

                  this.func_71027_c(var3);
               }

               this.field_71087_bX = false;
            }
         } else {
            if(this.field_82153_h > 0) {
               this.field_82153_h -= 4;
            }

            if(this.field_82153_h < 0) {
               this.field_82153_h = 0;
            }
         }

         if(this.field_71088_bW > 0) {
            --this.field_71088_bW;
         }

         this.field_70170_p.field_72984_F.func_76319_b();
      }

      if(this.field_70170_p.field_72995_K) {
         if(this.field_70510_h > 0) {
            double var15 = this.field_70165_t + (this.field_70511_i - this.field_70165_t) / (double)this.field_70510_h;
            double var17 = this.field_70163_u + (this.field_70509_j - this.field_70163_u) / (double)this.field_70510_h;
            double var18 = this.field_70161_v + (this.field_70514_an - this.field_70161_v) / (double)this.field_70510_h;
            double var7 = MathHelper.func_76138_g(this.field_70512_ao - (double)this.field_70177_z);
            this.field_70177_z = (float)((double)this.field_70177_z + var7 / (double)this.field_70510_h);
            this.field_70125_A = (float)((double)this.field_70125_A + (this.field_70513_ap - (double)this.field_70125_A) / (double)this.field_70510_h);
            --this.field_70510_h;
            this.func_70107_b(var15, var17, var18);
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
         } else {
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
         }

      } else {
         this.field_70169_q = this.field_70165_t;
         this.field_70167_r = this.field_70163_u;
         this.field_70166_s = this.field_70161_v;
         this.field_70181_x -= 0.03999999910593033D;
         int var14 = MathHelper.func_76128_c(this.field_70165_t);
         var2 = MathHelper.func_76128_c(this.field_70163_u);
         int var16 = MathHelper.func_76128_c(this.field_70161_v);
         if(BlockRailBase.func_176562_d(this.field_70170_p, new BlockPos(var14, var2 - 1, var16))) {
            --var2;
         }

         BlockPos var4 = new BlockPos(var14, var2, var16);
         IBlockState var5 = this.field_70170_p.func_180495_p(var4);
         if(BlockRailBase.func_176563_d(var5)) {
            this.func_180460_a(var4, var5);
            if(var5.func_177230_c() == Blocks.field_150408_cc) {
               this.func_96095_a(var14, var2, var16, ((Boolean)var5.func_177229_b(BlockRailPowered.field_176569_M)).booleanValue());
            }
         } else {
            this.func_180459_n();
         }

         this.func_145775_I();
         this.field_70125_A = 0.0F;
         double var6 = this.field_70169_q - this.field_70165_t;
         double var8 = this.field_70166_s - this.field_70161_v;
         if(var6 * var6 + var8 * var8 > 0.001D) {
            this.field_70177_z = (float)(Math.atan2(var8, var6) * 180.0D / 3.141592653589793D);
            if(this.field_70499_f) {
               this.field_70177_z += 180.0F;
            }
         }

         double var10 = (double)MathHelper.func_76142_g(this.field_70177_z - this.field_70126_B);
         if(var10 < -170.0D || var10 >= 170.0D) {
            this.field_70177_z += 180.0F;
            this.field_70499_f = !this.field_70499_f;
         }

         this.func_70101_b(this.field_70177_z, this.field_70125_A);
         Iterator var12 = this.field_70170_p.func_72839_b(this, this.func_174813_aQ().func_72314_b(0.20000000298023224D, 0.0D, 0.20000000298023224D)).iterator();

         while(var12.hasNext()) {
            Entity var13 = (Entity)var12.next();
            if(var13 != this.field_70153_n && var13.func_70104_M() && var13 instanceof EntityMinecart) {
               var13.func_70108_f(this);
            }
         }

         if(this.field_70153_n != null && this.field_70153_n.field_70128_L) {
            if(this.field_70153_n.field_70154_o == this) {
               this.field_70153_n.field_70154_o = null;
            }

            this.field_70153_n = null;
         }

         this.func_70072_I();
      }
   }

   protected double func_174898_m() {
      return 0.4D;
   }

   public void func_96095_a(int p_96095_1_, int p_96095_2_, int p_96095_3_, boolean p_96095_4_) {}

   protected void func_180459_n() {
      double var1 = this.func_174898_m();
      this.field_70159_w = MathHelper.func_151237_a(this.field_70159_w, -var1, var1);
      this.field_70179_y = MathHelper.func_151237_a(this.field_70179_y, -var1, var1);
      if(this.field_70122_E) {
         this.field_70159_w *= 0.5D;
         this.field_70181_x *= 0.5D;
         this.field_70179_y *= 0.5D;
      }

      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      if(!this.field_70122_E) {
         this.field_70159_w *= 0.949999988079071D;
         this.field_70181_x *= 0.949999988079071D;
         this.field_70179_y *= 0.949999988079071D;
      }

   }

   protected void func_180460_a(BlockPos p_180460_1_, IBlockState p_180460_2_) {
      this.field_70143_R = 0.0F;
      Vec3 var3 = this.func_70489_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70163_u = (double)p_180460_1_.func_177956_o();
      boolean var4 = false;
      boolean var5 = false;
      BlockRailBase var6 = (BlockRailBase)p_180460_2_.func_177230_c();
      if(var6 == Blocks.field_150318_D) {
         var4 = ((Boolean)p_180460_2_.func_177229_b(BlockRailPowered.field_176569_M)).booleanValue();
         var5 = !var4;
      }

      double var7 = 0.0078125D;
      BlockRailBase.EnumRailDirection var9 = (BlockRailBase.EnumRailDirection)p_180460_2_.func_177229_b(var6.func_176560_l());
      switch(EntityMinecart.SwitchEnumMinecartType.field_180036_b[var9.ordinal()]) {
      case 1:
         this.field_70159_w -= 0.0078125D;
         ++this.field_70163_u;
         break;
      case 2:
         this.field_70159_w += 0.0078125D;
         ++this.field_70163_u;
         break;
      case 3:
         this.field_70179_y += 0.0078125D;
         ++this.field_70163_u;
         break;
      case 4:
         this.field_70179_y -= 0.0078125D;
         ++this.field_70163_u;
      }

      int[][] var10 = field_70500_g[var9.func_177015_a()];
      double var11 = (double)(var10[1][0] - var10[0][0]);
      double var13 = (double)(var10[1][2] - var10[0][2]);
      double var15 = Math.sqrt(var11 * var11 + var13 * var13);
      double var17 = this.field_70159_w * var11 + this.field_70179_y * var13;
      if(var17 < 0.0D) {
         var11 = -var11;
         var13 = -var13;
      }

      double var19 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
      if(var19 > 2.0D) {
         var19 = 2.0D;
      }

      this.field_70159_w = var19 * var11 / var15;
      this.field_70179_y = var19 * var13 / var15;
      double var21;
      double var23;
      double var25;
      double var27;
      if(this.field_70153_n instanceof EntityLivingBase) {
         var21 = (double)((EntityLivingBase)this.field_70153_n).field_70701_bs;
         if(var21 > 0.0D) {
            var23 = -Math.sin((double)(this.field_70153_n.field_70177_z * 3.1415927F / 180.0F));
            var25 = Math.cos((double)(this.field_70153_n.field_70177_z * 3.1415927F / 180.0F));
            var27 = this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y;
            if(var27 < 0.01D) {
               this.field_70159_w += var23 * 0.1D;
               this.field_70179_y += var25 * 0.1D;
               var5 = false;
            }
         }
      }

      if(var5) {
         var21 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
         if(var21 < 0.03D) {
            this.field_70159_w *= 0.0D;
            this.field_70181_x *= 0.0D;
            this.field_70179_y *= 0.0D;
         } else {
            this.field_70159_w *= 0.5D;
            this.field_70181_x *= 0.0D;
            this.field_70179_y *= 0.5D;
         }
      }

      var21 = 0.0D;
      var23 = (double)p_180460_1_.func_177958_n() + 0.5D + (double)var10[0][0] * 0.5D;
      var25 = (double)p_180460_1_.func_177952_p() + 0.5D + (double)var10[0][2] * 0.5D;
      var27 = (double)p_180460_1_.func_177958_n() + 0.5D + (double)var10[1][0] * 0.5D;
      double var29 = (double)p_180460_1_.func_177952_p() + 0.5D + (double)var10[1][2] * 0.5D;
      var11 = var27 - var23;
      var13 = var29 - var25;
      double var31;
      double var33;
      if(var11 == 0.0D) {
         this.field_70165_t = (double)p_180460_1_.func_177958_n() + 0.5D;
         var21 = this.field_70161_v - (double)p_180460_1_.func_177952_p();
      } else if(var13 == 0.0D) {
         this.field_70161_v = (double)p_180460_1_.func_177952_p() + 0.5D;
         var21 = this.field_70165_t - (double)p_180460_1_.func_177958_n();
      } else {
         var31 = this.field_70165_t - var23;
         var33 = this.field_70161_v - var25;
         var21 = (var31 * var11 + var33 * var13) * 2.0D;
      }

      this.field_70165_t = var23 + var11 * var21;
      this.field_70161_v = var25 + var13 * var21;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      var31 = this.field_70159_w;
      var33 = this.field_70179_y;
      if(this.field_70153_n != null) {
         var31 *= 0.75D;
         var33 *= 0.75D;
      }

      double var35 = this.func_174898_m();
      var31 = MathHelper.func_151237_a(var31, -var35, var35);
      var33 = MathHelper.func_151237_a(var33, -var35, var35);
      this.func_70091_d(var31, 0.0D, var33);
      if(var10[0][1] != 0 && MathHelper.func_76128_c(this.field_70165_t) - p_180460_1_.func_177958_n() == var10[0][0] && MathHelper.func_76128_c(this.field_70161_v) - p_180460_1_.func_177952_p() == var10[0][2]) {
         this.func_70107_b(this.field_70165_t, this.field_70163_u + (double)var10[0][1], this.field_70161_v);
      } else if(var10[1][1] != 0 && MathHelper.func_76128_c(this.field_70165_t) - p_180460_1_.func_177958_n() == var10[1][0] && MathHelper.func_76128_c(this.field_70161_v) - p_180460_1_.func_177952_p() == var10[1][2]) {
         this.func_70107_b(this.field_70165_t, this.field_70163_u + (double)var10[1][1], this.field_70161_v);
      }

      this.func_94101_h();
      Vec3 var37 = this.func_70489_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      if(var37 != null && var3 != null) {
         double var38 = (var3.field_72448_b - var37.field_72448_b) * 0.05D;
         var19 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
         if(var19 > 0.0D) {
            this.field_70159_w = this.field_70159_w / var19 * (var19 + var38);
            this.field_70179_y = this.field_70179_y / var19 * (var19 + var38);
         }

         this.func_70107_b(this.field_70165_t, var37.field_72448_b, this.field_70161_v);
      }

      int var44 = MathHelper.func_76128_c(this.field_70165_t);
      int var39 = MathHelper.func_76128_c(this.field_70161_v);
      if(var44 != p_180460_1_.func_177958_n() || var39 != p_180460_1_.func_177952_p()) {
         var19 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
         this.field_70159_w = var19 * (double)(var44 - p_180460_1_.func_177958_n());
         this.field_70179_y = var19 * (double)(var39 - p_180460_1_.func_177952_p());
      }

      if(var4) {
         double var40 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
         if(var40 > 0.01D) {
            double var42 = 0.06D;
            this.field_70159_w += this.field_70159_w / var40 * var42;
            this.field_70179_y += this.field_70179_y / var40 * var42;
         } else if(var9 == BlockRailBase.EnumRailDirection.EAST_WEST) {
            if(this.field_70170_p.func_180495_p(p_180460_1_.func_177976_e()).func_177230_c().func_149721_r()) {
               this.field_70159_w = 0.02D;
            } else if(this.field_70170_p.func_180495_p(p_180460_1_.func_177974_f()).func_177230_c().func_149721_r()) {
               this.field_70159_w = -0.02D;
            }
         } else if(var9 == BlockRailBase.EnumRailDirection.NORTH_SOUTH) {
            if(this.field_70170_p.func_180495_p(p_180460_1_.func_177978_c()).func_177230_c().func_149721_r()) {
               this.field_70179_y = 0.02D;
            } else if(this.field_70170_p.func_180495_p(p_180460_1_.func_177968_d()).func_177230_c().func_149721_r()) {
               this.field_70179_y = -0.02D;
            }
         }
      }

   }

   protected void func_94101_h() {
      if(this.field_70153_n != null) {
         this.field_70159_w *= 0.996999979019165D;
         this.field_70181_x *= 0.0D;
         this.field_70179_y *= 0.996999979019165D;
      } else {
         this.field_70159_w *= 0.9599999785423279D;
         this.field_70181_x *= 0.0D;
         this.field_70179_y *= 0.9599999785423279D;
      }

   }

   public void func_70107_b(double p_70107_1_, double p_70107_3_, double p_70107_5_) {
      this.field_70165_t = p_70107_1_;
      this.field_70163_u = p_70107_3_;
      this.field_70161_v = p_70107_5_;
      float var7 = this.field_70130_N / 2.0F;
      float var8 = this.field_70131_O;
      this.func_174826_a(new AxisAlignedBB(p_70107_1_ - (double)var7, p_70107_3_, p_70107_5_ - (double)var7, p_70107_1_ + (double)var7, p_70107_3_ + (double)var8, p_70107_5_ + (double)var7));
   }

   public Vec3 func_70495_a(double p_70495_1_, double p_70495_3_, double p_70495_5_, double p_70495_7_) {
      int var9 = MathHelper.func_76128_c(p_70495_1_);
      int var10 = MathHelper.func_76128_c(p_70495_3_);
      int var11 = MathHelper.func_76128_c(p_70495_5_);
      if(BlockRailBase.func_176562_d(this.field_70170_p, new BlockPos(var9, var10 - 1, var11))) {
         --var10;
      }

      IBlockState var12 = this.field_70170_p.func_180495_p(new BlockPos(var9, var10, var11));
      if(BlockRailBase.func_176563_d(var12)) {
         BlockRailBase.EnumRailDirection var13 = (BlockRailBase.EnumRailDirection)var12.func_177229_b(((BlockRailBase)var12.func_177230_c()).func_176560_l());
         p_70495_3_ = (double)var10;
         if(var13.func_177018_c()) {
            p_70495_3_ = (double)(var10 + 1);
         }

         int[][] var14 = field_70500_g[var13.func_177015_a()];
         double var15 = (double)(var14[1][0] - var14[0][0]);
         double var17 = (double)(var14[1][2] - var14[0][2]);
         double var19 = Math.sqrt(var15 * var15 + var17 * var17);
         var15 /= var19;
         var17 /= var19;
         p_70495_1_ += var15 * p_70495_7_;
         p_70495_5_ += var17 * p_70495_7_;
         if(var14[0][1] != 0 && MathHelper.func_76128_c(p_70495_1_) - var9 == var14[0][0] && MathHelper.func_76128_c(p_70495_5_) - var11 == var14[0][2]) {
            p_70495_3_ += (double)var14[0][1];
         } else if(var14[1][1] != 0 && MathHelper.func_76128_c(p_70495_1_) - var9 == var14[1][0] && MathHelper.func_76128_c(p_70495_5_) - var11 == var14[1][2]) {
            p_70495_3_ += (double)var14[1][1];
         }

         return this.func_70489_a(p_70495_1_, p_70495_3_, p_70495_5_);
      } else {
         return null;
      }
   }

   public Vec3 func_70489_a(double p_70489_1_, double p_70489_3_, double p_70489_5_) {
      int var7 = MathHelper.func_76128_c(p_70489_1_);
      int var8 = MathHelper.func_76128_c(p_70489_3_);
      int var9 = MathHelper.func_76128_c(p_70489_5_);
      if(BlockRailBase.func_176562_d(this.field_70170_p, new BlockPos(var7, var8 - 1, var9))) {
         --var8;
      }

      IBlockState var10 = this.field_70170_p.func_180495_p(new BlockPos(var7, var8, var9));
      if(BlockRailBase.func_176563_d(var10)) {
         BlockRailBase.EnumRailDirection var11 = (BlockRailBase.EnumRailDirection)var10.func_177229_b(((BlockRailBase)var10.func_177230_c()).func_176560_l());
         int[][] var12 = field_70500_g[var11.func_177015_a()];
         double var13 = 0.0D;
         double var15 = (double)var7 + 0.5D + (double)var12[0][0] * 0.5D;
         double var17 = (double)var8 + 0.0625D + (double)var12[0][1] * 0.5D;
         double var19 = (double)var9 + 0.5D + (double)var12[0][2] * 0.5D;
         double var21 = (double)var7 + 0.5D + (double)var12[1][0] * 0.5D;
         double var23 = (double)var8 + 0.0625D + (double)var12[1][1] * 0.5D;
         double var25 = (double)var9 + 0.5D + (double)var12[1][2] * 0.5D;
         double var27 = var21 - var15;
         double var29 = (var23 - var17) * 2.0D;
         double var31 = var25 - var19;
         if(var27 == 0.0D) {
            p_70489_1_ = (double)var7 + 0.5D;
            var13 = p_70489_5_ - (double)var9;
         } else if(var31 == 0.0D) {
            p_70489_5_ = (double)var9 + 0.5D;
            var13 = p_70489_1_ - (double)var7;
         } else {
            double var33 = p_70489_1_ - var15;
            double var35 = p_70489_5_ - var19;
            var13 = (var33 * var27 + var35 * var31) * 2.0D;
         }

         p_70489_1_ = var15 + var27 * var13;
         p_70489_3_ = var17 + var29 * var13;
         p_70489_5_ = var19 + var31 * var13;
         if(var29 < 0.0D) {
            ++p_70489_3_;
         }

         if(var29 > 0.0D) {
            p_70489_3_ += 0.5D;
         }

         return new Vec3(p_70489_1_, p_70489_3_, p_70489_5_);
      } else {
         return null;
      }
   }

   protected void func_70037_a(NBTTagCompound p_70037_1_) {
      if(p_70037_1_.func_74767_n("CustomDisplayTile")) {
         int var2 = p_70037_1_.func_74762_e("DisplayData");
         Block var3;
         if(p_70037_1_.func_150297_b("DisplayTile", 8)) {
            var3 = Block.func_149684_b(p_70037_1_.func_74779_i("DisplayTile"));
            if(var3 == null) {
               this.func_174899_a(Blocks.field_150350_a.func_176223_P());
            } else {
               this.func_174899_a(var3.func_176203_a(var2));
            }
         } else {
            var3 = Block.func_149729_e(p_70037_1_.func_74762_e("DisplayTile"));
            if(var3 == null) {
               this.func_174899_a(Blocks.field_150350_a.func_176223_P());
            } else {
               this.func_174899_a(var3.func_176203_a(var2));
            }
         }

         this.func_94086_l(p_70037_1_.func_74762_e("DisplayOffset"));
      }

      if(p_70037_1_.func_150297_b("CustomName", 8) && p_70037_1_.func_74779_i("CustomName").length() > 0) {
         this.field_94102_c = p_70037_1_.func_74779_i("CustomName");
      }

   }

   protected void func_70014_b(NBTTagCompound p_70014_1_) {
      if(this.func_94100_s()) {
         p_70014_1_.func_74757_a("CustomDisplayTile", true);
         IBlockState var2 = this.func_174897_t();
         ResourceLocation var3 = (ResourceLocation)Block.field_149771_c.func_177774_c(var2.func_177230_c());
         p_70014_1_.func_74778_a("DisplayTile", var3 == null?"":var3.toString());
         p_70014_1_.func_74768_a("DisplayData", var2.func_177230_c().func_176201_c(var2));
         p_70014_1_.func_74768_a("DisplayOffset", this.func_94099_q());
      }

      if(this.field_94102_c != null && this.field_94102_c.length() > 0) {
         p_70014_1_.func_74778_a("CustomName", this.field_94102_c);
      }

   }

   public void func_70108_f(Entity p_70108_1_) {
      if(!this.field_70170_p.field_72995_K) {
         if(!p_70108_1_.field_70145_X && !this.field_70145_X) {
            if(p_70108_1_ != this.field_70153_n) {
               if(p_70108_1_ instanceof EntityLivingBase && !(p_70108_1_ instanceof EntityPlayer) && !(p_70108_1_ instanceof EntityIronGolem) && this.func_180456_s() == EntityMinecart.EnumMinecartType.RIDEABLE && this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y > 0.01D && this.field_70153_n == null && p_70108_1_.field_70154_o == null) {
                  p_70108_1_.func_70078_a(this);
               }

               double var2 = p_70108_1_.field_70165_t - this.field_70165_t;
               double var4 = p_70108_1_.field_70161_v - this.field_70161_v;
               double var6 = var2 * var2 + var4 * var4;
               if(var6 >= 9.999999747378752E-5D) {
                  var6 = (double)MathHelper.func_76133_a(var6);
                  var2 /= var6;
                  var4 /= var6;
                  double var8 = 1.0D / var6;
                  if(var8 > 1.0D) {
                     var8 = 1.0D;
                  }

                  var2 *= var8;
                  var4 *= var8;
                  var2 *= 0.10000000149011612D;
                  var4 *= 0.10000000149011612D;
                  var2 *= (double)(1.0F - this.field_70144_Y);
                  var4 *= (double)(1.0F - this.field_70144_Y);
                  var2 *= 0.5D;
                  var4 *= 0.5D;
                  if(p_70108_1_ instanceof EntityMinecart) {
                     double var10 = p_70108_1_.field_70165_t - this.field_70165_t;
                     double var12 = p_70108_1_.field_70161_v - this.field_70161_v;
                     Vec3 var14 = (new Vec3(var10, 0.0D, var12)).func_72432_b();
                     Vec3 var15 = (new Vec3((double)MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F), 0.0D, (double)MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F))).func_72432_b();
                     double var16 = Math.abs(var14.func_72430_b(var15));
                     if(var16 < 0.800000011920929D) {
                        return;
                     }

                     double var18 = p_70108_1_.field_70159_w + this.field_70159_w;
                     double var20 = p_70108_1_.field_70179_y + this.field_70179_y;
                     if(((EntityMinecart)p_70108_1_).func_180456_s() == EntityMinecart.EnumMinecartType.FURNACE && this.func_180456_s() != EntityMinecart.EnumMinecartType.FURNACE) {
                        this.field_70159_w *= 0.20000000298023224D;
                        this.field_70179_y *= 0.20000000298023224D;
                        this.func_70024_g(p_70108_1_.field_70159_w - var2, 0.0D, p_70108_1_.field_70179_y - var4);
                        p_70108_1_.field_70159_w *= 0.949999988079071D;
                        p_70108_1_.field_70179_y *= 0.949999988079071D;
                     } else if(((EntityMinecart)p_70108_1_).func_180456_s() != EntityMinecart.EnumMinecartType.FURNACE && this.func_180456_s() == EntityMinecart.EnumMinecartType.FURNACE) {
                        p_70108_1_.field_70159_w *= 0.20000000298023224D;
                        p_70108_1_.field_70179_y *= 0.20000000298023224D;
                        p_70108_1_.func_70024_g(this.field_70159_w + var2, 0.0D, this.field_70179_y + var4);
                        this.field_70159_w *= 0.949999988079071D;
                        this.field_70179_y *= 0.949999988079071D;
                     } else {
                        var18 /= 2.0D;
                        var20 /= 2.0D;
                        this.field_70159_w *= 0.20000000298023224D;
                        this.field_70179_y *= 0.20000000298023224D;
                        this.func_70024_g(var18 - var2, 0.0D, var20 - var4);
                        p_70108_1_.field_70159_w *= 0.20000000298023224D;
                        p_70108_1_.field_70179_y *= 0.20000000298023224D;
                        p_70108_1_.func_70024_g(var18 + var2, 0.0D, var20 + var4);
                     }
                  } else {
                     this.func_70024_g(-var2, 0.0D, -var4);
                     p_70108_1_.func_70024_g(var2 / 4.0D, 0.0D, var4 / 4.0D);
                  }
               }

            }
         }
      }
   }

   public void func_180426_a(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
      this.field_70511_i = p_180426_1_;
      this.field_70509_j = p_180426_3_;
      this.field_70514_an = p_180426_5_;
      this.field_70512_ao = (double)p_180426_7_;
      this.field_70513_ap = (double)p_180426_8_;
      this.field_70510_h = p_180426_9_ + 2;
      this.field_70159_w = this.field_70508_aq;
      this.field_70181_x = this.field_70507_ar;
      this.field_70179_y = this.field_70506_as;
   }

   public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
      this.field_70508_aq = this.field_70159_w = p_70016_1_;
      this.field_70507_ar = this.field_70181_x = p_70016_3_;
      this.field_70506_as = this.field_70179_y = p_70016_5_;
   }

   public void func_70492_c(float p_70492_1_) {
      this.field_70180_af.func_75692_b(19, Float.valueOf(p_70492_1_));
   }

   public float func_70491_i() {
      return this.field_70180_af.func_111145_d(19);
   }

   public void func_70497_h(int p_70497_1_) {
      this.field_70180_af.func_75692_b(17, Integer.valueOf(p_70497_1_));
   }

   public int func_70496_j() {
      return this.field_70180_af.func_75679_c(17);
   }

   public void func_70494_i(int p_70494_1_) {
      this.field_70180_af.func_75692_b(18, Integer.valueOf(p_70494_1_));
   }

   public int func_70493_k() {
      return this.field_70180_af.func_75679_c(18);
   }

   public abstract EntityMinecart.EnumMinecartType func_180456_s();

   public IBlockState func_174897_t() {
      return !this.func_94100_s()?this.func_180457_u():Block.func_176220_d(this.func_70096_w().func_75679_c(20));
   }

   public IBlockState func_180457_u() {
      return Blocks.field_150350_a.func_176223_P();
   }

   public int func_94099_q() {
      return !this.func_94100_s()?this.func_94085_r():this.func_70096_w().func_75679_c(21);
   }

   public int func_94085_r() {
      return 6;
   }

   public void func_174899_a(IBlockState p_174899_1_) {
      this.func_70096_w().func_75692_b(20, Integer.valueOf(Block.func_176210_f(p_174899_1_)));
      this.func_94096_e(true);
   }

   public void func_94086_l(int p_94086_1_) {
      this.func_70096_w().func_75692_b(21, Integer.valueOf(p_94086_1_));
      this.func_94096_e(true);
   }

   public boolean func_94100_s() {
      return this.func_70096_w().func_75683_a(22) == 1;
   }

   public void func_94096_e(boolean p_94096_1_) {
      this.func_70096_w().func_75692_b(22, Byte.valueOf((byte)(p_94096_1_?1:0)));
   }

   public void func_96094_a(String p_96094_1_) {
      this.field_94102_c = p_96094_1_;
   }

   public String func_70005_c_() {
      return this.field_94102_c != null?this.field_94102_c:super.func_70005_c_();
   }

   public boolean func_145818_k_() {
      return this.field_94102_c != null;
   }

   public String func_95999_t() {
      return this.field_94102_c;
   }

   public IChatComponent func_145748_c_() {
      if(this.func_145818_k_()) {
         ChatComponentText var2 = new ChatComponentText(this.field_94102_c);
         var2.func_150256_b().func_150209_a(this.func_174823_aP());
         var2.func_150256_b().func_179989_a(this.func_110124_au().toString());
         return var2;
      } else {
         ChatComponentTranslation var1 = new ChatComponentTranslation(this.func_70005_c_(), new Object[0]);
         var1.func_150256_b().func_150209_a(this.func_174823_aP());
         var1.func_150256_b().func_179989_a(this.func_110124_au().toString());
         return var1;
      }
   }


   public static enum EnumMinecartType {

      RIDEABLE("RIDEABLE", 0, 0, "MinecartRideable"),
      CHEST("CHEST", 1, 1, "MinecartChest"),
      FURNACE("FURNACE", 2, 2, "MinecartFurnace"),
      TNT("TNT", 3, 3, "MinecartTNT"),
      SPAWNER("SPAWNER", 4, 4, "MinecartSpawner"),
      HOPPER("HOPPER", 5, 5, "MinecartHopper"),
      COMMAND_BLOCK("COMMAND_BLOCK", 6, 6, "MinecartCommandBlock");
      private static final Map field_180051_h = Maps.newHashMap();
      private final int field_180052_i;
      private final String field_180049_j;
      // $FF: synthetic field
      private static final EntityMinecart.EnumMinecartType[] $VALUES = new EntityMinecart.EnumMinecartType[]{RIDEABLE, CHEST, FURNACE, TNT, SPAWNER, HOPPER, COMMAND_BLOCK};
      private static final String __OBFID = "CL_00002226";


      private EnumMinecartType(String p_i45847_1_, int p_i45847_2_, int p_i45847_3_, String p_i45847_4_) {
         this.field_180052_i = p_i45847_3_;
         this.field_180049_j = p_i45847_4_;
      }

      public int func_180039_a() {
         return this.field_180052_i;
      }

      public String func_180040_b() {
         return this.field_180049_j;
      }

      public static EntityMinecart.EnumMinecartType func_180038_a(int p_180038_0_) {
         EntityMinecart.EnumMinecartType var1 = (EntityMinecart.EnumMinecartType)field_180051_h.get(Integer.valueOf(p_180038_0_));
         return var1 == null?RIDEABLE:var1;
      }

      static {
         EntityMinecart.EnumMinecartType[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            EntityMinecart.EnumMinecartType var3 = var0[var2];
            field_180051_h.put(Integer.valueOf(var3.func_180039_a()), var3);
         }

      }
   }

   // $FF: synthetic class
   static final class SwitchEnumMinecartType {

      // $FF: synthetic field
      static final int[] field_180037_a;
      // $FF: synthetic field
      static final int[] field_180036_b = new int[BlockRailBase.EnumRailDirection.values().length];
      private static final String __OBFID = "CL_00002227";


      static {
         try {
            field_180036_b[BlockRailBase.EnumRailDirection.ASCENDING_EAST.ordinal()] = 1;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            field_180036_b[BlockRailBase.EnumRailDirection.ASCENDING_WEST.ordinal()] = 2;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            field_180036_b[BlockRailBase.EnumRailDirection.ASCENDING_NORTH.ordinal()] = 3;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            field_180036_b[BlockRailBase.EnumRailDirection.ASCENDING_SOUTH.ordinal()] = 4;
         } catch (NoSuchFieldError var7) {
            ;
         }

         field_180037_a = new int[EntityMinecart.EnumMinecartType.values().length];

         try {
            field_180037_a[EntityMinecart.EnumMinecartType.CHEST.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            field_180037_a[EntityMinecart.EnumMinecartType.FURNACE.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            field_180037_a[EntityMinecart.EnumMinecartType.TNT.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_180037_a[EntityMinecart.EnumMinecartType.SPAWNER.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_180037_a[EntityMinecart.EnumMinecartType.HOPPER.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_180037_a[EntityMinecart.EnumMinecartType.COMMAND_BLOCK.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
