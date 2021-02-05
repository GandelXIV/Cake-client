package net.minecraft.entity.ai;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.profiler.Profiler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityAITasks {

   private static final Logger field_151506_a = LogManager.getLogger();
   private List field_75782_a = Lists.newArrayList();
   private List field_75780_b = Lists.newArrayList();
   private final Profiler field_75781_c;
   private int field_75778_d;
   private int field_75779_e = 3;
   private static final String __OBFID = "CL_00001588";


   public EntityAITasks(Profiler p_i1628_1_) {
      this.field_75781_c = p_i1628_1_;
   }

   public void func_75776_a(int p_75776_1_, EntityAIBase p_75776_2_) {
      this.field_75782_a.add(new EntityAITasks.EntityAITaskEntry(p_75776_1_, p_75776_2_));
   }

   public void func_85156_a(EntityAIBase p_85156_1_) {
      Iterator var2 = this.field_75782_a.iterator();

      while(var2.hasNext()) {
         EntityAITasks.EntityAITaskEntry var3 = (EntityAITasks.EntityAITaskEntry)var2.next();
         EntityAIBase var4 = var3.field_75733_a;
         if(var4 == p_85156_1_) {
            if(this.field_75780_b.contains(var3)) {
               var4.func_75251_c();
               this.field_75780_b.remove(var3);
            }

            var2.remove();
         }
      }

   }

   public void func_75774_a() {
      this.field_75781_c.func_76320_a("goalSetup");
      Iterator var1;
      EntityAITasks.EntityAITaskEntry var2;
      if(this.field_75778_d++ % this.field_75779_e == 0) {
         var1 = this.field_75782_a.iterator();

         while(var1.hasNext()) {
            var2 = (EntityAITasks.EntityAITaskEntry)var1.next();
            boolean var3 = this.field_75780_b.contains(var2);
            if(var3) {
               if(this.func_75775_b(var2) && this.func_75773_a(var2)) {
                  continue;
               }

               var2.field_75733_a.func_75251_c();
               this.field_75780_b.remove(var2);
            }

            if(this.func_75775_b(var2) && var2.field_75733_a.func_75250_a()) {
               var2.field_75733_a.func_75249_e();
               this.field_75780_b.add(var2);
            }
         }
      } else {
         var1 = this.field_75780_b.iterator();

         while(var1.hasNext()) {
            var2 = (EntityAITasks.EntityAITaskEntry)var1.next();
            if(!this.func_75773_a(var2)) {
               var2.field_75733_a.func_75251_c();
               var1.remove();
            }
         }
      }

      this.field_75781_c.func_76319_b();
      this.field_75781_c.func_76320_a("goalTick");
      var1 = this.field_75780_b.iterator();

      while(var1.hasNext()) {
         var2 = (EntityAITasks.EntityAITaskEntry)var1.next();
         var2.field_75733_a.func_75246_d();
      }

      this.field_75781_c.func_76319_b();
   }

   private boolean func_75773_a(EntityAITasks.EntityAITaskEntry p_75773_1_) {
      boolean var2 = p_75773_1_.field_75733_a.func_75253_b();
      return var2;
   }

   private boolean func_75775_b(EntityAITasks.EntityAITaskEntry p_75775_1_) {
      Iterator var2 = this.field_75782_a.iterator();

      while(var2.hasNext()) {
         EntityAITasks.EntityAITaskEntry var3 = (EntityAITasks.EntityAITaskEntry)var2.next();
         if(var3 != p_75775_1_) {
            if(p_75775_1_.field_75731_b >= var3.field_75731_b) {
               if(!this.func_75777_a(p_75775_1_, var3) && this.field_75780_b.contains(var3)) {
                  return false;
               }
            } else if(!var3.field_75733_a.func_75252_g() && this.field_75780_b.contains(var3)) {
               return false;
            }
         }
      }

      return true;
   }

   private boolean func_75777_a(EntityAITasks.EntityAITaskEntry p_75777_1_, EntityAITasks.EntityAITaskEntry p_75777_2_) {
      return (p_75777_1_.field_75733_a.func_75247_h() & p_75777_2_.field_75733_a.func_75247_h()) == 0;
   }


   class EntityAITaskEntry {

      public EntityAIBase field_75733_a;
      public int field_75731_b;
      private static final String __OBFID = "CL_00001589";


      public EntityAITaskEntry(int p_i1627_2_, EntityAIBase p_i1627_3_) {
         this.field_75731_b = p_i1627_2_;
         this.field_75733_a = p_i1627_3_;
      }
   }
}
