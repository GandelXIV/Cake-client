package net.minecraft.world.gen.structure;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureMineshaftPieces {

   private static final List field_175893_a = Lists.newArrayList(new WeightedRandomChestContent[]{new WeightedRandomChestContent(Items.field_151042_j, 0, 1, 5, 10), new WeightedRandomChestContent(Items.field_151043_k, 0, 1, 3, 5), new WeightedRandomChestContent(Items.field_151137_ax, 0, 4, 9, 5), new WeightedRandomChestContent(Items.field_151100_aR, EnumDyeColor.BLUE.func_176767_b(), 4, 9, 5), new WeightedRandomChestContent(Items.field_151045_i, 0, 1, 2, 3), new WeightedRandomChestContent(Items.field_151044_h, 0, 3, 8, 10), new WeightedRandomChestContent(Items.field_151025_P, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151035_b, 0, 1, 1, 1), new WeightedRandomChestContent(Item.func_150898_a(Blocks.field_150448_aq), 0, 4, 8, 1), new WeightedRandomChestContent(Items.field_151081_bc, 0, 2, 4, 10), new WeightedRandomChestContent(Items.field_151080_bb, 0, 2, 4, 10), new WeightedRandomChestContent(Items.field_151141_av, 0, 1, 1, 3), new WeightedRandomChestContent(Items.field_151138_bX, 0, 1, 1, 1)});
   private static final String __OBFID = "CL_00000444";


   public static void func_143048_a() {
      MapGenStructureIO.func_143031_a(StructureMineshaftPieces.Corridor.class, "MSCorridor");
      MapGenStructureIO.func_143031_a(StructureMineshaftPieces.Cross.class, "MSCrossing");
      MapGenStructureIO.func_143031_a(StructureMineshaftPieces.Room.class, "MSRoom");
      MapGenStructureIO.func_143031_a(StructureMineshaftPieces.Stairs.class, "MSStairs");
   }

   private static StructureComponent func_175892_a(List p_175892_0_, Random p_175892_1_, int p_175892_2_, int p_175892_3_, int p_175892_4_, EnumFacing p_175892_5_, int p_175892_6_) {
      int var7 = p_175892_1_.nextInt(100);
      StructureBoundingBox var8;
      if(var7 >= 80) {
         var8 = StructureMineshaftPieces.Cross.func_175813_a(p_175892_0_, p_175892_1_, p_175892_2_, p_175892_3_, p_175892_4_, p_175892_5_);
         if(var8 != null) {
            return new StructureMineshaftPieces.Cross(p_175892_6_, p_175892_1_, var8, p_175892_5_);
         }
      } else if(var7 >= 70) {
         var8 = StructureMineshaftPieces.Stairs.func_175812_a(p_175892_0_, p_175892_1_, p_175892_2_, p_175892_3_, p_175892_4_, p_175892_5_);
         if(var8 != null) {
            return new StructureMineshaftPieces.Stairs(p_175892_6_, p_175892_1_, var8, p_175892_5_);
         }
      } else {
         var8 = StructureMineshaftPieces.Corridor.func_175814_a(p_175892_0_, p_175892_1_, p_175892_2_, p_175892_3_, p_175892_4_, p_175892_5_);
         if(var8 != null) {
            return new StructureMineshaftPieces.Corridor(p_175892_6_, p_175892_1_, var8, p_175892_5_);
         }
      }

      return null;
   }

   private static StructureComponent func_175890_b(StructureComponent p_175890_0_, List p_175890_1_, Random p_175890_2_, int p_175890_3_, int p_175890_4_, int p_175890_5_, EnumFacing p_175890_6_, int p_175890_7_) {
      if(p_175890_7_ > 8) {
         return null;
      } else if(Math.abs(p_175890_3_ - p_175890_0_.func_74874_b().field_78897_a) <= 80 && Math.abs(p_175890_5_ - p_175890_0_.func_74874_b().field_78896_c) <= 80) {
         StructureComponent var8 = func_175892_a(p_175890_1_, p_175890_2_, p_175890_3_, p_175890_4_, p_175890_5_, p_175890_6_, p_175890_7_ + 1);
         if(var8 != null) {
            p_175890_1_.add(var8);
            var8.func_74861_a(p_175890_0_, p_175890_1_, p_175890_2_);
         }

         return var8;
      } else {
         return null;
      }
   }


   public static class Corridor extends StructureComponent {

      private boolean field_74958_a;
      private boolean field_74956_b;
      private boolean field_74957_c;
      private int field_74955_d;
      private static final String __OBFID = "CL_00000445";


      public Corridor() {}

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         p_143012_1_.func_74757_a("hr", this.field_74958_a);
         p_143012_1_.func_74757_a("sc", this.field_74956_b);
         p_143012_1_.func_74757_a("hps", this.field_74957_c);
         p_143012_1_.func_74768_a("Num", this.field_74955_d);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         this.field_74958_a = p_143011_1_.func_74767_n("hr");
         this.field_74956_b = p_143011_1_.func_74767_n("sc");
         this.field_74957_c = p_143011_1_.func_74767_n("hps");
         this.field_74955_d = p_143011_1_.func_74762_e("Num");
      }

      public Corridor(int p_i45625_1_, Random p_i45625_2_, StructureBoundingBox p_i45625_3_, EnumFacing p_i45625_4_) {
         super(p_i45625_1_);
         this.field_74885_f = p_i45625_4_;
         this.field_74887_e = p_i45625_3_;
         this.field_74958_a = p_i45625_2_.nextInt(3) == 0;
         this.field_74956_b = !this.field_74958_a && p_i45625_2_.nextInt(23) == 0;
         if(this.field_74885_f != EnumFacing.NORTH && this.field_74885_f != EnumFacing.SOUTH) {
            this.field_74955_d = p_i45625_3_.func_78883_b() / 5;
         } else {
            this.field_74955_d = p_i45625_3_.func_78880_d() / 5;
         }

      }

      public static StructureBoundingBox func_175814_a(List p_175814_0_, Random p_175814_1_, int p_175814_2_, int p_175814_3_, int p_175814_4_, EnumFacing p_175814_5_) {
         StructureBoundingBox var6 = new StructureBoundingBox(p_175814_2_, p_175814_3_, p_175814_4_, p_175814_2_, p_175814_3_ + 2, p_175814_4_);

         int var7;
         for(var7 = p_175814_1_.nextInt(3) + 2; var7 > 0; --var7) {
            int var8 = var7 * 5;
            switch(StructureMineshaftPieces.SwitchEnumFacing.field_175894_a[p_175814_5_.ordinal()]) {
            case 1:
               var6.field_78893_d = p_175814_2_ + 2;
               var6.field_78896_c = p_175814_4_ - (var8 - 1);
               break;
            case 2:
               var6.field_78893_d = p_175814_2_ + 2;
               var6.field_78892_f = p_175814_4_ + (var8 - 1);
               break;
            case 3:
               var6.field_78897_a = p_175814_2_ - (var8 - 1);
               var6.field_78892_f = p_175814_4_ + 2;
               break;
            case 4:
               var6.field_78893_d = p_175814_2_ + (var8 - 1);
               var6.field_78892_f = p_175814_4_ + 2;
            }

            if(StructureComponent.func_74883_a(p_175814_0_, var6) == null) {
               break;
            }
         }

         return var7 > 0?var6:null;
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         int var4 = this.func_74877_c();
         int var5 = p_74861_3_.nextInt(4);
         if(this.field_74885_f != null) {
            switch(StructureMineshaftPieces.SwitchEnumFacing.field_175894_a[this.field_74885_f.ordinal()]) {
            case 1:
               if(var5 <= 1) {
                  StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c - 1, this.field_74885_f, var4);
               } else if(var5 == 2) {
                  StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c, EnumFacing.WEST, var4);
               } else {
                  StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c, EnumFacing.EAST, var4);
               }
               break;
            case 2:
               if(var5 <= 1) {
                  StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f + 1, this.field_74885_f, var4);
               } else if(var5 == 2) {
                  StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f - 3, EnumFacing.WEST, var4);
               } else {
                  StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f - 3, EnumFacing.EAST, var4);
               }
               break;
            case 3:
               if(var5 <= 1) {
                  StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c, this.field_74885_f, var4);
               } else if(var5 == 2) {
                  StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c - 1, EnumFacing.NORTH, var4);
               } else {
                  StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f + 1, EnumFacing.SOUTH, var4);
               }
               break;
            case 4:
               if(var5 <= 1) {
                  StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c, this.field_74885_f, var4);
               } else if(var5 == 2) {
                  StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d - 3, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c - 1, EnumFacing.NORTH, var4);
               } else {
                  StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d - 3, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f + 1, EnumFacing.SOUTH, var4);
               }
            }
         }

         if(var4 < 8) {
            int var6;
            int var7;
            if(this.field_74885_f != EnumFacing.NORTH && this.field_74885_f != EnumFacing.SOUTH) {
               for(var6 = this.field_74887_e.field_78897_a + 3; var6 + 3 <= this.field_74887_e.field_78893_d; var6 += 5) {
                  var7 = p_74861_3_.nextInt(5);
                  if(var7 == 0) {
                     StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, var6, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, EnumFacing.NORTH, var4 + 1);
                  } else if(var7 == 1) {
                     StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, var6, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, EnumFacing.SOUTH, var4 + 1);
                  }
               }
            } else {
               for(var6 = this.field_74887_e.field_78896_c + 3; var6 + 3 <= this.field_74887_e.field_78892_f; var6 += 5) {
                  var7 = p_74861_3_.nextInt(5);
                  if(var7 == 0) {
                     StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, var6, EnumFacing.WEST, var4 + 1);
                  } else if(var7 == 1) {
                     StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, var6, EnumFacing.EAST, var4 + 1);
                  }
               }
            }
         }

      }

      protected boolean func_180778_a(World p_180778_1_, StructureBoundingBox p_180778_2_, Random p_180778_3_, int p_180778_4_, int p_180778_5_, int p_180778_6_, List p_180778_7_, int p_180778_8_) {
         BlockPos var9 = new BlockPos(this.func_74865_a(p_180778_4_, p_180778_6_), this.func_74862_a(p_180778_5_), this.func_74873_b(p_180778_4_, p_180778_6_));
         if(p_180778_2_.func_175898_b(var9) && p_180778_1_.func_180495_p(var9).func_177230_c().func_149688_o() == Material.field_151579_a) {
            int var10 = p_180778_3_.nextBoolean()?1:0;
            p_180778_1_.func_180501_a(var9, Blocks.field_150448_aq.func_176203_a(this.func_151555_a(Blocks.field_150448_aq, var10)), 2);
            EntityMinecartChest var11 = new EntityMinecartChest(p_180778_1_, (double)((float)var9.func_177958_n() + 0.5F), (double)((float)var9.func_177956_o() + 0.5F), (double)((float)var9.func_177952_p() + 0.5F));
            WeightedRandomChestContent.func_177630_a(p_180778_3_, p_180778_7_, var11, p_180778_8_);
            p_180778_1_.func_72838_d(var11);
            return true;
         } else {
            return false;
         }
      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            boolean var4 = false;
            boolean var5 = true;
            boolean var6 = false;
            boolean var7 = true;
            int var8 = this.field_74955_d * 5 - 1;
            this.func_175804_a(p_74875_1_, p_74875_3_, 0, 0, 0, 2, 1, var8, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            this.func_175805_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.8F, 0, 2, 0, 2, 2, var8, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            if(this.field_74956_b) {
               this.func_175805_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.6F, 0, 0, 0, 2, 1, var8, Blocks.field_150321_G.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            }

            int var9;
            int var10;
            for(var9 = 0; var9 < this.field_74955_d; ++var9) {
               var10 = 2 + var9 * 5;
               this.func_175804_a(p_74875_1_, p_74875_3_, 0, 0, var10, 0, 1, var10, Blocks.field_180407_aO.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
               this.func_175804_a(p_74875_1_, p_74875_3_, 2, 0, var10, 2, 1, var10, Blocks.field_180407_aO.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
               if(p_74875_2_.nextInt(4) == 0) {
                  this.func_175804_a(p_74875_1_, p_74875_3_, 0, 2, var10, 0, 2, var10, Blocks.field_150344_f.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
                  this.func_175804_a(p_74875_1_, p_74875_3_, 2, 2, var10, 2, 2, var10, Blocks.field_150344_f.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
               } else {
                  this.func_175804_a(p_74875_1_, p_74875_3_, 0, 2, var10, 2, 2, var10, Blocks.field_150344_f.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
               }

               this.func_175809_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 0, 2, var10 - 1, Blocks.field_150321_G.func_176223_P());
               this.func_175809_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 2, 2, var10 - 1, Blocks.field_150321_G.func_176223_P());
               this.func_175809_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 0, 2, var10 + 1, Blocks.field_150321_G.func_176223_P());
               this.func_175809_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 2, 2, var10 + 1, Blocks.field_150321_G.func_176223_P());
               this.func_175809_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 0, 2, var10 - 2, Blocks.field_150321_G.func_176223_P());
               this.func_175809_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 2, 2, var10 - 2, Blocks.field_150321_G.func_176223_P());
               this.func_175809_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 0, 2, var10 + 2, Blocks.field_150321_G.func_176223_P());
               this.func_175809_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 2, 2, var10 + 2, Blocks.field_150321_G.func_176223_P());
               this.func_175809_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 1, 2, var10 - 1, Blocks.field_150478_aa.func_176203_a(EnumFacing.UP.func_176745_a()));
               this.func_175809_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 1, 2, var10 + 1, Blocks.field_150478_aa.func_176203_a(EnumFacing.UP.func_176745_a()));
               if(p_74875_2_.nextInt(100) == 0) {
                  this.func_180778_a(p_74875_1_, p_74875_3_, p_74875_2_, 2, 0, var10 - 1, WeightedRandomChestContent.func_177629_a(StructureMineshaftPieces.field_175893_a, new WeightedRandomChestContent[]{Items.field_151134_bR.func_92114_b(p_74875_2_)}), 3 + p_74875_2_.nextInt(4));
               }

               if(p_74875_2_.nextInt(100) == 0) {
                  this.func_180778_a(p_74875_1_, p_74875_3_, p_74875_2_, 0, 0, var10 + 1, WeightedRandomChestContent.func_177629_a(StructureMineshaftPieces.field_175893_a, new WeightedRandomChestContent[]{Items.field_151134_bR.func_92114_b(p_74875_2_)}), 3 + p_74875_2_.nextInt(4));
               }

               if(this.field_74956_b && !this.field_74957_c) {
                  int var11 = this.func_74862_a(0);
                  int var12 = var10 - 1 + p_74875_2_.nextInt(3);
                  int var13 = this.func_74865_a(1, var12);
                  var12 = this.func_74873_b(1, var12);
                  BlockPos var14 = new BlockPos(var13, var11, var12);
                  if(p_74875_3_.func_175898_b(var14)) {
                     this.field_74957_c = true;
                     p_74875_1_.func_180501_a(var14, Blocks.field_150474_ac.func_176223_P(), 2);
                     TileEntity var15 = p_74875_1_.func_175625_s(var14);
                     if(var15 instanceof TileEntityMobSpawner) {
                        ((TileEntityMobSpawner)var15).func_145881_a().func_98272_a("CaveSpider");
                     }
                  }
               }
            }

            for(var9 = 0; var9 <= 2; ++var9) {
               for(var10 = 0; var10 <= var8; ++var10) {
                  byte var17 = -1;
                  IBlockState var18 = this.func_175807_a(p_74875_1_, var9, var17, var10, p_74875_3_);
                  if(var18.func_177230_c().func_149688_o() == Material.field_151579_a) {
                     byte var19 = -1;
                     this.func_175811_a(p_74875_1_, Blocks.field_150344_f.func_176223_P(), var9, var19, var10, p_74875_3_);
                  }
               }
            }

            if(this.field_74958_a) {
               for(var9 = 0; var9 <= var8; ++var9) {
                  IBlockState var16 = this.func_175807_a(p_74875_1_, 1, -1, var9, p_74875_3_);
                  if(var16.func_177230_c().func_149688_o() != Material.field_151579_a && var16.func_177230_c().func_149730_j()) {
                     this.func_175809_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.7F, 1, 0, var9, Blocks.field_150448_aq.func_176203_a(this.func_151555_a(Blocks.field_150448_aq, 0)));
                  }
               }
            }

            return true;
         }
      }
   }

   public static class Cross extends StructureComponent {

      private EnumFacing field_74953_a;
      private boolean field_74952_b;
      private static final String __OBFID = "CL_00000446";


      public Cross() {}

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         p_143012_1_.func_74757_a("tf", this.field_74952_b);
         p_143012_1_.func_74768_a("D", this.field_74953_a.func_176736_b());
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         this.field_74952_b = p_143011_1_.func_74767_n("tf");
         this.field_74953_a = EnumFacing.func_176731_b(p_143011_1_.func_74762_e("D"));
      }

      public Cross(int p_i45624_1_, Random p_i45624_2_, StructureBoundingBox p_i45624_3_, EnumFacing p_i45624_4_) {
         super(p_i45624_1_);
         this.field_74953_a = p_i45624_4_;
         this.field_74887_e = p_i45624_3_;
         this.field_74952_b = p_i45624_3_.func_78882_c() > 3;
      }

      public static StructureBoundingBox func_175813_a(List p_175813_0_, Random p_175813_1_, int p_175813_2_, int p_175813_3_, int p_175813_4_, EnumFacing p_175813_5_) {
         StructureBoundingBox var6 = new StructureBoundingBox(p_175813_2_, p_175813_3_, p_175813_4_, p_175813_2_, p_175813_3_ + 2, p_175813_4_);
         if(p_175813_1_.nextInt(4) == 0) {
            var6.field_78894_e += 4;
         }

         switch(StructureMineshaftPieces.SwitchEnumFacing.field_175894_a[p_175813_5_.ordinal()]) {
         case 1:
            var6.field_78897_a = p_175813_2_ - 1;
            var6.field_78893_d = p_175813_2_ + 3;
            var6.field_78896_c = p_175813_4_ - 4;
            break;
         case 2:
            var6.field_78897_a = p_175813_2_ - 1;
            var6.field_78893_d = p_175813_2_ + 3;
            var6.field_78892_f = p_175813_4_ + 4;
            break;
         case 3:
            var6.field_78897_a = p_175813_2_ - 4;
            var6.field_78896_c = p_175813_4_ - 1;
            var6.field_78892_f = p_175813_4_ + 3;
            break;
         case 4:
            var6.field_78893_d = p_175813_2_ + 4;
            var6.field_78896_c = p_175813_4_ - 1;
            var6.field_78892_f = p_175813_4_ + 3;
         }

         return StructureComponent.func_74883_a(p_175813_0_, var6) != null?null:var6;
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         int var4 = this.func_74877_c();
         switch(StructureMineshaftPieces.SwitchEnumFacing.field_175894_a[this.field_74953_a.ordinal()]) {
         case 1:
            StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, EnumFacing.NORTH, var4);
            StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, EnumFacing.WEST, var4);
            StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, EnumFacing.EAST, var4);
            break;
         case 2:
            StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, EnumFacing.SOUTH, var4);
            StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, EnumFacing.WEST, var4);
            StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, EnumFacing.EAST, var4);
            break;
         case 3:
            StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, EnumFacing.NORTH, var4);
            StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, EnumFacing.SOUTH, var4);
            StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, EnumFacing.WEST, var4);
            break;
         case 4:
            StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, EnumFacing.NORTH, var4);
            StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, EnumFacing.SOUTH, var4);
            StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, EnumFacing.EAST, var4);
         }

         if(this.field_74952_b) {
            if(p_74861_3_.nextBoolean()) {
               StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b + 3 + 1, this.field_74887_e.field_78896_c - 1, EnumFacing.NORTH, var4);
            }

            if(p_74861_3_.nextBoolean()) {
               StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + 3 + 1, this.field_74887_e.field_78896_c + 1, EnumFacing.WEST, var4);
            }

            if(p_74861_3_.nextBoolean()) {
               StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + 3 + 1, this.field_74887_e.field_78896_c + 1, EnumFacing.EAST, var4);
            }

            if(p_74861_3_.nextBoolean()) {
               StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b + 3 + 1, this.field_74887_e.field_78892_f + 1, EnumFacing.SOUTH, var4);
            }
         }

      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            if(this.field_74952_b) {
               this.func_175804_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78895_b + 3 - 1, this.field_74887_e.field_78892_f, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
               this.func_175804_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d, this.field_74887_e.field_78895_b + 3 - 1, this.field_74887_e.field_78892_f - 1, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
               this.func_175804_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78894_e - 2, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
               this.func_175804_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78894_e - 2, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f - 1, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
               this.func_175804_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78892_f - 1, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            } else {
               this.func_175804_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
               this.func_175804_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f - 1, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            }

            this.func_175804_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78896_c + 1, Blocks.field_150344_f.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            this.func_175804_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f - 1, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f - 1, Blocks.field_150344_f.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            this.func_175804_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78896_c + 1, Blocks.field_150344_f.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            this.func_175804_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f - 1, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f - 1, Blocks.field_150344_f.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);

            for(int var4 = this.field_74887_e.field_78897_a; var4 <= this.field_74887_e.field_78893_d; ++var4) {
               for(int var5 = this.field_74887_e.field_78896_c; var5 <= this.field_74887_e.field_78892_f; ++var5) {
                  if(this.func_175807_a(p_74875_1_, var4, this.field_74887_e.field_78895_b - 1, var5, p_74875_3_).func_177230_c().func_149688_o() == Material.field_151579_a) {
                     this.func_175811_a(p_74875_1_, Blocks.field_150344_f.func_176223_P(), var4, this.field_74887_e.field_78895_b - 1, var5, p_74875_3_);
                  }
               }
            }

            return true;
         }
      }
   }

   public static class Room extends StructureComponent {

      private List field_74949_a = Lists.newLinkedList();
      private static final String __OBFID = "CL_00000447";


      public Room() {}

      public Room(int p_i2037_1_, Random p_i2037_2_, int p_i2037_3_, int p_i2037_4_) {
         super(p_i2037_1_);
         this.field_74887_e = new StructureBoundingBox(p_i2037_3_, 50, p_i2037_4_, p_i2037_3_ + 7 + p_i2037_2_.nextInt(6), 54 + p_i2037_2_.nextInt(6), p_i2037_4_ + 7 + p_i2037_2_.nextInt(6));
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         int var4 = this.func_74877_c();
         int var6 = this.field_74887_e.func_78882_c() - 3 - 1;
         if(var6 <= 0) {
            var6 = 1;
         }

         int var5;
         StructureComponent var7;
         StructureBoundingBox var8;
         for(var5 = 0; var5 < this.field_74887_e.func_78883_b(); var5 += 4) {
            var5 += p_74861_3_.nextInt(this.field_74887_e.func_78883_b());
            if(var5 + 3 > this.field_74887_e.func_78883_b()) {
               break;
            }

            var7 = StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + var5, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(var6) + 1, this.field_74887_e.field_78896_c - 1, EnumFacing.NORTH, var4);
            if(var7 != null) {
               var8 = var7.func_74874_b();
               this.field_74949_a.add(new StructureBoundingBox(var8.field_78897_a, var8.field_78895_b, this.field_74887_e.field_78896_c, var8.field_78893_d, var8.field_78894_e, this.field_74887_e.field_78896_c + 1));
            }
         }

         for(var5 = 0; var5 < this.field_74887_e.func_78883_b(); var5 += 4) {
            var5 += p_74861_3_.nextInt(this.field_74887_e.func_78883_b());
            if(var5 + 3 > this.field_74887_e.func_78883_b()) {
               break;
            }

            var7 = StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + var5, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(var6) + 1, this.field_74887_e.field_78892_f + 1, EnumFacing.SOUTH, var4);
            if(var7 != null) {
               var8 = var7.func_74874_b();
               this.field_74949_a.add(new StructureBoundingBox(var8.field_78897_a, var8.field_78895_b, this.field_74887_e.field_78892_f - 1, var8.field_78893_d, var8.field_78894_e, this.field_74887_e.field_78892_f));
            }
         }

         for(var5 = 0; var5 < this.field_74887_e.func_78880_d(); var5 += 4) {
            var5 += p_74861_3_.nextInt(this.field_74887_e.func_78880_d());
            if(var5 + 3 > this.field_74887_e.func_78880_d()) {
               break;
            }

            var7 = StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(var6) + 1, this.field_74887_e.field_78896_c + var5, EnumFacing.WEST, var4);
            if(var7 != null) {
               var8 = var7.func_74874_b();
               this.field_74949_a.add(new StructureBoundingBox(this.field_74887_e.field_78897_a, var8.field_78895_b, var8.field_78896_c, this.field_74887_e.field_78897_a + 1, var8.field_78894_e, var8.field_78892_f));
            }
         }

         for(var5 = 0; var5 < this.field_74887_e.func_78880_d(); var5 += 4) {
            var5 += p_74861_3_.nextInt(this.field_74887_e.func_78880_d());
            if(var5 + 3 > this.field_74887_e.func_78880_d()) {
               break;
            }

            var7 = StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(var6) + 1, this.field_74887_e.field_78896_c + var5, EnumFacing.EAST, var4);
            if(var7 != null) {
               var8 = var7.func_74874_b();
               this.field_74949_a.add(new StructureBoundingBox(this.field_74887_e.field_78893_d - 1, var8.field_78895_b, var8.field_78896_c, this.field_74887_e.field_78893_d, var8.field_78894_e, var8.field_78892_f));
            }
         }

      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_175804_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f, Blocks.field_150346_d.func_176223_P(), Blocks.field_150350_a.func_176223_P(), true);
            this.func_175804_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b + 1, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d, Math.min(this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78894_e), this.field_74887_e.field_78892_f, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            Iterator var4 = this.field_74949_a.iterator();

            while(var4.hasNext()) {
               StructureBoundingBox var5 = (StructureBoundingBox)var4.next();
               this.func_175804_a(p_74875_1_, p_74875_3_, var5.field_78897_a, var5.field_78894_e - 2, var5.field_78896_c, var5.field_78893_d, var5.field_78894_e, var5.field_78892_f, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            }

            this.func_180777_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b + 4, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f, Blocks.field_150350_a.func_176223_P(), false);
            return true;
         }
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {
         NBTTagList var2 = new NBTTagList();
         Iterator var3 = this.field_74949_a.iterator();

         while(var3.hasNext()) {
            StructureBoundingBox var4 = (StructureBoundingBox)var3.next();
            var2.func_74742_a(var4.func_151535_h());
         }

         p_143012_1_.func_74782_a("Entrances", var2);
      }

      protected void func_143011_b(NBTTagCompound p_143011_1_) {
         NBTTagList var2 = p_143011_1_.func_150295_c("Entrances", 11);

         for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
            this.field_74949_a.add(new StructureBoundingBox(var2.func_150306_c(var3)));
         }

      }
   }

   public static class Stairs extends StructureComponent {

      private static final String __OBFID = "CL_00000449";


      public Stairs() {}

      public Stairs(int p_i45623_1_, Random p_i45623_2_, StructureBoundingBox p_i45623_3_, EnumFacing p_i45623_4_) {
         super(p_i45623_1_);
         this.field_74885_f = p_i45623_4_;
         this.field_74887_e = p_i45623_3_;
      }

      protected void func_143012_a(NBTTagCompound p_143012_1_) {}

      protected void func_143011_b(NBTTagCompound p_143011_1_) {}

      public static StructureBoundingBox func_175812_a(List p_175812_0_, Random p_175812_1_, int p_175812_2_, int p_175812_3_, int p_175812_4_, EnumFacing p_175812_5_) {
         StructureBoundingBox var6 = new StructureBoundingBox(p_175812_2_, p_175812_3_ - 5, p_175812_4_, p_175812_2_, p_175812_3_ + 2, p_175812_4_);
         switch(StructureMineshaftPieces.SwitchEnumFacing.field_175894_a[p_175812_5_.ordinal()]) {
         case 1:
            var6.field_78893_d = p_175812_2_ + 2;
            var6.field_78896_c = p_175812_4_ - 8;
            break;
         case 2:
            var6.field_78893_d = p_175812_2_ + 2;
            var6.field_78892_f = p_175812_4_ + 8;
            break;
         case 3:
            var6.field_78897_a = p_175812_2_ - 8;
            var6.field_78892_f = p_175812_4_ + 2;
            break;
         case 4:
            var6.field_78893_d = p_175812_2_ + 8;
            var6.field_78892_f = p_175812_4_ + 2;
         }

         return StructureComponent.func_74883_a(p_175812_0_, var6) != null?null:var6;
      }

      public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
         int var4 = this.func_74877_c();
         if(this.field_74885_f != null) {
            switch(StructureMineshaftPieces.SwitchEnumFacing.field_175894_a[this.field_74885_f.ordinal()]) {
            case 1:
               StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, EnumFacing.NORTH, var4);
               break;
            case 2:
               StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, EnumFacing.SOUTH, var4);
               break;
            case 3:
               StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, EnumFacing.WEST, var4);
               break;
            case 4:
               StructureMineshaftPieces.func_175890_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, EnumFacing.EAST, var4);
            }
         }

      }

      public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
         if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
            return false;
         } else {
            this.func_175804_a(p_74875_1_, p_74875_3_, 0, 5, 0, 2, 7, 1, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            this.func_175804_a(p_74875_1_, p_74875_3_, 0, 0, 7, 2, 2, 8, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);

            for(int var4 = 0; var4 < 5; ++var4) {
               this.func_175804_a(p_74875_1_, p_74875_3_, 0, 5 - var4 - (var4 < 4?1:0), 2 + var4, 2, 7 - var4, 2 + var4, Blocks.field_150350_a.func_176223_P(), Blocks.field_150350_a.func_176223_P(), false);
            }

            return true;
         }
      }
   }

   // $FF: synthetic class
   static final class SwitchEnumFacing {

      // $FF: synthetic field
      static final int[] field_175894_a = new int[EnumFacing.values().length];
      private static final String __OBFID = "CL_00001998";


      static {
         try {
            field_175894_a[EnumFacing.NORTH.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_175894_a[EnumFacing.SOUTH.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_175894_a[EnumFacing.WEST.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_175894_a[EnumFacing.EAST.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
