package net.minecraft.block;

import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateHelper;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.stats.AchievementList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSkull extends BlockContainer {

   public static final PropertyDirection field_176418_a = PropertyDirection.func_177714_a("facing");
   public static final PropertyBool field_176417_b = PropertyBool.func_177716_a("nodrop");
   private static final Predicate field_176419_M = new Predicate() {

      private static final String __OBFID = "CL_00002065";

      public boolean func_177062_a(BlockWorldState p_177062_1_) {
         return p_177062_1_.func_177509_a().func_177230_c() == Blocks.field_150465_bP && p_177062_1_.func_177507_b() instanceof TileEntitySkull && ((TileEntitySkull)p_177062_1_.func_177507_b()).func_145904_a() == 1;
      }
      // $FF: synthetic method
      public boolean apply(Object p_apply_1_) {
         return this.func_177062_a((BlockWorldState)p_apply_1_);
      }
   };
   private BlockPattern field_176420_N;
   private BlockPattern field_176421_O;
   private static final String __OBFID = "CL_00000307";


   protected BlockSkull() {
      super(Material.field_151594_q);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176418_a, EnumFacing.NORTH).func_177226_a(field_176417_b, Boolean.valueOf(false)));
      this.func_149676_a(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
   }

   public boolean func_149662_c() {
      return false;
   }

   public boolean func_149686_d() {
      return false;
   }

   public void func_180654_a(IBlockAccess p_180654_1_, BlockPos p_180654_2_) {
      switch(BlockSkull.SwitchEnumFacing.field_177063_a[((EnumFacing)p_180654_1_.func_180495_p(p_180654_2_).func_177229_b(field_176418_a)).ordinal()]) {
      case 1:
      default:
         this.func_149676_a(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
         break;
      case 2:
         this.func_149676_a(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
         break;
      case 3:
         this.func_149676_a(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
         break;
      case 4:
         this.func_149676_a(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
         break;
      case 5:
         this.func_149676_a(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
      }

   }

   public AxisAlignedBB func_180640_a(World p_180640_1_, BlockPos p_180640_2_, IBlockState p_180640_3_) {
      this.func_180654_a(p_180640_1_, p_180640_2_);
      return super.func_180640_a(p_180640_1_, p_180640_2_, p_180640_3_);
   }

   public IBlockState func_180642_a(World p_180642_1_, BlockPos p_180642_2_, EnumFacing p_180642_3_, float p_180642_4_, float p_180642_5_, float p_180642_6_, int p_180642_7_, EntityLivingBase p_180642_8_) {
      return this.func_176223_P().func_177226_a(field_176418_a, p_180642_8_.func_174811_aO()).func_177226_a(field_176417_b, Boolean.valueOf(false));
   }

   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
      return new TileEntitySkull();
   }

   public Item func_180665_b(World p_180665_1_, BlockPos p_180665_2_) {
      return Items.field_151144_bL;
   }

   public int func_176222_j(World p_176222_1_, BlockPos p_176222_2_) {
      TileEntity var3 = p_176222_1_.func_175625_s(p_176222_2_);
      return var3 instanceof TileEntitySkull?((TileEntitySkull)var3).func_145904_a():super.func_176222_j(p_176222_1_, p_176222_2_);
   }

   public void func_180653_a(World p_180653_1_, BlockPos p_180653_2_, IBlockState p_180653_3_, float p_180653_4_, int p_180653_5_) {}

   public void func_176208_a(World p_176208_1_, BlockPos p_176208_2_, IBlockState p_176208_3_, EntityPlayer p_176208_4_) {
      if(p_176208_4_.field_71075_bZ.field_75098_d) {
         p_176208_3_ = p_176208_3_.func_177226_a(field_176417_b, Boolean.valueOf(true));
         p_176208_1_.func_180501_a(p_176208_2_, p_176208_3_, 4);
      }

      super.func_176208_a(p_176208_1_, p_176208_2_, p_176208_3_, p_176208_4_);
   }

   public void func_180663_b(World p_180663_1_, BlockPos p_180663_2_, IBlockState p_180663_3_) {
      if(!p_180663_1_.field_72995_K) {
         if(!((Boolean)p_180663_3_.func_177229_b(field_176417_b)).booleanValue()) {
            TileEntity var4 = p_180663_1_.func_175625_s(p_180663_2_);
            if(var4 instanceof TileEntitySkull) {
               TileEntitySkull var5 = (TileEntitySkull)var4;
               ItemStack var6 = new ItemStack(Items.field_151144_bL, 1, this.func_176222_j(p_180663_1_, p_180663_2_));
               if(var5.func_145904_a() == 3 && var5.func_152108_a() != null) {
                  var6.func_77982_d(new NBTTagCompound());
                  NBTTagCompound var7 = new NBTTagCompound();
                  NBTUtil.func_180708_a(var7, var5.func_152108_a());
                  var6.func_77978_p().func_74782_a("SkullOwner", var7);
               }

               func_180635_a(p_180663_1_, p_180663_2_, var6);
            }
         }

         super.func_180663_b(p_180663_1_, p_180663_2_, p_180663_3_);
      }
   }

   public Item func_180660_a(IBlockState p_180660_1_, Random p_180660_2_, int p_180660_3_) {
      return Items.field_151144_bL;
   }

   public boolean func_176415_b(World p_176415_1_, BlockPos p_176415_2_, ItemStack p_176415_3_) {
      return p_176415_3_.func_77960_j() == 1 && p_176415_2_.func_177956_o() >= 2 && p_176415_1_.func_175659_aa() != EnumDifficulty.PEACEFUL && !p_176415_1_.field_72995_K?this.func_176414_j().func_177681_a(p_176415_1_, p_176415_2_) != null:false;
   }

   public void func_180679_a(World p_180679_1_, BlockPos p_180679_2_, TileEntitySkull p_180679_3_) {
      if(p_180679_3_.func_145904_a() == 1 && p_180679_2_.func_177956_o() >= 2 && p_180679_1_.func_175659_aa() != EnumDifficulty.PEACEFUL && !p_180679_1_.field_72995_K) {
         BlockPattern var4 = this.func_176416_l();
         BlockPattern.PatternHelper var5 = var4.func_177681_a(p_180679_1_, p_180679_2_);
         if(var5 != null) {
            int var6;
            for(var6 = 0; var6 < 3; ++var6) {
               BlockWorldState var7 = var5.func_177670_a(var6, 0, 0);
               p_180679_1_.func_180501_a(var7.func_177508_d(), var7.func_177509_a().func_177226_a(field_176417_b, Boolean.valueOf(true)), 2);
            }

            for(var6 = 0; var6 < var4.func_177684_c(); ++var6) {
               for(int var13 = 0; var13 < var4.func_177685_b(); ++var13) {
                  BlockWorldState var8 = var5.func_177670_a(var6, var13, 0);
                  p_180679_1_.func_180501_a(var8.func_177508_d(), Blocks.field_150350_a.func_176223_P(), 2);
               }
            }

            BlockPos var12 = var5.func_177670_a(1, 0, 0).func_177508_d();
            EntityWither var14 = new EntityWither(p_180679_1_);
            BlockPos var15 = var5.func_177670_a(1, 2, 0).func_177508_d();
            var14.func_70012_b((double)var15.func_177958_n() + 0.5D, (double)var15.func_177956_o() + 0.55D, (double)var15.func_177952_p() + 0.5D, var5.func_177669_b().func_176740_k() == EnumFacing.Axis.X?0.0F:90.0F, 0.0F);
            var14.field_70761_aq = var5.func_177669_b().func_176740_k() == EnumFacing.Axis.X?0.0F:90.0F;
            var14.func_82206_m();
            Iterator var9 = p_180679_1_.func_72872_a(EntityPlayer.class, var14.func_174813_aQ().func_72314_b(50.0D, 50.0D, 50.0D)).iterator();

            while(var9.hasNext()) {
               EntityPlayer var10 = (EntityPlayer)var9.next();
               var10.func_71029_a(AchievementList.field_150963_I);
            }

            p_180679_1_.func_72838_d(var14);

            int var16;
            for(var16 = 0; var16 < 120; ++var16) {
               p_180679_1_.func_175688_a(EnumParticleTypes.SNOWBALL, (double)var12.func_177958_n() + p_180679_1_.field_73012_v.nextDouble(), (double)(var12.func_177956_o() - 2) + p_180679_1_.field_73012_v.nextDouble() * 3.9D, (double)var12.func_177952_p() + p_180679_1_.field_73012_v.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
            }

            for(var16 = 0; var16 < var4.func_177684_c(); ++var16) {
               for(int var17 = 0; var17 < var4.func_177685_b(); ++var17) {
                  BlockWorldState var11 = var5.func_177670_a(var16, var17, 0);
                  p_180679_1_.func_175722_b(var11.func_177508_d(), Blocks.field_150350_a);
               }
            }

         }
      }
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      return this.func_176223_P().func_177226_a(field_176418_a, EnumFacing.func_82600_a(p_176203_1_ & 7)).func_177226_a(field_176417_b, Boolean.valueOf((p_176203_1_ & 8) > 0));
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      byte var2 = 0;
      int var3 = var2 | ((EnumFacing)p_176201_1_.func_177229_b(field_176418_a)).func_176745_a();
      if(((Boolean)p_176201_1_.func_177229_b(field_176417_b)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   protected BlockState func_180661_e() {
      return new BlockState(this, new IProperty[]{field_176418_a, field_176417_b});
   }

   protected BlockPattern func_176414_j() {
      if(this.field_176420_N == null) {
         this.field_176420_N = FactoryBlockPattern.func_177660_a().func_177659_a(new String[]{"   ", "###", "~#~"}).func_177662_a('#', BlockWorldState.func_177510_a(BlockStateHelper.func_177638_a(Blocks.field_150425_aM))).func_177662_a('~', BlockWorldState.func_177510_a(BlockStateHelper.func_177638_a(Blocks.field_150350_a))).func_177661_b();
      }

      return this.field_176420_N;
   }

   protected BlockPattern func_176416_l() {
      if(this.field_176421_O == null) {
         this.field_176421_O = FactoryBlockPattern.func_177660_a().func_177659_a(new String[]{"^^^", "###", "~#~"}).func_177662_a('#', BlockWorldState.func_177510_a(BlockStateHelper.func_177638_a(Blocks.field_150425_aM))).func_177662_a('^', field_176419_M).func_177662_a('~', BlockWorldState.func_177510_a(BlockStateHelper.func_177638_a(Blocks.field_150350_a))).func_177661_b();
      }

      return this.field_176421_O;
   }


   // $FF: synthetic class
   static final class SwitchEnumFacing {

      // $FF: synthetic field
      static final int[] field_177063_a = new int[EnumFacing.values().length];
      private static final String __OBFID = "CL_00002064";


      static {
         try {
            field_177063_a[EnumFacing.UP.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            field_177063_a[EnumFacing.NORTH.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            field_177063_a[EnumFacing.SOUTH.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            field_177063_a[EnumFacing.WEST.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            field_177063_a[EnumFacing.EAST.ordinal()] = 5;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
