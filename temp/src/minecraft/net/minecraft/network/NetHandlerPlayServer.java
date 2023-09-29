package net.minecraft.network;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import io.netty.buffer.Unpooled;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import net.minecraft.block.material.Material;
import net.minecraft.command.server.CommandBlockLogic;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityMinecartCommandBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.PacketThreadUtil;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.play.client.C00PacketKeepAlive;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.client.C0CPacketInput;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.network.play.client.C0EPacketClickWindow;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;
import net.minecraft.network.play.client.C11PacketEnchantItem;
import net.minecraft.network.play.client.C12PacketUpdateSign;
import net.minecraft.network.play.client.C13PacketPlayerAbilities;
import net.minecraft.network.play.client.C14PacketTabComplete;
import net.minecraft.network.play.client.C15PacketClientSettings;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.network.play.client.C18PacketSpectate;
import net.minecraft.network.play.client.C19PacketResourcePackStatus;
import net.minecraft.network.play.server.S00PacketKeepAlive;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S18PacketEntityTeleport;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.network.play.server.S2FPacketSetSlot;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;
import net.minecraft.network.play.server.S3APacketTabComplete;
import net.minecraft.network.play.server.S40PacketDisconnect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.server.management.UserListBansEntry;
import net.minecraft.stats.AchievementList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IntHashMap;
import net.minecraft.util.ReportedException;
import net.minecraft.world.WorldServer;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NetHandlerPlayServer implements INetHandlerPlayServer, IUpdatePlayerListBox {

   private static final Logger field_147370_c = LogManager.getLogger();
   public final NetworkManager field_147371_a;
   private final MinecraftServer field_147367_d;
   public EntityPlayerMP field_147369_b;
   private int field_147368_e;
   private int field_175090_f;
   private int field_147365_f;
   private boolean field_147366_g;
   private int field_147378_h;
   private long field_147379_i;
   private long field_147377_k;
   private int field_147374_l;
   private int field_147375_m;
   private IntHashMap field_147372_n = new IntHashMap();
   private double field_147373_o;
   private double field_147382_p;
   private double field_147381_q;
   private boolean field_147380_r = true;
   private static final String __OBFID = "CL_00001452";


   public NetHandlerPlayServer(MinecraftServer p_i1530_1_, NetworkManager p_i1530_2_, EntityPlayerMP p_i1530_3_) {
      this.field_147367_d = p_i1530_1_;
      this.field_147371_a = p_i1530_2_;
      p_i1530_2_.func_150719_a(this);
      this.field_147369_b = p_i1530_3_;
      p_i1530_3_.field_71135_a = this;
   }

   public void func_73660_a() {
      this.field_147366_g = false;
      ++this.field_147368_e;
      this.field_147367_d.field_71304_b.func_76320_a("keepAlive");
      if((long)this.field_147368_e - this.field_147377_k > 40L) {
         this.field_147377_k = (long)this.field_147368_e;
         this.field_147379_i = this.func_147363_d();
         this.field_147378_h = (int)this.field_147379_i;
         this.func_147359_a(new S00PacketKeepAlive(this.field_147378_h));
      }

      this.field_147367_d.field_71304_b.func_76319_b();
      if(this.field_147374_l > 0) {
         --this.field_147374_l;
      }

      if(this.field_147375_m > 0) {
         --this.field_147375_m;
      }

      if(this.field_147369_b.func_154331_x() > 0L && this.field_147367_d.func_143007_ar() > 0 && MinecraftServer.func_130071_aq() - this.field_147369_b.func_154331_x() > (long)(this.field_147367_d.func_143007_ar() * 1000 * 60)) {
         this.func_147360_c("You have been idle for too long!");
      }

   }

   public NetworkManager func_147362_b() {
      return this.field_147371_a;
   }

   public void func_147360_c(String p_147360_1_) {
      final ChatComponentText var2 = new ChatComponentText(p_147360_1_);
      this.field_147371_a.func_179288_a(new S40PacketDisconnect(var2), new GenericFutureListener() {

         private static final String __OBFID = "CL_00001453";

         public void operationComplete(Future p_operationComplete_1_) {
            NetHandlerPlayServer.this.field_147371_a.func_150718_a(var2);
         }
      }, new GenericFutureListener[0]);
      this.field_147371_a.func_150721_g();
      Futures.getUnchecked(this.field_147367_d.func_152344_a(new Runnable() {

         private static final String __OBFID = "CL_00001454";

         public void run() {
            NetHandlerPlayServer.this.field_147371_a.func_179293_l();
         }
      }));
   }

   public void func_147358_a(C0CPacketInput p_147358_1_) {
      PacketThreadUtil.func_180031_a(p_147358_1_, this, this.field_147369_b.func_71121_q());
      this.field_147369_b.func_110430_a(p_147358_1_.func_149620_c(), p_147358_1_.func_149616_d(), p_147358_1_.func_149618_e(), p_147358_1_.func_149617_f());
   }

   public void func_147347_a(C03PacketPlayer p_147347_1_) {
      PacketThreadUtil.func_180031_a(p_147347_1_, this, this.field_147369_b.func_71121_q());
      WorldServer var2 = this.field_147367_d.func_71218_a(this.field_147369_b.field_71093_bK);
      this.field_147366_g = true;
      if(!this.field_147369_b.field_71136_j) {
         double var3 = this.field_147369_b.field_70165_t;
         double var5 = this.field_147369_b.field_70163_u;
         double var7 = this.field_147369_b.field_70161_v;
         double var9 = 0.0D;
         double var11 = p_147347_1_.func_149464_c() - this.field_147373_o;
         double var13 = p_147347_1_.func_149467_d() - this.field_147382_p;
         double var15 = p_147347_1_.func_149472_e() - this.field_147381_q;
         if(p_147347_1_.func_149466_j()) {
            var9 = var11 * var11 + var13 * var13 + var15 * var15;
            if(!this.field_147380_r && var9 < 0.25D) {
               this.field_147380_r = true;
            }
         }

         if(this.field_147380_r) {
            this.field_175090_f = this.field_147368_e;
            double var19;
            double var21;
            double var23;
            if(this.field_147369_b.field_70154_o != null) {
               float var47 = this.field_147369_b.field_70177_z;
               float var18 = this.field_147369_b.field_70125_A;
               this.field_147369_b.field_70154_o.func_70043_V();
               var19 = this.field_147369_b.field_70165_t;
               var21 = this.field_147369_b.field_70163_u;
               var23 = this.field_147369_b.field_70161_v;
               if(p_147347_1_.func_149463_k()) {
                  var47 = p_147347_1_.func_149462_g();
                  var18 = p_147347_1_.func_149470_h();
               }

               this.field_147369_b.field_70122_E = p_147347_1_.func_149465_i();
               this.field_147369_b.func_71127_g();
               this.field_147369_b.func_70080_a(var19, var21, var23, var47, var18);
               if(this.field_147369_b.field_70154_o != null) {
                  this.field_147369_b.field_70154_o.func_70043_V();
               }

               this.field_147367_d.func_71203_ab().func_72358_d(this.field_147369_b);
               if(this.field_147369_b.field_70154_o != null) {
                  if(var9 > 4.0D) {
                     Entity var48 = this.field_147369_b.field_70154_o;
                     this.field_147369_b.field_71135_a.func_147359_a(new S18PacketEntityTeleport(var48));
                     this.func_147364_a(this.field_147369_b.field_70165_t, this.field_147369_b.field_70163_u, this.field_147369_b.field_70161_v, this.field_147369_b.field_70177_z, this.field_147369_b.field_70125_A);
                  }

                  this.field_147369_b.field_70154_o.field_70160_al = true;
               }

               if(this.field_147380_r) {
                  this.field_147373_o = this.field_147369_b.field_70165_t;
                  this.field_147382_p = this.field_147369_b.field_70163_u;
                  this.field_147381_q = this.field_147369_b.field_70161_v;
               }

               var2.func_72870_g(this.field_147369_b);
               return;
            }

            if(this.field_147369_b.func_70608_bn()) {
               this.field_147369_b.func_71127_g();
               this.field_147369_b.func_70080_a(this.field_147373_o, this.field_147382_p, this.field_147381_q, this.field_147369_b.field_70177_z, this.field_147369_b.field_70125_A);
               var2.func_72870_g(this.field_147369_b);
               return;
            }

            double var17 = this.field_147369_b.field_70163_u;
            this.field_147373_o = this.field_147369_b.field_70165_t;
            this.field_147382_p = this.field_147369_b.field_70163_u;
            this.field_147381_q = this.field_147369_b.field_70161_v;
            var19 = this.field_147369_b.field_70165_t;
            var21 = this.field_147369_b.field_70163_u;
            var23 = this.field_147369_b.field_70161_v;
            float var25 = this.field_147369_b.field_70177_z;
            float var26 = this.field_147369_b.field_70125_A;
            if(p_147347_1_.func_149466_j() && p_147347_1_.func_149467_d() == -999.0D) {
               p_147347_1_.func_149469_a(false);
            }

            if(p_147347_1_.func_149466_j()) {
               var19 = p_147347_1_.func_149464_c();
               var21 = p_147347_1_.func_149467_d();
               var23 = p_147347_1_.func_149472_e();
               if(Math.abs(p_147347_1_.func_149464_c()) > 3.0E7D || Math.abs(p_147347_1_.func_149472_e()) > 3.0E7D) {
                  this.func_147360_c("Illegal position");
                  return;
               }
            }

            if(p_147347_1_.func_149463_k()) {
               var25 = p_147347_1_.func_149462_g();
               var26 = p_147347_1_.func_149470_h();
            }

            this.field_147369_b.func_71127_g();
            this.field_147369_b.func_70080_a(this.field_147373_o, this.field_147382_p, this.field_147381_q, var25, var26);
            if(!this.field_147380_r) {
               return;
            }

            double var27 = var19 - this.field_147369_b.field_70165_t;
            double var29 = var21 - this.field_147369_b.field_70163_u;
            double var31 = var23 - this.field_147369_b.field_70161_v;
            double var33 = Math.min(Math.abs(var27), Math.abs(this.field_147369_b.field_70159_w));
            double var35 = Math.min(Math.abs(var29), Math.abs(this.field_147369_b.field_70181_x));
            double var37 = Math.min(Math.abs(var31), Math.abs(this.field_147369_b.field_70179_y));
            double var39 = var33 * var33 + var35 * var35 + var37 * var37;
            if(var39 > 100.0D && (!this.field_147367_d.func_71264_H() || !this.field_147367_d.func_71214_G().equals(this.field_147369_b.func_70005_c_()))) {
               field_147370_c.warn(this.field_147369_b.func_70005_c_() + " moved too quickly! " + var27 + "," + var29 + "," + var31 + " (" + var33 + ", " + var35 + ", " + var37 + ")");
               this.func_147364_a(this.field_147373_o, this.field_147382_p, this.field_147381_q, this.field_147369_b.field_70177_z, this.field_147369_b.field_70125_A);
               return;
            }

            float var41 = 0.0625F;
            boolean var42 = var2.func_72945_a(this.field_147369_b, this.field_147369_b.func_174813_aQ().func_72331_e((double)var41, (double)var41, (double)var41)).isEmpty();
            if(this.field_147369_b.field_70122_E && !p_147347_1_.func_149465_i() && var29 > 0.0D) {
               this.field_147369_b.func_70664_aZ();
            }

            this.field_147369_b.func_70091_d(var27, var29, var31);
            this.field_147369_b.field_70122_E = p_147347_1_.func_149465_i();
            double var43 = var29;
            var27 = var19 - this.field_147369_b.field_70165_t;
            var29 = var21 - this.field_147369_b.field_70163_u;
            if(var29 > -0.5D || var29 < 0.5D) {
               var29 = 0.0D;
            }

            var31 = var23 - this.field_147369_b.field_70161_v;
            var39 = var27 * var27 + var29 * var29 + var31 * var31;
            boolean var45 = false;
            if(var39 > 0.0625D && !this.field_147369_b.func_70608_bn() && !this.field_147369_b.field_71134_c.func_73083_d()) {
               var45 = true;
               field_147370_c.warn(this.field_147369_b.func_70005_c_() + " moved wrongly!");
            }

            this.field_147369_b.func_70080_a(var19, var21, var23, var25, var26);
            this.field_147369_b.func_71000_j(this.field_147369_b.field_70165_t - var3, this.field_147369_b.field_70163_u - var5, this.field_147369_b.field_70161_v - var7);
            if(!this.field_147369_b.field_70145_X) {
               boolean var46 = var2.func_72945_a(this.field_147369_b, this.field_147369_b.func_174813_aQ().func_72331_e((double)var41, (double)var41, (double)var41)).isEmpty();
               if(var42 && (var45 || !var46) && !this.field_147369_b.func_70608_bn()) {
                  this.func_147364_a(this.field_147373_o, this.field_147382_p, this.field_147381_q, var25, var26);
                  return;
               }
            }

            AxisAlignedBB var49 = this.field_147369_b.func_174813_aQ().func_72314_b((double)var41, (double)var41, (double)var41).func_72321_a(0.0D, -0.55D, 0.0D);
            if(!this.field_147367_d.func_71231_X() && !this.field_147369_b.field_71075_bZ.field_75101_c && !var2.func_72829_c(var49)) {
               if(var43 >= -0.03125D) {
                  ++this.field_147365_f;
                  if(this.field_147365_f > 80) {
                     field_147370_c.warn(this.field_147369_b.func_70005_c_() + " was kicked for floating too long!");
                     this.func_147360_c("Flying is not enabled on this server");
                     return;
                  }
               }
            } else {
               this.field_147365_f = 0;
            }

            this.field_147369_b.field_70122_E = p_147347_1_.func_149465_i();
            this.field_147367_d.func_71203_ab().func_72358_d(this.field_147369_b);
            this.field_147369_b.func_71122_b(this.field_147369_b.field_70163_u - var17, p_147347_1_.func_149465_i());
         } else if(this.field_147368_e - this.field_175090_f > 20) {
            this.func_147364_a(this.field_147373_o, this.field_147382_p, this.field_147381_q, this.field_147369_b.field_70177_z, this.field_147369_b.field_70125_A);
         }

      }
   }

   public void func_147364_a(double p_147364_1_, double p_147364_3_, double p_147364_5_, float p_147364_7_, float p_147364_8_) {
      this.func_175089_a(p_147364_1_, p_147364_3_, p_147364_5_, p_147364_7_, p_147364_8_, Collections.emptySet());
   }

   public void func_175089_a(double p_175089_1_, double p_175089_3_, double p_175089_5_, float p_175089_7_, float p_175089_8_, Set p_175089_9_) {
      this.field_147380_r = false;
      this.field_147373_o = p_175089_1_;
      this.field_147382_p = p_175089_3_;
      this.field_147381_q = p_175089_5_;
      if(p_175089_9_.contains(S08PacketPlayerPosLook.EnumFlags.X)) {
         this.field_147373_o += this.field_147369_b.field_70165_t;
      }

      if(p_175089_9_.contains(S08PacketPlayerPosLook.EnumFlags.Y)) {
         this.field_147382_p += this.field_147369_b.field_70163_u;
      }

      if(p_175089_9_.contains(S08PacketPlayerPosLook.EnumFlags.Z)) {
         this.field_147381_q += this.field_147369_b.field_70161_v;
      }

      float var10 = p_175089_7_;
      float var11 = p_175089_8_;
      if(p_175089_9_.contains(S08PacketPlayerPosLook.EnumFlags.Y_ROT)) {
         var10 = p_175089_7_ + this.field_147369_b.field_70177_z;
      }

      if(p_175089_9_.contains(S08PacketPlayerPosLook.EnumFlags.X_ROT)) {
         var11 = p_175089_8_ + this.field_147369_b.field_70125_A;
      }

      this.field_147369_b.func_70080_a(this.field_147373_o, this.field_147382_p, this.field_147381_q, var10, var11);
      this.field_147369_b.field_71135_a.func_147359_a(new S08PacketPlayerPosLook(p_175089_1_, p_175089_3_, p_175089_5_, p_175089_7_, p_175089_8_, p_175089_9_));
   }

   public void func_147345_a(C07PacketPlayerDigging p_147345_1_) {
      PacketThreadUtil.func_180031_a(p_147345_1_, this, this.field_147369_b.func_71121_q());
      WorldServer var2 = this.field_147367_d.func_71218_a(this.field_147369_b.field_71093_bK);
      BlockPos var3 = p_147345_1_.func_179715_a();
      this.field_147369_b.func_143004_u();
      switch(NetHandlerPlayServer.SwitchAction.field_180224_a[p_147345_1_.func_180762_c().ordinal()]) {
      case 1:
         if(!this.field_147369_b.func_175149_v()) {
            this.field_147369_b.func_71040_bB(false);
         }

         return;
      case 2:
         if(!this.field_147369_b.func_175149_v()) {
            this.field_147369_b.func_71040_bB(true);
         }

         return;
      case 3:
         this.field_147369_b.func_71034_by();
         return;
      case 4:
      case 5:
      case 6:
         double var4 = this.field_147369_b.field_70165_t - ((double)var3.func_177958_n() + 0.5D);
         double var6 = this.field_147369_b.field_70163_u - ((double)var3.func_177956_o() + 0.5D) + 1.5D;
         double var8 = this.field_147369_b.field_70161_v - ((double)var3.func_177952_p() + 0.5D);
         double var10 = var4 * var4 + var6 * var6 + var8 * var8;
         if(var10 > 36.0D) {
            return;
         } else if(var3.func_177956_o() >= this.field_147367_d.func_71207_Z()) {
            return;
         } else {
            if(p_147345_1_.func_180762_c() == C07PacketPlayerDigging.Action.START_DESTROY_BLOCK) {
               if(!this.field_147367_d.func_175579_a(var2, var3, this.field_147369_b) && var2.func_175723_af().func_177746_a(var3)) {
                  this.field_147369_b.field_71134_c.func_180784_a(var3, p_147345_1_.func_179714_b());
               } else {
                  this.field_147369_b.field_71135_a.func_147359_a(new S23PacketBlockChange(var2, var3));
               }
            } else {
               if(p_147345_1_.func_180762_c() == C07PacketPlayerDigging.Action.STOP_DESTROY_BLOCK) {
                  this.field_147369_b.field_71134_c.func_180785_a(var3);
               } else if(p_147345_1_.func_180762_c() == C07PacketPlayerDigging.Action.ABORT_DESTROY_BLOCK) {
                  this.field_147369_b.field_71134_c.func_180238_e();
               }

               if(var2.func_180495_p(var3).func_177230_c().func_149688_o() != Material.field_151579_a) {
                  this.field_147369_b.field_71135_a.func_147359_a(new S23PacketBlockChange(var2, var3));
               }
            }

            return;
         }
      default:
         throw new IllegalArgumentException("Invalid player action");
      }
   }

   public void func_147346_a(C08PacketPlayerBlockPlacement p_147346_1_) {
      PacketThreadUtil.func_180031_a(p_147346_1_, this, this.field_147369_b.func_71121_q());
      WorldServer var2 = this.field_147367_d.func_71218_a(this.field_147369_b.field_71093_bK);
      ItemStack var3 = this.field_147369_b.field_71071_by.func_70448_g();
      boolean var4 = false;
      BlockPos var5 = p_147346_1_.func_179724_a();
      EnumFacing var6 = EnumFacing.func_82600_a(p_147346_1_.func_149568_f());
      this.field_147369_b.func_143004_u();
      if(p_147346_1_.func_149568_f() == 255) {
         if(var3 == null) {
            return;
         }

         this.field_147369_b.field_71134_c.func_73085_a(this.field_147369_b, var2, var3);
      } else if(var5.func_177956_o() >= this.field_147367_d.func_71207_Z() - 1 && (var6 == EnumFacing.UP || var5.func_177956_o() >= this.field_147367_d.func_71207_Z())) {
         ChatComponentTranslation var7 = new ChatComponentTranslation("build.tooHigh", new Object[]{Integer.valueOf(this.field_147367_d.func_71207_Z())});
         var7.func_150256_b().func_150238_a(EnumChatFormatting.RED);
         this.field_147369_b.field_71135_a.func_147359_a(new S02PacketChat(var7));
         var4 = true;
      } else {
         if(this.field_147380_r && this.field_147369_b.func_70092_e((double)var5.func_177958_n() + 0.5D, (double)var5.func_177956_o() + 0.5D, (double)var5.func_177952_p() + 0.5D) < 64.0D && !this.field_147367_d.func_175579_a(var2, var5, this.field_147369_b) && var2.func_175723_af().func_177746_a(var5)) {
            this.field_147369_b.field_71134_c.func_180236_a(this.field_147369_b, var2, var3, var5, var6, p_147346_1_.func_149573_h(), p_147346_1_.func_149569_i(), p_147346_1_.func_149575_j());
         }

         var4 = true;
      }

      if(var4) {
         this.field_147369_b.field_71135_a.func_147359_a(new S23PacketBlockChange(var2, var5));
         this.field_147369_b.field_71135_a.func_147359_a(new S23PacketBlockChange(var2, var5.func_177972_a(var6)));
      }

      var3 = this.field_147369_b.field_71071_by.func_70448_g();
      if(var3 != null && var3.field_77994_a == 0) {
         this.field_147369_b.field_71071_by.field_70462_a[this.field_147369_b.field_71071_by.field_70461_c] = null;
         var3 = null;
      }

      if(var3 == null || var3.func_77988_m() == 0) {
         this.field_147369_b.field_71137_h = true;
         this.field_147369_b.field_71071_by.field_70462_a[this.field_147369_b.field_71071_by.field_70461_c] = ItemStack.func_77944_b(this.field_147369_b.field_71071_by.field_70462_a[this.field_147369_b.field_71071_by.field_70461_c]);
         Slot var8 = this.field_147369_b.field_71070_bA.func_75147_a(this.field_147369_b.field_71071_by, this.field_147369_b.field_71071_by.field_70461_c);
         this.field_147369_b.field_71070_bA.func_75142_b();
         this.field_147369_b.field_71137_h = false;
         if(!ItemStack.func_77989_b(this.field_147369_b.field_71071_by.func_70448_g(), p_147346_1_.func_149574_g())) {
            this.func_147359_a(new S2FPacketSetSlot(this.field_147369_b.field_71070_bA.field_75152_c, var8.field_75222_d, this.field_147369_b.field_71071_by.func_70448_g()));
         }
      }

   }

   public void func_175088_a(C18PacketSpectate p_175088_1_) {
      PacketThreadUtil.func_180031_a(p_175088_1_, this, this.field_147369_b.func_71121_q());
      if(this.field_147369_b.func_175149_v()) {
         Entity var2 = null;
         WorldServer[] var3 = this.field_147367_d.field_71305_c;
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            WorldServer var6 = var3[var5];
            if(var6 != null) {
               var2 = p_175088_1_.func_179727_a(var6);
               if(var2 != null) {
                  break;
               }
            }
         }

         if(var2 != null) {
            this.field_147369_b.func_175399_e(this.field_147369_b);
            this.field_147369_b.func_70078_a((Entity)null);
            if(var2.field_70170_p != this.field_147369_b.field_70170_p) {
               WorldServer var7 = this.field_147369_b.func_71121_q();
               WorldServer var8 = (WorldServer)var2.field_70170_p;
               this.field_147369_b.field_71093_bK = var2.field_71093_bK;
               this.func_147359_a(new S07PacketRespawn(this.field_147369_b.field_71093_bK, var7.func_175659_aa(), var7.func_72912_H().func_76067_t(), this.field_147369_b.field_71134_c.func_73081_b()));
               var7.func_72973_f(this.field_147369_b);
               this.field_147369_b.field_70128_L = false;
               this.field_147369_b.func_70012_b(var2.field_70165_t, var2.field_70163_u, var2.field_70161_v, var2.field_70177_z, var2.field_70125_A);
               if(this.field_147369_b.func_70089_S()) {
                  var7.func_72866_a(this.field_147369_b, false);
                  var8.func_72838_d(this.field_147369_b);
                  var8.func_72866_a(this.field_147369_b, false);
               }

               this.field_147369_b.func_70029_a(var8);
               this.field_147367_d.func_71203_ab().func_72375_a(this.field_147369_b, var7);
               this.field_147369_b.func_70634_a(var2.field_70165_t, var2.field_70163_u, var2.field_70161_v);
               this.field_147369_b.field_71134_c.func_73080_a(var8);
               this.field_147367_d.func_71203_ab().func_72354_b(this.field_147369_b, var8);
               this.field_147367_d.func_71203_ab().func_72385_f(this.field_147369_b);
            } else {
               this.field_147369_b.func_70634_a(var2.field_70165_t, var2.field_70163_u, var2.field_70161_v);
            }
         }
      }

   }

   public void func_175086_a(C19PacketResourcePackStatus p_175086_1_) {}

   public void func_147231_a(IChatComponent p_147231_1_) {
      field_147370_c.info(this.field_147369_b.func_70005_c_() + " lost connection: " + p_147231_1_);
      this.field_147367_d.func_147132_au();
      ChatComponentTranslation var2 = new ChatComponentTranslation("multiplayer.player.left", new Object[]{this.field_147369_b.func_145748_c_()});
      var2.func_150256_b().func_150238_a(EnumChatFormatting.YELLOW);
      this.field_147367_d.func_71203_ab().func_148539_a(var2);
      this.field_147369_b.func_71123_m();
      this.field_147367_d.func_71203_ab().func_72367_e(this.field_147369_b);
      if(this.field_147367_d.func_71264_H() && this.field_147369_b.func_70005_c_().equals(this.field_147367_d.func_71214_G())) {
         field_147370_c.info("Stopping singleplayer server as player logged out");
         this.field_147367_d.func_71263_m();
      }

   }

   public void func_147359_a(final Packet p_147359_1_) {
      if(p_147359_1_ instanceof S02PacketChat) {
         S02PacketChat var2 = (S02PacketChat)p_147359_1_;
         EntityPlayer.EnumChatVisibility var3 = this.field_147369_b.func_147096_v();
         if(var3 == EntityPlayer.EnumChatVisibility.HIDDEN) {
            return;
         }

         if(var3 == EntityPlayer.EnumChatVisibility.SYSTEM && !var2.func_148916_d()) {
            return;
         }
      }

      try {
         this.field_147371_a.func_179290_a(p_147359_1_);
      } catch (Throwable var5) {
         CrashReport var6 = CrashReport.func_85055_a(var5, "Sending packet");
         CrashReportCategory var4 = var6.func_85058_a("Packet being sent");
         var4.func_71500_a("Packet class", new Callable() {

            private static final String __OBFID = "CL_00002270";

            public String func_180225_a() {
               return p_147359_1_.getClass().getCanonicalName();
            }
            // $FF: synthetic method
            public Object call() {
               return this.func_180225_a();
            }
         });
         throw new ReportedException(var6);
      }
   }

   public void func_147355_a(C09PacketHeldItemChange p_147355_1_) {
      PacketThreadUtil.func_180031_a(p_147355_1_, this, this.field_147369_b.func_71121_q());
      if(p_147355_1_.func_149614_c() >= 0 && p_147355_1_.func_149614_c() < InventoryPlayer.func_70451_h()) {
         this.field_147369_b.field_71071_by.field_70461_c = p_147355_1_.func_149614_c();
         this.field_147369_b.func_143004_u();
      } else {
         field_147370_c.warn(this.field_147369_b.func_70005_c_() + " tried to set an invalid carried item");
      }
   }

   public void func_147354_a(C01PacketChatMessage p_147354_1_) {
      PacketThreadUtil.func_180031_a(p_147354_1_, this, this.field_147369_b.func_71121_q());
      if(this.field_147369_b.func_147096_v() == EntityPlayer.EnumChatVisibility.HIDDEN) {
         ChatComponentTranslation var4 = new ChatComponentTranslation("chat.cannotSend", new Object[0]);
         var4.func_150256_b().func_150238_a(EnumChatFormatting.RED);
         this.func_147359_a(new S02PacketChat(var4));
      } else {
         this.field_147369_b.func_143004_u();
         String var2 = p_147354_1_.func_149439_c();
         var2 = StringUtils.normalizeSpace(var2);

         for(int var3 = 0; var3 < var2.length(); ++var3) {
            if(!ChatAllowedCharacters.func_71566_a(var2.charAt(var3))) {
               this.func_147360_c("Illegal characters in chat");
               return;
            }
         }

         if(var2.startsWith("/")) {
            this.func_147361_d(var2);
         } else {
            ChatComponentTranslation var5 = new ChatComponentTranslation("chat.type.text", new Object[]{this.field_147369_b.func_145748_c_(), var2});
            this.field_147367_d.func_71203_ab().func_148544_a(var5, false);
         }

         this.field_147374_l += 20;
         if(this.field_147374_l > 200 && !this.field_147367_d.func_71203_ab().func_152596_g(this.field_147369_b.func_146103_bH())) {
            this.func_147360_c("disconnect.spam");
         }

      }
   }

   private void func_147361_d(String p_147361_1_) {
      this.field_147367_d.func_71187_D().func_71556_a(this.field_147369_b, p_147361_1_);
   }

   public void func_175087_a(C0APacketAnimation p_175087_1_) {
      PacketThreadUtil.func_180031_a(p_175087_1_, this, this.field_147369_b.func_71121_q());
      this.field_147369_b.func_143004_u();
      this.field_147369_b.func_71038_i();
   }

   public void func_147357_a(C0BPacketEntityAction p_147357_1_) {
      PacketThreadUtil.func_180031_a(p_147357_1_, this, this.field_147369_b.func_71121_q());
      this.field_147369_b.func_143004_u();
      switch(NetHandlerPlayServer.SwitchAction.field_180222_b[p_147357_1_.func_180764_b().ordinal()]) {
      case 1:
         this.field_147369_b.func_70095_a(true);
         break;
      case 2:
         this.field_147369_b.func_70095_a(false);
         break;
      case 3:
         this.field_147369_b.func_70031_b(true);
         break;
      case 4:
         this.field_147369_b.func_70031_b(false);
         break;
      case 5:
         this.field_147369_b.func_70999_a(false, true, true);
         this.field_147380_r = false;
         break;
      case 6:
         if(this.field_147369_b.field_70154_o instanceof EntityHorse) {
            ((EntityHorse)this.field_147369_b.field_70154_o).func_110206_u(p_147357_1_.func_149512_e());
         }
         break;
      case 7:
         if(this.field_147369_b.field_70154_o instanceof EntityHorse) {
            ((EntityHorse)this.field_147369_b.field_70154_o).func_110199_f(this.field_147369_b);
         }
         break;
      default:
         throw new IllegalArgumentException("Invalid client command!");
      }

   }

   public void func_147340_a(C02PacketUseEntity p_147340_1_) {
      PacketThreadUtil.func_180031_a(p_147340_1_, this, this.field_147369_b.func_71121_q());
      WorldServer var2 = this.field_147367_d.func_71218_a(this.field_147369_b.field_71093_bK);
      Entity var3 = p_147340_1_.func_149564_a(var2);
      this.field_147369_b.func_143004_u();
      if(var3 != null) {
         boolean var4 = this.field_147369_b.func_70685_l(var3);
         double var5 = 36.0D;
         if(!var4) {
            var5 = 9.0D;
         }

         if(this.field_147369_b.func_70068_e(var3) < var5) {
            if(p_147340_1_.func_149565_c() == C02PacketUseEntity.Action.INTERACT) {
               this.field_147369_b.func_70998_m(var3);
            } else if(p_147340_1_.func_149565_c() == C02PacketUseEntity.Action.INTERACT_AT) {
               var3.func_174825_a(this.field_147369_b, p_147340_1_.func_179712_b());
            } else if(p_147340_1_.func_149565_c() == C02PacketUseEntity.Action.ATTACK) {
               if(var3 instanceof EntityItem || var3 instanceof EntityXPOrb || var3 instanceof EntityArrow || var3 == this.field_147369_b) {
                  this.func_147360_c("Attempting to attack an invalid entity");
                  this.field_147367_d.func_71236_h("Player " + this.field_147369_b.func_70005_c_() + " tried to attack an invalid entity");
                  return;
               }

               this.field_147369_b.func_71059_n(var3);
            }
         }
      }

   }

   public void func_147342_a(C16PacketClientStatus p_147342_1_) {
      PacketThreadUtil.func_180031_a(p_147342_1_, this, this.field_147369_b.func_71121_q());
      this.field_147369_b.func_143004_u();
      C16PacketClientStatus.EnumState var2 = p_147342_1_.func_149435_c();
      switch(NetHandlerPlayServer.SwitchAction.field_180223_c[var2.ordinal()]) {
      case 1:
         if(this.field_147369_b.field_71136_j) {
            this.field_147369_b = this.field_147367_d.func_71203_ab().func_72368_a(this.field_147369_b, 0, true);
         } else if(this.field_147369_b.func_71121_q().func_72912_H().func_76093_s()) {
            if(this.field_147367_d.func_71264_H() && this.field_147369_b.func_70005_c_().equals(this.field_147367_d.func_71214_G())) {
               this.field_147369_b.field_71135_a.func_147360_c("You have died. Game over, man, it\'s game over!");
               this.field_147367_d.func_71272_O();
            } else {
               UserListBansEntry var3 = new UserListBansEntry(this.field_147369_b.func_146103_bH(), (Date)null, "(You just lost the game)", (Date)null, "Death in Hardcore");
               this.field_147367_d.func_71203_ab().func_152608_h().func_152687_a(var3);
               this.field_147369_b.field_71135_a.func_147360_c("You have died. Game over, man, it\'s game over!");
            }
         } else {
            if(this.field_147369_b.func_110143_aJ() > 0.0F) {
               return;
            }

            this.field_147369_b = this.field_147367_d.func_71203_ab().func_72368_a(this.field_147369_b, 0, false);
         }
         break;
      case 2:
         this.field_147369_b.func_147099_x().func_150876_a(this.field_147369_b);
         break;
      case 3:
         this.field_147369_b.func_71029_a(AchievementList.field_76004_f);
      }

   }

   public void func_147356_a(C0DPacketCloseWindow p_147356_1_) {
      PacketThreadUtil.func_180031_a(p_147356_1_, this, this.field_147369_b.func_71121_q());
      this.field_147369_b.func_71128_l();
   }

   public void func_147351_a(C0EPacketClickWindow p_147351_1_) {
      PacketThreadUtil.func_180031_a(p_147351_1_, this, this.field_147369_b.func_71121_q());
      this.field_147369_b.func_143004_u();
      if(this.field_147369_b.field_71070_bA.field_75152_c == p_147351_1_.func_149548_c() && this.field_147369_b.field_71070_bA.func_75129_b(this.field_147369_b)) {
         if(this.field_147369_b.func_175149_v()) {
            ArrayList var2 = Lists.newArrayList();

            for(int var3 = 0; var3 < this.field_147369_b.field_71070_bA.field_75151_b.size(); ++var3) {
               var2.add(((Slot)this.field_147369_b.field_71070_bA.field_75151_b.get(var3)).func_75211_c());
            }

            this.field_147369_b.func_71110_a(this.field_147369_b.field_71070_bA, var2);
         } else {
            ItemStack var5 = this.field_147369_b.field_71070_bA.func_75144_a(p_147351_1_.func_149544_d(), p_147351_1_.func_149543_e(), p_147351_1_.func_149542_h(), this.field_147369_b);
            if(ItemStack.func_77989_b(p_147351_1_.func_149546_g(), var5)) {
               this.field_147369_b.field_71135_a.func_147359_a(new S32PacketConfirmTransaction(p_147351_1_.func_149548_c(), p_147351_1_.func_149547_f(), true));
               this.field_147369_b.field_71137_h = true;
               this.field_147369_b.field_71070_bA.func_75142_b();
               this.field_147369_b.func_71113_k();
               this.field_147369_b.field_71137_h = false;
            } else {
               this.field_147372_n.func_76038_a(this.field_147369_b.field_71070_bA.field_75152_c, Short.valueOf(p_147351_1_.func_149547_f()));
               this.field_147369_b.field_71135_a.func_147359_a(new S32PacketConfirmTransaction(p_147351_1_.func_149548_c(), p_147351_1_.func_149547_f(), false));
               this.field_147369_b.field_71070_bA.func_75128_a(this.field_147369_b, false);
               ArrayList var6 = Lists.newArrayList();

               for(int var4 = 0; var4 < this.field_147369_b.field_71070_bA.field_75151_b.size(); ++var4) {
                  var6.add(((Slot)this.field_147369_b.field_71070_bA.field_75151_b.get(var4)).func_75211_c());
               }

               this.field_147369_b.func_71110_a(this.field_147369_b.field_71070_bA, var6);
            }
         }
      }

   }

   public void func_147338_a(C11PacketEnchantItem p_147338_1_) {
      PacketThreadUtil.func_180031_a(p_147338_1_, this, this.field_147369_b.func_71121_q());
      this.field_147369_b.func_143004_u();
      if(this.field_147369_b.field_71070_bA.field_75152_c == p_147338_1_.func_149539_c() && this.field_147369_b.field_71070_bA.func_75129_b(this.field_147369_b) && !this.field_147369_b.func_175149_v()) {
         this.field_147369_b.field_71070_bA.func_75140_a(this.field_147369_b, p_147338_1_.func_149537_d());
         this.field_147369_b.field_71070_bA.func_75142_b();
      }

   }

   public void func_147344_a(C10PacketCreativeInventoryAction p_147344_1_) {
      PacketThreadUtil.func_180031_a(p_147344_1_, this, this.field_147369_b.func_71121_q());
      if(this.field_147369_b.field_71134_c.func_73083_d()) {
         boolean var2 = p_147344_1_.func_149627_c() < 0;
         ItemStack var3 = p_147344_1_.func_149625_d();
         if(var3 != null && var3.func_77942_o() && var3.func_77978_p().func_150297_b("BlockEntityTag", 10)) {
            NBTTagCompound var4 = var3.func_77978_p().func_74775_l("BlockEntityTag");
            if(var4.func_74764_b("x") && var4.func_74764_b("y") && var4.func_74764_b("z")) {
               BlockPos var5 = new BlockPos(var4.func_74762_e("x"), var4.func_74762_e("y"), var4.func_74762_e("z"));
               TileEntity var6 = this.field_147369_b.field_70170_p.func_175625_s(var5);
               if(var6 != null) {
                  NBTTagCompound var7 = new NBTTagCompound();
                  var6.func_145841_b(var7);
                  var7.func_82580_o("x");
                  var7.func_82580_o("y");
                  var7.func_82580_o("z");
                  var3.func_77983_a("BlockEntityTag", var7);
               }
            }
         }

         boolean var8 = p_147344_1_.func_149627_c() >= 1 && p_147344_1_.func_149627_c() < 36 + InventoryPlayer.func_70451_h();
         boolean var9 = var3 == null || var3.func_77973_b() != null;
         boolean var10 = var3 == null || var3.func_77960_j() >= 0 && var3.field_77994_a <= 64 && var3.field_77994_a > 0;
         if(var8 && var9 && var10) {
            if(var3 == null) {
               this.field_147369_b.field_71069_bz.func_75141_a(p_147344_1_.func_149627_c(), (ItemStack)null);
            } else {
               this.field_147369_b.field_71069_bz.func_75141_a(p_147344_1_.func_149627_c(), var3);
            }

            this.field_147369_b.field_71069_bz.func_75128_a(this.field_147369_b, true);
         } else if(var2 && var9 && var10 && this.field_147375_m < 200) {
            this.field_147375_m += 20;
            EntityItem var11 = this.field_147369_b.func_71019_a(var3, true);
            if(var11 != null) {
               var11.func_70288_d();
            }
         }
      }

   }

   public void func_147339_a(C0FPacketConfirmTransaction p_147339_1_) {
      PacketThreadUtil.func_180031_a(p_147339_1_, this, this.field_147369_b.func_71121_q());
      Short var2 = (Short)this.field_147372_n.func_76041_a(this.field_147369_b.field_71070_bA.field_75152_c);
      if(var2 != null && p_147339_1_.func_149533_d() == var2.shortValue() && this.field_147369_b.field_71070_bA.field_75152_c == p_147339_1_.func_149532_c() && !this.field_147369_b.field_71070_bA.func_75129_b(this.field_147369_b) && !this.field_147369_b.func_175149_v()) {
         this.field_147369_b.field_71070_bA.func_75128_a(this.field_147369_b, true);
      }

   }

   public void func_147343_a(C12PacketUpdateSign p_147343_1_) {
      PacketThreadUtil.func_180031_a(p_147343_1_, this, this.field_147369_b.func_71121_q());
      this.field_147369_b.func_143004_u();
      WorldServer var2 = this.field_147367_d.func_71218_a(this.field_147369_b.field_71093_bK);
      BlockPos var3 = p_147343_1_.func_179722_a();
      if(var2.func_175667_e(var3)) {
         TileEntity var4 = var2.func_175625_s(var3);
         if(!(var4 instanceof TileEntitySign)) {
            return;
         }

         TileEntitySign var5 = (TileEntitySign)var4;
         if(!var5.func_145914_a() || var5.func_145911_b() != this.field_147369_b) {
            this.field_147367_d.func_71236_h("Player " + this.field_147369_b.func_70005_c_() + " just tried to change non-editable sign");
            return;
         }

         System.arraycopy(p_147343_1_.func_180768_b(), 0, var5.field_145915_a, 0, 4);
         var5.func_70296_d();
         var2.func_175689_h(var3);
      }

   }

   public void func_147353_a(C00PacketKeepAlive p_147353_1_) {
      if(p_147353_1_.func_149460_c() == this.field_147378_h) {
         int var2 = (int)(this.func_147363_d() - this.field_147379_i);
         this.field_147369_b.field_71138_i = (this.field_147369_b.field_71138_i * 3 + var2) / 4;
      }

   }

   private long func_147363_d() {
      return System.nanoTime() / 1000000L;
   }

   public void func_147348_a(C13PacketPlayerAbilities p_147348_1_) {
      PacketThreadUtil.func_180031_a(p_147348_1_, this, this.field_147369_b.func_71121_q());
      this.field_147369_b.field_71075_bZ.field_75100_b = p_147348_1_.func_149488_d() && this.field_147369_b.field_71075_bZ.field_75101_c;
   }

   public void func_147341_a(C14PacketTabComplete p_147341_1_) {
      PacketThreadUtil.func_180031_a(p_147341_1_, this, this.field_147369_b.func_71121_q());
      ArrayList var2 = Lists.newArrayList();
      Iterator var3 = this.field_147367_d.func_180506_a(this.field_147369_b, p_147341_1_.func_149419_c(), p_147341_1_.func_179709_b()).iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         var2.add(var4);
      }

      this.field_147369_b.field_71135_a.func_147359_a(new S3APacketTabComplete((String[])var2.toArray(new String[var2.size()])));
   }

   public void func_147352_a(C15PacketClientSettings p_147352_1_) {
      PacketThreadUtil.func_180031_a(p_147352_1_, this, this.field_147369_b.func_71121_q());
      this.field_147369_b.func_147100_a(p_147352_1_);
   }

   public void func_147349_a(C17PacketCustomPayload p_147349_1_) {
      PacketThreadUtil.func_180031_a(p_147349_1_, this, this.field_147369_b.func_71121_q());
      PacketBuffer var2;
      ItemStack var3;
      ItemStack var4;
      if("MC|BEdit".equals(p_147349_1_.func_149559_c())) {
         var2 = new PacketBuffer(Unpooled.wrappedBuffer(p_147349_1_.func_180760_b()));

         try {
            var3 = var2.func_150791_c();
            if(var3 != null) {
               if(!ItemWritableBook.func_150930_a(var3.func_77978_p())) {
                  throw new IOException("Invalid book tag!");
               }

               var4 = this.field_147369_b.field_71071_by.func_70448_g();
               if(var4 == null) {
                  return;
               }

               if(var3.func_77973_b() == Items.field_151099_bA && var3.func_77973_b() == var4.func_77973_b()) {
                  var4.func_77983_a("pages", var3.func_77978_p().func_150295_c("pages", 8));
               }

               return;
            }
         } catch (Exception var38) {
            field_147370_c.error("Couldn\'t handle book info", var38);
            return;
         } finally {
            var2.release();
         }

         return;
      } else if("MC|BSign".equals(p_147349_1_.func_149559_c())) {
         var2 = new PacketBuffer(Unpooled.wrappedBuffer(p_147349_1_.func_180760_b()));

         try {
            var3 = var2.func_150791_c();
            if(var3 == null) {
               return;
            }

            if(!ItemEditableBook.func_77828_a(var3.func_77978_p())) {
               throw new IOException("Invalid book tag!");
            }

            var4 = this.field_147369_b.field_71071_by.func_70448_g();
            if(var4 != null) {
               if(var3.func_77973_b() == Items.field_151164_bB && var4.func_77973_b() == Items.field_151099_bA) {
                  var4.func_77983_a("author", new NBTTagString(this.field_147369_b.func_70005_c_()));
                  var4.func_77983_a("title", new NBTTagString(var3.func_77978_p().func_74779_i("title")));
                  var4.func_77983_a("pages", var3.func_77978_p().func_150295_c("pages", 8));
                  var4.func_150996_a(Items.field_151164_bB);
               }

               return;
            }
         } catch (Exception var36) {
            field_147370_c.error("Couldn\'t sign book", var36);
            return;
         } finally {
            var2.release();
         }

         return;
      } else if("MC|TrSel".equals(p_147349_1_.func_149559_c())) {
         try {
            int var40 = p_147349_1_.func_180760_b().readInt();
            Container var42 = this.field_147369_b.field_71070_bA;
            if(var42 instanceof ContainerMerchant) {
               ((ContainerMerchant)var42).func_75175_c(var40);
            }
         } catch (Exception var35) {
            field_147370_c.error("Couldn\'t select trade", var35);
         }
      } else if("MC|AdvCdm".equals(p_147349_1_.func_149559_c())) {
         if(!this.field_147367_d.func_82356_Z()) {
            this.field_147369_b.func_145747_a(new ChatComponentTranslation("advMode.notEnabled", new Object[0]));
         } else if(this.field_147369_b.func_70003_b(2, "") && this.field_147369_b.field_71075_bZ.field_75098_d) {
            var2 = p_147349_1_.func_180760_b();

            try {
               byte var43 = var2.readByte();
               CommandBlockLogic var46 = null;
               if(var43 == 0) {
                  TileEntity var5 = this.field_147369_b.field_70170_p.func_175625_s(new BlockPos(var2.readInt(), var2.readInt(), var2.readInt()));
                  if(var5 instanceof TileEntityCommandBlock) {
                     var46 = ((TileEntityCommandBlock)var5).func_145993_a();
                  }
               } else if(var43 == 1) {
                  Entity var48 = this.field_147369_b.field_70170_p.func_73045_a(var2.readInt());
                  if(var48 instanceof EntityMinecartCommandBlock) {
                     var46 = ((EntityMinecartCommandBlock)var48).func_145822_e();
                  }
               }

               String var49 = var2.func_150789_c(var2.readableBytes());
               boolean var6 = var2.readBoolean();
               if(var46 != null) {
                  var46.func_145752_a(var49);
                  var46.func_175573_a(var6);
                  if(!var6) {
                     var46.func_145750_b((IChatComponent)null);
                  }

                  var46.func_145756_e();
                  this.field_147369_b.func_145747_a(new ChatComponentTranslation("advMode.setCommand.success", new Object[]{var49}));
               }
            } catch (Exception var33) {
               field_147370_c.error("Couldn\'t set command block", var33);
            } finally {
               var2.release();
            }
         } else {
            this.field_147369_b.func_145747_a(new ChatComponentTranslation("advMode.notAllowed", new Object[0]));
         }
      } else if("MC|Beacon".equals(p_147349_1_.func_149559_c())) {
         if(this.field_147369_b.field_71070_bA instanceof ContainerBeacon) {
            try {
               var2 = p_147349_1_.func_180760_b();
               int var44 = var2.readInt();
               int var47 = var2.readInt();
               ContainerBeacon var50 = (ContainerBeacon)this.field_147369_b.field_71070_bA;
               Slot var51 = var50.func_75139_a(0);
               if(var51.func_75216_d()) {
                  var51.func_75209_a(1);
                  IInventory var7 = var50.func_180611_e();
                  var7.func_174885_b(1, var44);
                  var7.func_174885_b(2, var47);
                  var7.func_70296_d();
               }
            } catch (Exception var32) {
               field_147370_c.error("Couldn\'t set beacon", var32);
            }
         }
      } else if("MC|ItemName".equals(p_147349_1_.func_149559_c()) && this.field_147369_b.field_71070_bA instanceof ContainerRepair) {
         ContainerRepair var41 = (ContainerRepair)this.field_147369_b.field_71070_bA;
         if(p_147349_1_.func_180760_b() != null && p_147349_1_.func_180760_b().readableBytes() >= 1) {
            String var45 = ChatAllowedCharacters.func_71565_a(p_147349_1_.func_180760_b().func_150789_c(32767));
            if(var45.length() <= 30) {
               var41.func_82850_a(var45);
            }
         } else {
            var41.func_82850_a("");
         }
      }

   }


   // $FF: synthetic class
   static final class SwitchAction {

      // $FF: synthetic field
      static final int[] field_180224_a;
      // $FF: synthetic field
      static final int[] field_180222_b;
      // $FF: synthetic field
      static final int[] field_180223_c = new int[C16PacketClientStatus.EnumState.values().length];
      private static final String __OBFID = "CL_00002269";


      static {
         try {
            field_180223_c[C16PacketClientStatus.EnumState.PERFORM_RESPAWN.ordinal()] = 1;
         } catch (NoSuchFieldError var16) {
            ;
         }

         try {
            field_180223_c[C16PacketClientStatus.EnumState.REQUEST_STATS.ordinal()] = 2;
         } catch (NoSuchFieldError var15) {
            ;
         }

         try {
            field_180223_c[C16PacketClientStatus.EnumState.OPEN_INVENTORY_ACHIEVEMENT.ordinal()] = 3;
         } catch (NoSuchFieldError var14) {
            ;
         }

         field_180222_b = new int[C0BPacketEntityAction.Action.values().length];

         try {
            field_180222_b[C0BPacketEntityAction.Action.START_SNEAKING.ordinal()] = 1;
         } catch (NoSuchFieldError var13) {
            ;
         }

         try {
            field_180222_b[C0BPacketEntityAction.Action.STOP_SNEAKING.ordinal()] = 2;
         } catch (NoSuchFieldError var12) {
            ;
         }

         try {
            field_180222_b[C0BPacketEntityAction.Action.START_SPRINTING.ordinal()] = 3;
         } catch (NoSuchFieldError var11) {
            ;
         }

         try {
            field_180222_b[C0BPacketEntityAction.Action.STOP_SPRINTING.ordinal()] = 4;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            field_180222_b[C0BPacketEntityAction.Action.STOP_SLEEPING.ordinal()] = 5;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            field_180222_b[C0BPacketEntityAction.Action.RIDING_JUMP.ordinal()] = 6;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            field_180222_b[C0BPacketEntityAction.Action.OPEN_INVENTORY.ordinal()] = 7;
         } catch (NoSuchFieldError var7) {
            ;
         }

         field_180224_a = new int[C07PacketPlayerDigging.Action.values().length];

         try {
            field_180224_a[C07PacketPlayerDigging.Action.DROP_ITEM.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            field_180224_a[C07PacketPlayerDigging.Action.DROP_ALL_ITEMS.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            field_180224_a[C07PacketPlayerDigging.Action.RELEASE_USE_ITEM.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_180224_a[C07PacketPlayerDigging.Action.START_DESTROY_BLOCK.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_180224_a[C07PacketPlayerDigging.Action.ABORT_DESTROY_BLOCK.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_180224_a[C07PacketPlayerDigging.Action.STOP_DESTROY_BLOCK.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
