package net.minecraft.client.renderer.tileentity;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import java.util.Map;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelHumanoidHead;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class TileEntitySkullRenderer extends TileEntitySpecialRenderer {

   private static final ResourceLocation field_147537_c = new ResourceLocation("textures/entity/skeleton/skeleton.png");
   private static final ResourceLocation field_147534_d = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");
   private static final ResourceLocation field_147535_e = new ResourceLocation("textures/entity/zombie/zombie.png");
   private static final ResourceLocation field_147532_f = new ResourceLocation("textures/entity/creeper/creeper.png");
   public static TileEntitySkullRenderer field_147536_b;
   private final ModelSkeletonHead field_178467_h = new ModelSkeletonHead(0, 0, 64, 32);
   private final ModelSkeletonHead field_178468_i = new ModelHumanoidHead();
   private static final String __OBFID = "CL_00000971";


   public void func_180542_a(TileEntitySkull p_180542_1_, double p_180542_2_, double p_180542_4_, double p_180542_6_, float p_180542_8_, int p_180542_9_) {
      EnumFacing var10 = EnumFacing.func_82600_a(p_180542_1_.func_145832_p() & 7);
      this.func_180543_a((float)p_180542_2_, (float)p_180542_4_, (float)p_180542_6_, var10, (float)(p_180542_1_.func_145906_b() * 360) / 16.0F, p_180542_1_.func_145904_a(), p_180542_1_.func_152108_a(), p_180542_9_);
   }

   public void func_147497_a(TileEntityRendererDispatcher p_147497_1_) {
      super.func_147497_a(p_147497_1_);
      field_147536_b = this;
   }

   public void func_180543_a(float p_180543_1_, float p_180543_2_, float p_180543_3_, EnumFacing p_180543_4_, float p_180543_5_, int p_180543_6_, GameProfile p_180543_7_, int p_180543_8_) {
      ModelSkeletonHead var9 = this.field_178467_h;
      if(p_180543_8_ >= 0) {
         this.func_147499_a(field_178460_a[p_180543_8_]);
         GlStateManager.func_179128_n(5890);
         GlStateManager.func_179094_E();
         GlStateManager.func_179152_a(4.0F, 2.0F, 1.0F);
         GlStateManager.func_179109_b(0.0625F, 0.0625F, 0.0625F);
         GlStateManager.func_179128_n(5888);
      } else {
         switch(p_180543_6_) {
         case 0:
         default:
            this.func_147499_a(field_147537_c);
            break;
         case 1:
            this.func_147499_a(field_147534_d);
            break;
         case 2:
            this.func_147499_a(field_147535_e);
            var9 = this.field_178468_i;
            break;
         case 3:
            var9 = this.field_178468_i;
            ResourceLocation var10 = DefaultPlayerSkin.func_177335_a();
            if(p_180543_7_ != null) {
               Minecraft var11 = Minecraft.func_71410_x();
               Map var12 = var11.func_152342_ad().func_152788_a(p_180543_7_);
               if(var12.containsKey(Type.SKIN)) {
                  var10 = var11.func_152342_ad().func_152792_a((MinecraftProfileTexture)var12.get(Type.SKIN), Type.SKIN);
               } else {
                  UUID var13 = EntityPlayer.func_146094_a(p_180543_7_);
                  var10 = DefaultPlayerSkin.func_177334_a(var13);
               }
            }

            this.func_147499_a(var10);
            break;
         case 4:
            this.func_147499_a(field_147532_f);
         }
      }

      GlStateManager.func_179094_E();
      GlStateManager.func_179129_p();
      if(p_180543_4_ != EnumFacing.UP) {
         switch(TileEntitySkullRenderer.SwitchEnumFacing.field_178458_a[p_180543_4_.ordinal()]) {
         case 1:
            GlStateManager.func_179109_b(p_180543_1_ + 0.5F, p_180543_2_ + 0.25F, p_180543_3_ + 0.74F);
            break;
         case 2:
            GlStateManager.func_179109_b(p_180543_1_ + 0.5F, p_180543_2_ + 0.25F, p_180543_3_ + 0.26F);
            p_180543_5_ = 180.0F;
            break;
         case 3:
            GlStateManager.func_179109_b(p_180543_1_ + 0.74F, p_180543_2_ + 0.25F, p_180543_3_ + 0.5F);
            p_180543_5_ = 270.0F;
            break;
         case 4:
         default:
            GlStateManager.func_179109_b(p_180543_1_ + 0.26F, p_180543_2_ + 0.25F, p_180543_3_ + 0.5F);
            p_180543_5_ = 90.0F;
         }
      } else {
         GlStateManager.func_179109_b(p_180543_1_ + 0.5F, p_180543_2_, p_180543_3_ + 0.5F);
      }

      float var14 = 0.0625F;
      GlStateManager.func_179091_B();
      GlStateManager.func_179152_a(-1.0F, -1.0F, 1.0F);
      GlStateManager.func_179141_d();
      var9.func_78088_a((Entity)null, 0.0F, 0.0F, 0.0F, p_180543_5_, 0.0F, var14);
      GlStateManager.func_179121_F();
      if(p_180543_8_ >= 0) {
         GlStateManager.func_179128_n(5890);
         GlStateManager.func_179121_F();
         GlStateManager.func_179128_n(5888);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_180535_a(TileEntity p_180535_1_, double p_180535_2_, double p_180535_4_, double p_180535_6_, float p_180535_8_, int p_180535_9_) {
      this.func_180542_a((TileEntitySkull)p_180535_1_, p_180535_2_, p_180535_4_, p_180535_6_, p_180535_8_, p_180535_9_);
   }


   // $FF: synthetic class
   static final class SwitchEnumFacing {

      // $FF: synthetic field
      static final int[] field_178458_a = new int[EnumFacing.values().length];
      private static final String __OBFID = "CL_00002468";


      static {
         try {
            field_178458_a[EnumFacing.NORTH.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_178458_a[EnumFacing.SOUTH.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_178458_a[EnumFacing.WEST.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_178458_a[EnumFacing.EAST.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
