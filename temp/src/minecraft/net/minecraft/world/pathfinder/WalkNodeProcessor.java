package net.minecraft.world.pathfinder;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.pathfinder.NodeProcessor;

public class WalkNodeProcessor extends NodeProcessor {

   private boolean field_176180_f;
   private boolean field_176181_g;
   private boolean field_176183_h;
   private boolean field_176184_i;
   private boolean field_176182_j;
   private static final String __OBFID = "CL_00001965";


   public void func_176162_a(IBlockAccess p_176162_1_, Entity p_176162_2_) {
      super.func_176162_a(p_176162_1_, p_176162_2_);
      this.field_176182_j = this.field_176183_h;
   }

   public void func_176163_a() {
      super.func_176163_a();
      this.field_176183_h = this.field_176182_j;
   }

   public PathPoint func_176161_a(Entity p_176161_1_) {
      int var2;
      if(this.field_176184_i && p_176161_1_.func_70090_H()) {
         var2 = (int)p_176161_1_.func_174813_aQ().field_72338_b;

         for(Block var3 = this.field_176169_a.func_180495_p(new BlockPos(MathHelper.func_76128_c(p_176161_1_.field_70165_t), var2, MathHelper.func_76128_c(p_176161_1_.field_70161_v))).func_177230_c(); var3 == Blocks.field_150358_i || var3 == Blocks.field_150355_j; var3 = this.field_176169_a.func_180495_p(new BlockPos(MathHelper.func_76128_c(p_176161_1_.field_70165_t), var2, MathHelper.func_76128_c(p_176161_1_.field_70161_v))).func_177230_c()) {
            ++var2;
         }

         this.field_176183_h = false;
      } else {
         var2 = MathHelper.func_76128_c(p_176161_1_.func_174813_aQ().field_72338_b + 0.5D);
      }

      return this.func_176159_a(MathHelper.func_76128_c(p_176161_1_.func_174813_aQ().field_72340_a), var2, MathHelper.func_76128_c(p_176161_1_.func_174813_aQ().field_72339_c));
   }

   public PathPoint func_176160_a(Entity p_176160_1_, double p_176160_2_, double p_176160_4_, double p_176160_6_) {
      return this.func_176159_a(MathHelper.func_76128_c(p_176160_2_ - (double)(p_176160_1_.field_70130_N / 2.0F)), MathHelper.func_76128_c(p_176160_4_), MathHelper.func_76128_c(p_176160_6_ - (double)(p_176160_1_.field_70130_N / 2.0F)));
   }

   public int func_176164_a(PathPoint[] p_176164_1_, Entity p_176164_2_, PathPoint p_176164_3_, PathPoint p_176164_4_, float p_176164_5_) {
      int var6 = 0;
      byte var7 = 0;
      if(this.func_176177_a(p_176164_2_, p_176164_3_.field_75839_a, p_176164_3_.field_75837_b + 1, p_176164_3_.field_75838_c) == 1) {
         var7 = 1;
      }

      PathPoint var8 = this.func_176171_a(p_176164_2_, p_176164_3_.field_75839_a, p_176164_3_.field_75837_b, p_176164_3_.field_75838_c + 1, var7);
      PathPoint var9 = this.func_176171_a(p_176164_2_, p_176164_3_.field_75839_a - 1, p_176164_3_.field_75837_b, p_176164_3_.field_75838_c, var7);
      PathPoint var10 = this.func_176171_a(p_176164_2_, p_176164_3_.field_75839_a + 1, p_176164_3_.field_75837_b, p_176164_3_.field_75838_c, var7);
      PathPoint var11 = this.func_176171_a(p_176164_2_, p_176164_3_.field_75839_a, p_176164_3_.field_75837_b, p_176164_3_.field_75838_c - 1, var7);
      if(var8 != null && !var8.field_75842_i && var8.func_75829_a(p_176164_4_) < p_176164_5_) {
         p_176164_1_[var6++] = var8;
      }

      if(var9 != null && !var9.field_75842_i && var9.func_75829_a(p_176164_4_) < p_176164_5_) {
         p_176164_1_[var6++] = var9;
      }

      if(var10 != null && !var10.field_75842_i && var10.func_75829_a(p_176164_4_) < p_176164_5_) {
         p_176164_1_[var6++] = var10;
      }

      if(var11 != null && !var11.field_75842_i && var11.func_75829_a(p_176164_4_) < p_176164_5_) {
         p_176164_1_[var6++] = var11;
      }

      return var6;
   }

   private PathPoint func_176171_a(Entity p_176171_1_, int p_176171_2_, int p_176171_3_, int p_176171_4_, int p_176171_5_) {
      PathPoint var6 = null;
      int var7 = this.func_176177_a(p_176171_1_, p_176171_2_, p_176171_3_, p_176171_4_);
      if(var7 == 2) {
         return this.func_176159_a(p_176171_2_, p_176171_3_, p_176171_4_);
      } else {
         if(var7 == 1) {
            var6 = this.func_176159_a(p_176171_2_, p_176171_3_, p_176171_4_);
         }

         if(var6 == null && p_176171_5_ > 0 && var7 != -3 && var7 != -4 && this.func_176177_a(p_176171_1_, p_176171_2_, p_176171_3_ + p_176171_5_, p_176171_4_) == 1) {
            var6 = this.func_176159_a(p_176171_2_, p_176171_3_ + p_176171_5_, p_176171_4_);
            p_176171_3_ += p_176171_5_;
         }

         if(var6 != null) {
            int var8 = 0;

            int var9;
            for(var9 = 0; p_176171_3_ > 0; var6 = this.func_176159_a(p_176171_2_, p_176171_3_, p_176171_4_)) {
               var9 = this.func_176177_a(p_176171_1_, p_176171_2_, p_176171_3_ - 1, p_176171_4_);
               if(this.field_176183_h && var9 == -1) {
                  return null;
               }

               if(var9 != 1) {
                  break;
               }

               if(var8++ >= p_176171_1_.func_82143_as()) {
                  return null;
               }

               --p_176171_3_;
               if(p_176171_3_ <= 0) {
                  return null;
               }
            }

            if(var9 == -2) {
               return null;
            }
         }

         return var6;
      }
   }

   private int func_176177_a(Entity p_176177_1_, int p_176177_2_, int p_176177_3_, int p_176177_4_) {
      return func_176170_a(this.field_176169_a, p_176177_1_, p_176177_2_, p_176177_3_, p_176177_4_, this.field_176168_c, this.field_176165_d, this.field_176166_e, this.field_176183_h, this.field_176181_g, this.field_176180_f);
   }

   public static int func_176170_a(IBlockAccess p_176170_0_, Entity p_176170_1_, int p_176170_2_, int p_176170_3_, int p_176170_4_, int p_176170_5_, int p_176170_6_, int p_176170_7_, boolean p_176170_8_, boolean p_176170_9_, boolean p_176170_10_) {
      boolean var11 = false;
      BlockPos var12 = new BlockPos(p_176170_1_);

      for(int var13 = p_176170_2_; var13 < p_176170_2_ + p_176170_5_; ++var13) {
         for(int var14 = p_176170_3_; var14 < p_176170_3_ + p_176170_6_; ++var14) {
            for(int var15 = p_176170_4_; var15 < p_176170_4_ + p_176170_7_; ++var15) {
               BlockPos var16 = new BlockPos(var13, var14, var15);
               Block var17 = p_176170_0_.func_180495_p(var16).func_177230_c();
               if(var17.func_149688_o() != Material.field_151579_a) {
                  if(var17 != Blocks.field_150415_aT && var17 != Blocks.field_180400_cw) {
                     if(var17 != Blocks.field_150358_i && var17 != Blocks.field_150355_j) {
                        if(!p_176170_10_ && var17 instanceof BlockDoor && var17.func_149688_o() == Material.field_151575_d) {
                           return 0;
                        }
                     } else {
                        if(p_176170_8_) {
                           return -1;
                        }

                        var11 = true;
                     }
                  } else {
                     var11 = true;
                  }

                  if(p_176170_1_.field_70170_p.func_180495_p(var16).func_177230_c() instanceof BlockRailBase) {
                     if(!(p_176170_1_.field_70170_p.func_180495_p(var12).func_177230_c() instanceof BlockRailBase) && !(p_176170_1_.field_70170_p.func_180495_p(var12.func_177977_b()).func_177230_c() instanceof BlockRailBase)) {
                        return -3;
                     }
                  } else if(!var17.func_176205_b(p_176170_0_, var16) && (!p_176170_9_ || !(var17 instanceof BlockDoor) || var17.func_149688_o() != Material.field_151575_d)) {
                     if(var17 instanceof BlockFence || var17 instanceof BlockFenceGate || var17 instanceof BlockWall) {
                        return -3;
                     }

                     if(var17 == Blocks.field_150415_aT || var17 == Blocks.field_180400_cw) {
                        return -4;
                     }

                     Material var18 = var17.func_149688_o();
                     if(var18 != Material.field_151587_i) {
                        return 0;
                     }

                     if(!p_176170_1_.func_180799_ab()) {
                        return -2;
                     }
                  }
               }
            }
         }
      }

      return var11?2:1;
   }

   public void func_176175_a(boolean p_176175_1_) {
      this.field_176180_f = p_176175_1_;
   }

   public void func_176172_b(boolean p_176172_1_) {
      this.field_176181_g = p_176172_1_;
   }

   public void func_176176_c(boolean p_176176_1_) {
      this.field_176183_h = p_176176_1_;
   }

   public void func_176178_d(boolean p_176178_1_) {
      this.field_176184_i = p_176178_1_;
   }

   public boolean func_176179_b() {
      return this.field_176180_f;
   }

   public boolean func_176174_d() {
      return this.field_176184_i;
   }

   public boolean func_176173_e() {
      return this.field_176183_h;
   }
}
