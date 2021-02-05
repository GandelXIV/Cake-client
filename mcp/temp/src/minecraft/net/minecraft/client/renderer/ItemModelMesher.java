package net.minecraft.client.renderer;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemModelMesher {

   private final Map field_178093_a = Maps.newHashMap();
   private final Map field_178091_b = Maps.newHashMap();
   private final Map field_178092_c = Maps.newHashMap();
   private final ModelManager field_178090_d;
   private static final String __OBFID = "CL_00002536";


   public ItemModelMesher(ModelManager p_i46250_1_) {
      this.field_178090_d = p_i46250_1_;
   }

   public TextureAtlasSprite func_178082_a(Item p_178082_1_) {
      return this.func_178087_a(p_178082_1_, 0);
   }

   public TextureAtlasSprite func_178087_a(Item p_178087_1_, int p_178087_2_) {
      return this.func_178089_a(new ItemStack(p_178087_1_, 1, p_178087_2_)).func_177554_e();
   }

   public IBakedModel func_178089_a(ItemStack p_178089_1_) {
      Item var2 = p_178089_1_.func_77973_b();
      IBakedModel var3 = this.func_178088_b(var2, this.func_178084_b(p_178089_1_));
      if(var3 == null) {
         ItemMeshDefinition var4 = (ItemMeshDefinition)this.field_178092_c.get(var2);
         if(var4 != null) {
            var3 = this.field_178090_d.func_174953_a(var4.func_178113_a(p_178089_1_));
         }
      }

      if(var3 == null) {
         var3 = this.field_178090_d.func_174951_a();
      }

      return var3;
   }

   protected int func_178084_b(ItemStack p_178084_1_) {
      return p_178084_1_.func_77984_f()?0:p_178084_1_.func_77960_j();
   }

   protected IBakedModel func_178088_b(Item p_178088_1_, int p_178088_2_) {
      return (IBakedModel)this.field_178091_b.get(Integer.valueOf(this.func_178081_c(p_178088_1_, p_178088_2_)));
   }

   private int func_178081_c(Item p_178081_1_, int p_178081_2_) {
      return Item.func_150891_b(p_178081_1_) << 16 | p_178081_2_;
   }

   public void func_178086_a(Item p_178086_1_, int p_178086_2_, ModelResourceLocation p_178086_3_) {
      this.field_178093_a.put(Integer.valueOf(this.func_178081_c(p_178086_1_, p_178086_2_)), p_178086_3_);
      this.field_178091_b.put(Integer.valueOf(this.func_178081_c(p_178086_1_, p_178086_2_)), this.field_178090_d.func_174953_a(p_178086_3_));
   }

   public void func_178080_a(Item p_178080_1_, ItemMeshDefinition p_178080_2_) {
      this.field_178092_c.put(p_178080_1_, p_178080_2_);
   }

   public ModelManager func_178083_a() {
      return this.field_178090_d;
   }

   public void func_178085_b() {
      this.field_178091_b.clear();
      Iterator var1 = this.field_178093_a.entrySet().iterator();

      while(var1.hasNext()) {
         Entry var2 = (Entry)var1.next();
         this.field_178091_b.put(var2.getKey(), this.field_178090_d.func_174953_a((ModelResourceLocation)var2.getValue()));
      }

   }
}
