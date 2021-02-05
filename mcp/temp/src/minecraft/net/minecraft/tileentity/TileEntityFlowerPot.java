package net.minecraft.tileentity;

import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityFlowerPot extends TileEntity {

   private Item field_145967_a;
   private int field_145968_i;
   private static final String __OBFID = "CL_00000356";


   public TileEntityFlowerPot() {}

   public TileEntityFlowerPot(Item p_i45442_1_, int p_i45442_2_) {
      this.field_145967_a = p_i45442_1_;
      this.field_145968_i = p_i45442_2_;
   }

   public void func_145841_b(NBTTagCompound p_145841_1_) {
      super.func_145841_b(p_145841_1_);
      ResourceLocation var2 = (ResourceLocation)Item.field_150901_e.func_177774_c(this.field_145967_a);
      p_145841_1_.func_74778_a("Item", var2 == null?"":var2.toString());
      p_145841_1_.func_74768_a("Data", this.field_145968_i);
   }

   public void func_145839_a(NBTTagCompound p_145839_1_) {
      super.func_145839_a(p_145839_1_);
      if(p_145839_1_.func_150297_b("Item", 8)) {
         this.field_145967_a = Item.func_111206_d(p_145839_1_.func_74779_i("Item"));
      } else {
         this.field_145967_a = Item.func_150899_d(p_145839_1_.func_74762_e("Item"));
      }

      this.field_145968_i = p_145839_1_.func_74762_e("Data");
   }

   public Packet func_145844_m() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.func_145841_b(var1);
      var1.func_82580_o("Item");
      var1.func_74768_a("Item", Item.func_150891_b(this.field_145967_a));
      return new S35PacketUpdateTileEntity(this.field_174879_c, 5, var1);
   }

   public void func_145964_a(Item p_145964_1_, int p_145964_2_) {
      this.field_145967_a = p_145964_1_;
      this.field_145968_i = p_145964_2_;
   }

   public Item func_145965_a() {
      return this.field_145967_a;
   }

   public int func_145966_b() {
      return this.field_145968_i;
   }
}
