package net.minecraft.util;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.WeightedRandom;

public class WeightedRandomChestContent extends WeightedRandom.Item {

   private ItemStack field_76297_b;
   private int field_76295_d;
   private int field_76296_e;
   private static final String __OBFID = "CL_00001505";


   public WeightedRandomChestContent(Item p_i45311_1_, int p_i45311_2_, int p_i45311_3_, int p_i45311_4_, int p_i45311_5_) {
      super(p_i45311_5_);
      this.field_76297_b = new ItemStack(p_i45311_1_, 1, p_i45311_2_);
      this.field_76295_d = p_i45311_3_;
      this.field_76296_e = p_i45311_4_;
   }

   public WeightedRandomChestContent(ItemStack p_i1558_1_, int p_i1558_2_, int p_i1558_3_, int p_i1558_4_) {
      super(p_i1558_4_);
      this.field_76297_b = p_i1558_1_;
      this.field_76295_d = p_i1558_2_;
      this.field_76296_e = p_i1558_3_;
   }

   public static void func_177630_a(Random p_177630_0_, List p_177630_1_, IInventory p_177630_2_, int p_177630_3_) {
      for(int var4 = 0; var4 < p_177630_3_; ++var4) {
         WeightedRandomChestContent var5 = (WeightedRandomChestContent)WeightedRandom.func_76271_a(p_177630_0_, p_177630_1_);
         int var6 = var5.field_76295_d + p_177630_0_.nextInt(var5.field_76296_e - var5.field_76295_d + 1);
         if(var5.field_76297_b.func_77976_d() >= var6) {
            ItemStack var7 = var5.field_76297_b.func_77946_l();
            var7.field_77994_a = var6;
            p_177630_2_.func_70299_a(p_177630_0_.nextInt(p_177630_2_.func_70302_i_()), var7);
         } else {
            for(int var9 = 0; var9 < var6; ++var9) {
               ItemStack var8 = var5.field_76297_b.func_77946_l();
               var8.field_77994_a = 1;
               p_177630_2_.func_70299_a(p_177630_0_.nextInt(p_177630_2_.func_70302_i_()), var8);
            }
         }
      }

   }

   public static void func_177631_a(Random p_177631_0_, List p_177631_1_, TileEntityDispenser p_177631_2_, int p_177631_3_) {
      for(int var4 = 0; var4 < p_177631_3_; ++var4) {
         WeightedRandomChestContent var5 = (WeightedRandomChestContent)WeightedRandom.func_76271_a(p_177631_0_, p_177631_1_);
         int var6 = var5.field_76295_d + p_177631_0_.nextInt(var5.field_76296_e - var5.field_76295_d + 1);
         if(var5.field_76297_b.func_77976_d() >= var6) {
            ItemStack var7 = var5.field_76297_b.func_77946_l();
            var7.field_77994_a = var6;
            p_177631_2_.func_70299_a(p_177631_0_.nextInt(p_177631_2_.func_70302_i_()), var7);
         } else {
            for(int var9 = 0; var9 < var6; ++var9) {
               ItemStack var8 = var5.field_76297_b.func_77946_l();
               var8.field_77994_a = 1;
               p_177631_2_.func_70299_a(p_177631_0_.nextInt(p_177631_2_.func_70302_i_()), var8);
            }
         }
      }

   }

   public static List func_177629_a(List p_177629_0_, WeightedRandomChestContent ... p_177629_1_) {
      ArrayList var2 = Lists.newArrayList(p_177629_0_);
      Collections.addAll(var2, p_177629_1_);
      return var2;
   }
}
