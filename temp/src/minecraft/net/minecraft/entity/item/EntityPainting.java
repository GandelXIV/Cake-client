package net.minecraft.entity.item;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class EntityPainting extends EntityHanging {

   public EntityPainting.EnumArt field_70522_e;
   private static final String __OBFID = "CL_00001556";


   public EntityPainting(World p_i1599_1_) {
      super(p_i1599_1_);
   }

   public EntityPainting(World p_i45849_1_, BlockPos p_i45849_2_, EnumFacing p_i45849_3_) {
      super(p_i45849_1_, p_i45849_2_);
      ArrayList var4 = Lists.newArrayList();
      EntityPainting.EnumArt[] var5 = EntityPainting.EnumArt.values();
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         EntityPainting.EnumArt var8 = var5[var7];
         this.field_70522_e = var8;
         this.func_174859_a(p_i45849_3_);
         if(this.func_70518_d()) {
            var4.add(var8);
         }
      }

      if(!var4.isEmpty()) {
         this.field_70522_e = (EntityPainting.EnumArt)var4.get(this.field_70146_Z.nextInt(var4.size()));
      }

      this.func_174859_a(p_i45849_3_);
   }

   public EntityPainting(World p_i45850_1_, BlockPos p_i45850_2_, EnumFacing p_i45850_3_, String p_i45850_4_) {
      this(p_i45850_1_, p_i45850_2_, p_i45850_3_);
      EntityPainting.EnumArt[] var5 = EntityPainting.EnumArt.values();
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         EntityPainting.EnumArt var8 = var5[var7];
         if(var8.field_75702_A.equals(p_i45850_4_)) {
            this.field_70522_e = var8;
            break;
         }
      }

      this.func_174859_a(p_i45850_3_);
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      p_70014_1_.func_74778_a("Motive", this.field_70522_e.field_75702_A);
      super.func_70014_b(p_70014_1_);
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      String var2 = p_70037_1_.func_74779_i("Motive");
      EntityPainting.EnumArt[] var3 = EntityPainting.EnumArt.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EntityPainting.EnumArt var6 = var3[var5];
         if(var6.field_75702_A.equals(var2)) {
            this.field_70522_e = var6;
         }
      }

      if(this.field_70522_e == null) {
         this.field_70522_e = EntityPainting.EnumArt.KEBAB;
      }

      super.func_70037_a(p_70037_1_);
   }

   public int func_82329_d() {
      return this.field_70522_e.field_75703_B;
   }

   public int func_82330_g() {
      return this.field_70522_e.field_75704_C;
   }

   public void func_110128_b(Entity p_110128_1_) {
      if(this.field_70170_p.func_82736_K().func_82766_b("doTileDrops")) {
         if(p_110128_1_ instanceof EntityPlayer) {
            EntityPlayer var2 = (EntityPlayer)p_110128_1_;
            if(var2.field_71075_bZ.field_75098_d) {
               return;
            }
         }

         this.func_70099_a(new ItemStack(Items.field_151159_an), 0.0F);
      }
   }

   public void func_70012_b(double p_70012_1_, double p_70012_3_, double p_70012_5_, float p_70012_7_, float p_70012_8_) {
      BlockPos var9 = new BlockPos(p_70012_1_ - this.field_70165_t, p_70012_3_ - this.field_70163_u, p_70012_5_ - this.field_70161_v);
      BlockPos var10 = this.field_174861_a.func_177971_a(var9);
      this.func_70107_b((double)var10.func_177958_n(), (double)var10.func_177956_o(), (double)var10.func_177952_p());
   }

   public void func_180426_a(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
      BlockPos var11 = new BlockPos(p_180426_1_ - this.field_70165_t, p_180426_3_ - this.field_70163_u, p_180426_5_ - this.field_70161_v);
      BlockPos var12 = this.field_174861_a.func_177971_a(var11);
      this.func_70107_b((double)var12.func_177958_n(), (double)var12.func_177956_o(), (double)var12.func_177952_p());
   }

   public static enum EnumArt {

      KEBAB("KEBAB", 0, "Kebab", 16, 16, 0, 0),
      AZTEC("AZTEC", 1, "Aztec", 16, 16, 16, 0),
      ALBAN("ALBAN", 2, "Alban", 16, 16, 32, 0),
      AZTEC_2("AZTEC_2", 3, "Aztec2", 16, 16, 48, 0),
      BOMB("BOMB", 4, "Bomb", 16, 16, 64, 0),
      PLANT("PLANT", 5, "Plant", 16, 16, 80, 0),
      WASTELAND("WASTELAND", 6, "Wasteland", 16, 16, 96, 0),
      POOL("POOL", 7, "Pool", 32, 16, 0, 32),
      COURBET("COURBET", 8, "Courbet", 32, 16, 32, 32),
      SEA("SEA", 9, "Sea", 32, 16, 64, 32),
      SUNSET("SUNSET", 10, "Sunset", 32, 16, 96, 32),
      CREEBET("CREEBET", 11, "Creebet", 32, 16, 128, 32),
      WANDERER("WANDERER", 12, "Wanderer", 16, 32, 0, 64),
      GRAHAM("GRAHAM", 13, "Graham", 16, 32, 16, 64),
      MATCH("MATCH", 14, "Match", 32, 32, 0, 128),
      BUST("BUST", 15, "Bust", 32, 32, 32, 128),
      STAGE("STAGE", 16, "Stage", 32, 32, 64, 128),
      VOID("VOID", 17, "Void", 32, 32, 96, 128),
      SKULL_AND_ROSES("SKULL_AND_ROSES", 18, "SkullAndRoses", 32, 32, 128, 128),
      WITHER("WITHER", 19, "Wither", 32, 32, 160, 128),
      FIGHTERS("FIGHTERS", 20, "Fighters", 64, 32, 0, 96),
      POINTER("POINTER", 21, "Pointer", 64, 64, 0, 192),
      PIGSCENE("PIGSCENE", 22, "Pigscene", 64, 64, 64, 192),
      BURNING_SKULL("BURNING_SKULL", 23, "BurningSkull", 64, 64, 128, 192),
      SKELETON("SKELETON", 24, "Skeleton", 64, 48, 192, 64),
      DONKEY_KONG("DONKEY_KONG", 25, "DonkeyKong", 64, 48, 192, 112);
      public static final int field_180001_A = "SkullAndRoses".length();
      public final String field_75702_A;
      public final int field_75703_B;
      public final int field_75704_C;
      public final int field_75699_D;
      public final int field_75700_E;
      // $FF: synthetic field
      private static final EntityPainting.EnumArt[] $VALUES = new EntityPainting.EnumArt[]{KEBAB, AZTEC, ALBAN, AZTEC_2, BOMB, PLANT, WASTELAND, POOL, COURBET, SEA, SUNSET, CREEBET, WANDERER, GRAHAM, MATCH, BUST, STAGE, VOID, SKULL_AND_ROSES, WITHER, FIGHTERS, POINTER, PIGSCENE, BURNING_SKULL, SKELETON, DONKEY_KONG};
      private static final String __OBFID = "CL_00001557";


      private EnumArt(String p_i1598_1_, int p_i1598_2_, String p_i1598_3_, int p_i1598_4_, int p_i1598_5_, int p_i1598_6_, int p_i1598_7_) {
         this.field_75702_A = p_i1598_3_;
         this.field_75703_B = p_i1598_4_;
         this.field_75704_C = p_i1598_5_;
         this.field_75699_D = p_i1598_6_;
         this.field_75700_E = p_i1598_7_;
      }

   }
}
