package net.minecraft.client.resources;

import java.io.InputStream;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.util.ResourceLocation;

public interface IResource {

   ResourceLocation func_177241_a();

   InputStream func_110527_b();

   boolean func_110528_c();

   IMetadataSection func_110526_a(String var1);

   String func_177240_d();
}
