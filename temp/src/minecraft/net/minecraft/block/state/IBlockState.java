package net.minecraft.block.state;

import com.google.common.collect.ImmutableMap;
import java.util.Collection;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;

public interface IBlockState {

   Collection func_177227_a();

   Comparable func_177229_b(IProperty var1);

   IBlockState func_177226_a(IProperty var1, Comparable var2);

   IBlockState func_177231_a(IProperty var1);

   ImmutableMap func_177228_b();

   Block func_177230_c();
}
