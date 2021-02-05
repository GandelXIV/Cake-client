package net.minecraft.entity;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.event.HoverEvent;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ReportedException;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public abstract class Entity implements ICommandSender {

   private static final AxisAlignedBB field_174836_a = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
   private static int field_70152_a;
   private int field_145783_c;
   public double field_70155_l;
   public boolean field_70156_m;
   public Entity field_70153_n;
   public Entity field_70154_o;
   public boolean field_98038_p;
   public World field_70170_p;
   public double field_70169_q;
   public double field_70167_r;
   public double field_70166_s;
   public double field_70165_t;
   public double field_70163_u;
   public double field_70161_v;
   public double field_70159_w;
   public double field_70181_x;
   public double field_70179_y;
   public float field_70177_z;
   public float field_70125_A;
   public float field_70126_B;
   public float field_70127_C;
   private AxisAlignedBB field_70121_D;
   public boolean field_70122_E;
   public boolean field_70123_F;
   public boolean field_70124_G;
   public boolean field_70132_H;
   public boolean field_70133_I;
   protected boolean field_70134_J;
   private boolean field_174835_g;
   public boolean field_70128_L;
   public float field_70130_N;
   public float field_70131_O;
   public float field_70141_P;
   public float field_70140_Q;
   public float field_82151_R;
   public float field_70143_R;
   private int field_70150_b;
   public double field_70142_S;
   public double field_70137_T;
   public double field_70136_U;
   public float field_70138_W;
   public boolean field_70145_X;
   public float field_70144_Y;
   protected Random field_70146_Z;
   public int field_70173_aa;
   public int field_70174_ab;
   private int field_70151_c;
   protected boolean field_70171_ac;
   public int field_70172_ad;
   protected boolean field_70148_d;
   protected boolean field_70178_ae;
   protected DataWatcher field_70180_af;
   private double field_70149_e;
   private double field_70147_f;
   public boolean field_70175_ag;
   public int field_70176_ah;
   public int field_70162_ai;
   public int field_70164_aj;
   public int field_70118_ct;
   public int field_70117_cu;
   public int field_70116_cv;
   public boolean field_70158_ak;
   public boolean field_70160_al;
   public int field_71088_bW;
   protected boolean field_71087_bX;
   protected int field_82153_h;
   public int field_71093_bK;
   protected int field_82152_aq;
   private boolean field_83001_bt;
   protected UUID field_96093_i;
   private final CommandResultStats field_174837_as;
   private static final String __OBFID = "CL_00001533";


   public int func_145782_y() {
      return this.field_145783_c;
   }

   public void func_145769_d(int p_145769_1_) {
      this.field_145783_c = p_145769_1_;
   }

   public void func_174812_G() {
      this.func_70106_y();
   }

   public Entity(World p_i1582_1_) {
      this.field_145783_c = field_70152_a++;
      this.field_70155_l = 1.0D;
      this.field_70121_D = field_174836_a;
      this.field_70130_N = 0.6F;
      this.field_70131_O = 1.8F;
      this.field_70150_b = 1;
      this.field_70146_Z = new Random();
      this.field_70174_ab = 1;
      this.field_70148_d = true;
      this.field_96093_i = MathHelper.func_180182_a(this.field_70146_Z);
      this.field_174837_as = new CommandResultStats();
      this.field_70170_p = p_i1582_1_;
      this.func_70107_b(0.0D, 0.0D, 0.0D);
      if(p_i1582_1_ != null) {
         this.field_71093_bK = p_i1582_1_.field_73011_w.func_177502_q();
      }

      this.field_70180_af = new DataWatcher(this);
      this.field_70180_af.func_75682_a(0, Byte.valueOf((byte)0));
      this.field_70180_af.func_75682_a(1, Short.valueOf((short)300));
      this.field_70180_af.func_75682_a(3, Byte.valueOf((byte)0));
      this.field_70180_af.func_75682_a(2, "");
      this.field_70180_af.func_75682_a(4, Byte.valueOf((byte)0));
      this.func_70088_a();
   }

   protected abstract void func_70088_a();

   public DataWatcher func_70096_w() {
      return this.field_70180_af;
   }

   public boolean equals(Object p_equals_1_) {
      return p_equals_1_ instanceof Entity?((Entity)p_equals_1_).field_145783_c == this.field_145783_c:false;
   }

   public int hashCode() {
      return this.field_145783_c;
   }

   protected void func_70065_x() {
      if(this.field_70170_p != null) {
         while(this.field_70163_u > 0.0D && this.field_70163_u < 256.0D) {
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            if(this.field_70170_p.func_72945_a(this, this.func_174813_aQ()).isEmpty()) {
               break;
            }

            ++this.field_70163_u;
         }

         this.field_70159_w = this.field_70181_x = this.field_70179_y = 0.0D;
         this.field_70125_A = 0.0F;
      }
   }

   public void func_70106_y() {
      this.field_70128_L = true;
   }

   protected void func_70105_a(float p_70105_1_, float p_70105_2_) {
      if(p_70105_1_ != this.field_70130_N || p_70105_2_ != this.field_70131_O) {
         float var3 = this.field_70130_N;
         this.field_70130_N = p_70105_1_;
         this.field_70131_O = p_70105_2_;
         this.func_174826_a(new AxisAlignedBB(this.func_174813_aQ().field_72340_a, this.func_174813_aQ().field_72338_b, this.func_174813_aQ().field_72339_c, this.func_174813_aQ().field_72340_a + (double)this.field_70130_N, this.func_174813_aQ().field_72338_b + (double)this.field_70131_O, this.func_174813_aQ().field_72339_c + (double)this.field_70130_N));
         if(this.field_70130_N > var3 && !this.field_70148_d && !this.field_70170_p.field_72995_K) {
            this.func_70091_d((double)(var3 - this.field_70130_N), 0.0D, (double)(var3 - this.field_70130_N));
         }
      }

   }

   protected void func_70101_b(float p_70101_1_, float p_70101_2_) {
      this.field_70177_z = p_70101_1_ % 360.0F;
      this.field_70125_A = p_70101_2_ % 360.0F;
   }

   public void func_70107_b(double p_70107_1_, double p_70107_3_, double p_70107_5_) {
      this.field_70165_t = p_70107_1_;
      this.field_70163_u = p_70107_3_;
      this.field_70161_v = p_70107_5_;
      float var7 = this.field_70130_N / 2.0F;
      float var8 = this.field_70131_O;
      this.func_174826_a(new AxisAlignedBB(p_70107_1_ - (double)var7, p_70107_3_, p_70107_5_ - (double)var7, p_70107_1_ + (double)var7, p_70107_3_ + (double)var8, p_70107_5_ + (double)var7));
   }

   public void func_70082_c(float p_70082_1_, float p_70082_2_) {
      float var3 = this.field_70125_A;
      float var4 = this.field_70177_z;
      this.field_70177_z = (float)((double)this.field_70177_z + (double)p_70082_1_ * 0.15D);
      this.field_70125_A = (float)((double)this.field_70125_A - (double)p_70082_2_ * 0.15D);
      this.field_70125_A = MathHelper.func_76131_a(this.field_70125_A, -90.0F, 90.0F);
      this.field_70127_C += this.field_70125_A - var3;
      this.field_70126_B += this.field_70177_z - var4;
   }

   public void func_70071_h_() {
      this.func_70030_z();
   }

   public void func_70030_z() {
      this.field_70170_p.field_72984_F.func_76320_a("entityBaseTick");
      if(this.field_70154_o != null && this.field_70154_o.field_70128_L) {
         this.field_70154_o = null;
      }

      this.field_70141_P = this.field_70140_Q;
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      this.field_70127_C = this.field_70125_A;
      this.field_70126_B = this.field_70177_z;
      if(!this.field_70170_p.field_72995_K && this.field_70170_p instanceof WorldServer) {
         this.field_70170_p.field_72984_F.func_76320_a("portal");
         MinecraftServer var1 = ((WorldServer)this.field_70170_p).func_73046_m();
         int var2 = this.func_82145_z();
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

      this.func_174830_Y();
      this.func_70072_I();
      if(this.field_70170_p.field_72995_K) {
         this.field_70151_c = 0;
      } else if(this.field_70151_c > 0) {
         if(this.field_70178_ae) {
            this.field_70151_c -= 4;
            if(this.field_70151_c < 0) {
               this.field_70151_c = 0;
            }
         } else {
            if(this.field_70151_c % 20 == 0) {
               this.func_70097_a(DamageSource.field_76370_b, 1.0F);
            }

            --this.field_70151_c;
         }
      }

      if(this.func_180799_ab()) {
         this.func_70044_A();
         this.field_70143_R *= 0.5F;
      }

      if(this.field_70163_u < -64.0D) {
         this.func_70076_C();
      }

      if(!this.field_70170_p.field_72995_K) {
         this.func_70052_a(0, this.field_70151_c > 0);
      }

      this.field_70148_d = false;
      this.field_70170_p.field_72984_F.func_76319_b();
   }

   public int func_82145_z() {
      return 0;
   }

   protected void func_70044_A() {
      if(!this.field_70178_ae) {
         this.func_70097_a(DamageSource.field_76371_c, 4.0F);
         this.func_70015_d(15);
      }
   }

   public void func_70015_d(int p_70015_1_) {
      int var2 = p_70015_1_ * 20;
      var2 = EnchantmentProtection.func_92093_a(this, var2);
      if(this.field_70151_c < var2) {
         this.field_70151_c = var2;
      }

   }

   public void func_70066_B() {
      this.field_70151_c = 0;
   }

   protected void func_70076_C() {
      this.func_70106_y();
   }

   public boolean func_70038_c(double p_70038_1_, double p_70038_3_, double p_70038_5_) {
      AxisAlignedBB var7 = this.func_174813_aQ().func_72317_d(p_70038_1_, p_70038_3_, p_70038_5_);
      return this.func_174809_b(var7);
   }

   private boolean func_174809_b(AxisAlignedBB p_174809_1_) {
      return this.field_70170_p.func_72945_a(this, p_174809_1_).isEmpty() && !this.field_70170_p.func_72953_d(p_174809_1_);
   }

   public void func_70091_d(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
      if(this.field_70145_X) {
         this.func_174826_a(this.func_174813_aQ().func_72317_d(p_70091_1_, p_70091_3_, p_70091_5_));
         this.func_174829_m();
      } else {
         this.field_70170_p.field_72984_F.func_76320_a("move");
         double var7 = this.field_70165_t;
         double var9 = this.field_70163_u;
         double var11 = this.field_70161_v;
         if(this.field_70134_J) {
            this.field_70134_J = false;
            p_70091_1_ *= 0.25D;
            p_70091_3_ *= 0.05000000074505806D;
            p_70091_5_ *= 0.25D;
            this.field_70159_w = 0.0D;
            this.field_70181_x = 0.0D;
            this.field_70179_y = 0.0D;
         }

         double var13 = p_70091_1_;
         double var15 = p_70091_3_;
         double var17 = p_70091_5_;
         boolean var19 = this.field_70122_E && this.func_70093_af() && this instanceof EntityPlayer;
         if(var19) {
            double var20;
            for(var20 = 0.05D; p_70091_1_ != 0.0D && this.field_70170_p.func_72945_a(this, this.func_174813_aQ().func_72317_d(p_70091_1_, -1.0D, 0.0D)).isEmpty(); var13 = p_70091_1_) {
               if(p_70091_1_ < var20 && p_70091_1_ >= -var20) {
                  p_70091_1_ = 0.0D;
               } else if(p_70091_1_ > 0.0D) {
                  p_70091_1_ -= var20;
               } else {
                  p_70091_1_ += var20;
               }
            }

            for(; p_70091_5_ != 0.0D && this.field_70170_p.func_72945_a(this, this.func_174813_aQ().func_72317_d(0.0D, -1.0D, p_70091_5_)).isEmpty(); var17 = p_70091_5_) {
               if(p_70091_5_ < var20 && p_70091_5_ >= -var20) {
                  p_70091_5_ = 0.0D;
               } else if(p_70091_5_ > 0.0D) {
                  p_70091_5_ -= var20;
               } else {
                  p_70091_5_ += var20;
               }
            }

            for(; p_70091_1_ != 0.0D && p_70091_5_ != 0.0D && this.field_70170_p.func_72945_a(this, this.func_174813_aQ().func_72317_d(p_70091_1_, -1.0D, p_70091_5_)).isEmpty(); var17 = p_70091_5_) {
               if(p_70091_1_ < var20 && p_70091_1_ >= -var20) {
                  p_70091_1_ = 0.0D;
               } else if(p_70091_1_ > 0.0D) {
                  p_70091_1_ -= var20;
               } else {
                  p_70091_1_ += var20;
               }

               var13 = p_70091_1_;
               if(p_70091_5_ < var20 && p_70091_5_ >= -var20) {
                  p_70091_5_ = 0.0D;
               } else if(p_70091_5_ > 0.0D) {
                  p_70091_5_ -= var20;
               } else {
                  p_70091_5_ += var20;
               }
            }
         }

         List var53 = this.field_70170_p.func_72945_a(this, this.func_174813_aQ().func_72321_a(p_70091_1_, p_70091_3_, p_70091_5_));
         AxisAlignedBB var21 = this.func_174813_aQ();

         AxisAlignedBB var23;
         for(Iterator var22 = var53.iterator(); var22.hasNext(); p_70091_3_ = var23.func_72323_b(this.func_174813_aQ(), p_70091_3_)) {
            var23 = (AxisAlignedBB)var22.next();
         }

         this.func_174826_a(this.func_174813_aQ().func_72317_d(0.0D, p_70091_3_, 0.0D));
         boolean var54 = this.field_70122_E || var15 != p_70091_3_ && var15 < 0.0D;

         AxisAlignedBB var24;
         Iterator var55;
         for(var55 = var53.iterator(); var55.hasNext(); p_70091_1_ = var24.func_72316_a(this.func_174813_aQ(), p_70091_1_)) {
            var24 = (AxisAlignedBB)var55.next();
         }

         this.func_174826_a(this.func_174813_aQ().func_72317_d(p_70091_1_, 0.0D, 0.0D));

         for(var55 = var53.iterator(); var55.hasNext(); p_70091_5_ = var24.func_72322_c(this.func_174813_aQ(), p_70091_5_)) {
            var24 = (AxisAlignedBB)var55.next();
         }

         this.func_174826_a(this.func_174813_aQ().func_72317_d(0.0D, 0.0D, p_70091_5_));
         if(this.field_70138_W > 0.0F && var54 && (var13 != p_70091_1_ || var17 != p_70091_5_)) {
            double var56 = p_70091_1_;
            double var25 = p_70091_3_;
            double var27 = p_70091_5_;
            AxisAlignedBB var29 = this.func_174813_aQ();
            this.func_174826_a(var21);
            p_70091_3_ = (double)this.field_70138_W;
            List var30 = this.field_70170_p.func_72945_a(this, this.func_174813_aQ().func_72321_a(var13, p_70091_3_, var17));
            AxisAlignedBB var31 = this.func_174813_aQ();
            AxisAlignedBB var32 = var31.func_72321_a(var13, 0.0D, var17);
            double var33 = p_70091_3_;

            AxisAlignedBB var36;
            for(Iterator var35 = var30.iterator(); var35.hasNext(); var33 = var36.func_72323_b(var32, var33)) {
               var36 = (AxisAlignedBB)var35.next();
            }

            var31 = var31.func_72317_d(0.0D, var33, 0.0D);
            double var67 = var13;

            AxisAlignedBB var38;
            for(Iterator var37 = var30.iterator(); var37.hasNext(); var67 = var38.func_72316_a(var31, var67)) {
               var38 = (AxisAlignedBB)var37.next();
            }

            var31 = var31.func_72317_d(var67, 0.0D, 0.0D);
            double var68 = var17;

            AxisAlignedBB var40;
            for(Iterator var39 = var30.iterator(); var39.hasNext(); var68 = var40.func_72322_c(var31, var68)) {
               var40 = (AxisAlignedBB)var39.next();
            }

            var31 = var31.func_72317_d(0.0D, 0.0D, var68);
            AxisAlignedBB var69 = this.func_174813_aQ();
            double var70 = p_70091_3_;

            AxisAlignedBB var43;
            for(Iterator var42 = var30.iterator(); var42.hasNext(); var70 = var43.func_72323_b(var69, var70)) {
               var43 = (AxisAlignedBB)var42.next();
            }

            var69 = var69.func_72317_d(0.0D, var70, 0.0D);
            double var71 = var13;

            AxisAlignedBB var45;
            for(Iterator var44 = var30.iterator(); var44.hasNext(); var71 = var45.func_72316_a(var69, var71)) {
               var45 = (AxisAlignedBB)var44.next();
            }

            var69 = var69.func_72317_d(var71, 0.0D, 0.0D);
            double var72 = var17;

            AxisAlignedBB var47;
            for(Iterator var46 = var30.iterator(); var46.hasNext(); var72 = var47.func_72322_c(var69, var72)) {
               var47 = (AxisAlignedBB)var46.next();
            }

            var69 = var69.func_72317_d(0.0D, 0.0D, var72);
            double var73 = var67 * var67 + var68 * var68;
            double var48 = var71 * var71 + var72 * var72;
            if(var73 > var48) {
               p_70091_1_ = var67;
               p_70091_5_ = var68;
               this.func_174826_a(var31);
            } else {
               p_70091_1_ = var71;
               p_70091_5_ = var72;
               this.func_174826_a(var69);
            }

            p_70091_3_ = (double)(-this.field_70138_W);

            AxisAlignedBB var51;
            for(Iterator var50 = var30.iterator(); var50.hasNext(); p_70091_3_ = var51.func_72323_b(this.func_174813_aQ(), p_70091_3_)) {
               var51 = (AxisAlignedBB)var50.next();
            }

            this.func_174826_a(this.func_174813_aQ().func_72317_d(0.0D, p_70091_3_, 0.0D));
            if(var56 * var56 + var27 * var27 >= p_70091_1_ * p_70091_1_ + p_70091_5_ * p_70091_5_) {
               p_70091_1_ = var56;
               p_70091_3_ = var25;
               p_70091_5_ = var27;
               this.func_174826_a(var29);
            }
         }

         this.field_70170_p.field_72984_F.func_76319_b();
         this.field_70170_p.field_72984_F.func_76320_a("rest");
         this.func_174829_m();
         this.field_70123_F = var13 != p_70091_1_ || var17 != p_70091_5_;
         this.field_70124_G = var15 != p_70091_3_;
         this.field_70122_E = this.field_70124_G && var15 < 0.0D;
         this.field_70132_H = this.field_70123_F || this.field_70124_G;
         int var57 = MathHelper.func_76128_c(this.field_70165_t);
         int var58 = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D);
         int var59 = MathHelper.func_76128_c(this.field_70161_v);
         BlockPos var26 = new BlockPos(var57, var58, var59);
         Block var60 = this.field_70170_p.func_180495_p(var26).func_177230_c();
         if(var60.func_149688_o() == Material.field_151579_a) {
            Block var28 = this.field_70170_p.func_180495_p(var26.func_177977_b()).func_177230_c();
            if(var28 instanceof BlockFence || var28 instanceof BlockWall || var28 instanceof BlockFenceGate) {
               var60 = var28;
               var26 = var26.func_177977_b();
            }
         }

         this.func_180433_a(p_70091_3_, this.field_70122_E, var60, var26);
         if(var13 != p_70091_1_) {
            this.field_70159_w = 0.0D;
         }

         if(var17 != p_70091_5_) {
            this.field_70179_y = 0.0D;
         }

         if(var15 != p_70091_3_) {
            var60.func_176216_a(this.field_70170_p, this);
         }

         if(this.func_70041_e_() && !var19 && this.field_70154_o == null) {
            double var61 = this.field_70165_t - var7;
            double var64 = this.field_70163_u - var9;
            double var66 = this.field_70161_v - var11;
            if(var60 != Blocks.field_150468_ap) {
               var64 = 0.0D;
            }

            if(var60 != null && this.field_70122_E) {
               var60.func_176199_a(this.field_70170_p, var26, this);
            }

            this.field_70140_Q = (float)((double)this.field_70140_Q + (double)MathHelper.func_76133_a(var61 * var61 + var66 * var66) * 0.6D);
            this.field_82151_R = (float)((double)this.field_82151_R + (double)MathHelper.func_76133_a(var61 * var61 + var64 * var64 + var66 * var66) * 0.6D);
            if(this.field_82151_R > (float)this.field_70150_b && var60.func_149688_o() != Material.field_151579_a) {
               this.field_70150_b = (int)this.field_82151_R + 1;
               if(this.func_70090_H()) {
                  float var34 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w * 0.20000000298023224D + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y * 0.20000000298023224D) * 0.35F;
                  if(var34 > 1.0F) {
                     var34 = 1.0F;
                  }

                  this.func_85030_a(this.func_145776_H(), var34, 1.0F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4F);
               }

               this.func_180429_a(var26, var60);
            }
         }

         try {
            this.func_145775_I();
         } catch (Throwable var52) {
            CrashReport var63 = CrashReport.func_85055_a(var52, "Checking entity block collision");
            CrashReportCategory var65 = var63.func_85058_a("Entity being checked for collision");
            this.func_85029_a(var65);
            throw new ReportedException(var63);
         }

         boolean var62 = this.func_70026_G();
         if(this.field_70170_p.func_147470_e(this.func_174813_aQ().func_72331_e(0.001D, 0.001D, 0.001D))) {
            this.func_70081_e(1);
            if(!var62) {
               ++this.field_70151_c;
               if(this.field_70151_c == 0) {
                  this.func_70015_d(8);
               }
            }
         } else if(this.field_70151_c <= 0) {
            this.field_70151_c = -this.field_70174_ab;
         }

         if(var62 && this.field_70151_c > 0) {
            this.func_85030_a("random.fizz", 0.7F, 1.6F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4F);
            this.field_70151_c = -this.field_70174_ab;
         }

         this.field_70170_p.field_72984_F.func_76319_b();
      }
   }

   private void func_174829_m() {
      this.field_70165_t = (this.func_174813_aQ().field_72340_a + this.func_174813_aQ().field_72336_d) / 2.0D;
      this.field_70163_u = this.func_174813_aQ().field_72338_b;
      this.field_70161_v = (this.func_174813_aQ().field_72339_c + this.func_174813_aQ().field_72334_f) / 2.0D;
   }

   protected String func_145776_H() {
      return "game.neutral.swim";
   }

   protected void func_145775_I() {
      BlockPos var1 = new BlockPos(this.func_174813_aQ().field_72340_a + 0.001D, this.func_174813_aQ().field_72338_b + 0.001D, this.func_174813_aQ().field_72339_c + 0.001D);
      BlockPos var2 = new BlockPos(this.func_174813_aQ().field_72336_d - 0.001D, this.func_174813_aQ().field_72337_e - 0.001D, this.func_174813_aQ().field_72334_f - 0.001D);
      if(this.field_70170_p.func_175707_a(var1, var2)) {
         for(int var3 = var1.func_177958_n(); var3 <= var2.func_177958_n(); ++var3) {
            for(int var4 = var1.func_177956_o(); var4 <= var2.func_177956_o(); ++var4) {
               for(int var5 = var1.func_177952_p(); var5 <= var2.func_177952_p(); ++var5) {
                  BlockPos var6 = new BlockPos(var3, var4, var5);
                  IBlockState var7 = this.field_70170_p.func_180495_p(var6);

                  try {
                     var7.func_177230_c().func_180634_a(this.field_70170_p, var6, var7, this);
                  } catch (Throwable var11) {
                     CrashReport var9 = CrashReport.func_85055_a(var11, "Colliding entity with block");
                     CrashReportCategory var10 = var9.func_85058_a("Block being collided with");
                     CrashReportCategory.func_175750_a(var10, var6, var7);
                     throw new ReportedException(var9);
                  }
               }
            }
         }
      }

   }

   protected void func_180429_a(BlockPos p_180429_1_, Block p_180429_2_) {
      Block.SoundType var3 = p_180429_2_.field_149762_H;
      if(this.field_70170_p.func_180495_p(p_180429_1_.func_177984_a()).func_177230_c() == Blocks.field_150431_aC) {
         var3 = Blocks.field_150431_aC.field_149762_H;
         this.func_85030_a(var3.func_150498_e(), var3.func_150497_c() * 0.15F, var3.func_150494_d());
      } else if(!p_180429_2_.func_149688_o().func_76224_d()) {
         this.func_85030_a(var3.func_150498_e(), var3.func_150497_c() * 0.15F, var3.func_150494_d());
      }

   }

   public void func_85030_a(String p_85030_1_, float p_85030_2_, float p_85030_3_) {
      if(!this.func_174814_R()) {
         this.field_70170_p.func_72956_a(this, p_85030_1_, p_85030_2_, p_85030_3_);
      }

   }

   public boolean func_174814_R() {
      return this.field_70180_af.func_75683_a(4) == 1;
   }

   public void func_174810_b(boolean p_174810_1_) {
      this.field_70180_af.func_75692_b(4, Byte.valueOf((byte)(p_174810_1_?1:0)));
   }

   protected boolean func_70041_e_() {
      return true;
   }

   protected void func_180433_a(double p_180433_1_, boolean p_180433_3_, Block p_180433_4_, BlockPos p_180433_5_) {
      if(p_180433_3_) {
         if(this.field_70143_R > 0.0F) {
            if(p_180433_4_ != null) {
               p_180433_4_.func_180658_a(this.field_70170_p, p_180433_5_, this, this.field_70143_R);
            } else {
               this.func_180430_e(this.field_70143_R, 1.0F);
            }

            this.field_70143_R = 0.0F;
         }
      } else if(p_180433_1_ < 0.0D) {
         this.field_70143_R = (float)((double)this.field_70143_R - p_180433_1_);
      }

   }

   public AxisAlignedBB func_70046_E() {
      return null;
   }

   protected void func_70081_e(int p_70081_1_) {
      if(!this.field_70178_ae) {
         this.func_70097_a(DamageSource.field_76372_a, (float)p_70081_1_);
      }

   }

   public final boolean func_70045_F() {
      return this.field_70178_ae;
   }

   public void func_180430_e(float p_180430_1_, float p_180430_2_) {
      if(this.field_70153_n != null) {
         this.field_70153_n.func_180430_e(p_180430_1_, p_180430_2_);
      }

   }

   public boolean func_70026_G() {
      return this.field_70171_ac || this.field_70170_p.func_175727_C(new BlockPos(this.field_70165_t, this.field_70163_u, this.field_70161_v)) || this.field_70170_p.func_175727_C(new BlockPos(this.field_70165_t, this.field_70163_u + (double)this.field_70131_O, this.field_70161_v));
   }

   public boolean func_70090_H() {
      return this.field_70171_ac;
   }

   public boolean func_70072_I() {
      if(this.field_70170_p.func_72918_a(this.func_174813_aQ().func_72314_b(0.0D, -0.4000000059604645D, 0.0D).func_72331_e(0.001D, 0.001D, 0.001D), Material.field_151586_h, this)) {
         if(!this.field_70171_ac && !this.field_70148_d) {
            this.func_71061_d_();
         }

         this.field_70143_R = 0.0F;
         this.field_70171_ac = true;
         this.field_70151_c = 0;
      } else {
         this.field_70171_ac = false;
      }

      return this.field_70171_ac;
   }

   protected void func_71061_d_() {
      float var1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w * 0.20000000298023224D + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y * 0.20000000298023224D) * 0.2F;
      if(var1 > 1.0F) {
         var1 = 1.0F;
      }

      this.func_85030_a(this.func_145777_O(), var1, 1.0F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4F);
      float var2 = (float)MathHelper.func_76128_c(this.func_174813_aQ().field_72338_b);

      int var3;
      float var4;
      float var5;
      for(var3 = 0; (float)var3 < 1.0F + this.field_70130_N * 20.0F; ++var3) {
         var4 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
         var5 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
         this.field_70170_p.func_175688_a(EnumParticleTypes.WATER_BUBBLE, this.field_70165_t + (double)var4, (double)(var2 + 1.0F), this.field_70161_v + (double)var5, this.field_70159_w, this.field_70181_x - (double)(this.field_70146_Z.nextFloat() * 0.2F), this.field_70179_y, new int[0]);
      }

      for(var3 = 0; (float)var3 < 1.0F + this.field_70130_N * 20.0F; ++var3) {
         var4 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
         var5 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
         this.field_70170_p.func_175688_a(EnumParticleTypes.WATER_SPLASH, this.field_70165_t + (double)var4, (double)(var2 + 1.0F), this.field_70161_v + (double)var5, this.field_70159_w, this.field_70181_x, this.field_70179_y, new int[0]);
      }

   }

   public void func_174830_Y() {
      if(this.func_70051_ag() && !this.func_70090_H()) {
         this.func_174808_Z();
      }

   }

   protected void func_174808_Z() {
      int var1 = MathHelper.func_76128_c(this.field_70165_t);
      int var2 = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D);
      int var3 = MathHelper.func_76128_c(this.field_70161_v);
      BlockPos var4 = new BlockPos(var1, var2, var3);
      IBlockState var5 = this.field_70170_p.func_180495_p(var4);
      Block var6 = var5.func_177230_c();
      if(var6.func_149645_b() != -1) {
         this.field_70170_p.func_175688_a(EnumParticleTypes.BLOCK_CRACK, this.field_70165_t + ((double)this.field_70146_Z.nextFloat() - 0.5D) * (double)this.field_70130_N, this.func_174813_aQ().field_72338_b + 0.1D, this.field_70161_v + ((double)this.field_70146_Z.nextFloat() - 0.5D) * (double)this.field_70130_N, -this.field_70159_w * 4.0D, 1.5D, -this.field_70179_y * 4.0D, new int[]{Block.func_176210_f(var5)});
      }

   }

   protected String func_145777_O() {
      return "game.neutral.swim.splash";
   }

   public boolean func_70055_a(Material p_70055_1_) {
      double var2 = this.field_70163_u + (double)this.func_70047_e();
      BlockPos var4 = new BlockPos(this.field_70165_t, var2, this.field_70161_v);
      IBlockState var5 = this.field_70170_p.func_180495_p(var4);
      Block var6 = var5.func_177230_c();
      if(var6.func_149688_o() == p_70055_1_) {
         float var7 = BlockLiquid.func_149801_b(var5.func_177230_c().func_176201_c(var5)) - 0.11111111F;
         float var8 = (float)(var4.func_177956_o() + 1) - var7;
         boolean var9 = var2 < (double)var8;
         return !var9 && this instanceof EntityPlayer?false:var9;
      } else {
         return false;
      }
   }

   public boolean func_180799_ab() {
      return this.field_70170_p.func_72875_a(this.func_174813_aQ().func_72314_b(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.field_151587_i);
   }

   public void func_70060_a(float p_70060_1_, float p_70060_2_, float p_70060_3_) {
      float var4 = p_70060_1_ * p_70060_1_ + p_70060_2_ * p_70060_2_;
      if(var4 >= 1.0E-4F) {
         var4 = MathHelper.func_76129_c(var4);
         if(var4 < 1.0F) {
            var4 = 1.0F;
         }

         var4 = p_70060_3_ / var4;
         p_70060_1_ *= var4;
         p_70060_2_ *= var4;
         float var5 = MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F);
         float var6 = MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F);
         this.field_70159_w += (double)(p_70060_1_ * var6 - p_70060_2_ * var5);
         this.field_70179_y += (double)(p_70060_2_ * var6 + p_70060_1_ * var5);
      }
   }

   public int func_70070_b(float p_70070_1_) {
      BlockPos var2 = new BlockPos(this.field_70165_t, 0.0D, this.field_70161_v);
      if(this.field_70170_p.func_175667_e(var2)) {
         double var3 = (this.func_174813_aQ().field_72337_e - this.func_174813_aQ().field_72338_b) * 0.66D;
         int var5 = MathHelper.func_76128_c(this.field_70163_u + var3);
         return this.field_70170_p.func_175626_b(var2.func_177981_b(var5), 0);
      } else {
         return 0;
      }
   }

   public float func_70013_c(float p_70013_1_) {
      BlockPos var2 = new BlockPos(this.field_70165_t, 0.0D, this.field_70161_v);
      if(this.field_70170_p.func_175667_e(var2)) {
         double var3 = (this.func_174813_aQ().field_72337_e - this.func_174813_aQ().field_72338_b) * 0.66D;
         int var5 = MathHelper.func_76128_c(this.field_70163_u + var3);
         return this.field_70170_p.func_175724_o(var2.func_177981_b(var5));
      } else {
         return 0.0F;
      }
   }

   public void func_70029_a(World p_70029_1_) {
      this.field_70170_p = p_70029_1_;
   }

   public void func_70080_a(double p_70080_1_, double p_70080_3_, double p_70080_5_, float p_70080_7_, float p_70080_8_) {
      this.field_70169_q = this.field_70165_t = p_70080_1_;
      this.field_70167_r = this.field_70163_u = p_70080_3_;
      this.field_70166_s = this.field_70161_v = p_70080_5_;
      this.field_70126_B = this.field_70177_z = p_70080_7_;
      this.field_70127_C = this.field_70125_A = p_70080_8_;
      double var9 = (double)(this.field_70126_B - p_70080_7_);
      if(var9 < -180.0D) {
         this.field_70126_B += 360.0F;
      }

      if(var9 >= 180.0D) {
         this.field_70126_B -= 360.0F;
      }

      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.func_70101_b(p_70080_7_, p_70080_8_);
   }

   public void func_174828_a(BlockPos p_174828_1_, float p_174828_2_, float p_174828_3_) {
      this.func_70012_b((double)p_174828_1_.func_177958_n() + 0.5D, (double)p_174828_1_.func_177956_o(), (double)p_174828_1_.func_177952_p() + 0.5D, p_174828_2_, p_174828_3_);
   }

   public void func_70012_b(double p_70012_1_, double p_70012_3_, double p_70012_5_, float p_70012_7_, float p_70012_8_) {
      this.field_70142_S = this.field_70169_q = this.field_70165_t = p_70012_1_;
      this.field_70137_T = this.field_70167_r = this.field_70163_u = p_70012_3_;
      this.field_70136_U = this.field_70166_s = this.field_70161_v = p_70012_5_;
      this.field_70177_z = p_70012_7_;
      this.field_70125_A = p_70012_8_;
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
   }

   public float func_70032_d(Entity p_70032_1_) {
      float var2 = (float)(this.field_70165_t - p_70032_1_.field_70165_t);
      float var3 = (float)(this.field_70163_u - p_70032_1_.field_70163_u);
      float var4 = (float)(this.field_70161_v - p_70032_1_.field_70161_v);
      return MathHelper.func_76129_c(var2 * var2 + var3 * var3 + var4 * var4);
   }

   public double func_70092_e(double p_70092_1_, double p_70092_3_, double p_70092_5_) {
      double var7 = this.field_70165_t - p_70092_1_;
      double var9 = this.field_70163_u - p_70092_3_;
      double var11 = this.field_70161_v - p_70092_5_;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public double func_174818_b(BlockPos p_174818_1_) {
      return p_174818_1_.func_177954_c(this.field_70165_t, this.field_70163_u, this.field_70161_v);
   }

   public double func_174831_c(BlockPos p_174831_1_) {
      return p_174831_1_.func_177957_d(this.field_70165_t, this.field_70163_u, this.field_70161_v);
   }

   public double func_70011_f(double p_70011_1_, double p_70011_3_, double p_70011_5_) {
      double var7 = this.field_70165_t - p_70011_1_;
      double var9 = this.field_70163_u - p_70011_3_;
      double var11 = this.field_70161_v - p_70011_5_;
      return (double)MathHelper.func_76133_a(var7 * var7 + var9 * var9 + var11 * var11);
   }

   public double func_70068_e(Entity p_70068_1_) {
      double var2 = this.field_70165_t - p_70068_1_.field_70165_t;
      double var4 = this.field_70163_u - p_70068_1_.field_70163_u;
      double var6 = this.field_70161_v - p_70068_1_.field_70161_v;
      return var2 * var2 + var4 * var4 + var6 * var6;
   }

   public void func_70100_b_(EntityPlayer p_70100_1_) {}

   public void func_70108_f(Entity p_70108_1_) {
      if(p_70108_1_.field_70153_n != this && p_70108_1_.field_70154_o != this) {
         if(!p_70108_1_.field_70145_X && !this.field_70145_X) {
            double var2 = p_70108_1_.field_70165_t - this.field_70165_t;
            double var4 = p_70108_1_.field_70161_v - this.field_70161_v;
            double var6 = MathHelper.func_76132_a(var2, var4);
            if(var6 >= 0.009999999776482582D) {
               var6 = (double)MathHelper.func_76133_a(var6);
               var2 /= var6;
               var4 /= var6;
               double var8 = 1.0D / var6;
               if(var8 > 1.0D) {
                  var8 = 1.0D;
               }

               var2 *= var8;
               var4 *= var8;
               var2 *= 0.05000000074505806D;
               var4 *= 0.05000000074505806D;
               var2 *= (double)(1.0F - this.field_70144_Y);
               var4 *= (double)(1.0F - this.field_70144_Y);
               if(this.field_70153_n == null) {
                  this.func_70024_g(-var2, 0.0D, -var4);
               }

               if(p_70108_1_.field_70153_n == null) {
                  p_70108_1_.func_70024_g(var2, 0.0D, var4);
               }
            }

         }
      }
   }

   public void func_70024_g(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
      this.field_70159_w += p_70024_1_;
      this.field_70181_x += p_70024_3_;
      this.field_70179_y += p_70024_5_;
      this.field_70160_al = true;
   }

   protected void func_70018_K() {
      this.field_70133_I = true;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
      if(this.func_180431_b(p_70097_1_)) {
         return false;
      } else {
         this.func_70018_K();
         return false;
      }
   }

   public Vec3 func_70676_i(float p_70676_1_) {
      if(p_70676_1_ == 1.0F) {
         return this.func_174806_f(this.field_70125_A, this.field_70177_z);
      } else {
         float var2 = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * p_70676_1_;
         float var3 = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * p_70676_1_;
         return this.func_174806_f(var2, var3);
      }
   }

   protected final Vec3 func_174806_f(float p_174806_1_, float p_174806_2_) {
      float var3 = MathHelper.func_76134_b(-p_174806_2_ * 0.017453292F - 3.1415927F);
      float var4 = MathHelper.func_76126_a(-p_174806_2_ * 0.017453292F - 3.1415927F);
      float var5 = -MathHelper.func_76134_b(-p_174806_1_ * 0.017453292F);
      float var6 = MathHelper.func_76126_a(-p_174806_1_ * 0.017453292F);
      return new Vec3((double)(var4 * var5), (double)var6, (double)(var3 * var5));
   }

   public Vec3 func_174824_e(float p_174824_1_) {
      if(p_174824_1_ == 1.0F) {
         return new Vec3(this.field_70165_t, this.field_70163_u + (double)this.func_70047_e(), this.field_70161_v);
      } else {
         double var2 = this.field_70169_q + (this.field_70165_t - this.field_70169_q) * (double)p_174824_1_;
         double var4 = this.field_70167_r + (this.field_70163_u - this.field_70167_r) * (double)p_174824_1_ + (double)this.func_70047_e();
         double var6 = this.field_70166_s + (this.field_70161_v - this.field_70166_s) * (double)p_174824_1_;
         return new Vec3(var2, var4, var6);
      }
   }

   public MovingObjectPosition func_174822_a(double p_174822_1_, float p_174822_3_) {
      Vec3 var4 = this.func_174824_e(p_174822_3_);
      Vec3 var5 = this.func_70676_i(p_174822_3_);
      Vec3 var6 = var4.func_72441_c(var5.field_72450_a * p_174822_1_, var5.field_72448_b * p_174822_1_, var5.field_72449_c * p_174822_1_);
      return this.field_70170_p.func_147447_a(var4, var6, false, false, true);
   }

   public boolean func_70067_L() {
      return false;
   }

   public boolean func_70104_M() {
      return false;
   }

   public void func_70084_c(Entity p_70084_1_, int p_70084_2_) {}

   public boolean func_145770_h(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
      double var7 = this.field_70165_t - p_145770_1_;
      double var9 = this.field_70163_u - p_145770_3_;
      double var11 = this.field_70161_v - p_145770_5_;
      double var13 = var7 * var7 + var9 * var9 + var11 * var11;
      return this.func_70112_a(var13);
   }

   public boolean func_70112_a(double p_70112_1_) {
      double var3 = this.func_174813_aQ().func_72320_b();
      var3 *= 64.0D * this.field_70155_l;
      return p_70112_1_ < var3 * var3;
   }

   public boolean func_98035_c(NBTTagCompound p_98035_1_) {
      String var2 = this.func_70022_Q();
      if(!this.field_70128_L && var2 != null) {
         p_98035_1_.func_74778_a("id", var2);
         this.func_70109_d(p_98035_1_);
         return true;
      } else {
         return false;
      }
   }

   public boolean func_70039_c(NBTTagCompound p_70039_1_) {
      String var2 = this.func_70022_Q();
      if(!this.field_70128_L && var2 != null && this.field_70153_n == null) {
         p_70039_1_.func_74778_a("id", var2);
         this.func_70109_d(p_70039_1_);
         return true;
      } else {
         return false;
      }
   }

   public void func_70109_d(NBTTagCompound p_70109_1_) {
      try {
         p_70109_1_.func_74782_a("Pos", this.func_70087_a(new double[]{this.field_70165_t, this.field_70163_u, this.field_70161_v}));
         p_70109_1_.func_74782_a("Motion", this.func_70087_a(new double[]{this.field_70159_w, this.field_70181_x, this.field_70179_y}));
         p_70109_1_.func_74782_a("Rotation", this.func_70049_a(new float[]{this.field_70177_z, this.field_70125_A}));
         p_70109_1_.func_74776_a("FallDistance", this.field_70143_R);
         p_70109_1_.func_74777_a("Fire", (short)this.field_70151_c);
         p_70109_1_.func_74777_a("Air", (short)this.func_70086_ai());
         p_70109_1_.func_74757_a("OnGround", this.field_70122_E);
         p_70109_1_.func_74768_a("Dimension", this.field_71093_bK);
         p_70109_1_.func_74757_a("Invulnerable", this.field_83001_bt);
         p_70109_1_.func_74768_a("PortalCooldown", this.field_71088_bW);
         p_70109_1_.func_74772_a("UUIDMost", this.func_110124_au().getMostSignificantBits());
         p_70109_1_.func_74772_a("UUIDLeast", this.func_110124_au().getLeastSignificantBits());
         if(this.func_95999_t() != null && this.func_95999_t().length() > 0) {
            p_70109_1_.func_74778_a("CustomName", this.func_95999_t());
            p_70109_1_.func_74757_a("CustomNameVisible", this.func_174833_aM());
         }

         this.field_174837_as.func_179670_b(p_70109_1_);
         if(this.func_174814_R()) {
            p_70109_1_.func_74757_a("Silent", this.func_174814_R());
         }

         this.func_70014_b(p_70109_1_);
         if(this.field_70154_o != null) {
            NBTTagCompound var2 = new NBTTagCompound();
            if(this.field_70154_o.func_98035_c(var2)) {
               p_70109_1_.func_74782_a("Riding", var2);
            }
         }

      } catch (Throwable var5) {
         CrashReport var3 = CrashReport.func_85055_a(var5, "Saving entity NBT");
         CrashReportCategory var4 = var3.func_85058_a("Entity being saved");
         this.func_85029_a(var4);
         throw new ReportedException(var3);
      }
   }

   public void func_70020_e(NBTTagCompound p_70020_1_) {
      try {
         NBTTagList var2 = p_70020_1_.func_150295_c("Pos", 6);
         NBTTagList var6 = p_70020_1_.func_150295_c("Motion", 6);
         NBTTagList var7 = p_70020_1_.func_150295_c("Rotation", 5);
         this.field_70159_w = var6.func_150309_d(0);
         this.field_70181_x = var6.func_150309_d(1);
         this.field_70179_y = var6.func_150309_d(2);
         if(Math.abs(this.field_70159_w) > 10.0D) {
            this.field_70159_w = 0.0D;
         }

         if(Math.abs(this.field_70181_x) > 10.0D) {
            this.field_70181_x = 0.0D;
         }

         if(Math.abs(this.field_70179_y) > 10.0D) {
            this.field_70179_y = 0.0D;
         }

         this.field_70169_q = this.field_70142_S = this.field_70165_t = var2.func_150309_d(0);
         this.field_70167_r = this.field_70137_T = this.field_70163_u = var2.func_150309_d(1);
         this.field_70166_s = this.field_70136_U = this.field_70161_v = var2.func_150309_d(2);
         this.field_70126_B = this.field_70177_z = var7.func_150308_e(0);
         this.field_70127_C = this.field_70125_A = var7.func_150308_e(1);
         this.field_70143_R = p_70020_1_.func_74760_g("FallDistance");
         this.field_70151_c = p_70020_1_.func_74765_d("Fire");
         this.func_70050_g(p_70020_1_.func_74765_d("Air"));
         this.field_70122_E = p_70020_1_.func_74767_n("OnGround");
         this.field_71093_bK = p_70020_1_.func_74762_e("Dimension");
         this.field_83001_bt = p_70020_1_.func_74767_n("Invulnerable");
         this.field_71088_bW = p_70020_1_.func_74762_e("PortalCooldown");
         if(p_70020_1_.func_150297_b("UUIDMost", 4) && p_70020_1_.func_150297_b("UUIDLeast", 4)) {
            this.field_96093_i = new UUID(p_70020_1_.func_74763_f("UUIDMost"), p_70020_1_.func_74763_f("UUIDLeast"));
         } else if(p_70020_1_.func_150297_b("UUID", 8)) {
            this.field_96093_i = UUID.fromString(p_70020_1_.func_74779_i("UUID"));
         }

         this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         this.func_70101_b(this.field_70177_z, this.field_70125_A);
         if(p_70020_1_.func_150297_b("CustomName", 8) && p_70020_1_.func_74779_i("CustomName").length() > 0) {
            this.func_96094_a(p_70020_1_.func_74779_i("CustomName"));
         }

         this.func_174805_g(p_70020_1_.func_74767_n("CustomNameVisible"));
         this.field_174837_as.func_179668_a(p_70020_1_);
         this.func_174810_b(p_70020_1_.func_74767_n("Silent"));
         this.func_70037_a(p_70020_1_);
         if(this.func_142008_O()) {
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         }

      } catch (Throwable var5) {
         CrashReport var3 = CrashReport.func_85055_a(var5, "Loading entity NBT");
         CrashReportCategory var4 = var3.func_85058_a("Entity being loaded");
         this.func_85029_a(var4);
         throw new ReportedException(var3);
      }
   }

   protected boolean func_142008_O() {
      return true;
   }

   protected final String func_70022_Q() {
      return EntityList.func_75621_b(this);
   }

   protected abstract void func_70037_a(NBTTagCompound var1);

   protected abstract void func_70014_b(NBTTagCompound var1);

   public void func_110123_P() {}

   protected NBTTagList func_70087_a(double ... p_70087_1_) {
      NBTTagList var2 = new NBTTagList();
      double[] var3 = p_70087_1_;
      int var4 = p_70087_1_.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         double var6 = var3[var5];
         var2.func_74742_a(new NBTTagDouble(var6));
      }

      return var2;
   }

   protected NBTTagList func_70049_a(float ... p_70049_1_) {
      NBTTagList var2 = new NBTTagList();
      float[] var3 = p_70049_1_;
      int var4 = p_70049_1_.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         float var6 = var3[var5];
         var2.func_74742_a(new NBTTagFloat(var6));
      }

      return var2;
   }

   public EntityItem func_145779_a(Item p_145779_1_, int p_145779_2_) {
      return this.func_145778_a(p_145779_1_, p_145779_2_, 0.0F);
   }

   public EntityItem func_145778_a(Item p_145778_1_, int p_145778_2_, float p_145778_3_) {
      return this.func_70099_a(new ItemStack(p_145778_1_, p_145778_2_, 0), p_145778_3_);
   }

   public EntityItem func_70099_a(ItemStack p_70099_1_, float p_70099_2_) {
      if(p_70099_1_.field_77994_a != 0 && p_70099_1_.func_77973_b() != null) {
         EntityItem var3 = new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u + (double)p_70099_2_, this.field_70161_v, p_70099_1_);
         var3.func_174869_p();
         this.field_70170_p.func_72838_d(var3);
         return var3;
      } else {
         return null;
      }
   }

   public boolean func_70089_S() {
      return !this.field_70128_L;
   }

   public boolean func_70094_T() {
      if(this.field_70145_X) {
         return false;
      } else {
         for(int var1 = 0; var1 < 8; ++var1) {
            double var2 = this.field_70165_t + (double)(((float)((var1 >> 0) % 2) - 0.5F) * this.field_70130_N * 0.8F);
            double var4 = this.field_70163_u + (double)(((float)((var1 >> 1) % 2) - 0.5F) * 0.1F);
            double var6 = this.field_70161_v + (double)(((float)((var1 >> 2) % 2) - 0.5F) * this.field_70130_N * 0.8F);
            if(this.field_70170_p.func_180495_p(new BlockPos(var2, var4 + (double)this.func_70047_e(), var6)).func_177230_c().func_176214_u()) {
               return true;
            }
         }

         return false;
      }
   }

   public boolean func_130002_c(EntityPlayer p_130002_1_) {
      return false;
   }

   public AxisAlignedBB func_70114_g(Entity p_70114_1_) {
      return null;
   }

   public void func_70098_U() {
      if(this.field_70154_o.field_70128_L) {
         this.field_70154_o = null;
      } else {
         this.field_70159_w = 0.0D;
         this.field_70181_x = 0.0D;
         this.field_70179_y = 0.0D;
         this.func_70071_h_();
         if(this.field_70154_o != null) {
            this.field_70154_o.func_70043_V();
            this.field_70147_f += (double)(this.field_70154_o.field_70177_z - this.field_70154_o.field_70126_B);

            for(this.field_70149_e += (double)(this.field_70154_o.field_70125_A - this.field_70154_o.field_70127_C); this.field_70147_f >= 180.0D; this.field_70147_f -= 360.0D) {
               ;
            }

            while(this.field_70147_f < -180.0D) {
               this.field_70147_f += 360.0D;
            }

            while(this.field_70149_e >= 180.0D) {
               this.field_70149_e -= 360.0D;
            }

            while(this.field_70149_e < -180.0D) {
               this.field_70149_e += 360.0D;
            }

            double var1 = this.field_70147_f * 0.5D;
            double var3 = this.field_70149_e * 0.5D;
            float var5 = 10.0F;
            if(var1 > (double)var5) {
               var1 = (double)var5;
            }

            if(var1 < (double)(-var5)) {
               var1 = (double)(-var5);
            }

            if(var3 > (double)var5) {
               var3 = (double)var5;
            }

            if(var3 < (double)(-var5)) {
               var3 = (double)(-var5);
            }

            this.field_70147_f -= var1;
            this.field_70149_e -= var3;
         }
      }
   }

   public void func_70043_V() {
      if(this.field_70153_n != null) {
         this.field_70153_n.func_70107_b(this.field_70165_t, this.field_70163_u + this.func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v);
      }
   }

   public double func_70033_W() {
      return 0.0D;
   }

   public double func_70042_X() {
      return (double)this.field_70131_O * 0.75D;
   }

   public void func_70078_a(Entity p_70078_1_) {
      this.field_70149_e = 0.0D;
      this.field_70147_f = 0.0D;
      if(p_70078_1_ == null) {
         if(this.field_70154_o != null) {
            this.func_70012_b(this.field_70154_o.field_70165_t, this.field_70154_o.func_174813_aQ().field_72338_b + (double)this.field_70154_o.field_70131_O, this.field_70154_o.field_70161_v, this.field_70177_z, this.field_70125_A);
            this.field_70154_o.field_70153_n = null;
         }

         this.field_70154_o = null;
      } else {
         if(this.field_70154_o != null) {
            this.field_70154_o.field_70153_n = null;
         }

         if(p_70078_1_ != null) {
            for(Entity var2 = p_70078_1_.field_70154_o; var2 != null; var2 = var2.field_70154_o) {
               if(var2 == this) {
                  return;
               }
            }
         }

         this.field_70154_o = p_70078_1_;
         p_70078_1_.field_70153_n = this;
      }
   }

   public void func_180426_a(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
      this.func_70107_b(p_180426_1_, p_180426_3_, p_180426_5_);
      this.func_70101_b(p_180426_7_, p_180426_8_);
      List var11 = this.field_70170_p.func_72945_a(this, this.func_174813_aQ().func_72331_e(0.03125D, 0.0D, 0.03125D));
      if(!var11.isEmpty()) {
         double var12 = 0.0D;
         Iterator var14 = var11.iterator();

         while(var14.hasNext()) {
            AxisAlignedBB var15 = (AxisAlignedBB)var14.next();
            if(var15.field_72337_e > var12) {
               var12 = var15.field_72337_e;
            }
         }

         p_180426_3_ += var12 - this.func_174813_aQ().field_72338_b;
         this.func_70107_b(p_180426_1_, p_180426_3_, p_180426_5_);
      }

   }

   public float func_70111_Y() {
      return 0.1F;
   }

   public Vec3 func_70040_Z() {
      return null;
   }

   public void func_70063_aa() {
      if(this.field_71088_bW > 0) {
         this.field_71088_bW = this.func_82147_ab();
      } else {
         double var1 = this.field_70169_q - this.field_70165_t;
         double var3 = this.field_70166_s - this.field_70161_v;
         if(!this.field_70170_p.field_72995_K && !this.field_71087_bX) {
            int var5;
            if(MathHelper.func_76135_e((float)var1) > MathHelper.func_76135_e((float)var3)) {
               var5 = var1 > 0.0D?EnumFacing.WEST.func_176736_b():EnumFacing.EAST.func_176736_b();
            } else {
               var5 = var3 > 0.0D?EnumFacing.NORTH.func_176736_b():EnumFacing.SOUTH.func_176736_b();
            }

            this.field_82152_aq = var5;
         }

         this.field_71087_bX = true;
      }
   }

   public int func_82147_ab() {
      return 300;
   }

   public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
      this.field_70159_w = p_70016_1_;
      this.field_70181_x = p_70016_3_;
      this.field_70179_y = p_70016_5_;
   }

   public void func_70103_a(byte p_70103_1_) {}

   public void func_70057_ab() {}

   public ItemStack[] func_70035_c() {
      return null;
   }

   public void func_70062_b(int p_70062_1_, ItemStack p_70062_2_) {}

   public boolean func_70027_ad() {
      boolean var1 = this.field_70170_p != null && this.field_70170_p.field_72995_K;
      return !this.field_70178_ae && (this.field_70151_c > 0 || var1 && this.func_70083_f(0));
   }

   public boolean func_70115_ae() {
      return this.field_70154_o != null;
   }

   public boolean func_70093_af() {
      return this.func_70083_f(1);
   }

   public void func_70095_a(boolean p_70095_1_) {
      this.func_70052_a(1, p_70095_1_);
   }

   public boolean func_70051_ag() {
      return this.func_70083_f(3);
   }

   public void func_70031_b(boolean p_70031_1_) {
      this.func_70052_a(3, p_70031_1_);
   }

   public boolean func_82150_aj() {
      return this.func_70083_f(5);
   }

   public boolean func_98034_c(EntityPlayer p_98034_1_) {
      return p_98034_1_.func_175149_v()?false:this.func_82150_aj();
   }

   public void func_82142_c(boolean p_82142_1_) {
      this.func_70052_a(5, p_82142_1_);
   }

   public boolean func_70113_ah() {
      return this.func_70083_f(4);
   }

   public void func_70019_c(boolean p_70019_1_) {
      this.func_70052_a(4, p_70019_1_);
   }

   protected boolean func_70083_f(int p_70083_1_) {
      return (this.field_70180_af.func_75683_a(0) & 1 << p_70083_1_) != 0;
   }

   protected void func_70052_a(int p_70052_1_, boolean p_70052_2_) {
      byte var3 = this.field_70180_af.func_75683_a(0);
      if(p_70052_2_) {
         this.field_70180_af.func_75692_b(0, Byte.valueOf((byte)(var3 | 1 << p_70052_1_)));
      } else {
         this.field_70180_af.func_75692_b(0, Byte.valueOf((byte)(var3 & ~(1 << p_70052_1_))));
      }

   }

   public int func_70086_ai() {
      return this.field_70180_af.func_75693_b(1);
   }

   public void func_70050_g(int p_70050_1_) {
      this.field_70180_af.func_75692_b(1, Short.valueOf((short)p_70050_1_));
   }

   public void func_70077_a(EntityLightningBolt p_70077_1_) {
      this.func_70097_a(DamageSource.field_180137_b, 5.0F);
      ++this.field_70151_c;
      if(this.field_70151_c == 0) {
         this.func_70015_d(8);
      }

   }

   public void func_70074_a(EntityLivingBase p_70074_1_) {}

   protected boolean func_145771_j(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
      BlockPos var7 = new BlockPos(p_145771_1_, p_145771_3_, p_145771_5_);
      double var8 = p_145771_1_ - (double)var7.func_177958_n();
      double var10 = p_145771_3_ - (double)var7.func_177956_o();
      double var12 = p_145771_5_ - (double)var7.func_177952_p();
      List var14 = this.field_70170_p.func_147461_a(this.func_174813_aQ());
      if(var14.isEmpty() && !this.field_70170_p.func_175665_u(var7)) {
         return false;
      } else {
         byte var15 = 3;
         double var16 = 9999.0D;
         if(!this.field_70170_p.func_175665_u(var7.func_177976_e()) && var8 < var16) {
            var16 = var8;
            var15 = 0;
         }

         if(!this.field_70170_p.func_175665_u(var7.func_177974_f()) && 1.0D - var8 < var16) {
            var16 = 1.0D - var8;
            var15 = 1;
         }

         if(!this.field_70170_p.func_175665_u(var7.func_177984_a()) && 1.0D - var10 < var16) {
            var16 = 1.0D - var10;
            var15 = 3;
         }

         if(!this.field_70170_p.func_175665_u(var7.func_177978_c()) && var12 < var16) {
            var16 = var12;
            var15 = 4;
         }

         if(!this.field_70170_p.func_175665_u(var7.func_177968_d()) && 1.0D - var12 < var16) {
            var16 = 1.0D - var12;
            var15 = 5;
         }

         float var18 = this.field_70146_Z.nextFloat() * 0.2F + 0.1F;
         if(var15 == 0) {
            this.field_70159_w = (double)(-var18);
         }

         if(var15 == 1) {
            this.field_70159_w = (double)var18;
         }

         if(var15 == 3) {
            this.field_70181_x = (double)var18;
         }

         if(var15 == 4) {
            this.field_70179_y = (double)(-var18);
         }

         if(var15 == 5) {
            this.field_70179_y = (double)var18;
         }

         return true;
      }
   }

   public void func_70110_aj() {
      this.field_70134_J = true;
      this.field_70143_R = 0.0F;
   }

   public String func_70005_c_() {
      if(this.func_145818_k_()) {
         return this.func_95999_t();
      } else {
         String var1 = EntityList.func_75621_b(this);
         if(var1 == null) {
            var1 = "generic";
         }

         return StatCollector.func_74838_a("entity." + var1 + ".name");
      }
   }

   public Entity[] func_70021_al() {
      return null;
   }

   public boolean func_70028_i(Entity p_70028_1_) {
      return this == p_70028_1_;
   }

   public float func_70079_am() {
      return 0.0F;
   }

   public void func_70034_d(float p_70034_1_) {}

   public boolean func_70075_an() {
      return true;
   }

   public boolean func_85031_j(Entity p_85031_1_) {
      return false;
   }

   public String toString() {
      return String.format("%s[\'%s\'/%d, l=\'%s\', x=%.2f, y=%.2f, z=%.2f]", new Object[]{this.getClass().getSimpleName(), this.func_70005_c_(), Integer.valueOf(this.field_145783_c), this.field_70170_p == null?"~NULL~":this.field_70170_p.func_72912_H().func_76065_j(), Double.valueOf(this.field_70165_t), Double.valueOf(this.field_70163_u), Double.valueOf(this.field_70161_v)});
   }

   public boolean func_180431_b(DamageSource p_180431_1_) {
      return this.field_83001_bt && p_180431_1_ != DamageSource.field_76380_i && !p_180431_1_.func_180136_u();
   }

   public void func_82149_j(Entity p_82149_1_) {
      this.func_70012_b(p_82149_1_.field_70165_t, p_82149_1_.field_70163_u, p_82149_1_.field_70161_v, p_82149_1_.field_70177_z, p_82149_1_.field_70125_A);
   }

   public void func_180432_n(Entity p_180432_1_) {
      NBTTagCompound var2 = new NBTTagCompound();
      p_180432_1_.func_70109_d(var2);
      this.func_70020_e(var2);
      this.field_71088_bW = p_180432_1_.field_71088_bW;
      this.field_82152_aq = p_180432_1_.field_82152_aq;
   }

   public void func_71027_c(int p_71027_1_) {
      if(!this.field_70170_p.field_72995_K && !this.field_70128_L) {
         this.field_70170_p.field_72984_F.func_76320_a("changeDimension");
         MinecraftServer var2 = MinecraftServer.func_71276_C();
         int var3 = this.field_71093_bK;
         WorldServer var4 = var2.func_71218_a(var3);
         WorldServer var5 = var2.func_71218_a(p_71027_1_);
         this.field_71093_bK = p_71027_1_;
         if(var3 == 1 && p_71027_1_ == 1) {
            var5 = var2.func_71218_a(0);
            this.field_71093_bK = 0;
         }

         this.field_70170_p.func_72900_e(this);
         this.field_70128_L = false;
         this.field_70170_p.field_72984_F.func_76320_a("reposition");
         var2.func_71203_ab().func_82448_a(this, var3, var4, var5);
         this.field_70170_p.field_72984_F.func_76318_c("reloading");
         Entity var6 = EntityList.func_75620_a(EntityList.func_75621_b(this), var5);
         if(var6 != null) {
            var6.func_180432_n(this);
            if(var3 == 1 && p_71027_1_ == 1) {
               BlockPos var7 = this.field_70170_p.func_175672_r(var5.func_175694_M());
               var6.func_174828_a(var7, var6.field_70177_z, var6.field_70125_A);
            }

            var5.func_72838_d(var6);
         }

         this.field_70128_L = true;
         this.field_70170_p.field_72984_F.func_76319_b();
         var4.func_82742_i();
         var5.func_82742_i();
         this.field_70170_p.field_72984_F.func_76319_b();
      }
   }

   public float func_180428_a(Explosion p_180428_1_, World p_180428_2_, BlockPos p_180428_3_, IBlockState p_180428_4_) {
      return p_180428_4_.func_177230_c().func_149638_a(this);
   }

   public boolean func_174816_a(Explosion p_174816_1_, World p_174816_2_, BlockPos p_174816_3_, IBlockState p_174816_4_, float p_174816_5_) {
      return true;
   }

   public int func_82143_as() {
      return 3;
   }

   public int func_82148_at() {
      return this.field_82152_aq;
   }

   public boolean func_145773_az() {
      return false;
   }

   public void func_85029_a(CrashReportCategory p_85029_1_) {
      p_85029_1_.func_71500_a("Entity Type", new Callable() {

         private static final String __OBFID = "CL_00001534";

         public String call() {
            return EntityList.func_75621_b(Entity.this) + " (" + Entity.this.getClass().getCanonicalName() + ")";
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      p_85029_1_.func_71507_a("Entity ID", Integer.valueOf(this.field_145783_c));
      p_85029_1_.func_71500_a("Entity Name", new Callable() {

         private static final String __OBFID = "CL_00001535";

         public String call() {
            return Entity.this.func_70005_c_();
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      p_85029_1_.func_71507_a("Entity\'s Exact location", String.format("%.2f, %.2f, %.2f", new Object[]{Double.valueOf(this.field_70165_t), Double.valueOf(this.field_70163_u), Double.valueOf(this.field_70161_v)}));
      p_85029_1_.func_71507_a("Entity\'s Block location", CrashReportCategory.func_85074_a((double)MathHelper.func_76128_c(this.field_70165_t), (double)MathHelper.func_76128_c(this.field_70163_u), (double)MathHelper.func_76128_c(this.field_70161_v)));
      p_85029_1_.func_71507_a("Entity\'s Momentum", String.format("%.2f, %.2f, %.2f", new Object[]{Double.valueOf(this.field_70159_w), Double.valueOf(this.field_70181_x), Double.valueOf(this.field_70179_y)}));
      p_85029_1_.func_71500_a("Entity\'s Rider", new Callable() {

         private static final String __OBFID = "CL_00002259";

         public String func_180118_a() {
            return Entity.this.field_70153_n.toString();
         }
         // $FF: synthetic method
         public Object call() {
            return this.func_180118_a();
         }
      });
      p_85029_1_.func_71500_a("Entity\'s Vehicle", new Callable() {

         private static final String __OBFID = "CL_00002258";

         public String func_180116_a() {
            return Entity.this.field_70154_o.toString();
         }
         // $FF: synthetic method
         public Object call() {
            return this.func_180116_a();
         }
      });
   }

   public boolean func_90999_ad() {
      return this.func_70027_ad();
   }

   public UUID func_110124_au() {
      return this.field_96093_i;
   }

   public boolean func_96092_aw() {
      return true;
   }

   public IChatComponent func_145748_c_() {
      ChatComponentText var1 = new ChatComponentText(this.func_70005_c_());
      var1.func_150256_b().func_150209_a(this.func_174823_aP());
      var1.func_150256_b().func_179989_a(this.func_110124_au().toString());
      return var1;
   }

   public void func_96094_a(String p_96094_1_) {
      this.field_70180_af.func_75692_b(2, p_96094_1_);
   }

   public String func_95999_t() {
      return this.field_70180_af.func_75681_e(2);
   }

   public boolean func_145818_k_() {
      return this.field_70180_af.func_75681_e(2).length() > 0;
   }

   public void func_174805_g(boolean p_174805_1_) {
      this.field_70180_af.func_75692_b(3, Byte.valueOf((byte)(p_174805_1_?1:0)));
   }

   public boolean func_174833_aM() {
      return this.field_70180_af.func_75683_a(3) == 1;
   }

   public void func_70634_a(double p_70634_1_, double p_70634_3_, double p_70634_5_) {
      this.func_70012_b(p_70634_1_, p_70634_3_, p_70634_5_, this.field_70177_z, this.field_70125_A);
   }

   public boolean func_94059_bO() {
      return this.func_174833_aM();
   }

   public void func_145781_i(int p_145781_1_) {}

   public EnumFacing func_174811_aO() {
      return EnumFacing.func_176731_b(MathHelper.func_76128_c((double)(this.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3);
   }

   protected HoverEvent func_174823_aP() {
      NBTTagCompound var1 = new NBTTagCompound();
      String var2 = EntityList.func_75621_b(this);
      var1.func_74778_a("id", this.func_110124_au().toString());
      if(var2 != null) {
         var1.func_74778_a("type", var2);
      }

      var1.func_74778_a("name", this.func_70005_c_());
      return new HoverEvent(HoverEvent.Action.SHOW_ENTITY, new ChatComponentText(var1.toString()));
   }

   public boolean func_174827_a(EntityPlayerMP p_174827_1_) {
      return true;
   }

   public AxisAlignedBB func_174813_aQ() {
      return this.field_70121_D;
   }

   public void func_174826_a(AxisAlignedBB p_174826_1_) {
      this.field_70121_D = p_174826_1_;
   }

   public float func_70047_e() {
      return this.field_70131_O * 0.85F;
   }

   public boolean func_174832_aS() {
      return this.field_174835_g;
   }

   public void func_174821_h(boolean p_174821_1_) {
      this.field_174835_g = p_174821_1_;
   }

   public boolean func_174820_d(int p_174820_1_, ItemStack p_174820_2_) {
      return false;
   }

   public void func_145747_a(IChatComponent p_145747_1_) {}

   public boolean func_70003_b(int p_70003_1_, String p_70003_2_) {
      return true;
   }

   public BlockPos func_180425_c() {
      return new BlockPos(this.field_70165_t, this.field_70163_u + 0.5D, this.field_70161_v);
   }

   public Vec3 func_174791_d() {
      return new Vec3(this.field_70165_t, this.field_70163_u, this.field_70161_v);
   }

   public World func_130014_f_() {
      return this.field_70170_p;
   }

   public Entity func_174793_f() {
      return this;
   }

   public boolean func_174792_t_() {
      return false;
   }

   public void func_174794_a(CommandResultStats.Type p_174794_1_, int p_174794_2_) {
      this.field_174837_as.func_179672_a(this, p_174794_1_, p_174794_2_);
   }

   public CommandResultStats func_174807_aT() {
      return this.field_174837_as;
   }

   public void func_174817_o(Entity p_174817_1_) {
      this.field_174837_as.func_179671_a(p_174817_1_.func_174807_aT());
   }

   public NBTTagCompound func_174819_aU() {
      return null;
   }

   public void func_174834_g(NBTTagCompound p_174834_1_) {}

   public boolean func_174825_a(EntityPlayer p_174825_1_, Vec3 p_174825_2_) {
      return false;
   }

   public boolean func_180427_aV() {
      return false;
   }

   protected void func_174815_a(EntityLivingBase p_174815_1_, Entity p_174815_2_) {
      if(p_174815_2_ instanceof EntityLivingBase) {
         EnchantmentHelper.func_151384_a((EntityLivingBase)p_174815_2_, p_174815_1_);
      }

      EnchantmentHelper.func_151385_b(p_174815_1_, p_174815_2_);
   }

}
