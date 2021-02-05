package net.minecraft.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemPotion extends Item {

   private Map field_77836_a = Maps.newHashMap();
   private static final Map field_77835_b = Maps.newLinkedHashMap();
   private static final String __OBFID = "CL_00000055";


   public ItemPotion() {
      this.func_77625_d(1);
      this.func_77627_a(true);
      this.func_77656_e(0);
      this.func_77637_a(CreativeTabs.field_78038_k);
   }

   public List func_77832_l(ItemStack p_77832_1_) {
      if(p_77832_1_.func_77942_o() && p_77832_1_.func_77978_p().func_150297_b("CustomPotionEffects", 9)) {
         ArrayList var7 = Lists.newArrayList();
         NBTTagList var3 = p_77832_1_.func_77978_p().func_150295_c("CustomPotionEffects", 10);

         for(int var4 = 0; var4 < var3.func_74745_c(); ++var4) {
            NBTTagCompound var5 = var3.func_150305_b(var4);
            PotionEffect var6 = PotionEffect.func_82722_b(var5);
            if(var6 != null) {
               var7.add(var6);
            }
         }

         return var7;
      } else {
         List var2 = (List)this.field_77836_a.get(Integer.valueOf(p_77832_1_.func_77960_j()));
         if(var2 == null) {
            var2 = PotionHelper.func_77917_b(p_77832_1_.func_77960_j(), false);
            this.field_77836_a.put(Integer.valueOf(p_77832_1_.func_77960_j()), var2);
         }

         return var2;
      }
   }

   public List func_77834_f(int p_77834_1_) {
      List var2 = (List)this.field_77836_a.get(Integer.valueOf(p_77834_1_));
      if(var2 == null) {
         var2 = PotionHelper.func_77917_b(p_77834_1_, false);
         this.field_77836_a.put(Integer.valueOf(p_77834_1_), var2);
      }

      return var2;
   }

   public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
      if(!p_77654_3_.field_71075_bZ.field_75098_d) {
         --p_77654_1_.field_77994_a;
      }

      if(!p_77654_2_.field_72995_K) {
         List var4 = this.func_77832_l(p_77654_1_);
         if(var4 != null) {
            Iterator var5 = var4.iterator();

            while(var5.hasNext()) {
               PotionEffect var6 = (PotionEffect)var5.next();
               p_77654_3_.func_70690_d(new PotionEffect(var6));
            }
         }
      }

      p_77654_3_.func_71029_a(StatList.field_75929_E[Item.func_150891_b(this)]);
      if(!p_77654_3_.field_71075_bZ.field_75098_d) {
         if(p_77654_1_.field_77994_a <= 0) {
            return new ItemStack(Items.field_151069_bo);
         }

         p_77654_3_.field_71071_by.func_70441_a(new ItemStack(Items.field_151069_bo));
      }

      return p_77654_1_;
   }

   public int func_77626_a(ItemStack p_77626_1_) {
      return 32;
   }

   public EnumAction func_77661_b(ItemStack p_77661_1_) {
      return EnumAction.DRINK;
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      if(func_77831_g(p_77659_1_.func_77960_j())) {
         if(!p_77659_3_.field_71075_bZ.field_75098_d) {
            --p_77659_1_.field_77994_a;
         }

         p_77659_2_.func_72956_a(p_77659_3_, "random.bow", 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
         if(!p_77659_2_.field_72995_K) {
            p_77659_2_.func_72838_d(new EntityPotion(p_77659_2_, p_77659_3_, p_77659_1_));
         }

         p_77659_3_.func_71029_a(StatList.field_75929_E[Item.func_150891_b(this)]);
         return p_77659_1_;
      } else {
         p_77659_3_.func_71008_a(p_77659_1_, this.func_77626_a(p_77659_1_));
         return p_77659_1_;
      }
   }

   public static boolean func_77831_g(int p_77831_0_) {
      return (p_77831_0_ & 16384) != 0;
   }

   public int func_77620_a(int p_77620_1_) {
      return PotionHelper.func_77915_a(p_77620_1_, false);
   }

   public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_) {
      return p_82790_2_ > 0?16777215:this.func_77620_a(p_82790_1_.func_77960_j());
   }

   public boolean func_77833_h(int p_77833_1_) {
      List var2 = this.func_77834_f(p_77833_1_);
      if(var2 != null && !var2.isEmpty()) {
         Iterator var3 = var2.iterator();

         PotionEffect var4;
         do {
            if(!var3.hasNext()) {
               return false;
            }

            var4 = (PotionEffect)var3.next();
         } while(!Potion.field_76425_a[var4.func_76456_a()].func_76403_b());

         return true;
      } else {
         return false;
      }
   }

   public String func_77653_i(ItemStack p_77653_1_) {
      if(p_77653_1_.func_77960_j() == 0) {
         return StatCollector.func_74838_a("item.emptyPotion.name").trim();
      } else {
         String var2 = "";
         if(func_77831_g(p_77653_1_.func_77960_j())) {
            var2 = StatCollector.func_74838_a("potion.prefix.grenade").trim() + " ";
         }

         List var3 = Items.field_151068_bn.func_77832_l(p_77653_1_);
         String var4;
         if(var3 != null && !var3.isEmpty()) {
            var4 = ((PotionEffect)var3.get(0)).func_76453_d();
            var4 = var4 + ".postfix";
            return var2 + StatCollector.func_74838_a(var4).trim();
         } else {
            var4 = PotionHelper.func_77905_c(p_77653_1_.func_77960_j());
            return StatCollector.func_74838_a(var4).trim() + " " + super.func_77653_i(p_77653_1_);
         }
      }
   }

   public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
      if(p_77624_1_.func_77960_j() != 0) {
         List var5 = Items.field_151068_bn.func_77832_l(p_77624_1_);
         HashMultimap var6 = HashMultimap.create();
         Iterator var16;
         if(var5 != null && !var5.isEmpty()) {
            var16 = var5.iterator();

            while(var16.hasNext()) {
               PotionEffect var8 = (PotionEffect)var16.next();
               String var9 = StatCollector.func_74838_a(var8.func_76453_d()).trim();
               Potion var10 = Potion.field_76425_a[var8.func_76456_a()];
               Map var11 = var10.func_111186_k();
               if(var11 != null && var11.size() > 0) {
                  Iterator var12 = var11.entrySet().iterator();

                  while(var12.hasNext()) {
                     Entry var13 = (Entry)var12.next();
                     AttributeModifier var14 = (AttributeModifier)var13.getValue();
                     AttributeModifier var15 = new AttributeModifier(var14.func_111166_b(), var10.func_111183_a(var8.func_76458_c(), var14), var14.func_111169_c());
                     var6.put(((IAttribute)var13.getKey()).func_111108_a(), var15);
                  }
               }

               if(var8.func_76458_c() > 0) {
                  var9 = var9 + " " + StatCollector.func_74838_a("potion.potency." + var8.func_76458_c()).trim();
               }

               if(var8.func_76459_b() > 20) {
                  var9 = var9 + " (" + Potion.func_76389_a(var8) + ")";
               }

               if(var10.func_76398_f()) {
                  p_77624_3_.add(EnumChatFormatting.RED + var9);
               } else {
                  p_77624_3_.add(EnumChatFormatting.GRAY + var9);
               }
            }
         } else {
            String var7 = StatCollector.func_74838_a("potion.empty").trim();
            p_77624_3_.add(EnumChatFormatting.GRAY + var7);
         }

         if(!var6.isEmpty()) {
            p_77624_3_.add("");
            p_77624_3_.add(EnumChatFormatting.DARK_PURPLE + StatCollector.func_74838_a("potion.effects.whenDrank"));
            var16 = var6.entries().iterator();

            while(var16.hasNext()) {
               Entry var17 = (Entry)var16.next();
               AttributeModifier var18 = (AttributeModifier)var17.getValue();
               double var19 = var18.func_111164_d();
               double var20;
               if(var18.func_111169_c() != 1 && var18.func_111169_c() != 2) {
                  var20 = var18.func_111164_d();
               } else {
                  var20 = var18.func_111164_d() * 100.0D;
               }

               if(var19 > 0.0D) {
                  p_77624_3_.add(EnumChatFormatting.BLUE + StatCollector.func_74837_a("attribute.modifier.plus." + var18.func_111169_c(), new Object[]{ItemStack.field_111284_a.format(var20), StatCollector.func_74838_a("attribute.name." + (String)var17.getKey())}));
               } else if(var19 < 0.0D) {
                  var20 *= -1.0D;
                  p_77624_3_.add(EnumChatFormatting.RED + StatCollector.func_74837_a("attribute.modifier.take." + var18.func_111169_c(), new Object[]{ItemStack.field_111284_a.format(var20), StatCollector.func_74838_a("attribute.name." + (String)var17.getKey())}));
               }
            }
         }

      }
   }

   public boolean func_77636_d(ItemStack p_77636_1_) {
      List var2 = this.func_77832_l(p_77636_1_);
      return var2 != null && !var2.isEmpty();
   }

   public void func_150895_a(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_) {
      super.func_150895_a(p_150895_1_, p_150895_2_, p_150895_3_);
      int var5;
      if(field_77835_b.isEmpty()) {
         for(int var4 = 0; var4 <= 15; ++var4) {
            for(var5 = 0; var5 <= 1; ++var5) {
               int var6;
               if(var5 == 0) {
                  var6 = var4 | 8192;
               } else {
                  var6 = var4 | 16384;
               }

               for(int var7 = 0; var7 <= 2; ++var7) {
                  int var8 = var6;
                  if(var7 != 0) {
                     if(var7 == 1) {
                        var8 = var6 | 32;
                     } else if(var7 == 2) {
                        var8 = var6 | 64;
                     }
                  }

                  List var9 = PotionHelper.func_77917_b(var8, false);
                  if(var9 != null && !var9.isEmpty()) {
                     field_77835_b.put(var9, Integer.valueOf(var8));
                  }
               }
            }
         }
      }

      Iterator var10 = field_77835_b.values().iterator();

      while(var10.hasNext()) {
         var5 = ((Integer)var10.next()).intValue();
         p_150895_3_.add(new ItemStack(p_150895_1_, 1, var5));
      }

   }

}
