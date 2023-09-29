package net.minecraft.client.network;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.exceptions.AuthenticationUnavailableException;
import com.mojang.authlib.exceptions.InvalidCredentialsException;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.math.BigInteger;
import java.security.PublicKey;
import javax.crypto.SecretKey;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.login.INetHandlerLoginClient;
import net.minecraft.network.login.client.C01PacketEncryptionResponse;
import net.minecraft.network.login.server.S00PacketDisconnect;
import net.minecraft.network.login.server.S01PacketEncryptionRequest;
import net.minecraft.network.login.server.S02PacketLoginSuccess;
import net.minecraft.network.login.server.S03PacketEnableCompression;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.CryptManager;
import net.minecraft.util.IChatComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NetHandlerLoginClient implements INetHandlerLoginClient {

   private static final Logger field_147396_a = LogManager.getLogger();
   private final Minecraft field_147394_b;
   private final GuiScreen field_147395_c;
   private final NetworkManager field_147393_d;
   private GameProfile field_175091_e;
   private static final String __OBFID = "CL_00000876";


   public NetHandlerLoginClient(NetworkManager p_i45059_1_, Minecraft p_i45059_2_, GuiScreen p_i45059_3_) {
      this.field_147393_d = p_i45059_1_;
      this.field_147394_b = p_i45059_2_;
      this.field_147395_c = p_i45059_3_;
   }

   public void func_147389_a(S01PacketEncryptionRequest p_147389_1_) {
      final SecretKey var2 = CryptManager.func_75890_a();
      String var3 = p_147389_1_.func_149609_c();
      PublicKey var4 = p_147389_1_.func_149608_d();
      String var5 = (new BigInteger(CryptManager.func_75895_a(var3, var4, var2))).toString(16);

      try {
         this.func_147391_c().joinServer(this.field_147394_b.func_110432_I().func_148256_e(), this.field_147394_b.func_110432_I().func_148254_d(), var5);
      } catch (AuthenticationUnavailableException var7) {
         this.field_147393_d.func_150718_a(new ChatComponentTranslation("disconnect.loginFailedInfo", new Object[]{new ChatComponentTranslation("disconnect.loginFailedInfo.serversUnavailable", new Object[0])}));
         return;
      } catch (InvalidCredentialsException var8) {
         this.field_147393_d.func_150718_a(new ChatComponentTranslation("disconnect.loginFailedInfo", new Object[]{new ChatComponentTranslation("disconnect.loginFailedInfo.invalidSession", new Object[0])}));
         return;
      } catch (AuthenticationException var9) {
         this.field_147393_d.func_150718_a(new ChatComponentTranslation("disconnect.loginFailedInfo", new Object[]{var9.getMessage()}));
         return;
      }

      this.field_147393_d.func_179288_a(new C01PacketEncryptionResponse(var2, var4, p_147389_1_.func_149607_e()), new GenericFutureListener() {

         private static final String __OBFID = "CL_00000877";

         public void operationComplete(Future p_operationComplete_1_) {
            NetHandlerLoginClient.this.field_147393_d.func_150727_a(var2);
         }
      }, new GenericFutureListener[0]);
   }

   private MinecraftSessionService func_147391_c() {
      return this.field_147394_b.func_152347_ac();
   }

   public void func_147390_a(S02PacketLoginSuccess p_147390_1_) {
      this.field_175091_e = p_147390_1_.func_179730_a();
      this.field_147393_d.func_150723_a(EnumConnectionState.PLAY);
      this.field_147393_d.func_150719_a(new NetHandlerPlayClient(this.field_147394_b, this.field_147395_c, this.field_147393_d, this.field_175091_e));
   }

   public void func_147231_a(IChatComponent p_147231_1_) {
      this.field_147394_b.func_147108_a(new GuiDisconnected(this.field_147395_c, "connect.failed", p_147231_1_));
   }

   public void func_147388_a(S00PacketDisconnect p_147388_1_) {
      this.field_147393_d.func_150718_a(p_147388_1_.func_149603_c());
   }

   public void func_180464_a(S03PacketEnableCompression p_180464_1_) {
      if(!this.field_147393_d.func_150731_c()) {
         this.field_147393_d.func_179289_a(p_180464_1_.func_179731_a());
      }

   }

}
