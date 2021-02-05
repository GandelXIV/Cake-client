package net.minecraft.dispenser;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public abstract class BehaviorProjectileDispense extends BehaviorDefaultDispenseItem {

   private static final String __OBFID = "CL_00001394";


   public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
      World var3 = p_82487_1_.func_82618_k();
      IPosition var4 = BlockDispenser.func_149939_a(p_82487_1_);
      EnumFacing var5 = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
      IProjectile var6 = this.func_82499_a(var3, var4);
      var6.func_70186_c((double)var5.func_82601_c(), (double)((float)var5.func_96559_d() + 0.1F), (double)var5.func_82599_e(), this.func_82500_b(), this.func_82498_a());
      var3.func_72838_d((Entity)var6);
      p_82487_2_.func_77979_a(1);
      return p_82487_2_;
   }

   protected void func_82485_a(IBlockSource p_82485_1_) {
      p_82485_1_.func_82618_k().func_175718_b(1002, p_82485_1_.func_180699_d(), 0);
   }

   protected abstract IProjectile func_82499_a(World var1, IPosition var2);

   protected float func_82498_a() {
      return 6.0F;
   }

   protected float func_82500_b() {
      return 1.1F;
   }
}
