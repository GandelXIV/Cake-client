package net.minecraft.world.gen.feature;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorldGenDungeons extends WorldGenerator {

   private static final Logger field_175918_a = LogManager.getLogger();
   private static final String[] field_175916_b = new String[]{"Skeleton", "Zombie", "Zombie", "Spider"};
   private static final List field_175917_c = Lists.newArrayList(new WeightedRandomChestContent[]{new WeightedRandomChestContent(Items.field_151141_av, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151042_j, 0, 1, 4, 10), new WeightedRandomChestContent(Items.field_151025_P, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151015_O, 0, 1, 4, 10), new WeightedRandomChestContent(Items.field_151016_H, 0, 1, 4, 10), new WeightedRandomChestContent(Items.field_151007_F, 0, 1, 4, 10), new WeightedRandomChestContent(Items.field_151133_ar, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151153_ao, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151137_ax, 0, 1, 4, 10), new WeightedRandomChestContent(Items.field_151096_cd, 0, 1, 1, 4), new WeightedRandomChestContent(Items.field_151093_ce, 0, 1, 1, 4), new WeightedRandomChestContent(Items.field_151057_cb, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151136_bY, 0, 1, 1, 2), new WeightedRandomChestContent(Items.field_151138_bX, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151125_bZ, 0, 1, 1, 1)});
   private static final String __OBFID = "CL_00000425";


   public boolean func_180709_b(World p_180709_1_, Random p_180709_2_, BlockPos p_180709_3_) {
      boolean var4 = true;
      int var5 = p_180709_2_.nextInt(2) + 2;
      int var6 = -var5 - 1;
      int var7 = var5 + 1;
      boolean var8 = true;
      boolean var9 = true;
      int var10 = p_180709_2_.nextInt(2) + 2;
      int var11 = -var10 - 1;
      int var12 = var10 + 1;
      int var13 = 0;

      int var14;
      int var15;
      int var16;
      BlockPos var17;
      for(var14 = var6; var14 <= var7; ++var14) {
         for(var15 = -1; var15 <= 4; ++var15) {
            for(var16 = var11; var16 <= var12; ++var16) {
               var17 = p_180709_3_.func_177982_a(var14, var15, var16);
               Material var18 = p_180709_1_.func_180495_p(var17).func_177230_c().func_149688_o();
               boolean var19 = var18.func_76220_a();
               if(var15 == -1 && !var19) {
                  return false;
               }

               if(var15 == 4 && !var19) {
                  return false;
               }

               if((var14 == var6 || var14 == var7 || var16 == var11 || var16 == var12) && var15 == 0 && p_180709_1_.func_175623_d(var17) && p_180709_1_.func_175623_d(var17.func_177984_a())) {
                  ++var13;
               }
            }
         }
      }

      if(var13 >= 1 && var13 <= 5) {
         for(var14 = var6; var14 <= var7; ++var14) {
            for(var15 = 3; var15 >= -1; --var15) {
               for(var16 = var11; var16 <= var12; ++var16) {
                  var17 = p_180709_3_.func_177982_a(var14, var15, var16);
                  if(var14 != var6 && var15 != -1 && var16 != var11 && var14 != var7 && var15 != 4 && var16 != var12) {
                     if(p_180709_1_.func_180495_p(var17).func_177230_c() != Blocks.field_150486_ae) {
                        p_180709_1_.func_175698_g(var17);
                     }
                  } else if(var17.func_177956_o() >= 0 && !p_180709_1_.func_180495_p(var17.func_177977_b()).func_177230_c().func_149688_o().func_76220_a()) {
                     p_180709_1_.func_175698_g(var17);
                  } else if(p_180709_1_.func_180495_p(var17).func_177230_c().func_149688_o().func_76220_a() && p_180709_1_.func_180495_p(var17).func_177230_c() != Blocks.field_150486_ae) {
                     if(var15 == -1 && p_180709_2_.nextInt(4) != 0) {
                        p_180709_1_.func_180501_a(var17, Blocks.field_150341_Y.func_176223_P(), 2);
                     } else {
                        p_180709_1_.func_180501_a(var17, Blocks.field_150347_e.func_176223_P(), 2);
                     }
                  }
               }
            }
         }

         var14 = 0;

         while(var14 < 2) {
            var15 = 0;

            while(true) {
               if(var15 < 3) {
                  label197: {
                     var16 = p_180709_3_.func_177958_n() + p_180709_2_.nextInt(var5 * 2 + 1) - var5;
                     int var24 = p_180709_3_.func_177956_o();
                     int var25 = p_180709_3_.func_177952_p() + p_180709_2_.nextInt(var10 * 2 + 1) - var10;
                     BlockPos var26 = new BlockPos(var16, var24, var25);
                     if(p_180709_1_.func_175623_d(var26)) {
                        int var20 = 0;
                        Iterator var21 = EnumFacing.Plane.HORIZONTAL.iterator();

                        while(var21.hasNext()) {
                           EnumFacing var22 = (EnumFacing)var21.next();
                           if(p_180709_1_.func_180495_p(var26.func_177972_a(var22)).func_177230_c().func_149688_o().func_76220_a()) {
                              ++var20;
                           }
                        }

                        if(var20 == 1) {
                           p_180709_1_.func_180501_a(var26, Blocks.field_150486_ae.func_176458_f(p_180709_1_, var26, Blocks.field_150486_ae.func_176223_P()), 2);
                           List var27 = WeightedRandomChestContent.func_177629_a(field_175917_c, new WeightedRandomChestContent[]{Items.field_151134_bR.func_92114_b(p_180709_2_)});
                           TileEntity var28 = p_180709_1_.func_175625_s(var26);
                           if(var28 instanceof TileEntityChest) {
                              WeightedRandomChestContent.func_177630_a(p_180709_2_, var27, (TileEntityChest)var28, 8);
                           }
                           break label197;
                        }
                     }

                     ++var15;
                     continue;
                  }
               }

               ++var14;
               break;
            }
         }

         p_180709_1_.func_180501_a(p_180709_3_, Blocks.field_150474_ac.func_176223_P(), 2);
         TileEntity var23 = p_180709_1_.func_175625_s(p_180709_3_);
         if(var23 instanceof TileEntityMobSpawner) {
            ((TileEntityMobSpawner)var23).func_145881_a().func_98272_a(this.func_76543_b(p_180709_2_));
         } else {
            field_175918_a.error("Failed to fetch mob spawner entity at (" + p_180709_3_.func_177958_n() + ", " + p_180709_3_.func_177956_o() + ", " + p_180709_3_.func_177952_p() + ")");
         }

         return true;
      } else {
         return false;
      }
   }

   private String func_76543_b(Random p_76543_1_) {
      return field_175916_b[p_76543_1_.nextInt(field_175916_b.length)];
   }

}
