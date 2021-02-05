package net.minecraft.client.resources.data;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.resources.data.IMetadataSection;

public class TextureMetadataSection implements IMetadataSection {

   private final boolean field_110482_a;
   private final boolean field_110481_b;
   private final List field_148536_c;
   private static final String __OBFID = "CL_00001114";


   public TextureMetadataSection(boolean p_i45102_1_, boolean p_i45102_2_, List p_i45102_3_) {
      this.field_110482_a = p_i45102_1_;
      this.field_110481_b = p_i45102_2_;
      this.field_148536_c = p_i45102_3_;
   }

   public boolean func_110479_a() {
      return this.field_110482_a;
   }

   public boolean func_110480_b() {
      return this.field_110481_b;
   }

   public List func_148535_c() {
      return Collections.unmodifiableList(this.field_148536_c);
   }
}
