package net.minecraft.world.chunk.storage;

import com.google.common.collect.Lists;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import net.minecraft.server.MinecraftServer;

public class RegionFile {

   private static final byte[] field_76720_a = new byte[4096];
   private final File field_76718_b;
   private RandomAccessFile field_76719_c;
   private final int[] field_76716_d = new int[1024];
   private final int[] field_76717_e = new int[1024];
   private List field_76714_f;
   private int field_76715_g;
   private long field_76721_h;
   private static final String __OBFID = "CL_00000381";


   public RegionFile(File p_i2001_1_) {
      this.field_76718_b = p_i2001_1_;
      this.field_76715_g = 0;

      try {
         if(p_i2001_1_.exists()) {
            this.field_76721_h = p_i2001_1_.lastModified();
         }

         this.field_76719_c = new RandomAccessFile(p_i2001_1_, "rw");
         int var2;
         if(this.field_76719_c.length() < 4096L) {
            for(var2 = 0; var2 < 1024; ++var2) {
               this.field_76719_c.writeInt(0);
            }

            for(var2 = 0; var2 < 1024; ++var2) {
               this.field_76719_c.writeInt(0);
            }

            this.field_76715_g += 8192;
         }

         if((this.field_76719_c.length() & 4095L) != 0L) {
            for(var2 = 0; (long)var2 < (this.field_76719_c.length() & 4095L); ++var2) {
               this.field_76719_c.write(0);
            }
         }

         var2 = (int)this.field_76719_c.length() / 4096;
         this.field_76714_f = Lists.newArrayListWithCapacity(var2);

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field_76714_f.add(Boolean.valueOf(true));
         }

         this.field_76714_f.set(0, Boolean.valueOf(false));
         this.field_76714_f.set(1, Boolean.valueOf(false));
         this.field_76719_c.seek(0L);

         int var4;
         for(var3 = 0; var3 < 1024; ++var3) {
            var4 = this.field_76719_c.readInt();
            this.field_76716_d[var3] = var4;
            if(var4 != 0 && (var4 >> 8) + (var4 & 255) <= this.field_76714_f.size()) {
               for(int var5 = 0; var5 < (var4 & 255); ++var5) {
                  this.field_76714_f.set((var4 >> 8) + var5, Boolean.valueOf(false));
               }
            }
         }

         for(var3 = 0; var3 < 1024; ++var3) {
            var4 = this.field_76719_c.readInt();
            this.field_76717_e[var3] = var4;
         }
      } catch (IOException var6) {
         var6.printStackTrace();
      }

   }

   public synchronized DataInputStream func_76704_a(int p_76704_1_, int p_76704_2_) {
      if(this.func_76705_d(p_76704_1_, p_76704_2_)) {
         return null;
      } else {
         try {
            int var3 = this.func_76707_e(p_76704_1_, p_76704_2_);
            if(var3 == 0) {
               return null;
            } else {
               int var4 = var3 >> 8;
               int var5 = var3 & 255;
               if(var4 + var5 > this.field_76714_f.size()) {
                  return null;
               } else {
                  this.field_76719_c.seek((long)(var4 * 4096));
                  int var6 = this.field_76719_c.readInt();
                  if(var6 > 4096 * var5) {
                     return null;
                  } else if(var6 <= 0) {
                     return null;
                  } else {
                     byte var7 = this.field_76719_c.readByte();
                     byte[] var8;
                     if(var7 == 1) {
                        var8 = new byte[var6 - 1];
                        this.field_76719_c.read(var8);
                        return new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(var8))));
                     } else if(var7 == 2) {
                        var8 = new byte[var6 - 1];
                        this.field_76719_c.read(var8);
                        return new DataInputStream(new BufferedInputStream(new InflaterInputStream(new ByteArrayInputStream(var8))));
                     } else {
                        return null;
                     }
                  }
               }
            }
         } catch (IOException var9) {
            return null;
         }
      }
   }

   public DataOutputStream func_76710_b(int p_76710_1_, int p_76710_2_) {
      return this.func_76705_d(p_76710_1_, p_76710_2_)?null:new DataOutputStream(new DeflaterOutputStream(new RegionFile.ChunkBuffer(p_76710_1_, p_76710_2_)));
   }

   protected synchronized void func_76706_a(int p_76706_1_, int p_76706_2_, byte[] p_76706_3_, int p_76706_4_) {
      try {
         int var5 = this.func_76707_e(p_76706_1_, p_76706_2_);
         int var6 = var5 >> 8;
         int var7 = var5 & 255;
         int var8 = (p_76706_4_ + 5) / 4096 + 1;
         if(var8 >= 256) {
            return;
         }

         if(var6 != 0 && var7 == var8) {
            this.func_76712_a(var6, p_76706_3_, p_76706_4_);
         } else {
            int var9;
            for(var9 = 0; var9 < var7; ++var9) {
               this.field_76714_f.set(var6 + var9, Boolean.valueOf(true));
            }

            var9 = this.field_76714_f.indexOf(Boolean.valueOf(true));
            int var10 = 0;
            int var11;
            if(var9 != -1) {
               for(var11 = var9; var11 < this.field_76714_f.size(); ++var11) {
                  if(var10 != 0) {
                     if(((Boolean)this.field_76714_f.get(var11)).booleanValue()) {
                        ++var10;
                     } else {
                        var10 = 0;
                     }
                  } else if(((Boolean)this.field_76714_f.get(var11)).booleanValue()) {
                     var9 = var11;
                     var10 = 1;
                  }

                  if(var10 >= var8) {
                     break;
                  }
               }
            }

            if(var10 >= var8) {
               var6 = var9;
               this.func_76711_a(p_76706_1_, p_76706_2_, var9 << 8 | var8);

               for(var11 = 0; var11 < var8; ++var11) {
                  this.field_76714_f.set(var6 + var11, Boolean.valueOf(false));
               }

               this.func_76712_a(var6, p_76706_3_, p_76706_4_);
            } else {
               this.field_76719_c.seek(this.field_76719_c.length());
               var6 = this.field_76714_f.size();

               for(var11 = 0; var11 < var8; ++var11) {
                  this.field_76719_c.write(field_76720_a);
                  this.field_76714_f.add(Boolean.valueOf(false));
               }

               this.field_76715_g += 4096 * var8;
               this.func_76712_a(var6, p_76706_3_, p_76706_4_);
               this.func_76711_a(p_76706_1_, p_76706_2_, var6 << 8 | var8);
            }
         }

         this.func_76713_b(p_76706_1_, p_76706_2_, (int)(MinecraftServer.func_130071_aq() / 1000L));
      } catch (IOException var12) {
         var12.printStackTrace();
      }

   }

   private void func_76712_a(int p_76712_1_, byte[] p_76712_2_, int p_76712_3_) throws IOException {
      this.field_76719_c.seek((long)(p_76712_1_ * 4096));
      this.field_76719_c.writeInt(p_76712_3_ + 1);
      this.field_76719_c.writeByte(2);
      this.field_76719_c.write(p_76712_2_, 0, p_76712_3_);
   }

   private boolean func_76705_d(int p_76705_1_, int p_76705_2_) {
      return p_76705_1_ < 0 || p_76705_1_ >= 32 || p_76705_2_ < 0 || p_76705_2_ >= 32;
   }

   private int func_76707_e(int p_76707_1_, int p_76707_2_) {
      return this.field_76716_d[p_76707_1_ + p_76707_2_ * 32];
   }

   public boolean func_76709_c(int p_76709_1_, int p_76709_2_) {
      return this.func_76707_e(p_76709_1_, p_76709_2_) != 0;
   }

   private void func_76711_a(int p_76711_1_, int p_76711_2_, int p_76711_3_) throws IOException {
      this.field_76716_d[p_76711_1_ + p_76711_2_ * 32] = p_76711_3_;
      this.field_76719_c.seek((long)((p_76711_1_ + p_76711_2_ * 32) * 4));
      this.field_76719_c.writeInt(p_76711_3_);
   }

   private void func_76713_b(int p_76713_1_, int p_76713_2_, int p_76713_3_) throws IOException {
      this.field_76717_e[p_76713_1_ + p_76713_2_ * 32] = p_76713_3_;
      this.field_76719_c.seek((long)(4096 + (p_76713_1_ + p_76713_2_ * 32) * 4));
      this.field_76719_c.writeInt(p_76713_3_);
   }

   public void func_76708_c() throws IOException {
      if(this.field_76719_c != null) {
         this.field_76719_c.close();
      }

   }


   class ChunkBuffer extends ByteArrayOutputStream {

      private int field_76722_b;
      private int field_76723_c;
      private static final String __OBFID = "CL_00000382";


      public ChunkBuffer(int p_i2000_2_, int p_i2000_3_) {
         super(8096);
         this.field_76722_b = p_i2000_2_;
         this.field_76723_c = p_i2000_3_;
      }

      public void close() throws IOException {
         RegionFile.this.func_76706_a(this.field_76722_b, this.field_76723_c, this.buf, this.count);
      }
   }
}
