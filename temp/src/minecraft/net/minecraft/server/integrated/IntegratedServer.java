package net.minecraft.server.integrated;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ThreadLanServerPing;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.profiler.PlayerUsageSnooper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.integrated.IntegratedPlayerList;
import net.minecraft.server.integrated.IntegratedServerCommandManager;
import net.minecraft.util.CryptManager;
import net.minecraft.util.HttpUtil;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.WorldManager;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldServerMulti;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.demo.DemoWorldServer;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntegratedServer extends MinecraftServer {

   private static final Logger field_147148_h = LogManager.getLogger();
   private final Minecraft field_71349_l;
   private final WorldSettings field_71350_m;
   private boolean field_71348_o;
   private boolean field_71346_p;
   private ThreadLanServerPing field_71345_q;
   private static final String __OBFID = "CL_00001129";


   public IntegratedServer(Minecraft p_i46070_1_) {
      super(p_i46070_1_.func_110437_J(), new File(p_i46070_1_.field_71412_D, field_152367_a.getName()));
      this.field_71349_l = p_i46070_1_;
      this.field_71350_m = null;
   }

   public IntegratedServer(Minecraft p_i1317_1_, String p_i1317_2_, String p_i1317_3_, WorldSettings p_i1317_4_) {
      super(new File(p_i1317_1_.field_71412_D, "saves"), p_i1317_1_.func_110437_J(), new File(p_i1317_1_.field_71412_D, field_152367_a.getName()));
      this.func_71224_l(p_i1317_1_.func_110432_I().func_111285_a());
      this.func_71261_m(p_i1317_2_);
      this.func_71246_n(p_i1317_3_);
      this.func_71204_b(p_i1317_1_.func_71355_q());
      this.func_71194_c(p_i1317_4_.func_77167_c());
      this.func_71191_d(256);
      this.func_152361_a(new IntegratedPlayerList(this));
      this.field_71349_l = p_i1317_1_;
      this.field_71350_m = this.func_71242_L()?DemoWorldServer.field_73071_a:p_i1317_4_;
   }

   protected ServerCommandManager func_175582_h() {
      return new IntegratedServerCommandManager();
   }

   protected void func_71247_a(String p_71247_1_, String p_71247_2_, long p_71247_3_, WorldType p_71247_5_, String p_71247_6_) {
      this.func_71237_c(p_71247_1_);
      this.field_71305_c = new WorldServer[3];
      this.field_71312_k = new long[this.field_71305_c.length][100];
      ISaveHandler var7 = this.func_71254_M().func_75804_a(p_71247_1_, true);
      this.func_175584_a(this.func_71270_I(), var7);
      WorldInfo var8 = var7.func_75757_d();
      if(var8 == null) {
         var8 = new WorldInfo(this.field_71350_m, p_71247_2_);
      } else {
         var8.func_76062_a(p_71247_2_);
      }

      for(int var9 = 0; var9 < this.field_71305_c.length; ++var9) {
         byte var10 = 0;
         if(var9 == 1) {
            var10 = -1;
         }

         if(var9 == 2) {
            var10 = 1;
         }

         if(var9 == 0) {
            if(this.func_71242_L()) {
               this.field_71305_c[var9] = (WorldServer)(new DemoWorldServer(this, var7, var8, var10, this.field_71304_b)).func_175643_b();
            } else {
               this.field_71305_c[var9] = (WorldServer)(new WorldServer(this, var7, var8, var10, this.field_71304_b)).func_175643_b();
            }

            this.field_71305_c[var9].func_72963_a(this.field_71350_m);
         } else {
            this.field_71305_c[var9] = (WorldServer)(new WorldServerMulti(this, var7, var10, this.field_71305_c[0], this.field_71304_b)).func_175643_b();
         }

         this.field_71305_c[var9].func_72954_a(new WorldManager(this, this.field_71305_c[var9]));
      }

      this.func_71203_ab().func_72364_a(this.field_71305_c);
      if(this.field_71305_c[0].func_72912_H().func_176130_y() == null) {
         this.func_147139_a(this.field_71349_l.field_71474_y.field_74318_M);
      }

      this.func_71222_d();
   }

   protected boolean func_71197_b() throws IOException {
      field_147148_h.info("Starting integrated minecraft server version 1.8");
      this.func_71229_d(true);
      this.func_71251_e(true);
      this.func_71257_f(true);
      this.func_71188_g(true);
      this.func_71245_h(true);
      field_147148_h.info("Generating keypair");
      this.func_71253_a(CryptManager.func_75891_b());
      this.func_71247_a(this.func_71270_I(), this.func_71221_J(), this.field_71350_m.func_77160_d(), this.field_71350_m.func_77165_h(), this.field_71350_m.func_82749_j());
      this.func_71205_p(this.func_71214_G() + " - " + this.field_71305_c[0].func_72912_H().func_76065_j());
      return true;
   }

   public void func_71217_p() {
      boolean var1 = this.field_71348_o;
      this.field_71348_o = Minecraft.func_71410_x().func_147114_u() != null && Minecraft.func_71410_x().func_147113_T();
      if(!var1 && this.field_71348_o) {
         field_147148_h.info("Saving and pausing game...");
         this.func_71203_ab().func_72389_g();
         this.func_71267_a(false);
      }

      if(this.field_71348_o) {
         Queue var2 = this.field_175589_i;
         synchronized(this.field_175589_i) {
            while(!this.field_175589_i.isEmpty()) {
               try {
                  ((FutureTask)this.field_175589_i.poll()).run();
               } catch (Throwable var8) {
                  field_147148_h.fatal(var8);
               }
            }
         }
      } else {
         super.func_71217_p();
         if(this.field_71349_l.field_71474_y.field_151451_c != this.func_71203_ab().func_72395_o()) {
            field_147148_h.info("Changing view distance to {}, from {}", new Object[]{Integer.valueOf(this.field_71349_l.field_71474_y.field_151451_c), Integer.valueOf(this.func_71203_ab().func_72395_o())});
            this.func_71203_ab().func_152611_a(this.field_71349_l.field_71474_y.field_151451_c);
         }

         if(this.field_71349_l.field_71441_e != null) {
            WorldInfo var10 = this.field_71305_c[0].func_72912_H();
            WorldInfo var3 = this.field_71349_l.field_71441_e.func_72912_H();
            if(!var10.func_176123_z() && var3.func_176130_y() != var10.func_176130_y()) {
               field_147148_h.info("Changing difficulty to {}, from {}", new Object[]{var3.func_176130_y(), var10.func_176130_y()});
               this.func_147139_a(var3.func_176130_y());
            } else if(var3.func_176123_z() && !var10.func_176123_z()) {
               field_147148_h.info("Locking difficulty to {}", new Object[]{var3.func_176130_y()});
               WorldServer[] var4 = this.field_71305_c;
               int var5 = var4.length;

               for(int var6 = 0; var6 < var5; ++var6) {
                  WorldServer var7 = var4[var6];
                  if(var7 != null) {
                     var7.func_72912_H().func_180783_e(true);
                  }
               }
            }
         }
      }

   }

   public boolean func_71225_e() {
      return false;
   }

   public WorldSettings.GameType func_71265_f() {
      return this.field_71350_m.func_77162_e();
   }

   public EnumDifficulty func_147135_j() {
      return this.field_71349_l.field_71441_e.func_72912_H().func_176130_y();
   }

   public boolean func_71199_h() {
      return this.field_71350_m.func_77158_f();
   }

   public File func_71238_n() {
      return this.field_71349_l.field_71412_D;
   }

   public boolean func_71262_S() {
      return false;
   }

   protected void func_71228_a(CrashReport p_71228_1_) {
      this.field_71349_l.func_71404_a(p_71228_1_);
   }

   public CrashReport func_71230_b(CrashReport p_71230_1_) {
      p_71230_1_ = super.func_71230_b(p_71230_1_);
      p_71230_1_.func_85056_g().func_71500_a("Type", new Callable() {

         private static final String __OBFID = "CL_00001130";

         public String call() {
            return "Integrated Server (map_client.txt)";
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      p_71230_1_.func_85056_g().func_71500_a("Is Modded", new Callable() {

         private static final String __OBFID = "CL_00001131";

         public String call() {
            String var1 = ClientBrandRetriever.getClientModName();
            if(!var1.equals("vanilla")) {
               return "Definitely; Client brand changed to \'" + var1 + "\'";
            } else {
               var1 = IntegratedServer.this.getServerModName();
               return !var1.equals("vanilla")?"Definitely; Server brand changed to \'" + var1 + "\'":(Minecraft.class.getSigners() == null?"Very likely; Jar signature invalidated":"Probably not. Jar signature remains and both client + server brands are untouched.");
            }
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      return p_71230_1_;
   }

   public void func_147139_a(EnumDifficulty p_147139_1_) {
      super.func_147139_a(p_147139_1_);
      if(this.field_71349_l.field_71441_e != null) {
         this.field_71349_l.field_71441_e.func_72912_H().func_176144_a(p_147139_1_);
      }

   }

   public void func_70000_a(PlayerUsageSnooper p_70000_1_) {
      super.func_70000_a(p_70000_1_);
      p_70000_1_.func_152768_a("snooper_partner", this.field_71349_l.func_71378_E().func_80006_f());
   }

   public boolean func_70002_Q() {
      return Minecraft.func_71410_x().func_70002_Q();
   }

   public String func_71206_a(WorldSettings.GameType p_71206_1_, boolean p_71206_2_) {
      try {
         int var3 = -1;

         try {
            var3 = HttpUtil.func_76181_a();
         } catch (IOException var5) {
            ;
         }

         if(var3 <= 0) {
            var3 = 25564;
         }

         this.func_147137_ag().func_151265_a((InetAddress)null, var3);
         field_147148_h.info("Started on " + var3);
         this.field_71346_p = true;
         this.field_71345_q = new ThreadLanServerPing(this.func_71273_Y(), var3 + "");
         this.field_71345_q.start();
         this.func_71203_ab().func_152604_a(p_71206_1_);
         this.func_71203_ab().func_72387_b(p_71206_2_);
         return var3 + "";
      } catch (IOException var6) {
         return null;
      }
   }

   public void func_71260_j() {
      super.func_71260_j();
      if(this.field_71345_q != null) {
         this.field_71345_q.interrupt();
         this.field_71345_q = null;
      }

   }

   public void func_71263_m() {
      Futures.getUnchecked(this.func_152344_a(new Runnable() {

         private static final String __OBFID = "CL_00002380";

         public void run() {
            ArrayList var1 = Lists.newArrayList(IntegratedServer.this.func_71203_ab().field_72404_b);
            Iterator var2 = var1.iterator();

            while(var2.hasNext()) {
               EntityPlayerMP var3 = (EntityPlayerMP)var2.next();
               IntegratedServer.this.func_71203_ab().func_72367_e(var3);
            }

         }
      }));
      super.func_71263_m();
      if(this.field_71345_q != null) {
         this.field_71345_q.interrupt();
         this.field_71345_q = null;
      }

   }

   public void func_175592_a() {
      this.func_175585_v();
   }

   public boolean func_71344_c() {
      return this.field_71346_p;
   }

   public void func_71235_a(WorldSettings.GameType p_71235_1_) {
      this.func_71203_ab().func_152604_a(p_71235_1_);
   }

   public boolean func_82356_Z() {
      return true;
   }

   public int func_110455_j() {
      return 4;
   }

}
