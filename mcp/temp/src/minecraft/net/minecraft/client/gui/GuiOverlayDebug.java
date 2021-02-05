package net.minecraft.client.gui;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.Chunk;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class GuiOverlayDebug extends Gui {

   private final Minecraft field_175242_a;
   private final FontRenderer field_175241_f;
   private static final String __OBFID = "CL_00001956";


   public GuiOverlayDebug(Minecraft p_i45543_1_) {
      this.field_175242_a = p_i45543_1_;
      this.field_175241_f = p_i45543_1_.field_71466_p;
   }

   public void func_175237_a(ScaledResolution p_175237_1_) {
      this.field_175242_a.field_71424_I.func_76320_a("debug");
      GlStateManager.func_179094_E();
      this.func_180798_a();
      this.func_175239_b(p_175237_1_);
      GlStateManager.func_179121_F();
      this.field_175242_a.field_71424_I.func_76319_b();
   }

   private boolean func_175236_d() {
      return this.field_175242_a.field_71439_g.func_175140_cp() || this.field_175242_a.field_71474_y.field_178879_v;
   }

   protected void func_180798_a() {
      List var1 = this.call();

      for(int var2 = 0; var2 < var1.size(); ++var2) {
         String var3 = (String)var1.get(var2);
         if(!Strings.isNullOrEmpty(var3)) {
            int var4 = this.field_175241_f.field_78288_b;
            int var5 = this.field_175241_f.func_78256_a(var3);
            boolean var6 = true;
            int var7 = 2 + var4 * var2;
            func_73734_a(1, var7 - 1, 2 + var5 + 1, var7 + var4 - 1, -1873784752);
            this.field_175241_f.func_78276_b(var3, 2, var7, 14737632);
         }
      }

   }

   protected void func_175239_b(ScaledResolution p_175239_1_) {
      List var2 = this.func_175238_c();

      for(int var3 = 0; var3 < var2.size(); ++var3) {
         String var4 = (String)var2.get(var3);
         if(!Strings.isNullOrEmpty(var4)) {
            int var5 = this.field_175241_f.field_78288_b;
            int var6 = this.field_175241_f.func_78256_a(var4);
            int var7 = p_175239_1_.func_78326_a() - 2 - var6;
            int var8 = 2 + var5 * var3;
            func_73734_a(var7 - 1, var8 - 1, var7 + var6 + 1, var8 + var5 - 1, -1873784752);
            this.field_175241_f.func_78276_b(var4, var7, var8, 14737632);
         }
      }

   }

   protected List call() {
      BlockPos var1 = new BlockPos(this.field_175242_a.func_175606_aa().field_70165_t, this.field_175242_a.func_175606_aa().func_174813_aQ().field_72338_b, this.field_175242_a.func_175606_aa().field_70161_v);
      if(this.func_175236_d()) {
         return Lists.newArrayList(new String[]{"Minecraft 1.8 (" + this.field_175242_a.func_175600_c() + "/" + ClientBrandRetriever.getClientModName() + ")", this.field_175242_a.field_71426_K, this.field_175242_a.field_71438_f.func_72735_c(), this.field_175242_a.field_71438_f.func_72723_d(), "P: " + this.field_175242_a.field_71452_i.func_78869_b() + ". T: " + this.field_175242_a.field_71441_e.func_72981_t(), this.field_175242_a.field_71441_e.func_72827_u(), "", String.format("Chunk-relative: %d %d %d", new Object[]{Integer.valueOf(var1.func_177958_n() & 15), Integer.valueOf(var1.func_177956_o() & 15), Integer.valueOf(var1.func_177952_p() & 15)})});
      } else {
         Entity var2 = this.field_175242_a.func_175606_aa();
         EnumFacing var3 = var2.func_174811_aO();
         String var4 = "Invalid";
         switch(GuiOverlayDebug.SwitchEnumFacing.field_178907_a[var3.ordinal()]) {
         case 1:
            var4 = "Towards negative Z";
            break;
         case 2:
            var4 = "Towards positive Z";
            break;
         case 3:
            var4 = "Towards negative X";
            break;
         case 4:
            var4 = "Towards positive X";
         }

         ArrayList var5 = Lists.newArrayList(new String[]{"Minecraft 1.8 (" + this.field_175242_a.func_175600_c() + "/" + ClientBrandRetriever.getClientModName() + ")", this.field_175242_a.field_71426_K, this.field_175242_a.field_71438_f.func_72735_c(), this.field_175242_a.field_71438_f.func_72723_d(), "P: " + this.field_175242_a.field_71452_i.func_78869_b() + ". T: " + this.field_175242_a.field_71441_e.func_72981_t(), this.field_175242_a.field_71441_e.func_72827_u(), "", String.format("XYZ: %.3f / %.5f / %.3f", new Object[]{Double.valueOf(this.field_175242_a.func_175606_aa().field_70165_t), Double.valueOf(this.field_175242_a.func_175606_aa().func_174813_aQ().field_72338_b), Double.valueOf(this.field_175242_a.func_175606_aa().field_70161_v)}), String.format("Block: %d %d %d", new Object[]{Integer.valueOf(var1.func_177958_n()), Integer.valueOf(var1.func_177956_o()), Integer.valueOf(var1.func_177952_p())}), String.format("Chunk: %d %d %d in %d %d %d", new Object[]{Integer.valueOf(var1.func_177958_n() & 15), Integer.valueOf(var1.func_177956_o() & 15), Integer.valueOf(var1.func_177952_p() & 15), Integer.valueOf(var1.func_177958_n() >> 4), Integer.valueOf(var1.func_177956_o() >> 4), Integer.valueOf(var1.func_177952_p() >> 4)}), String.format("Facing: %s (%s) (%.1f / %.1f)", new Object[]{var3, var4, Float.valueOf(MathHelper.func_76142_g(var2.field_70177_z)), Float.valueOf(MathHelper.func_76142_g(var2.field_70125_A))})});
         if(this.field_175242_a.field_71441_e != null && this.field_175242_a.field_71441_e.func_175667_e(var1)) {
            Chunk var6 = this.field_175242_a.field_71441_e.func_175726_f(var1);
            var5.add("Biome: " + var6.func_177411_a(var1, this.field_175242_a.field_71441_e.func_72959_q()).field_76791_y);
            var5.add("Light: " + var6.func_177443_a(var1, 0) + " (" + var6.func_177413_a(EnumSkyBlock.SKY, var1) + " sky, " + var6.func_177413_a(EnumSkyBlock.BLOCK, var1) + " block)");
            DifficultyInstance var7 = this.field_175242_a.field_71441_e.func_175649_E(var1);
            if(this.field_175242_a.func_71387_A() && this.field_175242_a.func_71401_C() != null) {
               EntityPlayerMP var8 = this.field_175242_a.func_71401_C().func_71203_ab().func_177451_a(this.field_175242_a.field_71439_g.func_110124_au());
               if(var8 != null) {
                  var7 = var8.field_70170_p.func_175649_E(new BlockPos(var8));
               }
            }

            var5.add(String.format("Local Difficulty: %.2f (Day %d)", new Object[]{Float.valueOf(var7.func_180168_b()), Long.valueOf(this.field_175242_a.field_71441_e.func_72820_D() / 24000L)}));
         }

         if(this.field_175242_a.field_71460_t != null && this.field_175242_a.field_71460_t.func_147702_a()) {
            var5.add("Shader: " + this.field_175242_a.field_71460_t.func_147706_e().func_148022_b());
         }

         if(this.field_175242_a.field_71476_x != null && this.field_175242_a.field_71476_x.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK && this.field_175242_a.field_71476_x.func_178782_a() != null) {
            BlockPos var9 = this.field_175242_a.field_71476_x.func_178782_a();
            var5.add(String.format("Looking at: %d %d %d", new Object[]{Integer.valueOf(var9.func_177958_n()), Integer.valueOf(var9.func_177956_o()), Integer.valueOf(var9.func_177952_p())}));
         }

         return var5;
      }
   }

   protected List func_175238_c() {
      long var1 = Runtime.getRuntime().maxMemory();
      long var3 = Runtime.getRuntime().totalMemory();
      long var5 = Runtime.getRuntime().freeMemory();
      long var7 = var3 - var5;
      ArrayList var9 = Lists.newArrayList(new String[]{String.format("Java: %s %dbit", new Object[]{System.getProperty("java.version"), Integer.valueOf(this.field_175242_a.func_147111_S()?64:32)}), String.format("Mem: % 2d%% %03d/%03dMB", new Object[]{Long.valueOf(var7 * 100L / var1), Long.valueOf(func_175240_a(var7)), Long.valueOf(func_175240_a(var1))}), String.format("Allocated: % 2d%% %03dMB", new Object[]{Long.valueOf(var3 * 100L / var1), Long.valueOf(func_175240_a(var3))}), "", String.format("Display: %dx%d (%s)", new Object[]{Integer.valueOf(Display.getWidth()), Integer.valueOf(Display.getHeight()), GL11.glGetString(7936)}), GL11.glGetString(7937), GL11.glGetString(7938)});
      if(this.func_175236_d()) {
         return var9;
      } else {
         if(this.field_175242_a.field_71476_x != null && this.field_175242_a.field_71476_x.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK && this.field_175242_a.field_71476_x.func_178782_a() != null) {
            BlockPos var10 = this.field_175242_a.field_71476_x.func_178782_a();
            IBlockState var11 = this.field_175242_a.field_71441_e.func_180495_p(var10);
            if(this.field_175242_a.field_71441_e.func_175624_G() != WorldType.field_180272_g) {
               var11 = var11.func_177230_c().func_176221_a(var11, this.field_175242_a.field_71441_e, var10);
            }

            var9.add("");
            var9.add(String.valueOf(Block.field_149771_c.func_177774_c(var11.func_177230_c())));

            Entry var13;
            String var14;
            for(Iterator var12 = var11.func_177228_b().entrySet().iterator(); var12.hasNext(); var9.add(((IProperty)var13.getKey()).func_177701_a() + ": " + var14)) {
               var13 = (Entry)var12.next();
               var14 = ((Comparable)var13.getValue()).toString();
               if(var13.getValue() == Boolean.TRUE) {
                  var14 = EnumChatFormatting.GREEN + var14;
               } else if(var13.getValue() == Boolean.FALSE) {
                  var14 = EnumChatFormatting.RED + var14;
               }
            }
         }

         return var9;
      }
   }

   private static long func_175240_a(long p_175240_0_) {
      return p_175240_0_ / 1024L / 1024L;
   }

   // $FF: synthetic class
   static final class SwitchEnumFacing {

      // $FF: synthetic field
      static final int[] field_178907_a = new int[EnumFacing.values().length];
      private static final String __OBFID = "CL_00001955";


      static {
         try {
            field_178907_a[EnumFacing.NORTH.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_178907_a[EnumFacing.SOUTH.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_178907_a[EnumFacing.WEST.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_178907_a[EnumFacing.EAST.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
