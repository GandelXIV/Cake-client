package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.CombatTracker;

public class S42PacketCombatEvent implements Packet {

   public S42PacketCombatEvent.Event field_179776_a;
   public int field_179774_b;
   public int field_179775_c;
   public int field_179772_d;
   public String field_179773_e;
   private static final String __OBFID = "CL_00002299";


   public S42PacketCombatEvent() {}

   public S42PacketCombatEvent(CombatTracker p_i45970_1_, S42PacketCombatEvent.Event p_i45970_2_) {
      this.field_179776_a = p_i45970_2_;
      EntityLivingBase var3 = p_i45970_1_.func_94550_c();
      switch(S42PacketCombatEvent.SwitchEvent.field_179944_a[p_i45970_2_.ordinal()]) {
      case 1:
         this.field_179772_d = p_i45970_1_.func_180134_f();
         this.field_179775_c = var3 == null?-1:var3.func_145782_y();
         break;
      case 2:
         this.field_179774_b = p_i45970_1_.func_180135_h().func_145782_y();
         this.field_179775_c = var3 == null?-1:var3.func_145782_y();
         this.field_179773_e = p_i45970_1_.func_151521_b().func_150260_c();
      }

   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_179776_a = (S42PacketCombatEvent.Event)p_148837_1_.func_179257_a(S42PacketCombatEvent.Event.class);
      if(this.field_179776_a == S42PacketCombatEvent.Event.END_COMBAT) {
         this.field_179772_d = p_148837_1_.func_150792_a();
         this.field_179775_c = p_148837_1_.readInt();
      } else if(this.field_179776_a == S42PacketCombatEvent.Event.ENTITY_DIED) {
         this.field_179774_b = p_148837_1_.func_150792_a();
         this.field_179775_c = p_148837_1_.readInt();
         this.field_179773_e = p_148837_1_.func_150789_c(32767);
      }

   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_179249_a(this.field_179776_a);
      if(this.field_179776_a == S42PacketCombatEvent.Event.END_COMBAT) {
         p_148840_1_.func_150787_b(this.field_179772_d);
         p_148840_1_.writeInt(this.field_179775_c);
      } else if(this.field_179776_a == S42PacketCombatEvent.Event.ENTITY_DIED) {
         p_148840_1_.func_150787_b(this.field_179774_b);
         p_148840_1_.writeInt(this.field_179775_c);
         p_148840_1_.func_180714_a(this.field_179773_e);
      }

   }

   public void func_179771_a(INetHandlerPlayClient p_179771_1_) {
      p_179771_1_.func_175098_a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_179771_a((INetHandlerPlayClient)p_148833_1_);
   }

   public static enum Event {

      ENTER_COMBAT("ENTER_COMBAT", 0),
      END_COMBAT("END_COMBAT", 1),
      ENTITY_DIED("ENTITY_DIED", 2);
      // $FF: synthetic field
      private static final S42PacketCombatEvent.Event[] $VALUES = new S42PacketCombatEvent.Event[]{ENTER_COMBAT, END_COMBAT, ENTITY_DIED};
      private static final String __OBFID = "CL_00002297";


      private Event(String p_i45969_1_, int p_i45969_2_) {}

   }

   // $FF: synthetic class
   static final class SwitchEvent {

      // $FF: synthetic field
      static final int[] field_179944_a = new int[S42PacketCombatEvent.Event.values().length];
      private static final String __OBFID = "CL_00002298";


      static {
         try {
            field_179944_a[S42PacketCombatEvent.Event.END_COMBAT.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_179944_a[S42PacketCombatEvent.Event.ENTITY_DIED.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
