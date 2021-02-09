package CakeClient.modules.movement;

import CakeClient.modules.Module;

public class Speed extends Module
{
    public Speed() {
        super("Speed");
    }
    public double motX;
    public double motZ;
    @Override
    public void onDisable() {
    }
    
    @Override
    public void onUpdate() {
    	if (mc.thePlayer.onGround) 
    		{
    		mc.thePlayer.motionX*=1.4D;
    		mc.thePlayer.motionZ*=1.4D;
    		}
    	}
    @Override
    public void onEnable() {
    	
    }
    
}

