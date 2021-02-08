package CakeClient.modules.render;

import java.util.ArrayList;

import CakeClient.modules.Module;
import net.minecraft.block.Block;

public class Xray extends Module
{
	
	public static ArrayList<Block> xrayBlocks = new ArrayList();
	
    private Float defaultGamma;
    
    public Xray() {
        super("Xray");
    }
    
    @Override
    public void onEnable() {
    	mc.renderGlobal.loadRenderers();
    }
    
    @Override
    public void onDisable() {
    	mc.renderGlobal.loadRenderers();
        
    }
}
