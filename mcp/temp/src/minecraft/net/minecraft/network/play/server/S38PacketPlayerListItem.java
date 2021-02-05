package net.minecraft.network.play.server;

import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.WorldSettings;

public class S38PacketPlayerListItem implements Packet {

   private S38PacketPlayerListItem.Action field_179770_a;
   private final List field_179769_b = Lists.newArrayList();
   private static final String __OBFID = "CL_00001318";


   public S38PacketPlayerListItem() {}

   public S38PacketPlayerListItem(S38PacketPlayerListItem.Action p_i45967_1_, EntityPlayerMP ... p_i45967_2_) {
      this.field_179770_a = p_i45967_1_;
      EntityPlayerMP[] var3 = p_i45967_2_;
      int var4 = p_i45967_2_.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EntityPlayerMP var6 = var3[var5];
         this.field_179769_b.add(new S38PacketPlayerListItem.AddPlayerData(var6.func_146103_bH(), var6.field_71138_i, var6.field_71134_c.func_73081_b(), var6.func_175396_E()));
      }

   }

   public S38PacketPlayerListItem(S38PacketPlayerListItem.Action p_i45968_1_, Iterable p_i45968_2_) {
      this.field_179770_a = p_i45968_1_;
      Iterator var3 = p_i45968_2_.iterator();

      while(var3.hasNext()) {
         EntityPlayerMP var4 = (EntityPlayerMP)var3.next();
         this.field_179769_b.add(new S38PacketPlayerListItem.AddPlayerData(var4.func_146103_bH(), var4.field_71138_i, var4.field_71134_c.func_73081_b(), var4.func_175396_E()));
      }

   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_179770_a = (S38PacketPlayerListItem.Action)p_148837_1_.func_179257_a(S38PacketPlayerListItem.Action.class);
      int var2 = p_148837_1_.func_150792_a();

      for(int var3 = 0; var3 < var2; ++var3) {
         GameProfile var4 = null;
         int var5 = 0;
         WorldSettings.GameType var6 = null;
         IChatComponent var7 = null;
         switch(S38PacketPlayerListItem.SwitchAction.field_179938_a[this.field_179770_a.ordinal()]) {
         case 1:
            var4 = new GameProfile(p_148837_1_.func_179253_g(), p_148837_1_.func_150789_c(16));
            int var8 = p_148837_1_.func_150792_a();

            for(int var9 = 0; var9 < var8; ++var9) {
               String var10 = p_148837_1_.func_150789_c(32767);
               String var11 = p_148837_1_.func_150789_c(32767);
               if(p_148837_1_.readBoolean()) {
                  var4.getProperties().put(var10, new Property(var10, var11, p_148837_1_.func_150789_c(32767)));
               } else {
                  var4.getProperties().put(var10, new Property(var10, var11));
               }
            }

            var6 = WorldSettings.GameType.func_77146_a(p_148837_1_.func_150792_a());
            var5 = p_148837_1_.func_150792_a();
            if(p_148837_1_.readBoolean()) {
               var7 = p_148837_1_.func_179258_d();
            }
            break;
         case 2:
            var4 = new GameProfile(p_148837_1_.func_179253_g(), (String)null);
            var6 = WorldSettings.GameType.func_77146_a(p_148837_1_.func_150792_a());
            break;
         case 3:
            var4 = new GameProfile(p_148837_1_.func_179253_g(), (String)null);
            var5 = p_148837_1_.func_150792_a();
            break;
         case 4:
            var4 = new GameProfile(p_148837_1_.func_179253_g(), (String)null);
            if(p_148837_1_.readBoolean()) {
               var7 = p_148837_1_.func_179258_d();
            }
            break;
         case 5:
            var4 = new GameProfile(p_148837_1_.func_179253_g(), (String)null);
         }

         this.field_179769_b.add(new S38PacketPlayerListItem.AddPlayerData(var4, var5, var6, var7));
      }

   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_179249_a(this.field_179770_a);
      p_148840_1_.func_150787_b(this.field_179769_b.size());
      Iterator var2 = this.field_179769_b.iterator();

      while(var2.hasNext()) {
         S38PacketPlayerListItem.AddPlayerData var3 = (S38PacketPlayerListItem.AddPlayerData)var2.next();
         switch(S38PacketPlayerListItem.SwitchAction.field_179938_a[this.field_179770_a.ordinal()]) {
         case 1:
            p_148840_1_.func_179252_a(var3.func_179962_a().getId());
            p_148840_1_.func_180714_a(var3.func_179962_a().getName());
            p_148840_1_.func_150787_b(var3.func_179962_a().getProperties().size());
            Iterator var4 = var3.func_179962_a().getProperties().values().iterator();

            while(var4.hasNext()) {
               Property var5 = (Property)var4.next();
               p_148840_1_.func_180714_a(var5.getName());
               p_148840_1_.func_180714_a(var5.getValue());
               if(var5.hasSignature()) {
                  p_148840_1_.writeBoolean(true);
                  p_148840_1_.func_180714_a(var5.getSignature());
               } else {
                  p_148840_1_.writeBoolean(false);
               }
            }

            p_148840_1_.func_150787_b(var3.func_179960_c().func_77148_a());
            p_148840_1_.func_150787_b(var3.func_179963_b());
            if(var3.func_179961_d() == null) {
               p_148840_1_.writeBoolean(false);
            } else {
               p_148840_1_.writeBoolean(true);
               p_148840_1_.func_179256_a(var3.func_179961_d());
            }
            break;
         case 2:
            p_148840_1_.func_179252_a(var3.func_179962_a().getId());
            p_148840_1_.func_150787_b(var3.func_179960_c().func_77148_a());
            break;
         case 3:
            p_148840_1_.func_179252_a(var3.func_179962_a().getId());
            p_148840_1_.func_150787_b(var3.func_179963_b());
            break;
         case 4:
            p_148840_1_.func_179252_a(var3.func_179962_a().getId());
            if(var3.func_179961_d() == null) {
               p_148840_1_.writeBoolean(false);
            } else {
               p_148840_1_.writeBoolean(true);
               p_148840_1_.func_179256_a(var3.func_179961_d());
            }
            break;
         case 5:
            p_148840_1_.func_179252_a(var3.func_179962_a().getId());
         }
      }

   }

   public void func_180743_a(INetHandlerPlayClient p_180743_1_) {
      p_180743_1_.func_147256_a(this);
   }

   public List func_179767_a() {
      return this.field_179769_b;
   }

   public S38PacketPlayerListItem.Action func_179768_b() {
      return this.field_179770_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_180743_a((INetHandlerPlayClient)p_148833_1_);
   }

   public static enum Action {

      ADD_PLAYER("ADD_PLAYER", 0),
      UPDATE_GAME_MODE("UPDATE_GAME_MODE", 1),
      UPDATE_LATENCY("UPDATE_LATENCY", 2),
      UPDATE_DISPLAY_NAME("UPDATE_DISPLAY_NAME", 3),
      REMOVE_PLAYER("REMOVE_PLAYER", 4);
      // $FF: synthetic field
      private static final S38PacketPlayerListItem.Action[] $VALUES = new S38PacketPlayerListItem.Action[]{ADD_PLAYER, UPDATE_GAME_MODE, UPDATE_LATENCY, UPDATE_DISPLAY_NAME, REMOVE_PLAYER};
      private static final String __OBFID = "CL_00002295";


      private Action(String p_i45966_1_, int p_i45966_2_) {}

   }

   public class AddPlayerData {

      private final int field_179966_b;
      private final WorldSettings.GameType field_179967_c;
      private final GameProfile field_179964_d;
      private final IChatComponent field_179965_e;
      private static final String __OBFID = "CL_00002294";


      public AddPlayerData(GameProfile p_i45965_2_, int p_i45965_3_, WorldSettings.GameType p_i45965_4_, IChatComponent p_i45965_5_) {
         this.field_179964_d = p_i45965_2_;
         this.field_179966_b = p_i45965_3_;
         this.field_179967_c = p_i45965_4_;
         this.field_179965_e = p_i45965_5_;
      }

      public GameProfile func_179962_a() {
         return this.field_179964_d;
      }

      public int func_179963_b() {
         return this.field_179966_b;
      }

      public WorldSettings.GameType func_179960_c() {
         return this.field_179967_c;
      }

      public IChatComponent func_179961_d() {
         return this.field_179965_e;
      }
   }

   // $FF: synthetic class
   static final class SwitchAction {

      // $FF: synthetic field
      static final int[] field_179938_a = new int[S38PacketPlayerListItem.Action.values().length];
      private static final String __OBFID = "CL_00002296";


      static {
         try {
            field_179938_a[S38PacketPlayerListItem.Action.ADD_PLAYER.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            field_179938_a[S38PacketPlayerListItem.Action.UPDATE_GAME_MODE.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_179938_a[S38PacketPlayerListItem.Action.UPDATE_LATENCY.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_179938_a[S38PacketPlayerListItem.Action.UPDATE_DISPLAY_NAME.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_179938_a[S38PacketPlayerListItem.Action.REMOVE_PLAYER.ordinal()] = 5;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
