package net.minecraft.server.management;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.authlib.GameProfile;
import io.netty.buffer.Unpooled;
import java.io.File;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.S01PacketJoinGame;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.network.play.server.S03PacketTimeUpdate;
import net.minecraft.network.play.server.S05PacketSpawnPosition;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S09PacketHeldItemChange;
import net.minecraft.network.play.server.S1DPacketEntityEffect;
import net.minecraft.network.play.server.S1FPacketSetExperience;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.network.play.server.S38PacketPlayerListItem;
import net.minecraft.network.play.server.S39PacketPlayerAbilities;
import net.minecraft.network.play.server.S3EPacketTeams;
import net.minecraft.network.play.server.S3FPacketCustomPayload;
import net.minecraft.network.play.server.S41PacketServerDifficulty;
import net.minecraft.network.play.server.S44PacketWorldBorder;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.BanList;
import net.minecraft.server.management.IPBanEntry;
import net.minecraft.server.management.ItemInWorldManager;
import net.minecraft.server.management.PlayerManager;
import net.minecraft.server.management.PlayerProfileCache;
import net.minecraft.server.management.UserListBans;
import net.minecraft.server.management.UserListBansEntry;
import net.minecraft.server.management.UserListOps;
import net.minecraft.server.management.UserListOpsEntry;
import net.minecraft.server.management.UserListWhitelist;
import net.minecraft.server.management.UserListWhitelistEntry;
import net.minecraft.stats.StatList;
import net.minecraft.stats.StatisticsFile;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.border.IBorderListener;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.demo.DemoWorldManager;
import net.minecraft.world.storage.IPlayerFileData;
import net.minecraft.world.storage.WorldInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class ServerConfigurationManager {

   public static final File field_152613_a = new File("banned-players.json");
   public static final File field_152614_b = new File("banned-ips.json");
   public static final File field_152615_c = new File("ops.json");
   public static final File field_152616_d = new File("whitelist.json");
   private static final Logger field_148546_d = LogManager.getLogger();
   private static final SimpleDateFormat field_72403_e = new SimpleDateFormat("yyyy-MM-dd \'at\' HH:mm:ss z");
   private final MinecraftServer field_72400_f;
   public final List field_72404_b = Lists.newArrayList();
   public final Map field_177454_f = Maps.newHashMap();
   private final UserListBans field_72401_g;
   private final BanList field_72413_h;
   private final UserListOps field_72414_i;
   private final UserListWhitelist field_72411_j;
   private final Map field_148547_k;
   private IPlayerFileData field_72412_k;
   private boolean field_72409_l;
   protected int field_72405_c;
   private int field_72402_d;
   private WorldSettings.GameType field_72410_m;
   private boolean field_72407_n;
   private int field_72408_o;
   private static final String __OBFID = "CL_00001423";


   public ServerConfigurationManager(MinecraftServer p_i1500_1_) {
      this.field_72401_g = new UserListBans(field_152613_a);
      this.field_72413_h = new BanList(field_152614_b);
      this.field_72414_i = new UserListOps(field_152615_c);
      this.field_72411_j = new UserListWhitelist(field_152616_d);
      this.field_148547_k = Maps.newHashMap();
      this.field_72400_f = p_i1500_1_;
      this.field_72401_g.func_152686_a(false);
      this.field_72413_h.func_152686_a(false);
      this.field_72405_c = 8;
   }

   public void func_72355_a(NetworkManager p_72355_1_, EntityPlayerMP p_72355_2_) {
      GameProfile var3 = p_72355_2_.func_146103_bH();
      PlayerProfileCache var4 = this.field_72400_f.func_152358_ax();
      GameProfile var5 = var4.func_152652_a(var3.getId());
      String var6 = var5 == null?var3.getName():var5.getName();
      var4.func_152649_a(var3);
      NBTTagCompound var7 = this.func_72380_a(p_72355_2_);
      p_72355_2_.func_70029_a(this.field_72400_f.func_71218_a(p_72355_2_.field_71093_bK));
      p_72355_2_.field_71134_c.func_73080_a((WorldServer)p_72355_2_.field_70170_p);
      String var8 = "local";
      if(p_72355_1_.func_74430_c() != null) {
         var8 = p_72355_1_.func_74430_c().toString();
      }

      field_148546_d.info(p_72355_2_.func_70005_c_() + "[" + var8 + "] logged in with entity id " + p_72355_2_.func_145782_y() + " at (" + p_72355_2_.field_70165_t + ", " + p_72355_2_.field_70163_u + ", " + p_72355_2_.field_70161_v + ")");
      WorldServer var9 = this.field_72400_f.func_71218_a(p_72355_2_.field_71093_bK);
      WorldInfo var10 = var9.func_72912_H();
      BlockPos var11 = var9.func_175694_M();
      this.func_72381_a(p_72355_2_, (EntityPlayerMP)null, var9);
      NetHandlerPlayServer var12 = new NetHandlerPlayServer(this.field_72400_f, p_72355_1_, p_72355_2_);
      var12.func_147359_a(new S01PacketJoinGame(p_72355_2_.func_145782_y(), p_72355_2_.field_71134_c.func_73081_b(), var10.func_76093_s(), var9.field_73011_w.func_177502_q(), var9.func_175659_aa(), this.func_72352_l(), var10.func_76067_t(), var9.func_82736_K().func_82766_b("reducedDebugInfo")));
      var12.func_147359_a(new S3FPacketCustomPayload("MC|Brand", (new PacketBuffer(Unpooled.buffer())).func_180714_a(this.func_72365_p().getServerModName())));
      var12.func_147359_a(new S41PacketServerDifficulty(var10.func_176130_y(), var10.func_176123_z()));
      var12.func_147359_a(new S05PacketSpawnPosition(var11));
      var12.func_147359_a(new S39PacketPlayerAbilities(p_72355_2_.field_71075_bZ));
      var12.func_147359_a(new S09PacketHeldItemChange(p_72355_2_.field_71071_by.field_70461_c));
      p_72355_2_.func_147099_x().func_150877_d();
      p_72355_2_.func_147099_x().func_150884_b(p_72355_2_);
      this.func_96456_a((ServerScoreboard)var9.func_96441_U(), p_72355_2_);
      this.field_72400_f.func_147132_au();
      ChatComponentTranslation var13;
      if(!p_72355_2_.func_70005_c_().equalsIgnoreCase(var6)) {
         var13 = new ChatComponentTranslation("multiplayer.player.joined.renamed", new Object[]{p_72355_2_.func_145748_c_(), var6});
      } else {
         var13 = new ChatComponentTranslation("multiplayer.player.joined", new Object[]{p_72355_2_.func_145748_c_()});
      }

      var13.func_150256_b().func_150238_a(EnumChatFormatting.YELLOW);
      this.func_148539_a(var13);
      this.func_72377_c(p_72355_2_);
      var12.func_147364_a(p_72355_2_.field_70165_t, p_72355_2_.field_70163_u, p_72355_2_.field_70161_v, p_72355_2_.field_70177_z, p_72355_2_.field_70125_A);
      this.func_72354_b(p_72355_2_, var9);
      if(this.field_72400_f.func_147133_T().length() > 0) {
         p_72355_2_.func_175397_a(this.field_72400_f.func_147133_T(), this.field_72400_f.func_175581_ab());
      }

      Iterator var14 = p_72355_2_.func_70651_bq().iterator();

      while(var14.hasNext()) {
         PotionEffect var15 = (PotionEffect)var14.next();
         var12.func_147359_a(new S1DPacketEntityEffect(p_72355_2_.func_145782_y(), var15));
      }

      p_72355_2_.func_71116_b();
      if(var7 != null && var7.func_150297_b("Riding", 10)) {
         Entity var16 = EntityList.func_75615_a(var7.func_74775_l("Riding"), var9);
         if(var16 != null) {
            var16.field_98038_p = true;
            var9.func_72838_d(var16);
            p_72355_2_.func_70078_a(var16);
            var16.field_98038_p = false;
         }
      }

   }

   protected void func_96456_a(ServerScoreboard p_96456_1_, EntityPlayerMP p_96456_2_) {
      HashSet var3 = Sets.newHashSet();
      Iterator var4 = p_96456_1_.func_96525_g().iterator();

      while(var4.hasNext()) {
         ScorePlayerTeam var5 = (ScorePlayerTeam)var4.next();
         p_96456_2_.field_71135_a.func_147359_a(new S3EPacketTeams(var5, 0));
      }

      for(int var9 = 0; var9 < 19; ++var9) {
         ScoreObjective var10 = p_96456_1_.func_96539_a(var9);
         if(var10 != null && !var3.contains(var10)) {
            List var6 = p_96456_1_.func_96550_d(var10);
            Iterator var7 = var6.iterator();

            while(var7.hasNext()) {
               Packet var8 = (Packet)var7.next();
               p_96456_2_.field_71135_a.func_147359_a(var8);
            }

            var3.add(var10);
         }
      }

   }

   public void func_72364_a(WorldServer[] p_72364_1_) {
      this.field_72412_k = p_72364_1_[0].func_72860_G().func_75756_e();
      p_72364_1_[0].func_175723_af().func_177737_a(new IBorderListener() {

         private static final String __OBFID = "CL_00002267";

         public void func_177694_a(WorldBorder p_177694_1_, double p_177694_2_) {
            ServerConfigurationManager.this.func_148540_a(new S44PacketWorldBorder(p_177694_1_, S44PacketWorldBorder.Action.SET_SIZE));
         }
         public void func_177692_a(WorldBorder p_177692_1_, double p_177692_2_, double p_177692_4_, long p_177692_6_) {
            ServerConfigurationManager.this.func_148540_a(new S44PacketWorldBorder(p_177692_1_, S44PacketWorldBorder.Action.LERP_SIZE));
         }
         public void func_177693_a(WorldBorder p_177693_1_, double p_177693_2_, double p_177693_4_) {
            ServerConfigurationManager.this.func_148540_a(new S44PacketWorldBorder(p_177693_1_, S44PacketWorldBorder.Action.SET_CENTER));
         }
         public void func_177691_a(WorldBorder p_177691_1_, int p_177691_2_) {
            ServerConfigurationManager.this.func_148540_a(new S44PacketWorldBorder(p_177691_1_, S44PacketWorldBorder.Action.SET_WARNING_TIME));
         }
         public void func_177690_b(WorldBorder p_177690_1_, int p_177690_2_) {
            ServerConfigurationManager.this.func_148540_a(new S44PacketWorldBorder(p_177690_1_, S44PacketWorldBorder.Action.SET_WARNING_BLOCKS));
         }
         public void func_177696_b(WorldBorder p_177696_1_, double p_177696_2_) {}
         public void func_177695_c(WorldBorder p_177695_1_, double p_177695_2_) {}
      });
   }

   public void func_72375_a(EntityPlayerMP p_72375_1_, WorldServer p_72375_2_) {
      WorldServer var3 = p_72375_1_.func_71121_q();
      if(p_72375_2_ != null) {
         p_72375_2_.func_73040_p().func_72695_c(p_72375_1_);
      }

      var3.func_73040_p().func_72683_a(p_72375_1_);
      var3.field_73059_b.func_73158_c((int)p_72375_1_.field_70165_t >> 4, (int)p_72375_1_.field_70161_v >> 4);
   }

   public int func_72372_a() {
      return PlayerManager.func_72686_a(this.func_72395_o());
   }

   public NBTTagCompound func_72380_a(EntityPlayerMP p_72380_1_) {
      NBTTagCompound var2 = this.field_72400_f.field_71305_c[0].func_72912_H().func_76072_h();
      NBTTagCompound var3;
      if(p_72380_1_.func_70005_c_().equals(this.field_72400_f.func_71214_G()) && var2 != null) {
         p_72380_1_.func_70020_e(var2);
         var3 = var2;
         field_148546_d.debug("loading single player");
      } else {
         var3 = this.field_72412_k.func_75752_b(p_72380_1_);
      }

      return var3;
   }

   protected void func_72391_b(EntityPlayerMP p_72391_1_) {
      this.field_72412_k.func_75753_a(p_72391_1_);
      StatisticsFile var2 = (StatisticsFile)this.field_148547_k.get(p_72391_1_.func_110124_au());
      if(var2 != null) {
         var2.func_150883_b();
      }

   }

   public void func_72377_c(EntityPlayerMP p_72377_1_) {
      this.field_72404_b.add(p_72377_1_);
      this.field_177454_f.put(p_72377_1_.func_110124_au(), p_72377_1_);
      this.func_148540_a(new S38PacketPlayerListItem(S38PacketPlayerListItem.Action.ADD_PLAYER, new EntityPlayerMP[]{p_72377_1_}));
      WorldServer var2 = this.field_72400_f.func_71218_a(p_72377_1_.field_71093_bK);
      var2.func_72838_d(p_72377_1_);
      this.func_72375_a(p_72377_1_, (WorldServer)null);

      for(int var3 = 0; var3 < this.field_72404_b.size(); ++var3) {
         EntityPlayerMP var4 = (EntityPlayerMP)this.field_72404_b.get(var3);
         p_72377_1_.field_71135_a.func_147359_a(new S38PacketPlayerListItem(S38PacketPlayerListItem.Action.ADD_PLAYER, new EntityPlayerMP[]{var4}));
      }

   }

   public void func_72358_d(EntityPlayerMP p_72358_1_) {
      p_72358_1_.func_71121_q().func_73040_p().func_72685_d(p_72358_1_);
   }

   public void func_72367_e(EntityPlayerMP p_72367_1_) {
      p_72367_1_.func_71029_a(StatList.field_75947_j);
      this.func_72391_b(p_72367_1_);
      WorldServer var2 = p_72367_1_.func_71121_q();
      if(p_72367_1_.field_70154_o != null) {
         var2.func_72973_f(p_72367_1_.field_70154_o);
         field_148546_d.debug("removing player mount");
      }

      var2.func_72900_e(p_72367_1_);
      var2.func_73040_p().func_72695_c(p_72367_1_);
      this.field_72404_b.remove(p_72367_1_);
      this.field_177454_f.remove(p_72367_1_.func_110124_au());
      this.field_148547_k.remove(p_72367_1_.func_110124_au());
      this.func_148540_a(new S38PacketPlayerListItem(S38PacketPlayerListItem.Action.REMOVE_PLAYER, new EntityPlayerMP[]{p_72367_1_}));
   }

   public String func_148542_a(SocketAddress p_148542_1_, GameProfile p_148542_2_) {
      String var4;
      if(this.field_72401_g.func_152702_a(p_148542_2_)) {
         UserListBansEntry var5 = (UserListBansEntry)this.field_72401_g.func_152683_b(p_148542_2_);
         var4 = "You are banned from this server!\nReason: " + var5.func_73686_f();
         if(var5.func_73680_d() != null) {
            var4 = var4 + "\nYour ban will be removed on " + field_72403_e.format(var5.func_73680_d());
         }

         return var4;
      } else if(!this.func_152607_e(p_148542_2_)) {
         return "You are not white-listed on this server!";
      } else if(this.field_72413_h.func_152708_a(p_148542_1_)) {
         IPBanEntry var3 = this.field_72413_h.func_152709_b(p_148542_1_);
         var4 = "Your IP address is banned from this server!\nReason: " + var3.func_73686_f();
         if(var3.func_73680_d() != null) {
            var4 = var4 + "\nYour ban will be removed on " + field_72403_e.format(var3.func_73680_d());
         }

         return var4;
      } else {
         return this.field_72404_b.size() >= this.field_72405_c?"The server is full!":null;
      }
   }

   public EntityPlayerMP func_148545_a(GameProfile p_148545_1_) {
      UUID var2 = EntityPlayer.func_146094_a(p_148545_1_);
      ArrayList var3 = Lists.newArrayList();

      EntityPlayerMP var5;
      for(int var4 = 0; var4 < this.field_72404_b.size(); ++var4) {
         var5 = (EntityPlayerMP)this.field_72404_b.get(var4);
         if(var5.func_110124_au().equals(var2)) {
            var3.add(var5);
         }
      }

      Iterator var6 = var3.iterator();

      while(var6.hasNext()) {
         var5 = (EntityPlayerMP)var6.next();
         var5.field_71135_a.func_147360_c("You logged in from another location");
      }

      Object var7;
      if(this.field_72400_f.func_71242_L()) {
         var7 = new DemoWorldManager(this.field_72400_f.func_71218_a(0));
      } else {
         var7 = new ItemInWorldManager(this.field_72400_f.func_71218_a(0));
      }

      return new EntityPlayerMP(this.field_72400_f, this.field_72400_f.func_71218_a(0), p_148545_1_, (ItemInWorldManager)var7);
   }

   public EntityPlayerMP func_72368_a(EntityPlayerMP p_72368_1_, int p_72368_2_, boolean p_72368_3_) {
      p_72368_1_.func_71121_q().func_73039_n().func_72787_a(p_72368_1_);
      p_72368_1_.func_71121_q().func_73039_n().func_72790_b(p_72368_1_);
      p_72368_1_.func_71121_q().func_73040_p().func_72695_c(p_72368_1_);
      this.field_72404_b.remove(p_72368_1_);
      this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK).func_72973_f(p_72368_1_);
      BlockPos var4 = p_72368_1_.func_180470_cg();
      boolean var5 = p_72368_1_.func_82245_bX();
      p_72368_1_.field_71093_bK = p_72368_2_;
      Object var6;
      if(this.field_72400_f.func_71242_L()) {
         var6 = new DemoWorldManager(this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK));
      } else {
         var6 = new ItemInWorldManager(this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK));
      }

      EntityPlayerMP var7 = new EntityPlayerMP(this.field_72400_f, this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK), p_72368_1_.func_146103_bH(), (ItemInWorldManager)var6);
      var7.field_71135_a = p_72368_1_.field_71135_a;
      var7.func_71049_a(p_72368_1_, p_72368_3_);
      var7.func_145769_d(p_72368_1_.func_145782_y());
      var7.func_174817_o(p_72368_1_);
      WorldServer var8 = this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK);
      this.func_72381_a(var7, p_72368_1_, var8);
      BlockPos var9;
      if(var4 != null) {
         var9 = EntityPlayer.func_180467_a(this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK), var4, var5);
         if(var9 != null) {
            var7.func_70012_b((double)((float)var9.func_177958_n() + 0.5F), (double)((float)var9.func_177956_o() + 0.1F), (double)((float)var9.func_177952_p() + 0.5F), 0.0F, 0.0F);
            var7.func_180473_a(var4, var5);
         } else {
            var7.field_71135_a.func_147359_a(new S2BPacketChangeGameState(0, 0.0F));
         }
      }

      var8.field_73059_b.func_73158_c((int)var7.field_70165_t >> 4, (int)var7.field_70161_v >> 4);

      while(!var8.func_72945_a(var7, var7.func_174813_aQ()).isEmpty() && var7.field_70163_u < 256.0D) {
         var7.func_70107_b(var7.field_70165_t, var7.field_70163_u + 1.0D, var7.field_70161_v);
      }

      var7.field_71135_a.func_147359_a(new S07PacketRespawn(var7.field_71093_bK, var7.field_70170_p.func_175659_aa(), var7.field_70170_p.func_72912_H().func_76067_t(), var7.field_71134_c.func_73081_b()));
      var9 = var8.func_175694_M();
      var7.field_71135_a.func_147364_a(var7.field_70165_t, var7.field_70163_u, var7.field_70161_v, var7.field_70177_z, var7.field_70125_A);
      var7.field_71135_a.func_147359_a(new S05PacketSpawnPosition(var9));
      var7.field_71135_a.func_147359_a(new S1FPacketSetExperience(var7.field_71106_cc, var7.field_71067_cb, var7.field_71068_ca));
      this.func_72354_b(var7, var8);
      var8.func_73040_p().func_72683_a(var7);
      var8.func_72838_d(var7);
      this.field_72404_b.add(var7);
      this.field_177454_f.put(var7.func_110124_au(), var7);
      var7.func_71116_b();
      var7.func_70606_j(var7.func_110143_aJ());
      return var7;
   }

   public void func_72356_a(EntityPlayerMP p_72356_1_, int p_72356_2_) {
      int var3 = p_72356_1_.field_71093_bK;
      WorldServer var4 = this.field_72400_f.func_71218_a(p_72356_1_.field_71093_bK);
      p_72356_1_.field_71093_bK = p_72356_2_;
      WorldServer var5 = this.field_72400_f.func_71218_a(p_72356_1_.field_71093_bK);
      p_72356_1_.field_71135_a.func_147359_a(new S07PacketRespawn(p_72356_1_.field_71093_bK, p_72356_1_.field_70170_p.func_175659_aa(), p_72356_1_.field_70170_p.func_72912_H().func_76067_t(), p_72356_1_.field_71134_c.func_73081_b()));
      var4.func_72973_f(p_72356_1_);
      p_72356_1_.field_70128_L = false;
      this.func_82448_a(p_72356_1_, var3, var4, var5);
      this.func_72375_a(p_72356_1_, var4);
      p_72356_1_.field_71135_a.func_147364_a(p_72356_1_.field_70165_t, p_72356_1_.field_70163_u, p_72356_1_.field_70161_v, p_72356_1_.field_70177_z, p_72356_1_.field_70125_A);
      p_72356_1_.field_71134_c.func_73080_a(var5);
      this.func_72354_b(p_72356_1_, var5);
      this.func_72385_f(p_72356_1_);
      Iterator var6 = p_72356_1_.func_70651_bq().iterator();

      while(var6.hasNext()) {
         PotionEffect var7 = (PotionEffect)var6.next();
         p_72356_1_.field_71135_a.func_147359_a(new S1DPacketEntityEffect(p_72356_1_.func_145782_y(), var7));
      }

   }

   public void func_82448_a(Entity p_82448_1_, int p_82448_2_, WorldServer p_82448_3_, WorldServer p_82448_4_) {
      double var5 = p_82448_1_.field_70165_t;
      double var7 = p_82448_1_.field_70161_v;
      double var9 = 8.0D;
      float var11 = p_82448_1_.field_70177_z;
      p_82448_3_.field_72984_F.func_76320_a("moving");
      if(p_82448_1_.field_71093_bK == -1) {
         var5 = MathHelper.func_151237_a(var5 / var9, p_82448_4_.func_175723_af().func_177726_b() + 16.0D, p_82448_4_.func_175723_af().func_177728_d() - 16.0D);
         var7 = MathHelper.func_151237_a(var7 / var9, p_82448_4_.func_175723_af().func_177736_c() + 16.0D, p_82448_4_.func_175723_af().func_177733_e() - 16.0D);
         p_82448_1_.func_70012_b(var5, p_82448_1_.field_70163_u, var7, p_82448_1_.field_70177_z, p_82448_1_.field_70125_A);
         if(p_82448_1_.func_70089_S()) {
            p_82448_3_.func_72866_a(p_82448_1_, false);
         }
      } else if(p_82448_1_.field_71093_bK == 0) {
         var5 = MathHelper.func_151237_a(var5 * var9, p_82448_4_.func_175723_af().func_177726_b() + 16.0D, p_82448_4_.func_175723_af().func_177728_d() - 16.0D);
         var7 = MathHelper.func_151237_a(var7 * var9, p_82448_4_.func_175723_af().func_177736_c() + 16.0D, p_82448_4_.func_175723_af().func_177733_e() - 16.0D);
         p_82448_1_.func_70012_b(var5, p_82448_1_.field_70163_u, var7, p_82448_1_.field_70177_z, p_82448_1_.field_70125_A);
         if(p_82448_1_.func_70089_S()) {
            p_82448_3_.func_72866_a(p_82448_1_, false);
         }
      } else {
         BlockPos var12;
         if(p_82448_2_ == 1) {
            var12 = p_82448_4_.func_175694_M();
         } else {
            var12 = p_82448_4_.func_180504_m();
         }

         var5 = (double)var12.func_177958_n();
         p_82448_1_.field_70163_u = (double)var12.func_177956_o();
         var7 = (double)var12.func_177952_p();
         p_82448_1_.func_70012_b(var5, p_82448_1_.field_70163_u, var7, 90.0F, 0.0F);
         if(p_82448_1_.func_70089_S()) {
            p_82448_3_.func_72866_a(p_82448_1_, false);
         }
      }

      p_82448_3_.field_72984_F.func_76319_b();
      if(p_82448_2_ != 1) {
         p_82448_3_.field_72984_F.func_76320_a("placing");
         var5 = (double)MathHelper.func_76125_a((int)var5, -29999872, 29999872);
         var7 = (double)MathHelper.func_76125_a((int)var7, -29999872, 29999872);
         if(p_82448_1_.func_70089_S()) {
            p_82448_1_.func_70012_b(var5, p_82448_1_.field_70163_u, var7, p_82448_1_.field_70177_z, p_82448_1_.field_70125_A);
            p_82448_4_.func_85176_s().func_180266_a(p_82448_1_, var11);
            p_82448_4_.func_72838_d(p_82448_1_);
            p_82448_4_.func_72866_a(p_82448_1_, false);
         }

         p_82448_3_.field_72984_F.func_76319_b();
      }

      p_82448_1_.func_70029_a(p_82448_4_);
   }

   public void func_72374_b() {
      if(++this.field_72408_o > 600) {
         this.func_148540_a(new S38PacketPlayerListItem(S38PacketPlayerListItem.Action.UPDATE_LATENCY, this.field_72404_b));
         this.field_72408_o = 0;
      }

   }

   public void func_148540_a(Packet p_148540_1_) {
      for(int var2 = 0; var2 < this.field_72404_b.size(); ++var2) {
         ((EntityPlayerMP)this.field_72404_b.get(var2)).field_71135_a.func_147359_a(p_148540_1_);
      }

   }

   public void func_148537_a(Packet p_148537_1_, int p_148537_2_) {
      for(int var3 = 0; var3 < this.field_72404_b.size(); ++var3) {
         EntityPlayerMP var4 = (EntityPlayerMP)this.field_72404_b.get(var3);
         if(var4.field_71093_bK == p_148537_2_) {
            var4.field_71135_a.func_147359_a(p_148537_1_);
         }
      }

   }

   public void func_177453_a(EntityPlayer p_177453_1_, IChatComponent p_177453_2_) {
      Team var3 = p_177453_1_.func_96124_cp();
      if(var3 != null) {
         Collection var4 = var3.func_96670_d();
         Iterator var5 = var4.iterator();

         while(var5.hasNext()) {
            String var6 = (String)var5.next();
            EntityPlayerMP var7 = this.func_152612_a(var6);
            if(var7 != null && var7 != p_177453_1_) {
               var7.func_145747_a(p_177453_2_);
            }
         }

      }
   }

   public void func_177452_b(EntityPlayer p_177452_1_, IChatComponent p_177452_2_) {
      Team var3 = p_177452_1_.func_96124_cp();
      if(var3 == null) {
         this.func_148539_a(p_177452_2_);
      } else {
         for(int var4 = 0; var4 < this.field_72404_b.size(); ++var4) {
            EntityPlayerMP var5 = (EntityPlayerMP)this.field_72404_b.get(var4);
            if(var5.func_96124_cp() != var3) {
               var5.func_145747_a(p_177452_2_);
            }
         }

      }
   }

   public String func_180602_f() {
      String var1 = "";

      for(int var2 = 0; var2 < this.field_72404_b.size(); ++var2) {
         if(var2 > 0) {
            var1 = var1 + ", ";
         }

         var1 = var1 + ((EntityPlayerMP)this.field_72404_b.get(var2)).func_70005_c_();
      }

      return var1;
   }

   public String[] func_72369_d() {
      String[] var1 = new String[this.field_72404_b.size()];

      for(int var2 = 0; var2 < this.field_72404_b.size(); ++var2) {
         var1[var2] = ((EntityPlayerMP)this.field_72404_b.get(var2)).func_70005_c_();
      }

      return var1;
   }

   public GameProfile[] func_152600_g() {
      GameProfile[] var1 = new GameProfile[this.field_72404_b.size()];

      for(int var2 = 0; var2 < this.field_72404_b.size(); ++var2) {
         var1[var2] = ((EntityPlayerMP)this.field_72404_b.get(var2)).func_146103_bH();
      }

      return var1;
   }

   public UserListBans func_152608_h() {
      return this.field_72401_g;
   }

   public BanList func_72363_f() {
      return this.field_72413_h;
   }

   public void func_152605_a(GameProfile p_152605_1_) {
      this.field_72414_i.func_152687_a(new UserListOpsEntry(p_152605_1_, this.field_72400_f.func_110455_j()));
   }

   public void func_152610_b(GameProfile p_152610_1_) {
      this.field_72414_i.func_152684_c(p_152610_1_);
   }

   public boolean func_152607_e(GameProfile p_152607_1_) {
      return !this.field_72409_l || this.field_72414_i.func_152692_d(p_152607_1_) || this.field_72411_j.func_152692_d(p_152607_1_);
   }

   public boolean func_152596_g(GameProfile p_152596_1_) {
      return this.field_72414_i.func_152692_d(p_152596_1_) || this.field_72400_f.func_71264_H() && this.field_72400_f.field_71305_c[0].func_72912_H().func_76086_u() && this.field_72400_f.func_71214_G().equalsIgnoreCase(p_152596_1_.getName()) || this.field_72407_n;
   }

   public EntityPlayerMP func_152612_a(String p_152612_1_) {
      Iterator var2 = this.field_72404_b.iterator();

      EntityPlayerMP var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (EntityPlayerMP)var2.next();
      } while(!var3.func_70005_c_().equalsIgnoreCase(p_152612_1_));

      return var3;
   }

   public void func_148541_a(double p_148541_1_, double p_148541_3_, double p_148541_5_, double p_148541_7_, int p_148541_9_, Packet p_148541_10_) {
      this.func_148543_a((EntityPlayer)null, p_148541_1_, p_148541_3_, p_148541_5_, p_148541_7_, p_148541_9_, p_148541_10_);
   }

   public void func_148543_a(EntityPlayer p_148543_1_, double p_148543_2_, double p_148543_4_, double p_148543_6_, double p_148543_8_, int p_148543_10_, Packet p_148543_11_) {
      for(int var12 = 0; var12 < this.field_72404_b.size(); ++var12) {
         EntityPlayerMP var13 = (EntityPlayerMP)this.field_72404_b.get(var12);
         if(var13 != p_148543_1_ && var13.field_71093_bK == p_148543_10_) {
            double var14 = p_148543_2_ - var13.field_70165_t;
            double var16 = p_148543_4_ - var13.field_70163_u;
            double var18 = p_148543_6_ - var13.field_70161_v;
            if(var14 * var14 + var16 * var16 + var18 * var18 < p_148543_8_ * p_148543_8_) {
               var13.field_71135_a.func_147359_a(p_148543_11_);
            }
         }
      }

   }

   public void func_72389_g() {
      for(int var1 = 0; var1 < this.field_72404_b.size(); ++var1) {
         this.func_72391_b((EntityPlayerMP)this.field_72404_b.get(var1));
      }

   }

   public void func_152601_d(GameProfile p_152601_1_) {
      this.field_72411_j.func_152687_a(new UserListWhitelistEntry(p_152601_1_));
   }

   public void func_152597_c(GameProfile p_152597_1_) {
      this.field_72411_j.func_152684_c(p_152597_1_);
   }

   public UserListWhitelist func_152599_k() {
      return this.field_72411_j;
   }

   public String[] func_152598_l() {
      return this.field_72411_j.func_152685_a();
   }

   public UserListOps func_152603_m() {
      return this.field_72414_i;
   }

   public String[] func_152606_n() {
      return this.field_72414_i.func_152685_a();
   }

   public void func_72362_j() {}

   public void func_72354_b(EntityPlayerMP p_72354_1_, WorldServer p_72354_2_) {
      WorldBorder var3 = this.field_72400_f.field_71305_c[0].func_175723_af();
      p_72354_1_.field_71135_a.func_147359_a(new S44PacketWorldBorder(var3, S44PacketWorldBorder.Action.INITIALIZE));
      p_72354_1_.field_71135_a.func_147359_a(new S03PacketTimeUpdate(p_72354_2_.func_82737_E(), p_72354_2_.func_72820_D(), p_72354_2_.func_82736_K().func_82766_b("doDaylightCycle")));
      if(p_72354_2_.func_72896_J()) {
         p_72354_1_.field_71135_a.func_147359_a(new S2BPacketChangeGameState(1, 0.0F));
         p_72354_1_.field_71135_a.func_147359_a(new S2BPacketChangeGameState(7, p_72354_2_.func_72867_j(1.0F)));
         p_72354_1_.field_71135_a.func_147359_a(new S2BPacketChangeGameState(8, p_72354_2_.func_72819_i(1.0F)));
      }

   }

   public void func_72385_f(EntityPlayerMP p_72385_1_) {
      p_72385_1_.func_71120_a(p_72385_1_.field_71069_bz);
      p_72385_1_.func_71118_n();
      p_72385_1_.field_71135_a.func_147359_a(new S09PacketHeldItemChange(p_72385_1_.field_71071_by.field_70461_c));
   }

   public int func_72394_k() {
      return this.field_72404_b.size();
   }

   public int func_72352_l() {
      return this.field_72405_c;
   }

   public String[] func_72373_m() {
      return this.field_72400_f.field_71305_c[0].func_72860_G().func_75756_e().func_75754_f();
   }

   public void func_72371_a(boolean p_72371_1_) {
      this.field_72409_l = p_72371_1_;
   }

   public List func_72382_j(String p_72382_1_) {
      ArrayList var2 = Lists.newArrayList();
      Iterator var3 = this.field_72404_b.iterator();

      while(var3.hasNext()) {
         EntityPlayerMP var4 = (EntityPlayerMP)var3.next();
         if(var4.func_71114_r().equals(p_72382_1_)) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public int func_72395_o() {
      return this.field_72402_d;
   }

   public MinecraftServer func_72365_p() {
      return this.field_72400_f;
   }

   public NBTTagCompound func_72378_q() {
      return null;
   }

   public void func_152604_a(WorldSettings.GameType p_152604_1_) {
      this.field_72410_m = p_152604_1_;
   }

   private void func_72381_a(EntityPlayerMP p_72381_1_, EntityPlayerMP p_72381_2_, World p_72381_3_) {
      if(p_72381_2_ != null) {
         p_72381_1_.field_71134_c.func_73076_a(p_72381_2_.field_71134_c.func_73081_b());
      } else if(this.field_72410_m != null) {
         p_72381_1_.field_71134_c.func_73076_a(this.field_72410_m);
      }

      p_72381_1_.field_71134_c.func_73077_b(p_72381_3_.func_72912_H().func_76077_q());
   }

   public void func_72387_b(boolean p_72387_1_) {
      this.field_72407_n = p_72387_1_;
   }

   public void func_72392_r() {
      for(int var1 = 0; var1 < this.field_72404_b.size(); ++var1) {
         ((EntityPlayerMP)this.field_72404_b.get(var1)).field_71135_a.func_147360_c("Server closed");
      }

   }

   public void func_148544_a(IChatComponent p_148544_1_, boolean p_148544_2_) {
      this.field_72400_f.func_145747_a(p_148544_1_);
      int var3 = p_148544_2_?1:0;
      this.func_148540_a(new S02PacketChat(p_148544_1_, (byte)var3));
   }

   public void func_148539_a(IChatComponent p_148539_1_) {
      this.func_148544_a(p_148539_1_, true);
   }

   public StatisticsFile func_152602_a(EntityPlayer p_152602_1_) {
      UUID var2 = p_152602_1_.func_110124_au();
      StatisticsFile var3 = var2 == null?null:(StatisticsFile)this.field_148547_k.get(var2);
      if(var3 == null) {
         File var4 = new File(this.field_72400_f.func_71218_a(0).func_72860_G().func_75765_b(), "stats");
         File var5 = new File(var4, var2.toString() + ".json");
         if(!var5.exists()) {
            File var6 = new File(var4, p_152602_1_.func_70005_c_() + ".json");
            if(var6.exists() && var6.isFile()) {
               var6.renameTo(var5);
            }
         }

         var3 = new StatisticsFile(this.field_72400_f, var5);
         var3.func_150882_a();
         this.field_148547_k.put(var2, var3);
      }

      return var3;
   }

   public void func_152611_a(int p_152611_1_) {
      this.field_72402_d = p_152611_1_;
      if(this.field_72400_f.field_71305_c != null) {
         WorldServer[] var2 = this.field_72400_f.field_71305_c;
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            WorldServer var5 = var2[var4];
            if(var5 != null) {
               var5.func_73040_p().func_152622_a(p_152611_1_);
            }
         }

      }
   }

   public EntityPlayerMP func_177451_a(UUID p_177451_1_) {
      return (EntityPlayerMP)this.field_177454_f.get(p_177451_1_);
   }

}
