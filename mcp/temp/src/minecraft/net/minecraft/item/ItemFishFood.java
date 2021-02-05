package net.minecraft.item;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.world.World;

public class ItemFishFood extends ItemFood {

   private final boolean field_150907_b;
   private static final String __OBFID = "CL_00000032";


   public ItemFishFood(boolean p_i45338_1_) {
      super(0, 0.0F, false);
      this.field_150907_b = p_i45338_1_;
   }

   public int func_150905_g(ItemStack p_150905_1_) {
      ItemFishFood.FishType var2 = ItemFishFood.FishType.func_150978_a(p_150905_1_);
      return this.field_150907_b && var2.func_150973_i()?var2.func_150970_e():var2.func_150975_c();
   }

   public float func_150906_h(ItemStack p_150906_1_) {
      ItemFishFood.FishType var2 = ItemFishFood.FishType.func_150978_a(p_150906_1_);
      return this.field_150907_b && var2.func_150973_i()?var2.func_150977_f():var2.func_150967_d();
   }

   public String func_150896_i(ItemStack p_150896_1_) {
      return ItemFishFood.FishType.func_150978_a(p_150896_1_) == ItemFishFood.FishType.PUFFERFISH?PotionHelper.field_151423_m:null;
   }

   protected void func_77849_c(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer p_77849_3_) {
      ItemFishFood.FishType var4 = ItemFishFood.FishType.func_150978_a(p_77849_1_);
      if(var4 == ItemFishFood.FishType.PUFFERFISH) {
         p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76436_u.field_76415_H, 1200, 3));
         p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76438_s.field_76415_H, 300, 2));
         p_77849_3_.func_70690_d(new PotionEffect(Potion.field_76431_k.field_76415_H, 300, 1));
      }

      super.func_77849_c(p_77849_1_, p_77849_2_, p_77849_3_);
   }

   public void func_150895_a(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_) {
      ItemFishFood.FishType[] var4 = ItemFishFood.FishType.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ItemFishFood.FishType var7 = var4[var6];
         if(!this.field_150907_b || var7.func_150973_i()) {
            p_150895_3_.add(new ItemStack(this, 1, var7.func_150976_a()));
         }
      }

   }

   public String func_77667_c(ItemStack p_77667_1_) {
      ItemFishFood.FishType var2 = ItemFishFood.FishType.func_150978_a(p_77667_1_);
      return this.func_77658_a() + "." + var2.func_150972_b() + "." + (this.field_150907_b && var2.func_150973_i()?"cooked":"raw");
   }

   public static enum FishType {

      COD("COD", 0, 0, "cod", 2, 0.1F, 5, 0.6F),
      SALMON("SALMON", 1, 1, "salmon", 2, 0.1F, 6, 0.8F),
      CLOWNFISH("CLOWNFISH", 2, 2, "clownfish", 1, 0.1F),
      PUFFERFISH("PUFFERFISH", 3, 3, "pufferfish", 1, 0.1F);
      private static final Map field_150983_e = Maps.newHashMap();
      private final int field_150980_f;
      private final String field_150981_g;
      private final int field_150991_j;
      private final float field_150992_k;
      private final int field_150989_l;
      private final float field_150990_m;
      private boolean field_150987_n = false;
      // $FF: synthetic field
      private static final ItemFishFood.FishType[] $VALUES = new ItemFishFood.FishType[]{COD, SALMON, CLOWNFISH, PUFFERFISH};
      private static final String __OBFID = "CL_00000033";


      private FishType(String p_i45336_1_, int p_i45336_2_, int p_i45336_3_, String p_i45336_4_, int p_i45336_5_, float p_i45336_6_, int p_i45336_7_, float p_i45336_8_) {
         this.field_150980_f = p_i45336_3_;
         this.field_150981_g = p_i45336_4_;
         this.field_150991_j = p_i45336_5_;
         this.field_150992_k = p_i45336_6_;
         this.field_150989_l = p_i45336_7_;
         this.field_150990_m = p_i45336_8_;
         this.field_150987_n = true;
      }

      private FishType(String p_i45337_1_, int p_i45337_2_, int p_i45337_3_, String p_i45337_4_, int p_i45337_5_, float p_i45337_6_) {
         this.field_150980_f = p_i45337_3_;
         this.field_150981_g = p_i45337_4_;
         this.field_150991_j = p_i45337_5_;
         this.field_150992_k = p_i45337_6_;
         this.field_150989_l = 0;
         this.field_150990_m = 0.0F;
         this.field_150987_n = false;
      }

      public int func_150976_a() {
         return this.field_150980_f;
      }

      public String func_150972_b() {
         return this.field_150981_g;
      }

      public int func_150975_c() {
         return this.field_150991_j;
      }

      public float func_150967_d() {
         return this.field_150992_k;
      }

      public int func_150970_e() {
         return this.field_150989_l;
      }

      public float func_150977_f() {
         return this.field_150990_m;
      }

      public boolean func_150973_i() {
         return this.field_150987_n;
      }

      public static ItemFishFood.FishType func_150974_a(int p_150974_0_) {
         ItemFishFood.FishType var1 = (ItemFishFood.FishType)field_150983_e.get(Integer.valueOf(p_150974_0_));
         return var1 == null?COD:var1;
      }

      public static ItemFishFood.FishType func_150978_a(ItemStack p_150978_0_) {
         return p_150978_0_.func_77973_b() instanceof ItemFishFood?func_150974_a(p_150978_0_.func_77960_j()):COD;
      }

      static {
         ItemFishFood.FishType[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            ItemFishFood.FishType var3 = var0[var2];
            field_150983_e.put(Integer.valueOf(var3.func_150976_a()), var3);
         }

      }
   }
}
