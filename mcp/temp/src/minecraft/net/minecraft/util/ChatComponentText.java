package net.minecraft.util;

import java.util.Iterator;
import net.minecraft.util.ChatComponentStyle;
import net.minecraft.util.IChatComponent;

public class ChatComponentText extends ChatComponentStyle {

   private final String field_150267_b;
   private static final String __OBFID = "CL_00001269";


   public ChatComponentText(String p_i45159_1_) {
      this.field_150267_b = p_i45159_1_;
   }

   public String func_150265_g() {
      return this.field_150267_b;
   }

   public String func_150261_e() {
      return this.field_150267_b;
   }

   public ChatComponentText func_150259_f() {
      ChatComponentText var1 = new ChatComponentText(this.field_150267_b);
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
      } else if(!(p_equals_1_ instanceof ChatComponentText)) {
         return false;
      } else {
         ChatComponentText var2 = (ChatComponentText)p_equals_1_;
         return this.field_150267_b.equals(var2.func_150265_g()) && super.equals(p_equals_1_);
      }
   }

   public String toString() {
      return "TextComponent{text=\'" + this.field_150267_b + '\'' + ", siblings=" + this.field_150264_a + ", style=" + this.func_150256_b() + '}';
   }

   // $FF: synthetic method
   public IChatComponent func_150259_f() {
      return this.func_150259_f();
   }
}
