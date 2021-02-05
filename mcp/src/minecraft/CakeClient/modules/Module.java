package CakeClient.modules;

import net.minecraft.client.Minecraft;

public class Module
{
    public Minecraft mc;
    public String name;
    public Integer activationKey;
    public Boolean enabled;
    
    public Module(final String name) {
        this.mc = Minecraft.getMinecraft();
        this.enabled = false;
        this.name = name;
    }
    
    public void toggle() {
        this.enabled = !this.enabled;
    }
    
    public void onEnable() {
    }
    
    public void onDisable() {
    }
    
    public void onUpdate() {
    }
    
    public void onDraw() {
    }
    
    public void keyUpdate(final int key) {
    }
}