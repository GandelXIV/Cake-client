package net.minecraft.world.biome;

import java.util.Random;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMelon;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenVines;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenJungle extends BiomeGenBase {

   private boolean field_150614_aC;
   private static final String __OBFID = "CL_00000175";


   public BiomeGenJungle(int p_i45379_1_, boolean p_i45379_2_) {
      super(p_i45379_1_);
      this.field_150614_aC = p_i45379_2_;
      if(p_i45379_2_) {
         this.field_76760_I.field_76832_z = 2;
      } else {
         this.field_76760_I.field_76832_z = 50;
      }

      this.field_76760_I.field_76803_B = 25;
      this.field_76760_I.field_76802_A = 4;
      if(!p_i45379_2_) {
         this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityOcelot.class, 2, 1, 1));
      }

      this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityChicken.class, 10, 4, 4));
   }

   public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
      return (WorldGenAbstractTree)(p_150567_1_.nextInt(10) == 0?this.field_76758_O:(p_150567_1_.nextInt(2) == 0?new WorldGenShrub(BlockPlanks.EnumType.JUNGLE.func_176839_a(), BlockPlanks.EnumType.OAK.func_176839_a()):(!this.field_150614_aC && p_150567_1_.nextInt(3) == 0?new WorldGenMegaJungle(false, 10, 20, BlockPlanks.EnumType.JUNGLE.func_176839_a(), BlockPlanks.EnumType.JUNGLE.func_176839_a()):new WorldGenTrees(false, 4 + p_150567_1_.nextInt(7), BlockPlanks.EnumType.JUNGLE.func_176839_a(), BlockPlanks.EnumType.JUNGLE.func_176839_a(), true))));
   }

   public WorldGenerator func_76730_b(Random p_76730_1_) {
      return p_76730_1_.nextInt(4) == 0?new WorldGenTallGrass(BlockTallGrass.EnumType.FERN):new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
   }

   public void func_180624_a(World p_180624_1_, Random p_180624_2_, BlockPos p_180624_3_) {
      super.func_180624_a(p_180624_1_, p_180624_2_, p_180624_3_);
      int var4 = p_180624_2_.nextInt(16) + 8;
      int var5 = p_180624_2_.nextInt(16) + 8;
      int var6 = p_180624_2_.nextInt(p_180624_1_.func_175645_m(p_180624_3_.func_177982_a(var4, 0, var5)).func_177956_o() * 2);
      (new WorldGenMelon()).func_180709_b(p_180624_1_, p_180624_2_, p_180624_3_.func_177982_a(var4, var6, var5));
      WorldGenVines var9 = new WorldGenVines();

      for(var5 = 0; var5 < 50; ++var5) {
         var6 = p_180624_2_.nextInt(16) + 8;
         boolean var7 = true;
         int var8 = p_180624_2_.nextInt(16) + 8;
         var9.func_180709_b(p_180624_1_, p_180624_2_, p_180624_3_.func_177982_a(var6, 128, var8));
      }

   }
}
