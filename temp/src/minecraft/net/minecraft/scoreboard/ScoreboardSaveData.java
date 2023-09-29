package net.minecraft.scoreboard;

import java.util.Collection;
import java.util.Iterator;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.scoreboard.IScoreObjectiveCriteria;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.WorldSavedData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ScoreboardSaveData extends WorldSavedData {

   private static final Logger field_151481_a = LogManager.getLogger();
   private Scoreboard field_96507_a;
   private NBTTagCompound field_96506_b;
   private static final String __OBFID = "CL_00000620";


   public ScoreboardSaveData() {
      this("scoreboard");
   }

   public ScoreboardSaveData(String p_i2310_1_) {
      super(p_i2310_1_);
   }

   public void func_96499_a(Scoreboard p_96499_1_) {
      this.field_96507_a = p_96499_1_;
      if(this.field_96506_b != null) {
         this.func_76184_a(this.field_96506_b);
      }

   }

   public void func_76184_a(NBTTagCompound p_76184_1_) {
      if(this.field_96507_a == null) {
         this.field_96506_b = p_76184_1_;
      } else {
         this.func_96501_b(p_76184_1_.func_150295_c("Objectives", 10));
         this.func_96500_c(p_76184_1_.func_150295_c("PlayerScores", 10));
         if(p_76184_1_.func_150297_b("DisplaySlots", 10)) {
            this.func_96504_c(p_76184_1_.func_74775_l("DisplaySlots"));
         }

         if(p_76184_1_.func_150297_b("Teams", 9)) {
            this.func_96498_a(p_76184_1_.func_150295_c("Teams", 10));
         }

      }
   }

   protected void func_96498_a(NBTTagList p_96498_1_) {
      for(int var2 = 0; var2 < p_96498_1_.func_74745_c(); ++var2) {
         NBTTagCompound var3 = p_96498_1_.func_150305_b(var2);
         ScorePlayerTeam var4 = this.field_96507_a.func_96527_f(var3.func_74779_i("Name"));
         var4.func_96664_a(var3.func_74779_i("DisplayName"));
         if(var3.func_150297_b("TeamColor", 8)) {
            var4.func_178774_a(EnumChatFormatting.func_96300_b(var3.func_74779_i("TeamColor")));
         }

         var4.func_96666_b(var3.func_74779_i("Prefix"));
         var4.func_96662_c(var3.func_74779_i("Suffix"));
         if(var3.func_150297_b("AllowFriendlyFire", 99)) {
            var4.func_96660_a(var3.func_74767_n("AllowFriendlyFire"));
         }

         if(var3.func_150297_b("SeeFriendlyInvisibles", 99)) {
            var4.func_98300_b(var3.func_74767_n("SeeFriendlyInvisibles"));
         }

         Team.EnumVisible var5;
         if(var3.func_150297_b("NameTagVisibility", 8)) {
            var5 = Team.EnumVisible.func_178824_a(var3.func_74779_i("NameTagVisibility"));
            if(var5 != null) {
               var4.func_178772_a(var5);
            }
         }

         if(var3.func_150297_b("DeathMessageVisibility", 8)) {
            var5 = Team.EnumVisible.func_178824_a(var3.func_74779_i("DeathMessageVisibility"));
            if(var5 != null) {
               var4.func_178773_b(var5);
            }
         }

         this.func_96502_a(var4, var3.func_150295_c("Players", 8));
      }

   }

   protected void func_96502_a(ScorePlayerTeam p_96502_1_, NBTTagList p_96502_2_) {
      for(int var3 = 0; var3 < p_96502_2_.func_74745_c(); ++var3) {
         this.field_96507_a.func_151392_a(p_96502_2_.func_150307_f(var3), p_96502_1_.func_96661_b());
      }

   }

   protected void func_96504_c(NBTTagCompound p_96504_1_) {
      for(int var2 = 0; var2 < 19; ++var2) {
         if(p_96504_1_.func_150297_b("slot_" + var2, 8)) {
            String var3 = p_96504_1_.func_74779_i("slot_" + var2);
            ScoreObjective var4 = this.field_96507_a.func_96518_b(var3);
            this.field_96507_a.func_96530_a(var2, var4);
         }
      }

   }

   protected void func_96501_b(NBTTagList p_96501_1_) {
      for(int var2 = 0; var2 < p_96501_1_.func_74745_c(); ++var2) {
         NBTTagCompound var3 = p_96501_1_.func_150305_b(var2);
         IScoreObjectiveCriteria var4 = (IScoreObjectiveCriteria)IScoreObjectiveCriteria.field_96643_a.get(var3.func_74779_i("CriteriaName"));
         if(var4 != null) {
            ScoreObjective var5 = this.field_96507_a.func_96535_a(var3.func_74779_i("Name"), var4);
            var5.func_96681_a(var3.func_74779_i("DisplayName"));
            var5.func_178767_a(IScoreObjectiveCriteria.EnumRenderType.func_178795_a(var3.func_74779_i("RenderType")));
         }
      }

   }

   protected void func_96500_c(NBTTagList p_96500_1_) {
      for(int var2 = 0; var2 < p_96500_1_.func_74745_c(); ++var2) {
         NBTTagCompound var3 = p_96500_1_.func_150305_b(var2);
         ScoreObjective var4 = this.field_96507_a.func_96518_b(var3.func_74779_i("Objective"));
         Score var5 = this.field_96507_a.func_96529_a(var3.func_74779_i("Name"), var4);
         var5.func_96647_c(var3.func_74762_e("Score"));
         if(var3.func_74764_b("Locked")) {
            var5.func_178815_a(var3.func_74767_n("Locked"));
         }
      }

   }

   public void func_76187_b(NBTTagCompound p_76187_1_) {
      if(this.field_96507_a == null) {
         field_151481_a.warn("Tried to save scoreboard without having a scoreboard...");
      } else {
         p_76187_1_.func_74782_a("Objectives", this.func_96505_b());
         p_76187_1_.func_74782_a("PlayerScores", this.func_96503_e());
         p_76187_1_.func_74782_a("Teams", this.func_96496_a());
         this.func_96497_d(p_76187_1_);
      }
   }

   protected NBTTagList func_96496_a() {
      NBTTagList var1 = new NBTTagList();
      Collection var2 = this.field_96507_a.func_96525_g();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         ScorePlayerTeam var4 = (ScorePlayerTeam)var3.next();
         NBTTagCompound var5 = new NBTTagCompound();
         var5.func_74778_a("Name", var4.func_96661_b());
         var5.func_74778_a("DisplayName", var4.func_96669_c());
         if(var4.func_178775_l().func_175746_b() >= 0) {
            var5.func_74778_a("TeamColor", var4.func_178775_l().func_96297_d());
         }

         var5.func_74778_a("Prefix", var4.func_96668_e());
         var5.func_74778_a("Suffix", var4.func_96663_f());
         var5.func_74757_a("AllowFriendlyFire", var4.func_96665_g());
         var5.func_74757_a("SeeFriendlyInvisibles", var4.func_98297_h());
         var5.func_74778_a("NameTagVisibility", var4.func_178770_i().field_178830_e);
         var5.func_74778_a("DeathMessageVisibility", var4.func_178771_j().field_178830_e);
         NBTTagList var6 = new NBTTagList();
         Iterator var7 = var4.func_96670_d().iterator();

         while(var7.hasNext()) {
            String var8 = (String)var7.next();
            var6.func_74742_a(new NBTTagString(var8));
         }

         var5.func_74782_a("Players", var6);
         var1.func_74742_a(var5);
      }

      return var1;
   }

   protected void func_96497_d(NBTTagCompound p_96497_1_) {
      NBTTagCompound var2 = new NBTTagCompound();
      boolean var3 = false;

      for(int var4 = 0; var4 < 19; ++var4) {
         ScoreObjective var5 = this.field_96507_a.func_96539_a(var4);
         if(var5 != null) {
            var2.func_74778_a("slot_" + var4, var5.func_96679_b());
            var3 = true;
         }
      }

      if(var3) {
         p_96497_1_.func_74782_a("DisplaySlots", var2);
      }

   }

   protected NBTTagList func_96505_b() {
      NBTTagList var1 = new NBTTagList();
      Collection var2 = this.field_96507_a.func_96514_c();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         ScoreObjective var4 = (ScoreObjective)var3.next();
         if(var4.func_96680_c() != null) {
            NBTTagCompound var5 = new NBTTagCompound();
            var5.func_74778_a("Name", var4.func_96679_b());
            var5.func_74778_a("CriteriaName", var4.func_96680_c().func_96636_a());
            var5.func_74778_a("DisplayName", var4.func_96678_d());
            var5.func_74778_a("RenderType", var4.func_178766_e().func_178796_a());
            var1.func_74742_a(var5);
         }
      }

      return var1;
   }

   protected NBTTagList func_96503_e() {
      NBTTagList var1 = new NBTTagList();
      Collection var2 = this.field_96507_a.func_96528_e();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         Score var4 = (Score)var3.next();
         if(var4.func_96645_d() != null) {
            NBTTagCompound var5 = new NBTTagCompound();
            var5.func_74778_a("Name", var4.func_96653_e());
            var5.func_74778_a("Objective", var4.func_96645_d().func_96679_b());
            var5.func_74768_a("Score", var4.func_96652_c());
            var5.func_74757_a("Locked", var4.func_178816_g());
            var1.func_74742_a(var5);
         }
      }

      return var1;
   }

}
