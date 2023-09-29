package net.minecraft.event;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.util.IChatComponent;

public class HoverEvent {

   private final HoverEvent.Action field_150704_a;
   private final IChatComponent field_150703_b;
   private static final String __OBFID = "CL_00001264";


   public HoverEvent(HoverEvent.Action p_i45158_1_, IChatComponent p_i45158_2_) {
      this.field_150704_a = p_i45158_1_;
      this.field_150703_b = p_i45158_2_;
   }

   public HoverEvent.Action func_150701_a() {
      return this.field_150704_a;
   }

   public IChatComponent func_150702_b() {
      return this.field_150703_b;
   }

   public boolean equals(Object p_equals_1_) {
      if(this == p_equals_1_) {
         return true;
      } else if(p_equals_1_ != null && this.getClass() == p_equals_1_.getClass()) {
         HoverEvent var2 = (HoverEvent)p_equals_1_;
         if(this.field_150704_a != var2.field_150704_a) {
            return false;
         } else {
            if(this.field_150703_b != null) {
               if(!this.field_150703_b.equals(var2.field_150703_b)) {
                  return false;
               }
            } else if(var2.field_150703_b != null) {
               return false;
            }

            return true;
         }
      } else {
         return false;
      }
   }

   public String toString() {
      return "HoverEvent{action=" + this.field_150704_a + ", value=\'" + this.field_150703_b + '\'' + '}';
   }

   public int hashCode() {
      int var1 = this.field_150704_a.hashCode();
      var1 = 31 * var1 + (this.field_150703_b != null?this.field_150703_b.hashCode():0);
      return var1;
   }

   public static enum Action {

      SHOW_TEXT("SHOW_TEXT", 0, "show_text", true),
      SHOW_ACHIEVEMENT("SHOW_ACHIEVEMENT", 1, "show_achievement", true),
      SHOW_ITEM("SHOW_ITEM", 2, "show_item", true),
      SHOW_ENTITY("SHOW_ENTITY", 3, "show_entity", true);
      private static final Map field_150690_d = Maps.newHashMap();
      private final boolean field_150691_e;
      private final String field_150688_f;
      // $FF: synthetic field
      private static final HoverEvent.Action[] $VALUES = new HoverEvent.Action[]{SHOW_TEXT, SHOW_ACHIEVEMENT, SHOW_ITEM, SHOW_ENTITY};
      private static final String __OBFID = "CL_00001265";


      private Action(String p_i45157_1_, int p_i45157_2_, String p_i45157_3_, boolean p_i45157_4_) {
         this.field_150688_f = p_i45157_3_;
         this.field_150691_e = p_i45157_4_;
      }

      public boolean func_150686_a() {
         return this.field_150691_e;
      }

      public String func_150685_b() {
         return this.field_150688_f;
      }

      public static HoverEvent.Action func_150684_a(String p_150684_0_) {
         return (HoverEvent.Action)field_150690_d.get(p_150684_0_);
      }

      static {
         HoverEvent.Action[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            HoverEvent.Action var3 = var0[var2];
            field_150690_d.put(var3.func_150685_b(), var3);
         }

      }
   }
}
