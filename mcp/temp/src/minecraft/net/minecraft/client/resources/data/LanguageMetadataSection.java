package net.minecraft.client.resources.data;

import java.util.Collection;
import net.minecraft.client.resources.data.IMetadataSection;

public class LanguageMetadataSection implements IMetadataSection {

   private final Collection field_135019_a;
   private static final String __OBFID = "CL_00001110";


   public LanguageMetadataSection(Collection p_i1311_1_) {
      this.field_135019_a = p_i1311_1_;
   }

   public Collection func_135018_a() {
      return this.field_135019_a;
   }
}
