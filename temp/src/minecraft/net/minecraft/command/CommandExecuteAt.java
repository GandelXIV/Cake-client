package net.minecraft.command;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class CommandExecuteAt extends CommandBase {

   private static final String __OBFID = "CL_00002344";


   public String func_71517_b() {
      return "execute";
   }

   public int func_82362_a() {
      return 2;
   }

   public String func_71518_a(ICommandSender p_71518_1_) {
      return "commands.execute.usage";
   }

   public void func_71515_b(final ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
      if(p_71515_2_.length < 5) {
         throw new WrongUsageException("commands.execute.usage", new Object[0]);
      } else {
         final Entity var3 = func_175759_a(p_71515_1_, p_71515_2_[0], Entity.class);
         final double var4 = func_175761_b(var3.field_70165_t, p_71515_2_[1], false);
         final double var6 = func_175761_b(var3.field_70163_u, p_71515_2_[2], false);
         final double var8 = func_175761_b(var3.field_70161_v, p_71515_2_[3], false);
         final BlockPos var10 = new BlockPos(var4, var6, var8);
         byte var11 = 4;
         if("detect".equals(p_71515_2_[4]) && p_71515_2_.length > 10) {
            World var12 = p_71515_1_.func_130014_f_();
            double var13 = func_175761_b(var4, p_71515_2_[5], false);
            double var15 = func_175761_b(var6, p_71515_2_[6], false);
            double var17 = func_175761_b(var8, p_71515_2_[7], false);
            Block var19 = func_147180_g(p_71515_1_, p_71515_2_[8]);
            int var20 = func_175764_a(p_71515_2_[9], -1, 15);
            BlockPos var21 = new BlockPos(var13, var15, var17);
            IBlockState var22 = var12.func_180495_p(var21);
            if(var22.func_177230_c() != var19 || var20 >= 0 && var22.func_177230_c().func_176201_c(var22) != var20) {
               throw new CommandException("commands.execute.failed", new Object[]{"detect", var3.func_70005_c_()});
            }

            var11 = 10;
         }

         String var24 = func_180529_a(p_71515_2_, var11);
         ICommandSender var14 = new ICommandSender() {

            private static final String __OBFID = "CL_00002343";

            public String func_70005_c_() {
               return var3.func_70005_c_();
            }
            public IChatComponent func_145748_c_() {
               return var3.func_145748_c_();
            }
            public void func_145747_a(IChatComponent p_145747_1_) {
               p_71515_1_.func_145747_a(p_145747_1_);
            }
            public boolean func_70003_b(int p_70003_1_, String p_70003_2_) {
               return p_71515_1_.func_70003_b(p_70003_1_, p_70003_2_);
            }
            public BlockPos func_180425_c() {
               return var10;
            }
            public Vec3 func_174791_d() {
               return new Vec3(var4, var6, var8);
            }
            public World func_130014_f_() {
               return var3.field_70170_p;
            }
            public Entity func_174793_f() {
               return var3;
            }
            public boolean func_174792_t_() {
               MinecraftServer var1 = MinecraftServer.func_71276_C();
               return var1 == null || var1.field_71305_c[0].func_82736_K().func_82766_b("commandBlockOutput");
            }
            public void func_174794_a(CommandResultStats.Type p_174794_1_, int p_174794_2_) {
               var3.func_174794_a(p_174794_1_, p_174794_2_);
            }
         };
         ICommandManager var25 = MinecraftServer.func_71276_C().func_71187_D();

         try {
            int var16 = var25.func_71556_a(var14, var24);
            if(var16 < 1) {
               throw new CommandException("commands.execute.allInvocationsFailed", new Object[]{var24});
            }
         } catch (Throwable var23) {
            throw new CommandException("commands.execute.failed", new Object[]{var24, var3.func_70005_c_()});
         }
      }
   }

   public List func_180525_a(ICommandSender p_180525_1_, String[] p_180525_2_, BlockPos p_180525_3_) {
      return p_180525_2_.length == 1?func_71530_a(p_180525_2_, MinecraftServer.func_71276_C().func_71213_z()):(p_180525_2_.length > 1 && p_180525_2_.length <= 4?func_175771_a(p_180525_2_, 1, p_180525_3_):(p_180525_2_.length > 5 && p_180525_2_.length <= 8 && "detect".equals(p_180525_2_[4])?func_175771_a(p_180525_2_, 5, p_180525_3_):(p_180525_2_.length == 9 && "detect".equals(p_180525_2_[4])?func_175762_a(p_180525_2_, Block.field_149771_c.func_148742_b()):null)));
   }

   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
      return p_82358_2_ == 0;
   }
}
