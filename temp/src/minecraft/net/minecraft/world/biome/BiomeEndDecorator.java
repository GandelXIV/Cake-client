package net.minecraft.world.biome;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenSpikes;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeEndDecorator extends BiomeDecorator {

   protected WorldGenerator field_76835_L;
   private static final String __OBFID = "CL_00000188";


   public BiomeEndDecorator() {
      this.field_76835_L = new WorldGenSpikes(Blocks.field_150377_bs);
   }

   protected void func_150513_a(BiomeGenBase p_150513_1_) {
      this.func_76797_b();
      if(this.field_76813_b.nextInt(5) == 0) {
         int var2 = this.field_76813_b.nextInt(16) + 8;
         int var3 = this.field_76813_b.nextInt(16) + 8;
         this.field_76835_L.func_180709_b(this.field_76815_a, this.field_76813_b, this.field_76815_a.func_175672_r(this.field_180294_c.func_177982_a(var2, 0, var3)));
      }

      if(this.field_180294_c.func_177958_n() == 0 && this.field_180294_c.func_177952_p() == 0) {
         EntityDragon var4 = new EntityDragon(this.field_76815_a);
         var4.func_70012_b(0.0D, 128.0D, 0.0D, this.field_76813_b.nextFloat() * 360.0F, 0.0F);
         this.field_76815_a.func_72838_d(var4);
      }

   }
}
