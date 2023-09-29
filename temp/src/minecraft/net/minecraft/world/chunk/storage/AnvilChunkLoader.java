package net.minecraft.world.chunk.storage;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.NextTickListEntry;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.NibbleArray;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.chunk.storage.RegionFileCache;
import net.minecraft.world.storage.IThreadedFileIO;
import net.minecraft.world.storage.ThreadedFileIOBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnvilChunkLoader implements IChunkLoader, IThreadedFileIO {

   private static final Logger field_151505_a = LogManager.getLogger();
   private List field_75828_a = Lists.newArrayList();
   private Set field_75826_b = Sets.newHashSet();
   private Object field_75827_c = new Object();
   private final File field_75825_d;
   private static final String __OBFID = "CL_00000384";


   public AnvilChunkLoader(File p_i2003_1_) {
      this.field_75825_d = p_i2003_1_;
   }

   public Chunk func_75815_a(World p_75815_1_, int p_75815_2_, int p_75815_3_) throws IOException {
      NBTTagCompound var4 = null;
      ChunkCoordIntPair var5 = new ChunkCoordIntPair(p_75815_2_, p_75815_3_);
      Object var6 = this.field_75827_c;
      synchronized(this.field_75827_c) {
         if(this.field_75826_b.contains(var5)) {
            for(int var7 = 0; var7 < this.field_75828_a.size(); ++var7) {
               if(((AnvilChunkLoader.PendingChunk)this.field_75828_a.get(var7)).field_76548_a.equals(var5)) {
                  var4 = ((AnvilChunkLoader.PendingChunk)this.field_75828_a.get(var7)).field_76547_b;
                  break;
               }
            }
         }
      }

      if(var4 == null) {
         DataInputStream var10 = RegionFileCache.func_76549_c(this.field_75825_d, p_75815_2_, p_75815_3_);
         if(var10 == null) {
            return null;
         }

         var4 = CompressedStreamTools.func_74794_a(var10);
      }

      return this.func_75822_a(p_75815_1_, p_75815_2_, p_75815_3_, var4);
   }

   protected Chunk func_75822_a(World p_75822_1_, int p_75822_2_, int p_75822_3_, NBTTagCompound p_75822_4_) {
      if(!p_75822_4_.func_150297_b("Level", 10)) {
         field_151505_a.error("Chunk file at " + p_75822_2_ + "," + p_75822_3_ + " is missing level data, skipping");
         return null;
      } else if(!p_75822_4_.func_74775_l("Level").func_150297_b("Sections", 9)) {
         field_151505_a.error("Chunk file at " + p_75822_2_ + "," + p_75822_3_ + " is missing block data, skipping");
         return null;
      } else {
         Chunk var5 = this.func_75823_a(p_75822_1_, p_75822_4_.func_74775_l("Level"));
         if(!var5.func_76600_a(p_75822_2_, p_75822_3_)) {
            field_151505_a.error("Chunk file at " + p_75822_2_ + "," + p_75822_3_ + " is in the wrong location; relocating. (Expected " + p_75822_2_ + ", " + p_75822_3_ + ", got " + var5.field_76635_g + ", " + var5.field_76647_h + ")");
            p_75822_4_.func_74768_a("xPos", p_75822_2_);
            p_75822_4_.func_74768_a("zPos", p_75822_3_);
            var5 = this.func_75823_a(p_75822_1_, p_75822_4_.func_74775_l("Level"));
         }

         return var5;
      }
   }

   public void func_75816_a(World p_75816_1_, Chunk p_75816_2_) throws MinecraftException, IOException {
      p_75816_1_.func_72906_B();

      try {
         NBTTagCompound var3 = new NBTTagCompound();
         NBTTagCompound var4 = new NBTTagCompound();
         var3.func_74782_a("Level", var4);
         this.func_75820_a(p_75816_2_, p_75816_1_, var4);
         this.func_75824_a(p_75816_2_.func_76632_l(), var3);
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }

   protected void func_75824_a(ChunkCoordIntPair p_75824_1_, NBTTagCompound p_75824_2_) {
      Object var3 = this.field_75827_c;
      synchronized(this.field_75827_c) {
         if(this.field_75826_b.contains(p_75824_1_)) {
            for(int var4 = 0; var4 < this.field_75828_a.size(); ++var4) {
               if(((AnvilChunkLoader.PendingChunk)this.field_75828_a.get(var4)).field_76548_a.equals(p_75824_1_)) {
                  this.field_75828_a.set(var4, new AnvilChunkLoader.PendingChunk(p_75824_1_, p_75824_2_));
                  return;
               }
            }
         }

         this.field_75828_a.add(new AnvilChunkLoader.PendingChunk(p_75824_1_, p_75824_2_));
         this.field_75826_b.add(p_75824_1_);
         ThreadedFileIOBase.func_178779_a().func_75735_a(this);
      }
   }

   public boolean func_75814_c() {
      AnvilChunkLoader.PendingChunk var1 = null;
      Object var2 = this.field_75827_c;
      synchronized(this.field_75827_c) {
         if(this.field_75828_a.isEmpty()) {
            return false;
         }

         var1 = (AnvilChunkLoader.PendingChunk)this.field_75828_a.remove(0);
         this.field_75826_b.remove(var1.field_76548_a);
      }

      if(var1 != null) {
         try {
            this.func_75821_a(var1);
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

      return true;
   }

   private void func_75821_a(AnvilChunkLoader.PendingChunk p_75821_1_) throws IOException {
      DataOutputStream var2 = RegionFileCache.func_76552_d(this.field_75825_d, p_75821_1_.field_76548_a.field_77276_a, p_75821_1_.field_76548_a.field_77275_b);
      CompressedStreamTools.func_74800_a(p_75821_1_.field_76547_b, var2);
      var2.close();
   }

   public void func_75819_b(World p_75819_1_, Chunk p_75819_2_) {}

   public void func_75817_a() {}

   public void func_75818_b() {
      while(this.func_75814_c()) {
         ;
      }

   }

   private void func_75820_a(Chunk p_75820_1_, World p_75820_2_, NBTTagCompound p_75820_3_) {
      p_75820_3_.func_74774_a("V", (byte)1);
      p_75820_3_.func_74768_a("xPos", p_75820_1_.field_76635_g);
      p_75820_3_.func_74768_a("zPos", p_75820_1_.field_76647_h);
      p_75820_3_.func_74772_a("LastUpdate", p_75820_2_.func_82737_E());
      p_75820_3_.func_74783_a("HeightMap", p_75820_1_.func_177445_q());
      p_75820_3_.func_74757_a("TerrainPopulated", p_75820_1_.func_177419_t());
      p_75820_3_.func_74757_a("LightPopulated", p_75820_1_.func_177423_u());
      p_75820_3_.func_74772_a("InhabitedTime", p_75820_1_.func_177416_w());
      ExtendedBlockStorage[] var4 = p_75820_1_.func_76587_i();
      NBTTagList var5 = new NBTTagList();
      boolean var6 = !p_75820_2_.field_73011_w.func_177495_o();
      ExtendedBlockStorage[] var7 = var4;
      int var8 = var4.length;

      NBTTagCompound var11;
      for(int var9 = 0; var9 < var8; ++var9) {
         ExtendedBlockStorage var10 = var7[var9];
         if(var10 != null) {
            var11 = new NBTTagCompound();
            var11.func_74774_a("Y", (byte)(var10.func_76662_d() >> 4 & 255));
            byte[] var12 = new byte[var10.func_177487_g().length];
            NibbleArray var13 = new NibbleArray();
            NibbleArray var14 = null;

            for(int var15 = 0; var15 < var10.func_177487_g().length; ++var15) {
               char var16 = var10.func_177487_g()[var15];
               int var17 = var15 & 15;
               int var18 = var15 >> 8 & 15;
               int var19 = var15 >> 4 & 15;
               if(var16 >> 12 != 0) {
                  if(var14 == null) {
                     var14 = new NibbleArray();
                  }

                  var14.func_76581_a(var17, var18, var19, var16 >> 12);
               }

               var12[var15] = (byte)(var16 >> 4 & 255);
               var13.func_76581_a(var17, var18, var19, var16 & 15);
            }

            var11.func_74773_a("Blocks", var12);
            var11.func_74773_a("Data", var13.func_177481_a());
            if(var14 != null) {
               var11.func_74773_a("Add", var14.func_177481_a());
            }

            var11.func_74773_a("BlockLight", var10.func_76661_k().func_177481_a());
            if(var6) {
               var11.func_74773_a("SkyLight", var10.func_76671_l().func_177481_a());
            } else {
               var11.func_74773_a("SkyLight", new byte[var10.func_76661_k().func_177481_a().length]);
            }

            var5.func_74742_a(var11);
         }
      }

      p_75820_3_.func_74782_a("Sections", var5);
      p_75820_3_.func_74773_a("Biomes", p_75820_1_.func_76605_m());
      p_75820_1_.func_177409_g(false);
      NBTTagList var20 = new NBTTagList();

      Iterator var22;
      for(var8 = 0; var8 < p_75820_1_.func_177429_s().length; ++var8) {
         var22 = p_75820_1_.func_177429_s()[var8].iterator();

         while(var22.hasNext()) {
            Entity var24 = (Entity)var22.next();
            var11 = new NBTTagCompound();
            if(var24.func_70039_c(var11)) {
               p_75820_1_.func_177409_g(true);
               var20.func_74742_a(var11);
            }
         }
      }

      p_75820_3_.func_74782_a("Entities", var20);
      NBTTagList var21 = new NBTTagList();
      var22 = p_75820_1_.func_177434_r().values().iterator();

      while(var22.hasNext()) {
         TileEntity var25 = (TileEntity)var22.next();
         var11 = new NBTTagCompound();
         var25.func_145841_b(var11);
         var21.func_74742_a(var11);
      }

      p_75820_3_.func_74782_a("TileEntities", var21);
      List var23 = p_75820_2_.func_72920_a(p_75820_1_, false);
      if(var23 != null) {
         long var26 = p_75820_2_.func_82737_E();
         NBTTagList var27 = new NBTTagList();
         Iterator var28 = var23.iterator();

         while(var28.hasNext()) {
            NextTickListEntry var29 = (NextTickListEntry)var28.next();
            NBTTagCompound var30 = new NBTTagCompound();
            ResourceLocation var31 = (ResourceLocation)Block.field_149771_c.func_177774_c(var29.func_151351_a());
            var30.func_74778_a("i", var31 == null?"":var31.toString());
            var30.func_74768_a("x", var29.field_180282_a.func_177958_n());
            var30.func_74768_a("y", var29.field_180282_a.func_177956_o());
            var30.func_74768_a("z", var29.field_180282_a.func_177952_p());
            var30.func_74768_a("t", (int)(var29.field_77180_e - var26));
            var30.func_74768_a("p", var29.field_82754_f);
            var27.func_74742_a(var30);
         }

         p_75820_3_.func_74782_a("TileTicks", var27);
      }

   }

   private Chunk func_75823_a(World p_75823_1_, NBTTagCompound p_75823_2_) {
      int var3 = p_75823_2_.func_74762_e("xPos");
      int var4 = p_75823_2_.func_74762_e("zPos");
      Chunk var5 = new Chunk(p_75823_1_, var3, var4);
      var5.func_177420_a(p_75823_2_.func_74759_k("HeightMap"));
      var5.func_177446_d(p_75823_2_.func_74767_n("TerrainPopulated"));
      var5.func_177421_e(p_75823_2_.func_74767_n("LightPopulated"));
      var5.func_177415_c(p_75823_2_.func_74763_f("InhabitedTime"));
      NBTTagList var6 = p_75823_2_.func_150295_c("Sections", 10);
      byte var7 = 16;
      ExtendedBlockStorage[] var8 = new ExtendedBlockStorage[var7];
      boolean var9 = !p_75823_1_.field_73011_w.func_177495_o();

      for(int var10 = 0; var10 < var6.func_74745_c(); ++var10) {
         NBTTagCompound var11 = var6.func_150305_b(var10);
         byte var12 = var11.func_74771_c("Y");
         ExtendedBlockStorage var13 = new ExtendedBlockStorage(var12 << 4, var9);
         byte[] var14 = var11.func_74770_j("Blocks");
         NibbleArray var15 = new NibbleArray(var11.func_74770_j("Data"));
         NibbleArray var16 = var11.func_150297_b("Add", 7)?new NibbleArray(var11.func_74770_j("Add")):null;
         char[] var17 = new char[var14.length];

         for(int var18 = 0; var18 < var17.length; ++var18) {
            int var19 = var18 & 15;
            int var20 = var18 >> 8 & 15;
            int var21 = var18 >> 4 & 15;
            int var22 = var16 != null?var16.func_76582_a(var19, var20, var21):0;
            var17[var18] = (char)(var22 << 12 | (var14[var18] & 255) << 4 | var15.func_76582_a(var19, var20, var21));
         }

         var13.func_177486_a(var17);
         var13.func_76659_c(new NibbleArray(var11.func_74770_j("BlockLight")));
         if(var9) {
            var13.func_76666_d(new NibbleArray(var11.func_74770_j("SkyLight")));
         }

         var13.func_76672_e();
         var8[var12] = var13;
      }

      var5.func_76602_a(var8);
      if(p_75823_2_.func_150297_b("Biomes", 7)) {
         var5.func_76616_a(p_75823_2_.func_74770_j("Biomes"));
      }

      NBTTagList var23 = p_75823_2_.func_150295_c("Entities", 10);
      if(var23 != null) {
         for(int var24 = 0; var24 < var23.func_74745_c(); ++var24) {
            NBTTagCompound var26 = var23.func_150305_b(var24);
            Entity var29 = EntityList.func_75615_a(var26, p_75823_1_);
            var5.func_177409_g(true);
            if(var29 != null) {
               var5.func_76612_a(var29);
               Entity var32 = var29;

               for(NBTTagCompound var35 = var26; var35.func_150297_b("Riding", 10); var35 = var35.func_74775_l("Riding")) {
                  Entity var37 = EntityList.func_75615_a(var35.func_74775_l("Riding"), p_75823_1_);
                  if(var37 != null) {
                     var5.func_76612_a(var37);
                     var32.func_70078_a(var37);
                  }

                  var32 = var37;
               }
            }
         }
      }

      NBTTagList var25 = p_75823_2_.func_150295_c("TileEntities", 10);
      if(var25 != null) {
         for(int var27 = 0; var27 < var25.func_74745_c(); ++var27) {
            NBTTagCompound var30 = var25.func_150305_b(var27);
            TileEntity var33 = TileEntity.func_145827_c(var30);
            if(var33 != null) {
               var5.func_150813_a(var33);
            }
         }
      }

      if(p_75823_2_.func_150297_b("TileTicks", 9)) {
         NBTTagList var28 = p_75823_2_.func_150295_c("TileTicks", 10);
         if(var28 != null) {
            for(int var31 = 0; var31 < var28.func_74745_c(); ++var31) {
               NBTTagCompound var34 = var28.func_150305_b(var31);
               Block var36;
               if(var34.func_150297_b("i", 8)) {
                  var36 = Block.func_149684_b(var34.func_74779_i("i"));
               } else {
                  var36 = Block.func_149729_e(var34.func_74762_e("i"));
               }

               p_75823_1_.func_180497_b(new BlockPos(var34.func_74762_e("x"), var34.func_74762_e("y"), var34.func_74762_e("z")), var36, var34.func_74762_e("t"), var34.func_74762_e("p"));
            }
         }
      }

      return var5;
   }


   static class PendingChunk {

      public final ChunkCoordIntPair field_76548_a;
      public final NBTTagCompound field_76547_b;
      private static final String __OBFID = "CL_00000385";


      public PendingChunk(ChunkCoordIntPair p_i2002_1_, NBTTagCompound p_i2002_2_) {
         this.field_76548_a = p_i2002_1_;
         this.field_76547_b = p_i2002_2_;
      }
   }
}
