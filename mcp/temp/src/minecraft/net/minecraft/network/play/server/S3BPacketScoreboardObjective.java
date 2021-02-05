package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.scoreboard.IScoreObjectiveCriteria;
import net.minecraft.scoreboard.ScoreObjective;

public class S3BPacketScoreboardObjective implements Packet {

   private String field_149343_a;
   private String field_149341_b;
   private IScoreObjectiveCriteria.EnumRenderType field_179818_c;
   private int field_149342_c;
   private static final String __OBFID = "CL_00001333";


   public S3BPacketScoreboardObjective() {}

   public S3BPacketScoreboardObjective(ScoreObjective p_i45224_1_, int p_i45224_2_) {
      this.field_149343_a = p_i45224_1_.func_96679_b();
      this.field_149341_b = p_i45224_1_.func_96678_d();
      this.field_179818_c = p_i45224_1_.func_96680_c().func_178790_c();
      this.field_149342_c = p_i45224_2_;
   }

   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
      this.field_149343_a = p_148837_1_.func_150789_c(16);
      this.field_149342_c = p_148837_1_.readByte();
      if(this.field_149342_c == 0 || this.field_149342_c == 2) {
         this.field_149341_b = p_148837_1_.func_150789_c(32);
         this.field_179818_c = IScoreObjectiveCriteria.EnumRenderType.func_178795_a(p_148837_1_.func_150789_c(16));
      }

   }

   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
      p_148840_1_.func_180714_a(this.field_149343_a);
      p_148840_1_.writeByte(this.field_149342_c);
      if(this.field_149342_c == 0 || this.field_149342_c == 2) {
         p_148840_1_.func_180714_a(this.field_149341_b);
         p_148840_1_.func_180714_a(this.field_179818_c.func_178796_a());
      }

   }

   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
      p_148833_1_.func_147291_a(this);
   }

   public String func_149339_c() {
      return this.field_149343_a;
   }

   public String func_149337_d() {
      return this.field_149341_b;
   }

   public int func_149338_e() {
      return this.field_149342_c;
   }

   public IScoreObjectiveCriteria.EnumRenderType func_179817_d() {
      return this.field_179818_c;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_148833_a(INetHandler p_148833_1_) {
      this.func_148833_a((INetHandlerPlayClient)p_148833_1_);
   }
}
