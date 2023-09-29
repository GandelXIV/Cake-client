package net.minecraft.init;

import com.mojang.authlib.GameProfile;
import java.io.PrintStream;
import java.util.Random;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCommandBlock;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.LoggingPrintStream;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bootstrap {

   private static final PrintStream field_179872_a = System.out;
   private static boolean field_151355_a = false;
   private static final Logger field_179871_c = LogManager.getLogger();
   private static final String __OBFID = "CL_00001397";


   public static boolean func_179869_a() {
      return field_151355_a;
   }

   static void func_151353_a() {
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151032_g, new BehaviorProjectileDispense() {

         private static final String __OBFID = "CL_00001398";

         protected IProjectile func_82499_a(World p_82499_1_, IPosition p_82499_2_) {
            EntityArrow var3 = new EntityArrow(p_82499_1_, p_82499_2_.func_82615_a(), p_82499_2_.func_82617_b(), p_82499_2_.func_82616_c());
            var3.field_70251_a = 1;
            return var3;
         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151110_aK, new BehaviorProjectileDispense() {

         private static final String __OBFID = "CL_00001404";

         protected IProjectile func_82499_a(World p_82499_1_, IPosition p_82499_2_) {
            return new EntityEgg(p_82499_1_, p_82499_2_.func_82615_a(), p_82499_2_.func_82617_b(), p_82499_2_.func_82616_c());
         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151126_ay, new BehaviorProjectileDispense() {

         private static final String __OBFID = "CL_00001405";

         protected IProjectile func_82499_a(World p_82499_1_, IPosition p_82499_2_) {
            return new EntitySnowball(p_82499_1_, p_82499_2_.func_82615_a(), p_82499_2_.func_82617_b(), p_82499_2_.func_82616_c());
         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151062_by, new BehaviorProjectileDispense() {

         private static final String __OBFID = "CL_00001406";

         protected IProjectile func_82499_a(World p_82499_1_, IPosition p_82499_2_) {
            return new EntityExpBottle(p_82499_1_, p_82499_2_.func_82615_a(), p_82499_2_.func_82617_b(), p_82499_2_.func_82616_c());
         }
         protected float func_82498_a() {
            return super.func_82498_a() * 0.5F;
         }
         protected float func_82500_b() {
            return super.func_82500_b() * 1.25F;
         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151068_bn, new IBehaviorDispenseItem() {

         private final BehaviorDefaultDispenseItem field_150843_b = new BehaviorDefaultDispenseItem();
         private static final String __OBFID = "CL_00001407";

         public ItemStack func_82482_a(IBlockSource p_82482_1_, final ItemStack p_82482_2_) {
            return ItemPotion.func_77831_g(p_82482_2_.func_77960_j())?(new BehaviorProjectileDispense() {

               private static final String __OBFID = "CL_00001408";

               protected IProjectile func_82499_a(World p_82499_1_, IPosition p_82499_2_) {
                  return new EntityPotion(p_82499_1_, p_82499_2_.func_82615_a(), p_82499_2_.func_82617_b(), p_82499_2_.func_82616_c(), p_82482_2_.func_77946_l());
               }
               protected float func_82498_a() {
                  return super.func_82498_a() * 0.5F;
               }
               protected float func_82500_b() {
                  return super.func_82500_b() * 1.25F;
               }
            }).func_82482_a(p_82482_1_, p_82482_2_):this.field_150843_b.func_82482_a(p_82482_1_, p_82482_2_);
         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151063_bx, new BehaviorDefaultDispenseItem() {

         private static final String __OBFID = "CL_00001410";

         public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            EnumFacing var3 = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
            double var4 = p_82487_1_.func_82615_a() + (double)var3.func_82601_c();
            double var6 = (double)((float)p_82487_1_.func_180699_d().func_177956_o() + 0.2F);
            double var8 = p_82487_1_.func_82616_c() + (double)var3.func_82599_e();
            Entity var10 = ItemMonsterPlacer.func_77840_a(p_82487_1_.func_82618_k(), p_82487_2_.func_77960_j(), var4, var6, var8);
            if(var10 instanceof EntityLivingBase && p_82487_2_.func_82837_s()) {
               ((EntityLiving)var10).func_96094_a(p_82487_2_.func_82833_r());
            }

            p_82487_2_.func_77979_a(1);
            return p_82487_2_;
         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151152_bP, new BehaviorDefaultDispenseItem() {

         private static final String __OBFID = "CL_00001411";

         public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            EnumFacing var3 = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
            double var4 = p_82487_1_.func_82615_a() + (double)var3.func_82601_c();
            double var6 = (double)((float)p_82487_1_.func_180699_d().func_177956_o() + 0.2F);
            double var8 = p_82487_1_.func_82616_c() + (double)var3.func_82599_e();
            EntityFireworkRocket var10 = new EntityFireworkRocket(p_82487_1_.func_82618_k(), var4, var6, var8, p_82487_2_);
            p_82487_1_.func_82618_k().func_72838_d(var10);
            p_82487_2_.func_77979_a(1);
            return p_82487_2_;
         }
         protected void func_82485_a(IBlockSource p_82485_1_) {
            p_82485_1_.func_82618_k().func_175718_b(1002, p_82485_1_.func_180699_d(), 0);
         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151059_bz, new BehaviorDefaultDispenseItem() {

         private static final String __OBFID = "CL_00001412";

         public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            EnumFacing var3 = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
            IPosition var4 = BlockDispenser.func_149939_a(p_82487_1_);
            double var5 = var4.func_82615_a() + (double)((float)var3.func_82601_c() * 0.3F);
            double var7 = var4.func_82617_b() + (double)((float)var3.func_82601_c() * 0.3F);
            double var9 = var4.func_82616_c() + (double)((float)var3.func_82599_e() * 0.3F);
            World var11 = p_82487_1_.func_82618_k();
            Random var12 = var11.field_73012_v;
            double var13 = var12.nextGaussian() * 0.05D + (double)var3.func_82601_c();
            double var15 = var12.nextGaussian() * 0.05D + (double)var3.func_96559_d();
            double var17 = var12.nextGaussian() * 0.05D + (double)var3.func_82599_e();
            var11.func_72838_d(new EntitySmallFireball(var11, var5, var7, var9, var13, var15, var17));
            p_82487_2_.func_77979_a(1);
            return p_82487_2_;
         }
         protected void func_82485_a(IBlockSource p_82485_1_) {
            p_82485_1_.func_82618_k().func_175718_b(1009, p_82485_1_.func_180699_d(), 0);
         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151124_az, new BehaviorDefaultDispenseItem() {

         private final BehaviorDefaultDispenseItem field_150842_b = new BehaviorDefaultDispenseItem();
         private static final String __OBFID = "CL_00001413";

         public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            EnumFacing var3 = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
            World var4 = p_82487_1_.func_82618_k();
            double var5 = p_82487_1_.func_82615_a() + (double)((float)var3.func_82601_c() * 1.125F);
            double var7 = p_82487_1_.func_82617_b() + (double)((float)var3.func_96559_d() * 1.125F);
            double var9 = p_82487_1_.func_82616_c() + (double)((float)var3.func_82599_e() * 1.125F);
            BlockPos var11 = p_82487_1_.func_180699_d().func_177972_a(var3);
            Material var12 = var4.func_180495_p(var11).func_177230_c().func_149688_o();
            double var13;
            if(Material.field_151586_h.equals(var12)) {
               var13 = 1.0D;
            } else {
               if(!Material.field_151579_a.equals(var12) || !Material.field_151586_h.equals(var4.func_180495_p(var11.func_177977_b()).func_177230_c().func_149688_o())) {
                  return this.field_150842_b.func_82482_a(p_82487_1_, p_82487_2_);
               }

               var13 = 0.0D;
            }

            EntityBoat var15 = new EntityBoat(var4, var5, var7 + var13, var9);
            var4.func_72838_d(var15);
            p_82487_2_.func_77979_a(1);
            return p_82487_2_;
         }
         protected void func_82485_a(IBlockSource p_82485_1_) {
            p_82485_1_.func_82618_k().func_175718_b(1000, p_82485_1_.func_180699_d(), 0);
         }
      });
      BehaviorDefaultDispenseItem var0 = new BehaviorDefaultDispenseItem() {

         private final BehaviorDefaultDispenseItem field_150841_b = new BehaviorDefaultDispenseItem();
         private static final String __OBFID = "CL_00001399";

         public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            ItemBucket var3 = (ItemBucket)p_82487_2_.func_77973_b();
            BlockPos var4 = p_82487_1_.func_180699_d().func_177972_a(BlockDispenser.func_149937_b(p_82487_1_.func_82620_h()));
            if(var3.func_180616_a(p_82487_1_.func_82618_k(), var4)) {
               p_82487_2_.func_150996_a(Items.field_151133_ar);
               p_82487_2_.field_77994_a = 1;
               return p_82487_2_;
            } else {
               return this.field_150841_b.func_82482_a(p_82487_1_, p_82487_2_);
            }
         }
      };
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151129_at, var0);
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151131_as, var0);
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151133_ar, new BehaviorDefaultDispenseItem() {

         private final BehaviorDefaultDispenseItem field_150840_b = new BehaviorDefaultDispenseItem();
         private static final String __OBFID = "CL_00001400";

         public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            World var3 = p_82487_1_.func_82618_k();
            BlockPos var4 = p_82487_1_.func_180699_d().func_177972_a(BlockDispenser.func_149937_b(p_82487_1_.func_82620_h()));
            IBlockState var5 = var3.func_180495_p(var4);
            Block var6 = var5.func_177230_c();
            Material var7 = var6.func_149688_o();
            Item var8;
            if(Material.field_151586_h.equals(var7) && var6 instanceof BlockLiquid && ((Integer)var5.func_177229_b(BlockLiquid.field_176367_b)).intValue() == 0) {
               var8 = Items.field_151131_as;
            } else {
               if(!Material.field_151587_i.equals(var7) || !(var6 instanceof BlockLiquid) || ((Integer)var5.func_177229_b(BlockLiquid.field_176367_b)).intValue() != 0) {
                  return super.func_82487_b(p_82487_1_, p_82487_2_);
               }

               var8 = Items.field_151129_at;
            }

            var3.func_175698_g(var4);
            if(--p_82487_2_.field_77994_a == 0) {
               p_82487_2_.func_150996_a(var8);
               p_82487_2_.field_77994_a = 1;
            } else if(((TileEntityDispenser)p_82487_1_.func_150835_j()).func_146019_a(new ItemStack(var8)) < 0) {
               this.field_150840_b.func_82482_a(p_82487_1_, new ItemStack(var8));
            }

            return p_82487_2_;
         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151033_d, new BehaviorDefaultDispenseItem() {

         private boolean field_150839_b = true;
         private static final String __OBFID = "CL_00001401";

         protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            World var3 = p_82487_1_.func_82618_k();
            BlockPos var4 = p_82487_1_.func_180699_d().func_177972_a(BlockDispenser.func_149937_b(p_82487_1_.func_82620_h()));
            if(var3.func_175623_d(var4)) {
               var3.func_175656_a(var4, Blocks.field_150480_ab.func_176223_P());
               if(p_82487_2_.func_96631_a(1, var3.field_73012_v)) {
                  p_82487_2_.field_77994_a = 0;
               }
            } else if(var3.func_180495_p(var4).func_177230_c() == Blocks.field_150335_W) {
               Blocks.field_150335_W.func_176206_d(var3, var4, Blocks.field_150335_W.func_176223_P().func_177226_a(BlockTNT.field_176246_a, Boolean.valueOf(true)));
               var3.func_175698_g(var4);
            } else {
               this.field_150839_b = false;
            }

            return p_82487_2_;
         }
         protected void func_82485_a(IBlockSource p_82485_1_) {
            if(this.field_150839_b) {
               p_82485_1_.func_82618_k().func_175718_b(1000, p_82485_1_.func_180699_d(), 0);
            } else {
               p_82485_1_.func_82618_k().func_175718_b(1001, p_82485_1_.func_180699_d(), 0);
            }

         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151100_aR, new BehaviorDefaultDispenseItem() {

         private boolean field_150838_b = true;
         private static final String __OBFID = "CL_00001402";

         protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            if(EnumDyeColor.WHITE == EnumDyeColor.func_176766_a(p_82487_2_.func_77960_j())) {
               World var3 = p_82487_1_.func_82618_k();
               BlockPos var4 = p_82487_1_.func_180699_d().func_177972_a(BlockDispenser.func_149937_b(p_82487_1_.func_82620_h()));
               if(ItemDye.func_179234_a(p_82487_2_, var3, var4)) {
                  if(!var3.field_72995_K) {
                     var3.func_175718_b(2005, var4, 0);
                  }
               } else {
                  this.field_150838_b = false;
               }

               return p_82487_2_;
            } else {
               return super.func_82487_b(p_82487_1_, p_82487_2_);
            }
         }
         protected void func_82485_a(IBlockSource p_82485_1_) {
            if(this.field_150838_b) {
               p_82485_1_.func_82618_k().func_175718_b(1000, p_82485_1_.func_180699_d(), 0);
            } else {
               p_82485_1_.func_82618_k().func_175718_b(1001, p_82485_1_.func_180699_d(), 0);
            }

         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Item.func_150898_a(Blocks.field_150335_W), new BehaviorDefaultDispenseItem() {

         private static final String __OBFID = "CL_00001403";

         protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            World var3 = p_82487_1_.func_82618_k();
            BlockPos var4 = p_82487_1_.func_180699_d().func_177972_a(BlockDispenser.func_149937_b(p_82487_1_.func_82620_h()));
            EntityTNTPrimed var5 = new EntityTNTPrimed(var3, (double)var4.func_177958_n() + 0.5D, (double)var4.func_177956_o(), (double)var4.func_177952_p() + 0.5D, (EntityLivingBase)null);
            var3.func_72838_d(var5);
            var3.func_72956_a(var5, "game.tnt.primed", 1.0F, 1.0F);
            --p_82487_2_.field_77994_a;
            return p_82487_2_;
         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Items.field_151144_bL, new BehaviorDefaultDispenseItem() {

         private boolean field_179240_b = true;
         private static final String __OBFID = "CL_00002278";

         protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            World var3 = p_82487_1_.func_82618_k();
            EnumFacing var4 = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
            BlockPos var5 = p_82487_1_.func_180699_d().func_177972_a(var4);
            BlockSkull var6 = Blocks.field_150465_bP;
            if(var3.func_175623_d(var5) && var6.func_176415_b(var3, var5, p_82487_2_)) {
               if(!var3.field_72995_K) {
                  var3.func_180501_a(var5, var6.func_176223_P().func_177226_a(BlockSkull.field_176418_a, EnumFacing.UP), 3);
                  TileEntity var7 = var3.func_175625_s(var5);
                  if(var7 instanceof TileEntitySkull) {
                     if(p_82487_2_.func_77960_j() == 3) {
                        GameProfile var8 = null;
                        if(p_82487_2_.func_77942_o()) {
                           NBTTagCompound var9 = p_82487_2_.func_77978_p();
                           if(var9.func_150297_b("SkullOwner", 10)) {
                              var8 = NBTUtil.func_152459_a(var9.func_74775_l("SkullOwner"));
                           } else if(var9.func_150297_b("SkullOwner", 8)) {
                              var8 = new GameProfile((UUID)null, var9.func_74779_i("SkullOwner"));
                           }
                        }

                        ((TileEntitySkull)var7).func_152106_a(var8);
                     } else {
                        ((TileEntitySkull)var7).func_152107_a(p_82487_2_.func_77960_j());
                     }

                     ((TileEntitySkull)var7).func_145903_a(var4.func_176734_d().func_176736_b() * 4);
                     Blocks.field_150465_bP.func_180679_a(var3, var5, (TileEntitySkull)var7);
                  }

                  --p_82487_2_.field_77994_a;
               }
            } else {
               this.field_179240_b = false;
            }

            return p_82487_2_;
         }
         protected void func_82485_a(IBlockSource p_82485_1_) {
            if(this.field_179240_b) {
               p_82485_1_.func_82618_k().func_175718_b(1000, p_82485_1_.func_180699_d(), 0);
            } else {
               p_82485_1_.func_82618_k().func_175718_b(1001, p_82485_1_.func_180699_d(), 0);
            }

         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Item.func_150898_a(Blocks.field_150423_aK), new BehaviorDefaultDispenseItem() {

         private boolean field_179241_b = true;
         private static final String __OBFID = "CL_00002277";

         protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            World var3 = p_82487_1_.func_82618_k();
            BlockPos var4 = p_82487_1_.func_180699_d().func_177972_a(BlockDispenser.func_149937_b(p_82487_1_.func_82620_h()));
            BlockPumpkin var5 = (BlockPumpkin)Blocks.field_150423_aK;
            if(var3.func_175623_d(var4) && var5.func_176390_d(var3, var4)) {
               if(!var3.field_72995_K) {
                  var3.func_180501_a(var4, var5.func_176223_P(), 3);
               }

               --p_82487_2_.field_77994_a;
            } else {
               this.field_179241_b = false;
            }

            return p_82487_2_;
         }
         protected void func_82485_a(IBlockSource p_82485_1_) {
            if(this.field_179241_b) {
               p_82485_1_.func_82618_k().func_175718_b(1000, p_82485_1_.func_180699_d(), 0);
            } else {
               p_82485_1_.func_82618_k().func_175718_b(1001, p_82485_1_.func_180699_d(), 0);
            }

         }
      });
      BlockDispenser.field_149943_a.func_82595_a(Item.func_150898_a(Blocks.field_150483_bI), new BehaviorDefaultDispenseItem() {

         private static final String __OBFID = "CL_00002276";

         protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
            World var3 = p_82487_1_.func_82618_k();
            BlockPos var4 = p_82487_1_.func_180699_d().func_177972_a(BlockDispenser.func_149937_b(p_82487_1_.func_82620_h()));
            if(var3.func_175623_d(var4)) {
               if(!var3.field_72995_K) {
                  IBlockState var5 = Blocks.field_150483_bI.func_176223_P().func_177226_a(BlockCommandBlock.field_176452_a, Boolean.valueOf(false));
                  var3.func_180501_a(var4, var5, 3);
                  ItemBlock.func_179224_a(var3, var4, p_82487_2_);
                  var3.func_175685_c(p_82487_1_.func_180699_d(), p_82487_1_.func_179316_e());
               }

               --p_82487_2_.field_77994_a;
            }

            return p_82487_2_;
         }
         protected void func_82485_a(IBlockSource p_82485_1_) {}
         protected void func_82489_a(IBlockSource p_82489_1_, EnumFacing p_82489_2_) {}
      });
   }

   public static void func_151354_b() {
      if(!field_151355_a) {
         field_151355_a = true;
         if(field_179871_c.isDebugEnabled()) {
            func_179868_d();
         }

         Block.func_149671_p();
         BlockFire.func_149843_e();
         Item.func_150900_l();
         StatList.func_151178_a();
         func_151353_a();
      }
   }

   private static void func_179868_d() {
      System.setErr(new LoggingPrintStream("STDERR", System.err));
      System.setOut(new LoggingPrintStream("STDOUT", field_179872_a));
   }

   public static void func_179870_a(String p_179870_0_) {
      field_179872_a.println(p_179870_0_);
   }

}
