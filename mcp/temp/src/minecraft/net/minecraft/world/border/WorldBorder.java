package net.minecraft.world.border;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.border.EnumBorderStatus;
import net.minecraft.world.border.IBorderListener;

public class WorldBorder {

   private final List field_177758_a = Lists.newArrayList();
   private double field_177756_b = 0.0D;
   private double field_177757_c = 0.0D;
   private double field_177754_d = 6.0E7D;
   private double field_177755_e;
   private long field_177752_f;
   private long field_177753_g;
   private int field_177762_h;
   private double field_177763_i;
   private double field_177760_j;
   private int field_177761_k;
   private int field_177759_l;
   private static final String __OBFID = "CL_00002012";


   public WorldBorder() {
      this.field_177755_e = this.field_177754_d;
      this.field_177762_h = 29999984;
      this.field_177763_i = 0.2D;
      this.field_177760_j = 5.0D;
      this.field_177761_k = 15;
      this.field_177759_l = 5;
   }

   public boolean func_177746_a(BlockPos p_177746_1_) {
      return (double)(p_177746_1_.func_177958_n() + 1) > this.func_177726_b() && (double)p_177746_1_.func_177958_n() < this.func_177728_d() && (double)(p_177746_1_.func_177952_p() + 1) > this.func_177736_c() && (double)p_177746_1_.func_177952_p() < this.func_177733_e();
   }

   public boolean func_177730_a(ChunkCoordIntPair p_177730_1_) {
      return (double)p_177730_1_.func_180332_e() > this.func_177726_b() && (double)p_177730_1_.func_180334_c() < this.func_177728_d() && (double)p_177730_1_.func_180330_f() > this.func_177736_c() && (double)p_177730_1_.func_180333_d() < this.func_177733_e();
   }

   public boolean func_177743_a(AxisAlignedBB p_177743_1_) {
      return p_177743_1_.field_72336_d > this.func_177726_b() && p_177743_1_.field_72340_a < this.func_177728_d() && p_177743_1_.field_72334_f > this.func_177736_c() && p_177743_1_.field_72339_c < this.func_177733_e();
   }

   public double func_177745_a(Entity p_177745_1_) {
      return this.func_177729_b(p_177745_1_.field_70165_t, p_177745_1_.field_70161_v);
   }

   public double func_177729_b(double p_177729_1_, double p_177729_3_) {
      double var5 = p_177729_3_ - this.func_177736_c();
      double var7 = this.func_177733_e() - p_177729_3_;
      double var9 = p_177729_1_ - this.func_177726_b();
      double var11 = this.func_177728_d() - p_177729_1_;
      double var13 = Math.min(var9, var11);
      var13 = Math.min(var13, var5);
      return Math.min(var13, var7);
   }

   public EnumBorderStatus func_177734_a() {
      return this.field_177755_e < this.field_177754_d?EnumBorderStatus.SHRINKING:(this.field_177755_e > this.field_177754_d?EnumBorderStatus.GROWING:EnumBorderStatus.STATIONARY);
   }

   public double func_177726_b() {
      double var1 = this.func_177731_f() - this.func_177741_h() / 2.0D;
      if(var1 < (double)(-this.field_177762_h)) {
         var1 = (double)(-this.field_177762_h);
      }

      return var1;
   }

   public double func_177736_c() {
      double var1 = this.func_177721_g() - this.func_177741_h() / 2.0D;
      if(var1 < (double)(-this.field_177762_h)) {
         var1 = (double)(-this.field_177762_h);
      }

      return var1;
   }

   public double func_177728_d() {
      double var1 = this.func_177731_f() + this.func_177741_h() / 2.0D;
      if(var1 > (double)this.field_177762_h) {
         var1 = (double)this.field_177762_h;
      }

      return var1;
   }

   public double func_177733_e() {
      double var1 = this.func_177721_g() + this.func_177741_h() / 2.0D;
      if(var1 > (double)this.field_177762_h) {
         var1 = (double)this.field_177762_h;
      }

      return var1;
   }

   public double func_177731_f() {
      return this.field_177756_b;
   }

   public double func_177721_g() {
      return this.field_177757_c;
   }

   public void func_177739_c(double p_177739_1_, double p_177739_3_) {
      this.field_177756_b = p_177739_1_;
      this.field_177757_c = p_177739_3_;
      Iterator var5 = this.func_177735_k().iterator();

      while(var5.hasNext()) {
         IBorderListener var6 = (IBorderListener)var5.next();
         var6.func_177693_a(this, p_177739_1_, p_177739_3_);
      }

   }

   public double func_177741_h() {
      if(this.func_177734_a() != EnumBorderStatus.STATIONARY) {
         double var1 = (double)((float)(System.currentTimeMillis() - this.field_177753_g) / (float)(this.field_177752_f - this.field_177753_g));
         if(var1 < 1.0D) {
            return this.field_177754_d + (this.field_177755_e - this.field_177754_d) * var1;
         }

         this.func_177750_a(this.field_177755_e);
      }

      return this.field_177754_d;
   }

   public long func_177732_i() {
      return this.func_177734_a() != EnumBorderStatus.STATIONARY?this.field_177752_f - System.currentTimeMillis():0L;
   }

   public double func_177751_j() {
      return this.field_177755_e;
   }

   public void func_177750_a(double p_177750_1_) {
      this.field_177754_d = p_177750_1_;
      this.field_177755_e = p_177750_1_;
      this.field_177752_f = System.currentTimeMillis();
      this.field_177753_g = this.field_177752_f;
      Iterator var3 = this.func_177735_k().iterator();

      while(var3.hasNext()) {
         IBorderListener var4 = (IBorderListener)var3.next();
         var4.func_177694_a(this, p_177750_1_);
      }

   }

   public void func_177738_a(double p_177738_1_, double p_177738_3_, long p_177738_5_) {
      this.field_177754_d = p_177738_1_;
      this.field_177755_e = p_177738_3_;
      this.field_177753_g = System.currentTimeMillis();
      this.field_177752_f = this.field_177753_g + p_177738_5_;
      Iterator var7 = this.func_177735_k().iterator();

      while(var7.hasNext()) {
         IBorderListener var8 = (IBorderListener)var7.next();
         var8.func_177692_a(this, p_177738_1_, p_177738_3_, p_177738_5_);
      }

   }

   protected List func_177735_k() {
      return Lists.newArrayList(this.field_177758_a);
   }

   public void func_177737_a(IBorderListener p_177737_1_) {
      this.field_177758_a.add(p_177737_1_);
   }

   public void func_177725_a(int p_177725_1_) {
      this.field_177762_h = p_177725_1_;
   }

   public int func_177722_l() {
      return this.field_177762_h;
   }

   public double func_177742_m() {
      return this.field_177760_j;
   }

   public void func_177724_b(double p_177724_1_) {
      this.field_177760_j = p_177724_1_;
      Iterator var3 = this.func_177735_k().iterator();

      while(var3.hasNext()) {
         IBorderListener var4 = (IBorderListener)var3.next();
         var4.func_177695_c(this, p_177724_1_);
      }

   }

   public double func_177727_n() {
      return this.field_177763_i;
   }

   public void func_177744_c(double p_177744_1_) {
      this.field_177763_i = p_177744_1_;
      Iterator var3 = this.func_177735_k().iterator();

      while(var3.hasNext()) {
         IBorderListener var4 = (IBorderListener)var3.next();
         var4.func_177696_b(this, p_177744_1_);
      }

   }

   public double func_177749_o() {
      return this.field_177752_f == this.field_177753_g?0.0D:Math.abs(this.field_177754_d - this.field_177755_e) / (double)(this.field_177752_f - this.field_177753_g);
   }

   public int func_177740_p() {
      return this.field_177761_k;
   }

   public void func_177723_b(int p_177723_1_) {
      this.field_177761_k = p_177723_1_;
      Iterator var2 = this.func_177735_k().iterator();

      while(var2.hasNext()) {
         IBorderListener var3 = (IBorderListener)var2.next();
         var3.func_177691_a(this, p_177723_1_);
      }

   }

   public int func_177748_q() {
      return this.field_177759_l;
   }

   public void func_177747_c(int p_177747_1_) {
      this.field_177759_l = p_177747_1_;
      Iterator var2 = this.func_177735_k().iterator();

      while(var2.hasNext()) {
         IBorderListener var3 = (IBorderListener)var2.next();
         var3.func_177690_b(this, p_177747_1_);
      }

   }
}
