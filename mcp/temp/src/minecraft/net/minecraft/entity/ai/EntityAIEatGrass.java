package net.minecraft.entity.ai;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.pattern.BlockStateHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class EntityAIEatGrass extends EntityAIBase {

   private static final Predicate field_179505_b = BlockStateHelper.func_177638_a(Blocks.field_150329_H).func_177637_a(BlockTallGrass.field_176497_a, Predicates.equalTo(BlockTallGrass.EnumType.GRASS));
   private EntityLiving field_151500_b;
   private World field_151501_c;
   int field_151502_a;
   private static final String __OBFID = "CL_00001582";


   public EntityAIEatGrass(EntityLiving p_i45314_1_) {
      this.field_151500_b = p_i45314_1_;
      this.field_151501_c = p_i45314_1_.field_70170_p;
      this.func_75248_a(7);
   }

   public boolean func_75250_a() {
      if(this.field_151500_b.func_70681_au().nextInt(this.field_151500_b.func_70631_g_()?50:1000) != 0) {
         return false;
      } else {
         BlockPos var1 = new BlockPos(this.field_151500_b.field_70165_t, this.field_151500_b.field_70163_u, this.field_151500_b.field_70161_v);
         return field_179505_b.apply(this.field_151501_c.func_180495_p(var1))?true:this.field_151501_c.func_180495_p(var1.func_177977_b()).func_177230_c() == Blocks.field_150349_c;
      }
   }

   public void func_75249_e() {
      this.field_151502_a = 40;
      this.field_151501_c.func_72960_a(this.field_151500_b, (byte)10);
      this.field_151500_b.func_70661_as().func_75499_g();
   }

   public void func_75251_c() {
      this.field_151502_a = 0;
   }

   public boolean func_75253_b() {
      return this.field_151502_a > 0;
   }

   public int func_151499_f() {
      return this.field_151502_a;
   }

   public void func_75246_d() {
      this.field_151502_a = Math.max(0, this.field_151502_a - 1);
      if(this.field_151502_a == 4) {
         BlockPos var1 = new BlockPos(this.field_151500_b.field_70165_t, this.field_151500_b.field_70163_u, this.field_151500_b.field_70161_v);
         if(field_179505_b.apply(this.field_151501_c.func_180495_p(var1))) {
            if(this.field_151501_c.func_82736_K().func_82766_b("mobGriefing")) {
               this.field_151501_c.func_175655_b(var1, false);
            }

            this.field_151500_b.func_70615_aA();
         } else {
            BlockPos var2 = var1.func_177977_b();
            if(this.field_151501_c.func_180495_p(var2).func_177230_c() == Blocks.field_150349_c) {
               if(this.field_151501_c.func_82736_K().func_82766_b("mobGriefing")) {
                  this.field_151501_c.func_175718_b(2001, var2, Block.func_149682_b(Blocks.field_150349_c));
                  this.field_151501_c.func_180501_a(var2, Blocks.field_150346_d.func_176223_P(), 2);
               }

               this.field_151500_b.func_70615_aA();
            }
         }

      }
   }

}
