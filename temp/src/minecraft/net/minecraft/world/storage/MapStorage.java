package net.minecraft.world.storage;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagShort;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.storage.ISaveHandler;

public class MapStorage {

   private ISaveHandler field_75751_a;
   protected Map field_75749_b = Maps.newHashMap();
   private List field_75750_c = Lists.newArrayList();
   private Map field_75748_d = Maps.newHashMap();
   private static final String __OBFID = "CL_00000604";


   public MapStorage(ISaveHandler p_i2162_1_) {
      this.field_75751_a = p_i2162_1_;
      this.func_75746_b();
   }

   public WorldSavedData func_75742_a(Class p_75742_1_, String p_75742_2_) {
      WorldSavedData var3 = (WorldSavedData)this.field_75749_b.get(p_75742_2_);
      if(var3 != null) {
         return var3;
      } else {
         if(this.field_75751_a != null) {
            try {
               File var4 = this.field_75751_a.func_75758_b(p_75742_2_);
               if(var4 != null && var4.exists()) {
                  try {
                     var3 = (WorldSavedData)p_75742_1_.getConstructor(new Class[]{String.class}).newInstance(new Object[]{p_75742_2_});
                  } catch (Exception var7) {
                     throw new RuntimeException("Failed to instantiate " + p_75742_1_.toString(), var7);
                  }

                  FileInputStream var5 = new FileInputStream(var4);
                  NBTTagCompound var6 = CompressedStreamTools.func_74796_a(var5);
                  var5.close();
                  var3.func_76184_a(var6.func_74775_l("data"));
               }
            } catch (Exception var8) {
               var8.printStackTrace();
            }
         }

         if(var3 != null) {
            this.field_75749_b.put(p_75742_2_, var3);
            this.field_75750_c.add(var3);
         }

         return var3;
      }
   }

   public void func_75745_a(String p_75745_1_, WorldSavedData p_75745_2_) {
      if(this.field_75749_b.containsKey(p_75745_1_)) {
         this.field_75750_c.remove(this.field_75749_b.remove(p_75745_1_));
      }

      this.field_75749_b.put(p_75745_1_, p_75745_2_);
      this.field_75750_c.add(p_75745_2_);
   }

   public void func_75744_a() {
      for(int var1 = 0; var1 < this.field_75750_c.size(); ++var1) {
         WorldSavedData var2 = (WorldSavedData)this.field_75750_c.get(var1);
         if(var2.func_76188_b()) {
            this.func_75747_a(var2);
            var2.func_76186_a(false);
         }
      }

   }

   private void func_75747_a(WorldSavedData p_75747_1_) {
      if(this.field_75751_a != null) {
         try {
            File var2 = this.field_75751_a.func_75758_b(p_75747_1_.field_76190_i);
            if(var2 != null) {
               NBTTagCompound var3 = new NBTTagCompound();
               p_75747_1_.func_76187_b(var3);
               NBTTagCompound var4 = new NBTTagCompound();
               var4.func_74782_a("data", var3);
               FileOutputStream var5 = new FileOutputStream(var2);
               CompressedStreamTools.func_74799_a(var4, var5);
               var5.close();
            }
         } catch (Exception var6) {
            var6.printStackTrace();
         }

      }
   }

   private void func_75746_b() {
      try {
         this.field_75748_d.clear();
         if(this.field_75751_a == null) {
            return;
         }

         File var1 = this.field_75751_a.func_75758_b("idcounts");
         if(var1 != null && var1.exists()) {
            DataInputStream var2 = new DataInputStream(new FileInputStream(var1));
            NBTTagCompound var3 = CompressedStreamTools.func_74794_a(var2);
            var2.close();
            Iterator var4 = var3.func_150296_c().iterator();

            while(var4.hasNext()) {
               String var5 = (String)var4.next();
               NBTBase var6 = var3.func_74781_a(var5);
               if(var6 instanceof NBTTagShort) {
                  NBTTagShort var7 = (NBTTagShort)var6;
                  short var9 = var7.func_150289_e();
                  this.field_75748_d.put(var5, Short.valueOf(var9));
               }
            }
         }
      } catch (Exception var10) {
         var10.printStackTrace();
      }

   }

   public int func_75743_a(String p_75743_1_) {
      Short var2 = (Short)this.field_75748_d.get(p_75743_1_);
      if(var2 == null) {
         var2 = Short.valueOf((short)0);
      } else {
         var2 = Short.valueOf((short)(var2.shortValue() + 1));
      }

      this.field_75748_d.put(p_75743_1_, var2);
      if(this.field_75751_a == null) {
         return var2.shortValue();
      } else {
         try {
            File var3 = this.field_75751_a.func_75758_b("idcounts");
            if(var3 != null) {
               NBTTagCompound var4 = new NBTTagCompound();
               Iterator var5 = this.field_75748_d.keySet().iterator();

               while(var5.hasNext()) {
                  String var6 = (String)var5.next();
                  short var7 = ((Short)this.field_75748_d.get(var6)).shortValue();
                  var4.func_74777_a(var6, var7);
               }

               DataOutputStream var9 = new DataOutputStream(new FileOutputStream(var3));
               CompressedStreamTools.func_74800_a(var4, var9);
               var9.close();
            }
         } catch (Exception var8) {
            var8.printStackTrace();
         }

         return var2.shortValue();
      }
   }
}
