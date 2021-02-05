package net.minecraft.world.chunk.storage;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.chunk.NibbleArray;

public class ExtendedBlockStorage {

   private int field_76684_a;
   private int field_76682_b;
   private int field_76683_c;
   private char[] field_177488_d;
   private NibbleArray field_76679_g;
   private NibbleArray field_76685_h;
   private static final String __OBFID = "CL_00000375";


   public ExtendedBlockStorage(int p_i1997_1_, boolean p_i1997_2_) {
      this.field_76684_a = p_i1997_1_;
      this.field_177488_d = new char[4096];
      this.field_76679_g = new NibbleArray();
      if(p_i1997_2_) {
         this.field_76685_h = new NibbleArray();
      }

   }

   public IBlockState func_177485_a(int p_177485_1_, int p_177485_2_, int p_177485_3_) {
      IBlockState var4 = (IBlockState)Block.field_176229_d.func_148745_a(this.field_177488_d[p_177485_2_ << 8 | p_177485_3_ << 4 | p_177485_1_]);
      return var4 != null?var4:Blocks.field_150350_a.func_176223_P();
   }

   public void func_177484_a(int p_177484_1_, int p_177484_2_, int p_177484_3_, IBlockState p_177484_4_) {
      IBlockState var5 = this.func_177485_a(p_177484_1_, p_177484_2_, p_177484_3_);
      Block var6 = var5.func_177230_c();
      Block var7 = p_177484_4_.func_177230_c();
      if(var6 != Blocks.field_150350_a) {
         --this.field_76682_b;
         if(var6.func_149653_t()) {
            --this.field_76683_c;
         }
      }

      if(var7 != Blocks.field_150350_a) {
         ++this.field_76682_b;
         if(var7.func_149653_t()) {
            ++this.field_76683_c;
         }
      }

      this.field_177488_d[p_177484_2_ << 8 | p_177484_3_ << 4 | p_177484_1_] = (char)Block.field_176229_d.func_148747_b(p_177484_4_);
   }

   public Block func_150819_a(int p_150819_1_, int p_150819_2_, int p_150819_3_) {
      return this.func_177485_a(p_150819_1_, p_150819_2_, p_150819_3_).func_177230_c();
   }

   public int func_76665_b(int p_76665_1_, int p_76665_2_, int p_76665_3_) {
      IBlockState var4 = this.func_177485_a(p_76665_1_, p_76665_2_, p_76665_3_);
      return var4.func_177230_c().func_176201_c(var4);
   }

   public boolean func_76663_a() {
      return this.field_76682_b == 0;
   }

   public boolean func_76675_b() {
      return this.field_76683_c > 0;
   }

   public int func_76662_d() {
      return this.field_76684_a;
   }

   public void func_76657_c(int p_76657_1_, int p_76657_2_, int p_76657_3_, int p_76657_4_) {
      this.field_76685_h.func_76581_a(p_76657_1_, p_76657_2_, p_76657_3_, p_76657_4_);
   }

   public int func_76670_c(int p_76670_1_, int p_76670_2_, int p_76670_3_) {
      return this.field_76685_h.func_76582_a(p_76670_1_, p_76670_2_, p_76670_3_);
   }

   public void func_76677_d(int p_76677_1_, int p_76677_2_, int p_76677_3_, int p_76677_4_) {
      this.field_76679_g.func_76581_a(p_76677_1_, p_76677_2_, p_76677_3_, p_76677_4_);
   }

   public int func_76674_d(int p_76674_1_, int p_76674_2_, int p_76674_3_) {
      return this.field_76679_g.func_76582_a(p_76674_1_, p_76674_2_, p_76674_3_);
   }

   public void func_76672_e() {
      this.field_76682_b = 0;
      this.field_76683_c = 0;

      for(int var1 = 0; var1 < 16; ++var1) {
         for(int var2 = 0; var2 < 16; ++var2) {
            for(int var3 = 0; var3 < 16; ++var3) {
               Block var4 = this.func_150819_a(var1, var2, var3);
               if(var4 != Blocks.field_150350_a) {
                  ++this.field_76682_b;
                  if(var4.func_149653_t()) {
                     ++this.field_76683_c;
                  }
               }
            }
         }
      }

   }

   public char[] func_177487_g() {
      return this.field_177488_d;
   }

   public void func_177486_a(char[] p_177486_1_) {
      this.field_177488_d = p_177486_1_;
   }

   public NibbleArray func_76661_k() {
      return this.field_76679_g;
   }

   public NibbleArray func_76671_l() {
      return this.field_76685_h;
   }

   public void func_76659_c(NibbleArray p_76659_1_) {
      this.field_76679_g = p_76659_1_;
   }

   public void func_76666_d(NibbleArray p_76666_1_) {
      this.field_76685_h = p_76666_1_;
   }
}
