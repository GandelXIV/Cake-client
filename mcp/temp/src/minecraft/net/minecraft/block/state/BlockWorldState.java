package net.minecraft.block.state;

import com.google.common.base.Predicate;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockWorldState {

   private final World field_177515_a;
   private final BlockPos field_177513_b;
   private IBlockState field_177514_c;
   private TileEntity field_177511_d;
   private boolean field_177512_e;
   private static final String __OBFID = "CL_00002026";


   public BlockWorldState(World p_i45659_1_, BlockPos p_i45659_2_) {
      this.field_177515_a = p_i45659_1_;
      this.field_177513_b = p_i45659_2_;
   }

   public IBlockState func_177509_a() {
      if(this.field_177514_c == null && this.field_177515_a.func_175667_e(this.field_177513_b)) {
         this.field_177514_c = this.field_177515_a.func_180495_p(this.field_177513_b);
      }

      return this.field_177514_c;
   }

   public TileEntity func_177507_b() {
      if(this.field_177511_d == null && !this.field_177512_e) {
         this.field_177511_d = this.field_177515_a.func_175625_s(this.field_177513_b);
         this.field_177512_e = true;
      }

      return this.field_177511_d;
   }

   public BlockPos func_177508_d() {
      return this.field_177513_b;
   }

   public static Predicate func_177510_a(final Predicate p_177510_0_) {
      return new Predicate() {

         private static final String __OBFID = "CL_00002025";

         public boolean func_177503_a(BlockWorldState p_177503_1_) {
            return p_177503_1_ != null && p_177510_0_.apply(p_177503_1_.func_177509_a());
         }
         // $FF: synthetic method
         public boolean apply(Object p_apply_1_) {
            return this.func_177503_a((BlockWorldState)p_apply_1_);
         }
      };
   }
}
