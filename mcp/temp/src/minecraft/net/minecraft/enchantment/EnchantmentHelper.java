package net.minecraft.enchantment;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.WeightedRandom;

public class EnchantmentHelper {

   private static final Random field_77522_a = new Random();
   private static final EnchantmentHelper.ModifierDamage field_77520_b = new EnchantmentHelper.ModifierDamage(null);
   private static final EnchantmentHelper.ModifierLiving field_77521_c = new EnchantmentHelper.ModifierLiving(null);
   private static final EnchantmentHelper.HurtIterator field_151388_d = new EnchantmentHelper.HurtIterator(null);
   private static final EnchantmentHelper.DamageIterator field_151389_e = new EnchantmentHelper.DamageIterator(null);
   private static final String __OBFID = "CL_00000107";


   public static int func_77506_a(int p_77506_0_, ItemStack p_77506_1_) {
      if(p_77506_1_ == null) {
         return 0;
      } else {
         NBTTagList var2 = p_77506_1_.func_77986_q();
         if(var2 == null) {
            return 0;
         } else {
            for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
               short var4 = var2.func_150305_b(var3).func_74765_d("id");
               short var5 = var2.func_150305_b(var3).func_74765_d("lvl");
               if(var4 == p_77506_0_) {
                  return var5;
               }
            }

            return 0;
         }
      }
   }

   public static Map func_82781_a(ItemStack p_82781_0_) {
      LinkedHashMap var1 = Maps.newLinkedHashMap();
      NBTTagList var2 = p_82781_0_.func_77973_b() == Items.field_151134_bR?Items.field_151134_bR.func_92110_g(p_82781_0_):p_82781_0_.func_77986_q();
      if(var2 != null) {
         for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
            short var4 = var2.func_150305_b(var3).func_74765_d("id");
            short var5 = var2.func_150305_b(var3).func_74765_d("lvl");
            var1.put(Integer.valueOf(var4), Integer.valueOf(var5));
         }
      }

      return var1;
   }

   public static void func_82782_a(Map p_82782_0_, ItemStack p_82782_1_) {
      NBTTagList var2 = new NBTTagList();
      Iterator var3 = p_82782_0_.keySet().iterator();

      while(var3.hasNext()) {
         int var4 = ((Integer)var3.next()).intValue();
         Enchantment var5 = Enchantment.func_180306_c(var4);
         if(var5 != null) {
            NBTTagCompound var6 = new NBTTagCompound();
            var6.func_74777_a("id", (short)var4);
            var6.func_74777_a("lvl", (short)((Integer)p_82782_0_.get(Integer.valueOf(var4))).intValue());
            var2.func_74742_a(var6);
            if(p_82782_1_.func_77973_b() == Items.field_151134_bR) {
               Items.field_151134_bR.func_92115_a(p_82782_1_, new EnchantmentData(var5, ((Integer)p_82782_0_.get(Integer.valueOf(var4))).intValue()));
            }
         }
      }

      if(var2.func_74745_c() > 0) {
         if(p_82782_1_.func_77973_b() != Items.field_151134_bR) {
            p_82782_1_.func_77983_a("ench", var2);
         }
      } else if(p_82782_1_.func_77942_o()) {
         p_82782_1_.func_77978_p().func_82580_o("ench");
      }

   }

   public static int func_77511_a(int p_77511_0_, ItemStack[] p_77511_1_) {
      if(p_77511_1_ == null) {
         return 0;
      } else {
         int var2 = 0;
         ItemStack[] var3 = p_77511_1_;
         int var4 = p_77511_1_.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            ItemStack var6 = var3[var5];
            int var7 = func_77506_a(p_77511_0_, var6);
            if(var7 > var2) {
               var2 = var7;
            }
         }

         return var2;
      }
   }

   private static void func_77518_a(EnchantmentHelper.IModifier p_77518_0_, ItemStack p_77518_1_) {
      if(p_77518_1_ != null) {
         NBTTagList var2 = p_77518_1_.func_77986_q();
         if(var2 != null) {
            for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
               short var4 = var2.func_150305_b(var3).func_74765_d("id");
               short var5 = var2.func_150305_b(var3).func_74765_d("lvl");
               if(Enchantment.func_180306_c(var4) != null) {
                  p_77518_0_.func_77493_a(Enchantment.func_180306_c(var4), var5);
               }
            }

         }
      }
   }

   private static void func_77516_a(EnchantmentHelper.IModifier p_77516_0_, ItemStack[] p_77516_1_) {
      ItemStack[] var2 = p_77516_1_;
      int var3 = p_77516_1_.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ItemStack var5 = var2[var4];
         func_77518_a(p_77516_0_, var5);
      }

   }

   public static int func_77508_a(ItemStack[] p_77508_0_, DamageSource p_77508_1_) {
      field_77520_b.field_77497_a = 0;
      field_77520_b.field_77496_b = p_77508_1_;
      func_77516_a(field_77520_b, p_77508_0_);
      if(field_77520_b.field_77497_a > 25) {
         field_77520_b.field_77497_a = 25;
      }

      return (field_77520_b.field_77497_a + 1 >> 1) + field_77522_a.nextInt((field_77520_b.field_77497_a >> 1) + 1);
   }

   public static float func_152377_a(ItemStack p_152377_0_, EnumCreatureAttribute p_152377_1_) {
      field_77521_c.field_77495_a = 0.0F;
      field_77521_c.field_77494_b = p_152377_1_;
      func_77518_a(field_77521_c, p_152377_0_);
      return field_77521_c.field_77495_a;
   }

   public static void func_151384_a(EntityLivingBase p_151384_0_, Entity p_151384_1_) {
      field_151388_d.field_151363_b = p_151384_1_;
      field_151388_d.field_151364_a = p_151384_0_;
      if(p_151384_0_ != null) {
         func_77516_a(field_151388_d, p_151384_0_.func_70035_c());
      }

      if(p_151384_1_ instanceof EntityPlayer) {
         func_77518_a(field_151388_d, p_151384_0_.func_70694_bm());
      }

   }

   public static void func_151385_b(EntityLivingBase p_151385_0_, Entity p_151385_1_) {
      field_151389_e.field_151366_a = p_151385_0_;
      field_151389_e.field_151365_b = p_151385_1_;
      if(p_151385_0_ != null) {
         func_77516_a(field_151389_e, p_151385_0_.func_70035_c());
      }

      if(p_151385_0_ instanceof EntityPlayer) {
         func_77518_a(field_151389_e, p_151385_0_.func_70694_bm());
      }

   }

   public static int func_77501_a(EntityLivingBase p_77501_0_) {
      return func_77506_a(Enchantment.field_180313_o.field_77352_x, p_77501_0_.func_70694_bm());
   }

   public static int func_90036_a(EntityLivingBase p_90036_0_) {
      return func_77506_a(Enchantment.field_77334_n.field_77352_x, p_90036_0_.func_70694_bm());
   }

   public static int func_180319_a(Entity p_180319_0_) {
      return func_77511_a(Enchantment.field_180317_h.field_77352_x, p_180319_0_.func_70035_c());
   }

   public static int func_180318_b(Entity p_180318_0_) {
      return func_77511_a(Enchantment.field_180316_k.field_77352_x, p_180318_0_.func_70035_c());
   }

   public static int func_77509_b(EntityLivingBase p_77509_0_) {
      return func_77506_a(Enchantment.field_77349_p.field_77352_x, p_77509_0_.func_70694_bm());
   }

   public static boolean func_77502_d(EntityLivingBase p_77502_0_) {
      return func_77506_a(Enchantment.field_77348_q.field_77352_x, p_77502_0_.func_70694_bm()) > 0;
   }

   public static int func_77517_e(EntityLivingBase p_77517_0_) {
      return func_77506_a(Enchantment.field_77346_s.field_77352_x, p_77517_0_.func_70694_bm());
   }

   public static int func_151386_g(EntityLivingBase p_151386_0_) {
      return func_77506_a(Enchantment.field_151370_z.field_77352_x, p_151386_0_.func_70694_bm());
   }

   public static int func_151387_h(EntityLivingBase p_151387_0_) {
      return func_77506_a(Enchantment.field_151369_A.field_77352_x, p_151387_0_.func_70694_bm());
   }

   public static int func_77519_f(EntityLivingBase p_77519_0_) {
      return func_77506_a(Enchantment.field_77335_o.field_77352_x, p_77519_0_.func_70694_bm());
   }

   public static boolean func_77510_g(EntityLivingBase p_77510_0_) {
      return func_77511_a(Enchantment.field_77341_i.field_77352_x, p_77510_0_.func_70035_c()) > 0;
   }

   public static ItemStack func_92099_a(Enchantment p_92099_0_, EntityLivingBase p_92099_1_) {
      ItemStack[] var2 = p_92099_1_.func_70035_c();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ItemStack var5 = var2[var4];
         if(var5 != null && func_77506_a(p_92099_0_.field_77352_x, var5) > 0) {
            return var5;
         }
      }

      return null;
   }

   public static int func_77514_a(Random p_77514_0_, int p_77514_1_, int p_77514_2_, ItemStack p_77514_3_) {
      Item var4 = p_77514_3_.func_77973_b();
      int var5 = var4.func_77619_b();
      if(var5 <= 0) {
         return 0;
      } else {
         if(p_77514_2_ > 15) {
            p_77514_2_ = 15;
         }

         int var6 = p_77514_0_.nextInt(8) + 1 + (p_77514_2_ >> 1) + p_77514_0_.nextInt(p_77514_2_ + 1);
         return p_77514_1_ == 0?Math.max(var6 / 3, 1):(p_77514_1_ == 1?var6 * 2 / 3 + 1:Math.max(var6, p_77514_2_ * 2));
      }
   }

   public static ItemStack func_77504_a(Random p_77504_0_, ItemStack p_77504_1_, int p_77504_2_) {
      List var3 = func_77513_b(p_77504_0_, p_77504_1_, p_77504_2_);
      boolean var4 = p_77504_1_.func_77973_b() == Items.field_151122_aG;
      if(var4) {
         p_77504_1_.func_150996_a(Items.field_151134_bR);
      }

      if(var3 != null) {
         Iterator var5 = var3.iterator();

         while(var5.hasNext()) {
            EnchantmentData var6 = (EnchantmentData)var5.next();
            if(var4) {
               Items.field_151134_bR.func_92115_a(p_77504_1_, var6);
            } else {
               p_77504_1_.func_77966_a(var6.field_76302_b, var6.field_76303_c);
            }
         }
      }

      return p_77504_1_;
   }

   public static List func_77513_b(Random p_77513_0_, ItemStack p_77513_1_, int p_77513_2_) {
      Item var3 = p_77513_1_.func_77973_b();
      int var4 = var3.func_77619_b();
      if(var4 <= 0) {
         return null;
      } else {
         var4 /= 2;
         var4 = 1 + p_77513_0_.nextInt((var4 >> 1) + 1) + p_77513_0_.nextInt((var4 >> 1) + 1);
         int var5 = var4 + p_77513_2_;
         float var6 = (p_77513_0_.nextFloat() + p_77513_0_.nextFloat() - 1.0F) * 0.15F;
         int var7 = (int)((float)var5 * (1.0F + var6) + 0.5F);
         if(var7 < 1) {
            var7 = 1;
         }

         ArrayList var8 = null;
         Map var9 = func_77505_b(var7, p_77513_1_);
         if(var9 != null && !var9.isEmpty()) {
            EnchantmentData var10 = (EnchantmentData)WeightedRandom.func_76271_a(p_77513_0_, var9.values());
            if(var10 != null) {
               var8 = Lists.newArrayList();
               var8.add(var10);

               for(int var11 = var7; p_77513_0_.nextInt(50) <= var11; var11 >>= 1) {
                  Iterator var12 = var9.keySet().iterator();

                  while(var12.hasNext()) {
                     Integer var13 = (Integer)var12.next();
                     boolean var14 = true;
                     Iterator var15 = var8.iterator();

                     while(true) {
                        if(var15.hasNext()) {
                           EnchantmentData var16 = (EnchantmentData)var15.next();
                           if(var16.field_76302_b.func_77326_a(Enchantment.func_180306_c(var13.intValue()))) {
                              continue;
                           }

                           var14 = false;
                        }

                        if(!var14) {
                           var12.remove();
                        }
                        break;
                     }
                  }

                  if(!var9.isEmpty()) {
                     EnchantmentData var17 = (EnchantmentData)WeightedRandom.func_76271_a(p_77513_0_, var9.values());
                     var8.add(var17);
                  }
               }
            }
         }

         return var8;
      }
   }

   public static Map func_77505_b(int p_77505_0_, ItemStack p_77505_1_) {
      Item var2 = p_77505_1_.func_77973_b();
      HashMap var3 = null;
      boolean var4 = p_77505_1_.func_77973_b() == Items.field_151122_aG;
      Enchantment[] var5 = Enchantment.field_77331_b;
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         Enchantment var8 = var5[var7];
         if(var8 != null && (var8.field_77351_y.func_77557_a(var2) || var4)) {
            for(int var9 = var8.func_77319_d(); var9 <= var8.func_77325_b(); ++var9) {
               if(p_77505_0_ >= var8.func_77321_a(var9) && p_77505_0_ <= var8.func_77317_b(var9)) {
                  if(var3 == null) {
                     var3 = Maps.newHashMap();
                  }

                  var3.put(Integer.valueOf(var8.field_77352_x), new EnchantmentData(var8, var9));
               }
            }
         }
      }

      return var3;
   }


   static final class DamageIterator implements EnchantmentHelper.IModifier {

      public EntityLivingBase field_151366_a;
      public Entity field_151365_b;
      private static final String __OBFID = "CL_00000109";


      private DamageIterator() {}

      public void func_77493_a(Enchantment p_77493_1_, int p_77493_2_) {
         p_77493_1_.func_151368_a(this.field_151366_a, this.field_151365_b, p_77493_2_);
      }

      // $FF: synthetic method
      DamageIterator(Object p_i45359_1_) {
         this();
      }
   }

   static final class HurtIterator implements EnchantmentHelper.IModifier {

      public EntityLivingBase field_151364_a;
      public Entity field_151363_b;
      private static final String __OBFID = "CL_00000110";


      private HurtIterator() {}

      public void func_77493_a(Enchantment p_77493_1_, int p_77493_2_) {
         p_77493_1_.func_151367_b(this.field_151364_a, this.field_151363_b, p_77493_2_);
      }

      // $FF: synthetic method
      HurtIterator(Object p_i45360_1_) {
         this();
      }
   }

   interface IModifier {

      void func_77493_a(Enchantment var1, int var2);
   }

   static final class ModifierDamage implements EnchantmentHelper.IModifier {

      public int field_77497_a;
      public DamageSource field_77496_b;
      private static final String __OBFID = "CL_00000114";


      private ModifierDamage() {}

      public void func_77493_a(Enchantment p_77493_1_, int p_77493_2_) {
         this.field_77497_a += p_77493_1_.func_77318_a(p_77493_2_, this.field_77496_b);
      }

      // $FF: synthetic method
      ModifierDamage(Object p_i1929_1_) {
         this();
      }
   }

   static final class ModifierLiving implements EnchantmentHelper.IModifier {

      public float field_77495_a;
      public EnumCreatureAttribute field_77494_b;
      private static final String __OBFID = "CL_00000112";


      private ModifierLiving() {}

      public void func_77493_a(Enchantment p_77493_1_, int p_77493_2_) {
         this.field_77495_a += p_77493_1_.func_152376_a(p_77493_2_, this.field_77494_b);
      }

      // $FF: synthetic method
      ModifierLiving(Object p_i1928_1_) {
         this();
      }
   }
}
