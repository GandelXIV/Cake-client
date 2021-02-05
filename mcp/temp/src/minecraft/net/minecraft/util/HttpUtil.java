package net.minecraft.util;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.IProgressUpdate;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HttpUtil {

   public static final ListeningExecutorService field_180193_a = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool((new ThreadFactoryBuilder()).setDaemon(true).setNameFormat("Downloader %d").build()));
   private static final AtomicInteger field_151228_a = new AtomicInteger(0);
   private static final Logger field_151227_b = LogManager.getLogger();
   private static final String __OBFID = "CL_00001485";


   public static String func_76179_a(Map p_76179_0_) {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = p_76179_0_.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(var1.length() > 0) {
            var1.append('&');
         }

         try {
            var1.append(URLEncoder.encode((String)var3.getKey(), "UTF-8"));
         } catch (UnsupportedEncodingException var6) {
            var6.printStackTrace();
         }

         if(var3.getValue() != null) {
            var1.append('=');

            try {
               var1.append(URLEncoder.encode(var3.getValue().toString(), "UTF-8"));
            } catch (UnsupportedEncodingException var5) {
               var5.printStackTrace();
            }
         }
      }

      return var1.toString();
   }

   public static String func_151226_a(URL p_151226_0_, Map p_151226_1_, boolean p_151226_2_) {
      return func_151225_a(p_151226_0_, func_76179_a(p_151226_1_), p_151226_2_);
   }

   private static String func_151225_a(URL p_151225_0_, String p_151225_1_, boolean p_151225_2_) {
      try {
         Proxy var3 = MinecraftServer.func_71276_C() == null?null:MinecraftServer.func_71276_C().func_110454_ao();
         if(var3 == null) {
            var3 = Proxy.NO_PROXY;
         }

         HttpURLConnection var4 = (HttpURLConnection)p_151225_0_.openConnection(var3);
         var4.setRequestMethod("POST");
         var4.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         var4.setRequestProperty("Content-Length", "" + p_151225_1_.getBytes().length);
         var4.setRequestProperty("Content-Language", "en-US");
         var4.setUseCaches(false);
         var4.setDoInput(true);
         var4.setDoOutput(true);
         DataOutputStream var5 = new DataOutputStream(var4.getOutputStream());
         var5.writeBytes(p_151225_1_);
         var5.flush();
         var5.close();
         BufferedReader var6 = new BufferedReader(new InputStreamReader(var4.getInputStream()));
         StringBuffer var8 = new StringBuffer();

         String var7;
         while((var7 = var6.readLine()) != null) {
            var8.append(var7);
            var8.append('\r');
         }

         var6.close();
         return var8.toString();
      } catch (Exception var9) {
         if(!p_151225_2_) {
            field_151227_b.error("Could not post to " + p_151225_0_, var9);
         }

         return "";
      }
   }

   public static ListenableFuture func_180192_a(final File p_180192_0_, final String p_180192_1_, final Map p_180192_2_, final int p_180192_3_, final IProgressUpdate p_180192_4_, final Proxy p_180192_5_) {
      ListenableFuture var6 = field_180193_a.submit(new Runnable() {

         private static final String __OBFID = "CL_00001486";

         public void run() {
            InputStream var2 = null;
            DataOutputStream var3 = null;
            if(p_180192_4_ != null) {
               p_180192_4_.func_73721_b("Downloading Resource Pack");
               p_180192_4_.func_73719_c("Making Request...");
            }

            try {
               try {
                  byte[] var4 = new byte[4096];
                  URL var5 = new URL(p_180192_1_);
                  URLConnection var1 = var5.openConnection(p_180192_5_);
                  float var6 = 0.0F;
                  float var7 = (float)p_180192_2_.entrySet().size();
                  Iterator var8 = p_180192_2_.entrySet().iterator();

                  while(var8.hasNext()) {
                     Entry var9 = (Entry)var8.next();
                     var1.setRequestProperty((String)var9.getKey(), (String)var9.getValue());
                     if(p_180192_4_ != null) {
                        p_180192_4_.func_73718_a((int)(++var6 / var7 * 100.0F));
                     }
                  }

                  var2 = var1.getInputStream();
                  var7 = (float)var1.getContentLength();
                  int var16 = var1.getContentLength();
                  if(p_180192_4_ != null) {
                     p_180192_4_.func_73719_c(String.format("Downloading file (%.2f MB)...", new Object[]{Float.valueOf(var7 / 1000.0F / 1000.0F)}));
                  }

                  if(p_180192_0_.exists()) {
                     long var17 = p_180192_0_.length();
                     if(var17 == (long)var16) {
                        if(p_180192_4_ != null) {
                           p_180192_4_.func_146586_a();
                        }

                        return;
                     }

                     HttpUtil.field_151227_b.warn("Deleting " + p_180192_0_ + " as it does not match what we currently have (" + var16 + " vs our " + var17 + ").");
                     FileUtils.deleteQuietly(p_180192_0_);
                  } else if(p_180192_0_.getParentFile() != null) {
                     p_180192_0_.getParentFile().mkdirs();
                  }

                  var3 = new DataOutputStream(new FileOutputStream(p_180192_0_));
                  if(p_180192_3_ > 0 && var7 > (float)p_180192_3_) {
                     if(p_180192_4_ != null) {
                        p_180192_4_.func_146586_a();
                     }

                     throw new IOException("Filesize is bigger than maximum allowed (file is " + var6 + ", limit is " + p_180192_3_ + ")");
                  }

                  boolean var18 = false;

                  int var19;
                  while((var19 = var2.read(var4)) >= 0) {
                     var6 += (float)var19;
                     if(p_180192_4_ != null) {
                        p_180192_4_.func_73718_a((int)(var6 / var7 * 100.0F));
                     }

                     if(p_180192_3_ > 0 && var6 > (float)p_180192_3_) {
                        if(p_180192_4_ != null) {
                           p_180192_4_.func_146586_a();
                        }

                        throw new IOException("Filesize was bigger than maximum allowed (got >= " + var6 + ", limit was " + p_180192_3_ + ")");
                     }

                     var3.write(var4, 0, var19);
                  }

                  if(p_180192_4_ != null) {
                     p_180192_4_.func_146586_a();
                     return;
                  }
               } catch (Throwable var14) {
                  var14.printStackTrace();
               }

            } finally {
               IOUtils.closeQuietly(var2);
               IOUtils.closeQuietly(var3);
            }
         }
      });
      return var6;
   }

   public static int func_76181_a() throws IOException {
      ServerSocket var0 = null;
      boolean var1 = true;

      int var10;
      try {
         var0 = new ServerSocket(0);
         var10 = var0.getLocalPort();
      } finally {
         try {
            if(var0 != null) {
               var0.close();
            }
         } catch (IOException var8) {
            ;
         }

      }

      return var10;
   }

   public static String func_152755_a(URL p_152755_0_) throws IOException {
      HttpURLConnection var1 = (HttpURLConnection)p_152755_0_.openConnection();
      var1.setRequestMethod("GET");
      BufferedReader var2 = new BufferedReader(new InputStreamReader(var1.getInputStream()));
      StringBuilder var4 = new StringBuilder();

      String var3;
      while((var3 = var2.readLine()) != null) {
         var4.append(var3);
         var4.append('\r');
      }

      var2.close();
      return var4.toString();
   }

}
