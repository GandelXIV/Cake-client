package net.minecraft.world;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import net.minecraft.nbt.NBTTagCompound;

public class GameRules {

   private TreeMap field_82771_a = new TreeMap();
   private static final String __OBFID = "CL_00000136";


   public GameRules() {
      this.func_180262_a("doFireTick", "true", GameRules.ValueType.BOOLEAN_VALUE);
      this.func_180262_a("mobGriefing", "true", GameRules.ValueType.BOOLEAN_VALUE);
      this.func_180262_a("keepInventory", "false", GameRules.ValueType.BOOLEAN_VALUE);
      this.func_180262_a("doMobSpawning", "true", GameRules.ValueType.BOOLEAN_VALUE);
      this.func_180262_a("doMobLoot", "true", GameRules.ValueType.BOOLEAN_VALUE);
      this.func_180262_a("doTileDrops", "true", GameRules.ValueType.BOOLEAN_VALUE);
      this.func_180262_a("commandBlockOutput", "true", GameRules.ValueType.BOOLEAN_VALUE);
      this.func_180262_a("naturalRegeneration", "true", GameRules.ValueType.BOOLEAN_VALUE);
      this.func_180262_a("doDaylightCycle", "true", GameRules.ValueType.BOOLEAN_VALUE);
      this.func_180262_a("logAdminCommands", "true", GameRules.ValueType.BOOLEAN_VALUE);
      this.func_180262_a("showDeathMessages", "true", GameRules.ValueType.BOOLEAN_VALUE);
      this.func_180262_a("randomTickSpeed", "3", GameRules.ValueType.NUMERICAL_VALUE);
      this.func_180262_a("sendCommandFeedback", "true", GameRules.ValueType.BOOLEAN_VALUE);
      this.func_180262_a("reducedDebugInfo", "false", GameRules.ValueType.BOOLEAN_VALUE);
   }

   public void func_180262_a(String p_180262_1_, String p_180262_2_, GameRules.ValueType p_180262_3_) {
      this.field_82771_a.put(p_180262_1_, new GameRules.Value(p_180262_2_, p_180262_3_));
   }

   public void func_82764_b(String p_82764_1_, String p_82764_2_) {
      GameRules.Value var3 = (GameRules.Value)this.field_82771_a.get(p_82764_1_);
      if(var3 != null) {
         var3.func_82757_a(p_82764_2_);
      } else {
         this.func_180262_a(p_82764_1_, p_82764_2_, GameRules.ValueType.ANY_VALUE);
      }

   }

   public String func_82767_a(String p_82767_1_) {
      GameRules.Value var2 = (GameRules.Value)this.field_82771_a.get(p_82767_1_);
      return var2 != null?var2.func_82756_a():"";
   }

   public boolean func_82766_b(String p_82766_1_) {
      GameRules.Value var2 = (GameRules.Value)this.field_82771_a.get(p_82766_1_);
      return var2 != null?var2.func_82758_b():false;
   }

   public int func_180263_c(String p_180263_1_) {
      GameRules.Value var2 = (GameRules.Value)this.field_82771_a.get(p_180263_1_);
      return var2 != null?var2.func_180255_c():0;
   }

   public NBTTagCompound func_82770_a() {
      NBTTagCompound var1 = new NBTTagCompound();
      Iterator var2 = this.field_82771_a.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         GameRules.Value var4 = (GameRules.Value)this.field_82771_a.get(var3);
         var1.func_74778_a(var3, var4.func_82756_a());
      }

      return var1;
   }

   public void func_82768_a(NBTTagCompound p_82768_1_) {
      Set var2 = p_82768_1_.func_150296_c();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         String var6 = p_82768_1_.func_74779_i(var4);
         this.func_82764_b(var4, var6);
      }

   }

   public String[] func_82763_b() {
      return (String[])this.field_82771_a.keySet().toArray(new String[0]);
   }

   public boolean func_82765_e(String p_82765_1_) {
      return this.field_82771_a.containsKey(p_82765_1_);
   }

   public boolean func_180264_a(String p_180264_1_, GameRules.ValueType p_180264_2_) {
      GameRules.Value var3 = (GameRules.Value)this.field_82771_a.get(p_180264_1_);
      return var3 != null && (var3.func_180254_e() == p_180264_2_ || p_180264_2_ == GameRules.ValueType.ANY_VALUE);
   }

   static class Value {

      private String field_82762_a;
      private boolean field_82760_b;
      private int field_82761_c;
      private double field_82759_d;
      private final GameRules.ValueType field_180256_e;
      private static final String __OBFID = "CL_00000137";


      public Value(String p_i45751_1_, GameRules.ValueType p_i45751_2_) {
         this.field_180256_e = p_i45751_2_;
         this.func_82757_a(p_i45751_1_);
      }

      public void func_82757_a(String p_82757_1_) {
         this.field_82762_a = p_82757_1_;
         this.field_82760_b = Boolean.parseBoolean(p_82757_1_);
         this.field_82761_c = this.field_82760_b?1:0;

         try {
            this.field_82761_c = Integer.parseInt(p_82757_1_);
         } catch (NumberFormatException var4) {
            ;
         }

         try {
            this.field_82759_d = Double.parseDouble(p_82757_1_);
         } catch (NumberFormatException var3) {
            ;
         }

      }

      public String func_82756_a() {
         return this.field_82762_a;
      }

      public boolean func_82758_b() {
         return this.field_82760_b;
      }

      public int func_180255_c() {
         return this.field_82761_c;
      }

      public GameRules.ValueType func_180254_e() {
         return this.field_180256_e;
      }
   }

   public static enum ValueType {

      ANY_VALUE("ANY_VALUE", 0),
      BOOLEAN_VALUE("BOOLEAN_VALUE", 1),
      NUMERICAL_VALUE("NUMERICAL_VALUE", 2);
      // $FF: synthetic field
      private static final GameRules.ValueType[] $VALUES = new GameRules.ValueType[]{ANY_VALUE, BOOLEAN_VALUE, NUMERICAL_VALUE};
      private static final String __OBFID = "CL_00002151";


      private ValueType(String p_i45750_1_, int p_i45750_2_) {}

   }
}
