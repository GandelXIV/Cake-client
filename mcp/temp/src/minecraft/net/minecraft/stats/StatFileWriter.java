package net.minecraft.stats;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.StatBase;
import net.minecraft.util.IJsonSerializable;
import net.minecraft.util.TupleIntJsonSerializable;

public class StatFileWriter {

   protected final Map field_150875_a = Maps.newConcurrentMap();
   private static final String __OBFID = "CL_00001481";


   public boolean func_77443_a(Achievement p_77443_1_) {
      return this.func_77444_a(p_77443_1_) > 0;
   }

   public boolean func_77442_b(Achievement p_77442_1_) {
      return p_77442_1_.field_75992_c == null || this.func_77443_a(p_77442_1_.field_75992_c);
   }

   public int func_150874_c(Achievement p_150874_1_) {
      if(this.func_77443_a(p_150874_1_)) {
         return 0;
      } else {
         int var2 = 0;

         for(Achievement var3 = p_150874_1_.field_75992_c; var3 != null && !this.func_77443_a(var3); ++var2) {
            var3 = var3.field_75992_c;
         }

         return var2;
      }
   }

   public void func_150871_b(EntityPlayer p_150871_1_, StatBase p_150871_2_, int p_150871_3_) {
      if(!p_150871_2_.func_75967_d() || this.func_77442_b((Achievement)p_150871_2_)) {
         this.func_150873_a(p_150871_1_, p_150871_2_, this.func_77444_a(p_150871_2_) + p_150871_3_);
      }
   }

   public void func_150873_a(EntityPlayer p_150873_1_, StatBase p_150873_2_, int p_150873_3_) {
      TupleIntJsonSerializable var4 = (TupleIntJsonSerializable)this.field_150875_a.get(p_150873_2_);
      if(var4 == null) {
         var4 = new TupleIntJsonSerializable();
         this.field_150875_a.put(p_150873_2_, var4);
      }

      var4.func_151188_a(p_150873_3_);
   }

   public int func_77444_a(StatBase p_77444_1_) {
      TupleIntJsonSerializable var2 = (TupleIntJsonSerializable)this.field_150875_a.get(p_77444_1_);
      return var2 == null?0:var2.func_151189_a();
   }

   public IJsonSerializable func_150870_b(StatBase p_150870_1_) {
      TupleIntJsonSerializable var2 = (TupleIntJsonSerializable)this.field_150875_a.get(p_150870_1_);
      return var2 != null?var2.func_151187_b():null;
   }

   public IJsonSerializable func_150872_a(StatBase p_150872_1_, IJsonSerializable p_150872_2_) {
      TupleIntJsonSerializable var3 = (TupleIntJsonSerializable)this.field_150875_a.get(p_150872_1_);
      if(var3 == null) {
         var3 = new TupleIntJsonSerializable();
         this.field_150875_a.put(p_150872_1_, var3);
      }

      var3.func_151190_a(p_150872_2_);
      return p_150872_2_;
   }
}
