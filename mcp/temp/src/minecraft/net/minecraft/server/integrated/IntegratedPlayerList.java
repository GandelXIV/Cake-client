package net.minecraft.server.integrated;

import com.mojang.authlib.GameProfile;
import java.net.SocketAddress;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.management.ServerConfigurationManager;

public class IntegratedPlayerList extends ServerConfigurationManager {

   private NBTTagCompound field_72416_e;
   private static final String __OBFID = "CL_00001128";


   public IntegratedPlayerList(IntegratedServer p_i1314_1_) {
      super(p_i1314_1_);
      this.func_152611_a(10);
   }

   protected void func_72391_b(EntityPlayerMP p_72391_1_) {
      if(p_72391_1_.func_70005_c_().equals(this.func_180603_b().func_71214_G())) {
         this.field_72416_e = new NBTTagCompound();
         p_72391_1_.func_70109_d(this.field_72416_e);
      }

      super.func_72391_b(p_72391_1_);
   }

   public String func_148542_a(SocketAddress p_148542_1_, GameProfile p_148542_2_) {
      return p_148542_2_.getName().equalsIgnoreCase(this.func_180603_b().func_71214_G()) && this.func_152612_a(p_148542_2_.getName()) != null?"That name is already taken.":super.func_148542_a(p_148542_1_, p_148542_2_);
   }

   public IntegratedServer func_180603_b() {
      return (IntegratedServer)super.func_72365_p();
   }

   public NBTTagCompound func_72378_q() {
      return this.field_72416_e;
   }

   // $FF: synthetic method
   public MinecraftServer func_72365_p() {
      return this.func_180603_b();
   }
}
