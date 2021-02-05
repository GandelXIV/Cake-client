package net.minecraft.tileentity;

import io.netty.buffer.ByteBuf;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.server.CommandBlockLogic;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class TileEntityCommandBlock extends TileEntity {

   private final CommandBlockLogic field_145994_a = new CommandBlockLogic() {

      private static final String __OBFID = "CL_00000348";

      public BlockPos func_180425_c() {
         return TileEntityCommandBlock.this.field_174879_c;
      }
      public Vec3 func_174791_d() {
         return new Vec3((double)TileEntityCommandBlock.this.field_174879_c.func_177958_n() + 0.5D, (double)TileEntityCommandBlock.this.field_174879_c.func_177956_o() + 0.5D, (double)TileEntityCommandBlock.this.field_174879_c.func_177952_p() + 0.5D);
      }
      public World func_130014_f_() {
         return TileEntityCommandBlock.this.func_145831_w();
      }
      public void func_145752_a(String p_145752_1_) {
         super.func_145752_a(p_145752_1_);
         TileEntityCommandBlock.this.func_70296_d();
      }
      public void func_145756_e() {
         TileEntityCommandBlock.this.func_145831_w().func_175689_h(TileEntityCommandBlock.this.field_174879_c);
      }
      public int func_145751_f() {
         return 0;
      }
      public void func_145757_a(ByteBuf p_145757_1_) {
         p_145757_1_.writeInt(TileEntityCommandBlock.this.field_174879_c.func_177958_n());
         p_145757_1_.writeInt(TileEntityCommandBlock.this.field_174879_c.func_177956_o());
         p_145757_1_.writeInt(TileEntityCommandBlock.this.field_174879_c.func_177952_p());
      }
      public Entity func_174793_f() {
         return null;
      }
   };
   private static final String __OBFID = "CL_00000347";


   public void func_145841_b(NBTTagCompound p_145841_1_) {
      super.func_145841_b(p_145841_1_);
      this.field_145994_a.func_145758_a(p_145841_1_);
   }

   public void func_145839_a(NBTTagCompound p_145839_1_) {
      super.func_145839_a(p_145839_1_);
      this.field_145994_a.func_145759_b(p_145839_1_);
   }

   public Packet func_145844_m() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.func_145841_b(var1);
      return new S35PacketUpdateTileEntity(this.field_174879_c, 2, var1);
   }

   public CommandBlockLogic func_145993_a() {
      return this.field_145994_a;
   }

   public CommandResultStats func_175124_c() {
      return this.field_145994_a.func_175572_n();
   }
}
