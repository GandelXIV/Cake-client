package net.minecraft.client.multiplayer;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

public class ServerData {

   public String field_78847_a;
   public String field_78845_b;
   public String field_78846_c;
   public String field_78843_d;
   public long field_78844_e;
   public int field_82821_f = 47;
   public String field_82822_g = "1.8";
   public boolean field_78841_f;
   public String field_147412_i;
   private ServerData.ServerResourceMode field_152587_j;
   private String field_147411_m;
   private static final String __OBFID = "CL_00000890";


   public ServerData(String p_i1193_1_, String p_i1193_2_) {
      this.field_152587_j = ServerData.ServerResourceMode.PROMPT;
      this.field_78847_a = p_i1193_1_;
      this.field_78845_b = p_i1193_2_;
   }

   public NBTTagCompound func_78836_a() {
      NBTTagCompound var1 = new NBTTagCompound();
      var1.func_74778_a("name", this.field_78847_a);
      var1.func_74778_a("ip", this.field_78845_b);
      if(this.field_147411_m != null) {
         var1.func_74778_a("icon", this.field_147411_m);
      }

      if(this.field_152587_j == ServerData.ServerResourceMode.ENABLED) {
         var1.func_74757_a("acceptTextures", true);
      } else if(this.field_152587_j == ServerData.ServerResourceMode.DISABLED) {
         var1.func_74757_a("acceptTextures", false);
      }

      return var1;
   }

   public ServerData.ServerResourceMode func_152586_b() {
      return this.field_152587_j;
   }

   public void func_152584_a(ServerData.ServerResourceMode p_152584_1_) {
      this.field_152587_j = p_152584_1_;
   }

   public static ServerData func_78837_a(NBTTagCompound p_78837_0_) {
      ServerData var1 = new ServerData(p_78837_0_.func_74779_i("name"), p_78837_0_.func_74779_i("ip"));
      if(p_78837_0_.func_150297_b("icon", 8)) {
         var1.func_147407_a(p_78837_0_.func_74779_i("icon"));
      }

      if(p_78837_0_.func_150297_b("acceptTextures", 1)) {
         if(p_78837_0_.func_74767_n("acceptTextures")) {
            var1.func_152584_a(ServerData.ServerResourceMode.ENABLED);
         } else {
            var1.func_152584_a(ServerData.ServerResourceMode.DISABLED);
         }
      } else {
         var1.func_152584_a(ServerData.ServerResourceMode.PROMPT);
      }

      return var1;
   }

   public String func_147409_e() {
      return this.field_147411_m;
   }

   public void func_147407_a(String p_147407_1_) {
      this.field_147411_m = p_147407_1_;
   }

   public void func_152583_a(ServerData p_152583_1_) {
      this.field_78845_b = p_152583_1_.field_78845_b;
      this.field_78847_a = p_152583_1_.field_78847_a;
      this.func_152584_a(p_152583_1_.func_152586_b());
      this.field_147411_m = p_152583_1_.field_147411_m;
   }

   public static enum ServerResourceMode {

      ENABLED("ENABLED", 0, "enabled"),
      DISABLED("DISABLED", 1, "disabled"),
      PROMPT("PROMPT", 2, "prompt");
      private final IChatComponent field_152594_d;
      // $FF: synthetic field
      private static final ServerData.ServerResourceMode[] $VALUES = new ServerData.ServerResourceMode[]{ENABLED, DISABLED, PROMPT};
      private static final String __OBFID = "CL_00001833";


      private ServerResourceMode(String p_i1053_1_, int p_i1053_2_, String p_i1053_3_) {
         this.field_152594_d = new ChatComponentTranslation("addServer.resourcePack." + p_i1053_3_, new Object[0]);
      }

      public IChatComponent func_152589_a() {
         return this.field_152594_d;
      }

   }
}
