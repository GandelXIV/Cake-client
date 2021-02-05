package net.minecraft.client.resources.model;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.WeightedRandom;

public class WeightedBakedModel implements IBakedModel {

   private final int field_177567_a;
   private final List field_177565_b;
   private final IBakedModel field_177566_c;
   private static final String __OBFID = "CL_00002384";


   public WeightedBakedModel(List p_i46073_1_) {
      this.field_177565_b = p_i46073_1_;
      this.field_177567_a = WeightedRandom.func_76272_a(p_i46073_1_);
      this.field_177566_c = ((WeightedBakedModel.MyWeighedRandomItem)p_i46073_1_.get(0)).field_177636_b;
   }

   public List func_177551_a(EnumFacing p_177551_1_) {
      return this.field_177566_c.func_177551_a(p_177551_1_);
   }

   public List func_177550_a() {
      return this.field_177566_c.func_177550_a();
   }

   public boolean func_177555_b() {
      return this.field_177566_c.func_177555_b();
   }

   public boolean func_177556_c() {
      return this.field_177566_c.func_177556_c();
   }

   public boolean func_177553_d() {
      return this.field_177566_c.func_177553_d();
   }

   public TextureAtlasSprite func_177554_e() {
      return this.field_177566_c.func_177554_e();
   }

   public ItemCameraTransforms func_177552_f() {
      return this.field_177566_c.func_177552_f();
   }

   public IBakedModel func_177564_a(long p_177564_1_) {
      return ((WeightedBakedModel.MyWeighedRandomItem)WeightedRandom.func_180166_a(this.field_177565_b, Math.abs((int)p_177564_1_ >> 16) % this.field_177567_a)).field_177636_b;
   }

   public static class Builder {

      private List field_177678_a = Lists.newArrayList();
      private static final String __OBFID = "CL_00002383";


      public WeightedBakedModel.Builder func_177677_a(IBakedModel p_177677_1_, int p_177677_2_) {
         this.field_177678_a.add(new WeightedBakedModel.MyWeighedRandomItem(p_177677_1_, p_177677_2_));
         return this;
      }

      public WeightedBakedModel func_177676_a() {
         Collections.sort(this.field_177678_a);
         return new WeightedBakedModel(this.field_177678_a);
      }

      public IBakedModel func_177675_b() {
         return ((WeightedBakedModel.MyWeighedRandomItem)this.field_177678_a.get(0)).field_177636_b;
      }
   }

   static class MyWeighedRandomItem extends WeightedRandom.Item implements Comparable {

      protected final IBakedModel field_177636_b;
      private static final String __OBFID = "CL_00002382";


      public MyWeighedRandomItem(IBakedModel p_i46072_1_, int p_i46072_2_) {
         super(p_i46072_2_);
         this.field_177636_b = p_i46072_1_;
      }

      public int func_177634_a(WeightedBakedModel.MyWeighedRandomItem p_177634_1_) {
         return ComparisonChain.start().compare(p_177634_1_.field_76292_a, this.field_76292_a).compare(this.func_177635_a(), p_177634_1_.func_177635_a()).result();
      }

      protected int func_177635_a() {
         int var1 = this.field_177636_b.func_177550_a().size();
         EnumFacing[] var2 = EnumFacing.values();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            EnumFacing var5 = var2[var4];
            var1 += this.field_177636_b.func_177551_a(var5).size();
         }

         return var1;
      }

      public String toString() {
         return "MyWeighedRandomItem{weight=" + this.field_76292_a + ", model=" + this.field_177636_b + '}';
      }

      // $FF: synthetic method
      public int compareTo(Object p_compareTo_1_) {
         return this.func_177634_a((WeightedBakedModel.MyWeighedRandomItem)p_compareTo_1_);
      }
   }
}
