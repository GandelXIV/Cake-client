package net.minecraft.util;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public abstract class ChatComponentStyle implements IChatComponent {

   protected List field_150264_a = Lists.newArrayList();
   private ChatStyle field_150263_b;
   private static final String __OBFID = "CL_00001257";


   public IChatComponent func_150257_a(IChatComponent p_150257_1_) {
      p_150257_1_.func_150256_b().func_150221_a(this.func_150256_b());
      this.field_150264_a.add(p_150257_1_);
      return this;
   }

   public List func_150253_a() {
      return this.field_150264_a;
   }

   public IChatComponent func_150258_a(String p_150258_1_) {
      return this.func_150257_a(new ChatComponentText(p_150258_1_));
   }

   public IChatComponent func_150255_a(ChatStyle p_150255_1_) {
      this.field_150263_b = p_150255_1_;
      Iterator var2 = this.field_150264_a.iterator();

      while(var2.hasNext()) {
         IChatComponent var3 = (IChatComponent)var2.next();
         var3.func_150256_b().func_150221_a(this.func_150256_b());
      }

      return this;
   }

   public ChatStyle func_150256_b() {
      if(this.field_150263_b == null) {
         this.field_150263_b = new ChatStyle();
         Iterator var1 = this.field_150264_a.iterator();

         while(var1.hasNext()) {
            IChatComponent var2 = (IChatComponent)var1.next();
            var2.func_150256_b().func_150221_a(this.field_150263_b);
         }
      }

      return this.field_150263_b;
   }

   public Iterator iterator() {
      return Iterators.concat(Iterators.forArray(new ChatComponentStyle[]{this}), func_150262_a(this.field_150264_a));
   }

   public final String func_150260_c() {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = this.iterator();

      while(var2.hasNext()) {
         IChatComponent var3 = (IChatComponent)var2.next();
         var1.append(var3.func_150261_e());
      }

      return var1.toString();
   }

   public final String func_150254_d() {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = this.iterator();

      while(var2.hasNext()) {
         IChatComponent var3 = (IChatComponent)var2.next();
         var1.append(var3.func_150256_b().func_150218_j());
         var1.append(var3.func_150261_e());
         var1.append(EnumChatFormatting.RESET);
      }

      return var1.toString();
   }

   public static Iterator func_150262_a(Iterable p_150262_0_) {
      Iterator var1 = Iterators.concat(Iterators.transform(p_150262_0_.iterator(), new Function() {

         private static final String __OBFID = "CL_00001258";

         public Iterator apply(IChatComponent p_apply_1_) {
            return p_apply_1_.iterator();
         }
         // $FF: synthetic method
         public Object apply(Object p_apply_1_) {
            return this.apply((IChatComponent)p_apply_1_);
         }
      }));
      var1 = Iterators.transform(var1, new Function() {

         private static final String __OBFID = "CL_00001259";

         public IChatComponent apply(IChatComponent p_apply_1_) {
            IChatComponent var2 = p_apply_1_.func_150259_f();
            var2.func_150255_a(var2.func_150256_b().func_150206_m());
            return var2;
         }
         // $FF: synthetic method
         public Object apply(Object p_apply_1_) {
            return this.apply((IChatComponent)p_apply_1_);
         }
      });
      return var1;
   }

   public boolean equals(Object p_equals_1_) {
      if(this == p_equals_1_) {
         return true;
      } else if(!(p_equals_1_ instanceof ChatComponentStyle)) {
         return false;
      } else {
         ChatComponentStyle var2 = (ChatComponentStyle)p_equals_1_;
         return this.field_150264_a.equals(var2.field_150264_a) && this.func_150256_b().equals(var2.func_150256_b());
      }
   }

   public int hashCode() {
      return 31 * this.field_150263_b.hashCode() + this.field_150264_a.hashCode();
   }

   public String toString() {
      return "BaseComponent{style=" + this.field_150263_b + ", siblings=" + this.field_150264_a + '}';
   }
}
