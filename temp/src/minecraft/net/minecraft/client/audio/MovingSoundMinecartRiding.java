package net.minecraft.client.audio;

import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class MovingSoundMinecartRiding extends MovingSound {

   private final EntityPlayer field_147672_k;
   private final EntityMinecart field_147671_l;
   private static final String __OBFID = "CL_00001119";


   public MovingSoundMinecartRiding(EntityPlayer p_i45106_1_, EntityMinecart p_i45106_2_) {
      super(new ResourceLocation("minecraft:minecart.inside"));
      this.field_147672_k = p_i45106_1_;
      this.field_147671_l = p_i45106_2_;
      this.field_147666_i = ISound.AttenuationType.NONE;
      this.field_147659_g = true;
      this.field_147665_h = 0;
   }

   public void func_73660_a() {
      if(!this.field_147671_l.field_70128_L && this.field_147672_k.func_70115_ae() && this.field_147672_k.field_70154_o == this.field_147671_l) {
         float var1 = MathHelper.func_76133_a(this.field_147671_l.field_70159_w * this.field_147671_l.field_70159_w + this.field_147671_l.field_70179_y * this.field_147671_l.field_70179_y);
         if((double)var1 >= 0.01D) {
            this.field_147662_b = 0.0F + MathHelper.func_76131_a(var1, 0.0F, 1.0F) * 0.75F;
         } else {
            this.field_147662_b = 0.0F;
         }

      } else {
         this.field_147668_j = true;
      }
   }
}
