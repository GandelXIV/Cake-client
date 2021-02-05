package net.minecraft.village;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.village.Village;
import net.minecraft.village.VillageDoorInfo;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSavedData;

public class VillageCollection extends WorldSavedData {

   private World field_75556_a;
   private final List field_75554_b = Lists.newArrayList();
   private final List field_75555_c = Lists.newArrayList();
   private final List field_75552_d = Lists.newArrayList();
   private int field_75553_e;
   private static final String __OBFID = "CL_00001635";


   public VillageCollection(String p_i1677_1_) {
      super(p_i1677_1_);
   }

   public VillageCollection(World p_i1678_1_) {
      super(func_176062_a(p_i1678_1_.field_73011_w));
      this.field_75556_a = p_i1678_1_;
      this.func_76185_a();
   }

   public void func_82566_a(World p_82566_1_) {
      this.field_75556_a = p_82566_1_;
      Iterator var2 = this.field_75552_d.iterator();

      while(var2.hasNext()) {
         Village var3 = (Village)var2.next();
         var3.func_82691_a(p_82566_1_);
      }

   }

   public void func_176060_a(BlockPos p_176060_1_) {
      if(this.field_75554_b.size() <= 64) {
         if(!this.func_176057_e(p_176060_1_)) {
            this.field_75554_b.add(p_176060_1_);
         }

      }
   }

   public void func_75544_a() {
      ++this.field_75553_e;
      Iterator var1 = this.field_75552_d.iterator();

      while(var1.hasNext()) {
         Village var2 = (Village)var1.next();
         var2.func_75560_a(this.field_75553_e);
      }

      this.func_75549_c();
      this.func_75543_d();
      this.func_75545_e();
      if(this.field_75553_e % 400 == 0) {
         this.func_76185_a();
      }

   }

   private void func_75549_c() {
      Iterator var1 = this.field_75552_d.iterator();

      while(var1.hasNext()) {
         Village var2 = (Village)var1.next();
         if(var2.func_75566_g()) {
            var1.remove();
            this.func_76185_a();
         }
      }

   }

   public List func_75540_b() {
      return this.field_75552_d;
   }

   public Village func_176056_a(BlockPos p_176056_1_, int p_176056_2_) {
      Village var3 = null;
      double var4 = 3.4028234663852886E38D;
      Iterator var6 = this.field_75552_d.iterator();

      while(var6.hasNext()) {
         Village var7 = (Village)var6.next();
         double var8 = var7.func_180608_a().func_177951_i(p_176056_1_);
         if(var8 < var4) {
            float var10 = (float)(p_176056_2_ + var7.func_75568_b());
            if(var8 <= (double)(var10 * var10)) {
               var3 = var7;
               var4 = var8;
            }
         }
      }

      return var3;
   }

   private void func_75543_d() {
      if(!this.field_75554_b.isEmpty()) {
         this.func_180609_b((BlockPos)this.field_75554_b.remove(0));
      }
   }

   private void func_75545_e() {
      for(int var1 = 0; var1 < this.field_75555_c.size(); ++var1) {
         VillageDoorInfo var2 = (VillageDoorInfo)this.field_75555_c.get(var1);
         Village var3 = this.func_176056_a(var2.func_179852_d(), 32);
         if(var3 == null) {
            var3 = new Village(this.field_75556_a);
            this.field_75552_d.add(var3);
            this.func_76185_a();
         }

         var3.func_75576_a(var2);
      }

      this.field_75555_c.clear();
   }

   private void func_180609_b(BlockPos p_180609_1_) {
      byte var2 = 16;
      byte var3 = 4;
      byte var4 = 16;

      for(int var5 = -var2; var5 < var2; ++var5) {
         for(int var6 = -var3; var6 < var3; ++var6) {
            for(int var7 = -var4; var7 < var4; ++var7) {
               BlockPos var8 = p_180609_1_.func_177982_a(var5, var6, var7);
               if(this.func_176058_f(var8)) {
                  VillageDoorInfo var9 = this.func_176055_c(var8);
                  if(var9 == null) {
                     this.func_176059_d(var8);
                  } else {
                     var9.func_179849_a(this.field_75553_e);
                  }
               }
            }
         }
      }

   }

   private VillageDoorInfo func_176055_c(BlockPos p_176055_1_) {
      Iterator var2 = this.field_75555_c.iterator();

      VillageDoorInfo var3;
      do {
         if(!var2.hasNext()) {
            var2 = this.field_75552_d.iterator();

            VillageDoorInfo var4;
            do {
               if(!var2.hasNext()) {
                  return null;
               }

               Village var5 = (Village)var2.next();
               var4 = var5.func_179864_e(p_176055_1_);
            } while(var4 == null);

            return var4;
         }

         var3 = (VillageDoorInfo)var2.next();
      } while(var3.func_179852_d().func_177958_n() != p_176055_1_.func_177958_n() || var3.func_179852_d().func_177952_p() != p_176055_1_.func_177952_p() || Math.abs(var3.func_179852_d().func_177956_o() - p_176055_1_.func_177956_o()) > 1);

      return var3;
   }

   private void func_176059_d(BlockPos p_176059_1_) {
      EnumFacing var2 = BlockDoor.func_176517_h(this.field_75556_a, p_176059_1_);
      EnumFacing var3 = var2.func_176734_d();
      int var4 = this.func_176061_a(p_176059_1_, var2, 5);
      int var5 = this.func_176061_a(p_176059_1_, var3, var4 + 1);
      if(var4 != var5) {
         this.field_75555_c.add(new VillageDoorInfo(p_176059_1_, var4 < var5?var2:var3, this.field_75553_e));
      }

   }

   private int func_176061_a(BlockPos p_176061_1_, EnumFacing p_176061_2_, int p_176061_3_) {
      int var4 = 0;

      for(int var5 = 1; var5 <= 5; ++var5) {
         if(this.field_75556_a.func_175678_i(p_176061_1_.func_177967_a(p_176061_2_, var5))) {
            ++var4;
            if(var4 >= p_176061_3_) {
               return var4;
            }
         }
      }

      return var4;
   }

   private boolean func_176057_e(BlockPos p_176057_1_) {
      Iterator var2 = this.field_75554_b.iterator();

      BlockPos var3;
      do {
         if(!var2.hasNext()) {
            return false;
         }

         var3 = (BlockPos)var2.next();
      } while(!var3.equals(p_176057_1_));

      return true;
   }

   private boolean func_176058_f(BlockPos p_176058_1_) {
      Block var2 = this.field_75556_a.func_180495_p(p_176058_1_).func_177230_c();
      return var2 instanceof BlockDoor?var2.func_149688_o() == Material.field_151575_d:false;
   }

   public void func_76184_a(NBTTagCompound p_76184_1_) {
      this.field_75553_e = p_76184_1_.func_74762_e("Tick");
      NBTTagList var2 = p_76184_1_.func_150295_c("Villages", 10);

      for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
         NBTTagCompound var4 = var2.func_150305_b(var3);
         Village var5 = new Village();
         var5.func_82690_a(var4);
         this.field_75552_d.add(var5);
      }

   }

   public void func_76187_b(NBTTagCompound p_76187_1_) {
      p_76187_1_.func_74768_a("Tick", this.field_75553_e);
      NBTTagList var2 = new NBTTagList();
      Iterator var3 = this.field_75552_d.iterator();

      while(var3.hasNext()) {
         Village var4 = (Village)var3.next();
         NBTTagCompound var5 = new NBTTagCompound();
         var4.func_82689_b(var5);
         var2.func_74742_a(var5);
      }

      p_76187_1_.func_74782_a("Villages", var2);
   }

   public static String func_176062_a(WorldProvider p_176062_0_) {
      return "villages" + p_176062_0_.func_177498_l();
   }
}
