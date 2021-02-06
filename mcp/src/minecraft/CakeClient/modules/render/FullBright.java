package CakeClient.modules.render;
import CakeClient.modules.Module;

public class FullBright extends Module
{
    private Float defaultGamma;
    
    public FullBright() {
        super("FullBright");
    }
    
    @Override
    public void onEnable() {
        this.mc.gameSettings.gammaSetting = 72000.0f;
    }
    
    @Override
    public void onDisable() {
        this.mc.gameSettings.gammaSetting = 1.0f;
    }
}