package net.minecraft.client.gui.inventory;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class CreativeCrafting implements ICrafting {

   private final Minecraft field_146109_a;
   private static final String __OBFID = "CL_00000751";


   public CreativeCrafting(Minecraft p_i46314_1_) {
      this.field_146109_a = p_i46314_1_;
   }

   public void func_71110_a(Container p_71110_1_, List p_71110_2_) {}

   public void func_71111_a(Container p_71111_1_, int p_71111_2_, ItemStack p_71111_3_) {
      this.field_146109_a.field_71442_b.func_78761_a(p_71111_3_, p_71111_2_);
   }

   public void func_71112_a(Container p_71112_1_, int p_71112_2_, int p_71112_3_) {}

   public void func_175173_a(Container p_175173_1_, IInventory p_175173_2_) {}
}
