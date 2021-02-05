package net.minecraft.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerDispenser;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiDispenser extends GuiContainer {

   private static final ResourceLocation field_147088_v = new ResourceLocation("textures/gui/container/dispenser.png");
   private final InventoryPlayer field_175376_w;
   public IInventory field_175377_u;
   private static final String __OBFID = "CL_00000765";


   public GuiDispenser(InventoryPlayer p_i45503_1_, IInventory p_i45503_2_) {
      super(new ContainerDispenser(p_i45503_1_, p_i45503_2_));
      this.field_175376_w = p_i45503_1_;
      this.field_175377_u = p_i45503_2_;
   }

   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
      String var3 = this.field_175377_u.func_145748_c_().func_150260_c();
      this.field_146289_q.func_78276_b(var3, this.field_146999_f / 2 - this.field_146289_q.func_78256_a(var3) / 2, 6, 4210752);
      this.field_146289_q.func_78276_b(this.field_175376_w.func_145748_c_().func_150260_c(), 8, this.field_147000_g - 96 + 2, 4210752);
   }

   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_146297_k.func_110434_K().func_110577_a(field_147088_v);
      int var4 = (this.field_146294_l - this.field_146999_f) / 2;
      int var5 = (this.field_146295_m - this.field_147000_g) / 2;
      this.func_73729_b(var4, var5, 0, 0, this.field_146999_f, this.field_147000_g);
   }

}
