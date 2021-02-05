package net.minecraft.client.renderer;

import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.util.Vec3i;
import net.minecraft.world.IBlockAccess;

public class BlockModelRenderer {

   private static final String __OBFID = "CL_00002518";


   public boolean func_178259_a(IBlockAccess p_178259_1_, IBakedModel p_178259_2_, IBlockState p_178259_3_, BlockPos p_178259_4_, WorldRenderer p_178259_5_) {
      Block var6 = p_178259_3_.func_177230_c();
      var6.func_180654_a(p_178259_1_, p_178259_4_);
      return this.func_178267_a(p_178259_1_, p_178259_2_, p_178259_3_, p_178259_4_, p_178259_5_, true);
   }

   public boolean func_178267_a(IBlockAccess p_178267_1_, IBakedModel p_178267_2_, IBlockState p_178267_3_, BlockPos p_178267_4_, WorldRenderer p_178267_5_, boolean p_178267_6_) {
      boolean var7 = Minecraft.func_71379_u() && p_178267_3_.func_177230_c().func_149750_m() == 0 && p_178267_2_.func_177555_b();

      try {
         Block var8 = p_178267_3_.func_177230_c();
         return var7?this.func_178265_a(p_178267_1_, p_178267_2_, var8, p_178267_4_, p_178267_5_, p_178267_6_):this.func_178258_b(p_178267_1_, p_178267_2_, var8, p_178267_4_, p_178267_5_, p_178267_6_);
      } catch (Throwable var11) {
         CrashReport var9 = CrashReport.func_85055_a(var11, "Tesselating block model");
         CrashReportCategory var10 = var9.func_85058_a("Block model being tesselated");
         CrashReportCategory.func_175750_a(var10, p_178267_4_, p_178267_3_);
         var10.func_71507_a("Using AO", Boolean.valueOf(var7));
         throw new ReportedException(var9);
      }
   }

   public boolean func_178265_a(IBlockAccess p_178265_1_, IBakedModel p_178265_2_, Block p_178265_3_, BlockPos p_178265_4_, WorldRenderer p_178265_5_, boolean p_178265_6_) {
      boolean var7 = false;
      p_178265_5_.func_178963_b(983055);
      float[] var8 = new float[EnumFacing.values().length * 2];
      BitSet var9 = new BitSet(3);
      BlockModelRenderer.AmbientOcclusionFace var10 = new BlockModelRenderer.AmbientOcclusionFace();
      EnumFacing[] var11 = EnumFacing.values();
      int var12 = var11.length;

      for(int var13 = 0; var13 < var12; ++var13) {
         EnumFacing var14 = var11[var13];
         List var15 = p_178265_2_.func_177551_a(var14);
         if(!var15.isEmpty()) {
            BlockPos var16 = p_178265_4_.func_177972_a(var14);
            if(!p_178265_6_ || p_178265_3_.func_176225_a(p_178265_1_, var16, var14)) {
               this.func_178263_a(p_178265_1_, p_178265_3_, p_178265_4_, p_178265_5_, var15, var8, var9, var10);
               var7 = true;
            }
         }
      }

      List var17 = p_178265_2_.func_177550_a();
      if(var17.size() > 0) {
         this.func_178263_a(p_178265_1_, p_178265_3_, p_178265_4_, p_178265_5_, var17, var8, var9, var10);
         var7 = true;
      }

      return var7;
   }

   public boolean func_178258_b(IBlockAccess p_178258_1_, IBakedModel p_178258_2_, Block p_178258_3_, BlockPos p_178258_4_, WorldRenderer p_178258_5_, boolean p_178258_6_) {
      boolean var7 = false;
      BitSet var8 = new BitSet(3);
      EnumFacing[] var9 = EnumFacing.values();
      int var10 = var9.length;

      for(int var11 = 0; var11 < var10; ++var11) {
         EnumFacing var12 = var9[var11];
         List var13 = p_178258_2_.func_177551_a(var12);
         if(!var13.isEmpty()) {
            BlockPos var14 = p_178258_4_.func_177972_a(var12);
            if(!p_178258_6_ || p_178258_3_.func_176225_a(p_178258_1_, var14, var12)) {
               int var15 = p_178258_3_.func_176207_c(p_178258_1_, var14);
               this.func_178260_a(p_178258_1_, p_178258_3_, p_178258_4_, var12, var15, false, p_178258_5_, var13, var8);
               var7 = true;
            }
         }
      }

      List var16 = p_178258_2_.func_177550_a();
      if(var16.size() > 0) {
         this.func_178260_a(p_178258_1_, p_178258_3_, p_178258_4_, (EnumFacing)null, -1, true, p_178258_5_, var16, var8);
         var7 = true;
      }

      return var7;
   }

   private void func_178263_a(IBlockAccess p_178263_1_, Block p_178263_2_, BlockPos p_178263_3_, WorldRenderer p_178263_4_, List p_178263_5_, float[] p_178263_6_, BitSet p_178263_7_, BlockModelRenderer.AmbientOcclusionFace p_178263_8_) {
      double var9 = (double)p_178263_3_.func_177958_n();
      double var11 = (double)p_178263_3_.func_177956_o();
      double var13 = (double)p_178263_3_.func_177952_p();
      Block.EnumOffsetType var15 = p_178263_2_.func_176218_Q();
      if(var15 != Block.EnumOffsetType.NONE) {
         long var16 = MathHelper.func_180186_a(p_178263_3_);
         var9 += ((double)((float)(var16 >> 16 & 15L) / 15.0F) - 0.5D) * 0.5D;
         var13 += ((double)((float)(var16 >> 24 & 15L) / 15.0F) - 0.5D) * 0.5D;
         if(var15 == Block.EnumOffsetType.XYZ) {
            var11 += ((double)((float)(var16 >> 20 & 15L) / 15.0F) - 1.0D) * 0.2D;
         }
      }

      for(Iterator var22 = p_178263_5_.iterator(); var22.hasNext(); p_178263_4_.func_178987_a(var9, var11, var13)) {
         BakedQuad var17 = (BakedQuad)var22.next();
         this.func_178261_a(p_178263_2_, var17.func_178209_a(), var17.func_178210_d(), p_178263_6_, p_178263_7_);
         p_178263_8_.func_178204_a(p_178263_1_, p_178263_2_, p_178263_3_, var17.func_178210_d(), p_178263_6_, p_178263_7_);
         p_178263_4_.func_178981_a(var17.func_178209_a());
         p_178263_4_.func_178962_a(p_178263_8_.field_178207_c[0], p_178263_8_.field_178207_c[1], p_178263_8_.field_178207_c[2], p_178263_8_.field_178207_c[3]);
         if(var17.func_178212_b()) {
            int var18 = p_178263_2_.func_180662_a(p_178263_1_, p_178263_3_, var17.func_178211_c());
            if(EntityRenderer.field_78517_a) {
               var18 = TextureUtil.func_177054_c(var18);
            }

            float var19 = (float)(var18 >> 16 & 255) / 255.0F;
            float var20 = (float)(var18 >> 8 & 255) / 255.0F;
            float var21 = (float)(var18 & 255) / 255.0F;
            p_178263_4_.func_178978_a(p_178263_8_.field_178206_b[0] * var19, p_178263_8_.field_178206_b[0] * var20, p_178263_8_.field_178206_b[0] * var21, 4);
            p_178263_4_.func_178978_a(p_178263_8_.field_178206_b[1] * var19, p_178263_8_.field_178206_b[1] * var20, p_178263_8_.field_178206_b[1] * var21, 3);
            p_178263_4_.func_178978_a(p_178263_8_.field_178206_b[2] * var19, p_178263_8_.field_178206_b[2] * var20, p_178263_8_.field_178206_b[2] * var21, 2);
            p_178263_4_.func_178978_a(p_178263_8_.field_178206_b[3] * var19, p_178263_8_.field_178206_b[3] * var20, p_178263_8_.field_178206_b[3] * var21, 1);
         } else {
            p_178263_4_.func_178978_a(p_178263_8_.field_178206_b[0], p_178263_8_.field_178206_b[0], p_178263_8_.field_178206_b[0], 4);
            p_178263_4_.func_178978_a(p_178263_8_.field_178206_b[1], p_178263_8_.field_178206_b[1], p_178263_8_.field_178206_b[1], 3);
            p_178263_4_.func_178978_a(p_178263_8_.field_178206_b[2], p_178263_8_.field_178206_b[2], p_178263_8_.field_178206_b[2], 2);
            p_178263_4_.func_178978_a(p_178263_8_.field_178206_b[3], p_178263_8_.field_178206_b[3], p_178263_8_.field_178206_b[3], 1);
         }
      }

   }

   private void func_178261_a(Block p_178261_1_, int[] p_178261_2_, EnumFacing p_178261_3_, float[] p_178261_4_, BitSet p_178261_5_) {
      float var6 = 32.0F;
      float var7 = 32.0F;
      float var8 = 32.0F;
      float var9 = -32.0F;
      float var10 = -32.0F;
      float var11 = -32.0F;

      float var13;
      for(int var12 = 0; var12 < 4; ++var12) {
         var13 = Float.intBitsToFloat(p_178261_2_[var12 * 7]);
         float var14 = Float.intBitsToFloat(p_178261_2_[var12 * 7 + 1]);
         float var15 = Float.intBitsToFloat(p_178261_2_[var12 * 7 + 2]);
         var6 = Math.min(var6, var13);
         var7 = Math.min(var7, var14);
         var8 = Math.min(var8, var15);
         var9 = Math.max(var9, var13);
         var10 = Math.max(var10, var14);
         var11 = Math.max(var11, var15);
      }

      if(p_178261_4_ != null) {
         p_178261_4_[EnumFacing.WEST.func_176745_a()] = var6;
         p_178261_4_[EnumFacing.EAST.func_176745_a()] = var9;
         p_178261_4_[EnumFacing.DOWN.func_176745_a()] = var7;
         p_178261_4_[EnumFacing.UP.func_176745_a()] = var10;
         p_178261_4_[EnumFacing.NORTH.func_176745_a()] = var8;
         p_178261_4_[EnumFacing.SOUTH.func_176745_a()] = var11;
         p_178261_4_[EnumFacing.WEST.func_176745_a() + EnumFacing.values().length] = 1.0F - var6;
         p_178261_4_[EnumFacing.EAST.func_176745_a() + EnumFacing.values().length] = 1.0F - var9;
         p_178261_4_[EnumFacing.DOWN.func_176745_a() + EnumFacing.values().length] = 1.0F - var7;
         p_178261_4_[EnumFacing.UP.func_176745_a() + EnumFacing.values().length] = 1.0F - var10;
         p_178261_4_[EnumFacing.NORTH.func_176745_a() + EnumFacing.values().length] = 1.0F - var8;
         p_178261_4_[EnumFacing.SOUTH.func_176745_a() + EnumFacing.values().length] = 1.0F - var11;
      }

      float var16 = 1.0E-4F;
      var13 = 0.9999F;
      switch(BlockModelRenderer.SwitchEnumFacing.field_178290_a[p_178261_3_.ordinal()]) {
      case 1:
         p_178261_5_.set(1, var6 >= 1.0E-4F || var8 >= 1.0E-4F || var9 <= 0.9999F || var11 <= 0.9999F);
         p_178261_5_.set(0, (var7 < 1.0E-4F || p_178261_1_.func_149686_d()) && var7 == var10);
         break;
      case 2:
         p_178261_5_.set(1, var6 >= 1.0E-4F || var8 >= 1.0E-4F || var9 <= 0.9999F || var11 <= 0.9999F);
         p_178261_5_.set(0, (var10 > 0.9999F || p_178261_1_.func_149686_d()) && var7 == var10);
         break;
      case 3:
         p_178261_5_.set(1, var6 >= 1.0E-4F || var7 >= 1.0E-4F || var9 <= 0.9999F || var10 <= 0.9999F);
         p_178261_5_.set(0, (var8 < 1.0E-4F || p_178261_1_.func_149686_d()) && var8 == var11);
         break;
      case 4:
         p_178261_5_.set(1, var6 >= 1.0E-4F || var7 >= 1.0E-4F || var9 <= 0.9999F || var10 <= 0.9999F);
         p_178261_5_.set(0, (var11 > 0.9999F || p_178261_1_.func_149686_d()) && var8 == var11);
         break;
      case 5:
         p_178261_5_.set(1, var7 >= 1.0E-4F || var8 >= 1.0E-4F || var10 <= 0.9999F || var11 <= 0.9999F);
         p_178261_5_.set(0, (var6 < 1.0E-4F || p_178261_1_.func_149686_d()) && var6 == var9);
         break;
      case 6:
         p_178261_5_.set(1, var7 >= 1.0E-4F || var8 >= 1.0E-4F || var10 <= 0.9999F || var11 <= 0.9999F);
         p_178261_5_.set(0, (var9 > 0.9999F || p_178261_1_.func_149686_d()) && var6 == var9);
      }

   }

   private void func_178260_a(IBlockAccess p_178260_1_, Block p_178260_2_, BlockPos p_178260_3_, EnumFacing p_178260_4_, int p_178260_5_, boolean p_178260_6_, WorldRenderer p_178260_7_, List p_178260_8_, BitSet p_178260_9_) {
      double var10 = (double)p_178260_3_.func_177958_n();
      double var12 = (double)p_178260_3_.func_177956_o();
      double var14 = (double)p_178260_3_.func_177952_p();
      Block.EnumOffsetType var16 = p_178260_2_.func_176218_Q();
      if(var16 != Block.EnumOffsetType.NONE) {
         int var17 = p_178260_3_.func_177958_n();
         int var18 = p_178260_3_.func_177952_p();
         long var19 = (long)(var17 * 3129871) ^ (long)var18 * 116129781L;
         var19 = var19 * var19 * 42317861L + var19 * 11L;
         var10 += ((double)((float)(var19 >> 16 & 15L) / 15.0F) - 0.5D) * 0.5D;
         var14 += ((double)((float)(var19 >> 24 & 15L) / 15.0F) - 0.5D) * 0.5D;
         if(var16 == Block.EnumOffsetType.XYZ) {
            var12 += ((double)((float)(var19 >> 20 & 15L) / 15.0F) - 1.0D) * 0.2D;
         }
      }

      for(Iterator var23 = p_178260_8_.iterator(); var23.hasNext(); p_178260_7_.func_178987_a(var10, var12, var14)) {
         BakedQuad var24 = (BakedQuad)var23.next();
         if(p_178260_6_) {
            this.func_178261_a(p_178260_2_, var24.func_178209_a(), var24.func_178210_d(), (float[])null, p_178260_9_);
            p_178260_5_ = p_178260_9_.get(0)?p_178260_2_.func_176207_c(p_178260_1_, p_178260_3_.func_177972_a(var24.func_178210_d())):p_178260_2_.func_176207_c(p_178260_1_, p_178260_3_);
         }

         p_178260_7_.func_178981_a(var24.func_178209_a());
         p_178260_7_.func_178962_a(p_178260_5_, p_178260_5_, p_178260_5_, p_178260_5_);
         if(var24.func_178212_b()) {
            int var25 = p_178260_2_.func_180662_a(p_178260_1_, p_178260_3_, var24.func_178211_c());
            if(EntityRenderer.field_78517_a) {
               var25 = TextureUtil.func_177054_c(var25);
            }

            float var20 = (float)(var25 >> 16 & 255) / 255.0F;
            float var21 = (float)(var25 >> 8 & 255) / 255.0F;
            float var22 = (float)(var25 & 255) / 255.0F;
            p_178260_7_.func_178978_a(var20, var21, var22, 4);
            p_178260_7_.func_178978_a(var20, var21, var22, 3);
            p_178260_7_.func_178978_a(var20, var21, var22, 2);
            p_178260_7_.func_178978_a(var20, var21, var22, 1);
         }
      }

   }

   public void func_178262_a(IBakedModel p_178262_1_, float p_178262_2_, float p_178262_3_, float p_178262_4_, float p_178262_5_) {
      EnumFacing[] var6 = EnumFacing.values();
      int var7 = var6.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         EnumFacing var9 = var6[var8];
         this.func_178264_a(p_178262_2_, p_178262_3_, p_178262_4_, p_178262_5_, p_178262_1_.func_177551_a(var9));
      }

      this.func_178264_a(p_178262_2_, p_178262_3_, p_178262_4_, p_178262_5_, p_178262_1_.func_177550_a());
   }

   public void func_178266_a(IBakedModel p_178266_1_, IBlockState p_178266_2_, float p_178266_3_, boolean p_178266_4_) {
      Block var5 = p_178266_2_.func_177230_c();
      var5.func_149683_g();
      GlStateManager.func_179114_b(90.0F, 0.0F, 1.0F, 0.0F);
      int var6 = var5.func_180644_h(var5.func_176217_b(p_178266_2_));
      if(EntityRenderer.field_78517_a) {
         var6 = TextureUtil.func_177054_c(var6);
      }

      float var7 = (float)(var6 >> 16 & 255) / 255.0F;
      float var8 = (float)(var6 >> 8 & 255) / 255.0F;
      float var9 = (float)(var6 & 255) / 255.0F;
      if(!p_178266_4_) {
         GlStateManager.func_179131_c(p_178266_3_, p_178266_3_, p_178266_3_, 1.0F);
      }

      this.func_178262_a(p_178266_1_, p_178266_3_, var7, var8, var9);
   }

   private void func_178264_a(float p_178264_1_, float p_178264_2_, float p_178264_3_, float p_178264_4_, List p_178264_5_) {
      Tessellator var6 = Tessellator.func_178181_a();
      WorldRenderer var7 = var6.func_178180_c();
      Iterator var8 = p_178264_5_.iterator();

      while(var8.hasNext()) {
         BakedQuad var9 = (BakedQuad)var8.next();
         var7.func_178970_b();
         var7.func_178967_a(DefaultVertexFormats.field_176599_b);
         var7.func_178981_a(var9.func_178209_a());
         if(var9.func_178212_b()) {
            var7.func_178990_f(p_178264_2_ * p_178264_1_, p_178264_3_ * p_178264_1_, p_178264_4_ * p_178264_1_);
         } else {
            var7.func_178990_f(p_178264_1_, p_178264_1_, p_178264_1_);
         }

         Vec3i var10 = var9.func_178210_d().func_176730_m();
         var7.func_178975_e((float)var10.func_177958_n(), (float)var10.func_177956_o(), (float)var10.func_177952_p());
         var6.func_78381_a();
      }

   }

   class AmbientOcclusionFace {

      private final float[] field_178206_b = new float[4];
      private final int[] field_178207_c = new int[4];
      private static final String __OBFID = "CL_00002515";


      public void func_178204_a(IBlockAccess p_178204_1_, Block p_178204_2_, BlockPos p_178204_3_, EnumFacing p_178204_4_, float[] p_178204_5_, BitSet p_178204_6_) {
         BlockPos var7 = p_178204_6_.get(0)?p_178204_3_.func_177972_a(p_178204_4_):p_178204_3_;
         BlockModelRenderer.EnumNeighborInfo var8 = BlockModelRenderer.EnumNeighborInfo.func_178273_a(p_178204_4_);
         BlockPos var9 = var7.func_177972_a(var8.field_178276_g[0]);
         BlockPos var10 = var7.func_177972_a(var8.field_178276_g[1]);
         BlockPos var11 = var7.func_177972_a(var8.field_178276_g[2]);
         BlockPos var12 = var7.func_177972_a(var8.field_178276_g[3]);
         int var13 = p_178204_2_.func_176207_c(p_178204_1_, var9);
         int var14 = p_178204_2_.func_176207_c(p_178204_1_, var10);
         int var15 = p_178204_2_.func_176207_c(p_178204_1_, var11);
         int var16 = p_178204_2_.func_176207_c(p_178204_1_, var12);
         float var17 = p_178204_1_.func_180495_p(var9).func_177230_c().func_149685_I();
         float var18 = p_178204_1_.func_180495_p(var10).func_177230_c().func_149685_I();
         float var19 = p_178204_1_.func_180495_p(var11).func_177230_c().func_149685_I();
         float var20 = p_178204_1_.func_180495_p(var12).func_177230_c().func_149685_I();
         boolean var21 = p_178204_1_.func_180495_p(var9.func_177972_a(p_178204_4_)).func_177230_c().func_149751_l();
         boolean var22 = p_178204_1_.func_180495_p(var10.func_177972_a(p_178204_4_)).func_177230_c().func_149751_l();
         boolean var23 = p_178204_1_.func_180495_p(var11.func_177972_a(p_178204_4_)).func_177230_c().func_149751_l();
         boolean var24 = p_178204_1_.func_180495_p(var12.func_177972_a(p_178204_4_)).func_177230_c().func_149751_l();
         float var25;
         int var29;
         BlockPos var33;
         if(!var23 && !var21) {
            var25 = var17;
            var29 = var13;
         } else {
            var33 = var9.func_177972_a(var8.field_178276_g[2]);
            var25 = p_178204_1_.func_180495_p(var33).func_177230_c().func_149685_I();
            var29 = p_178204_2_.func_176207_c(p_178204_1_, var33);
         }

         float var26;
         int var30;
         if(!var24 && !var21) {
            var26 = var17;
            var30 = var13;
         } else {
            var33 = var9.func_177972_a(var8.field_178276_g[3]);
            var26 = p_178204_1_.func_180495_p(var33).func_177230_c().func_149685_I();
            var30 = p_178204_2_.func_176207_c(p_178204_1_, var33);
         }

         float var27;
         int var31;
         if(!var23 && !var22) {
            var27 = var18;
            var31 = var14;
         } else {
            var33 = var10.func_177972_a(var8.field_178276_g[2]);
            var27 = p_178204_1_.func_180495_p(var33).func_177230_c().func_149685_I();
            var31 = p_178204_2_.func_176207_c(p_178204_1_, var33);
         }

         float var28;
         int var32;
         if(!var24 && !var22) {
            var28 = var18;
            var32 = var14;
         } else {
            var33 = var10.func_177972_a(var8.field_178276_g[3]);
            var28 = p_178204_1_.func_180495_p(var33).func_177230_c().func_149685_I();
            var32 = p_178204_2_.func_176207_c(p_178204_1_, var33);
         }

         int var60 = p_178204_2_.func_176207_c(p_178204_1_, p_178204_3_);
         if(p_178204_6_.get(0) || !p_178204_1_.func_180495_p(p_178204_3_.func_177972_a(p_178204_4_)).func_177230_c().func_149662_c()) {
            var60 = p_178204_2_.func_176207_c(p_178204_1_, p_178204_3_.func_177972_a(p_178204_4_));
         }

         float var34 = p_178204_6_.get(0)?p_178204_1_.func_180495_p(var7).func_177230_c().func_149685_I():p_178204_1_.func_180495_p(p_178204_3_).func_177230_c().func_149685_I();
         BlockModelRenderer.VertexTranslations var35 = BlockModelRenderer.VertexTranslations.func_178184_a(p_178204_4_);
         float var36;
         float var37;
         float var38;
         float var39;
         if(p_178204_6_.get(1) && var8.field_178289_i) {
            var36 = (var20 + var17 + var26 + var34) * 0.25F;
            var37 = (var19 + var17 + var25 + var34) * 0.25F;
            var38 = (var19 + var18 + var27 + var34) * 0.25F;
            var39 = (var20 + var18 + var28 + var34) * 0.25F;
            float var40 = p_178204_5_[var8.field_178286_j[0].field_178229_m] * p_178204_5_[var8.field_178286_j[1].field_178229_m];
            float var41 = p_178204_5_[var8.field_178286_j[2].field_178229_m] * p_178204_5_[var8.field_178286_j[3].field_178229_m];
            float var42 = p_178204_5_[var8.field_178286_j[4].field_178229_m] * p_178204_5_[var8.field_178286_j[5].field_178229_m];
            float var43 = p_178204_5_[var8.field_178286_j[6].field_178229_m] * p_178204_5_[var8.field_178286_j[7].field_178229_m];
            float var44 = p_178204_5_[var8.field_178287_k[0].field_178229_m] * p_178204_5_[var8.field_178287_k[1].field_178229_m];
            float var45 = p_178204_5_[var8.field_178287_k[2].field_178229_m] * p_178204_5_[var8.field_178287_k[3].field_178229_m];
            float var46 = p_178204_5_[var8.field_178287_k[4].field_178229_m] * p_178204_5_[var8.field_178287_k[5].field_178229_m];
            float var47 = p_178204_5_[var8.field_178287_k[6].field_178229_m] * p_178204_5_[var8.field_178287_k[7].field_178229_m];
            float var48 = p_178204_5_[var8.field_178284_l[0].field_178229_m] * p_178204_5_[var8.field_178284_l[1].field_178229_m];
            float var49 = p_178204_5_[var8.field_178284_l[2].field_178229_m] * p_178204_5_[var8.field_178284_l[3].field_178229_m];
            float var50 = p_178204_5_[var8.field_178284_l[4].field_178229_m] * p_178204_5_[var8.field_178284_l[5].field_178229_m];
            float var51 = p_178204_5_[var8.field_178284_l[6].field_178229_m] * p_178204_5_[var8.field_178284_l[7].field_178229_m];
            float var52 = p_178204_5_[var8.field_178285_m[0].field_178229_m] * p_178204_5_[var8.field_178285_m[1].field_178229_m];
            float var53 = p_178204_5_[var8.field_178285_m[2].field_178229_m] * p_178204_5_[var8.field_178285_m[3].field_178229_m];
            float var54 = p_178204_5_[var8.field_178285_m[4].field_178229_m] * p_178204_5_[var8.field_178285_m[5].field_178229_m];
            float var55 = p_178204_5_[var8.field_178285_m[6].field_178229_m] * p_178204_5_[var8.field_178285_m[7].field_178229_m];
            this.field_178206_b[var35.field_178191_g] = var36 * var40 + var37 * var41 + var38 * var42 + var39 * var43;
            this.field_178206_b[var35.field_178200_h] = var36 * var44 + var37 * var45 + var38 * var46 + var39 * var47;
            this.field_178206_b[var35.field_178201_i] = var36 * var48 + var37 * var49 + var38 * var50 + var39 * var51;
            this.field_178206_b[var35.field_178198_j] = var36 * var52 + var37 * var53 + var38 * var54 + var39 * var55;
            int var56 = this.func_147778_a(var16, var13, var30, var60);
            int var57 = this.func_147778_a(var15, var13, var29, var60);
            int var58 = this.func_147778_a(var15, var14, var31, var60);
            int var59 = this.func_147778_a(var16, var14, var32, var60);
            this.field_178207_c[var35.field_178191_g] = this.func_178203_a(var56, var57, var58, var59, var40, var41, var42, var43);
            this.field_178207_c[var35.field_178200_h] = this.func_178203_a(var56, var57, var58, var59, var44, var45, var46, var47);
            this.field_178207_c[var35.field_178201_i] = this.func_178203_a(var56, var57, var58, var59, var48, var49, var50, var51);
            this.field_178207_c[var35.field_178198_j] = this.func_178203_a(var56, var57, var58, var59, var52, var53, var54, var55);
         } else {
            var36 = (var20 + var17 + var26 + var34) * 0.25F;
            var37 = (var19 + var17 + var25 + var34) * 0.25F;
            var38 = (var19 + var18 + var27 + var34) * 0.25F;
            var39 = (var20 + var18 + var28 + var34) * 0.25F;
            this.field_178207_c[var35.field_178191_g] = this.func_147778_a(var16, var13, var30, var60);
            this.field_178207_c[var35.field_178200_h] = this.func_147778_a(var15, var13, var29, var60);
            this.field_178207_c[var35.field_178201_i] = this.func_147778_a(var15, var14, var31, var60);
            this.field_178207_c[var35.field_178198_j] = this.func_147778_a(var16, var14, var32, var60);
            this.field_178206_b[var35.field_178191_g] = var36;
            this.field_178206_b[var35.field_178200_h] = var37;
            this.field_178206_b[var35.field_178201_i] = var38;
            this.field_178206_b[var35.field_178198_j] = var39;
         }

      }

      private int func_147778_a(int p_147778_1_, int p_147778_2_, int p_147778_3_, int p_147778_4_) {
         if(p_147778_1_ == 0) {
            p_147778_1_ = p_147778_4_;
         }

         if(p_147778_2_ == 0) {
            p_147778_2_ = p_147778_4_;
         }

         if(p_147778_3_ == 0) {
            p_147778_3_ = p_147778_4_;
         }

         return p_147778_1_ + p_147778_2_ + p_147778_3_ + p_147778_4_ >> 2 & 16711935;
      }

      private int func_178203_a(int p_178203_1_, int p_178203_2_, int p_178203_3_, int p_178203_4_, float p_178203_5_, float p_178203_6_, float p_178203_7_, float p_178203_8_) {
         int var9 = (int)((float)(p_178203_1_ >> 16 & 255) * p_178203_5_ + (float)(p_178203_2_ >> 16 & 255) * p_178203_6_ + (float)(p_178203_3_ >> 16 & 255) * p_178203_7_ + (float)(p_178203_4_ >> 16 & 255) * p_178203_8_) & 255;
         int var10 = (int)((float)(p_178203_1_ & 255) * p_178203_5_ + (float)(p_178203_2_ & 255) * p_178203_6_ + (float)(p_178203_3_ & 255) * p_178203_7_ + (float)(p_178203_4_ & 255) * p_178203_8_) & 255;
         return var9 << 16 | var10;
      }
   }

   public static enum EnumNeighborInfo {

      DOWN("DOWN", 0, new EnumFacing[]{EnumFacing.WEST, EnumFacing.EAST, EnumFacing.NORTH, EnumFacing.SOUTH}, 0.5F, false, new BlockModelRenderer.Orientation[0], new BlockModelRenderer.Orientation[0], new BlockModelRenderer.Orientation[0], new BlockModelRenderer.Orientation[0]),
      UP("UP", 1, new EnumFacing[]{EnumFacing.EAST, EnumFacing.WEST, EnumFacing.NORTH, EnumFacing.SOUTH}, 1.0F, false, new BlockModelRenderer.Orientation[0], new BlockModelRenderer.Orientation[0], new BlockModelRenderer.Orientation[0], new BlockModelRenderer.Orientation[0]),
      NORTH("NORTH", 2, new EnumFacing[]{EnumFacing.UP, EnumFacing.DOWN, EnumFacing.EAST, EnumFacing.WEST}, 0.8F, true, new BlockModelRenderer.Orientation[]{BlockModelRenderer.Orientation.UP, BlockModelRenderer.Orientation.FLIP_WEST, BlockModelRenderer.Orientation.UP, BlockModelRenderer.Orientation.WEST, BlockModelRenderer.Orientation.FLIP_UP, BlockModelRenderer.Orientation.WEST, BlockModelRenderer.Orientation.FLIP_UP, BlockModelRenderer.Orientation.FLIP_WEST}, new BlockModelRenderer.Orientation[]{BlockModelRenderer.Orientation.UP, BlockModelRenderer.Orientation.FLIP_EAST, BlockModelRenderer.Orientation.UP, BlockModelRenderer.Orientation.EAST, BlockModelRenderer.Orientation.FLIP_UP, BlockModelRenderer.Orientation.EAST, BlockModelRenderer.Orientation.FLIP_UP, BlockModelRenderer.Orientation.FLIP_EAST}, new BlockModelRenderer.Orientation[]{BlockModelRenderer.Orientation.DOWN, BlockModelRenderer.Orientation.FLIP_EAST, BlockModelRenderer.Orientation.DOWN, BlockModelRenderer.Orientation.EAST, BlockModelRenderer.Orientation.FLIP_DOWN, BlockModelRenderer.Orientation.EAST, BlockModelRenderer.Orientation.FLIP_DOWN, BlockModelRenderer.Orientation.FLIP_EAST}, new BlockModelRenderer.Orientation[]{BlockModelRenderer.Orientation.DOWN, BlockModelRenderer.Orientation.FLIP_WEST, BlockModelRenderer.Orientation.DOWN, BlockModelRenderer.Orientation.WEST, BlockModelRenderer.Orientation.FLIP_DOWN, BlockModelRenderer.Orientation.WEST, BlockModelRenderer.Orientation.FLIP_DOWN, BlockModelRenderer.Orientation.FLIP_WEST}),
      SOUTH("SOUTH", 3, new EnumFacing[]{EnumFacing.WEST, EnumFacing.EAST, EnumFacing.DOWN, EnumFacing.UP}, 0.8F, true, new BlockModelRenderer.Orientation[]{BlockModelRenderer.Orientation.UP, BlockModelRenderer.Orientation.FLIP_WEST, BlockModelRenderer.Orientation.FLIP_UP, BlockModelRenderer.Orientation.FLIP_WEST, BlockModelRenderer.Orientation.FLIP_UP, BlockModelRenderer.Orientation.WEST, BlockModelRenderer.Orientation.UP, BlockModelRenderer.Orientation.WEST}, new BlockModelRenderer.Orientation[]{BlockModelRenderer.Orientation.DOWN, BlockModelRenderer.Orientation.FLIP_WEST, BlockModelRenderer.Orientation.FLIP_DOWN, BlockModelRenderer.Orientation.FLIP_WEST, BlockModelRenderer.Orientation.FLIP_DOWN, BlockModelRenderer.Orientation.WEST, BlockModelRenderer.Orientation.DOWN, BlockModelRenderer.Orientation.WEST}, new BlockModelRenderer.Orientation[]{BlockModelRenderer.Orientation.DOWN, BlockModelRenderer.Orientation.FLIP_EAST, BlockModelRenderer.Orientation.FLIP_DOWN, BlockModelRenderer.Orientation.FLIP_EAST, BlockModelRenderer.Orientation.FLIP_DOWN, BlockModelRenderer.Orientation.EAST, BlockModelRenderer.Orientation.DOWN, BlockModelRenderer.Orientation.EAST}, new BlockModelRenderer.Orientation[]{BlockModelRenderer.Orientation.UP, BlockModelRenderer.Orientation.FLIP_EAST, BlockModelRenderer.Orientation.FLIP_UP, BlockModelRenderer.Orientation.FLIP_EAST, BlockModelRenderer.Orientation.FLIP_UP, BlockModelRenderer.Orientation.EAST, BlockModelRenderer.Orientation.UP, BlockModelRenderer.Orientation.EAST}),
      WEST("WEST", 4, new EnumFacing[]{EnumFacing.UP, EnumFacing.DOWN, EnumFacing.NORTH, EnumFacing.SOUTH}, 0.6F, true, new BlockModelRenderer.Orientation[]{BlockModelRenderer.Orientation.UP, BlockModelRenderer.Orientation.SOUTH, BlockModelRenderer.Orientation.UP, BlockModelRenderer.Orientation.FLIP_SOUTH, BlockModelRenderer.Orientation.FLIP_UP, BlockModelRenderer.Orientation.FLIP_SOUTH, BlockModelRenderer.Orientation.FLIP_UP, BlockModelRenderer.Orientation.SOUTH}, new BlockModelRenderer.Orientation[]{BlockModelRenderer.Orientation.UP, BlockModelRenderer.Orientation.NORTH, BlockModelRenderer.Orientation.UP, BlockModelRenderer.Orientation.FLIP_NORTH, BlockModelRenderer.Orientation.FLIP_UP, BlockModelRenderer.Orientation.FLIP_NORTH, BlockModelRenderer.Orientation.FLIP_UP, BlockModelRenderer.Orientation.NORTH}, new BlockModelRenderer.Orientation[]{BlockModelRenderer.Orientation.DOWN, BlockModelRenderer.Orientation.NORTH, BlockModelRenderer.Orientation.DOWN, BlockModelRenderer.Orientation.FLIP_NORTH, BlockModelRenderer.Orientation.FLIP_DOWN, BlockModelRenderer.Orientation.FLIP_NORTH, BlockModelRenderer.Orientation.FLIP_DOWN, BlockModelRenderer.Orientation.NORTH}, new BlockModelRenderer.Orientation[]{BlockModelRenderer.Orientation.DOWN, BlockModelRenderer.Orientation.SOUTH, BlockModelRenderer.Orientation.DOWN, BlockModelRenderer.Orientation.FLIP_SOUTH, BlockModelRenderer.Orientation.FLIP_DOWN, BlockModelRenderer.Orientation.FLIP_SOUTH, BlockModelRenderer.Orientation.FLIP_DOWN, BlockModelRenderer.Orientation.SOUTH}),
      EAST("EAST", 5, new EnumFacing[]{EnumFacing.DOWN, EnumFacing.UP, EnumFacing.NORTH, EnumFacing.SOUTH}, 0.6F, true, new BlockModelRenderer.Orientation[]{BlockModelRenderer.Orientation.FLIP_DOWN, BlockModelRenderer.Orientation.SOUTH, BlockModelRenderer.Orientation.FLIP_DOWN, BlockModelRenderer.Orientation.FLIP_SOUTH, BlockModelRenderer.Orientation.DOWN, BlockModelRenderer.Orientation.FLIP_SOUTH, BlockModelRenderer.Orientation.DOWN, BlockModelRenderer.Orientation.SOUTH}, new BlockModelRenderer.Orientation[]{BlockModelRenderer.Orientation.FLIP_DOWN, BlockModelRenderer.Orientation.NORTH, BlockModelRenderer.Orientation.FLIP_DOWN, BlockModelRenderer.Orientation.FLIP_NORTH, BlockModelRenderer.Orientation.DOWN, BlockModelRenderer.Orientation.FLIP_NORTH, BlockModelRenderer.Orientation.DOWN, BlockModelRenderer.Orientation.NORTH}, new BlockModelRenderer.Orientation[]{BlockModelRenderer.Orientation.FLIP_UP, BlockModelRenderer.Orientation.NORTH, BlockModelRenderer.Orientation.FLIP_UP, BlockModelRenderer.Orientation.FLIP_NORTH, BlockModelRenderer.Orientation.UP, BlockModelRenderer.Orientation.FLIP_NORTH, BlockModelRenderer.Orientation.UP, BlockModelRenderer.Orientation.NORTH}, new BlockModelRenderer.Orientation[]{BlockModelRenderer.Orientation.FLIP_UP, BlockModelRenderer.Orientation.SOUTH, BlockModelRenderer.Orientation.FLIP_UP, BlockModelRenderer.Orientation.FLIP_SOUTH, BlockModelRenderer.Orientation.UP, BlockModelRenderer.Orientation.FLIP_SOUTH, BlockModelRenderer.Orientation.UP, BlockModelRenderer.Orientation.SOUTH});
      protected final EnumFacing[] field_178276_g;
      protected final float field_178288_h;
      protected final boolean field_178289_i;
      protected final BlockModelRenderer.Orientation[] field_178286_j;
      protected final BlockModelRenderer.Orientation[] field_178287_k;
      protected final BlockModelRenderer.Orientation[] field_178284_l;
      protected final BlockModelRenderer.Orientation[] field_178285_m;
      private static final BlockModelRenderer.EnumNeighborInfo[] field_178282_n = new BlockModelRenderer.EnumNeighborInfo[6];
      // $FF: synthetic field
      private static final BlockModelRenderer.EnumNeighborInfo[] $VALUES = new BlockModelRenderer.EnumNeighborInfo[]{DOWN, UP, NORTH, SOUTH, WEST, EAST};
      private static final String __OBFID = "CL_00002516";


      private EnumNeighborInfo(String p_i46236_1_, int p_i46236_2_, EnumFacing[] p_i46236_3_, float p_i46236_4_, boolean p_i46236_5_, BlockModelRenderer.Orientation[] p_i46236_6_, BlockModelRenderer.Orientation[] p_i46236_7_, BlockModelRenderer.Orientation[] p_i46236_8_, BlockModelRenderer.Orientation[] p_i46236_9_) {
         this.field_178276_g = p_i46236_3_;
         this.field_178288_h = p_i46236_4_;
         this.field_178289_i = p_i46236_5_;
         this.field_178286_j = p_i46236_6_;
         this.field_178287_k = p_i46236_7_;
         this.field_178284_l = p_i46236_8_;
         this.field_178285_m = p_i46236_9_;
      }

      public static BlockModelRenderer.EnumNeighborInfo func_178273_a(EnumFacing p_178273_0_) {
         return field_178282_n[p_178273_0_.func_176745_a()];
      }

      static {
         field_178282_n[EnumFacing.DOWN.func_176745_a()] = DOWN;
         field_178282_n[EnumFacing.UP.func_176745_a()] = UP;
         field_178282_n[EnumFacing.NORTH.func_176745_a()] = NORTH;
         field_178282_n[EnumFacing.SOUTH.func_176745_a()] = SOUTH;
         field_178282_n[EnumFacing.WEST.func_176745_a()] = WEST;
         field_178282_n[EnumFacing.EAST.func_176745_a()] = EAST;
      }
   }

   public static enum Orientation {

      DOWN("DOWN", 0, EnumFacing.DOWN, false),
      UP("UP", 1, EnumFacing.UP, false),
      NORTH("NORTH", 2, EnumFacing.NORTH, false),
      SOUTH("SOUTH", 3, EnumFacing.SOUTH, false),
      WEST("WEST", 4, EnumFacing.WEST, false),
      EAST("EAST", 5, EnumFacing.EAST, false),
      FLIP_DOWN("FLIP_DOWN", 6, EnumFacing.DOWN, true),
      FLIP_UP("FLIP_UP", 7, EnumFacing.UP, true),
      FLIP_NORTH("FLIP_NORTH", 8, EnumFacing.NORTH, true),
      FLIP_SOUTH("FLIP_SOUTH", 9, EnumFacing.SOUTH, true),
      FLIP_WEST("FLIP_WEST", 10, EnumFacing.WEST, true),
      FLIP_EAST("FLIP_EAST", 11, EnumFacing.EAST, true);
      protected final int field_178229_m;
      // $FF: synthetic field
      private static final BlockModelRenderer.Orientation[] $VALUES = new BlockModelRenderer.Orientation[]{DOWN, UP, NORTH, SOUTH, WEST, EAST, FLIP_DOWN, FLIP_UP, FLIP_NORTH, FLIP_SOUTH, FLIP_WEST, FLIP_EAST};
      private static final String __OBFID = "CL_00002513";


      private Orientation(String p_i46233_1_, int p_i46233_2_, EnumFacing p_i46233_3_, boolean p_i46233_4_) {
         this.field_178229_m = p_i46233_3_.func_176745_a() + (p_i46233_4_?EnumFacing.values().length:0);
      }

   }

   // $FF: synthetic class
   static final class SwitchEnumFacing {

      // $FF: synthetic field
      static final int[] field_178290_a = new int[EnumFacing.values().length];
      private static final String __OBFID = "CL_00002517";


      static {
         try {
            field_178290_a[EnumFacing.DOWN.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            field_178290_a[EnumFacing.UP.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            field_178290_a[EnumFacing.NORTH.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_178290_a[EnumFacing.SOUTH.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_178290_a[EnumFacing.WEST.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_178290_a[EnumFacing.EAST.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   static enum VertexTranslations {

      DOWN("DOWN", 0, 0, 1, 2, 3),
      UP("UP", 1, 2, 3, 0, 1),
      NORTH("NORTH", 2, 3, 0, 1, 2),
      SOUTH("SOUTH", 3, 0, 1, 2, 3),
      WEST("WEST", 4, 3, 0, 1, 2),
      EAST("EAST", 5, 1, 2, 3, 0);
      private final int field_178191_g;
      private final int field_178200_h;
      private final int field_178201_i;
      private final int field_178198_j;
      private static final BlockModelRenderer.VertexTranslations[] field_178199_k = new BlockModelRenderer.VertexTranslations[6];
      // $FF: synthetic field
      private static final BlockModelRenderer.VertexTranslations[] $VALUES = new BlockModelRenderer.VertexTranslations[]{DOWN, UP, NORTH, SOUTH, WEST, EAST};
      private static final String __OBFID = "CL_00002514";


      private VertexTranslations(String p_i46234_1_, int p_i46234_2_, int p_i46234_3_, int p_i46234_4_, int p_i46234_5_, int p_i46234_6_) {
         this.field_178191_g = p_i46234_3_;
         this.field_178200_h = p_i46234_4_;
         this.field_178201_i = p_i46234_5_;
         this.field_178198_j = p_i46234_6_;
      }

      public static BlockModelRenderer.VertexTranslations func_178184_a(EnumFacing p_178184_0_) {
         return field_178199_k[p_178184_0_.func_176745_a()];
      }

      static {
         field_178199_k[EnumFacing.DOWN.func_176745_a()] = DOWN;
         field_178199_k[EnumFacing.UP.func_176745_a()] = UP;
         field_178199_k[EnumFacing.NORTH.func_176745_a()] = NORTH;
         field_178199_k[EnumFacing.SOUTH.func_176745_a()] = SOUTH;
         field_178199_k[EnumFacing.WEST.func_176745_a()] = WEST;
         field_178199_k[EnumFacing.EAST.func_176745_a()] = EAST;
      }
   }
}
