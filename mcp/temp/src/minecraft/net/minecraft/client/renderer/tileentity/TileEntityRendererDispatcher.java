package net.minecraft.client.renderer.tileentity;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntityBannerRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityBeaconRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityChestRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityEnchantmentTableRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityEndPortalRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityEnderChestRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityMobSpawnerRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityPistonRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySignRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.tileentity.TileEntityEndPortal;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ReportedException;
import net.minecraft.world.World;

public class TileEntityRendererDispatcher {

   private Map field_147559_m = Maps.newHashMap();
   public static TileEntityRendererDispatcher field_147556_a = new TileEntityRendererDispatcher();
   private FontRenderer field_147557_n;
   public static double field_147554_b;
   public static double field_147555_c;
   public static double field_147552_d;
   public TextureManager field_147553_e;
   public World field_147550_f;
   public Entity field_147551_g;
   public float field_147562_h;
   public float field_147563_i;
   public double field_147560_j;
   public double field_147561_k;
   public double field_147558_l;
   private static final String __OBFID = "CL_00000963";


   private TileEntityRendererDispatcher() {
      this.field_147559_m.put(TileEntitySign.class, new TileEntitySignRenderer());
      this.field_147559_m.put(TileEntityMobSpawner.class, new TileEntityMobSpawnerRenderer());
      this.field_147559_m.put(TileEntityPiston.class, new TileEntityPistonRenderer());
      this.field_147559_m.put(TileEntityChest.class, new TileEntityChestRenderer());
      this.field_147559_m.put(TileEntityEnderChest.class, new TileEntityEnderChestRenderer());
      this.field_147559_m.put(TileEntityEnchantmentTable.class, new TileEntityEnchantmentTableRenderer());
      this.field_147559_m.put(TileEntityEndPortal.class, new TileEntityEndPortalRenderer());
      this.field_147559_m.put(TileEntityBeacon.class, new TileEntityBeaconRenderer());
      this.field_147559_m.put(TileEntitySkull.class, new TileEntitySkullRenderer());
      this.field_147559_m.put(TileEntityBanner.class, new TileEntityBannerRenderer());
      Iterator var1 = this.field_147559_m.values().iterator();

      while(var1.hasNext()) {
         TileEntitySpecialRenderer var2 = (TileEntitySpecialRenderer)var1.next();
         var2.func_147497_a(this);
      }

   }

   public TileEntitySpecialRenderer func_147546_a(Class p_147546_1_) {
      TileEntitySpecialRenderer var2 = (TileEntitySpecialRenderer)this.field_147559_m.get(p_147546_1_);
      if(var2 == null && p_147546_1_ != TileEntity.class) {
         var2 = this.func_147546_a(p_147546_1_.getSuperclass());
         this.field_147559_m.put(p_147546_1_, var2);
      }

      return var2;
   }

   public boolean func_147545_a(TileEntity p_147545_1_) {
      return this.func_147547_b(p_147545_1_) != null;
   }

   public TileEntitySpecialRenderer func_147547_b(TileEntity p_147547_1_) {
      return p_147547_1_ == null?null:this.func_147546_a(p_147547_1_.getClass());
   }

   public void func_178470_a(World p_178470_1_, TextureManager p_178470_2_, FontRenderer p_178470_3_, Entity p_178470_4_, float p_178470_5_) {
      if(this.field_147550_f != p_178470_1_) {
         this.func_147543_a(p_178470_1_);
      }

      this.field_147553_e = p_178470_2_;
      this.field_147551_g = p_178470_4_;
      this.field_147557_n = p_178470_3_;
      this.field_147562_h = p_178470_4_.field_70126_B + (p_178470_4_.field_70177_z - p_178470_4_.field_70126_B) * p_178470_5_;
      this.field_147563_i = p_178470_4_.field_70127_C + (p_178470_4_.field_70125_A - p_178470_4_.field_70127_C) * p_178470_5_;
      this.field_147560_j = p_178470_4_.field_70142_S + (p_178470_4_.field_70165_t - p_178470_4_.field_70142_S) * (double)p_178470_5_;
      this.field_147561_k = p_178470_4_.field_70137_T + (p_178470_4_.field_70163_u - p_178470_4_.field_70137_T) * (double)p_178470_5_;
      this.field_147558_l = p_178470_4_.field_70136_U + (p_178470_4_.field_70161_v - p_178470_4_.field_70136_U) * (double)p_178470_5_;
   }

   public void func_180546_a(TileEntity p_180546_1_, float p_180546_2_, int p_180546_3_) {
      if(p_180546_1_.func_145835_a(this.field_147560_j, this.field_147561_k, this.field_147558_l) < p_180546_1_.func_145833_n()) {
         int var4 = this.field_147550_f.func_175626_b(p_180546_1_.func_174877_v(), 0);
         int var5 = var4 % 65536;
         int var6 = var4 / 65536;
         OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)var5 / 1.0F, (float)var6 / 1.0F);
         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
         BlockPos var7 = p_180546_1_.func_174877_v();
         this.func_178469_a(p_180546_1_, (double)var7.func_177958_n() - field_147554_b, (double)var7.func_177956_o() - field_147555_c, (double)var7.func_177952_p() - field_147552_d, p_180546_2_, p_180546_3_);
      }

   }

   public void func_147549_a(TileEntity p_147549_1_, double p_147549_2_, double p_147549_4_, double p_147549_6_, float p_147549_8_) {
      this.func_178469_a(p_147549_1_, p_147549_2_, p_147549_4_, p_147549_6_, p_147549_8_, -1);
   }

   public void func_178469_a(TileEntity p_178469_1_, double p_178469_2_, double p_178469_4_, double p_178469_6_, float p_178469_8_, int p_178469_9_) {
      TileEntitySpecialRenderer var10 = this.func_147547_b(p_178469_1_);
      if(var10 != null) {
         try {
            var10.func_180535_a(p_178469_1_, p_178469_2_, p_178469_4_, p_178469_6_, p_178469_8_, p_178469_9_);
         } catch (Throwable var14) {
            CrashReport var12 = CrashReport.func_85055_a(var14, "Rendering Block Entity");
            CrashReportCategory var13 = var12.func_85058_a("Block Entity Details");
            p_178469_1_.func_145828_a(var13);
            throw new ReportedException(var12);
         }
      }

   }

   public void func_147543_a(World p_147543_1_) {
      this.field_147550_f = p_147543_1_;
   }

   public FontRenderer func_147548_a() {
      return this.field_147557_n;
   }

}
