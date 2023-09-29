package net.minecraft.item;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multisets;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMapBase;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.storage.MapData;

public class ItemMap extends ItemMapBase {

   private static final String __OBFID = "CL_00000047";


   protected ItemMap() {
      this.func_77627_a(true);
   }

   public static MapData func_150912_a(int p_150912_0_, World p_150912_1_) {
      String var2 = "map_" + p_150912_0_;
      MapData var3 = (MapData)p_150912_1_.func_72943_a(MapData.class, var2);
      if(var3 == null) {
         var3 = new MapData(var2);
         p_150912_1_.func_72823_a(var2, var3);
      }

      return var3;
   }

   public MapData func_77873_a(ItemStack p_77873_1_, World p_77873_2_) {
      String var3 = "map_" + p_77873_1_.func_77960_j();
      MapData var4 = (MapData)p_77873_2_.func_72943_a(MapData.class, var3);
      if(var4 == null && !p_77873_2_.field_72995_K) {
         p_77873_1_.func_77964_b(p_77873_2_.func_72841_b("map"));
         var3 = "map_" + p_77873_1_.func_77960_j();
         var4 = new MapData(var3);
         var4.field_76197_d = 3;
         var4.func_176054_a((double)p_77873_2_.func_72912_H().func_76079_c(), (double)p_77873_2_.func_72912_H().func_76074_e(), var4.field_76197_d);
         var4.field_76200_c = (byte)p_77873_2_.field_73011_w.func_177502_q();
         var4.func_76185_a();
         p_77873_2_.func_72823_a(var3, var4);
      }

      return var4;
   }

   public void func_77872_a(World p_77872_1_, Entity p_77872_2_, MapData p_77872_3_) {
      if(p_77872_1_.field_73011_w.func_177502_q() == p_77872_3_.field_76200_c && p_77872_2_ instanceof EntityPlayer) {
         int var4 = 1 << p_77872_3_.field_76197_d;
         int var5 = p_77872_3_.field_76201_a;
         int var6 = p_77872_3_.field_76199_b;
         int var7 = MathHelper.func_76128_c(p_77872_2_.field_70165_t - (double)var5) / var4 + 64;
         int var8 = MathHelper.func_76128_c(p_77872_2_.field_70161_v - (double)var6) / var4 + 64;
         int var9 = 128 / var4;
         if(p_77872_1_.field_73011_w.func_177495_o()) {
            var9 /= 2;
         }

         MapData.MapInfo var10 = p_77872_3_.func_82568_a((EntityPlayer)p_77872_2_);
         ++var10.field_82569_d;
         boolean var11 = false;

         for(int var12 = var7 - var9 + 1; var12 < var7 + var9; ++var12) {
            if((var12 & 15) == (var10.field_82569_d & 15) || var11) {
               var11 = false;
               double var13 = 0.0D;

               for(int var15 = var8 - var9 - 1; var15 < var8 + var9; ++var15) {
                  if(var12 >= 0 && var15 >= -1 && var12 < 128 && var15 < 128) {
                     int var16 = var12 - var7;
                     int var17 = var15 - var8;
                     boolean var18 = var16 * var16 + var17 * var17 > (var9 - 2) * (var9 - 2);
                     int var19 = (var5 / var4 + var12 - 64) * var4;
                     int var20 = (var6 / var4 + var15 - 64) * var4;
                     HashMultiset var21 = HashMultiset.create();
                     Chunk var22 = p_77872_1_.func_175726_f(new BlockPos(var19, 0, var20));
                     if(!var22.func_76621_g()) {
                        int var23 = var19 & 15;
                        int var24 = var20 & 15;
                        int var25 = 0;
                        double var26 = 0.0D;
                        int var28;
                        if(p_77872_1_.field_73011_w.func_177495_o()) {
                           var28 = var19 + var20 * 231871;
                           var28 = var28 * var28 * 31287121 + var28 * 11;
                           if((var28 >> 20 & 1) == 0) {
                              var21.add(Blocks.field_150346_d.func_180659_g(Blocks.field_150346_d.func_176223_P().func_177226_a(BlockDirt.field_176386_a, BlockDirt.DirtType.DIRT)), 10);
                           } else {
                              var21.add(Blocks.field_150348_b.func_180659_g(Blocks.field_150348_b.func_176223_P().func_177226_a(BlockStone.field_176247_a, BlockStone.EnumType.STONE)), 100);
                           }

                           var26 = 100.0D;
                        } else {
                           for(var28 = 0; var28 < var4; ++var28) {
                              for(int var29 = 0; var29 < var4; ++var29) {
                                 int var30 = var22.func_76611_b(var28 + var23, var29 + var24) + 1;
                                 IBlockState var31 = Blocks.field_150350_a.func_176223_P();
                                 if(var30 > 1) {
                                    do {
                                       --var30;
                                       var31 = var22.func_177435_g(new BlockPos(var28 + var23, var30, var29 + var24));
                                    } while(var31.func_177230_c().func_180659_g(var31) == MapColor.field_151660_b && var30 > 0);

                                    if(var30 > 0 && var31.func_177230_c().func_149688_o().func_76224_d()) {
                                       int var32 = var30 - 1;

                                       Block var33;
                                       do {
                                          var33 = var22.func_177438_a(var28 + var23, var32--, var29 + var24);
                                          ++var25;
                                       } while(var32 > 0 && var33.func_149688_o().func_76224_d());
                                    }
                                 }

                                 var26 += (double)var30 / (double)(var4 * var4);
                                 var21.add(var31.func_177230_c().func_180659_g(var31));
                              }
                           }
                        }

                        var25 /= var4 * var4;
                        double var34 = (var26 - var13) * 4.0D / (double)(var4 + 4) + ((double)(var12 + var15 & 1) - 0.5D) * 0.4D;
                        byte var35 = 1;
                        if(var34 > 0.6D) {
                           var35 = 2;
                        }

                        if(var34 < -0.6D) {
                           var35 = 0;
                        }

                        MapColor var36 = (MapColor)Iterables.getFirst(Multisets.copyHighestCountFirst(var21), MapColor.field_151660_b);
                        if(var36 == MapColor.field_151662_n) {
                           var34 = (double)var25 * 0.1D + (double)(var12 + var15 & 1) * 0.2D;
                           var35 = 1;
                           if(var34 < 0.5D) {
                              var35 = 2;
                           }

                           if(var34 > 0.9D) {
                              var35 = 0;
                           }
                        }

                        var13 = var26;
                        if(var15 >= 0 && var16 * var16 + var17 * var17 < var9 * var9 && (!var18 || (var12 + var15 & 1) != 0)) {
                           byte var37 = p_77872_3_.field_76198_e[var12 + var15 * 128];
                           byte var38 = (byte)(var36.field_76290_q * 4 + var35);
                           if(var37 != var38) {
                              p_77872_3_.field_76198_e[var12 + var15 * 128] = var38;
                              p_77872_3_.func_176053_a(var12, var15);
                              var11 = true;
                           }
                        }
                     }
                  }
               }
            }
         }

      }
   }

   public void func_77663_a(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
      if(!p_77663_2_.field_72995_K) {
         MapData var6 = this.func_77873_a(p_77663_1_, p_77663_2_);
         if(p_77663_3_ instanceof EntityPlayer) {
            EntityPlayer var7 = (EntityPlayer)p_77663_3_;
            var6.func_76191_a(var7, p_77663_1_);
         }

         if(p_77663_5_) {
            this.func_77872_a(p_77663_2_, p_77663_3_, var6);
         }

      }
   }

   public Packet func_150911_c(ItemStack p_150911_1_, World p_150911_2_, EntityPlayer p_150911_3_) {
      return this.func_77873_a(p_150911_1_, p_150911_2_).func_176052_a(p_150911_1_, p_150911_2_, p_150911_3_);
   }

   public void func_77622_d(ItemStack p_77622_1_, World p_77622_2_, EntityPlayer p_77622_3_) {
      if(p_77622_1_.func_77942_o() && p_77622_1_.func_77978_p().func_74767_n("map_is_scaling")) {
         MapData var4 = Items.field_151098_aY.func_77873_a(p_77622_1_, p_77622_2_);
         p_77622_1_.func_77964_b(p_77622_2_.func_72841_b("map"));
         MapData var5 = new MapData("map_" + p_77622_1_.func_77960_j());
         var5.field_76197_d = (byte)(var4.field_76197_d + 1);
         if(var5.field_76197_d > 4) {
            var5.field_76197_d = 4;
         }

         var5.func_176054_a((double)var4.field_76201_a, (double)var4.field_76199_b, var5.field_76197_d);
         var5.field_76200_c = var4.field_76200_c;
         var5.func_76185_a();
         p_77622_2_.func_72823_a("map_" + p_77622_1_.func_77960_j(), var5);
      }

   }

   public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
      MapData var5 = this.func_77873_a(p_77624_1_, p_77624_2_.field_70170_p);
      if(p_77624_4_) {
         if(var5 == null) {
            p_77624_3_.add("Unknown map");
         } else {
            p_77624_3_.add("Scaling at 1:" + (1 << var5.field_76197_d));
            p_77624_3_.add("(Level " + var5.field_76197_d + "/" + 4 + ")");
         }
      }

   }
}
