package net.minecraft.block.material;


public class MapColor {

   public static final MapColor[] field_76281_a = new MapColor[64];
   public static final MapColor field_151660_b = new MapColor(0, 0);
   public static final MapColor field_151661_c = new MapColor(1, 8368696);
   public static final MapColor field_151658_d = new MapColor(2, 16247203);
   public static final MapColor field_151659_e = new MapColor(3, 10987431);
   public static final MapColor field_151656_f = new MapColor(4, 16711680);
   public static final MapColor field_151657_g = new MapColor(5, 10526975);
   public static final MapColor field_151668_h = new MapColor(6, 10987431);
   public static final MapColor field_151669_i = new MapColor(7, 31744);
   public static final MapColor field_151666_j = new MapColor(8, 16777215);
   public static final MapColor field_151667_k = new MapColor(9, 10791096);
   public static final MapColor field_151664_l = new MapColor(10, 12020271);
   public static final MapColor field_151665_m = new MapColor(11, 7368816);
   public static final MapColor field_151662_n = new MapColor(12, 4210943);
   public static final MapColor field_151663_o = new MapColor(13, 6837042);
   public static final MapColor field_151677_p = new MapColor(14, 16776437);
   public static final MapColor field_151676_q = new MapColor(15, 14188339);
   public static final MapColor field_151675_r = new MapColor(16, 11685080);
   public static final MapColor field_151674_s = new MapColor(17, 6724056);
   public static final MapColor field_151673_t = new MapColor(18, 15066419);
   public static final MapColor field_151672_u = new MapColor(19, 8375321);
   public static final MapColor field_151671_v = new MapColor(20, 15892389);
   public static final MapColor field_151670_w = new MapColor(21, 5000268);
   public static final MapColor field_151680_x = new MapColor(22, 10066329);
   public static final MapColor field_151679_y = new MapColor(23, 5013401);
   public static final MapColor field_151678_z = new MapColor(24, 8339378);
   public static final MapColor field_151649_A = new MapColor(25, 3361970);
   public static final MapColor field_151650_B = new MapColor(26, 6704179);
   public static final MapColor field_151651_C = new MapColor(27, 6717235);
   public static final MapColor field_151645_D = new MapColor(28, 10040115);
   public static final MapColor field_151646_E = new MapColor(29, 1644825);
   public static final MapColor field_151647_F = new MapColor(30, 16445005);
   public static final MapColor field_151648_G = new MapColor(31, 6085589);
   public static final MapColor field_151652_H = new MapColor(32, 4882687);
   public static final MapColor field_151653_I = new MapColor(33, '\ud93a');
   public static final MapColor field_151654_J = new MapColor(34, 1381407);
   public static final MapColor field_151655_K = new MapColor(35, 7340544);
   public final int field_76291_p;
   public final int field_76290_q;
   private static final String __OBFID = "CL_00000544";


   private MapColor(int p_i2117_1_, int p_i2117_2_) {
      if(p_i2117_1_ >= 0 && p_i2117_1_ <= 63) {
         this.field_76290_q = p_i2117_1_;
         this.field_76291_p = p_i2117_2_;
         field_76281_a[p_i2117_1_] = this;
      } else {
         throw new IndexOutOfBoundsException("Map colour ID must be between 0 and 63 (inclusive)");
      }
   }

   public int func_151643_b(int p_151643_1_) {
      short var2 = 220;
      if(p_151643_1_ == 3) {
         var2 = 135;
      }

      if(p_151643_1_ == 2) {
         var2 = 255;
      }

      if(p_151643_1_ == 1) {
         var2 = 220;
      }

      if(p_151643_1_ == 0) {
         var2 = 180;
      }

      int var3 = (this.field_76291_p >> 16 & 255) * var2 / 255;
      int var4 = (this.field_76291_p >> 8 & 255) * var2 / 255;
      int var5 = (this.field_76291_p & 255) * var2 / 255;
      return -16777216 | var3 << 16 | var4 << 8 | var5;
   }

}
