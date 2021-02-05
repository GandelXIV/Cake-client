package net.minecraft.village;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.village.VillageDoorInfo;
import net.minecraft.world.World;

public class Village {

   private World field_75586_a;
   private final List field_75584_b = Lists.newArrayList();
   private BlockPos field_75585_c;
   private BlockPos field_75582_d;
   private int field_75583_e;
   private int field_75580_f;
   private int field_75581_g;
   private int field_75588_h;
   private int field_82694_i;
   private TreeMap field_82693_j;
   private List field_75589_i;
   private int field_75587_j;
   private static final String __OBFID = "CL_00001631";


   public Village() {
      this.field_75585_c = BlockPos.field_177992_a;
      this.field_75582_d = BlockPos.field_177992_a;
      this.field_82693_j = new TreeMap();
      this.field_75589_i = Lists.newArrayList();
   }

   public Village(World p_i1675_1_) {
      this.field_75585_c = BlockPos.field_177992_a;
      this.field_75582_d = BlockPos.field_177992_a;
      this.field_82693_j = new TreeMap();
      this.field_75589_i = Lists.newArrayList();
      this.field_75586_a = p_i1675_1_;
   }

   public void func_82691_a(World p_82691_1_) {
      this.field_75586_a = p_82691_1_;
   }

   public void func_75560_a(int p_75560_1_) {
      this.field_75581_g = p_75560_1_;
      this.func_75557_k();
      this.func_75565_j();
      if(p_75560_1_ % 20 == 0) {
         this.func_75572_i();
      }

      if(p_75560_1_ % 30 == 0) {
         this.func_75579_h();
      }

      int var2 = this.field_75588_h / 10;
      if(this.field_75587_j < var2 && this.field_75584_b.size() > 20 && this.field_75586_a.field_73012_v.nextInt(7000) == 0) {
         Vec3 var3 = this.func_179862_a(this.field_75582_d, 2, 4, 2);
         if(var3 != null) {
            EntityIronGolem var4 = new EntityIronGolem(this.field_75586_a);
            var4.func_70107_b(var3.field_72450_a, var3.field_72448_b, var3.field_72449_c);
            this.field_75586_a.func_72838_d(var4);
            ++this.field_75587_j;
         }
      }

   }

   private Vec3 func_179862_a(BlockPos p_179862_1_, int p_179862_2_, int p_179862_3_, int p_179862_4_) {
      for(int var5 = 0; var5 < 10; ++var5) {
         BlockPos var6 = p_179862_1_.func_177982_a(this.field_75586_a.field_73012_v.nextInt(16) - 8, this.field_75586_a.field_73012_v.nextInt(6) - 3, this.field_75586_a.field_73012_v.nextInt(16) - 8);
         if(this.func_179866_a(var6) && this.func_179861_a(new BlockPos(p_179862_2_, p_179862_3_, p_179862_4_), var6)) {
            return new Vec3((double)var6.func_177958_n(), (double)var6.func_177956_o(), (double)var6.func_177952_p());
         }
      }

      return null;
   }

   private boolean func_179861_a(BlockPos p_179861_1_, BlockPos p_179861_2_) {
      if(!World.func_175683_a(this.field_75586_a, p_179861_2_.func_177977_b())) {
         return false;
      } else {
         int var3 = p_179861_2_.func_177958_n() - p_179861_1_.func_177958_n() / 2;
         int var4 = p_179861_2_.func_177952_p() - p_179861_1_.func_177952_p() / 2;

         for(int var5 = var3; var5 < var3 + p_179861_1_.func_177958_n(); ++var5) {
            for(int var6 = p_179861_2_.func_177956_o(); var6 < p_179861_2_.func_177956_o() + p_179861_1_.func_177956_o(); ++var6) {
               for(int var7 = var4; var7 < var4 + p_179861_1_.func_177952_p(); ++var7) {
                  if(this.field_75586_a.func_180495_p(new BlockPos(var5, var6, var7)).func_177230_c().func_149721_r()) {
                     return false;
                  }
               }
            }
         }

         return true;
      }
   }

   private void func_75579_h() {
      List var1 = this.field_75586_a.func_72872_a(EntityIronGolem.class, new AxisAlignedBB((double)(this.field_75582_d.func_177958_n() - this.field_75583_e), (double)(this.field_75582_d.func_177956_o() - 4), (double)(this.field_75582_d.func_177952_p() - this.field_75583_e), (double)(this.field_75582_d.func_177958_n() + this.field_75583_e), (double)(this.field_75582_d.func_177956_o() + 4), (double)(this.field_75582_d.func_177952_p() + this.field_75583_e)));
      this.field_75587_j = var1.size();
   }

   private void func_75572_i() {
      List var1 = this.field_75586_a.func_72872_a(EntityVillager.class, new AxisAlignedBB((double)(this.field_75582_d.func_177958_n() - this.field_75583_e), (double)(this.field_75582_d.func_177956_o() - 4), (double)(this.field_75582_d.func_177952_p() - this.field_75583_e), (double)(this.field_75582_d.func_177958_n() + this.field_75583_e), (double)(this.field_75582_d.func_177956_o() + 4), (double)(this.field_75582_d.func_177952_p() + this.field_75583_e)));
      this.field_75588_h = var1.size();
      if(this.field_75588_h == 0) {
         this.field_82693_j.clear();
      }

   }

   public BlockPos func_180608_a() {
      return this.field_75582_d;
   }

   public int func_75568_b() {
      return this.field_75583_e;
   }

   public int func_75567_c() {
      return this.field_75584_b.size();
   }

   public int func_75561_d() {
      return this.field_75581_g - this.field_75580_f;
   }

   public int func_75562_e() {
      return this.field_75588_h;
   }

   public boolean func_179866_a(BlockPos p_179866_1_) {
      return this.field_75582_d.func_177951_i(p_179866_1_) < (double)(this.field_75583_e * this.field_75583_e);
   }

   public List func_75558_f() {
      return this.field_75584_b;
   }

   public VillageDoorInfo func_179865_b(BlockPos p_179865_1_) {
      VillageDoorInfo var2 = null;
      int var3 = Integer.MAX_VALUE;
      Iterator var4 = this.field_75584_b.iterator();

      while(var4.hasNext()) {
         VillageDoorInfo var5 = (VillageDoorInfo)var4.next();
         int var6 = var5.func_179848_a(p_179865_1_);
         if(var6 < var3) {
            var2 = var5;
            var3 = var6;
         }
      }

      return var2;
   }

   public VillageDoorInfo func_179863_c(BlockPos p_179863_1_) {
      VillageDoorInfo var2 = null;
      int var3 = Integer.MAX_VALUE;
      Iterator var4 = this.field_75584_b.iterator();

      while(var4.hasNext()) {
         VillageDoorInfo var5 = (VillageDoorInfo)var4.next();
         int var6 = var5.func_179848_a(p_179863_1_);
         if(var6 > 256) {
            var6 *= 1000;
         } else {
            var6 = var5.func_75468_f();
         }

         if(var6 < var3) {
            var2 = var5;
            var3 = var6;
         }
      }

      return var2;
   }

   public VillageDoorInfo func_179864_e(BlockPos p_179864_1_) {
      if(this.field_75582_d.func_177951_i(p_179864_1_) > (double)(this.field_75583_e * this.field_75583_e)) {
         return null;
      } else {
         Iterator var2 = this.field_75584_b.iterator();

         VillageDoorInfo var3;
         do {
            if(!var2.hasNext()) {
               return null;
            }

            var3 = (VillageDoorInfo)var2.next();
         } while(var3.func_179852_d().func_177958_n() != p_179864_1_.func_177958_n() || var3.func_179852_d().func_177952_p() != p_179864_1_.func_177952_p() || Math.abs(var3.func_179852_d().func_177956_o() - p_179864_1_.func_177956_o()) > 1);

         return var3;
      }
   }

   public void func_75576_a(VillageDoorInfo p_75576_1_) {
      this.field_75584_b.add(p_75576_1_);
      this.field_75585_c = this.field_75585_c.func_177971_a(p_75576_1_.func_179852_d());
      this.func_75573_l();
      this.field_75580_f = p_75576_1_.func_75473_b();
   }

   public boolean func_75566_g() {
      return this.field_75584_b.isEmpty();
   }

   public void func_75575_a(EntityLivingBase p_75575_1_) {
      Iterator var2 = this.field_75589_i.iterator();

      Village.VillageAgressor var3;
      do {
         if(!var2.hasNext()) {
            this.field_75589_i.add(new Village.VillageAgressor(p_75575_1_, this.field_75581_g));
            return;
         }

         var3 = (Village.VillageAgressor)var2.next();
      } while(var3.field_75592_a != p_75575_1_);

      var3.field_75590_b = this.field_75581_g;
   }

   public EntityLivingBase func_75571_b(EntityLivingBase p_75571_1_) {
      double var2 = Double.MAX_VALUE;
      Village.VillageAgressor var4 = null;

      for(int var5 = 0; var5 < this.field_75589_i.size(); ++var5) {
         Village.VillageAgressor var6 = (Village.VillageAgressor)this.field_75589_i.get(var5);
         double var7 = var6.field_75592_a.func_70068_e(p_75571_1_);
         if(var7 <= var2) {
            var4 = var6;
            var2 = var7;
         }
      }

      return var4 != null?var4.field_75592_a:null;
   }

   public EntityPlayer func_82685_c(EntityLivingBase p_82685_1_) {
      double var2 = Double.MAX_VALUE;
      EntityPlayer var4 = null;
      Iterator var5 = this.field_82693_j.keySet().iterator();

      while(var5.hasNext()) {
         String var6 = (String)var5.next();
         if(this.func_82687_d(var6)) {
            EntityPlayer var7 = this.field_75586_a.func_72924_a(var6);
            if(var7 != null) {
               double var8 = var7.func_70068_e(p_82685_1_);
               if(var8 <= var2) {
                  var4 = var7;
                  var2 = var8;
               }
            }
         }
      }

      return var4;
   }

   private void func_75565_j() {
      Iterator var1 = this.field_75589_i.iterator();

      while(var1.hasNext()) {
         Village.VillageAgressor var2 = (Village.VillageAgressor)var1.next();
         if(!var2.field_75592_a.func_70089_S() || Math.abs(this.field_75581_g - var2.field_75590_b) > 300) {
            var1.remove();
         }
      }

   }

   private void func_75557_k() {
      boolean var1 = false;
      boolean var2 = this.field_75586_a.field_73012_v.nextInt(50) == 0;
      Iterator var3 = this.field_75584_b.iterator();

      while(var3.hasNext()) {
         VillageDoorInfo var4 = (VillageDoorInfo)var3.next();
         if(var2) {
            var4.func_75466_d();
         }

         if(!this.func_179860_f(var4.func_179852_d()) || Math.abs(this.field_75581_g - var4.func_75473_b()) > 1200) {
            this.field_75585_c = this.field_75585_c.func_177971_a(var4.func_179852_d().func_177966_a(-1));
            var1 = true;
            var4.func_179853_a(true);
            var3.remove();
         }
      }

      if(var1) {
         this.func_75573_l();
      }

   }

   private boolean func_179860_f(BlockPos p_179860_1_) {
      Block var2 = this.field_75586_a.func_180495_p(p_179860_1_).func_177230_c();
      return var2 instanceof BlockDoor?var2.func_149688_o() == Material.field_151575_d:false;
   }

   private void func_75573_l() {
      int var1 = this.field_75584_b.size();
      if(var1 == 0) {
         this.field_75582_d = new BlockPos(0, 0, 0);
         this.field_75583_e = 0;
      } else {
         this.field_75582_d = new BlockPos(this.field_75585_c.func_177958_n() / var1, this.field_75585_c.func_177956_o() / var1, this.field_75585_c.func_177952_p() / var1);
         int var2 = 0;

         VillageDoorInfo var4;
         for(Iterator var3 = this.field_75584_b.iterator(); var3.hasNext(); var2 = Math.max(var4.func_179848_a(this.field_75582_d), var2)) {
            var4 = (VillageDoorInfo)var3.next();
         }

         this.field_75583_e = Math.max(32, (int)Math.sqrt((double)var2) + 1);
      }
   }

   public int func_82684_a(String p_82684_1_) {
      Integer var2 = (Integer)this.field_82693_j.get(p_82684_1_);
      return var2 != null?var2.intValue():0;
   }

   public int func_82688_a(String p_82688_1_, int p_82688_2_) {
      int var3 = this.func_82684_a(p_82688_1_);
      int var4 = MathHelper.func_76125_a(var3 + p_82688_2_, -30, 10);
      this.field_82693_j.put(p_82688_1_, Integer.valueOf(var4));
      return var4;
   }

   public boolean func_82687_d(String p_82687_1_) {
      return this.func_82684_a(p_82687_1_) <= -15;
   }

   public void func_82690_a(NBTTagCompound p_82690_1_) {
      this.field_75588_h = p_82690_1_.func_74762_e("PopSize");
      this.field_75583_e = p_82690_1_.func_74762_e("Radius");
      this.field_75587_j = p_82690_1_.func_74762_e("Golems");
      this.field_75580_f = p_82690_1_.func_74762_e("Stable");
      this.field_75581_g = p_82690_1_.func_74762_e("Tick");
      this.field_82694_i = p_82690_1_.func_74762_e("MTick");
      this.field_75582_d = new BlockPos(p_82690_1_.func_74762_e("CX"), p_82690_1_.func_74762_e("CY"), p_82690_1_.func_74762_e("CZ"));
      this.field_75585_c = new BlockPos(p_82690_1_.func_74762_e("ACX"), p_82690_1_.func_74762_e("ACY"), p_82690_1_.func_74762_e("ACZ"));
      NBTTagList var2 = p_82690_1_.func_150295_c("Doors", 10);

      for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
         NBTTagCompound var4 = var2.func_150305_b(var3);
         VillageDoorInfo var5 = new VillageDoorInfo(new BlockPos(var4.func_74762_e("X"), var4.func_74762_e("Y"), var4.func_74762_e("Z")), var4.func_74762_e("IDX"), var4.func_74762_e("IDZ"), var4.func_74762_e("TS"));
         this.field_75584_b.add(var5);
      }

      NBTTagList var6 = p_82690_1_.func_150295_c("Players", 10);

      for(int var7 = 0; var7 < var6.func_74745_c(); ++var7) {
         NBTTagCompound var8 = var6.func_150305_b(var7);
         this.field_82693_j.put(var8.func_74779_i("Name"), Integer.valueOf(var8.func_74762_e("S")));
      }

   }

   public void func_82689_b(NBTTagCompound p_82689_1_) {
      p_82689_1_.func_74768_a("PopSize", this.field_75588_h);
      p_82689_1_.func_74768_a("Radius", this.field_75583_e);
      p_82689_1_.func_74768_a("Golems", this.field_75587_j);
      p_82689_1_.func_74768_a("Stable", this.field_75580_f);
      p_82689_1_.func_74768_a("Tick", this.field_75581_g);
      p_82689_1_.func_74768_a("MTick", this.field_82694_i);
      p_82689_1_.func_74768_a("CX", this.field_75582_d.func_177958_n());
      p_82689_1_.func_74768_a("CY", this.field_75582_d.func_177956_o());
      p_82689_1_.func_74768_a("CZ", this.field_75582_d.func_177952_p());
      p_82689_1_.func_74768_a("ACX", this.field_75585_c.func_177958_n());
      p_82689_1_.func_74768_a("ACY", this.field_75585_c.func_177956_o());
      p_82689_1_.func_74768_a("ACZ", this.field_75585_c.func_177952_p());
      NBTTagList var2 = new NBTTagList();
      Iterator var3 = this.field_75584_b.iterator();

      while(var3.hasNext()) {
         VillageDoorInfo var4 = (VillageDoorInfo)var3.next();
         NBTTagCompound var5 = new NBTTagCompound();
         var5.func_74768_a("X", var4.func_179852_d().func_177958_n());
         var5.func_74768_a("Y", var4.func_179852_d().func_177956_o());
         var5.func_74768_a("Z", var4.func_179852_d().func_177952_p());
         var5.func_74768_a("IDX", var4.func_179847_f());
         var5.func_74768_a("IDZ", var4.func_179855_g());
         var5.func_74768_a("TS", var4.func_75473_b());
         var2.func_74742_a(var5);
      }

      p_82689_1_.func_74782_a("Doors", var2);
      NBTTagList var7 = new NBTTagList();
      Iterator var8 = this.field_82693_j.keySet().iterator();

      while(var8.hasNext()) {
         String var9 = (String)var8.next();
         NBTTagCompound var6 = new NBTTagCompound();
         var6.func_74778_a("Name", var9);
         var6.func_74768_a("S", ((Integer)this.field_82693_j.get(var9)).intValue());
         var7.func_74742_a(var6);
      }

      p_82689_1_.func_74782_a("Players", var7);
   }

   public void func_82692_h() {
      this.field_82694_i = this.field_75581_g;
   }

   public boolean func_82686_i() {
      return this.field_82694_i == 0 || this.field_75581_g - this.field_82694_i >= 3600;
   }

   public void func_82683_b(int p_82683_1_) {
      Iterator var2 = this.field_82693_j.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         this.func_82688_a(var3, p_82683_1_);
      }

   }

   class VillageAgressor {

      public EntityLivingBase field_75592_a;
      public int field_75590_b;
      private static final String __OBFID = "CL_00001632";


      VillageAgressor(EntityLivingBase p_i1674_2_, int p_i1674_3_) {
         this.field_75592_a = p_i1674_2_;
         this.field_75590_b = p_i1674_3_;
      }
   }
}
