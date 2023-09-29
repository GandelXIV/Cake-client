package net.minecraft.world;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.WorldServer;

public class Teleporter {

   private final WorldServer field_85192_a;
   private final Random field_77187_a;
   private final LongHashMap field_85191_c = new LongHashMap();
   private final List field_85190_d = Lists.newArrayList();
   private static final String __OBFID = "CL_00000153";


   public Teleporter(WorldServer p_i1963_1_) {
      this.field_85192_a = p_i1963_1_;
      this.field_77187_a = new Random(p_i1963_1_.func_72905_C());
   }

   public void func_180266_a(Entity p_180266_1_, float p_180266_2_) {
      if(this.field_85192_a.field_73011_w.func_177502_q() != 1) {
         if(!this.func_180620_b(p_180266_1_, p_180266_2_)) {
            this.func_85188_a(p_180266_1_);
            this.func_180620_b(p_180266_1_, p_180266_2_);
         }
      } else {
         int var3 = MathHelper.func_76128_c(p_180266_1_.field_70165_t);
         int var4 = MathHelper.func_76128_c(p_180266_1_.field_70163_u) - 1;
         int var5 = MathHelper.func_76128_c(p_180266_1_.field_70161_v);
         byte var6 = 1;
         byte var7 = 0;

         for(int var8 = -2; var8 <= 2; ++var8) {
            for(int var9 = -2; var9 <= 2; ++var9) {
               for(int var10 = -1; var10 < 3; ++var10) {
                  int var11 = var3 + var9 * var6 + var8 * var7;
                  int var12 = var4 + var10;
                  int var13 = var5 + var9 * var7 - var8 * var6;
                  boolean var14 = var10 < 0;
                  this.field_85192_a.func_175656_a(new BlockPos(var11, var12, var13), var14?Blocks.field_150343_Z.func_176223_P():Blocks.field_150350_a.func_176223_P());
               }
            }
         }

         p_180266_1_.func_70012_b((double)var3, (double)var4, (double)var5, p_180266_1_.field_70177_z, 0.0F);
         p_180266_1_.field_70159_w = p_180266_1_.field_70181_x = p_180266_1_.field_70179_y = 0.0D;
      }
   }

   public boolean func_180620_b(Entity p_180620_1_, float p_180620_2_) {
      boolean var3 = true;
      double var4 = -1.0D;
      int var6 = MathHelper.func_76128_c(p_180620_1_.field_70165_t);
      int var7 = MathHelper.func_76128_c(p_180620_1_.field_70161_v);
      boolean var8 = true;
      Object var9 = BlockPos.field_177992_a;
      long var10 = ChunkCoordIntPair.func_77272_a(var6, var7);
      if(this.field_85191_c.func_76161_b(var10)) {
         Teleporter.PortalPosition var12 = (Teleporter.PortalPosition)this.field_85191_c.func_76164_a(var10);
         var4 = 0.0D;
         var9 = var12;
         var12.field_85087_d = this.field_85192_a.func_82737_E();
         var8 = false;
      } else {
         BlockPos var34 = new BlockPos(p_180620_1_);

         for(int var13 = -128; var13 <= 128; ++var13) {
            BlockPos var16;
            for(int var14 = -128; var14 <= 128; ++var14) {
               for(BlockPos var15 = var34.func_177982_a(var13, this.field_85192_a.func_72940_L() - 1 - var34.func_177956_o(), var14); var15.func_177956_o() >= 0; var15 = var16) {
                  var16 = var15.func_177977_b();
                  if(this.field_85192_a.func_180495_p(var15).func_177230_c() == Blocks.field_150427_aO) {
                     while(this.field_85192_a.func_180495_p(var16 = var15.func_177977_b()).func_177230_c() == Blocks.field_150427_aO) {
                        var15 = var16;
                     }

                     double var17 = var15.func_177951_i(var34);
                     if(var4 < 0.0D || var17 < var4) {
                        var4 = var17;
                        var9 = var15;
                     }
                  }
               }
            }
         }
      }

      if(var4 >= 0.0D) {
         if(var8) {
            this.field_85191_c.func_76163_a(var10, new Teleporter.PortalPosition((BlockPos)var9, this.field_85192_a.func_82737_E()));
            this.field_85190_d.add(Long.valueOf(var10));
         }

         double var35 = (double)((BlockPos)var9).func_177958_n() + 0.5D;
         double var36 = (double)((BlockPos)var9).func_177956_o() + 0.5D;
         double var37 = (double)((BlockPos)var9).func_177952_p() + 0.5D;
         EnumFacing var18 = null;
         if(this.field_85192_a.func_180495_p(((BlockPos)var9).func_177976_e()).func_177230_c() == Blocks.field_150427_aO) {
            var18 = EnumFacing.NORTH;
         }

         if(this.field_85192_a.func_180495_p(((BlockPos)var9).func_177974_f()).func_177230_c() == Blocks.field_150427_aO) {
            var18 = EnumFacing.SOUTH;
         }

         if(this.field_85192_a.func_180495_p(((BlockPos)var9).func_177978_c()).func_177230_c() == Blocks.field_150427_aO) {
            var18 = EnumFacing.EAST;
         }

         if(this.field_85192_a.func_180495_p(((BlockPos)var9).func_177968_d()).func_177230_c() == Blocks.field_150427_aO) {
            var18 = EnumFacing.WEST;
         }

         EnumFacing var19 = EnumFacing.func_176731_b(p_180620_1_.func_82148_at());
         if(var18 != null) {
            EnumFacing var20 = var18.func_176735_f();
            BlockPos var21 = ((BlockPos)var9).func_177972_a(var18);
            boolean var22 = this.func_180265_a(var21);
            boolean var23 = this.func_180265_a(var21.func_177972_a(var20));
            if(var23 && var22) {
               var9 = ((BlockPos)var9).func_177972_a(var20);
               var18 = var18.func_176734_d();
               var20 = var20.func_176734_d();
               BlockPos var24 = ((BlockPos)var9).func_177972_a(var18);
               var22 = this.func_180265_a(var24);
               var23 = this.func_180265_a(var24.func_177972_a(var20));
            }

            float var38 = 0.5F;
            float var25 = 0.5F;
            if(!var23 && var22) {
               var38 = 1.0F;
            } else if(var23 && !var22) {
               var38 = 0.0F;
            } else if(var23) {
               var25 = 0.0F;
            }

            var35 = (double)((BlockPos)var9).func_177958_n() + 0.5D;
            var36 = (double)((BlockPos)var9).func_177956_o() + 0.5D;
            var37 = (double)((BlockPos)var9).func_177952_p() + 0.5D;
            var35 += (double)((float)var20.func_82601_c() * var38 + (float)var18.func_82601_c() * var25);
            var37 += (double)((float)var20.func_82599_e() * var38 + (float)var18.func_82599_e() * var25);
            float var26 = 0.0F;
            float var27 = 0.0F;
            float var28 = 0.0F;
            float var29 = 0.0F;
            if(var18 == var19) {
               var26 = 1.0F;
               var27 = 1.0F;
            } else if(var18 == var19.func_176734_d()) {
               var26 = -1.0F;
               var27 = -1.0F;
            } else if(var18 == var19.func_176746_e()) {
               var28 = 1.0F;
               var29 = -1.0F;
            } else {
               var28 = -1.0F;
               var29 = 1.0F;
            }

            double var30 = p_180620_1_.field_70159_w;
            double var32 = p_180620_1_.field_70179_y;
            p_180620_1_.field_70159_w = var30 * (double)var26 + var32 * (double)var29;
            p_180620_1_.field_70179_y = var30 * (double)var28 + var32 * (double)var27;
            p_180620_1_.field_70177_z = p_180620_2_ - (float)(var19.func_176736_b() * 90) + (float)(var18.func_176736_b() * 90);
         } else {
            p_180620_1_.field_70159_w = p_180620_1_.field_70181_x = p_180620_1_.field_70179_y = 0.0D;
         }

         p_180620_1_.func_70012_b(var35, var36, var37, p_180620_1_.field_70177_z, p_180620_1_.field_70125_A);
         return true;
      } else {
         return false;
      }
   }

   private boolean func_180265_a(BlockPos p_180265_1_) {
      return !this.field_85192_a.func_175623_d(p_180265_1_) || !this.field_85192_a.func_175623_d(p_180265_1_.func_177984_a());
   }

   public boolean func_85188_a(Entity p_85188_1_) {
      byte var2 = 16;
      double var3 = -1.0D;
      int var5 = MathHelper.func_76128_c(p_85188_1_.field_70165_t);
      int var6 = MathHelper.func_76128_c(p_85188_1_.field_70163_u);
      int var7 = MathHelper.func_76128_c(p_85188_1_.field_70161_v);
      int var8 = var5;
      int var9 = var6;
      int var10 = var7;
      int var11 = 0;
      int var12 = this.field_77187_a.nextInt(4);

      int var13;
      double var14;
      int var16;
      double var17;
      int var19;
      int var20;
      int var21;
      int var22;
      int var23;
      int var24;
      int var25;
      int var26;
      int var27;
      double var32;
      double var33;
      for(var13 = var5 - var2; var13 <= var5 + var2; ++var13) {
         var14 = (double)var13 + 0.5D - p_85188_1_.field_70165_t;

         for(var16 = var7 - var2; var16 <= var7 + var2; ++var16) {
            var17 = (double)var16 + 0.5D - p_85188_1_.field_70161_v;

            label271:
            for(var19 = this.field_85192_a.func_72940_L() - 1; var19 >= 0; --var19) {
               if(this.field_85192_a.func_175623_d(new BlockPos(var13, var19, var16))) {
                  while(var19 > 0 && this.field_85192_a.func_175623_d(new BlockPos(var13, var19 - 1, var16))) {
                     --var19;
                  }

                  for(var20 = var12; var20 < var12 + 4; ++var20) {
                     var21 = var20 % 2;
                     var22 = 1 - var21;
                     if(var20 % 4 >= 2) {
                        var21 = -var21;
                        var22 = -var22;
                     }

                     for(var23 = 0; var23 < 3; ++var23) {
                        for(var24 = 0; var24 < 4; ++var24) {
                           for(var25 = -1; var25 < 4; ++var25) {
                              var26 = var13 + (var24 - 1) * var21 + var23 * var22;
                              var27 = var19 + var25;
                              int var28 = var16 + (var24 - 1) * var22 - var23 * var21;
                              if(var25 < 0 && !this.field_85192_a.func_180495_p(new BlockPos(var26, var27, var28)).func_177230_c().func_149688_o().func_76220_a() || var25 >= 0 && !this.field_85192_a.func_175623_d(new BlockPos(var26, var27, var28))) {
                                 continue label271;
                              }
                           }
                        }
                     }

                     var32 = (double)var19 + 0.5D - p_85188_1_.field_70163_u;
                     var33 = var14 * var14 + var32 * var32 + var17 * var17;
                     if(var3 < 0.0D || var33 < var3) {
                        var3 = var33;
                        var8 = var13;
                        var9 = var19;
                        var10 = var16;
                        var11 = var20 % 4;
                     }
                  }
               }
            }
         }
      }

      if(var3 < 0.0D) {
         for(var13 = var5 - var2; var13 <= var5 + var2; ++var13) {
            var14 = (double)var13 + 0.5D - p_85188_1_.field_70165_t;

            for(var16 = var7 - var2; var16 <= var7 + var2; ++var16) {
               var17 = (double)var16 + 0.5D - p_85188_1_.field_70161_v;

               label219:
               for(var19 = this.field_85192_a.func_72940_L() - 1; var19 >= 0; --var19) {
                  if(this.field_85192_a.func_175623_d(new BlockPos(var13, var19, var16))) {
                     while(var19 > 0 && this.field_85192_a.func_175623_d(new BlockPos(var13, var19 - 1, var16))) {
                        --var19;
                     }

                     for(var20 = var12; var20 < var12 + 2; ++var20) {
                        var21 = var20 % 2;
                        var22 = 1 - var21;

                        for(var23 = 0; var23 < 4; ++var23) {
                           for(var24 = -1; var24 < 4; ++var24) {
                              var25 = var13 + (var23 - 1) * var21;
                              var26 = var19 + var24;
                              var27 = var16 + (var23 - 1) * var22;
                              if(var24 < 0 && !this.field_85192_a.func_180495_p(new BlockPos(var25, var26, var27)).func_177230_c().func_149688_o().func_76220_a() || var24 >= 0 && !this.field_85192_a.func_175623_d(new BlockPos(var25, var26, var27))) {
                                 continue label219;
                              }
                           }
                        }

                        var32 = (double)var19 + 0.5D - p_85188_1_.field_70163_u;
                        var33 = var14 * var14 + var32 * var32 + var17 * var17;
                        if(var3 < 0.0D || var33 < var3) {
                           var3 = var33;
                           var8 = var13;
                           var9 = var19;
                           var10 = var16;
                           var11 = var20 % 2;
                        }
                     }
                  }
               }
            }
         }
      }

      int var29 = var8;
      int var15 = var9;
      var16 = var10;
      int var30 = var11 % 2;
      int var18 = 1 - var30;
      if(var11 % 4 >= 2) {
         var30 = -var30;
         var18 = -var18;
      }

      if(var3 < 0.0D) {
         var9 = MathHelper.func_76125_a(var9, 70, this.field_85192_a.func_72940_L() - 10);
         var15 = var9;

         for(var19 = -1; var19 <= 1; ++var19) {
            for(var20 = 1; var20 < 3; ++var20) {
               for(var21 = -1; var21 < 3; ++var21) {
                  var22 = var29 + (var20 - 1) * var30 + var19 * var18;
                  var23 = var15 + var21;
                  var24 = var16 + (var20 - 1) * var18 - var19 * var30;
                  boolean var34 = var21 < 0;
                  this.field_85192_a.func_175656_a(new BlockPos(var22, var23, var24), var34?Blocks.field_150343_Z.func_176223_P():Blocks.field_150350_a.func_176223_P());
               }
            }
         }
      }

      IBlockState var31 = Blocks.field_150427_aO.func_176223_P().func_177226_a(BlockPortal.field_176550_a, var30 != 0?EnumFacing.Axis.X:EnumFacing.Axis.Z);

      for(var20 = 0; var20 < 4; ++var20) {
         for(var21 = 0; var21 < 4; ++var21) {
            for(var22 = -1; var22 < 4; ++var22) {
               var23 = var29 + (var21 - 1) * var30;
               var24 = var15 + var22;
               var25 = var16 + (var21 - 1) * var18;
               boolean var35 = var21 == 0 || var21 == 3 || var22 == -1 || var22 == 3;
               this.field_85192_a.func_180501_a(new BlockPos(var23, var24, var25), var35?Blocks.field_150343_Z.func_176223_P():var31, 2);
            }
         }

         for(var21 = 0; var21 < 4; ++var21) {
            for(var22 = -1; var22 < 4; ++var22) {
               var23 = var29 + (var21 - 1) * var30;
               var24 = var15 + var22;
               var25 = var16 + (var21 - 1) * var18;
               this.field_85192_a.func_175685_c(new BlockPos(var23, var24, var25), this.field_85192_a.func_180495_p(new BlockPos(var23, var24, var25)).func_177230_c());
            }
         }
      }

      return true;
   }

   public void func_85189_a(long p_85189_1_) {
      if(p_85189_1_ % 100L == 0L) {
         Iterator var3 = this.field_85190_d.iterator();
         long var4 = p_85189_1_ - 600L;

         while(var3.hasNext()) {
            Long var6 = (Long)var3.next();
            Teleporter.PortalPosition var7 = (Teleporter.PortalPosition)this.field_85191_c.func_76164_a(var6.longValue());
            if(var7 == null || var7.field_85087_d < var4) {
               var3.remove();
               this.field_85191_c.func_76159_d(var6.longValue());
            }
         }
      }

   }

   public class PortalPosition extends BlockPos {

      public long field_85087_d;
      private static final String __OBFID = "CL_00000154";


      public PortalPosition(BlockPos p_i45747_2_, long p_i45747_3_) {
         super(p_i45747_2_.func_177958_n(), p_i45747_2_.func_177956_o(), p_i45747_2_.func_177952_p());
         this.field_85087_d = p_i45747_3_;
      }
   }
}
