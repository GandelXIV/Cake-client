package net.minecraft.entity;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ReportedException;
import net.minecraft.util.Rotations;
import org.apache.commons.lang3.ObjectUtils;

public class DataWatcher {

   private final Entity field_151511_a;
   private boolean field_92086_a = true;
   private static final Map field_75697_a = Maps.newHashMap();
   private final Map field_75695_b = Maps.newHashMap();
   private boolean field_75696_c;
   private ReadWriteLock field_75694_d = new ReentrantReadWriteLock();
   private static final String __OBFID = "CL_00001559";


   public DataWatcher(Entity p_i45313_1_) {
      this.field_151511_a = p_i45313_1_;
   }

   public void func_75682_a(int p_75682_1_, Object p_75682_2_) {
      Integer var3 = (Integer)field_75697_a.get(p_75682_2_.getClass());
      if(var3 == null) {
         throw new IllegalArgumentException("Unknown data type: " + p_75682_2_.getClass());
      } else if(p_75682_1_ > 31) {
         throw new IllegalArgumentException("Data value id is too big with " + p_75682_1_ + "! (Max is " + 31 + ")");
      } else if(this.field_75695_b.containsKey(Integer.valueOf(p_75682_1_))) {
         throw new IllegalArgumentException("Duplicate id value for " + p_75682_1_ + "!");
      } else {
         DataWatcher.WatchableObject var4 = new DataWatcher.WatchableObject(var3.intValue(), p_75682_1_, p_75682_2_);
         this.field_75694_d.writeLock().lock();
         this.field_75695_b.put(Integer.valueOf(p_75682_1_), var4);
         this.field_75694_d.writeLock().unlock();
         this.field_92086_a = false;
      }
   }

   public void func_82709_a(int p_82709_1_, int p_82709_2_) {
      DataWatcher.WatchableObject var3 = new DataWatcher.WatchableObject(p_82709_2_, p_82709_1_, (Object)null);
      this.field_75694_d.writeLock().lock();
      this.field_75695_b.put(Integer.valueOf(p_82709_1_), var3);
      this.field_75694_d.writeLock().unlock();
      this.field_92086_a = false;
   }

   public byte func_75683_a(int p_75683_1_) {
      return ((Byte)this.func_75691_i(p_75683_1_).func_75669_b()).byteValue();
   }

   public short func_75693_b(int p_75693_1_) {
      return ((Short)this.func_75691_i(p_75693_1_).func_75669_b()).shortValue();
   }

   public int func_75679_c(int p_75679_1_) {
      return ((Integer)this.func_75691_i(p_75679_1_).func_75669_b()).intValue();
   }

   public float func_111145_d(int p_111145_1_) {
      return ((Float)this.func_75691_i(p_111145_1_).func_75669_b()).floatValue();
   }

   public String func_75681_e(int p_75681_1_) {
      return (String)this.func_75691_i(p_75681_1_).func_75669_b();
   }

   public ItemStack func_82710_f(int p_82710_1_) {
      return (ItemStack)this.func_75691_i(p_82710_1_).func_75669_b();
   }

   private DataWatcher.WatchableObject func_75691_i(int p_75691_1_) {
      this.field_75694_d.readLock().lock();

      DataWatcher.WatchableObject var2;
      try {
         var2 = (DataWatcher.WatchableObject)this.field_75695_b.get(Integer.valueOf(p_75691_1_));
      } catch (Throwable var6) {
         CrashReport var4 = CrashReport.func_85055_a(var6, "Getting synched entity data");
         CrashReportCategory var5 = var4.func_85058_a("Synched entity data");
         var5.func_71507_a("Data ID", Integer.valueOf(p_75691_1_));
         throw new ReportedException(var4);
      }

      this.field_75694_d.readLock().unlock();
      return var2;
   }

   public Rotations func_180115_h(int p_180115_1_) {
      return (Rotations)this.func_75691_i(p_180115_1_).func_75669_b();
   }

   public void func_75692_b(int p_75692_1_, Object p_75692_2_) {
      DataWatcher.WatchableObject var3 = this.func_75691_i(p_75692_1_);
      if(ObjectUtils.notEqual(p_75692_2_, var3.func_75669_b())) {
         var3.func_75673_a(p_75692_2_);
         this.field_151511_a.func_145781_i(p_75692_1_);
         var3.func_75671_a(true);
         this.field_75696_c = true;
      }

   }

   public void func_82708_h(int p_82708_1_) {
      this.func_75691_i(p_82708_1_).field_75675_d = true;
      this.field_75696_c = true;
   }

   public boolean func_75684_a() {
      return this.field_75696_c;
   }

   public static void func_151507_a(List p_151507_0_, PacketBuffer p_151507_1_) throws IOException {
      if(p_151507_0_ != null) {
         Iterator var2 = p_151507_0_.iterator();

         while(var2.hasNext()) {
            DataWatcher.WatchableObject var3 = (DataWatcher.WatchableObject)var2.next();
            func_151510_a(p_151507_1_, var3);
         }
      }

      p_151507_1_.writeByte(127);
   }

   public List func_75688_b() {
      ArrayList var1 = null;
      if(this.field_75696_c) {
         this.field_75694_d.readLock().lock();
         Iterator var2 = this.field_75695_b.values().iterator();

         while(var2.hasNext()) {
            DataWatcher.WatchableObject var3 = (DataWatcher.WatchableObject)var2.next();
            if(var3.func_75670_d()) {
               var3.func_75671_a(false);
               if(var1 == null) {
                  var1 = Lists.newArrayList();
               }

               var1.add(var3);
            }
         }

         this.field_75694_d.readLock().unlock();
      }

      this.field_75696_c = false;
      return var1;
   }

   public void func_151509_a(PacketBuffer p_151509_1_) throws IOException {
      this.field_75694_d.readLock().lock();
      Iterator var2 = this.field_75695_b.values().iterator();

      while(var2.hasNext()) {
         DataWatcher.WatchableObject var3 = (DataWatcher.WatchableObject)var2.next();
         func_151510_a(p_151509_1_, var3);
      }

      this.field_75694_d.readLock().unlock();
      p_151509_1_.writeByte(127);
   }

   public List func_75685_c() {
      ArrayList var1 = null;
      this.field_75694_d.readLock().lock();

      DataWatcher.WatchableObject var3;
      for(Iterator var2 = this.field_75695_b.values().iterator(); var2.hasNext(); var1.add(var3)) {
         var3 = (DataWatcher.WatchableObject)var2.next();
         if(var1 == null) {
            var1 = Lists.newArrayList();
         }
      }

      this.field_75694_d.readLock().unlock();
      return var1;
   }

   private static void func_151510_a(PacketBuffer p_151510_0_, DataWatcher.WatchableObject p_151510_1_) throws IOException {
      int var2 = (p_151510_1_.func_75674_c() << 5 | p_151510_1_.func_75672_a() & 31) & 255;
      p_151510_0_.writeByte(var2);
      switch(p_151510_1_.func_75674_c()) {
      case 0:
         p_151510_0_.writeByte(((Byte)p_151510_1_.func_75669_b()).byteValue());
         break;
      case 1:
         p_151510_0_.writeShort(((Short)p_151510_1_.func_75669_b()).shortValue());
         break;
      case 2:
         p_151510_0_.writeInt(((Integer)p_151510_1_.func_75669_b()).intValue());
         break;
      case 3:
         p_151510_0_.writeFloat(((Float)p_151510_1_.func_75669_b()).floatValue());
         break;
      case 4:
         p_151510_0_.func_180714_a((String)p_151510_1_.func_75669_b());
         break;
      case 5:
         ItemStack var3 = (ItemStack)p_151510_1_.func_75669_b();
         p_151510_0_.func_150788_a(var3);
         break;
      case 6:
         BlockPos var4 = (BlockPos)p_151510_1_.func_75669_b();
         p_151510_0_.writeInt(var4.func_177958_n());
         p_151510_0_.writeInt(var4.func_177956_o());
         p_151510_0_.writeInt(var4.func_177952_p());
         break;
      case 7:
         Rotations var5 = (Rotations)p_151510_1_.func_75669_b();
         p_151510_0_.writeFloat(var5.func_179415_b());
         p_151510_0_.writeFloat(var5.func_179416_c());
         p_151510_0_.writeFloat(var5.func_179413_d());
      }

   }

   public static List func_151508_b(PacketBuffer p_151508_0_) throws IOException {
      ArrayList var1 = null;

      for(byte var2 = p_151508_0_.readByte(); var2 != 127; var2 = p_151508_0_.readByte()) {
         if(var1 == null) {
            var1 = Lists.newArrayList();
         }

         int var3 = (var2 & 224) >> 5;
         int var4 = var2 & 31;
         DataWatcher.WatchableObject var5 = null;
         switch(var3) {
         case 0:
            var5 = new DataWatcher.WatchableObject(var3, var4, Byte.valueOf(p_151508_0_.readByte()));
            break;
         case 1:
            var5 = new DataWatcher.WatchableObject(var3, var4, Short.valueOf(p_151508_0_.readShort()));
            break;
         case 2:
            var5 = new DataWatcher.WatchableObject(var3, var4, Integer.valueOf(p_151508_0_.readInt()));
            break;
         case 3:
            var5 = new DataWatcher.WatchableObject(var3, var4, Float.valueOf(p_151508_0_.readFloat()));
            break;
         case 4:
            var5 = new DataWatcher.WatchableObject(var3, var4, p_151508_0_.func_150789_c(32767));
            break;
         case 5:
            var5 = new DataWatcher.WatchableObject(var3, var4, p_151508_0_.func_150791_c());
            break;
         case 6:
            int var6 = p_151508_0_.readInt();
            int var7 = p_151508_0_.readInt();
            int var8 = p_151508_0_.readInt();
            var5 = new DataWatcher.WatchableObject(var3, var4, new BlockPos(var6, var7, var8));
            break;
         case 7:
            float var9 = p_151508_0_.readFloat();
            float var10 = p_151508_0_.readFloat();
            float var11 = p_151508_0_.readFloat();
            var5 = new DataWatcher.WatchableObject(var3, var4, new Rotations(var9, var10, var11));
         }

         var1.add(var5);
      }

      return var1;
   }

   public void func_75687_a(List p_75687_1_) {
      this.field_75694_d.writeLock().lock();
      Iterator var2 = p_75687_1_.iterator();

      while(var2.hasNext()) {
         DataWatcher.WatchableObject var3 = (DataWatcher.WatchableObject)var2.next();
         DataWatcher.WatchableObject var4 = (DataWatcher.WatchableObject)this.field_75695_b.get(Integer.valueOf(var3.func_75672_a()));
         if(var4 != null) {
            var4.func_75673_a(var3.func_75669_b());
            this.field_151511_a.func_145781_i(var3.func_75672_a());
         }
      }

      this.field_75694_d.writeLock().unlock();
      this.field_75696_c = true;
   }

   public boolean func_92085_d() {
      return this.field_92086_a;
   }

   public void func_111144_e() {
      this.field_75696_c = false;
   }

   static {
      field_75697_a.put(Byte.class, Integer.valueOf(0));
      field_75697_a.put(Short.class, Integer.valueOf(1));
      field_75697_a.put(Integer.class, Integer.valueOf(2));
      field_75697_a.put(Float.class, Integer.valueOf(3));
      field_75697_a.put(String.class, Integer.valueOf(4));
      field_75697_a.put(ItemStack.class, Integer.valueOf(5));
      field_75697_a.put(BlockPos.class, Integer.valueOf(6));
      field_75697_a.put(Rotations.class, Integer.valueOf(7));
   }

   public static class WatchableObject {

      private final int field_75678_a;
      private final int field_75676_b;
      private Object field_75677_c;
      private boolean field_75675_d;
      private static final String __OBFID = "CL_00001560";


      public WatchableObject(int p_i1603_1_, int p_i1603_2_, Object p_i1603_3_) {
         this.field_75676_b = p_i1603_2_;
         this.field_75677_c = p_i1603_3_;
         this.field_75678_a = p_i1603_1_;
         this.field_75675_d = true;
      }

      public int func_75672_a() {
         return this.field_75676_b;
      }

      public void func_75673_a(Object p_75673_1_) {
         this.field_75677_c = p_75673_1_;
      }

      public Object func_75669_b() {
         return this.field_75677_c;
      }

      public int func_75674_c() {
         return this.field_75678_a;
      }

      public boolean func_75670_d() {
         return this.field_75675_d;
      }

      public void func_75671_a(boolean p_75671_1_) {
         this.field_75675_d = p_75671_1_;
      }
   }
}
