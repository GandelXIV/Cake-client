package net.minecraft.client.renderer.entity.layers;

import com.mojang.authlib.GameProfile;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.EnumFacing;

public class LayerCustomHead implements LayerRenderer {

   private final ModelRenderer field_177209_a;
   private static final String __OBFID = "CL_00002422";


   public LayerCustomHead(ModelRenderer p_i46120_1_) {
      this.field_177209_a = p_i46120_1_;
   }

   public void func_177141_a(EntityLivingBase p_177141_1_, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
      ItemStack var9 = p_177141_1_.func_82169_q(3);
      if(var9 != null && var9.func_77973_b() != null) {
         Item var10 = var9.func_77973_b();
         Minecraft var11 = Minecraft.func_71410_x();
         GlStateManager.func_179094_E();
         if(p_177141_1_.func_70093_af()) {
            GlStateManager.func_179109_b(0.0F, 0.2F, 0.0F);
         }

         boolean var12 = p_177141_1_ instanceof EntityVillager || p_177141_1_ instanceof EntityZombie && ((EntityZombie)p_177141_1_).func_82231_m();
         float var13;
         if(!var12 && p_177141_1_.func_70631_g_()) {
            var13 = 2.0F;
            float var14 = 1.4F;
            GlStateManager.func_179152_a(var14 / var13, var14 / var13, var14 / var13);
            GlStateManager.func_179109_b(0.0F, 16.0F * p_177141_8_, 0.0F);
         }

         this.field_177209_a.func_78794_c(0.0625F);
         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
         if(var10 instanceof ItemBlock) {
            var13 = 0.625F;
            GlStateManager.func_179109_b(0.0F, -0.25F, 0.0F);
            GlStateManager.func_179114_b(180.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.func_179152_a(var13, -var13, -var13);
            if(var12) {
               GlStateManager.func_179109_b(0.0F, 0.1875F, 0.0F);
            }

            var11.func_175597_ag().func_178099_a(p_177141_1_, var9, ItemCameraTransforms.TransformType.HEAD);
         } else if(var10 == Items.field_151144_bL) {
            var13 = 1.1875F;
            GlStateManager.func_179152_a(var13, -var13, -var13);
            if(var12) {
               GlStateManager.func_179109_b(0.0F, 0.0625F, 0.0F);
            }

            GameProfile var16 = null;
            if(var9.func_77942_o()) {
               NBTTagCompound var15 = var9.func_77978_p();
               if(var15.func_150297_b("SkullOwner", 10)) {
                  var16 = NBTUtil.func_152459_a(var15.func_74775_l("SkullOwner"));
               } else if(var15.func_150297_b("SkullOwner", 8)) {
                  var16 = TileEntitySkull.func_174884_b(new GameProfile((UUID)null, var15.func_74779_i("SkullOwner")));
                  var15.func_74782_a("SkullOwner", NBTUtil.func_180708_a(new NBTTagCompound(), var16));
               }
            }

            TileEntitySkullRenderer.field_147536_b.func_180543_a(-0.5F, 0.0F, -0.5F, EnumFacing.UP, 180.0F, var9.func_77960_j(), var16, -1);
         }

         GlStateManager.func_179121_F();
      }
   }

   public boolean func_177142_b() {
      return true;
   }
}
