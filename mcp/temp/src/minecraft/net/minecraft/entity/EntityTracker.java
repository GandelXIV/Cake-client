package net.minecraft.entity;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityTrackerEntry;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.network.Packet;
import net.minecraft.util.IntHashMap;
import net.minecraft.util.ReportedException;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityTracker {

   private static final Logger field_151249_a = LogManager.getLogger();
   private final WorldServer field_72795_a;
   private Set field_72793_b = Sets.newHashSet();
   private IntHashMap field_72794_c = new IntHashMap();
   private int field_72792_d;
   private static final String __OBFID = "CL_00001431";


   public EntityTracker(WorldServer p_i1516_1_) {
      this.field_72795_a = p_i1516_1_;
      this.field_72792_d = p_i1516_1_.func_73046_m().func_71203_ab().func_72372_a();
   }

   public void func_72786_a(Entity p_72786_1_) {
      if(p_72786_1_ instanceof EntityPlayerMP) {
         this.func_72791_a(p_72786_1_, 512, 2);
         EntityPlayerMP var2 = (EntityPlayerMP)p_72786_1_;
         Iterator var3 = this.field_72793_b.iterator();

         while(var3.hasNext()) {
            EntityTrackerEntry var4 = (EntityTrackerEntry)var3.next();
            if(var4.field_73132_a != var2) {
               var4.func_73117_b(var2);
            }
         }
      } else if(p_72786_1_ instanceof EntityFishHook) {
         this.func_72785_a(p_72786_1_, 64, 5, true);
      } else if(p_72786_1_ instanceof EntityArrow) {
         this.func_72785_a(p_72786_1_, 64, 20, false);
      } else if(p_72786_1_ instanceof EntitySmallFireball) {
         this.func_72785_a(p_72786_1_, 64, 10, false);
      } else if(p_72786_1_ instanceof EntityFireball) {
         this.func_72785_a(p_72786_1_, 64, 10, false);
      } else if(p_72786_1_ instanceof EntitySnowball) {
         this.func_72785_a(p_72786_1_, 64, 10, true);
      } else if(p_72786_1_ instanceof EntityEnderPearl) {
         this.func_72785_a(p_72786_1_, 64, 10, true);
      } else if(p_72786_1_ instanceof EntityEnderEye) {
         this.func_72785_a(p_72786_1_, 64, 4, true);
      } else if(p_72786_1_ instanceof EntityEgg) {
         this.func_72785_a(p_72786_1_, 64, 10, true);
      } else if(p_72786_1_ instanceof EntityPotion) {
         this.func_72785_a(p_72786_1_, 64, 10, true);
      } else if(p_72786_1_ instanceof EntityExpBottle) {
         this.func_72785_a(p_72786_1_, 64, 10, true);
      } else if(p_72786_1_ instanceof EntityFireworkRocket) {
         this.func_72785_a(p_72786_1_, 64, 10, true);
      } else if(p_72786_1_ instanceof EntityItem) {
         this.func_72785_a(p_72786_1_, 64, 20, true);
      } else if(p_72786_1_ instanceof EntityMinecart) {
         this.func_72785_a(p_72786_1_, 80, 3, true);
      } else if(p_72786_1_ instanceof EntityBoat) {
         this.func_72785_a(p_72786_1_, 80, 3, true);
      } else if(p_72786_1_ instanceof EntitySquid) {
         this.func_72785_a(p_72786_1_, 64, 3, true);
      } else if(p_72786_1_ instanceof EntityWither) {
         this.func_72785_a(p_72786_1_, 80, 3, false);
      } else if(p_72786_1_ instanceof EntityBat) {
         this.func_72785_a(p_72786_1_, 80, 3, false);
      } else if(p_72786_1_ instanceof EntityDragon) {
         this.func_72785_a(p_72786_1_, 160, 3, true);
      } else if(p_72786_1_ instanceof IAnimals) {
         this.func_72785_a(p_72786_1_, 80, 3, true);
      } else if(p_72786_1_ instanceof EntityTNTPrimed) {
         this.func_72785_a(p_72786_1_, 160, 10, true);
      } else if(p_72786_1_ instanceof EntityFallingBlock) {
         this.func_72785_a(p_72786_1_, 160, 20, true);
      } else if(p_72786_1_ instanceof EntityHanging) {
         this.func_72785_a(p_72786_1_, 160, Integer.MAX_VALUE, false);
      } else if(p_72786_1_ instanceof EntityArmorStand) {
         this.func_72785_a(p_72786_1_, 160, 3, true);
      } else if(p_72786_1_ instanceof EntityXPOrb) {
         this.func_72785_a(p_72786_1_, 160, 20, true);
      } else if(p_72786_1_ instanceof EntityEnderCrystal) {
         this.func_72785_a(p_72786_1_, 256, Integer.MAX_VALUE, false);
      }

   }

   public void func_72791_a(Entity p_72791_1_, int p_72791_2_, int p_72791_3_) {
      this.func_72785_a(p_72791_1_, p_72791_2_, p_72791_3_, false);
   }

   public void func_72785_a(Entity p_72785_1_, int p_72785_2_, final int p_72785_3_, boolean p_72785_4_) {
      if(p_72785_2_ > this.field_72792_d) {
         p_72785_2_ = this.field_72792_d;
      }

      try {
         if(this.field_72794_c.func_76037_b(p_72785_1_.func_145782_y())) {
            throw new IllegalStateException("Entity is already tracked!");
         }

         EntityTrackerEntry var5 = new EntityTrackerEntry(p_72785_1_, p_72785_2_, p_72785_3_, p_72785_4_);
         this.field_72793_b.add(var5);
         this.field_72794_c.func_76038_a(p_72785_1_.func_145782_y(), var5);
         var5.func_73125_b(this.field_72795_a.field_73010_i);
      } catch (Throwable var11) {
         CrashReport var6 = CrashReport.func_85055_a(var11, "Adding entity to track");
         CrashReportCategory var7 = var6.func_85058_a("Entity To Track");
         var7.func_71507_a("Tracking range", p_72785_2_ + " blocks");
         var7.func_71500_a("Update interval", new Callable() {

            private static final String __OBFID = "CL_00001432";

            public String call() {
               String var1 = "Once per " + p_72785_3_ + " ticks";
               if(p_72785_3_ == Integer.MAX_VALUE) {
                  var1 = "Maximum (" + var1 + ")";
               }

               return var1;
            }
            // $FF: synthetic method
            public Object call() {
               return this.call();
            }
         });
         p_72785_1_.func_85029_a(var7);
         CrashReportCategory var8 = var6.func_85058_a("Entity That Is Already Tracked");
         ((EntityTrackerEntry)this.field_72794_c.func_76041_a(p_72785_1_.func_145782_y())).field_73132_a.func_85029_a(var8);

         try {
            throw new ReportedException(var6);
         } catch (ReportedException var10) {
            field_151249_a.error("\"Silently\" catching entity tracking error.", var10);
         }
      }

   }

   public void func_72790_b(Entity p_72790_1_) {
      if(p_72790_1_ instanceof EntityPlayerMP) {
         EntityPlayerMP var2 = (EntityPlayerMP)p_72790_1_;
         Iterator var3 = this.field_72793_b.iterator();

         while(var3.hasNext()) {
            EntityTrackerEntry var4 = (EntityTrackerEntry)var3.next();
            var4.func_73118_a(var2);
         }
      }

      EntityTrackerEntry var5 = (EntityTrackerEntry)this.field_72794_c.func_76049_d(p_72790_1_.func_145782_y());
      if(var5 != null) {
         this.field_72793_b.remove(var5);
         var5.func_73119_a();
      }

   }

   public void func_72788_a() {
      ArrayList var1 = Lists.newArrayList();
      Iterator var2 = this.field_72793_b.iterator();

      while(var2.hasNext()) {
         EntityTrackerEntry var3 = (EntityTrackerEntry)var2.next();
         var3.func_73122_a(this.field_72795_a.field_73010_i);
         if(var3.field_73133_n && var3.field_73132_a instanceof EntityPlayerMP) {
            var1.add((EntityPlayerMP)var3.field_73132_a);
         }
      }

      for(int var6 = 0; var6 < var1.size(); ++var6) {
         EntityPlayerMP var7 = (EntityPlayerMP)var1.get(var6);
         Iterator var4 = this.field_72793_b.iterator();

         while(var4.hasNext()) {
            EntityTrackerEntry var5 = (EntityTrackerEntry)var4.next();
            if(var5.field_73132_a != var7) {
               var5.func_73117_b(var7);
            }
         }
      }

   }

   public void func_180245_a(EntityPlayerMP p_180245_1_) {
      Iterator var2 = this.field_72793_b.iterator();

      while(var2.hasNext()) {
         EntityTrackerEntry var3 = (EntityTrackerEntry)var2.next();
         if(var3.field_73132_a == p_180245_1_) {
            var3.func_73125_b(this.field_72795_a.field_73010_i);
         } else {
            var3.func_73117_b(p_180245_1_);
         }
      }

   }

   public void func_151247_a(Entity p_151247_1_, Packet p_151247_2_) {
      EntityTrackerEntry var3 = (EntityTrackerEntry)this.field_72794_c.func_76041_a(p_151247_1_.func_145782_y());
      if(var3 != null) {
         var3.func_151259_a(p_151247_2_);
      }

   }

   public void func_151248_b(Entity p_151248_1_, Packet p_151248_2_) {
      EntityTrackerEntry var3 = (EntityTrackerEntry)this.field_72794_c.func_76041_a(p_151248_1_.func_145782_y());
      if(var3 != null) {
         var3.func_151261_b(p_151248_2_);
      }

   }

   public void func_72787_a(EntityPlayerMP p_72787_1_) {
      Iterator var2 = this.field_72793_b.iterator();

      while(var2.hasNext()) {
         EntityTrackerEntry var3 = (EntityTrackerEntry)var2.next();
         var3.func_73123_c(p_72787_1_);
      }

   }

   public void func_85172_a(EntityPlayerMP p_85172_1_, Chunk p_85172_2_) {
      Iterator var3 = this.field_72793_b.iterator();

      while(var3.hasNext()) {
         EntityTrackerEntry var4 = (EntityTrackerEntry)var3.next();
         if(var4.field_73132_a != p_85172_1_ && var4.field_73132_a.field_70176_ah == p_85172_2_.field_76635_g && var4.field_73132_a.field_70164_aj == p_85172_2_.field_76647_h) {
            var4.func_73117_b(p_85172_1_);
         }
      }

   }

}
