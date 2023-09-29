package net.minecraft.client.resources;

import java.util.List;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;

public interface IReloadableResourceManager extends IResourceManager {

   void func_110541_a(List var1);

   void func_110542_a(IResourceManagerReloadListener var1);
}
