package CakeClient.modules.movement;

import CakeClient.modules.Module;

public class NoSlowDown extends Module
{
    public NoSlowDown() {
        super("NoSlowDown");
    }
    
    @Override
    public void onDisable() {
        
    }
    
    @Override
    public void onUpdate() {
    	if (mc.thePlayer.onGround && mc.thePlayer.moveForward !=0 && (mc.thePlayer.isBlocking()||mc.thePlayer.isUsingItem())) {
    		//mc.thePlayer.motionX *= 1.4D;
    		//mc.thePlayer.motionY = 0.2D;
    		//mc.thePlayer.motionZ *= 1.4D;
    		
    	}
    	
    	if (mc.thePlayer.onGround && mc.thePlayer.moveForward !=0 && (mc.thePlayer.isBlocking()||mc.thePlayer.isUsingItem())) {
    		//mc.thePlayer.motionY = -1F;
    	}
    }
}
