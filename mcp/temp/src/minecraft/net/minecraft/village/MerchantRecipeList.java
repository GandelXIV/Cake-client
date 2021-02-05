package net.minecraft.village;

import java.io.IOException;
import java.util.ArrayList;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.PacketBuffer;
import net.minecraft.village.MerchantRecipe;

public class MerchantRecipeList extends ArrayList {

   private static final String __OBFID = "CL_00000127";


   public MerchantRecipeList() {}

   public MerchantRecipeList(NBTTagCompound p_i1944_1_) {
      this.func_77201_a(p_i1944_1_);
   }

   public MerchantRecipe func_77203_a(ItemStack p_77203_1_, ItemStack p_77203_2_, int p_77203_3_) {
      if(p_77203_3_ > 0 && p_77203_3_ < this.size()) {
         MerchantRecipe var6 = (MerchantRecipe)this.get(p_77203_3_);
         return ItemStack.func_179545_c(p_77203_1_, var6.func_77394_a()) && (p_77203_2_ == null && !var6.func_77398_c() || var6.func_77398_c() && ItemStack.func_179545_c(p_77203_2_, var6.func_77396_b())) && p_77203_1_.field_77994_a >= var6.func_77394_a().field_77994_a && (!var6.func_77398_c() || p_77203_2_.field_77994_a >= var6.func_77396_b().field_77994_a)?var6:null;
      } else {
         for(int var4 = 0; var4 < this.size(); ++var4) {
            MerchantRecipe var5 = (MerchantRecipe)this.get(var4);
            if(ItemStack.func_179545_c(p_77203_1_, var5.func_77394_a()) && p_77203_1_.field_77994_a >= var5.func_77394_a().field_77994_a && (!var5.func_77398_c() && p_77203_2_ == null || var5.func_77398_c() && ItemStack.func_179545_c(p_77203_2_, var5.func_77396_b()) && p_77203_2_.field_77994_a >= var5.func_77396_b().field_77994_a)) {
               return var5;
            }
         }

         return null;
      }
   }

   public void func_151391_a(PacketBuffer p_151391_1_) {
      p_151391_1_.writeByte((byte)(this.size() & 255));

      for(int var2 = 0; var2 < this.size(); ++var2) {
         MerchantRecipe var3 = (MerchantRecipe)this.get(var2);
         p_151391_1_.func_150788_a(var3.func_77394_a());
         p_151391_1_.func_150788_a(var3.func_77397_d());
         ItemStack var4 = var3.func_77396_b();
         p_151391_1_.writeBoolean(var4 != null);
         if(var4 != null) {
            p_151391_1_.func_150788_a(var4);
         }

         p_151391_1_.writeBoolean(var3.func_82784_g());
         p_151391_1_.writeInt(var3.func_180321_e());
         p_151391_1_.writeInt(var3.func_180320_f());
      }

   }

   public static MerchantRecipeList func_151390_b(PacketBuffer p_151390_0_) throws IOException {
      MerchantRecipeList var1 = new MerchantRecipeList();
      int var2 = p_151390_0_.readByte() & 255;

      for(int var3 = 0; var3 < var2; ++var3) {
         ItemStack var4 = p_151390_0_.func_150791_c();
         ItemStack var5 = p_151390_0_.func_150791_c();
         ItemStack var6 = null;
         if(p_151390_0_.readBoolean()) {
            var6 = p_151390_0_.func_150791_c();
         }

         boolean var7 = p_151390_0_.readBoolean();
         int var8 = p_151390_0_.readInt();
         int var9 = p_151390_0_.readInt();
         MerchantRecipe var10 = new MerchantRecipe(var4, var6, var5, var8, var9);
         if(var7) {
            var10.func_82785_h();
         }

         var1.add(var10);
      }

      return var1;
   }

   public void func_77201_a(NBTTagCompound p_77201_1_) {
      NBTTagList var2 = p_77201_1_.func_150295_c("Recipes", 10);

      for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
         NBTTagCompound var4 = var2.func_150305_b(var3);
         this.add(new MerchantRecipe(var4));
      }

   }

   public NBTTagCompound func_77202_a() {
      NBTTagCompound var1 = new NBTTagCompound();
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.size(); ++var3) {
         MerchantRecipe var4 = (MerchantRecipe)this.get(var3);
         var2.func_74742_a(var4.func_77395_g());
      }

      var1.func_74782_a("Recipes", var2);
      return var1;
   }
}
