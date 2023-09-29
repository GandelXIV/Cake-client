package net.minecraft.client.audio;

import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.util.ResourceLocation;

public class GuardianSound extends MovingSound {

   private final EntityGuardian field_174934_k;
   private static final String __OBFID = "CL_00002381";


   public GuardianSound(EntityGuardian p_i46071_1_) {
      super(new ResourceLocation("minecraft:mob.guardian.attack"));
      this.field_174934_k = p_i46071_1_;
      this.field_147666_i = ISound.AttenuationType.NONE;
      this.field_147659_g = true;
      this.field_147665_h = 0;
   }

   public void func_73660_a() {
      if(!this.field_174934_k.field_70128_L && this.field_174934_k.func_175474_cn()) {
         this.field_147660_d = (float)this.field_174934_k.field_70165_t;
         this.field_147661_e = (float)this.field_174934_k.field_70163_u;
         this.field_147658_f = (float)this.field_174934_k.field_70161_v;
         float var1 = this.field_174934_k.func_175477_p(0.0F);
         this.field_147662_b = 0.0F + 1.0F * var1 * var1;
         this.field_147663_c = 0.7F + 0.5F * var1;
      } else {
         this.field_147668_j = true;
      }
   }
}
