package net.minecraft.util;

import java.util.Iterator;
import net.minecraft.util.ChatComponentStyle;
import net.minecraft.util.IChatComponent;

public class ChatComponentSelector extends ChatComponentStyle {

   private final String field_179993_b;
   private static final String __OBFID = "CL_00002308";


   public ChatComponentSelector(String p_i45996_1_) {
      this.field_179993_b = p_i45996_1_;
   }

   public String func_179992_g() {
      return this.field_179993_b;
   }

   public String func_150261_e() {
      return this.field_179993_b;
   }

   public ChatComponentSelector func_179991_h() {
      ChatComponentSelector var1 = new ChatComponentSelector(this.field_179993_b);
      var1.func_150255_a(this.func_150256_b().func_150232_l());
      Iterator var2 = this.func_150253_a().iterator();

      while(var2.hasNext()) {
         IChatComponent var3 = (IChatComponent)var2.next();
         var1.func_150257_a(var3.func_150259_f());
      }

      return var1;
   }

   public boolean equals(Object p_equals_1_) {
      if(this == p_equals_1_) {
         return true;
      } else if(!(p_equals_1_ instanceof ChatComponentSelector)) {
         return false;
      } else {
         ChatComponentSelector var2 = (ChatComponentSelector)p_equals_1_;
         return this.field_179993_b.equals(var2.field_179993_b) && super.equals(p_equals_1_);
      }
   }

   public String toString() {
      return "SelectorComponent{pattern=\'" + this.field_179993_b + '\'' + ", siblings=" + this.field_150264_a + ", style=" + this.func_150256_b() + '}';
   }

   // $FF: synthetic method
   public IChatComponent func_150259_f() {
      return this.func_179991_h();
   }
}
