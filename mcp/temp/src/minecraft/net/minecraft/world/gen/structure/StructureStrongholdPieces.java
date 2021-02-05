package net.minecraft.world.gen.structure;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.block.BlockSilverfish;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureStrongholdPieces {

   private static final StructureStrongholdPieces.PieceWeight[] field_75205_b = new StructureStrongholdPieces.PieceWeight[]{new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.Straight.class, 40, 0), new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.Prison.class, 5, 5), new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.LeftTurn.class, 20, 0), new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.RightTurn.class, 20, 0), new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.RoomCrossing.class, 10, 6), new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.StairsStraight.class, 5, 5), new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.Stairs.class, 5, 5), new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.Crossing.class, 5, 4), new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.ChestCorridor.class, 5, 4), new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.Library.class, 10, 2) {

      private static final String __OBFID = "CL_00000484";

      public boolean func_75189_a(int p_75189_1_) {
         return super.func_75189_a(p_75189_1_) && p_75189_1_ > 4;
      }
   }, new StructureStrongholdPieces.PieceWeight(StructureStrongholdPieces.PortalRoom.class, 20, 1) {

      private static final String __OBFID = "CL_00000485";

      public boolean func_75189_a(int p_75189_1_) {
         return super.func_75189_a(p_75189_1_) && p_75189_1_ > 5;
      }
   }};
   private static List field_75206_c;
   private static Class field_75203_d;
   static int field_75207_a;
   private static final StructureStrongholdPieces.Stones field_75204_e = new StructureStrongholdPieces.Stones(null);
   private static final String __OBFID = "CL_00000483";


   public static void func_143046_a() {
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.ChestCorridor.class, "SHCC");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.Corridor.class, "SHFC");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.Crossing.class, "SH5C");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.LeftTurn.class, "SHLT");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.Library.class, "SHLi");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.PortalRoom.class, "SHPR");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.Prison.class, "SHPH");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.RightTurn.class, "SHRT");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.RoomCrossing.class, "SHRC");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.Stairs.class, "SHSD");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.Stairs2.class, "SHStart");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.Straight.class, "SHS");
      MapGenStructureIO.func_143031_a(StructureStrongholdPieces.StairsStraight.class, "SHSSD");
   }

   public static void func_75198_a() {
      field_75206_c = Lists.newArrayList();
      StructureStrongholdPieces.PieceWeight[] var0 = field_75205_b;
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         StructureStrongholdPieces.PieceWeight var3 = var0[var2];
         var3.field_75193_c = 0;
         field_75206_c.add(var3);
      }

      field_75203_d = null;
   }

   private static boolean func_75202_c() {
      boolean var0 = false;
      field_75207_a = 0;

      StructureStrongholdPieces.PieceWeight var2;
      for(Iterator var1 = field_75206_c.iterator(); var1.hasNext(); field_75207_a += var2.field_75192_b) {
         var2 = (StructureStrongholdPieces.PieceWeight)var1.next();
         if(var2.field_75191_d > 0 && var2.field_75193_c < var2.field_75191_d) {
            var0 = true;
         }
      }

      return var0;
   }

   private static StructureStrongholdPieces.Stronghold func_175954_a(Class p_175954_0_, List p_175954_1_, Random p_175954_2_, int p_175954_3_, int p_175954_4_, int p_175954_5_, EnumFacing p_175954_6_, int p_175954_7_) {
      Object var8 = null;
      if(p_175954_0_ == StructureStrongholdPieces.Straight.class) {
         var8 = StructureStrongholdPieces.Straight.func_175862_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if(p_175954_0_ == StructureStrongholdPieces.Prison.class) {
         var8 = StructureStrongholdPieces.Prison.func_175860_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if(p_175954_0_ == StructureStrongholdPieces.LeftTurn.class) {
         var8 = StructureStrongholdPieces.LeftTurn.func_175867_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if(p_175954_0_ == StructureStrongholdPieces.RightTurn.class) {
         var8 = StructureStrongholdPieces.RightTurn.func_175867_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if(p_175954_0_ == StructureStrongholdPieces.RoomCrossing.class) {
         var8 = StructureStrongholdPieces.RoomCrossing.func_175859_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if(p_175954_0_ == StructureStrongholdPieces.StairsStraight.class) {
         var8 = StructureStrongholdPieces.StairsStraight.func_175861_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if(p_175954_0_ == StructureStrongholdPieces.Stairs.class) {
         var8 = StructureStrongholdPieces.Stairs.func_175863_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if(p_175954_0_ == StructureStrongholdPieces.Crossing.class) {
         var8 = StructureStrongholdPieces.Crossing.func_175866_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if(p_175954_0_ == StructureStrongholdPieces.ChestCorridor.class) {
         var8 = StructureStrongholdPieces.ChestCorridor.func_175868_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if(p_175954_0_ == StructureStrongholdPieces.Library.class) {
         var8 = StructureStrongholdPieces.Library.func_175864_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      } else if(p_175954_0_ == StructureStrongholdPieces.PortalRoom.class) {
         var8 = StructureStrongholdPieces.PortalRoom.func_175865_a(p_175954_1_, p_175954_2_, p_175954_3_, p_175954_4_, p_175954_5_, p_175954_6_, p_175954_7_);
      }

      return (StructureStrongholdPieces.Stronghold)var8;
   }

   private static StructureStrongholdPieces.Stronghold func_175955_b(StructureStrongholdPieces.Stairs2 p_175955_0_, List p_175955_1_, Random p_175955_2_, int p_175955_3_, int p_175955_4_, int p_175955_5_, EnumFacing p_175955_6_, int p_175955_7_) {
      if(!func_75202_c()) {
         return null;
      } else {
         if(field_75203_d != null) {
            StructureStrongholdPieces.Stronghold var8 = func_175954_a(field_75203_d, p_175955_1_, p_175955_2_, p_175955_3_, p_175955_4_, p_175955_5_, p_175955_6_, p_175955_7_);
            field_75203_d = null;
            if(var8 != null) {
               return var8;
            }
         }

         int var13 = 0;

         while(var13 < 5) {
            ++var13;
            int var9 = p_175955_2_.nextInt(field_75207_a);
            Iterator var10 = field_75206_c.iterator();

            while(var10.hasNext()) {
               StructureStrongholdPieces.PieceWeight var11 = (StructureStrongholdPieces.PieceWeight)var10.next();
               var9 -= var11.field_75192_b;
               if(var9 < 0) {
                  if(!var11.func_75189_a(p_175955_7_) || var11 == p_175955_0_.field_75027_a) {
                     break;
                  }

                  StructureStrongholdPieces.Stronghold var12 = func_175954_a(var11.field_75194_a, p_175955_1_, p_175955_2_, p_175955_3_, p_175955_4_, p_175955_5_, p_175955_6_, p_175955_7_);
                  if(var12 != null) {
                     ++var11.field_75193_c;
                     p_175955_0_.field_75027_a = var11;
                     if(!var11.func_75190_a()) {
                        field_75206_c.remove(var11);
                     }

                     return var12;
                  }
               }
            }
         }

         StructureBoundingBox var14 = StructureStrongholdPieces.Corridor.func_175869_a(p_175955_1_, p_175955_2_, p_175955_3_, p_175955_4_, p_175955_5_, p_175955_6_);
         if(var14 != null && var14.field_78895_b > 1) {
            return new StructureStrongholdPieces.Corridor(p_175955_7_, p_175955_2_, var14, p_175955_6_);
         } else {
            return null;
         }
      }
   }

   private static StructureComponent func_175953_c(StructureStrongholdPieces.Stairs2 p_175953_0_, List p_175953_1_, Random p_175953_2_, int p_175953_3_, int p_175953_4_, int p_175953_5_, EnumFacing p_175953_6_, int p_175953_7_) {
      if(p_175953_7_ > 50) {
         return null;
      } else if(Math.abs(p_175953_3_ - p_175953_0_.func_74874_b().field_78897_a) <= 112 && Math.abs(p_175953_5_ - p_175953_0_.func_74874_b().field_78896_c) <= 112) {
         StructureStrongholdPieces.Stronghold var8 = func_175955_b(p_175953_0_, p_175953_1_, p_175953_2_, p_175953_3_, p_175953_4_, p_175953_5_, p_175953_6_, p_175953_7_ + 1);
         if(var8 != null) {
            p_175953_1_.add(var8);
            p_175953_0_.field_75026_c.add(var8);
         }

         return var8;
      } else {
         return null;
      }
   }


   public static class ChestCorridor extends StructureStrongholdPieces.Stronghold {

      private static final List field_75003_a = Lists.newArrayList(new WeightedRandomChestContent[]{new WeightedRandomChestContent(Items.field_151079_bi, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151045_i, 0, 1, 3, 3), new WeightedRandomChestContent(Items.field_151042_j, 0, 1, 5, 10), new WeightedRandomChestContent(Items.field_151043_k, 0, 1, 3, 5), new WeightedRandomChestContent(Items.field_151137_ax, 0, 4, 9, 5), new WeightedRandomChestContent(Items.field_151025_P, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151034_e, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151035_b, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151040_l, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151030_Z, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151028_Y, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151165_aa, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151167_ab, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151153_ao, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151141_av, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151138_bX, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151136_bY, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151125_bZ, 0, 1, 1, 1)});
      private boolean field_75002_c;
      private static final String __OBFID = "CL_00000487";


      public ChestCorridor() {}

      public ChestCorridor(int p_i45582_1_, Random p_i45582_2_, StructureBoundingBox p_i45582_3_, EnumFacing p_i45582_4_) {
         super(p_i45582_1_);
         this.field_74885_f = p_i45582_4_;
         this.field_143013_d = this.func_74988_a(p_i45582_2_);
         this.field_74887_e = p_i45582_3_;
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74757_a("Chest", this.field_75002_c);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_75002_c = p_143011_1_.func_74767_n("Chest");
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         this.func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
      }

      public static StructureStrongholdPieces.ChestCorridor func_175868_a(List p_175868_0_, Random p_175868_1_, int p_175868_2_, int p_175868_3_, int p_175868_4_, EnumFacing p_175868_5_, int p_175868_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175868_2_, p_175868_3_, p_175868_4_, -1, -1, 0, 5, 5, 7, p_175868_5_);
         return func_74991_a(var7) && StructureComponent.func_74883_a(p_175868_0_, var7) == null?new StructureStrongholdPieces.ChestCorridor(p_175868_6_, p_175868_1_, var7, p_175868_5_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 6, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, StructureStrongholdPieces.Stronghold.Door.OPENING, 1, 1, 6);
            this.func_175804_a(p_74875_1_, p_74875_3_, 3, 1, 2, 3, 1, 4, Blocks.field_150417_aV.func_176223_P(), Blocks.field_150417_aV.func_176223_P(), false);
            this.func_175811_a(p_74875_1_, Blocks.field_150333_U.func_176203_a(BlockStoneSlab.EnumType.SMOOTHBRICK.func_176624_a()), 3, 1, 1, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150333_U.func_176203_a(BlockStoneSlab.EnumType.SMOOTHBRICK.func_176624_a()), 3, 1, 5, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150333_U.func_176203_a(BlockStoneSlab.EnumType.SMOOTHBRICK.func_176624_a()), 3, 2, 2, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150333_U.func_176203_a(BlockStoneSlab.EnumType.SMOOTHBRICK.func_176624_a()), 3, 2, 4, p_74875_3_);

            for(int var4 = 2; var4 <= 4; ++var4) {
               this.func_175811_a(p_74875_1_, Blocks.field_150333_U.func_176203_a(BlockStoneSlab.EnumType.SMOOTHBRICK.func_176624_a()), 2, 1, var4, p_74875_3_);
            }

            if(!this.field_75002_c && p_74875_3_.func_175898_b(new BlockPos(this.func_74865_a(3, 3), this.func_74862_a(2), this.func_74873_b(3, 3)))) {
               this.field_75002_c = true;
               this.func_180778_a(p_74875_1_, p_74875_3_, p_74875_2_, 3, 2, 3, WeightedRandomChestContent.func_177629_a(field_75003_a, new WeightedRandomChestContent[]{Items.field_151134_bR.func_92114_b(p_74875_2_)}), 2 + p_74875_2_.nextInt(2));
            }

            return true;
         }
      }

   }

   public static class Corridor extends StructureStrongholdPieces.Stronghold {

      private int field_74993_a;
      private static final String __OBFID = "CL_00000488";


      public Corridor() {}

      public Corridor(int p_i45581_1_, Random p_i45581_2_, StructureBoundingBox p_i45581_3_, EnumFacing p_i45581_4_) {
         super(p_i45581_1_);
         this.field_74885_f = p_i45581_4_;
         this.field_74887_e = p_i45581_3_;
         this.field_74993_a = p_i45581_4_ != EnumFacing.NORTH && p_i45581_4_ != EnumFacing.SOUTH?p_i45581_3_.func_78883_b():p_i45581_3_.func_78880_d();
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74768_a("Steps", this.field_74993_a);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_74993_a = p_143011_1_.func_74762_e("Steps");
      }

      public static StructureBoundingBox func_175869_a(List p_175869_0_, Random p_175869_1_, int p_175869_2_, int p_175869_3_, int p_175869_4_, EnumFacing p_175869_5_) {
         boolean var6 = true;
         StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175869_2_, p_175869_3_, p_175869_4_, -1, -1, 0, 5, 5, 4, p_175869_5_);
         StructureComponent var8 = StructureComponent.func_74883_a(p_175869_0_, var7);
         if(var8 == null) {
            return null;
         } else {
            if(var8.func_74874_b().field_78895_b == var7.field_78895_b) {
               for(int var9 = 3; var9 >= 1; --var9) {
                  var7 = StructureBoundingBox.func_175897_a(p_175869_2_, p_175869_3_, p_175869_4_, -1, -1, 0, 5, 5, var9 - 1, p_175869_5_);
                  if(!var8.func_74874_b().func_78884_a(var7)) {
                     return StructureBoundingBox.func_175897_a(p_175869_2_, p_175869_3_, p_175869_4_, -1, -1, 0, 5, 5, var9, p_175869_5_);
                  }
               }
            }

            return null;
         }
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            for(int var4 = 0; var4 < this.field_74993_a; ++var4) {
               this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 0, 0, var4, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 1, 0, var4, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 2, 0, var4, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 3, 0, var4, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 4, 0, var4, p_74875_3_);

               for(int var5 = 1; var5 <= 3; ++var5) {
                  this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 0, var5, var4, p_74875_3_);
                  this.func_175811_a(p_74875_1_, Blocks.field_150350_a.func_176223_P(), 1, var5, var4, p_74875_3_);
                  this.func_175811_a(p_74875_1_, Blocks.field_150350_a.func_176223_P(), 2, var5, var4, p_74875_3_);
                  this.func_175811_a(p_74875_1_, Blocks.field_150350_a.func_176223_P(), 3, var5, var4, p_74875_3_);
                  this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 4, var5, var4, p_74875_3_);
               }

               this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 0, 4, var4, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 1, 4, var4, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 2, 4, var4, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 3, 4, var4, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 4, 4, var4, p_74875_3_);
            }

            return true;
         }
      }
   }

   public static class Crossing extends StructureStrongholdPieces.Stronghold {

      private boolean field_74996_b;
      private boolean field_74997_c;
      private boolean field_74995_d;
      private boolean field_74999_h;
      private static final String __OBFID = "CL_00000489";


      public Crossing() {}

      public Crossing(int p_i45580_1_, Random p_i45580_2_, StructureBoundingBox p_i45580_3_, EnumFacing p_i45580_4_) {
         super(p_i45580_1_);
         this.field_74885_f = p_i45580_4_;
         this.field_143013_d = this.func_74988_a(p_i45580_2_);
         this.field_74887_e = p_i45580_3_;
         this.field_74996_b = p_i45580_2_.nextBoolean();
         this.field_74997_c = p_i45580_2_.nextBoolean();
         this.field_74995_d = p_i45580_2_.nextBoolean();
         this.field_74999_h = p_i45580_2_.nextInt(3) > 0;
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74757_a("leftLow", this.field_74996_b);
         p_143012_1_.func_74757_a("leftHigh", this.field_74997_c);
         p_143012_1_.func_74757_a("rightLow", this.field_74995_d);
         p_143012_1_.func_74757_a("rightHigh", this.field_74999_h);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_74996_b = p_143011_1_.func_74767_n("leftLow");
         this.field_74997_c = p_143011_1_.func_74767_n("leftHigh");
         this.field_74995_d = p_143011_1_.func_74767_n("rightLow");
         this.field_74999_h = p_143011_1_.func_74767_n("rightHigh");
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         int var4 = 3;
         int var5 = 5;
         if(this.field_74885_f == EnumFacing.WEST || this.field_74885_f == EnumFacing.NORTH) {
            var4 = 8 - var4;
            var5 = 8 - var5;
         }

         this.func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 5, 1);
         if(this.field_74996_b) {
            this.func_74989_b((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, var4, 1);
         }

         if(this.field_74997_c) {
            this.func_74989_b((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, var5, 7);
         }

         if(this.field_74995_d) {
            this.func_74987_c((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, var4, 1);
         }

         if(this.field_74999_h) {
            this.func_74987_c((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, var5, 7);
         }

      }

      public static StructureStrongholdPieces.Crossing func_175866_a(List p_175866_0_, Random p_175866_1_, int p_175866_2_, int p_175866_3_, int p_175866_4_, EnumFacing p_175866_5_, int p_175866_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175866_2_, p_175866_3_, p_175866_4_, -4, -3, 0, 10, 9, 11, p_175866_5_);
         return func_74991_a(var7) && StructureComponent.func_74883_a(p_175866_0_, var7) == null?new StructureStrongholdPieces.Crossing(p_175866_6_, p_175866_1_, var7, p_175866_5_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 9, 8, 10, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 4, 3, 0);
            if(this.field_74996_b) {
               this.func_175804_a(p_74875_1_, p_74875_3_, 0, 3, 1, 0, 5, 3, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            }

            if(this.field_74995_d) {
               this.func_175804_a(p_74875_1_, p_74875_3_, 9, 3, 1, 9, 5, 3, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            }

            if(this.field_74997_c) {
               this.func_175804_a(p_74875_1_, p_74875_3_, 0, 5, 7, 0, 7, 9, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            }

            if(this.field_74999_h) {
               this.func_175804_a(p_74875_1_, p_74875_3_, 9, 5, 7, 9, 7, 9, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            }

            this.func_175804_a(p_74875_1_, p_74875_3_, 5, 1, 10, 7, 3, 10, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            this.func_74882_a(p_74875_1_, p_74875_3_, 1, 2, 1, 8, 2, 6, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 5, 4, 4, 9, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74882_a(p_74875_1_, p_74875_3_, 8, 1, 5, 8, 4, 9, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74882_a(p_74875_1_, p_74875_3_, 1, 4, 7, 3, 4, 9, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74882_a(p_74875_1_, p_74875_3_, 1, 3, 5, 3, 3, 6, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_175804_a(p_74875_1_, p_74875_3_, 1, 3, 4, 3, 3, 4, Blocks.field_150333_U.func_176223_P(), Blocks.field_150333_U.func_176223_P(), false);
            this.func_175804_a(p_74875_1_, p_74875_3_, 1, 4, 6, 3, 4, 6, Blocks.field_150333_U.func_176223_P(), Blocks.field_150333_U.func_176223_P(), false);
            this.func_74882_a(p_74875_1_, p_74875_3_, 5, 1, 7, 7, 1, 8, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_175804_a(p_74875_1_, p_74875_3_, 5, 1, 9, 7, 1, 9, Blocks.field_150333_U.func_176223_P(), Blocks.field_150333_U.func_176223_P(), false);
            this.func_175804_a(p_74875_1_, p_74875_3_, 5, 2, 7, 7, 2, 7, Blocks.field_150333_U.func_176223_P(), Blocks.field_150333_U.func_176223_P(), false);
            this.func_175804_a(p_74875_1_, p_74875_3_, 4, 5, 7, 4, 5, 9, Blocks.field_150333_U.func_176223_P(), Blocks.field_150333_U.func_176223_P(), false);
            this.func_175804_a(p_74875_1_, p_74875_3_, 8, 5, 7, 8, 5, 9, Blocks.field_150333_U.func_176223_P(), Blocks.field_150333_U.func_176223_P(), false);
            this.func_175804_a(p_74875_1_, p_74875_3_, 5, 5, 7, 7, 5, 9, Blocks.field_150334_T.func_176223_P(), Blocks.field_150334_T.func_176223_P(), false);
            this.func_175811_a(p_74875_1_, Blocks.field_150478_aa.func_176223_P(), 6, 5, 6, p_74875_3_);
            return true;
         }
      }
   }

   public static class LeftTurn extends StructureStrongholdPieces.Stronghold {

      private static final String __OBFID = "CL_00000490";


      public LeftTurn() {}

      public LeftTurn(int p_i45579_1_, Random p_i45579_2_, StructureBoundingBox p_i45579_3_, EnumFacing p_i45579_4_) {
         super(p_i45579_1_);
         this.field_74885_f = p_i45579_4_;
         this.field_143013_d = this.func_74988_a(p_i45579_2_);
         this.field_74887_e = p_i45579_3_;
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         if(this.field_74885_f != EnumFacing.NORTH && this.field_74885_f != EnumFacing.EAST) {
            this.func_74987_c((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
         } else {
            this.func_74989_b((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
         }

      }

      public static StructureStrongholdPieces.LeftTurn func_175867_a(List p_175867_0_, Random p_175867_1_, int p_175867_2_, int p_175867_3_, int p_175867_4_, EnumFacing p_175867_5_, int p_175867_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175867_2_, p_175867_3_, p_175867_4_, -1, -1, 0, 5, 5, 5, p_175867_5_);
         return func_74991_a(var7) && StructureComponent.func_74883_a(p_175867_0_, var7) == null?new StructureStrongholdPieces.LeftTurn(p_175867_6_, p_175867_1_, var7, p_175867_5_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 4, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);
            if(this.field_74885_f != EnumFacing.NORTH && this.field_74885_f != EnumFacing.EAST) {
               this.func_175804_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 3, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            } else {
               this.func_175804_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 3, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            }

            return true;
         }
      }
   }

   public static class Library extends StructureStrongholdPieces.Stronghold {

      private static final List field_75007_b = Lists.newArrayList(new WeightedRandomChestContent[]{new WeightedRandomChestContent(Items.field_151122_aG, 0, 1, 3, 20), new WeightedRandomChestContent(Items.field_151121_aF, 0, 2, 7, 20), new WeightedRandomChestContent(Items.field_151148_bJ, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151111_aL, 0, 1, 1, 1)});
      private boolean field_75008_c;
      private static final String __OBFID = "CL_00000491";


      public Library() {}

      public Library(int p_i45578_1_, Random p_i45578_2_, StructureBoundingBox p_i45578_3_, EnumFacing p_i45578_4_) {
         super(p_i45578_1_);
         this.field_74885_f = p_i45578_4_;
         this.field_143013_d = this.func_74988_a(p_i45578_2_);
         this.field_74887_e = p_i45578_3_;
         this.field_75008_c = p_i45578_3_.func_78882_c() > 6;
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74757_a("Tall", this.field_75008_c);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_75008_c = p_143011_1_.func_74767_n("Tall");
      }

      public static StructureStrongholdPieces.Library func_175864_a(List p_175864_0_, Random p_175864_1_, int p_175864_2_, int p_175864_3_, int p_175864_4_, EnumFacing p_175864_5_, int p_175864_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175864_2_, p_175864_3_, p_175864_4_, -4, -1, 0, 14, 11, 15, p_175864_5_);
         if(!func_74991_a(var7) || StructureComponent.func_74883_a(p_175864_0_, var7) != null) {
            var7 = StructureBoundingBox.func_175897_a(p_175864_2_, p_175864_3_, p_175864_4_, -4, -1, 0, 14, 6, 15, p_175864_5_);
            if(!func_74991_a(var7) || StructureComponent.func_74883_a(p_175864_0_, var7) != null) {
               return null;
            }
         }

         return new StructureStrongholdPieces.Library(p_175864_6_, p_175864_1_, var7, p_175864_5_);
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            byte var4 = 11;
            if(!this.field_75008_c) {
               var4 = 6;
            }

            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 13, var4 - 1, 14, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 4, 1, 0);
            this.func_175805_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.07F, 2, 1, 1, 11, 4, 13, Blocks.field_150321_G.func_176223_P(), Blocks.field_150321_G.func_176223_P(), false);
            boolean var5 = true;
            boolean var6 = true;

            int var7;
            for(var7 = 1; var7 <= 13; ++var7) {
               if((var7 - 1) % 4 == 0) {
                  this.func_175804_a(p_74875_1_, p_74875_3_, 1, 1, var7, 1, 4, var7, Blocks.field_150344_f.func_176223_P(), Blocks.field_150344_f.func_176223_P(), false);
                  this.func_175804_a(p_74875_1_, p_74875_3_, 12, 1, var7, 12, 4, var7, Blocks.field_150344_f.func_176223_P(), Blocks.field_150344_f.func_176223_P(), false);
                  this.func_175811_a(p_74875_1_, Blocks.field_150478_aa.func_176223_P(), 2, 3, var7, p_74875_3_);
                  this.func_175811_a(p_74875_1_, Blocks.field_150478_aa.func_176223_P(), 11, 3, var7, p_74875_3_);
                  if(this.field_75008_c) {
                     this.func_175804_a(p_74875_1_, p_74875_3_, 1, 6, var7, 1, 9, var7, Blocks.field_150344_f.func_176223_P(), Blocks.field_150344_f.func_176223_P(), false);
                     this.func_175804_a(p_74875_1_, p_74875_3_, 12, 6, var7, 12, 9, var7, Blocks.field_150344_f.func_176223_P(), Blocks.field_150344_f.func_176223_P(), false);
                  }
               } else {
                  this.func_175804_a(p_74875_1_, p_74875_3_, 1, 1, var7, 1, 4, var7, Blocks.field_150342_X.func_176223_P(), Blocks.field_150342_X.func_176223_P(), false);
                  this.func_175804_a(p_74875_1_, p_74875_3_, 12, 1, var7, 12, 4, var7, Blocks.field_150342_X.func_176223_P(), Blocks.field_150342_X.func_176223_P(), false);
                  if(this.field_75008_c) {
                     this.func_175804_a(p_74875_1_, p_74875_3_, 1, 6, var7, 1, 9, var7, Blocks.field_150342_X.func_176223_P(), Blocks.field_150342_X.func_176223_P(), false);
                     this.func_175804_a(p_74875_1_, p_74875_3_, 12, 6, var7, 12, 9, var7, Blocks.field_150342_X.func_176223_P(), Blocks.field_150342_X.func_176223_P(), false);
                  }
               }
            }

            for(var7 = 3; var7 < 12; var7 += 2) {
               this.func_175804_a(p_74875_1_, p_74875_3_, 3, 1, var7, 4, 3, var7, Blocks.field_150342_X.func_176223_P(), Blocks.field_150342_X.func_176223_P(), false);
               this.func_175804_a(p_74875_1_, p_74875_3_, 6, 1, var7, 7, 3, var7, Blocks.field_150342_X.func_176223_P(), Blocks.field_150342_X.func_176223_P(), false);
               this.func_175804_a(p_74875_1_, p_74875_3_, 9, 1, var7, 10, 3, var7, Blocks.field_150342_X.func_176223_P(), Blocks.field_150342_X.func_176223_P(), false);
            }

            if(this.field_75008_c) {
               this.func_175804_a(p_74875_1_, p_74875_3_, 1, 5, 1, 3, 5, 13, Blocks.field_150344_f.func_176223_P(), Blocks.field_150344_f.func_176223_P(), false);
               this.func_175804_a(p_74875_1_, p_74875_3_, 10, 5, 1, 12, 5, 13, Blocks.field_150344_f.func_176223_P(), Blocks.field_150344_f.func_176223_P(), false);
               this.func_175804_a(p_74875_1_, p_74875_3_, 4, 5, 1, 9, 5, 2, Blocks.field_150344_f.func_176223_P(), Blocks.field_150344_f.func_176223_P(), false);
               this.func_175804_a(p_74875_1_, p_74875_3_, 4, 5, 12, 9, 5, 13, Blocks.field_150344_f.func_176223_P(), Blocks.field_150344_f.func_176223_P(), false);
               this.func_175811_a(p_74875_1_, Blocks.field_150344_f.func_176223_P(), 9, 5, 11, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150344_f.func_176223_P(), 8, 5, 11, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150344_f.func_176223_P(), 9, 5, 10, p_74875_3_);
               this.func_175804_a(p_74875_1_, p_74875_3_, 3, 6, 2, 3, 6, 12, Blocks.field_180407_aO.func_176223_P(), Blocks.field_180407_aO.func_176223_P(), false);
               this.func_175804_a(p_74875_1_, p_74875_3_, 10, 6, 2, 10, 6, 10, Blocks.field_180407_aO.func_176223_P(), Blocks.field_180407_aO.func_176223_P(), false);
               this.func_175804_a(p_74875_1_, p_74875_3_, 4, 6, 2, 9, 6, 2, Blocks.field_180407_aO.func_176223_P(), Blocks.field_180407_aO.func_176223_P(), false);
               this.func_175804_a(p_74875_1_, p_74875_3_, 4, 6, 12, 8, 6, 12, Blocks.field_180407_aO.func_176223_P(), Blocks.field_180407_aO.func_176223_P(), false);
               this.func_175811_a(p_74875_1_, Blocks.field_180407_aO.func_176223_P(), 9, 6, 11, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_180407_aO.func_176223_P(), 8, 6, 11, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_180407_aO.func_176223_P(), 9, 6, 10, p_74875_3_);
               var7 = this.func_151555_a(Blocks.field_150468_ap, 3);
               this.func_175811_a(p_74875_1_, Blocks.field_150468_ap.func_176203_a(var7), 10, 1, 13, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150468_ap.func_176203_a(var7), 10, 2, 13, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150468_ap.func_176203_a(var7), 10, 3, 13, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150468_ap.func_176203_a(var7), 10, 4, 13, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150468_ap.func_176203_a(var7), 10, 5, 13, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150468_ap.func_176203_a(var7), 10, 6, 13, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150468_ap.func_176203_a(var7), 10, 7, 13, p_74875_3_);
               byte var8 = 7;
               byte var9 = 7;
               this.func_175811_a(p_74875_1_, Blocks.field_180407_aO.func_176223_P(), var8 - 1, 9, var9, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_180407_aO.func_176223_P(), var8, 9, var9, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_180407_aO.func_176223_P(), var8 - 1, 8, var9, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_180407_aO.func_176223_P(), var8, 8, var9, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_180407_aO.func_176223_P(), var8 - 1, 7, var9, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_180407_aO.func_176223_P(), var8, 7, var9, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_180407_aO.func_176223_P(), var8 - 2, 7, var9, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_180407_aO.func_176223_P(), var8 + 1, 7, var9, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_180407_aO.func_176223_P(), var8 - 1, 7, var9 - 1, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_180407_aO.func_176223_P(), var8 - 1, 7, var9 + 1, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_180407_aO.func_176223_P(), var8, 7, var9 - 1, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_180407_aO.func_176223_P(), var8, 7, var9 + 1, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150478_aa.func_176223_P(), var8 - 2, 8, var9, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150478_aa.func_176223_P(), var8 + 1, 8, var9, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150478_aa.func_176223_P(), var8 - 1, 8, var9 - 1, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150478_aa.func_176223_P(), var8 - 1, 8, var9 + 1, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150478_aa.func_176223_P(), var8, 8, var9 - 1, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150478_aa.func_176223_P(), var8, 8, var9 + 1, p_74875_3_);
            }

            this.func_180778_a(p_74875_1_, p_74875_3_, p_74875_2_, 3, 3, 5, WeightedRandomChestContent.func_177629_a(field_75007_b, new WeightedRandomChestContent[]{Items.field_151134_bR.func_92112_a(p_74875_2_, 1, 5, 2)}), 1 + p_74875_2_.nextInt(4));
            if(this.field_75008_c) {
               this.func_175811_a(p_74875_1_, Blocks.field_150350_a.func_176223_P(), 12, 9, 1, p_74875_3_);
               this.func_180778_a(p_74875_1_, p_74875_3_, p_74875_2_, 12, 8, 1, WeightedRandomChestContent.func_177629_a(field_75007_b, new WeightedRandomChestContent[]{Items.field_151134_bR.func_92112_a(p_74875_2_, 1, 5, 2)}), 1 + p_74875_2_.nextInt(4));
            }

            return true;
         }
      }

   }

   static class PieceWeight {

      public Class field_75194_a;
      public final int field_75192_b;
      public int field_75193_c;
      public int field_75191_d;
      private static final String __OBFID = "CL_00000492";


      public PieceWeight(Class p_i2076_1_, int p_i2076_2_, int p_i2076_3_) {
         this.field_75194_a = p_i2076_1_;
         this.field_75192_b = p_i2076_2_;
         this.field_75191_d = p_i2076_3_;
      }

      public boolean func_75189_a(int p_75189_1_) {
         return this.field_75191_d == 0 || this.field_75193_c < this.field_75191_d;
      }

      public boolean func_75190_a() {
         return this.field_75191_d == 0 || this.field_75193_c < this.field_75191_d;
      }
   }

   public static class PortalRoom extends StructureStrongholdPieces.Stronghold {

      private boolean field_75005_a;
      private static final String __OBFID = "CL_00000493";


      public PortalRoom() {}

      public PortalRoom(int p_i45577_1_, Random p_i45577_2_, StructureBoundingBox p_i45577_3_, EnumFacing p_i45577_4_) {
         super(p_i45577_1_);
         this.field_74885_f = p_i45577_4_;
         this.field_74887_e = p_i45577_3_;
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74757_a("Mob", this.field_75005_a);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_75005_a = p_143011_1_.func_74767_n("Mob");
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         if(p_74861_1_ != null) {
            ((StructureStrongholdPieces.Stairs2)p_74861_1_).field_75025_b = this;
         }

      }

      public static StructureStrongholdPieces.PortalRoom func_175865_a(List p_175865_0_, Random p_175865_1_, int p_175865_2_, int p_175865_3_, int p_175865_4_, EnumFacing p_175865_5_, int p_175865_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175865_2_, p_175865_3_, p_175865_4_, -4, -1, 0, 11, 8, 16, p_175865_5_);
         return func_74991_a(var7) && StructureComponent.func_74883_a(p_175865_0_, var7) == null?new StructureStrongholdPieces.PortalRoom(p_175865_6_, p_175865_1_, var7, p_175865_5_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 10, 7, 15, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, StructureStrongholdPieces.Stronghold.Door.GRATES, 4, 1, 0);
         byte var4 = 6;
         this.func_74882_a(p_74875_1_, p_74875_3_, 1, var4, 1, 1, var4, 14, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_74882_a(p_74875_1_, p_74875_3_, 9, var4, 1, 9, var4, 14, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_74882_a(p_74875_1_, p_74875_3_, 2, var4, 1, 8, var4, 2, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_74882_a(p_74875_1_, p_74875_3_, 2, var4, 14, 8, var4, 14, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_74882_a(p_74875_1_, p_74875_3_, 1, 1, 1, 2, 1, 4, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_74882_a(p_74875_1_, p_74875_3_, 8, 1, 1, 9, 1, 4, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_175804_a(p_74875_1_, p_74875_3_, 1, 1, 1, 1, 1, 3, Blocks.field_150356_k.func_176223_P(), Blocks.field_150356_k.func_176223_P(), false);
         this.func_175804_a(p_74875_1_, p_74875_3_, 9, 1, 1, 9, 1, 3, Blocks.field_150356_k.func_176223_P(), Blocks.field_150356_k.func_176223_P(), false);
         this.func_74882_a(p_74875_1_, p_74875_3_, 3, 1, 8, 7, 1, 12, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_175804_a(p_74875_1_, p_74875_3_, 4, 1, 9, 6, 1, 11, Blocks.field_150356_k.func_176223_P(), Blocks.field_150356_k.func_176223_P(), false);

         int var5;
         for(var5 = 3; var5 < 14; var5 += 2) {
            this.func_175804_a(p_74875_1_, p_74875_3_, 0, 3, var5, 0, 4, var5, Blocks.field_150411_aY.func_176223_P(), Blocks.field_150411_aY.func_176223_P(), false);
            this.func_175804_a(p_74875_1_, p_74875_3_, 10, 3, var5, 10, 4, var5, Blocks.field_150411_aY.func_176223_P(), Blocks.field_150411_aY.func_176223_P(), false);
         }

         for(var5 = 2; var5 < 9; var5 += 2) {
            this.func_175804_a(p_74875_1_, p_74875_3_, var5, 3, 15, var5, 4, 15, Blocks.field_150411_aY.func_176223_P(), Blocks.field_150411_aY.func_176223_P(), false);
         }

         var5 = this.func_151555_a(Blocks.field_150390_bg, 3);
         this.func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 5, 6, 1, 7, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_74882_a(p_74875_1_, p_74875_3_, 4, 2, 6, 6, 2, 7, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
         this.func_74882_a(p_74875_1_, p_74875_3_, 4, 3, 7, 6, 3, 7, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);

         int var6;
         for(var6 = 4; var6 <= 6; ++var6) {
            this.func_175811_a(p_74875_1_, Blocks.field_150390_bg.func_176203_a(var5), var6, 1, 4, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150390_bg.func_176203_a(var5), var6, 2, 5, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150390_bg.func_176203_a(var5), var6, 3, 6, p_74875_3_);
         }

         var6 = EnumFacing.NORTH.func_176736_b();
         int var7 = EnumFacing.SOUTH.func_176736_b();
         int var8 = EnumFacing.EAST.func_176736_b();
         int var9 = EnumFacing.WEST.func_176736_b();
         if(this.field_74885_f != null) {
            switch(StructureStrongholdPieces.SwitchEnumFacing.field_175951_b[this.field_74885_f.ordinal()]) {
            case 2:
               var6 = EnumFacing.SOUTH.func_176736_b();
               var7 = EnumFacing.NORTH.func_176736_b();
               break;
            case 3:
               var6 = EnumFacing.WEST.func_176736_b();
               var7 = EnumFacing.EAST.func_176736_b();
               var8 = EnumFacing.SOUTH.func_176736_b();
               var9 = EnumFacing.NORTH.func_176736_b();
               break;
            case 4:
               var6 = EnumFacing.EAST.func_176736_b();
               var7 = EnumFacing.WEST.func_176736_b();
               var8 = EnumFacing.SOUTH.func_176736_b();
               var9 = EnumFacing.NORTH.func_176736_b();
            }
         }

         this.func_175811_a(p_74875_1_, Blocks.field_150378_br.func_176203_a(var6).func_177226_a(BlockEndPortalFrame.field_176507_b, Boolean.valueOf(p_74875_2_.nextFloat() > 0.9F)), 4, 3, 8, p_74875_3_);
         this.func_175811_a(p_74875_1_, Blocks.field_150378_br.func_176203_a(var6).func_177226_a(BlockEndPortalFrame.field_176507_b, Boolean.valueOf(p_74875_2_.nextFloat() > 0.9F)), 5, 3, 8, p_74875_3_);
         this.func_175811_a(p_74875_1_, Blocks.field_150378_br.func_176203_a(var6).func_177226_a(BlockEndPortalFrame.field_176507_b, Boolean.valueOf(p_74875_2_.nextFloat() > 0.9F)), 6, 3, 8, p_74875_3_);
         this.func_175811_a(p_74875_1_, Blocks.field_150378_br.func_176203_a(var7).func_177226_a(BlockEndPortalFrame.field_176507_b, Boolean.valueOf(p_74875_2_.nextFloat() > 0.9F)), 4, 3, 12, p_74875_3_);
         this.func_175811_a(p_74875_1_, Blocks.field_150378_br.func_176203_a(var7).func_177226_a(BlockEndPortalFrame.field_176507_b, Boolean.valueOf(p_74875_2_.nextFloat() > 0.9F)), 5, 3, 12, p_74875_3_);
         this.func_175811_a(p_74875_1_, Blocks.field_150378_br.func_176203_a(var7).func_177226_a(BlockEndPortalFrame.field_176507_b, Boolean.valueOf(p_74875_2_.nextFloat() > 0.9F)), 6, 3, 12, p_74875_3_);
         this.func_175811_a(p_74875_1_, Blocks.field_150378_br.func_176203_a(var8).func_177226_a(BlockEndPortalFrame.field_176507_b, Boolean.valueOf(p_74875_2_.nextFloat() > 0.9F)), 3, 3, 9, p_74875_3_);
         this.func_175811_a(p_74875_1_, Blocks.field_150378_br.func_176203_a(var8).func_177226_a(BlockEndPortalFrame.field_176507_b, Boolean.valueOf(p_74875_2_.nextFloat() > 0.9F)), 3, 3, 10, p_74875_3_);
         this.func_175811_a(p_74875_1_, Blocks.field_150378_br.func_176203_a(var8).func_177226_a(BlockEndPortalFrame.field_176507_b, Boolean.valueOf(p_74875_2_.nextFloat() > 0.9F)), 3, 3, 11, p_74875_3_);
         this.func_175811_a(p_74875_1_, Blocks.field_150378_br.func_176203_a(var9).func_177226_a(BlockEndPortalFrame.field_176507_b, Boolean.valueOf(p_74875_2_.nextFloat() > 0.9F)), 7, 3, 9, p_74875_3_);
         this.func_175811_a(p_74875_1_, Blocks.field_150378_br.func_176203_a(var9).func_177226_a(BlockEndPortalFrame.field_176507_b, Boolean.valueOf(p_74875_2_.nextFloat() > 0.9F)), 7, 3, 10, p_74875_3_);
         this.func_175811_a(p_74875_1_, Blocks.field_150378_br.func_176203_a(var9).func_177226_a(BlockEndPortalFrame.field_176507_b, Boolean.valueOf(p_74875_2_.nextFloat() > 0.9F)), 7, 3, 11, p_74875_3_);
         if(!this.field_75005_a) {
            int var12 = this.func_74862_a(3);
            BlockPos var10 = new BlockPos(this.func_74865_a(5, 6), var12, this.func_74873_b(5, 6));
            if(p_74875_3_.func_175898_b(var10)) {
               this.field_75005_a = true;
               p_74875_1_.func_180501_a(var10, Blocks.field_150474_ac.func_176223_P(), 2);
               TileEntity var11 = p_74875_1_.func_175625_s(var10);
               if(var11 instanceof TileEntityMobSpawner) {
                  ((TileEntityMobSpawner)var11).func_145881_a().func_98272_a("Silverfish");
               }
            }
         }

         return true;
      }
   }

   public static class Prison extends StructureStrongholdPieces.Stronghold {

      private static final String __OBFID = "CL_00000494";


      public Prison() {}

      public Prison(int p_i45576_1_, Random p_i45576_2_, StructureBoundingBox p_i45576_3_, EnumFacing p_i45576_4_) {
         super(p_i45576_1_);
         this.field_74885_f = p_i45576_4_;
         this.field_143013_d = this.func_74988_a(p_i45576_2_);
         this.field_74887_e = p_i45576_3_;
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         this.func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
      }

      public static StructureStrongholdPieces.Prison func_175860_a(List p_175860_0_, Random p_175860_1_, int p_175860_2_, int p_175860_3_, int p_175860_4_, EnumFacing p_175860_5_, int p_175860_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175860_2_, p_175860_3_, p_175860_4_, -1, -1, 0, 9, 5, 11, p_175860_5_);
         return func_74991_a(var7) && StructureComponent.func_74883_a(p_175860_0_, var7) == null?new StructureStrongholdPieces.Prison(p_175860_6_, p_175860_1_, var7, p_175860_5_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 8, 4, 10, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);
            this.func_175804_a(p_74875_1_, p_74875_3_, 1, 1, 10, 3, 3, 10, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            this.func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 1, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 3, 4, 3, 3, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 7, 4, 3, 7, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 9, 4, 3, 9, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_175804_a(p_74875_1_, p_74875_3_, 4, 1, 4, 4, 3, 6, Blocks.field_150411_aY.func_176223_P(), Blocks.field_150411_aY.func_176223_P(), false);
            this.func_175804_a(p_74875_1_, p_74875_3_, 5, 1, 5, 7, 3, 5, Blocks.field_150411_aY.func_176223_P(), Blocks.field_150411_aY.func_176223_P(), false);
            this.func_175811_a(p_74875_1_, Blocks.field_150411_aY.func_176223_P(), 4, 3, 2, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150411_aY.func_176223_P(), 4, 3, 8, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150454_av.func_176203_a(this.func_151555_a(Blocks.field_150454_av, 3)), 4, 1, 2, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150454_av.func_176203_a(this.func_151555_a(Blocks.field_150454_av, 3) + 8), 4, 2, 2, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150454_av.func_176203_a(this.func_151555_a(Blocks.field_150454_av, 3)), 4, 1, 8, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150454_av.func_176203_a(this.func_151555_a(Blocks.field_150454_av, 3) + 8), 4, 2, 8, p_74875_3_);
            return true;
         }
      }
   }

   public static class RightTurn extends StructureStrongholdPieces.LeftTurn {

      private static final String __OBFID = "CL_00000495";


      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         if(this.field_74885_f != EnumFacing.NORTH && this.field_74885_f != EnumFacing.EAST) {
            this.func_74989_b((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
         } else {
            this.func_74987_c((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
         }

      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 4, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);
            if(this.field_74885_f != EnumFacing.NORTH && this.field_74885_f != EnumFacing.EAST) {
               this.func_175804_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 3, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            } else {
               this.func_175804_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 3, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            }

            return true;
         }
      }
   }

   public static class RoomCrossing extends StructureStrongholdPieces.Stronghold {

      private static final List field_75014_c = Lists.newArrayList(new WeightedRandomChestContent[]{new WeightedRandomChestContent(Items.field_151042_j, 0, 1, 5, 10), new WeightedRandomChestContent(Items.field_151043_k, 0, 1, 3, 5), new WeightedRandomChestContent(Items.field_151137_ax, 0, 4, 9, 5), new WeightedRandomChestContent(Items.field_151044_h, 0, 3, 8, 10), new WeightedRandomChestContent(Items.field_151025_P, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151034_e, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151035_b, 0, 1, 1, 1)});
      protected int field_75013_b;
      private static final String __OBFID = "CL_00000496";


      public RoomCrossing() {}

      public RoomCrossing(int p_i45575_1_, Random p_i45575_2_, StructureBoundingBox p_i45575_3_, EnumFacing p_i45575_4_) {
         super(p_i45575_1_);
         this.field_74885_f = p_i45575_4_;
         this.field_143013_d = this.func_74988_a(p_i45575_2_);
         this.field_74887_e = p_i45575_3_;
         this.field_75013_b = p_i45575_2_.nextInt(5);
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74768_a("Type", this.field_75013_b);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_75013_b = p_143011_1_.func_74762_e("Type");
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         this.func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 4, 1);
         this.func_74989_b((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 4);
         this.func_74987_c((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 4);
      }

      public static StructureStrongholdPieces.RoomCrossing func_175859_a(List p_175859_0_, Random p_175859_1_, int p_175859_2_, int p_175859_3_, int p_175859_4_, EnumFacing p_175859_5_, int p_175859_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175859_2_, p_175859_3_, p_175859_4_, -4, -1, 0, 11, 7, 11, p_175859_5_);
         return func_74991_a(var7) && StructureComponent.func_74883_a(p_175859_0_, var7) == null?new StructureStrongholdPieces.RoomCrossing(p_175859_6_, p_175859_1_, var7, p_175859_5_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 10, 6, 10, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 4, 1, 0);
            this.func_175804_a(p_74875_1_, p_74875_3_, 4, 1, 10, 6, 3, 10, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            this.func_175804_a(p_74875_1_, p_74875_3_, 0, 1, 4, 0, 3, 6, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            this.func_175804_a(p_74875_1_, p_74875_3_, 10, 1, 4, 10, 3, 6, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            int var4;
            switch(this.field_75013_b) {
            case 0:
               this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 5, 1, 5, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 5, 2, 5, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 5, 3, 5, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150478_aa.func_176223_P(), 4, 3, 5, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150478_aa.func_176223_P(), 6, 3, 5, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150478_aa.func_176223_P(), 5, 3, 4, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150478_aa.func_176223_P(), 5, 3, 6, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150333_U.func_176223_P(), 4, 1, 4, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150333_U.func_176223_P(), 4, 1, 5, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150333_U.func_176223_P(), 4, 1, 6, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150333_U.func_176223_P(), 6, 1, 4, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150333_U.func_176223_P(), 6, 1, 5, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150333_U.func_176223_P(), 6, 1, 6, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150333_U.func_176223_P(), 5, 1, 4, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150333_U.func_176223_P(), 5, 1, 6, p_74875_3_);
               break;
            case 1:
               for(var4 = 0; var4 < 5; ++var4) {
                  this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 3, 1, 3 + var4, p_74875_3_);
                  this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 7, 1, 3 + var4, p_74875_3_);
                  this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 3 + var4, 1, 3, p_74875_3_);
                  this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 3 + var4, 1, 7, p_74875_3_);
               }

               this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 5, 1, 5, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 5, 2, 5, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 5, 3, 5, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150358_i.func_176223_P(), 5, 4, 5, p_74875_3_);
               break;
            case 2:
               for(var4 = 1; var4 <= 9; ++var4) {
                  this.func_175811_a(p_74875_1_, Blocks.field_150347_e.func_176223_P(), 1, 3, var4, p_74875_3_);
                  this.func_175811_a(p_74875_1_, Blocks.field_150347_e.func_176223_P(), 9, 3, var4, p_74875_3_);
               }

               for(var4 = 1; var4 <= 9; ++var4) {
                  this.func_175811_a(p_74875_1_, Blocks.field_150347_e.func_176223_P(), var4, 3, 1, p_74875_3_);
                  this.func_175811_a(p_74875_1_, Blocks.field_150347_e.func_176223_P(), var4, 3, 9, p_74875_3_);
               }

               this.func_175811_a(p_74875_1_, Blocks.field_150347_e.func_176223_P(), 5, 1, 4, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150347_e.func_176223_P(), 5, 1, 6, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150347_e.func_176223_P(), 5, 3, 4, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150347_e.func_176223_P(), 5, 3, 6, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150347_e.func_176223_P(), 4, 1, 5, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150347_e.func_176223_P(), 6, 1, 5, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150347_e.func_176223_P(), 4, 3, 5, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150347_e.func_176223_P(), 6, 3, 5, p_74875_3_);

               for(var4 = 1; var4 <= 3; ++var4) {
                  this.func_175811_a(p_74875_1_, Blocks.field_150347_e.func_176223_P(), 4, var4, 4, p_74875_3_);
                  this.func_175811_a(p_74875_1_, Blocks.field_150347_e.func_176223_P(), 6, var4, 4, p_74875_3_);
                  this.func_175811_a(p_74875_1_, Blocks.field_150347_e.func_176223_P(), 4, var4, 6, p_74875_3_);
                  this.func_175811_a(p_74875_1_, Blocks.field_150347_e.func_176223_P(), 6, var4, 6, p_74875_3_);
               }

               this.func_175811_a(p_74875_1_, Blocks.field_150478_aa.func_176223_P(), 5, 3, 5, p_74875_3_);

               for(var4 = 2; var4 <= 8; ++var4) {
                  this.func_175811_a(p_74875_1_, Blocks.field_150344_f.func_176223_P(), 2, 3, var4, p_74875_3_);
                  this.func_175811_a(p_74875_1_, Blocks.field_150344_f.func_176223_P(), 3, 3, var4, p_74875_3_);
                  if(var4 <= 3 || var4 >= 7) {
                     this.func_175811_a(p_74875_1_, Blocks.field_150344_f.func_176223_P(), 4, 3, var4, p_74875_3_);
                     this.func_175811_a(p_74875_1_, Blocks.field_150344_f.func_176223_P(), 5, 3, var4, p_74875_3_);
                     this.func_175811_a(p_74875_1_, Blocks.field_150344_f.func_176223_P(), 6, 3, var4, p_74875_3_);
                  }

                  this.func_175811_a(p_74875_1_, Blocks.field_150344_f.func_176223_P(), 7, 3, var4, p_74875_3_);
                  this.func_175811_a(p_74875_1_, Blocks.field_150344_f.func_176223_P(), 8, 3, var4, p_74875_3_);
               }

               this.func_175811_a(p_74875_1_, Blocks.field_150468_ap.func_176203_a(this.func_151555_a(Blocks.field_150468_ap, EnumFacing.WEST.func_176745_a())), 9, 1, 3, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150468_ap.func_176203_a(this.func_151555_a(Blocks.field_150468_ap, EnumFacing.WEST.func_176745_a())), 9, 2, 3, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150468_ap.func_176203_a(this.func_151555_a(Blocks.field_150468_ap, EnumFacing.WEST.func_176745_a())), 9, 3, 3, p_74875_3_);
               this.func_180778_a(p_74875_1_, p_74875_3_, p_74875_2_, 3, 4, 8, WeightedRandomChestContent.func_177629_a(field_75014_c, new WeightedRandomChestContent[]{Items.field_151134_bR.func_92114_b(p_74875_2_)}), 1 + p_74875_2_.nextInt(4));
            }

            return true;
         }
      }

   }

   public static class Stairs extends StructureStrongholdPieces.Stronghold {

      private boolean field_75024_a;
      private static final String __OBFID = "CL_00000498";


      public Stairs() {}

      public Stairs(int p_i2081_1_, Random p_i2081_2_, int p_i2081_3_, int p_i2081_4_) {
         super(p_i2081_1_);
         this.field_75024_a = true;
         this.field_74885_f = EnumFacing.Plane.HORIZONTAL.func_179518_a(p_i2081_2_);
         this.field_143013_d = StructureStrongholdPieces.Stronghold.Door.OPENING;
         switch(StructureStrongholdPieces.SwitchEnumFacing.field_175951_b[this.field_74885_f.ordinal()]) {
         case 1:
         case 2:
            this.field_74887_e = new StructureBoundingBox(p_i2081_3_, 64, p_i2081_4_, p_i2081_3_ + 5 - 1, 74, p_i2081_4_ + 5 - 1);
            break;
         default:
            this.field_74887_e = new StructureBoundingBox(p_i2081_3_, 64, p_i2081_4_, p_i2081_3_ + 5 - 1, 74, p_i2081_4_ + 5 - 1);
         }

      }

      public Stairs(int p_i45574_1_, Random p_i45574_2_, StructureBoundingBox p_i45574_3_, EnumFacing p_i45574_4_) {
         super(p_i45574_1_);
         this.field_75024_a = false;
         this.field_74885_f = p_i45574_4_;
         this.field_143013_d = this.func_74988_a(p_i45574_2_);
         this.field_74887_e = p_i45574_3_;
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74757_a("Source", this.field_75024_a);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_75024_a = p_143011_1_.func_74767_n("Source");
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         if(this.field_75024_a) {
            StructureStrongholdPieces.field_75203_d = StructureStrongholdPieces.Crossing.class;
         }

         this.func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
      }

      public static StructureStrongholdPieces.Stairs func_175863_a(List p_175863_0_, Random p_175863_1_, int p_175863_2_, int p_175863_3_, int p_175863_4_, EnumFacing p_175863_5_, int p_175863_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175863_2_, p_175863_3_, p_175863_4_, -1, -7, 0, 5, 11, 5, p_175863_5_);
         return func_74991_a(var7) && StructureComponent.func_74883_a(p_175863_0_, var7) == null?new StructureStrongholdPieces.Stairs(p_175863_6_, p_175863_1_, var7, p_175863_5_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 10, 4, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 7, 0);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, StructureStrongholdPieces.Stronghold.Door.OPENING, 1, 1, 4);
            this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 2, 6, 1, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 1, 5, 1, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150333_U.func_176203_a(BlockStoneSlab.EnumType.STONE.func_176624_a()), 1, 6, 1, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 1, 5, 2, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 1, 4, 3, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150333_U.func_176203_a(BlockStoneSlab.EnumType.STONE.func_176624_a()), 1, 5, 3, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 2, 4, 3, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 3, 3, 3, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150333_U.func_176203_a(BlockStoneSlab.EnumType.STONE.func_176624_a()), 3, 4, 3, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 3, 3, 2, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 3, 2, 1, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150333_U.func_176203_a(BlockStoneSlab.EnumType.STONE.func_176624_a()), 3, 3, 1, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 2, 2, 1, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 1, 1, 1, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150333_U.func_176203_a(BlockStoneSlab.EnumType.STONE.func_176624_a()), 1, 2, 1, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 1, 1, 2, p_74875_3_);
            this.func_175811_a(p_74875_1_, Blocks.field_150333_U.func_176203_a(BlockStoneSlab.EnumType.STONE.func_176624_a()), 1, 1, 3, p_74875_3_);
            return true;
         }
      }
   }

   public static class Stairs2 extends StructureStrongholdPieces.Stairs {

      public StructureStrongholdPieces.PieceWeight field_75027_a;
      public StructureStrongholdPieces.PortalRoom field_75025_b;
      public List field_75026_c = Lists.newArrayList();
      private static final String __OBFID = "CL_00000499";


      public Stairs2() {}

      public Stairs2(int p_i2083_1_, Random p_i2083_2_, int p_i2083_3_, int p_i2083_4_) {
         super(0, p_i2083_2_, p_i2083_3_, p_i2083_4_);
      }

      public BlockPos func_180776_a() {
         return this.field_75025_b != null?this.field_75025_b.func_180776_a():super.func_180776_a();
      }
   }

   public static class StairsStraight extends StructureStrongholdPieces.Stronghold {

      private static final String __OBFID = "CL_00000501";


      public StairsStraight() {}

      public StairsStraight(int p_i45572_1_, Random p_i45572_2_, StructureBoundingBox p_i45572_3_, EnumFacing p_i45572_4_) {
         super(p_i45572_1_);
         this.field_74885_f = p_i45572_4_;
         this.field_143013_d = this.func_74988_a(p_i45572_2_);
         this.field_74887_e = p_i45572_3_;
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         this.func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
      }

      public static StructureStrongholdPieces.StairsStraight func_175861_a(List p_175861_0_, Random p_175861_1_, int p_175861_2_, int p_175861_3_, int p_175861_4_, EnumFacing p_175861_5_, int p_175861_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175861_2_, p_175861_3_, p_175861_4_, -1, -7, 0, 5, 11, 8, p_175861_5_);
         return func_74991_a(var7) && StructureComponent.func_74883_a(p_175861_0_, var7) == null?new StructureStrongholdPieces.StairsStraight(p_175861_6_, p_175861_1_, var7, p_175861_5_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 10, 7, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 7, 0);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, StructureStrongholdPieces.Stronghold.Door.OPENING, 1, 1, 7);
            int var4 = this.func_151555_a(Blocks.field_150446_ar, 2);

            for(int var5 = 0; var5 < 6; ++var5) {
               this.func_175811_a(p_74875_1_, Blocks.field_150446_ar.func_176203_a(var4), 1, 6 - var5, 1 + var5, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150446_ar.func_176203_a(var4), 2, 6 - var5, 1 + var5, p_74875_3_);
               this.func_175811_a(p_74875_1_, Blocks.field_150446_ar.func_176203_a(var4), 3, 6 - var5, 1 + var5, p_74875_3_);
               if(var5 < 5) {
                  this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 1, 5 - var5, 1 + var5, p_74875_3_);
                  this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 2, 5 - var5, 1 + var5, p_74875_3_);
                  this.func_175811_a(p_74875_1_, Blocks.field_150417_aV.func_176223_P(), 3, 5 - var5, 1 + var5, p_74875_3_);
               }
            }

            return true;
         }
      }
   }

   static class Stones extends StructureComponent.BlockSelector {

      private static final String __OBFID = "CL_00000497";


      private Stones() {}

      public void func_75062_a(Random p_75062_1_, int p_75062_2_, int p_75062_3_, int p_75062_4_, boolean p_75062_5_) {
         if(p_75062_5_) {
            float var6 = p_75062_1_.nextFloat();
            if(var6 < 0.2F) {
               this.field_151562_a = Blocks.field_150417_aV.func_176203_a(BlockStoneBrick.field_176251_N);
            } else if(var6 < 0.5F) {
               this.field_151562_a = Blocks.field_150417_aV.func_176203_a(BlockStoneBrick.field_176250_M);
            } else if(var6 < 0.55F) {
               this.field_151562_a = Blocks.field_150418_aU.func_176203_a(BlockSilverfish.EnumType.STONEBRICK.func_176881_a());
            } else {
               this.field_151562_a = Blocks.field_150417_aV.func_176223_P();
            }
         } else {
            this.field_151562_a = Blocks.field_150350_a.func_176223_P();
         }

      }

      // $FF: synthetic method
      Stones(Object p_i2080_1_) {
         this();
      }
   }

   public static class Straight extends StructureStrongholdPieces.Stronghold {

      private boolean field_75019_b;
      private boolean field_75020_c;
      private static final String __OBFID = "CL_00000500";


      public Straight() {}

      public Straight(int p_i45573_1_, Random p_i45573_2_, StructureBoundingBox p_i45573_3_, EnumFacing p_i45573_4_) {
         super(p_i45573_1_);
         this.field_74885_f = p_i45573_4_;
         this.field_143013_d = this.func_74988_a(p_i45573_2_);
         this.field_74887_e = p_i45573_3_;
         this.field_75019_b = p_i45573_2_.nextInt(2) == 0;
         this.field_75020_c = p_i45573_2_.nextInt(2) == 0;
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         super.func_143012_a(p_143012_1_);
         p_143012_1_.func_74757_a("Left", this.field_75019_b);
         p_143012_1_.func_74757_a("Right", this.field_75020_c);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         super.func_143011_b(p_143011_1_);
         this.field_75019_b = p_143011_1_.func_74767_n("Left");
         this.field_75020_c = p_143011_1_.func_74767_n("Right");
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         this.func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
         if(this.field_75019_b) {
            this.func_74989_b((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 2);
         }

         if(this.field_75020_c) {
            this.func_74987_c((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 2);
         }

      }

      public static StructureStrongholdPieces.Straight func_175862_a(List p_175862_0_, Random p_175862_1_, int p_175862_2_, int p_175862_3_, int p_175862_4_, EnumFacing p_175862_5_, int p_175862_6_) {
         StructureBoundingBox var7 = StructureBoundingBox.func_175897_a(p_175862_2_, p_175862_3_, p_175862_4_, -1, -1, 0, 5, 5, 7, p_175862_5_);
         return func_74991_a(var7) && StructureComponent.func_74883_a(p_175862_0_, var7) == null?new StructureStrongholdPieces.Straight(p_175862_6_, p_175862_1_, var7, p_175862_5_):null;
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 6, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, StructureStrongholdPieces.Stronghold.Door.OPENING, 1, 1, 6);
            this.func_175809_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 1, 2, 1, Blocks.field_150478_aa.func_176223_P());
            this.func_175809_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 3, 2, 1, Blocks.field_150478_aa.func_176223_P());
            this.func_175809_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 1, 2, 5, Blocks.field_150478_aa.func_176223_P());
            this.func_175809_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 3, 2, 5, Blocks.field_150478_aa.func_176223_P());
            if(this.field_75019_b) {
               this.func_175804_a(p_74875_1_, p_74875_3_, 0, 1, 2, 0, 3, 4, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            }

            if(this.field_75020_c) {
               this.func_175804_a(p_74875_1_, p_74875_3_, 4, 1, 2, 4, 3, 4, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            }

            return true;
         }
      }
   }

   abstract static class Stronghold extends StructureComponent {

      protected StructureStrongholdPieces.Stronghold.Door field_143013_d;
      private static final String __OBFID = "CL_00000503";


      public Stronghold() {
         this.field_143013_d = StructureStrongholdPieces.Stronghold.Door.OPENING;
      }

      protected Stronghold(int p_i2087_1_) {
         super(p_i2087_1_);
         this.field_143013_d = StructureStrongholdPieces.Stronghold.Door.OPENING;
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         p_143012_1_.func_74778_a("EntryDoor", this.field_143013_d.name());
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         this.field_143013_d = StructureStrongholdPieces.Stronghold.Door.valueOf(p_143011_1_.func_74779_i("EntryDoor"));
      }

      protected void func_74990_a(World p_74990_1_, Random p_74990_2_, StructureBoundingBox p_74990_3_, StructureStrongholdPieces.Stronghold.Door p_74990_4_, int p_74990_5_, int p_74990_6_, int p_74990_7_) {
         switch(StructureStrongholdPieces.SwitchEnumFacing.field_75245_a[p_74990_4_.ordinal()]) {
         case 1:
         default:
            this.func_175804_a(p_74990_1_, p_74990_3_, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_5_ + 3 - 1, p_74990_6_ + 3 - 1, p_74990_7_, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            break;
         case 2:
            this.func_175811_a(p_74990_1_, Blocks.field_150417_aV.func_176223_P(), p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150417_aV.func_176223_P(), p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150417_aV.func_176223_P(), p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150417_aV.func_176223_P(), p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150417_aV.func_176223_P(), p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150417_aV.func_176223_P(), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150417_aV.func_176223_P(), p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_180413_ao.func_176223_P(), p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_180413_ao.func_176203_a(8), p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            break;
         case 3:
            this.func_175811_a(p_74990_1_, Blocks.field_150350_a.func_176223_P(), p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150350_a.func_176223_P(), p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150411_aY.func_176223_P(), p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150411_aY.func_176223_P(), p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150411_aY.func_176223_P(), p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150411_aY.func_176223_P(), p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150411_aY.func_176223_P(), p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150411_aY.func_176223_P(), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150411_aY.func_176223_P(), p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
            break;
         case 4:
            this.func_175811_a(p_74990_1_, Blocks.field_150417_aV.func_176223_P(), p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150417_aV.func_176223_P(), p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150417_aV.func_176223_P(), p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150417_aV.func_176223_P(), p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150417_aV.func_176223_P(), p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150417_aV.func_176223_P(), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150417_aV.func_176223_P(), p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150454_av.func_176223_P(), p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150454_av.func_176203_a(8), p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150430_aB.func_176203_a(this.func_151555_a(Blocks.field_150430_aB, 4)), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_ + 1, p_74990_3_);
            this.func_175811_a(p_74990_1_, Blocks.field_150430_aB.func_176203_a(this.func_151555_a(Blocks.field_150430_aB, 3)), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_ - 1, p_74990_3_);
         }

      }

      protected StructureStrongholdPieces.Stronghold.Door func_74988_a(Random p_74988_1_) {
         int var2 = p_74988_1_.nextInt(5);
         switch(var2) {
         case 0:
         case 1:
         default:
            return StructureStrongholdPieces.Stronghold.Door.OPENING;
         case 2:
            return StructureStrongholdPieces.Stronghold.Door.WOOD_DOOR;
         case 3:
            return StructureStrongholdPieces.Stronghold.Door.GRATES;
         case 4:
            return StructureStrongholdPieces.Stronghold.Door.IRON_DOOR;
         }
      }

      protected StructureComponent func_74986_a(StructureStrongholdPieces.Stairs2 p_74986_1_, List p_74986_2_, Random p_74986_3_, int p_74986_4_, int p_74986_5_) {
         if(this.field_74885_f != null) {
            switch(StructureStrongholdPieces.SwitchEnumFacing.field_175951_b[this.field_74885_f.ordinal()]) {
            case 1:
               return StructureStrongholdPieces.func_175953_c(p_74986_1_, p_74986_2_, p_74986_3_, this.field_74887_e.field_78897_a + p_74986_4_, this.field_74887_e.field_78895_b + p_74986_5_, this.field_74887_e.field_78896_c - 1, this.field_74885_f, this.func_74877_c());
            case 2:
               return StructureStrongholdPieces.func_175953_c(p_74986_1_, p_74986_2_, p_74986_3_, this.field_74887_e.field_78897_a + p_74986_4_, this.field_74887_e.field_78895_b + p_74986_5_, this.field_74887_e.field_78892_f + 1, this.field_74885_f, this.func_74877_c());
            case 3:
               return StructureStrongholdPieces.func_175953_c(p_74986_1_, p_74986_2_, p_74986_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74986_5_, this.field_74887_e.field_78896_c + p_74986_4_, this.field_74885_f, this.func_74877_c());
            case 4:
               return StructureStrongholdPieces.func_175953_c(p_74986_1_, p_74986_2_, p_74986_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74986_5_, this.field_74887_e.field_78896_c + p_74986_4_, this.field_74885_f, this.func_74877_c());
            }
         }

         return null;
      }

      protected StructureComponent func_74989_b(StructureStrongholdPieces.Stairs2 p_74989_1_, List p_74989_2_, Random p_74989_3_, int p_74989_4_, int p_74989_5_) {
         if(this.field_74885_f != null) {
            switch(StructureStrongholdPieces.SwitchEnumFacing.field_175951_b[this.field_74885_f.ordinal()]) {
            case 1:
               return StructureStrongholdPieces.func_175953_c(p_74989_1_, p_74989_2_, p_74989_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74989_4_, this.field_74887_e.field_78896_c + p_74989_5_, EnumFacing.WEST, this.func_74877_c());
            case 2:
               return StructureStrongholdPieces.func_175953_c(p_74989_1_, p_74989_2_, p_74989_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74989_4_, this.field_74887_e.field_78896_c + p_74989_5_, EnumFacing.WEST, this.func_74877_c());
            case 3:
               return StructureStrongholdPieces.func_175953_c(p_74989_1_, p_74989_2_, p_74989_3_, this.field_74887_e.field_78897_a + p_74989_5_, this.field_74887_e.field_78895_b + p_74989_4_, this.field_74887_e.field_78896_c - 1, EnumFacing.NORTH, this.func_74877_c());
            case 4:
               return StructureStrongholdPieces.func_175953_c(p_74989_1_, p_74989_2_, p_74989_3_, this.field_74887_e.field_78897_a + p_74989_5_, this.field_74887_e.field_78895_b + p_74989_4_, this.field_74887_e.field_78896_c - 1, EnumFacing.NORTH, this.func_74877_c());
            }
         }

         return null;
      }

      protected StructureComponent func_74987_c(StructureStrongholdPieces.Stairs2 p_74987_1_, List p_74987_2_, Random p_74987_3_, int p_74987_4_, int p_74987_5_) {
         if(this.field_74885_f != null) {
            switch(StructureStrongholdPieces.SwitchEnumFacing.field_175951_b[this.field_74885_f.ordinal()]) {
            case 1:
               return StructureStrongholdPieces.func_175953_c(p_74987_1_, p_74987_2_, p_74987_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74987_4_, this.field_74887_e.field_78896_c + p_74987_5_, EnumFacing.EAST, this.func_74877_c());
            case 2:
               return StructureStrongholdPieces.func_175953_c(p_74987_1_, p_74987_2_, p_74987_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74987_4_, this.field_74887_e.field_78896_c + p_74987_5_, EnumFacing.EAST, this.func_74877_c());
            case 3:
               return StructureStrongholdPieces.func_175953_c(p_74987_1_, p_74987_2_, p_74987_3_, this.field_74887_e.field_78897_a + p_74987_5_, this.field_74887_e.field_78895_b + p_74987_4_, this.field_74887_e.field_78892_f + 1, EnumFacing.SOUTH, this.func_74877_c());
            case 4:
               return StructureStrongholdPieces.func_175953_c(p_74987_1_, p_74987_2_, p_74987_3_, this.field_74887_e.field_78897_a + p_74987_5_, this.field_74887_e.field_78895_b + p_74987_4_, this.field_74887_e.field_78892_f + 1, EnumFacing.SOUTH, this.func_74877_c());
            }
         }

         return null;
      }

      protected static boolean func_74991_a(StructureBoundingBox p_74991_0_) {
         return p_74991_0_ != null && p_74991_0_.field_78895_b > 10;
      }

      public static enum Door {

         OPENING("OPENING", 0),
         WOOD_DOOR("WOOD_DOOR", 1),
         GRATES("GRATES", 2),
         IRON_DOOR("IRON_DOOR", 3);
         // $FF: synthetic field
         private static final StructureStrongholdPieces.Stronghold.Door[] $VALUES = new StructureStrongholdPieces.Stronghold.Door[]{OPENING, WOOD_DOOR, GRATES, IRON_DOOR};
         private static final String __OBFID = "CL_00000504";


         private Door(String p_i2086_1_, int p_i2086_2_) {}

      }
   }

   // $FF: synthetic class
   static final class SwitchEnumFacing {

      // $FF: synthetic field
      static final int[] field_75245_a;
      // $FF: synthetic field
      static final int[] field_175951_b = new int[EnumFacing.values().length];
      private static final String __OBFID = "CL_00001970";


      static {
         try {
            field_175951_b[EnumFacing.NORTH.ordinal()] = 1;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            field_175951_b[EnumFacing.SOUTH.ordinal()] = 2;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            field_175951_b[EnumFacing.WEST.ordinal()] = 3;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            field_175951_b[EnumFacing.EAST.ordinal()] = 4;
         } catch (NoSuchFieldError var5) {
            ;
         }

         field_75245_a = new int[StructureStrongholdPieces.Stronghold.Door.values().length];

         try {
            field_75245_a[StructureStrongholdPieces.Stronghold.Door.OPENING.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_75245_a[StructureStrongholdPieces.Stronghold.Door.WOOD_DOOR.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_75245_a[StructureStrongholdPieces.Stronghold.Door.GRATES.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_75245_a[StructureStrongholdPieces.Stronghold.Door.IRON_DOOR.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
