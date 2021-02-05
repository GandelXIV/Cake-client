package net.minecraft.tileentity;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class TileEntityMobSpawner extends TileEntity implements IUpdatePlayerListBox {

   private final MobSpawnerBaseLogic field_145882_a = new MobSpawnerBaseLogic() {

      private static final String __OBFID = "CL_00000361";

      public void func_98267_a(int p_98267_1_) {
         TileEntityMobSpawner.this.field_145850_b.func_175641_c(TileEntityMobSpawner.this.field_174879_c, Blocks.field_150474_ac, p_98267_1_, 0);
      }
      public World func_98271_a() {
         return TileEntityMobSpawner.this.field_145850_b;
      }
      public BlockPos func_177221_b() {
         return TileEntityMobSpawner.this.field_174879_c;
      }
      public void func_98277_a(MobSpawnerBaseLogic.WeightedRandomMinecart p_98277_1_) {
         super.func_98277_a(p_98277_1_);
         if(this.func_98271_a() != null) {
            this.func_98271_a().func_175689_h(TileEntityMobSpawner.this.field_174879_c);
         }

      }
   };
   private static final String __OBFID = "CL_00000360";


   public void func_145839_a(NBTTagCompound p_145839_1_) {
      super.func_145839_a(p_145839_1_);
      this.field_145882_a.func_98270_a(p_145839_1_);
   }

   public void func_145841_b(NBTTagCompound p_145841_1_) {
      super.func_145841_b(p_145841_1_);
      this.field_145882_a.func_98280_b(p_145841_1_);
   }

   public void func_73660_a() {
      this.field_145882_a.func_98278_g();
   }

   public Packet func_145844_m() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.func_145841_b(var1);
      var1.func_82580_o("SpawnPotentials");
      return new S35PacketUpdateTileEntity(this.field_174879_c, 1, var1);
   }

   public boolean func_145842_c(int p_145842_1_, int p_145842_2_) {
      return this.field_145882_a.func_98268_b(p_145842_1_)?true:super.func_145842_c(p_145842_1_, p_145842_2_);
   }

   public MobSpawnerBaseLogic func_145881_a() {
      return this.field_145882_a;
   }
}
