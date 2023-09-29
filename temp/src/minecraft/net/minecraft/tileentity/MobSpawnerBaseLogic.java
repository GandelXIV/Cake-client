package net.minecraft.tileentity;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.World;

public abstract class MobSpawnerBaseLogic {

   private int field_98286_b = 20;
   private String field_98288_a = "Pig";
   private final List field_98285_e = Lists.newArrayList();
   private MobSpawnerBaseLogic.WeightedRandomMinecart field_98282_f;
   private double field_98287_c;
   private double field_98284_d;
   private int field_98283_g = 200;
   private int field_98293_h = 800;
   private int field_98294_i = 4;
   private Entity field_98291_j;
   private int field_98292_k = 6;
   private int field_98289_l = 16;
   private int field_98290_m = 4;
   private static final String __OBFID = "CL_00000129";


   private String func_98276_e() {
      if(this.func_98269_i() == null) {
         if(this.field_98288_a.equals("Minecart")) {
            this.field_98288_a = "MinecartRideable";
         }

         return this.field_98288_a;
      } else {
         return this.func_98269_i().field_98223_c;
      }
   }

   public void func_98272_a(String p_98272_1_) {
      this.field_98288_a = p_98272_1_;
   }

   private boolean func_98279_f() {
      BlockPos var1 = this.func_177221_b();
      return this.func_98271_a().func_175636_b((double)var1.func_177958_n() + 0.5D, (double)var1.func_177956_o() + 0.5D, (double)var1.func_177952_p() + 0.5D, (double)this.field_98289_l);
   }

   public void func_98278_g() {
      if(this.func_98279_f()) {
         BlockPos var1 = this.func_177221_b();
         double var6;
         if(this.func_98271_a().field_72995_K) {
            double var2 = (double)((float)var1.func_177958_n() + this.func_98271_a().field_73012_v.nextFloat());
            double var4 = (double)((float)var1.func_177956_o() + this.func_98271_a().field_73012_v.nextFloat());
            var6 = (double)((float)var1.func_177952_p() + this.func_98271_a().field_73012_v.nextFloat());
            this.func_98271_a().func_175688_a(EnumParticleTypes.SMOKE_NORMAL, var2, var4, var6, 0.0D, 0.0D, 0.0D, new int[0]);
            this.func_98271_a().func_175688_a(EnumParticleTypes.FLAME, var2, var4, var6, 0.0D, 0.0D, 0.0D, new int[0]);
            if(this.field_98286_b > 0) {
               --this.field_98286_b;
            }

            this.field_98284_d = this.field_98287_c;
            this.field_98287_c = (this.field_98287_c + (double)(1000.0F / ((float)this.field_98286_b + 200.0F))) % 360.0D;
         } else {
            if(this.field_98286_b == -1) {
               this.func_98273_j();
            }

            if(this.field_98286_b > 0) {
               --this.field_98286_b;
               return;
            }

            boolean var13 = false;

            for(int var3 = 0; var3 < this.field_98294_i; ++var3) {
               Entity var14 = EntityList.func_75620_a(this.func_98276_e(), this.func_98271_a());
               if(var14 == null) {
                  return;
               }

               int var5 = this.func_98271_a().func_72872_a(var14.getClass(), (new AxisAlignedBB((double)var1.func_177958_n(), (double)var1.func_177956_o(), (double)var1.func_177952_p(), (double)(var1.func_177958_n() + 1), (double)(var1.func_177956_o() + 1), (double)(var1.func_177952_p() + 1))).func_72314_b((double)this.field_98290_m, (double)this.field_98290_m, (double)this.field_98290_m)).size();
               if(var5 >= this.field_98292_k) {
                  this.func_98273_j();
                  return;
               }

               var6 = (double)var1.func_177958_n() + (this.func_98271_a().field_73012_v.nextDouble() - this.func_98271_a().field_73012_v.nextDouble()) * (double)this.field_98290_m + 0.5D;
               double var8 = (double)(var1.func_177956_o() + this.func_98271_a().field_73012_v.nextInt(3) - 1);
               double var10 = (double)var1.func_177952_p() + (this.func_98271_a().field_73012_v.nextDouble() - this.func_98271_a().field_73012_v.nextDouble()) * (double)this.field_98290_m + 0.5D;
               EntityLiving var12 = var14 instanceof EntityLiving?(EntityLiving)var14:null;
               var14.func_70012_b(var6, var8, var10, this.func_98271_a().field_73012_v.nextFloat() * 360.0F, 0.0F);
               if(var12 == null || var12.func_70601_bi() && var12.func_70058_J()) {
                  this.func_180613_a(var14, true);
                  this.func_98271_a().func_175718_b(2004, var1, 0);
                  if(var12 != null) {
                     var12.func_70656_aK();
                  }

                  var13 = true;
               }
            }

            if(var13) {
               this.func_98273_j();
            }
         }

      }
   }

   private Entity func_180613_a(Entity p_180613_1_, boolean p_180613_2_) {
      if(this.func_98269_i() != null) {
         NBTTagCompound var3 = new NBTTagCompound();
         p_180613_1_.func_70039_c(var3);
         Iterator var4 = this.func_98269_i().field_98222_b.func_150296_c().iterator();

         while(var4.hasNext()) {
            String var5 = (String)var4.next();
            NBTBase var6 = this.func_98269_i().field_98222_b.func_74781_a(var5);
            var3.func_74782_a(var5, var6.func_74737_b());
         }

         p_180613_1_.func_70020_e(var3);
         if(p_180613_1_.field_70170_p != null && p_180613_2_) {
            p_180613_1_.field_70170_p.func_72838_d(p_180613_1_);
         }

         NBTTagCompound var12;
         for(Entity var11 = p_180613_1_; var3.func_150297_b("Riding", 10); var3 = var12) {
            var12 = var3.func_74775_l("Riding");
            Entity var13 = EntityList.func_75620_a(var12.func_74779_i("id"), p_180613_1_.field_70170_p);
            if(var13 != null) {
               NBTTagCompound var7 = new NBTTagCompound();
               var13.func_70039_c(var7);
               Iterator var8 = var12.func_150296_c().iterator();

               while(var8.hasNext()) {
                  String var9 = (String)var8.next();
                  NBTBase var10 = var12.func_74781_a(var9);
                  var7.func_74782_a(var9, var10.func_74737_b());
               }

               var13.func_70020_e(var7);
               var13.func_70012_b(var11.field_70165_t, var11.field_70163_u, var11.field_70161_v, var11.field_70177_z, var11.field_70125_A);
               if(p_180613_1_.field_70170_p != null && p_180613_2_) {
                  p_180613_1_.field_70170_p.func_72838_d(var13);
               }

               var11.func_70078_a(var13);
            }

            var11 = var13;
         }
      } else if(p_180613_1_ instanceof EntityLivingBase && p_180613_1_.field_70170_p != null && p_180613_2_) {
         ((EntityLiving)p_180613_1_).func_180482_a(p_180613_1_.field_70170_p.func_175649_E(new BlockPos(p_180613_1_)), (IEntityLivingData)null);
         p_180613_1_.field_70170_p.func_72838_d(p_180613_1_);
      }

      return p_180613_1_;
   }

   private void func_98273_j() {
      if(this.field_98293_h <= this.field_98283_g) {
         this.field_98286_b = this.field_98283_g;
      } else {
         int var10003 = this.field_98293_h - this.field_98283_g;
         this.field_98286_b = this.field_98283_g + this.func_98271_a().field_73012_v.nextInt(var10003);
      }

      if(this.field_98285_e.size() > 0) {
         this.func_98277_a((MobSpawnerBaseLogic.WeightedRandomMinecart)WeightedRandom.func_76271_a(this.func_98271_a().field_73012_v, this.field_98285_e));
      }

      this.func_98267_a(1);
   }

   public void func_98270_a(NBTTagCompound p_98270_1_) {
      this.field_98288_a = p_98270_1_.func_74779_i("EntityId");
      this.field_98286_b = p_98270_1_.func_74765_d("Delay");
      this.field_98285_e.clear();
      if(p_98270_1_.func_150297_b("SpawnPotentials", 9)) {
         NBTTagList var2 = p_98270_1_.func_150295_c("SpawnPotentials", 10);

         for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
            this.field_98285_e.add(new MobSpawnerBaseLogic.WeightedRandomMinecart(var2.func_150305_b(var3)));
         }
      }

      if(p_98270_1_.func_150297_b("SpawnData", 10)) {
         this.func_98277_a(new MobSpawnerBaseLogic.WeightedRandomMinecart(p_98270_1_.func_74775_l("SpawnData"), this.field_98288_a));
      } else {
         this.func_98277_a((MobSpawnerBaseLogic.WeightedRandomMinecart)null);
      }

      if(p_98270_1_.func_150297_b("MinSpawnDelay", 99)) {
         this.field_98283_g = p_98270_1_.func_74765_d("MinSpawnDelay");
         this.field_98293_h = p_98270_1_.func_74765_d("MaxSpawnDelay");
         this.field_98294_i = p_98270_1_.func_74765_d("SpawnCount");
      }

      if(p_98270_1_.func_150297_b("MaxNearbyEntities", 99)) {
         this.field_98292_k = p_98270_1_.func_74765_d("MaxNearbyEntities");
         this.field_98289_l = p_98270_1_.func_74765_d("RequiredPlayerRange");
      }

      if(p_98270_1_.func_150297_b("SpawnRange", 99)) {
         this.field_98290_m = p_98270_1_.func_74765_d("SpawnRange");
      }

      if(this.func_98271_a() != null) {
         this.field_98291_j = null;
      }

   }

   public void func_98280_b(NBTTagCompound p_98280_1_) {
      p_98280_1_.func_74778_a("EntityId", this.func_98276_e());
      p_98280_1_.func_74777_a("Delay", (short)this.field_98286_b);
      p_98280_1_.func_74777_a("MinSpawnDelay", (short)this.field_98283_g);
      p_98280_1_.func_74777_a("MaxSpawnDelay", (short)this.field_98293_h);
      p_98280_1_.func_74777_a("SpawnCount", (short)this.field_98294_i);
      p_98280_1_.func_74777_a("MaxNearbyEntities", (short)this.field_98292_k);
      p_98280_1_.func_74777_a("RequiredPlayerRange", (short)this.field_98289_l);
      p_98280_1_.func_74777_a("SpawnRange", (short)this.field_98290_m);
      if(this.func_98269_i() != null) {
         p_98280_1_.func_74782_a("SpawnData", this.func_98269_i().field_98222_b.func_74737_b());
      }

      if(this.func_98269_i() != null || this.field_98285_e.size() > 0) {
         NBTTagList var2 = new NBTTagList();
         if(this.field_98285_e.size() > 0) {
            Iterator var3 = this.field_98285_e.iterator();

            while(var3.hasNext()) {
               MobSpawnerBaseLogic.WeightedRandomMinecart var4 = (MobSpawnerBaseLogic.WeightedRandomMinecart)var3.next();
               var2.func_74742_a(var4.func_98220_a());
            }
         } else {
            var2.func_74742_a(this.func_98269_i().func_98220_a());
         }

         p_98280_1_.func_74782_a("SpawnPotentials", var2);
      }

   }

   public Entity func_180612_a(World p_180612_1_) {
      if(this.field_98291_j == null) {
         Entity var2 = EntityList.func_75620_a(this.func_98276_e(), p_180612_1_);
         if(var2 != null) {
            var2 = this.func_180613_a(var2, false);
            this.field_98291_j = var2;
         }
      }

      return this.field_98291_j;
   }

   public boolean func_98268_b(int p_98268_1_) {
      if(p_98268_1_ == 1 && this.func_98271_a().field_72995_K) {
         this.field_98286_b = this.field_98283_g;
         return true;
      } else {
         return false;
      }
   }

   private MobSpawnerBaseLogic.WeightedRandomMinecart func_98269_i() {
      return this.field_98282_f;
   }

   public void func_98277_a(MobSpawnerBaseLogic.WeightedRandomMinecart p_98277_1_) {
      this.field_98282_f = p_98277_1_;
   }

   public abstract void func_98267_a(int var1);

   public abstract World func_98271_a();

   public abstract BlockPos func_177221_b();

   public double func_177222_d() {
      return this.field_98287_c;
   }

   public double func_177223_e() {
      return this.field_98284_d;
   }

   public class WeightedRandomMinecart extends WeightedRandom.Item {

      private final NBTTagCompound field_98222_b;
      private final String field_98223_c;
      private static final String __OBFID = "CL_00000130";


      public WeightedRandomMinecart(NBTTagCompound p_i1945_2_) {
         this(p_i1945_2_.func_74775_l("Properties"), p_i1945_2_.func_74779_i("Type"), p_i1945_2_.func_74762_e("Weight"));
      }

      public WeightedRandomMinecart(NBTTagCompound p_i1946_2_, String p_i1946_3_) {
         this(p_i1946_2_, p_i1946_3_, 1);
      }

      private WeightedRandomMinecart(NBTTagCompound p_i45757_2_, String p_i45757_3_, int p_i45757_4_) {
         super(p_i45757_4_);
         if(p_i45757_3_.equals("Minecart")) {
            if(p_i45757_2_ != null) {
               p_i45757_3_ = EntityMinecart.EnumMinecartType.func_180038_a(p_i45757_2_.func_74762_e("Type")).func_180040_b();
            } else {
               p_i45757_3_ = "MinecartRideable";
            }
         }

         this.field_98222_b = p_i45757_2_;
         this.field_98223_c = p_i45757_3_;
      }

      public NBTTagCompound func_98220_a() {
         NBTTagCompound var1 = new NBTTagCompound();
         var1.func_74782_a("Properties", this.field_98222_b);
         var1.func_74778_a("Type", this.field_98223_c);
         var1.func_74768_a("Weight", this.field_76292_a);
         return var1;
      }
   }
}
