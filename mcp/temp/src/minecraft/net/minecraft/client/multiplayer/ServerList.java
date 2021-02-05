package net.minecraft.client.multiplayer;

import com.google.common.collect.Lists;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServerList {

   private static final Logger field_147415_a = LogManager.getLogger();
   private final Minecraft field_78859_a;
   private final List field_78858_b = Lists.newArrayList();
   private static final String __OBFID = "CL_00000891";


   public ServerList(Minecraft p_i1194_1_) {
      this.field_78859_a = p_i1194_1_;
      this.func_78853_a();
   }

   public void func_78853_a() {
      try {
         this.field_78858_b.clear();
         NBTTagCompound var1 = CompressedStreamTools.func_74797_a(new File(this.field_78859_a.field_71412_D, "servers.dat"));
         if(var1 == null) {
            return;
         }

         NBTTagList var2 = var1.func_150295_c("servers", 10);

         for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
            this.field_78858_b.add(ServerData.func_78837_a(var2.func_150305_b(var3)));
         }
      } catch (Exception var4) {
         field_147415_a.error("Couldn\'t load server list", var4);
      }

   }

   public void func_78855_b() {
      try {
         NBTTagList var1 = new NBTTagList();
         Iterator var2 = this.field_78858_b.iterator();

         while(var2.hasNext()) {
            ServerData var3 = (ServerData)var2.next();
            var1.func_74742_a(var3.func_78836_a());
         }

         NBTTagCompound var5 = new NBTTagCompound();
         var5.func_74782_a("servers", var1);
         CompressedStreamTools.func_74793_a(var5, new File(this.field_78859_a.field_71412_D, "servers.dat"));
      } catch (Exception var4) {
         field_147415_a.error("Couldn\'t save server list", var4);
      }

   }

   public ServerData func_78850_a(int p_78850_1_) {
      return (ServerData)this.field_78858_b.get(p_78850_1_);
   }

   public void func_78851_b(int p_78851_1_) {
      this.field_78858_b.remove(p_78851_1_);
   }

   public void func_78849_a(ServerData p_78849_1_) {
      this.field_78858_b.add(p_78849_1_);
   }

   public int func_78856_c() {
      return this.field_78858_b.size();
   }

   public void func_78857_a(int p_78857_1_, int p_78857_2_) {
      ServerData var3 = this.func_78850_a(p_78857_1_);
      this.field_78858_b.set(p_78857_1_, this.func_78850_a(p_78857_2_));
      this.field_78858_b.set(p_78857_2_, var3);
      this.func_78855_b();
   }

   public void func_147413_a(int p_147413_1_, ServerData p_147413_2_) {
      this.field_78858_b.set(p_147413_1_, p_147413_2_);
   }

   public static void func_147414_b(ServerData p_147414_0_) {
      ServerList var1 = new ServerList(Minecraft.func_71410_x());
      var1.func_78853_a();

      for(int var2 = 0; var2 < var1.func_78856_c(); ++var2) {
         ServerData var3 = var1.func_78850_a(var2);
         if(var3.field_78847_a.equals(p_147414_0_.field_78847_a) && var3.field_78845_b.equals(p_147414_0_.field_78845_b)) {
            var1.func_147413_a(var2, p_147414_0_);
            break;
         }
      }

      var1.func_78855_b();
   }

}
