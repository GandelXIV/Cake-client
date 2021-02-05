package net.minecraft.world.gen.structure;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDoor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public abstract class StructureComponent {

   protected StructureBoundingBox field_74887_e;
   protected EnumFacing field_74885_f;
   protected int field_74886_g;
   private static final String __OBFID = "CL_00000511";


   public StructureComponent() {}

   protected StructureComponent(int p_i2091_1_) {
      this.field_74886_g = p_i2091_1_;
   }

   public NBTTagCompound func_143010_b() {
      NBTTagCompound var1 = new NBTTagCompound();
      var1.func_74778_a("id", MapGenStructureIO.func_143036_a(this));
      var1.func_74782_a("BB", this.field_74887_e.func_151535_h());
      var1.func_74768_a("O", this.field_74885_f == null?-1:this.field_74885_f.func_176736_b());
      var1.func_74768_a("GD", this.field_74886_g);
      this.func_143012_a(var1);
      return var1;
   }

   protected abstract void func_143012_a(NBTTagCompound var1);

   public void func_143009_a(World p_143009_1_, NBTTagCompound p_143009_2_) {
      if(p_143009_2_.func_74764_b("BB")) {
         this.field_74887_e = new StructureBoundingBox(p_143009_2_.func_74759_k("BB"));
      }

      int var3 = p_143009_2_.func_74762_e("O");
      this.field_74885_f = var3 == -1?null:EnumFacing.func_176731_b(var3);
      this.field_74886_g = p_143009_2_.func_74762_e("GD");
      this.func_143011_b(p_143009_2_);
   }

   protected abstract void func_143011_b(NBTTagCompound var1);

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {}

   public abstract boolean func_74875_a(World var1, Random var2, StructureBoundingBox var3);

   public StructureBoundingBox func_74874_b() {
      return this.field_74887_e;
   }

   public int func_74877_c() {
      return this.field_74886_g;
   }

   public static StructureComponent func_74883_a(List p_74883_0_, StructureBoundingBox p_74883_1_) {
      Iterator var2 = p_74883_0_.iterator();

      StructureComponent var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (StructureComponent)var2.next();
      } while(var3.func_74874_b() == null || !var3.func_74874_b().func_78884_a(p_74883_1_));

      return var3;
   }

   public BlockPos func_180776_a() {
      return new BlockPos(this.field_74887_e.func_180717_f());
   }

   protected boolean func_74860_a(World p_74860_1_, StructureBoundingBox p_74860_2_) {
      int var3 = Math.max(this.field_74887_e.field_78897_a - 1, p_74860_2_.field_78897_a);
      int var4 = Math.max(this.field_74887_e.field_78895_b - 1, p_74860_2_.field_78895_b);
      int var5 = Math.max(this.field_74887_e.field_78896_c - 1, p_74860_2_.field_78896_c);
      int var6 = Math.min(this.field_74887_e.field_78893_d + 1, p_74860_2_.field_78893_d);
      int var7 = Math.min(this.field_74887_e.field_78894_e + 1, p_74860_2_.field_78894_e);
      int var8 = Math.min(this.field_74887_e.field_78892_f + 1, p_74860_2_.field_78892_f);

      int var9;
      int var10;
      for(var9 = var3; var9 <= var6; ++var9) {
         for(var10 = var5; var10 <= var8; ++var10) {
            if(p_74860_1_.func_180495_p(new BlockPos(var9, var4, var10)).func_177230_c().func_149688_o().func_76224_d()) {
               return true;
            }

            if(p_74860_1_.func_180495_p(new BlockPos(var9, var7, var10)).func_177230_c().func_149688_o().func_76224_d()) {
               return true;
            }
         }
      }

      for(var9 = var3; var9 <= var6; ++var9) {
         for(var10 = var4; var10 <= var7; ++var10) {
            if(p_74860_1_.func_180495_p(new BlockPos(var9, var10, var5)).func_177230_c().func_149688_o().func_76224_d()) {
               return true;
            }

            if(p_74860_1_.func_180495_p(new BlockPos(var9, var10, var8)).func_177230_c().func_149688_o().func_76224_d()) {
               return true;
            }
         }
      }

      for(var9 = var5; var9 <= var8; ++var9) {
         for(var10 = var4; var10 <= var7; ++var10) {
            if(p_74860_1_.func_180495_p(new BlockPos(var3, var10, var9)).func_177230_c().func_149688_o().func_76224_d()) {
               return true;
            }

            if(p_74860_1_.func_180495_p(new BlockPos(var6, var10, var9)).func_177230_c().func_149688_o().func_76224_d()) {
               return true;
            }
         }
      }

      return false;
   }

   protected int func_74865_a(int p_74865_1_, int p_74865_2_) {
      if(this.field_74885_f == null) {
         return p_74865_1_;
      } else {
         switch(StructureComponent.SwitchEnumFacing.field_176100_a[this.field_74885_f.ordinal()]) {
         case 1:
         case 2:
            return this.field_74887_e.field_78897_a + p_74865_1_;
         case 3:
            return this.field_74887_e.field_78893_d - p_74865_2_;
         case 4:
            return this.field_74887_e.field_78897_a + p_74865_2_;
         default:
            return p_74865_1_;
         }
      }
   }

   protected int func_74862_a(int p_74862_1_) {
      return this.field_74885_f == null?p_74862_1_:p_74862_1_ + this.field_74887_e.field_78895_b;
   }

   protected int func_74873_b(int p_74873_1_, int p_74873_2_) {
      if(this.field_74885_f == null) {
         return p_74873_2_;
      } else {
         switch(StructureComponent.SwitchEnumFacing.field_176100_a[this.field_74885_f.ordinal()]) {
         case 1:
            return this.field_74887_e.field_78892_f - p_74873_2_;
         case 2:
            return this.field_74887_e.field_78896_c + p_74873_2_;
         case 3:
         case 4:
            return this.field_74887_e.field_78896_c + p_74873_1_;
         default:
            return p_74873_2_;
         }
      }
   }

   protected int func_151555_a(Block p_151555_1_, int p_151555_2_) {
      if(p_151555_1_ == Blocks.field_150448_aq) {
         if(this.field_74885_f == EnumFacing.WEST || this.field_74885_f == EnumFacing.EAST) {
            if(p_151555_2_ == 1) {
               return 0;
            }

            return 1;
         }
      } else if(p_151555_1_ instanceof BlockDoor) {
         if(this.field_74885_f == EnumFacing.SOUTH) {
            if(p_151555_2_ == 0) {
               return 2;
            }

            if(p_151555_2_ == 2) {
               return 0;
            }
         } else {
            if(this.field_74885_f == EnumFacing.WEST) {
               return p_151555_2_ + 1 & 3;
            }

            if(this.field_74885_f == EnumFacing.EAST) {
               return p_151555_2_ + 3 & 3;
            }
         }
      } else if(p_151555_1_ != Blocks.field_150446_ar && p_151555_1_ != Blocks.field_150476_ad && p_151555_1_ != Blocks.field_150387_bl && p_151555_1_ != Blocks.field_150390_bg && p_151555_1_ != Blocks.field_150372_bz) {
         if(p_151555_1_ == Blocks.field_150468_ap) {
            if(this.field_74885_f == EnumFacing.SOUTH) {
               if(p_151555_2_ == EnumFacing.NORTH.func_176745_a()) {
                  return EnumFacing.SOUTH.func_176745_a();
               }

               if(p_151555_2_ == EnumFacing.SOUTH.func_176745_a()) {
                  return EnumFacing.NORTH.func_176745_a();
               }
            } else if(this.field_74885_f == EnumFacing.WEST) {
               if(p_151555_2_ == EnumFacing.NORTH.func_176745_a()) {
                  return EnumFacing.WEST.func_176745_a();
               }

               if(p_151555_2_ == EnumFacing.SOUTH.func_176745_a()) {
                  return EnumFacing.EAST.func_176745_a();
               }

               if(p_151555_2_ == EnumFacing.WEST.func_176745_a()) {
                  return EnumFacing.NORTH.func_176745_a();
               }

               if(p_151555_2_ == EnumFacing.EAST.func_176745_a()) {
                  return EnumFacing.SOUTH.func_176745_a();
               }
            } else if(this.field_74885_f == EnumFacing.EAST) {
               if(p_151555_2_ == EnumFacing.NORTH.func_176745_a()) {
                  return EnumFacing.EAST.func_176745_a();
               }

               if(p_151555_2_ == EnumFacing.SOUTH.func_176745_a()) {
                  return EnumFacing.WEST.func_176745_a();
               }

               if(p_151555_2_ == EnumFacing.WEST.func_176745_a()) {
                  return EnumFacing.NORTH.func_176745_a();
               }

               if(p_151555_2_ == EnumFacing.EAST.func_176745_a()) {
                  return EnumFacing.SOUTH.func_176745_a();
               }
            }
         } else if(p_151555_1_ == Blocks.field_150430_aB) {
            if(this.field_74885_f == EnumFacing.SOUTH) {
               if(p_151555_2_ == 3) {
                  return 4;
               }

               if(p_151555_2_ == 4) {
                  return 3;
               }
            } else if(this.field_74885_f == EnumFacing.WEST) {
               if(p_151555_2_ == 3) {
                  return 1;
               }

               if(p_151555_2_ == 4) {
                  return 2;
               }

               if(p_151555_2_ == 2) {
                  return 3;
               }

               if(p_151555_2_ == 1) {
                  return 4;
               }
            } else if(this.field_74885_f == EnumFacing.EAST) {
               if(p_151555_2_ == 3) {
                  return 2;
               }

               if(p_151555_2_ == 4) {
                  return 1;
               }

               if(p_151555_2_ == 2) {
                  return 3;
               }

               if(p_151555_2_ == 1) {
                  return 4;
               }
            }
         } else if(p_151555_1_ != Blocks.field_150479_bC && !(p_151555_1_ instanceof BlockDirectional)) {
            if(p_151555_1_ == Blocks.field_150331_J || p_151555_1_ == Blocks.field_150320_F || p_151555_1_ == Blocks.field_150442_at || p_151555_1_ == Blocks.field_150367_z) {
               if(this.field_74885_f == EnumFacing.SOUTH) {
                  if(p_151555_2_ == EnumFacing.NORTH.func_176745_a() || p_151555_2_ == EnumFacing.SOUTH.func_176745_a()) {
                     return EnumFacing.func_82600_a(p_151555_2_).func_176734_d().func_176745_a();
                  }
               } else if(this.field_74885_f == EnumFacing.WEST) {
                  if(p_151555_2_ == EnumFacing.NORTH.func_176745_a()) {
                     return EnumFacing.WEST.func_176745_a();
                  }

                  if(p_151555_2_ == EnumFacing.SOUTH.func_176745_a()) {
                     return EnumFacing.EAST.func_176745_a();
                  }

                  if(p_151555_2_ == EnumFacing.WEST.func_176745_a()) {
                     return EnumFacing.NORTH.func_176745_a();
                  }

                  if(p_151555_2_ == EnumFacing.EAST.func_176745_a()) {
                     return EnumFacing.SOUTH.func_176745_a();
                  }
               } else if(this.field_74885_f == EnumFacing.EAST) {
                  if(p_151555_2_ == EnumFacing.NORTH.func_176745_a()) {
                     return EnumFacing.EAST.func_176745_a();
                  }

                  if(p_151555_2_ == EnumFacing.SOUTH.func_176745_a()) {
                     return EnumFacing.WEST.func_176745_a();
                  }

                  if(p_151555_2_ == EnumFacing.WEST.func_176745_a()) {
                     return EnumFacing.NORTH.func_176745_a();
                  }

                  if(p_151555_2_ == EnumFacing.EAST.func_176745_a()) {
                     return EnumFacing.SOUTH.func_176745_a();
                  }
               }
            }
         } else {
            EnumFacing var3 = EnumFacing.func_176731_b(p_151555_2_);
            if(this.field_74885_f == EnumFacing.SOUTH) {
               if(var3 == EnumFacing.SOUTH || var3 == EnumFacing.NORTH) {
                  return var3.func_176734_d().func_176736_b();
               }
            } else if(this.field_74885_f == EnumFacing.WEST) {
               if(var3 == EnumFacing.NORTH) {
                  return EnumFacing.WEST.func_176736_b();
               }

               if(var3 == EnumFacing.SOUTH) {
                  return EnumFacing.EAST.func_176736_b();
               }

               if(var3 == EnumFacing.WEST) {
                  return EnumFacing.NORTH.func_176736_b();
               }

               if(var3 == EnumFacing.EAST) {
                  return EnumFacing.SOUTH.func_176736_b();
               }
            } else if(this.field_74885_f == EnumFacing.EAST) {
               if(var3 == EnumFacing.NORTH) {
                  return EnumFacing.EAST.func_176736_b();
               }

               if(var3 == EnumFacing.SOUTH) {
                  return EnumFacing.WEST.func_176736_b();
               }

               if(var3 == EnumFacing.WEST) {
                  return EnumFacing.NORTH.func_176736_b();
               }

               if(var3 == EnumFacing.EAST) {
                  return EnumFacing.SOUTH.func_176736_b();
               }
            }
         }
      } else if(this.field_74885_f == EnumFacing.SOUTH) {
         if(p_151555_2_ == 2) {
            return 3;
         }

         if(p_151555_2_ == 3) {
            return 2;
         }
      } else if(this.field_74885_f == EnumFacing.WEST) {
         if(p_151555_2_ == 0) {
            return 2;
         }

         if(p_151555_2_ == 1) {
            return 3;
         }

         if(p_151555_2_ == 2) {
            return 0;
         }

         if(p_151555_2_ == 3) {
            return 1;
         }
      } else if(this.field_74885_f == EnumFacing.EAST) {
         if(p_151555_2_ == 0) {
            return 2;
         }

         if(p_151555_2_ == 1) {
            return 3;
         }

         if(p_151555_2_ == 2) {
            return 1;
         }

         if(p_151555_2_ == 3) {
            return 0;
         }
      }

      return p_151555_2_;
   }

   protected void func_175811_a(World p_175811_1_, IBlockState p_175811_2_, int p_175811_3_, int p_175811_4_, int p_175811_5_, StructureBoundingBox p_175811_6_) {
      BlockPos var7 = new BlockPos(this.func_74865_a(p_175811_3_, p_175811_5_), this.func_74862_a(p_175811_4_), this.func_74873_b(p_175811_3_, p_175811_5_));
      if(p_175811_6_.func_175898_b(var7)) {
         p_175811_1_.func_180501_a(var7, p_175811_2_, 2);
      }
   }

   protected IBlockState func_175807_a(World p_175807_1_, int p_175807_2_, int p_175807_3_, int p_175807_4_, StructureBoundingBox p_175807_5_) {
      int var6 = this.func_74865_a(p_175807_2_, p_175807_4_);
      int var7 = this.func_74862_a(p_175807_3_);
      int var8 = this.func_74873_b(p_175807_2_, p_175807_4_);
      return !p_175807_5_.func_175898_b(new BlockPos(var6, var7, var8))?Blocks.field_150350_a.func_176223_P():p_175807_1_.func_180495_p(new BlockPos(var6, var7, var8));
   }

   protected void func_74878_a(World p_74878_1_, StructureBoundingBox p_74878_2_, int p_74878_3_, int p_74878_4_, int p_74878_5_, int p_74878_6_, int p_74878_7_, int p_74878_8_) {
      for(int var9 = p_74878_4_; var9 <= p_74878_7_; ++var9) {
         for(int var10 = p_74878_3_; var10 <= p_74878_6_; ++var10) {
            for(int var11 = p_74878_5_; var11 <= p_74878_8_; ++var11) {
               this.func_175811_a(p_74878_1_, Blocks.field_150350_a.func_176223_P(), var10, var9, var11, p_74878_2_);
            }
         }
      }

   }

   protected void func_175804_a(World p_175804_1_, StructureBoundingBox p_175804_2_, int p_175804_3_, int p_175804_4_, int p_175804_5_, int p_175804_6_, int p_175804_7_, int p_175804_8_, IBlockState p_175804_9_, IBlockState p_175804_10_, boolean p_175804_11_) {
      for(int var12 = p_175804_4_; var12 <= p_175804_7_; ++var12) {
         for(int var13 = p_175804_3_; var13 <= p_175804_6_; ++var13) {
            for(int var14 = p_175804_5_; var14 <= p_175804_8_; ++var14) {
               if(!p_175804_11_ || this.func_175807_a(p_175804_1_, var13, var12, var14, p_175804_2_).func_177230_c().func_149688_o() != Material.field_151579_a) {
                  if(var12 != p_175804_4_ && var12 != p_175804_7_ && var13 != p_175804_3_ && var13 != p_175804_6_ && var14 != p_175804_5_ && var14 != p_175804_8_) {
                     this.func_175811_a(p_175804_1_, p_175804_10_, var13, var12, var14, p_175804_2_);
                  } else {
                     this.func_175811_a(p_175804_1_, p_175804_9_, var13, var12, var14, p_175804_2_);
                  }
               }
            }
         }
      }

   }

   protected void func_74882_a(World p_74882_1_, StructureBoundingBox p_74882_2_, int p_74882_3_, int p_74882_4_, int p_74882_5_, int p_74882_6_, int p_74882_7_, int p_74882_8_, boolean p_74882_9_, Random p_74882_10_, StructureComponent.BlockSelector p_74882_11_) {
      for(int var12 = p_74882_4_; var12 <= p_74882_7_; ++var12) {
         for(int var13 = p_74882_3_; var13 <= p_74882_6_; ++var13) {
            for(int var14 = p_74882_5_; var14 <= p_74882_8_; ++var14) {
               if(!p_74882_9_ || this.func_175807_a(p_74882_1_, var13, var12, var14, p_74882_2_).func_177230_c().func_149688_o() != Material.field_151579_a) {
                  p_74882_11_.func_75062_a(p_74882_10_, var13, var12, var14, var12 == p_74882_4_ || var12 == p_74882_7_ || var13 == p_74882_3_ || var13 == p_74882_6_ || var14 == p_74882_5_ || var14 == p_74882_8_);
                  this.func_175811_a(p_74882_1_, p_74882_11_.func_180780_a(), var13, var12, var14, p_74882_2_);
               }
            }
         }
      }

   }

   protected void func_175805_a(World p_175805_1_, StructureBoundingBox p_175805_2_, Random p_175805_3_, float p_175805_4_, int p_175805_5_, int p_175805_6_, int p_175805_7_, int p_175805_8_, int p_175805_9_, int p_175805_10_, IBlockState p_175805_11_, IBlockState p_175805_12_, boolean p_175805_13_) {
      for(int var14 = p_175805_6_; var14 <= p_175805_9_; ++var14) {
         for(int var15 = p_175805_5_; var15 <= p_175805_8_; ++var15) {
            for(int var16 = p_175805_7_; var16 <= p_175805_10_; ++var16) {
               if(p_175805_3_.nextFloat() <= p_175805_4_ && (!p_175805_13_ || this.func_175807_a(p_175805_1_, var15, var14, var16, p_175805_2_).func_177230_c().func_149688_o() != Material.field_151579_a)) {
                  if(var14 != p_175805_6_ && var14 != p_175805_9_ && var15 != p_175805_5_ && var15 != p_175805_8_ && var16 != p_175805_7_ && var16 != p_175805_10_) {
                     this.func_175811_a(p_175805_1_, p_175805_12_, var15, var14, var16, p_175805_2_);
                  } else {
                     this.func_175811_a(p_175805_1_, p_175805_11_, var15, var14, var16, p_175805_2_);
                  }
               }
            }
         }
      }

   }

   protected void func_175809_a(World p_175809_1_, StructureBoundingBox p_175809_2_, Random p_175809_3_, float p_175809_4_, int p_175809_5_, int p_175809_6_, int p_175809_7_, IBlockState p_175809_8_) {
      if(p_175809_3_.nextFloat() < p_175809_4_) {
         this.func_175811_a(p_175809_1_, p_175809_8_, p_175809_5_, p_175809_6_, p_175809_7_, p_175809_2_);
      }

   }

   protected void func_180777_a(World p_180777_1_, StructureBoundingBox p_180777_2_, int p_180777_3_, int p_180777_4_, int p_180777_5_, int p_180777_6_, int p_180777_7_, int p_180777_8_, IBlockState p_180777_9_, boolean p_180777_10_) {
      float var11 = (float)(p_180777_6_ - p_180777_3_ + 1);
      float var12 = (float)(p_180777_7_ - p_180777_4_ + 1);
      float var13 = (float)(p_180777_8_ - p_180777_5_ + 1);
      float var14 = (float)p_180777_3_ + var11 / 2.0F;
      float var15 = (float)p_180777_5_ + var13 / 2.0F;

      for(int var16 = p_180777_4_; var16 <= p_180777_7_; ++var16) {
         float var17 = (float)(var16 - p_180777_4_) / var12;

         for(int var18 = p_180777_3_; var18 <= p_180777_6_; ++var18) {
            float var19 = ((float)var18 - var14) / (var11 * 0.5F);

            for(int var20 = p_180777_5_; var20 <= p_180777_8_; ++var20) {
               float var21 = ((float)var20 - var15) / (var13 * 0.5F);
               if(!p_180777_10_ || this.func_175807_a(p_180777_1_, var18, var16, var20, p_180777_2_).func_177230_c().func_149688_o() != Material.field_151579_a) {
                  float var22 = var19 * var19 + var17 * var17 + var21 * var21;
                  if(var22 <= 1.05F) {
                     this.func_175811_a(p_180777_1_, p_180777_9_, var18, var16, var20, p_180777_2_);
                  }
               }
            }
         }
      }

   }

   protected void func_74871_b(World p_74871_1_, int p_74871_2_, int p_74871_3_, int p_74871_4_, StructureBoundingBox p_74871_5_) {
      BlockPos var6 = new BlockPos(this.func_74865_a(p_74871_2_, p_74871_4_), this.func_74862_a(p_74871_3_), this.func_74873_b(p_74871_2_, p_74871_4_));
      if(p_74871_5_.func_175898_b(var6)) {
         while(!p_74871_1_.func_175623_d(var6) && var6.func_177956_o() < 255) {
            p_74871_1_.func_180501_a(var6, Blocks.field_150350_a.func_176223_P(), 2);
            var6 = var6.func_177984_a();
         }

      }
   }

   protected void func_175808_b(World p_175808_1_, IBlockState p_175808_2_, int p_175808_3_, int p_175808_4_, int p_175808_5_, StructureBoundingBox p_175808_6_) {
      int var7 = this.func_74865_a(p_175808_3_, p_175808_5_);
      int var8 = this.func_74862_a(p_175808_4_);
      int var9 = this.func_74873_b(p_175808_3_, p_175808_5_);
      if(p_175808_6_.func_175898_b(new BlockPos(var7, var8, var9))) {
         while((p_175808_1_.func_175623_d(new BlockPos(var7, var8, var9)) || p_175808_1_.func_180495_p(new BlockPos(var7, var8, var9)).func_177230_c().func_149688_o().func_76224_d()) && var8 > 1) {
            p_175808_1_.func_180501_a(new BlockPos(var7, var8, var9), p_175808_2_, 2);
            --var8;
         }

      }
   }

   protected boolean func_180778_a(World p_180778_1_, StructureBoundingBox p_180778_2_, Random p_180778_3_, int p_180778_4_, int p_180778_5_, int p_180778_6_, List p_180778_7_, int p_180778_8_) {
      BlockPos var9 = new BlockPos(this.func_74865_a(p_180778_4_, p_180778_6_), this.func_74862_a(p_180778_5_), this.func_74873_b(p_180778_4_, p_180778_6_));
      if(p_180778_2_.func_175898_b(var9) && p_180778_1_.func_180495_p(var9).func_177230_c() != Blocks.field_150486_ae) {
         IBlockState var10 = Blocks.field_150486_ae.func_176223_P();
         p_180778_1_.func_180501_a(var9, Blocks.field_150486_ae.func_176458_f(p_180778_1_, var9, var10), 2);
         TileEntity var11 = p_180778_1_.func_175625_s(var9);
         if(var11 instanceof TileEntityChest) {
            WeightedRandomChestContent.func_177630_a(p_180778_3_, p_180778_7_, (TileEntityChest)var11, p_180778_8_);
         }

         return true;
      } else {
         return false;
      }
   }

   protected boolean func_175806_a(World p_175806_1_, StructureBoundingBox p_175806_2_, Random p_175806_3_, int p_175806_4_, int p_175806_5_, int p_175806_6_, int p_175806_7_, List p_175806_8_, int p_175806_9_) {
      BlockPos var10 = new BlockPos(this.func_74865_a(p_175806_4_, p_175806_6_), this.func_74862_a(p_175806_5_), this.func_74873_b(p_175806_4_, p_175806_6_));
      if(p_175806_2_.func_175898_b(var10) && p_175806_1_.func_180495_p(var10).func_177230_c() != Blocks.field_150367_z) {
         p_175806_1_.func_180501_a(var10, Blocks.field_150367_z.func_176203_a(this.func_151555_a(Blocks.field_150367_z, p_175806_7_)), 2);
         TileEntity var11 = p_175806_1_.func_175625_s(var10);
         if(var11 instanceof TileEntityDispenser) {
            WeightedRandomChestContent.func_177631_a(p_175806_3_, p_175806_8_, (TileEntityDispenser)var11, p_175806_9_);
         }

         return true;
      } else {
         return false;
      }
   }

   protected void func_175810_a(World p_175810_1_, StructureBoundingBox p_175810_2_, Random p_175810_3_, int p_175810_4_, int p_175810_5_, int p_175810_6_, EnumFacing p_175810_7_) {
      BlockPos var8 = new BlockPos(this.func_74865_a(p_175810_4_, p_175810_6_), this.func_74862_a(p_175810_5_), this.func_74873_b(p_175810_4_, p_175810_6_));
      if(p_175810_2_.func_175898_b(var8)) {
         ItemDoor.func_179235_a(p_175810_1_, var8, p_175810_7_.func_176735_f(), Blocks.field_180413_ao);
      }

   }

   public abstract static class BlockSelector {

      protected IBlockState field_151562_a;
      private static final String __OBFID = "CL_00000512";


      protected BlockSelector() {
         this.field_151562_a = Blocks.field_150350_a.func_176223_P();
      }

      public abstract void func_75062_a(Random var1, int var2, int var3, int var4, boolean var5);

      public IBlockState func_180780_a() {
         return this.field_151562_a;
      }
   }

   // $FF: synthetic class
   static final class SwitchEnumFacing {

      // $FF: synthetic field
      static final int[] field_176100_a = new int[EnumFacing.values().length];
      private static final String __OBFID = "CL_00001969";


      static {
         try {
            field_176100_a[EnumFacing.NORTH.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_176100_a[EnumFacing.SOUTH.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_176100_a[EnumFacing.WEST.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_176100_a[EnumFacing.EAST.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
