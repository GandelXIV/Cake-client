package net.minecraft.item;

import net.minecraft.util.EnumChatFormatting;

public enum EnumRarity {

   COMMON("COMMON", 0, EnumChatFormatting.WHITE, "Common"),
   UNCOMMON("UNCOMMON", 1, EnumChatFormatting.YELLOW, "Uncommon"),
   RARE("RARE", 2, EnumChatFormatting.AQUA, "Rare"),
   EPIC("EPIC", 3, EnumChatFormatting.LIGHT_PURPLE, "Epic");
   public final EnumChatFormatting field_77937_e;
   public final String field_77934_f;
   // $FF: synthetic field
   private static final EnumRarity[] $VALUES = new EnumRarity[]{COMMON, UNCOMMON, RARE, EPIC};
   private static final String __OBFID = "CL_00000056";


   private EnumRarity(String p_i45349_1_, int p_i45349_2_, EnumChatFormatting p_i45349_3_, String p_i45349_4_) {
      this.field_77937_e = p_i45349_3_;
      this.field_77934_f = p_i45349_4_;
   }

}
