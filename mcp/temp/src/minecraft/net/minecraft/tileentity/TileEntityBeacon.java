package net.minecraft.tileentity;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.stats.AchievementList;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;

public class TileEntityBeacon extends TileEntityLockable implements IUpdatePlayerListBox, IInventory {

   public static final Potion[][] field_146009_a = new Potion[][]{{Potion.field_76424_c, Potion.field_76422_e}, {Potion.field_76429_m, Potion.field_76430_j}, {Potion.field_76420_g}, {Potion.field_76428_l}};
   private final List field_174909_f = Lists.newArrayList();
   private long field_146016_i;
   private float field_146014_j;
   private boolean field_146015_k;
   private int field_146012_l = -1;
   private int field_146013_m;
   private int field_146010_n;
   private ItemStack field_146011_o;
   private String field_146008_p;
   private static final String __OBFID = "CL_00000339";


   public void func_73660_a() {
      if(this.field_145850_b.func_82737_E() % 80L == 0L) {
         this.func_174908_m();
      }

   }

   public void func_174908_m() {
      this.func_146003_y();
      this.func_146000_x();
   }

   private void func_146000_x() {
      if(this.field_146015_k && this.field_146012_l > 0 && !this.field_145850_b.field_72995_K && this.field_146013_m > 0) {
         double var1 = (double)(this.field_146012_l * 10 + 10);
         byte var3 = 0;
         if(this.field_146012_l >= 4 && this.field_146013_m == this.field_146010_n) {
            var3 = 1;
         }

         int var4 = this.field_174879_c.func_177958_n();
         int var5 = this.field_174879_c.func_177956_o();
         int var6 = this.field_174879_c.func_177952_p();
         AxisAlignedBB var7 = (new AxisAlignedBB((double)var4, (double)var5, (double)var6, (double)(var4 + 1), (double)(var5 + 1), (double)(var6 + 1))).func_72314_b(var1, var1, var1).func_72321_a(0.0D, (double)this.field_145850_b.func_72800_K(), 0.0D);
         List var8 = this.field_145850_b.func_72872_a(EntityPlayer.class, var7);
         Iterator var9 = var8.iterator();

         EntityPlayer var10;
         while(var9.hasNext()) {
            var10 = (EntityPlayer)var9.next();
            var10.func_70690_d(new PotionEffect(this.field_146013_m, 180, var3, true, true));
         }

         if(this.field_146012_l >= 4 && this.field_146013_m != this.field_146010_n && this.field_146010_n > 0) {
            var9 = var8.iterator();

            while(var9.hasNext()) {
               var10 = (EntityPlayer)var9.next();
               var10.func_70690_d(new PotionEffect(this.field_146010_n, 180, 0, true, true));
            }
         }
      }

   }

   private void func_146003_y() {
      int var1 = this.field_146012_l;
      int var2 = this.field_174879_c.func_177958_n();
      int var3 = this.field_174879_c.func_177956_o();
      int var4 = this.field_174879_c.func_177952_p();
      this.field_146012_l = 0;
      this.field_174909_f.clear();
      this.field_146015_k = true;
      TileEntityBeacon.BeamSegment var5 = new TileEntityBeacon.BeamSegment(EntitySheep.func_175513_a(EnumDyeColor.WHITE));
      this.field_174909_f.add(var5);
      boolean var6 = true;

      int var7;
      for(var7 = var3 + 1; var7 < this.field_145850_b.func_72940_L(); ++var7) {
         BlockPos var8 = new BlockPos(var2, var7, var4);
         IBlockState var9 = this.field_145850_b.func_180495_p(var8);
         float[] var10;
         if(var9.func_177230_c() == Blocks.field_150399_cn) {
            var10 = EntitySheep.func_175513_a((EnumDyeColor)var9.func_177229_b(BlockStainedGlass.field_176547_a));
         } else {
            if(var9.func_177230_c() != Blocks.field_150397_co) {
               if(var9.func_177230_c().func_149717_k() >= 15) {
                  this.field_146015_k = false;
                  this.field_174909_f.clear();
                  break;
               }

               var5.func_177262_a();
               continue;
            }

            var10 = EntitySheep.func_175513_a((EnumDyeColor)var9.func_177229_b(BlockStainedGlassPane.field_176245_a));
         }

         if(!var6) {
            var10 = new float[]{(var5.func_177263_b()[0] + var10[0]) / 2.0F, (var5.func_177263_b()[1] + var10[1]) / 2.0F, (var5.func_177263_b()[2] + var10[2]) / 2.0F};
         }

         if(Arrays.equals(var10, var5.func_177263_b())) {
            var5.func_177262_a();
         } else {
            var5 = new TileEntityBeacon.BeamSegment(var10);
            this.field_174909_f.add(var5);
         }

         var6 = false;
      }

      if(this.field_146015_k) {
         for(var7 = 1; var7 <= 4; this.field_146012_l = var7++) {
            int var14 = var3 - var7;
            if(var14 < 0) {
               break;
            }

            boolean var16 = true;

            for(int var17 = var2 - var7; var17 <= var2 + var7 && var16; ++var17) {
               for(int var11 = var4 - var7; var11 <= var4 + var7; ++var11) {
                  Block var12 = this.field_145850_b.func_180495_p(new BlockPos(var17, var14, var11)).func_177230_c();
                  if(var12 != Blocks.field_150475_bE && var12 != Blocks.field_150340_R && var12 != Blocks.field_150484_ah && var12 != Blocks.field_150339_S) {
                     var16 = false;
                     break;
                  }
               }
            }

            if(!var16) {
               break;
            }
         }

         if(this.field_146012_l == 0) {
            this.field_146015_k = false;
         }
      }

      if(!this.field_145850_b.field_72995_K && this.field_146012_l == 4 && var1 < this.field_146012_l) {
         Iterator var13 = this.field_145850_b.func_72872_a(EntityPlayer.class, (new AxisAlignedBB((double)var2, (double)var3, (double)var4, (double)var2, (double)(var3 - 4), (double)var4)).func_72314_b(10.0D, 5.0D, 10.0D)).iterator();

         while(var13.hasNext()) {
            EntityPlayer var15 = (EntityPlayer)var13.next();
            var15.func_71029_a(AchievementList.field_150965_K);
         }
      }

   }

   public List func_174907_n() {
      return this.field_174909_f;
   }

   public float func_146002_i() {
      if(!this.field_146015_k) {
         return 0.0F;
      } else {
         int var1 = (int)(this.field_145850_b.func_82737_E() - this.field_146016_i);
         this.field_146016_i = this.field_145850_b.func_82737_E();
         if(var1 > 1) {
            this.field_146014_j -= (float)var1 / 40.0F;
            if(this.field_146014_j < 0.0F) {
               this.field_146014_j = 0.0F;
            }
         }

         this.field_146014_j += 0.025F;
         if(this.field_146014_j > 1.0F) {
            this.field_146014_j = 1.0F;
         }

         return this.field_146014_j;
      }
   }

   public Packet func_145844_m() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.func_145841_b(var1);
      return new S35PacketUpdateTileEntity(this.field_174879_c, 3, var1);
   }

   public double func_145833_n() {
      return 65536.0D;
   }

   public void func_145839_a(NBTTagCompound p_145839_1_) {
      super.func_145839_a(p_145839_1_);
      this.field_146013_m = p_145839_1_.func_74762_e("Primary");
      this.field_146010_n = p_145839_1_.func_74762_e("Secondary");
      this.field_146012_l = p_145839_1_.func_74762_e("Levels");
   }

   public void func_145841_b(NBTTagCompound p_145841_1_) {
      super.func_145841_b(p_145841_1_);
      p_145841_1_.func_74768_a("Primary", this.field_146013_m);
      p_145841_1_.func_74768_a("Secondary", this.field_146010_n);
      p_145841_1_.func_74768_a("Levels", this.field_146012_l);
   }

   public int func_70302_i_() {
      return 1;
   }

   public ItemStack func_70301_a(int p_70301_1_) {
      return p_70301_1_ == 0?this.field_146011_o:null;
   }

   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
      if(p_70298_1_ == 0 && this.field_146011_o != null) {
         if(p_70298_2_ >= this.field_146011_o.field_77994_a) {
            ItemStack var3 = this.field_146011_o;
            this.field_146011_o = null;
            return var3;
         } else {
            this.field_146011_o.field_77994_a -= p_70298_2_;
            return new ItemStack(this.field_146011_o.func_77973_b(), p_70298_2_, this.field_146011_o.func_77960_j());
         }
      } else {
         return null;
      }
   }

   public ItemStack func_70304_b(int p_70304_1_) {
      if(p_70304_1_ == 0 && this.field_146011_o != null) {
         ItemStack var2 = this.field_146011_o;
         this.field_146011_o = null;
         return var2;
      } else {
         return null;
      }
   }

   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
      if(p_70299_1_ == 0) {
         this.field_146011_o = p_70299_2_;
      }

   }

   public String func_70005_c_() {
      return this.func_145818_k_()?this.field_146008_p:"container.beacon";
   }

   public boolean func_145818_k_() {
      return this.field_146008_p != null && this.field_146008_p.length() > 0;
   }

   public void func_145999_a(String p_145999_1_) {
      this.field_146008_p = p_145999_1_;
   }

   public int func_70297_j_() {
      return 1;
   }

   public boolean func_70300_a(EntityPlayer p_70300_1_) {
      return this.field_145850_b.func_175625_s(this.field_174879_c) != this?false:p_70300_1_.func_70092_e((double)this.field_174879_c.func_177958_n() + 0.5D, (double)this.field_174879_c.func_177956_o() + 0.5D, (double)this.field_174879_c.func_177952_p() + 0.5D) <= 64.0D;
   }

   public void func_174889_b(EntityPlayer p_174889_1_) {}

   public void func_174886_c(EntityPlayer p_174886_1_) {}

   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
      return p_94041_2_.func_77973_b() == Items.field_151166_bC || p_94041_2_.func_77973_b() == Items.field_151045_i || p_94041_2_.func_77973_b() == Items.field_151043_k || p_94041_2_.func_77973_b() == Items.field_151042_j;
   }

   public String func_174875_k() {
      return "minecraft:beacon";
   }

   public Container func_174876_a(InventoryPlayer p_174876_1_, EntityPlayer p_174876_2_) {
      return new ContainerBeacon(p_174876_1_, this);
   }

   public int func_174887_a_(int p_174887_1_) {
      switch(p_174887_1_) {
      case 0:
         return this.field_146012_l;
      case 1:
         return this.field_146013_m;
      case 2:
         return this.field_146010_n;
      default:
         return 0;
      }
   }

   public void func_174885_b(int p_174885_1_, int p_174885_2_) {
      switch(p_174885_1_) {
      case 0:
         this.field_146012_l = p_174885_2_;
         break;
      case 1:
         this.field_146013_m = p_174885_2_;
         break;
      case 2:
         this.field_146010_n = p_174885_2_;
      }

   }

   public int func_174890_g() {
      return 3;
   }

   public void func_174888_l() {
      this.field_146011_o = null;
   }

   public boolean func_145842_c(int p_145842_1_, int p_145842_2_) {
      if(p_145842_1_ == 1) {
         this.func_174908_m();
         return true;
      } else {
         return super.func_145842_c(p_145842_1_, p_145842_2_);
      }
   }


   public static class BeamSegment {

      private final float[] field_177266_a;
      private int field_177265_b;
      private static final String __OBFID = "CL_00002042";


      public BeamSegment(float[] p_i45669_1_) {
         this.field_177266_a = p_i45669_1_;
         this.field_177265_b = 1;
      }

      protected void func_177262_a() {
         ++this.field_177265_b;
      }

      public float[] func_177263_b() {
         return this.field_177266_a;
      }

      public int func_177264_c() {
         return this.field_177265_b;
      }
   }
}
