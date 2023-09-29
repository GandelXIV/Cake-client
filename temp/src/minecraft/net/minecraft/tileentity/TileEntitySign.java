package net.minecraft.tileentity;

import com.google.gson.JsonParseException;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S33PacketUpdateSign;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentProcessor;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class TileEntitySign extends TileEntity {

   public final IChatComponent[] field_145915_a = new IChatComponent[]{new ChatComponentText(""), new ChatComponentText(""), new ChatComponentText(""), new ChatComponentText("")};
   public int field_145918_i = -1;
   private boolean field_145916_j = true;
   private EntityPlayer field_145917_k;
   private final CommandResultStats field_174883_i = new CommandResultStats();
   private static final String __OBFID = "CL_00000363";


   public void func_145841_b(NBTTagCompound p_145841_1_) {
      super.func_145841_b(p_145841_1_);

      for(int var2 = 0; var2 < 4; ++var2) {
         String var3 = IChatComponent.Serializer.func_150696_a(this.field_145915_a[var2]);
         p_145841_1_.func_74778_a("Text" + (var2 + 1), var3);
      }

      this.field_174883_i.func_179670_b(p_145841_1_);
   }

   public void func_145839_a(NBTTagCompound p_145839_1_) {
      this.field_145916_j = false;
      super.func_145839_a(p_145839_1_);
      ICommandSender var2 = new ICommandSender() {

         private static final String __OBFID = "CL_00002039";

         public String func_70005_c_() {
            return "Sign";
         }
         public IChatComponent func_145748_c_() {
            return new ChatComponentText(this.func_70005_c_());
         }
         public void func_145747_a(IChatComponent p_145747_1_) {}
         public boolean func_70003_b(int p_70003_1_, String p_70003_2_) {
            return true;
         }
         public BlockPos func_180425_c() {
            return TileEntitySign.this.field_174879_c;
         }
         public Vec3 func_174791_d() {
            return new Vec3((double)TileEntitySign.this.field_174879_c.func_177958_n() + 0.5D, (double)TileEntitySign.this.field_174879_c.func_177956_o() + 0.5D, (double)TileEntitySign.this.field_174879_c.func_177952_p() + 0.5D);
         }
         public World func_130014_f_() {
            return TileEntitySign.this.field_145850_b;
         }
         public Entity func_174793_f() {
            return null;
         }
         public boolean func_174792_t_() {
            return false;
         }
         public void func_174794_a(CommandResultStats.Type p_174794_1_, int p_174794_2_) {}
      };

      for(int var3 = 0; var3 < 4; ++var3) {
         String var4 = p_145839_1_.func_74779_i("Text" + (var3 + 1));

         try {
            IChatComponent var5 = IChatComponent.Serializer.func_150699_a(var4);

            try {
               this.field_145915_a[var3] = ChatComponentProcessor.func_179985_a(var2, var5, (Entity)null);
            } catch (CommandException var7) {
               this.field_145915_a[var3] = var5;
            }
         } catch (JsonParseException var8) {
            this.field_145915_a[var3] = new ChatComponentText(var4);
         }
      }

      this.field_174883_i.func_179668_a(p_145839_1_);
   }

   public Packet func_145844_m() {
      IChatComponent[] var1 = new IChatComponent[4];
      System.arraycopy(this.field_145915_a, 0, var1, 0, 4);
      return new S33PacketUpdateSign(this.field_145850_b, this.field_174879_c, var1);
   }

   public boolean func_145914_a() {
      return this.field_145916_j;
   }

   public void func_145913_a(boolean p_145913_1_) {
      this.field_145916_j = p_145913_1_;
      if(!p_145913_1_) {
         this.field_145917_k = null;
      }

   }

   public void func_145912_a(EntityPlayer p_145912_1_) {
      this.field_145917_k = p_145912_1_;
   }

   public EntityPlayer func_145911_b() {
      return this.field_145917_k;
   }

   public boolean func_174882_b(final EntityPlayer p_174882_1_) {
      ICommandSender var2 = new ICommandSender() {

         private static final String __OBFID = "CL_00002038";

         public String func_70005_c_() {
            return p_174882_1_.func_70005_c_();
         }
         public IChatComponent func_145748_c_() {
            return p_174882_1_.func_145748_c_();
         }
         public void func_145747_a(IChatComponent p_145747_1_) {}
         public boolean func_70003_b(int p_70003_1_, String p_70003_2_) {
            return true;
         }
         public BlockPos func_180425_c() {
            return TileEntitySign.this.field_174879_c;
         }
         public Vec3 func_174791_d() {
            return new Vec3((double)TileEntitySign.this.field_174879_c.func_177958_n() + 0.5D, (double)TileEntitySign.this.field_174879_c.func_177956_o() + 0.5D, (double)TileEntitySign.this.field_174879_c.func_177952_p() + 0.5D);
         }
         public World func_130014_f_() {
            return p_174882_1_.func_130014_f_();
         }
         public Entity func_174793_f() {
            return p_174882_1_;
         }
         public boolean func_174792_t_() {
            return false;
         }
         public void func_174794_a(CommandResultStats.Type p_174794_1_, int p_174794_2_) {
            TileEntitySign.this.field_174883_i.func_179672_a(this, p_174794_1_, p_174794_2_);
         }
      };

      for(int var3 = 0; var3 < this.field_145915_a.length; ++var3) {
         ChatStyle var4 = this.field_145915_a[var3] == null?null:this.field_145915_a[var3].func_150256_b();
         if(var4 != null && var4.func_150235_h() != null) {
            ClickEvent var5 = var4.func_150235_h();
            if(var5.func_150669_a() == ClickEvent.Action.RUN_COMMAND) {
               MinecraftServer.func_71276_C().func_71187_D().func_71556_a(var2, var5.func_150668_b());
            }
         }
      }

      return true;
   }

   public CommandResultStats func_174880_d() {
      return this.field_174883_i;
   }
}
