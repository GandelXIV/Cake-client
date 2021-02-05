package CakeClient.modules.combat;

import java.util.Iterator;
import java.util.List;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import CakeClient.modules.Module;

public class KillAura extends Module
{
    public Float activationRange;
    public Float attackRange;
    
    public KillAura() {
        super("KillAura");
        this.activationRange = 208.0f;
        this.attackRange = 4.0f;
    }
    
    @Override
    public void onUpdate() {
        Float closestDistance = this.activationRange;
        EntityLivingBase closestTarget = null;
        final List<Entity> targets = (List<Entity>)this.mc.theWorld.getLoadedEntityList();
        for (final Entity target : targets) {
            if (target instanceof EntityLivingBase && target != this.mc.thePlayer && target.getDistanceToEntity((Entity)this.mc.thePlayer) < closestDistance) {
                closestDistance = target.getDistanceToEntity((Entity)this.mc.thePlayer);
                closestTarget = (EntityLivingBase)target;
            }
        }
        if (closestTarget != null && closestTarget.getDistanceToEntity((Entity)this.mc.thePlayer) <= this.attackRange) {
            this.mc.thePlayer.swingItem();
            this.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C02PacketUseEntity((Entity)closestTarget, C02PacketUseEntity.Action.ATTACK));
        }
    }
}