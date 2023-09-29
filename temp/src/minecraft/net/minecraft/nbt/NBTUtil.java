package net.minecraft.nbt;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.StringUtils;

public final class NBTUtil {

   private static final String __OBFID = "CL_00001901";


   public static GameProfile func_152459_a(NBTTagCompound p_152459_0_) {
      String var1 = null;
      String var2 = null;
      if(p_152459_0_.func_150297_b("Name", 8)) {
         var1 = p_152459_0_.func_74779_i("Name");
      }

      if(p_152459_0_.func_150297_b("Id", 8)) {
         var2 = p_152459_0_.func_74779_i("Id");
      }

      if(StringUtils.func_151246_b(var1) && StringUtils.func_151246_b(var2)) {
         return null;
      } else {
         UUID var3;
         try {
            var3 = UUID.fromString(var2);
         } catch (Throwable var12) {
            var3 = null;
         }

         GameProfile var4 = new GameProfile(var3, var1);
         if(p_152459_0_.func_150297_b("Properties", 10)) {
            NBTTagCompound var5 = p_152459_0_.func_74775_l("Properties");
            Iterator var6 = var5.func_150296_c().iterator();

            while(var6.hasNext()) {
               String var7 = (String)var6.next();
               NBTTagList var8 = var5.func_150295_c(var7, 10);

               for(int var9 = 0; var9 < var8.func_74745_c(); ++var9) {
                  NBTTagCompound var10 = var8.func_150305_b(var9);
                  String var11 = var10.func_74779_i("Value");
                  if(var10.func_150297_b("Signature", 8)) {
                     var4.getProperties().put(var7, new Property(var7, var11, var10.func_74779_i("Signature")));
                  } else {
                     var4.getProperties().put(var7, new Property(var7, var11));
                  }
               }
            }
         }

         return var4;
      }
   }

   public static NBTTagCompound func_180708_a(NBTTagCompound p_180708_0_, GameProfile p_180708_1_) {
      if(!StringUtils.func_151246_b(p_180708_1_.getName())) {
         p_180708_0_.func_74778_a("Name", p_180708_1_.getName());
      }

      if(p_180708_1_.getId() != null) {
         p_180708_0_.func_74778_a("Id", p_180708_1_.getId().toString());
      }

      if(!p_180708_1_.getProperties().isEmpty()) {
         NBTTagCompound var2 = new NBTTagCompound();
         Iterator var3 = p_180708_1_.getProperties().keySet().iterator();

         while(var3.hasNext()) {
            String var4 = (String)var3.next();
            NBTTagList var5 = new NBTTagList();

            NBTTagCompound var8;
            for(Iterator var6 = p_180708_1_.getProperties().get(var4).iterator(); var6.hasNext(); var5.func_74742_a(var8)) {
               Property var7 = (Property)var6.next();
               var8 = new NBTTagCompound();
               var8.func_74778_a("Value", var7.getValue());
               if(var7.hasSignature()) {
                  var8.func_74778_a("Signature", var7.getSignature());
               }
            }

            var2.func_74782_a(var4, var5);
         }

         p_180708_0_.func_74782_a("Properties", var2);
      }

      return p_180708_0_;
   }
}
