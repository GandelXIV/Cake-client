package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.StitcherException;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.IIconCreator;
import net.minecraft.client.renderer.texture.ITickableTextureObject;
import net.minecraft.client.renderer.texture.Stitcher;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import net.minecraft.client.resources.data.TextureMetadataSection;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextureMap extends AbstractTexture implements ITickableTextureObject {

   private static final Logger field_147635_d = LogManager.getLogger();
   public static final ResourceLocation field_174945_f = new ResourceLocation("missingno");
   public static final ResourceLocation field_110575_b = new ResourceLocation("textures/atlas/blocks.png");
   private final List field_94258_i;
   private final Map field_110574_e;
   private final Map field_94252_e;
   private final String field_94254_c;
   private final IIconCreator field_174946_m;
   private int field_147636_j;
   private final TextureAtlasSprite field_94249_f;
   private static final String __OBFID = "CL_00001058";


   public TextureMap(String p_i46099_1_) {
      this(p_i46099_1_, (IIconCreator)null);
   }

   public TextureMap(String p_i46100_1_, IIconCreator p_i46100_2_) {
      this.field_94258_i = Lists.newArrayList();
      this.field_110574_e = Maps.newHashMap();
      this.field_94252_e = Maps.newHashMap();
      this.field_94249_f = new TextureAtlasSprite("missingno");
      this.field_94254_c = p_i46100_1_;
      this.field_174946_m = p_i46100_2_;
   }

   private void func_110569_e() {
      int[] var1 = TextureUtil.field_110999_b;
      this.field_94249_f.func_110966_b(16);
      this.field_94249_f.func_110969_c(16);
      int[][] var2 = new int[this.field_147636_j + 1][];
      var2[0] = var1;
      this.field_94249_f.func_110968_a(Lists.newArrayList(new int[][][]{var2}));
   }

   public void func_110551_a(IResourceManager p_110551_1_) throws IOException {
      if(this.field_174946_m != null) {
         this.func_174943_a(p_110551_1_, this.field_174946_m);
      }

   }

   public void func_174943_a(IResourceManager p_174943_1_, IIconCreator p_174943_2_) {
      this.field_110574_e.clear();
      p_174943_2_.func_177059_a(this);
      this.func_110569_e();
      this.func_147631_c();
      this.func_110571_b(p_174943_1_);
   }

   public void func_110571_b(IResourceManager p_110571_1_) {
      int var2 = Minecraft.func_71369_N();
      Stitcher var3 = new Stitcher(var2, var2, true, 0, this.field_147636_j);
      this.field_94252_e.clear();
      this.field_94258_i.clear();
      int var4 = Integer.MAX_VALUE;
      int var5 = 1 << this.field_147636_j;
      Iterator var6 = this.field_110574_e.entrySet().iterator();

      while(var6.hasNext()) {
         Entry var7 = (Entry)var6.next();
         TextureAtlasSprite var8 = (TextureAtlasSprite)var7.getValue();
         ResourceLocation var9 = new ResourceLocation(var8.func_94215_i());
         ResourceLocation var10 = this.func_147634_a(var9, 0);

         try {
            IResource var11 = p_110571_1_.func_110536_a(var10);
            BufferedImage[] var12 = new BufferedImage[1 + this.field_147636_j];
            var12[0] = TextureUtil.func_177053_a(var11.func_110527_b());
            TextureMetadataSection var13 = (TextureMetadataSection)var11.func_110526_a("texture");
            if(var13 != null) {
               List var14 = var13.func_148535_c();
               int var16;
               if(!var14.isEmpty()) {
                  int var15 = var12[0].getWidth();
                  var16 = var12[0].getHeight();
                  if(MathHelper.func_151236_b(var15) != var15 || MathHelper.func_151236_b(var16) != var16) {
                     throw new RuntimeException("Unable to load extra miplevels, source-texture is not power of two");
                  }
               }

               Iterator var39 = var14.iterator();

               while(var39.hasNext()) {
                  var16 = ((Integer)var39.next()).intValue();
                  if(var16 > 0 && var16 < var12.length - 1 && var12[var16] == null) {
                     ResourceLocation var17 = this.func_147634_a(var9, var16);

                     try {
                        var12[var16] = TextureUtil.func_177053_a(p_110571_1_.func_110536_a(var17).func_110527_b());
                     } catch (IOException var22) {
                        field_147635_d.error("Unable to load miplevel {} from: {}", new Object[]{Integer.valueOf(var16), var17, var22});
                     }
                  }
               }
            }

            AnimationMetadataSection var37 = (AnimationMetadataSection)var11.func_110526_a("animation");
            var8.func_180598_a(var12, var37);
         } catch (RuntimeException var23) {
            field_147635_d.error("Unable to parse metadata from " + var10, var23);
            continue;
         } catch (IOException var24) {
            field_147635_d.error("Using missing texture, unable to load " + var10, var24);
            continue;
         }

         var4 = Math.min(var4, Math.min(var8.func_94211_a(), var8.func_94216_b()));
         int var32 = Math.min(Integer.lowestOneBit(var8.func_94211_a()), Integer.lowestOneBit(var8.func_94216_b()));
         if(var32 < var5) {
            field_147635_d.warn("Texture {} with size {}x{} limits mip level from {} to {}", new Object[]{var10, Integer.valueOf(var8.func_94211_a()), Integer.valueOf(var8.func_94216_b()), Integer.valueOf(MathHelper.func_151239_c(var5)), Integer.valueOf(MathHelper.func_151239_c(var32))});
            var5 = var32;
         }

         var3.func_110934_a(var8);
      }

      int var25 = Math.min(var4, var5);
      int var26 = MathHelper.func_151239_c(var25);
      if(var26 < this.field_147636_j) {
         field_147635_d.debug("{}: dropping miplevel from {} to {}, because of minimum power of two: {}", new Object[]{this.field_94254_c, Integer.valueOf(this.field_147636_j), Integer.valueOf(var26), Integer.valueOf(var25)});
         this.field_147636_j = var26;
      }

      Iterator var27 = this.field_110574_e.values().iterator();

      while(var27.hasNext()) {
         final TextureAtlasSprite var29 = (TextureAtlasSprite)var27.next();

         try {
            var29.func_147963_d(this.field_147636_j);
         } catch (Throwable var21) {
            CrashReport var33 = CrashReport.func_85055_a(var21, "Applying mipmap");
            CrashReportCategory var35 = var33.func_85058_a("Sprite being mipmapped");
            var35.func_71500_a("Sprite name", new Callable() {

               private static final String __OBFID = "CL_00001059";

               public String call() {
                  return var29.func_94215_i();
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            var35.func_71500_a("Sprite size", new Callable() {

               private static final String __OBFID = "CL_00001060";

               public String call() {
                  return var29.func_94211_a() + " x " + var29.func_94216_b();
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            var35.func_71500_a("Sprite frames", new Callable() {

               private static final String __OBFID = "CL_00001061";

               public String call() {
                  return var29.func_110970_k() + " frames";
               }
               // $FF: synthetic method
               public Object call() {
                  return this.call();
               }
            });
            var35.func_71507_a("Mipmap levels", Integer.valueOf(this.field_147636_j));
            throw new ReportedException(var33);
         }
      }

      this.field_94249_f.func_147963_d(this.field_147636_j);
      var3.func_110934_a(this.field_94249_f);

      try {
         var3.func_94305_f();
      } catch (StitcherException var20) {
         throw var20;
      }

      field_147635_d.info("Created: {}x{} {}-atlas", new Object[]{Integer.valueOf(var3.func_110935_a()), Integer.valueOf(var3.func_110936_b()), this.field_94254_c});
      TextureUtil.func_180600_a(this.func_110552_b(), this.field_147636_j, var3.func_110935_a(), var3.func_110936_b());
      HashMap var28 = Maps.newHashMap(this.field_110574_e);
      Iterator var30 = var3.func_94309_g().iterator();

      TextureAtlasSprite var31;
      while(var30.hasNext()) {
         var31 = (TextureAtlasSprite)var30.next();
         String var34 = var31.func_94215_i();
         var28.remove(var34);
         this.field_94252_e.put(var34, var31);

         try {
            TextureUtil.func_147955_a(var31.func_147965_a(0), var31.func_94211_a(), var31.func_94216_b(), var31.func_130010_a(), var31.func_110967_i(), false, false);
         } catch (Throwable var19) {
            CrashReport var36 = CrashReport.func_85055_a(var19, "Stitching texture atlas");
            CrashReportCategory var38 = var36.func_85058_a("Texture being stitched together");
            var38.func_71507_a("Atlas path", this.field_94254_c);
            var38.func_71507_a("Sprite", var31);
            throw new ReportedException(var36);
         }

         if(var31.func_130098_m()) {
            this.field_94258_i.add(var31);
         }
      }

      var30 = var28.values().iterator();

      while(var30.hasNext()) {
         var31 = (TextureAtlasSprite)var30.next();
         var31.func_94217_a(this.field_94249_f);
      }

      TextureUtil.func_177055_a(this.field_94254_c.replaceAll("/", "_"), this.func_110552_b(), this.field_147636_j, var3.func_110935_a(), var3.func_110936_b());
   }

   private ResourceLocation func_147634_a(ResourceLocation p_147634_1_, int p_147634_2_) {
      return p_147634_2_ == 0?new ResourceLocation(p_147634_1_.func_110624_b(), String.format("%s/%s%s", new Object[]{this.field_94254_c, p_147634_1_.func_110623_a(), ".png"})):new ResourceLocation(p_147634_1_.func_110624_b(), String.format("%s/mipmaps/%s.%d%s", new Object[]{this.field_94254_c, p_147634_1_.func_110623_a(), Integer.valueOf(p_147634_2_), ".png"}));
   }

   public TextureAtlasSprite func_110572_b(String p_110572_1_) {
      TextureAtlasSprite var2 = (TextureAtlasSprite)this.field_94252_e.get(p_110572_1_);
      if(var2 == null) {
         var2 = this.field_94249_f;
      }

      return var2;
   }

   public void func_94248_c() {
      TextureUtil.func_94277_a(this.func_110552_b());
      Iterator var1 = this.field_94258_i.iterator();

      while(var1.hasNext()) {
         TextureAtlasSprite var2 = (TextureAtlasSprite)var1.next();
         var2.func_94219_l();
      }

   }

   public TextureAtlasSprite func_174942_a(ResourceLocation p_174942_1_) {
      if(p_174942_1_ == null) {
         throw new IllegalArgumentException("Location cannot be null!");
      } else {
         TextureAtlasSprite var2 = (TextureAtlasSprite)this.field_110574_e.get(p_174942_1_);
         if(var2 == null) {
            var2 = TextureAtlasSprite.func_176604_a(p_174942_1_);
            this.field_110574_e.put(p_174942_1_.toString(), var2);
         }

         return var2;
      }
   }

   public void func_110550_d() {
      this.func_94248_c();
   }

   public void func_147633_a(int p_147633_1_) {
      this.field_147636_j = p_147633_1_;
   }

   public TextureAtlasSprite func_174944_f() {
      return this.field_94249_f;
   }

}
