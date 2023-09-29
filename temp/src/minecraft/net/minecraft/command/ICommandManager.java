package net.minecraft.command;

import java.util.List;
import java.util.Map;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;

public interface ICommandManager {

   int func_71556_a(ICommandSender var1, String var2);

   List func_180524_a(ICommandSender var1, String var2, BlockPos var3);

   List func_71557_a(ICommandSender var1);

   Map func_71555_a();
}
