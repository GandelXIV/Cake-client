package net.minecraft.tileentity;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockJukebox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.tileentity.TileEntityComparator;
import net.minecraft.tileentity.TileEntityDaylightDetector;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityDropper;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.tileentity.TileEntityEndPortal;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.tileentity.TileEntityNote;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class TileEntity {

   private static final Logger field_145852_a = LogManager.getLogger();
   private static Map field_145855_i = Maps.newHashMap();
   private static Map field_145853_j = Maps.newHashMap();
   protected World field_145850_b;
   protected BlockPos field_174879_c;
   protected boolean field_145846_f;
   private int field_145847_g;
   protected Block field_145854_h;
   private static final String __OBFID = "CL_00000340";


   public TileEntity() {
      this.field_174879_c = BlockPos.field_177992_a;
      this.field_145847_g = -1;
   }

   private static void func_145826_a(Class p_145826_0_, String p_145826_1_) {
      if(field_145855_i.containsKey(p_145826_1_)) {
         throw new IllegalArgumentException("Duplicate id: " + p_145826_1_);
      } else {
         field_145855_i.put(p_145826_1_, p_145826_0_);
         field_145853_j.put(p_145826_0_, p_145826_1_);
      }
   }

   public World func_145831_w() {
      return this.field_145850_b;
   }

   public void func_145834_a(World p_145834_1_) {
      this.field_145850_b = p_145834_1_;
   }

   public boolean func_145830_o() {
      return this.field_145850_b != null;
   }

   public void func_145839_a(NBTTagCompound p_145839_1_) {
      this.field_174879_c = new BlockPos(p_145839_1_.func_74762_e("x"), p_145839_1_.func_74762_e("y"), p_145839_1_.func_74762_e("z"));
   }

   public void func_145841_b(NBTTagCompound p_145841_1_) {
      String var2 = (String)field_145853_j.get(this.getClass());
      if(var2 == null) {
         throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
      } else {
         p_145841_1_.func_74778_a("id", var2);
         p_145841_1_.func_74768_a("x", this.field_174879_c.func_177958_n());
         p_145841_1_.func_74768_a("y", this.field_174879_c.func_177956_o());
         p_145841_1_.func_74768_a("z", this.field_174879_c.func_177952_p());
      }
   }

   public static TileEntity func_145827_c(NBTTagCompound p_145827_0_) {
      TileEntity var1 = null;

      try {
         Class var2 = (Class)field_145855_i.get(p_145827_0_.func_74779_i("id"));
         if(var2 != null) {
            var1 = (TileEntity)var2.newInstance();
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      if(var1 != null) {
         var1.func_145839_a(p_145827_0_);
      } else {
         field_145852_a.warn("Skipping BlockEntity with id " + p_145827_0_.func_74779_i("id"));
      }

      return var1;
   }

   public int func_145832_p() {
      if(this.field_145847_g == -1) {
         IBlockState var1 = this.field_145850_b.func_180495_p(this.field_174879_c);
         this.field_145847_g = var1.func_177230_c().func_176201_c(var1);
      }

      return this.field_145847_g;
   }

   public void func_70296_d() {
      if(this.field_145850_b != null) {
         IBlockState var1 = this.field_145850_b.func_180495_p(this.field_174879_c);
         this.field_145847_g = var1.func_177230_c().func_176201_c(var1);
         this.field_145850_b.func_175646_b(this.field_174879_c, this);
         if(this.func_145838_q() != Blocks.field_150350_a) {
            this.field_145850_b.func_175666_e(this.field_174879_c, this.func_145838_q());
         }
      }

   }

   public double func_145835_a(double p_145835_1_, double p_145835_3_, double p_145835_5_) {
      double var7 = (double)this.field_174879_c.func_177958_n() + 0.5D - p_145835_1_;
      double var9 = (double)this.field_174879_c.func_177956_o() + 0.5D - p_145835_3_;
      double var11 = (double)this.field_174879_c.func_177952_p() + 0.5D - p_145835_5_;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public double func_145833_n() {
      return 4096.0D;
   }

   public BlockPos func_174877_v() {
      return this.field_174879_c;
   }

   public Block func_145838_q() {
      if(this.field_145854_h == null) {
         this.field_145854_h = this.field_145850_b.func_180495_p(this.field_174879_c).func_177230_c();
      }

      return this.field_145854_h;
   }

   public Packet func_145844_m() {
      return null;
   }

   public boolean func_145837_r() {
      return this.field_145846_f;
   }

   public void func_145843_s() {
      this.field_145846_f = true;
   }

   public void func_145829_t() {
      this.field_145846_f = false;
   }

   public boolean func_145842_c(int p_145842_1_, int p_145842_2_) {
      return false;
   }

   public void func_145836_u() {
      this.field_145854_h = null;
      this.field_145847_g = -1;
   }

   public void func_145828_a(CrashReportCategory p_145828_1_) {
      p_145828_1_.func_71500_a("Name", new Callable() {

         private static final String __OBFID = "CL_00000341";

         public String call() {
            return (String)TileEntity.field_145853_j.get(TileEntity.this.getClass()) + " // " + TileEntity.this.getClass().getCanonicalName();
         }
         // $FF: synthetic method
         public Object call() {
            return this.call();
         }
      });
      if(this.field_145850_b != null) {
         CrashReportCategory.func_180523_a(p_145828_1_, this.field_174879_c, this.func_145838_q(), this.func_145832_p());
         p_145828_1_.func_71500_a("Actual block type", new Callable() {

            private static final String __OBFID = "CL_00000343";

            public String call() {
               int var1 = Block.func_149682_b(TileEntity.this.field_145850_b.func_180495_p(TileEntity.this.field_174879_c).func_177230_c());

               try {
                  return String.format("ID #%d (%s // %s)", new Object[]{Integer.valueOf(var1), Block.func_149729_e(var1).func_149739_a(), Block.func_149729_e(var1).getClass().getCanonicalName()});
               } catch (Throwable var3) {
                  return "ID #" + var1;
               }
            }
            // $FF: synthetic method
            public Object call() {
               return this.call();
            }
         });
         p_145828_1_.func_71500_a("Actual block data value", new Callable() {

            private static final String __OBFID = "CL_00000344";

            public String call() {
               IBlockState var1 = TileEntity.this.field_145850_b.func_180495_p(TileEntity.this.field_174879_c);
               int var2 = var1.func_177230_c().func_176201_c(var1);
               if(var2 < 0) {
                  return "Unknown? (Got " + var2 + ")";
               } else {
                  String var3 = String.format("%4s", new Object[]{Integer.toBinaryString(var2)}).replace(" ", "0");
                  return String.format("%1$d / 0x%1$X / 0b%2$s", new Object[]{Integer.valueOf(var2), var3});
               }
            }
            // $FF: synthetic method
            public Object call() {
               return this.call();
            }
         });
      }
   }

   public void func_174878_a(BlockPos p_174878_1_) {
      this.field_174879_c = p_174878_1_;
   }

   static {
      func_145826_a(TileEntityFurnace.class, "Furnace");
      func_145826_a(TileEntityChest.class, "Chest");
      func_145826_a(TileEntityEnderChest.class, "EnderChest");
      func_145826_a(BlockJukebox.TileEntityJukebox.class, "RecordPlayer");
      func_145826_a(TileEntityDispenser.class, "Trap");
      func_145826_a(TileEntityDropper.class, "Dropper");
      func_145826_a(TileEntitySign.class, "Sign");
      func_145826_a(TileEntityMobSpawner.class, "MobSpawner");
      func_145826_a(TileEntityNote.class, "Music");
      func_145826_a(TileEntityPiston.class, "Piston");
      func_145826_a(TileEntityBrewingStand.class, "Cauldron");
      func_145826_a(TileEntityEnchantmentTable.class, "EnchantTable");
      func_145826_a(TileEntityEndPortal.class, "Airportal");
      func_145826_a(TileEntityCommandBlock.class, "Control");
      func_145826_a(TileEntityBeacon.class, "Beacon");
      func_145826_a(TileEntitySkull.class, "Skull");
      func_145826_a(TileEntityDaylightDetector.class, "DLDetector");
      func_145826_a(TileEntityHopper.class, "Hopper");
      func_145826_a(TileEntityComparator.class, "Comparator");
      func_145826_a(TileEntityFlowerPot.class, "FlowerPot");
      func_145826_a(TileEntityBanner.class, "Banner");
   }
}
